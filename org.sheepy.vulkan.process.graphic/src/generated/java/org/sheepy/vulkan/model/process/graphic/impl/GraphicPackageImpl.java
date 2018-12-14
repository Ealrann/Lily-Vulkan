/**
 */
package org.sheepy.vulkan.model.process.graphic.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.common.model.action.ActionPackage;
import org.sheepy.common.model.application.ApplicationPackage;
import org.sheepy.common.model.inference.InferencePackage;
import org.sheepy.common.model.root.RootPackage;
import org.sheepy.common.model.types.TypesPackage;

import org.sheepy.vulkan.model.VulkanPackage;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.process.graphic.AttachmentDescription;
import org.sheepy.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment;
import org.sheepy.vulkan.model.process.graphic.DynamicState;
import org.sheepy.vulkan.model.process.graphic.DynamicViewportState;
import org.sheepy.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline;
import org.sheepy.vulkan.model.process.graphic.ImagePipeline;
import org.sheepy.vulkan.model.process.graphic.PipelineImageBarrier;
import org.sheepy.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.vulkan.model.process.graphic.Scissor;
import org.sheepy.vulkan.model.process.graphic.StaticViewportState;
import org.sheepy.vulkan.model.process.graphic.SubpassDependency;
import org.sheepy.vulkan.model.process.graphic.Viewport;
import org.sheepy.vulkan.model.process.graphic.ViewportState;

