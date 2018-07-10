package org.sheepy.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.KHRSurface.*;
import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.vulkan.pipeline.swap.graphic.IVertexDescriptor;
import org.sheepy.vulkan.pipeline.swap.graphic.graphic.impl.VertexDescriptor;
import org.sheepy.vulkan.swapchain.ColorDomain;

public class SwapConfiguration
{
	public final ColorDomain colorDomain;
	
	public SwapConfiguration()
	{
		this(VK_FORMAT_B8G8R8A8_UNORM, VK_COLOR_SPACE_SRGB_NONLINEAR_KHR);
	}
	
	public SwapConfiguration(int imageFormat, int colorSpace)
	{
		this.colorDomain = new ColorDomain(imageFormat, colorSpace);
	}
	public int presentationMode = VK_PRESENT_MODE_MAILBOX_KHR;
	
	public int rasterizerCullMode = VK_CULL_MODE_BACK_BIT;
	public int rasterizerFrontFace = VK_FRONT_FACE_CLOCKWISE;
	
	public int swapImageUsages = VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT;
	
	/** true if the graphic pipeline should activate a render pass during command recording **/
	public boolean renderPipeline = true;
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
