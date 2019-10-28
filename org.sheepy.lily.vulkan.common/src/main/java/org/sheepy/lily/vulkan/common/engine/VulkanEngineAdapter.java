package org.sheepy.lily.vulkan.common.engine;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.common.allocation.TreeAllocator;
import org.sheepy.lily.vulkan.common.engine.utils.VulkanEngineAllocationRoot;
import org.sheepy.lily.vulkan.common.input.VulkanInputManager;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.IResource;
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
import org.sheepy.vulkan.extension.EngineExtensionRequirement;
import org.sheepy.vulkan.instance.VulkanInstance;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.surface.VkSurface;
import org.sheepy.vulkan.window.IWindowListener;
import org.sheepy.vulkan.window.Window;

@Statefull
@Adapter(scope = VulkanEngine.class)
public class VulkanEngineAdapter implements IVulkanEngineAdapter
{
	private static final String USING_GRAPHIC_DEVICE = "\nUsing Graphic Device: %s (%s)";

	private final IWindowListener windowListener = new IWindowListener()
	{
		@Override
		public void onResize(Vector2i size)
		{
			resize(size);
		}

		@Override
		public void onOpen(long id)
		{
			inputManager.load();
		}
	};

	private final List<VkFence> fences = new ArrayList<>();
	private final VulkanInputManager inputManager;
	private final VulkanEngine engine;
	private final Application application;
	private final EngineExtensionRequirement extensionRequirement;

	protected VulkanInstance vkInstance;
	protected PhysicalDevice physicalDevice;
	protected LogicalDevice logicalDevice = null;
	protected VulkanContext vulkanContext = null;
	protected TreeAllocator<IVulkanContext> allocator;
	private VulkanEngineAllocationRoot allocationRoot;
	private boolean allocated = false;
	private ExecutionContext executionContext = null;

	protected Window window;
	private boolean listeningResize = true;

	private final AdapterImpl applicationAdapter = new AdapterImpl()
	{
		@Override
		public void notifyChanged(Notification notification)
		{
			if (listeningResize)
			{
				if (notification.getFeature() == ApplicationPackage.Literals.APPLICATION__SIZE)
				{
					final Vector2ic newSize = (Vector2ic) notification.getNewValue();
					window.setSize(newSize.x(), newSize.y());
				}
				else if (notification.getFeature() == ApplicationPackage.Literals.APPLICATION__FULLSCREEN)
				{
					window.requestFullscreen(notification.getNewBooleanValue());
				}
			}
		}
	};

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

	public VulkanEngineAdapter(VulkanEngine engine)
	{
		this.engine = engine;
		application = (Application) engine.eContainer();
		if (application.isHeadless() == false)
		{
			window = new Window(application.getSize(),
								application.getTitle(),
								application.isResizeable(),
								application.isFullscreen());
			inputManager = new VulkanInputManager(application, window);
		}
		else
		{
			window = null;
			inputManager = null;
		}
		executionContext = new ExecutionContext(EQueueType.Graphic, false);

		try (MemoryStack stack = stackPush())
		{
			extensionRequirement = new EngineExtensionRequirement(	stack,
																	DebugUtil.DEBUG_ENABLED,
																	DebugUtil.DEBUG_VERBOSE_ENABLED);
		}
	}

	@Override
	public void start()
	{
		application.eAdapters().add(applicationAdapter);

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

		application.eAdapters().remove(applicationAdapter);
	}

	private void load()
	{
		try
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
				if (inputManager != null) inputManager.load();
				if (window != null) window.addListener(windowListener);
			}

			allocate();

		} catch (final Throwable e)
		{
			e.printStackTrace();
		}
	}

	private void resize(Vector2i size)
	{
		listeningResize = false;

		try
		{
			final Vector2i newSize = new Vector2i(size);
			application.setSize(newSize);
		} catch (final Throwable e)
		{
			e.printStackTrace();
		} finally
		{
			listeningResize = true;
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

		if (window != null) window.removeListener(windowListener);
		cleanup();
	}

	private void allocate()
	{
		allocationRoot = new VulkanEngineAllocationRoot(executionContext, gatherResourceAdapters());
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

	private List<IResourceAdapter> gatherResourceAdapters()
	{
		final List<IResourceAdapter> allocationList = new ArrayList<>();
		final var resourcePkg = engine.getResourcePkg();
		if (resourcePkg != null)
		{
			final var resources = resourcePkg.getResources();
			for (final IResource resource : resources)
			{
				final var resourceAdapter = resource.adapt(IResourceAdapter.class);
				if (resourceAdapter != null)
				{
					allocationList.add(resourceAdapter);
				}
			}
		}
		return allocationList;
	}

	private void free()
	{
		executionContext.getQueue().waitIdle();
		allocator.free();

		stopProcesses();

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

		printDeviceInfo();

		if (DebugUtil.DEBUG_ENABLED)
		{
			physicalDevice.printRetainedExtensions();
		}
		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			physicalDevice.printPhysicalProperties();
		}
	}

	private void printDeviceInfo()
	{
		final String name = physicalDevice.getName();
		final int driverVersion = physicalDevice.getDriverVersion();
		final var deviceInfo = String.format(USING_GRAPHIC_DEVICE, name, driverVersion);
		System.out.println(deviceInfo);
	}

	private void createLogicalDevice(MemoryStack stack, VkSurface dummySurface)
	{
		final var features = engine.getFeatures();
		final var vkFeatures = features	.stream()
										.map(f -> EPhysicalFeature.valueOf(f.getName()))
										.collect(Collectors.toList());

		logicalDevice = new LogicalDevice(physicalDevice, dummySurface, vkFeatures, true);
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
