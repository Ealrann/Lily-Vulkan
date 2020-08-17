package org.sheepy.lily.vulkan.extra.graphic.rendering.builder;

import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.maintainer.MaintainerUtil;
import org.sheepy.lily.vulkan.extra.api.rendering.ISpecializationAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory;

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
		final var pipeline = MaintainerUtil.instanciateMaintainer(renderer);

		final var range = pipeline.getPushConstantRanges();
		final var rangeSize = range.get(0).getSize();
		range.get(0).setSize(rangeSize + 4);

		pipeline.setDescriptorPkg(VulkanFactory.eINSTANCE.createDescriptorPkg());
		pipeline.getTaskPkgs().add(ProcessFactory.eINSTANCE.createTaskPkg());
		pipeline.setResourcePkg(VulkanFactory.eINSTANCE.createVulkanResourcePkg());
		pipeline.setDescriptorPool(VulkanResourceFactory.eINSTANCE.createDescriptorPool());

		final var specializationData = prepareSpecializationBuffer(index, specialization);
		final var constantBuffer = VulkanResourceFactory.eINSTANCE.createConstantBuffer();
		constantBuffer.setData(specializationData);

		pipeline.getResourcePkg().getResources().add(constantBuffer);
		pipeline.setSpecializationData(constantBuffer);

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
