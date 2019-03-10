package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.api.util.UPSMeter;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.adapter.IProcessAdapter;

public class MeshMainLoop implements IMainLoop
{
	public MeshModelFactory factory;

	private IProcessAdapter processAdapter;

	private UPSMeter meter;
	private long start = 0;

	public MeshMainLoop(MeshModelFactory factory)
	{
		this.factory = factory;
	}

	@Override
	public void load(Application application)
	{
		var graphicProcess = factory.graphicProcess;

		factory.engine.setEnabled(true);
		processAdapter = IProcessAdapter.adapt(graphicProcess);

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

	@Override
	public void free(Application application)
	{}

	private void updateUniformBuffer()
	{
		if (factory.uniformBufferManager != null)
		{
			final long current = System.currentTimeMillis();
			final float progress = factory.rotationSpeed * (current - start) / 1000f;

			factory.uniformBufferManager.update(progress);
		}
	}
}
