package org.sheepy.lily.vulkan.demo.test.composite.test.grow;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.vulkan.demo.test.composite.grow.MainCompositeBufferTest;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.GrowEngineFactory;

public class CompositeBufferTest
{
	@Test
	public void main()
	{
		GrowEngineFactory.MAX_COUNT = 8;
		LilyLauncher.launch(MainCompositeBufferTest.buildApplication());
	}
}
