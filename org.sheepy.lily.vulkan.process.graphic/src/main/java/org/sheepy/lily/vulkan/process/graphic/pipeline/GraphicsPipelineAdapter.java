package org.sheepy.lily.vulkan.process.graphic.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.util.ModelUtil;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.resource.indexed.IVertexBufferDescriptor;

@Statefull
@Adapter(scope = GraphicsPipeline.class)
public abstract class GraphicsPipelineAdapter extends AbstractGraphicsPipelineAdapter
{
	protected final GraphicsPipeline pipeline;

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
	public void record(VkCommandBuffer vkCommandBuffer, int bindPoint, int index)
	{
		vkCmdBindPipeline(vkCommandBuffer, bindPoint, pipelineId);

		pushConstants(vkCommandBuffer);

		if (pipeline.getDescriptorSet() != null)
		{
			bindDescriptor(vkCommandBuffer, bindPoint, 0);
		}
	}

	@Override
	public List<IVkDescriptorSet> getDescriptorSets()
	{
		final List<IVkDescriptorSet> res = new ArrayList<>();
		final var ds = pipeline.getDescriptorSet();

		if (ds != null)
		{
			final var adapter = IDescriptorSetAdapter.adapt(ds);
			res.add(adapter);
		}
		return res;
	}

	protected void pushConstants(final VkCommandBuffer vkCommandBuffer)
	{
		final var constants = pipeline.getConstants();
		if (constants != null)
		{
			final var pushAdapter = AbstractConstantsAdapter.adapt(constants);
			final var stages = constants.getStages();
			final var data = pushAdapter.getData();
			final int stageFlags = ModelUtil.getEnumeratedFlag(stages);

			vkCmdPushConstants(vkCommandBuffer, pipelineLayout, stageFlags, 0, data);
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
}
