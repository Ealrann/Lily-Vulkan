package org.sheepy.vulkan.demo.triangle;

import org.sheepy.common.api.application.ApplicationLauncher;
import org.sheepy.common.api.util.UPSMeter;
import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;

public class MainTriangle
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private Application application;
	private VulkanEngine engine;
	private GraphicProcess graphicProcess;

	public static void main(String[] args)
	{
		final MainTriangle mainTriangle = new MainTriangle();
		mainTriangle.launch();
	}

	public MainTriangle()
	{
		MeshAdapter.meshBuilder = new TriangleMeshBuilder();
	}

	public void launch()
	{
		buildApplication();

		ApplicationLauncher.launch(application);
		final var engineAdapter = IVulkanEngineAdapter.adapt(engine);
		final var processAdapter = IProcessAdapter.adapt(graphicProcess);

		processAdapter.allocatePart();

		UPSMeter meter = new UPSMeter(2000);

		var window = engineAdapter.getWindow();
		while (!window.shouldClose())
		{
			engineAdapter.pollEvents();
			processAdapter.prepare();
			processAdapter.execute();
			meter.tick();
		}

		processAdapter.freePart();
	}

	private void buildApplication()
	{
		final var meshConfiguration = new MeshConfiguration(WIDTH, HEIGHT, false);
		final var modelFactory = new MeshModelFactory(meshConfiguration);
		application = modelFactory.application;
		engine = modelFactory.engine;
		graphicProcess = modelFactory.graphicProcess;
	}
}
