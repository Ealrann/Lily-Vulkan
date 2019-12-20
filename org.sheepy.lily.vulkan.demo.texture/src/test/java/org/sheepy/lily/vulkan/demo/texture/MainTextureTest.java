package org.sheepy.lily.vulkan.demo.texture;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class MainTextureTest
{
	@Test
	public void mainTest()
	{
		final var count = new AtomicInteger(0);
		final var application = MainTexture.createApplication();
		LilyLauncher.launch(application, () -> 
		{
			if(count.addAndGet(1) >= 500)
			{
				application.setRun(false);
			}
		});
	}
}
