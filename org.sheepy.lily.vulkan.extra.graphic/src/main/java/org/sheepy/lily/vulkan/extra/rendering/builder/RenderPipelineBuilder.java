package org.sheepy.lily.vulkan.extra.rendering.builder;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.maintainer.MaintainerUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.ISpecializationAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;

public final class RenderPipelineBuilder
{
	private final List<DescriptedResource> commonResources;
	private final GenericRenderer<?> renderer;

	public RenderPipelineBuilder(	List<DescriptedResource> commonResources,
									GenericRenderer<?> renderer)
	{
		this.commonResources = commonResources;
		this.renderer = renderer;
	}

	public GraphicsPipeline build(int index, ISpecialization specialization)
	{
		final var pipeline = MaintainerUtil.instanciateMaintainer(renderer);

		final var range = pipeline.getPushConstantRanges();
		final var rangeSize = range.get(0).getSize();
		range.get(0).setSize(rangeSize + 4);

		pipeline.setTaskPkg(ProcessFactory.eINSTANCE.createTaskPkg());
		pipeline.setResourcePkg(VulkanFactory.eINSTANCE.createResourcePkg());
		pipeline.setDescriptorSetPkg(ResourceFactory.eINSTANCE.createDescriptorSetPkg());

		final var specializationData = prepareSpecializationBuffer(index, specialization);
		pipeline.setSpecializationData(specializationData);

		if (commonResources.isEmpty() == false)
		{
			final var descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();
			descriptorSet.getDescriptors().addAll(commonResources);
			pipeline.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);
		}

		return pipeline;
	}

	private static ByteBuffer prepareSpecializationBuffer(int index, ISpecialization specialization)
	{
		final var specializationAdapter = resolveSpecializationAdapter(specialization);
		int speByteCount = 4;
		speByteCount += specializationAdapter != null
				? specializationAdapter.byteCount(specialization)
				: 0;

		final var constantsData = BufferUtils.createByteBuffer(speByteCount);
		constantsData.putInt(index);
		if (specializationAdapter != null)
		{
			specializationAdapter.fillBuffer(specialization, constantsData);
		}
		constantsData.flip();
		return constantsData;
	}

	private static ISpecializationAdapter resolveSpecializationAdapter(ISpecialization specialization)
	{
		if (specialization != null)
		{
			return specialization.adapt(ISpecializationAdapter.class);
		}
		return null;
	}
}