package org.sheepy.vulkan.demo.mesh;

import org.sheepy.common.api.cadence.IMainLoop;
import org.sheepy.common.api.util.UPSMeter;
import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.vulkan.api.window.IWindow;

public class MeshMainLoop implements IMainLoop
{
	public MeshModelFactory factory;

	private IVulkanEngineAdapter engineAdapter;
	private IProcessAdapter processAdapter;

	private IWindow window;

	private UPSMeter meter;
	private long start = 0;

	@Override
	public void load(Application application)
	{
		var engine = factory.engine;
		var graphicProcess = factory.graphicProcess;

		engineAdapter = IVulkanEngineAdapter.adapt(engine);
		processAdapter = IProcessAdapter.adapt(graphicProcess);

		processAdapter.allocatePart();

		meter = new UPSMeter(2000);
		start = System.currentTimeMillis();

		window = engineAdapter.getWindow();
	}

	@Override
	public void step(Application application)
	{
		updateUniformBuffer();
		engineAdapter.pollEvents();
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

	@Override
	public void dispose(Application application)
	{
		processAdapter.freePart();
	}

	@Override
	public boolean shouldClose()
	{
		return window.shouldClose();
	}

}
