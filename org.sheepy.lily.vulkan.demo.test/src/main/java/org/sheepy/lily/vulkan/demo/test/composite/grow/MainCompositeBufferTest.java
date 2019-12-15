package org.sheepy.lily.vulkan.demo.test.composite.grow;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.presentation.PresentationFactory;

public class MainCompositeBufferTest
{
	public static final String VIEW_NAME = "Vulkan - CompositeBuffer test";

	public static void main(String[] args)
	{
		final Application application = buildApplication();
		LilyLauncher.launch(application);
	}

	public static Application buildApplication()
	{
		final Application application = ApplicationFactory.eINSTANCE.createApplication();
		application.setTitle(VIEW_NAME);
		application.setHeadless(true);

		final var view = PresentationFactory.eINSTANCE.createGenericView();
		view.setName(VIEW_NAME);
		application.setView(view);

		return application;
	}
}
