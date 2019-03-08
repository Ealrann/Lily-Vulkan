package org.sheepy.lily.vulkan.nuklear.pipeline;

import java.nio.ByteBuffer;

import org.joml.Vector2i;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.nuklear.model.NuklearConstants;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;

@Statefull
@Adapter(scope = NuklearConstants.class)
public class NuklearConstantsAdapter extends AbstractConstantsAdapter implements IAllocableAdapter
{
	private final int SIZE = 16 * 4;
	private ByteBuffer buffer;
	private GraphicContext graphicContext;
	private boolean needRecord = true;

	private final IWindowListener windowListener = new IWindowListener()
	{
		@Override
		public void onResize(Vector2i size)
		{
			needRecord = true;
		}
	};

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		graphicContext = (GraphicContext) context;
		buffer = MemoryUtil.memAlloc(SIZE);
		graphicContext.getWindow().addListener(windowListener);
	}

	@Override
	public void free(IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		MemoryUtil.memFree(buffer);
		graphicContext.getWindow().removeListener(windowListener);
	}

	@Override
	public boolean needRecord()
	{
		return needRecord;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	@Override
	protected int getSize()
	{
		return SIZE;
	}

	@Override
	public ByteBuffer getData()
	{
		Vector2i size = graphicContext.getWindow().getSize();
		int width = size.x;
		int height = size.y;

		buffer.putFloat(2.0f / width);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(-2.0f / height);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(-1.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(-1.0f);
		buffer.putFloat(1.0f);
		buffer.putFloat(0.0f);
		buffer.putFloat(1.0f);

		buffer.flip();

		needRecord = false;
		return buffer;
	}
}
