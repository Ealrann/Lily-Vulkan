package org.sheepy.lily.vulkan.common.allocation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.notification.util.ModelObserver;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;

public final class GenericAllocator
{
	private final List<ModelObserver> observers;

	private final AllocableContainer<ExecutionContext> container = new AllocableContainer<>();

	public GenericAllocator(List<List<EReference>> featureLists)
	{
		observers = List.copyOf(buildObservers(featureLists, this::resourceChanged));
	}

	public void start(ILilyEObject rootObject)
	{
		for (final var observer : observers)
		{
			observer.startObserve(rootObject);
		}
	}

	public void stop(ILilyEObject rootObject)
	{
		for (final var observer : observers)
		{
			observer.stopObserve(rootObject);
		}
	}

	private void resourceChanged(Notification notification)
	{
		NotificationUnifier.unifyList(notification, this::add, this::remove);
	}

	private void add(List<? extends ILilyEObject> newChildren)
	{
		final List<IAllocable<ExecutionContext>> res = new ArrayList<>();
		for (final var resource : newChildren)
		{
			final var adapter = resource.<IAllocableAdapter<ExecutionContext>> adaptGeneric(IAllocableAdapter.class);
			if (adapter != null)
			{
				res.add(adapter);
			}
		}

		container.addChildren(res);
	}

	private void remove(List<? extends ILilyEObject> oldChildren)
	{
		final List<IAllocable<ExecutionContext>> res = new ArrayList<>();
		for (final var resource : oldChildren)
		{
			final var adapter = resource.<IAllocableAdapter<ExecutionContext>> adaptGeneric(IAllocableAdapter.class);
			if (adapter != null)
			{
				res.add(adapter);
			}
		}

		container.removeChildren(res);
	}

	public IAllocable<ExecutionContext> getAllocable()
	{
		return container;
	}

	public boolean isDirty()
	{
		return container.isDirty();
	}

	private static List<ModelObserver> buildObservers(	List<List<EReference>> featureLists,
														INotificationListener listener)
	{
		final List<ModelObserver> res = new ArrayList<>();
		for (final var featureList : featureLists)
		{
			res.add(new ModelObserver(listener, featureList));
		}
		return res;
	}
}
