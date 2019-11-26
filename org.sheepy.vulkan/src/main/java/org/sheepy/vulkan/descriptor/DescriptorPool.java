package org.sheepy.vulkan.descriptor;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDescriptorPoolCreateInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.log.Logger;

public final class DescriptorPool implements IAllocable<IExecutionContext>
{
	private static final String FAILED_TO_CREATE_DESCRIPTOR_POOL = "Failed to create descriptor pool";

	private final List<IVkDescriptorSet> descriptorSets;

	private long id;
	private boolean hasChanged = false;

	public DescriptorPool(List<IVkDescriptorSet> descriptorSets)
	{
		this.descriptorSets = List.copyOf(descriptorSets);
	}
	
	@Override
	public void allocate(IExecutionContext context)
	{
		final var vkDevice = ((ExecutionContext) context).getVkDevice();
		int poolSize = 0;
		for (int i = 0; i < descriptorSets.size(); i++)
		{
			final var descriptorSet = descriptorSets.get(i);
			poolSize += descriptorSet.descriptorCount();
		}

		if (poolSize > 0)
		{
			final var poolSizes = VkDescriptorPoolSize.callocStack(poolSize);
			for (int i = 0; i < descriptorSets.size(); i++)
			{
				final var descriptorSet = descriptorSets.get(i);
				descriptorSet.fillPoolSizes(poolSizes);
			}
			poolSizes.flip();

			final var poolInfo = VkDescriptorPoolCreateInfo.callocStack();
			poolInfo.sType(VK_STRUCTURE_TYPE_DESCRIPTOR_POOL_CREATE_INFO);
			poolInfo.pPoolSizes(poolSizes);
			poolInfo.maxSets(descriptorSets.size());

			final long[] aDescriptor = new long[1];
			Logger.check(	FAILED_TO_CREATE_DESCRIPTOR_POOL,
							() -> vkCreateDescriptorPool(vkDevice, poolInfo, null, aDescriptor));
			id = aDescriptor[0];
		}

		for (final var descriptorSet : descriptorSets)
		{
			descriptorSet.allocate(context, id);
		}
	}

	public void prepare(MemoryStack stack)
	{
		hasChanged = false;

		for (int i = 0; i < descriptorSets.size(); i++)
		{
			final IVkDescriptorSet descriptorSet = descriptorSets.get(i);
			descriptorSet.updateDescriptorSet(stack);
			if (descriptorSet.hasChanged())
			{
				hasChanged = true;
				break;
			}
		}

		if (hasChanged)
		{
			for (int i = 0; i < descriptorSets.size(); i++)
			{
				final IVkDescriptorSet descriptorSet = descriptorSets.get(i);
				descriptorSet.updateDescriptorSet(stack);
			}
		}
	}

	public boolean hasChanged()
	{
		return hasChanged;
	}

	@Override
	public void free(IExecutionContext context)
	{
		final var vkDevice = ((ExecutionContext) context).getVkDevice();

		for (final var descriptorSet : descriptorSets)
		{
			descriptorSet.free(context);
		}

		vkDestroyDescriptorPool(vkDevice, id, null);
		id = -1;
	}

	public long getId()
	{
		return id;
	}
}
