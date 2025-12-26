package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.joml.Vector2ic;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CloseApplication;
import org.sheepy.lily.core.model.cadence.CountUntil;
import org.sheepy.lily.core.model.cadence.ExecuteIf;
import org.sheepy.lily.core.model.cadence.ExecuteWhile;
import org.sheepy.lily.core.model.cadence.HaveTime;
import org.sheepy.lily.core.model.cadence.PrintUPS;
import org.sheepy.lily.core.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.demo.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkan.RunProcess;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EBindPoint;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class EngineBuilder
{
	public static final int WORKGROUP_SIDE = 8;
	public static int FRAME_COUNT = 0;

	private static final String SHADER_LIFE = "life.comp.spv";
	private static final String SHADER_LIFE2PIXEL = "life2pixel.comp.spv";

	private final Vector2ic size;

	public final StaticImage boardImage;
	public final SwapImageAttachment colorAttachment = SwapImageAttachment.builder().build();

	private GraphicProcess graphicProcess;
	private ComputeProcess barrierProcess;
	private ComputeProcess lifeProcess;
	private ComputeProcess pixelProcess;

	public EngineBuilder(Vector2ic size)
	{
		this.size = size;
		boardImage = BoardImageFactory.createBoardImage(size);
	}

	public IEngine build()
	{
		final var sharedResources = VulkanResourcePkg.builder().build();
		final var sharedDescriptors = DescriptorPkg.builder().build();

		final var swapchainConfiguration = SwapchainConfiguration.builder()
																 .addSwapImageUsage(EImageUsage.TRANSFER_DST)
																 .addSwapImageUsage(EImageUsage.COLOR_ATTACHMENT)
																 .acquireWaitForVBlank(false)
																 .presentWhenVBlank(false)
																 .allowingAccessFromCompute(true)
																 .colorAttachment(() -> colorAttachment)
																 .build();

		final var configuration = GraphicConfiguration.builder()
													  .acquireWaitStage(EPipelineStage.TRANSFER_BIT)
													  .swapchainConfiguration(() -> swapchainConfiguration)
													  .framebufferConfiguration(FramebufferConfiguration.builder()::build)
													  .surface(() -> PhysicalSurface.builder()
																					.colorDomain(ColorDomain.builder()::build)
																					.build())
													  .renderPass(RenderPass.builder()::build)
													  .imageViews(ImageViews.builder()::build)
													  .build();

		createComputeProcessPool(sharedResources, sharedDescriptors);
		loadColorAttachment();

		graphicProcess = GraphicProcess.builder()
									   .configuration(() -> configuration)
									   .executionManager(GraphicExecutionManager.builder()::build)
									   .attachmentPkg(AttachmentPkg.builder()::build)
									   .resetAllowed(true)
									   .build();
		graphicProcess.cadence(buildCadence(FRAME_COUNT));

		return VulkanEngine.builder()
						   .resourcePkg(() -> sharedResources)
						   .descriptorPkg(() -> sharedDescriptors)
						   .addProcesse(() -> barrierProcess)
						   .addProcesse(() -> lifeProcess)
						   .addProcesse(() -> pixelProcess)
						   .addProcesse(() -> graphicProcess)
						   .build();
	}

	private void loadColorAttachment()
	{
		colorAttachment.samples(ESampleCount.SAMPLE_COUNT_1_BIT);
		colorAttachment.loadOp(EAttachmentLoadOp.LOAD);
		colorAttachment.storeOp(EAttachmentStoreOp.STORE);
		colorAttachment.stencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.stencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.initialLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		colorAttachment.finalLayout(EImageLayout.PRESENT_SRC_KHR);
	}

	private void createComputeProcessPool(VulkanResourcePkg sharedResources, DescriptorPkg sharedDescriptors)
	{
		final var lifeExecutionManager = ComputeExecutionManager.builder().indexCount(2).build();
		final var pixelExecutionManager = ComputeExecutionManager.builder().indexCount(1).build();

		lifeProcess = ComputeProcess.builder()
									.name("Life Process")
									.resetAllowed(true)
									.configuration(ComputeConfiguration.builder()::build)
									.executionManager(() -> lifeExecutionManager)
									.build();
		pixelProcess = ComputeProcess.builder()
									 .name("Pixel Process")
									 .resetAllowed(true)
									 .configuration(ComputeConfiguration.builder()::build)
									 .executionManager(() -> pixelExecutionManager)
									 .build();

		createBarrierProcess();

		final Module thisModule = getClass().getModule();

		final var lifeShaderFile = ModuleResource.builder()
												 .module(thisModule)
												 .path(SHADER_LIFE)
												 .build();
		final var life2pixelShaderFile = ModuleResource.builder()
													   .module(thisModule)
													   .path(SHADER_LIFE2PIXEL)
													   .build();

		final var lifeShader = Shader.builder()
									 .file(() -> lifeShaderFile)
									 .stage(EShaderStage.COMPUTE_BIT)
									 .build();
		final var life2pixelShader = Shader.builder()
										   .file(() -> life2pixelShaderFile)
										   .stage(EShaderStage.COMPUTE_BIT)
										   .build();

		final Board board = Board.createTestBoard(size);
		final var boardBuffer1 = BoardBufferFactory.createBoardBuffer(board, "BoardBuffer1");
		final var boardBuffer2 = BoardBufferFactory.createBoardBuffer(board, "BoardBuffer2");

		final var bufferMemory = BufferMemory.builder()
											 .addBuffer(() -> boardBuffer1)
											 .addBuffer(() -> boardBuffer2)
											 .build();
		final var memoryChunk = MemoryChunk.builder()
										   .addPart(() -> bufferMemory)
										   .addPart(() -> boardImage)
										   .build();

		final var boardBuffer1Descriptor = newDescriptor(boardBuffer1);
		final var boardBuffer2Descriptor = newDescriptor(boardBuffer2);
		final var boardImageDescriptor = newDescriptor(boardImage);

		final var lifeDescriptorSet1 = DescriptorSet.builder()
													.addDescriptor(() -> boardBuffer1Descriptor)
													.addDescriptor(() -> boardBuffer2Descriptor)
													.build();
		final var lifeDescriptorSet2 = DescriptorSet.builder()
													.addDescriptor(() -> boardBuffer2Descriptor)
													.addDescriptor(() -> boardBuffer1Descriptor)
													.build();
		final var pixelDescriptorSet1 = DescriptorSet.builder()
													 .addDescriptor(() -> boardBuffer2Descriptor)
													 .addDescriptor(() -> boardImageDescriptor)
													 .build();
		final var pixelDescriptorSet2 = DescriptorSet.builder()
													 .addDescriptor(() -> boardBuffer1Descriptor)
													 .addDescriptor(() -> boardImageDescriptor)
													 .build();

		final var lifeDescriptorPool = DescriptorPool.builder()
													 .addDescriptorSet(() -> lifeDescriptorSet1)
													 .addDescriptorSet(() -> lifeDescriptorSet2)
													 .build();
		final var pixelDescriptorPool = DescriptorPool.builder()
													  .addDescriptorSet(() -> pixelDescriptorSet1)
													  .addDescriptorSet(() -> pixelDescriptorSet2)
													  .build();
		lifeProcess.descriptorPool(lifeDescriptorPool);
		pixelProcess.descriptorPool(pixelDescriptorPool);

		final var lifePipeline = createPipeline(lifeShader, lifeDescriptorSet1, lifeDescriptorSet2);
		final var pixelPipeline = createPipeline(life2pixelShader, pixelDescriptorSet1, pixelDescriptorSet2);

		lifeProcess.pipelinePkg(PipelinePkg.builder()
										   .addPipeline(() -> lifePipeline)
										   .build());
		pixelProcess.pipelinePkg(PipelinePkg.builder()
											.addPipeline(() -> pixelPipeline)
											.build());

		sharedResources.resources().add(lifeShader);
		sharedResources.resources().add(life2pixelShader);
		sharedResources.resources().add(memoryChunk);

		sharedDescriptors.descriptors().add(boardBuffer1Descriptor);
		sharedDescriptors.descriptors().add(boardBuffer2Descriptor);
		sharedDescriptors.descriptors().add(boardImageDescriptor);
	}

	private void createBarrierProcess()
	{
		final var imageBarrier = ImageBarrier.builder()
											 .image(() -> boardImage)
											 .srcLayout(EImageLayout.UNDEFINED)
											 .dstLayout(EImageLayout.GENERAL)
											 .addDstAccessMask(EAccess.SHADER_WRITE_BIT)
											 .build();

		final var pipelineBarrier = PipelineBarrier.builder()
												   .srcStage(EPipelineStage.TRANSFER_BIT)
												   .dstStage(EPipelineStage.COMPUTE_SHADER_BIT)
												   .addBarrier(() -> imageBarrier)
												   .build();

		final var taskPkg = TaskPkg.builder()
								   .addTask(() -> pipelineBarrier)
								   .build();
		final var pipeline = Pipeline.builder()
									 .addTaskPkg(() -> taskPkg)
									 .build();
		final var pipelinePkg = PipelinePkg.builder()
										   .addPipeline(() -> pipeline)
										   .build();

		barrierProcess = ComputeProcess.builder()
									   .configuration(ComputeConfiguration.builder()::build)
									   .executionManager(ComputeExecutionManager.builder()::build)
									   .pipelinePkg(() -> pipelinePkg)
									   .resetAllowed(true)
									   .build();

		final var runBarrierProcess = RunProcess.builder()
												.process(() -> barrierProcess)
												.build();
		final var cadence = Cadence.builder()
								   .addTask(() -> runBarrierProcess)
								   .build();
		barrierProcess.cadence(cadence);
	}

	private ComputePipeline createPipeline(Shader shader, DescriptorSet ds1, DescriptorSet ds2)
	{
		final var bindTask = BindDescriptorSets.builder()
											   .bindPoint(EBindPoint.COMPUTE)
											   .addDescriptorSet(() -> ds1)
											   .addDescriptorSet(() -> ds2)
											   .stride(1)
											   .build();
		final var taskPkg = TaskPkg.builder().build();
		final var dispatch = createDispatchTask();

		taskPkg.tasks().add(bindTask);
		taskPkg.tasks().add(dispatch);

		return ComputePipeline.builder()
							  .addTaskPkg(() -> taskPkg)
							  .addLayout(() -> ds1)
							  .shader(() -> shader)
							  .build();
	}

	private DispatchTask createDispatchTask()
	{
		return DispatchTask.builder()
						   .workgroupCountX(size.x() / WORKGROUP_SIDE)
						   .workgroupCountY(size.y() / WORKGROUP_SIDE)
						   .build();
	}

	private Cadence buildCadence(int frameCount)
	{
		final var runComputeLifeTask = RunProcess.builder()
												 .process(() -> lifeProcess)
												 .build();
		final var runComputePixelTask = RunProcess.builder()
												  .process(() -> pixelProcess)
												  .build();
		final var runGraphicTask = RunProcess.builder()
											 .process(() -> graphicProcess)
											 .build();
		final var executeWhile = ExecuteWhile.builder()
											 .addCondition(HaveTime.builder()::build)
											 .addTask(() -> PrintUPS.builder().printEveryMs(1200).build())
											 .addTask(() -> runComputeLifeTask)
											 .build();

		final var cadence = Cadence.builder()
								   .frequency(60)
								   .addTask(() -> runComputePixelTask)
								   .addTask(() -> runGraphicTask)
								   .addTask(() -> executeWhile)
								   .build();

		if (frameCount > 0)
		{
			final var executeIf = ExecuteIf.builder()
										   .addCondition(() -> CountUntil.builder().totalCount(frameCount).build())
										   .addTask(() -> CloseApplication.builder().build())
										   .build();
			executeWhile.tasks().add(executeIf);
		}

		return cadence;
	}

	private static IDescriptor newDescriptor(IBuffer buffer)
	{
		return BufferDescriptor.builder()
							   .type(EDescriptorType.STORAGE_BUFFER)
							   .addShaderStage(EShaderStage.COMPUTE_BIT)
							   .buffer(() -> buffer)
							   .build();
	}

	private static IDescriptor newDescriptor(IVulkanImage image)
	{
		return ImageDescriptor.builder()
							  .type(EDescriptorType.STORAGE_IMAGE)
							  .addShaderStage(EShaderStage.COMPUTE_BIT)
							  .addImage(() -> image)
							  .build();
	}
}
