/**
 */
package org.sheepy.vulkan.model.graphicpipeline.provider;


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

import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;

/**
 * This is the item provider adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DepthStencilStateItemProvider 
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
	public DepthStencilStateItemProvider(AdapterFactory adapterFactory)
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

			addDepthTestPropertyDescriptor(object);
			addDepthWritePropertyDescriptor(object);
			addDepthBoundTestPropertyDescriptor(object);
			addStencilTestPropertyDescriptor(object);
			addDepthCompareOpPropertyDescriptor(object);
			addMinDepthBoundsPropertyDescriptor(object);
			addMaxDepthBoundsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Depth Test feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDepthTestPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DepthStencilState_depthTest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DepthStencilState_depthTest_feature", "_UI_DepthStencilState_type"),
				 GraphicpipelinePackage.Literals.DEPTH_STENCIL_STATE__DEPTH_TEST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Depth Write feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDepthWritePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DepthStencilState_depthWrite_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DepthStencilState_depthWrite_feature", "_UI_DepthStencilState_type"),
				 GraphicpipelinePackage.Literals.DEPTH_STENCIL_STATE__DEPTH_WRITE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Depth Bound Test feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDepthBoundTestPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DepthStencilState_depthBoundTest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DepthStencilState_depthBoundTest_feature", "_UI_DepthStencilState_type"),
				 GraphicpipelinePackage.Literals.DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stencil Test feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStencilTestPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DepthStencilState_stencilTest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DepthStencilState_stencilTest_feature", "_UI_DepthStencilState_type"),
				 GraphicpipelinePackage.Literals.DEPTH_STENCIL_STATE__STENCIL_TEST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Depth Compare Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDepthCompareOpPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DepthStencilState_depthCompareOp_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DepthStencilState_depthCompareOp_feature", "_UI_DepthStencilState_type"),
				 GraphicpipelinePackage.Literals.DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min Depth Bounds feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinDepthBoundsPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DepthStencilState_minDepthBounds_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DepthStencilState_minDepthBounds_feature", "_UI_DepthStencilState_type"),
				 GraphicpipelinePackage.Literals.DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Depth Bounds feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxDepthBoundsPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DepthStencilState_maxDepthBounds_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DepthStencilState_maxDepthBounds_feature", "_UI_DepthStencilState_type"),
				 GraphicpipelinePackage.Literals.DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns DepthStencilState.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DepthStencilState"));
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
		DepthStencilState depthStencilState = (DepthStencilState)object;
		return getString("_UI_DepthStencilState_type") + " " + depthStencilState.isDepthTest();
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

		switch (notification.getFeatureID(DepthStencilState.class))
		{
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_TEST:
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_WRITE:
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST:
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__STENCIL_TEST:
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP:
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS:
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS:
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
