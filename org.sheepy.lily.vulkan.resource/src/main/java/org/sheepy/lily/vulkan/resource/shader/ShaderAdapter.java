package org.sheepy.lily.vulkan.resource.shader;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.pipeline.VkShaderStage;

@Statefull
@Adapter(scope = Shader.class)
public class ShaderAdapter implements IShaderAdapter
{
	private final Shader shader;

	private ShaderBackend shaderBackend;

	private VkShaderStage shaderStage;

	public ShaderAdapter(Shader shader)
	{
		this.shader = shader;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		final var resource = shader.getFile();

		shaderBackend = new ShaderBackend(vkDevice, resource);
		shaderBackend.allocate(context.stack());

		final var specializationConstants = shader.getConstants();
		final long id = shaderBackend.getId();
		final var stage = shader.getStage();

		shaderStage = new VkShaderStage(stage, id, specializationConstants);
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

	@Override
	public VkShaderStage getVkShaderStage()
	{
		return shaderStage;
	}
}
