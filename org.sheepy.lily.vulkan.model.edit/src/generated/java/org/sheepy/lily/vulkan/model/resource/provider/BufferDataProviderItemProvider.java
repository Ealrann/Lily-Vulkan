/**
 */
package org.sheepy.lily.vulkan.model.resource.provider;

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
import org.sheepy.lily.core.model.application.ApplicationFactory;
import org.sheepy.lily.core.model.cadence.CadenceFactory;
import org.sheepy.lily.core.model.inference.InferenceFactory;
import org.sheepy.lily.core.model.resource.ResourceFactory;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.core.model.ui.UiFactory;
import org.sheepy.lily.core.model.variable.VariableFactory;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.binding.BindingFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.barrier.BarrierFactory;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelineFactory;
import org.sheepy.vulkan.model.image.ImageFactory;
import org.sheepy.vulkan.model.pipeline.PipelineFactory;

/**
 * This is the item provider adapter for a {@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BufferDataProviderItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferDataProviderItemProvider(AdapterFactory adapterFactory)
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
			addDataSourcePropertyDescriptor(object);
			addUsedToPushPropertyDescriptor(object);
			addUsedToFetchPropertyDescriptor(object);
			addStageBeforePushPropertyDescriptor(object);
			addAccessBeforePushPropertyDescriptor(object);
			addStageBeforeFetchPropertyDescriptor(object);
			addAccessBeforeFetchPropertyDescriptor(object);
			addUsagesPropertyDescriptor(object);
			addInstanceCountPropertyDescriptor(object);
			addGrowFactorPropertyDescriptor(object);
			addGrowThresholdPropertyDescriptor(object);
			addMinSizePropertyDescriptor(object);
			addRequestedSizePropertyDescriptor(object);
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
	 * This adds a property descriptor for the Instance Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInstanceCountPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_instanceCount_feature"),
				 getString("_UI_BufferDataProvider_instanceCount_description"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__INSTANCE_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Grow Factor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGrowFactorPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_growFactor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_growFactor_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__GROW_FACTOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Grow Threshold feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGrowThresholdPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_growThreshold_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_growThreshold_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__GROW_THRESHOLD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinSizePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_minSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_minSize_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__MIN_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Requested Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequestedSizePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_requestedSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_requestedSize_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__REQUESTED_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE);
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
	 * This adds a property descriptor for the Data Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDataSourcePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_dataSource_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_dataSource_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Used To Push feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsedToPushPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_usedToPush_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_usedToPush_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__USED_TO_PUSH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Used To Fetch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsedToFetchPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_usedToFetch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_usedToFetch_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__USED_TO_FETCH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stage Before Push feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStageBeforePushPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_stageBeforePush_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_stageBeforePush_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Access Before Push feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccessBeforePushPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_accessBeforePush_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_accessBeforePush_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stage Before Fetch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStageBeforeFetchPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_stageBeforeFetch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_stageBeforeFetch_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Access Before Fetch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccessBeforeFetchPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_accessBeforeFetch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_accessBeforeFetch_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Usages feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsagesPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BufferDataProvider_usages_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BufferDataProvider_usages_feature", "_UI_BufferDataProvider_type"),
				 VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__USAGES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns BufferDataProvider.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BufferDataProvider"));
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
		String label = ((BufferDataProvider<?>)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BufferDataProvider_type") :
			getString("_UI_BufferDataProvider_type") + " " + label;
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

		switch (notification.getFeatureID(BufferDataProvider.class))
		{
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__USAGES:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_FACTOR:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_THRESHOLD:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__MIN_SIZE:
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case VulkanResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE:
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
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createTransferBuffer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createConstantBuffer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createBuffer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createCompositeBuffer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createBufferPart()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createBufferDataProvider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createStaticImage()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createFileImage()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createFontImage()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createCompositeImage()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createImageInlay()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createSampledImage()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createSampler()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createSemaphore()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createBufferDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createImageDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createSampledImageDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createSamplerDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createDescriptorSet()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createDescriptorSetPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createBufferBarrier()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createImageBarrier()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createShader()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanResourceFactory.eINSTANCE.createImageArrayDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 BindingFactory.eINSTANCE.createBindingConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 BindingFactory.eINSTANCE.createConfigureBind()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 BindingFactory.eINSTANCE.createRotateConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 BindingFactory.eINSTANCE.createConfigurePrepareComposite()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 BindingFactory.eINSTANCE.createConfigureBufferDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 BindingFactory.eINSTANCE.createConfigureCompositeBufferBarrier()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 BindingFactory.eINSTANCE.createIndexConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ComputeFactory.eINSTANCE.createComputeProcess()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ComputeFactory.eINSTANCE.createComputePipeline()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ComputeFactory.eINSTANCE.createDispatchTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createGraphicConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createColorDomain()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createSwapchainConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createFramebufferConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createImageAttachment()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createDepthAttachment()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createColorAttachment()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createAttachmentPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createSubpass()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createAttachmentRefPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createAttachmentRef()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createSwapImageAttachment()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createGraphicProcess()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createGraphicsPipeline()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createSwapImageBarrier()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createBlitToSwapImage()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createBlitTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createDrawIndexed()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createDraw()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createVertexInputState()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createInputDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createAttributeDescription()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createBindVertexBuffer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createSetScissor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createSetViewport()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createVertexBinding()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createBindIndexBuffer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicFactory.eINSTANCE.createAttachmentDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createPipelinePkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createITaskPipeline()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createIVkPipeline()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createTaskPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createPipeline()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createCompositePipeline()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createPipelineBarrier()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createCompositeTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createBindDescriptorSets()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createPushConstantBuffer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createFlushTransferBufferTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createCopyBufferTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createProcessExtensionPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createPrepareCompositeTransfer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ProcessFactory.eINSTANCE.createSwapBindingsTask()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanFactory.eINSTANCE.createVulkanEngine()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanFactory.eINSTANCE.createRunProcess()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanFactory.eINSTANCE.createWaitProcessIdle()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VulkanFactory.eINSTANCE.createDescriptorPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createPanel()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createUI()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createUIPage()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createDynamicRowLayout()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createVariableLabel()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createLabel()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createSlider()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createTextField()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createButton()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createBooleanButton()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createBooleanActionButton()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createFontPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createFontTable()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 UiFactory.eINSTANCE.createFont()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ApplicationFactory.eINSTANCE.createApplication()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ApplicationFactory.eINSTANCE.createApplicationExtensionPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ApplicationFactory.eINSTANCE.createTimeConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ApplicationFactory.eINSTANCE.createIModel()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ApplicationFactory.eINSTANCE.createScene()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ApplicationFactory.eINSTANCE.createGenericScenePart()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ApplicationFactory.eINSTANCE.createBackgroundImage()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ApplicationFactory.eINSTANCE.createScreenEffect()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createChainVariableResolver()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createChainResolver()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createDirectVariableResolver()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createBooleanChangeAction()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createIntChangeAction()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createVarChangeActionPkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createIModelVariable()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createIntVariable()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 VariableFactory.eINSTANCE.createDurationVariable()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 TypesFactory.eINSTANCE.createFloatParameter()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 TypesFactory.eINSTANCE.createStringParameter()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 TypesFactory.eINSTANCE.createBooleanParameter()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 InferenceFactory.eINSTANCE.createLRule()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 CadenceFactory.eINSTANCE.createCadence()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 CadenceFactory.eINSTANCE.createExecuteWhile()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 CadenceFactory.eINSTANCE.createExecuteIf()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 CadenceFactory.eINSTANCE.createPrintUPS()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 CadenceFactory.eINSTANCE.createHaveTime()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 CadenceFactory.eINSTANCE.createCountUntil()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 CadenceFactory.eINSTANCE.createCloseApplication()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 CadenceFactory.eINSTANCE.createGenericCadence()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 BarrierFactory.eINSTANCE.createImageTransition()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createColorBlend()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createColorBlendAttachment()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createInputAssembly()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createRasterizer()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createDynamicState()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createStaticViewportState()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createDynamicViewportState()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createVec2I()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createViewport()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createScissor()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 GraphicpipelineFactory.eINSTANCE.createDepthStencilState()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ImageFactory.eINSTANCE.createSamplerInfo()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ImageFactory.eINSTANCE.createImageInfo()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ImageFactory.eINSTANCE.createImageLayout()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 PipelineFactory.eINSTANCE.createPushConstantRange()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 PipelineFactory.eINSTANCE.createSpecializationConstant()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createIResource()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createSound()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createMusic()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createSoundContinuous()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createResourcePkg()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createVirtualResource()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createLocalResource()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createModuleResource()));

		newChildDescriptors.add
			(createChildParameter
				(VulkanResourcePackage.Literals.BUFFER_DATA_PROVIDER__DATA_SOURCE,
				 ResourceFactory.eINSTANCE.createStringModuleResource()));
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
