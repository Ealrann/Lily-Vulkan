package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.joml.Vector2ic;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.demo.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.*;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.*;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.resource.*;
import org.sheepy.vulkan.model.enumeration.*;

public final class EngineBuilder
{
	public static final int WORKGROUP_SIDE = 8;
	public static int FRAME_COUNT = 0;

	private static final String SHADER_LIFE = "life.comp.spv";
	private static final String SHADER_LIFE2PIXEL = "life2pixel.comp.spv";

	private final Vector2ic size;

	public final StaticImage boardImage;
	public final SwapImageAttachment colorAttachment = GraphicFactory.eINSTANCE.createSwapImageAttachment();

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
		final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();

		final var sharedResources = VulkanFactory.eINSTANCE.createVulkanResourcePkg();
		final var sharedDescriptors = VulkanFactory.eINSTANCE.createDescriptorPkg();

		final var swapchainConfiguration = GraphicFactory.eINSTANCE.createSwapchainConfiguration();
		swapchainConfiguration.getSwapImageUsages().add(EImageUsage.TRANSFER_DST);
		swapchainConfiguration.getSwapImageUsages().add(EImageUsage.COLOR_ATTACHMENT);
		swapchainConfiguration.setAcquireWaitForVBlank(false);
		swapchainConfiguration.setPresentWhenVBlank(false);
		swapchainConfiguration.setAllowingAccessFromCompute(true);
		swapchainConfiguration.setColorAttachment(colorAttachment);

		final var framebufferConfiguration = GraphicFactory.eINSTANCE.createFramebufferConfiguration();
		final var configuration = GraphicFactory.eINSTANCE.createGraphicConfiguration();
		final var surface = GraphicFactory.eINSTANCE.createPhysicalSurface();
		final var renderPass = GraphicFactory.eINSTANCE.createRenderPass();
		final var imageViews = GraphicFactory.eINSTANCE.createImageViews();
		surface.setColorDomain(GraphicFactory.eINSTANCE.createColorDomain());

		configuration.setAcquireWaitStage(EPipelineStage.TRANSFER_BIT);
		configuration.setSwapchainConfiguration(swapchainConfiguration);
		configuration.setFramebufferConfiguration(framebufferConfiguration);
		configuration.setSurface(surface);
		configuration.setRenderPass(renderPass);
		configuration.setImageViews(imageViews);

		createComputeProcessPool(sharedResources, sharedDescriptors);

		loadColorAttachment();
		graphicProcess = GraphicFactory.eINSTANCE.createGraphicProcess();
		graphicProcess.setConfiguration(configuration);
		graphicProcess.setExecutionManager(GraphicFactory.eINSTANCE.createGraphicExecutionManager());
		graphicProcess.setCadence(buildCadence(FRAME_COUNT));
		graphicProcess.setResetAllowed(true);

		engine.getProcesses().add(barrierProcess);
		engine.getProcesses().add(lifeProcess);
		engine.getProcesses().add(pixelProcess);
		engine.getProcesses().add(graphicProcess);
		engine.setVulkanResourcePkg(sharedResources);
		engine.setDescriptorPkg(sharedDescriptors);

