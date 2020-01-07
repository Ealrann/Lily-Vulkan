package org.sheepy.lily.vulkan.demo.mesh;

import java.util.List;

import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
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
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelineFactory;
import org.sheepy.vulkan.model.image.ImageFactory;
import org.sheepy.vulkan.model.pipeline.PipelineFactory;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public final class MeshSubpassBuilder
{
	private final MeshConfiguration meshConfiguration;

	public MeshSubpassBuilder(MeshConfiguration meshConfiguration)
	{
		this.meshConfiguration = meshConfiguration;
	}

	public Subpass build(AttachmentPkg attachmentPkg)
	{
		final var pipelines = buildPipelines();

		List<ExtraAttachment> extraAttachments;
		ExtraAttachment depthAttachment;
		if (meshConfiguration.depth == true)
		{
			depthAttachment = buildDepthAttachmentDescriptor();
			extraAttachments = List.of(depthAttachment);
		}
		else
		{
			depthAttachment = null;
			extraAttachments = List.of();
		}

		attachmentPkg.getExtraAttachments().addAll(extraAttachments);
		final var pipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		pipelinePkg.getPipelines().addAll(pipelines);
		final var attachmentRefPkg = GraphicFactory.eINSTANCE.createAttachmentRefPkg();

		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(attachmentPkg.getColorAttachment());
		attachmentRefPkg.getAttachmentRefs().add(colorRef);

		if (depthAttachment != null)
		{
			final var depthRef = GraphicFactory.eINSTANCE.createAttachmentRef();
			depthRef.setLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			depthRef.setAttachment(depthAttachment);
			attachmentRefPkg.getAttachmentRefs().add(depthRef);
		}

		final var res = GraphicFactory.eINSTANCE.createSubpass();
		res.getStages().add(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		res.getAccesses().add(EAccess.COLOR_ATTACHMENT_WRITE_BIT);
		res.getAccesses().add(EAccess.COLOR_ATTACHMENT_READ_BIT);
		res.setAttachmantRefPkg(attachmentRefPkg);
		res.setPipelinePkg(pipelinePkg);
		return res;
	}

	private static ExtraAttachment buildDepthAttachmentDescriptor()
	{
		final var depthAttachmentDescriptor = GraphicFactory.eINSTANCE.createDepthAttachment();

		depthAttachmentDescriptor.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		depthAttachmentDescriptor.setLoadOp(EAttachmentLoadOp.CLEAR);
		depthAttachmentDescriptor.setStoreOp(EAttachmentStoreOp.DONT_CARE);
		depthAttachmentDescriptor.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		depthAttachmentDescriptor.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		depthAttachmentDescriptor.setInitialLayout(EImageLayout.UNDEFINED);
		depthAttachmentDescriptor.setFinalLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);

		return depthAttachmentDescriptor;
	}

	private List<IPipeline> buildPipelines()
	{
		final var module = meshConfiguration.module;

		final var vertexShaderFile = ApplicationFactory.eINSTANCE.createModuleResource();
		vertexShaderFile.setModule(module);
		vertexShaderFile.setPath(meshConfiguration.vertexShaderPath);

		final var fragmentShaderFile = ApplicationFactory.eINSTANCE.createModuleResource();
		fragmentShaderFile.setModule(module);
		fragmentShaderFile.setPath(meshConfiguration.fragmentShaderPath);

		final Shader vertexShader = ResourceFactory.eINSTANCE.createShader();
		vertexShader.setFile(vertexShaderFile);
		vertexShader.setStage(EShaderStage.VERTEX_BIT);

		final Shader fragmentShader = ResourceFactory.eINSTANCE.createShader();
		fragmentShader.setFile(fragmentShaderFile);
		fragmentShader.setStage(EShaderStage.FRAGMENT_BIT);

		final var vertexBuffer = ResourceFactory.eINSTANCE.createBuffer();
		vertexBuffer.setSize((long) Math.pow(2, 10));
		vertexBuffer.getUsages().add(EBufferUsage.VERTEX_BUFFER_BIT);
		vertexBuffer.getUsages().add(EBufferUsage.INDEX_BUFFER_BIT);
		vertexBuffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
		vertexBuffer.setData(meshConfiguration.vertexData);
		final var indexBuffer = ResourceFactory.eINSTANCE.createBuffer();
		indexBuffer.setSize((long) Math.pow(2, 8));
		indexBuffer.getUsages().add(EBufferUsage.VERTEX_BUFFER_BIT);
		indexBuffer.getUsages().add(EBufferUsage.INDEX_BUFFER_BIT);
		indexBuffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
		indexBuffer.setData(meshConfiguration.indexData);

		final var transferBuffer = ResourceFactory.eINSTANCE.createTransferBuffer();
		transferBuffer.setInstanceCount(EInstanceCount.FIT_TO_SWAP_IMAGE_COUNT);
		transferBuffer.setSize((long) Math.pow(2, 16));

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
		graphicPipeline.setDepthStencil(meshConfiguration.depth);
		if (pushConstantRange != null)
			graphicPipeline.getPushConstantRanges().add(pushConstantRange);

		final var bindVertexBuffer = GraphicFactory.eINSTANCE.createBindVertexBuffer();
		final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
		vertexBinding.setBuffer(vertexBuffer);
		bindVertexBuffer.getVertexBindings().add(vertexBinding);

		final var bindIndexBuffer = GraphicFactory.eINSTANCE.createBindIndexBuffer();
		bindIndexBuffer.setBuffer(indexBuffer);
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

		final var resourcePkg = ApplicationFactory.eINSTANCE.createResourcePkg();
		graphicPipeline.setResourcePkg(resourcePkg);

		resourcePkg.getResources().add(vertexShader);
		resourcePkg.getResources().add(fragmentShader);
		resourcePkg.getResources().add(transferBuffer);
		resourcePkg.getResources().add(vertexBuffer);
		resourcePkg.getResources().add(indexBuffer);
		if (constantBuffer != null) resourcePkg.getResources().add(constantBuffer);

		if (meshConfiguration.useTexture)
		{
			final var imageFile = ApplicationFactory.eINSTANCE.createModuleResource();
			imageFile.setModule(module);
			imageFile.setPath(meshConfiguration.texturePath);

			final var texture = ResourceFactory.eINSTANCE.createFileImage();
			texture.setFile(imageFile);
			texture.setMipmapEnabled(meshConfiguration.mipmap);
			texture.setFormat(EFormat.R8G8B8A8_UNORM);
			texture.getUsages().add(EImageUsage.SAMPLED);

			final var sampler = ImageFactory.eINSTANCE.createSamplerInfo();

			final var sampledImage = ResourceFactory.eINSTANCE.createSampledImage();
			sampledImage.setSampler(sampler);
			sampledImage.setImage(texture);

			final var sampledImageDescriptor = ResourceFactory.eINSTANCE.createSampledImageDescriptor();
			sampledImageDescriptor.setType(EDescriptorType.COMBINED_IMAGE_SAMPLER);
			sampledImageDescriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);
			sampledImageDescriptor.setSampledImage(sampledImage);

			resourcePkg.getResources().add(sampledImage);
			resourcePkg.getResources().add(imageFile);
			descriptorSet.getDescriptors().add(sampledImageDescriptor);

			final var descriptorPkg = VulkanFactory.eINSTANCE.createDescriptorPkg();
			descriptorPkg.getDescriptors().add(sampledImageDescriptor);
			graphicPipeline.setDescriptorPkg(descriptorPkg);
		}

		if (descriptorSet.getDescriptors().isEmpty() == false)
		{
			graphicPipeline.setDescriptorSetPkg(ResourceFactory.eINSTANCE.createDescriptorSetPkg());
			graphicPipeline.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);
			bindDescriptorSets.getDescriptorSets().add(descriptorSet);
		}

		return List.of(graphicPipeline);
	}
}
