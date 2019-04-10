package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.nativehelper.resource.IBufferBackend;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;

@Statefull
@Adapter(scope = Buffer.class)
public class BufferAdapter implements IDescriptorAdapter, IResourceAdapter
{
	protected Buffer buffer;
	protected IBufferBackend bufferBackend;
	private boolean hasChanged = true;

	private IExecutionContext executionManager;

	public BufferAdapter(Buffer buffer)
	{
		this.buffer = buffer;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		executionManager = (IExecutionContext) context;
		final var info = new BufferInfo(buffer);

		if (buffer.isGpuBuffer())
		{
			bufferBackend = new GPUBufferBackend(info, buffer.isOftenUpdated());
		}
		else
		{
			bufferBackend = new CPUBufferBackend(info, true);
		}

		bufferBackend.allocate(stack, context);

		final ByteBuffer data = buffer.getData();
		if (data != null)
		{
			bufferBackend.pushData(executionManager, data);
		}
	}

	public void pushData(ByteBuffer data)
	{
		bufferBackend.nextInstance();
		bufferBackend.pushData(executionManager, data);

		if (buffer.getInstanceCount() > 1)
		{
			hasChanged = true;
		}
	}

	@Override
	public void free(IAllocationContext context)
	{
		bufferBackend.free(context);
		bufferBackend = null;
	}

	public long getAddress()
	{
		return bufferBackend.getAddress();
	}

	public long getMemoryAddress()
	{
		return bufferBackend.getMemoryAddress();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final int stageFlags = VulkanModelUtil.getEnumeratedFlag(buffer.getShaderStages());
		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(buffer.getDescriptorType().getValue());
		res.descriptorCount(getDescriptorCount());
		res.stageFlags(stageFlags);
		return res;
	}

	protected static int getDescriptorCount()
	{
		return 1;
	}

	@Override
	public void fillWriteDescriptor(MemoryStack stack, VkWriteDescriptorSet writeDescriptor)
	{
		final var bufferInfo = allocBufferInfo(stack);

		writeDescriptor.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		writeDescriptor.dstArrayElement(0);
		writeDescriptor.descriptorType(buffer.getDescriptorType().getValue());
		writeDescriptor.pBufferInfo(bufferInfo);
		writeDescriptor.pImageInfo(null);
		writeDescriptor.pTexelBufferView(null);
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final VkDescriptorBufferInfo.Buffer bufferInfo = VkDescriptorBufferInfo.callocStack(1,
				stack);
		bufferInfo.buffer(getAddress());
		bufferInfo.offset(bufferBackend.getOffset());
		bufferInfo.range(buffer.getSize());

		return bufferInfo;
	}

	@Override
	public void fillPoolSize(VkDescriptorPoolSize poolSize)
	{
		poolSize.type(buffer.getDescriptorType().getValue());
		poolSize.descriptorCount(getDescriptorCount());
	}

	@Override
	public void update()
	{
		hasChanged = false;
	}

	@Override
	public boolean hasChanged()
	{
		return hasChanged;
	}

	public static BufferAdapter adapt(Buffer buffer)
	{
		return IAdapterFactoryService.INSTANCE.adapt(buffer, BufferAdapter.class);
	}
}
