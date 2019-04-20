package org.sheepy.lily.vulkan.process.graphic.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.resource.IConstantsAdapter;
import org.sheepy.lily.vulkan.api.resource.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicState;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.InputAssembly;
import org.sheepy.lily.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.lily.vulkan.model.process.graphic.ViewportState;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;

@Statefull
@Adapter(scope = GraphicsPipeline.class)
public abstract class GraphicsPipelineAdapter extends AbstractGraphicsPipelineAdapter
{
	protected final GraphicsPipeline pipeline;
	private IConstantsAdapter pushAdapter;
	private int pushStageFlags;

	public GraphicsPipelineAdapter(GraphicsPipeline pipeline)
	{
		super(pipeline);

		this.pipeline = pipeline;
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		return null;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);
		final var constants = pipeline.getConstants();
		if (constants != null)
		{
			pushAdapter = AbstractConstantsAdapter.adapt(constants);
			final var stages = constants.getStages();
			pushStageFlags = VulkanModelUtil.getEnumeratedFlag(stages);
		}
	}

	protected void pushConstants(final VkCommandBuffer vkCommandBuffer)
	{
		if (pushAdapter != null)
		{
			final var data = pushAdapter.getData();
			vkCmdPushConstants(vkCommandBuffer, getPipelineLayout(), pushStageFlags, 0, data);
		}
	}

	@Override
	public AbstractConstants getConstants()
	{
		return pipeline.getConstants();
	}

	@Override
	public int getSubpass()
	{
		return pipeline.getSubpass();
	}

	@Override
	protected List<Shader> getShaders()
	{
		return pipeline.getShaders();
	}

	@Override
	protected ViewportState getViewportState()
	{
		return pipeline.getViewportState();
	}

	@Override
	protected InputAssembly getInputAssembly()
	{
		return pipeline.getInputAssembly();
	}

	@Override
	protected Rasterizer getRasterizer()
	{
		return pipeline.getRasterizer();
	}

	@Override
	protected ColorBlend getColorBlend()
	{
		return pipeline.getColorBlend();
	}

	@Override
	protected DynamicState getDynamicState()
	{
		return pipeline.getDynamicState();
	}
}
