package org.sheepy.lily.vulkan.demo.gameoflife;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.presentation.PresentationFactory;

public class MainGameOfLife
{
	public static final String VIEW_NAME = "Vulkan - Game of Life";

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		final Application application = buildApplication();

		LilyLauncher.launch(application);
	}

	public static Application buildApplication()
	{
		final Application application = ApplicationFactory.eINSTANCE.createApplication();
		application.setTitle(VIEW_NAME);
		application.setSize(new Vector2i(WIDTH, HEIGHT));

		final var view = PresentationFactory.eINSTANCE.createGenericView();
		view.setName(VIEW_NAME);
		application.setView(view);

		return application;
	}
}
