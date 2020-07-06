package org.sheepy.lily.vulkan.demo.test.composite.instance.model;

import org.sheepy.lily.vulkan.demo.test.composite.instance.model.InstanceTestResourceFactory.ResourceContainer;
import org.sheepy.lily.vulkan.model.process.*;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;
import org.sheepy.lily.vulkan.model.resource.*;
import org.sheepy.vulkan.model.enumeration.EBindPoint;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;

public class InstanceTaskManager
{
	public final FlushTransferBufferTask pushTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();
	public final FlushTransferBufferTask fetchTask = ProcessFactory.eINSTANCE.createFlushTransferBufferTask();

	public final PipelineBarrier barrier = ProcessFactory.eINSTANCE.createPipelineBarrier();
	public final BufferBarrier readBarrier = VulkanResourceFactory.eINSTANCE.createBufferBarrier();
	public final BufferBarrier writeBarrier = VulkanResourceFactory.eINSTANCE.createBufferBarrier();

	public final PipelineBarrier barrier2 = ProcessFactory.eINSTANCE.createPipelineBarrier();
	public final BufferBarrier readBarrier2 = VulkanResourceFactory.eINSTANCE.createBufferBarrier();

	public final BindDescriptorSets bindDS = ProcessFactory.eINSTANCE.createBindDescriptorSets();

	public final DispatchTask dispatch = ComputeFactory.eINSTANCE.createDispatchTask();
	public final PrepareCompositeTransfer preparePush = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();
	public final PrepareCompositeTransfer prepareFetch = ProcessFactory.eINSTANCE.createPrepareCompositeTransfer();

	InstanceTaskManager(ResourceContainer resourceContainer)
	{
		final var parts = resourceContainer.compositeBuffer.getParts();
		final var pushbufferReference = newCircularBufferReference(parts, EContextIndex.CONTEXT_INSTANCE);
		final var readbufferReference = newCircularBufferReference(parts, EContextIndex.CONTEXT_INSTANCE);
		final var fetchbufferReference = newCircularBufferReference(parts, EContextIndex.CONTEXT_INSTANCE_PLUS_ONE);
		final var writehbufferReference = newCircularBufferReference(parts, EContextIndex.CONTEXT_INSTANCE_PLUS_ONE);
		final var readbufferReference2 = newCircularBufferReference(parts, EContextIndex.CONTEXT_INSTANCE_PLUS_ONE);

		preparePush.setCompositeBuffer(resourceContainer.compositeBuffer);
		preparePush.setMode(EFlushMode.PUSH);
		preparePush.setTransferBuffer(resourceContainer.transferBuffer);
		preparePush.setBufferReference(pushbufferReference);

		pushTask.setTransferBuffer(resourceContainer.transferBuffer);

		readBarrier.setBuffers(readbufferReference);
		writeBarrier.setBuffers(writehbufferReference);
		barrier.setSrcStage(EPipelineStage.TRANSFER_BIT);
		barrier.setDstStage(EPipelineStage.COMPUTE_SHADER_BIT);
		barrier.getBarriers().add(readBarrier);
		barrier.getBarriers().add(writeBarrier);

		bindDS.setBindPoint(EBindPoint.COMPUTE);
		bindDS.getDescriptorSets().addAll(resourceContainer.dSets);
		bindDS.setStride(1);

		dispatch.setWorkgroupCountX(31250);

		readBarrier2.setBuffers(readbufferReference2);
		barrier2.setSrcStage(EPipelineStage.COMPUTE_SHADER_BIT);
		barrier2.setDstStage(EPipelineStage.TRANSFER_BIT);
		barrier2.getBarriers().add(readBarrier2);

		prepareFetch.setCompositeBuffer(resourceContainer.compositeBuffer);
		prepareFetch.setMode(EFlushMode.FETCH);
		prepareFetch.setTransferBuffer(resourceContainer.transferBuffer);
		prepareFetch.setBufferReference(fetchbufferReference);

		fetchTask.setTransferBuffer(resourceContainer.transferBuffer);
	}

	private static CircularBufferReference newCircularBufferReference(final List<BufferPart> parts,
																	  final EContextIndex contextIndex)
	{
		final var res = VulkanResourceFactory.eINSTANCE.createCircularBufferReference();
		res.getBuffers().addAll(parts);
		res.setStride(1);
		res.setIndexType(contextIndex);
		return res;
	}

	public void install(List<IPipelineTask> tasks)
	{
		tasks.add(preparePush);
		tasks.add(pushTask);
		tasks.add(barrier);
		tasks.add(bindDS);
		tasks.add(dispatch);
		tasks.add(barrier2);
		tasks.add(prepareFetch);
		tasks.add(fetchTask);
	}
}
