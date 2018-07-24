package test.vulkan.mesh;

import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.graphic.GraphicConfiguration;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcess;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcessPool;

public class MeshRenderProcessPool extends GraphicProcessPool
{
	public MeshRenderProcessPool(LogicalDevice logicalDevice, GraphicConfiguration configuration)
	{
		super(logicalDevice, configuration, false);
	}

	public void configure(MeshPipelineConfiguration pipelineConfiguration)
	{
		allocationObjects.add(pipelineConfiguration.mesh);
		
		MeshGraphicPipeline graphicPipeline = new MeshGraphicPipeline(logicalDevice,
				pipelineConfiguration);

		GraphicProcess graphicProcess = new GraphicProcess(configuration);
		graphicProcess.addGraphicPipeline(graphicPipeline);

		addProcess(graphicProcess);
	}
}
