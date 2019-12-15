package org.sheepy.lily.vulkan.demo.rotating;

import org.sheepy.lily.core.api.LilyLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.lily.vulkan.demo.triangle.TriangleMeshBuilder;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

public class MainRotating
{
	static final String VERTEX_SHADER_PATH = "rotating.vert.spv";
	static final String FRAGMENT_SHADER_PATH = "rotating.frag.spv";

	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		final var modelFactory = createFactory(0);

		LilyLauncher.launch(modelFactory.application);
	}

	static MeshModelFactory createFactory(int frameCount)
	{
		final var meshBuilder = new TriangleMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder);
		meshConfiguration.useCamera = true;
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;
		meshConfiguration.frameCount = frameCount;

		final var modelFactory = new MeshModelFactory(meshConfiguration);
		return modelFactory;
	}
}
