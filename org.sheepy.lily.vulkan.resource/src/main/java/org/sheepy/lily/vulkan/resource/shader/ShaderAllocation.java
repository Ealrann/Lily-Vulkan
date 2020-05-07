package org.sheepy.lily.vulkan.resource.shader;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkShaderModuleCreateInfo;
import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.pipeline.VkShaderStage;
import org.sheepy.lily.vulkan.core.resource.IShaderAllocation;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.resource.Shader;

import java.nio.LongBuffer;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = Shader.class)
@Allocation(context = ExecutionContext.class)
public final class ShaderAllocation implements IShaderAllocation
{
	private static final String FAILED_TO_CREATE_SHADER = "Failed to create shader";

	private final VkShaderStage shaderStage;
	private final long shaderPtr;

	public ShaderAllocation(Shader shader, ExecutionContext context)
	{
		shaderPtr = allocateShader(shader, context);

		final var specializationConstants = shader.getConstants();
		final var stage = shader.getStage();

		shaderStage = new VkShaderStage(stage, shaderPtr, specializationConstants);
		// System.out.println(shaderBackend.getPtr() + " - " + shader.getName());
	}

	@Free
	public void free(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		vkDestroyShaderModule(vkDevice, shaderPtr, null);
	}

	@Override
	public VkShaderStage getVkShaderStage()
	{
		return shaderStage;
	}

	private static long allocateShader(final Shader shader, final ExecutionContext context)
	{
		final long shaderPtr;
		final var shaderResource = shader.getFile();
		final var vkDevice = context.getVkDevice();
		final var stack = context.stack();
		final var fileAdapter = shaderResource.adapt(IFileResourceAdapter.class);
		final var moduleCreateInfo = VkShaderModuleCreateInfo.mallocStack(stack);
		final var shaderCode = fileAdapter.allocByteBuffer(shaderResource);
		moduleCreateInfo.sType(VK_STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO);
		moduleCreateInfo.pCode(shaderCode);
		moduleCreateInfo.flags(0);
		moduleCreateInfo.pNext(NULL);

		final LongBuffer pShaderModule = stack.mallocLong(1);
		Logger.check(vkCreateShaderModule(vkDevice, moduleCreateInfo, null, pShaderModule), FAILED_TO_CREATE_SHADER);
		shaderPtr = pShaderModule.get();
		MemoryUtil.memFree(shaderCode);
		return shaderPtr;
	}
}
