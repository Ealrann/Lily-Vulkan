package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorSetAllocation;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.model.process.VkPipeline;

import java.util.stream.Collectors;

public abstract class AbstractVkPipelineAdapter<T extends IVulkanContext> extends AbstractTaskPipelineAdapter<T> implements
																												 IVkPipelineAdapter<T>
{
	protected final VkPipeline pipeline;

	private VkPipelineLayout vkPipelineLayout;

	public AbstractVkPipelineAdapter(VkPipeline pipeline)
	{
		super(pipeline);
		this.pipeline = pipeline;
	}

	@Override
	public void allocate(T context)
	{
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

	@Override
	public void free(T context)
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
