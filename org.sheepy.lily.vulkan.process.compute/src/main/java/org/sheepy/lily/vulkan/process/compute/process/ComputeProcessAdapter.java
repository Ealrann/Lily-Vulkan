package org.sheepy.lily.vulkan.process.compute.process;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;

import java.util.List;

@ModelExtender(scope = ComputeProcess.class)
@Adapter
public class ComputeProcessAdapter extends AbstractProcessAdapter
{
	private static final List<EReference> DERSCRIPTOR_POOL_FEATURES = List.of(ProcessPackage.Literals.ABSTRACT_PROCESS__DESCRIPTOR_POOL);
	private static final List<EReference> PIPELINE_DERSCRIPTOR_POOL_FEATURES = List.of(ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																					   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																					   ProcessPackage.Literals.VK_PIPELINE__DESCRIPTOR_POOL);
	private static final List<EReference> COMPOSITE_PIPELINE_DERSCRIPTOR_POOL_FEATURES = List.of(ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																								 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																								 ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES,
																								 ProcessPackage.Literals.VK_PIPELINE__DESCRIPTOR_POOL);

	public ComputeProcessAdapter(ComputeProcess process)
	{
		super(process);
	}

	@Override
	public EQueueType getExecutionQueueType()
	{
		return EQueueType.Compute;
	}

	@Override
	public boolean needPresentQueue()
	{
		return false;
	}

	@Override
	protected List<List<EReference>> getDescriptorPoolFeatureLists()
	{
		return List.of(DERSCRIPTOR_POOL_FEATURES,
					   PIPELINE_DERSCRIPTOR_POOL_FEATURES,
					   COMPOSITE_PIPELINE_DERSCRIPTOR_POOL_FEATURES);
	}

	@Override
	protected ComputeExecutionRecorder getProcessExecutionRecorder()
	{
		return ((ComputeProcess) process).getExecutionRecorder();
	}
}
