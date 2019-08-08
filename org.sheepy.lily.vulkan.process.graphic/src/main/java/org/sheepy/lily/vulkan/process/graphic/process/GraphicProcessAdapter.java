package org.sheepy.lily.vulkan.process.graphic.process;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.present.ImageAcquirer;
import org.sheepy.lily.vulkan.process.process.AbstractProcessAdapter;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.queue.VulkanQueue;

@Statefull
@Adapter(scope = GraphicProcess.class)
public class GraphicProcessAdapter extends AbstractProcessAdapter<IGraphicContext>
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.TRANSFER,
			ECommandStage.COMPUTE, ECommandStage.PRE_RENDER, ECommandStage.RENDER,
			ECommandStage.POST_RENDER);

	private final ImageAcquirer acquirer = new ImageAcquirer();

	public GraphicProcessAdapter(GraphicProcess process)
	{
		super(process);

		allocationList.add(acquirer);
	}

	@Override
	protected IGraphicContext createContext()
	{
		return new GraphicContext(getQueueType(), isResetAllowed(), descriptorPool,
				(GraphicProcess) process);
	}

	@Override
	protected Integer prepareNextExecution()
	{
		final Integer nextImage = acquirer.acquireNextImage();

		return nextImage;
	}

	@Override
	public VulkanQueue getQueue()
	{
		return context.getQueue();
	}

	@Override
	public EQueueType getQueueType()
	{
		return EQueueType.Graphic;
	}

	public static GraphicProcessAdapter adapt(GraphicProcess object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, GraphicProcessAdapter.class);
	}

	@Override
	protected List<ECommandStage> getStages()
	{
		return stages;
	}
}
