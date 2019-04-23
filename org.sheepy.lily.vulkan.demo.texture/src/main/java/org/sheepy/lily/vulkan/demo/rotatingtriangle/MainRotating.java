package org.sheepy.lily.vulkan.demo.rotatingtriangle;

import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.lily.vulkan.demo.mesh.MeshPipelineAdapter;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

public class MainRotating
{
	private static final String VERTEX_SHADER_PATH = "rotating.vert.spv";
	private static final String FRAGMENT_SHADER_PATH = "rotating.frag.spv";

	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		MeshPipelineAdapter.meshBuilder = new RotatingMeshBuilder();

		final var meshConfiguration = new MeshConfiguration();
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;

		final var modelFactory = new MeshModelFactory(meshConfiguration);

		final MeshMainLoop mainLoop = new MeshMainLoop(modelFactory);

		ApplicationLauncher.launch(modelFactory.application, mainLoop);
	}
}
