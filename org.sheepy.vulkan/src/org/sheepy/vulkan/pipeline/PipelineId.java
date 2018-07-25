package org.sheepy.vulkan.pipeline;

public abstract class PipelineId implements IProcessUnit
{
	public final long id;

	public PipelineId(long id)
	{
		this.id = id;
	}
}