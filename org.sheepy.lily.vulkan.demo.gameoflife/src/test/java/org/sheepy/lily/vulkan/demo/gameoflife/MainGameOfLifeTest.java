package org.sheepy.lily.vulkan.demo.gameoflife;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.gameoflife.model.EngineBuilder;

public class MainGameOfLifeTest
{
	@Test
	public void main()
	{
		DebugUtil.DEBUG_ENABLED = true;
		EngineBuilder.FRAME_COUNT = 300;
		final var application = MainGameOfLife.buildApplication();
		LilyLauncher.launch(application);
	}
}
