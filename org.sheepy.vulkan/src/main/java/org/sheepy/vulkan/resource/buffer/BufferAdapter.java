package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.device.ILogicalDeviceAdapter;
import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.resource.ResourceAdapter;
import org.sheepy.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.vulkan.util.Logger;

public class BufferAdapter extends ResourceAdapter implements IDescriptorAdapter
{
	protected int stage = -1;
	protected int descriptorType = -1;

	private StandaloneBuffer backendBuffer;

	private boolean allocated = false;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final var logicalDevice = ILogicalDeviceAdapter.adapt(target).getLogicalDevice();
		backendBuffer = new StandaloneBuffer(logicalDevice, (Buffer) target);
		backendBuffer.allocate(stack);
		allocated = true;
	}

	@Override
	public void free()
	{
		backendBuffer.free();
		backendBuffer = null;
		allocated = false;
	}

	public boolean isAllocated()
	{
		return allocated;
	}

	public long getId()
	{
		return backendBuffer.getId();
	}

	public long getMemoryId()
	{
		return backendBuffer.getMemoryId();
	}

	public void fillWithBuffer(ByteBuffer byteBuffer)
	{
		backendBuffer.fillWithBuffer(byteBuffer);
	}

	public void configureDescriptor(int stage, int descriptorType)
	{
		this.stage = stage;
		this.descriptorType = descriptorType;
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		if (descriptorType == -1)
			Logger.log("Unconfigured descriptor, call configureDescriptor() first.");

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(descriptorType);
		res.descriptorCount(getDescriptorCount());
		res.stageFlags(stage);
		return res;
	}

	protected static int getDescriptorCount()
	{
		return 1;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		if (descriptorType == -1)
			new Exception("Unconfigured descriptor, call configureDescriptor() first.")
					.printStackTrace();

		final VkDescriptorBufferInfo.Buffer bufferInfo = allocBufferInfo(stack);

		final VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(descriptorType);
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final var buffer = (Buffer) target;
		final VkDescriptorBufferInfo.Buffer bufferInfo = VkDescriptorBufferInfo.callocStack(1,
				stack);
		bufferInfo.buffer(getId());
		bufferInfo.offset(0);
		bufferInfo.range(buffer.getSize());

		return bufferInfo;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		if (descriptorType == -1)
			Logger.log("Unconfigured descriptor, call configureDescriptor() first.");

		final VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(descriptorType);
		poolSize.descriptorCount(getDescriptorCount());
		return poolSize;
	}

	public static BufferAdapter adapt(Buffer buffer)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(buffer, BufferAdapter.class);
	}

}
