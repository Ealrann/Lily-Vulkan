package org.sheepy.vulkan.demo.triangle;

import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.api.cadence.IMainLoop;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.vulkan.demo.mesh.MeshModelFactory;

public class MainTriangle
{
	public static void main(String[] args)
	{
		MeshAdapter.meshBuilder = new TriangleMeshBuilder();

		final var meshConfiguration = new MeshConfiguration();
		final var modelFactory = new MeshModelFactory(meshConfiguration);

		((MeshMainLoop) IMainLoop.INSTANCE).factory = modelFactory;

		ICadencer.INSTANCE.start(modelFactory.application);
	}
}
