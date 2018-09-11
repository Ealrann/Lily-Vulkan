package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.vkDestroyPipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.common.IAllocationObject;
import org.sheepy.vulkan.descriptor.IDescriptor;

public abstract class AbstractCompositePipeline extends AbstractPipeline
		implements ICompositeProcessUnit
{
	private List<IPipelineUnit> units = new ArrayList<>();
	private List<IProcessUnit> executables;

	private boolean enabled = true;
	protected boolean dirty = false;

	public AbstractCompositePipeline(Context context, List<IDescriptor> descriptors)
	{
		super(context, descriptors);
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
		super.allocate(stack);
		executables = new ArrayList<>(allocatePipeline(stack));
	}

	@Override
	public void free()
	{
		for (IProcessUnit executable : executables)
		{
			if (executable instanceof PipelineId)
			{
				vkDestroyPipeline(context.getVkDevice(), ((PipelineId) executable).id, null);
			}
		}

		executables.clear();
		executables = null;

		super.free();
	}

	public List<IPipelineUnit> getUnits()
	{
		return Collections.unmodifiableList(units);
	}

	@Override
	public List<IProcessUnit> getExecutables()
	{
		return Collections.unmodifiableList(executables);
	}

	@Override
	public void setEnabled(boolean enabled)
	{
		if (this.enabled != enabled)
		{
			this.enabled = enabled;
			dirty = true;
		}
	}

	@Override
	public boolean isDirty()
	{
		if (isDirty())
		{
			return dirty;
		}
		else
		{
			for (IDescriptor descriptor : descriptors)
			{
				if(descriptor.isDirty())
				{
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}

	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	protected abstract List<IProcessUnit> allocatePipeline(MemoryStack stack);
}
