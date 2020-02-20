package org.sheepy.lily.vulkan.process.graphic.pipeline.util;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

public final class SubpassUtil
{
	public static boolean isGraphic(Subpass subpass)
	{
		final var pipelinePkg = subpass.getPipelinePkg();
		if (pipelinePkg != null)
		{
			for (final var pipeline : pipelinePkg.getPipelines())
			{
				if (pipeline instanceof GraphicsPipeline)
				{
					return true;
				}
			}
		}
		return false;
	}
}
