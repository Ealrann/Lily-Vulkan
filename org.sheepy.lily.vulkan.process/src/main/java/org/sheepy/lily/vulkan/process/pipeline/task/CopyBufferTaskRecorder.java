package org.sheepy.lily.vulkan.process.pipeline.task;

import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.core.resource.IBufferReferenceAllocation;
import org.sheepy.lily.vulkan.core.resource.buffer.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

@ModelExtender(scope = CopyBufferTask.class)
@Allocation
@AllocationChild(allocateBeforeParent = true, features = ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER)
@AllocationChild(allocateBeforeParent = true, features = ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER)
@AllocationDependency(features = ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER, type = IBufferReferenceAllocation.class)
@AllocationDependency(features = ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER, type = IBufferReferenceAllocation.class)
public final class CopyBufferTaskRecorder implements IRecordableAdapter
{
	private final List<CopyPass> copyPasses;

	public CopyBufferTaskRecorder(CopyBufferTask task,
								  @InjectDependency(index = 0) IBufferReferenceAllocation srcBufferReference,
								  @InjectDependency(index = 1) IBufferReferenceAllocation dstBufferReference)
	{
		final int indexCount = gatherIndexCount(task);
		final BufferReference srcBuffer = task.getSrcBuffer();
		final BufferReference dstBuffer = task.getDstBuffer();
		assert srcBuffer.getStride() == dstBuffer.getStride();
		assert srcBuffer.getBuffers().size() == dstBuffer.getBuffers().size();
		final int stride = srcBuffer.getStride();
		final int effectiveStride = stride == 0 ? srcBuffer.getBuffers().size() : stride;

		final List<CopyPass> tmpPasses = buildCopyPasses(srcBufferReference,
														 dstBufferReference,
														 indexCount,
														 effectiveStride);
		copyPasses = List.copyOf(tmpPasses);
	}

	@Dispose
	public void dispose()
	{
		copyPasses.forEach(CopyPass::free);
	}

	@Override
	public void record(RecordContext context)
	{
		copyPasses.get(context.index).record(context);
	}

	private static int gatherIndexCount(final CopyBufferTask task)
	{
		final var process = ModelUtil.findParent(task, AbstractProcess.class);
		final var executionManager = process.adapt(InternalProcessAdapter.class);
		return executionManager.getExecutionCount();
	}

	private static List<CopyPass> buildCopyPasses(final IBufferReferenceAllocation srcBufferReference,
												  final IBufferReferenceAllocation dstBufferReference,
												  final int indexCount,
												  final int effectiveStride)
	{
		final List<CopyPass> passes = new ArrayList<>();
		for (int i = 0; i < indexCount; i++)
		{
			final var srcBufferAllocations = srcBufferReference.getBufferAllocations(i);
			final var dstBufferAllocations = dstBufferReference.getBufferAllocations(i);

			final CopyPass copyPass = buildCopyPass(effectiveStride, srcBufferAllocations, dstBufferAllocations);
			passes.add(copyPass);
		}
		return passes;
	}

	private static CopyPass buildCopyPass(final int stride,
										  final List<IVulkanBufferAllocation> srcBufferAllocations,
										  final List<IVulkanBufferAllocation> dstBufferAllocations)
	{
		final var bufferConfigurationMap = IntStream.range(0, stride)
													.mapToObj(index -> new BufferCopyConfiguration(srcBufferAllocations.get(
															index), dstBufferAllocations.get(index)))
													.collect(Collectors.groupingBy(BufferCopyConfiguration::toPtrConfiguration));

		final var copyConfiguration = bufferConfigurationMap.entrySet()
															.stream()
															.map(CopyBufferTaskRecorder::newCopyData)
															.collect(Collectors.toUnmodifiableList());
		return new CopyPass(copyConfiguration);
	}

	private static CopyConfiguration newCopyData(Map.Entry<BufferCopyConfigurationPtr, List<BufferCopyConfiguration>> entry)
	{
		return new CopyConfiguration(entry.getValue().get(0), entry.getValue());
	}

	private static record BufferCopyConfiguration(IVulkanBufferAllocation srcBuffer, IVulkanBufferAllocation dstBuffer)
	{
		private BufferCopyConfigurationPtr toPtrConfiguration()
		{
			return new BufferCopyConfigurationPtr(srcBuffer.getPtr(), dstBuffer.getPtr());
		}
	}

	private static record BufferCopyConfigurationPtr(long srcPtr, long dstPtr)
	{
	}

	private static record CopyPass(List<CopyConfiguration> copyData)
	{

		private void record(RecordContext context)
		{
			copyData.forEach(copyConfiguration -> copyConfiguration.record(context));
		}

		private void free()
		{
			copyData.forEach(CopyConfiguration::free);
		}
	}

	private static record CopyConfiguration(BufferCopyConfiguration bufferCopyConfiguration, VkBufferCopy.Buffer vkBufferCopy)
	{
		public CopyConfiguration(BufferCopyConfiguration bufferCopyConfiguration,
								 List<BufferCopyConfiguration> copyConfigurations)
		{
			this(bufferCopyConfiguration, createBufferCopyInfo(copyConfigurations));
		}

		private void record(RecordContext context)
		{
			final var commandBuffer = context.commandBuffer;

			bufferCopyConfiguration.srcBuffer.attach(context);
			bufferCopyConfiguration.dstBuffer.attach(context);

			vkCmdCopyBuffer(commandBuffer,
							bufferCopyConfiguration.srcBuffer.getPtr(),
							bufferCopyConfiguration.dstBuffer.getPtr(),
							vkBufferCopy);
		}

		private void free()
		{
			vkBufferCopy.free();
		}

		private static VkBufferCopy.Buffer createBufferCopyInfo(List<BufferCopyConfiguration> copyConfigurations)
		{
			final var copyInfoBuffer = VkBufferCopy.calloc(copyConfigurations.size());
			for (final var copyConfiguration : copyConfigurations)
			{
				final var copyInfo = copyInfoBuffer.get();
				final var srcBufferAllocation = copyConfiguration.srcBuffer;
				final var dstBufferAllocation = copyConfiguration.dstBuffer;

				final var scrOffset = srcBufferAllocation.getBindOffset();
				final var dstOffset = dstBufferAllocation.getBindOffset();
				copyInfo.srcOffset(scrOffset);
				copyInfo.dstOffset(dstOffset);

				final var srcSize = srcBufferAllocation.getBindSize();
				final var trgSize = dstBufferAllocation.getBindSize();
				final var size = Math.min(srcSize, trgSize);
				copyInfo.size(size);
			}
			copyInfoBuffer.flip();
			return copyInfoBuffer;
		}
	}
}
