package org.sheepy.lily.vulkan.extra.graphic.shape;

import org.lwjgl.util.par.ParShapes;
import org.lwjgl.util.par.ParShapesMesh;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.extra.model.mesh.Icosahedron;

@Statefull
@Adapter(scope = Icosahedron.class)
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
