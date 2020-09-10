/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import org.sheepy.lily.vulkan.extra.model.sprite.SpriteFactory;
import org.sheepy.lily.vulkan.model.process.graphic.provider.GraphicsPipelineItemProvider;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericRendererItemProvider extends GraphicsPipelineItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericRendererItemProvider(AdapterFactory adapterFactory)
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

			addRenderedStructuresPropertyDescriptor(object);
			addConstantBufferPropertyDescriptor(object);
			addTransferBufferPropertyDescriptor(object);
			addFlushTransferBufferTaskPropertyDescriptor(object);
			addOnePipelinePerPartPropertyDescriptor(object);
			addMaintainingPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Rendered Structures feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRenderedStructuresPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRenderer_renderedStructures_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRenderer_renderedStructures_feature", "_UI_GenericRenderer_type"),
				 RenderingPackage.Literals.GENERIC_RENDERER__RENDERED_STRUCTURES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Constant Buffer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConstantBufferPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRenderer_constantBuffer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRenderer_constantBuffer_feature", "_UI_GenericRenderer_type"),
				 RenderingPackage.Literals.GENERIC_RENDERER__CONSTANT_BUFFER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Transfer Buffer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTransferBufferPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRenderer_transferBuffer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRenderer_transferBuffer_feature", "_UI_GenericRenderer_type"),
				 RenderingPackage.Literals.GENERIC_RENDERER__TRANSFER_BUFFER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Flush Transfer Buffer Task feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFlushTransferBufferTaskPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRenderer_flushTransferBufferTask_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRenderer_flushTransferBufferTask_feature", "_UI_GenericRenderer_type"),
				 RenderingPackage.Literals.GENERIC_RENDERER__FLUSH_TRANSFER_BUFFER_TASK,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the One Pipeline Per Part feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOnePipelinePerPartPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRenderer_onePipelinePerPart_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRenderer_onePipelinePerPart_feature", "_UI_GenericRenderer_type"),
				 RenderingPackage.Literals.GENERIC_RENDERER__ONE_PIPELINE_PER_PART,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maintaining feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaintainingPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GenericRenderer_maintaining_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GenericRenderer_maintaining_feature", "_UI_GenericRenderer_type"),
				 RenderingPackage.Literals.GENERIC_RENDERER__MAINTAINING,
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
		if (childrenFeatures == null)
		{
			super.getChildrenFeatures(object);
			childrenFeatures.add(RenderingPackage.Literals.GENERIC_RENDERER__DATA_PROVIDER_PKG);
			childrenFeatures.add(RenderingPackage.Literals.GENERIC_RENDERER__DESCRIPTOR_PROVIDER_PKG);
			childrenFeatures.add(RenderingPackage.Literals.GENERIC_RENDERER__SPECIALIZATION);
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
		String label = ((GenericRenderer<?>)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_GenericRenderer_type") :
			getString("_UI_GenericRenderer_type") + " " + label;
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

		switch (notification.getFeatureID(GenericRenderer.class))
		{
			case RenderingPackage.GENERIC_RENDERER__ONE_PIPELINE_PER_PART:
			case RenderingPackage.GENERIC_RENDERER__MAINTAINING:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG:
			case RenderingPackage.GENERIC_RENDERER__DESCRIPTOR_PROVIDER_PKG:
			case RenderingPackage.GENERIC_RENDERER__SPECIALIZATION:
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
				(RenderingPackage.Literals.GENERIC_RENDERER__DATA_PROVIDER_PKG,
				 RenderingFactory.eINSTANCE.createDataProviderPkg()));

		newChildDescriptors.add
			(createChildParameter
				(RenderingPackage.Literals.GENERIC_RENDERER__DESCRIPTOR_PROVIDER_PKG,
				 RenderingFactory.eINSTANCE.createResourceDescriptorProviderPkg()));

		newChildDescriptors.add
			(createChildParameter
				(RenderingPackage.Literals.GENERIC_RENDERER__SPECIALIZATION,
				 RenderingFactory.eINSTANCE.createISpecialization()));

		newChildDescriptors.add
			(createChildParameter
				(RenderingPackage.Literals.GENERIC_RENDERER__SPECIALIZATION,
				 SpriteFactory.eINSTANCE.createSpriteCountSpecialization()));
	}

}
