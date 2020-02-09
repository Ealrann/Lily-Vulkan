/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshFactory;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteFactory;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.model.resource.provider.BufferDataProviderItemProvider;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IndexProviderItemProvider extends BufferDataProviderItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexProviderItemProvider(AdapterFactory adapterFactory)
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

			addIndexTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Index Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndexTypePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IndexProvider_indexType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IndexProvider_indexType_feature", "_UI_IndexProvider_type"),
				 RenderingPackage.Literals.INDEX_PROVIDER__INDEX_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns IndexProvider.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IndexProvider"));
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
		String label = ((IndexProvider<?>)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IndexProvider_type") :
			getString("_UI_IndexProvider_type") + " " + label;
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

		switch (notification.getFeatureID(IndexProvider.class))
		{
			case RenderingPackage.INDEX_PROVIDER__INDEX_TYPE:
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
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createAxis()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createPresentationPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createPresentableEntity()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createDataProviderPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createRenderableDataSource()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createVertexProvider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createIndexProvider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createDescriptorsProvider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createDataDescriptorsProvider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createDataDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createResourceDescriptorProviderPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createRenderProxyConstantBuffer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createISpecialization()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createRenderDrawTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 RenderingFactory.eINSTANCE.createRenderIndexedDrawTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 MeshFactory.eINSTANCE.createMeshRenderer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 MeshFactory.eINSTANCE.createIMeshStructure()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 MeshFactory.eINSTANCE.createGeometricMesh()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 MeshFactory.eINSTANCE.createIcosahedron()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 MeshFactory.eINSTANCE.createSphere()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 MeshFactory.eINSTANCE.createIcoSphere()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createNuklearPushConstants()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createNuklearLayoutTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createNuklearFillBufferTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createNuklearContext()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createNuklearFont()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createSelectorPanel()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createPanelViewer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createNuklearVertexProvider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 NuklearFactory.eINSTANCE.createNuklearIndexProvider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 SpriteFactory.eINSTANCE.createSpriteRenderer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 SpriteFactory.eINSTANCE.createSprite()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 SpriteFactory.eINSTANCE.createSpriteMonoSamplerProvider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 SpriteFactory.eINSTANCE.createSpriteStructure()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 SpriteFactory.eINSTANCE.createSpriteCountSpecialization()));
	}

}
