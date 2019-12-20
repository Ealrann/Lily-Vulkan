package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
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
		reload();
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
		reload();
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

	private void reload()
	{
		final var parts = process.getPartPkg().getParts();
		final var application = ModelUtil.getApplication(process);
		final var scene = application.getScene();

		for (final var part : scene.getParts())
		{
			final var subpassData = getSubpassData(part);

			parts.clear();
			parts.addAll(subpassData.pipelines);

			configureRenderPass(subpassData);
		}

		if (config != null)
		{
			config.setDirty();
		}
	}

	private <T extends IScenePart> SubpassData getSubpassData(T view)
	{
		final var graphicProcess = (GraphicProcess) process;
		final var renderPass = graphicProcess.getRenderPassInfo();
		final var pipelineProvider = view.<IScenePart_SubpassProvider<T>> adaptGeneric(IScenePart_SubpassProvider.class);
		final var data = pipelineProvider.build(view, renderPass.getColorAttachment());
		return data;
	}

	private void configureRenderPass(SubpassData packet)
	{
		final var graphicProcess = (GraphicProcess) process;
		final var renderPass = graphicProcess.getRenderPassInfo();
		final var attachments = renderPass.getExtraAttachments();

		attachments.clear();
		attachments.addAll(packet.extraAttachments);

		renderPass.getSubpasses().clear();
		renderPass.getDependencies().clear();
		{
			for (final var pipeline : packet.pipelines)
			{
				if (pipeline instanceof GraphicsPipeline)
				{
					((GraphicsPipeline) pipeline).setSubpass(0);
				}
			}

			renderPass.getSubpasses().add(packet.subpass);

			final var dependency = GraphicFactory.eINSTANCE.createSubpassDependency();
			dependency.setSrcSubpass(null);
			dependency.setDstSubpass(packet.subpass);
			dependency.getSrcStageMask().add(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
			dependency.getDstStageMask().add(packet.stage);
			dependency.getDstAccesses().addAll(packet.accesses);

			renderPass.getDependencies().add(dependency);
		}
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
}
