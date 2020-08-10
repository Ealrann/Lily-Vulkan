package org.sheepy.lily.vulkan.extra.graphic.shape.adapter;

import org.joml.Vector3d;
import org.lwjgl.util.par.ParShapesMesh;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.notification.DummyNotifier;
import org.sheepy.lily.vulkan.extra.api.mesh.IMeshStructureAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.model.mesh.GeometricStructure;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.util.par.ParShapes.par_shapes_compute_normals;
import static org.lwjgl.util.par.ParShapes.par_shapes_free_mesh;

public abstract class AbstractShapeMeshAdapter<T extends GeometricStructure> extends DummyNotifier<IStructureAdapter.Features> implements
																															   IMeshStructureAdapter
{
	private final int[] indexes;
	private final double[] vertices;
	private final double[] trianglesNormals;
	private final double[] normals;

	private final ParShapesMesh mesh;

	public AbstractShapeMeshAdapter(T structure)
	{
		mesh = createShape(structure);
		par_shapes_compute_normals(mesh);

		indexes = intBufferToArray(mesh.triangles(getIndexCount(0)));
		vertices = doubleBufferToArray(mesh.points(getVertexCount(0) * 3));
		//noinspection ConstantConditions
		normals = doubleBufferToArray(mesh.normals(getVertexCount(0) * 3));
		trianglesNormals = computeTriangleNormals();
	}

	private static double[] doubleBufferToArray(FloatBuffer buffer)
	{
		final int limit = buffer.limit();
		final double[] res = new double[limit];

		for (int i = 0; i < limit; i++)
		{
			res[i] = buffer.get(i);
		}

		return res;
	}

	private static int[] intBufferToArray(IntBuffer buffer)
	{
		final int[] res = new int[buffer.limit()];
		buffer.get(res);

		return res;
	}

	@Dispose
	public void dispose()
	{
		par_shapes_free_mesh(mesh);
	}

	public final double[] computeTriangleNormals()
	{
		final double[] res = new double[indexes.length];

		final Vector3d v1 = new Vector3d();
		final Vector3d v2 = new Vector3d();
		final Vector3d v3 = new Vector3d();

		final Vector3d edge1 = new Vector3d();
		final Vector3d edge2 = new Vector3d();

		final Vector3d normal = new Vector3d();

		int triangleIndex = 0;
		for (int i = 0; i < indexes.length; i += 3)
		{
			final int index1 = indexes[i] * 3;
			final int index2 = indexes[i + 1] * 3;
			final int index3 = indexes[i + 2] * 3;

			v1.x = vertices[index1];
			v1.y = vertices[index1 + 1];
			v1.z = vertices[index1 + 2];

			v2.x = vertices[index2];
			v2.y = vertices[index2 + 1];
			v2.z = vertices[index2 + 2];

			v3.x = vertices[index3];
			v3.y = vertices[index3 + 1];
			v3.z = vertices[index3 + 2];

			v1.sub(v3, edge2);
			v1.sub(v2, edge1);

			edge1.cross(edge2, normal);
			normal.normalize();

			res[triangleIndex++] = normal.x;
			res[triangleIndex++] = normal.y;
			res[triangleIndex++] = normal.z;
		}

		return res;
	}

	@Override
	public int getPartCount(Structure structure)
	{
		return 1;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getInstanceCount(Structure structure)
	{
		return (int) ((T) structure).getMeshes().stream().mapToLong(mesh -> mesh.getPresentedEntities().size()).sum();
	}

	@Override
	public int getIndexCount(int part)
	{
		return mesh.ntriangles() * 3;
	}

	@Override
	public int getVertexCount(int part)
	{
		return mesh.npoints();
	}

	@Override
	public int getTriangleCount(int part)
	{
		return mesh.ntriangles();
	}

	@Override
	public int[] getIndices(int part)
	{
		return indexes;
	}

	@Override
	public double[] getVertices(int part)
	{
		return vertices;
	}

	@Override
	public double[] getVertexNormals(int part)
	{
		return normals;
	}

	@Override
	public double[] getTriangleNormals(int part)
	{
		return trianglesNormals;
	}

	protected abstract ParShapesMesh createShape(T structure);

}