import org.sheepy.vulkan.model.resource.ResourcePackage;

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
	private EClass graphicProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iGraphicsPipelineEClass = null;

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
	private EClass dynamicStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorBlendEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorBlendAttachmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewportStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticViewportStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicViewportStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scissorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rasterizerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imagePipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineImageBarrierEClass = null;

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
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#eNS_URI
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
		if (isInited) return (GraphicPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGraphicPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GraphicPackageImpl theGraphicPackage = registeredGraphicPackage instanceof GraphicPackageImpl ? (GraphicPackageImpl)registeredGraphicPackage : new GraphicPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ProcessPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
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
	public EClass getGraphicProcess()
	{
		return graphicProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicProcess_Configuration()
	{
		return (EReference)graphicProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicProcess_RenderPassInfo()
	{
		return (EReference)graphicProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicProcess_DepthImage()
	{
		return (EReference)graphicProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIGraphicsPipeline()
	{
		return iGraphicsPipelineEClass;
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
	public EReference getGraphicsPipeline_ViewportState()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicsPipeline_Rasterizer()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicsPipeline_ColorBlend()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicsPipeline_DynamicState()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicState()
	{
		return dynamicStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicState_States()
	{
		return (EAttribute)dynamicStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorBlend()
	{
		return colorBlendEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColorBlend_Attachments()
	{
		return (EReference)colorBlendEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlend_LogicOpEnable()
	{
		return (EAttribute)colorBlendEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlend_LogicOp()
	{
		return (EAttribute)colorBlendEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlend_BlendConstant0()
	{
		return (EAttribute)colorBlendEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlend_BlendConstant1()
	{
		return (EAttribute)colorBlendEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlend_BlendConstant2()
	{
		return (EAttribute)colorBlendEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlend_BlendConstant3()
	{
		return (EAttribute)colorBlendEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorBlendAttachment()
	{
		return colorBlendAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_BlendEnable()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_RedComponentEnable()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_GreenComponentEnable()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_BlueComponentEnable()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_AlphaComponentEnable()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_SrcColor()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_DstColor()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_SrcAlpha()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_DstAlpha()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_ColorBlendOp()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorBlendAttachment_AlphaBlendOp()
	{
		return (EAttribute)colorBlendAttachmentEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewportState()
	{
		return viewportStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticViewportState()
	{
		return staticViewportStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStaticViewportState_Viewports()
	{
		return (EReference)staticViewportStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStaticViewportState_Scissors()
	{
		return (EReference)staticViewportStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicViewportState()
	{
		return dynamicViewportStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicViewportState_ViewportCount()
	{
		return (EAttribute)dynamicViewportStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDynamicViewportState_ScissorCount()
	{
		return (EAttribute)dynamicViewportStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewport()
	{
		return viewportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewport_Offset()
	{
		return (EAttribute)viewportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewport_Extent()
	{
		return (EAttribute)viewportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewport_MinDepth()
	{
		return (EAttribute)viewportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewport_MaxDepth()
	{
		return (EAttribute)viewportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScissor()
	{
		return scissorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScissor_Offset()
	{
		return (EAttribute)scissorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScissor_Extent()
	{
		return (EAttribute)scissorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRasterizer()
	{
		return rasterizerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRasterizer_CullMode()
	{
		return (EAttribute)rasterizerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRasterizer_FrontFace()
	{
		return (EAttribute)rasterizerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRasterizer_PolygonMode()
	{
		return (EAttribute)rasterizerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRasterizer_LineWidth()
	{
		return (EAttribute)rasterizerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRasterizer_DepthClampEnable()
	{
		return (EAttribute)rasterizerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRasterizer_DiscardEnable()
	{
		return (EAttribute)rasterizerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRasterizer_DepthBiasEnable()
	{
		return (EAttribute)rasterizerEClass.getEStructuralFeatures().get(6);
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
	public EClass getPipelineImageBarrier()
	{
		return pipelineImageBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPipelineImageBarrier_ImageBarrier()
	{
		return (EReference)pipelineImageBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicFactory getGraphicFactory()
	{
		return (GraphicFactory)getEFactoryInstance();
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
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__PRESENTATION_MODE);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE);
		createEReference(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__COLOR_DOMAIN);

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

		graphicProcessEClass = createEClass(GRAPHIC_PROCESS);
		createEReference(graphicProcessEClass, GRAPHIC_PROCESS__CONFIGURATION);
		createEReference(graphicProcessEClass, GRAPHIC_PROCESS__RENDER_PASS_INFO);
		createEReference(graphicProcessEClass, GRAPHIC_PROCESS__DEPTH_IMAGE);

		iGraphicsPipelineEClass = createEClass(IGRAPHICS_PIPELINE);

		graphicsPipelineEClass = createEClass(GRAPHICS_PIPELINE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__SHADERS);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__VIEWPORT_STATE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__RASTERIZER);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__COLOR_BLEND);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__DYNAMIC_STATE);

		dynamicStateEClass = createEClass(DYNAMIC_STATE);
		createEAttribute(dynamicStateEClass, DYNAMIC_STATE__STATES);

		colorBlendEClass = createEClass(COLOR_BLEND);
		createEReference(colorBlendEClass, COLOR_BLEND__ATTACHMENTS);
		createEAttribute(colorBlendEClass, COLOR_BLEND__LOGIC_OP_ENABLE);
		createEAttribute(colorBlendEClass, COLOR_BLEND__LOGIC_OP);
		createEAttribute(colorBlendEClass, COLOR_BLEND__BLEND_CONSTANT0);
		createEAttribute(colorBlendEClass, COLOR_BLEND__BLEND_CONSTANT1);
		createEAttribute(colorBlendEClass, COLOR_BLEND__BLEND_CONSTANT2);
		createEAttribute(colorBlendEClass, COLOR_BLEND__BLEND_CONSTANT3);

		colorBlendAttachmentEClass = createEClass(COLOR_BLEND_ATTACHMENT);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__BLEND_ENABLE);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__SRC_COLOR);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__DST_COLOR);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__SRC_ALPHA);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__DST_ALPHA);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP);

		viewportStateEClass = createEClass(VIEWPORT_STATE);

		staticViewportStateEClass = createEClass(STATIC_VIEWPORT_STATE);
		createEReference(staticViewportStateEClass, STATIC_VIEWPORT_STATE__VIEWPORTS);
		createEReference(staticViewportStateEClass, STATIC_VIEWPORT_STATE__SCISSORS);

		dynamicViewportStateEClass = createEClass(DYNAMIC_VIEWPORT_STATE);
		createEAttribute(dynamicViewportStateEClass, DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT);
		createEAttribute(dynamicViewportStateEClass, DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT);

		viewportEClass = createEClass(VIEWPORT);
		createEAttribute(viewportEClass, VIEWPORT__OFFSET);
		createEAttribute(viewportEClass, VIEWPORT__EXTENT);
		createEAttribute(viewportEClass, VIEWPORT__MIN_DEPTH);
		createEAttribute(viewportEClass, VIEWPORT__MAX_DEPTH);

		scissorEClass = createEClass(SCISSOR);
		createEAttribute(scissorEClass, SCISSOR__OFFSET);
		createEAttribute(scissorEClass, SCISSOR__EXTENT);

		rasterizerEClass = createEClass(RASTERIZER);
		createEAttribute(rasterizerEClass, RASTERIZER__CULL_MODE);
		createEAttribute(rasterizerEClass, RASTERIZER__FRONT_FACE);
		createEAttribute(rasterizerEClass, RASTERIZER__POLYGON_MODE);
		createEAttribute(rasterizerEClass, RASTERIZER__LINE_WIDTH);
		createEAttribute(rasterizerEClass, RASTERIZER__DEPTH_CLAMP_ENABLE);
		createEAttribute(rasterizerEClass, RASTERIZER__DISCARD_ENABLE);
		createEAttribute(rasterizerEClass, RASTERIZER__DEPTH_BIAS_ENABLE);

		imagePipelineEClass = createEClass(IMAGE_PIPELINE);
		createEReference(imagePipelineEClass, IMAGE_PIPELINE__IMAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_SRC_STAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_DST_STAGE);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_SRC_ACCESS);
		createEAttribute(imagePipelineEClass, IMAGE_PIPELINE__IMAGE_DST_ACCESS);

		pipelineImageBarrierEClass = createEClass(PIPELINE_IMAGE_BARRIER);
		createEReference(pipelineImageBarrierEClass, PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER);
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
		ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		graphicConfigurationEClass.getESuperTypes().add(theProcessPackage.getConfiguration());
		graphicProcessEClass.getESuperTypes().add(theProcessPackage.getAbstractProcess());
		iGraphicsPipelineEClass.getESuperTypes().add(theProcessPackage.getIPipeline());
		graphicsPipelineEClass.getESuperTypes().add(theProcessPackage.getAbstractPipeline());
		graphicsPipelineEClass.getESuperTypes().add(this.getIGraphicsPipeline());
		staticViewportStateEClass.getESuperTypes().add(this.getViewportState());
		dynamicViewportStateEClass.getESuperTypes().add(this.getViewportState());
		imagePipelineEClass.getESuperTypes().add(theProcessPackage.getAbstractPipeline());
		pipelineImageBarrierEClass.getESuperTypes().add(theProcessPackage.getPipelineBarrier());

		// Initialize classes, features, and operations; add parameters
		initEClass(graphicConfigurationEClass, GraphicConfiguration.class, "GraphicConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphicConfiguration_ClearBeforeRender(), theEcorePackage.getEBoolean(), "clearBeforeRender", "true", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_PresentationMode(), theEnumerationPackage.getEPresentMode(), "presentationMode", "MailBox", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_SwapImageUsage(), theEcorePackage.getEInt(), "swapImageUsage", "16", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_FrameWaitStage(), theEnumerationPackage.getEPipelineStage(), "frameWaitStage", "COLOR_ATTACHMENT_OUTPUT_BIT", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicConfiguration_ColorDomain(), theVulkanPackage.getColorDomain(), null, "colorDomain", null, 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(graphicProcessEClass, GraphicProcess.class, "GraphicProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicProcess_Configuration(), this.getGraphicConfiguration(), null, "configuration", null, 0, 1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicProcess_RenderPassInfo(), this.getRenderPassInfo(), null, "renderPassInfo", null, 0, 1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicProcess_DepthImage(), theResourcePackage.getDepthImage(), null, "depthImage", null, 0, 1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iGraphicsPipelineEClass, IGraphicsPipeline.class, "IGraphicsPipeline", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(graphicsPipelineEClass, GraphicsPipeline.class, "GraphicsPipeline", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicsPipeline_Shaders(), theResourcePackage.getShader(), null, "shaders", null, 0, -1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_ViewportState(), this.getViewportState(), null, "viewportState", null, 0, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_Rasterizer(), this.getRasterizer(), null, "rasterizer", null, 0, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_ColorBlend(), this.getColorBlend(), null, "colorBlend", null, 0, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_DynamicState(), this.getDynamicState(), null, "dynamicState", null, 0, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicStateEClass, DynamicState.class, "DynamicState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicState_States(), theEnumerationPackage.getEDynamicState(), "states", null, 0, -1, DynamicState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorBlendEClass, ColorBlend.class, "ColorBlend", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getColorBlend_Attachments(), this.getColorBlendAttachment(), null, "attachments", null, 0, -1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_LogicOpEnable(), theEcorePackage.getEBoolean(), "logicOpEnable", "false", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_LogicOp(), theEnumerationPackage.getELogicOp(), "logicOp", "COPY", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_BlendConstant0(), theEcorePackage.getEInt(), "blendConstant0", "0", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_BlendConstant1(), theEcorePackage.getEInt(), "blendConstant1", "0", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_BlendConstant2(), theEcorePackage.getEInt(), "blendConstant2", "0", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_BlendConstant3(), theEcorePackage.getEInt(), "blendConstant3", "1", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorBlendAttachmentEClass, ColorBlendAttachment.class, "ColorBlendAttachment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorBlendAttachment_BlendEnable(), theEcorePackage.getEBoolean(), "blendEnable", "false", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_RedComponentEnable(), theEcorePackage.getEBoolean(), "redComponentEnable", "true", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_GreenComponentEnable(), theEcorePackage.getEBoolean(), "greenComponentEnable", "true", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_BlueComponentEnable(), theEcorePackage.getEBoolean(), "blueComponentEnable", "true", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_AlphaComponentEnable(), theEcorePackage.getEBoolean(), "alphaComponentEnable", "true", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_SrcColor(), theEnumerationPackage.getEBlendFactor(), "srcColor", "ONE", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_DstColor(), theEnumerationPackage.getEBlendFactor(), "dstColor", "ZERO", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_SrcAlpha(), theEnumerationPackage.getEBlendFactor(), "srcAlpha", "ONE", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_DstAlpha(), theEnumerationPackage.getEBlendFactor(), "dstAlpha", "ZERO", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_ColorBlendOp(), theEnumerationPackage.getEBlendOp(), "colorBlendOp", "ADD", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_AlphaBlendOp(), theEnumerationPackage.getEBlendOp(), "alphaBlendOp", "ADD", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewportStateEClass, ViewportState.class, "ViewportState", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(staticViewportStateEClass, StaticViewportState.class, "StaticViewportState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStaticViewportState_Viewports(), this.getViewport(), null, "viewports", null, 0, -1, StaticViewportState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStaticViewportState_Scissors(), this.getScissor(), null, "scissors", null, 0, -1, StaticViewportState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicViewportStateEClass, DynamicViewportState.class, "DynamicViewportState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicViewportState_ViewportCount(), theEcorePackage.getEInt(), "viewportCount", null, 0, 1, DynamicViewportState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDynamicViewportState_ScissorCount(), theEcorePackage.getEInt(), "scissorCount", null, 0, 1, DynamicViewportState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewportEClass, Viewport.class, "Viewport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewport_Offset(), theTypesPackage.getSVector2i(), "offset", "0, 0", 0, 1, Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewport_Extent(), theTypesPackage.getSVector2i(), "extent", null, 0, 1, Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewport_MinDepth(), theEcorePackage.getEInt(), "minDepth", "0", 0, 1, Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewport_MaxDepth(), theEcorePackage.getEInt(), "maxDepth", "1", 0, 1, Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scissorEClass, Scissor.class, "Scissor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScissor_Offset(), theTypesPackage.getSVector2i(), "offset", "0, 0", 0, 1, Scissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScissor_Extent(), theTypesPackage.getSVector2i(), "extent", null, 0, 1, Scissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rasterizerEClass, Rasterizer.class, "Rasterizer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRasterizer_CullMode(), theEnumerationPackage.getECullMode(), "cullMode", "BACK_BIT", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_FrontFace(), theEnumerationPackage.getEFrontFace(), "frontFace", "CLOCKWISE", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_PolygonMode(), theEnumerationPackage.getEPolygonMode(), "polygonMode", "FILL", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_LineWidth(), theEcorePackage.getEInt(), "lineWidth", "1", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_DepthClampEnable(), theEcorePackage.getEBoolean(), "depthClampEnable", "false", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_DiscardEnable(), theEcorePackage.getEBoolean(), "discardEnable", "false", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_DepthBiasEnable(), theEcorePackage.getEBoolean(), "depthBiasEnable", "false", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imagePipelineEClass, ImagePipeline.class, "ImagePipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImagePipeline_Image(), theResourcePackage.getImage(), null, "image", null, 1, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageSrcStage(), theEnumerationPackage.getEPipelineStage(), "imageSrcStage", null, 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageDstStage(), theEnumerationPackage.getEPipelineStage(), "imageDstStage", null, 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageSrcAccess(), theEcorePackage.getEInt(), "imageSrcAccess", "0", 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagePipeline_ImageDstAccess(), theEcorePackage.getEInt(), "imageDstAccess", "0", 0, 1, ImagePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pipelineImageBarrierEClass, PipelineImageBarrier.class, "PipelineImageBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipelineImageBarrier_ImageBarrier(), theResourcePackage.getImageBarrier(), null, "imageBarrier", null, 0, 1, PipelineImageBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphicPackageImpl
