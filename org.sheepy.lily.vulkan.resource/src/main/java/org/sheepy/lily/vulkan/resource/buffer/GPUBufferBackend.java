package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.engine.IVulkanContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.resource.nativehelper.VkBufferAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryInfo;

public class GPUBufferBackend implements IBufferBackend
{
	public static final int DEVICE_LOCAL = VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;

	private final int properties;
	private final BufferInfo infos;

	private long bufferId;
	private long bufferMemoryId;

	private CPUBufferBackend cpuBackend = null;

	public GPUBufferBackend(BufferInfo info, boolean keepStagingBuffer)
	{
		this.infos = info;

		if (keepStagingBuffer)
		{
			BufferInfo stagingInfo = new BufferInfo(info.size, VK_BUFFER_USAGE_TRANSFER_SRC_BIT,
					info.keptMapped);
			cpuBackend = new CPUBufferBackend(stagingInfo, true);
		}

		properties = DEVICE_LOCAL;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var vulkanContext = (IVulkanContext) context;
		var vkDevice = vulkanContext.getVkDevice();
		bufferId = VkBufferAllocator.allocate(stack, vkDevice, infos);

		final var memoryInfo = allocateMemory(stack, vulkanContext.getLogicalDevice());
		bufferMemoryId = memoryInfo.id;

		vkBindBufferMemory(vkDevice, bufferId, bufferMemoryId, 0);
		// System.out.println(Long.toHexString(bufferMemoryId));

		if (cpuBackend != null)
		{
			cpuBackend.allocate(stack, context);
		}
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, bufferId, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}

	@Override
	public void free(IAllocationContext context)
	{
		var vulkanContext = (IVulkanContext) context;
		var vkDevice = vulkanContext.getVkDevice();

		vkDestroyBuffer(vkDevice, bufferId, null);
		vkFreeMemory(vkDevice, bufferMemoryId, null);

		if (cpuBackend != null)
		{
			cpuBackend.free(context);
		}

		bufferId = -1;
		bufferMemoryId = -1;
	}

	@Override
	public void pushData(ExecutionContext executionContext, ByteBuffer data)
	{
		if (cpuBackend == null)
		{
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				int size = (int) Math.min(data.remaining(), infos.size);
				var bufferFiller = new BufferGPUFiller(stack, executionContext, bufferId);
				bufferFiller.fill(data, size);
			}
		}
		else
		{
			cpuBackend.pushData(executionContext, data);
			pushData(executionContext, cpuBackend);
		}
	}

	public void pushData(ExecutionContext executionContext, CPUBufferBackend stagingBuffer)
	{
		int size = (int) Math.min(stagingBuffer.infos.size, infos.size);

		executionContext.execute(new ISingleTimeCommand()
		{
			@Override
			public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				BufferUtils.copyBuffer(commandBuffer, stagingBuffer.getId(), bufferId, size);
			}
		});
	}

	@Override
	public long mapMemory(VkDevice vkDevice)
	{
		if (cpuBackend != null)
		{
			return cpuBackend.mapMemory(vkDevice);
		}
		else
		{
			throw new AssertionError(
					"Memory mapping for GPUBuffer is only availlable if keepStagingBuffer is true.");
		}
	}

	@Override
	public void unmapMemory(VkDevice vkDevice)
	{
		if (cpuBackend != null)
		{
			cpuBackend.unmapMemory(vkDevice);
		}
		else
		{
			throw new AssertionError(
					"Memory mapping for GPUBuffer is only availlable if keepStagingBuffer is true.");
		}
	}

	public void pushStagging(ExecutionContext executionManager)
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
