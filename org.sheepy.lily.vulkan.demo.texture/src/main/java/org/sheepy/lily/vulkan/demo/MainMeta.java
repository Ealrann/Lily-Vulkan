package org.sheepy.lily.vulkan.demo;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.mesh.MeshEngineFactory;
import org.sheepy.lily.vulkan.demo.rotating.MainRotating;
import org.sheepy.lily.vulkan.demo.texture.MainTexture;
import org.sheepy.lily.vulkan.demo.triangle.MainTriangle;

import java.util.concurrent.atomic.AtomicInteger;

public class MainMeta
{
	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		final var frame = new AtomicInteger(0);
		final var index = new AtomicInteger(0);
		final var application = createApplication();
		LilyLauncher.launch(application, () -> {
			final int currentFrame = frame.addAndGet(1);
			final int currentIndex = currentFrame / 1000 % 3;

			if (currentIndex != index.get())
			{
				index.set(currentIndex);
				final String name = switch (currentIndex)
						{
							case 0 -> MainTriangle.NAME;
							case 1 -> MainRotating.NAME;
							default -> MainTexture.NAME;
						};
				setupScene(application, name);
			}
		});
	}

	public static Application createApplication()
	{
		final var application = ApplicationFactory.eINSTANCE.createApplication();
		final var scene = ApplicationFactory.eINSTANCE.createScene();

		scene.setSize(new Vector2i(800, 600));

		application.setTitle("Vulkan Meta Test");
		application.getEngines().add(MeshEngineFactory.build());
		application.setScene(scene);

		setupScene(application, MainTriangle.NAME);

		return application;
	}

	public static void setupScene(final Application application, String name)
	{
		final var parts = application.getScene().getCompositors();
		final var part = ApplicationFactory.eINSTANCE.createGenericScenePart();
		part.setName(name);

		parts.clear();
		parts.add(part);
	}
}
