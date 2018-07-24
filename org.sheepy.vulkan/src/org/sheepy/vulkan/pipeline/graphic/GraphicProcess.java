package org.sheepy.vulkan.pipeline.graphic;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.IExecutable;
import org.sheepy.vulkan.pipeline.IProcessUnit;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicsPipeline;

/**
 * A set of GraphicPipelines.
 * 
 * @author ealrann
 *
 */
public class GraphicProcess extends AllocationNode
{
	public final LogicalDevice logicalDevice;
	protected GraphicContext context;

	public DescriptorPool descriptorPool;

	protected final List<IProcessUnit> processUnits = new ArrayList<>();

	/**
	 * @param logicalDevice
	 * @param configuration
	 * @param commandPool
	 * @param colorDomain
	 * @param bindType
	 *            VK_PIPELINE_BIND_POINT_COMPUTE or
	 *            VK_PIPELINE_BIND_POINT_GRAPHICS
	 */
	public GraphicProcess(GraphicConfiguration configuration)
	{
		this.logicalDevice = configuration.logicalDevice;

		descriptorPool = new DescriptorPool(logicalDevice);
		allocationObjects.add(descriptorPool);
	}

	public void addGraphicPipeline(GraphicsPipeline pipeline)
	{
		addProcessUnit(pipeline);
	}

	public void addProcessUnit(IProcessUnit processUnit)
	{
		processUnits.add(processUnit);

		if (processUnit instanceof IAllocationObject)
		{
			allocationObjects.add((IAllocationObject) processUnit);
		}

		if (processUnit instanceof IGraphicProcessUnit)
		{
			((IGraphicProcessUnit) processUnit).bindContext(context, descriptorPool);

			if (((IGraphicProcessUnit) processUnit).getDescriptors().isEmpty() == false)
			{
				descriptorPool.addConfiguration(((IGraphicProcessUnit) processUnit));
			}
		}
	}

	public void bindContext(GraphicContext context)
	{
		this.context = context;
		for (IProcessUnit unit : processUnits)
		{
			if (unit instanceof IGraphicProcessUnit)
			{
				((IGraphicProcessUnit) unit).bindContext(context, descriptorPool);
			}
		}
	}

	public void recordBeginCommand(RenderCommandBuffer commandBuffer)
	{
		for (IProcessUnit unit : processUnits)
		{
			if (unit instanceof IGraphicProcessUnit)
			{
				((IGraphicProcessUnit) unit).executePreRender(commandBuffer);
			}
		}
	}

	public void recordRenderPass(RenderCommandBuffer commandBuffer)
	{
		for (IProcessUnit unit : processUnits)
		{
			if (unit instanceof IGraphicProcessUnit)
			{
				((IGraphicProcessUnit) unit).execute(commandBuffer);
			}
			else if (unit instanceof IExecutable)
			{
				((IExecutable) unit).execute(commandBuffer.getVkCommandBuffer());
			}
		}
	}

	public void recordEndCommand(RenderCommandBuffer commandBuffer)
	{
		for (IProcessUnit unit : processUnits)
		{
			if (unit instanceof IGraphicProcessUnit)
			{
				((IGraphicProcessUnit) unit).executePostRender(commandBuffer);
			}
		}
	}

}
