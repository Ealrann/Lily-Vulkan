package org.sheepy.lily.vulkan.process.pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.allocation.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.allocation.adapter.IAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.api.nativehelper.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.api.resource.IConstantsAdapter;
import org.sheepy.lily.vulkan.api.resource.IVkDescriptorSet;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;

@Statefull
public abstract class AbstractPipelineAdapter
		implements IAllocableAdapter, IPipelineAdapter, IAllocationDescriptorAdapter
{
	protected final IPipeline pipeline;
	private final List<Object> allocationList;

	protected boolean recordNeeded = false;

	protected List<IAllocable> allocationDependencies = new ArrayList<>();
	private VkPipeline vkPipeline;

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
		vkPipeline = createVkPipeline(context);
		vkPipeline.allocate(stack, context);
	}

	protected VkPipeline createVkPipeline(IAllocationContext context)
	{
		final var constants = getConstants();
		List<IVkDescriptorSet> descriptorSets = new ArrayList<>();
		final List<AbstractConstants> constantsList = constants != null
				? List.of(constants)
				: Collections.emptyList();

		collectDescriptorSets(descriptorSets);

		return new VkPipeline(descriptorSets, constantsList);
	}

	@Override
	public void free(IAllocationContext context)
	{
		vkPipeline.free(context);
		allocationDependencies.clear();
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
				final IConstantsAdapter pushAdapter = AbstractConstantsAdapter.adapt(pushConstant);
				res |= pushAdapter.needRecord();
			}
		}

		return res;
	}

	@Override
	public void collectResources(List<Object> collectIn)
	{
		if (pipeline instanceof AbstractPipeline)
		{
			final var resourcePkg = ((AbstractPipeline) pipeline).getResourcePkg();
			if (resourcePkg != null)
			{
				collectIn.addAll(resourcePkg.getResources());
			}
		}
	}

	@Override
	public void collectDescriptorSets(List<IVkDescriptorSet> collectIn)
	{
		if (pipeline instanceof AbstractPipeline)
		{
			final var abstractPipeline = (AbstractPipeline) pipeline;
			var ds = abstractPipeline.getDescriptorSet();
			if (ds == null)
			{
				ds = abstractPipeline.getDescriptorSetRef();
			}

			if (ds != null)
			{
				final var adapter = IDescriptorSetAdapter.adapt(ds);
				collectIn.add(adapter);
			}
		}
	}

	public long getPipelineLayout()
	{
		return vkPipeline.getPipelineLayout();
	}

	public long getPipelineId()
	{
		return vkPipeline.getPipelineId();
	}

	public void bindDescriptor(	VkCommandBuffer commandBuffer,
								int bindPoint,
								Integer[] descriptorSetIndexes)
	{
		vkPipeline.bindDescriptor(commandBuffer, bindPoint, descriptorSetIndexes);
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
