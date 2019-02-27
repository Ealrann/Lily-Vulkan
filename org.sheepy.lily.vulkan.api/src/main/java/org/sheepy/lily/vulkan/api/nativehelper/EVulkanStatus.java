package org.sheepy.lily.vulkan.api.nativehelper;

import static org.lwjgl.vulkan.EXTDebugReport.VK_ERROR_VALIDATION_FAILED_EXT;
import static org.lwjgl.vulkan.KHRDisplaySwapchain.VK_ERROR_INCOMPATIBLE_DISPLAY_KHR;
import static org.lwjgl.vulkan.KHRSurface.*;
import static org.lwjgl.vulkan.KHRSwapchain.*;
import static org.lwjgl.vulkan.VK10.*;

public enum EVulkanStatus
{
	// Success codes
	SUCCESS(VK_SUCCESS, false, "Command successfully completed."),
	NOT_READY(VK_NOT_READY, false, "A fence or query has not yet completed."),
	TIMEOUT(VK_TIMEOUT, false, "A wait operation has not completed in the specified time."),
	EVENT_SET(VK_EVENT_SET, false, "An event is signaled."),
	EVENT_RESET(VK_EVENT_RESET, false, "An event is unsignaled."),
	INCOMPLETE(VK_INCOMPLETE, false, "A return array was too small for the result."),
	
	SUBOPTIMAL_KHR(
			VK_SUBOPTIMAL_KHR,
			false, "A swapchain no longer matches the surface properties exactly, "
					+ "but can still be used to present to the surface successfully."),

	// Error codes
	ERROR_OUT_OF_HOST_MEMORY(VK_ERROR_OUT_OF_HOST_MEMORY, true, "A host memory allocation has failed."),
	ERROR_OUT_OF_DEVICE_MEMORY(VK_ERROR_OUT_OF_DEVICE_MEMORY, true, "A device memory allocation has failed."),
	ERROR_INITIALIZATION_FAILED(VK_ERROR_INITIALIZATION_FAILED, true, "Initialization of an object could not be completed for implementation-specific reasons."),
	ERROR_DEVICE_LOST(VK_ERROR_DEVICE_LOST, true, "The logical or physical device has been lost."),
	ERROR_MEMORY_MAP_FAILED(VK_ERROR_MEMORY_MAP_FAILED, true, "Mapping of a memory object has failed."),
	ERROR_LAYER_NOT_PRESENT(VK_ERROR_LAYER_NOT_PRESENT, true, "A requested layer is not present or could not be loaded."),
	ERROR_EXTENSION_NOT_PRESENT(VK_ERROR_EXTENSION_NOT_PRESENT, true, "A requested extension is not supported."),
	ERROR_FEATURE_NOT_PRESENT(VK_ERROR_FEATURE_NOT_PRESENT, true, "A requested feature is not supported."),
	ERROR_INCOMPATIBLE_DRIVER(VK_ERROR_INCOMPATIBLE_DRIVER, true, "The requested version of Vulkan is not supported by the driver or is otherwise incompatible for implementation-specific reasons."),
	ERROR_TOO_MANY_OBJECTS(VK_ERROR_TOO_MANY_OBJECTS, true, "Too many objects of the type have already been created."),
	ERROR_FORMAT_NOT_SUPPORTED(VK_ERROR_FORMAT_NOT_SUPPORTED, true, "A requested format is not supported on this device."),
	ERROR_FRAGMENTED_POOL(VK_ERROR_FRAGMENTED_POOL, true, "A pool allocation has failed due to fragmentation of the pool’s memory."),
	
	ERROR_SURFACE_LOST_KHR(VK_ERROR_SURFACE_LOST_KHR, true, "A surface is no longer available."),
	ERROR_NATIVE_WINDOW_IN_USE_KHR(VK_ERROR_NATIVE_WINDOW_IN_USE_KHR, true, "The requested window is already connected to a VkSurfaceKHR, or to some other non-Vulkan API."),
	ERROR_OUT_OF_DATE_KHR(VK_ERROR_OUT_OF_DATE_KHR, true, "A surface has changed in such a way that it is no longer compatible with the swapchain, and further presentation requests using the "
			+ "swapchain will fail. Applications must query the new surface properties and recreate their swapchain if they wish to continue"
			+ "presenting to the surface."),
	ERROR_INCOMPATIBLE_DISPLAY_KHR(VK_ERROR_INCOMPATIBLE_DISPLAY_KHR, true, "The display used by a swapchain does not use the same presentable image layout, or is incompatible in a way that prevents sharing an"
			+ " image."),
	ERROR_VALIDATION_FAILED_EXT(VK_ERROR_VALIDATION_FAILED_EXT, true, "A validation layer found an error.")
	;

	public final int code;
	public final boolean isError;
	public final String message;

	private EVulkanStatus(int code, boolean isError, String message)
	{
		this.code = code;
		this.isError = isError;
		this.message = message;
	}

	public static final EVulkanStatus resolveFromCode(int errorCode)
	{
		EVulkanStatus[] values = EVulkanStatus.values();
		for (int i = 0; i < values.length; i++)
		{
			EVulkanStatus eVulkanError = values[i];
			if (eVulkanError.code == errorCode)
			{
				return eVulkanError;
			}
		}
		return null;
	}
}
