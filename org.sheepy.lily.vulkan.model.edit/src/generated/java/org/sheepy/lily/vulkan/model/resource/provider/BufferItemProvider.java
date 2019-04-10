/**
 */
package org.sheepy.lily.vulkan.model.resource.provider;

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
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.resource.Buffer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BufferItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferItemProvider(AdapterFactory adapterFactory)
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

			addDescriptorTypePropertyDescriptor(object);
			addShaderStagesPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addSizePropertyDescriptor(object);
			addUsagesPropertyDescriptor(object);
			addDataPropertyDescriptor(object);
			addOftenUpdatedPropertyDescriptor(object);
			addGpuBufferPropertyDescriptor(object);
			addInstanceCountPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Descriptor Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptorTypePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_IDescriptor_descriptorType_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_IDescriptor_descriptorType_feature", "_UI_IDescriptor_type"),
				ResourcePackage.Literals.IDESCRIPTOR__DESCRIPTOR_TYPE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Shader Stages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addShaderStagesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_IDescriptor_shaderStages_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_IDescriptor_shaderStages_feature", "_UI_IDescriptor_type"),
				ResourcePackage.Literals.IDESCRIPTOR__SHADER_STAGES, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
	 * This adds a property descriptor for the Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSizePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_Buffer_size_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Buffer_size_feature",
						"_UI_Buffer_type"),
				ResourcePackage.Literals.BUFFER__SIZE, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Usages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsagesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_Buffer_usages_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Buffer_usages_feature",
						"_UI_Buffer_type"),
				ResourcePackage.Literals.BUFFER__USAGES, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Data feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_Buffer_data_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Buffer_data_feature",
						"_UI_Buffer_type"),
				ResourcePackage.Literals.BUFFER__DATA, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Often Updated feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOftenUpdatedPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_Buffer_oftenUpdated_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Buffer_oftenUpdated_feature",
						"_UI_Buffer_type"),
				ResourcePackage.Literals.BUFFER__OFTEN_UPDATED, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Gpu Buffer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGpuBufferPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_Buffer_gpuBuffer_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Buffer_gpuBuffer_feature",
						"_UI_Buffer_type"),
				ResourcePackage.Literals.BUFFER__GPU_BUFFER, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Instance Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInstanceCountPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(), getString("_UI_Buffer_instanceCount_feature"),
				getString("_UI_Buffer_instanceCount_description"),
				ResourcePackage.Literals.BUFFER__INSTANCE_COUNT, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns Buffer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Buffer"));
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
		String label = ((Buffer) object).getName();
		return label == null || label.length() == 0
				? getString("_UI_Buffer_type")
				: getString("_UI_Buffer_type") + " " + label;
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

		switch (notification.getFeatureID(Buffer.class))
		{
		case ResourcePackage.BUFFER__DESCRIPTOR_TYPE:
		case ResourcePackage.BUFFER__SHADER_STAGES:
		case ResourcePackage.BUFFER__NAME:
		case ResourcePackage.BUFFER__SIZE:
		case ResourcePackage.BUFFER__USAGES:
		case ResourcePackage.BUFFER__DATA:
		case ResourcePackage.BUFFER__OFTEN_UPDATED:
		case ResourcePackage.BUFFER__GPU_BUFFER:
		case ResourcePackage.BUFFER__INSTANCE_COUNT:
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
