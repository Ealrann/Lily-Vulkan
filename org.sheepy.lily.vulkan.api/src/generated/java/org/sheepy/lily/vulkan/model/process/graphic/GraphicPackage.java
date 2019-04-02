/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

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
 *        annotation="http://www.eclipse.org/emf/2002/GenModel cleanup='true' codeFormatting='true' modelDirectory='/org.sheepy.lily.vulkan.model/src/generated/java' editDirectory='/org.sheepy.lily.vulkan.model.edit/src/generated/java' publicConstructors='true' complianceLevel='11.0' resource='XMI' extensibleProviderFactory='true' childCreationExtenders='true' updateClasspath='false' basePackage='org.sheepy.lily.vulkan.model.process'"
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl <em>Swapchain Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSwapchainConfiguration()
	 * @generated
	 */
	int SWAPCHAIN_CONFIGURATION = 1;

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
	int FRAMEBUFFER_CONFIGURATION = 2;

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
	int ISWAP_ATTACHMENT = 3;

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
	int IMAGE_ATTACHMENT = 4;

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
	int DEPTH_ATTACHMENT = 5;

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
	int RENDER_PASS_INFO = 6;

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
	int SUBPASS = 7;

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
	int ATTACHEMENT_REF = 8;

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
	int SUBPASS_DEPENDENCY = 9;

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
	int ATTACHMENT_DESCRIPTION = 10;

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
	int SWAP_IMAGE_ATTACHMENT_DESCRIPTION = 11;

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
	int EXTRA_ATTACHMENT_DESCRIPTION = 12;

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
	int GRAPHIC_PROCESS = 13;

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
	 * The feature id for the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__DESCRIPTOR_SET_PKG = ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SET_PKG;

	/**
	 * The feature id for the '<em><b>Pipeline Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__PIPELINE_PKG = ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG;

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
	 * The feature id for the '<em><b>Graphic Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__GRAPHIC_OFFSET = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Field Of View Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__FIELD_OF_VIEW_Y = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_FEATURE_COUNT = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_OPERATION_COUNT = ProcessPackage.ABSTRACT_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline <em>IGraphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIGraphicsPipeline()
	 * @generated
	 */
	int IGRAPHICS_PIPELINE = 14;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE__CONTENT_OBJECTS = ProcessPackage.IPIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE__NAME = ProcessPackage.IPIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE__ENABLED = ProcessPackage.IPIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE__STAGE = ProcessPackage.IPIPELINE__STAGE;

	/**
	 * The number of structural features of the '<em>IGraphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE_FEATURE_COUNT = ProcessPackage.IPIPELINE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE___LINFERENCE_OBJECT = ProcessPackage.IPIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = ProcessPackage.IPIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE___LCONTENTS = ProcessPackage.IPIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE___LPARENT = ProcessPackage.IPIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE___LALL_CONTENTS = ProcessPackage.IPIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IGraphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE_OPERATION_COUNT = ProcessPackage.IPIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline <em>IGUI Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIGUIPipeline()
	 * @generated
	 */
	int IGUI_PIPELINE = 15;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE__CONTENT_OBJECTS = IGRAPHICS_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE__NAME = IGRAPHICS_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE__ENABLED = IGRAPHICS_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE__STAGE = IGRAPHICS_PIPELINE__STAGE;

	/**
	 * The number of structural features of the '<em>IGUI Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE_FEATURE_COUNT = IGRAPHICS_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE___LINFERENCE_OBJECT = IGRAPHICS_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = IGRAPHICS_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE___LCONTENTS = IGRAPHICS_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE___LPARENT = IGRAPHICS_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE___LALL_CONTENTS = IGRAPHICS_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IGUI Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE_OPERATION_COUNT = IGRAPHICS_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractGraphicsPipelineImpl <em>Abstract Graphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractGraphicsPipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAbstractGraphicsPipeline()
	 * @generated
	 */
	int ABSTRACT_GRAPHICS_PIPELINE = 16;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__CONTENT_OBJECTS = ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__NAME = ProcessPackage.ABSTRACT_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__ENABLED = ProcessPackage.ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__STAGE = ProcessPackage.ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__RESOURCE_PKG = ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__UNITS = ProcessPackage.ABSTRACT_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET_REF;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__DESCRIPTOR_SET = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__CONSTANTS = ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__SHADERS = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__VIEWPORT_STATE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT
			+ 1;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__INPUT_ASSEMBLY = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT
			+ 2;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__RASTERIZER = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__COLOR_BLEND = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT
			+ 4;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__DYNAMIC_STATE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT
			+ 5;

	/**
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE__SUBPASS = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Abstract Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE_FEATURE_COUNT = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT
			+ 7;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE___LINFERENCE_OBJECT = ProcessPackage.ABSTRACT_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = ProcessPackage.ABSTRACT_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE___LCONTENTS = ProcessPackage.ABSTRACT_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE___LPARENT = ProcessPackage.ABSTRACT_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE___LALL_CONTENTS = ProcessPackage.ABSTRACT_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Abstract Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPHICS_PIPELINE_OPERATION_COUNT = ProcessPackage.ABSTRACT_PIPELINE_OPERATION_COUNT
			+ 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicsPipeline()
	 * @generated
	 */
	int GRAPHICS_PIPELINE = 17;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__CONTENT_OBJECTS = ABSTRACT_GRAPHICS_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__NAME = ABSTRACT_GRAPHICS_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__ENABLED = ABSTRACT_GRAPHICS_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__STAGE = ABSTRACT_GRAPHICS_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__RESOURCE_PKG = ABSTRACT_GRAPHICS_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__UNITS = ABSTRACT_GRAPHICS_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF = ABSTRACT_GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DESCRIPTOR_SET = ABSTRACT_GRAPHICS_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__CONSTANTS = ABSTRACT_GRAPHICS_PIPELINE__CONSTANTS;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__SHADERS = ABSTRACT_GRAPHICS_PIPELINE__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__VIEWPORT_STATE = ABSTRACT_GRAPHICS_PIPELINE__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__INPUT_ASSEMBLY = ABSTRACT_GRAPHICS_PIPELINE__INPUT_ASSEMBLY;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__RASTERIZER = ABSTRACT_GRAPHICS_PIPELINE__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__COLOR_BLEND = ABSTRACT_GRAPHICS_PIPELINE__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DYNAMIC_STATE = ABSTRACT_GRAPHICS_PIPELINE__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__SUBPASS = ABSTRACT_GRAPHICS_PIPELINE__SUBPASS;

	/**
	 * The number of structural features of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_FEATURE_COUNT = ABSTRACT_GRAPHICS_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___LINFERENCE_OBJECT = ABSTRACT_GRAPHICS_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = ABSTRACT_GRAPHICS_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___LCONTENTS = ABSTRACT_GRAPHICS_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___LPARENT = ABSTRACT_GRAPHICS_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___LALL_CONTENTS = ABSTRACT_GRAPHICS_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_OPERATION_COUNT = ABSTRACT_GRAPHICS_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DynamicStateImpl <em>Dynamic State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DynamicStateImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDynamicState()
	 * @generated
	 */
	int DYNAMIC_STATE = 18;

	/**
	 * The feature id for the '<em><b>States</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STATE__STATES = 0;

	/**
	 * The number of structural features of the '<em>Dynamic State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STATE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Dynamic State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl <em>Color Blend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorBlend()
	 * @generated
	 */
	int COLOR_BLEND = 19;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__ATTACHMENTS = 0;

	/**
	 * The feature id for the '<em><b>Logic Op Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__LOGIC_OP_ENABLE = 1;

	/**
	 * The feature id for the '<em><b>Logic Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__LOGIC_OP = 2;

	/**
	 * The feature id for the '<em><b>Blend Constant0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__BLEND_CONSTANT0 = 3;

	/**
	 * The feature id for the '<em><b>Blend Constant1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__BLEND_CONSTANT1 = 4;

	/**
	 * The feature id for the '<em><b>Blend Constant2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__BLEND_CONSTANT2 = 5;

	/**
	 * The feature id for the '<em><b>Blend Constant3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__BLEND_CONSTANT3 = 6;

	/**
	 * The number of structural features of the '<em>Color Blend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Color Blend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl <em>Color Blend Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorBlendAttachment()
	 * @generated
	 */
	int COLOR_BLEND_ATTACHMENT = 20;

	/**
	 * The feature id for the '<em><b>Blend Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__BLEND_ENABLE = 0;

	/**
	 * The feature id for the '<em><b>Src Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__SRC_COLOR = 1;

	/**
	 * The feature id for the '<em><b>Dst Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__DST_COLOR = 2;

	/**
	 * The feature id for the '<em><b>Src Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__SRC_ALPHA = 3;

	/**
	 * The feature id for the '<em><b>Dst Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__DST_ALPHA = 4;

	/**
	 * The feature id for the '<em><b>Color Blend Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP = 5;

	/**
	 * The feature id for the '<em><b>Alpha Blend Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP = 6;

	/**
	 * The feature id for the '<em><b>Red Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE = 7;

	/**
	 * The feature id for the '<em><b>Green Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE = 8;

	/**
	 * The feature id for the '<em><b>Blue Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE = 9;

	/**
	 * The feature id for the '<em><b>Alpha Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE = 10;

	/**
	 * The number of structural features of the '<em>Color Blend Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Color Blend Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.ViewportState <em>Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ViewportState
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getViewportState()
	 * @generated
	 */
	int VIEWPORT_STATE = 21;

	/**
	 * The number of structural features of the '<em>Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT_STATE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.StaticViewportStateImpl <em>Static Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.StaticViewportStateImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getStaticViewportState()
	 * @generated
	 */
	int STATIC_VIEWPORT_STATE = 22;

	/**
	 * The feature id for the '<em><b>Viewports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEWPORT_STATE__VIEWPORTS = VIEWPORT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scissors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEWPORT_STATE__SCISSORS = VIEWPORT_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Static Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEWPORT_STATE_FEATURE_COUNT = VIEWPORT_STATE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Static Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEWPORT_STATE_OPERATION_COUNT = VIEWPORT_STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DynamicViewportStateImpl <em>Dynamic Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DynamicViewportStateImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDynamicViewportState()
	 * @generated
	 */
	int DYNAMIC_VIEWPORT_STATE = 23;

	/**
	 * The feature id for the '<em><b>Viewport Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT = VIEWPORT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scissor Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT = VIEWPORT_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dynamic Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VIEWPORT_STATE_FEATURE_COUNT = VIEWPORT_STATE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dynamic Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VIEWPORT_STATE_OPERATION_COUNT = VIEWPORT_STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ViewportImpl <em>Viewport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ViewportImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getViewport()
	 * @generated
	 */
	int VIEWPORT = 24;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__OFFSET = 0;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__EXTENT = 1;

	/**
	 * The feature id for the '<em><b>Min Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__MIN_DEPTH = 2;

	/**
	 * The feature id for the '<em><b>Max Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__MAX_DEPTH = 3;

	/**
	 * The number of structural features of the '<em>Viewport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Viewport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ScissorImpl <em>Scissor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ScissorImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getScissor()
	 * @generated
	 */
	int SCISSOR = 25;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR__OFFSET = 0;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR__EXTENT = 1;

	/**
	 * The number of structural features of the '<em>Scissor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Scissor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RasterizerImpl <em>Rasterizer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.RasterizerImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getRasterizer()
	 * @generated
	 */
	int RASTERIZER = 26;

	/**
	 * The feature id for the '<em><b>Cull Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__CULL_MODE = 0;

	/**
	 * The feature id for the '<em><b>Front Face</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__FRONT_FACE = 1;

	/**
	 * The feature id for the '<em><b>Polygon Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__POLYGON_MODE = 2;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__LINE_WIDTH = 3;

	/**
	 * The feature id for the '<em><b>Depth Clamp Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__DEPTH_CLAMP_ENABLE = 4;

	/**
	 * The feature id for the '<em><b>Discard Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__DISCARD_ENABLE = 5;

	/**
	 * The feature id for the '<em><b>Depth Bias Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__DEPTH_BIAS_ENABLE = 6;

	/**
	 * The number of structural features of the '<em>Rasterizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Rasterizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.InputAssemblyImpl <em>Input Assembly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.InputAssemblyImpl
	 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getInputAssembly()
	 * @generated
	 */
	int INPUT_ASSEMBLY = 27;

	/**
	 * The feature id for the '<em><b>Primitive Restart Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Primitive Topology</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY = 1;

	/**
	 * The number of structural features of the '<em>Input Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSEMBLY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Input Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSEMBLY_OPERATION_COUNT = 0;

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getGraphicOffset <em>Graphic Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Graphic Offset</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess#getGraphicOffset()
	 * @see #getGraphicProcess()
	 * @generated
	 */
	EAttribute getGraphicProcess_GraphicOffset();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline <em>IGraphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IGraphics Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline
	 * @generated
	 */
	EClass getIGraphicsPipeline();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline <em>IGUI Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IGUI Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline
	 * @generated
	 */
	EClass getIGUIPipeline();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline <em>Abstract Graphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Graphics Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline
	 * @generated
	 */
	EClass getAbstractGraphicsPipeline();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getShaders <em>Shaders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shaders</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getShaders()
	 * @see #getAbstractGraphicsPipeline()
	 * @generated
	 */
	EReference getAbstractGraphicsPipeline_Shaders();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getViewportState <em>Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Viewport State</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getViewportState()
	 * @see #getAbstractGraphicsPipeline()
	 * @generated
	 */
	EReference getAbstractGraphicsPipeline_ViewportState();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getInputAssembly <em>Input Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Assembly</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getInputAssembly()
	 * @see #getAbstractGraphicsPipeline()
	 * @generated
	 */
	EReference getAbstractGraphicsPipeline_InputAssembly();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getRasterizer <em>Rasterizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rasterizer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getRasterizer()
	 * @see #getAbstractGraphicsPipeline()
	 * @generated
	 */
	EReference getAbstractGraphicsPipeline_Rasterizer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getColorBlend <em>Color Blend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Color Blend</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getColorBlend()
	 * @see #getAbstractGraphicsPipeline()
	 * @generated
	 */
	EReference getAbstractGraphicsPipeline_ColorBlend();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getDynamicState <em>Dynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dynamic State</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getDynamicState()
	 * @see #getAbstractGraphicsPipeline()
	 * @generated
	 */
	EReference getAbstractGraphicsPipeline_DynamicState();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getSubpass <em>Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subpass</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.AbstractGraphicsPipeline#getSubpass()
	 * @see #getAbstractGraphicsPipeline()
	 * @generated
	 */
	EAttribute getAbstractGraphicsPipeline_Subpass();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.DynamicState <em>Dynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic State</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DynamicState
	 * @generated
	 */
	EClass getDynamicState();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.process.graphic.DynamicState#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>States</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DynamicState#getStates()
	 * @see #getDynamicState()
	 * @generated
	 */
	EAttribute getDynamicState_States();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend <em>Color Blend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Blend</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend
	 * @generated
	 */
	EClass getColorBlend();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachments</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getAttachments()
	 * @see #getColorBlend()
	 * @generated
	 */
	EReference getColorBlend_Attachments();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#isLogicOpEnable <em>Logic Op Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logic Op Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#isLogicOpEnable()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_LogicOpEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getLogicOp <em>Logic Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logic Op</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getLogicOp()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_LogicOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getBlendConstant0 <em>Blend Constant0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant0</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getBlendConstant0()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant0();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getBlendConstant1 <em>Blend Constant1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant1</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getBlendConstant1()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant1();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getBlendConstant2 <em>Blend Constant2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant2</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getBlendConstant2()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant2();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getBlendConstant3 <em>Blend Constant3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant3</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlend#getBlendConstant3()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant3();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment <em>Color Blend Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Blend Attachment</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment
	 * @generated
	 */
	EClass getColorBlendAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isBlendEnable <em>Blend Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isBlendEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_BlendEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isRedComponentEnable <em>Red Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Red Component Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isRedComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_RedComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isGreenComponentEnable <em>Green Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Green Component Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isGreenComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_GreenComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isBlueComponentEnable <em>Blue Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blue Component Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isBlueComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_BlueComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isAlphaComponentEnable <em>Alpha Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Component Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#isAlphaComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_AlphaComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getSrcColor <em>Src Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Color</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getSrcColor()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_SrcColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getDstColor <em>Dst Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Color</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getDstColor()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_DstColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getSrcAlpha <em>Src Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Alpha</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getSrcAlpha()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_SrcAlpha();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getDstAlpha <em>Dst Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Alpha</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getDstAlpha()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_DstAlpha();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getColorBlendOp <em>Color Blend Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Blend Op</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getColorBlendOp()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_ColorBlendOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getAlphaBlendOp <em>Alpha Blend Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Blend Op</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ColorBlendAttachment#getAlphaBlendOp()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_AlphaBlendOp();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.ViewportState <em>Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewport State</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.ViewportState
	 * @generated
	 */
	EClass getViewportState();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState <em>Static Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Viewport State</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState
	 * @generated
	 */
	EClass getStaticViewportState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState#getViewports <em>Viewports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Viewports</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState#getViewports()
	 * @see #getStaticViewportState()
	 * @generated
	 */
	EReference getStaticViewportState_Viewports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState#getScissors <em>Scissors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scissors</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState#getScissors()
	 * @see #getStaticViewportState()
	 * @generated
	 */
	EReference getStaticViewportState_Scissors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState <em>Dynamic Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Viewport State</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState
	 * @generated
	 */
	EClass getDynamicViewportState();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState#getViewportCount <em>Viewport Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Viewport Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState#getViewportCount()
	 * @see #getDynamicViewportState()
	 * @generated
	 */
	EAttribute getDynamicViewportState_ViewportCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState#getScissorCount <em>Scissor Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scissor Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.DynamicViewportState#getScissorCount()
	 * @see #getDynamicViewportState()
	 * @generated
	 */
	EAttribute getDynamicViewportState_ScissorCount();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.Viewport <em>Viewport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewport</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Viewport
	 * @generated
	 */
	EClass getViewport();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Viewport#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Viewport#getOffset()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Viewport#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extent</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Viewport#getExtent()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_Extent();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Viewport#getMinDepth <em>Min Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Depth</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Viewport#getMinDepth()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_MinDepth();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Viewport#getMaxDepth <em>Max Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Depth</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Viewport#getMaxDepth()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_MaxDepth();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.Scissor <em>Scissor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scissor</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Scissor
	 * @generated
	 */
	EClass getScissor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Scissor#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Scissor#getOffset()
	 * @see #getScissor()
	 * @generated
	 */
	EAttribute getScissor_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Scissor#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extent</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Scissor#getExtent()
	 * @see #getScissor()
	 * @generated
	 */
	EAttribute getScissor_Extent();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer <em>Rasterizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rasterizer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer
	 * @generated
	 */
	EClass getRasterizer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#getCullMode <em>Cull Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cull Mode</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#getCullMode()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_CullMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#getFrontFace <em>Front Face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Front Face</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#getFrontFace()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_FrontFace();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#getPolygonMode <em>Polygon Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Polygon Mode</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#getPolygonMode()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_PolygonMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#getLineWidth <em>Line Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Width</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#getLineWidth()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_LineWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#isDepthClampEnable <em>Depth Clamp Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Clamp Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#isDepthClampEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DepthClampEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#isDiscardEnable <em>Discard Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discard Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#isDiscardEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DiscardEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#isDepthBiasEnable <em>Depth Bias Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Bias Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.Rasterizer#isDepthBiasEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DepthBiasEnable();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.graphic.InputAssembly <em>Input Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Assembly</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.InputAssembly
	 * @generated
	 */
	EClass getInputAssembly();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.InputAssembly#isPrimitiveRestartEnabled <em>Primitive Restart Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive Restart Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.InputAssembly#isPrimitiveRestartEnabled()
	 * @see #getInputAssembly()
	 * @generated
	 */
	EAttribute getInputAssembly_PrimitiveRestartEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.graphic.InputAssembly#getPrimitiveTopology <em>Primitive Topology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive Topology</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.InputAssembly#getPrimitiveTopology()
	 * @see #getInputAssembly()
	 * @generated
	 */
	EAttribute getInputAssembly_PrimitiveTopology();

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
		 * The meta object literal for the '<em><b>Graphic Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_PROCESS__GRAPHIC_OFFSET = eINSTANCE.getGraphicProcess_GraphicOffset();

		/**
		 * The meta object literal for the '<em><b>Field Of View Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_PROCESS__FIELD_OF_VIEW_Y = eINSTANCE.getGraphicProcess_FieldOfViewY();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline <em>IGraphics Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.IGraphicsPipeline
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIGraphicsPipeline()
		 * @generated
		 */
		EClass IGRAPHICS_PIPELINE = eINSTANCE.getIGraphicsPipeline();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline <em>IGUI Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.IGUIPipeline
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIGUIPipeline()
		 * @generated
		 */
		EClass IGUI_PIPELINE = eINSTANCE.getIGUIPipeline();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractGraphicsPipelineImpl <em>Abstract Graphics Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.AbstractGraphicsPipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAbstractGraphicsPipeline()
		 * @generated
		 */
		EClass ABSTRACT_GRAPHICS_PIPELINE = eINSTANCE.getAbstractGraphicsPipeline();

		/**
		 * The meta object literal for the '<em><b>Shaders</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GRAPHICS_PIPELINE__SHADERS = eINSTANCE
				.getAbstractGraphicsPipeline_Shaders();

		/**
		 * The meta object literal for the '<em><b>Viewport State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GRAPHICS_PIPELINE__VIEWPORT_STATE = eINSTANCE
				.getAbstractGraphicsPipeline_ViewportState();

		/**
		 * The meta object literal for the '<em><b>Input Assembly</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GRAPHICS_PIPELINE__INPUT_ASSEMBLY = eINSTANCE
				.getAbstractGraphicsPipeline_InputAssembly();

		/**
		 * The meta object literal for the '<em><b>Rasterizer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GRAPHICS_PIPELINE__RASTERIZER = eINSTANCE
				.getAbstractGraphicsPipeline_Rasterizer();

		/**
		 * The meta object literal for the '<em><b>Color Blend</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GRAPHICS_PIPELINE__COLOR_BLEND = eINSTANCE
				.getAbstractGraphicsPipeline_ColorBlend();

		/**
		 * The meta object literal for the '<em><b>Dynamic State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GRAPHICS_PIPELINE__DYNAMIC_STATE = eINSTANCE
				.getAbstractGraphicsPipeline_DynamicState();

		/**
		 * The meta object literal for the '<em><b>Subpass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_GRAPHICS_PIPELINE__SUBPASS = eINSTANCE
				.getAbstractGraphicsPipeline_Subpass();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DynamicStateImpl <em>Dynamic State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DynamicStateImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDynamicState()
		 * @generated
		 */
		EClass DYNAMIC_STATE = eINSTANCE.getDynamicState();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_STATE__STATES = eINSTANCE.getDynamicState_States();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl <em>Color Blend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorBlend()
		 * @generated
		 */
		EClass COLOR_BLEND = eINSTANCE.getColorBlend();

		/**
		 * The meta object literal for the '<em><b>Attachments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLOR_BLEND__ATTACHMENTS = eINSTANCE.getColorBlend_Attachments();

		/**
		 * The meta object literal for the '<em><b>Logic Op Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__LOGIC_OP_ENABLE = eINSTANCE.getColorBlend_LogicOpEnable();

		/**
		 * The meta object literal for the '<em><b>Logic Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__LOGIC_OP = eINSTANCE.getColorBlend_LogicOp();

		/**
		 * The meta object literal for the '<em><b>Blend Constant0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__BLEND_CONSTANT0 = eINSTANCE.getColorBlend_BlendConstant0();

		/**
		 * The meta object literal for the '<em><b>Blend Constant1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__BLEND_CONSTANT1 = eINSTANCE.getColorBlend_BlendConstant1();

		/**
		 * The meta object literal for the '<em><b>Blend Constant2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__BLEND_CONSTANT2 = eINSTANCE.getColorBlend_BlendConstant2();

		/**
		 * The meta object literal for the '<em><b>Blend Constant3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__BLEND_CONSTANT3 = eINSTANCE.getColorBlend_BlendConstant3();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl <em>Color Blend Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorBlendAttachment()
		 * @generated
		 */
		EClass COLOR_BLEND_ATTACHMENT = eINSTANCE.getColorBlendAttachment();

		/**
		 * The meta object literal for the '<em><b>Blend Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__BLEND_ENABLE = eINSTANCE
				.getColorBlendAttachment_BlendEnable();

		/**
		 * The meta object literal for the '<em><b>Red Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE = eINSTANCE
				.getColorBlendAttachment_RedComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Green Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE = eINSTANCE
				.getColorBlendAttachment_GreenComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Blue Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE = eINSTANCE
				.getColorBlendAttachment_BlueComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Alpha Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE = eINSTANCE
				.getColorBlendAttachment_AlphaComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Src Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__SRC_COLOR = eINSTANCE.getColorBlendAttachment_SrcColor();

		/**
		 * The meta object literal for the '<em><b>Dst Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__DST_COLOR = eINSTANCE.getColorBlendAttachment_DstColor();

		/**
		 * The meta object literal for the '<em><b>Src Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__SRC_ALPHA = eINSTANCE.getColorBlendAttachment_SrcAlpha();

		/**
		 * The meta object literal for the '<em><b>Dst Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__DST_ALPHA = eINSTANCE.getColorBlendAttachment_DstAlpha();

		/**
		 * The meta object literal for the '<em><b>Color Blend Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP = eINSTANCE
				.getColorBlendAttachment_ColorBlendOp();

		/**
		 * The meta object literal for the '<em><b>Alpha Blend Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP = eINSTANCE
				.getColorBlendAttachment_AlphaBlendOp();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.ViewportState <em>Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.ViewportState
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getViewportState()
		 * @generated
		 */
		EClass VIEWPORT_STATE = eINSTANCE.getViewportState();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.StaticViewportStateImpl <em>Static Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.StaticViewportStateImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getStaticViewportState()
		 * @generated
		 */
		EClass STATIC_VIEWPORT_STATE = eINSTANCE.getStaticViewportState();

		/**
		 * The meta object literal for the '<em><b>Viewports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIC_VIEWPORT_STATE__VIEWPORTS = eINSTANCE.getStaticViewportState_Viewports();

		/**
		 * The meta object literal for the '<em><b>Scissors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIC_VIEWPORT_STATE__SCISSORS = eINSTANCE.getStaticViewportState_Scissors();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DynamicViewportStateImpl <em>Dynamic Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.DynamicViewportStateImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDynamicViewportState()
		 * @generated
		 */
		EClass DYNAMIC_VIEWPORT_STATE = eINSTANCE.getDynamicViewportState();

		/**
		 * The meta object literal for the '<em><b>Viewport Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT = eINSTANCE
				.getDynamicViewportState_ViewportCount();

		/**
		 * The meta object literal for the '<em><b>Scissor Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT = eINSTANCE
				.getDynamicViewportState_ScissorCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ViewportImpl <em>Viewport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ViewportImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getViewport()
		 * @generated
		 */
		EClass VIEWPORT = eINSTANCE.getViewport();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWPORT__OFFSET = eINSTANCE.getViewport_Offset();

		/**
		 * The meta object literal for the '<em><b>Extent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWPORT__EXTENT = eINSTANCE.getViewport_Extent();

		/**
		 * The meta object literal for the '<em><b>Min Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWPORT__MIN_DEPTH = eINSTANCE.getViewport_MinDepth();

		/**
		 * The meta object literal for the '<em><b>Max Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWPORT__MAX_DEPTH = eINSTANCE.getViewport_MaxDepth();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ScissorImpl <em>Scissor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.ScissorImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getScissor()
		 * @generated
		 */
		EClass SCISSOR = eINSTANCE.getScissor();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCISSOR__OFFSET = eINSTANCE.getScissor_Offset();

		/**
		 * The meta object literal for the '<em><b>Extent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCISSOR__EXTENT = eINSTANCE.getScissor_Extent();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.RasterizerImpl <em>Rasterizer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.RasterizerImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getRasterizer()
		 * @generated
		 */
		EClass RASTERIZER = eINSTANCE.getRasterizer();

		/**
		 * The meta object literal for the '<em><b>Cull Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__CULL_MODE = eINSTANCE.getRasterizer_CullMode();

		/**
		 * The meta object literal for the '<em><b>Front Face</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__FRONT_FACE = eINSTANCE.getRasterizer_FrontFace();

		/**
		 * The meta object literal for the '<em><b>Polygon Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__POLYGON_MODE = eINSTANCE.getRasterizer_PolygonMode();

		/**
		 * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__LINE_WIDTH = eINSTANCE.getRasterizer_LineWidth();

		/**
		 * The meta object literal for the '<em><b>Depth Clamp Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__DEPTH_CLAMP_ENABLE = eINSTANCE.getRasterizer_DepthClampEnable();

		/**
		 * The meta object literal for the '<em><b>Discard Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__DISCARD_ENABLE = eINSTANCE.getRasterizer_DiscardEnable();

		/**
		 * The meta object literal for the '<em><b>Depth Bias Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__DEPTH_BIAS_ENABLE = eINSTANCE.getRasterizer_DepthBiasEnable();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.graphic.impl.InputAssemblyImpl <em>Input Assembly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.InputAssemblyImpl
		 * @see org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl#getInputAssembly()
		 * @generated
		 */
		EClass INPUT_ASSEMBLY = eINSTANCE.getInputAssembly();

		/**
		 * The meta object literal for the '<em><b>Primitive Restart Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED = eINSTANCE
				.getInputAssembly_PrimitiveRestartEnabled();

		/**
		 * The meta object literal for the '<em><b>Primitive Topology</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY = eINSTANCE
				.getInputAssembly_PrimitiveTopology();

	}

} //GraphicPackage
