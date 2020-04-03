package org.sheepy.lily.vulkan.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.mesh.MeshEngineFactory;
import org.sheepy.lily.vulkan.demo.rotating.MainRotating;
import org.sheepy.lily.vulkan.demo.texture.MainTexture;
import org.sheepy.lily.vulkan.demo.triangle.MainTriangle;

public class MainMeta
{
	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		final var frame = new AtomicInteger(0);
		final var index = new AtomicInteger(0);
		final var application = createApplication();
		LilyLauncher.launch(application, () ->
		{
			final int currentFrame = frame.addAndGet(1);
			final int currentIndex = currentFrame / 1000 % 3;

			if (currentIndex != index.get())
			{
				index.set(currentIndex);

				switch (currentIndex)
				{
				case 0:
					setupScene(application, MainTriangle.NAME);
					break;
				case 1:
					setupScene(application, MainRotating.NAME);
					break;
				case 2:
					setupScene(application, MainTexture.NAME);
					break;
				}
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
		final var part = ApplicationFactory.eINSTANCE.createGenericScenePart();
		final var parts = application.getScene().getCompositors();

		part.setName(name);

		parts.clear();
		parts.add(part);
	}
}
