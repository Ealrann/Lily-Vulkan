/**
 */
package org.sheepy.lily.vulkan.model.resource.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;
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
import org.sheepy.lily.vulkan.model.process.compute.provider.LilyVulkanEditPlugin;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.util.ResourceAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceItemProviderAdapterFactory extends ResourceAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender
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
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(LilyVulkanEditPlugin.INSTANCE, ResourcePackage.eNS_URI);

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
	public ResourceItemProviderAdapterFactory()
	{
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.TransferBuffer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransferBufferItemProvider transferBufferItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.TransferBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTransferBufferAdapter()
	{
		if (transferBufferItemProvider == null)
		{
			transferBufferItemProvider = new TransferBufferItemProvider(this);
		}

		return transferBufferItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.ConstantBuffer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantBufferItemProvider constantBufferItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.ConstantBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConstantBufferAdapter()
	{
		if (constantBufferItemProvider == null)
		{
			constantBufferItemProvider = new ConstantBufferItemProvider(this);
		}

		return constantBufferItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.Buffer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferItemProvider bufferItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.Buffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBufferAdapter()
	{
		if (bufferItemProvider == null)
		{
			bufferItemProvider = new BufferItemProvider(this);
		}

		return bufferItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeBufferItemProvider compositeBufferItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeBufferAdapter()
	{
		if (compositeBufferItemProvider == null)
		{
			compositeBufferItemProvider = new CompositeBufferItemProvider(this);
		}

		return compositeBufferItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.BufferReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferReferenceItemProvider bufferReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.BufferReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBufferReferenceAdapter()
	{
		if (bufferReferenceItemProvider == null)
		{
			bufferReferenceItemProvider = new BufferReferenceItemProvider(this);
		}

		return bufferReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.CompositeBufferReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeBufferReferenceItemProvider compositeBufferReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.CompositeBufferReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeBufferReferenceAdapter()
	{
		if (compositeBufferReferenceItemProvider == null)
		{
			compositeBufferReferenceItemProvider = new CompositeBufferReferenceItemProvider(this);
		}

		return compositeBufferReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferDataProviderItemProvider bufferDataProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBufferDataProviderAdapter()
	{
		if (bufferDataProviderItemProvider == null)
		{
			bufferDataProviderItemProvider = new BufferDataProviderItemProvider(this);
		}

		return bufferDataProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.StaticImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticImageItemProvider staticImageItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.StaticImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStaticImageAdapter()
	{
		if (staticImageItemProvider == null)
		{
			staticImageItemProvider = new StaticImageItemProvider(this);
		}

		return staticImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.FileImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileImageItemProvider fileImageItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.FileImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFileImageAdapter()
	{
		if (fileImageItemProvider == null)
		{
			fileImageItemProvider = new FileImageItemProvider(this);
		}

		return fileImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.SampledImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampledImageItemProvider sampledImageItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.SampledImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSampledImageAdapter()
	{
		if (sampledImageItemProvider == null)
		{
			sampledImageItemProvider = new SampledImageItemProvider(this);
		}

		return sampledImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.Sampler} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SamplerItemProvider samplerItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.Sampler}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSamplerAdapter()
	{
		if (samplerItemProvider == null)
		{
			samplerItemProvider = new SamplerItemProvider(this);
		}

		return samplerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.Semaphore} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemaphoreItemProvider semaphoreItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.Semaphore}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSemaphoreAdapter()
	{
		if (semaphoreItemProvider == null)
		{
			semaphoreItemProvider = new SemaphoreItemProvider(this);
		}

		return semaphoreItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.FontImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FontImageItemProvider fontImageItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.FontImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFontImageAdapter()
	{
		if (fontImageItemProvider == null)
		{
			fontImageItemProvider = new FontImageItemProvider(this);
		}

		return fontImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.BufferDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferDescriptorItemProvider bufferDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.BufferDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBufferDescriptorAdapter()
	{
		if (bufferDescriptorItemProvider == null)
		{
			bufferDescriptorItemProvider = new BufferDescriptorItemProvider(this);
		}

		return bufferDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageDescriptorItemProvider imageDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImageDescriptorAdapter()
	{
		if (imageDescriptorItemProvider == null)
		{
			imageDescriptorItemProvider = new ImageDescriptorItemProvider(this);
		}

		return imageDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampledImageDescriptorItemProvider sampledImageDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSampledImageDescriptorAdapter()
	{
		if (sampledImageDescriptorItemProvider == null)
		{
			sampledImageDescriptorItemProvider = new SampledImageDescriptorItemProvider(this);
		}

		return sampledImageDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.SamplerDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SamplerDescriptorItemProvider samplerDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.SamplerDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSamplerDescriptorAdapter()
	{
		if (samplerDescriptorItemProvider == null)
		{
			samplerDescriptorItemProvider = new SamplerDescriptorItemProvider(this);
		}

		return samplerDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Texture2DArrayDescriptorItemProvider texture2DArrayDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTexture2DArrayDescriptorAdapter()
	{
		if (texture2DArrayDescriptorItemProvider == null)
		{
			texture2DArrayDescriptorItemProvider = new Texture2DArrayDescriptorItemProvider(this);
		}

		return texture2DArrayDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.DescriptorSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptorSetItemProvider descriptorSetItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDescriptorSetAdapter()
	{
		if (descriptorSetItemProvider == null)
		{
			descriptorSetItemProvider = new DescriptorSetItemProvider(this);
		}

		return descriptorSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptorSetPkgItemProvider descriptorSetPkgItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDescriptorSetPkgAdapter()
	{
		if (descriptorSetPkgItemProvider == null)
		{
			descriptorSetPkgItemProvider = new DescriptorSetPkgItemProvider(this);
		}

		return descriptorSetPkgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.BufferBarrier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferBarrierItemProvider bufferBarrierItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.BufferBarrier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBufferBarrierAdapter()
	{
		if (bufferBarrierItemProvider == null)
		{
			bufferBarrierItemProvider = new BufferBarrierItemProvider(this);
		}

		return bufferBarrierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeBufferBarrierItemProvider compositeBufferBarrierItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositeBufferBarrierAdapter()
	{
		if (compositeBufferBarrierItemProvider == null)
		{
			compositeBufferBarrierItemProvider = new CompositeBufferBarrierItemProvider(this);
		}

		return compositeBufferBarrierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.ImageBarrier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageBarrierItemProvider imageBarrierItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.ImageBarrier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImageBarrierAdapter()
	{
		if (imageBarrierItemProvider == null)
		{
			imageBarrierItemProvider = new ImageBarrierItemProvider(this);
		}

		return imageBarrierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.Shader} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShaderItemProvider shaderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.Shader}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createShaderAdapter()
	{
		if (shaderItemProvider == null)
		{
			shaderItemProvider = new ShaderItemProvider(this);
		}

		return shaderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.FileResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileResourceItemProvider fileResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.FileResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFileResourceAdapter()
	{
		if (fileResourceItemProvider == null)
		{
			fileResourceItemProvider = new FileResourceItemProvider(this);
		}

		return fileResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.ModuleResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleResourceItemProvider moduleResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.ModuleResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModuleResourceAdapter()
	{
		if (moduleResourceItemProvider == null)
		{
			moduleResourceItemProvider = new ModuleResourceItemProvider(this);
		}

		return moduleResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.StringModuleResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringModuleResourceItemProvider stringModuleResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.StringModuleResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringModuleResourceAdapter()
	{
		if (stringModuleResourceItemProvider == null)
		{
			stringModuleResourceItemProvider = new StringModuleResourceItemProvider(this);
		}

		return stringModuleResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.resource.Texture2DArray} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Texture2DArrayItemProvider texture2DArrayItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.resource.Texture2DArray}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTexture2DArrayAdapter()
	{
		if (texture2DArrayItemProvider == null)
		{
			texture2DArrayItemProvider = new Texture2DArrayItemProvider(this);
		}

		return texture2DArrayItemProvider;
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
		if (transferBufferItemProvider != null) transferBufferItemProvider.dispose();
		if (constantBufferItemProvider != null) constantBufferItemProvider.dispose();
		if (bufferItemProvider != null) bufferItemProvider.dispose();
		if (compositeBufferItemProvider != null) compositeBufferItemProvider.dispose();
		if (bufferReferenceItemProvider != null) bufferReferenceItemProvider.dispose();
		if (compositeBufferReferenceItemProvider != null) compositeBufferReferenceItemProvider.dispose();
		if (bufferDataProviderItemProvider != null) bufferDataProviderItemProvider.dispose();
		if (staticImageItemProvider != null) staticImageItemProvider.dispose();
		if (fileImageItemProvider != null) fileImageItemProvider.dispose();
		if (sampledImageItemProvider != null) sampledImageItemProvider.dispose();
		if (samplerItemProvider != null) samplerItemProvider.dispose();
		if (semaphoreItemProvider != null) semaphoreItemProvider.dispose();
		if (fontImageItemProvider != null) fontImageItemProvider.dispose();
		if (bufferDescriptorItemProvider != null) bufferDescriptorItemProvider.dispose();
		if (imageDescriptorItemProvider != null) imageDescriptorItemProvider.dispose();
		if (sampledImageDescriptorItemProvider != null) sampledImageDescriptorItemProvider.dispose();
		if (samplerDescriptorItemProvider != null) samplerDescriptorItemProvider.dispose();
		if (texture2DArrayDescriptorItemProvider != null) texture2DArrayDescriptorItemProvider.dispose();
		if (descriptorSetItemProvider != null) descriptorSetItemProvider.dispose();
		if (descriptorSetPkgItemProvider != null) descriptorSetPkgItemProvider.dispose();
		if (bufferBarrierItemProvider != null) bufferBarrierItemProvider.dispose();
		if (compositeBufferBarrierItemProvider != null) compositeBufferBarrierItemProvider.dispose();
		if (imageBarrierItemProvider != null) imageBarrierItemProvider.dispose();
		if (shaderItemProvider != null) shaderItemProvider.dispose();
		if (fileResourceItemProvider != null) fileResourceItemProvider.dispose();
		if (moduleResourceItemProvider != null) moduleResourceItemProvider.dispose();
		if (stringModuleResourceItemProvider != null) stringModuleResourceItemProvider.dispose();
		if (texture2DArrayItemProvider != null) texture2DArrayItemProvider.dispose();
	}

}
