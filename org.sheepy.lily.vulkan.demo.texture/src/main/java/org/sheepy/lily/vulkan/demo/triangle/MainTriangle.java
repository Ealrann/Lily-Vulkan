package org.sheepy.lily.vulkan.demo.triangle;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;

public class MainTriangle
{
	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		final var modelFactory = createFactory();

		final MeshMainLoop mainLoop = new MeshMainLoop(modelFactory);

		LilyLauncher.launch(modelFactory.application, mainLoop);
	}

	static MeshModelFactory createFactory()
	{
		final var meshBuilder = new TriangleMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder);
		return new MeshModelFactory(meshConfiguration);
	}
}
