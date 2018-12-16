package org.sheepy.vulkan.demo.rotatingtriangle;

import org.sheepy.common.api.cadence.ICadencer;
import org.sheepy.common.api.cadence.IMainLoop;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.vulkan.demo.triangle.TriangleMeshBuilder;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

public class MainRotating
{
	private static final String VERTEX_SHADER_PATH = "rotating.vert.spv";
	private static final String FRAGMENT_SHADER_PATH = "rotating.frag.spv";

	public static void main(String[] args)
	{
		MeshAdapter.meshBuilder = new TriangleMeshBuilder();

		final var meshConfiguration = new MeshConfiguration();
		meshConfiguration.buildUniformBuffer = true;
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;

		final var modelFactory = new MeshModelFactory(meshConfiguration);

		((MeshMainLoop) IMainLoop.INSTANCE).factory = modelFactory;

		ICadencer.INSTANCE.start(modelFactory.application);
	}
}
