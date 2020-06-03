package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.pipeline.*;
import org.sheepy.lily.vulkan.core.resource.IShaderAllocation;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.pipeline.VkInputStateDescriptor.VkAttributeDescription;
import org.sheepy.lily.vulkan.process.graphic.pipeline.VkInputStateDescriptor.VkVertexBinding;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.pipeline.TaskPipelineManager;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ModelExtender(scope = GraphicsPipeline.class)
@Adapter
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_POOL})
@AllocationChild(features = {GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS})
@AllocationDependency(features = {GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS}, type = IPipelineTaskRecorder.class)
@AllocationDependency(features = GraphicPackage.GRAPHICS_PIPELINE__SHADERS, type = IShaderAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS}, type = RenderPassAllocation.class)
public class GraphicsPipelineRecorder implements IVkPipelineRecordable
{
	private final GraphicsPipeline pipeline;
	private final VkGraphicsPipeline vkPipeline;
	private final VkPipelineLayout vkPipelineLayout;
	private final TaskPipelineManager taskManager;
	private boolean recordNeeded = false;

	public GraphicsPipelineRecorder(GraphicsPipeline pipeline,
									ProcessContext context,
									IObservatoryBuilder observatory,
									@InjectDependency(index = 0) List<IPipelineTaskRecorder> tasks,
									@InjectDependency(index = 1) List<IShaderAllocation> shaders,
									@InjectDependency(index = 2) PhysicalSurfaceAllocation surfaceAllocation,
									@InjectDependency(index = 3) RenderPassAllocation renderPassAllocation)
	{
		this.pipeline = pipeline;
		taskManager = new TaskPipelineManager(pipeline, tasks);

		final var pushConstantRanges = pipeline.getPushConstantRanges();
		final var sets = pipeline.getLayout()
								 .stream()
								 .map(set -> set.adapt(IDescriptorSetAllocation.class))
								 .collect(Collectors.toUnmodifiableList());

		vkPipelineLayout = new VkPipelineLayout(sets, pushConstantRanges);
		vkPipelineLayout.allocate(context);

		observatory.listenNoParam(() -> recordNeeded = true, ProcessPackage.ABSTRACT_PIPELINE__ENABLED);

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
	public void update(final int index)
	{
		taskManager.update(index);
	}

	@Override
	public void record(RecordContext context)
	{
		if (isActive())
		{
			final var pipelineStage = pipeline.getStage();
			final var currentStage = context.stage;
			if (vkPipeline != null && pipelineStage == currentStage)
			{
				vkPipeline.bindPipeline(context.commandBuffer);
			}
			taskManager.record(context);
		}
		recordNeeded = false;
	}

	@Override
	public boolean shouldRecord(final ECommandStage stage)
	{
		return pipeline.getStage() == stage || taskManager.shouldRecord(stage);
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}

	@Override
	public boolean isRecordDirty(final int index)
	{
		return recordNeeded || taskManager.isRecordDirty(index);
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
