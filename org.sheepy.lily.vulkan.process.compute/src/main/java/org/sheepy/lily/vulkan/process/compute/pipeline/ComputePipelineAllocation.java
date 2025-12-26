package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetLayoutAllocation;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.core.resource.IShaderAllocation;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class, activator = ComputePipeline.FeatureIDs.ALLOCATE)
public final class ComputePipelineAllocation implements IPipelineAllocation
{
	private final VkComputePipeline vkPipeline;
	private final VkPipelineLayout vkPipelineLayout;
	private final IAllocationState allocationState;

	private ComputePipelineAllocation(ComputePipeline pipeline,
									  ProcessContext context,
									  IAllocationState allocationState)
	{
		this.allocationState = allocationState;
		final var pushConstantRanges = pipeline.pushConstantRanges();
		final var sets = pipeline.layout()
								 .stream()
								 .map(set -> set.adapt(IDescriptorSetLayoutAllocation.class))
								 .toList();

		vkPipelineLayout = new VkPipelineLayout(sets, pushConstantRanges);
		vkPipelineLayout.allocate(context);

		final var shader = pipeline.shader();
		final var shaderAdapter = shader.adapt(IShaderAllocation.class);
		final var shaderStage = shaderAdapter.getVkShaderStage();
		final var specializationData = pipeline.specializationData();
		final var specializationBuffer = specializationData != null ? specializationData.data() : null;

		vkPipeline = new VkComputePipeline(vkPipelineLayout, shaderStage, specializationBuffer);
		vkPipeline.allocate(context);
	}

	@Free
	private void free(ProcessContext context)
	{
		vkPipeline.free(context);
		vkPipelineLayout.free(context);
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

	public void attach(final RecordContext context)
	{
		context.lockAllocationDuringExecution(allocationState);
	}
}
