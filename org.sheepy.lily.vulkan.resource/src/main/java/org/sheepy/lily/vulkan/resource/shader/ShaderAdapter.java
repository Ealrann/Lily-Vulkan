package org.sheepy.lily.vulkan.resource.shader;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;
import org.sheepy.lily.vulkan.core.resource.IShaderAdapter;
import org.sheepy.lily.vulkan.model.resource.Shader;

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
	public void allocate(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		final var resource = shader.getFile();

		shaderBackend = new ShaderBackend(vkDevice, resource);
		shaderBackend.allocate(context.stack());

		final var specializationConstants = shader.getConstants();
		final long id = shaderBackend.getPtr();
		final var stage = shader.getStage();

		shaderStage = new VkShaderStage(stage, id, specializationConstants);
		// System.out.println(shaderBackend.getPtr() + " - " + shader.getName());
	}

	@Override
	public void free(ExecutionContext context)
	{
		shaderBackend.free();
		shaderBackend = null;
	}

	@Override
	public VkShaderStage getVkShaderStage()
	{
		return shaderStage;
	}
}
