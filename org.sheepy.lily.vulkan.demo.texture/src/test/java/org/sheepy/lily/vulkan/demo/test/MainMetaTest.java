package org.sheepy.lily.vulkan.demo.test;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.MainMeta;
import org.sheepy.lily.vulkan.demo.rotating.MainRotating;
import org.sheepy.lily.vulkan.demo.texture.MainTexture;
import org.sheepy.lily.vulkan.demo.triangle.MainTriangle;

public class MainMetaTest
{
	@Test
	public void mainTest()
	{
		DebugUtil.DEBUG_ENABLED = true;

		final var frame = new AtomicInteger(0);
		final var index = new AtomicInteger(0);
		final var application = MainMeta.createApplication();
		LilyLauncher.launch(application, () ->
		{
			final int currentFrame = frame.addAndGet(1);
			final int currentIndex = currentFrame / 500 % 4;

			if (currentIndex != index.get())
			{
				index.set(currentIndex);

				switch (currentIndex)
				{
				case 0:
					MainMeta.setupScene(application, MainTriangle.NAME);
					break;
				case 1:
					MainMeta.setupScene(application, MainRotating.NAME);
					break;
				case 2:
					MainMeta.setupScene(application, MainTexture.NAME);
					break;
				case 3:
					application.setRun(false);
					break;
				}
			}
		});
	}
}
