package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_COMPUTE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.vulkan.command.ECommandStage;
import org.sheepy.vulkan.command.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.AbstractProcess;
import org.sheepy.vulkan.pipeline.ICompositeProcessUnit;
import org.sheepy.vulkan.pipeline.IProcessUnit;

/**
 * A set of ComputePipelines.
 * 
 * @author ealrann
 *
 */
public class ComputeProcess extends AbstractProcess<ComputeCommandBuffer>
{
	protected final List<IProcessUnit> units = new ArrayList<>();

	public ComputeProcess(LogicalDevice logicalDevice)
	{
		this(logicalDevice, Collections.emptyList());
	}

	public ComputeProcess(LogicalDevice logicalDevice, List<ICompositeProcessUnit> units)
	{
		super(logicalDevice, VK_PIPELINE_BIND_POINT_COMPUTE, ECommandStage.Compute);

		for (ICompositeProcessUnit unit : units)
		{
			addProcessUnit(unit);
		}
	}

	@Override
	protected void bindUnit(IProcessUnit unit)
	{
		if (unit instanceof ComputePipeline)
		{
			((ComputePipeline) unit).bindContext(logicalDevice, descriptorPool);
		}
	}

	@Override
	protected List<IProcessUnit> getStageList(ECommandStage stage)
	{
		if (stage == ECommandStage.Compute)
		{
			return units;
		}
		else
		{
			return Collections.emptyList();
		}
	}

	@Override
	protected void doExecuteUnit(ComputeCommandBuffer commandBuffer, IProcessUnit unit)
	{
		if(unit instanceof IComputeExecutable)
		{
			((IComputeExecutable) unit).execute(commandBuffer);
		}
	}

}
