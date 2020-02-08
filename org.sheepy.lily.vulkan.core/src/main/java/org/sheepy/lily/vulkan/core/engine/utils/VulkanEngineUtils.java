package org.sheepy.lily.vulkan.core.engine.utils;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.VulkanEngine;

public final class VulkanEngineUtils
{
	private VulkanEngineUtils()
	{}

	public static List<EQueueType> generateQueueList(VulkanEngine engine)
	{
		final List<EQueueType> res = new ArrayList<>();
		boolean needPresent = false;

		for (final var process : engine.getProcesses())
		{
			final var adapter = process.adaptNotNull(InternalProcessAdapter.class);
			res.add(adapter.getExecutionQueueType());
			needPresent |= adapter.needPresentQueue();
		}

		if (needPresent)
		{
			res.add(EQueueType.Present);
		}

		return res;
	}
}
