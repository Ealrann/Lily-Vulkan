package org.sheepy.lily.vulkan.process.graphic.execution;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.IExecutionManagerAdapter;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicAcquirer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.execution.util.FenceManager;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.stream.IntStream;

@ModelExtender(scope = GraphicExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicExecutionManager.FeatureIDs.COMMAND_BUFFERS)
@AllocationChild(features = GraphicExecutionManager.FeatureIDs.ACQUIRER)
@AllocationChild(features = GraphicExecutionManager.FeatureIDs.RECORDERS)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicProcess.FeatureIDs.CONFIGURATION, GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION}, type = SwapChainAllocation.class)
public final class GraphicExecutionManagerAllocation extends ExecutionManagerAllocation<GraphicExecutionRecorderAllocation> implements
																															IExecutionManagerAdapter
{
	private final List<VkSemaphore> presentSemaphores;
	private final List<FenceManager> frameFences;
	private final int executionCount;
	private final IAllocationState allocationState;

	private List<GraphicExecutionRecorderAllocation> recorders;

	private GraphicExecutionManagerAllocation(GraphicExecutionManager executionManager,
											  ProcessContext context,
											  IAllocationState allocationState,
											  @InjectDependency(index = 0) SwapChainAllocation swapChainAllocation)
	{
		super(executionManager, context);

		this.allocationState = allocationState;
		this.executionCount = swapChainAllocation.getImageCount();
		this.presentSemaphores = IntStream.range(0, executionCount)
										  .mapToObj(index -> new VkSemaphore(context.getVkDevice(), "GraphicExecutionRecorderAllocation"))
										  .toList();
		this.frameFences = IntStream.range(0, executionCount)
									.mapToObj(index -> new FenceManager(context.getVkDevice()))
									.toList();
		setupRecorders(executionManager, executionCount);

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			Logger.log(String.format("[Swapchain] Using %d present semaphores (first=0x%x)",
									 executionCount, presentSemaphores.get(0).getPtr()),
					   true);
		}
	}

	@UpdateDependency(index = 0)
	private void updateSwaptChain(SwapChainAllocation swapChainAllocation)
	{
		if (executionCount != swapChainAllocation.getImageCount())
		{
			allocationState.setAllocationObsolete();
		}
	}

	@InjectChildren(index = 2, type = GraphicExecutionRecorderAllocation.class)
	private void injectRecorders(List<GraphicExecutionRecorderAllocation> recorders)
	{
		this.recorders = recorders;
	}

	@Free
	private void free(ProcessContext context)
	{
		final var vkDevice = context.getVkDevice();
		presentSemaphores.forEach(semaphore -> semaphore.free(vkDevice));
		frameFences.forEach(FenceManager::free);
	}

	@Override
	protected List<VkSemaphore> signalSemaphores(final int executionID, final int recordIndex)
	{
		return List.of(presentSemaphores.get(executionID));
	}

	public FenceManager getFrameFence(final int recordIndex)
	{
		return frameFences.get(recordIndex);
	}

	@Override
	protected List<GraphicExecutionRecorderAllocation> getRecorders()
	{
		return recorders;
	}

	public VkSemaphore getPresentSemaphore(final int imageIndex)
	{
		return presentSemaphores.get(imageIndex);
	}

	private static void setupRecorders(GraphicExecutionManager executionManager, int count)
	{
		final var recorderList = executionManager.recorders();
		if (recorderList.size() != count)
		{
			executionManager.acquirer(GraphicAcquirer.builder().build());

			recorderList.clear();
			executionManager.commandBuffers().clear();

				for (int imageID = 0; imageID < count; imageID++)
				{
					final int currentImageID = imageID;
					final var commandBuffers = IntStream.range(0, count)
													.mapToObj(index -> createCommandBuffer(index, currentImageID, executionManager))
													.toList();
					final var submission = createSubmission();
					final var recorder = createRecorder(submission, commandBuffers);
					recorderList.add(recorder);
				}
		}
	}

	private static GraphicCommandBuffer createCommandBuffer(final int index,
															final int imageID,
															final GraphicExecutionManager executionManager)
	{
		final var commandBuffer = GraphicCommandBuffer.builder().index(index).imageID(imageID).build();
		executionManager.commandBuffers().add(commandBuffer);
		return commandBuffer;
	}

	private static GraphicExecutionRecorder createRecorder(final Submission submission,
														   final List<GraphicCommandBuffer> commandBuffers)
	{
		return GraphicExecutionRecorder.builder()
									   .submission(() -> submission)
									   .addCommandBuffers(commandBuffers)
									   .build();
	}

	private static Submission createSubmission()
	{
		return ProcessModelDefinition.Groups.SUBMISSION.lmBuilder().newBuilder().build();
	}
}
