package org.sheepy.vulkan.test;

import org.sheepy.common.api.types.SVector2i;
import org.sheepy.vulkan.model.VulkanApplication;
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

	public VulkanApplication createBasicModel()
	{
		final var vulkanApplication = VulkanFactory.eINSTANCE.createVulkanApplication();

		vulkanApplication.setTitle(title);
		vulkanApplication.setSize(new SVector2i(width, height));
		vulkanApplication.setDebug(true);
		
		return vulkanApplication;
	}
}
