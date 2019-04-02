package org.sheepy.lily.vulkan.gameoflife.model;

import org.joml.Vector2i;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.impl.ApplicationImpl;
import org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline;
import org.sheepy.lily.vulkan.extra.graphic.model.impl.ImagePipelineImpl;
import org.sheepy.lily.vulkan.gameoflife.compute.Board;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.enumeration.EAccess;
import org.sheepy.lily.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.lily.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;
import org.sheepy.lily.vulkan.model.enumeration.EImageLayout;
import org.sheepy.lily.vulkan.model.enumeration.EImageUsage;
import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.lily.vulkan.model.enumeration.ESampleCount;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.impl.ColorDomainImpl;
import org.sheepy.lily.vulkan.model.impl.ResourcePkgImpl;
import org.sheepy.lily.vulkan.model.impl.VulkanEngineImpl;
import org.sheepy.lily.vulkan.model.process.IPipelineUnit;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.compute.Computer;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePipelineImpl;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputerImpl;
import org.sheepy.lily.vulkan.model.process.graphic.AttachementRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttachementRefImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.FramebufferConfigurationImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageAttachmentDescriptionImpl;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl;
import org.sheepy.lily.vulkan.model.process.impl.PipelinePkgImpl;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.IDescriptor;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ModuleResource;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl;
import org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl;

public class ModelFactory
{
	private static final String SHADER_LIFE = "life.comp.spv";
	private static final String SHADER_LIFE2PIXEL = "life2pixel.comp.spv";

	public final Application application = new ApplicationImpl();
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

		final var swapchainConfiguration = new SwapchainConfigurationImpl();
		swapchainConfiguration.getSwapImageUsages().add(EImageUsage.TRANSFER_DST);
		swapchainConfiguration.getSwapImageUsages().add(EImageUsage.COLOR_ATTACHMENT);

		final GraphicConfiguration configuration = new GraphicConfigurationImpl();
		configuration.setColorDomain(new ColorDomainImpl());
		configuration.setAcquireWaitStage(EPipelineStage.TRANSFER_BIT);
		configuration.setSwapchainConfiguration(swapchainConfiguration);
		configuration.setFramebufferConfiguration(new FramebufferConfigurationImpl());

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
		final RenderPassInfo renderPass = new RenderPassInfoImpl();
		final var subpass = new SubpassImpl();
		renderPass.getSubpasses().add(subpass);

		final AttachmentDescription colorAttachment = new SwapImageAttachmentDescriptionImpl();
		colorAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachment.setLoadOp(EAttachmentLoadOp.LOAD);
		colorAttachment.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.setInitialLayout(EImageLayout.TRANSFER_DST_OPTIMAL);
		colorAttachment.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);

		renderPass.getAttachments().add(colorAttachment);

		final AttachementRef colorRef = new AttachementRefImpl();
		colorRef.setLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorRef.setAttachement(colorAttachment);
		subpass.getRefs().add(colorRef);

		final SubpassDependency dependencyExt = new SubpassDependencyImpl();
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
		final ImagePipeline imagePipeline = new ImagePipelineImpl();
		imagePipeline.setImageSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		imagePipeline.setImageDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		imagePipeline.getImageSrcAccessMask().add(EAccess.SHADER_WRITE_BIT);
		imagePipeline.getImageDstAccessMask().add(EAccess.SHADER_WRITE_BIT);
		imagePipeline.setImage(boardImage);
		imagePipeline.setStage(ECommandStage.PRE_RENDER);

		final GraphicProcess graphicProcess = new GraphicProcessImpl();
		graphicProcess.setPipelinePkg(new PipelinePkgImpl());
		graphicProcess.getPipelinePkg().getPipelines().add(imagePipeline);

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

		final var lifePipeline1 = createPipeline(process1, lifeComputer1, boardBuffer1,
				boardBuffer2);
		final var lifePipeline2 = createPipeline(process2, lifeComputer2, boardBuffer2,
				boardBuffer1);

		final var pixelPipeline1 = createPipeline(process1, pixelComputer1, boardBuffer2,
				boardImage);
		final var pixelPipeline2 = createPipeline(process2, pixelComputer2, boardBuffer1,
				boardImage);

		final PipelinePkg pipelines1 = new PipelinePkgImpl();
		process1.setPipelinePkg(pipelines1);

		pipelines1.getPipelines().add(lifePipeline1);
		pipelines1.getPipelines().add(pixelPipeline1);

		final PipelinePkg pipelines2 = new PipelinePkgImpl();
		process2.setPipelinePkg(pipelines2);

		pipelines2.getPipelines().add(lifePipeline2);
		pipelines2.getPipelines().add(pixelPipeline2);

		sharedResources.getResources().add(lifeShader);
		sharedResources.getResources().add(life2pixelShader);
		sharedResources.getResources().add(boardBuffer1);
		sharedResources.getResources().add(boardBuffer2);
		sharedResources.getResources().add(boardImage);

		process1.setResetAllowed(true);
		process2.setResetAllowed(true);
	}

	private ComputePipeline createPipeline(	ComputeProcess process,
											IPipelineUnit computer,
											IDescriptor... descriptors)
	{
		final var descriptorSet = new DescriptorSetImpl();
		for (final IDescriptor descriptor : descriptors)
		{
			descriptorSet.getDescriptors().add(descriptor);
		}

		final ComputePipeline res = new ComputePipelineImpl();
		res.getUnits().add(computer);

		res.setDescriptorSet(descriptorSet);
		res.setStage(ECommandStage.COMPUTE);

		res.setWidth(application.getSize().x);
		res.setHeight(application.getSize().y);
		res.setDepth(1);

		return res;
	}

	private static Computer createComputer(final Shader shader)
	{
		final Computer res = new ComputerImpl();
		res.setShader(shader);
		return res;
	}
}
