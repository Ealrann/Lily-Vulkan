package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.system.MemoryUtil.memAddress;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.SingleTimeCommand;
import org.sheepy.vulkan.resource.nativehelper.VkBufferAllocator;
import org.sheepy.vulkan.resource.nativehelper.VkMemoryAllocator;
import org.sheepy.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryInfo;

public class BufferBackend
{
	private final LogicalDevice logicalDevice;

	private final BufferInfo infos;

	private long bufferId;
	private long bufferMemoryId;

	public BufferBackend(LogicalDevice logicalDevice, BufferInfo info)
	{
		this.logicalDevice = logicalDevice;
		this.infos = info;
	}

	public void allocate(MemoryStack stack)
	{
		bufferId = VkBufferAllocator.allocate(stack, logicalDevice.getVkDevice(), infos);

		final var memoryInfo = allocateMemory(stack, logicalDevice);
		bufferMemoryId = memoryInfo.id;

		vkBindBufferMemory(logicalDevice.getVkDevice(), bufferId, bufferMemoryId, 0);

		// System.out.println(Long.toHexString(bufferMemoryId));
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var properties = infos.properties;
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, bufferId, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}

	public void free()
	{
		vkDestroyBuffer(logicalDevice.getVkDevice(), bufferId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), bufferMemoryId, null);
	}

	public void pushData(MemoryStack stack, ExecutionManager executionManager, ByteBuffer data)
	{
		if (isGPU())
		{
			pushDataToGPU(stack, executionManager, data);
		}
		else
		{
			pushDataToCPU(data);
		}
	}

	public boolean isGPU()
	{
		return (infos.properties & VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT) != 0;
	}

	public void pushDataToGPU(ExecutionManager executionManager, BufferBackend stagingBuffer)
	{
		int size = (int) Math.min(stagingBuffer.infos.size, infos.size);
		final SingleTimeCommand stc = new SingleTimeCommand(executionManager)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				BufferUtils.copyBuffer(commandBuffer, stagingBuffer.bufferId, bufferId, size);
			}
		};
		stc.execute();
	}

	public void pushDataToGPU(MemoryStack stack, ExecutionManager executionManager, ByteBuffer data)
	{
		int size = (int) Math.min(data.remaining(), infos.size);
		var bufferFiller = new BufferGPUFiller(stack, executionManager, bufferId);
		bufferFiller.fill(data, size);
	}

	public void pushDataToCPU(ByteBuffer byteBuffer)
	{
		final var device = logicalDevice.getVkDevice();
		final PointerBuffer pBuffer = MemoryUtil.memAllocPointer(1);
		vkMapMemory(device, bufferMemoryId, 0, infos.size, 0, pBuffer);
		final long data = pBuffer.get(0);
		MemoryUtil.memCopy(memAddress(byteBuffer), data, infos.size);
		vkUnmapMemory(device, bufferMemoryId);
		MemoryUtil.memFree(pBuffer);
	}

	public BufferInfo getInfos()
	{
		return infos;
	}

	public long getId()
	{
		return bufferId;
	}

	public long getMemoryId()
	{
		return bufferMemoryId;
	}
}
