package org.sheepy.lily.vulkan.resource.memorychunk;

import org.logoce.extender.api.IAdapter;
import org.sheepy.lily.vulkan.core.resource.util.FillCommand;

import java.util.stream.Stream;

public interface IMemoryChunkPartAllocation extends IAdapter
{
	Stream<FillCommand> streamFillCommands(boolean force);
}
