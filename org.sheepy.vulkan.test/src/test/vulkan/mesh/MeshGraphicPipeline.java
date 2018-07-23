package test.vulkan.mesh;

import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.PipelineId;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicsPipeline;

public class MeshGraphicPipeline extends GraphicsPipeline
{

	public MeshGraphicPipeline(LogicalDevice logicalDevice,
			MeshPipelineConfiguration pipelineConfiguration)
	{
		super(logicalDevice, pipelineConfiguration);
	}

	@Override
	protected PipelineId buildGraphicPipeline(long id)
	{
		return new IndexedGraphicPipeline(id,
				((MeshPipelineConfiguration) pipelineConfiguration).mesh);
	}
}
