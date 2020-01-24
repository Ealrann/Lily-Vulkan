package org.sheepy.lily.vulkan.process.graphic.renderpass;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubpassDependency;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class VkSubpassDependencyAllocator
{
	public static VkSubpassDependency.Buffer allocate(	MemoryStack stack,
														final List<Subpass> subpasses)
	{
		final int size = Math.max(1, subpasses.size());
		final var dependencies = VkSubpassDependency.callocStack(size, stack);
		if (subpasses.isEmpty() == false)
		{
			Subpass previousSubpass = null;
			for (int i = 0; i < size; i++)
			{
				final var subpass = subpasses.get(i);
				fillDependency(dependencies.get(), previousSubpass, subpass);
				previousSubpass = subpass;
			}
		}
		else
		{
			fillEmptyDependency(dependencies.get());
		}
		dependencies.flip();
		return dependencies;
	}

	private static void fillDependency(	final VkSubpassDependency dependency,
										final Subpass src,
										final Subpass dst)
	{
		final int srcAccessMask = buildAccessMask(src);
		final int dstAccessMask = buildAccessMask(src);
		final int srcStageMask = buildStageMask(dst);
		final int dstStageMask = buildStageMask(dst);
		final int srcSubpassIndex = getSubpassIndex(src);
		final int dstSubpassIndex = getSubpassIndex(dst);

		dependency.srcSubpass(srcSubpassIndex);
		dependency.dstSubpass(dstSubpassIndex);
		dependency.srcStageMask(srcStageMask);
		dependency.dstStageMask(dstStageMask);
		dependency.srcAccessMask(srcAccessMask);
		dependency.dstAccessMask(dstAccessMask);
	}

	private static void fillEmptyDependency(final VkSubpassDependency dependency)
	{
		dependency.srcSubpass(-1);
		dependency.dstSubpass(0);
		dependency.srcStageMask(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT_VALUE);
		dependency.dstStageMask(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT_VALUE);
		dependency.srcAccessMask(0);
		dependency.dstAccessMask(EAccess.COLOR_ATTACHMENT_WRITE_BIT_VALUE);
	}

	private static int getSubpassIndex(final Subpass subpass)
	{
		return subpass != null ? subpass.getSubpassIndex() : -1;
	}

	private static int buildAccessMask(final Subpass subpass)
	{
		return subpass != null ? VulkanModelUtil.getEnumeratedFlag(subpass.getAccesses()) : 0;
	}

	private static int buildStageMask(final Subpass subpass)
	{
		return subpass != null ? VulkanModelUtil.getEnumeratedFlag(subpass.getStages()) : 0;
	}
}
