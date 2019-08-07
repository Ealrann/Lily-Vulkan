package org.sheepy.lily.vulkan.extra.rendering.builder;

import java.util.List;

import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.maintainer.MaintainerUtil;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class PipelineContext
{
	public final GraphicsPipeline pipeline;
	public final PushBuffer pushBuffer;

	public PipelineContext(GraphicsPipeline pipeline, PushBuffer pushBuffer)
	{
		this.pipeline = pipeline;
		this.pushBuffer = pushBuffer;
	}

	public static final class Builder
	{
		private final List<DescriptedResource> commonResources;
		private final GenericRenderer<?> renderer;

		public Builder(List<DescriptedResource> commonResources, GenericRenderer<?> renderer)
		{
			this.commonResources = commonResources;
			this.renderer = renderer;
		}

		public PipelineContext build(int index)
		{
			final var pipeline = MaintainerUtil.instanciateMaintainer(renderer);

			pipeline.setTaskPkg(ProcessFactory.eINSTANCE.createTaskPkg());
			pipeline.setResourcePkg(VulkanFactory.eINSTANCE.createResourcePkg());
			pipeline.setDescriptorSetPkg(ResourceFactory.eINSTANCE.createDescriptorSetPkg());

			final var constantsData = BufferUtils.createByteBuffer(4);
			constantsData.putInt(0, index);
			pipeline.setSpecializationData(constantsData);

			final var constantBuffer = renderer.getConstantBuffer();
			if (constantBuffer != null)
			{
				final var pushConstant = ProcessFactory.eINSTANCE.createPushConstantBuffer();
				pushConstant.getStages().add(EShaderStage.VERTEX_BIT);
				pushConstant.getStages().add(EShaderStage.FRAGMENT_BIT);
				pushConstant.setBuffer(constantBuffer);
				pipeline.getTaskPkg().getTasks().add(pushConstant);
			}

			if (commonResources.isEmpty() == false)
			{
				final var descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();
				descriptorSet.getDescriptors().addAll(commonResources);
				pipeline.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);
			}

			return new PipelineContext(pipeline, renderer.getPushBuffer());
		}
	}
}