package org.sheepy.lily.vulkan.demo.rotating;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.lily.vulkan.demo.mesh.TestLoop;

public class MainRotatingTest
{
	@Test
	public void mainTest()
	{
		final var modelFactory = MainRotating.createFactory();

		final MeshMainLoop mainLoop = new TestLoop(modelFactory, 500);
		LilyLauncher.launch(modelFactory.application, mainLoop);
	}
}
