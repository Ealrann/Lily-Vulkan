/**
 */
package org.sheepy.lily.vulkan.model.process.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.process.AbstractProcess} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractProcessItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcessItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addEnabledPropertyDescriptor(object);
			addQueuePriorityPropertyDescriptor(object);
			addWaitingFenceDuringAcquirePropertyDescriptor(object);
			addResetAllowedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LNamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LNamedElement_name_feature", "_UI_LNamedElement_type"),
				 TypesPackage.Literals.LNAMED_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnabledPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IProcess_enabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IProcess_enabled_feature", "_UI_IProcess_type"),
				 VulkanPackage.Literals.IPROCESS__ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Queue Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueuePriorityPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IProcess_queuePriority_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IProcess_queuePriority_feature", "_UI_IProcess_type"),
				 VulkanPackage.Literals.IPROCESS__QUEUE_PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Waiting Fence During Acquire feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWaitingFenceDuringAcquirePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractProcess_waitingFenceDuringAcquire_feature"),
				 getString("_UI_AbstractProcess_waitingFenceDuringAcquire_description"),
				 ProcessPackage.Literals.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reset Allowed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResetAllowedPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractProcess_resetAllowed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractProcess_resetAllowed_feature", "_UI_AbstractProcess_type"),
				 ProcessPackage.Literals.ABSTRACT_PROCESS__RESET_ALLOWED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
	{
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG);
			childrenFeatures.add(VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG);
			childrenFeatures.add(VulkanPackage.Literals.IPROCESS__CADENCE);
			childrenFeatures.add(ProcessPackage.Literals.ABSTRACT_PROCESS__DESCRIPTOR_POOL);
			childrenFeatures.add(ProcessPackage.Literals.ABSTRACT_PROCESS__EXTENSION_PKG);
			childrenFeatures.add(ProcessPackage.Literals.ABSTRACT_PROCESS__EXECUTION_MANAGER);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child)
	{
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object)
	{
		String label = ((AbstractProcess)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractProcess_type") :
			getString("_UI_AbstractProcess_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(AbstractProcess.class)) {
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
			case ProcessPackage.ABSTRACT_PROCESS__QUEUE_PRIORITY:
			case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG:
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG:
			case ProcessPackage.ABSTRACT_PROCESS__CADENCE:
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_POOL:
			case ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG:
			case ProcessPackage.ABSTRACT_PROCESS__EXECUTION_MANAGER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
				 ResourceFactory.eINSTANCE.createResourcePkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
				 VulkanFactory.eINSTANCE.createDescriptorPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanPackage.Literals.IPROCESS__CADENCE,
				 CadenceFactory.eINSTANCE.createCadence()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanPackage.Literals.IPROCESS__CADENCE,
				 CadenceFactory.eINSTANCE.createGenericCadence()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.ABSTRACT_PROCESS__DESCRIPTOR_POOL,
				 VulkanResourceFactory.eINSTANCE.createDescriptorPool()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.ABSTRACT_PROCESS__EXTENSION_PKG,
				 ProcessFactory.eINSTANCE.createProcessExtensionPkg()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.ABSTRACT_PROCESS__EXECUTION_MANAGER,
				 ComputeFactory.eINSTANCE.createComputeExecutionManager()));

		newChildDescriptors.add
			(createChildParameter
				(ProcessPackage.Literals.ABSTRACT_PROCESS__EXECUTION_MANAGER,
				 GraphicFactory.eINSTANCE.createGraphicExecutionManager()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		return ((IChildCreationExtender)adapterFactory).getResourceLocator();
	}

}
