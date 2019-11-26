package org.sheepy.lily.vulkan.demo.test.composite.instance;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.vulkan.demo.test.composite.instance.MainCompositeInstanceTest.MainLoop;
import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceModelFactory;

public class InstanceCompositeBufferTest
{
	@Test
	public void main()
	{
		final var factory = new InstanceModelFactory();
		final var mainLoop = new MainLoop(factory, 50);

		LilyLauncher.launch(factory.application, mainLoop);
	}
}
