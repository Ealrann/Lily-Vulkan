package org.sheepy.vulkan.demo.texture;

import org.sheepy.common.api.application.ApplicationLauncher;
import org.sheepy.common.api.util.UPSMeter;
import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.vulkan.demo.mesh.UniformBufferManager;
import org.sheepy.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;

public class MainTexture
{
	private static final String IMAGE_PATH = "image_77MJJZ.png";
	private static final String VERTEX_SHADER_PATH = "texture.vert.spv";
	private static final String FRAGMENT_SHADER_PATH = "texture.frag.spv";

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private Application application;
	private VulkanEngine engine;
	private GraphicProcess graphicProcess;
	private UniformBufferManager uniformBufferManager;
	private long start;

	public static void main(String[] args)
	{
		final MainTexture mainTexture = new MainTexture();
		mainTexture.launch();
	}

	public MainTexture()
	{
		MeshAdapter.meshBuilder = new TextureMeshBuilder();
	}

	public void launch()
	{
		buildApplication();

		ApplicationLauncher.launch(application);
		final var engineAdapter = IVulkanEngineAdapter.adapt(engine);
		final var processAdapter = IProcessAdapter.adapt(graphicProcess);

		processAdapter.allocatePart();

		UPSMeter meter = new UPSMeter(2000);
		start = System.currentTimeMillis();

		var window = engineAdapter.getWindow();
		while (!window.shouldClose())
		{
			updateUniformBuffer();
			engineAdapter.pollEvents();
			processAdapter.prepare();
			processAdapter.execute();
			meter.tick();
		}

		processAdapter.freePart();
	}

	private void updateUniformBuffer()
	{
		final long current = System.currentTimeMillis();
		final float progress = (current - start) / 1000f;

		uniformBufferManager.update(progress);
	}

	private void buildApplication()
	{
		final var meshConfiguration = new MeshConfiguration(WIDTH, HEIGHT, true);
		meshConfiguration.buildUniformBuffer = true;
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;
		meshConfiguration.texturePath = IMAGE_PATH;

		final var modelFactory = new MeshModelFactory(meshConfiguration);
		application = modelFactory.application;
		engine = modelFactory.engine;
		graphicProcess = modelFactory.graphicProcess;
		uniformBufferManager = modelFactory.uniformBufferManager;
	}
}
