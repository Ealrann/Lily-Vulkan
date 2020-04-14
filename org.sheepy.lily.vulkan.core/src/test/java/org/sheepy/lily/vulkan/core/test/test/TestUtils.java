package org.sheepy.lily.vulkan.core.test.test;

import org.sheepy.lily.core.model.application.Application;

public class TestUtils
{
	public static final BasicModelFactory modelfactory = new BasicModelFactory();

	public static Application newBasicApplication()
	{
		return modelfactory.createBasicModel();
	}
}
