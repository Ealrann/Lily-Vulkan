package org.sheepy.lily.vulkan.demo.texture;

import org.sheepy.lily.core.api.application.ApplicationLauncher;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

public class MainTexture
{
	private static final String IMAGE_PATH = "image_77MJJZ.png";
	private static final String VERTEX_SHADER_PATH = "texture.vert.spv";
	private static final String FRAGMENT_SHADER_PATH = "texture.frag.spv";

	public static void main(String[] args)
	{
		DebugUtil.DEBUG_ENABLED = true;

		final var modelFactory = createFactory();

		final MeshMainLoop mainLoop = new MeshMainLoop(modelFactory);

		ApplicationLauncher.launch(modelFactory.application, mainLoop);
	}

	static MeshModelFactory createFactory()
	{
		final var meshBuilder = new TextureMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder);
		meshConfiguration.depth = true;
		meshConfiguration.useCamera = true;
		meshConfiguration.useTexture = true;
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;
		meshConfiguration.texturePath = IMAGE_PATH;

		final var modelFactory = new MeshModelFactory(meshConfiguration);
		return modelFactory;
	}
}
