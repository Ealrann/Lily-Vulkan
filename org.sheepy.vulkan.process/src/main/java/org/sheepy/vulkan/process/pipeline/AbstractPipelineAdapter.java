package org.sheepy.vulkan.process.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.common.allocation.IAllocable;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.process.IPipeline;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.PushConstant;
import org.sheepy.vulkan.resource.buffer.PushConstantAdapter;
import org.sheepy.vulkan.resource.descriptor.IDescriptorSetAdapter;

public abstract class AbstractPipelineAdapter<T extends AbstractCommandBuffer>
		extends AbstractProcessUnitAdapter<T>
{
	protected long pipelineLayout = -1;

	protected IPipeline pipeline = null;

	protected List<IAllocable> allocationDependencies = new ArrayList<>();

	@Override
	public void setTarget(Notifier target)
	{
		pipeline = (IPipeline) target;
		super.setTarget(target);
	}

	@Override
	public final boolean isAllocationDirty()
	{
		boolean res = false;

		for (IAllocable dependency : allocationDependencies)
		{
			if (dependency.isAllocationDirty())
			{
				res = true;
				break;
			}
		}

		return res;
	}

	@Override
	public boolean isRecordNeeded()
	{
		boolean res = super.isRecordNeeded();

		if (res == false)
		{
			PushConstant pushConstant = getPushConstant();
			if (pushConstant != null)
			{
				var pushAdapter = PushConstantAdapter.adapt(pushConstant);
				res |= pushAdapter.needRecord();
			}
		}

		return res;
	}

	@Override
	public void record(T commandBuffer, int bindPoint)
	{
		recordDescriptors(commandBuffer, bindPoint);
	}

	protected void recordDescriptors(T commandBuffer, int bindPoint)
	{
		final DescriptorSet descriptorSet = getDescriptorSet();
		if (descriptorSet != null)
		{
			final var adapter = IDescriptorSetAdapter.adapt(descriptorSet);
			adapter.bindDescriptorSet(commandBuffer, bindPoint, pipelineLayout);
		}

		final var pushConstant = getPushConstant();
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
		final DescriptorSet descriptorSet = getDescriptorSet();

		LongBuffer bDescriptorSet = null;
		if (descriptorSet != null)
		{
			final var descriptorSetAdapter = IDescriptorSetAdapter.adapt(descriptorSet);
			if (descriptorSetAdapter.getDescriptors().isEmpty() == false)
			{
				// Create Pipeline Layout
				// -----------------------
				bDescriptorSet = stack.mallocLong(1);
				bDescriptorSet.put(descriptorSetAdapter.getLayoutId());
				bDescriptorSet.flip();
			}
		}

		// Create compute pipeline
		final long[] aLayout = new long[1];
		final VkPipelineLayoutCreateInfo info = VkPipelineLayoutCreateInfo.callocStack(stack);
		info.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		info.pSetLayouts(bDescriptorSet);

		allocPushConstant(stack, info);

		Logger.check("Failed to create compute pipeline layout",
				() -> vkCreatePipelineLayout(vkDevice, info, null, aLayout));
		return aLayout[0];
	}

	private void allocPushConstant(MemoryStack stack, VkPipelineLayoutCreateInfo info)
	{
		var pushConstant = getPushConstant();
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

		allocationDependencies.clear();
		pipelineLayout = -1;
	}

	public long getLayoutId()
	{
		return pipelineLayout;
	}

	protected abstract PushConstant getPushConstant();

	protected abstract DescriptorSet getDescriptorSet();

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractPipelineAdapter<T> adapt(IPipeline object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, AbstractPipelineAdapter.class);
	}
}
