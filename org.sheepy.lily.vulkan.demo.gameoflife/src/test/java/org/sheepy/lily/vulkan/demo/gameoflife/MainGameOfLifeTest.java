package org.sheepy.lily.vulkan.demo.gameoflife;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.gameoflife.model.ModelFactory;

public class MainGameOfLifeTest
{
	@Test
	public void main()
	{
		DebugUtil.DEBUG_ENABLED = true;

		final ModelFactory factory = new ModelFactory(MainGameOfLife.WIDTH, MainGameOfLife.HEIGHT);
		final MainLoopTest mainLoop = new MainLoopTest(factory, 300);
		ApplicationLauncher.launch(factory.application, mainLoop);
	}
}
