package org.sheepy.lily.vulkan.demo.triangle;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.lily.vulkan.demo.mesh.TestLoop;

public class MainTriangleTest
{
	@Test
	public void mainTest()
	{
		final var modelFactory = MainTriangle.createFactory();

		final MeshMainLoop mainLoop = new TestLoop(modelFactory, 500);
		ApplicationLauncher.launch(modelFactory.application, mainLoop);
	}
}
