package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.core.resource.IShaderAllocation;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.stream.Collectors;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__DESCRIPTOR_POOL})
@AllocationChild(features = {ComputePackage.COMPUTE_PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS})
public final class ComputePipelineAllocation implements IExtender
{
	private final VkComputePipeline vkPipeline;
	private final VkPipelineLayout vkPipelineLayout;

	private ComputePipelineAllocation(ComputePipeline pipeline, ProcessContext context)
	{
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
	}

	@Free
	private void free(ProcessContext context)
	{
		vkPipeline.free(context);
		vkPipelineLayout.free(context);
	}

	public VkPipelineLayout getVkPipelineLayout()
	{
		return vkPipelineLayout;
	}

	public VkPipeline getVkPipeline()
	{
		return vkPipeline;
	}
}
