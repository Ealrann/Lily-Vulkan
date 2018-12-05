package org.sheepy.vulkan.demo.triangle;

import org.sheepy.common.api.util.UPSMeter;
import org.sheepy.vulkan.api.VulkanApplicationLauncher;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;

public class MainTriangle
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private VulkanApplication application;
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
		
		final var applicationAdapter = VulkanApplicationLauncher.launch(application);
		final var processAdapter = IProcessAdapter.adapt(graphicProcess);
		
		processAdapter.allocateProcess();

		UPSMeter meter = new UPSMeter(2000);
		
		var window = applicationAdapter.getWindow();
		while (!window.shouldClose())
		{
			applicationAdapter.pollEvents();
			processAdapter.prepare();
			processAdapter.execute();
			meter.tick();
		}
		
		processAdapter.freeProcess();
	}

	private void buildApplication()
	{
		final var meshConfiguration = new MeshConfiguration(WIDTH, HEIGHT, false);
		final var modelFactory = new MeshModelFactory(meshConfiguration);
		application = modelFactory.application;
		graphicProcess = modelFactory.graphicProcess;
	}
}
