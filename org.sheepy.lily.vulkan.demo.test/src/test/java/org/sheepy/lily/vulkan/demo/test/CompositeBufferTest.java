package org.sheepy.lily.vulkan.demo.test;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.vulkan.demo.test.MainCompositeBufferTest.MainLoop;
import org.sheepy.lily.vulkan.demo.test.model.ModelFactory;

public class CompositeBufferTest
{
	@Test
	public void main()
	{
		final var factory = new ModelFactory();
		final var mainLoop = new MainLoop(factory);

		LilyLauncher.launch(factory.application, mainLoop);
	}
}
