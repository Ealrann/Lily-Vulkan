package org.sheepy.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.common.api.types.SVector2i;
import org.sheepy.common.model.application.Application;
import org.sheepy.common.model.application.impl.ApplicationImpl;
import org.sheepy.vulkan.demo.model.MeshBuffer;
import org.sheepy.vulkan.demo.model.MeshPipeline;
import org.sheepy.vulkan.demo.model.impl.MeshBufferImpl;
import org.sheepy.vulkan.demo.model.impl.MeshPipelineImpl;
import org.sheepy.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.impl.ColorDomainImpl;
import org.sheepy.vulkan.model.impl.VulkanEngineImpl;
import org.sheepy.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl;
import org.sheepy.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl;
import org.sheepy.vulkan.model.process.graphic.impl.ColorBlendImpl;
import org.sheepy.vulkan.model.process.graphic.impl.GraphicConfigurationImpl;
import org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl;
import org.sheepy.vulkan.model.process.graphic.impl.RasterizerImpl;
import org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl;
import org.sheepy.vulkan.model.process.graphic.impl.ScissorImpl;
import org.sheepy.vulkan.model.process.graphic.impl.StaticViewportStateImpl;
import org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl;
import org.sheepy.vulkan.model.process.graphic.impl.ViewportImpl;
import org.sheepy.vulkan.model.resource.DepthImage;
import org.sheepy.vulkan.model.resource.ModuleResource;
import org.sheepy.vulkan.model.resource.Shader;
import org.sheepy.vulkan.model.resource.impl.BasicDescriptorSetImpl;
import org.sheepy.vulkan.model.resource.impl.DepthImageImpl;
import org.sheepy.vulkan.model.resource.impl.ModuleResourceImpl;
import org.sheepy.vulkan.model.resource.impl.ShaderImpl;
import org.sheepy.vulkan.model.resource.impl.TextureImpl;

public class MeshModelFactory
{
	private final MeshConfiguration meshConfiguration;

	public final Application application = new ApplicationImpl();
	public final VulkanEngine engine = new VulkanEngineImpl();
	public final MeshBuffer meshBuffer = new MeshBufferImpl();
	public final GraphicProcess graphicProcess;

	public final UniformBufferManager uniformBufferManager = new UniformBufferManager();

	public MeshModelFactory(MeshConfiguration meshConfiguration)
	{
		this.meshConfiguration = meshConfiguration;
		var size = new SVector2i(meshConfiguration.width, meshConfiguration.height);

		application.setTitle("Vulkan Triangle");
		application.setSize(size);
		application.setDebug(false);

		application.getEngines().add(engine);

		final GraphicConfiguration configuration = new GraphicConfigurationImpl();
		configuration.setColorDomain(new ColorDomainImpl());

		graphicProcess = newMeshProcess();
		graphicProcess.setConfiguration(configuration);
		graphicProcess.setRenderPassInfo(newInfo());

		engine.getProcesses().add(graphicProcess);
	}

	private RenderPassInfo newInfo()
	{
		final RenderPassInfo renderPass = new RenderPassInfoImpl();

		final AttachmentDescription colorAttachment = new AttachmentDescriptionImpl();
		colorAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachment.setLoadOp(EAttachmentLoadOp.CLEAR);
		colorAttachment.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.setInitialLayout(EImageLayout.UNDEFINED);
		colorAttachment.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		colorAttachment.setRefLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);

		renderPass.getAttachments().add(colorAttachment);

		if (meshConfiguration.depth)
		{
			final AttachmentDescription depthAttachment = new AttachmentDescriptionImpl();
			depthAttachment.setStencil(true);

			depthAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
			depthAttachment.setLoadOp(EAttachmentLoadOp.CLEAR);
			depthAttachment.setStoreOp(EAttachmentStoreOp.DONT_CARE);
			depthAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
			depthAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
			depthAttachment.setInitialLayout(EImageLayout.UNDEFINED);
			depthAttachment.setFinalLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);

