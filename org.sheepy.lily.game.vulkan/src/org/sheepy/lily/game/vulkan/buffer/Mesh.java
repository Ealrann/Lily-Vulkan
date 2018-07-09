package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffer;
import org.sheepy.lily.game.vulkan.descriptor.IDescriptor;
import org.sheepy.lily.game.vulkan.shader.Shader;

public class Mesh
{
	private IndexBuffer buffer;
	private List<Shader> shaders = new ArrayList<>();
	private List<IDescriptor> descriptors = new ArrayList<>();

	public Mesh(IndexBuffer buffer, List<Shader> shaders, List<IDescriptor> descriptors)
	{
		this.buffer = buffer;
		this.shaders = Collections.unmodifiableList(new ArrayList<>(shaders));
		this.descriptors = Collections.unmodifiableList(new ArrayList<>(descriptors));
	}

	public void bindBufferForRender(AbstractCommandBuffer commandBuffer)
	{
		long[] indexBuffers = new long[] {
				buffer.getBufferId()
		};
		long[] offsets = {
				0
		};

		vkCmdBindVertexBuffers(commandBuffer.getVkCommandBuffer(), 0, indexBuffers, offsets);
		vkCmdBindIndexBuffer(commandBuffer.getVkCommandBuffer(), buffer.getIndexBufferId(), 0,
				VK_INDEX_TYPE_UINT32);
	}

	public void draw(AbstractCommandBuffer commandBuffer)
	{
		vkCmdDrawIndexed(commandBuffer.getVkCommandBuffer(), buffer.indexCount(), 1, 0, 0, 0);
	}

	public void free()
	{
		for (IDescriptor descriptor : descriptors)
		{
			descriptor.free();
		}

		buffer.free();
		for (Shader shader : shaders)
		{
			shader.free();
		}
	}

	public List<Shader> getShaders()
	{
		return shaders;
	}

	public IndexBuffer getIndexBuffer()
	{
		return buffer;
	}

	public List<IDescriptor> getDescriptors()
	{
		return descriptors;
	}

	public void allocate(MemoryStack stack)
	{
		for (Shader shader : shaders)
		{
			shader.allocate(stack);
		}
	}
}
