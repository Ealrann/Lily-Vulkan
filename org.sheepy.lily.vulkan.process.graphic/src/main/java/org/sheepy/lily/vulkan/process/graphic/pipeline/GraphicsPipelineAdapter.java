package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.core.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;
import org.sheepy.lily.vulkan.core.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.process.graphic.pipeline.VkInputStateDescriptor.VkAttributeDescription;
import org.sheepy.lily.vulkan.process.graphic.pipeline.VkInputStateDescriptor.VkVertexBinding;
import org.sheepy.lily.vulkan.process.pipeline.AbstractVkPipelineAdapter;

import java.util.ArrayList;
import java.util.List;

@Statefull
@Adapter(scope = GraphicsPipeline.class)
public class GraphicsPipelineAdapter extends AbstractVkPipelineAdapter<IGraphicContext>
{
	protected final GraphicsPipeline pipeline;

	private VkGraphicsPipeline vkGraphicsPipeline;
	private IAllocationConfigurator config;

	public GraphicsPipelineAdapter(GraphicsPipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		this.config = config;
		this.config.addDependencies(List.of(context.getRenderPass()));
		super.configureAllocation(config, context);
	}

	@NotifyChanged(featureIds = GraphicPackage.GRAPHICS_PIPELINE__SHADERS)
	private void shaderChanged()
	{
		if (config != null) config.setDirty();
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
		final var subpass = ModelUtil.findParent(pipeline, Subpass.class);
		final var viewportState = pipeline.getViewportState();
		final var inputAssembly = pipeline.getInputAssembly();
		final var rasterizer = pipeline.getRasterizer();
		final var colorBlend = pipeline.getColorBlend();
		final var dynamicState = pipeline.getDynamicState();
		final var specialization = pipeline.getSpecializationData();
		final var depthStencilState = pipeline.getDepthStencilState();
		final var specializationBuffer = specialization != null ? specialization.getData() : null;
		final int subpassIndex = subpass.getSubpassIndex();

		vkGraphicsPipeline = new VkGraphicsPipeline(getVkPipelineLayout(),
													colorBlend,
													rasterizer,
													inputAssembly,
													viewportState,
													dynamicState,
													depthStencilState,
													inputState,
													shaderStages,
													specializationBuffer,
													subpassIndex);
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
	public VkPipeline<IGraphicContext> getVkPipeline()
	{
		return vkGraphicsPipeline;
	}
}
