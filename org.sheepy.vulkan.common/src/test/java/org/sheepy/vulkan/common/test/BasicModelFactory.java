package org.sheepy.vulkan.common.test;

import org.sheepy.common.api.types.SVector2i;
import org.sheepy.common.model.application.Application;
import org.sheepy.common.model.application.ApplicationFactory;
import org.sheepy.vulkan.model.VulkanFactory;

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
		application.setSize(new SVector2i(width, height));
		application.setDebug(true);

		application.getEngines().add(VulkanFactory.eINSTANCE.createVulkanEngine());

		return application;
	}
}
