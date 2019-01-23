package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.execution.ExecutionManager;
import org.sheepy.lily.vulkan.common.execution.SingleTimeCommand;
import org.sheepy.lily.vulkan.resource.nativehelper.VkBufferAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryInfo;

public class GPUBufferBackend implements IBufferBackend
{
	public static final int DEVICE_LOCAL = VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;

	private final LogicalDevice logicalDevice;
	private final int properties;
	private final BufferInfo infos;

	private long bufferId;
	private long bufferMemoryId;

	private CPUBufferBackend cpuBackend = null;

	public GPUBufferBackend(LogicalDevice logicalDevice, BufferInfo info, boolean keepStagingBuffer)
	{
		this.logicalDevice = logicalDevice;
		this.infos = info;

		if (keepStagingBuffer)
		{
			BufferInfo stagingInfo = new BufferInfo(info.size, VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
					info.keptMapped);
			cpuBackend = new CPUBufferBackend(logicalDevice, stagingInfo, true);
		}

		properties = DEVICE_LOCAL;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		bufferId = VkBufferAllocator.allocate(stack, logicalDevice.getVkDevice(), infos);

		final var memoryInfo = allocateMemory(stack, logicalDevice);
		bufferMemoryId = memoryInfo.id;

		vkBindBufferMemory(logicalDevice.getVkDevice(), bufferId, bufferMemoryId, 0);
		// System.out.println(Long.toHexString(bufferMemoryId));

		if (cpuBackend != null)
		{
			cpuBackend.allocate(stack);
		}
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, bufferId, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}

	@Override
	public void free()
	{
		vkDestroyBuffer(logicalDevice.getVkDevice(), bufferId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), bufferMemoryId, null);

		if (cpuBackend != null)
		{
			cpuBackend.free();
		}

		bufferId = -1;
		bufferMemoryId = -1;
	}

	@Override
	public void pushData(ExecutionManager executionManager, ByteBuffer data)
	{
		if (cpuBackend == null)
		{
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				int size = (int) Math.min(data.remaining(), infos.size);
				var bufferFiller = new BufferGPUFiller(stack, executionManager, bufferId);
				bufferFiller.fill(data, size);
			}
		}
		else
		{
			cpuBackend.pushData(data);
			pushData(executionManager, cpuBackend);
		}
	}

	public void pushData(ExecutionManager executionManager, CPUBufferBackend stagingBuffer)
	{
		int size = (int) Math.min(stagingBuffer.infos.size, infos.size);
		final SingleTimeCommand stc = new SingleTimeCommand(executionManager)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				BufferUtils.copyBuffer(commandBuffer, stagingBuffer.getId(), bufferId, size);
			}
		};
		stc.execute();
	}

	@Override
	public long mapMemory()
	{
		if (cpuBackend != null)
		{
			return cpuBackend.mapMemory();
		}
		else
		{
			throw new AssertionError(
					"Memory mapping for GPUBuffer is only availlable if keepStagingBuffer is true.");
		}
	}

	@Override
	public void unmapMemory()
	{
		if (cpuBackend != null)
		{
			cpuBackend.unmapMemory();
		}
		else
		{
			throw new AssertionError(
					"Memory mapping for GPUBuffer is only availlable if keepStagingBuffer is true.");
		}
	}

	public void pushStagging(ExecutionManager executionManager)
	{
		pushData(executionManager, cpuBackend);
	}

	public BufferInfo getInfos()
	{
		return infos;
	}

	@Override
	public long getId()
	{
		return bufferId;
	}

	@Override
	public long getMemoryId()
	{
		return bufferMemoryId;
	}
}