		return engine;
	}

	private void loadColorAttachment()
	{
		colorAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachment.setLoadOp(EAttachmentLoadOp.LOAD);
		colorAttachment.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.setInitialLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		colorAttachment.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);
	}

	private void createComputeProcessPool(VulkanResourcePkg sharedResources, DescriptorPkg sharedDescriptors)
	{
		lifeProcess = ComputeFactory.eINSTANCE.createComputeProcess();
		pixelProcess = ComputeFactory.eINSTANCE.createComputeProcess();

		lifeProcess.setName("Life Process");
		pixelProcess.setName("Pixel Process");

		lifeProcess.setResetAllowed(true);
		pixelProcess.setResetAllowed(true);

		lifeProcess.setConfiguration(ComputeFactory.eINSTANCE.createComputeConfiguration());
		pixelProcess.setConfiguration(ComputeFactory.eINSTANCE.createComputeConfiguration());

		final ComputeExecutionManager lifeExecutionManager = ComputeFactory.eINSTANCE.createComputeExecutionManager();
		final ComputeExecutionManager pixelExecutionManager = ComputeFactory.eINSTANCE.createComputeExecutionManager();
		lifeExecutionManager.setIndexCount(2);
		pixelExecutionManager.setIndexCount(1);
		lifeProcess.setExecutionManager(lifeExecutionManager);
		pixelProcess.setExecutionManager(pixelExecutionManager);

		createBarrierProcess();

		final Module thisModule = getClass().getModule();

		final var lifeShaderFile = ResourceFactory.eINSTANCE.createModuleResource();
		lifeShaderFile.setModule(thisModule);
		lifeShaderFile.setPath(SHADER_LIFE);

		final var life2pixelShaderFile = ResourceFactory.eINSTANCE.createModuleResource();
		life2pixelShaderFile.setModule(thisModule);
		life2pixelShaderFile.setPath(SHADER_LIFE2PIXEL);

		final Shader lifeShader = VulkanResourceFactory.eINSTANCE.createShader();
		lifeShader.setFile(lifeShaderFile);
		lifeShader.setStage(EShaderStage.COMPUTE_BIT);

		final Shader life2pixelShader = VulkanResourceFactory.eINSTANCE.createShader();
		life2pixelShader.setFile(life2pixelShaderFile);
		life2pixelShader.setStage(EShaderStage.COMPUTE_BIT);

		final Board board = Board.createTestBoard(size);
		final var memoryChunk = VulkanResourceFactory.eINSTANCE.createMemoryChunk();
		final var bufferMemory = VulkanResourceFactory.eINSTANCE.createBufferMemory();
		final var boardBuffer1 = BoardBufferFactory.createBoardBuffer(board);
		final var boardBuffer2 = BoardBufferFactory.createBoardBuffer(board);
		boardBuffer1.setName("BoardBuffer1");
		boardBuffer2.setName("BoardBuffer2");
		bufferMemory.getBuffers().add(boardBuffer1);
		bufferMemory.getBuffers().add(boardBuffer2);
		memoryChunk.getParts().add(bufferMemory);
		memoryChunk.getParts().add(boardImage);

		final var boardBuffer1Descriptor = newDescriptor(boardBuffer1);
		final var boardBuffer2Descriptor = newDescriptor(boardBuffer2);
		final var boardImageDescriptor = newDescriptor(boardImage);

		final var lifeDescriptorSet1 = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
		final var lifeDescriptorSet2 = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
		final var pixelDescriptorSet1 = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
		final var pixelDescriptorSet2 = VulkanResourceFactory.eINSTANCE.createDescriptorSet();

		lifeDescriptorSet1.getDescriptors().add(boardBuffer1Descriptor);
		lifeDescriptorSet1.getDescriptors().add(boardBuffer2Descriptor);
		lifeDescriptorSet2.getDescriptors().add(boardBuffer2Descriptor);
		lifeDescriptorSet2.getDescriptors().add(boardBuffer1Descriptor);
		pixelDescriptorSet1.getDescriptors().add(boardBuffer2Descriptor);
		pixelDescriptorSet1.getDescriptors().add(boardImageDescriptor);
		pixelDescriptorSet2.getDescriptors().add(boardBuffer1Descriptor);
		pixelDescriptorSet2.getDescriptors().add(boardImageDescriptor);

		final var lifeDescriptorPool = VulkanResourceFactory.eINSTANCE.createDescriptorPool();
		lifeDescriptorPool.getDescriptorSets().add(lifeDescriptorSet1);
		lifeDescriptorPool.getDescriptorSets().add(lifeDescriptorSet2);
		final var pixelDescriptorPool = VulkanResourceFactory.eINSTANCE.createDescriptorPool();
		pixelDescriptorPool.getDescriptorSets().add(pixelDescriptorSet1);
		pixelDescriptorPool.getDescriptorSets().add(pixelDescriptorSet2);
		lifeProcess.setDescriptorPool(lifeDescriptorPool);
		pixelProcess.setDescriptorPool(pixelDescriptorPool);

		final var lifePipeline = createPipeline(lifeShader, lifeDescriptorSet1, lifeDescriptorSet2);
		final var pixelPipeline = createPipeline(life2pixelShader, pixelDescriptorSet1, pixelDescriptorSet2);

		final var lifePipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		lifePipelinePkg.getPipelines().add(lifePipeline);
		lifeProcess.setPipelinePkg(lifePipelinePkg);

		final var pixelPipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		pixelPipelinePkg.getPipelines().add(pixelPipeline);
		pixelProcess.setPipelinePkg(pixelPipelinePkg);

		sharedResources.getResources().add(lifeShader);
		sharedResources.getResources().add(life2pixelShader);
		sharedResources.getResources().add(memoryChunk);

		sharedDescriptors.getDescriptors().add(boardBuffer1Descriptor);
		sharedDescriptors.getDescriptors().add(boardBuffer2Descriptor);
		sharedDescriptors.getDescriptors().add(boardImageDescriptor);

		lifeProcess.setResetAllowed(true);
		pixelProcess.setResetAllowed(true);
	}

	private void createBarrierProcess()
	{
		barrierProcess = ComputeFactory.eINSTANCE.createComputeProcess();
		barrierProcess.setConfiguration(ComputeFactory.eINSTANCE.createComputeConfiguration());
		barrierProcess.setExecutionManager(ComputeFactory.eINSTANCE.createComputeExecutionManager());
		barrierProcess.setPipelinePkg(ProcessFactory.eINSTANCE.createPipelinePkg());
		barrierProcess.setResetAllowed(true);

		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		final var pipeline = ProcessFactory.eINSTANCE.createPipeline();
		pipeline.getTaskPkgs().add(taskPkg);

		final var pipelineBarrier = ProcessFactory.eINSTANCE.createPipelineBarrier();
		final var imageBarrier = VulkanResourceFactory.eINSTANCE.createImageBarrier();
		imageBarrier.setImage(boardImage);
		imageBarrier.setDstLayout(EImageLayout.GENERAL);
		imageBarrier.getDstAccessMask().add(EAccess.SHADER_WRITE_BIT);

		pipelineBarrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		pipelineBarrier.setDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		pipelineBarrier.getBarriers().add(imageBarrier);

		barrierProcess.getPipelinePkg().getPipelines().add(pipeline);
		taskPkg.getTasks().add(pipelineBarrier);

		final var cadence = CadenceFactory.eINSTANCE.createCadence();
		final var runBarrierProcess = VulkanFactory.eINSTANCE.createRunProcess();
		runBarrierProcess.setProcess(barrierProcess);
		cadence.getTasks().add(runBarrierProcess);
		barrierProcess.setCadence(cadence);
	}

	private ComputePipeline createPipeline(Shader shader, DescriptorSet ds1, DescriptorSet ds2)
	{
		final var bindTask = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		bindTask.setBindPoint(EBindPoint.COMPUTE);
		bindTask.getDescriptorSets().add(ds1);
		bindTask.getDescriptorSets().add(ds2);
		bindTask.setStride(1);
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		final var dispatch = createDispatchTask();

		final var pipeline = ComputeFactory.eINSTANCE.createComputePipeline();
		pipeline.getTaskPkgs().add(taskPkg);
		taskPkg.getTasks().add(bindTask);
		taskPkg.getTasks().add(dispatch);

		pipeline.getLayout().add(ds1);
		pipeline.setShader(shader);

		return pipeline;
	}

	private DispatchTask createDispatchTask()
	{
		final var res = ComputeFactory.eINSTANCE.createDispatchTask();
		res.setWorkgroupCountX(size.x() / WORKGROUP_SIDE);
		res.setWorkgroupCountY(size.y() / WORKGROUP_SIDE);
		return res;
	}

	private Cadence buildCadence(int frameCount)
	{
		final var runComputeLifeTask = VulkanFactory.eINSTANCE.createRunProcess();
		final var runComputePixelTask = VulkanFactory.eINSTANCE.createRunProcess();
		final var runGraphicTask = VulkanFactory.eINSTANCE.createRunProcess();
		final var executeWhile = CadenceFactory.eINSTANCE.createExecuteWhile();
		final var printUPS = CadenceFactory.eINSTANCE.createPrintUPS();
		final var cadence = CadenceFactory.eINSTANCE.createCadence();
		final var haveTime = CadenceFactory.eINSTANCE.createHaveTime();
		final var loopTasks = executeWhile.getTasks();

		runComputeLifeTask.setProcess(lifeProcess);
		runComputePixelTask.setProcess(pixelProcess);
		runGraphicTask.setProcess(graphicProcess);
		printUPS.setPrintEveryMs(1200);
		cadence.setFrequency(60);
		executeWhile.getConditions().add(haveTime);
		loopTasks.add(printUPS);
		loopTasks.add(runComputeLifeTask);

		cadence.getTasks().add(runComputePixelTask);
		cadence.getTasks().add(runGraphicTask);
		cadence.getTasks().add(executeWhile);

		if (frameCount > 0)
		{
			final var executeIf = CadenceFactory.eINSTANCE.createExecuteIf();
			final var countUntil = CadenceFactory.eINSTANCE.createCountUntil();
			final var closeApp = CadenceFactory.eINSTANCE.createCloseApplication();
			countUntil.setTotalCount(frameCount);
			executeIf.getConditions().add(countUntil);
			executeIf.getTasks().add(closeApp);

			loopTasks.add(executeIf);
		}

		return cadence;
	}

	private static IDescriptor newDescriptor(IBuffer buffer)
	{
		final var descriptor = VulkanResourceFactory.eINSTANCE.createBufferDescriptor();
		descriptor.setType(EDescriptorType.STORAGE_BUFFER);
		descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
		descriptor.setBuffer(buffer);
		return descriptor;
	}

	private static IDescriptor newDescriptor(VulkanImage image)
	{
		final var descriptor = VulkanResourceFactory.eINSTANCE.createImageDescriptor();
		descriptor.setType(EDescriptorType.STORAGE_IMAGE);
		descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
		descriptor.setImage(image);
		return descriptor;
	}
}