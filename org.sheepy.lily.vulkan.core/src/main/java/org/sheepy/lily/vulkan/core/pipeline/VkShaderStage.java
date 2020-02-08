package org.sheepy.lily.vulkan.core.pipeline;

import static org.lwjgl.vulkan.VK10.*;

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

public final class VkShaderStage
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

	private final int stage;
	private final long shaderModule;
	private final List<SpecializationConstant> specializationConstants;

	public VkShaderStage(	EShaderStage stage,
							long shaderModule,
							List<SpecializationConstant> specializationConstants)
	{
		this.stage = stage.getValue();
		this.shaderModule = shaderModule;
		this.specializationConstants = List.copyOf(specializationConstants);
	}

	public void fillInfo(	MemoryStack stack,
							VkPipelineShaderStageCreateInfo stageInfo,
							ByteBuffer specializationData)
	{
		final var speInfo = allocSpecializationInfo(stack, specializationData);

		stageInfo.set(	VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO,
						VK_NULL_HANDLE,
						0,
						stage,
						shaderModule,
						MAIN_FUNCTION_NAME,
						speInfo);
	}

	private VkSpecializationInfo allocSpecializationInfo(	MemoryStack stack,
															ByteBuffer specializationData)
	{
		VkSpecializationInfo speInfo = null;
		if (specializationConstants.isEmpty() == false)
		{
			final int constantCount = specializationConstants.size();
			final var mapEntries = VkSpecializationMapEntry.mallocStack(constantCount, stack);

			int offset = 0;
			for (int i = 0; i < constantCount; i++)
			{
				final var constant = specializationConstants.get(i);
				final var entry = mapEntries.get();
				final int size = constant.getSize();
				final int constantId = constant.getConstantId();

				entry.set(constantId, offset, size);

				offset += size;
			}

			mapEntries.flip();

			speInfo = VkSpecializationInfo.callocStack(stack);
			speInfo.set(mapEntries, specializationData);
		}
		return speInfo;
	}
}
