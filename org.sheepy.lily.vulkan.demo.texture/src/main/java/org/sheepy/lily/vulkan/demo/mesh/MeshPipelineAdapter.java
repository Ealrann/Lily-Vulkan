package org.sheepy.lily.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.demo.adapter.CameraMatrixComputer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.descriptor.VkDescriptorSet;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;
import org.sheepy.vulkan.resource.indexed.IndexedBuffer;
import org.sheepy.vulkan.resource.indexed.IndexedBufferWithUniform;

@Statefull
@Adapter(scope = GraphicsPipeline.class, name = MeshModelFactory.MESH_PIPELINE_NAME)
public class MeshPipelineAdapter extends GraphicsPipelineAdapter
{
	public static IIndexedBufferBuilder<?> meshBuilder = null;

	private final IndexedBuffer<?> indexBuffer;
	private final CameraMatrixComputer cameraComputer;

	private boolean first = true;

	VkDescriptorSet descriptorSet;

	public MeshPipelineAdapter(GraphicsPipeline pipeline)
	{
		super(pipeline);

		final var application = VulkanModelUtil.getApplication(pipeline);

		indexBuffer = meshBuilder.getIndexedBuffer();

		if (indexBuffer instanceof IndexedBufferWithUniform)
		{
			final var uniformBuffer = ((IndexedBufferWithUniform<?>) indexBuffer)
					.getUniformBuffer();
			cameraComputer = new CameraMatrixComputer(application, uniformBuffer);

			final var indexedBufferWithUniform = (IndexedBufferWithUniform<?>) indexBuffer;
			final var size = indexedBufferWithUniform.getUniformBufferCapacity();
			final var offset = indexedBufferWithUniform.getUniformBufferOffset();

			final CameraUniformDescriptor descriptor = new CameraUniformDescriptor(
					indexedBufferWithUniform.getUniformBuffer(), offset, size);

			descriptorSet = new VkDescriptorSet(List.of(descriptor));
		}
		else
		{
			cameraComputer = null;
			descriptorSet = null;
		}
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		super.allocate(stack, context);

		if (cameraComputer != null) cameraComputer.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		super.free(context);

		if (cameraComputer != null) cameraComputer.free(context);
	}

	@Override
	public void collectDescriptorSets(List<IVkDescriptorSet> collectIn)
	{
		if (descriptorSet != null) collectIn.add(descriptorSet);
		super.collectDescriptorSets(collectIn);
	}

	@Override
	public void collectResources(List<Object> collectIn)
	{
		collectIn.add(indexBuffer);
	}

	@Override
	public void prepareExecution(IExecutionContext context)
	{
		// We shouldn't update a uniform buffer while running.
		// Updating a uniformBuffer every frame is dumb since it require to wait the execution
		// termination.
		// PushConstants are way better, since they only require a new record.

		if (cameraComputer != null)
		{
			context.getQueue().waitIdle();
			cameraComputer.update(context);
		}
	}

	@Override
	public void record(	ECommandStage stage,
						VkCommandBuffer vkCommandBuffer,
						int bindPoint,
						int index)
	{
		if (stage == pipeline.getStage())
		{
			if (first == true)
			{
				meshBuilder.fillBuffer();
				first = false;
			}

			final var indexBufferId = indexBuffer.getIndexBufferAddress();

			final long[] vertexBuffers = new long[] {
					indexBuffer.getVertexBufferAddress()
			};
			final long[] offsets = {
					0
			};

			vkCmdBindPipeline(vkCommandBuffer, bindPoint, getPipelineId());

			bindDescriptor(vkCommandBuffer, bindPoint, new Integer[] {
					0, 1
			});

			vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
			vkCmdBindIndexBuffer(vkCommandBuffer, indexBufferId, 0, VK_INDEX_TYPE_UINT32);
			vkCmdDrawIndexed(vkCommandBuffer, indexBuffer.getIndicesCount(), 1, 0, 0, 0);
		}
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		return indexBuffer.getIndexBufferDescriptor();
	}
}
