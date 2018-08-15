package org.sheepy.vulkan.resource;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;
import static org.lwjgl.vulkan.VK10.vkCreateShaderModule;
import static org.lwjgl.vulkan.VK10.vkDestroyShaderModule;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.lwjgl.vulkan.VkShaderModuleCreateInfo;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.IPipelineUnit;
import org.sheepy.vulkan.util.ModuleResource;
import org.sheepy.vulkan.util.VulkanUtils;

public class Shader implements IPipelineUnit, IResource
{
	private static final ByteBuffer MAIN_FUNCTION_NAME = MemoryUtil.memUTF8("main");

	private VkDevice logicalDevice;
	private ModuleResource shaderResource;
	private int shaderType;

	private long shaderModule;

	public Shader(LogicalDevice logicalDevice, ModuleResource shaderResource, int shaderType)
	{
		this.logicalDevice = logicalDevice.getVkDevice();
		this.shaderResource = shaderResource;
		this.shaderType = shaderType;
	}

	@Override
	public void allocate(MemoryStack stack, CommandPool commandPool)
	{
		ByteBuffer shaderCode = shaderResource.ioResourceToByteBuffer();
		VkShaderModuleCreateInfo moduleCreateInfo = VkShaderModuleCreateInfo.callocStack(stack);
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

	@Override
	public void free()
	{
		vkDestroyShaderModule(logicalDevice, shaderModule, null);
	}

	public long getShaderModule()
	{
		return shaderModule;
	}
}
