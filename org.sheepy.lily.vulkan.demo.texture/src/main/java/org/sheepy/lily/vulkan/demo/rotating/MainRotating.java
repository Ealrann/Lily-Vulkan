package org.sheepy.lily.vulkan.demo.rotating;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.mesh.MeshEngineFactory;

public class MainRotating
{
	public static final String NAME = "Vulkan Rotating Triangle";

	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;
		final var application = createApplication();
		LilyLauncher.launch(application);
	}

	public static Application createApplication()
	{
		final var application = ApplicationFactory.eINSTANCE.createApplication();
		final var scene = ApplicationFactory.eINSTANCE.createScene();
		final var part = ApplicationFactory.eINSTANCE.createGenericScenePart();

		part.setName(NAME);

		scene.setSize(new Vector2i(800, 600));
		scene.getCompositors().add(part);

		application.setTitle(NAME);
		application.getEngines().add(MeshEngineFactory.build());
		application.setScene(scene);

		return application;
	}
}
