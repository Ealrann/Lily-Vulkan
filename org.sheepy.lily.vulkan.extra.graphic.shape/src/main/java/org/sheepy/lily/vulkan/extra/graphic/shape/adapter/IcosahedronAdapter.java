package org.sheepy.lily.vulkan.extra.graphic.shape.adapter;

import org.lwjgl.util.par.ParShapes;
import org.lwjgl.util.par.ParShapesMesh;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.extra.model.mesh.Icosahedron;

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
