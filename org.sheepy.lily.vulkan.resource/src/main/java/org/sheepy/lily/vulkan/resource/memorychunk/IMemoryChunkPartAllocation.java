package org.sheepy.lily.vulkan.resource.memorychunk;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.notification.Feature;
import org.sheepy.lily.core.api.notification.IFeatures;
import org.sheepy.lily.core.api.notification.INotifier;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.FillCommand;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface IMemoryChunkPartAllocation extends IExtender, INotifier<IMemoryChunkPartAllocation.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Runnable, Features> PushRequest = Feature.newFeature();
		Feature<Runnable, Features> Obsolete = Feature.newFeature();
		Feature<Consumer<IRecordContext>, Features> Attach = Feature.newFeature();

		List<Feature<?, Features>> Values = List.of(PushRequest, Obsolete, Attach);
	}

	void registerMemory(MemoryBuilder memoryBuilder);

	Stream<FillCommand> streamFillCommands(boolean force);
}
