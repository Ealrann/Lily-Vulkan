package org.sheepy.vulkan.pipeline;

import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.pipeline.compute.IComputeProcessUnit;

public abstract class PipelineBarrier
		implements IAllocable, IComputeProcessUnit, IProcessUnit, IPipelineUnit, IPipelineExecutable
{

}
