package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.core.util.FillCommand;

import java.util.stream.Stream;

public interface IMemoryChunkPartAllocation extends IExtender
{
	Stream<FillCommand> streamFillCommands(boolean force);
}
