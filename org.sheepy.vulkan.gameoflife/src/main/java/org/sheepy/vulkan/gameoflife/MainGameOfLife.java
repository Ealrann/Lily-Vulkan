package org.sheepy.vulkan.gameoflife;

import org.sheepy.common.api.application.ApplicationLauncher;
import org.sheepy.common.api.cadence.IMainLoop;
import org.sheepy.vulkan.gameoflife.model.ModelFactory;

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
