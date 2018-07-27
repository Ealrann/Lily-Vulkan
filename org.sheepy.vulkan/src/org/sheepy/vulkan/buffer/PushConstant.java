package org.sheepy.vulkan.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;

public class PushConstant implements IAllocable
{
	public final int size;
	public final int stage;
	public ByteBuffer buffer;

	/**
	 * @param logicalDevice
	 * @param size
	 *            in bytes
	 */
	public PushConstant(LogicalDevice logicalDevice, int stage, int size)
	{
		this.size = size;
		this.stage = stage;
	}

	public VkPushConstantRange.Buffer alloPushConstantRange(MemoryStack stack)
	{
		VkPushConstantRange.Buffer pushConstantRange = VkPushConstantRange.callocStack(1, stack);
		pushConstantRange.get(0).set(stage, 0, size);

		return pushConstantRange;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		buffer = MemoryUtil.memAlloc(size);
	}

	@Override
	public void free()
	{
		MemoryUtil.memFree(buffer);
	}
}
