package org.sheepy.lily.vulkan.core.engine;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.IRootAllocator;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.game.api.window.IWindowListener;
import org.sheepy.lily.game.core.allocation.GenericAllocator;
import org.sheepy.lily.vulkan.api.device.EPhysicalFeature;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.device.PhysicalDeviceSelector;
import org.sheepy.lily.vulkan.core.device.VulkanContext;
import org.sheepy.lily.vulkan.core.engine.extension.EngineExtensionRequirement;
import org.sheepy.lily.vulkan.core.engine.utils.VulkanEngineAllocationRoot;
import org.sheepy.lily.vulkan.core.engine.utils.VulkanEngineUtils;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.input.VulkanInputManager;
import org.sheepy.lily.vulkan.core.instance.VulkanInstance;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.lwjgl.system.MemoryStack.stackPush;

@Statefull
@Adapter(scope = VulkanEngine.class)
public final class VulkanEngineAdapter implements IVulkanEngineAdapter
{
	private static final String WAIT_IDLE_RELOAD_ENGINE_RESOURCES = "[WaitIdle] Reload engine resources";
	private static final List<EReference> RESOURCE_FEATURES = List.of(ApplicationPackage.Literals.IENGINE__RESOURCE_PKG,
																	  ResourcePackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> DESCRIPTOR_FEATURES = List.of(VulkanPackage.Literals.VULKAN_ENGINE__DESCRIPTOR_PKG,
																		VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);

	private final List<VkFence> fences = new ArrayList<>();
	private final VulkanInputManager inputManager;
	private final VulkanEngine engine;
	private final Application application;
	private final EngineExtensionRequirement extensionRequirement;
	private final GenericAllocator<ExecutionContext> resourceAllocator = new GenericAllocator<>(List.of(
			RESOURCE_FEATURES,
			DESCRIPTOR_FEATURES));
	private final IWindowListener.IOpenListener openListener = id -> loadInputManager();
	private final Window window;

	private VulkanInstance vkInstance;
	private PhysicalDevice physicalDevice;
	private LogicalDevice logicalDevice = null;
	private IRootAllocator<VulkanContext> allocator;
	private boolean allocated = false;

	private VulkanContext vulkanContext;
	private VulkanEngineAllocationRoot allocationRoot;

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

		try (final var stack = stackPush())
		{
			extensionRequirement = new EngineExtensionRequirement(stack,
																  DebugUtil.DEBUG_ENABLED,
																  DebugUtil.DEBUG_VERBOSE_ENABLED);
		}
	}

	@NotifyChanged(featureIds = VulkanPackage.VULKAN_ENGINE__ENABLED)
	public void notifyChanged(Notification notification)
	{
		if (engine != null && notification.getNewBooleanValue() != notification.getOldBooleanValue())
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

	private void load()
	{
		try (final var stack = stackPush())
		{
			createInstance(stack);
			if (window != null) window.open(vkInstance.getVkInstance());

			final var dummySurface = window != null ? window.createSurface() : null;
			pickPhysicalDevice(stack, dummySurface);
			createLogicalDevice(stack, dummySurface);
			if (dummySurface != null) dummySurface.free();

			if (window != null)
			{
				loadInputManager();
				window.addListener(openListener);
			}
		}

		try
		{
			allocate();
		}
		catch (final Throwable e)
		{
			e.printStackTrace();
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
		updateAllocation();

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

	private void updateAllocation()
	{
		if (allocator.isAllocationDirty())
		{
			for (final var process : engine.getProcesses())
			{
				final var adapter = process.adapt(IProcessAdapter.class);
				adapter.waitIdle();
				if (DebugUtil.DEBUG_VERBOSE_ENABLED)
				{
					System.err.println(WAIT_IDLE_RELOAD_ENGINE_RESOURCES);
				}
			}

			allocator.reloadDirtyElements();
		}
	}

	private void dispose()
	{
		if (allocated == true)
		{
			resourceAllocator.stop(engine);
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

		vulkanContext = null;

		cleanup();
	}

	private void allocate()
	{
		resourceAllocator.start(engine);
		vulkanContext = new VulkanContext(logicalDevice, window);

		allocationRoot = new VulkanEngineAllocationRoot(List.of(resourceAllocator.getAllocable()));
		allocator = IAllocationService.INSTANCE.createAllocator(allocationRoot, vulkanContext);
		allocator.allocate();

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
			final var adapter = process.adaptNotNull(InternalProcessAdapter.class);
			adapter.start(vulkanContext, allocator);
		}
	}

	private void free()
	{
		allocationRoot.executionContext.getQueue().waitIdle();
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
			final var adapter = process.adaptNotNull(InternalProcessAdapter.class);
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
		final var deviceSelector = new PhysicalDeviceSelector(vkInstance,
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
		final var vkFeatures = features.stream()
									   .map(f -> EPhysicalFeature.valueOf(f.getName()))
									   .collect(Collectors.toList());

		final var queueList = VulkanEngineUtils.generateQueueList(engine);
		queueList.add(VulkanEngineAllocationRoot.ENGINE_QUEUE_TYPE);
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

	@Override
	public VulkanInputManager getInputManager()
	{
		return inputManager;
	}
}
