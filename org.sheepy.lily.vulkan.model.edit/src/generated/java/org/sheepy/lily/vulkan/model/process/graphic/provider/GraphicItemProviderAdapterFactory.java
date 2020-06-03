/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.provider;

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
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.core.model.application.util.ApplicationSwitch;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.core.model.resource.util.ResourceSwitch;
import org.sheepy.lily.vulkan.model.binding.provider.LilyVulkanEditPlugin;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.lily.vulkan.model.process.graphic.util.GraphicAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicItemProviderAdapterFactory extends GraphicAdapterFactory
		implements ComposeableAdapterFactory, IChangeNotifier, IChildCreationExtender
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
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(LilyVulkanEditPlugin.INSTANCE, GraphicPackage.eNS_URI);

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
	public GraphicItemProviderAdapterFactory()
	{
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicConfigurationItemProvider graphicConfigurationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphicConfigurationAdapter()
	{
		if (graphicConfigurationItemProvider == null)
		{
			graphicConfigurationItemProvider = new GraphicConfigurationItemProvider(this);
		}

		return graphicConfigurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicExecutionRecorderItemProvider graphicExecutionRecorderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphicExecutionRecorderAdapter()
	{
		if (graphicExecutionRecorderItemProvider == null)
		{
			graphicExecutionRecorderItemProvider = new GraphicExecutionRecorderItemProvider(this);
		}

		return graphicExecutionRecorderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorDomainItemProvider colorDomainItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createColorDomainAdapter()
	{
		if (colorDomainItemProvider == null)
		{
			colorDomainItemProvider = new ColorDomainItemProvider(this);
		}

		return colorDomainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalSurfaceItemProvider physicalSurfaceItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPhysicalSurfaceAdapter()
	{
		if (physicalSurfaceItemProvider == null)
		{
			physicalSurfaceItemProvider = new PhysicalSurfaceItemProvider(this);
		}

		return physicalSurfaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwapchainConfigurationItemProvider swapchainConfigurationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSwapchainConfigurationAdapter()
	{
		if (swapchainConfigurationItemProvider == null)
		{
			swapchainConfigurationItemProvider = new SwapchainConfigurationItemProvider(this);
		}

		return swapchainConfigurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FramebufferConfigurationItemProvider framebufferConfigurationItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFramebufferConfigurationAdapter()
	{
		if (framebufferConfigurationItemProvider == null)
		{
			framebufferConfigurationItemProvider = new FramebufferConfigurationItemProvider(this);
		}

		return framebufferConfigurationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.ImageViews} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageViewsItemProvider imageViewsItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.ImageViews}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImageViewsAdapter()
	{
		if (imageViewsItemProvider == null)
		{
			imageViewsItemProvider = new ImageViewsItemProvider(this);
		}

		return imageViewsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.RenderPass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderPassItemProvider renderPassItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.RenderPass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRenderPassAdapter()
	{
		if (renderPassItemProvider == null)
		{
			renderPassItemProvider = new RenderPassItemProvider(this);
		}

		return renderPassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageAttachmentItemProvider imageAttachmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImageAttachmentAdapter()
	{
		if (imageAttachmentItemProvider == null)
		{
			imageAttachmentItemProvider = new ImageAttachmentItemProvider(this);
		}

		return imageAttachmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepthAttachmentItemProvider depthAttachmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDepthAttachmentAdapter()
	{
		if (depthAttachmentItemProvider == null)
		{
			depthAttachmentItemProvider = new DepthAttachmentItemProvider(this);
		}

		return depthAttachmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorAttachmentItemProvider colorAttachmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createColorAttachmentAdapter()
	{
		if (colorAttachmentItemProvider == null)
		{
			colorAttachmentItemProvider = new ColorAttachmentItemProvider(this);
		}

		return colorAttachmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentPkgItemProvider attachmentPkgItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttachmentPkgAdapter()
	{
		if (attachmentPkgItemProvider == null)
		{
			attachmentPkgItemProvider = new AttachmentPkgItemProvider(this);
		}

		return attachmentPkgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.Subpass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubpassItemProvider subpassItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.Subpass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubpassAdapter()
	{
		if (subpassItemProvider == null)
		{
			subpassItemProvider = new SubpassItemProvider(this);
		}

		return subpassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentRefPkgItemProvider attachmentRefPkgItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttachmentRefPkgAdapter()
	{
		if (attachmentRefPkgItemProvider == null)
		{
			attachmentRefPkgItemProvider = new AttachmentRefPkgItemProvider(this);
		}

		return attachmentRefPkgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentRefItemProvider attachmentRefItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttachmentRefAdapter()
	{
		if (attachmentRefItemProvider == null)
		{
			attachmentRefItemProvider = new AttachmentRefItemProvider(this);
		}

		return attachmentRefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwapImageAttachmentItemProvider swapImageAttachmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSwapImageAttachmentAdapter()
	{
		if (swapImageAttachmentItemProvider == null)
		{
			swapImageAttachmentItemProvider = new SwapImageAttachmentItemProvider(this);
		}

		return swapImageAttachmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicProcessItemProvider graphicProcessItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphicProcessAdapter()
	{
		if (graphicProcessItemProvider == null)
		{
			graphicProcessItemProvider = new GraphicProcessItemProvider(this);
		}

		return graphicProcessItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicsPipelineItemProvider graphicsPipelineItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGraphicsPipelineAdapter()
	{
		if (graphicsPipelineItemProvider == null)
		{
			graphicsPipelineItemProvider = new GraphicsPipelineItemProvider(this);
		}

		return graphicsPipelineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwapImageBarrierItemProvider swapImageBarrierItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSwapImageBarrierAdapter()
	{
		if (swapImageBarrierItemProvider == null)
		{
			swapImageBarrierItemProvider = new SwapImageBarrierItemProvider(this);
		}

		return swapImageBarrierItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlitToSwapImageItemProvider blitToSwapImageItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBlitToSwapImageAdapter()
	{
		if (blitToSwapImageItemProvider == null)
		{
			blitToSwapImageItemProvider = new BlitToSwapImageItemProvider(this);
		}

		return blitToSwapImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.BlitTask} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlitTaskItemProvider blitTaskItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.BlitTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBlitTaskAdapter()
	{
		if (blitTaskItemProvider == null)
		{
			blitTaskItemProvider = new BlitTaskItemProvider(this);
		}

		return blitTaskItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DrawIndexedItemProvider drawIndexedItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDrawIndexedAdapter()
	{
		if (drawIndexedItemProvider == null)
		{
			drawIndexedItemProvider = new DrawIndexedItemProvider(this);
		}

		return drawIndexedItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.Draw} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DrawItemProvider drawItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.Draw}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDrawAdapter()
	{
		if (drawItemProvider == null)
		{
			drawItemProvider = new DrawItemProvider(this);
		}

		return drawItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.VertexInputState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VertexInputStateItemProvider vertexInputStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.VertexInputState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVertexInputStateAdapter()
	{
		if (vertexInputStateItemProvider == null)
		{
			vertexInputStateItemProvider = new VertexInputStateItemProvider(this);
		}

		return vertexInputStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputDescriptorItemProvider inputDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInputDescriptorAdapter()
	{
		if (inputDescriptorItemProvider == null)
		{
			inputDescriptorItemProvider = new InputDescriptorItemProvider(this);
		}

		return inputDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeDescriptionItemProvider attributeDescriptionItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeDescriptionAdapter()
	{
		if (attributeDescriptionItemProvider == null)
		{
			attributeDescriptionItemProvider = new AttributeDescriptionItemProvider(this);
		}

		return attributeDescriptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindVertexBufferItemProvider bindVertexBufferItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBindVertexBufferAdapter()
	{
		if (bindVertexBufferItemProvider == null)
		{
			bindVertexBufferItemProvider = new BindVertexBufferItemProvider(this);
		}

		return bindVertexBufferItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetScissorItemProvider setScissorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSetScissorAdapter()
	{
		if (setScissorItemProvider == null)
		{
			setScissorItemProvider = new SetScissorItemProvider(this);
		}

		return setScissorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetViewportItemProvider setViewportItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSetViewportAdapter()
	{
		if (setViewportItemProvider == null)
		{
			setViewportItemProvider = new SetViewportItemProvider(this);
		}

		return setViewportItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VertexBindingItemProvider vertexBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVertexBindingAdapter()
	{
		if (vertexBindingItemProvider == null)
		{
			vertexBindingItemProvider = new VertexBindingItemProvider(this);
		}

		return vertexBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindIndexBufferItemProvider bindIndexBufferItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBindIndexBufferAdapter()
	{
		if (bindIndexBufferItemProvider == null)
		{
			bindIndexBufferItemProvider = new BindIndexBufferItemProvider(this);
		}

		return bindIndexBufferItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentDescriptorItemProvider attachmentDescriptorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttachmentDescriptorAdapter()
	{
		if (attachmentDescriptorItemProvider == null)
		{
			attachmentDescriptorItemProvider = new AttachmentDescriptorItemProvider(this);
		}

		return attachmentDescriptorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.model.process.graphic.Compositor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositorItemProvider compositorItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.model.process.graphic.Compositor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCompositorAdapter()
	{
		if (compositorItemProvider == null)
		{
			compositorItemProvider = new CompositorItemProvider(this);
		}

		return compositorItemProvider;
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
	 * A child creation extender for the {@link ApplicationPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class ApplicationChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends ApplicationSwitch<Object>
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
			public Object caseScene(Scene object)
			{
				newChildDescriptors.add
					(createChildParameter
						(ApplicationPackage.Literals.SCENE__COMPOSITORS,
						 GraphicFactory.eINSTANCE.createCompositor()));

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
			return LilyVulkanEditPlugin.INSTANCE;
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
						 GraphicFactory.eINSTANCE.createImageAttachment()));

				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.RESOURCE_PKG__RESOURCES,
						 GraphicFactory.eINSTANCE.createDepthAttachment()));

				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.RESOURCE_PKG__RESOURCES,
						 GraphicFactory.eINSTANCE.createColorAttachment()));

				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.RESOURCE_PKG__RESOURCES,
						 GraphicFactory.eINSTANCE.createSwapImageAttachment()));

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
			return LilyVulkanEditPlugin.INSTANCE;
		}
	}

}
