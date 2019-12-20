package org.sheepy.lily.vulkan.demo.triangle;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.mesh.MeshEngineFactory;

public class MainTriangle
{
	public static final String NAME = "Vulkan Triangle";

	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;
		final var application = createApplication();
		LilyLauncher.launch(application);
	}

	static Application createApplication()
	{
		final var application = ApplicationFactory.eINSTANCE.createApplication();
		final var scene = ApplicationFactory.eINSTANCE.createScene();
		final var part = ApplicationFactory.eINSTANCE.createGenericScenePart();

		part.setName(NAME);

		scene.setSize(new Vector2i(800, 600));
		scene.getParts().add(part);

		application.setTitle(NAME);
		application.getEngines().add(MeshEngineFactory.build());
		application.setScene(scene);

		return application;
	}
}
