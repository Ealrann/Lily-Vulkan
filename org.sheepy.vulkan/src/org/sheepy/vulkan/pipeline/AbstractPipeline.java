package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.vkDestroyPipeline;
import static org.lwjgl.vulkan.VK10.vkDestroyPipelineLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.device.LogicalDevice;

public abstract class AbstractPipeline extends AllocationNode implements IAllocable
{
	protected final LogicalDevice logicalDevice;

	private List<IPipelineUnit> units = new ArrayList<>();

	protected long pipelineLayout = 1;
	private List<IPipelineExecutable> executables;

	private boolean lock = false;
	private boolean enabled = true;
	protected boolean dirty = false;

	public AbstractPipeline(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
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

	protected abstract long allocatePipelineLayout(MemoryStack stack);

	protected abstract List<IPipelineExecutable> allocatePipeline(MemoryStack stack);
}
