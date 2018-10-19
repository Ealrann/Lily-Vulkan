/**
 */
package org.sheepy.vulkan.model.process.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.vulkan.model.process.AbstractCompositePipeline;
import org.sheepy.vulkan.model.process.AbstractImageBarrier;
import org.sheepy.vulkan.model.process.AbstractPipeline;
import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.model.process.AttachmentDescription;
import org.sheepy.vulkan.model.process.BufferBarrier;
import org.sheepy.vulkan.model.process.ColorDomain;
import org.sheepy.vulkan.model.process.ComputePipeline;
import org.sheepy.vulkan.model.process.ComputeProcess;
import org.sheepy.vulkan.model.process.ComputeProcessPool;
import org.sheepy.vulkan.model.process.Computer;
import org.sheepy.vulkan.model.process.Configuration;
import org.sheepy.vulkan.model.process.GraphicConfiguration;
import org.sheepy.vulkan.model.process.GraphicProcess;
import org.sheepy.vulkan.model.process.GraphicProcessPool;
import org.sheepy.vulkan.model.process.GraphicsPipeline;
import org.sheepy.vulkan.model.process.IProcessUnit;
import org.sheepy.vulkan.model.process.ImageBarrier;
import org.sheepy.vulkan.model.process.ImagePipeline;
import org.sheepy.vulkan.model.process.ImageTransition;
import org.sheepy.vulkan.model.process.PipelineBarrier;
import org.sheepy.vulkan.model.process.ProcessFactory;
import org.sheepy.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.process.ReferenceImageBarrier;
import org.sheepy.vulkan.model.process.RenderPassInfo;
import org.sheepy.vulkan.model.process.SubpassDependency;

