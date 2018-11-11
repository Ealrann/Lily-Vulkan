package org.sheepy.vulkan.resource.shader;

import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.lwjgl.vulkan.VkShaderModuleCreateInfo;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.common.util.Logger;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.resource.Shader;
import org.sheepy.vulkan.resource.ResourceAdapter;
import org.sheepy.vulkan.resource.file.PathResourceAdapter;

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
				() -> vkCreateShaderModule(context.getVkDevice(target), moduleCreateInfo, null,
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
		vkDestroyShaderModule(context.getVkDevice(target), shaderModule, null);
	}

	public long getShaderModule()
	{
		return shaderModule;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.SHADER == eClass;
	}

	public static ShaderAdapter adapt(Shader shader)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(shader, ShaderAdapter.class);
	}
}
