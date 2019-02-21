package org.sheepy.lily.vulkan.process.compute.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.IStatefullAdapter;
import org.sheepy.lily.core.api.adapter.impl.AbstractSingletonAdapter;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.process.pipeline.IPipelineUnitAdapter;
import org.sheepy.lily.vulkan.process.pipeline.IProcessUnitAdapter;

public class ComputerAdapter extends AbstractSingletonAdapter
		implements IProcessUnitAdapter<ComputeCommandBuffer>, IStatefullAdapter,
		IPipelineUnitAdapter<ComputeCommandBuffer>
{
	private Computer computer = null;
	private int index;

	@Override
	public void setTarget(Notifier target)
	{
		computer = (Computer) target;
	}

	@Override
	public void record(ComputeCommandBuffer commandBuffer, int bindPoint)
	{
		var computePipeline = (ComputePipeline) computer.eContainer();
		var pipelineAdapter = ComputePipelineAdapter.adapt(computePipeline);

		var groupCountX = pipelineAdapter.getGroupCountX();
		var groupCountY = pipelineAdapter.getGroupCountY();
		var groupCountZ = pipelineAdapter.getGroupCountZ();

		var id = pipelineAdapter.getPipelineId(index);

		vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), bindPoint, id);

		vkCmdDispatch(commandBuffer.getVkCommandBuffer(), groupCountX, groupCountY, groupCountZ);
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	@Override
	public boolean isRecordNeeded()
	{
		return false;
	}

	@Override
	public void setRecordNeeded(boolean value)
	{}

	public static ComputerAdapter adapt(Computer object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, ComputerAdapter.class);
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ComputePackage.Literals.COMPUTER == eClass;
	}
}