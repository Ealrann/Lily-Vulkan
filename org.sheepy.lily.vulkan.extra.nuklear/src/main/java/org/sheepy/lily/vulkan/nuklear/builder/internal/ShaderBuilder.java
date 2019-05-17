package org.sheepy.lily.vulkan.nuklear.builder.internal;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public class ShaderBuilder
{
	private final static String GUI_VERT_SHADER = "ui.vert.spv";
	private final static String GUI_FRAG_SHADER = "ui.frag.spv";

	public static final void setup(GraphicsPipeline pipeline)
	{
		final var module = ShaderBuilder.class.getModule();

		final var vertexShaderResource = ResourceFactory.eINSTANCE.createModuleResource();
		vertexShaderResource.setModule(module);
		vertexShaderResource.setPath(GUI_VERT_SHADER);

		final var fragmentShaderResource = ResourceFactory.eINSTANCE.createModuleResource();
		fragmentShaderResource.setModule(module);
		fragmentShaderResource.setPath(GUI_FRAG_SHADER);

		final var vertexShader = ResourceFactory.eINSTANCE.createShader();
		vertexShader.setFile(vertexShaderResource);
		vertexShader.setStage(EShaderStage.VERTEX_BIT);

		final var fragmentShader = ResourceFactory.eINSTANCE.createShader();
		fragmentShader.setFile(fragmentShaderResource);
		fragmentShader.setStage(EShaderStage.FRAGMENT_BIT);

		pipeline.getShaders().add(vertexShader);
		pipeline.getShaders().add(fragmentShader);

		pipeline.getResourcePkg().getResources().add(vertexShader);
		pipeline.getResourcePkg().getResources().add(fragmentShader);
	}
}
