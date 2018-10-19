/**
 */
package org.sheepy.vulkan.model.process.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.vulkan.model.process.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessFactoryImpl extends EFactoryImpl implements ProcessFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessFactory init()
	{
		try
		{
			ProcessFactory theProcessFactory = (ProcessFactory)EPackage.Registry.INSTANCE.getEFactory(ProcessPackage.eNS_URI);
			if (theProcessFactory != null)
			{
				return theProcessFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProcessFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessFactoryImpl()
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
			case ProcessPackage.GRAPHIC_CONFIGURATION: return createGraphicConfiguration();
			case ProcessPackage.RENDER_PASS_INFO: return createRenderPassInfo();
			case ProcessPackage.SUBPASS_DEPENDENCY: return createSubpassDependency();
			case ProcessPackage.ATTACHMENT_DESCRIPTION: return createAttachmentDescription();
			case ProcessPackage.COLOR_DOMAIN: return createColorDomain();
			case ProcessPackage.COMPUTE_PROCESS_POOL: return createComputeProcessPool();
			case ProcessPackage.GRAPHIC_PROCESS_POOL: return createGraphicProcessPool();
			case ProcessPackage.GRAPHIC_PROCESS: return createGraphicProcess();
			case ProcessPackage.COMPUTE_PROCESS: return createComputeProcess();
			case ProcessPackage.BUFFER_BARRIER: return createBufferBarrier();
			case ProcessPackage.IMAGE_BARRIER: return createImageBarrier();
			case ProcessPackage.REFERENCE_IMAGE_BARRIER: return createReferenceImageBarrier();
			case ProcessPackage.IMAGE_TRANSITION: return createImageTransition();
			case ProcessPackage.COMPUTE_PIPELINE: return createComputePipeline();
			case ProcessPackage.COMPUTER: return createComputer();
			case ProcessPackage.IMAGE_PIPELINE: return createImagePipeline();
			case ProcessPackage.MESH_PIPELINE: return createMeshPipeline();
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
	public ComputeProcessPool createComputeProcessPool()
	{
		ComputeProcessPoolImpl computeProcessPool = new ComputeProcessPoolImpl();
		return computeProcessPool;
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
	public ComputeProcess createComputeProcess()
	{
		ComputeProcessImpl computeProcess = new ComputeProcessImpl();
		return computeProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferBarrier createBufferBarrier()
	{
		BufferBarrierImpl bufferBarrier = new BufferBarrierImpl();
		return bufferBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageBarrier createImageBarrier()
	{
		ImageBarrierImpl imageBarrier = new ImageBarrierImpl();
		return imageBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceImageBarrier createReferenceImageBarrier()
	{
		ReferenceImageBarrierImpl referenceImageBarrier = new ReferenceImageBarrierImpl();
		return referenceImageBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageTransition createImageTransition()
	{
		ImageTransitionImpl imageTransition = new ImageTransitionImpl();
		return imageTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputePipeline createComputePipeline()
	{
		ComputePipelineImpl computePipeline = new ComputePipelineImpl();
		return computePipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Computer createComputer()
	{
		ComputerImpl computer = new ComputerImpl();
		return computer;
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
	public MeshPipeline createMeshPipeline()
	{
		MeshPipelineImpl meshPipeline = new MeshPipelineImpl();
		return meshPipeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessPackage getProcessPackage()
	{
		return (ProcessPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProcessPackage getPackage()
	{
		return ProcessPackage.eINSTANCE;
	}

} //ProcessFactoryImpl
