package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.allocation.up.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.model.process.graphic.BlitTask;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = BlitTask.class)
@Adapter
public class BlitTaskAllocation extends AbstractBlitTaskAllocation
{
	private final VkImage dstVkImage;

	public BlitTaskAllocation(BlitTask blitTask,
							  ProcessContext context,
							  @InjectDependency(index = 0) IVkImageAllocation srcImage,
							  @InjectDependency(index = 1) IVkImageAllocation dstImage)
	{
		super(blitTask, context, srcImage);
		dstVkImage = dstImage.getVkImage();
	}

	@Override
	protected long getDstImagePtr(int index)
	{
		return dstVkImage.getPtr();
	}

	@Override
	protected Vector2ic getDstImageSize()
	{
		return new Vector2i(dstVkImage.width, dstVkImage.height);
	}
}
