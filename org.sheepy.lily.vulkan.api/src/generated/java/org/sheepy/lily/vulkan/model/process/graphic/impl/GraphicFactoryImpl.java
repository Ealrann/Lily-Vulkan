/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.model.process.graphic.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicFactoryImpl extends EFactoryImpl implements GraphicFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphicFactory init()
	{
		try
		{
			GraphicFactory theGraphicFactory = (GraphicFactory)EPackage.Registry.INSTANCE.getEFactory(GraphicPackage.eNS_URI);
			if (theGraphicFactory != null)
			{
				return theGraphicFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphicFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case GraphicPackage.GRAPHIC_CONFIGURATION: return (EObject)createGraphicConfiguration();
			case GraphicPackage.COLOR_DOMAIN: return (EObject)createColorDomain();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION: return (EObject)createSwapchainConfiguration();
			case GraphicPackage.FRAMEBUFFER_CONFIGURATION: return (EObject)createFramebufferConfiguration();
			case GraphicPackage.IMAGE_ATTACHMENT: return (EObject)createImageAttachment();
			case GraphicPackage.DEPTH_ATTACHMENT: return (EObject)createDepthAttachment();
			case GraphicPackage.RENDER_PASS_INFO: return (EObject)createRenderPassInfo();
			case GraphicPackage.SUBPASS: return (EObject)createSubpass();
			case GraphicPackage.ATTACHMENT_REF: return (EObject)createAttachmentRef();
			case GraphicPackage.SUBPASS_DEPENDENCY: return (EObject)createSubpassDependency();
			case GraphicPackage.SWAP_IMAGE_ATTACHMENT_DESCRIPTION: return (EObject)createSwapImageAttachmentDescription();
			case GraphicPackage.EXTRA_ATTACHMENT_DESCRIPTION: return (EObject)createExtraAttachmentDescription();
			case GraphicPackage.GRAPHIC_PROCESS: return (EObject)createGraphicProcess();
			case GraphicPackage.GRAPHICS_PIPELINE: return (EObject)createGraphicsPipeline();
			case GraphicPackage.SWAP_IMAGE_BARRIER: return (EObject)createSwapImageBarrier();
			case GraphicPackage.BLIT_TO_SWAP_IMAGE: return (EObject)createBlitToSwapImage();
			case GraphicPackage.DRAW_INDEXED: return (EObject)createDrawIndexed();
			case GraphicPackage.DRAW: return (EObject)createDraw();
			case GraphicPackage.VERTEX_INPUT_STATE: return (EObject)createVertexInputState();
			case GraphicPackage.INPUT_DESCRIPTOR: return (EObject)createInputDescriptor();
			case GraphicPackage.ATTRIBUTE_DESCRIPTION: return (EObject)createAttributeDescription();
			case GraphicPackage.BIND_VERTEX_BUFFER: return (EObject)createBindVertexBuffer();
			case GraphicPackage.SET_SCISSOR: return (EObject)createSetScissor();
			case GraphicPackage.SET_VIEWPORT: return (EObject)createSetViewport();
			case GraphicPackage.VERTEX_BINDING: return (EObject)createVertexBinding();
			case GraphicPackage.BIND_INDEX_BUFFER: return (EObject)createBindIndexBuffer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicConfiguration createGraphicConfiguration()
	{
		GraphicConfigurationImpl graphicConfiguration = new GraphicConfigurationImpl();
		return graphicConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColorDomain createColorDomain()
	{
		ColorDomainImpl colorDomain = new ColorDomainImpl();
		return colorDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwapchainConfiguration createSwapchainConfiguration()
	{
		SwapchainConfigurationImpl swapchainConfiguration = new SwapchainConfigurationImpl();
		return swapchainConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FramebufferConfiguration createFramebufferConfiguration()
	{
		FramebufferConfigurationImpl framebufferConfiguration = new FramebufferConfigurationImpl();
		return framebufferConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageAttachment createImageAttachment()
	{
		ImageAttachmentImpl imageAttachment = new ImageAttachmentImpl();
		return imageAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DepthAttachment createDepthAttachment()
	{
		DepthAttachmentImpl depthAttachment = new DepthAttachmentImpl();
		return depthAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderPassInfo createRenderPassInfo()
	{
		RenderPassInfoImpl renderPassInfo = new RenderPassInfoImpl();
		return renderPassInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Subpass createSubpass()
	{
		SubpassImpl subpass = new SubpassImpl();
		return subpass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttachmentRef createAttachmentRef()
	{
		AttachmentRefImpl attachmentRef = new AttachmentRefImpl();
		return attachmentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubpassDependency createSubpassDependency()
	{
		SubpassDependencyImpl subpassDependency = new SubpassDependencyImpl();
		return subpassDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwapImageAttachmentDescription createSwapImageAttachmentDescription()
	{
		SwapImageAttachmentDescriptionImpl swapImageAttachmentDescription = new SwapImageAttachmentDescriptionImpl();
		return swapImageAttachmentDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtraAttachmentDescription createExtraAttachmentDescription()
	{
		ExtraAttachmentDescriptionImpl extraAttachmentDescription = new ExtraAttachmentDescriptionImpl();
		return extraAttachmentDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicProcess createGraphicProcess()
	{
		GraphicProcessImpl graphicProcess = new GraphicProcessImpl();
		return graphicProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicsPipeline createGraphicsPipeline()
	{
		GraphicsPipelineImpl graphicsPipeline = new GraphicsPipelineImpl();
		return graphicsPipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwapImageBarrier createSwapImageBarrier()
	{
		SwapImageBarrierImpl swapImageBarrier = new SwapImageBarrierImpl();
		return swapImageBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlitToSwapImage createBlitToSwapImage()
	{
		BlitToSwapImageImpl blitToSwapImage = new BlitToSwapImageImpl();
		return blitToSwapImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DrawIndexed createDrawIndexed()
	{
		DrawIndexedImpl drawIndexed = new DrawIndexedImpl();
		return drawIndexed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Draw createDraw()
	{
		DrawImpl draw = new DrawImpl();
		return draw;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VertexInputState createVertexInputState()
	{
		VertexInputStateImpl vertexInputState = new VertexInputStateImpl();
		return vertexInputState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputDescriptor createInputDescriptor()
	{
		InputDescriptorImpl inputDescriptor = new InputDescriptorImpl();
		return inputDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeDescription createAttributeDescription()
	{
		AttributeDescriptionImpl attributeDescription = new AttributeDescriptionImpl();
		return attributeDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindVertexBuffer createBindVertexBuffer()
	{
		BindVertexBufferImpl bindVertexBuffer = new BindVertexBufferImpl();
		return bindVertexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SetScissor createSetScissor()
	{
		SetScissorImpl setScissor = new SetScissorImpl();
		return setScissor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SetViewport createSetViewport()
	{
		SetViewportImpl setViewport = new SetViewportImpl();
		return setViewport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VertexBinding createVertexBinding()
	{
		VertexBindingImpl vertexBinding = new VertexBindingImpl();
		return vertexBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindIndexBuffer createBindIndexBuffer()
	{
		BindIndexBufferImpl bindIndexBuffer = new BindIndexBufferImpl();
		return bindIndexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicPackage getGraphicPackage()
	{
		return (GraphicPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphicPackage getPackage()
	{
		return GraphicPackage.eINSTANCE;
	}

} //GraphicFactoryImpl
