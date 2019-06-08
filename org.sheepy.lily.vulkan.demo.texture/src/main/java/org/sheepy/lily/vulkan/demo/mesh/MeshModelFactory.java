package org.sheepy.lily.vulkan.demo.mesh;

import org.joml.Vector2i;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.impl.ResourcePkgImpl;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.AttachementRef;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttachementRefImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttributeDescriptionImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ColorDomainImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ExtraAttachmentDescriptionImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.FramebufferConfigurationImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.IndexedVertexDescriptorImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageAttachmentDescriptionImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.impl.BufferImpl;
import org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl;
import org.sheepy.lily.vulkan.model.resource.impl.PushBufferImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl;
import org.sheepy.lily.vulkan.model.resource.impl.TextureImpl;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl;
import org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendImpl;
import org.sheepy.vulkan.model.graphicpipeline.impl.InputAssemblyImpl;
import org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl;
import org.sheepy.vulkan.model.graphicpipeline.impl.ScissorImpl;
import org.sheepy.vulkan.model.graphicpipeline.impl.StaticViewportStateImpl;
import org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl;
import org.sheepy.vulkan.model.pipeline.PipelineFactory;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public class MeshModelFactory
{
	private final MeshConfiguration meshConfiguration;

	public final Application application = ApplicationFactory.eINSTANCE.createApplication();
	public final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();
	public final GraphicProcess graphicProcess;

	private DepthAttachment depthAttachment;

	public MeshModelFactory(MeshConfiguration meshConfiguration)
	{
		this.meshConfiguration = meshConfiguration;
		final var size = new Vector2i(meshConfiguration.width, meshConfiguration.height);

		application.setTitle("Vulkan Triangle");
		application.setSize(size);
		application.getEngines().add(engine);

		final var framebufferConfiguration = new FramebufferConfigurationImpl();
		final var graphicConfiguration = new GraphicConfigurationImpl();
		final var swapchainConfiguration = new SwapchainConfigurationImpl();

		if (meshConfiguration.depth)
		{
			depthAttachment = new DepthAttachmentImpl();
			swapchainConfiguration.getAtachments().add(depthAttachment);
		}

		graphicConfiguration.setSwapchainConfiguration(swapchainConfiguration);
		graphicConfiguration.setFramebufferConfiguration(framebufferConfiguration);
		graphicConfiguration.setColorDomain(new ColorDomainImpl());

		graphicProcess = newMeshProcess();
		graphicProcess.setConfiguration(graphicConfiguration);
		graphicProcess.setRenderPassInfo(newInfo());

		engine.getProcesses().add(graphicProcess);
	}

	private RenderPassInfo newInfo()
	{
		final RenderPassInfo renderPass = new RenderPassInfoImpl();
		final var subpass = new SubpassImpl();
		renderPass.getSubpasses().add(subpass);

		final var colorAttachmentDescriptor = new SwapImageAttachmentDescriptionImpl();
		colorAttachmentDescriptor.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachmentDescriptor.setLoadOp(EAttachmentLoadOp.CLEAR);
		colorAttachmentDescriptor.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachmentDescriptor.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachmentDescriptor.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachmentDescriptor.setInitialLayout(EImageLayout.UNDEFINED);
		colorAttachmentDescriptor.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		renderPass.getAttachments().add(colorAttachmentDescriptor);

		final AttachementRef colorRef = new AttachementRefImpl();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachement(colorAttachmentDescriptor);
		subpass.getRefs().add(colorRef);

		if (meshConfiguration.depth)
		{
			final var depthAttachmentDescriptor = new ExtraAttachmentDescriptionImpl();

			depthAttachmentDescriptor.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
			depthAttachmentDescriptor.setLoadOp(EAttachmentLoadOp.CLEAR);
			depthAttachmentDescriptor.setStoreOp(EAttachmentStoreOp.DONT_CARE);
			depthAttachmentDescriptor.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
			depthAttachmentDescriptor.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
			depthAttachmentDescriptor.setInitialLayout(EImageLayout.UNDEFINED);
			depthAttachmentDescriptor.setFinalLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			depthAttachmentDescriptor.setAttachment(depthAttachment);

			final AttachementRef depthRef = new AttachementRefImpl();
			depthRef.setLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			depthRef.setAttachement(depthAttachmentDescriptor);

			subpass.getRefs().add(depthRef);
			renderPass.getAttachments().add(depthAttachmentDescriptor);
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
		final var module = meshConfiguration.module;

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

		final var indexedVertexBuffer = new BufferImpl();
		indexedVertexBuffer.setSize((long) Math.pow(2, 10));
		indexedVertexBuffer.getUsages().add(EBufferUsage.VERTEX_BUFFER_BIT);
		indexedVertexBuffer.getUsages().add(EBufferUsage.INDEX_BUFFER_BIT);
		indexedVertexBuffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
		indexedVertexBuffer.setData(meshConfiguration.vertexData);

		final var pushBuffer = new PushBufferImpl();
		pushBuffer.setInstanceCount(3);
		pushBuffer.setSize((long) Math.pow(2, 16));

		PushConstantRange pushConstantRange = null;
		PushConstantBuffer pushConstants = null;
		ConstantBuffer constantBuffer = null;
		if (meshConfiguration.useCamera)
		{
			constantBuffer = ResourceFactory.eINSTANCE.createConstantBuffer();
			constantBuffer.setName(CameraConstantAdapter.DEMO_CAMERA);

			pushConstants = ProcessFactory.eINSTANCE.createPushConstantBuffer();
			pushConstants.getStages().add(EShaderStage.VERTEX_BIT);
			pushConstants.setBuffer(constantBuffer);

			pushConstantRange = PipelineFactory.eINSTANCE.createPushConstantRange();
			pushConstantRange.setSize(CameraConstantAdapter.SIZE_OF);
			pushConstantRange.getStages().add(EShaderStage.VERTEX_BIT);
		}

		final var descriptorSet = new DescriptorSetImpl();

		final var rasterizer = new RasterizerImpl();
		rasterizer.setFrontFace(meshConfiguration.rasterizerFrontFace);

		final var viewportState = new StaticViewportStateImpl();
		viewportState.getViewports().add(new ViewportImpl());
		viewportState.getScissors().add(new ScissorImpl());

		final var colorBlend = new ColorBlendImpl();
		colorBlend.getAttachments().add(new ColorBlendAttachmentImpl());

		final var locationAttribute = new AttributeDescriptionImpl();
		if (meshConfiguration.useTexture) locationAttribute.setFormat(EFormat.R32G32B32_SFLOAT);
		else locationAttribute.setFormat(EFormat.R32G32_SFLOAT);
		locationAttribute.setOffset(0);

		final var colorAttribute = new AttributeDescriptionImpl();
		colorAttribute.setFormat(EFormat.R32G32B32_SFLOAT);
		if (meshConfiguration.useTexture) colorAttribute.setOffset(12);
		else colorAttribute.setOffset(8);

		final var textureAttribute = new AttributeDescriptionImpl();
		textureAttribute.setFormat(EFormat.R32G32B32_SFLOAT);
		textureAttribute.setOffset(24);

		final int strideLength = meshConfiguration.useTexture ? 32 : 20;

		final var vertexDescriptor = new IndexedVertexDescriptorImpl();
		vertexDescriptor.setIndexType(EIndexType.UINT32);
		vertexDescriptor.setStrideLength(strideLength);
		vertexDescriptor.getAttributes().add(locationAttribute);
		vertexDescriptor.getAttributes().add(colorAttribute);
		if (meshConfiguration.useTexture) vertexDescriptor.getAttributes().add(textureAttribute);

		final var graphicPipeline = new GraphicsPipelineImpl();
		graphicPipeline.getShaders().add(vertexShader);
		graphicPipeline.getShaders().add(fragmentShader);
		graphicPipeline.setRasterizer(rasterizer);
		graphicPipeline.setInputAssembly(new InputAssemblyImpl());
		graphicPipeline.setViewportState(viewportState);
		graphicPipeline.setColorBlend(colorBlend);
		graphicPipeline.setVertexDescriptor(vertexDescriptor);
		if (pushConstantRange != null)
			graphicPipeline.getPushConstantRanges().add(pushConstantRange);

		final var vertexRef = ResourceFactory.eINSTANCE.createBufferReference();
		vertexRef.setBuffer(indexedVertexBuffer);
		vertexRef.setOffset(0);

		final var bindVertexBuffer = new BindVertexBufferImpl();
		final var vertexBinding = new VertexBindingImpl();
		vertexBinding.setBufferRef(vertexRef);
		bindVertexBuffer.getVertexBindings().add(vertexBinding);

		final var indexRef = ResourceFactory.eINSTANCE.createBufferReference();
		indexRef.setBuffer(indexedVertexBuffer);
		indexRef.setOffset(meshConfiguration.indexOffset);

		final var bindIndexBuffer = new BindIndexBufferImpl();
		bindIndexBuffer.setBufferRef(indexRef);

		final var drawIndexed = new DrawIndexedImpl();
		drawIndexed.setIndexCount(meshConfiguration.indexCount);

		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		graphicPipeline.setTaskPkg(taskPkg);

		final var taskList = taskPkg.getTasks();
		final var bindDescriptorSets = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		taskList.add(bindDescriptorSets);
		if (meshConfiguration.useCamera) taskList.add(pushConstants);
		taskList.add(bindVertexBuffer);
		taskList.add(bindIndexBuffer);
		taskList.add(drawIndexed);

		final var graphicProcess = new GraphicProcessImpl();
		graphicProcess.setResetAllowed(true);

		final var resourceContainer = new ResourcePkgImpl();
		graphicProcess.setResourcePkg(resourceContainer);

		resourceContainer.getResources().add(vertexShader);
		resourceContainer.getResources().add(fragmentShader);
		resourceContainer.getResources().add(pushBuffer);
		resourceContainer.getResources().add(indexedVertexBuffer);
		if (constantBuffer != null) resourceContainer.getResources().add(constantBuffer);

		graphicProcess.setPartPkg(ProcessFactory.eINSTANCE.createProcessPartPkg());
		graphicProcess.getPartPkg().getParts().add(graphicPipeline);

		if (meshConfiguration.useTexture)
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
			graphicPipeline.setDescriptorSetPkg(ResourceFactory.eINSTANCE.createDescriptorSetPkg());
			graphicPipeline.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);
			bindDescriptorSets.getDescriptorSets().add(descriptorSet);
		}

		return graphicProcess;
	}
}
