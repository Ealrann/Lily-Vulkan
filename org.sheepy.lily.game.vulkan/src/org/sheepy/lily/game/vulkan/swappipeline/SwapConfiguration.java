package org.sheepy.lily.game.vulkan.swappipeline;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.lily.game.vulkan.pipeline.IVertexDescriptor;
import org.sheepy.lily.game.vulkan.pipeline.impl.VertexDescriptor;

public class SwapConfiguration
{
	public int rasterizerCullMode = VK_CULL_MODE_BACK_BIT;
	public int rasterizerFrontFace = VK_FRONT_FACE_CLOCKWISE;
	
	public boolean depthBuffer = false;
	
	private IVertexDescriptor<?> vertexInputState = null;
	
	public IVertexDescriptor<?> getVertexInputState()
	{
		if(vertexInputState == null)
			vertexInputState = new VertexDescriptor();
		
		return vertexInputState;
	}
	
	public void setVertexInputState(IVertexDescriptor<?> vertexInputState)
	{
		this.vertexInputState = vertexInputState;
	}
}
