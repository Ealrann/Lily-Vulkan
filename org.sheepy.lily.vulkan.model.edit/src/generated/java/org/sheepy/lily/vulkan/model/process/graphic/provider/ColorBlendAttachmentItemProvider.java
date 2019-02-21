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

import org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ColorBlendAttachmentItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorBlendAttachmentItemProvider(AdapterFactory adapterFactory)
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

			addBlendEnablePropertyDescriptor(object);
			addRedComponentEnablePropertyDescriptor(object);
			addGreenComponentEnablePropertyDescriptor(object);
			addBlueComponentEnablePropertyDescriptor(object);
			addAlphaComponentEnablePropertyDescriptor(object);
			addSrcColorPropertyDescriptor(object);
			addDstColorPropertyDescriptor(object);
			addSrcAlphaPropertyDescriptor(object);
			addDstAlphaPropertyDescriptor(object);
			addColorBlendOpPropertyDescriptor(object);
			addAlphaBlendOpPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Blend Enable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBlendEnablePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ColorBlendAttachment_blendEnable_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_blendEnable_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__BLEND_ENABLE, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Red Component Enable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRedComponentEnablePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ColorBlendAttachment_redComponentEnable_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_redComponentEnable_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE, true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Green Component Enable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGreenComponentEnablePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ColorBlendAttachment_greenComponentEnable_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_greenComponentEnable_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE, true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Blue Component Enable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBlueComponentEnablePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ColorBlendAttachment_blueComponentEnable_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_blueComponentEnable_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE, true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Alpha Component Enable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlphaComponentEnablePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ColorBlendAttachment_alphaComponentEnable_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_alphaComponentEnable_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE, true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Src Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSrcColorPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ColorBlendAttachment_srcColor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_srcColor_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__SRC_COLOR, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Dst Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDstColorPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ColorBlendAttachment_dstColor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_dstColor_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__DST_COLOR, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Src Alpha feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSrcAlphaPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ColorBlendAttachment_srcAlpha_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_srcAlpha_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__SRC_ALPHA, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Dst Alpha feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDstAlphaPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ColorBlendAttachment_dstAlpha_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_dstAlpha_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__DST_ALPHA, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Color Blend Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColorBlendOpPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ColorBlendAttachment_colorBlendOp_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_colorBlendOp_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Alpha Blend Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlphaBlendOpPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ColorBlendAttachment_alphaBlendOp_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ColorBlendAttachment_alphaBlendOp_feature",
						"_UI_ColorBlendAttachment_type"),
				GraphicPackage.Literals.COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns ColorBlendAttachment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/ColorBlendAttachment"));
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
		ColorBlendAttachment colorBlendAttachment = (ColorBlendAttachment) object;
		return getString("_UI_ColorBlendAttachment_type")
				+ " "
				+ colorBlendAttachment.isBlendEnable();
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

		switch (notification.getFeatureID(ColorBlendAttachment.class))
		{
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__BLEND_ENABLE:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__SRC_COLOR:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__DST_COLOR:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__SRC_ALPHA:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__DST_ALPHA:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP:
		case GraphicPackage.COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP:
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
