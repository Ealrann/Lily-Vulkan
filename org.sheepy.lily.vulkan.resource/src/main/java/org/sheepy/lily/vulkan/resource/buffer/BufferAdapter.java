package org.sheepy.lily.vulkan.resource.buffer;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.descriptor.VkBufferDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.BufferInfo;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;
import org.sheepy.vulkan.resource.buffer.IBufferBackend;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = Buffer.class)
public final class BufferAdapter implements IBufferAdapter
{
	protected Buffer buffer;
	protected IBufferBackend bufferBackend;

	private List<IVkDescriptor> descriptors = null;
	private IExecutionContext executionManager;
	private VkBufferDescriptor vkDescriptor;

	public BufferAdapter(Buffer buffer)
	{
		this.buffer = buffer;
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		executionManager = context;
		final var info = createInfo(buffer);

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

	@Override
	public void pushData(ByteBuffer data)
	{
		bufferBackend.nextInstance();
		bufferBackend.pushData(executionManager, data);

		if (vkDescriptor != null)
		{
			vkDescriptor.updateOffset(bufferBackend.getOffset());
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		bufferBackend.free(context);
		bufferBackend = null;
	}

	@Override
	public long getPtr()
	{
		return bufferBackend.getAddress();
	}

	@Override
	public long getMemoryPtr()
	{
		return bufferBackend.getMemoryAddress();
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		if (descriptors == null)
		{
			final var descriptor = buffer.getDescriptor();
			final long bufferPtr = bufferBackend.getAddress();
			final long size = buffer.getSize();
			final var type = descriptor.getDescriptorType();
			final var shaderStages = descriptor.getShaderStages();
			final var offset = bufferBackend.getOffset();

			vkDescriptor = new VkBufferDescriptor(bufferPtr, size, offset, type, shaderStages);
			descriptors = List.of(vkDescriptor);
		}

		return descriptors;
	}

	private static BufferInfo createInfo(Buffer buffer)
	{
		final var size = buffer.getSize();
		final int usage = VkModelUtil.getEnumeratedFlag(buffer.getUsages());
		final var keptMapped = buffer.isOftenUpdated();
		final int instanceCount = buffer.getInstanceCount();

		return new BufferInfo(size, usage, keptMapped, instanceCount);
	}
}
