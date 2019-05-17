/**
 */
package org.sheepy.vulkan.model.barrier.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.barrier.ReferenceImageBarrier;

import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * This is the item provider adapter for a {@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceImageBarrierItemProvider extends AbstractImageBarrierItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceImageBarrierItemProvider(AdapterFactory adapterFactory)
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

			addImagePtrPropertyDescriptor(object);
			addMipLevelsPropertyDescriptor(object);
			addImageFormatPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Image Ptr feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImagePtrPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ReferenceImageBarrier_imagePtr_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ReferenceImageBarrier_imagePtr_feature",
						"_UI_ReferenceImageBarrier_type"),
				BarrierPackage.Literals.REFERENCE_IMAGE_BARRIER__IMAGE_PTR, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Mip Levels feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMipLevelsPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ReferenceImageBarrier_mipLevels_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ReferenceImageBarrier_mipLevels_feature",
						"_UI_ReferenceImageBarrier_type"),
				BarrierPackage.Literals.REFERENCE_IMAGE_BARRIER__MIP_LEVELS, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Image Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImageFormatPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ReferenceImageBarrier_imageFormat_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ReferenceImageBarrier_imageFormat_feature",
						"_UI_ReferenceImageBarrier_type"),
				BarrierPackage.Literals.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns ReferenceImageBarrier.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/ReferenceImageBarrier"));
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
		EImageLayout labelValue = ((ReferenceImageBarrier) object).getSrcLayout();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0
				? getString("_UI_ReferenceImageBarrier_type")
				: getString("_UI_ReferenceImageBarrier_type") + " " + label;
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

		switch (notification.getFeatureID(ReferenceImageBarrier.class))
		{
		case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_PTR:
		case BarrierPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
		case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
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

}
