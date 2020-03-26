package org.sheepy.lily.vulkan.core.instance;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.sheepy.lily.vulkan.core.engine.extension.EngineExtensionRequirement;
import org.sheepy.lily.vulkan.core.instance.loader.InstanceUtils;
import org.sheepy.lily.vulkan.core.instance.loader.LayerFinder;
import org.sheepy.lily.vulkan.core.util.Logger;

import static org.lwjgl.vulkan.EXTDebugReport.vkDestroyDebugReportCallbackEXT;
import static org.lwjgl.vulkan.VK10.*;

public final class VulkanInstance
{
	private static final String ENGINE_NAME = "Lily";
	private static final String CREATION_FAILED = "Failed to create VkInstance";

	private static final String[] LAYERS_TO_ENABLE = {"VK_LAYER_KHRONOS_validation", "VK_LAYER_RENDERDOC_Capture",
//			"VK_LAYER_MESA_overlay",
//			 "VK_LAYER_LUNARG_monitor",
			// "VK_LAYER_LUNARG_api_dump"
	};

	private final EngineExtensionRequirement requirements;
	private final String title;
	private final boolean debug;
	private final boolean verbose;

	private VkInstance vkInstance;

	private VkDebugReportCallbackEXT vkDebugReportCallback;
	private long debugCallbackHandle = -1;
	private PointerBuffer ppEnabledLayerNames = null;

	public VulkanInstance(String title, EngineExtensionRequirement requirements, boolean debug, boolean verbose)
	{
		this.requirements = requirements;
		this.title = title;
		this.debug = debug;
		this.verbose = verbose;
	}

	public void allocate(MemoryStack stack)
	{
		if (debug)
		{
			ppEnabledLayerNames = LayerFinder.convertToPointerBuffer(stack, LAYERS_TO_ENABLE, verbose);
		}

		final var appInfo = VkApplicationInfo.mallocStack(stack)
											 .set(VK_STRUCTURE_TYPE_APPLICATION_INFO,
												  VK_NULL_HANDLE,
												  stack.UTF8(title),
												  VK_MAKE_VERSION(1, 0, 0),
												  stack.UTF8(ENGINE_NAME),
												  VK_MAKE_VERSION(1, 0, 0),
												  VK_MAKE_VERSION(1, 0, 0));

		final var requiredExtensions = requirements.getRequiredInstanceExtensions(stack);
		final var createInfo = VkInstanceCreateInfo.mallocStack(stack)
												   .set(VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO,
														VK_NULL_HANDLE,
														0,
														appInfo,
														ppEnabledLayerNames,
														requiredExtensions);

		final var pInstancePtr = stack.mallocPointer(1);
		Logger.check(CREATION_FAILED, () -> vkCreateInstance(createInfo, null, pInstancePtr));
		vkInstance = new VkInstance(pInstancePtr.get(0), createInfo);

		if (debug && requirements.supportDebug())
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
		if (debug)
		{
			vkDestroyDebugReportCallbackEXT(vkInstance, debugCallbackHandle, null);
			if (vkDebugReportCallback != null)
			{
				vkDebugReportCallback.free();
			}
			debugCallbackHandle = -1;
		}

		vkDestroyInstance(vkInstance, null);
	}

	private static final class DebugReportCallbackImpl extends VkDebugReportCallbackEXT
	{
		@Override
		public int invoke(int flags,
						  int objectType,
						  long object,
						  long location,
						  int messageCode,
						  long pLayerPrefix,
						  long pMessage,
						  long pUserData)
		{
			final String message = VkDebugReportCallbackEXT.getString(pMessage);
			System.err.println("ERROR OCCURED: " + message);
			return 0;
		}
	}
}
