package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.resource.PushConstant;

public class PushConstantAdapter extends AbstractFlatAllocableAdapter
{
	public ByteBuffer buffer;

	private PushConstant pushConstant;

	@Override
	protected void load()
	{
		pushConstant = (PushConstant) target;
	}

	@Override
	protected void unload()
	{
		pushConstant = null;
	}

	public VkPushConstantRange.Buffer allocRange(MemoryStack stack)
	{
		final int size = pushConstant.getSize();
		final EPipelineStage stage = pushConstant.getStage();

		final VkPushConstantRange.Buffer pushConstantRange = VkPushConstantRange.callocStack(1, stack);
		pushConstantRange.get(0).set(stage.getValue(), 0, size);

		return pushConstantRange;
	}

	public void pushConstants(VkCommandBuffer commandBuffer, long pipelineLayout)
	{
		updateBuffer();
		final EPipelineStage stage = pushConstant.getStage();
		vkCmdPushConstants(commandBuffer, pipelineLayout, stage.getValue(), 0, buffer);
	}

	protected void updateBuffer()
	{}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final int size = pushConstant.getSize();
		buffer = MemoryUtil.memAlloc(size);
	}

	@Override
	public void free()
	{
		MemoryUtil.memFree(buffer);
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}
	
	public static PushConstantAdapter adapt(PushConstant object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, PushConstantAdapter.class);
	}
}
