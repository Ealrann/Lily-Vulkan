package org.sheepy.lily.vulkan.demo.gameoflife;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.gameoflife.model.ModelFactory;

public class MainGameOfLife
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		final var factory = new ModelFactory(WIDTH, HEIGHT);

		LilyLauncher.launch(factory.application);
	}
}
