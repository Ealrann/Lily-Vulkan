package org.sheepy.lily.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.allocation.IRootAllocator;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;

import java.util.List;

@ModelExtender(scope = GraphicProcess.class)
@Adapter
public final class GraphicProcessAdapter extends AbstractProcessAdapter
{
	private static final List<EReference> PIPELINE__FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																	   GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																	   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES);
	private static final List<EReference> COMPOSITE_PIPELINE__FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																				 GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																				 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																				 ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES);
	private static final List<EReference> RESOURCE_FEATURES = List.of(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																	  ResourcePackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> SUBPASS_RESOURCE_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																			  VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																			  ResourcePackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> PIPELINE_RESOURCE_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																			   GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																			   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																			   VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																			   ResourcePackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> COMPOSITE_PIPELINE_RESOURCE_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																						 GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																						 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																						 ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES,
																						 VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																						 ResourcePackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> DESCRIPTOR_FEATURES = List.of(VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																		VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);
	private static final List<EReference> SUBPASS_DESCRIPTOR_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																				VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																				VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);
	private static final List<EReference> PIPELINE_DESCRIPTOR_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																				 GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																				 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																				 VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																				 VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);
	private static final List<EReference> COMPOSITE_PIPELINE_DESCRIPTOR_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																						   GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																						   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																						   ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES,
																						   VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																						   VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);

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

	public GraphicProcessAdapter(GraphicProcess process)
	{
		super(process);
		subpassManager = new SubpassManager(process);

		if (process.getResourcePkg() == null)
		{
			process.setResourcePkg(ResourceFactory.eINSTANCE.createResourcePkg());
		}
		if (process.getDescriptorPkg() == null)
		{
			process.setDescriptorPkg(VulkanFactory.eINSTANCE.createDescriptorPkg());
		}
	}

	@Override
	public void start(final IVulkanContext vulkanContext, final IRootAllocator<IVulkanContext> rootAllocator)
	{
		subpassManager.start(vulkanContext);
		super.start(vulkanContext, rootAllocator);
	}

	@Override
	public void stop(final IVulkanContext vulkanContext)
	{
		super.stop(vulkanContext);
		subpassManager.stop(vulkanContext);
	}

	@Override
	public EQueueType getExecutionQueueType()
	{
		return EQueueType.Graphic;
	}

	@Override
	public boolean needPresentQueue()
	{
		return true;
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
					   SUBPASS_RESOURCE_FEATURES,
					   PIPELINE_RESOURCE_FEATURES,
					   COMPOSITE_PIPELINE_RESOURCE_FEATURES,
					   DESCRIPTOR_FEATURES,
					   SUBPASS_DESCRIPTOR_FEATURES,
					   PIPELINE_DESCRIPTOR_FEATURES,
					   COMPOSITE_PIPELINE_DESCRIPTOR_FEATURES);
	}

	@Override
	protected List<List<EReference>> getDescriptorPoolFeatureLists()
	{
		return List.of(DERSCRIPTOR_POOL_FEATURES,
					   PIPELINE_DERSCRIPTOR_POOL_FEATURES,
					   COMPOSITE_PIPELINE_DERSCRIPTOR_POOL_FEATURES);
	}

	@Override
	protected GraphicConfiguration getProcessConfiguration()
	{
		return ((GraphicProcess) process).getConfiguration();
	}
}
