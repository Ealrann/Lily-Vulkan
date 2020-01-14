/**
 */
package org.sheepy.vulkan.model.graphicpipeline.provider;

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

import org.sheepy.vulkan.model.barrier.provider.VulkanEditPlugin;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;

import org.sheepy.vulkan.model.graphicpipeline.util.GraphicpipelineAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicpipelineItemProviderAdapterFactory extends GraphicpipelineAdapterFactory
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
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(VulkanEditPlugin.INSTANCE, GraphicpipelinePackage.eNS_URI);

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
	public GraphicpipelineItemProviderAdapterFactory()
	{
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorBlendItemProvider colorBlendItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createColorBlendAdapter()
	{
		if (colorBlendItemProvider == null)
		{
			colorBlendItemProvider = new ColorBlendItemProvider(this);
		}

		return colorBlendItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorBlendAttachmentItemProvider colorBlendAttachmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createColorBlendAttachmentAdapter()
	{
		if (colorBlendAttachmentItemProvider == null)
		{
			colorBlendAttachmentItemProvider = new ColorBlendAttachmentItemProvider(this);
		}

		return colorBlendAttachmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputAssemblyItemProvider inputAssemblyItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInputAssemblyAdapter()
	{
		if (inputAssemblyItemProvider == null)
		{
			inputAssemblyItemProvider = new InputAssemblyItemProvider(this);
		}

		return inputAssemblyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RasterizerItemProvider rasterizerItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRasterizerAdapter()
	{
		if (rasterizerItemProvider == null)
		{
			rasterizerItemProvider = new RasterizerItemProvider(this);
		}

		return rasterizerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.DynamicState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicStateItemProvider dynamicStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.DynamicState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDynamicStateAdapter()
	{
		if (dynamicStateItemProvider == null)
		{
			dynamicStateItemProvider = new DynamicStateItemProvider(this);
		}

		return dynamicStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.StaticViewportState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticViewportStateItemProvider staticViewportStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.StaticViewportState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStaticViewportStateAdapter()
	{
		if (staticViewportStateItemProvider == null)
		{
			staticViewportStateItemProvider = new StaticViewportStateItemProvider(this);
		}

		return staticViewportStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicViewportStateItemProvider dynamicViewportStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDynamicViewportStateAdapter()
	{
		if (dynamicViewportStateItemProvider == null)
		{
			dynamicViewportStateItemProvider = new DynamicViewportStateItemProvider(this);
		}

		return dynamicViewportStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.Vec2I} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Vec2IItemProvider vec2IItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.Vec2I}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVec2IAdapter()
	{
		if (vec2IItemProvider == null)
		{
			vec2IItemProvider = new Vec2IItemProvider(this);
		}

		return vec2IItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.Viewport} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewportItemProvider viewportItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.Viewport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createViewportAdapter()
	{
		if (viewportItemProvider == null)
		{
			viewportItemProvider = new ViewportItemProvider(this);
		}

		return viewportItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.Scissor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScissorItemProvider scissorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.Scissor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScissorAdapter()
	{
		if (scissorItemProvider == null)
		{
			scissorItemProvider = new ScissorItemProvider(this);
		}

		return scissorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepthStencilStateItemProvider depthStencilStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDepthStencilStateAdapter()
	{
		if (depthStencilStateItemProvider == null)
		{
			depthStencilStateItemProvider = new DepthStencilStateItemProvider(this);
		}

		return depthStencilStateItemProvider;
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
		if (colorBlendItemProvider != null) colorBlendItemProvider.dispose();
		if (colorBlendAttachmentItemProvider != null) colorBlendAttachmentItemProvider.dispose();
		if (inputAssemblyItemProvider != null) inputAssemblyItemProvider.dispose();
		if (rasterizerItemProvider != null) rasterizerItemProvider.dispose();
		if (dynamicStateItemProvider != null) dynamicStateItemProvider.dispose();
		if (staticViewportStateItemProvider != null) staticViewportStateItemProvider.dispose();
		if (dynamicViewportStateItemProvider != null) dynamicViewportStateItemProvider.dispose();
		if (vec2IItemProvider != null) vec2IItemProvider.dispose();
		if (viewportItemProvider != null) viewportItemProvider.dispose();
		if (scissorItemProvider != null) scissorItemProvider.dispose();
		if (depthStencilStateItemProvider != null) depthStencilStateItemProvider.dispose();
	}

}
