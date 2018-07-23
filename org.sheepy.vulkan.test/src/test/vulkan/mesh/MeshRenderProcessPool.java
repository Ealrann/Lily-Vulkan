package test.vulkan.mesh;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.SurfaceProcessPool;
import org.sheepy.vulkan.pipeline.graphic.GraphicConfiguration;
import org.sheepy.vulkan.pipeline.graphic.GraphicProcessPool;
import org.sheepy.vulkan.window.Surface;

public class MeshRenderProcessPool extends SurfaceProcessPool
{
	private GraphicProcessPool swapProcessPool;

	public MeshRenderProcessPool(LogicalDevice logicalDevice)
	{
		super(logicalDevice, logicalDevice.getQueueManager().getGraphicQueueIndex());
	}

	@Override
	public void execute()
	{
		swapProcessPool.exectue();
	}

	@Override
	public void configure(Surface surface)
	{
		swapProcessPool.configure(surface);
	}

	@Override
	public void resize(MemoryStack stack, Surface surface)
	{
		swapProcessPool.freeNode();
		configure(surface);
		swapProcessPool.allocateNode(stack);
	}

	public void setProcessPool(GraphicProcessPool swapProcessPool, GraphicConfiguration configuration)
	{
		this.swapProcessPool = swapProcessPool;
		subAllocationObjects.add(configuration);
		subAllocationObjects.add(swapProcessPool);
	}

	public void attachMesh(Mesh mesh)
	{
		subAllocationObjects.add(mesh);		
	}
}
