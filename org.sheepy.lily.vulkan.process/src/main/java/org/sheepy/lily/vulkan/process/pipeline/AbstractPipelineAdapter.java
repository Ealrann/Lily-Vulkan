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
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.api.allocation.IAllocationDescriptorAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.resource.IConstantsAdapter;
import org.sheepy.lily.vulkan.api.resource.IPushBufferAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.pipeline.VkPipeline;

@Statefull
public abstract class AbstractPipelineAdapter
		implements IAllocableAdapter, IPipelineAdapter, IAllocationDescriptorAdapter
{
	private final List<Object> allocationList;
	private final boolean[] stagingFlushHistory;
	protected final IPushBufferAdapter pushBufferAdapter;
	protected final IPipeline pipeline;

	protected boolean recordNeeded = false;
	protected List<IAllocable> allocationDependencies = new ArrayList<>();

	private VkPipeline vkPipeline;

	public AbstractPipelineAdapter(IPipeline pipeline)
	{
		this.pipeline = pipeline;

		if (pipeline instanceof AbstractPipeline)
		{
			final AbstractPipeline abstractPipeline = (AbstractPipeline) pipeline;
			allocationList = List.copyOf(abstractPipeline.getUnits());
			final PushBuffer pushBuffer = abstractPipeline.getPushBuffer();

			if (pushBuffer != null)
			{
				pushBufferAdapter = IPushBufferAdapter.adapt(pushBuffer);
				stagingFlushHistory = new boolean[pushBuffer.getInstanceCount()];
			}
			else
			{
				pushBufferAdapter = null;
				stagingFlushHistory = null;
			}
		}
		else
		{
			allocationList = Collections.emptyList();
			stagingFlushHistory = null;
			pushBufferAdapter = null;
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
		vkPipeline = createVkPipeline();
		vkPipeline.allocate(stack, context);
	}

	protected VkPipeline createVkPipeline()
	{
		final var constants = getConstants();
		final List<IVkDescriptorSet> descriptorSets = new ArrayList<>();
		final List<AbstractConstants> constantsList = constants != null
				? List.of(constants)
				: Collections.emptyList();

		collectDescriptorSets(descriptorSets);

		final List<IConstantsAdapter> adapters = new ArrayList<>();
		for (final AbstractConstants constant : constantsList)
		{
			adapters.add(IConstantsAdapter.adapt(constant));
		}

		return new VkPipeline(descriptorSets, adapters);
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
	public boolean isRecordNeeded(int index)
	{
		boolean res = recordNeeded;

		if (pushBufferAdapter != null)
		{
			final var stagingBuffer = pushBufferAdapter.getStagingBuffer();
			final boolean previousRecordMadeFlush = stagingFlushHistory[index];
			if (previousRecordMadeFlush)
			{
				stagingFlushHistory[index] = false;
			}

			res |= !stagingBuffer.isEmpty();
			res |= previousRecordMadeFlush;
		}

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
	public final void record(	ECommandStage stage,
								VkCommandBuffer vkCommandBuffer,
								int bindPoint,
								int index)
	{
		final var pipelineStage = pipeline.getStage();

		if (stage == ECommandStage.TRANSFER)
		{
			final var stagingBuffer = pushBufferAdapter.getStagingBuffer();

			stagingFlushHistory[index] = true;
			stagingBuffer.flush(vkCommandBuffer);
			System.out.println("flush" + index);
		}
		if (stage == pipelineStage)
		{
			record(vkCommandBuffer, bindPoint, index);
		}
	}

	@Override
	public void collectResources(List<Object> collectIn)
	{
		if (pipeline instanceof AbstractPipeline)
		{
			final var abstractPipeline = (AbstractPipeline) pipeline;
			final var resourcePkg = abstractPipeline.getResourcePkg();

			if (resourcePkg != null)
			{
				collectIn.addAll(resourcePkg.getResources());
			}
			if (pushBufferAdapter != null)
			{
				collectIn.add(pushBufferAdapter.getStagingBuffer());
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

		final boolean enabled = pipeline.isEnabled();
		final boolean requiredStage = pipeline.getStage() == stage;
		boolean needTransfer = false;

		if (pushBufferAdapter != null)
		{
			final var stagingBuffer = pushBufferAdapter.getStagingBuffer();
			needTransfer = (stage == ECommandStage.TRANSFER && !stagingBuffer.isEmpty());
		}

		return enabled && (requiredStage || needTransfer);
	}

	@Override
	public List<? extends Object> getAllocationChildren()
	{
		return allocationList;
	}

	public abstract AbstractConstants getConstants();
	protected abstract void record(VkCommandBuffer vkCommandBuffer, int bindPoint, int index);

	public static AbstractPipelineAdapter adapt(IPipeline object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, AbstractPipelineAdapter.class);
	}
}
