package org.sheepy.vulkan.resource.shader;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.resource.Shader;
import org.sheepy.vulkan.resource.ResourceAdapter;

public class ShaderAdapter extends ResourceAdapter
{
	private static ByteBuffer MAIN_FUNCTION_NAME = MemoryUtil.memUTF8("main");

	private ShaderBackend shaderBackend;

	@Override
	public void allocate(MemoryStack stack, ExecutionManager executionManager)
	{
		var vkDevice = executionManager.logicalDevice.getVkDevice();
		var shader = (Shader) target;
		var resource = shader.getFile();

		shaderBackend = new ShaderBackend(vkDevice, resource);
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
		shaderBackend = null;
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
		return IServiceAdapterFactory.INSTANCE.adapt(shader, ShaderAdapter.class);
	}
}
