package test.vulkan.mesh;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_GRAPHICS;
import static org.lwjgl.vulkan.VK10.vkCmdBindPipeline;

import org.sheepy.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicPipelineId;

public class IndexedGraphicPipeline extends GraphicPipelineId
{
	private Mesh mesh;

	public IndexedGraphicPipeline(long id, Mesh mesh)
	{
		super(id);
		this.mesh = mesh;
	}

	@Override
	public void execute(RenderCommandBuffer commandBuffer)
	{
		vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), VK_PIPELINE_BIND_POINT_GRAPHICS, id);

		mesh.bindBufferForRender(commandBuffer.getVkCommandBuffer());

		mesh.draw(commandBuffer.getVkCommandBuffer());
	}
}