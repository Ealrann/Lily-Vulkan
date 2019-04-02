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
			GraphicFactory theGraphicFactory = (GraphicFactory) EPackage.Registry.INSTANCE
					.getEFactory(GraphicPackage.eNS_URI);
			if (theGraphicFactory != null)
			{
				return theGraphicFactory;
			}
		} catch (Exception exception)
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
		case GraphicPackage.GRAPHIC_CONFIGURATION:
			return createGraphicConfiguration();
		case GraphicPackage.SWAPCHAIN_CONFIGURATION:
			return createSwapchainConfiguration();
		case GraphicPackage.FRAMEBUFFER_CONFIGURATION:
			return createFramebufferConfiguration();
		case GraphicPackage.IMAGE_ATTACHMENT:
			return createImageAttachment();
		case GraphicPackage.DEPTH_ATTACHMENT:
			return createDepthAttachment();
		case GraphicPackage.RENDER_PASS_INFO:
			return createRenderPassInfo();
		case GraphicPackage.SUBPASS:
			return createSubpass();
		case GraphicPackage.ATTACHEMENT_REF:
			return createAttachementRef();
		case GraphicPackage.SUBPASS_DEPENDENCY:
			return createSubpassDependency();
		case GraphicPackage.SWAP_IMAGE_ATTACHMENT_DESCRIPTION:
			return createSwapImageAttachmentDescription();
		case GraphicPackage.EXTRA_ATTACHMENT_DESCRIPTION:
			return createExtraAttachmentDescription();
		case GraphicPackage.GRAPHIC_PROCESS:
			return createGraphicProcess();
		case GraphicPackage.GRAPHICS_PIPELINE:
			return createGraphicsPipeline();
		case GraphicPackage.DYNAMIC_STATE:
			return createDynamicState();
		case GraphicPackage.COLOR_BLEND:
			return createColorBlend();
		case GraphicPackage.COLOR_BLEND_ATTACHMENT:
			return createColorBlendAttachment();
		case GraphicPackage.STATIC_VIEWPORT_STATE:
			return createStaticViewportState();
		case GraphicPackage.DYNAMIC_VIEWPORT_STATE:
			return createDynamicViewportState();
		case GraphicPackage.VIEWPORT:
			return createViewport();
		case GraphicPackage.SCISSOR:
			return createScissor();
		case GraphicPackage.RASTERIZER:
			return createRasterizer();
		case GraphicPackage.INPUT_ASSEMBLY:
			return createInputAssembly();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier");
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
	public AttachementRef createAttachementRef()
	{
		AttachementRefImpl attachementRef = new AttachementRefImpl();
		return attachementRef;
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
	public DynamicState createDynamicState()
	{
		DynamicStateImpl dynamicState = new DynamicStateImpl();
		return dynamicState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColorBlend createColorBlend()
	{
		ColorBlendImpl colorBlend = new ColorBlendImpl();
		return colorBlend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColorBlendAttachment createColorBlendAttachment()
	{
		ColorBlendAttachmentImpl colorBlendAttachment = new ColorBlendAttachmentImpl();
		return colorBlendAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StaticViewportState createStaticViewportState()
	{
		StaticViewportStateImpl staticViewportState = new StaticViewportStateImpl();
		return staticViewportState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DynamicViewportState createDynamicViewportState()
	{
		DynamicViewportStateImpl dynamicViewportState = new DynamicViewportStateImpl();
		return dynamicViewportState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Viewport createViewport()
	{
		ViewportImpl viewport = new ViewportImpl();
		return viewport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Scissor createScissor()
	{
		ScissorImpl scissor = new ScissorImpl();
		return scissor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Rasterizer createRasterizer()
	{
		RasterizerImpl rasterizer = new RasterizerImpl();
		return rasterizer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputAssembly createInputAssembly()
	{
		InputAssemblyImpl inputAssembly = new InputAssemblyImpl();
		return inputAssembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicPackage getGraphicPackage()
	{
		return (GraphicPackage) getEPackage();
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
