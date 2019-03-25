package org.sheepy.lily.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.device.ILogicalDevice;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.api.process.IVulkanContext;
import org.sheepy.lily.vulkan.resource.nativehelper.VkBufferAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.lily.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryInfo;

public class GPUBufferBackend implements IBufferBackend
{
	public static final int DEVICE_LOCAL = VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;

	private final int properties;
	private final BufferInfo infos;

	private long address = -1;
	private long memoryAddress;

	private CPUBufferBackend cpuBackend = null;

	public GPUBufferBackend(BufferInfo info, boolean keepStagingBuffer)
	{
		this.infos = info;

		if (keepStagingBuffer)
		{
			final BufferInfo stagingInfo = new BufferInfo(info.size,
					VK_BUFFER_USAGE_TRANSFER_SRC_BIT, info.keptMapped);
			cpuBackend = new CPUBufferBackend(stagingInfo, true);
		}

		properties = DEVICE_LOCAL;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var vulkanContext = (IVulkanContext) context;
		final var vkDevice = vulkanContext.getVkDevice();
		address = VkBufferAllocator.allocate(stack, vkDevice, infos);

		final var memoryInfo = allocateMemory(stack, vulkanContext.getLogicalDevice());
		memoryAddress = memoryInfo.id;

		vkBindBufferMemory(vkDevice, address, memoryAddress, 0);
		// System.out.println(Long.toHexString(bufferMemoryId));

		if (cpuBackend != null)
		{
			cpuBackend.allocate(stack, context);
		}
	}

	private MemoryInfo allocateMemory(MemoryStack stack, ILogicalDevice logicalDevice)
	{
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, address, properties);
		return VkMemoryAllocator.allocateFromBuffer(stack, allocationInfo);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var vulkanContext = (IVulkanContext) context;
		final var vkDevice = vulkanContext.getVkDevice();

		vkDestroyBuffer(vkDevice, address, null);
		vkFreeMemory(vkDevice, memoryAddress, null);

		if (cpuBackend != null)
		{
			cpuBackend.free(context);
		}

		address = -1;
		memoryAddress = -1;
	}

	@Override
	public void pushData(IExecutionContext executionContext, ByteBuffer data)
	{
		if (address == -1)
		{
			throw new AssertionError("Buffer not allocated");
		}

		if (cpuBackend == null)
		{
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				final int size = (int) Math.min(data.remaining(), infos.size);
				final var bufferFiller = new BufferGPUFiller(stack, executionContext, address);
				bufferFiller.fill(data, size);
			}
		}
		else
		{
			cpuBackend.pushData(executionContext, data);
			pushData(executionContext, cpuBackend);
		}
	}

	public void pushData(IExecutionContext executionContext, CPUBufferBackend stagingBuffer)
	{
		final int size = (int) Math.min(stagingBuffer.infos.size, infos.size);

		executionContext.execute(new ISingleTimeCommand()
		{
			@Override
			public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				BufferUtils.copyBuffer(commandBuffer, stagingBuffer.getAddress(), address, size);
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

	public void pushStagging(IExecutionContext executionManager)
	{
		pushData(executionManager, cpuBackend);
	}

	public BufferInfo getInfos()
	{
		return infos;
	}

	@Override
	public long getAddress()
	{
		return address;
	}

	@Override
	public long getMemoryAddress()
	{
		return memoryAddress;
	}
}
