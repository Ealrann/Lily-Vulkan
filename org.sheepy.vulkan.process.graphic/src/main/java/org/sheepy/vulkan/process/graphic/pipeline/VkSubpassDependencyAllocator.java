package org.sheepy.vulkan.process.graphic.pipeline;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubpassDependency;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.process.graphic.SubpassDependency;

public class VkSubpassDependencyAllocator
{

	public static VkSubpassDependency.Buffer allocate(	MemoryStack stack,
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

	private static void fillDependency(	final VkSubpassDependency dependency,
										final SubpassDependency dependencyInfo)
	{
		int srcAccessMask = buildAccessMask(dependencyInfo.getSrcAccesses());
		int dstAccessMask = buildAccessMask(dependencyInfo.getDstAccesses());

		dependency.srcSubpass(dependencyInfo.getSrcSubpass());
		dependency.dstSubpass(dependencyInfo.getDstSubpass());
		dependency.srcStageMask(dependencyInfo.getSrcStageMask().getValue());
		dependency.dstStageMask(dependencyInfo.getDstStageMask().getValue());
		dependency.srcAccessMask(srcAccessMask);
		dependency.dstAccessMask(dstAccessMask);
	}

	private static int buildAccessMask(final EList<EAccess> accesses)
	{
		int res = 0;
		for (EAccess access : accesses)
		{
			res |= access.getValue();
		}
		return res;
	}
}
