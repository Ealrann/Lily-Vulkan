package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineRecordable;
import org.sheepy.lily.vulkan.core.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.core.resource.IShaderAllocation;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.pipeline.TaskPipelineManager;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;
import java.util.stream.Collectors;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__DESCRIPTOR_POOL})
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS})
@AllocationDependency(features = {ComputePackage.COMPUTE_PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS}, type = IPipelineTaskRecorder.class)
public final class ComputePipelineRecorder implements IVkPipelineRecordable
{
	private final ComputePipeline pipeline;
	private final VkComputePipeline vkPipeline;
	private final VkPipelineLayout vkPipelineLayout;
	private final TaskPipelineManager taskManager;
	private boolean recordNeeded = false;

	private ComputePipelineRecorder(ComputePipeline pipeline,
								   ProcessContext context,
								   IObservatoryBuilder observatory,
								   @InjectDependency(index = 0) List<IPipelineTaskRecorder> tasks)
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

		final var shader = pipeline.getShader();
		final var shaderAdapter = shader.adapt(IShaderAllocation.class);
		final var shaderStage = shaderAdapter.getVkShaderStage();
		final var specializationData = pipeline.getSpecializationData();
		final var specializationBuffer = specializationData != null ? specializationData.getData() : null;

		vkPipeline = new VkComputePipeline(vkPipelineLayout, shaderStage, specializationBuffer);
		vkPipeline.allocate(context);

		observatory.listenNoParam(() -> recordNeeded = true, ProcessPackage.ABSTRACT_PIPELINE__ENABLED);
	}

	@Free
	private void free(ProcessContext context)
	{
		vkPipeline.free(context);
		vkPipelineLayout.free(context);
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
