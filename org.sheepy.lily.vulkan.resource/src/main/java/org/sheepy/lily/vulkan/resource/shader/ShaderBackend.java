package org.sheepy.lily.vulkan.resource.shader;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkShaderModuleCreateInfo;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.nio.LongBuffer;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.*;

public class ShaderBackend
{
	private static final String FAILED_TO_CREATE_SHADER = "Failed to create shader";

	private final VkDevice vkDevice;
	private final FileResource shaderResource;

	private long shaderPtr = 0;

	public ShaderBackend(VkDevice vkDevice, FileResource shaderResource)
	{
		this.vkDevice = vkDevice;
		this.shaderResource = shaderResource;
	}

	public void allocate(MemoryStack stack)
	{
		final var fileAdapter = shaderResource.adapt(IFileResourceAdapter.class);
		final var shaderCode = fileAdapter.allocByteBuffer(shaderResource);

		final var moduleCreateInfo = VkShaderModuleCreateInfo.mallocStack(stack);
		moduleCreateInfo.sType(VK_STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO);
		moduleCreateInfo.pCode(shaderCode);
		moduleCreateInfo.flags(0);
		moduleCreateInfo.pNext(NULL);

		final LongBuffer pShaderModule = stack.mallocLong(1);
		Logger.check(vkCreateShaderModule(vkDevice, moduleCreateInfo, null, pShaderModule), FAILED_TO_CREATE_SHADER);
		shaderPtr = pShaderModule.get();
		MemoryUtil.memFree(shaderCode);
	}

	public void free()
	{
		vkDestroyShaderModule(vkDevice, shaderPtr, null);
		shaderPtr = 0;
	}

	public long getPtr()
	{
		return shaderPtr;
	}
}
