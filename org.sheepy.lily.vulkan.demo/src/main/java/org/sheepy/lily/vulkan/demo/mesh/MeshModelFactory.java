package org.sheepy.lily.vulkan.demo.mesh;

import org.joml.Vector2i;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.impl.ApplicationImpl;
import org.sheepy.lily.vulkan.demo.model.MeshBuffer;
import org.sheepy.lily.vulkan.demo.model.MeshPipeline;
import org.sheepy.lily.vulkan.demo.model.impl.MeshBufferImpl;
import org.sheepy.lily.vulkan.demo.model.impl.MeshPipelineImpl;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.enumeration.EAccess;
import org.sheepy.lily.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.lily.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.lily.vulkan.model.enumeration.EImageLayout;
import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.lily.vulkan.model.enumeration.ESampleCount;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.impl.ColorDomainImpl;
import org.sheepy.lily.vulkan.model.impl.ResourcePkgImpl;
import org.sheepy.lily.vulkan.model.impl.VulkanEngineImpl;
import org.sheepy.lily.vulkan.model.process.graphic.AttachementRef;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttachementRefImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentDescriptionImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.RasterizerImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ScissorImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.StaticViewportStateImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ViewportImpl;
import org.sheepy.lily.vulkan.model.process.impl.PipelinePkgImpl;
import org.sheepy.lily.vulkan.model.resource.DepthImage;
import org.sheepy.lily.vulkan.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.impl.DepthImageImpl;
import org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl;
import org.sheepy.lily.vulkan.model.resource.impl.TextureImpl;

public class MeshModelFactory
{
	private final MeshConfiguration meshConfiguration;

	public final Application application = new ApplicationImpl();
	public final VulkanEngine engine = new VulkanEngineImpl();
	public final MeshBuffer meshBuffer = new MeshBufferImpl();
	public final GraphicProcess graphicProcess;

	public float rotationSpeed = 1f;

	public UniformBufferManager uniformBufferManager = null;

	private DepthImage depthImage;

	public MeshModelFactory(MeshConfiguration meshConfiguration)
	{
		this.meshConfiguration = meshConfiguration;
		var size = new Vector2i(meshConfiguration.width, meshConfiguration.height);

		application.setTitle("Vulkan Triangle");
		application.setSize(size);
		application.setDebug(true);

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
		var subpass = new SubpassImpl();
		renderPass.getSubpasses().add(subpass);

		var colorAttachment = new AttachmentDescriptionImpl();
		colorAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachment.setLoadOp(EAttachmentLoadOp.CLEAR);
		colorAttachment.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.setInitialLayout(EImageLayout.UNDEFINED);
		colorAttachment.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		renderPass.getAttachments().add(colorAttachment);

		AttachementRef colorRef = new AttachementRefImpl();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachement(colorAttachment);
		subpass.getRefs().add(colorRef);

		if (meshConfiguration.depth)
		{
			var depthAttachment = new DepthAttachmentDescriptionImpl();

			depthAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
			depthAttachment.setLoadOp(EAttachmentLoadOp.CLEAR);
			depthAttachment.setStoreOp(EAttachmentStoreOp.DONT_CARE);
			depthAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
			depthAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
			depthAttachment.setInitialLayout(EImageLayout.UNDEFINED);
			depthAttachment.setFinalLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			depthAttachment.setDepthImage(depthImage);

			AttachementRef depthRef = new AttachementRefImpl();
			depthRef.setLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			depthRef.setAttachement(depthAttachment);

			subpass.getRefs().add(depthRef);
			renderPass.getAttachments().add(depthAttachment);
		}

		final SubpassDependency dependency = new SubpassDependencyImpl();
		dependency.setSrcSubpass(null);
		dependency.setDstSubpass(subpass);
		dependency.getSrcStageMask().add(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		dependency.getDstStageMask().add(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		dependency.getDstAccesses().add(EAccess.COLOR_ATTACHMENT_READ_BIT);
		dependency.getDstAccesses().add(EAccess.COLOR_ATTACHMENT_WRITE_BIT);

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

		var descriptorSet = new DescriptorSetImpl();

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

		ResourcePkg resourceContainer = new ResourcePkgImpl();
		graphicProcess.setResourcePkg(resourceContainer);

		resourceContainer.getResources().add(meshBuffer);
		resourceContainer.getResources().add(vertexShader);
		resourceContainer.getResources().add(fragmentShader);
		graphicProcess.setPipelinePkg(new PipelinePkgImpl());
		graphicProcess.getPipelinePkg().getPipelines().add(graphicPipeline);

		if (meshConfiguration.depth)
		{
			depthImage = new DepthImageImpl();
			graphicProcess.setDepthImage(depthImage);
		}

		if (meshConfiguration.buildUniformBuffer == true)
		{
			uniformBufferManager = new UniformBufferManager();
			var uniformBuffer = uniformBufferManager.buffer;
			descriptorSet.getDescriptors().add(uniformBuffer);
			resourceContainer.getResources().add(uniformBuffer);
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
			resourceContainer.getResources().add(texture);
		}

		if (descriptorSet.getDescriptors().isEmpty() == false)
		{
			graphicPipeline.setDescriptorSet(descriptorSet);
			graphicProcess.getDescriptorSets().add(descriptorSet);
		}

		return graphicProcess;
	}
}
