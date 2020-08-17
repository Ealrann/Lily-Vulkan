/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
			case GraphicPackage.GRAPHIC_CONFIGURATION: return createGraphicConfiguration();
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER: return createGraphicExecutionManager();
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER: return createGraphicExecutionRecorder();
			case GraphicPackage.COLOR_DOMAIN: return createColorDomain();
			case GraphicPackage.PHYSICAL_SURFACE: return createPhysicalSurface();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION: return createSwapchainConfiguration();
			case GraphicPackage.FRAMEBUFFER_CONFIGURATION: return createFramebufferConfiguration();
			case GraphicPackage.IMAGE_VIEWS: return createImageViews();
			case GraphicPackage.RENDER_PASS: return createRenderPass();
			case GraphicPackage.IMAGE_ATTACHMENT: return createImageAttachment();
			case GraphicPackage.DEPTH_ATTACHMENT: return createDepthAttachment();
			case GraphicPackage.COLOR_ATTACHMENT: return createColorAttachment();
			case GraphicPackage.ATTACHMENT_PKG: return createAttachmentPkg();
			case GraphicPackage.SUBPASS: return createSubpass();
			case GraphicPackage.ATTACHMENT_REF_PKG: return createAttachmentRefPkg();
			case GraphicPackage.ATTACHMENT_REF: return createAttachmentRef();
			case GraphicPackage.SWAP_IMAGE_ATTACHMENT: return createSwapImageAttachment();
			case GraphicPackage.GRAPHIC_PROCESS: return createGraphicProcess();
			case GraphicPackage.GRAPHICS_PIPELINE: return createGraphicsPipeline();
			case GraphicPackage.SWAP_IMAGE_BARRIER: return createSwapImageBarrier();
			case GraphicPackage.BLIT_TO_SWAP_IMAGE: return createBlitToSwapImage();
			case GraphicPackage.BLIT_TASK: return createBlitTask();
			case GraphicPackage.DRAW_INDEXED: return createDrawIndexed();
			case GraphicPackage.DRAW: return createDraw();
			case GraphicPackage.VERTEX_INPUT_STATE: return createVertexInputState();
			case GraphicPackage.INPUT_DESCRIPTOR: return createInputDescriptor();
			case GraphicPackage.ATTRIBUTE_DESCRIPTION: return createAttributeDescription();
			case GraphicPackage.BIND_VERTEX_BUFFER: return createBindVertexBuffer();
			case GraphicPackage.SET_SCISSOR: return createSetScissor();
			case GraphicPackage.SET_VIEWPORT: return createSetViewport();
			case GraphicPackage.VERTEX_BINDING: return createVertexBinding();
			case GraphicPackage.BIND_INDEX_BUFFER: return createBindIndexBuffer();
			case GraphicPackage.COMPOSITOR: return createCompositor();
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
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case GraphicPackage.EATTACHMENT_TYPE:
				return createEAttachmentTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case GraphicPackage.EATTACHMENT_TYPE:
				return convertEAttachmentTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public GraphicExecutionManager createGraphicExecutionManager()
	{
		GraphicExecutionManagerImpl graphicExecutionManager = new GraphicExecutionManagerImpl();
		return graphicExecutionManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicExecutionRecorder createGraphicExecutionRecorder()
	{
		GraphicExecutionRecorderImpl graphicExecutionRecorder = new GraphicExecutionRecorderImpl();
		return graphicExecutionRecorder;
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
	public PhysicalSurface createPhysicalSurface()
	{
		PhysicalSurfaceImpl physicalSurface = new PhysicalSurfaceImpl();
		return physicalSurface;
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
	public ImageViews createImageViews()
	{
		ImageViewsImpl imageViews = new ImageViewsImpl();
		return imageViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderPass createRenderPass()
	{
		RenderPassImpl renderPass = new RenderPassImpl();
		return renderPass;
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
	public ColorAttachment createColorAttachment()
	{
		ColorAttachmentImpl colorAttachment = new ColorAttachmentImpl();
		return colorAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttachmentPkg createAttachmentPkg()
	{
		AttachmentPkgImpl attachmentPkg = new AttachmentPkgImpl();
		return attachmentPkg;
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
	public AttachmentRefPkg createAttachmentRefPkg()
	{
		AttachmentRefPkgImpl attachmentRefPkg = new AttachmentRefPkgImpl();
		return attachmentRefPkg;
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
	public SwapImageAttachment createSwapImageAttachment()
	{
		SwapImageAttachmentImpl swapImageAttachment = new SwapImageAttachmentImpl();
		return swapImageAttachment;
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
	public BlitTask createBlitTask()
	{
		BlitTaskImpl blitTask = new BlitTaskImpl();
		return blitTask;
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
	public Compositor createCompositor()
	{
		CompositorImpl compositor = new CompositorImpl();
		return compositor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttachmentType createEAttachmentTypeFromString(EDataType eDataType, String initialValue)
	{
		EAttachmentType result = EAttachmentType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEAttachmentTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
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
