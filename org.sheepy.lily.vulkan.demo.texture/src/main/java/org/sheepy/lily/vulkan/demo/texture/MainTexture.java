package org.sheepy.lily.vulkan.demo.texture;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.presentation.PresentationFactory;

public class MainTexture
{
	public static final String NAME = "Vulkan Texture";

	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;
		final var application = createApplication();
		LilyLauncher.launch(application);
	}

	static Application createApplication()
	{
		final Application application = ApplicationFactory.eINSTANCE.createApplication();

		final var size = new Vector2i(800, 600);

		application.setTitle("Vulkan Demo");
		application.setSize(size);

		final var view = PresentationFactory.eINSTANCE.createGenericView();
		view.setName(NAME);
		application.setView(view);

		return application;
	}
}
