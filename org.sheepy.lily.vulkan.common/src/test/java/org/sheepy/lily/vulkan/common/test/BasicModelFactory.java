package org.sheepy.lily.vulkan.common.test;

import org.joml.Vector2i;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;

public class BasicModelFactory
{
	public static String TITLE = "Vulkan Test Application";
	public static int WIDTH = 400;
	public static int HEIGHT = 400;

	private final String title;
	private final int width;
	private final int height;

	public BasicModelFactory()
	{
		this(TITLE, WIDTH, HEIGHT);
	}

	public BasicModelFactory(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
	}

	public Application createBasicModel()
	{
		final var application = ApplicationFactory.eINSTANCE.createApplication();

		application.setTitle(title);
		application.setSize(new Vector2i(width, height));

		return application;
	}
}
