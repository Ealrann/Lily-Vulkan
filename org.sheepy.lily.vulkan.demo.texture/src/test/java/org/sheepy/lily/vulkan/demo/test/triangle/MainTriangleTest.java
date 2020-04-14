package org.sheepy.lily.vulkan.demo.test.triangle;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.vulkan.demo.triangle.MainTriangle;

public class MainTriangleTest
{
	@Test
	public void mainTest()
	{
		final var count = new AtomicInteger(0);
		final var application = MainTriangle.createApplication();
		LilyLauncher.launch(application, () -> 
		{
			if(count.addAndGet(1) >= 500)
			{
				application.setRun(false);
			}
		});
	}
}
