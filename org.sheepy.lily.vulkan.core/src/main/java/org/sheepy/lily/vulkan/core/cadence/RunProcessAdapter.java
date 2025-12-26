package org.sheepy.lily.vulkan.core.cadence;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.model.vulkan.RunProcess;

@ModelExtender(scope = RunProcess.class)
@Adapter(singleton = true)
public final class RunProcessAdapter implements ICadenceTaskAdapter
{
	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		final var runProcess = (RunProcess) task;
		final var processAdapter = runProcess.process().adaptNotNull(IProcessAdapter.class);

		processAdapter.run();
	}
}
