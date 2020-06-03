package org.sheepy.lily.vulkan.process.graphic.execution;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.graphic.IGraphicExecutionRecorders;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecordersAllocation;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.graphic.frame.FramebufferAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.graphic.renderpass.RenderPassAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = GraphicExecutionRecorder.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(parent = GraphicProcess.class, features = GraphicPackage.GRAPHIC_PROCESS__SUBPASSES)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS}, type = RenderPassAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS}, type = ImageViewAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION}, type = FramebufferAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = GraphicPackage.GRAPHIC_PROCESS__SUBPASSES, type = IRecordableExtender.class)
public final class GraphicExecutionRecordersAllocation extends ExecutionRecordersAllocation implements
																							IGraphicExecutionRecorders,
																							IExtender
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.TRANSFER,
															  ECommandStage.COMPUTE,
															  ECommandStage.PRE_RENDER,
															  ECommandStage.RENDER,
															  ECommandStage.POST_RENDER);

	private final List<GraphicExecutionRecorderAllocation> recorders;
	private final VkSemaphore imageAvailableSemaphore;
	private final ImageAcquirer imageAcquirer;

	private GraphicExecutionRecordersAllocation(GraphicExecutionRecorder executionrecorder,
												ProcessContext context,
												@InjectDependency(index = 0) PhysicalSurfaceAllocation surfaceAllocation,
												@InjectDependency(index = 1) SwapChainAllocation swapChainAllocation,
												@InjectDependency(index = 2) RenderPassAllocation renderPassAllocation,
												@InjectDependency(index = 4) FramebufferAllocation framebufferAllocation,
												@InjectDependency(index = 5) List<IRecordableExtender> recordables)
	{
		super(recordables, stages);

		final var process = (GraphicProcess) executionrecorder.eContainer();
		imageAvailableSemaphore = new VkSemaphore(context.getVkDevice());

		final var recorderBuilder = new RecorderBuilder(process,
														context,
														surfaceAllocation,
														swapChainAllocation,
														renderPassAllocation,
														framebufferAllocation);

		recorders = List.copyOf(recorderBuilder.build());

		imageAcquirer = new ImageAcquirer(context.getVkDevice(),
										  imageAvailableSemaphore.getPtr(),
										  surfaceAllocation,
										  swapChainAllocation.getPtr());
	}

	@UpdateDependency(index = 5)
	private void updateRecorders(List<IRecordableExtender> recordables)
	{
		super.updateRecordables(recordables);
	}

	@Free
	private void free(ProcessContext context)
	{
		for (final var recorder : recorders)
		{
			recorder.free(context);
		}
		imageAvailableSemaphore.free(context.getVkDevice());
	}

	@Override
	public Integer acquire()
	{
		return imageAcquirer.acquireNextImage();
	}

	@Override
	protected List<WaitData> gatherWaitDatas(AbstractProcess process)
	{
		final var res = super.gatherWaitDatas(process);
		res.add(0, createAcquireSemaphoreData((GraphicProcess) process));
		return res;
	}

	private WaitData createAcquireSemaphoreData(GraphicProcess process)
	{
		final var acquireWaitStage = process.getConfiguration().getAcquireWaitStage();
		return new WaitData(imageAvailableSemaphore, acquireWaitStage);
	}

	@Override
	public List<GraphicExecutionRecorderAllocation> getRecorders()
	{
		return recorders;
	}

	@Override
	public VkSemaphore getAcquireSemaphore()
	{
		return imageAvailableSemaphore;
	}

	private final class RecorderBuilder
	{
		private final GraphicProcess process;
		private final ProcessContext context;
		private final PhysicalSurfaceAllocation surfaceAllocation;
		private final SwapChainAllocation swapChainAllocation;
		private final RenderPassAllocation renderPassAllocation;
		private final FramebufferAllocation framebufferAllocation;

		private RecorderBuilder(final GraphicProcess process,
								final ProcessContext context,
								PhysicalSurfaceAllocation surfaceAllocation,
								SwapChainAllocation swapChainAllocation,
								RenderPassAllocation renderPassAllocation,
								FramebufferAllocation framebufferAllocation)
		{
			this.process = process;
			this.context = context;
			this.surfaceAllocation = surfaceAllocation;
			this.swapChainAllocation = swapChainAllocation;
			this.renderPassAllocation = renderPassAllocation;
			this.framebufferAllocation = framebufferAllocation;
		}

		private List<GraphicExecutionRecorderAllocation> build()
		{
			final List<GraphicExecutionRecorderAllocation> res = new ArrayList<>();

			final int executionCount = swapChainAllocation.getImageCount();
			final var waitForEmitters = gatherWaitDatas(process);
			final var signals = gatherSinalSemaphores(process);

			for (int i = 0; i < executionCount; i++)
			{
				res.add(createRecorder(process, waitForEmitters, signals, i));
			}

			return res;
		}

		private GraphicExecutionRecorderAllocation createRecorder(GraphicProcess process,
																  List<WaitData> waitForEmitters,
																  List<VkSemaphore> signals,
																  int index)
		{
			final var framebufferPtr = framebufferAllocation.getFramebufferAddresses().get(index);
			final var commandBuffer = new GraphicCommandBuffer(context,
															   surfaceAllocation,
															   renderPassAllocation,
															   framebufferPtr);
			final var presentSemaphore = new VkSemaphore(context.getVkDevice());
			final var currentSignalSemaphores = new ArrayList<VkSemaphore>(signals.size() + 1);
			currentSignalSemaphores.addAll(signals);
			currentSignalSemaphores.add(presentSemaphore);
			final var presentQueue = surfaceAllocation.getPresentQueue().vkQueue;
			final var submission = new Submission(commandBuffer.getVkCommandBuffer(),
												  context,
												  waitForEmitters,
												  currentSignalSemaphores,
												  true);
			final var presentSubmission = new PresentSubmission(swapChainAllocation.getPtr(),
																presentQueue,
																index,
																presentSemaphore);
			return new GraphicExecutionRecorderAllocation(process,
														  commandBuffer,
														  submission,
														  presentSubmission,
														  presentSemaphore,
														  index);
		}
	}
}
