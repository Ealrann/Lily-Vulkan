package org.sheepy.lily.vulkan.demo.test.composite.grow;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class CompositeBufferTest
{
	@Test
	public void main()
	{
		MainCompositeBufferTest.MAX_COUNT = 50;
		LilyLauncher.launch(MainCompositeBufferTest.FACTORY.application);
	}
}
