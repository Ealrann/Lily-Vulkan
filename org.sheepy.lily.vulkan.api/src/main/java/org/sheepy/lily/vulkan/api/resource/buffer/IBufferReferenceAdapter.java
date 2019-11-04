package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;

public interface IBufferReferenceAdapter<T extends IBufferReference> extends IVulkanAdapter
{
	long getBufferPtr(T ref);
	long getOffset(T ref);
	long getSize(T ref);
	void flush(T ref);

	static final class Helper
	{
		public static <T extends IBufferReference> long getBufferPtr(T ref)
		{
			final var adapter = ref.<IBufferReferenceAdapter<T>> adaptNotNullGeneric(IBufferReferenceAdapter.class);
			return adapter.getBufferPtr(ref);
		}

		public static <T extends IBufferReference> long getOffset(T ref)
		{
			final var adapter = ref.<IBufferReferenceAdapter<T>> adaptNotNullGeneric(IBufferReferenceAdapter.class);
			return adapter.getOffset(ref);
		}

		public static <T extends IBufferReference> long getSize(T ref)
		{
			final var adapter = ref.<IBufferReferenceAdapter<T>> adaptNotNullGeneric(IBufferReferenceAdapter.class);
			return adapter.getSize(ref);
		}

		public static <T extends IBufferReference> void flush(T ref)
		{
			final var adapter = ref.<IBufferReferenceAdapter<T>> adaptNotNullGeneric(IBufferReferenceAdapter.class);
			adapter.flush(ref);
		}
	}
}
