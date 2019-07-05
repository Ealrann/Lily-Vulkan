package org.sheepy.lily.vulkan.demo.gameoflife.model;

import org.joml.Vector2i;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.vulkan.demo.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.impl.ResourcePkgImpl;
import org.sheepy.lily.vulkan.model.impl.VulkanEngineImpl;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.ProcessPartPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.process.graphic.impl.BlitToSwapImageImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageBarrierImpl;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public class ModelFactory
{
	public static final int WORKGROUP_SIDE = 8;

	private static final String SHADER_LIFE = "life.comp.spv";
	private static final String SHADER_LIFE2PIXEL = "life2pixel.comp.spv";

	public final Application application = ApplicationFactory.eINSTANCE.createApplication();
	public final VulkanEngine engine = new VulkanEngineImpl();
	public final GraphicProcess imageProcess;
	public ComputeProcess process1;
	public ComputeProcess process2;
	public ResourcePkg sharedResources = new ResourcePkgImpl();

	private Image boardImage;
	private final Vector2i size;

	public ModelFactory(int width, int height)
	{
		size = new Vector2i(width, height);

		application.setTitle("Vulkan - Game of Life");
		application.setSize(size);
		application.getEngines().add(engine);

		final var swapchainConfiguration = GraphicFactory.eINSTANCE.createSwapchainConfiguration();
		swapchainConfiguration.getSwapImageUsages().add(EImageUsage.TRANSFER_DST);
		swapchainConfiguration.getSwapImageUsages().add(EImageUsage.COLOR_ATTACHMENT);

		final var framebufferConfiguration = GraphicFactory.eINSTANCE
				.createFramebufferConfiguration();
		final var configuration = GraphicFactory.eINSTANCE.createGraphicConfiguration();
		configuration.setColorDomain(GraphicFactory.eINSTANCE.createColorDomain());
		configuration.setAcquireWaitStage(EPipelineStage.TRANSFER_BIT);
		configuration.setSwapchainConfiguration(swapchainConfiguration);
		configuration.setFramebufferConfiguration(framebufferConfiguration);

		createComputeProcessPool();

		imageProcess = newImageProcess();
		imageProcess.setConfiguration(configuration);
		imageProcess.setRenderPassInfo(newInfo());

		engine.getProcesses().add(process1);
		engine.getProcesses().add(process2);
		engine.getProcesses().add(imageProcess);
		engine.setResourcePkg(sharedResources);
	}

	private static RenderPassInfo newInfo()
	{
		final var renderPass = GraphicFactory.eINSTANCE.createRenderPassInfo();
		final var subpass = GraphicFactory.eINSTANCE.createSubpass();
		renderPass.getSubpasses().add(subpass);

		final var colorAttachment = GraphicFactory.eINSTANCE.createSwapImageAttachmentDescription();
		colorAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachment.setLoadOp(EAttachmentLoadOp.LOAD);
		colorAttachment.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.setInitialLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		colorAttachment.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		renderPass.getAttachments().add(colorAttachment);

		final var colorRef = GraphicFactory.eINSTANCE.createAttachmentRef();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachment(colorAttachment);
		subpass.getRefs().add(colorRef);

		final var dependencyExt = GraphicFactory.eINSTANCE.createSubpassDependency();
		dependencyExt.setSrcSubpass(null);
		dependencyExt.setDstSubpass(subpass);
		dependencyExt.getSrcStageMask().add(EPipelineStage.TRANSFER_BIT);
		dependencyExt.getDstStageMask().add(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		dependencyExt.getSrcAccesses().add(EAccess.TRANSFER_WRITE_BIT);
		dependencyExt.getDstAccesses().add(EAccess.COLOR_ATTACHMENT_READ_BIT);
		dependencyExt.getDstAccesses().add(EAccess.COLOR_ATTACHMENT_WRITE_BIT);

		renderPass.getDependencies().add(dependencyExt);

		return renderPass;
	}

	private GraphicProcess newImageProcess()
	{
		final var imagePipeline = ProcessFactory.eINSTANCE.createPipeline();

		final var imageBarrier1 = new ImageBarrierImpl();
		imageBarrier1.setImage(boardImage);
		imageBarrier1.getSrcAccessMask().add(EAccess.SHADER_WRITE_BIT);
		imageBarrier1.getDstAccessMask().add(EAccess.TRANSFER_READ_BIT);
		imageBarrier1.setSrcLayout(EImageLayout.UNDEFINED);
		imageBarrier1.setDstLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);

		final var swapImageBarrier = new SwapImageBarrierImpl();
		swapImageBarrier.getSrcAccessMask().add(EAccess.SHADER_WRITE_BIT);
		swapImageBarrier.getDstAccessMask().add(EAccess.TRANSFER_WRITE_BIT);
		swapImageBarrier.setSrcLayout(EImageLayout.UNDEFINED);
		swapImageBarrier.setDstLayout(EImageLayout.TRANSFER_DST_OPTIMAL);

		final var pipelineBarrier1 = ProcessFactory.eINSTANCE.createPipelineBarrier();
		pipelineBarrier1.setSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		pipelineBarrier1.setDstStage(EPipelineStage.TRANSFER_BIT);
		pipelineBarrier1.getBarriers().add(imageBarrier1);
		pipelineBarrier1.getBarriers().add(swapImageBarrier);

		final var blit = new BlitToSwapImageImpl();
		blit.setImage(boardImage);

		final var imageBarrier2 = new ImageBarrierImpl();
		imageBarrier2.setImage(boardImage);
		imageBarrier2.getSrcAccessMask().add(EAccess.TRANSFER_READ_BIT);
		imageBarrier2.getDstAccessMask().add(EAccess.SHADER_WRITE_BIT);
		imageBarrier2.setSrcLayout(EImageLayout.TRANSFER_SRC_OPTIMAL);
		imageBarrier2.setDstLayout(EImageLayout.GENERAL);

		final var pipelineBarrier2 = ProcessFactory.eINSTANCE.createPipelineBarrier();
		pipelineBarrier2.setSrcStage(EPipelineStage.TRANSFER_BIT);
		pipelineBarrier2.setDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		pipelineBarrier2.getBarriers().add(imageBarrier2);

		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();
		taskPkg.getTasks().add(pipelineBarrier1);
		taskPkg.getTasks().add(blit);
		taskPkg.getTasks().add(pipelineBarrier2);

		imagePipeline.setStage(ECommandStage.TRANSFER);
		imagePipeline.setTaskPkg(taskPkg);

		final GraphicProcess graphicProcess = new GraphicProcessImpl();
		graphicProcess.setPartPkg(ProcessFactory.eINSTANCE.createProcessPartPkg());
		graphicProcess.getPartPkg().getParts().add(imagePipeline);

		return graphicProcess;
	}

	private void createComputeProcessPool()
	{
		process1 = new ComputeProcessImpl();
		process2 = new ComputeProcessImpl();
		final Module thisModule = getClass().getModule();

		final ModuleResource lifeShaderFile = new ModuleResourceImpl();
		lifeShaderFile.setModule(thisModule);
		lifeShaderFile.setPath(SHADER_LIFE);

		final ModuleResource life2pixelShaderFile = new ModuleResourceImpl();
		life2pixelShaderFile.setModule(thisModule);
		life2pixelShaderFile.setPath(SHADER_LIFE2PIXEL);

		final Shader lifeShader = new ShaderImpl();
		lifeShader.setFile(lifeShaderFile);
		lifeShader.setStage(EShaderStage.COMPUTE_BIT);

		final Shader life2pixelShader = new ShaderImpl();
		life2pixelShader.setFile(life2pixelShaderFile);
		life2pixelShader.setStage(EShaderStage.COMPUTE_BIT);

		final Board board = Board.createTestBoard(size);
		final Buffer boardBuffer1 = BoardBufferFactory.createBoardBuffer(board);
		final Buffer boardBuffer2 = BoardBufferFactory.createBoardBuffer(board);
		boardImage = BoardImageFactory.createBoardImage(size);

		final Computer lifeComputer1 = createComputer(lifeShader);
		final Computer pixelComputer1 = createComputer(life2pixelShader);

		final Computer lifeComputer2 = createComputer(lifeShader);
		final Computer pixelComputer2 = createComputer(life2pixelShader);

		final var lifePipeline1 = createPipeline(lifeComputer1, boardBuffer1, boardBuffer2);
		final var lifePipeline2 = createPipeline(lifeComputer2, boardBuffer2, boardBuffer1);

		final var pixelPipeline1 = createPipeline(pixelComputer1, boardBuffer2, boardImage);
		final var pixelPipeline2 = createPipeline(pixelComputer2, boardBuffer1, boardImage);

		final ProcessPartPkg pipelines1 = ProcessFactory.eINSTANCE.createProcessPartPkg();
		process1.setPartPkg(pipelines1);

		pipelines1.getParts().add(lifePipeline1);
		pipelines1.getParts().add(pixelPipeline1);

		final ProcessPartPkg pipelines2 = ProcessFactory.eINSTANCE.createProcessPartPkg();
		process2.setPartPkg(pipelines2);

		pipelines2.getParts().add(lifePipeline2);
		pipelines2.getParts().add(pixelPipeline2);

		sharedResources.getResources().add(lifeShader);
		sharedResources.getResources().add(life2pixelShader);
		sharedResources.getResources().add(boardBuffer1);
		sharedResources.getResources().add(boardBuffer2);
		sharedResources.getResources().add(boardImage);

		process1.setResetAllowed(true);
		process2.setResetAllowed(true);
	}

	private ComputePipeline createPipeline(Computer computer, DescriptedResource... descriptors)
	{
		final var descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();
		for (final var descriptor : descriptors)
		{
			descriptorSet.getDescriptors().add(descriptor);
		}

		final var bindDescriptorSet = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		bindDescriptorSet.getDescriptorSets().add(descriptorSet);
		final var taskPkg = ProcessFactory.eINSTANCE.createTaskPkg();

		final var res = ComputeFactory.eINSTANCE.createComputePipeline();
		computer.setWorkgroupCountX(application.getSize().x() / WORKGROUP_SIDE);
		computer.setWorkgroupCountY(application.getSize().y() / WORKGROUP_SIDE);
		res.setTaskPkg(taskPkg);
		taskPkg.getTasks().add(bindDescriptorSet);
		taskPkg.getTasks().add(computer);

		res.setDescriptorSetPkg(ResourceFactory.eINSTANCE.createDescriptorSetPkg());
		res.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);
		res.setStage(ECommandStage.COMPUTE);

		return res;
	}

	private static Computer createComputer(final Shader shader)
	{
		final var res = ComputeFactory.eINSTANCE.createComputer();
		res.setShader(shader);
		return res;
	}
}
