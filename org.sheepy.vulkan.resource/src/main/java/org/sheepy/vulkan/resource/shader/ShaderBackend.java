package org.sheepy.vulkan.resource.shader;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkShaderModuleCreateInfo;
import org.sheepy.vulkan.common.util.Logger;

public class ShaderBackend
{
	private final VkDevice vkDevice;
	private final ByteBuffer shaderCode;

	private long shaderId;

	public ShaderBackend(VkDevice vkDevice, ByteBuffer shaderCode)
	{
		this.vkDevice = vkDevice;
		this.shaderCode = shaderCode;
	}

	public void allocate(MemoryStack stack)
	{
		var moduleCreateInfo = VkShaderModuleCreateInfo.callocStack(stack);
		moduleCreateInfo.sType(VK_STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO);
		moduleCreateInfo.pNext(NULL);
		moduleCreateInfo.pCode(shaderCode);
		moduleCreateInfo.flags(0);

		long[] aShaderModule = new long[1];
		Logger.check("Failed to create shader",
				() -> vkCreateShaderModule(vkDevice, moduleCreateInfo, null, aShaderModule));
		shaderId = aShaderModule[0];
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
