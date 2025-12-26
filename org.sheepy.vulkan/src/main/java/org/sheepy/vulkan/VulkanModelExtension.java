package org.sheepy.vulkan;

import org.logoce.lmf.core.api.model.IModelPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.vulkan.model.barrier.BarrierModelPackage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelPackage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelPackage;
import org.sheepy.vulkan.model.image.ImageModelPackage;
import org.sheepy.vulkan.model.pipeline.PipelineModelPackage;

import java.util.Collection;
import java.util.List;

public class VulkanModelExtension implements IModelExtension
{
	@Override
	public Collection<IModelPackage> getEPackages()
	{
		return List.of(BarrierModelPackage.Instance,
					   EnumerationModelPackage.Instance,
					   GraphicPipelineModelPackage.Instance,
					   ImageModelPackage.Instance,
					   PipelineModelPackage.Instance);
	}
}
