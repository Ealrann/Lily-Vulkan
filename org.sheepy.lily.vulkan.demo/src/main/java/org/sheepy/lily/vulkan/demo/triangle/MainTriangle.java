package org.sheepy.lily.vulkan.demo.triangle;

import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;

public class MainTriangle
{
	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		MeshAdapter.meshBuilder = new TriangleMeshBuilder();

		final var meshConfiguration = new MeshConfiguration();
		final var modelFactory = new MeshModelFactory(meshConfiguration);

		final MeshMainLoop mainLoop = new MeshMainLoop(modelFactory);

		ApplicationLauncher.launch(modelFactory.application, mainLoop);
	}
}
