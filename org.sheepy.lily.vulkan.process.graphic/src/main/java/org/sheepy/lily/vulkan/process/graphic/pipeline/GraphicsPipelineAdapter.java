package org.sheepy.lily.vulkan.process.graphic.pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfiguration;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.VkShaderStage;
import org.sheepy.vulkan.resource.indexed.VkInputStateDescriptor;
import org.sheepy.vulkan.resource.indexed.VkInputStateDescriptor.VkAttributeDescription;
import org.sheepy.vulkan.resource.indexed.VkInputStateDescriptor.VkVertexBinding;

@Statefull
@Adapter(scope = GraphicsPipeline.class)
public class GraphicsPipelineAdapter extends AbstractPipelineAdapter<IGraphicContext>
{
	protected final GraphicsPipeline pipeline;

	private VkGraphicsPipeline vkGraphicsPipeline;

	public GraphicsPipelineAdapter(GraphicsPipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
	}

	@Override
	public void configureAllocation(IAllocationConfiguration config, IGraphicContext context)
	{
		config.addDependencies(List.of(context.getRenderPass()));
		super.configureAllocation(config, context);
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		super.allocate(context);
		final var shaders = pipeline.getShaders();

		final List<VkShaderStage> shaderStages = new ArrayList<>();
		for (final Shader shader : shaders)
		{
			shaderStages.add(shader.adaptNotNull(IShaderAdapter.class).getVkShaderStage());
		}

		final var vertexInputState = pipeline.getVertexInputState();
		final var inputState = createVkInputState(vertexInputState);
		final var subpass = pipeline.getSubpass();
		final var viewportState = pipeline.getViewportState();
		final var inputAssembly = pipeline.getInputAssembly();
		final var rasterizer = pipeline.getRasterizer();
		final var colorBlend = pipeline.getColorBlend();
		final var dynamicState = pipeline.getDynamicState();
		final var specializationData = pipeline.getSpecializationData();

		vkGraphicsPipeline = new VkGraphicsPipeline(getVkPipelineLayout(),
													colorBlend,
													rasterizer,
													inputAssembly,
													viewportState,
													dynamicState,
													inputState,
													shaderStages,
													specializationData,
													subpass);
		vkGraphicsPipeline.allocate(context);
	}

	@Override
	public void free(IGraphicContext context)
	{
		vkGraphicsPipeline.free(context);
		super.free(context);
	}

	public static VkInputStateDescriptor createVkInputState(VertexInputState inputState)
	{
		final List<VkVertexBinding> bindings = new ArrayList<>();

		for (final var inputDescriptor : inputState.getInputDescriptor())
		{
			final var inputRate = inputDescriptor.getInputRate();
			final var stride = inputDescriptor.getStrideLength();
			final List<VkAttributeDescription> attributes = new ArrayList<>();

			for (final var attribute : inputDescriptor.getAttributes())
			{
				final var format = attribute.getFormat().getValue();
				final var offset = attribute.getOffset();
				attributes.add(new VkAttributeDescription(format, offset));
			}

			bindings.add(new VkVertexBinding(inputRate, stride, attributes));
		}

		return new VkInputStateDescriptor(bindings);
	}

	@Override
	public List<VkPipeline<IGraphicContext>> getVkPipelines()
	{
		return Collections.singletonList(vkGraphicsPipeline);
	}

	public int getSubpass()
	{
		return pipeline.getSubpass();
	}
}
