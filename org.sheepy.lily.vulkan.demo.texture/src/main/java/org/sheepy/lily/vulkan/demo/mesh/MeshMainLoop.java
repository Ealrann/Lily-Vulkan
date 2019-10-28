package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.api.util.UPSMeter;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;

public class MeshMainLoop implements IMainLoop
{
	public MeshModelFactory factory;

	private IProcessAdapter processAdapter;

	private UPSMeter meter;

	public MeshMainLoop(MeshModelFactory factory)
	{
		this.factory = factory;
	}

	@Override
	public void load(Application application)
	{
		final var graphicProcess = factory.graphicProcess;

		processAdapter = graphicProcess.adaptNotNull(IProcessAdapter.class);

		meter = new UPSMeter(2000);
	}

	@Override
	public void step(Application application)
	{
		processAdapter.run();
		meter.tick();
	}

	@Override
	public void free(Application application)
	{}
}
