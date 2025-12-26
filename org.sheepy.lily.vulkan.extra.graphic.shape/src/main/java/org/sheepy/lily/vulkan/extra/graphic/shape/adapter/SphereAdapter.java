package org.sheepy.lily.vulkan.extra.graphic.shape.adapter;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.lwjgl.util.par.ParShapes;
import org.lwjgl.util.par.ParShapesMesh;
import org.sheepy.lily.vulkan.extra.model.shape.Sphere;

@ModelExtender(scope = Sphere.class)
@Adapter
public class SphereAdapter extends AbstractShapeMeshAdapter<Sphere>
{
	public SphereAdapter(Sphere meshObject)
	{
		super(meshObject);
	}

	@Override
	protected ParShapesMesh createShape(Sphere sphere)
	{
		final int sliceCount = sphere.sliceCount();
		final var res = ParShapes.par_shapes_create_parametric_sphere(sliceCount, sliceCount);

		// System.out.println("Sphere: " + res.ntriangles());

		return res;
	}
}
