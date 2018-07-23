package test.vulkan.gameoflife.pipelinepool;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_USAGE_TRANSFER_DST_BIT;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.buffer.Image;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.SurfaceProcessPool;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcess;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcessPool;
import org.sheepy.vulkan.window.Surface;

import test.vulkan.gameoflife.graphics.BufferToPixelRenderPass;
import test.vulkan.gameoflife.graphics.BufferedGraphicPipeline;
import test.vulkan.gameoflife.graphics.BufferedSwapConfiguration;

public class RenderPipelinePool extends SurfaceProcessPool
{
	private LogicalDevice logicalDevice;
	private Image image;

	private BufferedSwapConfiguration configuration;

	private GraphicProcessPool graphicProcessPool;

	public RenderPipelinePool(LogicalDevice logicalDevice, Image image)
	{
		super(logicalDevice, logicalDevice.getQueueManager().getGraphicQueueIndex());

		this.logicalDevice = logicalDevice;
		this.image = image;

		buildPipelines();
	}

	public void buildPipelines()
	{
		configuration = new BufferedSwapConfiguration(logicalDevice, commandPool, image);

		// We will use the swap image as a target transfer
		configuration.swapImageUsages |= VK_IMAGE_USAGE_TRANSFER_DST_BIT;

		configuration.renderPass = new BufferToPixelRenderPass(configuration);


		graphicProcessPool = new GraphicProcessPool(logicalDevice, commandPool, configuration);
		
		GraphicProcess process = new GraphicProcess(configuration);
		process.addProcessUnit(new BufferedGraphicPipeline(configuration));

		graphicProcessPool.addProcess(process);
		
		subAllocationObjects.add(configuration);
		subAllocationObjects.add(graphicProcessPool);
	}

	@Override
	public void configure(Surface surface)
	{
		graphicProcessPool.configure(surface);
	}

	@Override
	public void execute()
	{
		graphicProcessPool.exectue();
	}

	@Override
	public void resize(MemoryStack stack, Surface surface)
	{
		graphicProcessPool.freeNode();
		configure(surface);
		graphicProcessPool.allocateNode(stack);
	}
}
