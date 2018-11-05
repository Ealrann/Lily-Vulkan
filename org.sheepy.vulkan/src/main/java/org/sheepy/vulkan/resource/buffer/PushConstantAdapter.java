package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkPushConstantRange;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.resource.PushConstant;
import org.sheepy.vulkan.model.resource.ResourcePackage;

public class PushConstantAdapter extends AbstractFlatAllocableAdapter
{
	public ByteBuffer buffer;

	private PushConstant pushConstant;

	@Override
	public void setTarget(Notifier target)
	{
		pushConstant = (PushConstant) target;
	}

	public VkPushConstantRange.Buffer allocRange(MemoryStack stack)
	{
		final int size = pushConstant.getSize();
		final EPipelineStage stage = pushConstant.getStage();

		final VkPushConstantRange.Buffer pushConstantRange = VkPushConstantRange.callocStack(1,
				stack);
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

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.PUSH_CONSTANT == eClass;
	}

	public static PushConstantAdapter adapt(PushConstant object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, PushConstantAdapter.class);
	}
}
