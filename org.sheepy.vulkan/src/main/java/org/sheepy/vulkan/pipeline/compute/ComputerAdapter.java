package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.IStatefullAdapter;
import org.sheepy.common.api.adapter.impl.AbstractServiceAdapter;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.execution.compute.ComputeCommandBuffer;
import org.sheepy.vulkan.model.process.ComputePipeline;
import org.sheepy.vulkan.model.process.Computer;
import org.sheepy.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.pipeline.IProcessUnitAdapter;

public class ComputerAdapter extends AbstractServiceAdapter
		implements IProcessUnitAdapter<ComputeCommandBuffer>, IStatefullAdapter
{
	private Computer computer = null;

	@Override
	public void setTarget(Notifier target)
	{
		computer = (Computer) target;
	}
	
	@Override
	public void record(ComputeCommandBuffer commandBuffer, int bindPoint)
	{
		var computePipeline = (ComputePipeline) computer.eContainer();
		var index = computePipeline.getComputers().indexOf(computer);
		var pipelineAdapter = ComputePipelineAdapter.adapt(computePipeline);

		var groupCountX = pipelineAdapter.getGroupCountX();
		var groupCountY = pipelineAdapter.getGroupCountY();
		var groupCountZ = pipelineAdapter.getGroupCountZ();

		var id = pipelineAdapter.getPipelineId(index);

		vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), bindPoint, id);

		vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCountX, groupCountY, groupCountZ);
	}

	public static ComputerAdapter adapt(Computer object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, ComputerAdapter.class);
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ProcessPackage.Literals.COMPUTER == eClass;
	}
}
