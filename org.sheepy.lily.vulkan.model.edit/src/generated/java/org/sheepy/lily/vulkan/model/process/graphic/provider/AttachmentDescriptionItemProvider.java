/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttachmentDescriptionItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttachmentDescriptionItemProvider(AdapterFactory adapterFactory)
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
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addSamplesPropertyDescriptor(object);
			addLoadOpPropertyDescriptor(object);
			addStoreOpPropertyDescriptor(object);
			addStencilLoadOpPropertyDescriptor(object);
			addStencilStoreOpPropertyDescriptor(object);
			addInitialLayoutPropertyDescriptor(object);
			addFinalLayoutPropertyDescriptor(object);
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
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_LNamedElement_name_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_LNamedElement_name_feature",
						"_UI_LNamedElement_type"),
				TypesPackage.Literals.LNAMED_ELEMENT__NAME, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Samples feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSamplesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_AttachmentDescription_samples_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_AttachmentDescription_samples_feature",
						"_UI_AttachmentDescription_type"),
				GraphicPackage.Literals.ATTACHMENT_DESCRIPTION__SAMPLES, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Load Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLoadOpPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_AttachmentDescription_loadOp_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_AttachmentDescription_loadOp_feature",
						"_UI_AttachmentDescription_type"),
				GraphicPackage.Literals.ATTACHMENT_DESCRIPTION__LOAD_OP, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Store Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStoreOpPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_AttachmentDescription_storeOp_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_AttachmentDescription_storeOp_feature",
						"_UI_AttachmentDescription_type"),
				GraphicPackage.Literals.ATTACHMENT_DESCRIPTION__STORE_OP, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Stencil Load Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStencilLoadOpPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_AttachmentDescription_stencilLoadOp_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_AttachmentDescription_stencilLoadOp_feature",
						"_UI_AttachmentDescription_type"),
				GraphicPackage.Literals.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Stencil Store Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStencilStoreOpPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_AttachmentDescription_stencilStoreOp_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_AttachmentDescription_stencilStoreOp_feature",
						"_UI_AttachmentDescription_type"),
				GraphicPackage.Literals.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Initial Layout feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialLayoutPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_AttachmentDescription_initialLayout_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_AttachmentDescription_initialLayout_feature",
						"_UI_AttachmentDescription_type"),
				GraphicPackage.Literals.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Final Layout feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFinalLayoutPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_AttachmentDescription_finalLayout_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_AttachmentDescription_finalLayout_feature",
						"_UI_AttachmentDescription_type"),
				GraphicPackage.Literals.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
		String label = ((AttachmentDescription) object).getName();
		return label == null || label.length() == 0
				? getString("_UI_AttachmentDescription_type")
				: getString("_UI_AttachmentDescription_type") + " " + label;
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

		switch (notification.getFeatureID(AttachmentDescription.class))
		{
		case GraphicPackage.ATTACHMENT_DESCRIPTION__NAME:
		case GraphicPackage.ATTACHMENT_DESCRIPTION__SAMPLES:
		case GraphicPackage.ATTACHMENT_DESCRIPTION__LOAD_OP:
		case GraphicPackage.ATTACHMENT_DESCRIPTION__STORE_OP:
		case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP:
		case GraphicPackage.ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP:
		case GraphicPackage.ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT:
		case GraphicPackage.ATTACHMENT_DESCRIPTION__FINAL_LAYOUT:
			fireNotifyChanged(
					new ViewerNotification(notification, notification.getNotifier(), false, true));
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
		return ((IChildCreationExtender) adapterFactory).getResourceLocator();
	}

}
