package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.util.ModelDependencyInjector;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.model.process.graphic.BlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

@Statefull
@Adapter(scope = BlitTask.class)
public class BlitTaskAdapter extends AbstractBlitTaskAdapter
{
	private final BlitTask blitTask;
	private final ModelDependencyInjector dependencyInjector;

	private VkImage dstVkImage;

	public BlitTaskAdapter(BlitTask blitTask)
	{
		super(blitTask);
		this.blitTask = blitTask;
		dependencyInjector = new ModelDependencyInjector(blitTask, GraphicPackage.Literals.BLIT_TASK__DST_IMAGE);
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, GraphicContext context)
	{
		super.configureAllocation(config, context);
		dependencyInjector.start(config);
	}

	@Dispose
	private void dispose()
	{
		dependencyInjector.stop();
	}

	@Override
	public void allocate(final GraphicContext context)
	{
		final var dstImage = blitTask.getDstImage();
		final var imageAdapter = dstImage.adaptNotNull(IVkImageAdapter.class);
		dstVkImage = imageAdapter.getVkImage();

		super.allocate(context);
	}

	@Override
	protected long getDstImagePtr(final IRecordContext context)
	{
		return dstVkImage.getPtr();
	}

	@Override
	protected Vector2ic getDtImageSize(final IGraphicContext context)
	{
		return new Vector2i(dstVkImage.width, dstVkImage.height);
	}
}
