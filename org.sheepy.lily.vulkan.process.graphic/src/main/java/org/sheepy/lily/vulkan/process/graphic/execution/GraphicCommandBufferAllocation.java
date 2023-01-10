package org.sheepy.lily.vulkan.process.graphic.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.AbstractCommandBufferAllocation;
import org.sheepy.lily.vulkan.process.execution.AbstractProcessCommandBufferHelper;
import org.sheepy.lily.vulkan.process.graphic.frame.FramebufferAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

@ModelExtender(scope = GraphicCommandBuffer.class)
@Allocation(context = ProcessContext.class, reuseDirtyAllocations = true)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS}, type = RenderPassAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS}, type = ImageViewAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION}, type = FramebufferAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = GraphicPackage.GRAPHIC_PROCESS__SUBPASSES, type = IRecordableAdapter.class)
public final class GraphicCommandBufferAllocation extends AbstractCommandBufferAllocation
{
	private GraphicCommandBufferAllocation(GraphicCommandBuffer commandBuffer,
										   IAllocationState allocationState,
										   ProcessContext context,
										   @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation,
										   @InjectDependency(index = 1) RenderPassAllocation renderPassAllocation,
										   @InjectDependency(index = 3) FramebufferAllocation framebufferAllocation,
										   @InjectDependency(index = 4) List<IRecordableAdapter> recordables)
	{
		super(buildCommandBufferHelper(commandBuffer,
									   context,
									   surfaceAllocation,
									   renderPassAllocation,
									   framebufferAllocation), context, allocationState);
		changeRecordables(recordables);
	}

	@UpdateDependency(index = 4)
	private void updateRecorders(List<IRecordableAdapter> recordables)
	{
		changeRecordables(recordables);
	}

	private static GraphicCommandBufferHelper buildCommandBufferHelper(final GraphicCommandBuffer commandBuffer,
																	   final ProcessContext context,
																	   final PhysicalSurfaceAllocation surfaceAllocation,
																	   final RenderPassAllocation renderPassAllocation,
																	   final FramebufferAllocation framebufferAllocation)
	{
		final var process = ModelUtil.findParent(commandBuffer, GraphicProcess.class);
		final var subpassCount = countSubpasses(process);
		final int imageID = commandBuffer.getImageID();
		final var framebufferPtr = framebufferAllocation.getFramebufferAddresses().get(imageID);
		final var recordInfo = new AbstractProcessCommandBufferHelper.RecordInfo(imageID, commandBuffer.getIndex());
		return new GraphicCommandBufferHelper(context,
											  surfaceAllocation,
											  renderPassAllocation,
											  framebufferPtr,
											  subpassCount,
											  recordInfo);
	}

	private static int countSubpasses(GraphicProcess process)
	{
		int res = 0;
		for (final var subpass : process.getSubpasses())
		{
			final int subpassIndex = subpass.getSubpassIndex() + 1;
			if (subpassIndex > res)
			{
				res = subpassIndex;
			}
		}
		return res;
	}
}
