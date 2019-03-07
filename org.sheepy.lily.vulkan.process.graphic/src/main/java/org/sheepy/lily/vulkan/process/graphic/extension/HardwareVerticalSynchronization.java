package org.sheepy.lily.vulkan.process.graphic.extension;

import static org.lwjgl.vulkan.EXTDisplayControl.*;

import java.nio.LongBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDisplayEventInfoEXT;
import org.sheepy.lily.vulkan.common.device.EDeviceExtension;
import org.sheepy.lily.vulkan.common.device.ILogicalDeviceContext;
import org.sheepy.lily.vulkan.common.device.display.DisplayInfo;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

public class HardwareVerticalSynchronization
{
	public HardwareVerticalSynchronization()
	{}

	public boolean isApplicable(GraphicContext context)
	{
		var deviceContext = context;
		var physicalDevice = deviceContext.getPhysicalDevice();
		var displaysInfomations = physicalDevice.getDisplaysInfomations();

		boolean displayControl = physicalDevice.getRetainedExtensions()
				.contains(EDeviceExtension.VK_EXT_display_control);
		boolean hasDisplayInformations = displaysInfomations != null
				&& !displaysInfomations.isEmpty();

		return displayControl && hasDisplayInformations;
	}

	public void apply(MemoryStack stack, GraphicContext context)
	{
		var deviceContext = context;
		var physicalDevice = ((ILogicalDeviceContext) context).getPhysicalDevice();
		var device = deviceContext.getVkDevice();

		context.hardwareVSync = true;

		VkDisplayEventInfoEXT eventInfo = VkDisplayEventInfoEXT.callocStack(stack);
		eventInfo.sType(VK_STRUCTURE_TYPE_DISPLAY_EVENT_INFO_EXT);
		eventInfo.displayEvent(VK_DISPLAY_EVENT_TYPE_FIRST_PIXEL_OUT_EXT);

		DisplayInfo displayInfo = physicalDevice.getDisplaysInfomations().get(0);
		LongBuffer fenceId = stack.callocLong(1).put(context.presentFence.getId()).flip();

		vkRegisterDisplayEventEXT(device, displayInfo.address, eventInfo, null, fenceId);
	}
}
