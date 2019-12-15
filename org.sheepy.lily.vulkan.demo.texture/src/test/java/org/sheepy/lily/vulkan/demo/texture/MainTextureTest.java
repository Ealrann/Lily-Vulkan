package org.sheepy.lily.vulkan.demo.texture;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class MainTextureTest
{
	@Test
	public void mainTest()
	{
		final var modelFactory = MainTexture.createFactory(500);
		LilyLauncher.launch(modelFactory.application);
	}
}
