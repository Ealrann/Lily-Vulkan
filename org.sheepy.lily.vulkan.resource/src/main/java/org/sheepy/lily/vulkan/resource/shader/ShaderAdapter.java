package org.sheepy.lily.vulkan.resource.shader;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.vulkan.execution.IExecutionContext;

@Statefull
@Adapter(scope = Shader.class)
public class ShaderAdapter implements IShaderAdapter
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

	private final Shader shader;

	private ShaderBackend shaderBackend;

	public ShaderAdapter(Shader shader)
	{
		this.shader = shader;
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		final var resource = shader.getFile();

		shaderBackend = new ShaderBackend(vkDevice, resource);
		shaderBackend.allocate(stack);
	}

	/**
	 * You will be responsible to free this object.
	 *
	 * @return
	 */
	@Override
	public void fillInfo(VkPipelineShaderStageCreateInfo info)
	{
		info.sType(VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO);
		info.stage(shader.getStage().getValue());
		info.module(getShaderModule());
		info.pName(MAIN_FUNCTION_NAME);
	}

	@Override
	public void free(IExecutionContext context)
	{
		shaderBackend.free();
		shaderBackend = null;
	}

	@Override
	public long getShaderModule()
	{
		return shaderBackend.getId();
	}
}
