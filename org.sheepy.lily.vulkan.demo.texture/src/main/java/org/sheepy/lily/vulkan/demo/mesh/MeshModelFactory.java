package org.sheepy.lily.vulkan.demo.mesh;

import org.joml.Vector2i;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelineFactory;
import org.sheepy.vulkan.model.image.ImageFactory;
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

		final var framebufferConfiguration = GraphicFactory.eINSTANCE.createFramebufferConfiguration();
		final var graphicConfiguration = GraphicFactory.eINSTANCE.createGraphicConfiguration();
		final var swapchainConfiguration = GraphicFactory.eINSTANCE.createSwapchainConfiguration();
		swapchainConfiguration.setAcquireWaitForVBlank(false);
		swapchainConfiguration.setPresentWhenVBlank(false);

		if (meshConfiguration.depth)
		{
			depthAttachment = GraphicFactory.eINSTANCE.createDepthAttachment();
			swapchainConfiguration.getAtachments().add(depthAttachment);
		}

		graphicConfiguration.setSwapchainConfiguration(swapchainConfiguration);
		graphicConfiguration.setFramebufferConfiguration(framebufferConfiguration);
		graphicConfiguration.setColorDomain(GraphicFactory.eINSTANCE.createColorDomain());

		graphicProcess = newMeshProcess();
		graphicProcess.setConfiguration(graphicConfiguration);
		graphicProcess.setRenderPassInfo(newInfo());

		engine.getProcesses().add(graphicProcess);
	}

	private RenderPassInfo newInfo()
	{
		final var renderPass = GraphicFactory.eINSTANCE.createRenderPassInfo();
		final var subpass = GraphicFactory.eINSTANCE.createSubpass();
		renderPass.getSubpasses().add(subpass);

		final var colorAttachmentDescriptor = GraphicFactory.eINSTANCE.createSwapImageAttachmentDescription();
		colorAttachmentDescriptor.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachmentDescriptor.setLoadOp(EAttachmentLoadOp.CLEAR);
		colorAttachmentDescriptor.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachmentDescriptor.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachmentDescriptor.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachmentDescriptor.setInitialLayout(EImageLayout.UNDEFINED);
		colorAttachmentDescriptor.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		renderPass.getAttachments().add(colorAttachmentDescriptor);

		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(colorAttachmentDescriptor);
		subpass.getRefs().add(colorRef);

		if (meshConfiguration.depth)
		{
			final var depthAttachmentDescriptor = GraphicFactory.eINSTANCE.createExtraAttachmentDescription();

			depthAttachmentDescriptor.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
			depthAttachmentDescriptor.setLoadOp(EAttachmentLoadOp.CLEAR);
			depthAttachmentDescriptor.setStoreOp(EAttachmentStoreOp.DONT_CARE);
			depthAttachmentDescriptor.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
			depthAttachmentDescriptor.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
			depthAttachmentDescriptor.setInitialLayout(EImageLayout.UNDEFINED);
			depthAttachmentDescriptor.setFinalLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			depthAttachmentDescriptor.setAttachment(depthAttachment);

			final var depthRef = GraphicFactory.eINSTANCE.createAttachmentRef();
			depthRef.setLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			depthRef.setAttachment(depthAttachmentDescriptor);

			subpass.getRefs().add(depthRef);
			renderPass.getAttachments().add(depthAttachmentDescriptor);
		}

		final var dependency = GraphicFactory.eINSTANCE.createSubpassDependency();
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

		final var vertexShaderFile = ResourceFactory.eINSTANCE.createModuleResource();
		vertexShaderFile.setModule(module);
		vertexShaderFile.setPath(meshConfiguration.vertexShaderPath);

		final var fragmentShaderFile = ResourceFactory.eINSTANCE.createModuleResource();
		fragmentShaderFile.setModule(module);
		fragmentShaderFile.setPath(meshConfiguration.fragmentShaderPath);

		final Shader vertexShader = ResourceFactory.eINSTANCE.createShader();
		vertexShader.setFile(vertexShaderFile);
		vertexShader.setStage(EShaderStage.VERTEX_BIT);

		final Shader fragmentShader = ResourceFactory.eINSTANCE.createShader();
		fragmentShader.setFile(fragmentShaderFile);
		fragmentShader.setStage(EShaderStage.FRAGMENT_BIT);

		final var indexedVertexBuffer = ResourceFactory.eINSTANCE.createBuffer();
		indexedVertexBuffer.setSize((long) Math.pow(2, 10));
		indexedVertexBuffer.getUsages().add(EBufferUsage.VERTEX_BUFFER_BIT);
		indexedVertexBuffer.getUsages().add(EBufferUsage.INDEX_BUFFER_BIT);
		indexedVertexBuffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
		indexedVertexBuffer.setData(meshConfiguration.vertexData);

		final var pushBuffer = ResourceFactory.eINSTANCE.createPushBuffer();
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

		final var descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();

		final var rasterizer = GraphicpipelineFactory.eINSTANCE.createRasterizer();
		rasterizer.setFrontFace(meshConfiguration.rasterizerFrontFace);

		final var viewportState = GraphicpipelineFactory.eINSTANCE.createStaticViewportState();
		viewportState.getViewports().add(GraphicpipelineFactory.eINSTANCE.createViewport());
		viewportState.getScissors().add(GraphicpipelineFactory.eINSTANCE.createScissor());

		final var colorBlend = GraphicpipelineFactory.eINSTANCE.createColorBlend();
		colorBlend	.getAttachments()
					.add(GraphicpipelineFactory.eINSTANCE.createColorBlendAttachment());

		final var locationAttribute = GraphicFactory.eINSTANCE.createAttributeDescription();
		if (meshConfiguration.useTexture) locationAttribute.setFormat(EFormat.R32G32B32_SFLOAT);
		else locationAttribute.setFormat(EFormat.R32G32_SFLOAT);
		locationAttribute.setOffset(0);

		final var colorAttribute = GraphicFactory.eINSTANCE.createAttributeDescription();
		colorAttribute.setFormat(EFormat.R32G32B32_SFLOAT);
		if (meshConfiguration.useTexture) colorAttribute.setOffset(12);
		else colorAttribute.setOffset(8);

		final var textureAttribute = GraphicFactory.eINSTANCE.createAttributeDescription();
		textureAttribute.setFormat(EFormat.R32G32_SFLOAT);
		textureAttribute.setOffset(24);

		final int strideLength = meshConfiguration.useTexture ? 32 : 20;

		final var inputState = GraphicFactory.eINSTANCE.createVertexInputState();
		final var inputDescriptor = GraphicFactory.eINSTANCE.createInputDescriptor();
		inputState.getInputDescriptor().add(inputDescriptor);

		inputDescriptor.setStrideLength(strideLength);
		inputDescriptor.getAttributes().add(locationAttribute);
		inputDescriptor.getAttributes().add(colorAttribute);
		if (meshConfiguration.useTexture) inputDescriptor.getAttributes().add(textureAttribute);

		final var graphicPipeline = GraphicFactory.eINSTANCE.createGraphicsPipeline();
		graphicPipeline.getShaders().add(vertexShader);
		graphicPipeline.getShaders().add(fragmentShader);
		graphicPipeline.setRasterizer(rasterizer);
		graphicPipeline.setInputAssembly(GraphicpipelineFactory.eINSTANCE.createInputAssembly());
		graphicPipeline.setViewportState(viewportState);
		graphicPipeline.setColorBlend(colorBlend);
		graphicPipeline.setVertexInputState(inputState);
		if (pushConstantRange != null)
			graphicPipeline.getPushConstantRanges().add(pushConstantRange);

		final var vertexRef = ResourceFactory.eINSTANCE.createBufferReference();
		vertexRef.setBuffer(indexedVertexBuffer);
		vertexRef.setOffset(0);

		final var bindVertexBuffer = GraphicFactory.eINSTANCE.createBindVertexBuffer();
		final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
		vertexBinding.setBufferRef(vertexRef);
		bindVertexBuffer.getVertexBindings().add(vertexBinding);

		final var indexRef = ResourceFactory.eINSTANCE.createBufferReference();
		indexRef.setBuffer(indexedVertexBuffer);
		indexRef.setOffset(meshConfiguration.indexOffset);

		final var bindIndexBuffer = GraphicFactory.eINSTANCE.createBindIndexBuffer();
		bindIndexBuffer.setBufferRef(indexRef);
		bindIndexBuffer.setIndexType(EIndexType.UINT32);

		final var drawIndexed = GraphicFactory.eINSTANCE.createDrawIndexed();
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

		final var graphicProcess = GraphicFactory.eINSTANCE.createGraphicProcess();
		graphicProcess.setResetAllowed(true);

		final var resourcePkg = VulkanFactory.eINSTANCE.createResourcePkg();
		graphicProcess.setResourcePkg(resourcePkg);

		resourcePkg.getResources().add(vertexShader);
		resourcePkg.getResources().add(fragmentShader);
		resourcePkg.getResources().add(pushBuffer);
		resourcePkg.getResources().add(indexedVertexBuffer);
		if (constantBuffer != null) resourcePkg.getResources().add(constantBuffer);

		graphicProcess.setPartPkg(ProcessFactory.eINSTANCE.createProcessPartPkg());
		graphicProcess.getPartPkg().getParts().add(graphicPipeline);

		if (meshConfiguration.useTexture)
		{
			final var imageFile = ResourceFactory.eINSTANCE.createModuleResource();
			imageFile.setModule(module);
			imageFile.setPath(meshConfiguration.texturePath);

			final var texture = ResourceFactory.eINSTANCE.createFileImage();
			texture.setFile(imageFile);
			texture.setMipmapEnabled(meshConfiguration.mipmap);

			final var descriptor = ResourceFactory.eINSTANCE.createDescriptor();
			descriptor.setDescriptorType(EDescriptorType.COMBINED_IMAGE_SAMPLER);
			descriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);

			final var sampler = ImageFactory.eINSTANCE.createSamplerInfo();

			final var sampledImage = ResourceFactory.eINSTANCE.createSampledImage();
			sampledImage.setSampler(sampler);
			sampledImage.setImage(texture);
			sampledImage.setDescriptor(descriptor);

			resourcePkg.getResources().add(sampledImage);
			descriptorSet.getDescriptors().add(sampledImage);
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
