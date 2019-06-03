/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.AttachementRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.pipeline.PipelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicPackageImpl extends EPackageImpl implements GraphicPackage
{
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
	private EClass colorDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swapchainConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass framebufferConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSwapAttachmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageAttachmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass depthAttachmentEClass = null;

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
	private EClass subpassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attachementRefEClass = null;

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
	private EClass swapImageAttachmentDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extraAttachmentDescriptionEClass = null;

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
	private EClass graphicsPipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swapImageBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blitToSwapImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass drawIndexedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass drawEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vertexDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexedVertexDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindVertexBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setScissorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setViewportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vertexBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindIndexBufferEClass = null;

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
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphicPackageImpl()
	{
		super(eNS_URI, GraphicFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraphicPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphicPackage init()
	{
		if (isInited)
			return (GraphicPackage) EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGraphicPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GraphicPackageImpl theGraphicPackage = registeredGraphicPackage instanceof GraphicPackageImpl
				? (GraphicPackageImpl) registeredGraphicPackage
				: new GraphicPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ProcessPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraphicPackage.createPackageContents();

		// Initialize created meta-data
		theGraphicPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphicPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphicPackage.eNS_URI, theGraphicPackage);
		return theGraphicPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphicConfiguration()
	{
		return graphicConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicConfiguration_SwapchainConfiguration()
	{
		return (EReference) graphicConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicConfiguration_FramebufferConfiguration()
	{
		return (EReference) graphicConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicConfiguration_AcquireWaitStage()
	{
		return (EAttribute) graphicConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicConfiguration_ColorDomain()
	{
		return (EReference) graphicConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getColorDomain()
	{
		return colorDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorDomain_Format()
	{
		return (EAttribute) colorDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorDomain_ColorSpace()
	{
		return (EAttribute) colorDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSwapchainConfiguration()
	{
		return swapchainConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSwapchainConfiguration_PresentationMode()
	{
		return (EAttribute) swapchainConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSwapchainConfiguration_RequiredSwapImageCount()
	{
		return (EAttribute) swapchainConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSwapchainConfiguration_SwapImageUsages()
	{
		return (EAttribute) swapchainConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSwapchainConfiguration_Atachments()
	{
		return (EReference) swapchainConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFramebufferConfiguration()
	{
		return framebufferConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFramebufferConfiguration_ClearValue()
	{
		return (EAttribute) framebufferConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getISwapAttachment()
	{
		return iSwapAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImageAttachment()
	{
		return imageAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImageAttachment_ClearValue()
	{
		return (EAttribute) imageAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageAttachment_ImageRef()
	{
		return (EReference) imageAttachmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDepthAttachment()
	{
		return depthAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDepthAttachment_Clear()
	{
		return (EAttribute) depthAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRenderPassInfo()
	{
		return renderPassInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderPassInfo_Attachments()
	{
		return (EReference) renderPassInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderPassInfo_Subpasses()
	{
		return (EReference) renderPassInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderPassInfo_Dependencies()
	{
		return (EReference) renderPassInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRenderPassInfo_BindPoint()
	{
		return (EAttribute) renderPassInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSubpass()
	{
		return subpassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_Name()
	{
		return (EAttribute) subpassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubpass_Refs()
	{
		return (EReference) subpassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttachementRef()
	{
		return attachementRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttachementRef_Attachement()
	{
		return (EReference) attachementRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachementRef_Layout()
	{
		return (EAttribute) attachementRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSubpassDependency()
	{
		return subpassDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubpassDependency_SrcSubpass()
	{
		return (EReference) subpassDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubpassDependency_DstSubpass()
	{
		return (EReference) subpassDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpassDependency_SrcStageMask()
	{
		return (EAttribute) subpassDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpassDependency_DstStageMask()
	{
		return (EAttribute) subpassDependencyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpassDependency_SrcAccesses()
	{
		return (EAttribute) subpassDependencyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpassDependency_DstAccesses()
	{
		return (EAttribute) subpassDependencyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttachmentDescription()
	{
		return attachmentDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentDescription_Samples()
	{
		return (EAttribute) attachmentDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentDescription_LoadOp()
	{
		return (EAttribute) attachmentDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentDescription_StoreOp()
	{
		return (EAttribute) attachmentDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentDescription_StencilLoadOp()
	{
		return (EAttribute) attachmentDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentDescription_StencilStoreOp()
	{
		return (EAttribute) attachmentDescriptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentDescription_InitialLayout()
	{
		return (EAttribute) attachmentDescriptionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentDescription_FinalLayout()
	{
		return (EAttribute) attachmentDescriptionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSwapImageAttachmentDescription()
	{
		return swapImageAttachmentDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExtraAttachmentDescription()
	{
		return extraAttachmentDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExtraAttachmentDescription_Attachment()
	{
		return (EReference) extraAttachmentDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphicProcess()
	{
		return graphicProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicProcess_Configuration()
	{
		return (EReference) graphicProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicProcess_RenderPassInfo()
	{
		return (EReference) graphicProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicProcess_FieldOfViewY()
	{
		return (EAttribute) graphicProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphicsPipeline()
	{
		return graphicsPipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_Shaders()
	{
		return (EReference) graphicsPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_ViewportState()
	{
		return (EReference) graphicsPipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_InputAssembly()
	{
		return (EReference) graphicsPipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_Rasterizer()
	{
		return (EReference) graphicsPipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_ColorBlend()
	{
		return (EReference) graphicsPipelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_DynamicState()
	{
		return (EReference) graphicsPipelineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicsPipeline_Subpass()
	{
		return (EAttribute) graphicsPipelineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_VertexDescriptor()
	{
		return (EReference) graphicsPipelineEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSwapImageBarrier()
	{
		return swapImageBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBlitToSwapImage()
	{
		return blitToSwapImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBlitToSwapImage_Image()
	{
		return (EReference) blitToSwapImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDrawIndexed()
	{
		return drawIndexedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_IndexCount()
	{
		return (EAttribute) drawIndexedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_InstanceCount()
	{
		return (EAttribute) drawIndexedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_FirstIndex()
	{
		return (EAttribute) drawIndexedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_VertexOffset()
	{
		return (EAttribute) drawIndexedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_FirstInstance()
	{
		return (EAttribute) drawIndexedEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDraw()
	{
		return drawEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDraw_VertexCount()
	{
		return (EAttribute) drawEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDraw_InstanceCount()
	{
		return (EAttribute) drawEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDraw_FirstVertex()
	{
		return (EAttribute) drawEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDraw_FirstInstance()
	{
		return (EAttribute) drawEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVertexDescriptor()
	{
		return vertexDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVertexDescriptor_Attributes()
	{
		return (EReference) vertexDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVertexDescriptor_StrideLength()
	{
		return (EAttribute) vertexDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeDescription()
	{
		return attributeDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeDescription_Format()
	{
		return (EAttribute) attributeDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeDescription_Offset()
	{
		return (EAttribute) attributeDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIndexedVertexDescriptor()
	{
		return indexedVertexDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIndexedVertexDescriptor_IndexType()
	{
		return (EAttribute) indexedVertexDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBindVertexBuffer()
	{
		return bindVertexBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBindVertexBuffer_FirstBinding()
	{
		return (EAttribute) bindVertexBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindVertexBuffer_VertexBindings()
	{
		return (EReference) bindVertexBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSetScissor()
	{
		return setScissorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetScissor_OffsetX()
	{
		return (EAttribute) setScissorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetScissor_OffsetY()
	{
		return (EAttribute) setScissorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetScissor_Width()
	{
		return (EAttribute) setScissorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetScissor_Height()
	{
		return (EAttribute) setScissorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSetViewport()
	{
		return setViewportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_X()
	{
		return (EAttribute) setViewportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_Y()
	{
		return (EAttribute) setViewportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_Width()
	{
		return (EAttribute) setViewportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_Height()
	{
		return (EAttribute) setViewportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_MinDepth()
	{
		return (EAttribute) setViewportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_MaxDepth()
	{
		return (EAttribute) setViewportEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVertexBinding()
	{
		return vertexBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVertexBinding_Buffer()
	{
		return (EReference) vertexBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVertexBinding_Offset()
	{
		return (EAttribute) vertexBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBindIndexBuffer()
	{
		return bindIndexBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindIndexBuffer_Buffer()
	{
		return (EReference) bindIndexBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBindIndexBuffer_Offset()
	{
		return (EAttribute) bindIndexBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicFactory getGraphicFactory()
	{
		return (GraphicFactory) getEFactoryInstance();
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
		graphicConfigurationEClass = createEClass(GRAPHIC_CONFIGURATION);
		createEReference(graphicConfigurationEClass,
				GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION);
		createEReference(graphicConfigurationEClass,
				GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE);
		createEReference(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__COLOR_DOMAIN);

		colorDomainEClass = createEClass(COLOR_DOMAIN);
		createEAttribute(colorDomainEClass, COLOR_DOMAIN__FORMAT);
		createEAttribute(colorDomainEClass, COLOR_DOMAIN__COLOR_SPACE);

		swapchainConfigurationEClass = createEClass(SWAPCHAIN_CONFIGURATION);
		createEAttribute(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__PRESENTATION_MODE);
		createEAttribute(swapchainConfigurationEClass,
				SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT);
		createEAttribute(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES);
		createEReference(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__ATACHMENTS);

		framebufferConfigurationEClass = createEClass(FRAMEBUFFER_CONFIGURATION);
		createEAttribute(framebufferConfigurationEClass, FRAMEBUFFER_CONFIGURATION__CLEAR_VALUE);

		iSwapAttachmentEClass = createEClass(ISWAP_ATTACHMENT);

		imageAttachmentEClass = createEClass(IMAGE_ATTACHMENT);
		createEAttribute(imageAttachmentEClass, IMAGE_ATTACHMENT__CLEAR_VALUE);
		createEReference(imageAttachmentEClass, IMAGE_ATTACHMENT__IMAGE_REF);

		depthAttachmentEClass = createEClass(DEPTH_ATTACHMENT);
		createEAttribute(depthAttachmentEClass, DEPTH_ATTACHMENT__CLEAR);

		renderPassInfoEClass = createEClass(RENDER_PASS_INFO);
		createEReference(renderPassInfoEClass, RENDER_PASS_INFO__ATTACHMENTS);
		createEReference(renderPassInfoEClass, RENDER_PASS_INFO__SUBPASSES);
		createEReference(renderPassInfoEClass, RENDER_PASS_INFO__DEPENDENCIES);
		createEAttribute(renderPassInfoEClass, RENDER_PASS_INFO__BIND_POINT);

		subpassEClass = createEClass(SUBPASS);
		createEAttribute(subpassEClass, SUBPASS__NAME);
		createEReference(subpassEClass, SUBPASS__REFS);

		attachementRefEClass = createEClass(ATTACHEMENT_REF);
		createEReference(attachementRefEClass, ATTACHEMENT_REF__ATTACHEMENT);
		createEAttribute(attachementRefEClass, ATTACHEMENT_REF__LAYOUT);

		subpassDependencyEClass = createEClass(SUBPASS_DEPENDENCY);
		createEReference(subpassDependencyEClass, SUBPASS_DEPENDENCY__SRC_SUBPASS);
		createEReference(subpassDependencyEClass, SUBPASS_DEPENDENCY__DST_SUBPASS);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__SRC_STAGE_MASK);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__DST_STAGE_MASK);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__SRC_ACCESSES);
		createEAttribute(subpassDependencyEClass, SUBPASS_DEPENDENCY__DST_ACCESSES);

		attachmentDescriptionEClass = createEClass(ATTACHMENT_DESCRIPTION);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__SAMPLES);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__LOAD_OP);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__STORE_OP);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT);
		createEAttribute(attachmentDescriptionEClass, ATTACHMENT_DESCRIPTION__FINAL_LAYOUT);

		swapImageAttachmentDescriptionEClass = createEClass(SWAP_IMAGE_ATTACHMENT_DESCRIPTION);

		extraAttachmentDescriptionEClass = createEClass(EXTRA_ATTACHMENT_DESCRIPTION);
		createEReference(extraAttachmentDescriptionEClass,
				EXTRA_ATTACHMENT_DESCRIPTION__ATTACHMENT);

		graphicProcessEClass = createEClass(GRAPHIC_PROCESS);
		createEReference(graphicProcessEClass, GRAPHIC_PROCESS__CONFIGURATION);
		createEReference(graphicProcessEClass, GRAPHIC_PROCESS__RENDER_PASS_INFO);
		createEAttribute(graphicProcessEClass, GRAPHIC_PROCESS__FIELD_OF_VIEW_Y);

		graphicsPipelineEClass = createEClass(GRAPHICS_PIPELINE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__SHADERS);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__VIEWPORT_STATE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__INPUT_ASSEMBLY);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__RASTERIZER);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__COLOR_BLEND);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__DYNAMIC_STATE);
		createEAttribute(graphicsPipelineEClass, GRAPHICS_PIPELINE__SUBPASS);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR);

		swapImageBarrierEClass = createEClass(SWAP_IMAGE_BARRIER);

		blitToSwapImageEClass = createEClass(BLIT_TO_SWAP_IMAGE);
		createEReference(blitToSwapImageEClass, BLIT_TO_SWAP_IMAGE__IMAGE);

		drawIndexedEClass = createEClass(DRAW_INDEXED);
		createEAttribute(drawIndexedEClass, DRAW_INDEXED__INDEX_COUNT);
		createEAttribute(drawIndexedEClass, DRAW_INDEXED__INSTANCE_COUNT);
		createEAttribute(drawIndexedEClass, DRAW_INDEXED__FIRST_INDEX);
		createEAttribute(drawIndexedEClass, DRAW_INDEXED__VERTEX_OFFSET);
		createEAttribute(drawIndexedEClass, DRAW_INDEXED__FIRST_INSTANCE);

		drawEClass = createEClass(DRAW);
		createEAttribute(drawEClass, DRAW__VERTEX_COUNT);
		createEAttribute(drawEClass, DRAW__INSTANCE_COUNT);
		createEAttribute(drawEClass, DRAW__FIRST_VERTEX);
		createEAttribute(drawEClass, DRAW__FIRST_INSTANCE);

		vertexDescriptorEClass = createEClass(VERTEX_DESCRIPTOR);
		createEReference(vertexDescriptorEClass, VERTEX_DESCRIPTOR__ATTRIBUTES);
		createEAttribute(vertexDescriptorEClass, VERTEX_DESCRIPTOR__STRIDE_LENGTH);

		attributeDescriptionEClass = createEClass(ATTRIBUTE_DESCRIPTION);
		createEAttribute(attributeDescriptionEClass, ATTRIBUTE_DESCRIPTION__FORMAT);
		createEAttribute(attributeDescriptionEClass, ATTRIBUTE_DESCRIPTION__OFFSET);

		indexedVertexDescriptorEClass = createEClass(INDEXED_VERTEX_DESCRIPTOR);
		createEAttribute(indexedVertexDescriptorEClass, INDEXED_VERTEX_DESCRIPTOR__INDEX_TYPE);

		bindVertexBufferEClass = createEClass(BIND_VERTEX_BUFFER);
		createEAttribute(bindVertexBufferEClass, BIND_VERTEX_BUFFER__FIRST_BINDING);
		createEReference(bindVertexBufferEClass, BIND_VERTEX_BUFFER__VERTEX_BINDINGS);

		setScissorEClass = createEClass(SET_SCISSOR);
		createEAttribute(setScissorEClass, SET_SCISSOR__OFFSET_X);
		createEAttribute(setScissorEClass, SET_SCISSOR__OFFSET_Y);
		createEAttribute(setScissorEClass, SET_SCISSOR__WIDTH);
		createEAttribute(setScissorEClass, SET_SCISSOR__HEIGHT);

		setViewportEClass = createEClass(SET_VIEWPORT);
		createEAttribute(setViewportEClass, SET_VIEWPORT__X);
		createEAttribute(setViewportEClass, SET_VIEWPORT__Y);
		createEAttribute(setViewportEClass, SET_VIEWPORT__WIDTH);
		createEAttribute(setViewportEClass, SET_VIEWPORT__HEIGHT);
		createEAttribute(setViewportEClass, SET_VIEWPORT__MIN_DEPTH);
		createEAttribute(setViewportEClass, SET_VIEWPORT__MAX_DEPTH);

		vertexBindingEClass = createEClass(VERTEX_BINDING);
		createEReference(vertexBindingEClass, VERTEX_BINDING__BUFFER);
		createEAttribute(vertexBindingEClass, VERTEX_BINDING__OFFSET);

		bindIndexBufferEClass = createEClass(BIND_INDEX_BUFFER);
		createEReference(bindIndexBufferEClass, BIND_INDEX_BUFFER__BUFFER);
		createEAttribute(bindIndexBufferEClass, BIND_INDEX_BUFFER__OFFSET);
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
		ProcessPackage theProcessPackage = (ProcessPackage) EPackage.Registry.INSTANCE
				.getEPackage(ProcessPackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage) EPackage.Registry.INSTANCE
				.getEPackage(EnumerationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE
				.getEPackage(TypesPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage) EPackage.Registry.INSTANCE
				.getEPackage(ResourcePackage.eNS_URI);
		MaintainerPackage theMaintainerPackage = (MaintainerPackage) EPackage.Registry.INSTANCE
				.getEPackage(MaintainerPackage.eNS_URI);
		GraphicpipelinePackage theGraphicpipelinePackage = (GraphicpipelinePackage) EPackage.Registry.INSTANCE
				.getEPackage(GraphicpipelinePackage.eNS_URI);
		BarrierPackage theBarrierPackage = (BarrierPackage) EPackage.Registry.INSTANCE
				.getEPackage(BarrierPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		graphicConfigurationEClass.getESuperTypes().add(theProcessPackage.getConfiguration());
		imageAttachmentEClass.getESuperTypes().add(this.getISwapAttachment());
		depthAttachmentEClass.getESuperTypes().add(this.getISwapAttachment());
		attachmentDescriptionEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		swapImageAttachmentDescriptionEClass.getESuperTypes().add(this.getAttachmentDescription());
		extraAttachmentDescriptionEClass.getESuperTypes().add(this.getAttachmentDescription());
		graphicProcessEClass.getESuperTypes().add(theProcessPackage.getAbstractProcess());
		EGenericType g1 = createEGenericType(theProcessPackage.getIPipeline());
		graphicsPipelineEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMaintainerPackage.getMaintainable());
		EGenericType g2 = createEGenericType(this.getGraphicsPipeline());
		g1.getETypeArguments().add(g2);
		graphicsPipelineEClass.getEGenericSuperTypes().add(g1);
		swapImageBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractImageBarrier());
		blitToSwapImageEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		drawIndexedEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		drawEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		attributeDescriptionEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		indexedVertexDescriptorEClass.getESuperTypes().add(this.getVertexDescriptor());
		bindVertexBufferEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		setScissorEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		setViewportEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		bindIndexBufferEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());

		// Initialize classes, features, and operations; add parameters
		initEClass(graphicConfigurationEClass, GraphicConfiguration.class, "GraphicConfiguration",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicConfiguration_SwapchainConfiguration(),
				this.getSwapchainConfiguration(), null, "swapchainConfiguration", null, 1, 1,
				GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getGraphicConfiguration_FramebufferConfiguration(),
				this.getFramebufferConfiguration(), null, "framebufferConfiguration", null, 1, 1,
				GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getGraphicConfiguration_AcquireWaitStage(),
				theEnumerationPackage.getEPipelineStage(), "acquireWaitStage",
				"COLOR_ATTACHMENT_OUTPUT_BIT", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getGraphicConfiguration_ColorDomain(), this.getColorDomain(), null,
				"colorDomain", null, 1, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(colorDomainEClass, ColorDomain.class, "ColorDomain", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorDomain_Format(), theEnumerationPackage.getEFormat(), "format",
				"B8G8R8A8_UNORM", 0, 1, ColorDomain.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorDomain_ColorSpace(), theEnumerationPackage.getEColorSpace(),
				"colorSpace", "SRGB_NONLINEAR_KHR", 0, 1, ColorDomain.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(swapchainConfigurationEClass, SwapchainConfiguration.class,
				"SwapchainConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwapchainConfiguration_PresentationMode(),
				theEnumerationPackage.getEPresentMode(), "presentationMode", "MailBox", 0, 1,
				SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwapchainConfiguration_RequiredSwapImageCount(),
				theEcorePackage.getEInt(), "requiredSwapImageCount", "3", 0, 1,
				SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwapchainConfiguration_SwapImageUsages(),
				theEnumerationPackage.getEImageUsage(), "swapImageUsages", null, 0, -1,
				SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwapchainConfiguration_Atachments(), this.getISwapAttachment(), null,
				"atachments", null, 0, -1, SwapchainConfiguration.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(framebufferConfigurationEClass, FramebufferConfiguration.class,
				"FramebufferConfiguration", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFramebufferConfiguration_ClearValue(), theTypesPackage.getColor4f(),
				"clearValue", "0;0;0;0", 0, 1, FramebufferConfiguration.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(iSwapAttachmentEClass, ISwapAttachment.class, "ISwapAttachment", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imageAttachmentEClass, ImageAttachment.class, "ImageAttachment", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageAttachment_ClearValue(), theTypesPackage.getColor4f(), "clearValue",
				"0;0;0;0", 0, 1, ImageAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImageAttachment_ImageRef(), theResourcePackage.getImage(), null,
				"imageRef", null, 0, 1, ImageAttachment.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(depthAttachmentEClass, DepthAttachment.class, "DepthAttachment", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDepthAttachment_Clear(), theEcorePackage.getEBoolean(), "clear", "true",
				0, 1, DepthAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderPassInfoEClass, RenderPassInfo.class, "RenderPassInfo", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenderPassInfo_Attachments(), this.getAttachmentDescription(), null,
				"attachments", null, 0, -1, RenderPassInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getRenderPassInfo_Subpasses(), this.getSubpass(), null, "subpasses", null, 0,
				-1, RenderPassInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRenderPassInfo_Dependencies(), this.getSubpassDependency(), null,
				"dependencies", null, 0, -1, RenderPassInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenderPassInfo_BindPoint(), theEcorePackage.getEInt(), "bindPoint", "0",
				0, 1, RenderPassInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subpassEClass, Subpass.class, "Subpass", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubpass_Name(), theEcorePackage.getEString(), "name", null, 0, 1,
				Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubpass_Refs(), this.getAttachementRef(), null, "refs", null, 0, -1,
				Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attachementRefEClass, AttachementRef.class, "AttachementRef", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttachementRef_Attachement(), this.getAttachmentDescription(), null,
				"attachement", null, 0, 1, AttachementRef.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachementRef_Layout(), theEnumerationPackage.getEImageLayout(),
				"layout", null, 0, 1, AttachementRef.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subpassDependencyEClass, SubpassDependency.class, "SubpassDependency",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubpassDependency_SrcSubpass(), this.getSubpass(), null, "srcSubpass",
				null, 0, 1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getSubpassDependency_DstSubpass(), this.getSubpass(), null, "dstSubpass",
				null, 0, 1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getSubpassDependency_SrcStageMask(),
				theEnumerationPackage.getEPipelineStage(), "srcStageMask", null, 0, -1,
				SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpassDependency_DstStageMask(),
				theEnumerationPackage.getEPipelineStage(), "dstStageMask", null, 0, -1,
				SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpassDependency_SrcAccesses(), theEnumerationPackage.getEAccess(),
				"srcAccesses", null, 0, -1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpassDependency_DstAccesses(), theEnumerationPackage.getEAccess(),
				"dstAccesses", null, 0, -1, SubpassDependency.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attachmentDescriptionEClass, AttachmentDescription.class,
				"AttachmentDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttachmentDescription_Samples(), theEnumerationPackage.getESampleCount(),
				"samples", null, 0, 1, AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_LoadOp(),
				theEnumerationPackage.getEAttachmentLoadOp(), "loadOp", null, 0, 1,
				AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_StoreOp(),
				theEnumerationPackage.getEAttachmentStoreOp(), "storeOp", null, 0, 1,
				AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_StencilLoadOp(),
				theEnumerationPackage.getEAttachmentLoadOp(), "stencilLoadOp", null, 0, 1,
				AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_StencilStoreOp(),
				theEnumerationPackage.getEAttachmentStoreOp(), "stencilStoreOp", null, 0, 1,
				AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_InitialLayout(),
				theEnumerationPackage.getEImageLayout(), "initialLayout", null, 0, 1,
				AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentDescription_FinalLayout(),
				theEnumerationPackage.getEImageLayout(), "finalLayout", null, 0, 1,
				AttachmentDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swapImageAttachmentDescriptionEClass, SwapImageAttachmentDescription.class,
				"SwapImageAttachmentDescription", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(extraAttachmentDescriptionEClass, ExtraAttachmentDescription.class,
				"ExtraAttachmentDescription", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtraAttachmentDescription_Attachment(), this.getISwapAttachment(), null,
				"attachment", null, 1, 1, ExtraAttachmentDescription.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicProcessEClass, GraphicProcess.class, "GraphicProcess", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicProcess_Configuration(), this.getGraphicConfiguration(), null,
				"configuration", null, 1, 1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicProcess_RenderPassInfo(), this.getRenderPassInfo(), null,
				"renderPassInfo", null, 1, 1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicProcess_FieldOfViewY(), theEcorePackage.getEFloat(),
				"fieldOfViewY", "45", 0, 1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicsPipelineEClass, GraphicsPipeline.class, "GraphicsPipeline", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicsPipeline_Shaders(), theResourcePackage.getShader(), null,
				"shaders", null, 1, -1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_ViewportState(),
				theGraphicpipelinePackage.getViewportState(), null, "viewportState", null, 1, 1,
				GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_InputAssembly(),
				theGraphicpipelinePackage.getInputAssembly(), null, "inputAssembly", null, 1, 1,
				GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_Rasterizer(), theGraphicpipelinePackage.getRasterizer(),
				null, "rasterizer", null, 1, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_ColorBlend(), theGraphicpipelinePackage.getColorBlend(),
				null, "colorBlend", null, 1, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_DynamicState(),
				theGraphicpipelinePackage.getDynamicState(), null, "dynamicState", null, 0, 1,
				GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicsPipeline_Subpass(), theEcorePackage.getEInt(), "subpass", "0", 0,
				1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_VertexDescriptor(), this.getVertexDescriptor(), null,
				"vertexDescriptor", null, 1, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(swapImageBarrierEClass, SwapImageBarrier.class, "SwapImageBarrier", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blitToSwapImageEClass, BlitToSwapImage.class, "BlitToSwapImage", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlitToSwapImage_Image(), theResourcePackage.getImage(), null, "image",
				null, 1, 1, BlitToSwapImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(drawIndexedEClass, DrawIndexed.class, "DrawIndexed", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDrawIndexed_IndexCount(), theEcorePackage.getEInt(), "indexCount", null,
				1, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDrawIndexed_InstanceCount(), theEcorePackage.getEInt(), "instanceCount",
				"1", 0, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDrawIndexed_FirstIndex(), theEcorePackage.getEInt(), "firstIndex", "0", 0,
				1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDrawIndexed_VertexOffset(), theEcorePackage.getEInt(), "vertexOffset",
				"0", 0, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDrawIndexed_FirstInstance(), theEcorePackage.getEInt(), "firstInstance",
				"0", 0, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(drawEClass, Draw.class, "Draw", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDraw_VertexCount(), theEcorePackage.getEInt(), "vertexCount", null, 1, 1,
				Draw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDraw_InstanceCount(), theEcorePackage.getEInt(), "instanceCount", "1", 0,
				1, Draw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDraw_FirstVertex(), theEcorePackage.getEInt(), "firstVertex", "0", 0, 1,
				Draw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDraw_FirstInstance(), theEcorePackage.getEInt(), "firstInstance", "0", 0,
				1, Draw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vertexDescriptorEClass, VertexDescriptor.class, "VertexDescriptor", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVertexDescriptor_Attributes(), this.getAttributeDescription(), null,
				"attributes", null, 1, -1, VertexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getVertexDescriptor_StrideLength(), theEcorePackage.getEInt(),
				"strideLength", null, 0, 1, VertexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeDescriptionEClass, AttributeDescription.class, "AttributeDescription",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeDescription_Format(), theEnumerationPackage.getEFormat(),
				"format", null, 0, 1, AttributeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeDescription_Offset(), theEcorePackage.getEInt(), "offset", null,
				0, 1, AttributeDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexedVertexDescriptorEClass, IndexedVertexDescriptor.class,
				"IndexedVertexDescriptor", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexedVertexDescriptor_IndexType(),
				theEnumerationPackage.getEIndexType(), "indexType", null, 0, 1,
				IndexedVertexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindVertexBufferEClass, BindVertexBuffer.class, "BindVertexBuffer", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindVertexBuffer_FirstBinding(), theEcorePackage.getEInt(),
				"firstBinding", "0", 0, 1, BindVertexBuffer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindVertexBuffer_VertexBindings(), this.getVertexBinding(), null,
				"vertexBindings", null, 1, -1, BindVertexBuffer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(setScissorEClass, SetScissor.class, "SetScissor", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetScissor_OffsetX(), theEcorePackage.getEInt(), "offsetX", "0", 0, 1,
				SetScissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetScissor_OffsetY(), theEcorePackage.getEInt(), "offsetY", "0", 0, 1,
				SetScissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetScissor_Width(), theEcorePackage.getEInt(), "width", null, 0, 1,
				SetScissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetScissor_Height(), theEcorePackage.getEInt(), "height", null, 0, 1,
				SetScissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setViewportEClass, SetViewport.class, "SetViewport", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetViewport_X(), theEcorePackage.getEFloat(), "x", "0", 0, 1,
				SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_Y(), theEcorePackage.getEFloat(), "y", "0", 0, 1,
				SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_Width(), theEcorePackage.getEFloat(), "width", null, 0, 1,
				SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_Height(), theEcorePackage.getEFloat(), "height", null, 0, 1,
				SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_MinDepth(), theEcorePackage.getEFloat(), "minDepth", "1", 0,
				1, SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_MaxDepth(), theEcorePackage.getEFloat(), "maxDepth", "1", 0,
				1, SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vertexBindingEClass, VertexBinding.class, "VertexBinding", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVertexBinding_Buffer(), theResourcePackage.getIBuffer(), null, "buffer",
				null, 1, 1, VertexBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getVertexBinding_Offset(), theEcorePackage.getELong(), "offset", "0", 0, 1,
				VertexBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindIndexBufferEClass, BindIndexBuffer.class, "BindIndexBuffer", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindIndexBuffer_Buffer(), theResourcePackage.getIBuffer(), null, "buffer",
				null, 1, 1, BindIndexBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getBindIndexBuffer_Offset(), theEcorePackage.getELong(), "offset", "0", 0, 1,
				BindIndexBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphicPackageImpl
