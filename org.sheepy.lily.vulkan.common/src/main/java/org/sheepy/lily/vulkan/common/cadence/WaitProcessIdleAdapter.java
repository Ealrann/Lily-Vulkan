package org.sheepy.lily.vulkan.common.cadence;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.ICadenceContext;
import org.sheepy.lily.core.api.cadence.ICadenceTaskAdapter;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.model.WaitProcessIdle;

@Adapter(scope = WaitProcessIdle.class)
public class WaitProcessIdleAdapter implements ICadenceTaskAdapter
{

	@Override
	public void execute(ICadenceTask task, ICadenceContext context)
	{
		final var runProcess = (WaitProcessIdle) task;
		final var processAdapter = runProcess.getProcess().adapt(IProcessAdapter.class);

		processAdapter.getQueue().waitIdle();
	}
}
