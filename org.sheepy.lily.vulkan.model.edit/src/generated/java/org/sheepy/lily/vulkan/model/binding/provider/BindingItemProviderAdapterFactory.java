/**
 */
package org.sheepy.lily.vulkan.model.binding.provider;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.sheepy.lily.vulkan.model.binding.util.BindingAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BindingItemProviderAdapterFactory extends BindingAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
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
	public BindingItemProviderAdapterFactory()
	{
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingConfigurationItemProvider bindingConfigurationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBindingConfigurationAdapter()
	{
		if (bindingConfigurationItemProvider == null)
		{
			bindingConfigurationItemProvider = new BindingConfigurationItemProvider(this);
		}

		return bindingConfigurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.binding.ConfigureBind} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigureBindItemProvider configureBindItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.binding.ConfigureBind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConfigureBindAdapter()
	{
		if (configureBindItemProvider == null)
		{
			configureBindItemProvider = new ConfigureBindItemProvider(this);
		}

		return configureBindItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RotateConfigurationItemProvider rotateConfigurationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRotateConfigurationAdapter()
	{
		if (rotateConfigurationItemProvider == null)
		{
			rotateConfigurationItemProvider = new RotateConfigurationItemProvider(this);
		}

		return rotateConfigurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurePrepareCompositeItemProvider configurePrepareCompositeItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConfigurePrepareCompositeAdapter()
	{
		if (configurePrepareCompositeItemProvider == null)
		{
			configurePrepareCompositeItemProvider = new ConfigurePrepareCompositeItemProvider(this);
		}

		return configurePrepareCompositeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigureBufferDescriptorItemProvider configureBufferDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConfigureBufferDescriptorAdapter()
	{
		if (configureBufferDescriptorItemProvider == null)
		{
			configureBufferDescriptorItemProvider = new ConfigureBufferDescriptorItemProvider(this);
		}

		return configureBufferDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigureCompositeBufferBarrierItemProvider configureCompositeBufferBarrierItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConfigureCompositeBufferBarrierAdapter()
	{
		if (configureCompositeBufferBarrierItemProvider == null)
		{
			configureCompositeBufferBarrierItemProvider = new ConfigureCompositeBufferBarrierItemProvider(this);
		}

		return configureCompositeBufferBarrierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.binding.IndexConfiguration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexConfigurationItemProvider indexConfigurationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.binding.IndexConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIndexConfigurationAdapter()
	{
		if (indexConfigurationItemProvider == null)
		{
			indexConfigurationItemProvider = new IndexConfigurationItemProvider(this);
		}

		return indexConfigurationItemProvider;
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
		if (bindingConfigurationItemProvider != null) bindingConfigurationItemProvider.dispose();
		if (configureBindItemProvider != null) configureBindItemProvider.dispose();
		if (rotateConfigurationItemProvider != null) rotateConfigurationItemProvider.dispose();
		if (configurePrepareCompositeItemProvider != null) configurePrepareCompositeItemProvider.dispose();
		if (configureBufferDescriptorItemProvider != null) configureBufferDescriptorItemProvider.dispose();
		if (configureCompositeBufferBarrierItemProvider != null) configureCompositeBufferBarrierItemProvider.dispose();
		if (indexConfigurationItemProvider != null) indexConfigurationItemProvider.dispose();
	}

}