package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.descriptor.DescriptorSet;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.descriptor.IDescriptorSetConfiguration;
import org.sheepy.vulkan.device.LogicalDevice;

public abstract class AbstractPipeline extends AllocationNode
		implements IAllocable, IDescriptorSetConfiguration
{
	protected LogicalDevice logicalDevice;
	protected DescriptorPool descriptorPool;

	private List<IDescriptor> descriptors;
	private List<IPipelineUnit> units = new ArrayList<>();

	protected long pipelineLayout = 1;
	private List<IPipelineExecutable> executables;

	private boolean lock = false;
	private boolean enabled = true;
	protected boolean dirty = false;

	public AbstractPipeline(List<IDescriptor> descriptors)
	{
		this.descriptors = Collections.unmodifiableList(new ArrayList<>(descriptors));
	}

	public void bindContext(LogicalDevice logicalDevice, DescriptorPool descriptorPool)
	{
		this.logicalDevice = logicalDevice;
		this.descriptorPool = descriptorPool;
	}

	public void addPipelineUnits(Collection<? extends IPipelineUnit> units)
	{
		if (lock)
		{
			throw new AssertionError("You cannot add Units after the allocation of the pipeline.");
		}

		for (IPipelineUnit unit : units)
		{
			if (unit instanceof IAllocationObject)
			{
				allocationObjects.add((IAllocationObject) unit);
			}

			this.units.add(unit);
		}
	}

	public void addPipelineUnit(IPipelineUnit unit)
	{
		addPipelineUnits(Collections.singleton(unit));
	}

	@Override
	public final void allocate(MemoryStack stack)
	{
		pipelineLayout = allocatePipelineLayout(stack);
		executables = new ArrayList<>(allocatePipeline(stack));
	}

	protected long allocatePipelineLayout(MemoryStack stack)
	{
		// Create Pipeline Layout
		// -----------------------

		DescriptorSet descriptorSet = descriptorPool.getDescriptorSet(this);
		LongBuffer bDescriptorSet = stack.mallocLong(1);
		bDescriptorSet.put(descriptorSet.getLayoutId());
		bDescriptorSet.flip();

		// Create compute pipeline
		long[] aLayout = new long[1];
		VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo
				.callocStack(stack);
		pipelineLayoutCreateInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		pipelineLayoutCreateInfo.pSetLayouts(bDescriptorSet);
		if (vkCreatePipelineLayout(logicalDevice.getVkDevice(), pipelineLayoutCreateInfo, null,
				aLayout) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create compute pipeline layout!");
		}
		return aLayout[0];
	}

	@Override
	public void free()
	{
		for (IPipelineExecutable executable : executables)
		{
			if (executable instanceof PipelineId)
			{
				vkDestroyPipeline(logicalDevice.getVkDevice(), ((PipelineId) executable).id, null);
			}
		}

		vkDestroyPipelineLayout(logicalDevice.getVkDevice(), pipelineLayout, null);

		executables.clear();
		executables = null;

		pipelineLayout = -1;
	}

	public long getLayoutId()
	{
		return pipelineLayout;
	}

	public List<IPipelineUnit> getUnits()
	{
		return Collections.unmodifiableList(units);
	}

	public List<IPipelineExecutable> getExecutables()
	{
		return Collections.unmodifiableList(executables);
	}

	public void setEnabled(boolean enabled)
	{
		if (this.enabled != enabled)
		{
			this.enabled = enabled;
			dirty = true;
		}
	}

	public boolean isDirty()
	{
		return dirty;
	}

	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	@Override
	public List<IDescriptor> getDescriptors()
	{
		return descriptors;
	}

	protected abstract List<IPipelineExecutable> allocatePipeline(MemoryStack stack);
}
