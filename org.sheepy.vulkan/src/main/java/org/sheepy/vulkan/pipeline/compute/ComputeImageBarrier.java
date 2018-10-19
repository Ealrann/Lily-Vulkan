//package org.sheepy.vulkan.pipeline.compute;
//
//import static org.lwjgl.vulkan.VK10.VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT;
//
//import org.sheepy.vulkan.buffer.Image;
//import org.sheepy.vulkan.buffer.ImageBarrier;
//
//public class ComputeImageBarrier extends ImageBarrier
//{
//	public ComputeImageBarrier(Image image, int srcLayout, int dstLayout, int srcAccess, int dstAccess)
//	{
//		super(VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT, VK_PIPELINE_STAGE_COMPUTE_SHADER_BIT);
//		addImageBarrier(image, srcLayout, dstLayout, srcAccess, dstAccess);
//	}
//}
