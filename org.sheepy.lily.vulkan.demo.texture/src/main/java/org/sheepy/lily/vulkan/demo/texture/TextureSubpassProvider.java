package org.sheepy.lily.vulkan.demo.texture;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.vulkan.api.view.IScenePart_SubpassProvider;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshGraphicBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

@Adapter(scope = GenericScenePart.class, name = MainTexture.NAME)
public class TextureSubpassProvider implements IScenePart_SubpassProvider<GenericScenePart>
{
	private static final String IMAGE_PATH = "image_77MJJZ.png";
	private static final String VERTEX_SHADER_PATH = "texture.vert.spv";
	private static final String FRAGMENT_SHADER_PATH = "texture.frag.spv";

	@Override
	public SubpassData build(GenericScenePart part, SwapImageAttachment colorAttachment)
	{
		final var scene = (Scene) part.eContainer();
		final var size = scene.getSize();
		final var meshBuilder = new TextureMeshBuilder();
		final var meshConfiguration = new MeshConfiguration(meshBuilder, size);
		meshConfiguration.depth = true;
		meshConfiguration.useCamera = true;
		meshConfiguration.useTexture = true;
		meshConfiguration.vertexShaderPath = VERTEX_SHADER_PATH;
		meshConfiguration.fragmentShaderPath = FRAGMENT_SHADER_PATH;
		meshConfiguration.rasterizerFrontFace = EFrontFace.COUNTER_CLOCKWISE;
		meshConfiguration.texturePath = IMAGE_PATH;

		final var builder = new MeshGraphicBuilder(meshConfiguration);
		return builder.build(colorAttachment);
	}
}
