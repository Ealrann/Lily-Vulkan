package org.sheepy.vulkan.pipeline.swap;

import java.util.Collection;
import java.util.Collections;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.buffer.Mesh;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.concurrent.ISignalEmitter;
import org.sheepy.vulkan.descriptor.BasicDescriptorSetConfiguration;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.swap.graphic.GraphicsPipeline;

public class MeshSwapPipeline extends AbstractSwapPipeline
{
	protected DescriptorPool descriptorPool;

	private Mesh mesh = null;

	public MeshSwapPipeline(LogicalDevice logicalDevice, Mesh mesh, SwapConfiguration configuration,
			CommandPool commandPool)
	{
		this(logicalDevice, mesh, configuration, commandPool, null);
	}

	public MeshSwapPipeline(LogicalDevice logicalDevice, Mesh mesh, SwapConfiguration configuration,
			CommandPool commandPool, Collection<ISignalEmitter> waitForSignals)
	{
		super(logicalDevice, configuration, commandPool, waitForSignals);

		this.mesh = mesh;

		if (mesh.getDescriptors().isEmpty() == false)
		{
			BasicDescriptorSetConfiguration descriptorConfiguration = new BasicDescriptorSetConfiguration();
			descriptorConfiguration.addAll(mesh.getDescriptors());

			descriptorPool = new DescriptorPool(logicalDevice,
					Collections.singletonList(descriptorConfiguration));
		}
	}

	boolean first = true;

	@Override
	public void allocate(MemoryStack stack)
	{
		if (first)
		{
			mesh.allocate(stack);
			if (descriptorPool != null) descriptorPool.allocate(stack);
			first = false;
		}

		super.allocate(stack);
	}

	@Override
	protected IGraphicsPipeline buildGraphicsPipeline()
	{
		return new GraphicsPipeline(logicalDevice, configuration, mesh.getShaders(),
				descriptorPool);
	}

	@Override
	protected IRenderPass buildRenderPass()
	{
		return new RenderPass(logicalDevice, depthResource, mesh, descriptorPool, graphicsPipeline);
	}

	@Override
	public void free(boolean full)
	{
		super.free(full);

		if (full && descriptorPool != null) descriptorPool.free();
		if (full && mesh != null) mesh.free();
	}

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}
}
