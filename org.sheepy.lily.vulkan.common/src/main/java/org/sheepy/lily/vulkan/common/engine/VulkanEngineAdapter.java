package org.sheepy.lily.vulkan.common.engine;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.vulkan.EXTDebugReport.vkDestroyDebugReportCallbackEXT;
import static org.lwjgl.vulkan.KHRSwapchain.VK_KHR_SWAPCHAIN_EXTENSION_NAME;
import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.joml.Vector2i;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.allocator.TreeAllocator;
import org.sheepy.lily.vulkan.common.concurrent.VkFence;
import org.sheepy.lily.vulkan.common.device.DeviceExtension;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;
import org.sheepy.lily.vulkan.common.device.judge.PhysicalDeviceSelector;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.input.VulkanInputManager;
import org.sheepy.lily.vulkan.common.util.LayerFinder;
import org.sheepy.lily.vulkan.common.util.VulkanUtils;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanPackage;

@Statefull
@Adapter(scope = VulkanEngine.class)
public class VulkanEngineAdapter implements IVulkanEngineAdapter
{
	private static final String[] LAYERS_TO_ENABLE = {
			"VK_LAYER_LUNARG_standard_validation",
			"VK_LAYER_GOOGLE_threading",
			"VK_LAYER_LUNARG_parameter_validation",
			"VK_LAYER_LUNARG_object_tracker",
			"VK_LAYER_LUNARG_core_validation",
			"VK_LAYER_GOOGLE_unique_objects",
			// "VK_LAYER_LUNARG_api_dump"
	};

	private static final DeviceExtension[] REQUIRED_DEVICE_EXTENSIONS = {
			new DeviceExtension(VK_KHR_SWAPCHAIN_EXTENSION_NAME, true)
	};

	private final IWindowListener resizeListener = new IWindowListener()
	{
		@Override
		public void onWindowResize(VkSurface surface)
		{
			resize(surface);
		}
	};

	private final List<VkFence> fences = new ArrayList<>();
	private final VulkanInputManager inputManager;
	private final VulkanEngine engine;
	private final Application application;

	private final boolean debug;

	protected VkInstance vkInstance;
	protected PhysicalDevice physicalDevice;
	protected LogicalDevice logicalDevice = null;
	protected LogicalDeviceContext logicalDeviceContext = null;
	protected TreeAllocator allocator;
	private VulkanEngineAllocationRoot allocationRoot;
	private boolean allocated = false;
	private VkDebugReportCallbackEXT vkDebugReportCallback;

