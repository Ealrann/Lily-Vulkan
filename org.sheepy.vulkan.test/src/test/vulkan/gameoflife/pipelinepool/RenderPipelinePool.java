package test.vulkan.gameoflife.pipelinepool;

import org.sheepy.vulkan.buffer.Image;
import org.sheepy.vulkan.command.ECommandStage;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcess;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcessPool;

import test.vulkan.gameoflife.graphics.BufferedGraphicPipeline;
import test.vulkan.gameoflife.graphics.BufferedSwapConfiguration;

public class RenderPipelinePool extends GraphicProcessPool
{
	public RenderPipelinePool(LogicalDevice logicalDevice, Image image)
	{
		super(new BufferedSwapConfiguration(logicalDevice, image), false);

		GraphicProcess process = new GraphicProcess(context);
		process.addProcessUnit(new BufferedGraphicPipeline(context, image), ECommandStage.PreRender);

		addProcess(process);
	}
}
