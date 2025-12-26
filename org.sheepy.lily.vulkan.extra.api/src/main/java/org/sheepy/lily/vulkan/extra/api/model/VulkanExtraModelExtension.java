package org.sheepy.lily.vulkan.extra.api.model;

import org.logoce.lmf.core.api.model.IModelPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshModelPackage;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearModelPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelPackage;
import org.sheepy.lily.vulkan.extra.model.shape.ShapeModelPackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteModelPackage;

import java.util.Collection;
import java.util.List;

public class VulkanExtraModelExtension implements IModelExtension
{
	@Override
	public Collection<IModelPackage> getEPackages()
	{
		return List.of(NuklearModelPackage.Instance,
					   RenderingModelPackage.Instance,
					   MeshModelPackage.Instance,
					   ShapeModelPackage.Instance,
					   SpriteModelPackage.Instance);
	}
}
