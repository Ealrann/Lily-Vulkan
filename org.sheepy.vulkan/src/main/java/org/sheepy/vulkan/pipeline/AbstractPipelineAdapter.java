package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.allocation.adapter.impl.AbstractDeepAllocableAdapter;
import org.sheepy.vulkan.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.AbstractPipeline;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.PushConstant;
import org.sheepy.vulkan.resource.buffer.PushConstantAdapter;
import org.sheepy.vulkan.resource.descriptor.DescriptorSetAdapter;
import org.sheepy.vulkan.resource.descriptor.IDescriptorSetAdapter;

public abstract class AbstractPipelineAdapter<T extends AbstractCommandBuffer>
		extends AbstractDeepAllocableAdapter implements IProcessUnitAdapter<T>
{
	protected long pipelineLayout = -1;

	private AbstractPipeline pipeline = null;

	@Override
	public void setTarget(Notifier target)
	{
		pipeline = (AbstractPipeline) target;
		super.setTarget(target);
	}

	@Override
	public void record(T commandBuffer, int bindPoint)
	{
		final DescriptorSet descriptorSet = pipeline.getDescriptorSet();
		if (descriptorSet != null)
		{
			final var adapter = IDescriptorSetAdapter.adapt(descriptorSet);
			adapter.bindDescriptorSet(commandBuffer, bindPoint, pipelineLayout);
		}

		final var pushConstant = pipeline.getPushConstant();
		if (pushConstant != null)
		{
			final var pushConstantAdapter = PushConstantAdapter.adapt(pushConstant);
			final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
			pushConstantAdapter.pushConstants(vkCommandBuffer, pipelineLayout);
		}
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		pipelineLayout = allocatePipelineLayout(stack);
	}

	protected long allocatePipelineLayout(MemoryStack stack)
	{
		final var vkDevice = ILogicalDeviceAdapter.adapt(pipeline).getVkDevice(pipeline);
		final DescriptorSet descriptorSet = pipeline.getDescriptorSet();

		LongBuffer bDescriptorSet = null;
		if (descriptorSet != null && descriptorSet.getDescriptors().isEmpty() == false)
		{
			final var descriptorSetAdapter = DescriptorSetAdapter.adapt(descriptorSet);

			// Create Pipeline Layout
			// -----------------------
			bDescriptorSet = stack.mallocLong(1);
			bDescriptorSet.put(descriptorSetAdapter.getLayoutId());
			bDescriptorSet.flip();
		}

		// Create compute pipeline
		final long[] aLayout = new long[1];
		final VkPipelineLayoutCreateInfo info = VkPipelineLayoutCreateInfo.callocStack(stack);
		info.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		info.pSetLayouts(bDescriptorSet);

		allocPushConstant(stack, info);

		if (vkCreatePipelineLayout(vkDevice, info, null, aLayout) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline layout!");
		}
		return aLayout[0];
	}

	private void allocPushConstant(MemoryStack stack, VkPipelineLayoutCreateInfo info)
	{
		final PushConstant pushConstant = pipeline.getPushConstant();
		if (pushConstant != null)
		{
			final var adapter = PushConstantAdapter.adapt(pushConstant);
			info.pPushConstantRanges(adapter.allocRange(stack));
		}
	}

	@Override
	public void free()
	{
		final var vkDevice = ILogicalDeviceAdapter.adapt(pipeline).getVkDevice(pipeline);
		vkDestroyPipelineLayout(vkDevice, pipelineLayout, null);

		pipelineLayout = -1;
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractPipelineAdapter<T> adapt(AbstractPipeline object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, AbstractPipelineAdapter.class);
	}

	public long getLayoutId()
	{
		return pipelineLayout;
	}
}
