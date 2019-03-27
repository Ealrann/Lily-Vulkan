package org.sheepy.lily.vulkan.common.engine;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.joml.Vector2i;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkFence;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.TreeAllocator;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;
import org.sheepy.lily.vulkan.common.device.VulkanContext;
import org.sheepy.lily.vulkan.common.device.VulkanInstance;
import org.sheepy.lily.vulkan.common.device.judge.PhysicalDeviceSelector;
import org.sheepy.lily.vulkan.common.engine.utils.EngineExtensionRequirement;
import org.sheepy.lily.vulkan.common.engine.utils.VulkanEngineAllocationRoot;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.input.VulkanInputManager;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanPackage;

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
		public void onClose(long oldId)
		{}

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

	private final boolean debug;

	protected VulkanInstance vkInstance;
	protected PhysicalDevice physicalDevice;
	protected LogicalDevice logicalDevice = null;
	protected VulkanContext vulkanContext = null;
	protected TreeAllocator allocator;
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
					final Vector2i newSize = (Vector2i) notification.getNewValue();
					window.setSize(newSize.x, newSize.y);
				}
				else if (notification
						.getFeature() == ApplicationPackage.Literals.APPLICATION__FULLSCREEN)
				{
					window.requestFullscreen(notification.getNewBooleanValue());
				}
			}
		}
	};

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == VulkanPackage.Literals.VULKAN_ENGINE__ENABLED)
		{
			if (engine != null
					&& notification.getNewBooleanValue() != notification.getOldBooleanValue())
			{
				if (engine.isEnabled())
				{
					start();
				}
				else
				{
					stop();
				}
			}
		}
	}

	public VulkanEngineAdapter(VulkanEngine engine)
	{
		this.engine = engine;
		application = (Application) engine.eContainer();
		debug = DebugUtil.DEBUG_ENABLED;
		window = new Window(application.getSize(), application.getTitle(),
				application.isResizeable(), application.isFullscreen());
		executionContext = new ExecutionContext(EQueueType.Graphic, false);
		inputManager = new VulkanInputManager(application, window);

		try (MemoryStack stack = stackPush())
		{
			extensionRequirement = new EngineExtensionRequirement(engine, stack, debug);
		}
	}

	@Autorun
	public void load()
	{
		application.eAdapters().add(applicationAdapter);

		if (engine.isEnabled())
		{
			start();
		}
	}

	@Dispose
	public void dispose()
	{
		if (engine != null)
		{
			if (engine.isEnabled())
			{
				stop();
			}
		}

		application.eAdapters().remove(applicationAdapter);
	}

	private void start()
	{
		try (MemoryStack stack = stackPush())
		{
			createInstance(stack);
			window.open(vkInstance.getVkInstance());

			final var dummySurface = window.createSurface();
			pickPhysicalDevice(stack, dummySurface);
			createLogicalDevice(stack, dummySurface);
			dummySurface.free();

			vulkanContext = new VulkanContext(logicalDevice, window);
			inputManager.load();
			window.addListener(windowListener);
			allocate(stack);
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

	private void stop()
	{
		if (allocated == true)
		{
			free();
		}

		if (logicalDevice != null)
		{
			logicalDevice.waitIdle();
		}

		window.removeListener(windowListener);
		cleanup();
	}

	private void allocate(MemoryStack stack)
	{
		allocationRoot = new VulkanEngineAllocationRoot(executionContext, gatherAllocationList());
		allocator = new TreeAllocator(allocationRoot);
		allocator.allocate(stack, vulkanContext);
		allocated = true;
	}

	private List<Object> gatherAllocationList()
	{
		final List<Object> allocationList = new ArrayList<>();
		final var resourcePkg = engine.getResourcePkg();
		if (resourcePkg != null)
		{
			allocationList.addAll(resourcePkg.getResources());
		}
		allocationList.addAll(engine.getProcesses());
		return allocationList;
	}

	private void free()
	{
		executionContext.getQueue().waitIdle();
		allocator.free(vulkanContext);

		for (final VkFence fence : fences)
		{
			fence.free(vulkanContext);
		}
		allocated = false;
	}

	private void createInstance(MemoryStack stack)
	{

		vkInstance = new VulkanInstance(application, extensionRequirement, debug);

		vkInstance.allocate(stack);

	}

	private void pickPhysicalDevice(MemoryStack stack, VkSurface dummySurface)
	{
		final var deviceSelector = new PhysicalDeviceSelector(vkInstance, extensionRequirement,
				dummySurface, debug);

		physicalDevice = deviceSelector.findBestPhysicalDevice(stack);

		printDeviceInfo();

		if (debug)
		{
			physicalDevice.printRetainedExtensions();
			// physicalDevice.printPhysicalProperties();
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

		logicalDevice = new LogicalDevice(physicalDevice, dummySurface, features, true);
		logicalDevice.allocate(stack);
	}

	private void cleanup()
	{
		inputManager.dispose();
		logicalDevice.free();

		window.close();
		window.destroy();

		physicalDevice.free();

		vkInstance.free();
		vkInstance = null;
	}

	@Override
	public IFence newFence()
	{
		return newFence(false);
	}

	@Override
	public IFence newFence(boolean signaled)
	{
		final VkFence res = new VkFence(signaled);
		res.allocate(null, vulkanContext);

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

	public static VulkanEngineAdapter adapt(VulkanEngine engine)
	{
		return IAdapterFactoryService.INSTANCE.adapt(engine, VulkanEngineAdapter.class);
	}
}
