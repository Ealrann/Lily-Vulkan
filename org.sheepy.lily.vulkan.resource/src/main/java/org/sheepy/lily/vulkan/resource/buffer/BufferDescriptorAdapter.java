package org.sheepy.lily.vulkan.resource.buffer;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptorAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.VkBufferDescriptor;

@Statefull
@Adapter(scope = BufferDescriptor.class)
public class BufferDescriptorAdapter implements IDescriptorAdapter
{
	private final INotificationListener bufferRefListener = this::descriptionChange;
	private final BufferDescriptor descriptor;
	private final VkBufferDescriptor vkDescriptor;

	private BufferDescriptorAdapter(BufferDescriptor descriptor)
	{
		this.descriptor = descriptor;
		vkDescriptor = new VkBufferDescriptor(	0,
												0,
												0,
												descriptor.getType(),
												descriptor.getShaderStages());
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var reference = descriptor.getBufferReference();
		final var refAdapter = reference.adaptNotNull(IBufferReferenceAdapter.class);

		vkDescriptor.updateBufferPtr(refAdapter.getBufferPtr(reference));
		vkDescriptor.updateSize(refAdapter.getSize(reference));
		vkDescriptor.updateOffset(refAdapter.getOffset(reference));

		refAdapter.addListener(	bufferRefListener,
								IBufferReferenceAdapter.FEATURES.SIZE.ordinal(),
								IBufferReferenceAdapter.FEATURES.OFFSET.ordinal(),
								IBufferReferenceAdapter.FEATURES.BUFFER_PTR.ordinal());
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var reference = descriptor.getBufferReference();
		final var refAdapter = reference.adaptNotNull(IBufferReferenceAdapter.class);
		refAdapter.removeListener(	bufferRefListener,
									IBufferReferenceAdapter.FEATURES.SIZE.ordinal(),
									IBufferReferenceAdapter.FEATURES.OFFSET.ordinal(),
									IBufferReferenceAdapter.FEATURES.BUFFER_PTR.ordinal());
	}

	private void descriptionChange(Notification notification)
	{
		switch ((IBufferReferenceAdapter.FEATURES) notification.getFeature())
		{
		case BUFFER_PTR:
			vkDescriptor.updateBufferPtr(notification.getNewLongValue());
			break;
		case OFFSET:
			vkDescriptor.updateOffset(notification.getNewLongValue());
			break;
		case SIZE:
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
