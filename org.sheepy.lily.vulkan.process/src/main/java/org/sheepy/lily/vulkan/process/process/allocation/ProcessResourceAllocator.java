package org.sheepy.lily.vulkan.process.process.allocation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.util.ModelObserver;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.execution.IExecutionContext;

public class ProcessResourceAllocator
{
	private static final List<EStructuralFeature> RESOURCE_FEATURES = List.of(	VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																				ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EStructuralFeature> PIPELINE_RESOURCE_FEATURES = List.of(	ProcessPackage.Literals.ABSTRACT_PROCESS__PART_PKG,
																						ProcessPackage.Literals.PROCESS_PART_PKG__PARTS,
																						VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
																						ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EStructuralFeature> DESCRIPTOR_FEATURES = List.of(VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																				VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);
	private static final List<EStructuralFeature> PIPELINE_DESCRIPTOR_FEATURES = List.of(	ProcessPackage.Literals.ABSTRACT_PROCESS__PART_PKG,
																							ProcessPackage.Literals.PROCESS_PART_PKG__PARTS,
																							VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
																							VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);

	private final ModelObserver RESOURCE_OBSERVER = new ModelObserver(	this::resourceChanged,
																		RESOURCE_FEATURES);
	private final ModelObserver PIPELINE_RESOURCE_OBSERVER = new ModelObserver(	this::resourceChanged,
																				PIPELINE_RESOURCE_FEATURES);
	private final ModelObserver DESCRIPTOR_OBSERVER = new ModelObserver(this::resourceChanged,
																		DESCRIPTOR_FEATURES);
	private final ModelObserver PIPELINE_DESCRIPTOR_OBSERVER = new ModelObserver(	this::resourceChanged,
																					PIPELINE_DESCRIPTOR_FEATURES);
	private final AbstractProcess process;

	private final AllocableContainer<IExecutionContext> container = new AllocableContainer<>();

	public ProcessResourceAllocator(AbstractProcess process)
	{
		this.process = process;
	}

	public void start()
	{
		RESOURCE_OBSERVER.startObserve(process);
		PIPELINE_RESOURCE_OBSERVER.startObserve(process);
		DESCRIPTOR_OBSERVER.startObserve(process);
		PIPELINE_DESCRIPTOR_OBSERVER.startObserve(process);
	}

	public void stop()
	{
		RESOURCE_OBSERVER.stopObserve(process);
		PIPELINE_RESOURCE_OBSERVER.stopObserve(process);
		DESCRIPTOR_OBSERVER.stopObserve(process);
		PIPELINE_DESCRIPTOR_OBSERVER.stopObserve(process);
	}

	@SuppressWarnings("unchecked")
	private void resourceChanged(Notification notification)
	{
		switch (notification.getEventType())
		{
		case Notification.ADD:
			final var newResource = (ILilyEObject) notification.getNewValue();
			add(List.of(newResource));
			break;
		case Notification.ADD_MANY:
			final var newResources = (List<ILilyEObject>) notification.getNewValue();
			add(newResources);
			break;
		case Notification.REMOVE:
			final var oldResource = (ILilyEObject) notification.getOldValue();
			remove(List.of(oldResource));
			break;
		case Notification.REMOVE_MANY:
			final var oldResources = (List<ILilyEObject>) notification.getOldValue();
			remove(oldResources);
			break;
		default:
			System.err.println(this.getClass().getSimpleName() + " resourceChanged");
			break;
		}
	}

	private void add(List<ILilyEObject> newChildren)
	{
		final List<IAllocable<IExecutionContext>> res = new ArrayList<>();
		for (final var resource : newChildren)
		{
			final var adapter = resource.<IAllocableAdapter<IExecutionContext>> adaptGeneric(IAllocableAdapter.class);
			if (adapter != null)
			{
				res.add(adapter);
			}
		}

		container.addChildren(res);
	}

	private void remove(List<ILilyEObject> oldChildren)
	{
		final List<IAllocable<IExecutionContext>> res = new ArrayList<>();
		for (final var resource : oldChildren)
		{
			final var adapter = resource.<IAllocableAdapter<IExecutionContext>> adaptGeneric(IAllocableAdapter.class);
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
