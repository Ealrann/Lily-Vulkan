package org.sheepy.vulkan.gameoflife.compute;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.common.execution.SingleTimeCommand;
import org.sheepy.vulkan.common.util.ModelUtil;
import org.sheepy.vulkan.gameoflife.model.GameOfLifePackage;
import org.sheepy.vulkan.resource.PipelineResourceAdapter;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.BufferUtils;
import org.sheepy.vulkan.resource.buffer.BufferBackend;
import org.sheepy.vulkan.resource.descriptor.IDescriptorAdapter;

public class BoardBufferAdapter extends PipelineResourceAdapter implements IDescriptorAdapter
{
	private int width;
	private int height;
	private BufferBackend buffer;

	private Board board;
	private int sizeBuffer;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		var executionManager = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		var logicalDevice = executionManager.logicalDevice;
		var application = ModelUtil.getVulkanApplication(target);
		var windowSize = application.getSize();
		
		this.width = windowSize.getX();
		this.height = windowSize.getY();
		board = Board.createTestBoard(width, height);

		int size = board.getWidth() * board.getHeight();
		sizeBuffer = size * Integer.BYTES;
		int usage = VK_BUFFER_USAGE_STORAGE_BUFFER_BIT
				| VK_BUFFER_USAGE_TRANSFER_SRC_BIT
				| VK_BUFFER_USAGE_TRANSFER_DST_BIT;

		buffer = BufferAllocator.allocateGPUBuffer(stack, logicalDevice, sizeBuffer, usage);

		var indexStagingBuffer = BufferAllocator.allocateCPUBuffer(stack, logicalDevice, sizeBuffer,
				VK_BUFFER_USAGE_TRANSFER_SRC_BIT);

		ByteBuffer byteBuffer = MemoryUtil.memAlloc(sizeBuffer);
		IntBuffer intBufferView = byteBuffer.asIntBuffer();
		for (int i = 0; i < size; i++)
		{
			intBufferView.put(board.isActivated(i) ? 1 : 0);
		}
		intBufferView.flip();

		indexStagingBuffer.fillWithBuffer(byteBuffer);

		SingleTimeCommand stc = new SingleTimeCommand(executionManager)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				BufferUtils.copyBuffer(commandBuffer, indexStagingBuffer.getId(), buffer.getId(),
						sizeBuffer);
			}
		};
		stc.execute();

		indexStagingBuffer.free();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(VK_DESCRIPTOR_TYPE_STORAGE_BUFFER);
		res.descriptorCount(1);
		res.stageFlags(VK_SHADER_STAGE_COMPUTE_BIT);
		return res;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		VkDescriptorBufferInfo.Buffer bufferInfo = VkDescriptorBufferInfo.callocStack(1, stack);
		bufferInfo.buffer(buffer.getId());
		bufferInfo.offset(0);
		bufferInfo.range(sizeBuffer);

		VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(VK_DESCRIPTOR_TYPE_STORAGE_BUFFER);
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(VK_DESCRIPTOR_TYPE_STORAGE_BUFFER);
		poolSize.descriptorCount(1);
		return poolSize;
	}

	public long getBufferId()
	{
		return buffer.getId();
	}

	@Override
	public void free()
	{
		buffer.free();
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return GameOfLifePackage.Literals.BOARD_BUFFER == eClass;
	}
}
