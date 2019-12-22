package org.sheepy.lily.vulkan.common.engine;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelExplorer;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.api.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.api.resource.IVulkanResourceAdapter;
import org.sheepy.lily.vulkan.common.allocation.TreeAllocator;
import org.sheepy.lily.vulkan.common.engine.utils.VulkanEngineAllocationRoot;
import org.sheepy.lily.vulkan.common.engine.utils.VulkanEngineUtils;
import org.sheepy.lily.vulkan.common.input.VulkanInputManager;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.vulkan.concurrent.VkFence;
import org.sheepy.vulkan.device.EPhysicalFeature;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.device.PhysicalDevice;
import org.sheepy.vulkan.device.PhysicalDeviceSelector;
import org.sheepy.vulkan.device.VulkanContext;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.extension.EngineExtensionRequirement;
import org.sheepy.vulkan.instance.VulkanInstance;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.surface.VkSurface;
import org.sheepy.vulkan.window.IWindowListener.IOpenListener;
import org.sheepy.vulkan.window.Window;

@Statefull
@Adapter(scope = VulkanEngine.class)
public final class VulkanEngineAdapter implements IVulkanEngineAdapter
{
	private static final EQueueType ENGINE_QUEUE_TYPE = EQueueType.Graphic;
	private static final ModelExplorer RESOURCE_EXPLORER = new ModelExplorer(List.of(	VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																						ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES));
	private static final ModelExplorer DESCRIPTOR_EXPLORER = new ModelExplorer(List.of(	VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																						VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS));

	private final List<VkFence> fences = new ArrayList<>();
	private final VulkanInputManager inputManager;
	private final VulkanEngine engine;
	private final Application application;
	private final EngineExtensionRequirement extensionRequirement;

	private final IOpenListener openListener = id -> loadInputManager();

	private VulkanInstance vkInstance;
	private PhysicalDevice physicalDevice;
	private LogicalDevice logicalDevice = null;
	private VulkanContext vulkanContext = null;
	private TreeAllocator<IVulkanContext> allocator;
	private VulkanEngineAllocationRoot allocationRoot;
	private boolean allocated = false;
	private ExecutionContext executionContext = null;

	private Window window;

	public VulkanEngineAdapter(VulkanEngine engine)
	{
		this.engine = engine;
		application = (Application) engine.eContainer();
		final var scene = application.getScene();
		if (scene != null)
		{
			window = new Window(scene, application.getTitle());
			inputManager = new VulkanInputManager(application, window);
		}
		else
		{
			window = null;
			inputManager = null;
		}
		executionContext = new ExecutionContext(ENGINE_QUEUE_TYPE, false);

		try (MemoryStack stack = stackPush())
		{
			extensionRequirement = new EngineExtensionRequirement(	stack,
																	DebugUtil.DEBUG_ENABLED,
																	DebugUtil.DEBUG_VERBOSE_ENABLED);
		}
	}

	@NotifyChanged(featureIds = VulkanPackage.VULKAN_ENGINE__ENABLED)
	public void notifyChanged(Notification notification)
	{
		if (engine != null
				&& notification.getNewBooleanValue() != notification.getOldBooleanValue())
		{
			if (engine.isEnabled())
			{
				load();
			}
			else
			{
				dispose();
			}
		}
	}

	@Override
	public void start()
	{
		if (engine.isEnabled())
		{
			load();
		}
	}

	@Override
	public void stop()
	{
		if (engine != null)
		{
			if (engine.isEnabled())
			{
				dispose();
			}
		}
	}

	@Override
	public void step()
	{
		for (final var process : engine.getProcesses())
		{
			final var cadence = process.getCadence();
			if (cadence != null)
			{
				final var adapter = cadence.adaptNotNull(ICadenceAdapter.class);
				adapter.run();
			}
		}
	}

	private void load()
	{
		try (MemoryStack stack = stackPush())
		{
			createInstance(stack);
			if (window != null) window.open(vkInstance.getVkInstance());

			final var dummySurface = window != null ? window.createSurface() : null;
			pickPhysicalDevice(stack, dummySurface);
			createLogicalDevice(stack, dummySurface);
			if (dummySurface != null) dummySurface.free();

			vulkanContext = new VulkanContext(logicalDevice, window);
			if (window != null)
			{
				loadInputManager();
				window.addListener(openListener);
			}
		}

		try
		{
			allocate();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}
	}

