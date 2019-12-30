package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
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
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider.SubpassData;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.lily.vulkan.process.graphic.present.ImageAcquirer;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.queue.EQueueType;

@Statefull
@Adapter(scope = GraphicProcess.class)
public final class GraphicProcessAdapter extends AbstractProcessAdapter<IGraphicContext>
{
	private static final List<ECommandStage> stages = List.of(	ECommandStage.TRANSFER,
																ECommandStage.COMPUTE,
																ECommandStage.PRE_RENDER,
																ECommandStage.RENDER,
																ECommandStage.POST_RENDER);

	private final List<SubPassContainer> subpasses = new ArrayList<>();
	private final INotificationListener sceneListener = this::sceneChanged;
	private final ImageAcquirer acquirer = new ImageAcquirer();

	public GraphicProcessAdapter(GraphicProcess process)
	{
		super(process);

		if (process.getPartPkg() == null)
		{
			process.setPartPkg(ProcessFactory.eINSTANCE.createProcessPartPkg());
		}
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
		application.getScene().addListener(sceneListener, ApplicationPackage.SCENE__PARTS);
		final var parts = application.getScene().getParts();
		boolean containsGraphic = false;
		for (int i = 0; i < parts.size(); i++)
		{
			final var part = parts.get(i);
			containsGraphic |= setupScenePart(part, i).isGraphic;
		}

		if (containsGraphic == false)
		{
			setupEmptyRenderPass();
		}
	}

	@Dispose
	private void dispose()
	{
		final var application = ModelUtil.getApplication(process);
		application.getScene().removeListener(sceneListener, ApplicationPackage.SCENE__PARTS);
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
			setupScenePart((IScenePart) notification.getNewValue(), notification.getPosition());
			break;
		case Notification.REMOVE:
			uninstallScenePart((IScenePart) notification.getOldValue());
			break;
		}
	}

	@Override
	protected IGraphicContext createContext()
	{
		return new GraphicContext(	getExecutionQueueType(),
									isResetAllowed(),
									descriptorPool,
									(GraphicProcess) process);
	}

	private SubPassContainer setupScenePart(IScenePart part, int index)
	{
		final var subpassData = getSubpassData(part);
		final var graphicProcess = (GraphicProcess) process;
		final var previousGraphicSubpass = getGraphicSubpass(index);
		final int newIndex = previousGraphicSubpass != null ? previousGraphicSubpass.index + 1 : 0;
		final var container = new SubPassContainer(part, newIndex, subpassData);

		container.setup(graphicProcess, previousGraphicSubpass);

		subpasses.add(container);

		if (config != null)
		{
			config.setDirty();
		}

		return container;
	}

	private void setupEmptyRenderPass()
	{
		final var graphicProcess = (GraphicProcess) process;
		final var renderPass = graphicProcess.getRenderPassInfo();
		final var colorAttachment = renderPass.getColorAttachment();
		final var subpass = GraphicFactory.eINSTANCE.createSubpass();
		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(colorAttachment);
		subpass.getRefs().add(colorRef);

		final var subpassData = new SubpassData(List.of(),
												subpass,
												EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT,
												List.of(EAccess.COLOR_ATTACHMENT_WRITE_BIT,
														EAccess.COLOR_ATTACHMENT_READ_BIT),
												List.of());
		final var container = new SubPassContainer(null, 0, subpassData);
		container.setup(graphicProcess, container);

		subpasses.add(container);
	}

	private SubPassContainer getGraphicSubpass(int index)
	{
		SubPassContainer res = null;
		for (int i = 0; i < index; i++)
		{
			final var subpass = subpasses.get(i);
			if (subpass.isGraphic)
			{
				res = subpass;
			}
		}
		return res;
	}

	private void uninstallScenePart(IScenePart part)
	{
		final var graphicProcess = (GraphicProcess) process;
		final var container = findSubpass(part);
		container.uninstall(graphicProcess);
		subpasses.remove(container);
	}

	private SubPassContainer findSubpass(IScenePart part)
	{
		for (final var subpass : subpasses)
		{
			if (subpass.scenePart == part)
			{
				return subpass;
			}
		}
		return null;
	}

	private <T extends IScenePart> SubpassData getSubpassData(T view)
	{
		final var graphicProcess = (GraphicProcess) process;
		final var renderPass = graphicProcess.getRenderPassInfo();
		final var pipelineProvider = view.<IScenePart_SubpassProvider<T>> adaptGeneric(IScenePart_SubpassProvider.class);
		final var colorAttachment = renderPass.getColorAttachment();
		final var data = pipelineProvider.build(view, colorAttachment);
		return data;
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

	private static final class SubPassContainer
	{
		public final IScenePart scenePart;
		public final SubpassData data;
		public final boolean isGraphic;
		private SubpassDependency dependency;
		private final int index;

		public SubPassContainer(IScenePart scenePart, int index, SubpassData data)
		{
			this.scenePart = scenePart;
			this.data = data;
			this.index = index;

			isGraphic = data.subpass != null;
		}

		private void setup(GraphicProcess process, SubPassContainer previousGraphicData)
		{
			final var renderPass = process.getRenderPassInfo();
			final var parts = process.getPartPkg().getParts();
			final var resourcePkg = process.getResourcePkg();
			final var descriptorPkg = process.getDescriptorPkg();

			if (isGraphic)
			{
				final var attachments = renderPass.getExtraAttachments();
				final var dependencies = renderPass.getDependencies();
				final var subpasses = renderPass.getSubpasses();

				for (final var pipeline : data.pipelines)
				{
					if (pipeline instanceof GraphicsPipeline)
					{
						((GraphicsPipeline) pipeline).setSubpass(index);
						((GraphicsPipeline) pipeline).setScenePart(scenePart);
					}
				}
				dependency = GraphicFactory.eINSTANCE.createSubpassDependency();
				dependency.setSrcSubpass(previousGraphicData != null
						? previousGraphicData.data.subpass
						: null);
				dependency.setDstSubpass(data.subpass);
				dependency.getSrcStageMask().add(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
				dependency.getDstStageMask().add(data.stage);
				dependency.getDstAccesses().addAll(data.accesses);

				attachments.addAll(data.extraAttachments);
				subpasses.add(data.subpass);
				dependencies.add(dependency);
			}

			resourcePkg.getResources().addAll(data.resources);
			descriptorPkg.getDescriptors().addAll(data.descriptors);

			parts.addAll(data.pipelines);
		}

		private void uninstall(GraphicProcess process)
		{
			final var renderPass = process.getRenderPassInfo();
			final var parts = process.getPartPkg().getParts();
			final var resourcePkg = process.getResourcePkg();
			final var descriptorPkg = process.getDescriptorPkg();

			if (isGraphic)
			{
				final var attachments = renderPass.getExtraAttachments();
				final var dependencies = renderPass.getDependencies();
				final var subpasses = renderPass.getSubpasses();

				attachments.removeAll(data.extraAttachments);
				subpasses.remove(data.subpass);
				dependencies.remove(dependency);
				EcoreUtil.delete(dependency);
			}

			resourcePkg.getResources().removeAll(data.resources);
			descriptorPkg.getDescriptors().removeAll(data.descriptors);

			parts.removeAll(data.pipelines);
		}
	}
}
