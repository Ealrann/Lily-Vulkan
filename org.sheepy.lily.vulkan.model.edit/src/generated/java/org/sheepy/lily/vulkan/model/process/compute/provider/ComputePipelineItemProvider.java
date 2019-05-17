/**
 */
package org.sheepy.lily.vulkan.model.process.compute.provider;

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
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.pipeline.PipelineFactory;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputePipelineItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
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

			addNamePropertyDescriptor(object);
			addEnabledPropertyDescriptor(object);
			addStagePropertyDescriptor(object);
			addDescriptorSetRefPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnabledPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_IPipeline_enabled_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_IPipeline_enabled_feature",
						"_UI_IPipeline_type"),
				ProcessPackage.Literals.IPIPELINE__ENABLED, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Stage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_IPipeline_stage_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_IPipeline_stage_feature",
						"_UI_IPipeline_type"),
				ProcessPackage.Literals.IPIPELINE__STAGE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Descriptor Set Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptorSetRefPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_IPipeline_descriptorSetRef_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_IPipeline_descriptorSetRef_feature", "_UI_IPipeline_type"),
				ProcessPackage.Literals.IPIPELINE__DESCRIPTOR_SET_REF, true, false, true, null,
				null, null));
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
			childrenFeatures.add(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG);
			childrenFeatures.add(ProcessPackage.Literals.IPIPELINE__PUSH_CONSTANT_RANGES);
			childrenFeatures.add(ProcessPackage.Literals.IPIPELINE__DESCRIPTOR_SET);
			childrenFeatures.add(ProcessPackage.Literals.IPIPELINE__TASK_PKG);
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
		case ComputePackage.COMPUTE_PIPELINE__NAME:
		case ComputePackage.COMPUTE_PIPELINE__ENABLED:
		case ComputePackage.COMPUTE_PIPELINE__STAGE:
		case ComputePackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_X:
		case ComputePackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Y:
		case ComputePackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Z:
		case ComputePackage.COMPUTE_PIPELINE__WIDTH:
		case ComputePackage.COMPUTE_PIPELINE__HEIGHT:
		case ComputePackage.COMPUTE_PIPELINE__DEPTH:
			fireNotifyChanged(
					new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ComputePackage.COMPUTE_PIPELINE__RESOURCE_PKG:
		case ComputePackage.COMPUTE_PIPELINE__PUSH_CONSTANT_RANGES:
		case ComputePackage.COMPUTE_PIPELINE__DESCRIPTOR_SET:
		case ComputePackage.COMPUTE_PIPELINE__TASK_PKG:
			fireNotifyChanged(
					new ViewerNotification(notification, notification.getNotifier(), true, false));
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
				.add(createChildParameter(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
						VulkanFactory.eINSTANCE.createResourcePkg()));

		newChildDescriptors
				.add(createChildParameter(ProcessPackage.Literals.IPIPELINE__PUSH_CONSTANT_RANGES,
						PipelineFactory.eINSTANCE.createPushConstantRange()));

		newChildDescriptors
				.add(createChildParameter(ProcessPackage.Literals.IPIPELINE__DESCRIPTOR_SET,
						ResourceFactory.eINSTANCE.createDescriptorSet()));

		newChildDescriptors.add(createChildParameter(ProcessPackage.Literals.IPIPELINE__TASK_PKG,
				ProcessFactory.eINSTANCE.createTaskPkg()));
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
