/**
 */
package org.sheepy.vulkan.model.process.graphic.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sheepy.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;

import org.sheepy.vulkan.model.process.provider.AbstractPipelineItemProvider;

/**
 * This is the item provider adapter for a {@link org.sheepy.vulkan.model.process.graphic.ImagePipeline} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ImagePipelineItemProvider extends AbstractPipelineItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImagePipelineItemProvider(AdapterFactory adapterFactory)
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

			addImagePropertyDescriptor(object);
			addImageSrcStagePropertyDescriptor(object);
			addImageDstStagePropertyDescriptor(object);
			addImageSrcAccessPropertyDescriptor(object);
			addImageDstAccessPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Image feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ImagePipeline_image_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ImagePipeline_image_feature", "_UI_ImagePipeline_type"),
				 GraphicPackage.Literals.IMAGE_PIPELINE__IMAGE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Image Src Stage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImageSrcStagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ImagePipeline_imageSrcStage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ImagePipeline_imageSrcStage_feature", "_UI_ImagePipeline_type"),
				 GraphicPackage.Literals.IMAGE_PIPELINE__IMAGE_SRC_STAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Image Dst Stage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImageDstStagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ImagePipeline_imageDstStage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ImagePipeline_imageDstStage_feature", "_UI_ImagePipeline_type"),
				 GraphicPackage.Literals.IMAGE_PIPELINE__IMAGE_DST_STAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Image Src Access feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImageSrcAccessPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ImagePipeline_imageSrcAccess_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ImagePipeline_imageSrcAccess_feature", "_UI_ImagePipeline_type"),
				 GraphicPackage.Literals.IMAGE_PIPELINE__IMAGE_SRC_ACCESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Image Dst Access feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImageDstAccessPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ImagePipeline_imageDstAccess_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ImagePipeline_imageDstAccess_feature", "_UI_ImagePipeline_type"),
				 GraphicPackage.Literals.IMAGE_PIPELINE__IMAGE_DST_ACCESS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns ImagePipeline.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ImagePipeline"));
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
		String label = ((ImagePipeline)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ImagePipeline_type") :
			getString("_UI_ImagePipeline_type") + " " + label;
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

		switch (notification.getFeatureID(ImagePipeline.class))
		{
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_STAGE:
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_STAGE:
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_SRC_ACCESS:
			case GraphicPackage.IMAGE_PIPELINE__IMAGE_DST_ACCESS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
				(ProcessPackage.Literals.ABSTRACT_PIPELINE__UNITS,
				 GraphicFactory.eINSTANCE.createPipelineImageBarrier()));
	}

}
