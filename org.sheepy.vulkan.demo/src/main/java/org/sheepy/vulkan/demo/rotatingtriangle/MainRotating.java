package org.sheepy.vulkan.demo.rotatingtriangle;

import org.sheepy.common.api.util.UPSMeter;
import org.sheepy.vulkan.api.VulkanApplicationLauncher;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.vulkan.demo.mesh.UniformBufferManager;
import org.sheepy.vulkan.demo.triangle.TriangleMeshBuilder;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;

public class MainRotating
{
	private static final String VERTEX_SHADER_PATH = "rotating.vert.spv";
	private static final String FRAGMENT_SHADER_PATH = "rotating.frag.spv";

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private VulkanApplication application;
	private GraphicProcess graphicProcess;
	private UniformBufferManager uniformBufferManager;
	private long start;

	public static void main(String[] args)
	{
		final MainRotating mainRotating = new MainRotating();
		mainRotating.launch();
	}

	public MainRotating()
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
		start = System.currentTimeMillis();
		
		var window = applicationAdapter.getWindow();
		while (!window.shouldClose())
		{
			updateUniformBuffer();
			applicationAdapter.pollEvents();
			processAdapter.prepare();
			processAdapter.execute();
			meter.tick();
		}

		processAdapter.freeProcess();
	}

	private void updateUniformBuffer()
	{
		final long current = System.currentTimeMillis();
		final float progress = (current - start) / 1000f;

		uniformBufferManager.update(progress);
	}

	private void buildApplication()
	{
		final var meshConfiguration = new MeshConfiguration(WIDTH, HEIGHT, false);
		meshConfiguration.buildUniformBuffer = true;
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;

		final var modelFactory = new MeshModelFactory(meshConfiguration);
		application = modelFactory.application;
		graphicProcess = modelFactory.graphicProcess;
		uniformBufferManager = modelFactory.uniformBufferManager;
	}
}
