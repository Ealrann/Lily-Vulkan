package org.sheepy.vulkan.process.graphic;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_GRAPHICS;

import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.execution.graphic.RenderCommandBuffer;
import org.sheepy.vulkan.model.process.GraphicProcess;
import org.sheepy.vulkan.process.AbstractProcessAdapter;

public class GraphicProcessAdapter extends AbstractProcessAdapter<RenderCommandBuffer>
{
	@Override
	protected int getBindPoint()
	{
		return VK_PIPELINE_BIND_POINT_GRAPHICS;
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}

	public static GraphicProcessAdapter adapt(GraphicProcess object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, GraphicProcessAdapter.class);
	}
}
