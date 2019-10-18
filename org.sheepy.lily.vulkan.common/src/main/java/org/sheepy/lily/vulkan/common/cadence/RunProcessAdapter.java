package org.sheepy.lily.vulkan.common.cadence;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.model.RunProcess;

@Adapter(scope = RunProcess.class)
public final class RunProcessAdapter implements ICadenceTaskAdapter
{
	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		final var runProcess = (RunProcess) task;
		final var processAdapter = runProcess.getProcess().adaptNotNull(IProcessAdapter.class);

		processAdapter.run();
	}
}
