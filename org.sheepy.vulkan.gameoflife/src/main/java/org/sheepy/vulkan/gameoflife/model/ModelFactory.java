package org.sheepy.vulkan.gameoflife.model;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.common.api.types.SVector2i;
import org.sheepy.common.model.application.Application;
import org.sheepy.common.model.application.impl.ApplicationImpl;
import org.sheepy.vulkan.gameoflife.compute.Board;
import org.sheepy.vulkan.model.SharedResources;
import org.sheepy.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.impl.ColorDomainImpl;
import org.sheepy.vulkan.model.impl.SharedResourcesImpl;
import org.sheepy.vulkan.model.impl.VulkanEngineImpl;
import org.sheepy.vulkan.model.process.IPipelineUnit;
import org.sheepy.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.vulkan.model.process.compute.Computer;
import org.sheepy.vulkan.model.process.compute.impl.ComputePipelineImpl;
import org.sheepy.vulkan.model.process.compute.impl.ComputeProcessImpl;
import org.sheepy.vulkan.model.process.compute.impl.ComputerImpl;
import org.sheepy.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;
import org.sheepy.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl;
import org.sheepy.vulkan.model.process.graphic.impl.GraphicConfigurationImpl;
import org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl;
import org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl;
import org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl;
import org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl;
import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.IDescriptor;
import org.sheepy.vulkan.model.resource.Image;
import org.sheepy.vulkan.model.resource.ModuleResource;
import org.sheepy.vulkan.model.resource.Shader;
import org.sheepy.vulkan.model.resource.impl.DescriptorSetImpl;
import org.sheepy.vulkan.model.resource.impl.ModuleResourceImpl;
import org.sheepy.vulkan.model.resource.impl.ShaderImpl;

public class ModelFactory
{
	private static final String SHADER_LIFE = "life.comp.spv";
	private static final String SHADER_LIFE2PIXEL = "life2pixel.comp.spv";

	public final Application application = new ApplicationImpl();
	public final VulkanEngine engine = new VulkanEngineImpl();
	public final GraphicProcess imageProcess;
	public ComputeProcess computeProcess1;
	public ComputeProcess computeProcess2;
	public SharedResources sharedResources = new SharedResourcesImpl();
	private Image boardImage;
	private final SVector2i size;

	public ModelFactory(int width, int height)
	{
		size = new SVector2i(width, height);

		application.setTitle("Vulkan - Game of Life");
		application.setSize(size);
		application.setDebug(false);
		application.getEngines().add(engine);

		int swapImageUsage = EImageUsage.TRANSFER_DST.getValue()
				| EImageUsage.COLOR_ATTACHMENT.getValue();

		final GraphicConfiguration configuration = new GraphicConfigurationImpl();
		configuration.setColorDomain(new ColorDomainImpl());
		configuration.setClearBeforeRender(false);
		configuration.setFrameWaitStage(EPipelineStage.TRANSFER_BIT);
		configuration.setSwapImageUsage(swapImageUsage);

		createComputeProcessPool();

		imageProcess = newImageProcess();
		imageProcess.setConfiguration(configuration);
		imageProcess.setRenderPassInfo(newInfo());

		engine.getProcesses().add(computeProcess1);
		engine.getProcesses().add(computeProcess2);
		engine.getProcesses().add(imageProcess);
		engine.setSharedResources(sharedResources);
	}

	private static RenderPassInfo newInfo()
	{
		final RenderPassInfo renderPass = new RenderPassInfoImpl();

		final AttachmentDescription colorAttachment = new AttachmentDescriptionImpl();
		colorAttachment.setSamples(ESampleCount.SAMPLE_COUNT_1BIT);
		colorAttachment.setLoadOp(EAttachmentLoadOp.LOAD);
		colorAttachment.setStoreOp(EAttachmentStoreOp.STORE);
		colorAttachment.setStencilLoadOp(EAttachmentLoadOp.DONT_CARE);
		colorAttachment.setStencilStoreOp(EAttachmentStoreOp.DONT_CARE);
		colorAttachment.setInitialLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);
		colorAttachment.setFinalLayout(EImageLayout.PRESENT_SRC_KHR);
		colorAttachment.setRefLayout(EImageLayout.COLOR_ATTACHMENT_OPTIMAL);

