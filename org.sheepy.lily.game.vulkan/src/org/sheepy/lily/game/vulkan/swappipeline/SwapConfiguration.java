package org.sheepy.lily.game.vulkan.swappipeline;

import static org.lwjgl.vulkan.VK10.*;

public class SwapConfiguration
{
	public int rasterizerCullMode = VK_CULL_MODE_BACK_BIT;
	public int rasterizerFrontFace = VK_FRONT_FACE_CLOCKWISE;
}
