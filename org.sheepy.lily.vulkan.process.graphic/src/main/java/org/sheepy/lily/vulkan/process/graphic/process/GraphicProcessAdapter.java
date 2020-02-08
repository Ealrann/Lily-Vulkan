package org.sheepy.lily.vulkan.process.graphic.process;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.process.graphic.pipeline.SubpassUtil;
import org.sheepy.lily.vulkan.process.graphic.present.ImageAcquirer;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Statefull
@Adapter(scope = GraphicProcess.class)
public final class GraphicProcessAdapter extends AbstractProcessAdapter<IGraphicContext>
{
	private static final List<EReference> PIPELINE__FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																	   GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																	   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES);
	private static final List<EReference> COMPOSITE_PIPELINE__FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																				 GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																				 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																				 ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES);
	private static final List<EReference> RESOURCE_FEATURES = List.of(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																	  ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> SUBPASS_RESOURCE_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																			  VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																			  ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> PIPELINE_RESOURCE_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																			   GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																			   ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																			   VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																			   ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> COMPOSITE_PIPELINE_RESOURCE_FEATURES = List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																						 GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
																						 ProcessPackage.Literals.PIPELINE_PKG__PIPELINES,
																						 ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES,
																						 VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																						 ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
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

	private final Map<IScenePart, Subpass> subpassMap = new HashMap<>();
	private final INotificationListener sceneListener = this::sceneChanged;
	private final ImageAcquirer acquirer = new ImageAcquirer();

	public GraphicProcessAdapter(GraphicProcess process)
	{
		super(process);

		if (process.getResourcePkg() == null)
		{
			process.setResourcePkg(ApplicationFactory.eINSTANCE.createResourcePkg());
		}
		if (process.getDescriptorPkg() == null)
		{
			process.setDescriptorPkg(VulkanFactory.eINSTANCE.createDescriptorPkg());
		}
	}

	@Load
	private void load()
	{
		final var application = ModelUtil.getApplication(process);
		application.getScene()
				   .addListener(sceneListener, ApplicationPackage.SCENE__PARTS);
		final var parts = application.getScene()
									 .getParts();
		for (int i = 0; i < parts.size(); i++)
		{
			final var part = parts.get(i);
			setupScenePart(part);
		}
	}

	@Dispose
	private void dispose()
	{
		final var application = ModelUtil.getApplication(process);
		application.getScene()
				   .removeListener(sceneListener, ApplicationPackage.SCENE__PARTS);
	}

	@Override
	protected List<IAllocable<? super IGraphicContext>> getExtraAllocables()
	{
		return List.of(acquirer);
	}

	private void sceneChanged(Notification notification)
	{
		switch (notification.getEventType())
		{
			case Notification.ADD:
				final var graphicProcess = (GraphicProcess) process;
				graphicProcess.getAttachmentPkg()
							  .getExtraAttachments()
							  .clear();
				setupScenePart((IScenePart) notification.getNewValue());
				break;
			case Notification.REMOVE:
				uninstallScenePart((IScenePart) notification.getOldValue());
				break;
		}
	}

	@Override
	protected GraphicContext createContext()
	{
		return new GraphicContext(getExecutionQueueType(),
								  isResetAllowed(),
								  descriptorPool,
								  (GraphicProcess) process);
	}

	private void setupScenePart(IScenePart part)
	{
		final var subpass = buildSubpass(part);
		final var graphicProcess = (GraphicProcess) process;
		final int index = findAvailableIndex(graphicProcess);

		subpass.setScenePart(part);
		subpass.setSubpassIndex(index);
		graphicProcess.getSubpasses()
					  .add(subpass);

		if (config != null)
		{
			config.setDirty();
		}

		subpassMap.put(part, subpass);
	}

	private static int findAvailableIndex(GraphicProcess process)
	{
		final var subpasses = process.getSubpasses();
		final int size = subpasses.size();
		final boolean[] reservedIndices = new boolean[size + 1];
		for (int i = 0; i < size; i++)
		{
			final var subpass = subpasses.get(i);
			if (SubpassUtil.isGraphic(subpass))
			{
				reservedIndices[subpass.getSubpassIndex()] = true;
			}
		}

		int res = 0;
		for (int i = 0; i < reservedIndices.length; i++)
		{
			if (reservedIndices[i] == false)
			{
				res = i;
				break;
			}
		}
		return res;
	}

	private void uninstallScenePart(IScenePart part)
	{
		final var subpass = subpassMap.get(part);
		EcoreUtil.delete(subpass);
		subpassMap.remove(part);
	}

	private <T extends IScenePart> Subpass buildSubpass(T scenePart)
	{
		final var graphicProcess = (GraphicProcess) process;
		final var subpassProvider = scenePart.<IScenePart_SubpassProvider<T>>adaptGeneric(IScenePart_SubpassProvider.class);
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
