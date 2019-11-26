package org.sheepy.lily.vulkan.demo.test.composite.grow;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.vulkan.demo.test.composite.grow.MainCompositeBufferTest.MainLoop;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.ModelFactory;

public class CompositeBufferTest
{
	@Test
	public void main()
	{
		final var factory = new ModelFactory();
		final var mainLoop = new MainLoop(factory, 50);

		LilyLauncher.launch(factory.application, mainLoop);
	}
}
