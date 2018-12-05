/**
 */
package org.sheepy.vulkan.model.process.graphic.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.process.graphic.*;

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
			case GraphicPackage.RENDER_PASS_INFO: return createRenderPassInfo();
			case GraphicPackage.SUBPASS_DEPENDENCY: return createSubpassDependency();
			case GraphicPackage.ATTACHMENT_DESCRIPTION: return createAttachmentDescription();
			case GraphicPackage.GRAPHIC_PROCESS: return createGraphicProcess();
			case GraphicPackage.DYNAMIC_STATE: return createDynamicState();
			case GraphicPackage.COLOR_BLEND: return createColorBlend();
			case GraphicPackage.COLOR_BLEND_ATTACHMENT: return createColorBlendAttachment();
			case GraphicPackage.STATIC_VIEWPORT_STATE: return createStaticViewportState();
			case GraphicPackage.DYNAMIC_VIEWPORT_STATE: return createDynamicViewportState();
			case GraphicPackage.VIEWPORT: return createViewport();
			case GraphicPackage.SCISSOR: return createScissor();
			case GraphicPackage.RASTERIZER: return createRasterizer();
			case GraphicPackage.IMAGE_PIPELINE: return createImagePipeline();
			case GraphicPackage.PIPELINE_IMAGE_BARRIER: return createPipelineImageBarrier();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public AttachmentDescription createAttachmentDescription()
	{
		AttachmentDescriptionImpl attachmentDescription = new AttachmentDescriptionImpl();
		return attachmentDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public ImagePipeline createImagePipeline()
	{
		ImagePipelineImpl imagePipeline = new ImagePipelineImpl();
		return imagePipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipelineImageBarrier createPipelineImageBarrier()
	{
		PipelineImageBarrierImpl pipelineImageBarrier = new PipelineImageBarrierImpl();
		return pipelineImageBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
