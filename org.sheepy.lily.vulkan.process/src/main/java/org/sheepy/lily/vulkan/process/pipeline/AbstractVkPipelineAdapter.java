package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelExplorer;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.core.device.VulkanContext;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.core.resource.IDescriptorSetAdapter;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Statefull
public abstract class AbstractVkPipelineAdapter<T extends VulkanContext> extends AbstractTaskPipelineAdapter<T> implements
																												IVkPipelineAdapter<T>
{
	private static final ModelExplorer DERSCRIPTOR_SET_EXPLORER = new ModelExplorer(List.of(ProcessPackage.Literals.VK_PIPELINE__DESCRIPTOR_SET_PKG,
																							VulkanResourcePackage.Literals.DESCRIPTOR_SET_PKG__DESCRIPTOR_SETS));

	protected final VkPipeline pipeline;

	private VkPipelineLayout<? super T> vkPipelineLayout;

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

	protected VkPipelineLayout<T> createVkPipelineLayout()
	{
		final List<IVkDescriptorSet> descriptorSets = new ArrayList<>();
		for (final var descriptorSet : pipeline.getLayout())
		{
			descriptorSets.add(descriptorSet.adapt(IDescriptorSetAdapter.class));
		}

		final var pushConstantRanges = pipeline.getPushConstantRanges();
		return new VkPipelineLayout<>(descriptorSets, pushConstantRanges);
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
	public void collectDescriptorSets(List<IVkDescriptorSet> collectIn)
	{
		DERSCRIPTOR_SET_EXPLORER.streamAdaptNotNull(pipeline, IDescriptorSetAdapter.class)
								.collect(Collectors.toCollection(() -> collectIn));
	}

	@Override
	public VkPipelineLayout<? super T> getVkPipelineLayout()
	{
		return vkPipelineLayout;
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
