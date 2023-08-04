package org.sheepy.lily.vulkan.extra.api.model;

import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.shape.ShapePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VulkanExtraModelExtension implements IModelExtension
{
	@Override
	public Collection<EPackage> getEPackages()
	{
		final List<EPackage> res = new ArrayList<>();

		res.add(NuklearPackage.eINSTANCE);
		res.add(RenderingPackage.eINSTANCE);
		res.add(ShapePackage.eINSTANCE);
		res.add(SpritePackage.eINSTANCE);

		return List.copyOf(res);
	}
}
