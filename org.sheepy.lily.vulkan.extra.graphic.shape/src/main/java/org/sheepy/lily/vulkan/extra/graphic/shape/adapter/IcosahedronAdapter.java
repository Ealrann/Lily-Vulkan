package org.sheepy.lily.vulkan.extra.graphic.shape.adapter;

import org.lwjgl.util.par.ParShapes;
import org.lwjgl.util.par.ParShapesMesh;
import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.extra.model.shape.Icosahedron;

@ModelExtender(scope = Icosahedron.class)
@Adapter
public class IcosahedronAdapter extends AbstractShapeMeshAdapter<Icosahedron>
{
	public IcosahedronAdapter(Icosahedron structure)
	{
		super(structure);
	}

	@Override
	protected ParShapesMesh createShape(Icosahedron structure)
	{
		return ParShapes.par_shapes_create_icosahedron();
	}
}
