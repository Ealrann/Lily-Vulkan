package test.vulkan.mesh;

import org.sheepy.vulkan.pipeline.graphic.GraphicConfiguration;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcess;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcessPool;

public class MeshRenderProcessPool extends GraphicProcessPool
{
	public MeshRenderProcessPool(GraphicConfiguration configuration)
	{
		super(configuration, false);
	}

	public void configure(MeshPipelineConfiguration pipelineConfiguration)
	{
		MeshGraphicPipeline graphicPipeline = new MeshGraphicPipeline(context,
				pipelineConfiguration);

		GraphicProcess graphicProcess = new GraphicProcess(context);
		graphicProcess.addGraphicPipeline(graphicPipeline);

		addProcess(graphicProcess);

		addResource(pipelineConfiguration.mesh);
	}
}
