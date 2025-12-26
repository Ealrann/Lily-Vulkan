package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.maintainer.MaintainerUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.ISpecializationAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;

import java.nio.ByteBuffer;

public final class RenderPipelineBuilder
{
	private final GenericRenderer<?> renderer;

	public RenderPipelineBuilder(GenericRenderer<?> renderer)
	{
		this.renderer = renderer;
	}

	public GraphicsPipeline build(int index, ISpecialization specialization)
	{
		final var pipeline = MaintainerUtil.instanciateMaintainer(renderer, false);

		final var range = pipeline.pushConstantRanges();
		final var rangeSize = range.get(0).size();
		range.get(0).size(rangeSize + 4);

		pipeline.descriptorPkg(DescriptorPkg.builder().build());
		pipeline.taskPkgs().add(TaskPkg.builder().build());
		pipeline.resourcePkg(VulkanResourcePkg.builder().build());
		pipeline.descriptorPool(DescriptorPool.builder().build());

		final var specializationData = prepareSpecializationBuffer(index, specialization);
		final var constantBuffer = ConstantBuffer.builder().data(specializationData).build();

		pipeline.resourcePkg().resources().add(constantBuffer);
		pipeline.specializationData(constantBuffer);

		return pipeline;
	}

	private static ByteBuffer prepareSpecializationBuffer(int index, ISpecialization specialization)
	{
		final var specializationAdapter = resolveSpecializationAdapter(specialization);
		final int speByteCount = specializationAdapter != null ? specializationAdapter.byteCount(specialization) : 0;
		final var constantsData = BufferUtils.createByteBuffer(speByteCount + 4);

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
		else
		{
			return null;
		}
	}
}
