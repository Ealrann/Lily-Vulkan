package org.sheepy.lily.vulkan.demo.texture;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.model.application.GenericScenePart;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.vulkan.api.device.IVulkanApiContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.demo.mesh.MeshConfiguration;
import org.sheepy.lily.vulkan.demo.mesh.MeshSubpassBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.EFrontFace;

@ModelExtender(scope = GenericScenePart.class, name = MainTexture.NAME)
@Adapter(singleton = true)
public class TextureSubpassProvider implements ICompositor_SubpassProvider<GenericScenePart>
{
	private static final String IMAGE_PATH = "image_77MJJZ.png";
	private static final String VERTEX_SHADER_PATH = "texture.vert.spv";
	private static final String FRAGMENT_SHADER_PATH = "texture.frag.spv";

	@Override
	public Subpass build(GenericScenePart part, GraphicProcess process, IVulkanApiContext context)
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

		final var builder = new MeshSubpassBuilder(meshConfiguration);
		return builder.build(process);
	}
}
