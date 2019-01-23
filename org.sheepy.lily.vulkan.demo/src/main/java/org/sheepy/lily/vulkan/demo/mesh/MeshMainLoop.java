package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.api.util.UPSMeter;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.lily.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.model.VulkanEngine;

public class MeshMainLoop implements IMainLoop
{
	public MeshModelFactory factory;

	private IProcessAdapter processAdapter;

	private UPSMeter meter;
	private long start = 0;

	@Override
	public void load(Application application)
	{
		var graphicProcess = factory.graphicProcess;

		var engine = (VulkanEngine) application.getEngines().get(0);
		IVulkanEngineAdapter engineAdapter = IVulkanEngineAdapter.adapt(engine);

		processAdapter = IProcessAdapter.adapt(graphicProcess);
		engineAdapter.allocate();

		meter = new UPSMeter(2000);
		start = System.currentTimeMillis();
	}

	@Override
	public void step(Application application)
	{
		updateUniformBuffer();
		processAdapter.prepare();
		processAdapter.execute();
		meter.tick();
	}

	private void updateUniformBuffer()
	{
		if (factory.uniformBufferManager != null)
		{
			final long current = System.currentTimeMillis();
			final float progress = (current - start) / 1000f;

			factory.uniformBufferManager.update(progress);
		}
	}
}
