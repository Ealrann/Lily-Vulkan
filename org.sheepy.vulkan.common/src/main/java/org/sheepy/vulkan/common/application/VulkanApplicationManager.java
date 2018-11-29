package org.sheepy.vulkan.common.application;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.memUTF8;
import static org.lwjgl.vulkan.EXTDebugReport.vkDestroyDebugReportCallbackEXT;
import static org.lwjgl.vulkan.KHRSwapchain.VK_KHR_SWAPCHAIN_EXTENSION_NAME;
import static org.lwjgl.vulkan.VK10.VK_MAKE_VERSION;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_APPLICATION_INFO;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO;
import static org.lwjgl.vulkan.VK10.vkCreateInstance;
import static org.lwjgl.vulkan.VK10.vkDestroyInstance;
import static org.lwjgl.vulkan.VK10.vkQueueWaitIdle;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.sheepy.vulkan.api.adapter.IProcessPoolAdapter;
import org.sheepy.vulkan.api.window.Surface;
import org.sheepy.vulkan.common.allocation.allocator.TreeAllocator;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.device.PhysicalDevice;
import org.sheepy.vulkan.common.device.judge.PhysicalDeviceSelector;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.common.util.VulkanUtils;
import org.sheepy.vulkan.common.window.Window;
import org.sheepy.vulkan.model.IComputeProcessPool;
import org.sheepy.vulkan.model.IProcessPool;
import org.sheepy.vulkan.model.VulkanApplication;

public class VulkanApplicationManager
{
	private static final ByteBuffer[] LAYERS_TO_ENABLE = {
			memUTF8("VK_LAYER_LUNARG_standard_validation")
	};

	private static final String[] REQUIRED_EXTENSIONS = {
			VK_KHR_SWAPCHAIN_EXTENSION_NAME
	};

	protected final boolean debug;

	protected VkInstance vkInstance;
	protected PhysicalDevice physicalDevice;
	protected LogicalDevice logicalDevice = null;

	private long debugCallbackHandle = -1;
	private PointerBuffer ppEnabledLayerNames = null;

	protected VulkanApplication application;
	protected Window window;
	private final TreeAllocator allocator;

	public VulkanApplicationManager(VulkanApplication application)
	{
		this.application = application;

		debug = application.isDebug();
		allocator = new TreeAllocator(application);

		if (debug)
		{
			try (MemoryStack stack = stackPush())
			{
				loadLayerNames(stack);
			}
		}
	}

	public LogicalDevice initLogicalDevice()
	{
		try (MemoryStack stack = stackPush())
		{
			window = new Window(application);
			createInstance(stack);
			window.open(vkInstance);
			pickPhysicalDevice(stack);
			createLogicalDevice(stack);
		}

		return logicalDevice;
	}

	public void loadPipelinePool()
	{
		try (MemoryStack stack = stackPush())
		{
			allocator.allocate(stack);
		}
	}

	public void resize(Surface surface)
	{
		logicalDevice.recreateQueues(surface);
	}

	public void stop()
	{
		if (logicalDevice != null)
		{
			logicalDevice.waitIdle();
		}
		cleanup();
		window.close();
	}

	public void prepare()
	{
		Window.pollEvents();

		if (allocator.isDirty())
		{
			try (MemoryStack stack = stackPush())
			{
				allocator.reloadDirtyElements(stack);
			}

			final var graphicPool = application.getGraphicPool();
			if (graphicPool != null)
			{
				final var graphicPoolAdapter = IProcessPoolAdapter.adapt(graphicPool);
				graphicPoolAdapter.recordCommands();
			}

			for (final IComputeProcessPool computePool : application.getComputePools())
			{
				final var computePoolAdapter = IProcessPoolAdapter.adapt(computePool);
				computePoolAdapter.recordCommands();
			}

			vkQueueWaitIdle(logicalDevice.queueManager.getPresentQueue().vkQueue);
		}
	}

	public static void execute(IProcessPool processPool)
	{
		var poolAdapter = IProcessPoolAdapter.adapt(processPool);
		poolAdapter.execute();
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
		VulkanUtils.printAvailableLayers(stack);
		ppEnabledLayerNames = stack.mallocPointer(LAYERS_TO_ENABLE.length);
		for (int i = 0; i < LAYERS_TO_ENABLE.length; i++)
			ppEnabledLayerNames.put(LAYERS_TO_ENABLE[i]);
		ppEnabledLayerNames.flip();
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

		if (debug) physicalDevice.printDeviceProperties();
	}

	private void createLogicalDevice(MemoryStack stack)
	{
		logicalDevice = LogicalDevice.alloc(stack, physicalDevice, window, REQUIRED_EXTENSIONS,
				ppEnabledLayerNames, true);
	}

	private void cleanup()
	{
		allocator.free();
		logicalDevice.free();

		if (debug)
		{
			vkDestroyDebugReportCallbackEXT(vkInstance, debugCallbackHandle, null);
		}

		vkDestroyInstance(vkInstance, null);
	}

	public LogicalDevice getLogicalDevice()
	{
		return logicalDevice;
	}

	public Window getWindow()
	{
		return window;
	}
}
