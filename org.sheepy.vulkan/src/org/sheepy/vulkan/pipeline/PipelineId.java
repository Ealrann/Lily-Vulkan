package org.sheepy.vulkan.pipeline;


public abstract class PipelineId implements IPipelineExecutable
{
	public final long id;

	public PipelineId(long id)
	{
		this.id = id;
	}
}