package org.sheepy.lily.game.core.allocation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.allocation.up.IAllocationContext;
import org.sheepy.lily.core.api.allocation.up.IAllocationManager;
import org.sheepy.lily.core.api.notification.util.ModelObserver;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public final class ModelAllocator
{
	private final List<ModelObserver> observers;
	private final List<ILilyEObject> objects = new ArrayList<>();
	private final Deque<ILilyEObject> toFree = new ArrayDeque<>();

	private boolean started = false;

	public ModelAllocator(final List<List<EReference>> featureLists)
	{
		observers = List.copyOf(buildObservers(featureLists, this::resourceChanged));
	}

	public void start(ILilyEObject rootObject, IAllocationContext context)
	{
		for (final var observer : observers)
		{
			observer.startObserve(rootObject);
		}
		started = true;
		update(context);
	}

	public void stop(ILilyEObject rootObject, IAllocationContext context)
	{
		free(context);
		started = false;
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
		objects.addAll(newChildren);
	}

	private void remove(List<? extends ILilyEObject> oldChildren)
	{
		objects.removeAll(oldChildren);
		if (started)
		{
			toFree.addAll(oldChildren);
		}
	}

	private static List<ModelObserver> buildObservers(List<List<EReference>> featureLists,
													  Consumer<Notification> listener)
	{
		final List<ModelObserver> res = new ArrayList<>();
		for (final var featureList : featureLists)
		{
			res.add(new ModelObserver(listener, featureList));
		}
		return res;
	}

	public void update(final IAllocationContext context)
	{
		context.preAllocation();
		while (toFree.isEmpty() == false)
		{
			final var object = toFree.removeLast();
			IAllocationManager.INSTANCE.free(object, context);
		}
		for (var object : objects)
		{
			IAllocationManager.INSTANCE.maintainAllocation(object, context);
		}
		context.postAllocation();
	}

	private void free(final IAllocationContext context)
	{
		while (toFree.isEmpty() == false)
		{
			final var object = toFree.removeLast();
			IAllocationManager.INSTANCE.free(object, context);
		}
		for (int i = objects.size() - 1; i >= 0; i--)
		{
			final var object = objects.get(i);
			IAllocationManager.INSTANCE.free(object, context);
		}
	}
}
