package org.sheepy.lily.vulkan.process.graphic.pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.resource.IConstantsAdapter;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;
import org.sheepy.vulkan.pipeline.IConstantsFiller;
import org.sheepy.vulkan.pipeline.IShaderStageFiller;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;

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

		final List<IShaderStageFiller> shaderStageFillers = new ArrayList<>();
		for (final Shader shader : getShaders())
		{
			shaderStageFillers.add(IShaderAdapter.adapt(shader));
		}
		final List<IConstantsFiller> constantsFiller = new ArrayList<>();
		for (final var constantss : constantsList)
		{
			constantsFiller.add(IConstantsAdapter.adapt(constantss));
		}

		return new VkGraphicsPipeline(descriptorSets, constantsFiller, getColorBlend(),
				getRasterizer(), getInputAssembly(), getViewportState(), getDynamicState(),
				getVertexBufferDescriptor(), shaderStageFillers, getSubpass());
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
