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
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.IScenePart;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider.SubpassData;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.lily.vulkan.process.graphic.present.ImageAcquirer;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
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
	}

	@Load
	private void load()
	{
		final var application = ModelUtil.getApplication(process);
		application.getScene().addListener(sceneListener, ApplicationPackage.SCENE__PARTS);
		final var parts = application.getScene().getParts();
		for (int i = 0; i < parts.size(); i++)
		{
			final var part = parts.get(i);
			setupScenePart(part, i);
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
		needReload = true;
	}

	@Override
	protected IGraphicContext createContext()
	{
		return new GraphicContext(	getExecutionQueueType(),
									isResetAllowed(),
									descriptorPool,
									(GraphicProcess) process);
	}

	private void setupScenePart(IScenePart part, int index)
	{
		final var subpassData = getSubpassData(part);
		final var graphicProcess = (GraphicProcess) process;
		final var container = new SubPassContainer(part, subpassData);
		final int subpassIndex = computeSubpassIndex(index);

		container.setup(graphicProcess, subpassIndex);

		subpasses.add(container);

		if (config != null)
		{
			config.setDirty();
		}
	}

	private int computeSubpassIndex(int index)
	{
		int res = 0;
		for (int i = 0; i < index; i++)
		{
			final var subpass = subpasses.get(i);
			if (subpass.isGraphic)
			{
				res++;
			}
		}
		return res;
	}

	private void uninstallScenePart(IScenePart part)
	{
		final var graphicProcess = (GraphicProcess) process;
		final var container = findSubpass(part);
		container.uninstall(graphicProcess);
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
		final var data = pipelineProvider.build(view, renderPass.getColorAttachment());
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

		public SubPassContainer(IScenePart scenePart, SubpassData data)
		{
			this.scenePart = scenePart;
			this.data = data;

			isGraphic = isGraphic(data);
		}

		private static boolean isGraphic(SubpassData data)
		{
			for (final var pipeline : data.pipelines)
			{
				if (pipeline instanceof GraphicsPipeline)
				{
					return true;
				}
			}
			return false;
		}

		private void setup(GraphicProcess process, int subpassIndex)
		{
			final var renderPass = process.getRenderPassInfo();
			final var attachments = renderPass.getExtraAttachments();
			final var parts = process.getPartPkg().getParts();
			final var dependencies = renderPass.getDependencies();
			final var subpasses = renderPass.getSubpasses();

			for (final var pipeline : data.pipelines)
			{
				if (pipeline instanceof GraphicsPipeline)
				{
					((GraphicsPipeline) pipeline).setSubpass(subpassIndex);
					((GraphicsPipeline) pipeline).setScenePart(scenePart);
				}
			}

			dependency = GraphicFactory.eINSTANCE.createSubpassDependency();
			dependency.setSrcSubpass(null);
			dependency.setDstSubpass(data.subpass);
			dependency.getSrcStageMask().add(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
			dependency.getDstStageMask().add(data.stage);
			dependency.getDstAccesses().addAll(data.accesses);

			parts.addAll(data.pipelines);
			attachments.addAll(data.extraAttachments);
			dependencies.add(dependency);
			subpasses.add(data.subpass);
		}

		private void uninstall(GraphicProcess process)
		{
			final var renderPass = process.getRenderPassInfo();
			final var attachments = renderPass.getExtraAttachments();
			final var parts = process.getPartPkg().getParts();
			final var dependencies = renderPass.getDependencies();
			final var subpasses = renderPass.getSubpasses();

			parts.removeAll(data.pipelines);
			attachments.addAll(data.extraAttachments);
			dependencies.remove(dependency);
			subpasses.remove(data.subpass);

			EcoreUtil.delete(dependency);
		}
	}
}
