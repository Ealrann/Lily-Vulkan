package org.sheepy.lily.vulkan.demo.test.texture;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.texture.MainTexture;

public class MainTextureTest
{
	@Test
	public void mainTest()
	{
		DebugUtil.DEBUG_VERBOSE_ENABLED = true;
		DebugUtil.DEBUG_ENABLED = true;

		final var count = new AtomicInteger(0);
		final var application = MainTexture.createApplication();
		LilyLauncher.launch(application, () -> 
		{
			if(count.addAndGet(1) >= 500)
			{
				application.run(false);
			}
		});
	}
}
