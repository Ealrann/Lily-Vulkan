package org.sheepy.lily.game.vulkan.pipeline.compute;

import static org.lwjgl.vulkan.VK10.VK_SHADER_STAGE_COMPUTE_BIT;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.game.vulkan.descriptor.IDescriptor;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.shader.Shader;

public class Computer implements IComputer
{
	private LogicalDevice logicalDevice;
	private String shaderLocation;
	private int width;
	private int height;
	private List<IDescriptor> descriptors;

	private Shader shader;

	public Computer(LogicalDevice logicalDevice, String shaderLocation, int width, int height,
			List<IDescriptor> descriptors)
	{
		this.logicalDevice = logicalDevice;
		this.shaderLocation = shaderLocation;
		this.width = width;
		this.height = height;
		this.descriptors = new ArrayList<>(descriptors);
	}

	@Override
	public void load()
	{
		shader = new Shader(logicalDevice, shaderLocation, VK_SHADER_STAGE_COMPUTE_BIT);
	}

	@Override
	public void free()
	{
		shader.destroy();
	}

	@Override
	public Shader getShader()
	{
		return shader;
	}

	@Override
	public int getDataWidth()
	{
		return width;
	}

	@Override
	public int getDataHeight()
	{
		return height;
	}

	@Override
	public int getDataDepth()
	{
		return 1;
	}

	@Override
	public List<IDescriptor> getDescriptors()
	{
		return descriptors;
	}
}
