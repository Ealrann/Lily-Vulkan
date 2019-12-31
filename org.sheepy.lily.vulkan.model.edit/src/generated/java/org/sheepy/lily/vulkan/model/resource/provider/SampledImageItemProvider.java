/**
 */
package org.sheepy.lily.vulkan.model.resource.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sheepy.lily.core.model.application.provider.IResourceItemProvider;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.vulkan.model.image.ImageFactory;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.resource.SampledImage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SampledImageItemProvider extends IResourceItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampledImageItemProvider(AdapterFactory adapterFactory)
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(ResourcePackage.Literals.SAMPLED_IMAGE__SAMPLER);
			childrenFeatures.add(ResourcePackage.Literals.SAMPLED_IMAGE__IMAGE);
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
	 * This returns SampledImage.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SampledImage"));
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
		String label = ((SampledImage)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_SampledImage_type") :
			getString("_UI_SampledImage_type") + " " + label;
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

		switch (notification.getFeatureID(SampledImage.class))
		{
			case ResourcePackage.SAMPLED_IMAGE__SAMPLER:
			case ResourcePackage.SAMPLED_IMAGE__IMAGE:
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
				(ResourcePackage.Literals.SAMPLED_IMAGE__SAMPLER,
				 ResourceFactory.eINSTANCE.createSampler()));

		newChildDescriptors.add
			(createChildParameter
				(ResourcePackage.Literals.SAMPLED_IMAGE__SAMPLER,
				 ImageFactory.eINSTANCE.createSamplerInfo()));

		newChildDescriptors.add
			(createChildParameter
				(ResourcePackage.Literals.SAMPLED_IMAGE__IMAGE,
				 ResourceFactory.eINSTANCE.createStaticImage()));

		newChildDescriptors.add
			(createChildParameter
				(ResourcePackage.Literals.SAMPLED_IMAGE__IMAGE,
				 ResourceFactory.eINSTANCE.createFileImage()));

		newChildDescriptors.add
			(createChildParameter
				(ResourcePackage.Literals.SAMPLED_IMAGE__IMAGE,
				 ResourceFactory.eINSTANCE.createFontImage()));

		newChildDescriptors.add
			(createChildParameter
				(ResourcePackage.Literals.SAMPLED_IMAGE__IMAGE,
				 ResourceFactory.eINSTANCE.createITextureArray()));

		newChildDescriptors.add
			(createChildParameter
				(ResourcePackage.Literals.SAMPLED_IMAGE__IMAGE,
				 ResourceFactory.eINSTANCE.createTexture2DArray()));
	}

}
