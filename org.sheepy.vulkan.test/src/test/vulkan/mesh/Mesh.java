package test.vulkan.mesh;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.buffer.IndexBuffer;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.shader.Shader;
import org.sheepy.vulkan.texture.Texture;

public class Mesh implements IAllocable
{
	private IndexBuffer<?> buffer;
	protected List<Shader> shaders = new ArrayList<>();
	protected UniformBufferObject ubo;
	protected Texture texture;
	public final List<IDescriptor> descriptors;

	public Mesh(LogicalDevice logicalDevice, IndexBuffer<?> buffer, List<Shader> shaders,
			UniformBufferObject ubo, Texture texture)
	{
		this.buffer = buffer;
		this.shaders = Collections.unmodifiableList(new ArrayList<>(shaders));

		this.ubo = ubo;
		this.texture = texture;

		descriptors = new ArrayList<>();
		if (ubo != null) descriptors.add(ubo);
		if (texture != null) descriptors.add(texture);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		if (ubo != null) ubo.allocate(stack);
		if (texture != null) texture.allocate(stack);

		for (Shader shader : shaders)
		{
			shader.allocate(stack);
		}
	}

	public void bindBufferForRender(VkCommandBuffer commandBuffer)
	{
		long[] indexBuffers = new long[] {
				buffer.getVertexBufferId()
		};
		long[] offsets = {
				0
		};

		vkCmdBindVertexBuffers(commandBuffer, 0, indexBuffers, offsets);
		vkCmdBindIndexBuffer(commandBuffer, buffer.getIndexBufferId(), 0,
				VK_INDEX_TYPE_UINT32);
	}

	public void draw(VkCommandBuffer commandBuffer)
	{
		vkCmdDrawIndexed(commandBuffer, buffer.indexCount(), 1, 0, 0, 0);
	}

	@Override
	public void free()
	{
		if (ubo != null) ubo.free();
		if (texture != null) texture.free();

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

	public IndexBuffer<?> getIndexBuffer()
	{
		return buffer;
	}

	public List<IDescriptor> getDescriptors()
	{
		return descriptors;
	}
}
