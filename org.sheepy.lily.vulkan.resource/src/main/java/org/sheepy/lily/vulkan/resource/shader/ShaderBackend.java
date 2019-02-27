package org.sheepy.lily.vulkan.resource.shader;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkShaderModuleCreateInfo;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.resource.file.PathResourceAdapter;

public class ShaderBackend
{
	private final VkDevice vkDevice;
	private final PathResource shaderResource;

	private long shaderId;

	public ShaderBackend(VkDevice vkDevice, PathResource shaderResource)
	{
		this.vkDevice = vkDevice;
		this.shaderResource = shaderResource;
	}

	public void allocate(MemoryStack stack)
	{
		var fileAdapter = PathResourceAdapter.adapt(shaderResource);
		var shaderCode = fileAdapter.toByteBuffer(shaderResource);

		var moduleCreateInfo = VkShaderModuleCreateInfo.callocStack(stack);
		moduleCreateInfo.sType(VK_STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO);
		moduleCreateInfo.pNext(NULL);
		moduleCreateInfo.pCode(shaderCode);
		moduleCreateInfo.flags(0);

		long[] aShaderModule = new long[1];
		Logger.check("Failed to create shader",
				() -> vkCreateShaderModule(vkDevice, moduleCreateInfo, null, aShaderModule));
		shaderId = aShaderModule[0];
		MemoryUtil.memFree(shaderCode);
	}

	public void free()
	{
		vkDestroyShaderModule(vkDevice, shaderId, null);
		shaderId = -1;
	}

	public long getId()
	{
		return shaderId;
	}
}
