package org.sheepy.lily.vulkan.process.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.allocation.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.allocation.adapter.IAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;

@Statefull
public abstract class AbstractPipelineAdapter
		implements IAllocableAdapter, IPipelineAdapter, IAllocationDescriptorAdapter
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
		final var vkDevice = ((IExecutionContext) context).getVkDevice();
		pipelineLayout = allocatePipelineLayout(stack, vkDevice);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var vkDevice = ((IExecutionContext) context).getVkDevice();
		vkDestroyPipelineLayout(vkDevice, pipelineLayout, null);

		allocationDependencies.clear();
		pipelineLayout = -1;
		descriptorSets = null;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		boolean res = false;

		for (final IAllocable dependency : allocationDependencies)
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
			final var pushConstant = getConstants();
			if (pushConstant != null)
			{
				final var pushAdapter = AbstractConstantsAdapter.adapt(pushConstant);
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
			for (final IVkDescriptorSet vkDescriptorSet : descriptorSets)
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
		final var constants = getConstants();
		if (constants != null)
		{
			final var adapter = AbstractConstantsAdapter.adapt(constants);
			info.pPushConstantRanges(adapter.allocRange(stack, constants));
		}
	}

	@Override
	public List<? extends Object> getResources()
	{
		final List<Object> resources = new ArrayList<>();

		if (pipeline instanceof AbstractPipeline)
		{
			final var resourcePkg = ((AbstractPipeline) pipeline).getResourcePkg();
			if (resourcePkg != null)
			{
				resources.addAll(resourcePkg.getResources());
			}
		}

		return resources;
	}

	public long getLayoutId()
	{
		return pipelineLayout;
	}

	@Override
	public List<IVkDescriptorSet> getDescriptorSets()
	{
		final List<IVkDescriptorSet> res = new ArrayList<>();

		if (pipeline instanceof AbstractPipeline)
		{
			var abstractPipeline = (AbstractPipeline) pipeline;
			var ds = abstractPipeline.getDescriptorSet();
			if (ds == null)
			{
				ds = abstractPipeline.getDescriptorSetRef();
			}

			if (ds != null)
			{
				final var adapter = IDescriptorSetAdapter.adapt(ds);
				res.add(adapter);
			}
		}

		return res;
	}

	public void bindDescriptor(VkCommandBuffer commandBuffer, int bindPoint, int descriptorSetIndex)
	{
		if (descriptorSetIndex < descriptorSets.size())
		{
			final IVkDescriptorSet descriptorSet = descriptorSets.get(descriptorSetIndex);
			descriptorSet.bindDescriptorSet(commandBuffer, bindPoint, getLayoutId());
		}
	}

	@Override
	public boolean shouldRecord(ECommandStage stage)
	{
		return pipeline.isEnabled() && pipeline.getStage() == stage;
	}

	@Override
	public List<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}

	public abstract AbstractConstants getConstants();

	public static AbstractPipelineAdapter adapt(IPipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, AbstractPipelineAdapter.class);
	}
}
