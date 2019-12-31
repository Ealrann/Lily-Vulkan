package org.sheepy.lily.vulkan.process.compute.process;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.util.ModelExplorer;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.api.process.IComputeContext;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.queue.EQueueType;

@Statefull
@Adapter(scope = ComputeProcess.class)
public class ComputeProcessAdapter extends AbstractProcessAdapter<IComputeContext>
{
	private static final List<EStructuralFeature> PIPELINE__FEATURES = List.of(	ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																				ProcessPackage.Literals.PIPELINE_PKG__PIPELINES);
	private static final List<EStructuralFeature> RESOURCE_FEATURES = List.of(	VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																				ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EStructuralFeature> PIPELINE_RESOURCE_FEATURES = List.of(	ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																						ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																						VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																						ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EStructuralFeature> DESCRIPTOR_FEATURES = List.of(VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																				VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);
	private static final List<EStructuralFeature> PIPELINE_DESCRIPTOR_FEATURES = List.of(	ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																							ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																							VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																							VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);

	private final ModelExplorer PARTS_EXPLORER = new ModelExplorer(List.of(	ComputePackage.Literals.COMPUTE_PROCESS__PIPELINE_PKG,
																			ProcessPackage.Literals.PIPELINE_PKG__PIPELINES));

	private static final List<ECommandStage> stages = List.of(	ECommandStage.TRANSFER,
																ECommandStage.COMPUTE);

	public ComputeProcessAdapter(ComputeProcess process)
	{
		super(process);
	}

	@Override
	protected IComputeContext createContext()
	{
		return new ComputeContext(	getExecutionQueueType(),
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
	protected List<List<EStructuralFeature>> getPipelineFeatureLists()
	{
		return List.of(PIPELINE__FEATURES);
	}

	@Override
	protected List<List<EStructuralFeature>> getResourceFeatureLists()
	{
		return List.of(	RESOURCE_FEATURES,
						PIPELINE_RESOURCE_FEATURES,
						DESCRIPTOR_FEATURES,
						PIPELINE_DESCRIPTOR_FEATURES);
	}

	@Override
	protected ModelExplorer getPipelineExplorer()
	{
		return PARTS_EXPLORER;
	}
}
