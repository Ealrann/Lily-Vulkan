package org.sheepy.lily.vulkan.process.cadence;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.vulkan.model.process.SwapBindingsTask;

@Statefull
@Adapter(scope = SwapBindingsTask.class)
public class SwapBindingsTaskAdapter implements ICadenceTaskAdapter
{
	private int current = -1;

	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		final var swapTask = (SwapBindingsTask) task;
		final var bindTask = swapTask.getTask();
		final var descriptorSets = swapTask.getDescriptorSets();

		current = (current + 1) % descriptorSets.size();

		bindTask.getDescriptorSets().clear();
		bindTask.getDescriptorSets().add(descriptorSets.get(current));
	}
}
