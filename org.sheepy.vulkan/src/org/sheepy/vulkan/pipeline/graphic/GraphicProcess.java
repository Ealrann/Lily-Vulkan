package org.sheepy.vulkan.pipeline.graphic;

import static org.lwjgl.vulkan.VK10.VK_PIPELINE_BIND_POINT_GRAPHICS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.vulkan.command.ECommandStage;
import org.sheepy.vulkan.command.graphic.RenderCommandBuffer;
import org.sheepy.vulkan.pipeline.AbstractProcess;
import org.sheepy.vulkan.pipeline.IProcessUnit;
import org.sheepy.vulkan.pipeline.graphic.render.GraphicsPipeline;

/**
 * A set of GraphicPipelines.
 * 
 * @author ealrann
 *
 */
public class GraphicProcess extends AbstractProcess<RenderCommandBuffer>
{
	protected GraphicContext context;

	protected final List<IProcessUnit> preRenderUnits = new ArrayList<>();
	protected final List<IProcessUnit> renderUnits = new ArrayList<>();
	protected final List<IProcessUnit> postRenderUnits = new ArrayList<>();

	/**
	 * @param logicalDevice
	 * @param configuration
	 * @param commandPool
	 * @param colorDomain
	 * @param bindType
	 *            VK_PIPELINE_BIND_POINT_COMPUTE or
	 *            VK_PIPELINE_BIND_POINT_GRAPHICS
	 */
	public GraphicProcess(GraphicContext context)
	{
		super(context, VK_PIPELINE_BIND_POINT_GRAPHICS, ECommandStage.Render);
	}

	public void addGraphicPipeline(GraphicsPipeline pipeline)
	{
		addProcessUnit(pipeline, ECommandStage.Render);
	}

	@Override
	protected List<IProcessUnit> getStageList(ECommandStage stage)
	{
		switch (stage)
		{
		case PreRender:
			return preRenderUnits;
		case Render:
			return renderUnits;
		case PostRender:
			return postRenderUnits;
		default:
			return Collections.emptyList();
		}
	}

	@Override
	protected void doExecuteUnit(RenderCommandBuffer commandBuffer, IProcessUnit unit)
	{
		if (unit instanceof IGraphicExecutable)
		{
			((IGraphicExecutable) unit).execute(commandBuffer);
		}
	}

	public boolean update()
	{
		boolean res = false;

		for (ECommandStage stage : ECommandStage.values())
		{
			for (IProcessUnit unit : getStageList(stage))
			{
				if (unit instanceof IGraphicProcessUnit)
				{
					res |= ((IGraphicProcessUnit) unit).update();
				}
			}
		}

		return res;
	}
}
