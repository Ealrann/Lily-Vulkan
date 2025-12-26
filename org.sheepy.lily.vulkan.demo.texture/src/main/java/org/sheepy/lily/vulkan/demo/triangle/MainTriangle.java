package org.sheepy.lily.vulkan.demo.triangle;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.Scene;
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

	public static Application createApplication()
	{
		final var part = GenericScenePart.builder().name(NAME).build();
		final var scene = Scene.builder()
							   .size(new Vector2i(800, 600))
							   .addCompositor(() -> part)
							   .build();

		return Application.builder()
						  .title(NAME)
						  .addEngine(MeshEngineFactory::build)
						  .scene(() -> scene)
						  .build();
	}
}
