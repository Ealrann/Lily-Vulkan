package org.sheepy.lily.game.vulkan.shader;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.*;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.lwjgl.vulkan.VkShaderModuleCreateInfo;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.util.VulkanBufferUtils;
import org.sheepy.lily.game.vulkan.util.VulkanUtils;

public class Shader
{
	private static final ByteBuffer MAIN_FUNCTION_NAME = MemoryUtil.memUTF8("main");

	private VkDevice logicalDevice;
	private String shaderPath;
	private int shaderType;

	private long shaderModule;

	public Shader(LogicalDevice logicalDevice, String shaderPath, int shaderType)
	{
		this.logicalDevice = logicalDevice.getVkDevice();
		this.shaderPath = shaderPath;
		this.shaderType = shaderType;

		try
		{
			load();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void load() throws IOException
	{
		ByteBuffer shaderCode = VulkanBufferUtils.ioResourceToByteBuffer(shaderPath, 1024);
		VkShaderModuleCreateInfo moduleCreateInfo = VkShaderModuleCreateInfo.calloc();
		moduleCreateInfo.sType(VK_STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO);
		moduleCreateInfo.pNext(NULL);
		moduleCreateInfo.pCode(shaderCode);
		moduleCreateInfo.flags(0);

		long[] aShaderModule = new long[1];
		int err = vkCreateShaderModule(logicalDevice, moduleCreateInfo, null, aShaderModule);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError(
					"Failed to create shader module: " + VulkanUtils.translateVulkanResult(err));
		}
		shaderModule = aShaderModule[0];

		moduleCreateInfo.free();
	}

	/**
	 * You will be responsible to free this object.
	 * 
	 * @return
	 */
	public VkPipelineShaderStageCreateInfo allocInfo()
	{
		VkPipelineShaderStageCreateInfo res = VkPipelineShaderStageCreateInfo.calloc();

		res.sType(VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO);
		res.stage(shaderType);
		res.module(shaderModule);
		res.pName(MAIN_FUNCTION_NAME);

		return res;
	}

	public void destroy()
	{
		vkDestroyShaderModule(logicalDevice, shaderModule, null);
	}

	public long getShaderModule()
	{
		return shaderModule;
	}
}
