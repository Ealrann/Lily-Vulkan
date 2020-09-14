package org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferFetchAdapter;
import org.sheepy.lily.vulkan.demo.test.composite.grow.model.TestResourceFactory;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;

import java.nio.ByteBuffer;

@ModelExtender(scope = BufferViewer.class, name = TestResourceFactory.BUFFER_NAME)
@Adapter
public final class TestFetchAdapter implements IBufferFetchAdapter
{
	private final TestDataProviderAdapter dataProviderAdapter;

	private TestFetchAdapter(final BufferViewer bufferViewer)
	{
		this.dataProviderAdapter = bufferViewer.getDataProvider().adapt(TestDataProviderAdapter.class);
	}

	@Override
	public void fetch(final ByteBuffer buffer)
	{
		dataProviderAdapter.fetch(buffer);
	}
}
