package org.sheepy.lily.vulkan.common.engine.utils;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.vulkan.common.process.IExecutionProcessAdapter;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.queue.EQueueType;

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
			final var adapter = process.adaptNotNull(IExecutionProcessAdapter.class);
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
