package org.sheepy.vulkan.resource.shader;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.lwjgl.vulkan.VkShaderModuleCreateInfo;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.model.resource.Shader;
import org.sheepy.vulkan.resource.ResourceAdapter;
import org.sheepy.vulkan.resource.file.PathResourceAdapter;
import org.sheepy.vulkan.util.Logger;

public class ShaderAdapter extends ResourceAdapter
{
	private static ByteBuffer MAIN_FUNCTION_NAME = MemoryUtil.memUTF8("main");

	private long shaderModule;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		var context = ILogicalDeviceAdapter.adapt(target);
		var shader = (Shader) target;
		var resource = shader.getFile();
		var fileAdapter = PathResourceAdapter.adapt(resource);
		var shaderCode = fileAdapter.toByteBuffer();
		
		var moduleCreateInfo = VkShaderModuleCreateInfo.callocStack(stack);
		moduleCreateInfo.sType(VK_STRUCTURE_TYPE_SHADER_MODULE_CREATE_INFO);
		moduleCreateInfo.pNext(NULL);
		moduleCreateInfo.pCode(shaderCode);
		moduleCreateInfo.flags(0);

		long[] aShaderModule = new long[1];
		Logger.check("Failed to create shader module: " + resource.getPath(),
				() -> vkCreateShaderModule(context.getVkDevice(), moduleCreateInfo, null,
						aShaderModule));
		shaderModule = aShaderModule[0];
	}

	/**
	 * You will be responsible to free this object.
	 * 
	 * @return
	 */
	public void fillInfo(VkPipelineShaderStageCreateInfo info)
	{
		Shader shader = (Shader) target;

		info.sType(VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO);
		info.stage(shader.getStage().getValue());
		info.module(shaderModule);
		info.pName(MAIN_FUNCTION_NAME);
	}

	@Override
	public void free()
	{
		var context = ILogicalDeviceAdapter.adapt(target);
		vkDestroyShaderModule(context.getVkDevice(), shaderModule, null);
	}

	public long getShaderModule()
	{
		return shaderModule;
	}

	public static ShaderAdapter adapt(Shader shader)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(shader, ShaderAdapter.class);
	}
}
