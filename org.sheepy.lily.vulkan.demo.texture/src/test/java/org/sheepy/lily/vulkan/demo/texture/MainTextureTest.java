package org.sheepy.lily.vulkan.demo.texture;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class MainTextureTest
{
	@Test
	public void mainTest()
	{
		TextureEngineProvider.FRAME_COUNT = 500;
		final var application = MainTexture.createApplication();
		LilyLauncher.launch(application);
	}
}
