package org.sheepy.lily.vulkan.demo.test.composite.grow;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.GrowEngineFactory;

public class MainCompositeBufferTest
{
	public static final String NAME = "Vulkan - CompositeBuffer test";

	public static void main(String[] args)
	{
		final Application application = buildApplication();
		LilyLauncher.launch(application);
	}

	public static Application buildApplication()
	{
		final Application application = ApplicationFactory.eINSTANCE.createApplication();
		application.setTitle(NAME);
		application.getEngines().add(GrowEngineFactory.build());

		return application;
	}
}
