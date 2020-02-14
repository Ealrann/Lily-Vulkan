package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkSubpassDependency;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;

public final class VkSubpassDependencyAllocator
{
	private EPipelineStage previousFinishStage;
	private List<EAccess> previousFinishAccess;

	public VkSubpassDependency.Buffer allocate(MemoryStack stack, final List<Subpass> subpasses)
	{
		previousFinishStage = EPipelineStage.TOP_OF_PIPE_BIT;
		previousFinishAccess = List.of();

		final int size = Math.max(1, subpasses.size());
		final var dependencies = VkSubpassDependency.callocStack(size, stack);
		if (subpasses.isEmpty() == false)
		{

			for (int i = 0; i < size; i++)
			{
				final var subpass = subpasses.get(i);
				fillDependency(dependencies.get(), subpass);
			}
		}
		else
		{
			fillEmptyDependency(dependencies.get());
		}
		dependencies.flip();
		return dependencies;
	}

	private void fillDependency(final VkSubpassDependency dependency, final Subpass subpass)
	{
		final var worstWaitForStage = subpass.getWaitForStage();
		final boolean usePrevious = previousFinishStage.getValue() < worstWaitForStage.getValue();

		final var effectiveWaitStage = usePrevious ? previousFinishStage : worstWaitForStage;
		final var effectiveWaitAccesses = usePrevious ? previousFinishAccess : subpass.getWaitForAccesses();

		final int subpassIndex = subpass.getSubpassIndex();
		final int srcStageMask = effectiveWaitStage.getValue();
		final int srcAccessMask = buildAccessMask(effectiveWaitAccesses);
		final int dstStageMask = subpass.getSyncStage().getValue();
		final int dstAccessMask = buildAccessMask(subpass.getSyncAccesses());
		final int srcSubpassIndex = subpassIndex - 1;
		final int dstSubpassIndex = subpassIndex;

		dependency.srcSubpass(srcSubpassIndex);
		dependency.dstSubpass(dstSubpassIndex);
		dependency.srcStageMask(srcStageMask);
		dependency.dstStageMask(dstStageMask);
		dependency.srcAccessMask(srcAccessMask);
		dependency.dstAccessMask(dstAccessMask);
		dependency.dependencyFlags(VK10.VK_DEPENDENCY_BY_REGION_BIT);

		previousFinishStage = subpass.getFinishStage();
		previousFinishAccess = subpass.getFinishAccesses();
	}

	private static void fillEmptyDependency(final VkSubpassDependency dependency)
	{
		dependency.srcSubpass(-1);
		dependency.dstSubpass(0);
		dependency.srcStageMask(EPipelineStage.TOP_OF_PIPE_BIT_VALUE);
		dependency.dstStageMask(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT_VALUE);
		dependency.srcAccessMask(0);
		dependency.dstAccessMask(EAccess.COLOR_ATTACHMENT_WRITE_BIT_VALUE);
	}

	private static int buildAccessMask(final List<EAccess> accesses)
	{
		return accesses != null ? VulkanModelUtil.getEnumeratedFlag(accesses) : 0;
	}
}
