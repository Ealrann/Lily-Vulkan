package org.sheepy.lily.vulkan.resource.buffer;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.game.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;
import org.sheepy.lily.vulkan.core.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@Statefull
@Adapter(scope = BufferDescriptor.class)
public class BufferDescriptorAdapter implements IDescriptorAdapter
{
	private final INotificationListener bufferListener = this::bindChange;
	private final BufferDescriptor descriptor;
	private final VkBufferDescriptor vkDescriptor;

	private BufferDescriptorAdapter(BufferDescriptor descriptor)
	{
		this.descriptor = descriptor;
		vkDescriptor = new VkBufferDescriptor(0, 0, 0, descriptor.getType(), descriptor.getShaderStages());
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var buffer = descriptor.getBuffer();
		final var bufferAdapter = buffer.adaptNotNull(IBufferAdapter.class);

		updateFromBuffer();

		bufferAdapter.addListener(bufferListener,
								  IBufferAdapter.Features.Size.ordinal(),
								  IBufferAdapter.Features.Offset.ordinal(),
								  IBufferAdapter.Features.Ptr.ordinal());
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var buffer = descriptor.getBuffer();
		final var bufferAdapter = buffer.adaptNotNull(IBufferAdapter.class);

		bufferAdapter.removeListener(bufferListener,
									 IBufferAdapter.Features.Size.ordinal(),
									 IBufferAdapter.Features.Offset.ordinal(),
									 IBufferAdapter.Features.Ptr.ordinal());
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

	private void bindChange(Notification notification)
	{
		switch ((IBufferAdapter.Features) notification.getFeature())
		{
			case Ptr:
				vkDescriptor.updateBufferPtr(notification.getNewLongValue());
				break;
			case Offset:
				vkDescriptor.updateOffset(notification.getNewLongValue());
				break;
			case Size:
				vkDescriptor.updateSize(notification.getNewLongValue());
				break;
			default:
				break;
		}
	}

	@Override
	public IVkDescriptor getVkDescriptor()
	{
		return vkDescriptor;
	}
}
