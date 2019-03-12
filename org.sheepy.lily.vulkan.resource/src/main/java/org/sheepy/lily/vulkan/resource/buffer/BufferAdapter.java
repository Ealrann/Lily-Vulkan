package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;

@Statefull
@Adapter(scope = Buffer.class)
public class BufferAdapter implements IDescriptorAdapter, IResourceAdapter
{
	protected Buffer buffer;
	protected IBufferBackend bufferBackend;

	private ExecutionContext executionManager;

	public BufferAdapter(Buffer buffer)
	{
		this.buffer = buffer;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		executionManager = (ExecutionContext) context;
		var info = new BufferInfo(buffer);

		if (buffer.isGpuBuffer())
		{
			bufferBackend = new GPUBufferBackend(info, buffer.isOftenUpdated());
		}
		else
		{
			bufferBackend = new CPUBufferBackend(info, true);
		}

		bufferBackend.allocate(stack, context);

		ByteBuffer data = buffer.getData();
		if (data != null)
		{
			bufferBackend.pushData(executionManager, data);
		}
	}

	public void pushData(ByteBuffer data)
	{
		bufferBackend.pushData(executionManager, data);
	}

	@Override
	public void free(IAllocationContext context)
	{
		bufferBackend.free(context);
		bufferBackend = null;
	}

	public long getId()
	{
		return bufferBackend.getId();
	}

	public long getMemoryId()
	{
		return bufferBackend.getMemoryId();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		int stages = 0;
		for (EShaderStage stage : buffer.getShaderStages())
		{
			stages |= stage.getValue();
		}

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(buffer.getDescriptorType().getValue());
		res.descriptorCount(getDescriptorCount());
		res.stageFlags(stages);
		return res;
	}

	protected static int getDescriptorCount()
	{
		return 1;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		final VkDescriptorBufferInfo.Buffer bufferInfo = allocBufferInfo(stack);

		final VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(buffer.getDescriptorType().getValue());
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
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
		final VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(buffer.getDescriptorType().getValue());
		poolSize.descriptorCount(getDescriptorCount());
		return poolSize;
	}

	public static BufferAdapter adapt(Buffer buffer)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(buffer, BufferAdapter.class);
	}
}
