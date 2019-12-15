package org.sheepy.lily.vulkan.demo.rotating;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class MainRotatingTest
{
	@Test
	public void mainTest()
	{
		RotatingEngineProvider.FRAME_COUNT = 500;
		final var application = MainRotating.createApplication();
		LilyLauncher.launch(application);
	}
}
