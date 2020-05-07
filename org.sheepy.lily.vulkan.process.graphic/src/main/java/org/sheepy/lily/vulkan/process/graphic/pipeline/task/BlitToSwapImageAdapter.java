package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = BlitToSwapImage.class)
@Adapter
public class BlitToSwapImageAdapter extends AbstractBlitTaskAdapter
{
	private final GraphicProcess process;

	public BlitToSwapImageAdapter(BlitToSwapImage blitTask)
	{
		super(blitTask);
		this.process = ModelUtil.findParent(blitTask, GraphicProcess.class);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, ProcessContext context)
	{
//		final var imageViewManager = context.getImageViewManager();
//		config.addDependencies(List.of(imageViewManager));
		super.configureAllocation(config, context);
	}

	@Override
	protected Vector2ic getDstImageSize()
	{
		final var extent = process.getConfiguration()
								  .getSurface()
								  .allocationHandle(PhysicalSurfaceAllocation.class)
								  .get()
								  .getExtent();

		return new Vector2i(extent.x(), extent.y());
	}

	@Override
	protected long getDstImagePtr(int index)
	{
		return process.getConfiguration()
					  .getImageViews()
					  .allocationHandle(ImageViewAllocation.class)
					  .get()
					  .getImageViews()
					  .get(index)
					  .getImagePtr();
	}
}
