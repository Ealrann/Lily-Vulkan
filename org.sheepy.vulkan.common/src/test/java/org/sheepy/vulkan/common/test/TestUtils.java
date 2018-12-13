package org.sheepy.vulkan.common.test;

import org.sheepy.common.model.application.Application;

public class TestUtils
{
	public static final BasicModelFactory modelfactory = new BasicModelFactory();

	public static Application newBasicApplication()
	{
		return modelfactory.createBasicModel();
	}
}
