package org.sheepy.lily.vulkan.demo.triangle;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class MainTriangleTest
{
	@Test
	public void mainTest()
	{
		final var modelFactory = MainTriangle.createFactory(500);
		LilyLauncher.launch(modelFactory.application);
	}
}
