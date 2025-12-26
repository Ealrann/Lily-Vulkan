package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.lily.vulkan.demo.adapter.CameraConstantAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.Sampler;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.vulkan.model.enumeration.*;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;
import org.sheepy.vulkan.model.graphicpipeline.StaticViewportState;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;

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
		final var pipelines = buildPipelines();
		final var pipelinePkg = PipelinePkg.builder().addPipelines(pipelines).build();
		final var attachmentRefPkg = AttachmentRefPkg.builder().build();

		final var colorRef = AttachmentRef.builder()
										  .layout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL)
										  .attachment(() -> process.configuration().swapchainConfiguration().colorAttachment())
										  .build();
		attachmentRefPkg.attachmentRefs().add(colorRef);

		if (meshConfiguration.depth)
		{
			final var depthAttachment = process.attachmentPkg().extraAttachments().get(0);
			final var depthRef = AttachmentRef.builder()
											  .layout(EImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
											  .attachment(() -> depthAttachment)
											  .type(EAttachmentType.Depth)
											  .build();
			attachmentRefPkg.attachmentRefs().add(depthRef);
		}

		return Subpass.builder()
					  .waitForStage(EPipelineStage.TOP_OF_PIPE_BIT)
					  .syncStage(EPipelineStage.EARLY_FRAGMENT_TESTS_BIT)
					  .attachmentRefPkg(() -> attachmentRefPkg)
					  .pipelinePkg(() -> pipelinePkg)
					  .build();
	}

	private List<AbstractPipeline> buildPipelines()
	{
		final var module = meshConfiguration.module;

		final var vertexShaderFile = ModuleResource.builder()
												   .module(module)
												   .path(meshConfiguration.vertexShaderPath)
												   .build();

		final var fragmentShaderFile = ModuleResource.builder()
													 .module(module)
													 .path(meshConfiguration.fragmentShaderPath)
													 .build();

		final var vertexShader = Shader.builder()
									   .file(() -> vertexShaderFile)
									   .stage(EShaderStage.VERTEX_BIT)
									   .build();

		final var fragmentShader = Shader.builder()
										 .file(() -> fragmentShaderFile)
										 .stage(EShaderStage.FRAGMENT_BIT)
										 .build();

		final var vertexBuffer = org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer.builder()
																					 .addUsage(EBufferUsage.VERTEX_BUFFER_BIT)
																					 .addUsage(EBufferUsage.INDEX_BUFFER_BIT)
																					 .addUsage(EBufferUsage.TRANSFER_DST_BIT)
																					 .data(meshConfiguration.vertexData)
																					 .build();
		final var indexBuffer = org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer.builder()
																					.addUsage(EBufferUsage.VERTEX_BUFFER_BIT)
																					.addUsage(EBufferUsage.INDEX_BUFFER_BIT)
																					.addUsage(EBufferUsage.TRANSFER_DST_BIT)
																					.data(meshConfiguration.indexData)
																					.build();

		final var bufferMemory = org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory.builder()
																						.addBuffer(() -> vertexBuffer)
																						.addBuffer(() -> indexBuffer)
																						.build();
		final var memoryChunk = MemoryChunk.builder().build();
		memoryChunk.parts().add(bufferMemory);

		final PushConstantRange pushConstantRange;
		final PushConstantBuffer pushConstants;
		final ConstantBuffer constantBuffer;
		if (meshConfiguration.useCamera)
		{
			constantBuffer = ConstantBuffer.builder()
										   .name(CameraConstantAdapter.DEMO_CAMERA)
										   .build();

			pushConstants = PushConstantBuffer.builder()
											  .addStage(EShaderStage.VERTEX_BIT)
											  .buffer(() -> constantBuffer)
											  .build();

			pushConstantRange = PushConstantRange.builder()
												 .size(CameraConstantAdapter.SIZE_OF)
												 .addStage(EShaderStage.VERTEX_BIT)
												 .build();
		}
		else
		{
			pushConstantRange = null;
			pushConstants = null;
			constantBuffer = null;
		}

		final var rasterizer = Rasterizer.builder()
										 .frontFace(meshConfiguration.rasterizerFrontFace)
										 .build();

		final var viewportState = StaticViewportState.builder()
													 .addViewport(Viewport.builder()::build)
													 .addScissor(Scissor.builder()::build)
													 .build();

		final var colorBlend = ColorBlend.builder()
										 .addAttachment(ColorBlendAttachment.builder()::build)
										 .build();

		final var locationAttribute = AttributeDescription.builder()
														  .format(meshConfiguration.useTexture ? EFormat.R32G32B32_SFLOAT : EFormat.R32G32_SFLOAT)
														  .offset(0)
														  .build();

		final var colorAttribute = AttributeDescription.builder()
													   .format(EFormat.R32G32B32_SFLOAT)
													   .offset(meshConfiguration.useTexture ? 12 : 8)
													   .build();

		final var textureAttribute = AttributeDescription.builder()
														 .format(EFormat.R32G32_SFLOAT)
														 .offset(24)
														 .build();

		final int strideLength = meshConfiguration.useTexture ? 32 : 20;

		final var inputDescriptor = InputDescriptor.builder()
												   .strideLength(strideLength)
												   .addAttribute(() -> locationAttribute)
												   .addAttribute(() -> colorAttribute)
												   .build();
		if (meshConfiguration.useTexture) inputDescriptor.attributes().add(textureAttribute);

		final var inputState = VertexInputState.builder()
											   .addInputDescriptor(() -> inputDescriptor)
											   .build();

		final var bindDescriptorSets = BindDescriptorSets.builder()
														 .bindPoint(EBindPoint.GRAPHICS)
														 .build();
		final var bindVertexBuffer = BindVertexBuffer.builder()
													 .addVertexBinding(() -> VertexBinding.builder()
																						  .buffer(() -> vertexBuffer)
																						  .build())
													 .build();
		final var bindIndexBuffer = BindIndexBuffer.builder()
												   .buffer(() -> indexBuffer)
												   .indexType(EIndexType.UINT32)
												   .build();
		final var drawIndexed = DrawIndexed.builder()
										   .indexCount(meshConfiguration.indexCount)
										   .build();

		final var taskPkgBuilder = TaskPkg.builder()
										  .addTask(() -> bindDescriptorSets);
		if (meshConfiguration.useCamera) taskPkgBuilder.addTask(() -> pushConstants);
		final var taskPkg = taskPkgBuilder
				.addTask(() -> bindVertexBuffer)
				.addTask(() -> bindIndexBuffer)
				.addTask(() -> drawIndexed)
				.stage(ECommandStage.MAIN)
				.build();

		final var vulkanResourcePkg = VulkanResourcePkg.builder().build();
		vulkanResourcePkg.resources().add(vertexShader);
		vulkanResourcePkg.resources().add(fragmentShader);
		vulkanResourcePkg.resources().add(memoryChunk);
		if (constantBuffer != null) vulkanResourcePkg.resources().add(constantBuffer);

		final var graphicPipelineBuilder = GraphicsPipeline.builder()
														   .addShader(() -> vertexShader)
														   .addShader(() -> fragmentShader)
														   .rasterizer(() -> rasterizer)
														   .inputAssembly(InputAssembly.builder()::build)
														   .viewportState(() -> viewportState)
														   .colorBlend(() -> colorBlend)
														   .vertexInputState(() -> inputState)
														   .addTaskPkg(() -> taskPkg)
														   .resourcePkg(() -> vulkanResourcePkg);
		if (meshConfiguration.depth) graphicPipelineBuilder.depthStencilState(DepthStencilState.builder()::build);
		if (pushConstantRange != null) graphicPipelineBuilder.addPushConstantRange(() -> pushConstantRange);

		final var graphicPipeline = graphicPipelineBuilder.build();

		if (meshConfiguration.useTexture)
		{
			final var imageFileResource = ModuleResource.builder()
														.module(module)
														.path(meshConfiguration.texturePath)
														.build();
			final var imageFile = FileImage.builder()
										   .file(() -> imageFileResource)
										   .build();

			final var textureProvider = FileImageDataProvider.builder()
															 .fileImageReference(() -> null)
															 .fileImageContainment(() -> imageFile)
															 .build();

			final var imageViewer = ImageViewer.builder()
											   .dataProvider(() -> textureProvider)
											   .mipmapEnabled(true)
											   .format(EFormat.R8G8B8A8_UNORM)
											   .addUsage(EImageUsage.SAMPLED)
											   .addUsage(EImageUsage.TRANSFER_DST)
											   .initialLayout(EImageLayout.SHADER_READ_ONLY_OPTIMAL)
											   .build();
			memoryChunk.parts().add(imageViewer);

			final var sampler = Sampler.builder().build();

			final var sampledImageDescriptor = ImageDescriptor.builder()
															  .type(EDescriptorType.COMBINED_IMAGE_SAMPLER)
															  .addShaderStage(EShaderStage.FRAGMENT_BIT)
															  .layout(EImageLayout.SHADER_READ_ONLY_OPTIMAL)
															  .sampler(() -> sampler)
															  .addImage(() -> imageViewer)
															  .build();

			vulkanResourcePkg.resources().add(sampler);

			final var descriptorSet = org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet.builder()
																							   .addDescriptor(() -> sampledImageDescriptor)
																							   .build();

			final var descriptorPkg = DescriptorPkg.builder()
												   .addDescriptor(() -> sampledImageDescriptor)
												   .build();
			graphicPipeline.descriptorPkg(descriptorPkg);

			final DescriptorPool descriptorPool = DescriptorPool.builder().build();
			graphicPipeline.descriptorPool(descriptorPool);
			bindDescriptorSets.descriptorSets().add(descriptorSet);
			graphicPipeline.layout().add(descriptorSet);
			descriptorPool.descriptorSets().add(descriptorSet);
		}

		return List.of(graphicPipeline);
	}
}
