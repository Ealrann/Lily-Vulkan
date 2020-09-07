package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;
import org.sheepy.vulkan.model.enumeration.*;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelineFactory;
import org.sheepy.vulkan.model.pipeline.PipelineFactory;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

import java.util.List;

public final class MeshSubpassBuilder
{
	private final MeshConfiguration meshConfiguration;

	public MeshSubpassBuilder(MeshConfiguration meshConfiguration)
	{
		this.meshConfiguration = meshConfiguration;
	}

	public Subpass build(GraphicProcess process)
	{
		final var res = GraphicFactory.eINSTANCE.createSubpass();
		final var pipelines = buildPipelines();
		final var pipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		pipelinePkg.getPipelines().addAll(pipelines);
		final var attachmentRefPkg = GraphicFactory.eINSTANCE.createAttachmentRefPkg();

		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(process.getConfiguration().getSwapchainConfiguration().getColorAttachment());
		attachmentRefPkg.getAttachmentRefs().add(colorRef);

		if (meshConfiguration.depth)
		{
			final var depthAttachment = process.getAttachmentPkg().getExtraAttachments().get(0);
			final var depthRef = GraphicFactory.eINSTANCE.createAttachmentRef();
			depthRef.setLayout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL);
			depthRef.setAttachment(depthAttachment);
			depthRef.setType(EAttachmentType.DEPTH);
			attachmentRefPkg.getAttachmentRefs().add(depthRef);
		}

