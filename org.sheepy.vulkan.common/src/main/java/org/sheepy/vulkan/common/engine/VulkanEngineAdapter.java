package org.sheepy.vulkan.common.engine;

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
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.sheepy.common.api.adapter.IAutoAdapter;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.common.api.input.IInputManager;
import org.sheepy.common.api.types.SVector2i;
import org.sheepy.common.model.application.Application;
import org.sheepy.common.model.application.ApplicationPackage;
import org.sheepy.vulkan.api.adapter.IEnginePartAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.vulkan.api.concurrent.IFence;
import org.sheepy.vulkan.api.window.IWindowListener;
import org.sheepy.vulkan.api.window.Surface;
import org.sheepy.vulkan.common.concurrent.VkFence;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.device.PhysicalDevice;
import org.sheepy.vulkan.common.device.judge.PhysicalDeviceSelector;
import org.sheepy.vulkan.common.input.VulkanInputManager;
import org.sheepy.vulkan.common.util.LayerFinder;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.common.util.VulkanUtils;
import org.sheepy.vulkan.common.window.Window;
import org.sheepy.vulkan.model.IProcess;
import org.sheepy.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.model.VulkanPackage;

public class VulkanEngineAdapter extends AbstractStatefullAdapter
		implements IVulkanEngineAdapter, IAutoAdapter
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
	boolean allocated = false;

	protected VkInstance vkInstance;
	protected PhysicalDevice physicalDevice;
	protected LogicalDevice logicalDevice = null;

	private long debugCallbackHandle = -1;
	private PointerBuffer ppEnabledLayerNames = null;
	private VulkanInputManager inputManager;

	protected Application application;
	protected VulkanEngine engine;
	protected Window window;
	private boolean listeningResize = true;
	private final List<VkFence> fences = new ArrayList<>();
	private final IWindowListener resizeListener = new IWindowListener()
	{
		@Override
		public void onWindowResize(Surface surface)
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
					SVector2i newSize = (SVector2i) notification.getNewValue();
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

	@Override
	public void start()
	{
		try (MemoryStack stack = stackPush())
		{
			window = new Window(application);
			createInstance(stack);
			window.open(vkInstance);
			inputManager = new VulkanInputManager(application, window);
			pickPhysicalDevice(stack);
			createLogicalDevice(stack);

			window.addListener(resizeListener);
		}
	}

	private void resize(Surface surface)
	{
		listeningResize = false;

		try
		{
			SVector2i size = new SVector2i();
			size.x = surface.width;
			size.y = surface.height;

			application.setSize(size);
			logicalDevice.recreateQueues(surface);
		} finally
		{
			listeningResize = true;
		}
	}

	@Override
	public void stop()
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
		window.close();
	}

	@Override
	public void allocate()
	{
		var sharedResources = engine.getSharedResources();
		if (sharedResources != null)
		{
			var adapter = IEnginePartAdapter.adapt(sharedResources);
			adapter.allocatePart();
		}

		for (IProcess process : engine.getProcesses())
		{
			var adapter = IEnginePartAdapter.adapt(process);
			adapter.allocatePart();
		}
		allocated = true;
	}

	@Override
	public void free()
	{
		var sharedResources = engine.getSharedResources();
		if (sharedResources != null)
		{
			var adapter = IEnginePartAdapter.adapt(sharedResources);
			adapter.freePart();
		}

		for (IProcess process : engine.getProcesses())
		{
			var adapter = IEnginePartAdapter.adapt(process);
			adapter.freePart();
		}

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
		final var surface = window.getSurface();
		final var deviceSelector = new PhysicalDeviceSelector(vkInstance, REQUIRED_EXTENSIONS,
				surface);

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
	}

	private void cleanup()
	{
		logicalDevice.free();

		if (debug)
		{
			vkDestroyDebugReportCallbackEXT(vkInstance, debugCallbackHandle, null);
			debugCallbackHandle = -1;
		}

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
	public IInputManager getInputManager()
	{
		return inputManager;
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
