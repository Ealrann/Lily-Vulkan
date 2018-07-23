package test.vulkan.mesh;

import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicPipelineConfiguration;

public class MeshPipelineConfiguration extends GraphicPipelineConfiguration
{
	public final Mesh mesh;

	public MeshPipelineConfiguration(LogicalDevice logicalDevice, CommandPool commandPool,
			Mesh mesh)
	{
		super(logicalDevice, commandPool, mesh.getShaders(), mesh.descriptors);

		this.mesh = mesh;
	}
}
