package org.sheepy.lily.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Observe;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.process.graphic.pipeline.util.SubpassUtil;
import org.sheepy.lily.vulkan.process.graphic.present.ImageAcquirer;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Statefull
@Adapter(scope = GraphicProcess.class)
public final class GraphicProcessAdapter extends AbstractProcessAdapter<GraphicContext>
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

	private static final List<ECommandStage> stages = List.of(ECommandStage.TRANSFER,
															  ECommandStage.COMPUTE,
															  ECommandStage.PRE_RENDER,
															  ECommandStage.RENDER,
															  ECommandStage.POST_RENDER);

	private final Map<ICompositor, Subpass> subpassMap = new HashMap<>();
	private final ImageAcquirer acquirer = new ImageAcquirer();

	public GraphicProcessAdapter(GraphicProcess process)
	{
		super(process);

		if (process.getResourcePkg() == null)
		{
			process.setResourcePkg(ResourceFactory.eINSTANCE.createResourcePkg());
		}
		if (process.getDescriptorPkg() == null)
		{
			process.setDescriptorPkg(VulkanFactory.eINSTANCE.createDescriptorPkg());
		}
	}

	@Observe
	private void observe(IObservatoryBuilder observatory)
	{
		final var application = ModelUtil.getApplication(process);
		final var scene = application.getScene();
		observatory.focus(scene)
				   .explore(ApplicationPackage.Literals.SCENE__COMPOSITORS, ICompositor.class)
				   .gatherBulk(this::installCompositors, this::uninstallCompositors);
	}

	@Override
	protected List<IAllocable<? super GraphicContext>> getExtraAllocables()
	{
		return List.of(acquirer);
	}

	private void installCompositors(List<ICompositor> compositors)
	{
		for (int i = 0; i < compositors.size(); i++)
		{
			final var compositor = compositors.get(i);
			setupScenePart(compositor);
		}
	}

	private void uninstallCompositors(List<ICompositor> compositors)
	{
		for (int i = 0; i < compositors.size(); i++)
		{
			final var compositor = compositors.get(i);
			final var subpass = subpassMap.get(compositor);
			EcoreUtil.delete(subpass);
			subpassMap.remove(compositor);
			if (config != null) config.setDirty();
		}
	}

	@Override
	protected GraphicContext createContext()
	{
		final var graphicProcess = (GraphicProcess) this.process;
		return new GraphicContext(getExecutionQueueType(), isResetAllowed(), descriptorPool, graphicProcess);
	}

	private void setupScenePart(ICompositor part)
	{
		final var subpass = buildSubpass(part);
		final var graphicProcess = (GraphicProcess) process;
		final int index = findAvailableIndex(graphicProcess);

		subpass.setCompositor(part);
		subpass.setSubpassIndex(index);
		graphicProcess.getSubpasses().add(subpass);

		subpassMap.put(part, subpass);
		if (config != null) config.setDirty();
	}

	private static int findAvailableIndex(GraphicProcess process)
	{
		final var subpasses = process.getSubpasses();
		final int size = subpasses.size();
		final int maxIndex = SubpassUtil.maxGraphicIndex(subpasses);

		final boolean[] reservedIndices = new boolean[Math.max(size, maxIndex) + 1];
		for (int i = 0; i < size; i++)
		{
			final var subpass = subpasses.get(i);
			if (SubpassUtil.isGraphic(subpass))
			{
				reservedIndices[subpass.getSubpassIndex()] = true;
			}
		}

		for (int i = 0; i < reservedIndices.length; i++)
		{
			if (reservedIndices[i] == false)
			{
				return i;
			}
		}
		return 0;
	}

	private <T extends ICompositor> Subpass buildSubpass(T scenePart)
	{
		final var graphicProcess = (GraphicProcess) process;
		final var subpassProvider = scenePart.<ICompositor_SubpassProvider<T>>adaptGeneric(ICompositor_SubpassProvider.class);
		return subpassProvider.build(scenePart, graphicProcess.getAttachmentPkg());
	}

	@Override
	protected Integer prepareNextExecution()
	{
		return acquirer.acquireNextImage();
	}

	@Override
	protected List<ECommandStage> getStages()
	{
		return stages;
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
}
