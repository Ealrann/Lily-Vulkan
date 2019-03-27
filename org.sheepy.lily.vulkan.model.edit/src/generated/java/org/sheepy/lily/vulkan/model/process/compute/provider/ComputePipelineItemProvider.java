/**
 */
package org.sheepy.lily.vulkan.model.process.compute.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.provider.AbstractPipelineItemProvider;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputePipelineItemProvider extends AbstractPipelineItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputePipelineItemProvider(AdapterFactory adapterFactory)
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

			addWorkgroupSizeXPropertyDescriptor(object);
			addWorkgroupSizeYPropertyDescriptor(object);
			addWorkgroupSizeZPropertyDescriptor(object);
			addWidthPropertyDescriptor(object);
			addHeightPropertyDescriptor(object);
			addDepthPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Workgroup Size X feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWorkgroupSizeXPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ComputePipeline_workgroupSizeX_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ComputePipeline_workgroupSizeX_feature", "_UI_ComputePipeline_type"),
				ComputePackage.Literals.COMPUTE_PIPELINE__WORKGROUP_SIZE_X, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Workgroup Size Y feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWorkgroupSizeYPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ComputePipeline_workgroupSizeY_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ComputePipeline_workgroupSizeY_feature", "_UI_ComputePipeline_type"),
				ComputePackage.Literals.COMPUTE_PIPELINE__WORKGROUP_SIZE_Y, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Workgroup Size Z feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWorkgroupSizeZPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ComputePipeline_workgroupSizeZ_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ComputePipeline_workgroupSizeZ_feature", "_UI_ComputePipeline_type"),
				ComputePackage.Literals.COMPUTE_PIPELINE__WORKGROUP_SIZE_Z, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Width feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWidthPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ComputePipeline_width_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ComputePipeline_width_feature",
						"_UI_ComputePipeline_type"),
				ComputePackage.Literals.COMPUTE_PIPELINE__WIDTH, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Height feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHeightPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ComputePipeline_height_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ComputePipeline_height_feature", "_UI_ComputePipeline_type"),
				ComputePackage.Literals.COMPUTE_PIPELINE__HEIGHT, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Depth feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDepthPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_ComputePipeline_depth_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ComputePipeline_depth_feature",
						"_UI_ComputePipeline_type"),
				ComputePackage.Literals.COMPUTE_PIPELINE__DEPTH, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns ComputePipeline.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ComputePipeline"));
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
		String label = ((ComputePipeline) object).getName();
		return label == null || label.length() == 0
				? getString("_UI_ComputePipeline_type")
				: getString("_UI_ComputePipeline_type") + " " + label;
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

		switch (notification.getFeatureID(ComputePipeline.class))
		{
		case ComputePackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_X:
		case ComputePackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Y:
		case ComputePackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Z:
		case ComputePackage.COMPUTE_PIPELINE__WIDTH:
		case ComputePackage.COMPUTE_PIPELINE__HEIGHT:
		case ComputePackage.COMPUTE_PIPELINE__DEPTH:
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

		newChildDescriptors
				.add(createChildParameter(ProcessPackage.Literals.ABSTRACT_PIPELINE__UNITS,
						ComputeFactory.eINSTANCE.createComputer()));
	}

}
