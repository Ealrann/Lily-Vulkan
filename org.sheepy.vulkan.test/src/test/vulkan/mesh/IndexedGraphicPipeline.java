package test.vulkan.mesh;


import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_GRAPHICS;
import static org.lwjgl.vulkan.VK10.vkCmdBindPipeline;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.pipeline.PipelineId;

public class IndexedGraphicPipeline extends PipelineId
{
	private Mesh mesh;
	
	public IndexedGraphicPipeline(long id, Mesh mesh)
	{
		super(id);
		this.mesh = mesh;
	}

	@Override
	public void execute(VkCommandBuffer commandBuffer)
	{
		vkCmdBindPipeline(commandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS, id);

		mesh.bindBufferForRender(commandBuffer);

		mesh.draw(commandBuffer);
	}
}