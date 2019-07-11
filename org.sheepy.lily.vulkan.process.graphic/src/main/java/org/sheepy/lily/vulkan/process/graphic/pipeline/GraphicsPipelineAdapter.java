package org.sheepy.lily.vulkan.process.graphic.pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.api.resource.IVertexDescriptorAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.process.pipeline.AbstractPipelineAdapter;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.VkShaderStage;

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
	public void allocate(MemoryStack stack, IGraphicContext context)
	{
		super.allocate(stack, context);
		final var renderPass = context.getRenderPass();
		final var shaders = pipeline.getShaders();
		allocationDependencies.add(renderPass);

		final List<VkShaderStage> shaderStages = new ArrayList<>();
		for (final Shader shader : shaders)
		{
			shaderStages.add(IShaderAdapter.adapt(shader).getVkShaderStage());
		}

		final var vertexDescriptor = pipeline.getVertexDescriptor();
		final var vertexAdapter = IVertexDescriptorAdapter.adapt(vertexDescriptor);
		final var vkVertexDescriptor = vertexAdapter.buildVertexDescriptor(vertexDescriptor);
		final var subpass = pipeline.getSubpass();
		final var viewportState = pipeline.getViewportState();
		final var inputAssembly = pipeline.getInputAssembly();
		final var rasterizer = pipeline.getRasterizer();
		final var colorBlend = pipeline.getColorBlend();
		final var dynamicState = pipeline.getDynamicState();
		final var specializationData = pipeline.getSpecializationData();

		vkGraphicsPipeline = new VkGraphicsPipeline(getVkPipelineLayout(), colorBlend, rasterizer,
				inputAssembly, viewportState, dynamicState, vkVertexDescriptor, shaderStages,
				specializationData, subpass);
		vkGraphicsPipeline.allocate(stack, context);
	}

	@Override
	public void free(IGraphicContext context)
	{
		final var graphicContext = context;
		final var renderPass = graphicContext.getRenderPass();
		allocationDependencies.remove(renderPass);
		vkGraphicsPipeline.free(context);
		super.free(context);
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
