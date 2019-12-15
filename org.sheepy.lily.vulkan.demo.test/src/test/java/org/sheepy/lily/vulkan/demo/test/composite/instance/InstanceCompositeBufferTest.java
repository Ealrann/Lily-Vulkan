package org.sheepy.lily.vulkan.demo.test.composite.instance;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceEngineFactory;

public class InstanceCompositeBufferTest
{
	@Test
	public void main()
	{
		InstanceEngineFactory.MAX_COUNT = 50;
		LilyLauncher.launch(MainCompositeInstanceTest.buildApplication());
	}
}
