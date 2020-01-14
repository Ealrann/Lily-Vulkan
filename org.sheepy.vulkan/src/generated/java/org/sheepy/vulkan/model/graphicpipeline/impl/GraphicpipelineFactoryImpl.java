/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.graphicpipeline.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicpipelineFactoryImpl extends EFactoryImpl implements GraphicpipelineFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphicpipelineFactory init()
	{
		try
		{
			GraphicpipelineFactory theGraphicpipelineFactory = (GraphicpipelineFactory)EPackage.Registry.INSTANCE.getEFactory(GraphicpipelinePackage.eNS_URI);
			if (theGraphicpipelineFactory != null)
			{
				return theGraphicpipelineFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphicpipelineFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicpipelineFactoryImpl()
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
			case GraphicpipelinePackage.COLOR_BLEND: return createColorBlend();
			case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT: return createColorBlendAttachment();
			case GraphicpipelinePackage.INPUT_ASSEMBLY: return createInputAssembly();
			case GraphicpipelinePackage.RASTERIZER: return createRasterizer();
			case GraphicpipelinePackage.DYNAMIC_STATE: return createDynamicState();
			case GraphicpipelinePackage.STATIC_VIEWPORT_STATE: return createStaticViewportState();
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE: return createDynamicViewportState();
			case GraphicpipelinePackage.VEC2_I: return createVec2I();
			case GraphicpipelinePackage.VIEWPORT: return createViewport();
			case GraphicpipelinePackage.SCISSOR: return createScissor();
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE: return createDepthStencilState();
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
	public Vec2I createVec2I()
	{
		Vec2IImpl vec2I = new Vec2IImpl();
		return vec2I;
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
	public DepthStencilState createDepthStencilState()
	{
		DepthStencilStateImpl depthStencilState = new DepthStencilStateImpl();
		return depthStencilState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicpipelinePackage getGraphicpipelinePackage()
	{
		return (GraphicpipelinePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphicpipelinePackage getPackage()
	{
		return GraphicpipelinePackage.eINSTANCE;
	}

} //GraphicpipelineFactoryImpl
