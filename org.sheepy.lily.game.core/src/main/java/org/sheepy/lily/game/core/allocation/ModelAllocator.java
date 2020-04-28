package org.sheepy.lily.game.core.allocation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.up.IAllocationContext;
import org.sheepy.lily.core.api.allocation.up.IAllocationManager;
import org.sheepy.lily.core.api.notification.util.ModelObserver;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public final class ModelAllocator implements IAllocable<org.sheepy.lily.core.api.allocation.IAllocationContext>
{
	private final ILilyEObject root;
	private final List<ModelObserver> observers;
	private final List<ILilyEObject> objects = new ArrayList<>();
	private final Deque<ILilyEObject> toFree = new ArrayDeque<>();

	private boolean started = false;

	public ModelAllocator(ILilyEObject root, final List<List<EReference>> featureLists)
	{
		this.root = root;
		observers = List.copyOf(buildObservers(featureLists, this::resourceChanged));
	}

	@Override
	public void allocate(final org.sheepy.lily.core.api.allocation.IAllocationContext context)
	{
		for (final var observer : observers)
		{
			observer.startObserve(root);
		}
		started = true;
		update(context);
	}

	@Override
	public void free(final org.sheepy.lily.core.api.allocation.IAllocationContext context)
	{
		free((IAllocationContext) context);
		started = false;
		for (final var observer : observers)
		{
			observer.stopObserve(root);
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

	public void update(final org.sheepy.lily.core.api.allocation.IAllocationContext _context)
	{
		final var context = (IAllocationContext) _context;
		while (toFree.isEmpty() == false)
		{
			final var object = toFree.removeLast();
			object.adapt(IAllocationManager.class).free(context);
		}
		for (var object : objects)
		{
			object.adapt(IAllocationManager.class).maintains(context);
		}
	}

	private void free(final IAllocationContext context)
	{
		while (toFree.isEmpty() == false)
		{
			final var object = toFree.removeLast();
			object.adapt(IAllocationManager.class).free(context);
		}
		for (int i = objects.size() - 1; i >= 0; i--)
		{
			final var object = objects.get(i);
			object.adapt(IAllocationManager.class).free(context);
		}
	}
}
