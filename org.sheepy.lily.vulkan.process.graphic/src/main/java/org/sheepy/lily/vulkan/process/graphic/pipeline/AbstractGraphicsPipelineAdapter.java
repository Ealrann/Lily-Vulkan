package org.sheepy.lily.vulkan.process.graphic.pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.nativehelper.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.api.nativehelper.pipeline.VkGraphicsPipeline;
import org.sheepy.lily.vulkan.api.nativehelper.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.api.resource.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.lily.vulkan.model.process.graphic.DynamicState;
import org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.InputAssembly;
import org.sheepy.lily.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.lily.vulkan.model.process.graphic.ViewportState;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;

public abstract class AbstractGraphicsPipelineAdapter extends AbstractPipelineAdapter
{
	public AbstractGraphicsPipelineAdapter(IGraphicsPipeline pipeline)
	{
		super(pipeline);
	}

	@Override
	protected VkPipeline createVkPipeline()
	{
		final var constants = getConstants();
		final List<IVkDescriptorSet> descriptorSets = new ArrayList<>();
		final List<AbstractConstants> constantsList = constants != null
				? List.of(constants)
				: Collections.emptyList();

		collectDescriptorSets(descriptorSets);

		return new VkGraphicsPipeline(descriptorSets, constantsList, getColorBlend(),
				getRasterizer(), getInputAssembly(), getViewportState(), getDynamicState(),
				getVertexBufferDescriptor(), getShaders(), getSubpass());
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		final var graphicContext = (IGraphicContext) context;
		final var renderPass = graphicContext.getRenderPass();
		allocationDependencies.add(renderPass);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		final var renderPass = graphicContext.getRenderPass();
		allocationDependencies.remove(renderPass);

		super.free(context);
	}

	protected abstract List<Shader> getShaders();

	protected abstract ViewportState getViewportState();

	protected abstract Rasterizer getRasterizer();

	protected abstract InputAssembly getInputAssembly();

	protected abstract ColorBlend getColorBlend();

	protected abstract DynamicState getDynamicState();

	public abstract int getSubpass();

	abstract protected IVertexBufferDescriptor<?> getVertexBufferDescriptor();
}
