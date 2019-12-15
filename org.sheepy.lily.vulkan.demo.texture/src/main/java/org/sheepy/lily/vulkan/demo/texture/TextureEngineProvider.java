package org.sheepy.lily.vulkan.demo.texture;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.api.view.IViewAdapter;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.presentation.GenericView;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

@Adapter(scope = GenericView.class, name = MainTexture.NAME)
public class TextureEngineProvider implements IViewAdapter<GenericView>
{
	public static int FRAME_COUNT = 0;

	private static final String IMAGE_PATH = "image_77MJJZ.png";
	private static final String VERTEX_SHADER_PATH = "texture.vert.spv";
	private static final String FRAGMENT_SHADER_PATH = "texture.frag.spv";

	@Override
	public IEngine buildEngine(GenericView view)
	{
		final var application = ModelUtil.getApplication(view);
		final var size = application.getSize();
		final var meshBuilder = new TextureMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder, size);
		meshConfiguration.depth = true;
		meshConfiguration.useCamera = true;
		meshConfiguration.useTexture = true;
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;
		meshConfiguration.texturePath = IMAGE_PATH;
		meshConfiguration.frameCount = FRAME_COUNT;
		final var factory = new MeshModelFactory(meshConfiguration);

		return factory.build();
	}
}
