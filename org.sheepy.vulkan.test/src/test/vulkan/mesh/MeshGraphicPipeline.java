package test.vulkan.mesh;

import org.sheepy.vulkan.pipeline.graphic.render.GraphicPipelineId;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicsPipeline;

public class MeshGraphicPipeline extends GraphicsPipeline
{

	public MeshGraphicPipeline(MeshPipelineConfiguration pipelineConfiguration)
	{
		super(pipelineConfiguration);
	}

	@Override
	protected GraphicPipelineId buildGraphicPipeline(long id)
	{
		return new IndexedGraphicPipeline(id,
				((MeshPipelineConfiguration) pipelineConfiguration).mesh);
	}
}
