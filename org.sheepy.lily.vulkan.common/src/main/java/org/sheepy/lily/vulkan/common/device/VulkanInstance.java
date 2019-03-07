package org.sheepy.lily.vulkan.common.device;

import static org.lwjgl.vulkan.EXTDebugReport.vkDestroyDebugReportCallbackEXT;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.engine.EngineExtensionRequirement;
import org.sheepy.lily.vulkan.common.util.LayerFinder;
import org.sheepy.lily.vulkan.common.util.VulkanUtils;

public class VulkanInstance
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

	private final EngineExtensionRequirement requirements;
	private final Application application;
	private final boolean debug;

	private VkInstance vkInstance;

	private VkDebugReportCallbackEXT vkDebugReportCallback;
	private long debugCallbackHandle = -1;
	private PointerBuffer ppEnabledLayerNames = null;

	public VulkanInstance(	Application application,
							EngineExtensionRequirement requirements,
							boolean debug)
	{
		this.requirements = requirements;
		this.application = application;
		this.debug = debug;
	}

	public void allocate(MemoryStack stack)
	{
		if (debug)
		{
			ppEnabledLayerNames = LayerFinder.convertToPointerBuffer(stack, LAYERS_TO_ENABLE);
		}

		final VkApplicationInfo appInfo = VkApplicationInfo.callocStack(stack);
		appInfo.sType(VK_STRUCTURE_TYPE_APPLICATION_INFO);
		appInfo.pApplicationName(stack.UTF8(application.getTitle()));
		appInfo.applicationVersion(VK_MAKE_VERSION(1, 0, 0));
		appInfo.pEngineName(stack.UTF8("Lily"));
		appInfo.engineVersion(VK_MAKE_VERSION(1, 0, 0));
		appInfo.apiVersion(VK_MAKE_VERSION(1, 0, 0));

		final var requiredExtensions = requirements.getRequiredInstanceExtensions(stack);
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
		if (debug
				&& requirements.getRequiredInstanceExtensions()
						.contains(EInstanceExtension.VK_EXT_debug_report))
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
}
