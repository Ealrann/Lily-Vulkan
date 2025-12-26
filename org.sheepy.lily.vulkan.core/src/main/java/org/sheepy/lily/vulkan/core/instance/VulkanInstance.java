package org.sheepy.lily.vulkan.core.instance;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.sheepy.lily.vulkan.core.debug.DebugReportCallbackImpl;
import org.sheepy.lily.vulkan.core.engine.extension.InstanceExtensions;
import org.sheepy.lily.vulkan.core.instance.loader.InstanceUtils;
import org.sheepy.lily.vulkan.core.instance.loader.Layers;
import org.sheepy.lily.vulkan.core.util.Logger;

import static org.lwjgl.vulkan.EXTDebugReport.vkDestroyDebugReportCallbackEXT;
import static org.lwjgl.vulkan.VK10.*;

public final class VulkanInstance
{
	private static final String ENGINE_NAME = "Lily";
	private static final String CREATION_FAILED = "Failed to create VkInstance";

	private final InstanceExtensions instanceExtensions;
	private final String title;
	private final Layers layers;
	private final boolean debugCallback;

	private VkInstance vkInstance;

	private VkDebugReportCallbackEXT vkDebugReportCallback;
	private long debugCallbackHandle = -1;

	public VulkanInstance(String title, InstanceExtensions instanceExtensions, Layers layers, boolean debugCallback)
	{
		this.instanceExtensions = instanceExtensions;
		this.title = title;
		this.layers = layers;
		this.debugCallback = debugCallback;
	}

	public void allocate(MemoryStack stack)
	{
		final var allocTitle = MemoryUtil.memUTF8(title);
		final var allocEngineName = MemoryUtil.memUTF8(ENGINE_NAME);

		final var appInfo = VkApplicationInfo.malloc(stack)
											 .set(VK_STRUCTURE_TYPE_APPLICATION_INFO,
												  VK_NULL_HANDLE,
												  allocTitle,
												  VK_MAKE_VERSION(1, 0, 0),
												  allocEngineName,
												  VK_MAKE_VERSION(1, 0, 0),
												  VK_MAKE_VERSION(1, 0, 0));

		final var requiredExtensions = instanceExtensions.callocBuffer();
		final var layersBuffer = layers.callocBuffer();
		final var createInfo = VkInstanceCreateInfo.calloc()
												   .set(VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO,
														VK_NULL_HANDLE,
														0,
														appInfo,
														layersBuffer,
														requiredExtensions);

		final var pInstancePtr = stack.mallocPointer(1);
		Logger.check(CREATION_FAILED, () -> vkCreateInstance(createInfo, null, pInstancePtr));
		vkInstance = new VkInstance(pInstancePtr.get(0), createInfo);

		requiredExtensions.free();
		layersBuffer.free();
		createInfo.free();

		if (debugCallback && instanceExtensions.supportDebug())
		{
			installDebugCallback(stack);
		}
	}

	private void installDebugCallback(MemoryStack stack)
	{
		vkDebugReportCallback = new DebugReportCallbackImpl();
		debugCallbackHandle = InstanceUtils.setupDebugCallback(stack, vkInstance, vkDebugReportCallback);
	}

	public VkInstance getVkInstance()
	{
		return vkInstance;
	}

	public void free()
	{
		if (debugCallback)
		{
			vkDestroyDebugReportCallbackEXT(vkInstance, debugCallbackHandle, null);
			if (vkDebugReportCallback != null)
			{
				vkDebugReportCallback.free();
			}
			debugCallbackHandle = 0;
		}

		vkDestroyInstance(vkInstance, null);
	}
}
