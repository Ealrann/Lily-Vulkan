package org.sheepy.lily.vulkan.process.graphic.execution;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.GenericExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.IExecutionRecorderAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.frame.FramebufferAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.graphic.pipeline.SubpassRecorder;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

@ModelExtender(scope = GraphicExecutionRecorder.class)
@Allocation(context = ProcessContext.class, reuseDirtyAllocations = true)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS}, type = RenderPassAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS}, type = ImageViewAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION}, type = FramebufferAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = GraphicPackage.GRAPHIC_PROCESS__SUBPASSES, type = IRecordableExtender.class)
public final class GraphicExecutionRecorderAllocation implements IExecutionRecorderAllocation
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.PRE_RENDER,
															  ECommandStage.MAIN,
															  ECommandStage.POST_RENDER);

	private final GraphicCommandBuffer commandBuffer;
	private final GraphicProcess process;
	private final PresentSubmission presentSubmission;
	private final VkSemaphore presentSemaphore;
	private final GenericExecutionRecorder executionRecorder;
	private final List<VkSemaphore> signalSemaphores;

	private List<IRecordableExtender> recordables;
	private int subpassCount;
	private boolean needRecord = true;

	public GraphicExecutionRecorderAllocation(GraphicExecutionRecorder recorder,
											  ProcessContext context,
											  IAllocationState allocationState,
											  @InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation,
											  @InjectDependency(index = 1) SwapChainAllocation swapChainAllocation,
											  @InjectDependency(index = 2) RenderPassAllocation renderPassAllocation,
											  @InjectDependency(index = 4) FramebufferAllocation framebufferAllocation,
											  @InjectDependency(index = 5) List<IRecordableExtender> recordables)
	{
		final int index = recorder.getIndex();
		final var framebufferPtr = framebufferAllocation.getFramebufferAddresses().get(index);

		this.recordables = recordables;
		this.process = ModelUtil.findParent(recorder, GraphicProcess.class);
		this.commandBuffer = new GraphicCommandBuffer(context, surfaceAllocation, renderPassAllocation, framebufferPtr);
		this.presentSemaphore = new VkSemaphore(context.getVkDevice());
		final var presentQueue = surfaceAllocation.getPresentQueue().vkQueue;

		this.presentSubmission = new PresentSubmission(swapChainAllocation.getPtr(),
													   presentQueue,
													   index,
													   presentSemaphore);
		countSubpasses();
		executionRecorder = new GenericExecutionRecorder(commandBuffer,
														 context,
														 allocationState,
														 index,
														 1,
														 this::recordCommand);

		signalSemaphores = List.of(presentSemaphore);
	}

	@Free
	public void free(ExecutionContext context)
	{
		executionRecorder.free(context.getVkDevice());
		commandBuffer.free(context);
		presentSemaphore.free(context.getVkDevice());
		presentSubmission.free();
	}

	@UpdateDependency(index = 5)
	private void updateRecordables(List<IRecordableExtender> recordables)
	{
		this.recordables = recordables;
		needRecord = true;
	}

	@Override
	public void prepare(final List<WaitData> waitSemaphores, int semaphoreCount)
	{
		executionRecorder.prepare(waitSemaphores, signalSemaphores, semaphoreCount);

		if (needRecord)
		{
			executionRecorder.record(stages);
			needRecord = false;
		}
	}

	private void recordCommand(RecordContext recordContext)
	{
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		final var stage = recordContext.stage;
		int current = 0;

		while (current < subpassCount)
		{
			if (stage == ECommandStage.MAIN && current != 0)
			{
				vkCmdNextSubpass(vkCommandBuffer, VK_SUBPASS_CONTENTS_INLINE);
			}

			for (int i = 0; i < recordables.size(); i++)
			{
				final var subpass = (SubpassRecorder) recordables.get(i);
				final int subpassIndex = subpass.getSubpassIndex();
				if (stage != ECommandStage.MAIN || subpassIndex == current)
				{
					subpass.record(recordContext);
				}
			}

			current++;
		}
	}

	@Override
	public IFenceView play()
	{
		final var res = executionRecorder.play();
		if (res.result() == VK_SUCCESS)
		{
			presentSubmission.submit();
		}
		return res.fence();
	}

	private void countSubpasses()
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
		subpassCount = res;
	}

	@Override
	public boolean checkFence()
	{
		return executionRecorder.checkFence();
	}

	@Override
	public void waitIdle()
	{
		executionRecorder.waitIdle();
	}

	@Override
	public VkSemaphore borrowSemaphore()
	{
		return executionRecorder.borrowSemaphore();
	}
}
