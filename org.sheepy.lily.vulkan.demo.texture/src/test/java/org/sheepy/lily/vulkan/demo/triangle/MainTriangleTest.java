package org.sheepy.lily.vulkan.demo.triangle;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class MainTriangleTest
{
	@Test
	public void mainTest()
	{
		TriangleEngineProvider.FRAME_COUNT = 500;
		final var application = MainTriangle.createApplication();
		LilyLauncher.launch(application);
	}
}
