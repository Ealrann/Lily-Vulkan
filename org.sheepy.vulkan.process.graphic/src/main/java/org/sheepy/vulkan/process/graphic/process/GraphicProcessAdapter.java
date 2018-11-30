package org.sheepy.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_GRAPHICS;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.process.graphic.execution.RenderCommandBuffer;
import org.sheepy.vulkan.process.process.AbstractProcessAdapter;

public class GraphicProcessAdapter extends AbstractProcessAdapter<RenderCommandBuffer>
{
	@Override
	protected int getBindPoint()
	{
		return VK_PIPELINE_BIND_POINT_GRAPHICS;
	}
	
	@Override
	public boolean isApplicable(EClass eClass)
	{
		return GraphicPackage.Literals.GRAPHIC_PROCESS == eClass;
	}
	
	public static GraphicProcessAdapter adapt(GraphicProcess object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, GraphicProcessAdapter.class);
	}
}
