package org.sheepy.lily.vulkan.process.compute.process;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.common.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.common.process.IComputeContext;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@Statefull
@Adapter(scope = ComputeProcess.class)
public class ComputeProcessAdapter extends AbstractProcessAdapter<IComputeContext>
{
	private static final List<EReference> PIPELINE__FEATURES = List.of(ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																	   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES);
	private static final List<EReference> COMPOSITE_PIPELINE__FEATURES = List.of(ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																				 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																				 ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES);

	private static final List<EReference> RESOURCE_FEATURES = List.of(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																	  ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> PIPELINE_RESOURCE_FEATURES = List.of(ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																			   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																			   VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																			   ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> COMPOSITE_PIPELINE_RESOURCE_FEATURES = List.of(ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																						 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																						 ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES,
																						 VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																						 ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> DESCRIPTOR_FEATURES = List.of(VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																		VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);
	private static final List<EReference> PIPELINE_DESCRIPTOR_FEATURES = List.of(ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																				 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																				 VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																				 VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);
	private static final List<EReference> COMPOSITE_PIPELINE_DESCRIPTOR_FEATURES = List.of(ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																						   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																						   ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES,
																						   VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																						   VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);

	private static final List<ECommandStage> stages = List.of(ECommandStage.TRANSFER,
															  ECommandStage.COMPUTE);

	public ComputeProcessAdapter(ComputeProcess process)
	{
		super(process);
	}

	@Override
	protected ComputeContext createContext()
	{
		return new ComputeContext(getExecutionQueueType(),
								  isResetAllowed(),
								  descriptorPool,
								  process);
	}

	@Override
	protected Integer prepareNextExecution()
	{
		return 0;
	}

	@Override
	protected List<IAllocable<? super IComputeContext>> getExtraAllocables()
	{
		return List.of();
	}

	@Override
	protected List<ECommandStage> getStages()
	{
		return stages;
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
	protected List<List<EReference>> getPipelineFeatureLists()
	{
		return List.of(PIPELINE__FEATURES, COMPOSITE_PIPELINE__FEATURES);
	}

	@Override
	protected List<List<EReference>> getResourceFeatureLists()
	{
		return List.of(RESOURCE_FEATURES,
					   PIPELINE_RESOURCE_FEATURES,
					   COMPOSITE_PIPELINE_RESOURCE_FEATURES,
					   DESCRIPTOR_FEATURES,
					   PIPELINE_DESCRIPTOR_FEATURES,
					   COMPOSITE_PIPELINE_DESCRIPTOR_FEATURES);
	}
}