		res.setWaitForStage(EPipelineStage.TOP_OF_PIPE_BIT);
		res.setSyncStage(EPipelineStage.EARLY_FRAGMENT_TESTS_BIT);
		res.setAttachmentRefPkg(attachmentRefPkg);
		res.setPipelinePkg(pipelinePkg);
		return res;
	}

	private List<AbstractPipeline> buildPipelines()
	{
		final var module = meshConfiguration.module;

		final var vertexShaderFile = ResourceFactory.eINSTANCE.createModuleResource();
		vertexShaderFile.setModule(module);
		vertexShaderFile.setPath(meshConfiguration.vertexShaderPath);

		final var fragmentShaderFile = ResourceFactory.eINSTANCE.createModuleResource();
		fragmentShaderFile.setModule(module);
		fragmentShaderFile.setPath(meshConfiguration.fragmentShaderPath);

		final Shader vertexShader = VulkanResourceFactory.eINSTANCE.createShader();
		vertexShader.setFile(vertexShaderFile);
		vertexShader.setStage(EShaderStage.VERTEX_BIT);

		final Shader fragmentShader = VulkanResourceFactory.eINSTANCE.createShader();
		fragmentShader.setFile(fragmentShaderFile);
		fragmentShader.setStage(EShaderStage.FRAGMENT_BIT);

		final var bufferMemory = VulkanResourceFactory.eINSTANCE.createBufferMemory();
		final var memoryChunk = VulkanResourceFactory.eINSTANCE.createMemoryChunk();
		final var vertexBuffer = VulkanResourceFactory.eINSTANCE.createDataBuffer();
		vertexBuffer.getUsages().add(EBufferUsage.VERTEX_BUFFER_BIT);
		vertexBuffer.getUsages().add(EBufferUsage.INDEX_BUFFER_BIT);
		vertexBuffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
		vertexBuffer.setData(meshConfiguration.vertexData);
		final var indexBuffer = VulkanResourceFactory.eINSTANCE.createDataBuffer();
		indexBuffer.getUsages().add(EBufferUsage.VERTEX_BUFFER_BIT);
		indexBuffer.getUsages().add(EBufferUsage.INDEX_BUFFER_BIT);
		indexBuffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);
		indexBuffer.setData(meshConfiguration.indexData);
		bufferMemory.getBuffers().add(vertexBuffer);
		bufferMemory.getBuffers().add(indexBuffer);
		memoryChunk.getParts().add(bufferMemory);

		PushConstantRange pushConstantRange = null;
		PushConstantBuffer pushConstants = null;
		ConstantBuffer constantBuffer = null;
		if (meshConfiguration.useCamera)
		{
			constantBuffer = VulkanResourceFactory.eINSTANCE.createConstantBuffer();
			constantBuffer.setName(CameraConstantAdapter.DEMO_CAMERA);

			pushConstants = ProcessFactory.eINSTANCE.createPushConstantBuffer();
			pushConstants.getStages().add(EShaderStage.VERTEX_BIT);
			pushConstants.setBuffer(constantBuffer);

			pushConstantRange = PipelineFactory.eINSTANCE.createPushConstantRange();
			pushConstantRange.setSize(CameraConstantAdapter.SIZE_OF);
			pushConstantRange.getStages().add(EShaderStage.VERTEX_BIT);
		}

		final var rasterizer = GraphicpipelineFactory.eINSTANCE.createRasterizer();
		rasterizer.setFrontFace(meshConfiguration.rasterizerFrontFace);

		final var viewportState = GraphicpipelineFactory.eINSTANCE.createStaticViewportState();
		viewportState.getViewports().add(GraphicpipelineFactory.eINSTANCE.createViewport());
		viewportState.getScissors().add(GraphicpipelineFactory.eINSTANCE.createScissor());

		final var colorBlend = GraphicpipelineFactory.eINSTANCE.createColorBlend();
		colorBlend.getAttachments().add(GraphicpipelineFactory.eINSTANCE.createColorBlendAttachment());

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
		if (meshConfiguration.depth)
			graphicPipeline.setDepthStencilState(GraphicpipelineFactory.eINSTANCE.createDepthStencilState());
		if (pushConstantRange != null) graphicPipeline.getPushConstantRanges().add(pushConstantRange);

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
		graphicPipeline.getTaskPkgs().add(taskPkg);

		final var taskList = taskPkg.getTasks();
		final var bindDescriptorSets = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		taskList.add(bindDescriptorSets);
		if (meshConfiguration.useCamera) taskList.add(pushConstants);
		taskList.add(bindVertexBuffer);
		taskList.add(bindIndexBuffer);
		taskList.add(drawIndexed);

		final var vulkanResourcePkg = VulkanFactory.eINSTANCE.createVulkanResourcePkg();
		graphicPipeline.setResourcePkg(vulkanResourcePkg);

		vulkanResourcePkg.getResources().add(vertexShader);
		vulkanResourcePkg.getResources().add(fragmentShader);
		vulkanResourcePkg.getResources().add(memoryChunk);
		if (constantBuffer != null) vulkanResourcePkg.getResources().add(constantBuffer);

		if (meshConfiguration.useTexture)
		{
			final var imageFileResource = ResourceFactory.eINSTANCE.createModuleResource();
			imageFileResource.setModule(module);
			imageFileResource.setPath(meshConfiguration.texturePath);
			final var imageFile = ResourceFactory.eINSTANCE.createFileImage();
			imageFile.setFile(imageFileResource);

			final var textureProvider = VulkanResourceFactory.eINSTANCE.createFileImageDataProvider();
			textureProvider.setFileImageContainment(imageFile);

			final var imageViewer = VulkanResourceFactory.eINSTANCE.createImageViewer();
			imageViewer.setDataProvider(textureProvider);
			imageViewer.setMipmapEnabled(true);
			imageViewer.setFormat(EFormat.R8G8B8A8_UNORM);
			imageViewer.getUsages().add(EImageUsage.SAMPLED);
			imageViewer.getUsages().add(EImageUsage.TRANSFER_DST);
			imageViewer.setInitialLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
			memoryChunk.getParts().add(imageViewer);

			final var sampler = VulkanResourceFactory.eINSTANCE.createSampler();

			final var sampledImageDescriptor = VulkanResourceFactory.eINSTANCE.createImageDescriptor();
			sampledImageDescriptor.setType(EDescriptorType.COMBINED_IMAGE_SAMPLER);
			sampledImageDescriptor.getShaderStages().add(EShaderStage.FRAGMENT_BIT);
			sampledImageDescriptor.setLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL);
			sampledImageDescriptor.setSampler(sampler);
			sampledImageDescriptor.getImages().add(imageViewer);

			vulkanResourcePkg.getResources().add(sampler);

			final var descriptorSet = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
			descriptorSet.getDescriptors().add(sampledImageDescriptor);

			final var descriptorPkg = VulkanFactory.eINSTANCE.createDescriptorPkg();
			descriptorPkg.getDescriptors().add(sampledImageDescriptor);
			graphicPipeline.setDescriptorPkg(descriptorPkg);

			final DescriptorPool descriptorPool = VulkanResourceFactory.eINSTANCE.createDescriptorPool();
			graphicPipeline.setDescriptorPool(descriptorPool);
			bindDescriptorSets.getDescriptorSets().add(descriptorSet);
			graphicPipeline.getLayout().add(descriptorSet);
			descriptorPool.getDescriptorSets().add(descriptorSet);
		}

		return List.of(graphicPipeline);
	}
}
