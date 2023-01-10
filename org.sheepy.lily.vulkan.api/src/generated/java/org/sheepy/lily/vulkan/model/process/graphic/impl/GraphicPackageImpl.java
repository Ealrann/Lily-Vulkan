/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sheepy.lily.core.model.action.ActionPackage;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.inference.InferencePackage;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl;
import org.sheepy.lily.vulkan.model.process.graphic.AbstractBlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.Compositor;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.image.ImagePackage;
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
	private EClass graphicExecutionManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicExecutionRecorderEClass = null;

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
	private EClass physicalSurfaceEClass = null;

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
	private EClass imageViewsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderPassEClass = null;

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
	private EClass colorAttachmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attachmentPkgEClass = null;

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
	private EClass attachmentRefPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attachmentRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attachmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass swapImageAttachmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extraAttachmentEClass = null;

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
	private EClass abstractBlitTaskEClass = null;

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
	private EClass blitTaskEClass = null;

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
	private EClass vertexInputStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputDescriptorEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicCommandBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eAttachmentTypeEEnum = null;

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
		if (isInited) return (GraphicPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGraphicPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GraphicPackageImpl theGraphicPackage = registeredGraphicPackage instanceof GraphicPackageImpl ? (GraphicPackageImpl)registeredGraphicPackage : new GraphicPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ResourcePackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ComputePackage.eNS_URI);
		ComputePackageImpl theComputePackage = (ComputePackageImpl)(registeredPackage instanceof ComputePackageImpl ? registeredPackage : ComputePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(registeredPackage instanceof ProcessPackageImpl ? registeredPackage : ProcessPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VulkanPackageImpl theVulkanPackage = (VulkanPackageImpl)(registeredPackage instanceof VulkanPackageImpl ? registeredPackage : VulkanPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);
		VulkanResourcePackageImpl theVulkanResourcePackage = (VulkanResourcePackageImpl)(registeredPackage instanceof VulkanResourcePackageImpl ? registeredPackage : VulkanResourcePackage.eINSTANCE);

		// Create package meta-data objects
		theGraphicPackage.createPackageContents();
		theComputePackage.createPackageContents();
		theProcessPackage.createPackageContents();
		theVulkanPackage.createPackageContents();
		theVulkanResourcePackage.createPackageContents();

		// Initialize created meta-data
		theGraphicPackage.initializePackageContents();
		theComputePackage.initializePackageContents();
		theProcessPackage.initializePackageContents();
		theVulkanPackage.initializePackageContents();
		theVulkanResourcePackage.initializePackageContents();

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
		return (EReference)graphicConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicConfiguration_FramebufferConfiguration()
	{
		return (EReference)graphicConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicConfiguration_AcquireWaitStage()
	{
		return (EAttribute)graphicConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicConfiguration_Surface()
	{
		return (EReference)graphicConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicConfiguration_RenderPass()
	{
		return (EReference)graphicConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicConfiguration_ImageViews()
	{
		return (EReference)graphicConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphicExecutionManager()
	{
		return graphicExecutionManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicExecutionManager_Recorders()
	{
		return (EReference)graphicExecutionManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicExecutionManager_CommandBuffers()
	{
		return (EReference)graphicExecutionManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphicExecutionRecorder()
	{
		return graphicExecutionRecorderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicExecutionRecorder_CommandBuffers()
	{
		return (EReference)graphicExecutionRecorderEClass.getEStructuralFeatures().get(0);
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
		return (EAttribute)colorDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorDomain_ColorSpace()
	{
		return (EAttribute)colorDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPhysicalSurface()
	{
		return physicalSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPhysicalSurface_ColorDomain()
	{
		return (EReference)physicalSurfaceEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getSwapchainConfiguration_RequiredSwapImageCount()
	{
		return (EAttribute)swapchainConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSwapchainConfiguration_SwapImageUsages()
	{
		return (EAttribute)swapchainConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSwapchainConfiguration_PresentWhenVBlank()
	{
		return (EAttribute)swapchainConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSwapchainConfiguration_AcquireWaitForVBlank()
	{
		return (EAttribute)swapchainConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSwapchainConfiguration_AllowingAccessFromCompute()
	{
		return (EAttribute)swapchainConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSwapchainConfiguration_ColorAttachment()
	{
		return (EReference)swapchainConfigurationEClass.getEStructuralFeatures().get(5);
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
	public EClass getImageViews()
	{
		return imageViewsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRenderPass()
	{
		return renderPassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderPass_Attachments()
	{
		return (EReference)renderPassEClass.getEStructuralFeatures().get(0);
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
		return (EAttribute)imageAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImageAttachment_ImageRef()
	{
		return (EReference)imageAttachmentEClass.getEStructuralFeatures().get(1);
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
		return (EAttribute)depthAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDepthAttachment_Usages()
	{
		return (EAttribute)depthAttachmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getColorAttachment()
	{
		return colorAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorAttachment_ClearValue()
	{
		return (EAttribute)colorAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorAttachment_Usages()
	{
		return (EAttribute)colorAttachmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorAttachment_Format()
	{
		return (EAttribute)colorAttachmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttachmentPkg()
	{
		return attachmentPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttachmentPkg_ExtraAttachments()
	{
		return (EReference)attachmentPkgEClass.getEStructuralFeatures().get(0);
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
	public EReference getSubpass_AttachmentRefPkg()
	{
		return (EReference)subpassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubpass_AttachmentPkg()
	{
		return (EReference)subpassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_SubpassIndex()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubpass_PipelinePkg()
	{
		return (EReference)subpassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_BindPoint()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubpass_Compositor()
	{
		return (EReference)subpassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_WaitForStage()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_SyncStage()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_FinishStage()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_WaitForAccesses()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_SyncAccesses()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_FinishAccesses()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSubpass_ExtensionPkg()
	{
		return (EReference)subpassEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSubpass_Enabled()
	{
		return (EAttribute)subpassEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttachmentRefPkg()
	{
		return attachmentRefPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttachmentRefPkg_AttachmentRefs()
	{
		return (EReference)attachmentRefPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttachmentRef()
	{
		return attachmentRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttachmentRef_Attachment()
	{
		return (EReference)attachmentRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentRef_Layout()
	{
		return (EAttribute)attachmentRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachmentRef_Type()
	{
		return (EAttribute)attachmentRefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttachment()
	{
		return attachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachment_Samples()
	{
		return (EAttribute)attachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachment_LoadOp()
	{
		return (EAttribute)attachmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachment_StoreOp()
	{
		return (EAttribute)attachmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachment_StencilLoadOp()
	{
		return (EAttribute)attachmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachment_StencilStoreOp()
	{
		return (EAttribute)attachmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachment_InitialLayout()
	{
		return (EAttribute)attachmentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttachment_FinalLayout()
	{
		return (EAttribute)attachmentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSwapImageAttachment()
	{
		return swapImageAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSwapImageAttachment_ClearValue()
	{
		return (EAttribute)swapImageAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExtraAttachment()
	{
		return extraAttachmentEClass;
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
		return (EReference)graphicProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicProcess_AttachmentPkg()
	{
		return (EReference)graphicProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicProcess_Subpasses()
	{
		return (EReference)graphicProcessEClass.getEStructuralFeatures().get(2);
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
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_ViewportState()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_InputAssembly()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_Rasterizer()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_ColorBlend()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_DynamicState()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_VertexInputState()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicsPipeline_DepthStencilState()
	{
		return (EReference)graphicsPipelineEClass.getEStructuralFeatures().get(7);
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
	public EClass getAbstractBlitTask()
	{
		return abstractBlitTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractBlitTask_Filter()
	{
		return (EAttribute)abstractBlitTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractBlitTask_ClearColor()
	{
		return (EAttribute)abstractBlitTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractBlitTask_SrcImage()
	{
		return (EReference)abstractBlitTaskEClass.getEStructuralFeatures().get(2);
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
	public EClass getBlitTask()
	{
		return blitTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBlitTask_DstImage()
	{
		return (EReference)blitTaskEClass.getEStructuralFeatures().get(0);
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
		return (EAttribute)drawIndexedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_InstanceCount()
	{
		return (EAttribute)drawIndexedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_FirstIndex()
	{
		return (EAttribute)drawIndexedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_VertexOffset()
	{
		return (EAttribute)drawIndexedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDrawIndexed_FirstInstance()
	{
		return (EAttribute)drawIndexedEClass.getEStructuralFeatures().get(4);
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
		return (EAttribute)drawEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDraw_InstanceCount()
	{
		return (EAttribute)drawEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDraw_FirstVertex()
	{
		return (EAttribute)drawEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDraw_FirstInstance()
	{
		return (EAttribute)drawEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVertexInputState()
	{
		return vertexInputStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVertexInputState_InputDescriptor()
	{
		return (EReference)vertexInputStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInputDescriptor()
	{
		return inputDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInputDescriptor_InputRate()
	{
		return (EAttribute)inputDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInputDescriptor_StrideLength()
	{
		return (EAttribute)inputDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInputDescriptor_Attributes()
	{
		return (EReference)inputDescriptorEClass.getEStructuralFeatures().get(2);
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
		return (EAttribute)attributeDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeDescription_Offset()
	{
		return (EAttribute)attributeDescriptionEClass.getEStructuralFeatures().get(1);
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
		return (EAttribute)bindVertexBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindVertexBuffer_VertexBindings()
	{
		return (EReference)bindVertexBufferEClass.getEStructuralFeatures().get(1);
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
		return (EAttribute)setScissorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetScissor_OffsetY()
	{
		return (EAttribute)setScissorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetScissor_Width()
	{
		return (EAttribute)setScissorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetScissor_Height()
	{
		return (EAttribute)setScissorEClass.getEStructuralFeatures().get(3);
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
		return (EAttribute)setViewportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_Y()
	{
		return (EAttribute)setViewportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_Width()
	{
		return (EAttribute)setViewportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_Height()
	{
		return (EAttribute)setViewportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_MinDepth()
	{
		return (EAttribute)setViewportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetViewport_MaxDepth()
	{
		return (EAttribute)setViewportEClass.getEStructuralFeatures().get(5);
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
		return (EReference)vertexBindingEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getBindIndexBuffer_IndexType()
	{
		return (EAttribute)bindIndexBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindIndexBuffer_Buffer()
	{
		return (EReference)bindIndexBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositor()
	{
		return compositorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositor_VertexShader()
	{
		return (EReference)compositorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositor_FragmentShader()
	{
		return (EReference)compositorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositor_ColorAttachments()
	{
		return (EReference)compositorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositor_InputAttachments()
	{
		return (EReference)compositorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositor_ConstantVariables()
	{
		return (EReference)compositorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositor_DescriptorPkg()
	{
		return (EReference)compositorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphicCommandBuffer()
	{
		return graphicCommandBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicCommandBuffer_ImageID()
	{
		return (EAttribute)graphicCommandBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEAttachmentType()
	{
		return eAttachmentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		createEReference(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION);
		createEReference(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION);
		createEAttribute(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE);
		createEReference(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__SURFACE);
		createEReference(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__RENDER_PASS);
		createEReference(graphicConfigurationEClass, GRAPHIC_CONFIGURATION__IMAGE_VIEWS);

		graphicExecutionManagerEClass = createEClass(GRAPHIC_EXECUTION_MANAGER);
		createEReference(graphicExecutionManagerEClass, GRAPHIC_EXECUTION_MANAGER__RECORDERS);
		createEReference(graphicExecutionManagerEClass, GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS);

		graphicExecutionRecorderEClass = createEClass(GRAPHIC_EXECUTION_RECORDER);
		createEReference(graphicExecutionRecorderEClass, GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFERS);

		colorDomainEClass = createEClass(COLOR_DOMAIN);
		createEAttribute(colorDomainEClass, COLOR_DOMAIN__FORMAT);
		createEAttribute(colorDomainEClass, COLOR_DOMAIN__COLOR_SPACE);

		physicalSurfaceEClass = createEClass(PHYSICAL_SURFACE);
		createEReference(physicalSurfaceEClass, PHYSICAL_SURFACE__COLOR_DOMAIN);

		swapchainConfigurationEClass = createEClass(SWAPCHAIN_CONFIGURATION);
		createEAttribute(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT);
		createEAttribute(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES);
		createEAttribute(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__PRESENT_WHEN_VBLANK);
		createEAttribute(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__ACQUIRE_WAIT_FOR_VBLANK);
		createEAttribute(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__ALLOWING_ACCESS_FROM_COMPUTE);
		createEReference(swapchainConfigurationEClass, SWAPCHAIN_CONFIGURATION__COLOR_ATTACHMENT);

		framebufferConfigurationEClass = createEClass(FRAMEBUFFER_CONFIGURATION);

		imageViewsEClass = createEClass(IMAGE_VIEWS);

		renderPassEClass = createEClass(RENDER_PASS);
		createEReference(renderPassEClass, RENDER_PASS__ATTACHMENTS);

		imageAttachmentEClass = createEClass(IMAGE_ATTACHMENT);
		createEAttribute(imageAttachmentEClass, IMAGE_ATTACHMENT__CLEAR_VALUE);
		createEReference(imageAttachmentEClass, IMAGE_ATTACHMENT__IMAGE_REF);

		depthAttachmentEClass = createEClass(DEPTH_ATTACHMENT);
		createEAttribute(depthAttachmentEClass, DEPTH_ATTACHMENT__CLEAR);
		createEAttribute(depthAttachmentEClass, DEPTH_ATTACHMENT__USAGES);

		colorAttachmentEClass = createEClass(COLOR_ATTACHMENT);
		createEAttribute(colorAttachmentEClass, COLOR_ATTACHMENT__CLEAR_VALUE);
		createEAttribute(colorAttachmentEClass, COLOR_ATTACHMENT__USAGES);
		createEAttribute(colorAttachmentEClass, COLOR_ATTACHMENT__FORMAT);

		attachmentPkgEClass = createEClass(ATTACHMENT_PKG);
		createEReference(attachmentPkgEClass, ATTACHMENT_PKG__EXTRA_ATTACHMENTS);

		subpassEClass = createEClass(SUBPASS);
		createEReference(subpassEClass, SUBPASS__ATTACHMENT_REF_PKG);
		createEReference(subpassEClass, SUBPASS__ATTACHMENT_PKG);
		createEAttribute(subpassEClass, SUBPASS__SUBPASS_INDEX);
		createEReference(subpassEClass, SUBPASS__PIPELINE_PKG);
		createEAttribute(subpassEClass, SUBPASS__BIND_POINT);
		createEReference(subpassEClass, SUBPASS__COMPOSITOR);
		createEAttribute(subpassEClass, SUBPASS__WAIT_FOR_STAGE);
		createEAttribute(subpassEClass, SUBPASS__SYNC_STAGE);
		createEAttribute(subpassEClass, SUBPASS__FINISH_STAGE);
		createEAttribute(subpassEClass, SUBPASS__WAIT_FOR_ACCESSES);
		createEAttribute(subpassEClass, SUBPASS__SYNC_ACCESSES);
		createEAttribute(subpassEClass, SUBPASS__FINISH_ACCESSES);
		createEReference(subpassEClass, SUBPASS__EXTENSION_PKG);
		createEAttribute(subpassEClass, SUBPASS__ENABLED);

		attachmentRefPkgEClass = createEClass(ATTACHMENT_REF_PKG);
		createEReference(attachmentRefPkgEClass, ATTACHMENT_REF_PKG__ATTACHMENT_REFS);

		attachmentRefEClass = createEClass(ATTACHMENT_REF);
		createEReference(attachmentRefEClass, ATTACHMENT_REF__ATTACHMENT);
		createEAttribute(attachmentRefEClass, ATTACHMENT_REF__LAYOUT);
		createEAttribute(attachmentRefEClass, ATTACHMENT_REF__TYPE);

		attachmentEClass = createEClass(ATTACHMENT);
		createEAttribute(attachmentEClass, ATTACHMENT__SAMPLES);
		createEAttribute(attachmentEClass, ATTACHMENT__LOAD_OP);
		createEAttribute(attachmentEClass, ATTACHMENT__STORE_OP);
		createEAttribute(attachmentEClass, ATTACHMENT__STENCIL_LOAD_OP);
		createEAttribute(attachmentEClass, ATTACHMENT__STENCIL_STORE_OP);
		createEAttribute(attachmentEClass, ATTACHMENT__INITIAL_LAYOUT);
		createEAttribute(attachmentEClass, ATTACHMENT__FINAL_LAYOUT);

		swapImageAttachmentEClass = createEClass(SWAP_IMAGE_ATTACHMENT);
		createEAttribute(swapImageAttachmentEClass, SWAP_IMAGE_ATTACHMENT__CLEAR_VALUE);

		extraAttachmentEClass = createEClass(EXTRA_ATTACHMENT);

		graphicProcessEClass = createEClass(GRAPHIC_PROCESS);
		createEReference(graphicProcessEClass, GRAPHIC_PROCESS__CONFIGURATION);
		createEReference(graphicProcessEClass, GRAPHIC_PROCESS__ATTACHMENT_PKG);
		createEReference(graphicProcessEClass, GRAPHIC_PROCESS__SUBPASSES);

		graphicsPipelineEClass = createEClass(GRAPHICS_PIPELINE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__SHADERS);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__VIEWPORT_STATE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__INPUT_ASSEMBLY);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__RASTERIZER);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__COLOR_BLEND);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__DYNAMIC_STATE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__VERTEX_INPUT_STATE);
		createEReference(graphicsPipelineEClass, GRAPHICS_PIPELINE__DEPTH_STENCIL_STATE);

		swapImageBarrierEClass = createEClass(SWAP_IMAGE_BARRIER);

		abstractBlitTaskEClass = createEClass(ABSTRACT_BLIT_TASK);
		createEAttribute(abstractBlitTaskEClass, ABSTRACT_BLIT_TASK__FILTER);
		createEAttribute(abstractBlitTaskEClass, ABSTRACT_BLIT_TASK__CLEAR_COLOR);
		createEReference(abstractBlitTaskEClass, ABSTRACT_BLIT_TASK__SRC_IMAGE);

		blitToSwapImageEClass = createEClass(BLIT_TO_SWAP_IMAGE);

		blitTaskEClass = createEClass(BLIT_TASK);
		createEReference(blitTaskEClass, BLIT_TASK__DST_IMAGE);

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

		vertexInputStateEClass = createEClass(VERTEX_INPUT_STATE);
		createEReference(vertexInputStateEClass, VERTEX_INPUT_STATE__INPUT_DESCRIPTOR);

		inputDescriptorEClass = createEClass(INPUT_DESCRIPTOR);
		createEAttribute(inputDescriptorEClass, INPUT_DESCRIPTOR__INPUT_RATE);
		createEAttribute(inputDescriptorEClass, INPUT_DESCRIPTOR__STRIDE_LENGTH);
		createEReference(inputDescriptorEClass, INPUT_DESCRIPTOR__ATTRIBUTES);

		attributeDescriptionEClass = createEClass(ATTRIBUTE_DESCRIPTION);
		createEAttribute(attributeDescriptionEClass, ATTRIBUTE_DESCRIPTION__FORMAT);
		createEAttribute(attributeDescriptionEClass, ATTRIBUTE_DESCRIPTION__OFFSET);

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

		bindIndexBufferEClass = createEClass(BIND_INDEX_BUFFER);
		createEAttribute(bindIndexBufferEClass, BIND_INDEX_BUFFER__INDEX_TYPE);
		createEReference(bindIndexBufferEClass, BIND_INDEX_BUFFER__BUFFER);

		compositorEClass = createEClass(COMPOSITOR);
		createEReference(compositorEClass, COMPOSITOR__VERTEX_SHADER);
		createEReference(compositorEClass, COMPOSITOR__FRAGMENT_SHADER);
		createEReference(compositorEClass, COMPOSITOR__COLOR_ATTACHMENTS);
		createEReference(compositorEClass, COMPOSITOR__INPUT_ATTACHMENTS);
		createEReference(compositorEClass, COMPOSITOR__CONSTANT_VARIABLES);
		createEReference(compositorEClass, COMPOSITOR__DESCRIPTOR_PKG);

		graphicCommandBufferEClass = createEClass(GRAPHIC_COMMAND_BUFFER);
		createEAttribute(graphicCommandBufferEClass, GRAPHIC_COMMAND_BUFFER__IMAGE_ID);

		// Create enums
		eAttachmentTypeEEnum = createEEnum(EATTACHMENT_TYPE);
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
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		ApplicationPackage theApplicationPackage = (ApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		VulkanResourcePackage theVulkanResourcePackage = (VulkanResourcePackage)EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);
		MaintainerPackage theMaintainerPackage = (MaintainerPackage)EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		GraphicpipelinePackage theGraphicpipelinePackage = (GraphicpipelinePackage)EPackage.Registry.INSTANCE.getEPackage(GraphicpipelinePackage.eNS_URI);
		BarrierPackage theBarrierPackage = (BarrierPackage)EPackage.Registry.INSTANCE.getEPackage(BarrierPackage.eNS_URI);
		VariablePackage theVariablePackage = (VariablePackage)EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		graphicConfigurationEClass.getESuperTypes().add(theProcessPackage.getProcessConfiguration());
		graphicExecutionManagerEClass.getESuperTypes().add(theProcessPackage.getProcessExecutionManager());
		graphicExecutionRecorderEClass.getESuperTypes().add(theProcessPackage.getExecutionRecorder());
		imageAttachmentEClass.getESuperTypes().add(this.getExtraAttachment());
		depthAttachmentEClass.getESuperTypes().add(this.getExtraAttachment());
		colorAttachmentEClass.getESuperTypes().add(this.getExtraAttachment());
		subpassEClass.getESuperTypes().add(theVulkanPackage.getIResourceContainer());
		subpassEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		attachmentEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		attachmentEClass.getESuperTypes().add(theVulkanResourcePackage.getIVulkanImage());
		swapImageAttachmentEClass.getESuperTypes().add(this.getAttachment());
		extraAttachmentEClass.getESuperTypes().add(this.getAttachment());
		EGenericType g1 = createEGenericType(theProcessPackage.getAbstractProcess());
		graphicProcessEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMaintainerPackage.getMaintainable());
		EGenericType g2 = createEGenericType(this.getGraphicProcess());
		g1.getETypeArguments().add(g2);
		graphicProcessEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theProcessPackage.getVkPipeline());
		graphicsPipelineEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMaintainerPackage.getMaintainable());
		g2 = createEGenericType(this.getGraphicsPipeline());
		g1.getETypeArguments().add(g2);
		graphicsPipelineEClass.getEGenericSuperTypes().add(g1);
		swapImageBarrierEClass.getESuperTypes().add(theBarrierPackage.getAbstractImageBarrier());
		abstractBlitTaskEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		blitToSwapImageEClass.getESuperTypes().add(this.getAbstractBlitTask());
		blitTaskEClass.getESuperTypes().add(this.getAbstractBlitTask());
		drawIndexedEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		drawEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		attributeDescriptionEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		bindVertexBufferEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		setScissorEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		setViewportEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		bindIndexBufferEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		compositorEClass.getESuperTypes().add(theApplicationPackage.getICompositor());
		compositorEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		graphicCommandBufferEClass.getESuperTypes().add(theProcessPackage.getICommandBuffer());

		// Initialize classes, features, and operations; add parameters
		initEClass(graphicConfigurationEClass, GraphicConfiguration.class, "GraphicConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicConfiguration_SwapchainConfiguration(), this.getSwapchainConfiguration(), null, "swapchainConfiguration", null, 1, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicConfiguration_FramebufferConfiguration(), this.getFramebufferConfiguration(), null, "framebufferConfiguration", null, 1, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicConfiguration_AcquireWaitStage(), theEnumerationPackage.getEPipelineStage(), "acquireWaitStage", "COLOR_ATTACHMENT_OUTPUT_BIT", 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicConfiguration_Surface(), this.getPhysicalSurface(), null, "surface", null, 1, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicConfiguration_RenderPass(), this.getRenderPass(), null, "renderPass", null, 1, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicConfiguration_ImageViews(), this.getImageViews(), null, "imageViews", null, 0, 1, GraphicConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicExecutionManagerEClass, GraphicExecutionManager.class, "GraphicExecutionManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicExecutionManager_Recorders(), this.getGraphicExecutionRecorder(), null, "recorders", null, 0, -1, GraphicExecutionManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicExecutionManager_CommandBuffers(), this.getGraphicCommandBuffer(), null, "commandBuffers", null, 0, -1, GraphicExecutionManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicExecutionRecorderEClass, GraphicExecutionRecorder.class, "GraphicExecutionRecorder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicExecutionRecorder_CommandBuffers(), this.getGraphicCommandBuffer(), null, "commandBuffers", null, 1, -1, GraphicExecutionRecorder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorDomainEClass, ColorDomain.class, "ColorDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorDomain_Format(), theEnumerationPackage.getEFormat(), "format", "B8G8R8A8_UNORM", 0, 1, ColorDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorDomain_ColorSpace(), theEnumerationPackage.getEColorSpace(), "colorSpace", "SRGB_NONLINEAR_KHR", 0, 1, ColorDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(physicalSurfaceEClass, PhysicalSurface.class, "PhysicalSurface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPhysicalSurface_ColorDomain(), this.getColorDomain(), null, "colorDomain", null, 1, 1, PhysicalSurface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swapchainConfigurationEClass, SwapchainConfiguration.class, "SwapchainConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwapchainConfiguration_RequiredSwapImageCount(), ecorePackage.getEInt(), "requiredSwapImageCount", "3", 0, 1, SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwapchainConfiguration_SwapImageUsages(), theEnumerationPackage.getEImageUsage(), "swapImageUsages", null, 0, -1, SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwapchainConfiguration_PresentWhenVBlank(), ecorePackage.getEBoolean(), "presentWhenVBlank", "true", 1, 1, SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwapchainConfiguration_AcquireWaitForVBlank(), ecorePackage.getEBoolean(), "acquireWaitForVBlank", "true", 1, 1, SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwapchainConfiguration_AllowingAccessFromCompute(), ecorePackage.getEBoolean(), "allowingAccessFromCompute", "false", 1, 1, SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwapchainConfiguration_ColorAttachment(), this.getSwapImageAttachment(), null, "colorAttachment", null, 1, 1, SwapchainConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(framebufferConfigurationEClass, FramebufferConfiguration.class, "FramebufferConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imageViewsEClass, ImageViews.class, "ImageViews", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(renderPassEClass, RenderPass.class, "RenderPass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenderPass_Attachments(), this.getExtraAttachment(), null, "attachments", null, 0, -1, RenderPass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageAttachmentEClass, ImageAttachment.class, "ImageAttachment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageAttachment_ClearValue(), theTypesPackage.getColor4f(), "clearValue", "0;0;0;0", 0, 1, ImageAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImageAttachment_ImageRef(), theVulkanPackage.getVulkanEngine(), null, "imageRef", null, 0, 1, ImageAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(depthAttachmentEClass, DepthAttachment.class, "DepthAttachment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDepthAttachment_Clear(), ecorePackage.getEBoolean(), "clear", "true", 0, 1, DepthAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDepthAttachment_Usages(), theEnumerationPackage.getEImageUsage(), "usages", null, 0, -1, DepthAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorAttachmentEClass, ColorAttachment.class, "ColorAttachment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorAttachment_ClearValue(), theTypesPackage.getColor4f(), "clearValue", "0;0;0;0", 0, 1, ColorAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorAttachment_Usages(), theEnumerationPackage.getEImageUsage(), "usages", null, 0, -1, ColorAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorAttachment_Format(), theEnumerationPackage.getEFormat(), "format", null, 0, 1, ColorAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attachmentPkgEClass, AttachmentPkg.class, "AttachmentPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttachmentPkg_ExtraAttachments(), this.getExtraAttachment(), null, "extraAttachments", null, 0, -1, AttachmentPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subpassEClass, Subpass.class, "Subpass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubpass_AttachmentRefPkg(), this.getAttachmentRefPkg(), null, "attachmentRefPkg", null, 0, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubpass_AttachmentPkg(), this.getAttachmentPkg(), null, "attachmentPkg", null, 0, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_SubpassIndex(), ecorePackage.getEInt(), "subpassIndex", "0", 1, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubpass_PipelinePkg(), theProcessPackage.getPipelinePkg(), null, "pipelinePkg", null, 0, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_BindPoint(), ecorePackage.getEInt(), "bindPoint", "0", 1, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubpass_Compositor(), theApplicationPackage.getICompositor(), null, "compositor", null, 0, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_WaitForStage(), theEnumerationPackage.getEPipelineStage(), "waitForStage", "BOTTOM_OF_PIPE_BIT", 1, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_SyncStage(), theEnumerationPackage.getEPipelineStage(), "syncStage", null, 1, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_FinishStage(), theEnumerationPackage.getEPipelineStage(), "finishStage", "BOTTOM_OF_PIPE_BIT", 1, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_WaitForAccesses(), theEnumerationPackage.getEAccess(), "waitForAccesses", null, 0, -1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_SyncAccesses(), theEnumerationPackage.getEAccess(), "syncAccesses", null, 0, -1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_FinishAccesses(), theEnumerationPackage.getEAccess(), "finishAccesses", null, 0, -1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubpass_ExtensionPkg(), theProcessPackage.getProcessExtensionPkg(), null, "extensionPkg", null, 0, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubpass_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 1, 1, Subpass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attachmentRefPkgEClass, AttachmentRefPkg.class, "AttachmentRefPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttachmentRefPkg_AttachmentRefs(), this.getAttachmentRef(), null, "attachmentRefs", null, 0, -1, AttachmentRefPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attachmentRefEClass, AttachmentRef.class, "AttachmentRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttachmentRef_Attachment(), this.getAttachment(), null, "attachment", null, 0, 1, AttachmentRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentRef_Layout(), theEnumerationPackage.getEImageLayout(), "layout", null, 0, 1, AttachmentRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachmentRef_Type(), this.getEAttachmentType(), "type", "Color", 1, 1, AttachmentRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attachmentEClass, Attachment.class, "Attachment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttachment_Samples(), theEnumerationPackage.getESampleCount(), "samples", null, 0, 1, Attachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachment_LoadOp(), theEnumerationPackage.getEAttachmentLoadOp(), "loadOp", null, 0, 1, Attachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachment_StoreOp(), theEnumerationPackage.getEAttachmentStoreOp(), "storeOp", null, 0, 1, Attachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachment_StencilLoadOp(), theEnumerationPackage.getEAttachmentLoadOp(), "stencilLoadOp", null, 0, 1, Attachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachment_StencilStoreOp(), theEnumerationPackage.getEAttachmentStoreOp(), "stencilStoreOp", null, 0, 1, Attachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachment_InitialLayout(), theEnumerationPackage.getEImageLayout(), "initialLayout", null, 0, 1, Attachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttachment_FinalLayout(), theEnumerationPackage.getEImageLayout(), "finalLayout", null, 0, 1, Attachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swapImageAttachmentEClass, SwapImageAttachment.class, "SwapImageAttachment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwapImageAttachment_ClearValue(), theTypesPackage.getColor4f(), "clearValue", "0;0;0;0", 0, 1, SwapImageAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extraAttachmentEClass, ExtraAttachment.class, "ExtraAttachment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(graphicProcessEClass, GraphicProcess.class, "GraphicProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicProcess_Configuration(), this.getGraphicConfiguration(), null, "configuration", null, 1, 1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicProcess_AttachmentPkg(), this.getAttachmentPkg(), null, "attachmentPkg", null, 1, 1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicProcess_Subpasses(), this.getSubpass(), null, "subpasses", null, 0, -1, GraphicProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicsPipelineEClass, GraphicsPipeline.class, "GraphicsPipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicsPipeline_Shaders(), theVulkanResourcePackage.getShader(), null, "shaders", null, 1, -1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_ViewportState(), theGraphicpipelinePackage.getViewportState(), null, "viewportState", null, 1, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_InputAssembly(), theGraphicpipelinePackage.getInputAssembly(), null, "inputAssembly", null, 1, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_Rasterizer(), theGraphicpipelinePackage.getRasterizer(), null, "rasterizer", null, 1, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_ColorBlend(), theGraphicpipelinePackage.getColorBlend(), null, "colorBlend", null, 1, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_DynamicState(), theGraphicpipelinePackage.getDynamicState(), null, "dynamicState", null, 0, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_VertexInputState(), this.getVertexInputState(), null, "vertexInputState", null, 1, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicsPipeline_DepthStencilState(), theGraphicpipelinePackage.getDepthStencilState(), null, "depthStencilState", null, 0, 1, GraphicsPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(swapImageBarrierEClass, SwapImageBarrier.class, "SwapImageBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractBlitTaskEClass, AbstractBlitTask.class, "AbstractBlitTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractBlitTask_Filter(), theEnumerationPackage.getEFilter(), "filter", "NEAREST", 0, 1, AbstractBlitTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractBlitTask_ClearColor(), theTypesPackage.getVector3i(), "clearColor", "0;0;0", 1, 1, AbstractBlitTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractBlitTask_SrcImage(), theVulkanResourcePackage.getIVulkanImage(), null, "srcImage", null, 1, 1, AbstractBlitTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blitToSwapImageEClass, BlitToSwapImage.class, "BlitToSwapImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blitTaskEClass, BlitTask.class, "BlitTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlitTask_DstImage(), theVulkanResourcePackage.getIVulkanImage(), null, "dstImage", null, 1, 1, BlitTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(drawIndexedEClass, DrawIndexed.class, "DrawIndexed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDrawIndexed_IndexCount(), ecorePackage.getEInt(), "indexCount", null, 1, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDrawIndexed_InstanceCount(), ecorePackage.getEInt(), "instanceCount", "1", 0, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDrawIndexed_FirstIndex(), ecorePackage.getEInt(), "firstIndex", "0", 0, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDrawIndexed_VertexOffset(), ecorePackage.getEInt(), "vertexOffset", "0", 0, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDrawIndexed_FirstInstance(), ecorePackage.getEInt(), "firstInstance", "0", 0, 1, DrawIndexed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(drawEClass, Draw.class, "Draw", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDraw_VertexCount(), ecorePackage.getEInt(), "vertexCount", null, 1, 1, Draw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDraw_InstanceCount(), ecorePackage.getEInt(), "instanceCount", "1", 0, 1, Draw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDraw_FirstVertex(), ecorePackage.getEInt(), "firstVertex", "0", 0, 1, Draw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDraw_FirstInstance(), ecorePackage.getEInt(), "firstInstance", "0", 0, 1, Draw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vertexInputStateEClass, VertexInputState.class, "VertexInputState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVertexInputState_InputDescriptor(), this.getInputDescriptor(), null, "inputDescriptor", null, 0, -1, VertexInputState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputDescriptorEClass, InputDescriptor.class, "InputDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputDescriptor_InputRate(), theEnumerationPackage.getEInputRate(), "inputRate", "VERTEX", 0, 1, InputDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInputDescriptor_StrideLength(), ecorePackage.getEInt(), "strideLength", null, 0, 1, InputDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputDescriptor_Attributes(), this.getAttributeDescription(), null, "attributes", null, 1, -1, InputDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeDescriptionEClass, AttributeDescription.class, "AttributeDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeDescription_Format(), theEnumerationPackage.getEFormat(), "format", null, 0, 1, AttributeDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeDescription_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, AttributeDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindVertexBufferEClass, BindVertexBuffer.class, "BindVertexBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindVertexBuffer_FirstBinding(), ecorePackage.getEInt(), "firstBinding", "0", 0, 1, BindVertexBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindVertexBuffer_VertexBindings(), this.getVertexBinding(), null, "vertexBindings", null, 1, -1, BindVertexBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setScissorEClass, SetScissor.class, "SetScissor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetScissor_OffsetX(), ecorePackage.getEInt(), "offsetX", "0", 0, 1, SetScissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetScissor_OffsetY(), ecorePackage.getEInt(), "offsetY", "0", 0, 1, SetScissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetScissor_Width(), ecorePackage.getEInt(), "width", null, 0, 1, SetScissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetScissor_Height(), ecorePackage.getEInt(), "height", null, 0, 1, SetScissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setViewportEClass, SetViewport.class, "SetViewport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetViewport_X(), ecorePackage.getEFloat(), "x", "0", 0, 1, SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_Y(), ecorePackage.getEFloat(), "y", "0", 0, 1, SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_Width(), ecorePackage.getEFloat(), "width", null, 0, 1, SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_Height(), ecorePackage.getEFloat(), "height", null, 0, 1, SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_MinDepth(), ecorePackage.getEFloat(), "minDepth", "1", 0, 1, SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetViewport_MaxDepth(), ecorePackage.getEFloat(), "maxDepth", "1", 0, 1, SetViewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vertexBindingEClass, VertexBinding.class, "VertexBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVertexBinding_Buffer(), theVulkanResourcePackage.getIBuffer(), null, "buffer", null, 0, 1, VertexBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindIndexBufferEClass, BindIndexBuffer.class, "BindIndexBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindIndexBuffer_IndexType(), theEnumerationPackage.getEIndexType(), "indexType", "UINT32", 0, 1, BindIndexBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindIndexBuffer_Buffer(), theVulkanResourcePackage.getIBuffer(), null, "buffer", null, 0, 1, BindIndexBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositorEClass, Compositor.class, "Compositor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositor_VertexShader(), theVulkanResourcePackage.getShader(), null, "vertexShader", null, 1, 1, Compositor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositor_FragmentShader(), theVulkanResourcePackage.getShader(), null, "fragmentShader", null, 1, 1, Compositor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositor_ColorAttachments(), this.getAttachment(), null, "colorAttachments", null, 1, -1, Compositor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositor_InputAttachments(), this.getExtraAttachment(), null, "inputAttachments", null, 0, -1, Compositor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositor_ConstantVariables(), theVariablePackage.getModelVariablePkg(), null, "constantVariables", null, 0, 1, Compositor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositor_DescriptorPkg(), theVulkanPackage.getDescriptorPkg(), null, "descriptorPkg", null, 0, 1, Compositor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicCommandBufferEClass, GraphicCommandBuffer.class, "GraphicCommandBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphicCommandBuffer_ImageID(), ecorePackage.getEInt(), "imageID", null, 1, 1, GraphicCommandBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eAttachmentTypeEEnum, EAttachmentType.class, "EAttachmentType");
		addEEnumLiteral(eAttachmentTypeEEnum, EAttachmentType.COLOR);
		addEEnumLiteral(eAttachmentTypeEEnum, EAttachmentType.DEPTH);
		addEEnumLiteral(eAttachmentTypeEEnum, EAttachmentType.INPUT);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphicPackageImpl
