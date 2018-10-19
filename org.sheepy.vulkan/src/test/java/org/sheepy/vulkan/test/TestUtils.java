package org.sheepy.vulkan.test;

import org.sheepy.vulkan.model.VulkanApplication;

public class TestUtils
{
	public static final BasicModelFactory modelfactory = new BasicModelFactory();

	public static VulkanApplication newBasicApplication()
	{
		return modelfactory.createBasicModel();
	}
}
