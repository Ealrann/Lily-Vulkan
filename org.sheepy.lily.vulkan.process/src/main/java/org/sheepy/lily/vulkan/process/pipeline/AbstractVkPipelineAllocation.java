package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.stream.Collectors;

public abstract class AbstractVkPipelineAllocation<T extends IVulkanContext> extends AbstractTaskPipelineAllocation implements
																													IVkPipelineAllocation<T>
{
	protected final VkPipeline pipeline;
	private final VkPipelineLayout vkPipelineLayout;

	protected AbstractVkPipelineAllocation(VkPipeline pipeline, IObservatoryBuilder observatory, ProcessContext context)
	{
		super(pipeline, observatory);
		this.pipeline = pipeline;

		vkPipelineLayout = createVkPipelineLayout();
		vkPipelineLayout.allocate(context);

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			System.out.print("Pipeline Layout: ");
			System.out.println(vkPipelineLayout.toString());
		}
	}

	protected VkPipelineLayout createVkPipelineLayout()
	{
		final var pushConstantRanges = pipeline.getPushConstantRanges();
		final var sets = pipeline.getLayout()
								 .stream()
								 .map(set -> set.allocationHandle(IDescriptorSetAllocation.class).get())
								 .collect(Collectors.toUnmodifiableList());

		return new VkPipelineLayout(sets, pushConstantRanges);
	}

	@Free
	private void free(T context)
	{
		vkPipelineLayout.free(context);
	}

	@Override
	protected final void recordInternal(RecordContext context)
	{
		final var pipelineStage = pipeline.getStage();
		final var vkPipeline = getVkPipeline();
		final var currentStage = context.stage;
		if (vkPipeline != null && pipelineStage == currentStage)
		{
			vkPipeline.bindPipeline(context.commandBuffer);
		}

		super.recordInternal(context);
	}

	@Override
	public VkPipelineLayout getVkPipelineLayout()
	{
		return vkPipelineLayout;
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
