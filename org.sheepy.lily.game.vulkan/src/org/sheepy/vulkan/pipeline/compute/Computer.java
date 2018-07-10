package org.sheepy.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.VK_SHADER_STAGE_COMPUTE_BIT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.shader.Shader;

public class Computer extends AllocationNode
{
	public static final float DEFAULT_WORKGROUP_SIZE = 32f;
	
	protected int width;
	protected int height;
	protected List<IDescriptor> descriptors;
	protected float workgroupSize = DEFAULT_WORKGROUP_SIZE;

	protected Shader shader;

	public Computer(LogicalDevice logicalDevice, String shaderLocation, int width, int height,
			List<IDescriptor> descriptors)
	{
		this.width = width;
		this.height = height;
		this.descriptors = new ArrayList<>(descriptors);

		shader = new Shader(logicalDevice, shaderLocation, VK_SHADER_STAGE_COMPUTE_BIT);
	}

	public Shader getShader()
	{
		return shader;
	}

	public int getDataWidth()
	{
		return width;
	}

	public int getDataHeight()
	{
		return height;
	}

	public int getDataDepth()
	{
		return 1;
	}

	public List<IDescriptor> getDescriptors()
	{
		return descriptors;
	}

	@Override
	protected Collection<? extends IAllocationObject> getSubAllocables()
	{
		return Collections.singletonList(shader);
	}

	public float getWorkgroupSize()
	{
		return workgroupSize;
	}
	
	public void setWorkgroupSize(float workgroupSize)
	{
		this.workgroupSize = workgroupSize;
	}
}