import org.sheepy.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessPackageImpl extends EPackageImpl implements ProcessPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderPassInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subpassDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attachmentDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractProcessPoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computeProcessPoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicProcessPoolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computeProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iProcessUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractImageBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceImageBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractCompositePipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicsPipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computePipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imagePipelineEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sheepy.vulkan.model.process.ProcessPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProcessPackageImpl()
	{
		super(eNS_URI, ProcessFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ProcessPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProcessPackage init()
	{
		if (isInited) return (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredProcessPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ProcessPackageImpl theProcessPackage = registeredProcessPackage instanceof ProcessPackageImpl ? (ProcessPackageImpl)registeredProcessPackage : new ProcessPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProcessPackage.createPackageContents();

		// Initialize created meta-data
		theProcessPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProcessPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProcessPackage.eNS_URI, theProcessPackage);
		return theProcessPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration()
	{
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicConfiguration()
	{
		return graphicConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicConfiguration_ClearBeforeRender()
	{
		return (EAttribute)graphicConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicConfiguration_PresentationMode()
	{
		return (EAttribute)graphicConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicConfiguration_SwapImageUsage()
	{
		return (EAttribute)graphicConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicConfiguration_FrameWaitStage()
	{
		return (EAttribute)graphicConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicConfiguration_ColorDomain()
	{
		return (EReference)graphicConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicConfiguration_RasterizerCullMode()
	{
		return (EAttribute)graphicConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicConfiguration_RasterizerFrontFace()
	{
		return (EAttribute)graphicConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenderPassInfo()
	{
		return renderPassInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenderPassInfo_Attachments()
	{
		return (EReference)renderPassInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenderPassInfo_Dependencies()
	{
		return (EReference)renderPassInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRenderPassInfo_BindPoint()
	{
		return (EAttribute)renderPassInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubpassDependency()
	{
		return subpassDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubpassDependency_SrcSubpass()
	{
		return (EAttribute)subpassDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubpassDependency_DstSubpass()
	{
		return (EAttribute)subpassDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubpassDependency_SrcStageMask()
	{
		return (EAttribute)subpassDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubpassDependency_DstStageMask()
	{
		return (EAttribute)subpassDependencyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubpassDependency_SrcAccessMask()
	{
		return (EAttribute)subpassDependencyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubpassDependency_DstAccessMask()
	{
		return (EAttribute)subpassDependencyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttachmentDescription()
	{
		return attachmentDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_Stencil()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_Samples()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_LoadOp()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_StoreOp()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_StencilLoadOp()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_StencilStoreOp()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_InitialLayout()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_FinalLayout()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttachmentDescription_RefLayout()
	{
		return (EAttribute)attachmentDescriptionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorDomain()
	{
		return colorDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorDomain_Format()
	{
		return (EAttribute)colorDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorDomain_ColorSpace()
	{
		return (EAttribute)colorDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractProcessPool()
	{
		return abstractProcessPoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractProcessPool_Processes()
	{
		return (EReference)abstractProcessPoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractProcessPool_Resources()
	{
		return (EReference)abstractProcessPoolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractProcessPool_ResetAllowed()
	{
		return (EAttribute)abstractProcessPoolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputeProcessPool()
	{
		return computeProcessPoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicProcessPool()
	{
		return graphicProcessPoolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicProcessPool_Configuration()
	{
		return (EReference)graphicProcessPoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicProcessPool_RenderPassInfo()
	{
		return (EReference)graphicProcessPoolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicProcessPool_DepthImage()
	{
		return (EReference)graphicProcessPoolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractProcess()
	{
		return abstractProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractProcess_Units()
	{
		return (EReference)abstractProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicProcess()
	{
		return graphicProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputeProcess()
	{
		return computeProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIProcessUnit()
	{
		return iProcessUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProcessUnit_Enabled()
	{
		return (EAttribute)iProcessUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIProcessUnit_Stage()
	{
		return (EAttribute)iProcessUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPipelineBarrier()
	{
		return pipelineBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipelineBarrier_SrcStage()
	{
		return (EAttribute)pipelineBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPipelineBarrier_DstStage()
	{
		return (EAttribute)pipelineBarrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBufferBarrier()
	{
		return bufferBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBufferBarrier_Buffer()
	{
		return (EReference)bufferBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBufferBarrier_SrcAccess()
	{
		return (EAttribute)bufferBarrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBufferBarrier_DstAccess()
	{
		return (EAttribute)bufferBarrierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractImageBarrier()
	{
		return abstractImageBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractImageBarrier_Transitions()
	{
		return (EReference)abstractImageBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageBarrier()
	{
		return imageBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImageBarrier_Image()
	{
		return (EReference)imageBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceImageBarrier()
	{
		return referenceImageBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceImageBarrier_ImageId()
	{
		return (EAttribute)referenceImageBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceImageBarrier_MipLevels()
	{
		return (EAttribute)referenceImageBarrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceImageBarrier_ImageFormat()
	{
		return (EAttribute)referenceImageBarrierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageTransition()
	{
		return imageTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageTransition_SrcLayout()
	{
		return (EAttribute)imageTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageTransition_DstLayout()
	{
		return (EAttribute)imageTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageTransition_SrcAccess()
	{
		return (EAttribute)imageTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageTransition_DstAccess()
	{
		return (EAttribute)imageTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPipeline()
	{
		return abstractPipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPipeline_DescriptorSet()
	{
		return (EReference)abstractPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPipeline_PushConstant()
	{
		return (EReference)abstractPipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractCompositePipeline()
	{
		return abstractCompositePipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractCompositePipeline_Pipelines()
	{
		return (EReference)abstractCompositePipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicsPipeline()
	{
		return graphicsPipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicsPipeline_Shaders()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputePipeline()
	{
		return computePipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputePipeline_Computers()
	{
		return (EReference)computePipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputePipeline_WorkgroupSizeX()
	{
		return (EAttribute)computePipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputePipeline_WorkgroupSizeY()
	{
		return (EAttribute)computePipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputePipeline_WorkgroupSizeZ()
	{
		return (EAttribute)computePipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputePipeline_Width()
	{
		return (EAttribute)computePipelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputePipeline_Height()
	{
		return (EAttribute)computePipelineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputePipeline_Depth()
	{
		return (EAttribute)computePipelineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputer()
	{
		return computerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputer_Shader()
	{
		return (EReference)computerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImagePipeline()
	{
		return imagePipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImagePipeline_Image()
	{
		return (EReference)imagePipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImagePipeline_ImageSrcStage()
	{
		return (EAttribute)imagePipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImagePipeline_ImageDstStage()
	{
		return (EAttribute)imagePipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImagePipeline_ImageSrcAccess()
	{
		return (EAttribute)imagePipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImagePipeline_ImageDstAccess()
	{
		return (EAttribute)imagePipelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessFactory getProcessFactory()
	{
		return (ProcessFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		configurationEClass = createEClass(CONFIGURATION);

		graphicConfigurationEClass = createEClass(GRAPHIC_CONFIGURATION);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__PRESENTATION_MODE);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE);
		createEReference(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__COLOR_DOMAIN);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE);

		renderPassInfoEClass = createEClass(RENDER_PASS_INFO);
		createEReference(renderPassInfoEClass, RENDER_PASS_INFO__ATTACHMENTS);
		createEReference(renderPassInfoEClass, RENDER_PASS_INFO__DEPENDENCIES);
		createEAttribute(renderPassInfoEClass, RENDER_PASS_INFO__BIND_POINT);

		subpassDependencyEClass = createEClass(SUBPASS_DEPENDENCY);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__SRC_SUBPASS);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__DST_SUBPASS);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__SRC_STAGE_MASK);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__DST_STAGE_MASK);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__SRC_ACCESS_MASK);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__DST_ACCESS_MASK);

		attachmentDescriptionEClass = createEClass(ATTACHMENT_DESCRIPTION);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__STENCIL);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__SAMPLES);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__LOAD_OP);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__STORE_OP);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__FINAL_LAYOUT);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__REF_LAYOUT);

		colorDomainEClass = createEClass(COLOR_DOMAIN);
		createEAttribute(colorDomainEClass, COLOR_DOMAIN__FORMAT);
		createEAttribute(colorDomainEClass, COLOR_DOMAIN__COLOR_SPACE);

		abstractProcessPoolEClass = createEClass(ABSTRACT_PROCESS_POOL);
		createEReference(abstractProcessPoolEClass, ABSTRACT_PROCESS_POOL__PROCESSES);
		createEReference(abstractProcessPoolEClass, ABSTRACT_PROCESS_POOL__RESOURCES);
		createEAttribute(abstractProcessPoolEClass, ABSTRACT_PROCESS_POOL__RESET_ALLOWED);

		computeProcessPoolEClass = createEClass(COMPUTE_PROCESS_POOL);

		graphicProcessPoolEClass = createEClass(GRAPHIC_PROCESS_POOL);
		createEReference(graphicProcessPoolEClass, GRAPHIC_PROCESS_POOL__CONFIGURATION);
		createEReference(graphicProcessPoolEClass, GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO);
		createEReference(graphicProcessPoolEClass, GRAPHIC_PROCESS_POOL__DEPTH_IMAGE);

		abstractProcessEClass = createEClass(ABSTRACT_PROCESS);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__UNITS);

		graphicProcessEClass = createEClass(GRAPHIC_PROCESS);

		computeProcessEClass = createEClass(COMPUTE_PROCESS);

		iProcessUnitEClass = createEClass(IPROCESS_UNIT);
		createEAttribute(iProcessUnitEClass, IPROCESS_UNIT__ENABLED);
		createEAttribute(iProcessUnitEClass, IPROCESS_UNIT__STAGE);

		pipelineBarrierEClass = createEClass(PIPELINE_BARRIER);
		createEAttribute(pipelineBarrierEClass, PIPELINE_BARRIER__SRC_STAGE);
		createEAttribute(pipelineBarrierEClass, PIPELINE_BARRIER__DST_STAGE);

		bufferBarrierEClass = createEClass(BUFFER_BARRIER);
		createEReference(bufferBarrierEClass, BUFFER_BARRIER__BUFFER);
		createEAttribute(bufferBarrierEClass, BUFFER_BARRIER__SRC_ACCESS);
		createEAttribute(bufferBarrierEClass, BUFFER_BARRIER__DST_ACCESS);

		abstractImageBarrierEClass = createEClass(ABSTRACT_IMAGE_BARRIER);
		createEReference(abstractImageBarrierEClass, ABSTRACT_IMAGE_BARRIER__TRANSITIONS);

		imageBarrierEClass = createEClass(IMAGE_BARRIER);
		createEReference(imageBarrierEClass, IMAGE_BARRIER__IMAGE);

		referenceImageBarrierEClass = createEClass(REFERENCE_IMAGE_BARRIER);
		createEAttribute(referenceImageBarrierEClass, REFERENCE_IMAGE_BARRIER__IMAGE_ID);
		createEAttribute(referenceImageBarrierEClass, REFERENCE_IMAGE_BARRIER__MIP_LEVELS);
		createEAttribute(referenceImageBarrierEClass, REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT);

		imageTransitionEClass = createEClass(IMAGE_TRANSITION);
		createEAttribute(imageTransitionEClass, IMAGE_TRANSITION__SRC_LAYOUT);
		createEAttribute(imageTransitionEClass, IMAGE_TRANSITION__DST_LAYOUT);
		createEAttribute(imageTransitionEClass, IMAGE_TRANSITION__SRC_ACCESS);
		createEAttribute(imageTransitionEClass, IMAGE_TRANSITION__DST_ACCESS);

		abstractPipelineEClass = createEClass(ABSTRACT_PIPELINE);
		createEReference(abstractPipelineEClass, ABSTRACT_PIPELINE__DESCRIPTOR_SET);
		createEReference(abstractPipelineEClass, ABSTRACT_PIPELINE__PUSH_CONSTANT);

		abstractCompositePipelineEClass = createEClass(ABSTRACT_COMPOSITE_PIPELINE);
		createEReference(abstractCompositePipelineEClass, ABSTRACT_COMPOSITE_PIPELINE__PIPELINES);

		graphicsPipelineEClass = createEClass(GRAPHICS_PIPELINE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__SHADERS);

		computePipelineEClass = createEClass(COMPUTE_PIPELINE);
		createEReference(computePipelineEClass, COMPUTE_PIPELINE__COMPUTERS);
		createEAttribute(computePipelineEClass, COMPUTE_PIPELINE__WORKGROUP_SIZE_X);
		createEAttribute(computePipelineEClass, COMPUTE_PIPELINE__WORKGROUP_SIZE_Y);
		createEAttribute(computePipelineEClass, COMPUTE_PIPELINE__WORKGROUP_SIZE_Z);
		createEAttribute(computePipelineEClass, COMPUTE_PIPELINE__WIDTH);
		createEAttribute(computePipelineEClass, COMPUTE_PIPELINE__HEIGHT);
		createEAttribute(computePipelineEClass, COMPUTE_PIPELINE__DEPTH);

		computerEClass = createEClass(COMPUTER);
		createEReference(computerEClass, COMPUTER__SHADER);

		imagePipelineEClass = createEClass(IMAGE_PIPELINE);
		createEReference(imagePipelineEClass, IMAGE_PIPELINE__IMAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_SRC_STAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_DST_STAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_SRC_ACCESS);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_DST_ACCESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);

		// Create type parameters
		ETypeParameter abstractProcessPoolEClass_T = addETypeParameter(abstractProcessPoolEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getAbstractProcess());
		abstractProcessPoolEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		graphicConfigurationEClass.getESuperTypes().add(this.getConfiguration());
		g1 = createEGenericType(this.getAbstractProcessPool());
		EGenericType g2 = createEGenericType(this.getComputeProcess());
		g1.getETypeArguments().add(g2);
		computeProcessPoolEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAbstractProcessPool());
		g2 = createEGenericType(this.getGraphicProcess());
		g1.getETypeArguments().add(g2);
		graphicProcessPoolEClass.getEGenericSuperTypes().add(g1);
		graphicProcessEClass.getESuperTypes().add(this.getAbstractProcess());
		computeProcessEClass.getESuperTypes().add(this.getAbstractProcess());
		pipelineBarrierEClass.getESuperTypes().add(this.getIProcessUnit());
		bufferBarrierEClass.getESuperTypes().add(this.getPipelineBarrier());
		abstractImageBarrierEClass.getESuperTypes().add(this.getPipelineBarrier());
		imageBarrierEClass.getESuperTypes().add(this.getAbstractImageBarrier());
		referenceImageBarrierEClass.getESuperTypes().add(this.getAbstractImageBarrier());
		abstractPipelineEClass.getESuperTypes().add(this.getIProcessUnit());
		abstractCompositePipelineEClass.getESuperTypes().add(this.getAbstractPipeline());
		graphicsPipelineEClass.getESuperTypes().add(this.getAbstractPipeline());
		computePipelineEClass.getESuperTypes().add(this.getAbstractPipeline());
		computerEClass.getESuperTypes().add(this.getIProcessUnit());
		imagePipelineEClass.getESuperTypes().add(this.getAbstractPipeline());

		// Initialize classes, features, and operations; add parameters
		initEClass(configurationEClass, Configuration.class, "Configuration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(graphicConfigurationEClass, GraphicConfiguration.class, "GraphicConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphicConfiguration_ClearBeforeRender(), theEcorePackage.getEBoolean(), "clearBeforeRender", "true", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_PresentationMode(), theEnumerationPackage.getEPresentMode(), "presentationMode", "MailBox", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_SwapImageUsage(), theEcorePackage.getEInt(), "swapImageUsage", "16", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_FrameWaitStage(), theEnumerationPackage.getEPipelineStage(), "frameWaitStage", "COLOR_ATTACHMENT_OUTPUT_BIT", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicConfiguration_ColorDomain(), this.getColorDomain(), null, "colorDomain", null, 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_RasterizerCullMode(), theEnumerationPackage.getECullMode(), "rasterizerCullMode", "BACK_BIT", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_RasterizerFrontFace(), theEnumerationPackage.getEFrontFace(), "rasterizerFrontFace", "CLOCKWISE", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderPassInfoEClass, RenderPassInfo.class, "RenderPassInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenderPassInfo_Attachments(), this.getAttachmentDescription(), null, "attachments", null, 0, -1, RenderPassInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRenderPassInfo_Dependencies(), this.getSubpassDependency(), null, "dependencies", null, 0, -1, RenderPassInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenderPassInfo_BindPoint(), theEcorePackage.getEInt(), "bindPoint", "0", 0, 1, RenderPassInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subpassDependencyEClass, SubpassDependency.class, "SubpassDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubpassDependency_SrcSubpass(), theEcorePackage.getEInt(), "srcSubpass", "-1", 0, 1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpassDependency_DstSubpass(), theEcorePackage.getEInt(), "dstSubpass", "0", 0, 1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpassDependency_SrcStageMask(), theEnumerationPackage.getEPipelineStage(), "srcStageMask", "COLOR_ATTACHMENT_OUTPUT_BIT", 0, 1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpassDependency_DstStageMask(), theEnumerationPackage.getEPipelineStage(), "dstStageMask", "COLOR_ATTACHMENT_OUTPUT_BIT", 0, 1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpassDependency_SrcAccessMask(), theEcorePackage.getEInt(), "srcAccessMask", "0", 0, 1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpassDependency_DstAccessMask(), theEcorePackage.getEInt(), "dstAccessMask", "0", 0, 1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attachmentDescriptionEClass, AttachmentDescription.class, "AttachmentDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttachmentDescription_Stencil(), theEcorePackage.getEBoolean(), "stencil", "false", 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_Samples(), theEnumerationPackage.getESampleCount(), "samples", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_LoadOp(), theEnumerationPackage.getEAttachmentLoadOp(), "loadOp", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_StoreOp(), theEnumerationPackage.getEAttachmentStoreOp(), "storeOp", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_StencilLoadOp(), theEnumerationPackage.getEAttachmentLoadOp(), "stencilLoadOp", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_StencilStoreOp(), theEnumerationPackage.getEAttachmentStoreOp(), "stencilStoreOp", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_InitialLayout(), theEnumerationPackage.getEImageLayout(), "initialLayout", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_FinalLayout(), theEnumerationPackage.getEImageLayout(), "finalLayout", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_RefLayout(), theEnumerationPackage.getEImageLayout(), "refLayout", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorDomainEClass, ColorDomain.class, "ColorDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorDomain_Format(), theEnumerationPackage.getEFormat(), "format", "B8G8R8A8_UNORM", 0, 1, ColorDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorDomain_ColorSpace(), theEnumerationPackage.getEColorSpace(), "colorSpace", "SRGB_NONLINEAR_KHR", 0, 1, ColorDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractProcessPoolEClass, AbstractProcessPool.class, "AbstractProcessPool", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(abstractProcessPoolEClass_T);
		initEReference(getAbstractProcessPool_Processes(), g1, null, "processes", null, 0, -1, AbstractProcessPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcessPool_Resources(), theResourcePackage.getResource(), null, "resources", null, 0, -1, AbstractProcessPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractProcessPool_ResetAllowed(), theEcorePackage.getEBoolean(), "resetAllowed", null, 0, 1, AbstractProcessPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computeProcessPoolEClass, ComputeProcessPool.class, "ComputeProcessPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(graphicProcessPoolEClass, GraphicProcessPool.class, "GraphicProcessPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicProcessPool_Configuration(), this.getGraphicConfiguration(), null, "configuration", null, 0, 1, GraphicProcessPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicProcessPool_RenderPassInfo(), this.getRenderPassInfo(), null, "renderPassInfo", null, 0, 1, GraphicProcessPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicProcessPool_DepthImage(), theResourcePackage.getDepthImage(), null, "depthImage", null, 0, 1, GraphicProcessPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractProcessEClass, AbstractProcess.class, "AbstractProcess", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractProcess_Units(), this.getIProcessUnit(), null, "units", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicProcessEClass, GraphicProcess.class, "GraphicProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(computeProcessEClass, ComputeProcess.class, "ComputeProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iProcessUnitEClass, IProcessUnit.class, "IProcessUnit", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIProcessUnit_Enabled(), theEcorePackage.getEBoolean(), "enabled", "true", 0, 1, IProcessUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIProcessUnit_Stage(), theEnumerationPackage.getECommandStage(), "stage", "Render", 0, 1, IProcessUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pipelineBarrierEClass, PipelineBarrier.class, "PipelineBarrier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPipelineBarrier_SrcStage(), theEnumerationPackage.getEPipelineStage(), "srcStage", null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipelineBarrier_DstStage(), theEnumerationPackage.getEPipelineStage(), "dstStage", null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferBarrierEClass, BufferBarrier.class, "BufferBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferBarrier_Buffer(), theResourcePackage.getBuffer(), null, "buffer", null, 0, 1, BufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferBarrier_SrcAccess(), theEcorePackage.getEInt(), "srcAccess", null, 0, 1, BufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBufferBarrier_DstAccess(), theEcorePackage.getEInt(), "dstAccess", null, 0, 1, BufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractImageBarrierEClass, AbstractImageBarrier.class, "AbstractImageBarrier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractImageBarrier_Transitions(), this.getImageTransition(), null, "transitions", null, 0, -1, AbstractImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageBarrierEClass, ImageBarrier.class, "ImageBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageBarrier_Image(), theResourcePackage.getImage(), null, "image", null, 0, 1, ImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceImageBarrierEClass, ReferenceImageBarrier.class, "ReferenceImageBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceImageBarrier_ImageId(), theEcorePackage.getELong(), "imageId", null, 0, 1, ReferenceImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceImageBarrier_MipLevels(), theEcorePackage.getEInt(), "mipLevels", null, 0, 1, ReferenceImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceImageBarrier_ImageFormat(), theEcorePackage.getEInt(), "imageFormat", null, 0, 1, ReferenceImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageTransitionEClass, ImageTransition.class, "ImageTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageTransition_SrcLayout(), theEnumerationPackage.getEImageLayout(), "srcLayout", null, 0, 1, ImageTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageTransition_DstLayout(), theEnumerationPackage.getEImageLayout(), "dstLayout", null, 0, 1, ImageTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageTransition_SrcAccess(), theEcorePackage.getEInt(), "srcAccess", null, 0, 1, ImageTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageTransition_DstAccess(), theEcorePackage.getEInt(), "dstAccess", null, 0, 1, ImageTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractPipelineEClass, AbstractPipeline.class, "AbstractPipeline", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractPipeline_DescriptorSet(), theResourcePackage.getDescriptorSet(), null, "descriptorSet", null, 0, 1, AbstractPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractPipeline_PushConstant(), theResourcePackage.getPushConstant(), null, "pushConstant", null, 0, 1, AbstractPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractCompositePipelineEClass, AbstractCompositePipeline.class, "AbstractCompositePipeline", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractCompositePipeline_Pipelines(), this.getAbstractPipeline(), null, "pipelines", null, 0, -1, AbstractCompositePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicsPipelineEClass, GraphicsPipeline.class, "GraphicsPipeline", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicsPipeline_Shaders(), theResourcePackage.getShader(), null, "shaders", null, 0, -1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computePipelineEClass, ComputePipeline.class, "ComputePipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputePipeline_Computers(), this.getComputer(), null, "computers", null, 0, -1, ComputePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputePipeline_WorkgroupSizeX(), theEcorePackage.getEInt(), "workgroupSizeX", "32", 0, 1, ComputePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputePipeline_WorkgroupSizeY(), theEcorePackage.getEInt(), "workgroupSizeY", "32", 0, 1, ComputePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputePipeline_WorkgroupSizeZ(), theEcorePackage.getEInt(), "workgroupSizeZ", "32", 0, 1, ComputePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputePipeline_Width(), theEcorePackage.getEInt(), "width", null, 0, 1, ComputePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputePipeline_Height(), theEcorePackage.getEInt(), "height", null, 0, 1, ComputePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputePipeline_Depth(), theEcorePackage.getEInt(), "depth", null, 0, 1, ComputePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computerEClass, Computer.class, "Computer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputer_Shader(), theResourcePackage.getShader(), null, "shader", null, 0, 1, Computer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imagePipelineEClass, ImagePipeline.class, "ImagePipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImagePipeline_Image(), theResourcePackage.getImage(), null, "image", null, 1, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageSrcStage(), theEnumerationPackage.getEPipelineStage(), "imageSrcStage", null, 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageDstStage(), theEnumerationPackage.getEPipelineStage(), "imageDstStage", null, 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageSrcAccess(), theEcorePackage.getEInt(), "imageSrcAccess", "0", 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageDstAccess(), theEcorePackage.getEInt(), "imageDstAccess", "0", 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ProcessPackageImpl
