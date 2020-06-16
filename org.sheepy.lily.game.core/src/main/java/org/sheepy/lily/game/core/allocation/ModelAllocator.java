package org.sheepy.lily.game.core.allocation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.model.ILilyEObject;
import org.sheepy.lily.core.api.notification.util.ModelObserver;
import org.sheepy.lily.core.api.notification.util.NotificationUnifier;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public final class ModelAllocator
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

	public void allocate(final org.sheepy.lily.core.api.allocation.IAllocationContext context)
	{
		for (final var observer : observers)
		{
			observer.startObserve(root);
		}
		started = true;
		for (int i = 0; i < objects.size(); i++)
		{
			final var object = objects.get(i);
			IAllocationService.INSTANCE.ensureAllocation(object, context);
		}
	}

	public void free(final IAllocationContext context)
	{
		freeInternal(context);
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
			final int size = featureList.size();
			final int[] referenceIds = new int[size];
			for (int i = 0; i < size; i++)
			{
				referenceIds[i] = featureList.get(i).getFeatureID();
			}

			res.add(new ModelObserver(listener, referenceIds));
		}
		return res;
	}

	private void freeInternal(final IAllocationContext context)
	{
		while (toFree.isEmpty() == false)
		{
			final var object = toFree.removeLast();
			IAllocationService.INSTANCE.free(object, context);
		}
		for (int i = objects.size() - 1; i >= 0; i--)
		{
			final var object = objects.get(i);
			IAllocationService.INSTANCE.free(object, context);
		}
	}
}
