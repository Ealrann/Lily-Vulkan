package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.game.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.function.LongConsumer;

@Statefull
@Adapter(scope = BufferDescriptor.class)
public final class BufferDescriptorAdapter implements IDescriptorAdapter, IAllocableAdapter<IExecutionContext>
{
	private final BufferDescriptor descriptor;
	private final VkBufferDescriptor vkDescriptor;

	private final LongConsumer ptrChange;
	private final LongConsumer sizeChange;
	private final LongConsumer offsetChange;

	private BufferDescriptorAdapter(BufferDescriptor descriptor)
	{
		this.descriptor = descriptor;
		vkDescriptor = new VkBufferDescriptor(0, 0, 0, descriptor.getType(), descriptor.getShaderStages());
		ptrChange = vkDescriptor::updateBufferPtr;
		sizeChange = vkDescriptor::updateSize;
		offsetChange = vkDescriptor::updateOffset;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var buffer = descriptor.getBuffer();
		final var bufferAdapter = buffer.adaptNotNull(IBufferAdapter.class);

		updateFromBuffer();

		bufferAdapter.listen(ptrChange, IBufferAdapter.Features.Ptr);
		bufferAdapter.listen(sizeChange, IBufferAdapter.Features.Size);
		bufferAdapter.listen(offsetChange, IBufferAdapter.Features.Offset);
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var buffer = descriptor.getBuffer();
		final var bufferAdapter = buffer.adaptNotNull(IBufferAdapter.class);

		bufferAdapter.sulk(ptrChange, IBufferAdapter.Features.Ptr);
		bufferAdapter.sulk(sizeChange, IBufferAdapter.Features.Size);
		bufferAdapter.sulk(offsetChange, IBufferAdapter.Features.Offset);
	}

	@NotifyChanged(featureIds = VulkanResourcePackage.BUFFER_DESCRIPTOR__BUFFER)
	private void notifyChanged()
	{
		updateFromBuffer();
	}

	private void updateFromBuffer()
	{
		final var buffer = descriptor.getBuffer();
		final var bufferAdapter = buffer.adaptNotNull(IBufferAdapter.class);

		vkDescriptor.updateBufferPtr(bufferAdapter.getPtr());
		vkDescriptor.updateSize(bufferAdapter.getBindSize());
		vkDescriptor.updateOffset(bufferAdapter.getBindOffset());
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}

//
//@Statefull
//@Allocable
//@Adapter(scope = BufferDescriptor.class)
//public final class BufferDescriptorAdapter implements IDescriptorAdapter
//{
//	private final BufferDescriptor descriptor;
//	private final VkBufferDescriptor vkDescriptor;
//
//	private final LongConsumer ptrChange;
//	private final LongConsumer sizeChange;
//	private final LongConsumer offsetChange;
//
//	private BufferDescriptorAdapter(BufferDescriptor descriptor,
//									@Depends(feature = VulkanResourcePackage.BUFFER_DESCRIPTOR__BUFFER) IBufferAdapter bufferAdapter)
//	{
//		this.descriptor = descriptor;
//		vkDescriptor = new VkBufferDescriptor(0, 0, 0, descriptor.getType(), descriptor.getShaderStages());
//		ptrChange = vkDescriptor::updateBufferPtr;
//		sizeChange = vkDescriptor::updateSize;
//		offsetChange = vkDescriptor::updateOffset;
//
//		updateFromBuffer(bufferAdapter);
//
//		bufferAdapter.listen(ptrChange, IBufferAdapter.Features.Ptr);
//		bufferAdapter.listen(sizeChange, IBufferAdapter.Features.Size);
//		bufferAdapter.listen(offsetChange, IBufferAdapter.Features.Offset);
//	}
//
//	@Free
//	public void free()
//	{
//		final var buffer = descriptor.getBuffer();
//		final var bufferAdapter = buffer.adaptNotNull(IBufferAdapter.class);
//
//		bufferAdapter.sulk(ptrChange, IBufferAdapter.Features.Ptr);
//		bufferAdapter.sulk(sizeChange, IBufferAdapter.Features.Size);
//		bufferAdapter.sulk(offsetChange, IBufferAdapter.Features.Offset);
//	}
//
//	@UpdateDependency(feature = VulkanResourcePackage.BUFFER_DESCRIPTOR__BUFFER)
//	private void update(IBufferAdapter bufferAdapter)
//	{
//		updateFromBuffer(bufferAdapter);
//	}
//
//	private void updateFromBuffer(IBufferAdapter bufferAdapter)
//	{
//		vkDescriptor.updateBufferPtr(bufferAdapter.getPtr());
//		vkDescriptor.updateSize(bufferAdapter.getBindSize());
//		vkDescriptor.updateOffset(bufferAdapter.getBindOffset());
//	}
//
//	@Override
//	public IVkDescriptor getVkDescriptor()
//	{
//		return vkDescriptor;
//	}
//}
