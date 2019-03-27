/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.IExecutionManager;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.Configuration;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage
 * @generated
 */
public class GraphicAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphicPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = GraphicPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicSwitch<Adapter> modelSwitch = new GraphicSwitch<Adapter>()
	{
		@Override
		public Adapter caseGraphicConfiguration(GraphicConfiguration object)
		{
			return createGraphicConfigurationAdapter();
		}

		@Override
		public Adapter caseSwapchainConfiguration(SwapchainConfiguration object)
		{
			return createSwapchainConfigurationAdapter();
		}

		@Override
		public Adapter caseFramebufferConfiguration(FramebufferConfiguration object)
		{
			return createFramebufferConfigurationAdapter();
		}

		@Override
		public Adapter caseISwapAttachment(ISwapAttachment object)
		{
			return createISwapAttachmentAdapter();
		}

		@Override
		public Adapter caseImageAttachment(ImageAttachment object)
		{
			return createImageAttachmentAdapter();
		}

		@Override
		public Adapter caseDepthAttachment(DepthAttachment object)
		{
			return createDepthAttachmentAdapter();
		}

		@Override
		public Adapter caseRenderPassInfo(RenderPassInfo object)
		{
			return createRenderPassInfoAdapter();
		}

		@Override
		public Adapter caseSubpass(Subpass object)
		{
			return createSubpassAdapter();
		}

		@Override
		public Adapter caseAttachementRef(AttachementRef object)
		{
			return createAttachementRefAdapter();
		}

		@Override
		public Adapter caseSubpassDependency(SubpassDependency object)
		{
			return createSubpassDependencyAdapter();
		}

		@Override
		public Adapter caseAttachmentDescription(AttachmentDescription object)
		{
			return createAttachmentDescriptionAdapter();
		}

		@Override
		public Adapter caseSwapImageAttachmentDescription(SwapImageAttachmentDescription object)
		{
			return createSwapImageAttachmentDescriptionAdapter();
		}

		@Override
		public Adapter caseExtraAttachmentDescription(ExtraAttachmentDescription object)
		{
			return createExtraAttachmentDescriptionAdapter();
		}

		@Override
		public Adapter caseGraphicProcess(GraphicProcess object)
		{
			return createGraphicProcessAdapter();
		}

		@Override
		public Adapter caseIGraphicsPipeline(IGraphicsPipeline object)
		{
			return createIGraphicsPipelineAdapter();
		}

		@Override
		public Adapter caseIGUIPipeline(IGUIPipeline object)
		{
			return createIGUIPipelineAdapter();
		}

		@Override
		public Adapter caseAbstractGraphicsPipeline(AbstractGraphicsPipeline object)
		{
			return createAbstractGraphicsPipelineAdapter();
		}

		@Override
		public Adapter caseGraphicsPipeline(GraphicsPipeline object)
		{
			return createGraphicsPipelineAdapter();
		}

		@Override
		public Adapter caseDynamicState(DynamicState object)
		{
			return createDynamicStateAdapter();
		}

		@Override
		public Adapter caseColorBlend(ColorBlend object)
		{
			return createColorBlendAdapter();
		}

		@Override
		public Adapter caseColorBlendAttachment(ColorBlendAttachment object)
		{
			return createColorBlendAttachmentAdapter();
		}

		@Override
		public Adapter caseViewportState(ViewportState object)
		{
			return createViewportStateAdapter();
		}

		@Override
		public Adapter caseStaticViewportState(StaticViewportState object)
		{
			return createStaticViewportStateAdapter();
		}

		@Override
		public Adapter caseDynamicViewportState(DynamicViewportState object)
		{
			return createDynamicViewportStateAdapter();
		}

		@Override
		public Adapter caseViewport(Viewport object)
		{
			return createViewportAdapter();
		}

		@Override
		public Adapter caseScissor(Scissor object)
		{
			return createScissorAdapter();
		}

		@Override
		public Adapter caseRasterizer(Rasterizer object)
		{
			return createRasterizerAdapter();
		}

		@Override
		public Adapter caseImagePipeline(ImagePipeline object)
		{
			return createImagePipelineAdapter();
		}

		@Override
		public Adapter caseConfiguration(Configuration object)
		{
			return createConfigurationAdapter();
		}

		@Override
		public Adapter caseLNamedElement(LNamedElement object)
		{
			return createLNamedElementAdapter();
		}

		@Override
		public Adapter caseIResourceContainer(IResourceContainer object)
		{
			return createIResourceContainerAdapter();
		}

		@Override
		public Adapter caseIExecutionManager(IExecutionManager object)
		{
			return createIExecutionManagerAdapter();
		}

		@Override
		public Adapter caseIProcess(IProcess object)
		{
			return createIProcessAdapter();
		}

		@Override
		public Adapter caseAbstractProcess(AbstractProcess object)
		{
			return createAbstractProcessAdapter();
		}

		@Override
		public Adapter caseIInferenceObject(IInferenceObject object)
		{
			return createIInferenceObjectAdapter();
		}

		@Override
		public Adapter caseLObject(LObject object)
		{
			return createLObjectAdapter();
		}

		@Override
		public Adapter caseIPipeline(IPipeline object)
		{
			return createIPipelineAdapter();
		}

		@Override
		public Adapter caseAbstractPipeline(AbstractPipeline object)
		{
			return createAbstractPipelineAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object)
		{
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration
	 * @generated
	 */
	public Adapter createGraphicConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration <em>Swapchain Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration
	 * @generated
	 */
	public Adapter createSwapchainConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration <em>Framebuffer Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration
	 * @generated
	 */
	public Adapter createFramebufferConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment <em>ISwap Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment
	 * @generated
	 */
	public Adapter createISwapAttachmentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment <em>Image Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment
	 * @generated
	 */
	public Adapter createImageAttachmentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment <em>Depth Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment
	 * @generated
	 */
	public Adapter createDepthAttachmentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo
	 * @generated
	 */
	public Adapter createRenderPassInfoAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass <em>Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Subpass
	 * @generated
	 */
	public Adapter createSubpassAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachementRef <em>Attachement Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachementRef
	 * @generated
	 */
	public Adapter createAttachementRefAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency <em>Subpass Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency
	 * @generated
	 */
	public Adapter createSubpassDependencyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription <em>Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription
	 * @generated
	 */
	public Adapter createAttachmentDescriptionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachmentDescription <em>Swap Image Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachmentDescription
	 * @generated
	 */
	public Adapter createSwapImageAttachmentDescriptionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription <em>Extra Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription
	 * @generated
	 */
	public Adapter createExtraAttachmentDescriptionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess
	 * @generated
	 */
	public Adapter createGraphicProcessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline <em>IGraphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline
	 * @generated
	 */
	public Adapter createIGraphicsPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline <em>IGUI Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline
	 * @generated
	 */
	public Adapter createIGUIPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline <em>Abstract Graphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline
	 * @generated
	 */
	public Adapter createAbstractGraphicsPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline <em>Graphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline
	 * @generated
	 */
	public Adapter createGraphicsPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.DynamicState <em>Dynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DynamicState
	 * @generated
	 */
	public Adapter createDynamicStateAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend <em>Color Blend</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend
	 * @generated
	 */
	public Adapter createColorBlendAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment <em>Color Blend Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment
	 * @generated
	 */
	public Adapter createColorBlendAttachmentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.ViewportState <em>Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ViewportState
	 * @generated
	 */
	public Adapter createViewportStateAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState <em>Static Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState
	 * @generated
	 */
	public Adapter createStaticViewportStateAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState <em>Dynamic Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState
	 * @generated
	 */
	public Adapter createDynamicViewportStateAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.Viewport <em>Viewport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Viewport
	 * @generated
	 */
	public Adapter createViewportAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.Scissor <em>Scissor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Scissor
	 * @generated
	 */
	public Adapter createScissorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer <em>Rasterizer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer
	 * @generated
	 */
	public Adapter createRasterizerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.ImagePipeline <em>Image Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ImagePipeline
	 * @generated
	 */
	public Adapter createImagePipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.types.LNamedElement <em>LNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.types.LNamedElement
	 * @generated
	 */
	public Adapter createLNamedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IResourceContainer <em>IResource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IResourceContainer
	 * @generated
	 */
	public Adapter createIResourceContainerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IExecutionManager <em>IExecution Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IExecutionManager
	 * @generated
	 */
	public Adapter createIExecutionManagerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IProcess <em>IProcess</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IProcess
	 * @generated
	 */
	public Adapter createIProcessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess
	 * @generated
	 */
	public Adapter createAbstractProcessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.inference.IInferenceObject <em>IInference Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.inference.IInferenceObject
	 * @generated
	 */
	public Adapter createIInferenceObjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.root.LObject <em>LObject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.root.LObject
	 * @generated
	 */
	public Adapter createLObjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.IPipeline <em>IPipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline
	 * @generated
	 */
	public Adapter createIPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline <em>Abstract Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractPipeline
	 * @generated
	 */
	public Adapter createAbstractPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //GraphicAdapterFactory
