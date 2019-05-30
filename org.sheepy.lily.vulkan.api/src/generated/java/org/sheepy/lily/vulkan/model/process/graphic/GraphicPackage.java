/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.barrier.BarrierPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory
 * @model kind="package"
 * @generated
 */
public interface GraphicPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.model.process.graphic";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graphic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphicPackage eINSTANCE = org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicConfiguration()
	 * @generated
	 */
	int GRAPHIC_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Swapchain Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION = ProcessPackage.CONFIGURATION_FEATURE_COUNT
			+ 0;

	/**
	 * The feature id for the '<em><b>Framebuffer Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION = ProcessPackage.CONFIGURATION_FEATURE_COUNT
			+ 1;

	/**
	 * The feature id for the '<em><b>Acquire Wait Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Color Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__COLOR_DOMAIN = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION_FEATURE_COUNT = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION_OPERATION_COUNT = ProcessPackage.CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorDomainImpl <em>Color Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ColorDomainImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorDomain()
	 * @generated
	 */
	int COLOR_DOMAIN = 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DOMAIN__FORMAT = 0;

	/**
	 * The feature id for the '<em><b>Color Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DOMAIN__COLOR_SPACE = 1;

	/**
	 * The number of structural features of the '<em>Color Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DOMAIN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Color Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DOMAIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl <em>Swapchain Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSwapchainConfiguration()
	 * @generated
	 */
	int SWAPCHAIN_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Presentation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAPCHAIN_CONFIGURATION__PRESENTATION_MODE = 0;

	/**
	 * The feature id for the '<em><b>Required Swap Image Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Swap Image Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES = 2;

	/**
	 * The feature id for the '<em><b>Atachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAPCHAIN_CONFIGURATION__ATACHMENTS = 3;

	/**
	 * The number of structural features of the '<em>Swapchain Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAPCHAIN_CONFIGURATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Swapchain Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAPCHAIN_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.FramebufferConfigurationImpl <em>Framebuffer Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.FramebufferConfigurationImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getFramebufferConfiguration()
	 * @generated
	 */
	int FRAMEBUFFER_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Clear Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAMEBUFFER_CONFIGURATION__CLEAR_VALUE = 0;

	/**
	 * The number of structural features of the '<em>Framebuffer Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAMEBUFFER_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Framebuffer Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAMEBUFFER_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment <em>ISwap Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getISwapAttachment()
	 * @generated
	 */
	int ISWAP_ATTACHMENT = 4;

	/**
	 * The number of structural features of the '<em>ISwap Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISWAP_ATTACHMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>ISwap Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISWAP_ATTACHMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ImageAttachmentImpl <em>Image Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ImageAttachmentImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getImageAttachment()
	 * @generated
	 */
	int IMAGE_ATTACHMENT = 5;

	/**
	 * The feature id for the '<em><b>Clear Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ATTACHMENT__CLEAR_VALUE = ISWAP_ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ATTACHMENT__IMAGE_REF = ISWAP_ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Image Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ATTACHMENT_FEATURE_COUNT = ISWAP_ATTACHMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Image Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ATTACHMENT_OPERATION_COUNT = ISWAP_ATTACHMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentImpl <em>Depth Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDepthAttachment()
	 * @generated
	 */
	int DEPTH_ATTACHMENT = 6;

	/**
	 * The feature id for the '<em><b>Clear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT__CLEAR = ISWAP_ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Depth Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_FEATURE_COUNT = ISWAP_ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Depth Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_OPERATION_COUNT = ISWAP_ATTACHMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl <em>Render Pass Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getRenderPassInfo()
	 * @generated
	 */
	int RENDER_PASS_INFO = 7;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO__ATTACHMENTS = 0;

	/**
	 * The feature id for the '<em><b>Subpasses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO__SUBPASSES = 1;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO__DEPENDENCIES = 2;

	/**
	 * The feature id for the '<em><b>Bind Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO__BIND_POINT = 3;

	/**
	 * The number of structural features of the '<em>Render Pass Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Render Pass Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl <em>Subpass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpass()
	 * @generated
	 */
	int SUBPASS = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS__REFS = 1;

	/**
	 * The number of structural features of the '<em>Subpass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Subpass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachementRefImpl <em>Attachement Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.AttachementRefImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachementRef()
	 * @generated
	 */
	int ATTACHEMENT_REF = 9;

	/**
	 * The feature id for the '<em><b>Attachement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT_REF__ATTACHEMENT = 0;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT_REF__LAYOUT = 1;

	/**
	 * The number of structural features of the '<em>Attachement Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT_REF_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attachement Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHEMENT_REF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpassDependency()
	 * @generated
	 */
	int SUBPASS_DEPENDENCY = 10;

	/**
	 * The feature id for the '<em><b>Src Subpass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__SRC_SUBPASS = 0;

	/**
	 * The feature id for the '<em><b>Dst Subpass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__DST_SUBPASS = 1;

	/**
	 * The feature id for the '<em><b>Src Stage Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__SRC_STAGE_MASK = 2;

	/**
	 * The feature id for the '<em><b>Dst Stage Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__DST_STAGE_MASK = 3;

	/**
	 * The feature id for the '<em><b>Src Accesses</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__SRC_ACCESSES = 4;

	/**
	 * The feature id for the '<em><b>Dst Accesses</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__DST_ACCESSES = 5;

	/**
	 * The number of structural features of the '<em>Subpass Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Subpass Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachmentDescription()
	 * @generated
	 */
	int ATTACHMENT_DESCRIPTION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__SAMPLES = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__LOAD_OP = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__STORE_OP = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stencil Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Stencil Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Final Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__FINAL_LAYOUT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageAttachmentDescriptionImpl <em>Swap Image Attachment Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageAttachmentDescriptionImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSwapImageAttachmentDescription()
	 * @generated
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION__NAME = ATTACHMENT_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION__SAMPLES = ATTACHMENT_DESCRIPTION__SAMPLES;

	/**
	 * The feature id for the '<em><b>Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION__LOAD_OP = ATTACHMENT_DESCRIPTION__LOAD_OP;

	/**
	 * The feature id for the '<em><b>Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION__STORE_OP = ATTACHMENT_DESCRIPTION__STORE_OP;

	/**
	 * The feature id for the '<em><b>Stencil Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP = ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP;

	/**
	 * The feature id for the '<em><b>Stencil Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP = ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT = ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Final Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION__FINAL_LAYOUT = ATTACHMENT_DESCRIPTION__FINAL_LAYOUT;

	/**
	 * The number of structural features of the '<em>Swap Image Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION_FEATURE_COUNT = ATTACHMENT_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Swap Image Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION_OPERATION_COUNT = ATTACHMENT_DESCRIPTION_OPERATION_COUNT
			+ 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ExtraAttachmentDescriptionImpl <em>Extra Attachment Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ExtraAttachmentDescriptionImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getExtraAttachmentDescription()
	 * @generated
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__NAME = ATTACHMENT_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__SAMPLES = ATTACHMENT_DESCRIPTION__SAMPLES;

	/**
	 * The feature id for the '<em><b>Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__LOAD_OP = ATTACHMENT_DESCRIPTION__LOAD_OP;

	/**
	 * The feature id for the '<em><b>Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__STORE_OP = ATTACHMENT_DESCRIPTION__STORE_OP;

	/**
	 * The feature id for the '<em><b>Stencil Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP = ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP;

	/**
	 * The feature id for the '<em><b>Stencil Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP = ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT = ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Final Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__FINAL_LAYOUT = ATTACHMENT_DESCRIPTION__FINAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Attachment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION__ATTACHMENT = ATTACHMENT_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extra Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION_FEATURE_COUNT = ATTACHMENT_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Extra Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRA_ATTACHMENT_DESCRIPTION_OPERATION_COUNT = ATTACHMENT_DESCRIPTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicProcess()
	 * @generated
	 */
	int GRAPHIC_PROCESS = 14;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__RESOURCE_PKG = ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__NAME = ProcessPackage.ABSTRACT_PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__ENABLED = ProcessPackage.ABSTRACT_PROCESS__ENABLED;

	/**
	 * The feature id for the '<em><b>Waiting Fence During Acquire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__WAITING_FENCE_DURING_ACQUIRE = ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE;

	/**
	 * The feature id for the '<em><b>Part Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__PART_PKG = ProcessPackage.ABSTRACT_PROCESS__PART_PKG;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__RESET_ALLOWED = ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED;

	/**
	 * The feature id for the '<em><b>Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__SIGNALS = ProcessPackage.ABSTRACT_PROCESS__SIGNALS;

	/**
	 * The feature id for the '<em><b>Wait For</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__WAIT_FOR = ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__CONFIGURATION = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Render Pass Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__RENDER_PASS_INFO = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Field Of View Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__FIELD_OF_VIEW_Y = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_FEATURE_COUNT = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_OPERATION_COUNT = ProcessPackage.ABSTRACT_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicsPipeline()
	 * @generated
	 */
	int GRAPHICS_PIPELINE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__NAME = ProcessPackage.IPIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__RESOURCE_PKG = ProcessPackage.IPIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__ENABLED = ProcessPackage.IPIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__STAGE = ProcessPackage.IPIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES = ProcessPackage.IPIPELINE__PUSH_CONSTANT_RANGES;

	/**
	 * The feature id for the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG = ProcessPackage.IPIPELINE__DESCRIPTOR_SET_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__TASK_PKG = ProcessPackage.IPIPELINE__TASK_PKG;

	/**
	 * The feature id for the '<em><b>Builder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__BUILDER = ProcessPackage.IPIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__SHADERS = ProcessPackage.IPIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__VIEWPORT_STATE = ProcessPackage.IPIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__INPUT_ASSEMBLY = ProcessPackage.IPIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__RASTERIZER = ProcessPackage.IPIPELINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__COLOR_BLEND = ProcessPackage.IPIPELINE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DYNAMIC_STATE = ProcessPackage.IPIPELINE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__SUBPASS = ProcessPackage.IPIPELINE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Vertex Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR = ProcessPackage.IPIPELINE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_FEATURE_COUNT = ProcessPackage.IPIPELINE_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_OPERATION_COUNT = ProcessPackage.IPIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageBarrierImpl <em>Swap Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSwapImageBarrier()
	 * @generated
	 */
	int SWAP_IMAGE_BARRIER = 16;

	/**
	 * The feature id for the '<em><b>Src Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_BARRIER__SRC_ACCESS_MASK = BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_ACCESS_MASK;

	/**
	 * The feature id for the '<em><b>Dst Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_BARRIER__DST_ACCESS_MASK = BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_ACCESS_MASK;

	/**
	 * The feature id for the '<em><b>Src Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_BARRIER__SRC_LAYOUT = BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_LAYOUT;

	/**
	 * The feature id for the '<em><b>Dst Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_BARRIER__DST_LAYOUT = BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_LAYOUT;

	/**
	 * The number of structural features of the '<em>Swap Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_BARRIER_FEATURE_COUNT = BarrierPackage.ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Swap Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_IMAGE_BARRIER_OPERATION_COUNT = BarrierPackage.ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT
			+ 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BlitToSwapImageImpl <em>Blit To Swap Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.BlitToSwapImageImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getBlitToSwapImage()
	 * @generated
	 */
	int BLIT_TO_SWAP_IMAGE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLIT_TO_SWAP_IMAGE__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLIT_TO_SWAP_IMAGE__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLIT_TO_SWAP_IMAGE__IMAGE = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Blit To Swap Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLIT_TO_SWAP_IMAGE_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Blit To Swap Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLIT_TO_SWAP_IMAGE_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl <em>Draw Indexed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDrawIndexed()
	 * @generated
	 */
	int DRAW_INDEXED = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Index Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED__INDEX_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED__INSTANCE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>First Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED__FIRST_INDEX = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Vertex Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED__VERTEX_OFFSET = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>First Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED__FIRST_INSTANCE = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Draw Indexed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Draw Indexed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_INDEXED_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl <em>Draw</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDraw()
	 * @generated
	 */
	int DRAW = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Vertex Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW__VERTEX_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW__INSTANCE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>First Vertex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW__FIRST_VERTEX = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>First Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW__FIRST_INSTANCE = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Draw</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Draw</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAW_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.VertexDescriptorImpl <em>Vertex Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.VertexDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getVertexDescriptor()
	 * @generated
	 */
	int VERTEX_DESCRIPTOR = 20;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_DESCRIPTOR__ATTRIBUTES = 0;

	/**
	 * The feature id for the '<em><b>Stride Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_DESCRIPTOR__STRIDE_LENGTH = 1;

	/**
	 * The number of structural features of the '<em>Vertex Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Vertex Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttributeDescriptionImpl <em>Attribute Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.AttributeDescriptionImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttributeDescription()
	 * @generated
	 */
	int ATTRIBUTE_DESCRIPTION = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DESCRIPTION__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DESCRIPTION__FORMAT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DESCRIPTION__OFFSET = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DESCRIPTION_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DESCRIPTION_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.IndexedVertexDescriptorImpl <em>Indexed Vertex Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.IndexedVertexDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIndexedVertexDescriptor()
	 * @generated
	 */
	int INDEXED_VERTEX_DESCRIPTOR = 22;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_VERTEX_DESCRIPTOR__ATTRIBUTES = VERTEX_DESCRIPTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Stride Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_VERTEX_DESCRIPTOR__STRIDE_LENGTH = VERTEX_DESCRIPTOR__STRIDE_LENGTH;

	/**
	 * The feature id for the '<em><b>Index Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_VERTEX_DESCRIPTOR__INDEX_TYPE = VERTEX_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Indexed Vertex Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_VERTEX_DESCRIPTOR_FEATURE_COUNT = VERTEX_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Indexed Vertex Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_VERTEX_DESCRIPTOR_OPERATION_COUNT = VERTEX_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl <em>Bind Vertex Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getBindVertexBuffer()
	 * @generated
	 */
	int BIND_VERTEX_BUFFER = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_VERTEX_BUFFER__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_VERTEX_BUFFER__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>First Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_VERTEX_BUFFER__FIRST_BINDING = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vertex Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_VERTEX_BUFFER__VERTEX_BINDINGS = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bind Vertex Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_VERTEX_BUFFER_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bind Vertex Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_VERTEX_BUFFER_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl <em>Set Scissor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSetScissor()
	 * @generated
	 */
	int SET_SCISSOR = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SCISSOR__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SCISSOR__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Offset X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SCISSOR__OFFSET_X = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SCISSOR__OFFSET_Y = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SCISSOR__WIDTH = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SCISSOR__HEIGHT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Set Scissor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SCISSOR_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Set Scissor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SCISSOR_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetViewportImpl <em>Set Viewport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SetViewportImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSetViewport()
	 * @generated
	 */
	int SET_VIEWPORT = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT__X = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT__Y = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT__WIDTH = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT__HEIGHT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Min Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT__MIN_DEPTH = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT__MAX_DEPTH = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Set Viewport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Set Viewport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VIEWPORT_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl <em>Vertex Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getVertexBinding()
	 * @generated
	 */
	int VERTEX_BINDING = 26;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_BINDING__BUFFER = 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_BINDING__OFFSET = 1;

	/**
	 * The number of structural features of the '<em>Vertex Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_BINDING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Vertex Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl <em>Bind Index Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getBindIndexBuffer()
	 * @generated
	 */
	int BIND_INDEX_BUFFER = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_INDEX_BUFFER__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_INDEX_BUFFER__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_INDEX_BUFFER__BUFFER = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_INDEX_BUFFER__OFFSET = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bind Index Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_INDEX_BUFFER_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Bind Index Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_INDEX_BUFFER_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration
	 * @generated
	 */
	EClass getGraphicConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getSwapchainConfiguration <em>Swapchain Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Swapchain Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getSwapchainConfiguration()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EReference getGraphicConfiguration_SwapchainConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getFramebufferConfiguration <em>Framebuffer Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Framebuffer Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getFramebufferConfiguration()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EReference getGraphicConfiguration_FramebufferConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getAcquireWaitStage <em>Acquire Wait Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acquire Wait Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getAcquireWaitStage()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_AcquireWaitStage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Color Domain</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration#getColorDomain()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EReference getGraphicConfiguration_ColorDomain();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Domain</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorDomain
	 * @generated
	 */
	EClass getColorDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorDomain#getFormat()
	 * @see #getColorDomain()
	 * @generated
	 */
	EAttribute getColorDomain_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorDomain#getColorSpace <em>Color Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Space</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorDomain#getColorSpace()
	 * @see #getColorDomain()
	 * @generated
	 */
	EAttribute getColorDomain_ColorSpace();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration <em>Swapchain Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Swapchain Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration
	 * @generated
	 */
	EClass getSwapchainConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getPresentationMode <em>Presentation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Presentation Mode</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getPresentationMode()
	 * @see #getSwapchainConfiguration()
	 * @generated
	 */
	EAttribute getSwapchainConfiguration_PresentationMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getRequiredSwapImageCount <em>Required Swap Image Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Swap Image Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getRequiredSwapImageCount()
	 * @see #getSwapchainConfiguration()
	 * @generated
	 */
	EAttribute getSwapchainConfiguration_RequiredSwapImageCount();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getSwapImageUsages <em>Swap Image Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Swap Image Usages</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getSwapImageUsages()
	 * @see #getSwapchainConfiguration()
	 * @generated
	 */
	EAttribute getSwapchainConfiguration_SwapImageUsages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getAtachments <em>Atachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Atachments</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration#getAtachments()
	 * @see #getSwapchainConfiguration()
	 * @generated
	 */
	EReference getSwapchainConfiguration_Atachments();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration <em>Framebuffer Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Framebuffer Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration
	 * @generated
	 */
	EClass getFramebufferConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration#getClearValue <em>Clear Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear Value</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration#getClearValue()
	 * @see #getFramebufferConfiguration()
	 * @generated
	 */
	EAttribute getFramebufferConfiguration_ClearValue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment <em>ISwap Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISwap Attachment</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment
	 * @generated
	 */
	EClass getISwapAttachment();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment <em>Image Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Attachment</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment
	 * @generated
	 */
	EClass getImageAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment#getClearValue <em>Clear Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear Value</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment#getClearValue()
	 * @see #getImageAttachment()
	 * @generated
	 */
	EAttribute getImageAttachment_ClearValue();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment#getImageRef <em>Image Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image Ref</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment#getImageRef()
	 * @see #getImageAttachment()
	 * @generated
	 */
	EReference getImageAttachment_ImageRef();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment <em>Depth Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depth Attachment</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment
	 * @generated
	 */
	EClass getDepthAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment#isClear <em>Clear</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment#isClear()
	 * @see #getDepthAttachment()
	 * @generated
	 */
	EAttribute getDepthAttachment_Clear();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Pass Info</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo
	 * @generated
	 */
	EClass getRenderPassInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachments</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo#getAttachments()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Attachments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo#getSubpasses <em>Subpasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subpasses</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo#getSubpasses()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Subpasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo#getDependencies()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo#getBindPoint <em>Bind Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bind Point</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo#getBindPoint()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EAttribute getRenderPassInfo_BindPoint();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass <em>Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subpass</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Subpass
	 * @generated
	 */
	EClass getSubpass();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Subpass#getName()
	 * @see #getSubpass()
	 * @generated
	 */
	EAttribute getSubpass_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.Subpass#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refs</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Subpass#getRefs()
	 * @see #getSubpass()
	 * @generated
	 */
	EReference getSubpass_Refs();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachementRef <em>Attachement Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachement Ref</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachementRef
	 * @generated
	 */
	EClass getAttachementRef();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachementRef#getAttachement <em>Attachement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attachement</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachementRef#getAttachement()
	 * @see #getAttachementRef()
	 * @generated
	 */
	EReference getAttachementRef_Attachement();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachementRef#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachementRef#getLayout()
	 * @see #getAttachementRef()
	 * @generated
	 */
	EAttribute getAttachementRef_Layout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency <em>Subpass Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subpass Dependency</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency
	 * @generated
	 */
	EClass getSubpassDependency();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src Subpass</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EReference getSubpassDependency_SrcSubpass();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dst Subpass</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EReference getSubpassDependency_DstSubpass();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask <em>Src Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Src Stage Mask</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcStageMask();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstStageMask <em>Dst Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dst Stage Mask</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstStageMask();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcAccesses <em>Src Accesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Src Accesses</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getSrcAccesses()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcAccesses();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstAccesses <em>Dst Accesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dst Accesses</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SubpassDependency#getDstAccesses()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstAccesses();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription <em>Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachment Description</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription
	 * @generated
	 */
	EClass getAttachmentDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Samples</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getSamples()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_Samples();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getLoadOp <em>Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Op</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getLoadOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_LoadOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getStoreOp <em>Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Op</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getStoreOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StoreOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getStencilLoadOp <em>Stencil Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Load Op</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getStencilLoadOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StencilLoadOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getStencilStoreOp <em>Stencil Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Store Op</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getStencilStoreOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StencilStoreOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getInitialLayout <em>Initial Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getInitialLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_InitialLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getFinalLayout <em>Final Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescription#getFinalLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_FinalLayout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachmentDescription <em>Swap Image Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Swap Image Attachment Description</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachmentDescription
	 * @generated
	 */
	EClass getSwapImageAttachmentDescription();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription <em>Extra Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extra Attachment Description</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription
	 * @generated
	 */
	EClass getExtraAttachmentDescription();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription#getAttachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attachment</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription#getAttachment()
	 * @see #getExtraAttachmentDescription()
	 * @generated
	 */
	EReference getExtraAttachmentDescription_Attachment();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess
	 * @generated
	 */
	EClass getGraphicProcess();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getConfiguration()
	 * @see #getGraphicProcess()
	 * @generated
	 */
	EReference getGraphicProcess_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getRenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Render Pass Info</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getRenderPassInfo()
	 * @see #getGraphicProcess()
	 * @generated
	 */
	EReference getGraphicProcess_RenderPassInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getFieldOfViewY <em>Field Of View Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Of View Y</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getFieldOfViewY()
	 * @see #getGraphicProcess()
	 * @generated
	 */
	EAttribute getGraphicProcess_FieldOfViewY();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline <em>Graphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphics Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline
	 * @generated
	 */
	EClass getGraphicsPipeline();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getShaders <em>Shaders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shaders</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getShaders()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_Shaders();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getViewportState <em>Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Viewport State</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getViewportState()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_ViewportState();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getInputAssembly <em>Input Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Assembly</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getInputAssembly()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_InputAssembly();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getRasterizer <em>Rasterizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rasterizer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getRasterizer()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_Rasterizer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getColorBlend <em>Color Blend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Color Blend</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getColorBlend()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_ColorBlend();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getDynamicState <em>Dynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dynamic State</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getDynamicState()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_DynamicState();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getSubpass <em>Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subpass</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getSubpass()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EAttribute getGraphicsPipeline_Subpass();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getVertexDescriptor <em>Vertex Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertex Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline#getVertexDescriptor()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_VertexDescriptor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier <em>Swap Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Swap Image Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier
	 * @generated
	 */
	EClass getSwapImageBarrier();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage <em>Blit To Swap Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blit To Swap Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage
	 * @generated
	 */
	EClass getBlitToSwapImage();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage#getImage()
	 * @see #getBlitToSwapImage()
	 * @generated
	 */
	EReference getBlitToSwapImage_Image();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed <em>Draw Indexed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Draw Indexed</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed
	 * @generated
	 */
	EClass getDrawIndexed();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getIndexCount <em>Index Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getIndexCount()
	 * @see #getDrawIndexed()
	 * @generated
	 */
	EAttribute getDrawIndexed_IndexCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getInstanceCount <em>Instance Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getInstanceCount()
	 * @see #getDrawIndexed()
	 * @generated
	 */
	EAttribute getDrawIndexed_InstanceCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getFirstIndex <em>First Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Index</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getFirstIndex()
	 * @see #getDrawIndexed()
	 * @generated
	 */
	EAttribute getDrawIndexed_FirstIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getVertexOffset <em>Vertex Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertex Offset</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getVertexOffset()
	 * @see #getDrawIndexed()
	 * @generated
	 */
	EAttribute getDrawIndexed_VertexOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getFirstInstance <em>First Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Instance</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed#getFirstInstance()
	 * @see #getDrawIndexed()
	 * @generated
	 */
	EAttribute getDrawIndexed_FirstInstance();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw <em>Draw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Draw</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Draw
	 * @generated
	 */
	EClass getDraw();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getVertexCount <em>Vertex Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertex Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Draw#getVertexCount()
	 * @see #getDraw()
	 * @generated
	 */
	EAttribute getDraw_VertexCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getInstanceCount <em>Instance Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Draw#getInstanceCount()
	 * @see #getDraw()
	 * @generated
	 */
	EAttribute getDraw_InstanceCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getFirstVertex <em>First Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Vertex</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Draw#getFirstVertex()
	 * @see #getDraw()
	 * @generated
	 */
	EAttribute getDraw_FirstVertex();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Draw#getFirstInstance <em>First Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Instance</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Draw#getFirstInstance()
	 * @see #getDraw()
	 * @generated
	 */
	EAttribute getDraw_FirstInstance();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor <em>Vertex Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor
	 * @generated
	 */
	EClass getVertexDescriptor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor#getAttributes()
	 * @see #getVertexDescriptor()
	 * @generated
	 */
	EReference getVertexDescriptor_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor#getStrideLength <em>Stride Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stride Length</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.VertexDescriptor#getStrideLength()
	 * @see #getVertexDescriptor()
	 * @generated
	 */
	EAttribute getVertexDescriptor_StrideLength();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription <em>Attribute Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Description</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription
	 * @generated
	 */
	EClass getAttributeDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription#getFormat()
	 * @see #getAttributeDescription()
	 * @generated
	 */
	EAttribute getAttributeDescription_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription#getOffset()
	 * @see #getAttributeDescription()
	 * @generated
	 */
	EAttribute getAttributeDescription_Offset();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor <em>Indexed Vertex Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indexed Vertex Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor
	 * @generated
	 */
	EClass getIndexedVertexDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor#getIndexType <em>Index Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Type</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor#getIndexType()
	 * @see #getIndexedVertexDescriptor()
	 * @generated
	 */
	EAttribute getIndexedVertexDescriptor_IndexType();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer <em>Bind Vertex Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bind Vertex Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer
	 * @generated
	 */
	EClass getBindVertexBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer#getFirstBinding <em>First Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Binding</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer#getFirstBinding()
	 * @see #getBindVertexBuffer()
	 * @generated
	 */
	EAttribute getBindVertexBuffer_FirstBinding();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer#getVertexBindings <em>Vertex Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vertex Bindings</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer#getVertexBindings()
	 * @see #getBindVertexBuffer()
	 * @generated
	 */
	EReference getBindVertexBuffer_VertexBindings();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor <em>Set Scissor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Scissor</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetScissor
	 * @generated
	 */
	EClass getSetScissor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getOffsetX <em>Offset X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset X</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getOffsetX()
	 * @see #getSetScissor()
	 * @generated
	 */
	EAttribute getSetScissor_OffsetX();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getOffsetY <em>Offset Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset Y</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getOffsetY()
	 * @see #getSetScissor()
	 * @generated
	 */
	EAttribute getSetScissor_OffsetY();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getWidth()
	 * @see #getSetScissor()
	 * @generated
	 */
	EAttribute getSetScissor_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetScissor#getHeight()
	 * @see #getSetScissor()
	 * @generated
	 */
	EAttribute getSetScissor_Height();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport <em>Set Viewport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Viewport</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetViewport
	 * @generated
	 */
	EClass getSetViewport();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getX()
	 * @see #getSetViewport()
	 * @generated
	 */
	EAttribute getSetViewport_X();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getY()
	 * @see #getSetViewport()
	 * @generated
	 */
	EAttribute getSetViewport_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getWidth()
	 * @see #getSetViewport()
	 * @generated
	 */
	EAttribute getSetViewport_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getHeight()
	 * @see #getSetViewport()
	 * @generated
	 */
	EAttribute getSetViewport_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getMinDepth <em>Min Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Depth</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getMinDepth()
	 * @see #getSetViewport()
	 * @generated
	 */
	EAttribute getSetViewport_MinDepth();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getMaxDepth <em>Max Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Depth</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.SetViewport#getMaxDepth()
	 * @see #getSetViewport()
	 * @generated
	 */
	EAttribute getSetViewport_MaxDepth();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding <em>Vertex Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex Binding</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.VertexBinding
	 * @generated
	 */
	EClass getVertexBinding();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.VertexBinding#getBuffer()
	 * @see #getVertexBinding()
	 * @generated
	 */
	EReference getVertexBinding_Buffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.VertexBinding#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.VertexBinding#getOffset()
	 * @see #getVertexBinding()
	 * @generated
	 */
	EAttribute getVertexBinding_Offset();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer <em>Bind Index Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bind Index Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer
	 * @generated
	 */
	EClass getBindIndexBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getBuffer()
	 * @see #getBindIndexBuffer()
	 * @generated
	 */
	EReference getBindIndexBuffer_Buffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer#getOffset()
	 * @see #getBindIndexBuffer()
	 * @generated
	 */
	EAttribute getBindIndexBuffer_Offset();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphicFactory getGraphicFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicConfiguration()
		 * @generated
		 */
		EClass GRAPHIC_CONFIGURATION = eINSTANCE.getGraphicConfiguration();

		/**
		 * The meta object literal for the '<em><b>Swapchain Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION = eINSTANCE
				.getGraphicConfiguration_SwapchainConfiguration();

		/**
		 * The meta object literal for the '<em><b>Framebuffer Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION = eINSTANCE
				.getGraphicConfiguration_FramebufferConfiguration();

		/**
		 * The meta object literal for the '<em><b>Acquire Wait Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE = eINSTANCE
				.getGraphicConfiguration_AcquireWaitStage();

		/**
		 * The meta object literal for the '<em><b>Color Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CONFIGURATION__COLOR_DOMAIN = eINSTANCE
				.getGraphicConfiguration_ColorDomain();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorDomainImpl <em>Color Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ColorDomainImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorDomain()
		 * @generated
		 */
		EClass COLOR_DOMAIN = eINSTANCE.getColorDomain();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_DOMAIN__FORMAT = eINSTANCE.getColorDomain_Format();

		/**
		 * The meta object literal for the '<em><b>Color Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_DOMAIN__COLOR_SPACE = eINSTANCE.getColorDomain_ColorSpace();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl <em>Swapchain Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSwapchainConfiguration()
		 * @generated
		 */
		EClass SWAPCHAIN_CONFIGURATION = eINSTANCE.getSwapchainConfiguration();

		/**
		 * The meta object literal for the '<em><b>Presentation Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWAPCHAIN_CONFIGURATION__PRESENTATION_MODE = eINSTANCE
				.getSwapchainConfiguration_PresentationMode();

		/**
		 * The meta object literal for the '<em><b>Required Swap Image Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT = eINSTANCE
				.getSwapchainConfiguration_RequiredSwapImageCount();

		/**
		 * The meta object literal for the '<em><b>Swap Image Usages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES = eINSTANCE
				.getSwapchainConfiguration_SwapImageUsages();

		/**
		 * The meta object literal for the '<em><b>Atachments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWAPCHAIN_CONFIGURATION__ATACHMENTS = eINSTANCE
				.getSwapchainConfiguration_Atachments();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.FramebufferConfigurationImpl <em>Framebuffer Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.FramebufferConfigurationImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getFramebufferConfiguration()
		 * @generated
		 */
		EClass FRAMEBUFFER_CONFIGURATION = eINSTANCE.getFramebufferConfiguration();

		/**
		 * The meta object literal for the '<em><b>Clear Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAMEBUFFER_CONFIGURATION__CLEAR_VALUE = eINSTANCE
				.getFramebufferConfiguration_ClearValue();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment <em>ISwap Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getISwapAttachment()
		 * @generated
		 */
		EClass ISWAP_ATTACHMENT = eINSTANCE.getISwapAttachment();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ImageAttachmentImpl <em>Image Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ImageAttachmentImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getImageAttachment()
		 * @generated
		 */
		EClass IMAGE_ATTACHMENT = eINSTANCE.getImageAttachment();

		/**
		 * The meta object literal for the '<em><b>Clear Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_ATTACHMENT__CLEAR_VALUE = eINSTANCE.getImageAttachment_ClearValue();

		/**
		 * The meta object literal for the '<em><b>Image Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_ATTACHMENT__IMAGE_REF = eINSTANCE.getImageAttachment_ImageRef();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentImpl <em>Depth Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDepthAttachment()
		 * @generated
		 */
		EClass DEPTH_ATTACHMENT = eINSTANCE.getDepthAttachment();

		/**
		 * The meta object literal for the '<em><b>Clear</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPTH_ATTACHMENT__CLEAR = eINSTANCE.getDepthAttachment_Clear();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl <em>Render Pass Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassInfoImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getRenderPassInfo()
		 * @generated
		 */
		EClass RENDER_PASS_INFO = eINSTANCE.getRenderPassInfo();

		/**
		 * The meta object literal for the '<em><b>Attachments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_PASS_INFO__ATTACHMENTS = eINSTANCE.getRenderPassInfo_Attachments();

		/**
		 * The meta object literal for the '<em><b>Subpasses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_PASS_INFO__SUBPASSES = eINSTANCE.getRenderPassInfo_Subpasses();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_PASS_INFO__DEPENDENCIES = eINSTANCE.getRenderPassInfo_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Bind Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RENDER_PASS_INFO__BIND_POINT = eINSTANCE.getRenderPassInfo_BindPoint();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl <em>Subpass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpass()
		 * @generated
		 */
		EClass SUBPASS = eINSTANCE.getSubpass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS__NAME = eINSTANCE.getSubpass_Name();

		/**
		 * The meta object literal for the '<em><b>Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBPASS__REFS = eINSTANCE.getSubpass_Refs();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachementRefImpl <em>Attachement Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.AttachementRefImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachementRef()
		 * @generated
		 */
		EClass ATTACHEMENT_REF = eINSTANCE.getAttachementRef();

		/**
		 * The meta object literal for the '<em><b>Attachement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACHEMENT_REF__ATTACHEMENT = eINSTANCE.getAttachementRef_Attachement();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHEMENT_REF__LAYOUT = eINSTANCE.getAttachementRef_Layout();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SubpassDependencyImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpassDependency()
		 * @generated
		 */
		EClass SUBPASS_DEPENDENCY = eINSTANCE.getSubpassDependency();

		/**
		 * The meta object literal for the '<em><b>Src Subpass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBPASS_DEPENDENCY__SRC_SUBPASS = eINSTANCE.getSubpassDependency_SrcSubpass();

		/**
		 * The meta object literal for the '<em><b>Dst Subpass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBPASS_DEPENDENCY__DST_SUBPASS = eINSTANCE.getSubpassDependency_DstSubpass();

		/**
		 * The meta object literal for the '<em><b>Src Stage Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__SRC_STAGE_MASK = eINSTANCE
				.getSubpassDependency_SrcStageMask();

		/**
		 * The meta object literal for the '<em><b>Dst Stage Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__DST_STAGE_MASK = eINSTANCE
				.getSubpassDependency_DstStageMask();

		/**
		 * The meta object literal for the '<em><b>Src Accesses</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__SRC_ACCESSES = eINSTANCE.getSubpassDependency_SrcAccesses();

		/**
		 * The meta object literal for the '<em><b>Dst Accesses</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__DST_ACCESSES = eINSTANCE.getSubpassDependency_DstAccesses();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachmentDescription()
		 * @generated
		 */
		EClass ATTACHMENT_DESCRIPTION = eINSTANCE.getAttachmentDescription();

		/**
		 * The meta object literal for the '<em><b>Samples</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__SAMPLES = eINSTANCE.getAttachmentDescription_Samples();

		/**
		 * The meta object literal for the '<em><b>Load Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__LOAD_OP = eINSTANCE.getAttachmentDescription_LoadOp();

		/**
		 * The meta object literal for the '<em><b>Store Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__STORE_OP = eINSTANCE.getAttachmentDescription_StoreOp();

		/**
		 * The meta object literal for the '<em><b>Stencil Load Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP = eINSTANCE
				.getAttachmentDescription_StencilLoadOp();

		/**
		 * The meta object literal for the '<em><b>Stencil Store Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP = eINSTANCE
				.getAttachmentDescription_StencilStoreOp();

		/**
		 * The meta object literal for the '<em><b>Initial Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT = eINSTANCE
				.getAttachmentDescription_InitialLayout();

		/**
		 * The meta object literal for the '<em><b>Final Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__FINAL_LAYOUT = eINSTANCE
				.getAttachmentDescription_FinalLayout();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageAttachmentDescriptionImpl <em>Swap Image Attachment Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageAttachmentDescriptionImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSwapImageAttachmentDescription()
		 * @generated
		 */
		EClass SWAP_IMAGE_ATTACHMENT_DESCRIPTION = eINSTANCE.getSwapImageAttachmentDescription();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ExtraAttachmentDescriptionImpl <em>Extra Attachment Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ExtraAttachmentDescriptionImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getExtraAttachmentDescription()
		 * @generated
		 */
		EClass EXTRA_ATTACHMENT_DESCRIPTION = eINSTANCE.getExtraAttachmentDescription();

		/**
		 * The meta object literal for the '<em><b>Attachment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTRA_ATTACHMENT_DESCRIPTION__ATTACHMENT = eINSTANCE
				.getExtraAttachmentDescription_Attachment();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicProcess()
		 * @generated
		 */
		EClass GRAPHIC_PROCESS = eINSTANCE.getGraphicProcess();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_PROCESS__CONFIGURATION = eINSTANCE.getGraphicProcess_Configuration();

		/**
		 * The meta object literal for the '<em><b>Render Pass Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_PROCESS__RENDER_PASS_INFO = eINSTANCE.getGraphicProcess_RenderPassInfo();

		/**
		 * The meta object literal for the '<em><b>Field Of View Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_PROCESS__FIELD_OF_VIEW_Y = eINSTANCE.getGraphicProcess_FieldOfViewY();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicsPipeline()
		 * @generated
		 */
		EClass GRAPHICS_PIPELINE = eINSTANCE.getGraphicsPipeline();

		/**
		 * The meta object literal for the '<em><b>Shaders</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICS_PIPELINE__SHADERS = eINSTANCE.getGraphicsPipeline_Shaders();

		/**
		 * The meta object literal for the '<em><b>Viewport State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICS_PIPELINE__VIEWPORT_STATE = eINSTANCE
				.getGraphicsPipeline_ViewportState();

		/**
		 * The meta object literal for the '<em><b>Input Assembly</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICS_PIPELINE__INPUT_ASSEMBLY = eINSTANCE
				.getGraphicsPipeline_InputAssembly();

		/**
		 * The meta object literal for the '<em><b>Rasterizer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICS_PIPELINE__RASTERIZER = eINSTANCE.getGraphicsPipeline_Rasterizer();

		/**
		 * The meta object literal for the '<em><b>Color Blend</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICS_PIPELINE__COLOR_BLEND = eINSTANCE.getGraphicsPipeline_ColorBlend();

		/**
		 * The meta object literal for the '<em><b>Dynamic State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICS_PIPELINE__DYNAMIC_STATE = eINSTANCE.getGraphicsPipeline_DynamicState();

		/**
		 * The meta object literal for the '<em><b>Subpass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHICS_PIPELINE__SUBPASS = eINSTANCE.getGraphicsPipeline_Subpass();

		/**
		 * The meta object literal for the '<em><b>Vertex Descriptor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICS_PIPELINE__VERTEX_DESCRIPTOR = eINSTANCE
				.getGraphicsPipeline_VertexDescriptor();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageBarrierImpl <em>Swap Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSwapImageBarrier()
		 * @generated
		 */
		EClass SWAP_IMAGE_BARRIER = eINSTANCE.getSwapImageBarrier();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BlitToSwapImageImpl <em>Blit To Swap Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.BlitToSwapImageImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getBlitToSwapImage()
		 * @generated
		 */
		EClass BLIT_TO_SWAP_IMAGE = eINSTANCE.getBlitToSwapImage();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLIT_TO_SWAP_IMAGE__IMAGE = eINSTANCE.getBlitToSwapImage_Image();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl <em>Draw Indexed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDrawIndexed()
		 * @generated
		 */
		EClass DRAW_INDEXED = eINSTANCE.getDrawIndexed();

		/**
		 * The meta object literal for the '<em><b>Index Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW_INDEXED__INDEX_COUNT = eINSTANCE.getDrawIndexed_IndexCount();

		/**
		 * The meta object literal for the '<em><b>Instance Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW_INDEXED__INSTANCE_COUNT = eINSTANCE.getDrawIndexed_InstanceCount();

		/**
		 * The meta object literal for the '<em><b>First Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW_INDEXED__FIRST_INDEX = eINSTANCE.getDrawIndexed_FirstIndex();

		/**
		 * The meta object literal for the '<em><b>Vertex Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW_INDEXED__VERTEX_OFFSET = eINSTANCE.getDrawIndexed_VertexOffset();

		/**
		 * The meta object literal for the '<em><b>First Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW_INDEXED__FIRST_INSTANCE = eINSTANCE.getDrawIndexed_FirstInstance();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl <em>Draw</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDraw()
		 * @generated
		 */
		EClass DRAW = eINSTANCE.getDraw();

		/**
		 * The meta object literal for the '<em><b>Vertex Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW__VERTEX_COUNT = eINSTANCE.getDraw_VertexCount();

		/**
		 * The meta object literal for the '<em><b>Instance Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW__INSTANCE_COUNT = eINSTANCE.getDraw_InstanceCount();

		/**
		 * The meta object literal for the '<em><b>First Vertex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW__FIRST_VERTEX = eINSTANCE.getDraw_FirstVertex();

		/**
		 * The meta object literal for the '<em><b>First Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAW__FIRST_INSTANCE = eINSTANCE.getDraw_FirstInstance();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.VertexDescriptorImpl <em>Vertex Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.VertexDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getVertexDescriptor()
		 * @generated
		 */
		EClass VERTEX_DESCRIPTOR = eINSTANCE.getVertexDescriptor();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX_DESCRIPTOR__ATTRIBUTES = eINSTANCE.getVertexDescriptor_Attributes();

		/**
		 * The meta object literal for the '<em><b>Stride Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTEX_DESCRIPTOR__STRIDE_LENGTH = eINSTANCE.getVertexDescriptor_StrideLength();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttributeDescriptionImpl <em>Attribute Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.AttributeDescriptionImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttributeDescription()
		 * @generated
		 */
		EClass ATTRIBUTE_DESCRIPTION = eINSTANCE.getAttributeDescription();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_DESCRIPTION__FORMAT = eINSTANCE.getAttributeDescription_Format();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_DESCRIPTION__OFFSET = eINSTANCE.getAttributeDescription_Offset();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.IndexedVertexDescriptorImpl <em>Indexed Vertex Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.IndexedVertexDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIndexedVertexDescriptor()
		 * @generated
		 */
		EClass INDEXED_VERTEX_DESCRIPTOR = eINSTANCE.getIndexedVertexDescriptor();

		/**
		 * The meta object literal for the '<em><b>Index Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEXED_VERTEX_DESCRIPTOR__INDEX_TYPE = eINSTANCE
				.getIndexedVertexDescriptor_IndexType();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl <em>Bind Vertex Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getBindVertexBuffer()
		 * @generated
		 */
		EClass BIND_VERTEX_BUFFER = eINSTANCE.getBindVertexBuffer();

		/**
		 * The meta object literal for the '<em><b>First Binding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIND_VERTEX_BUFFER__FIRST_BINDING = eINSTANCE.getBindVertexBuffer_FirstBinding();

		/**
		 * The meta object literal for the '<em><b>Vertex Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIND_VERTEX_BUFFER__VERTEX_BINDINGS = eINSTANCE
				.getBindVertexBuffer_VertexBindings();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl <em>Set Scissor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSetScissor()
		 * @generated
		 */
		EClass SET_SCISSOR = eINSTANCE.getSetScissor();

		/**
		 * The meta object literal for the '<em><b>Offset X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SCISSOR__OFFSET_X = eINSTANCE.getSetScissor_OffsetX();

		/**
		 * The meta object literal for the '<em><b>Offset Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SCISSOR__OFFSET_Y = eINSTANCE.getSetScissor_OffsetY();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SCISSOR__WIDTH = eINSTANCE.getSetScissor_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SCISSOR__HEIGHT = eINSTANCE.getSetScissor_Height();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SetViewportImpl <em>Set Viewport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SetViewportImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSetViewport()
		 * @generated
		 */
		EClass SET_VIEWPORT = eINSTANCE.getSetViewport();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_VIEWPORT__X = eINSTANCE.getSetViewport_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_VIEWPORT__Y = eINSTANCE.getSetViewport_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_VIEWPORT__WIDTH = eINSTANCE.getSetViewport_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_VIEWPORT__HEIGHT = eINSTANCE.getSetViewport_Height();

		/**
		 * The meta object literal for the '<em><b>Min Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_VIEWPORT__MIN_DEPTH = eINSTANCE.getSetViewport_MinDepth();

		/**
		 * The meta object literal for the '<em><b>Max Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_VIEWPORT__MAX_DEPTH = eINSTANCE.getSetViewport_MaxDepth();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl <em>Vertex Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getVertexBinding()
		 * @generated
		 */
		EClass VERTEX_BINDING = eINSTANCE.getVertexBinding();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX_BINDING__BUFFER = eINSTANCE.getVertexBinding_Buffer();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTEX_BINDING__OFFSET = eINSTANCE.getVertexBinding_Offset();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl <em>Bind Index Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getBindIndexBuffer()
		 * @generated
		 */
		EClass BIND_INDEX_BUFFER = eINSTANCE.getBindIndexBuffer();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIND_INDEX_BUFFER__BUFFER = eINSTANCE.getBindIndexBuffer_Buffer();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIND_INDEX_BUFFER__OFFSET = eINSTANCE.getBindIndexBuffer_Offset();

	}

} //GraphicPackage
