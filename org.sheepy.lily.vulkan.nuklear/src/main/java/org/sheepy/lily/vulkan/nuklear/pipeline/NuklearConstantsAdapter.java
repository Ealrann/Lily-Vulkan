package org.sheepy.lily.vulkan.nuklear.pipeline;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.nuklear.model.NuklearPackage;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;
import org.sheepy.lily.vulkan.resource.buffer.AbstractConstantsAdapter;

public class NuklearConstantsAdapter extends AbstractConstantsAdapter implements IAllocableAdapter
{
	private final int SIZE = 16 * 4;
	private ByteBuffer buffer;
	private LogicalDevice logicalDevice;
	private boolean needRecord = true;

	private final IWindowListener windowListener = new IWindowListener()
	{
		@Override
		public void onWindowResize(VkSurface surface)
		{
			needRecord = true;
		}
	};

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var graphicContext = (GraphicContext) context;
		logicalDevice = graphicContext.getLogicalDevice();
		buffer = MemoryUtil.memAlloc(SIZE);
		logicalDevice.window.addListener(windowListener);
	}

	@Override
	public void free(IAllocationContext context)
	{
		MemoryUtil.memFree(buffer);
		logicalDevice.window.removeListener(windowListener);
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
	public boolean isApplicable(EClass eClass)
	{
		return NuklearPackage.Literals.NUKLEAR_CONSTANTS == eClass;
	}

	@Override
	public ByteBuffer getData()
	{
		VkSurface surface = logicalDevice.window.getSurface();
		int width = surface.width;
		int height = surface.height;

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