	private void dispose()
	{
		if (allocated == true)
		{
			free();
		}

		if (logicalDevice != null)
		{
			logicalDevice.waitIdle();
		}

		if (window != null)
		{
			window.removeListener(openListener);
		}
		cleanup();
	}

	private void allocate()
	{
		final List<IAllocable<? super IExecutionContext>> resources = new ArrayList<>();
		RESOURCE_EXPLORER	.streamAdapt(engine, IVulkanResourceAdapter.class)
							.collect(Collectors.toCollection(() -> resources));
		DESCRIPTOR_EXPLORER	.streamAdapt(engine, IDescriptorAdapter.class)
							.collect(Collectors.toCollection(() -> resources));

		allocationRoot = new VulkanEngineAllocationRoot(executionContext, resources);
		allocator = new TreeAllocator<IVulkanContext>(allocationRoot);

		allocator.allocate(vulkanContext);

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			System.out.println("Engine Resources Allocation tree:");
			System.out.println(allocator.toString());
		}

		startProcesses();

		allocated = true;
	}

	private void startProcesses()
	{
		for (final IProcess process : engine.getProcesses())
		{
			final var adapter = process.adaptNotNull(IProcessAdapter.class);
			adapter.start(vulkanContext);
		}
	}

	private void free()
	{
		executionContext.getQueue().waitIdle();
		stopProcesses();
		allocator.free();

		for (final VkFence fence : fences)
		{
			fence.free(vulkanContext);
		}
		allocated = false;
	}

	private void stopProcesses()
	{
		for (final var process : engine.getProcesses())
		{
			final var adapter = process.adaptNotNull(IProcessAdapter.class);
			adapter.stop(vulkanContext);
		}
	}

	private void createInstance(MemoryStack stack)
	{
		vkInstance = new VulkanInstance(application.getTitle(),
										extensionRequirement,
										DebugUtil.DEBUG_ENABLED,
										DebugUtil.DEBUG_VERBOSE_ENABLED);
		vkInstance.allocate(stack);
	}

	private void pickPhysicalDevice(MemoryStack stack, VkSurface dummySurface)
	{
		final var deviceSelector = new PhysicalDeviceSelector(	vkInstance,
																extensionRequirement,
																dummySurface,
																DebugUtil.DEBUG_VERBOSE_ENABLED);

		physicalDevice = deviceSelector.findBestPhysicalDevice(stack);

		physicalDevice.printInfo();

		if (DebugUtil.DEBUG_ENABLED)
		{
			physicalDevice.printRetainedExtensions();
		}
		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			physicalDevice.printPhysicalProperties();
		}
	}

	private void createLogicalDevice(MemoryStack stack, VkSurface dummySurface)
	{
		final var features = engine.getFeatures();
		final var vkFeatures = features	.stream()
										.map(f -> EPhysicalFeature.valueOf(f.getName()))
										.collect(Collectors.toList());

		final var queueList = VulkanEngineUtils.generateQueueList(engine);
		queueList.add(ENGINE_QUEUE_TYPE);
		logicalDevice = new LogicalDevice(physicalDevice, queueList, dummySurface, vkFeatures);
		logicalDevice.allocate(stack);
	}

	private void cleanup()
	{
		if (inputManager != null) inputManager.dispose();
		logicalDevice.free();

		if (window != null) window.close();
		if (window != null) window.destroy();

		physicalDevice.free();

		vkInstance.free();
		vkInstance = null;
	}

	private void loadInputManager()
	{
		inputManager.load();
	}

	@Override
	public VkFence newFence()
	{
		return newFence(false);
	}

	@Override
	public VkFence newFence(boolean signaled)
	{
		final VkFence res = new VkFence(signaled);
		res.allocate(vulkanContext);

		fences.add(res);
		return res;
	}

	public LogicalDevice getLogicalDevice()
	{
		return logicalDevice;
	}

	@Override
	public Window getWindow()
	{
		return window;
	}

	public PhysicalDevice getPhysicalDevice()
	{
		return physicalDevice;
	}

	@Override
	public VulkanInputManager getInputManager()
	{
		return inputManager;
	}
}
