package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.joml.Vector2ic;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.vulkan.demo.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.DescriptorPkg;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.binding.BindingConfiguration;
import org.sheepy.lily.vulkan.model.binding.BindingFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
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

		final var sharedResources = ResourceFactory.eINSTANCE.createResourcePkg();
		final var sharedDescriptors = VulkanFactory.eINSTANCE.createDescriptorPkg();

		final var swapchainConfiguration = GraphicFactory.eINSTANCE.createSwapchainConfiguration();
		swapchainConfiguration.getSwapImageUsages().add(EImageUsage.TRANSFER_DST);
		swapchainConfiguration.getSwapImageUsages().add(EImageUsage.COLOR_ATTACHMENT);
		swapchainConfiguration.setAcquireWaitForVBlank(false);
		swapchainConfiguration.setPresentWhenVBlank(false);
		swapchainConfiguration.setAllowingAccessFromCompute(true);

		final var framebufferConfiguration = GraphicFactory.eINSTANCE.createFramebufferConfiguration();
		final var configuration = GraphicFactory.eINSTANCE.createGraphicConfiguration();
		configuration.setColorDomain(GraphicFactory.eINSTANCE.createColorDomain());
		configuration.setAcquireWaitStage(EPipelineStage.TRANSFER_BIT);
		configuration.setSwapchainConfiguration(swapchainConfiguration);
		configuration.setFramebufferConfiguration(framebufferConfiguration);

		createComputeProcessPool(sharedResources, sharedDescriptors);

		graphicProcess = GraphicFactory.eINSTANCE.createGraphicProcess();
		graphicProcess.setConfiguration(configuration);
		graphicProcess.setAttachmentPkg(newAttachmentPkg());
		graphicProcess.setCadence(buildCadence(FRAME_COUNT));

		engine.getProcesses().add(barrierProcess);
		engine.getProcesses().add(lifeProcess);
		engine.getProcesses().add(pixelProcess);
		engine.getProcesses().add(graphicProcess);
		engine.setResourcePkg(sharedResources);
		engine.setDescriptorPkg(sharedDescriptors);

		return engine;
	}

	private AttachmentPkg newAttachmentPkg()
	{
		final var attachments = GraphicFactory.eINSTANCE.createAttachmentPkg();

		colorAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachment.setLoadOp(EAttachmentLoadOp.LOAD);
		colorAttachment.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.setInitialLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		colorAttachment.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		attachments.setColorAttachment(colorAttachment);

		return attachments;
	}

	private void createComputeProcessPool(ResourcePkg sharedResources, DescriptorPkg sharedDescriptors)
	{
		lifeProcess = ComputeFactory.eINSTANCE.createComputeProcess();
		pixelProcess = ComputeFactory.eINSTANCE.createComputeProcess();

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
		final Buffer boardBuffer1 = BoardBufferFactory.createBoardBuffer(board);
		final Buffer boardBuffer2 = BoardBufferFactory.createBoardBuffer(board);

		final var boardBuffer1Descriptor = newDescriptor(boardBuffer1);
		final var boardBuffer2Descriptor = newDescriptor(boardBuffer2);
		final var boardImageDescriptor = newDescriptor(boardImage);

		final var lifeDescriptorSet1 = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
		final var lifeDescriptorSet2 = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
		final var pixelDescriptorSet1 = VulkanResourceFactory.eINSTANCE.createDescriptorSet();
		final var pixelDescriptorSet2 = VulkanResourceFactory.eINSTANCE.createDescriptorSet();

		lifeDescriptorSet1.getDescriptors().add(boardBuffer1Descriptor);
		lifeDescriptorSet1.getDescriptors().add(boardBuffer2Descriptor);
		lifeDescriptorSet1.getDescriptors().add(boardImageDescriptor);
		lifeDescriptorSet2.getDescriptors().add(boardBuffer2Descriptor);
		lifeDescriptorSet2.getDescriptors().add(boardBuffer1Descriptor);
		lifeDescriptorSet2.getDescriptors().add(boardImageDescriptor);
		pixelDescriptorSet1.getDescriptors().add(boardBuffer2Descriptor);
		pixelDescriptorSet1.getDescriptors().add(boardImageDescriptor);
		pixelDescriptorSet2.getDescriptors().add(boardBuffer1Descriptor);
		pixelDescriptorSet2.getDescriptors().add(boardImageDescriptor);

		final var lifeBindingConfiguration = BindingFactory.eINSTANCE.createBindingConfiguration();
		lifeBindingConfiguration.getDescriptorsSets().add(lifeDescriptorSet1);
		lifeBindingConfiguration.getDescriptorsSets().add(lifeDescriptorSet2);
		lifeBindingConfiguration.setDescriptorSetStride(1);
		final var pixelBindingConfiguration = BindingFactory.eINSTANCE.createBindingConfiguration();
		pixelBindingConfiguration.getDescriptorsSets().add(pixelDescriptorSet1);
		pixelBindingConfiguration.getDescriptorsSets().add(pixelDescriptorSet2);
		lifeBindingConfiguration.setDescriptorSetStride(1);

		final var lifePipeline = createPipeline(lifeShader, lifeBindingConfiguration);
		final var pixelPipeline = createPipeline(life2pixelShader, pixelBindingConfiguration);

		final var rotateTask = BindingFactory.eINSTANCE.createRotateConfiguration();
		rotateTask.getConfigurations().add(lifeBindingConfiguration);
		rotateTask.getConfigurations().add(pixelBindingConfiguration);
		lifePipeline.getTaskPkg().getTasks().add(rotateTask);

		final var lifePipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		lifePipelinePkg.getPipelines().add(lifePipeline);
		lifeProcess.setPipelinePkg(lifePipelinePkg);

		final var pixelPipelinePkg = ProcessFactory.eINSTANCE.createPipelinePkg();
		pixelPipelinePkg.getPipelines().add(pixelPipeline);
		pixelProcess.setPipelinePkg(pixelPipelinePkg);

		sharedResources.getResources().add(lifeShader);
		sharedResources.getResources().add(life2pixelShader);
		sharedResources.getResources().add(boardBuffer1);
		sharedResources.getResources().add(boardBuffer2);
		sharedResources.getResources().add(boardImage);

		sharedDescriptors.getDescriptors().add(boardBuffer1Descriptor);
		sharedDescriptors.getDescriptors().add(boardBuffer2Descriptor);
		sharedDescriptors.getDescriptors().add(boardImageDescriptor);

		lifeProcess.setExtensionPkg(ProcessFactory.eINSTANCE.createProcessExtensionPkg());
		lifeProcess.getExtensionPkg().getExtensions().add(lifeBindingConfiguration);
		pixelProcess.setExtensionPkg(ProcessFactory.eINSTANCE.createProcessExtensionPkg());
		pixelProcess.getExtensionPkg().getExtensions().add(pixelBindingConfiguration);

		lifeProcess.setResetAllowed(true);
		pixelProcess.setResetAllowed(true);
	}

	private void createBarrierProcess()
	{
		barrierProcess = ComputeFactory.eINSTANCE.createComputeProcess();
		barrierProcess.setPipelinePkg(ProcessFactory.eINSTANCE.createPipelinePkg());

		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		final var pipeline = ProcessFactory.eINSTANCE.createPipeline();
		pipeline.setTaskPkg(taskPkg);
		pipeline.setStage(ECommandStage.COMPUTE);

		final var pipelineBarrier = ProcessFactory.eINSTANCE.createPipelineBarrier();
		final var imageBarrier = VulkanResourceFactory.eINSTANCE.createImageBarrier();
		imageBarrier.setImage(boardImage);
		imageBarrier.setDstLayout(EImageLayout.GENERAL);
		imageBarrier.getDstAccessMask().add(EAccess.SHADER_WRITE_BIT);

		pipelineBarrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		pipelineBarrier.setDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		pipelineBarrier.getBarriers().add(imageBarrier);

		barrierProcess.getPipelinePkg().getPipelines().add(pipeline);
		pipeline.getTaskPkg().getTasks().add(pipelineBarrier);

		final var cadence = CadenceFactory.eINSTANCE.createCadence();
		final var runBarrierProcess = VulkanFactory.eINSTANCE.createRunProcess();
		runBarrierProcess.setProcess(barrierProcess);
		cadence.getTasks().add(runBarrierProcess);
		barrierProcess.setCadence(cadence);
	}

	private ComputePipeline createPipeline(Shader shader, BindingConfiguration bindingConfiguration)
	{
		final var bindTask = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		final var descriptorSet1 = bindingConfiguration.getDescriptorsSets().get(0);
		bindTask.setBindPoint(EBindPoint.COMPUTE);
		bindTask.getDescriptorSets().add(descriptorSet1);
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		final var dispatch = createDispatchTask();

		final var configureBindTask = BindingFactory.eINSTANCE.createConfigureBind();
		configureBindTask.getBindTasks().add(bindTask);
		bindingConfiguration.getTasks().add(configureBindTask);

		final var pipeline = ComputeFactory.eINSTANCE.createComputePipeline();
		pipeline.setTaskPkg(taskPkg);
		taskPkg.getTasks().add(bindTask);
		taskPkg.getTasks().add(dispatch);

		final var dSetPkg = VulkanResourceFactory.eINSTANCE.createDescriptorSetPkg();
		dSetPkg.getDescriptorSets().addAll(bindingConfiguration.getDescriptorsSets());

		pipeline.getLayout().addAll(bindingConfiguration.getDescriptorsSets());
		pipeline.setShader(shader);
		pipeline.setStage(ECommandStage.COMPUTE);
		pipeline.setDescriptorSetPkg(dSetPkg);

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

	private static IDescriptor newDescriptor(Buffer buffer)
	{
		final var descriptor = VulkanResourceFactory.eINSTANCE.createBufferDescriptor();
		descriptor.setType(EDescriptorType.STORAGE_BUFFER);
		descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
		descriptor.setBuffer(buffer);
		return descriptor;
	}

	private static IDescriptor newDescriptor(Image image)
	{
		final var descriptor = VulkanResourceFactory.eINSTANCE.createImageDescriptor();
		descriptor.setType(EDescriptorType.STORAGE_IMAGE);
		descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
		descriptor.setImage(image);
		return descriptor;
	}
}