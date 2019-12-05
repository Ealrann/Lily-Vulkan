/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.provider;


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

import org.sheepy.lily.core.model.presentation.PresentationPackage;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.variable.VariableFactory;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SelectorPanelItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectorPanelItemProvider(AdapterFactory adapterFactory)
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
			addPositionPropertyDescriptor(object);
			addVerticalRelativePropertyDescriptor(object);
			addHorizontalRelativePropertyDescriptor(object);
			addButtonSizePxPropertyDescriptor(object);
			addSelectionRPropertyDescriptor(object);
			addSelectionGPropertyDescriptor(object);
			addSelectionBPropertyDescriptor(object);
			addPrintLabelsPropertyDescriptor(object);
			addVerticalPropertyDescriptor(object);
			addAutoHideLabelsPropertyDescriptor(object);
			addFadeOutMsPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Position feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPositionPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IPositionElement_position_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IPositionElement_position_feature", "_UI_IPositionElement_type"),
				 PresentationPackage.Literals.IPOSITION_ELEMENT__POSITION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vertical Relative feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVerticalRelativePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IPositionElement_verticalRelative_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IPositionElement_verticalRelative_feature", "_UI_IPositionElement_type"),
				 PresentationPackage.Literals.IPOSITION_ELEMENT__VERTICAL_RELATIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Horizontal Relative feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHorizontalRelativePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IPositionElement_horizontalRelative_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IPositionElement_horizontalRelative_feature", "_UI_IPositionElement_type"),
				 PresentationPackage.Literals.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Button Size Px feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addButtonSizePxPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SelectorPanel_buttonSizePx_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SelectorPanel_buttonSizePx_feature", "_UI_SelectorPanel_type"),
				 NuklearPackage.Literals.SELECTOR_PANEL__BUTTON_SIZE_PX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Selection R feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectionRPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SelectorPanel_selectionR_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SelectorPanel_selectionR_feature", "_UI_SelectorPanel_type"),
				 NuklearPackage.Literals.SELECTOR_PANEL__SELECTION_R,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_SelectionColorPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Selection G feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectionGPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SelectorPanel_selectionG_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SelectorPanel_selectionG_feature", "_UI_SelectorPanel_type"),
				 NuklearPackage.Literals.SELECTOR_PANEL__SELECTION_G,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_SelectionColorPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Selection B feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectionBPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SelectorPanel_selectionB_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SelectorPanel_selectionB_feature", "_UI_SelectorPanel_type"),
				 NuklearPackage.Literals.SELECTOR_PANEL__SELECTION_B,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 getString("_UI_SelectionColorPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Print Labels feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPrintLabelsPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SelectorPanel_printLabels_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SelectorPanel_printLabels_feature", "_UI_SelectorPanel_type"),
				 NuklearPackage.Literals.SELECTOR_PANEL__PRINT_LABELS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vertical feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVerticalPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SelectorPanel_vertical_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SelectorPanel_vertical_feature", "_UI_SelectorPanel_type"),
				 NuklearPackage.Literals.SELECTOR_PANEL__VERTICAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Auto Hide Labels feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAutoHideLabelsPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SelectorPanel_autoHideLabels_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SelectorPanel_autoHideLabels_feature", "_UI_SelectorPanel_type"),
				 NuklearPackage.Literals.SELECTOR_PANEL__AUTO_HIDE_LABELS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fade Out Ms feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFadeOutMsPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SelectorPanel_fadeOutMs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SelectorPanel_fadeOutMs_feature", "_UI_SelectorPanel_type"),
				 NuklearPackage.Literals.SELECTOR_PANEL__FADE_OUT_MS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
		if (childrenFeatures == null)
		{
			super.getChildrenFeatures(object);
			childrenFeatures.add(NuklearPackage.Literals.SELECTOR_PANEL__VARIABLE_RESOLVER);
			childrenFeatures.add(NuklearPackage.Literals.SELECTOR_PANEL__INPUT_PROVIDER);
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
	 * This returns SelectorPanel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SelectorPanel"));
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
		String label = ((SelectorPanel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SelectorPanel_type") :
			getString("_UI_SelectorPanel_type") + " " + label;
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

		switch (notification.getFeatureID(SelectorPanel.class))
		{
			case NuklearPackage.SELECTOR_PANEL__NAME:
			case NuklearPackage.SELECTOR_PANEL__POSITION:
			case NuklearPackage.SELECTOR_PANEL__VERTICAL_RELATIVE:
			case NuklearPackage.SELECTOR_PANEL__HORIZONTAL_RELATIVE:
			case NuklearPackage.SELECTOR_PANEL__BUTTON_SIZE_PX:
			case NuklearPackage.SELECTOR_PANEL__SELECTION_R:
			case NuklearPackage.SELECTOR_PANEL__SELECTION_G:
			case NuklearPackage.SELECTOR_PANEL__SELECTION_B:
			case NuklearPackage.SELECTOR_PANEL__PRINT_LABELS:
			case NuklearPackage.SELECTOR_PANEL__VERTICAL:
			case NuklearPackage.SELECTOR_PANEL__AUTO_HIDE_LABELS:
			case NuklearPackage.SELECTOR_PANEL__FADE_OUT_MS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER:
			case NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER:
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
				(NuklearPackage.Literals.SELECTOR_PANEL__VARIABLE_RESOLVER,
				 VariableFactory.eINSTANCE.createDirectVariableResolver()));
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
