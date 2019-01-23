package org.sheepy.lily.vulkan.process.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.common.execution.IResourceAllocable;
import org.sheepy.lily.vulkan.common.util.Logger;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

public abstract class IPipelineAdapter<T extends AbstractCommandBuffer>
		extends AbstractProcessUnitAdapter<T>
{
	protected long pipelineLayout = -1;

	protected IPipeline pipeline = null;

	protected List<IAllocable> allocationDependencies = new ArrayList<>();

	private List<IVkDescriptorSet> descriptorSets;

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
			var pushConstant = getConstants();
			if (pushConstant != null)
			{
				var pushAdapter = AbstractConstantsAdapter.adapt(pushConstant);
				res |= pushAdapter.needRecord();
			}
		}

		return res;
	}

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		pipelineLayout = allocatePipelineLayout(stack);
	}

	protected long allocatePipelineLayout(MemoryStack stack)
	{
		final var vkDevice = ILogicalDeviceAdapter.adapt(pipeline).getVkDevice(pipeline);
		descriptorSets = List.copyOf(getDescriptorSets());

		LongBuffer bDescriptorSet = null;
		if (descriptorSets.isEmpty() == false)
		{
			bDescriptorSet = stack.mallocLong(descriptorSets.size());
			for (IVkDescriptorSet vkDescriptorSet : descriptorSets)
			{
				if (vkDescriptorSet.getDescriptors().isEmpty() == false)
				{
					// Create Pipeline Layout
					// -----------------------
					bDescriptorSet.put(vkDescriptorSet.getLayoutId());
				}
			}
			bDescriptorSet.flip();
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
		var constants = getConstants();
		if (constants != null)
		{
			final var adapter = AbstractConstantsAdapter.adapt(constants);
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
		descriptorSets = null;
	}

	public long getLayoutId()
	{
		return pipelineLayout;
	}

	public void bindDescriptor(T commandBuffer, int bindPoint, int descriptorSetIndex)
	{
		IVkDescriptorSet descriptorSet = descriptorSets.get(descriptorSetIndex);
		descriptorSet.bindDescriptorSet(commandBuffer, bindPoint, getLayoutId());
	}

	@SuppressWarnings("static-method")
	public List<IResourceAllocable> getResources()
	{
		return List.of();
	}

	protected abstract AbstractConstants getConstants();

	public abstract List<IVkDescriptorSet> getDescriptorSets();

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> IPipelineAdapter<T> adapt(IPipeline object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IPipelineAdapter.class);
	}
}
