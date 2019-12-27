package org.sheepy.lily.vulkan.process.process.allocation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.util.ModelObserver;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.execution.IExecutionContext;

public class PipelineAllocator
{
	private static final List<EStructuralFeature> PIPELINE__FEATURES = List.of(	ProcessPackage.Literals.ABSTRACT_PROCESS__PART_PKG,
																				ProcessPackage.Literals.PROCESS_PART_PKG__PARTS);

	private final ModelObserver PIPELINE_OBSERVER = new ModelObserver(	this::pipelineChanged,
																		PIPELINE__FEATURES);
	private final AbstractProcess process;

	private final AllocableContainer<IExecutionContext> container = new AllocableContainer<>();

	public PipelineAllocator(AbstractProcess process)
	{
		this.process = process;
	}

	public void start()
	{
		PIPELINE_OBSERVER.startObserve(process);
	}

	public void stop()
	{
		PIPELINE_OBSERVER.stopObserve(process);
	}

	@SuppressWarnings("unchecked")
	private void pipelineChanged(Notification notification)
	{
		switch (notification.getEventType())
		{
		case Notification.ADD:
			final var newPipeline = (IPipeline) notification.getNewValue();
			add(List.of(newPipeline));
			break;
		case Notification.ADD_MANY:
			final var newPipelines = (List<IPipeline>) notification.getNewValue();
			add(newPipelines);
			break;
		case Notification.REMOVE:
			final var oldPipeline = (IPipeline) notification.getOldValue();
			remove(List.of(oldPipeline));
			break;
		case Notification.REMOVE_MANY:
			final var oldPipelines = (List<IPipeline>) notification.getOldValue();
			remove(oldPipelines);
			break;
		default:
			System.err.println(this.getClass().getSimpleName() + " resourceChanged");
			break;
		}
	}

	private void add(List<IPipeline> newChildren)
	{
		final List<IAllocable<IExecutionContext>> res = new ArrayList<>();
		for (final var pipeline : newChildren)
		{
			final var adapter = pipeline.<IAllocableAdapter<IExecutionContext>> adaptGeneric(IAllocableAdapter.class);
			if (adapter != null)
			{
				res.add(adapter);
			}
		}

		container.addChildren(res);
	}

	private void remove(List<IPipeline> oldChildren)
	{
		final List<IAllocable<IExecutionContext>> res = new ArrayList<>();
		for (final var pipeline : oldChildren)
		{
			final var adapter = pipeline.<IAllocableAdapter<IExecutionContext>> adaptGeneric(IAllocableAdapter.class);
			if (adapter != null)
			{
				res.add(adapter);
			}
		}

		container.removeChildren(res);
	}

	public IAllocable<IExecutionContext> getAllocable()
	{
		return container;
	}

	public boolean isDirty()
	{
		return container.isDirty();
	}
}
