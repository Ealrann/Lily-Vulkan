package org.sheepy.lily.vulkan.extra.graphic.shape.adapter;

import org.lwjgl.util.par.ParShapes;
import org.lwjgl.util.par.ParShapesMesh;
import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.extra.model.shape.IcoSphere;

@ModelExtender(scope = IcoSphere.class)
@Adapter
public class IcoSphereAdapter extends AbstractShapeMeshAdapter<IcoSphere>
{
	public IcoSphereAdapter(IcoSphere structure)
	{
		super(structure);
	}

	@Override
	protected ParShapesMesh createShape(IcoSphere structure)
	{
		final int subdivisionCount = structure.getSubdivisionCount();
		final var res = ParShapes.par_shapes_create_subdivided_sphere(subdivisionCount);

		// System.out.println("IcoSphere: " + res.ntriangles());

		return res;
	}
}
