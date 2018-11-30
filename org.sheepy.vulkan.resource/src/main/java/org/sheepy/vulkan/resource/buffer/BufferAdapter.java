package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.resource.PipelineResourceAdapter;

public class BufferAdapter extends PipelineResourceAdapter
{
	private final int STAGING_USAGE = VK_BUFFER_USAGE_TRANSFER_DST_BIT
			| VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

	private BufferBackend bufferBackend;
	private BufferBackend stagingBuffer;
	private Buffer buffer;

	private ExecutionManager executionManager;

	@Override
	public void setTarget(Notifier target)
	{
		this.buffer = (Buffer) target;
		super.setTarget(target);
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		executionManager = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		var logicalDevice = executionManager.logicalDevice;
		var info = new BufferInfo(buffer);

		bufferBackend = new BufferBackend(logicalDevice, info);
		bufferBackend.allocate(stack);

		if (buffer.isChangeable() && bufferBackend.isGPU())
		{
			allocateStagingBuffer(stack, logicalDevice, info);
		}

		ByteBuffer data = buffer.getData();
		if (data != null)
		{
			if (bufferBackend.isGPU() == false)
			{
				bufferBackend.pushDataToCPU(data);
			}
			else
			{
				if (stagingBuffer != null)
				{
					bufferBackend.pushDataToGPU(executionManager, stagingBuffer);
				}
				else
				{
					bufferBackend.pushDataToGPU(stack, executionManager, data);
				}
			}
		}

		dirty = false;
	}

	private void allocateStagingBuffer(	MemoryStack stack,
										LogicalDevice logicalDevice,
										BufferInfo info)
	{
		if (buffer.getData() != null)
		{
			stagingBuffer = BufferAllocator.allocateCPUBufferAndFill(stack, logicalDevice,
					info.size, STAGING_USAGE, buffer.getData());
		}
		else
		{
			stagingBuffer = BufferAllocator.allocateCPUBuffer(stack, logicalDevice, info.size,
					STAGING_USAGE);
		}
	}

	public void pushData(ByteBuffer data)
	{
		if (bufferBackend.isGPU())
		{
			if (buffer.isChangeable() == false)
			{
				new AssertionError("Unchangeable GPU Buffer.").printStackTrace();
			}

			bufferBackend.pushDataToGPU(executionManager, stagingBuffer);
		}
		else
		{
			bufferBackend.pushDataToCPU(data);
		}
	}

	@Override
	public void free()
	{
		bufferBackend.free();
		bufferBackend = null;
	}

	public long getId()
	{
		return bufferBackend.getId();
	}

	public long getMemoryId()
	{
		return bufferBackend.getMemoryId();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		int stages = 0;
		for (EShaderStage stage : buffer.getShaderStages())
		{
			stages |= stage.getValue();
		}

		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(buffer.getDescriptorType().getValue());
		res.descriptorCount(getDescriptorCount());
		res.stageFlags(stages);
		return res;
	}

	protected static int getDescriptorCount()
	{
		return 1;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		final VkDescriptorBufferInfo.Buffer bufferInfo = allocBufferInfo(stack);

		final VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(buffer.getDescriptorType().getValue());
		descriptorWrite.pBufferInfo(bufferInfo);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	protected VkDescriptorBufferInfo.Buffer allocBufferInfo(MemoryStack stack)
	{
		final var buffer = (Buffer) target;
		final VkDescriptorBufferInfo.Buffer bufferInfo = VkDescriptorBufferInfo.callocStack(1,
				stack);
		bufferInfo.buffer(getId());
		bufferInfo.offset(0);
		bufferInfo.range(buffer.getSize());

		return bufferInfo;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		final VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(buffer.getDescriptorType().getValue());
		poolSize.descriptorCount(getDescriptorCount());
		return poolSize;
	}

	public static BufferAdapter adapt(Buffer buffer)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(buffer, BufferAdapter.class);
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return ResourcePackage.Literals.BUFFER == eClass;
	}
}
