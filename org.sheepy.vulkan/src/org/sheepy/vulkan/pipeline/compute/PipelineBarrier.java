package org.sheepy.vulkan.pipeline.compute;

import org.sheepy.vulkan.buffer.Buffer;
import org.sheepy.vulkan.pipeline.compute.ComputePipeline.IComputePipelineExecutableUnit;

public class PipelineBarrier implements IComputeProcessUnit, IComputePipelineUnit, IComputePipelineExecutableUnit
{
	private Buffer buffer;
	private int srcAccessMask;
	private int dstAccessMask;

	public PipelineBarrier(Buffer buffer, int srcAccessMask, int dstAccessMask)
	{
		this.buffer = buffer;
		this.srcAccessMask = srcAccessMask;
		this.dstAccessMask = dstAccessMask;
	}

	public Buffer getBuffer()
	{
		return buffer;
	}

	public int getSrcAccessMask()
	{
		return srcAccessMask;
	}

	public int getDstAccessMask()
	{
		return dstAccessMask;
	}
}
