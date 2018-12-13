package org.sheepy.vulkan.common.window;

import static org.junit.jupiter.api.Assertions.*;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;

import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.common.application.VulkanApplicationUtil;

public class WindowTestUtil
{
	public static void checkWindowSize(	Application application,
										int expectedWidth,
										int expectedHeight)
	{
		var window = VulkanApplicationUtil.getWindow(application);

		if (window == null)
		{
			fail("No window");
		}

		int[] width = new int[1];
		int[] height = new int[1];

		glfwGetWindowSize(window.getId(), width, height);

		assertEquals(expectedWidth, width[0]);
		assertEquals(expectedHeight, height[0]);
	}
}
