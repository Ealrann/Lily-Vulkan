package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetLayoutAllocation;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;
import org.sheepy.lily.vulkan.core.resource.IShaderAllocation;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.pipeline.VkInputStateDescriptor.VkAttributeDescription;
import org.sheepy.lily.vulkan.process.graphic.pipeline.VkInputStateDescriptor.VkVertexBinding;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicConfigurationAllocation;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = GraphicsPipeline.class)
@Allocation(context = ProcessContext.class, activator = GraphicPackage.GRAPHICS_PIPELINE__ALLOCATE)
@AllocationDependency(features = GraphicPackage.GRAPHICS_PIPELINE__SHADERS, type = IShaderAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, type = GraphicConfigurationAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS}, type = RenderPassAllocation.class)
public final class GraphicsPipelineAllocation implements IPipelineAllocation
{
	private final VkGraphicsPipeline vkPipeline;
	private final VkPipelineLayout vkPipelineLayout;
	private final IAllocationState allocationState;
	private final GraphicConfigurationAllocation graphicConfigurationAllocation;

	public GraphicsPipelineAllocation(GraphicsPipeline pipeline,
									  ProcessContext context,
									  IAllocationState allocationState,
									  @InjectDependency(index = 0) List<IShaderAllocation> shaders,
									  @InjectDependency(index = 1) GraphicConfigurationAllocation graphicConfigurationAllocation,
									  @InjectDependency(index = 2) PhysicalSurfaceAllocation surfaceAllocation,
									  @InjectDependency(index = 3) RenderPassAllocation renderPassAllocation)
	{
		this.allocationState = allocationState;
		this.graphicConfigurationAllocation = graphicConfigurationAllocation;
		final var pushConstantRanges = pipeline.getPushConstantRanges();
		final var sets = pipeline.getLayout()
								 .stream()
								 .map(set -> set.adapt(IDescriptorSetLayoutAllocation.class))
								 .toList();

		vkPipelineLayout = new VkPipelineLayout(sets, pushConstantRanges);
		vkPipelineLayout.allocate(context);

		final List<VkShaderStage> shaderStages = new ArrayList<>();
		for (final var shader : shaders)
		{
			shaderStages.add(shader.getVkShaderStage());
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
		final var extent = surfaceAllocation.getExtent();

		vkPipeline = new VkGraphicsPipeline(vkPipelineLayout,
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

		vkPipeline.allocate(context, extent, renderPassAllocation);
	}

	public void attach(final RecordContext context)
	{
		context.lockAllocationDuringExecution(allocationState);
		graphicConfigurationAllocation.attach(context);
	}

	@Free
	public void free(ProcessContext context)
	{
		vkPipeline.free(context);
		vkPipelineLayout.free(context);
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
	public VkPipelineLayout getVkPipelineLayout()
	{
		return vkPipelineLayout;
	}

	@Override
	public VkPipeline getVkPipeline()
	{
		return vkPipeline;
	}
}
