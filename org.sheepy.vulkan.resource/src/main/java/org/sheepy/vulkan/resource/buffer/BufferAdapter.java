package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.execution.ExecutionManager;
import org.sheepy.vulkan.common.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.resource.PipelineResourceAdapter;

public class BufferAdapter extends PipelineResourceAdapter
{
	private BufferBackend bufferBackend;
	private Buffer buffer;

	private IBufferLoader loader = null;
	private ExecutionManager executionManager;

	@Override
	public void setTarget(Notifier target)
	{
		this.buffer = (Buffer) target;
		super.setTarget(target);
	}

	public void setLoader(IBufferLoader loader)
	{
		this.loader = loader;
	}

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		executionManager = IExecutionManagerAdapter.adapt(target).getExecutionManager(target);
		var logicalDevice = executionManager.logicalDevice;
		var info = new BufferInfo(buffer);

		bufferBackend = new BufferBackend(logicalDevice, info);
		bufferBackend.allocate(stack);

		load();

		dirty = false;
	}

	public void load()
	{
		if (loader != null)
		{
			loader.load(executionManager, bufferBackend);
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

	public void fillWithBuffer(ByteBuffer byteBuffer)
	{
		bufferBackend.fillWithBuffer(byteBuffer);
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

	public static interface IBufferLoader
	{
		void load(ExecutionManager executionManager, BufferBackend backendBuffer);
	}
}
