package test.vulkan.mesh;

import org.sheepy.vulkan.pipeline.graphic.GraphicContext;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicPipelineConfiguration;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicPipelineId;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicsPipeline;

public class MeshGraphicPipeline extends GraphicsPipeline
{

	public MeshGraphicPipeline(GraphicContext context,
			GraphicPipelineConfiguration pipelineConfiguration)
	{
		super(context, pipelineConfiguration);
	}

	@Override
	protected GraphicPipelineId buildGraphicPipeline(long id)
	{
		return new IndexedGraphicPipeline(id,
				((MeshPipelineConfiguration) pipelineConfiguration).mesh);
	}

	@Override
	public boolean update()
	{
		return false;
	}
}
