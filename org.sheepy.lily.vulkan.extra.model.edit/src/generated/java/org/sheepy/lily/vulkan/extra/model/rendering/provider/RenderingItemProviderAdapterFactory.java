/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.core.model.resource.util.ResourceSwitch;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.core.model.variable.util.VariableSwitch;
import org.sheepy.lily.vulkan.extra.model.nuklear.provider.ExtraEditPlugin;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.util.RenderingAdapterFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.util.ProcessSwitch;
import org.sheepy.lily.vulkan.model.util.VulkanSwitch;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RenderingItemProviderAdapterFactory extends RenderingAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IChildCreationExtender
{
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This helps manage the child creation extenders.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(ExtraEditPlugin.INSTANCE, RenderingPackage.eNS_URI);

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenderingItemProviderAdapterFactory()
	{
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.Axis} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AxisItemProvider axisItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.Axis}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAxisAdapter()
	{
		if (axisItemProvider == null)
		{
			axisItemProvider = new AxisItemProvider(this);
		}

		return axisItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationPkgItemProvider presentationPkgItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPresentationPkgAdapter()
	{
		if (presentationPkgItemProvider == null)
		{
			presentationPkgItemProvider = new PresentationPkgItemProvider(this);
		}

		return presentationPkgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentableEntityItemProvider presentableEntityItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPresentableEntityAdapter()
	{
		if (presentableEntityItemProvider == null)
		{
			presentableEntityItemProvider = new PresentableEntityItemProvider(this);
		}

		return presentableEntityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataProviderPkgItemProvider dataProviderPkgItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataProviderPkgAdapter()
	{
		if (dataProviderPkgItemProvider == null)
		{
			dataProviderPkgItemProvider = new DataProviderPkgItemProvider(this);
		}

		return dataProviderPkgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataProviderItemProvider dataProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataProviderAdapter()
	{
		if (dataProviderItemProvider == null)
		{
			dataProviderItemProvider = new DataProviderItemProvider(this);
		}

		return dataProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexedDataDescriptionItemProvider indexedDataDescriptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIndexedDataDescriptionAdapter()
	{
		if (indexedDataDescriptionItemProvider == null)
		{
			indexedDataDescriptionItemProvider = new IndexedDataDescriptionItemProvider(this);
		}

		return indexedDataDescriptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderableDataSourceItemProvider renderableDataSourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRenderableDataSourceAdapter()
	{
		if (renderableDataSourceItemProvider == null)
		{
			renderableDataSourceItemProvider = new RenderableDataSourceItemProvider(this);
		}

		return renderableDataSourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptorsProviderItemProvider descriptorsProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDescriptorsProviderAdapter()
	{
		if (descriptorsProviderItemProvider == null)
		{
			descriptorsProviderItemProvider = new DescriptorsProviderItemProvider(this);
		}

		return descriptorsProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataDescriptorsProviderItemProvider dataDescriptorsProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataDescriptorsProviderAdapter()
	{
		if (dataDescriptorsProviderItemProvider == null)
		{
			dataDescriptorsProviderItemProvider = new DataDescriptorsProviderItemProvider(this);
		}

		return dataDescriptorsProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataDescriptorItemProvider dataDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataDescriptorAdapter()
	{
		if (dataDescriptorItemProvider == null)
		{
			dataDescriptorItemProvider = new DataDescriptorItemProvider(this);
		}

		return dataDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDescriptorProviderPkgItemProvider resourceDescriptorProviderPkgItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceDescriptorProviderPkgAdapter()
	{
		if (resourceDescriptorProviderPkgItemProvider == null)
		{
			resourceDescriptorProviderPkgItemProvider = new ResourceDescriptorProviderPkgItemProvider(this);
		}

		return resourceDescriptorProviderPkgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderProxyConstantBufferItemProvider renderProxyConstantBufferItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRenderProxyConstantBufferAdapter()
	{
		if (renderProxyConstantBufferItemProvider == null)
		{
			renderProxyConstantBufferItemProvider = new RenderProxyConstantBufferItemProvider(this);
		}

		return renderProxyConstantBufferItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISpecializationItemProvider iSpecializationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createISpecializationAdapter()
	{
		if (iSpecializationItemProvider == null)
		{
			iSpecializationItemProvider = new ISpecializationItemProvider(this);
		}

		return iSpecializationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalEntityVariableItemProvider physicalEntityVariableItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPhysicalEntityVariableAdapter()
	{
		if (physicalEntityVariableItemProvider == null)
		{
			physicalEntityVariableItemProvider = new PhysicalEntityVariableItemProvider(this);
		}

		return physicalEntityVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.Camera} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraItemProvider cameraItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.Camera}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCameraAdapter()
	{
		if (cameraItemProvider == null)
		{
			cameraItemProvider = new CameraItemProvider(this);
		}

		return cameraItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.CameraMatrix} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraMatrixItemProvider cameraMatrixItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.CameraMatrix}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCameraMatrixAdapter()
	{
		if (cameraMatrixItemProvider == null)
		{
			cameraMatrixItemProvider = new CameraMatrixItemProvider(this);
		}

		return cameraMatrixItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.CameraPosition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraPositionItemProvider cameraPositionItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.CameraPosition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCameraPositionAdapter()
	{
		if (cameraPositionItemProvider == null)
		{
			cameraPositionItemProvider = new CameraPositionItemProvider(this);
		}

		return cameraPositionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraScreenWorldPositionItemProvider cameraScreenWorldPositionItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCameraScreenWorldPositionAdapter()
	{
		if (cameraScreenWorldPositionItemProvider == null)
		{
			cameraScreenWorldPositionItemProvider = new CameraScreenWorldPositionItemProvider(this);
		}

		return cameraScreenWorldPositionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraVariableItemProvider cameraVariableItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCameraVariableAdapter()
	{
		if (cameraVariableItemProvider == null)
		{
			cameraVariableItemProvider = new CameraVariableItemProvider(this);
		}

		return cameraVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MousePickConstantsItemProvider mousePickConstantsItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMousePickConstantsAdapter()
	{
		if (mousePickConstantsItemProvider == null)
		{
			mousePickConstantsItemProvider = new MousePickConstantsItemProvider(this);
		}

		return mousePickConstantsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MousePickExtensionItemProvider mousePickExtensionItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMousePickExtensionAdapter()
	{
		if (mousePickExtensionItemProvider == null)
		{
			mousePickExtensionItemProvider = new MousePickExtensionItemProvider(this);
		}

		return mousePickExtensionItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory()
	{
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
	{
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type)
	{
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type)
	{
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type)
	{
		if (isFactoryForType(type))
		{
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter)))
			{
				return adapter;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IChildCreationExtender> getChildCreationExtenders()
	{
		return childCreationExtenderManager.getChildCreationExtenders();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain)
	{
		return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		return childCreationExtenderManager;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener)
	{
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener)
	{
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification)
	{
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null)
		{
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * A child creation extender for the {@link VariablePackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class VariableChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends VariableSwitch<Object>
		{
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain)
			{
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseModelVariablePkg(ModelVariablePkg object)
			{
				newChildDescriptors.add
					(createChildParameter
						(VariablePackage.Literals.MODEL_VARIABLE_PKG__VARIABLES,
						 RenderingFactory.eINSTANCE.createPhysicalEntityVariable()));

				newChildDescriptors.add
					(createChildParameter
						(VariablePackage.Literals.MODEL_VARIABLE_PKG__VARIABLES,
						 RenderingFactory.eINSTANCE.createCameraMatrix()));

				newChildDescriptors.add
					(createChildParameter
						(VariablePackage.Literals.MODEL_VARIABLE_PKG__VARIABLES,
						 RenderingFactory.eINSTANCE.createCameraPosition()));

				newChildDescriptors.add
					(createChildParameter
						(VariablePackage.Literals.MODEL_VARIABLE_PKG__VARIABLES,
						 RenderingFactory.eINSTANCE.createCameraScreenWorldPosition()));

				newChildDescriptors.add
					(createChildParameter
						(VariablePackage.Literals.MODEL_VARIABLE_PKG__VARIABLES,
						 RenderingFactory.eINSTANCE.createCameraVariable()));

				return null;
			}

			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child)
			{
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain)
		{
			ArrayList<Object> result = new ArrayList<>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator()
		{
			return ExtraEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link ProcessPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class ProcessChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends ProcessSwitch<Object>
		{
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain)
			{
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseProcessExtensionPkg(ProcessExtensionPkg object)
			{
				newChildDescriptors.add
					(createChildParameter
						(ProcessPackage.Literals.PROCESS_EXTENSION_PKG__EXTENSIONS,
						 RenderingFactory.eINSTANCE.createMousePickExtension()));

				return null;
			}

			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child)
			{
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain)
		{
			ArrayList<Object> result = new ArrayList<>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator()
		{
			return ExtraEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link VulkanPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class VulkanChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends VulkanSwitch<Object>
		{
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain)
			{
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseVulkanResourcePkg(VulkanResourcePkg object)
			{
				newChildDescriptors.add
					(createChildParameter
						(VulkanPackage.Literals.VULKAN_RESOURCE_PKG__RESOURCES,
						 RenderingFactory.eINSTANCE.createRenderableDataSource()));

				newChildDescriptors.add
					(createChildParameter
						(VulkanPackage.Literals.VULKAN_RESOURCE_PKG__RESOURCES,
						 RenderingFactory.eINSTANCE.createRenderProxyConstantBuffer()));

				newChildDescriptors.add
					(createChildParameter
						(VulkanPackage.Literals.VULKAN_RESOURCE_PKG__RESOURCES,
						 RenderingFactory.eINSTANCE.createMousePickConstants()));

				return null;
			}

			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child)
			{
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain)
		{
			ArrayList<Object> result = new ArrayList<>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator()
		{
			return ExtraEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link ResourcePackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class ResourceChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends ResourceSwitch<Object>
		{
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain)
			{
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseResourcePkg(ResourcePkg object)
			{
				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.RESOURCE_PKG__RESOURCES,
						 RenderingFactory.eINSTANCE.createCamera()));

				return null;
			}

			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child)
			{
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain)
		{
			ArrayList<Object> result = new ArrayList<>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator()
		{
			return ExtraEditPlugin.INSTANCE;
		}
	}

}
