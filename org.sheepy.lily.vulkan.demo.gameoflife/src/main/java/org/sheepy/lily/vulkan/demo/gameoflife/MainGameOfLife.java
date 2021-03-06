package org.sheepy.lily.vulkan.demo.gameoflife;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.gameoflife.model.EngineBuilder;

public class MainGameOfLife
{
	public static final String NAME = "Vulkan - Game of Life";

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static void main(String[] args)
	{
		DebugUtil.parseMainArgs(args);
		DebugUtil.DEBUG_ENABLED = true;

		final Application application = buildApplication(0);

		LilyLauncher.launch(application);
	}

	public static Application buildApplication(int frameCount)
	{
		EngineBuilder.FRAME_COUNT = frameCount;
		final var size = new Vector2i(WIDTH, HEIGHT);
		final var application = ApplicationFactory.eINSTANCE.createApplication();
		final var scene = ApplicationFactory.eINSTANCE.createScene();
		final var background = ApplicationFactory.eINSTANCE.createBackgroundImage();
		final var engineBuilder = new EngineBuilder(size);

		background.setSrcImage(engineBuilder.boardImage);
		background.setDstImage(engineBuilder.colorAttachment);

		scene.setSize(size);
		scene.getCompositors().add(background);

		application.setTitle(NAME);
		application.getEngines().add(engineBuilder.build());
		application.setScene(scene);

		return application;
	}
}
