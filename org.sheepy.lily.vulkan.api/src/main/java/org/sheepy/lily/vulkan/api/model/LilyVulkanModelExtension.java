package org.sheepy.lily.vulkan.api.model;

import org.logoce.lmf.core.api.model.IModelPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelPackage;
import org.sheepy.lily.vulkan.model.process.ProcessModelPackage;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelPackage;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelPackage;

import java.util.Collection;
import java.util.List;

public class LilyVulkanModelExtension implements IModelExtension
{
	@Override
	public Collection<IModelPackage> getEPackages()
	{
		return List.of(ComputeModelPackage.Instance,
					   GraphicModelPackage.Instance,
					   ProcessModelPackage.Instance,
					   VulkanModelPackage.Instance,
					   VulkanResourceModelPackage.Instance);
	}
}
