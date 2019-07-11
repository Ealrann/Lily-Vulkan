package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.lwjgl.vulkan.VkSpecializationInfo;
import org.lwjgl.vulkan.VkSpecializationMapEntry;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

public class VkShaderStage
{
	private static final ByteBuffer MAIN_FUNCTION_NAME;
	static
	{
		final var memASCII = MemoryUtil.memASCII("main");
		final int capacity = memASCII.capacity();

		MAIN_FUNCTION_NAME = BufferUtils.createByteBuffer(capacity);
		for (int i = 0; i < capacity; i++)
		{
			MAIN_FUNCTION_NAME.put(i, memASCII.get(i));
		}

		MemoryUtil.memFree(memASCII);
	}

	private final EShaderStage stage;
	private final long shaderModule;
	private final List<SpecializationConstant> specializationConstants;

	public VkShaderStage(	EShaderStage stage,
							long shaderModule,
							List<SpecializationConstant> specializationConstants)
	{
		this.stage = stage;
		this.shaderModule = shaderModule;
		this.specializationConstants = specializationConstants;
	}

	public void fillInfo(	MemoryStack stack,
							VkPipelineShaderStageCreateInfo stageInfo,
							ByteBuffer specializationData)
	{
		stageInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO);
		stageInfo.stage(stage.getValue());
		stageInfo.module(shaderModule);
		stageInfo.pName(MAIN_FUNCTION_NAME);

		if (specializationConstants.isEmpty() == false)
		{
			final var speInfo = VkSpecializationInfo.callocStack(stack);
			final var mapEntries = VkSpecializationMapEntry
					.mallocStack(specializationConstants.size(), stack);

			int offset = 0;
			for (final var constant : specializationConstants)
			{
				final var entry = mapEntries.get();
				final int size = constant.getSize();

				entry.constantID(constant.getConstantId());
				entry.size(size);
				entry.offset(offset);

				offset += size;
			}

			mapEntries.flip();

			speInfo.pMapEntries(mapEntries);
			speInfo.pData(specializationData);

			stageInfo.pSpecializationInfo(speInfo);
		}
	}
}
