package org.sheepy.lily.vulkan.core.cadence;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.model.WaitProcessIdle;

@ModelExtender(scope = WaitProcessIdle.class)
@Adapter(singleton = true)
public final class WaitProcessIdleAdapter implements ICadenceTaskAdapter
{
	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		final var runProcess = (WaitProcessIdle) task;
		final var processAdapter = runProcess.getProcess().adapt(IProcessAdapter.class);

		processAdapter.waitIdle();
	}
}
