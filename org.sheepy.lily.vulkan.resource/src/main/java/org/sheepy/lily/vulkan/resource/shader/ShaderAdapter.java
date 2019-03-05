package org.sheepy.lily.vulkan.resource.shader;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.Shader;

@Statefull
@Adapter(scope = Shader.class)
public class ShaderAdapter implements IResourceAdapter
{
	private static ByteBuffer MAIN_FUNCTION_NAME = MemoryUtil.memASCII("main");

	private final Shader shader;

	private ShaderBackend shaderBackend;

	public ShaderAdapter(Shader shader)
	{
		this.shader = shader;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var vkDevice = ((ExecutionContext) context).getVkDevice();
		var resource = shader.getFile();

		shaderBackend = new ShaderBackend(vkDevice, resource);
		shaderBackend.allocate(stack);
	}

	/**
	 * You will be responsible to free this object.
	 *
	 * @return
	 */
	public void fillInfo(VkPipelineShaderStageCreateInfo info)
	{
		info.sType(VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO);
		info.stage(shader.getStage().getValue());
		info.module(getShaderModule());
		info.pName(MAIN_FUNCTION_NAME);
	}

	@Override
	public void free(IAllocationContext context)
	{
		shaderBackend.free();
		shaderBackend = null;
	}

	public long getShaderModule()
	{
		return shaderBackend.getId();
	}

	public static ShaderAdapter adapt(Shader shader)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(shader, ShaderAdapter.class);
	}
}
