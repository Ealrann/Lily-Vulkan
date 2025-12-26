package org.sheepy.lily.vulkan.demo;

import org.joml.Vector2i;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.vulkan.demo.mesh.MeshEngineFactory;
import org.sheepy.lily.vulkan.demo.rotating.MainRotating;
import org.sheepy.lily.vulkan.demo.texture.MainTexture;
import org.sheepy.lily.vulkan.demo.triangle.MainTriangle;

import java.util.concurrent.atomic.AtomicInteger;

public class MainMeta
{
	public static void main(String[] args)
	{
		DebugUtil.parseMainArgs(args);

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
		final var part = GenericScenePart.builder().name(MainTriangle.NAME).build();
		final var scene = Scene.builder()
							   .size(new Vector2i(800, 600))
							   .addCompositor(() -> part)
							   .build();
		final var application = Application.builder()
											   .title("Vulkan Meta Test")
											   .addEngine(MeshEngineFactory::build)
											   .scene(() -> scene)
											   .build();

		return application;
	}

	public static void setupScene(final Application application, String name)
	{
		final var parts = application.scene().compositors();
		final var part = GenericScenePart.builder().name(name).build();

		parts.clear();
		parts.add(part);
	}
}
