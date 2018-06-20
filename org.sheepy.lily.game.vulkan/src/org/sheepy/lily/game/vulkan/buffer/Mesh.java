package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.game.vulkan.UniformBufferObject;
import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffer;
import org.sheepy.lily.game.vulkan.descriptor.IDescriptor;
import org.sheepy.lily.game.vulkan.shader.Shader;
import org.sheepy.lily.game.vulkan.texture.Texture;

public class Mesh
{
	private IndexBuffer buffer;
	private List<Shader> shaders = new ArrayList<>();
	private Texture texture = null;
	private UniformBufferObject uniformBufferObject = null;

	public Mesh(IndexBuffer buffer, List<Shader> shaders)
	{
		this.buffer = buffer;
		this.shaders = Collections.unmodifiableList(new ArrayList<>(shaders));
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
		if (uniformBufferObject != null) uniformBufferObject.free();
		if (texture != null) texture.free();

		buffer.free();
		for (Shader shader : shaders)
		{
			shader.destroy();
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

	public void attachTexture(Texture texture)
	{
		this.texture = texture;
	}

	public void attachUniformBuffer(UniformBufferObject uniformBufferObject)
	{
		this.uniformBufferObject = uniformBufferObject;
	}

	public List<IDescriptor> getDescriptors()
	{
		List<IDescriptor> res = new ArrayList<>();

		if (uniformBufferObject != null) res.add(uniformBufferObject);
		if (texture != null) res.add(texture);

		return res;
	}
}
