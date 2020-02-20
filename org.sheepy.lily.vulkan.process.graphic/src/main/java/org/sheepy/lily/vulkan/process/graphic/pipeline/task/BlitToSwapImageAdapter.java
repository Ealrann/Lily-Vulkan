package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.graphic.IImageViewManager;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;

import java.util.List;

@Statefull
@Adapter(scope = BlitToSwapImage.class)
public class BlitToSwapImageAdapter extends AbstractBlitTaskAdapter
{
	private IImageViewManager imageViewManager;

	public BlitToSwapImageAdapter(BlitToSwapImage blitTask)
	{
		super(blitTask);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		final var imageViewManager = context.getImageViewManager();
		config.addDependencies(List.of(imageViewManager));
		super.configureAllocation(config, context);
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		imageViewManager = context.getImageViewManager();
		super.allocate(context);
	}

	@Override
	public void free(IGraphicContext context)
	{
		super.free(context);
		imageViewManager = null;
	}

	@Override
	protected Vector2ic getDtImageSize(final IGraphicContext context)
	{
		final var extent = context.getSurfaceManager().getExtent();
		return new Vector2i(extent.x(), extent.y());
	}

	@Override
	protected long getDstImagePtr(final IRecordContext context)
	{
		return imageViewManager.getImageViews().get(context.index()).getImagePtr();
	}
}
