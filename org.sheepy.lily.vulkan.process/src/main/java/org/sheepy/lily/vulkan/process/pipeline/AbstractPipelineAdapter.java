package org.sheepy.lily.vulkan.process.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

@Statefull
public abstract class AbstractPipelineAdapter<T extends AbstractCommandBuffer>
		implements IAllocableAdapter, IPipelineAdapter<T>, IAllocationDescriptorAdapter
{
	protected final IPipeline pipeline;
	private final List<Object> allocationList;

	protected long pipelineLayout = -1;
	protected boolean recordNeeded = false;

	protected List<IAllocable> allocationDependencies = new ArrayList<>();
	private List<IVkDescriptorSet> descriptorSets;

	public AbstractPipelineAdapter(IPipeline pipeline)
	{
		this.pipeline = pipeline;

		if (pipeline instanceof AbstractPipeline)
		{
			allocationList = List.copyOf(((AbstractPipeline) pipeline).getUnits());
		}
		else
		{
			allocationList = Collections.emptyList();
		}
	}

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == ProcessPackage.Literals.IPIPELINE__ENABLED
				&& notification.getOldBooleanValue() != notification.getNewBooleanValue())
		{
			recordNeeded = true;
		}
	}

	@Override
	public void setRecordNeeded(boolean value)
	{
		recordNeeded = value;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var vkDevice = ((ProcessContext) context).getVkDevice();
		pipelineLayout = allocatePipelineLayout(stack, vkDevice);
	}

	@Override
	public void free(IAllocationContext context)
	{
		var vkDevice = ((ProcessContext) context).getVkDevice();
		vkDestroyPipelineLayout(vkDevice, pipelineLayout, null);

		allocationDependencies.clear();
		pipelineLayout = -1;
		descriptorSets = null;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		boolean res = false;

		for (IAllocable dependency : allocationDependencies)
		{
			if (dependency.isAllocationDirty(context))
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
		boolean res = recordNeeded;

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

	protected long allocatePipelineLayout(MemoryStack stack, VkDevice vkDevice)
	{
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

		preparePushConstant(stack, info);

		Logger.check("Failed to create compute pipeline layout",
				() -> vkCreatePipelineLayout(vkDevice, info, null, aLayout));
		return aLayout[0];
	}

	private void preparePushConstant(MemoryStack stack, VkPipelineLayoutCreateInfo info)
	{
		var constants = getConstants();
		if (constants != null)
		{
			final var adapter = AbstractConstantsAdapter.adapt(constants);
			info.pPushConstantRanges(adapter.allocRange(stack, constants));
		}
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

	@Override
	public List<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}

	/**
	 * @return IAllocable or EObject
	 */
	@SuppressWarnings("static-method")
	public List<? extends Object> getResources()
	{
		return List.of();
	}

	public abstract AbstractConstants getConstants();

	public abstract List<IVkDescriptorSet> getDescriptorSets();

	@SuppressWarnings("unchecked")
	public static <T extends AbstractCommandBuffer> AbstractPipelineAdapter<T> adapt(IPipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, AbstractPipelineAdapter.class);
	}
}
