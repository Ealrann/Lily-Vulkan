package org.sheepy.lily.vulkan.gameoflife;

import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.vulkan.gameoflife.model.ModelFactory;

public class MainGameOfLife
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static void main(String[] args)
	{
		ModelFactory factory = new ModelFactory(WIDTH, HEIGHT);
		((MainLoop) IMainLoop.INSTANCE).factory = factory;
		ApplicationLauncher.launch(factory.application);
	}
}
