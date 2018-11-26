package org.sheepy.vulkan.resource.shader;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.resource.Shader;
import org.sheepy.vulkan.resource.ResourceAdapter;
import org.sheepy.vulkan.resource.file.PathResourceAdapter;

public class ShaderAdapter extends ResourceAdapter
{
	private static ByteBuffer MAIN_FUNCTION_NAME = MemoryUtil.memUTF8("main");

	private ShaderBackend shaderBackend;
	
	@Override
	public void flatAllocate(MemoryStack stack)
	{
		var context = ILogicalDeviceAdapter.adapt(target);
		var shader = (Shader) target;
		var resource = shader.getFile();
		var fileAdapter = PathResourceAdapter.adapt(resource);
		var shaderCode = fileAdapter.toByteBuffer();

		shaderBackend = new ShaderBackend(context.getVkDevice(target), shaderCode);
		shaderBackend.allocate(stack);
		
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
		info.module(getShaderModule());
		info.pName(MAIN_FUNCTION_NAME);
	}

	@Override
	public void free()
	{
		shaderBackend.free();
	}

	public long getShaderModule()
	{
		return shaderBackend.getId();
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
