/**
 */
package org.sheepy.vulkan.model.image.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.sheepy.vulkan.model.barrier.provider.VulkanEditPlugin;

import org.sheepy.vulkan.model.enumeration.EFilter;

import org.sheepy.vulkan.model.image.ImagePackage;
import org.sheepy.vulkan.model.image.SamplerInfo;

/**
 * This is the item provider adapter for a {@link org.sheepy.vulkan.model.image.SamplerInfo} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SamplerInfoItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SamplerInfoItemProvider(AdapterFactory adapterFactory)
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

			addMinFilterPropertyDescriptor(object);
			addMagFilterPropertyDescriptor(object);
			addMipmapModePropertyDescriptor(object);
			addAddressModePropertyDescriptor(object);
			addBorderColorPropertyDescriptor(object);
			addAnisotropyEnabledPropertyDescriptor(object);
			addUnnormalizedCoordinatesPropertyDescriptor(object);
			addCompareEnablePropertyDescriptor(object);
			addLodBiasPropertyDescriptor(object);
			addMinLodPropertyDescriptor(object);
			addMaxLodPropertyDescriptor(object);
			addMaxAnisotropyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Min Filter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinFilterPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_minFilter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_minFilter_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__MIN_FILTER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mag Filter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMagFilterPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_magFilter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_magFilter_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__MAG_FILTER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mipmap Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMipmapModePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_mipmapMode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_mipmapMode_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__MIPMAP_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Address Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAddressModePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_addressMode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_addressMode_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__ADDRESS_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Border Color feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBorderColorPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_borderColor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_borderColor_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__BORDER_COLOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Anisotropy Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnisotropyEnabledPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_anisotropyEnabled_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_anisotropyEnabled_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__ANISOTROPY_ENABLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unnormalized Coordinates feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUnnormalizedCoordinatesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_unnormalizedCoordinates_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_unnormalizedCoordinates_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__UNNORMALIZED_COORDINATES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Compare Enable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompareEnablePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_compareEnable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_compareEnable_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__COMPARE_ENABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lod Bias feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLodBiasPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_lodBias_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_lodBias_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__LOD_BIAS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min Lod feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinLodPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_minLod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_minLod_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__MIN_LOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Lod feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxLodPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_maxLod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_maxLod_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__MAX_LOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Anisotropy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxAnisotropyPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SamplerInfo_maxAnisotropy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SamplerInfo_maxAnisotropy_feature", "_UI_SamplerInfo_type"),
				 ImagePackage.Literals.SAMPLER_INFO__MAX_ANISOTROPY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns SamplerInfo.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SamplerInfo"));
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
		EFilter labelValue = ((SamplerInfo)object).getMinFilter();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_SamplerInfo_type") :
			getString("_UI_SamplerInfo_type") + " " + label;
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

		switch (notification.getFeatureID(SamplerInfo.class))
		{
			case ImagePackage.SAMPLER_INFO__MIN_FILTER:
			case ImagePackage.SAMPLER_INFO__MAG_FILTER:
			case ImagePackage.SAMPLER_INFO__MIPMAP_MODE:
			case ImagePackage.SAMPLER_INFO__ADDRESS_MODE:
			case ImagePackage.SAMPLER_INFO__BORDER_COLOR:
			case ImagePackage.SAMPLER_INFO__ANISOTROPY_ENABLED:
			case ImagePackage.SAMPLER_INFO__UNNORMALIZED_COORDINATES:
			case ImagePackage.SAMPLER_INFO__COMPARE_ENABLE:
			case ImagePackage.SAMPLER_INFO__LOD_BIAS:
			case ImagePackage.SAMPLER_INFO__MIN_LOD:
			case ImagePackage.SAMPLER_INFO__MAX_LOD:
			case ImagePackage.SAMPLER_INFO__MAX_ANISOTROPY:
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
		return VulkanEditPlugin.INSTANCE;
	}

}
