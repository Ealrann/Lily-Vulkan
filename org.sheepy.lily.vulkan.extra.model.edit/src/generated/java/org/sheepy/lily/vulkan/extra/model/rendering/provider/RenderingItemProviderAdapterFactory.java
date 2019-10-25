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
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.sheepy.lily.vulkan.extra.model.mesh.provider.ExtraEditPlugin;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.util.RenderingAdapterFactory;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.util.ResourceSwitch;
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
public class RenderingItemProviderAdapterFactory extends RenderingAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender
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
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

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
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.DescribedDataProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescribedDataProviderItemProvider describedDataProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.DescribedDataProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDescribedDataProviderAdapter()
	{
		if (describedDataProviderItemProvider == null)
		{
			describedDataProviderItemProvider = new DescribedDataProviderItemProvider(this);
		}

		return describedDataProviderItemProvider;
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
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VertexProviderItemProvider vertexProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVertexProviderAdapter()
	{
		if (vertexProviderItemProvider == null)
		{
			vertexProviderItemProvider = new VertexProviderItemProvider(this);
		}

		return vertexProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexProviderItemProvider indexProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIndexProviderAdapter()
	{
		if (indexProviderItemProvider == null)
		{
			indexProviderItemProvider = new IndexProviderItemProvider(this);
		}

		return indexProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticResourceProviderItemProvider staticResourceProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStaticResourceProviderAdapter()
	{
		if (staticResourceProviderItemProvider == null)
		{
			staticResourceProviderItemProvider = new StaticResourceProviderItemProvider(this);
		}

		return staticResourceProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.rendering.CompositeResourceProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeResourceProviderItemProvider compositeResourceProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.rendering.CompositeResourceProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeResourceProviderAdapter()
	{
		if (compositeResourceProviderItemProvider == null)
		{
			compositeResourceProviderItemProvider = new CompositeResourceProviderItemProvider(this);
		}

		return compositeResourceProviderItemProvider;
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
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose()
	{
		if (axisItemProvider != null) axisItemProvider.dispose();
		if (presentationPkgItemProvider != null) presentationPkgItemProvider.dispose();
		if (presentableEntityItemProvider != null) presentableEntityItemProvider.dispose();
		if (dataProviderPkgItemProvider != null) dataProviderPkgItemProvider.dispose();
		if (describedDataProviderItemProvider != null) describedDataProviderItemProvider.dispose();
		if (renderableDataSourceItemProvider != null) renderableDataSourceItemProvider.dispose();
		if (vertexProviderItemProvider != null) vertexProviderItemProvider.dispose();
		if (indexProviderItemProvider != null) indexProviderItemProvider.dispose();
		if (staticResourceProviderItemProvider != null) staticResourceProviderItemProvider.dispose();
		if (compositeResourceProviderItemProvider != null) compositeResourceProviderItemProvider.dispose();
		if (renderProxyConstantBufferItemProvider != null) renderProxyConstantBufferItemProvider.dispose();
		if (iSpecializationItemProvider != null) iSpecializationItemProvider.dispose();
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
			public Object caseResourcePkg(ResourcePkg object)
			{
				newChildDescriptors.add
					(createChildParameter
						(VulkanPackage.Literals.RESOURCE_PKG__RESOURCES,
						 RenderingFactory.eINSTANCE.createRenderProxyConstantBuffer()));

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
			ArrayList<Object> result = new ArrayList<Object>();
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
			public Object caseCompositeBuffer(CompositeBuffer object)
			{
				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.COMPOSITE_BUFFER__DATA_PROVIDERS,
						 RenderingFactory.eINSTANCE.createDescribedDataProvider()));

				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.COMPOSITE_BUFFER__DATA_PROVIDERS,
						 RenderingFactory.eINSTANCE.createVertexProvider()));

				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.COMPOSITE_BUFFER__DATA_PROVIDERS,
						 RenderingFactory.eINSTANCE.createIndexProvider()));

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
			ArrayList<Object> result = new ArrayList<Object>();
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
