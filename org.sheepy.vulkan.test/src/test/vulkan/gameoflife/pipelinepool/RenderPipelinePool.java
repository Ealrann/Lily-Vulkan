package test.vulkan.gameoflife.pipelinepool;

import org.sheepy.vulkan.buffer.Image;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcess;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcessPool;

import test.vulkan.gameoflife.graphics.BufferedGraphicPipeline;
import test.vulkan.gameoflife.graphics.BufferedSwapConfiguration;

public class RenderPipelinePool extends GraphicProcessPool
{
	public RenderPipelinePool(LogicalDevice logicalDevice, Image image)
	{
		super(logicalDevice, new BufferedSwapConfiguration(logicalDevice, image), false);

		GraphicProcess process = new GraphicProcess(configuration);
		process.addProcessUnit(new BufferedGraphicPipeline(image));

		addProcess(process);
	}
}
