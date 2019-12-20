package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.joml.Vector2ic;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.application.ModuleResource;
import org.sheepy.lily.core.model.application.ResourcePkg;
import org.sheepy.lily.core.model.cadence.Cadence;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
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
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EBindPoint;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
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

	private GraphicProcess graphicProcess;
	private ComputeProcess lifeProcess;
	private ComputeProcess pixelProcess;
	private ComputePipeline lifePipeline;
	private ComputePipeline pixelPipeline;

	public EngineBuilder(Vector2ic size)
	{
		this.size = size;
		boardImage = BoardImageFactory.createBoardImage(size);
	}

	public IEngine build()
	{
		final VulkanEngine engine = VulkanFactory.eINSTANCE.createVulkanEngine();

		final var sharedResources = ApplicationFactory.eINSTANCE.createResourcePkg();
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
		graphicProcess.setPartPkg(ProcessFactory.eINSTANCE.createProcessPartPkg());
		graphicProcess.setConfiguration(configuration);
		graphicProcess.setRenderPassInfo(newInfo());
		graphicProcess.setCadence(buildGraphicCadence(FRAME_COUNT));

		engine.getProcesses().add(lifeProcess);
		engine.getProcesses().add(pixelProcess);
		engine.getProcesses().add(graphicProcess);
		engine.setResourcePkg(sharedResources);
		engine.setDescriptorPkg(sharedDescriptors);

		return engine;
	}

	private static RenderPassInfo newInfo()
	{
		final var renderPass = GraphicFactory.eINSTANCE.createRenderPassInfo();

		final var colorAttachment = GraphicFactory.eINSTANCE.createSwapImageAttachment();
		colorAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachment.setLoadOp(EAttachmentLoadOp.LOAD);
		colorAttachment.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.setInitialLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		colorAttachment.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		renderPass.setColorAttachment(colorAttachment);

		return renderPass;
	}

	private void createComputeProcessPool(	ResourcePkg sharedResources,
											DescriptorPkg sharedDescriptors)
	{
		lifeProcess = ComputeFactory.eINSTANCE.createComputeProcess();
		pixelProcess = ComputeFactory.eINSTANCE.createComputeProcess();
		final Module thisModule = getClass().getModule();

		final ModuleResource lifeShaderFile = ApplicationFactory.eINSTANCE.createModuleResource();
		lifeShaderFile.setModule(thisModule);
		lifeShaderFile.setPath(SHADER_LIFE);

		final ModuleResource life2pixelShaderFile = ApplicationFactory.eINSTANCE.createModuleResource();
		life2pixelShaderFile.setModule(thisModule);
		life2pixelShaderFile.setPath(SHADER_LIFE2PIXEL);

		final Shader lifeShader = ResourceFactory.eINSTANCE.createShader();
		lifeShader.setFile(lifeShaderFile);
		lifeShader.setStage(EShaderStage.COMPUTE_BIT);

		final Shader life2pixelShader = ResourceFactory.eINSTANCE.createShader();
		life2pixelShader.setFile(life2pixelShaderFile);
		life2pixelShader.setStage(EShaderStage.COMPUTE_BIT);

		final Board board = Board.createTestBoard(size);
		final Buffer boardBuffer1 = BoardBufferFactory.createBoardBuffer(board);
		final Buffer boardBuffer2 = BoardBufferFactory.createBoardBuffer(board);

		final var boardBuffer1Descriptor = newDescriptor(boardBuffer1);
		final var boardBuffer2Descriptor = newDescriptor(boardBuffer2);
		final var boardImageDescriptor = newDescriptor(boardImage);

		final var lifeDescriptorSet1 = ResourceFactory.eINSTANCE.createDescriptorSet();
		final var lifeDescriptorSet2 = ResourceFactory.eINSTANCE.createDescriptorSet();
		final var pixelDescriptorSet1 = ResourceFactory.eINSTANCE.createDescriptorSet();
		final var pixelDescriptorSet2 = ResourceFactory.eINSTANCE.createDescriptorSet();

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

		lifePipeline = createPipeline(lifeShader, lifeBindingConfiguration);
		pixelPipeline = createPipeline(life2pixelShader, pixelBindingConfiguration);

		final var rotateTask = BindingFactory.eINSTANCE.createRotateConfiguration();
		rotateTask.getConfigurations().add(lifeBindingConfiguration);
		rotateTask.getConfigurations().add(pixelBindingConfiguration);
		lifePipeline.getTaskPkg().getTasks().add(rotateTask);

		final var lifeProcessPkg = ProcessFactory.eINSTANCE.createProcessPartPkg();
		lifeProcessPkg.getParts().add(lifePipeline);
		lifeProcess.setPartPkg(lifeProcessPkg);

		final var pixelProcessPkg = ProcessFactory.eINSTANCE.createProcessPartPkg();
		pixelProcessPkg.getParts().add(pixelPipeline);
		pixelProcess.setPartPkg(pixelProcessPkg);

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

	private ComputePipeline createPipeline(Shader shader, BindingConfiguration bindingConfiguration)
	{
		final var bindTask = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		bindTask.setBindPoint(EBindPoint.COMPUTE);
		bindTask.getDescriptorSets().add(bindingConfiguration.getDescriptorsSets().get(0));
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		final var dispatch = createDispatchTask();

		final var configureBindTask = BindingFactory.eINSTANCE.createConfigureBind();
		configureBindTask.setBindTask(bindTask);
		bindingConfiguration.getTasks().add(configureBindTask);

		final var pipeline = ComputeFactory.eINSTANCE.createComputePipeline();
		pipeline.setTaskPkg(taskPkg);
		taskPkg.getTasks().add(bindTask);
		taskPkg.getTasks().add(dispatch);

		final var dSetPkg = ResourceFactory.eINSTANCE.createDescriptorSetPkg();
		dSetPkg.getDescriptorSets().addAll(bindingConfiguration.getDescriptorsSets());

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

	private final Cadence buildGraphicCadence(int frameCount)
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
		final var reference = ResourceFactory.eINSTANCE.createBufferReference();
		reference.setBuffer(buffer);

		final var descriptor = ResourceFactory.eINSTANCE.createBufferDescriptor();
		descriptor.setType(EDescriptorType.STORAGE_BUFFER);
		descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
		descriptor.setBufferReference(reference);
		return descriptor;
	}

	private static IDescriptor newDescriptor(Image image)
	{
		final var descriptor = ResourceFactory.eINSTANCE.createImageDescriptor();
		descriptor.setType(EDescriptorType.STORAGE_IMAGE);
		descriptor.getShaderStages().add(EShaderStage.COMPUTE_BIT);
		descriptor.setImage(image);
		return descriptor;
	}
}