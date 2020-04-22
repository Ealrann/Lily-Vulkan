package org.sheepy.lily.vulkan.demo.test.composite.instance;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceEngineFactory;

public class MainCompositeInstanceTest
{
	public static final String NAME = "Vulkan - CompositeInstanceBuffer test";

	public static void main(String[] args)
	{
		DebugUtil.parseMainArgs(args);
		final Application application = buildApplication();
		LilyLauncher.launch(application);
	}

	public static Application buildApplication()
	{
		final Application application = ApplicationFactory.eINSTANCE.createApplication();
		application.setTitle(NAME);
		application.getEngines().add(InstanceEngineFactory.build());

		return application;
	}
}
