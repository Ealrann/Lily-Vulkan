package org.sheepy.lily.game.vulkan;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.memUTF8;
import static org.lwjgl.vulkan.EXTDebugReport.vkDestroyDebugReportCallbackEXT;
import static org.lwjgl.vulkan.KHRSwapchain.VK_KHR_SWAPCHAIN_EXTENSION_NAME;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.device.PhysicalDeviceSelector;
import org.sheepy.lily.game.vulkan.device.PhysicalDeviceWrapper;
import org.sheepy.lily.game.vulkan.util.VulkanUtils;
import org.sheepy.lily.game.vulkan.window.IWindowListener;
import org.sheepy.lily.game.vulkan.window.Window;

public class VulkanApplication
{
	public static boolean DEBUG = true;
	private static final ByteBuffer[] LAYERS_TO_ENABLE = {
			memUTF8("VK_LAYER_LUNARG_standard_validation")
	};

	private static final String[] REQUIRED_EXTENSIONS = {
			VK_KHR_SWAPCHAIN_EXTENSION_NAME
	};

	private VkInstance vkInstance;
	private PhysicalDeviceWrapper physicalDevice;
	private long debugCallbackHandle = -1;
	private PointerBuffer ppEnabledLayerNames;

	private LogicalDevice logicalDevice = null;

	private int width;
	private int height;
	private Window window;

	public VulkanApplication(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public void run()
	{
		mainLoop();
		cleanup();
	}

	public LogicalDevice initLogicalDevice()
	{
		return initLogicalDevice(false);
	}

	public LogicalDevice initLogicalDevice(boolean needComputeCapability)
	{
		try (MemoryStack stack = stackPush())
		{
			window = new Window(width, height);
			window.addListener(new IWindowListener()
			{
				@Override
				public void onWindowResize(long surface, int width, int height)
				{
					logicalDevice.recreateSwapChain(surface, width, height);
				}
			});
			createInstance(stack);
			window.open(vkInstance);
			pickPhysicalDevice(stack);
			createLogicalDevice(stack);
		}

		return logicalDevice;
	}

	public void stop()
	{
		cleanup();
	}

	public void mainLoop()
	{
		long counter = 0;
		long counterTime = System.currentTimeMillis();
		boolean ecoMode = false;

		while (window.shouldClose() == false)
		{
			window.pollEvents();
			updateAppState();
			drawFrame();

			if (ecoMode == false)
			{
				counter++;

				if (System.currentTimeMillis() > counterTime + 2000)
				{
					System.out.println("FPS: " + (counter / 2));
					ecoMode = true;
				}
			}
			else
			{
				try
				{
					Thread.sleep(16);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}

		logicalDevice.waitIdle();
	}

	public void drawFrame()
	{
		vkQueueWaitIdle(logicalDevice.getQueueManager().getPresentQueue());

		logicalDevice.draw();
	}

	protected void updateAppState()
	{}

	private void createInstance(MemoryStack stack)
	{
		VkApplicationInfo appInfo = VkApplicationInfo.calloc();
		appInfo.sType(VK_STRUCTURE_TYPE_APPLICATION_INFO);
		appInfo.pApplicationName(stack.UTF8("Hello Triangle"));
		appInfo.applicationVersion(VK_MAKE_VERSION(1, 0, 0));
		appInfo.pEngineName(stack.UTF8("No Engine"));
		appInfo.engineVersion(VK_MAKE_VERSION(1, 0, 0));
		appInfo.apiVersion(VK_API_VERSION_1_0);
		VkInstanceCreateInfo createInfo = VkInstanceCreateInfo.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO);
		createInfo.pApplicationInfo(appInfo);
		createInfo.ppEnabledExtensionNames(VulkanUtils.getRequiredExtensions(stack, window, DEBUG));
		if (DEBUG)
		{
			VulkanUtils.printAvailableExtensions(stack);
			VulkanUtils.printAvailableLayers(stack);
			ppEnabledLayerNames = stack.mallocPointer(LAYERS_TO_ENABLE.length);
			for (int i = 0; i < LAYERS_TO_ENABLE.length; i++)
				ppEnabledLayerNames.put(LAYERS_TO_ENABLE[i]);
			ppEnabledLayerNames.flip();
			createInfo.ppEnabledLayerNames(ppEnabledLayerNames);
		}

		PointerBuffer pInstance = stack.mallocPointer(1);
		int err = vkCreateInstance(createInfo, null, pInstance);
		long instance = pInstance.get(0);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError(
					"Failed to create VkInstance: " + VulkanUtils.translateVulkanResult(err));
		}

		vkInstance = new VkInstance(instance, createInfo);
		createInfo.free();
		appInfo.free();
		if (DEBUG)
		{
			debugCallbackHandle = VulkanUtils.setupDebugCallback(stack, vkInstance);
		}
	}

	private void pickPhysicalDevice(MemoryStack stack)
	{
		PhysicalDeviceSelector pds = new PhysicalDeviceSelector(vkInstance, REQUIRED_EXTENSIONS,
				window.getSurface());
		physicalDevice = pds.getBestPhysicalDevice();
		System.out.println("\nGraphic Device : " + physicalDevice.getName());
	}

	private void createLogicalDevice(MemoryStack stack)
	{
		logicalDevice = LogicalDevice.alloc(stack, physicalDevice, window.getSurface(),
				REQUIRED_EXTENSIONS, ppEnabledLayerNames);
	}

	public void cleanup()
	{
		logicalDevice.free();

		if (DEBUG)
		{
			vkDestroyDebugReportCallbackEXT(vkInstance, debugCallbackHandle, null);
		}
		vkDestroyInstance(vkInstance, null);
		window.close();
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
