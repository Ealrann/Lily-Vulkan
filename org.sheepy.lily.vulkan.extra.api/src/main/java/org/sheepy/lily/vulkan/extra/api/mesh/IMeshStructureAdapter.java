package org.sheepy.lily.vulkan.extra.api.mesh;

import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;

public interface IMeshStructureAdapter extends IStructureAdapter
{
	int getIndexCount(int part);
	int getVertexCount(int part);
	int getTriangleCount(int part);

	int[] getIndices(int part);
	double[] getVertices(int part);
	double[] getVertexNormals(int part);
	double[] getTriangleNormals(int part);
}
