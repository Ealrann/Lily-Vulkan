/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.provider;

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
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.Subpass} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SubpassItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubpassItemProvider(AdapterFactory adapterFactory)
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
			addSubpassIndexPropertyDescriptor(object);
			addBindPointPropertyDescriptor(object);
			addCompositorPropertyDescriptor(object);
			addWaitForStagePropertyDescriptor(object);
			addSyncStagePropertyDescriptor(object);
			addFinishStagePropertyDescriptor(object);
			addWaitForAccessesPropertyDescriptor(object);
			addSyncAccessesPropertyDescriptor(object);
			addFinishAccessesPropertyDescriptor(object);
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
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LNamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LNamedElement_name_feature", "_UI_LNamedElement_type"),
				 TypesPackage.Literals.LNAMED_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Subpass Index feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubpassIndexPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_subpassIndex_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_subpassIndex_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__SUBPASS_INDEX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bind Point feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBindPointPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_bindPoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_bindPoint_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__BIND_POINT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Compositor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompositorPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_compositor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_compositor_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__COMPOSITOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Wait For Stage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWaitForStagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_waitForStage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_waitForStage_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__WAIT_FOR_STAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI__0WaitForprevioussubpassPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Sync Stage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSyncStagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_syncStage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_syncStage_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__SYNC_STAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI__1SynccurrentsubpassPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Finish Stage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFinishStagePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_finishStage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_finishStage_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__FINISH_STAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI__2FinishfornextsubpassPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Wait For Accesses feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWaitForAccessesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_waitForAccesses_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_waitForAccesses_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__WAIT_FOR_ACCESSES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI__0WaitForprevioussubpassPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Sync Accesses feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSyncAccessesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_syncAccesses_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_syncAccesses_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__SYNC_ACCESSES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI__1SynccurrentsubpassPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Finish Accesses feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFinishAccessesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Subpass_finishAccesses_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subpass_finishAccesses_feature", "_UI_Subpass_type"),
				 GraphicPackage.Literals.SUBPASS__FINISH_ACCESSES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI__2FinishfornextsubpassPropertyCategory"),
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
			childrenFeatures.add(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG);
			childrenFeatures.add(VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG);
			childrenFeatures.add(GraphicPackage.Literals.SUBPASS__ATTACHMENT_REF_PKG);
			childrenFeatures.add(GraphicPackage.Literals.SUBPASS__ATTACHMENT_PKG);
			childrenFeatures.add(GraphicPackage.Literals.SUBPASS__PIPELINE_PKG);
			childrenFeatures.add(GraphicPackage.Literals.SUBPASS__EXTENSION_PKG);
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
	 * This returns Subpass.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Subpass"));
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
		String label = ((Subpass)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Subpass_type") :
			getString("_UI_Subpass_type") + " " + label;
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

		switch (notification.getFeatureID(Subpass.class))
		{
			case GraphicPackage.SUBPASS__NAME:
			case GraphicPackage.SUBPASS__SUBPASS_INDEX:
			case GraphicPackage.SUBPASS__BIND_POINT:
			case GraphicPackage.SUBPASS__WAIT_FOR_STAGE:
			case GraphicPackage.SUBPASS__SYNC_STAGE:
			case GraphicPackage.SUBPASS__FINISH_STAGE:
			case GraphicPackage.SUBPASS__WAIT_FOR_ACCESSES:
			case GraphicPackage.SUBPASS__SYNC_ACCESSES:
			case GraphicPackage.SUBPASS__FINISH_ACCESSES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GraphicPackage.SUBPASS__RESOURCE_PKG:
			case GraphicPackage.SUBPASS__DESCRIPTOR_PKG:
			case GraphicPackage.SUBPASS__ATTACHMENT_REF_PKG:
			case GraphicPackage.SUBPASS__ATTACHMENT_PKG:
			case GraphicPackage.SUBPASS__PIPELINE_PKG:
			case GraphicPackage.SUBPASS__EXTENSION_PKG:
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
				(VulkanPackage.Literals.IRESOURCE_CONTAINER__RESOURCE_PKG,
				 VulkanFactory.eINSTANCE.createVulkanResourcePkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanPackage.Literals.IRESOURCE_CONTAINER__DESCRIPTOR_PKG,
				 VulkanFactory.eINSTANCE.createDescriptorPkg()));

		newChildDescriptors.add
			(createChildParameter
				(GraphicPackage.Literals.SUBPASS__ATTACHMENT_REF_PKG,
				 GraphicFactory.eINSTANCE.createAttachmentRefPkg()));

		newChildDescriptors.add
			(createChildParameter
				(GraphicPackage.Literals.SUBPASS__ATTACHMENT_PKG,
				 GraphicFactory.eINSTANCE.createAttachmentPkg()));

		newChildDescriptors.add
			(createChildParameter
				(GraphicPackage.Literals.SUBPASS__PIPELINE_PKG,
				 ProcessFactory.eINSTANCE.createPipelinePkg()));

		newChildDescriptors.add
			(createChildParameter
				(GraphicPackage.Literals.SUBPASS__EXTENSION_PKG,
				 ProcessFactory.eINSTANCE.createProcessExtensionPkg()));
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
