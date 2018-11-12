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
			case GraphicPackage.GRAPHIC_PROCESS_POOL: return createGraphicProcessPool();
			case GraphicPackage.GRAPHIC_PROCESS: return createGraphicProcess();
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
	public GraphicProcessPool createGraphicProcessPool()
	{
		GraphicProcessPoolImpl graphicProcessPool = new GraphicProcessPoolImpl();
		return graphicProcessPool;
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
