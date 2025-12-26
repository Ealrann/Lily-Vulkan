package org.sheepy.lily.vulkan.demo.gameoflife.test;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.gameoflife.MainGameOfLife;

public class MainGameOfLifeTest
{
	@Test
	public void main()
	{
		DebugUtil.DEBUG_ENABLED = true;
		final var application = MainGameOfLife.buildApplication(300);
		LilyLauncher.launch(application);
	}
}
