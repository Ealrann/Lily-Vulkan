package org.sheepy.lily.vulkan.demo.gameoflife;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.gameoflife.model.ModelFactory;

public class MainGameOfLifeTest
{
	@Test
	public void main()
	{
		DebugUtil.DEBUG_ENABLED = true;
		final var factory = new ModelFactory(MainGameOfLife.WIDTH, MainGameOfLife.HEIGHT, 300);
		LilyLauncher.launch(factory.application);
	}
}