	private long debugCallbackHandle = -1;
	private PointerBuffer ppEnabledLayerNames = null;
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
					Vector2i newSize = (Vector2i) notification.getNewValue();
					window.setSize(newSize.x, newSize.y);
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
		debug = application.isDebug();
		executionContext = new ExecutionContext(EQueueType.Graphic, false);
		window = new Window(application.getSize(), application.getTitle(),
				application.isResizeable(), application.isFullscreen());
		inputManager = new VulkanInputManager(application, window);
	}

	@Autorun
	public void load()
	{
		application.eAdapters().add(applicationAdapter);

		if (debug)
		{
			try (MemoryStack stack = stackPush())
			{
				loadLayerNames(stack);
			}
		}

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
			window.open(vkInstance);
			pickPhysicalDevice(stack);
			createLogicalDevice(stack);
			inputManager.load();
			window.addListener(resizeListener);
			allocate(stack);
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	private void resize(VkSurface surface)
	{
		listeningResize = false;

		try
		{
			Vector2i newSize = new Vector2i(surface.width, surface.height);
			application.setSize(newSize);
			logicalDevice.recreateQueues(surface);
		} catch (Throwable e)
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

		window.removeListener(resizeListener);
		cleanup();
	}

	private void allocate(MemoryStack stack)
	{
		allocationRoot = new VulkanEngineAllocationRoot(executionContext, gatherAllocationList());
		allocator = new TreeAllocator(allocationRoot);
		allocator.allocate(stack, logicalDeviceContext);
		allocated = true;
	}

	private List<Object> gatherAllocationList()
	{
		List<Object> allocationList = new ArrayList<>();
		var resourcePkg = engine.getResourcePkg();
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
		allocator.free(logicalDeviceContext);

		for (VkFence fence : fences)
		{
			fence.free();
		}
		allocated = false;
	}

	private void createInstance(MemoryStack stack)
	{
		final VkApplicationInfo appInfo = VkApplicationInfo.callocStack(stack);
		appInfo.sType(VK_STRUCTURE_TYPE_APPLICATION_INFO);
		appInfo.pApplicationName(stack.UTF8(application.getTitle()));
		appInfo.applicationVersion(VK_MAKE_VERSION(1, 0, 0));
		appInfo.pEngineName(stack.UTF8("Sheepy"));
		appInfo.engineVersion(VK_MAKE_VERSION(1, 0, 0));
		appInfo.apiVersion(VK_MAKE_VERSION(1, 0, 0));

		final var requiredExtensions = VulkanUtils.getRequiredInstanceExtensions(stack, debug);
		final VkInstanceCreateInfo createInfo = VkInstanceCreateInfo.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO);
		createInfo.pApplicationInfo(appInfo);
		createInfo.ppEnabledExtensionNames(requiredExtensions);
		createInfo.ppEnabledLayerNames(ppEnabledLayerNames);

		final var aInstance = stack.mallocPointer(1);
		final int err = vkCreateInstance(createInfo, null, aInstance);
		Logger.check(err, "Failed to create VkInstance");
		final long instance = aInstance.get(0);

		vkInstance = new VkInstance(instance, createInfo);
		if (debug)
		{
			vkDebugReportCallback = new VkDebugReportCallbackEXT()
			{
				@Override
				public int invoke(	int flags,
									int objectType,
									long object,
									long location,
									int messageCode,
									long pLayerPrefix,
									long pMessage,
									long pUserData)
				{
					String message = VkDebugReportCallbackEXT.getString(pMessage);
					System.err.println("ERROR OCCURED: " + message);
					return 0;
				}
			};

			debugCallbackHandle = VulkanUtils.setupDebugCallback(stack, vkInstance,
					vkDebugReportCallback);
		}
	}

	private void loadLayerNames(MemoryStack stack)
	{
		VulkanUtils.printAvailableExtensions(stack);
		ppEnabledLayerNames = LayerFinder.convertToPointerBuffer(stack, LAYERS_TO_ENABLE);
	}

	private void pickPhysicalDevice(MemoryStack stack)
	{
		final var deviceSelector = new PhysicalDeviceSelector(vkInstance,
				REQUIRED_DEVICE_EXTENSIONS, window.getSurface(), debug);

		physicalDevice = deviceSelector.findBestPhysicalDevice(stack);

		String deviceInfo = String.format("\nUsing Graphic Device: %s (%s)",
				physicalDevice.getName(), physicalDevice.getDriverVersion());
		System.out.println(deviceInfo);

		if (debug)
		{
			physicalDevice.printRetainedExtensions();
			// physicalDevice.printPhysicalProperties();
		}
	}

	private void createLogicalDevice(MemoryStack stack)
	{
		logicalDevice = LogicalDevice.alloc(stack, physicalDevice, window, true);
		logicalDeviceContext = new LogicalDeviceContext(logicalDevice);
	}

	private void cleanup()
	{
		inputManager.dispose();
		logicalDevice.free();

		if (debug)
		{
			vkDestroyDebugReportCallbackEXT(vkInstance, debugCallbackHandle, null);
			if (vkDebugReportCallback != null)
			{
				vkDebugReportCallback.free();
			}
			debugCallbackHandle = -1;
		}

		window.close();

		physicalDevice.free();

		vkDestroyInstance(vkInstance, null);
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
		VkFence res = new VkFence(logicalDevice.getVkDevice());
		res.allocate(signaled);

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
		return IServiceAdapterFactory.INSTANCE.adapt(engine, VulkanEngineAdapter.class);
	}
}
