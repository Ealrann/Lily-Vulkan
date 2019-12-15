package org.sheepy.lily.vulkan.demo.test.composite.instance;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.api.LilyLauncher;

public class InstanceCompositeBufferTest
{
	@Test
	public void main()
	{
		MainCompositeInstanceTest.MAX_COUNT = 50;
		LilyLauncher.launch(MainCompositeInstanceTest.FACTORY.application);
	}
}
