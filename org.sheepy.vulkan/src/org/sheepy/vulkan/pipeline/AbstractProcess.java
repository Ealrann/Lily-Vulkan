package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdBindDescriptorSets;

import java.nio.LongBuffer;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.vulkan.command.AbstractCommandBuffer;
import org.sheepy.vulkan.command.ECommandStage;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.DescriptorSet;
import org.sheepy.vulkan.descriptor.IDescriptorSetContext;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.compute.ComputePipeline;

public abstract class AbstractProcess<T extends AbstractCommandBuffer> extends AllocationNode
{
	protected final LogicalDevice logicalDevice;
	private int bindPoint;

	private ECommandStage currentStage;
	protected final DescriptorPool descriptorPool;

	public AbstractProcess(LogicalDevice logicalDevice, int bindPoint, ECommandStage stage)
	{
		this.logicalDevice = logicalDevice;
		this.bindPoint = bindPoint;
		this.currentStage = stage;

		descriptorPool = new DescriptorPool(logicalDevice);
		allocationObjects.add(descriptorPool);
	}

	public void addProcessUnit(IProcessUnit unit)
	{
		addProcessUnit(unit, currentStage);
	}
	
	public void addProcessUnit(IProcessUnit unit, ECommandStage stage)
	{
		getStageList(stage).add(unit);

		bindUnit(unit);

		if (unit instanceof IAllocationObject)
		{
			allocationObjects.add((IAllocationObject) unit);
		}
		if (unit instanceof IDescriptorSetContext)
		{
			descriptorPool.addConfiguration((IDescriptorSetContext) unit);
		}
	}

	public void recordCommand(T commandBuffer, ECommandStage stage)
	{
		for (IProcessUnit unit : getStageList(stage))
		{
			if (unit instanceof IDescriptorSetContext)
			{
				IDescriptorSetContext context = (IDescriptorSetContext) unit;
				DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(context);
				if (descriptorSet != null)
				{
					long pipelineLayout = context.getLayoutId();
					LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(1);
					bDescriptorSet.put(descriptorSet.getId());
					bDescriptorSet.flip();
					vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(), bindPoint,
							pipelineLayout, 0, bDescriptorSet, null);
					MemoryUtil.memFree(bDescriptorSet);
				}
			}

			executeUnit(commandBuffer, unit);
		}
	}

	private void executeUnit(T commandBuffer, IProcessUnit unit)
	{
		if (unit instanceof ICompositeProcessUnit)
		{
			ICompositeProcessUnit pipeline = (ICompositeProcessUnit) unit;
			if (pipeline.isEnabled())
			{
				List<IProcessUnit> executables = pipeline.getExecutables();
				for (int i = 0; i < executables.size(); i++)
				{
					executeUnit(commandBuffer, executables.get(i));
				}
			}
			pipeline.setDirty(false);
		}
		else if (unit instanceof IExecutable)
		{
			((IExecutable) unit).execute(commandBuffer.getVkCommandBuffer());
		}
		else 
		{
			doExecuteUnit(commandBuffer, unit);
		}
	}


	public boolean isDirty()
	{
		for (ECommandStage stage : ECommandStage.values())
		{
			for (IProcessUnit unit : getStageList(stage))
			{
				if (unit instanceof ComputePipeline && ((ComputePipeline) unit).isDirty())
				{
					return true;
				}
			}
		}

		return false;
	}

	public void setCommandStage(ECommandStage stage)
	{
		this.currentStage = stage;
	}

	protected abstract List<IProcessUnit> getStageList(ECommandStage stage);
	protected abstract void bindUnit(IProcessUnit unit);
	protected abstract void doExecuteUnit(T commandBuffer, IProcessUnit unit);
}
