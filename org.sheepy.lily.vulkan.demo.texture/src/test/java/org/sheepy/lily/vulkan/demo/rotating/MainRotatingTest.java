package org.sheepy.lily.vulkan.demo.rotating;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class MainRotatingTest
{
	@Test
	public void mainTest()
	{
		final var modelFactory = MainRotating.createFactory(500);
		LilyLauncher.launch(modelFactory.application);
	}
}
