package org.sheepy.vulkan.nativehelper;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSubpassDependency;
import org.sheepy.vulkan.model.process.SubpassDependency;

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
		dependency.srcSubpass(dependencyInfo.getSrcSubpass());
		dependency.dstSubpass(dependencyInfo.getDstSubpass());
		dependency.srcStageMask(dependencyInfo.getSrcStageMask().getValue());
		dependency.dstStageMask(dependencyInfo.getDstStageMask().getValue());
		dependency.srcAccessMask(dependencyInfo.getSrcAccessMask());
		dependency.dstAccessMask(dependencyInfo.getDstAccessMask());
	}
}