			depthAttachment.setRefLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);

			renderPass.getAttachments().add(depthAttachment);
		}

		final SubpassDependency dependency = new SubpassDependencyImpl();
		dependency.setSrcSubpass(VK_SUBPASS_EXTERNAL);
		dependency.setDstSubpass(0);
		dependency.setSrcStageMask(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		dependency.setDstStageMask(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		dependency.setSrcAccessMask(0);
		dependency.setDstAccessMask(
				VK_ACCESS_COLOR_ATTACHMENT_READ_BIT | VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT);

		renderPass.getDependencies().add(dependency);

		return renderPass;
	}

	private GraphicProcess newMeshProcess()
	{
		var module = meshConfiguration.module;

		final ModuleResource vertexShaderFile = new ModuleResourceImpl();
		vertexShaderFile.setModule(module);
		vertexShaderFile.setPath(meshConfiguration.vertexShaderPath);

		final ModuleResource fragmentShaderFile = new ModuleResourceImpl();
		fragmentShaderFile.setModule(module);
		fragmentShaderFile.setPath(meshConfiguration.fragmentShaderPath);

		final Shader vertexShader = new ShaderImpl();
		vertexShader.setFile(vertexShaderFile);
		vertexShader.setStage(EShaderStage.VERTEX_BIT);

		final Shader fragmentShader = new ShaderImpl();
		fragmentShader.setFile(fragmentShaderFile);
		fragmentShader.setStage(EShaderStage.FRAGMENT_BIT);

		var descriptorSet = new BasicDescriptorSetImpl();

		var rasterizer = new RasterizerImpl();
		rasterizer.setFrontFace(meshConfiguration.rasterizerFrontFace);

		var viewportState = new StaticViewportStateImpl();
		viewportState.getViewports().add(new ViewportImpl());
		viewportState.getScissors().add(new ScissorImpl());

		var colorBlend = new ColorBlendImpl();
		colorBlend.getAttachments().add(new ColorBlendAttachmentImpl());

		final MeshPipeline graphicPipeline = new MeshPipelineImpl();
		graphicPipeline.getShaders().add(vertexShader);
		graphicPipeline.getShaders().add(fragmentShader);
		graphicPipeline.setMesh(meshBuffer);
		graphicPipeline.setRasterizer(rasterizer);
		graphicPipeline.setViewportState(viewportState);
		graphicPipeline.setColorBlend(colorBlend);

		final GraphicProcess graphicProcess = new GraphicProcessImpl();
		graphicProcess.getResources().add(meshBuffer);
		graphicProcess.getResources().add(vertexShader);
		graphicProcess.getResources().add(fragmentShader);
		graphicProcess.getUnits().add(graphicPipeline);

		if (meshConfiguration.depth)
		{
			final DepthImage depthImage = new DepthImageImpl();
			graphicProcess.getResources().add(depthImage);
			graphicProcess.setDepthImage(depthImage);
		}

		if (meshConfiguration.buildUniformBuffer == true)
		{
			var uniformBuffer = uniformBufferManager.buffer;
			descriptorSet.getDescriptors().add(uniformBuffer);
			graphicProcess.getResources().add(uniformBuffer);
		}

		if (meshConfiguration.texturePath != null)
		{
			final ModuleResource textureFile = new ModuleResourceImpl();
			textureFile.setModule(module);
			textureFile.setPath(meshConfiguration.texturePath);

			final var texture = new TextureImpl();
			texture.setFile(textureFile);
			texture.setMipmapEnabled(meshConfiguration.mipmap);

			descriptorSet.getDescriptors().add(texture);
			graphicProcess.getResources().add(texture);
		}

		if (descriptorSet.getDescriptors().isEmpty() == false)
		{
			graphicPipeline.setDescriptorSet(descriptorSet);
			graphicProcess.getDescriptorSets().add(descriptorSet);
		}

		return graphicProcess;
	}
}
