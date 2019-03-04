package org.sheepy.lily.vulkan.common.engine;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.vulkan.EXTDebugReport.vkDestroyDebugReportCallbackEXT;
import static org.lwjgl.vulkan.KHRSwapchain.VK_KHR_SWAPCHAIN_EXTENSION_NAME;
import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.joml.Vector2i;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.sheepy.lily.core.api.adapter.IAutoAdapter;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.impl.AbstractStatefullAdapter;
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
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;
import org.sheepy.lily.vulkan.common.device.judge.PhysicalDeviceSelector;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.lily.vulkan.common.input.VulkanInputManager;
import org.sheepy.lily.vulkan.common.util.LayerFinder;
import org.sheepy.lily.vulkan.common.util.VulkanUtils;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanPackage;

public class VulkanEngineAdapter extends AbstractStatefullAdapter
		implements IVulkanEngineAdapter, IAutoAdapter, IExecutionManagerAdapter
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

	private static final String[] REQUIRED_EXTENSIONS = {
			VK_KHR_SWAPCHAIN_EXTENSION_NAME
	};

	protected boolean debug;

	protected VkInstance vkInstance;
	protected PhysicalDevice physicalDevice;
	protected LogicalDevice logicalDevice = null;
	protected LogicalDeviceContext logicalDeviceContext = null;
	protected TreeAllocator allocator;
	private VulkanEngineAllocationRoot allocationRoot;
	private boolean allocated = false;

	private long debugCallbackHandle = -1;
	private PointerBuffer ppEnabledLayerNames = null;
	private VulkanInputManager inputManager;
	private ExecutionContext executionContext = null;

	protected Application application;
	protected VulkanEngine engine;
	protected Window window;
	private boolean listeningResize = true;
	private final List<VkFence> fences = new ArrayList<>();
	private final IWindowListener resizeListener = new IWindowListener()
	{
		@Override
		public void onWindowResize(VkSurface surface)
		{
			resize(surface);
		}
	};

	private final Adapter applicationAdapter = new AdapterImpl()
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

	@Override
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

	@Override
	public void load(EObject target)
	{
		engine = (VulkanEngine) target;
		application = (Application) engine.eContainer();
		application.eAdapters().add(applicationAdapter);
		debug = application.isDebug();
		executionContext = new ExecutionContext(EQueueType.Graphic, false);

		window = new Window(application.getSize(), application.getTitle(),
				application.isResizeable(), application.isFullscreen());
		inputManager = new VulkanInputManager(application, window);

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

	@Override
	public void dispose(EObject target)
	{
		if (engine != null)
		{
			if (engine.isEnabled())
			{
				stop();
			}
		}

		application.eAdapters().remove(applicationAdapter);

		engine = null;
		application = null;
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

		final var requiredExtensions = VulkanUtils.getRequiredExtensions(stack, debug);
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
			debugCallbackHandle = VulkanUtils.setupDebugCallback(stack, vkInstance);
		}
	}

	private void loadLayerNames(MemoryStack stack)
	{
		VulkanUtils.printAvailableExtensions(stack);
		ppEnabledLayerNames = LayerFinder.convertToPointerBuffer(stack, LAYERS_TO_ENABLE);
	}

	private void pickPhysicalDevice(MemoryStack stack)
	{
		final var deviceSelector = new PhysicalDeviceSelector(vkInstance, REQUIRED_EXTENSIONS,
				window.getSurface());

		physicalDevice = deviceSelector.findBestPhysicalDevice(stack);

		String deviceInfo = String.format("\nGraphic Device: %s (%s)", physicalDevice.getName(),
				physicalDevice.getDriverVersion());
		System.out.println(deviceInfo);

		if (debug) physicalDevice.deviceProperties.print();
	}

	private void createLogicalDevice(MemoryStack stack)
	{
		logicalDevice = LogicalDevice.alloc(stack, physicalDevice, window, REQUIRED_EXTENSIONS,
				ppEnabledLayerNames, true);
		logicalDeviceContext = new LogicalDeviceContext(logicalDevice);
	}

	private void cleanup()
	{
		logicalDevice.free();

		if (debug)
		{
			vkDestroyDebugReportCallbackEXT(vkInstance, debugCallbackHandle, null);
			debugCallbackHandle = -1;
		}

		window.close();

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

	@Override
	public ExecutionContext getExecutionContext()
	{
		return executionContext;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanPackage.Literals.VULKAN_ENGINE == eClass;
	}

	public static VulkanEngineAdapter adapt(VulkanEngine engine)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(engine, VulkanEngineAdapter.class);
	}
}
