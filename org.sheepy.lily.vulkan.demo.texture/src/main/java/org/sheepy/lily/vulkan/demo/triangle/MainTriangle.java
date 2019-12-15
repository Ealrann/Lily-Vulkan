package org.sheepy.lily.vulkan.demo.triangle;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;

public class MainTriangle
{
	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		final var modelFactory = createFactory(0);

		LilyLauncher.launch(modelFactory.application);
	}

	static MeshModelFactory createFactory(int frameCount)
	{
		final var meshBuilder = new TriangleMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder);
		meshConfiguration.frameCount = frameCount;
		return new MeshModelFactory(meshConfiguration);
	}
}
