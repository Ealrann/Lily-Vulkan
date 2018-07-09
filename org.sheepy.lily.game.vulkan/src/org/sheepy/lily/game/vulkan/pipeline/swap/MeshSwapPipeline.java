package org.sheepy.lily.game.vulkan.pipeline.swap;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.Collection;
import java.util.Collections;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.game.vulkan.buffer.Mesh;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.concurrent.ISignalEmitter;
import org.sheepy.lily.game.vulkan.descriptor.BasicDescriptorSetConfiguration;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.pipeline.swap.graphic.GraphicsPipeline;

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
			try (MemoryStack stack = stackPush())
			{
				BasicDescriptorSetConfiguration descriptorConfiguration = new BasicDescriptorSetConfiguration();
				descriptorConfiguration.addAll(mesh.getDescriptors());

				descriptorPool = DescriptorPool.alloc(stack, logicalDevice,
						Collections.singletonList(descriptorConfiguration));
			}
		}
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
	public void load(long surface, int width, int height)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			mesh.allocate(stack);
		}

		super.load(surface, width, height);
	}

	@Override
	public void destroy(boolean full)
	{
		if (full && descriptorPool != null) descriptorPool.free();
		if (full && mesh != null) mesh.free();

		super.destroy(full);
	}

	public DescriptorPool getDescriptorPool()
	{
		return descriptorPool;
	}
}
