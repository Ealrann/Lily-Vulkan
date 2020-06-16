package org.sheepy.lily.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAllocation;

import java.util.List;

@ModelExtender(scope = GraphicProcess.class)
@Allocation(context = IVulkanContext.class)
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION)
@AllocationChild(features = {GraphicPackage.GRAPHIC_PROCESS__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {GraphicPackage.GRAPHIC_PROCESS__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__DESCRIPTOR_POOL)
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__SUBPASSES)
@AllocationChild(features = GraphicPackage.GRAPHIC_PROCESS__EXECUTION_RECORDER)
public final class GraphicProcessAllocation extends AbstractProcessAllocation
{
	private static final List<EReference> DERSCRIPTOR_POOL_FEATURES = List.of(ProcessPackage.Literals.ABSTRACT_PROCESS__DESCRIPTOR_POOL);
	private static final List<EReference> PIPELINE_DERSCRIPTOR_POOL_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																					   GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																					   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																					   ProcessPackage.Literals.VK_PIPELINE__DESCRIPTOR_POOL);
	private static final List<EReference> COMPOSITE_PIPELINE_DERSCRIPTOR_POOL_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																								 GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																								 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																								 ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES,
																								 ProcessPackage.Literals.VK_PIPELINE__DESCRIPTOR_POOL);

	public final SubpassManager subpassManager;

	public GraphicProcessAllocation(GraphicProcess process, IVulkanContext vulkanContext)
	{
		super(process, vulkanContext);
		subpassManager = new SubpassManager(process);

		if (process.getResourcePkg() == null)
		{
			process.setResourcePkg(ResourceFactory.eINSTANCE.createResourcePkg());
		}
		if (process.getDescriptorPkg() == null)
		{
			process.setDescriptorPkg(VulkanFactory.eINSTANCE.createDescriptorPkg());
		}
		subpassManager.start(vulkanContext);
	}

	@Free
	private void free()
	{
		subpassManager.stop(vulkanContext);
	}

	@Override
	protected List<List<EReference>> getDescriptorPoolFeatureLists()
	{
		return List.of(DERSCRIPTOR_POOL_FEATURES,
					   PIPELINE_DERSCRIPTOR_POOL_FEATURES,
					   COMPOSITE_PIPELINE_DERSCRIPTOR_POOL_FEATURES);
	}

	@Override
	protected GraphicExecutionRecorder getProcessExecutionRecorder()
	{
		return ((GraphicProcess) process).getExecutionRecorder();
	}
}
