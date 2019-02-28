package org.sheepy.lily.vulkan.resource.shader;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineShaderStageCreateInfo;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.lily.vulkan.resource.ResourceAdapter;

public class ShaderAdapter extends ResourceAdapter
{
	private static ByteBuffer MAIN_FUNCTION_NAME = MemoryUtil.memASCII("main");

	private ShaderBackend shaderBackend;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var vkDevice = ((ExecutionContext) context).getVkDevice();
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
	public void free(IAllocationContext context)
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
