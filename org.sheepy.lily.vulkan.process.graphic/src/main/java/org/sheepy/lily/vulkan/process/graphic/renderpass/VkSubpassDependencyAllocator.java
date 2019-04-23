package org.sheepy.lily.vulkan.process.graphic.renderpass;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubpassDependency;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public class VkSubpassDependencyAllocator
{
	private final RenderPassInfo renderPass;

	public VkSubpassDependencyAllocator(RenderPassInfo renderPass)
	{
		this.renderPass = renderPass;
	}

	public VkSubpassDependency.Buffer allocate(	MemoryStack stack,
												final List<SubpassDependency> dependencyInfos)
	{
		final var dependencies = VkSubpassDependency.callocStack(dependencyInfos.size(), stack);
		for (final SubpassDependency dependencyInfo : dependencyInfos)
		{
			fillDependency(dependencies.get(), dependencyInfo);
		}
		dependencies.flip();
		return dependencies;
	}

	private void fillDependency(final VkSubpassDependency dependency,
								final SubpassDependency dependencyInfo)
	{
		final int srcAccessMask = buildAccessMask(dependencyInfo.getSrcAccesses());
		final int dstAccessMask = buildAccessMask(dependencyInfo.getDstAccesses());
		final int srcStageMask = buildStageMask(dependencyInfo.getSrcStageMask());
		final int dstStageMask = buildStageMask(dependencyInfo.getDstStageMask());

		final var srcSubpass = dependencyInfo.getSrcSubpass();
		final var dstSubpass = dependencyInfo.getDstSubpass();

		int srcSubpassIndex = -1;
		int dstSubpassIndex = -1;

		if (srcSubpass != null)
		{
			srcSubpassIndex = renderPass.getSubpasses().indexOf(srcSubpass);
		}
		if (dstSubpass != null)
		{
			dstSubpassIndex = renderPass.getSubpasses().indexOf(dstSubpass);
		}

		dependency.srcSubpass(srcSubpassIndex);
		dependency.dstSubpass(dstSubpassIndex);
		dependency.srcStageMask(srcStageMask);
		dependency.dstStageMask(dstStageMask);
		dependency.srcAccessMask(srcAccessMask);
		dependency.dstAccessMask(dstAccessMask);
	}

	private static int buildAccessMask(final EList<EAccess> accesses)
	{
		int res = 0;
		for (final EAccess access : accesses)
		{
			res |= access.getValue();
		}
		return res;
	}

	private static int buildStageMask(final EList<EPipelineStage> stages)
	{
		int res = 0;
		for (final EPipelineStage stage : stages)
		{
			res |= stage.getValue();
		}
		return res;
	}
}
