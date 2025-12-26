package org.sheepy.lily.vulkan.process.graphic.pipeline.util;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

import java.util.List;

public final class SubpassUtil
{
	public static int maxGraphicIndex(final List<Subpass> subpasses)
	{
		int maxIndex = 0;
		for (int i = 0; i < subpasses.size(); i++)
		{
			final var subpass = subpasses.get(i);
			if (isGraphic(subpass) && subpass.subpassIndex() > maxIndex)
			{
				maxIndex = subpass.subpassIndex();
			}
		}
		return maxIndex;
	}

	public static boolean isGraphic(Subpass subpass)
	{
		final var pipelinePkg = subpass.pipelinePkg();
		if (pipelinePkg != null)
		{
			for (final var pipeline : pipelinePkg.pipelines())
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