		renderPass.getAttachments().add(colorAttachment);

		final SubpassDependency dependencyExt = new SubpassDependencyImpl();
		dependencyExt.setSrcSubpass(VK_SUBPASS_EXTERNAL);
		dependencyExt.setDstSubpass(0);
		dependencyExt.setSrcStageMask(EPipelineStage.TRANSFER_BIT);
		dependencyExt.setDstStageMask(EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT);
		dependencyExt.setSrcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
		dependencyExt.setDstAccessMask(
				VK_ACCESS_COLOR_ATTACHMENT_READ_BIT | VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT);

		renderPass.getDependencies().add(dependencyExt);

		return renderPass;
	}

	private GraphicProcess newImageProcess()
	{
		final ImagePipeline imagePipeline = new ImagePipelineImpl();
		imagePipeline.setImageSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		imagePipeline.setImageDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		imagePipeline.setImageSrcAccess(VK_ACCESS_SHADER_WRITE_BIT);
		imagePipeline.setImageDstAccess(VK_ACCESS_SHADER_WRITE_BIT);
		imagePipeline.setImage(boardImage);
		imagePipeline.setStage(ECommandStage.PRE_RENDER);

		final GraphicProcess graphicProcess = new GraphicProcessImpl();
		graphicProcess.getUnits().add(imagePipeline);

		return graphicProcess;
	}

	private void createComputeProcessPool()
	{
		computeProcess1 = new ComputeProcessImpl();
		computeProcess2 = new ComputeProcessImpl();
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

		Board board = Board.createTestBoard(size);
		Buffer boardBuffer1 = BoardBufferFactory.createBoardBuffer(board);
		Buffer boardBuffer2 = BoardBufferFactory.createBoardBuffer(board);
		boardImage = BoardImageFactory.createBoardImage(size);

		Computer lifeComputer1 = createComputer(lifeShader);
		Computer pixelComputer1 = createComputer(life2pixelShader);

		Computer lifeComputer2 = createComputer(lifeShader);
		Computer pixelComputer2 = createComputer(life2pixelShader);

		ComputePipeline lifePipeline1 = createPipeline(computeProcess1, lifeComputer1, boardBuffer1,
				boardBuffer2);
		ComputePipeline lifePipeline2 = createPipeline(computeProcess2, lifeComputer2, boardBuffer2,
				boardBuffer1);

		ComputePipeline pixelPipeline1 = createPipeline(computeProcess1, pixelComputer1,
				boardBuffer2, boardImage);
		ComputePipeline pixelPipeline2 = createPipeline(computeProcess2, pixelComputer2,
				boardBuffer1, boardImage);

		computeProcess1.getUnits().add(lifePipeline1);
		computeProcess1.getUnits().add(pixelPipeline1);

		computeProcess2.getUnits().add(lifePipeline2);
		computeProcess2.getUnits().add(pixelPipeline2);

		sharedResources.getResources().add(lifeShader);
		sharedResources.getResources().add(life2pixelShader);
		sharedResources.getResources().add(boardBuffer1);
		sharedResources.getResources().add(boardBuffer2);
		sharedResources.getResources().add(boardImage);

		computeProcess1.setResetAllowed(true);
		computeProcess2.setResetAllowed(true);
	}

	private ComputePipeline createPipeline(	ComputeProcess process,
											IPipelineUnit computer,
											IDescriptor... descriptors)
	{
		var descriptorSet = new DescriptorSetImpl();
		for (IDescriptor descriptor : descriptors)
		{
			descriptorSet.getDescriptors().add(descriptor);
		}

		ComputePipeline res = new ComputePipelineImpl();
		res.getUnits().add(computer);
		process.getDescriptorSets().add(descriptorSet);
		res.setDescriptorSet(descriptorSet);
		res.setStage(ECommandStage.COMPUTE);

		res.setWidth(application.getSize().getX());
		res.setHeight(application.getSize().getY());
		res.setDepth(1);

		return res;
	}

	private static Computer createComputer(final Shader shader)
	{
		Computer res = new ComputerImpl();
		res.setShader(shader);
		return res;
	}
}
