/**
 */
package org.sheepy.vulkan.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.sheepy.vulkan.model.VulkanFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model.plugin/src/generated/java' modelName='Vulkan' prefix='Vulkan' publicConstructors='true' basePackage='org.sheepy.vulkan'"
 * @generated
 */
public interface VulkanPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VulkanPackage eINSTANCE = org.sheepy.vulkan.model.impl.VulkanPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.VulkanApplicationImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getVulkanApplication()
	 * @generated
	 */
	int VULKAN_APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Fullscreen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__FULLSCREEN = 1;

	/**
	 * The feature id for the '<em><b>Resizeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__RESIZEABLE = 2;

	/**
	 * The feature id for the '<em><b>Debug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__DEBUG = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__TITLE = 4;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__SIZE = 5;

	/**
	 * The feature id for the '<em><b>Compute Pools</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__COMPUTE_POOLS = 6;

	/**
	 * The feature id for the '<em><b>Graphic Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__GRAPHIC_POOL = 7;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.Configuration <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.Configuration
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.GraphicConfigurationImpl <em>Graphic Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.GraphicConfigurationImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getGraphicConfiguration()
	 * @generated
	 */
	int GRAPHIC_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Clear Before Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER = CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Presentation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__PRESENTATION_MODE = CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Swap Image Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE = CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Frame Wait Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE = CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Color Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__COLOR_DOMAIN = CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Rasterizer Cull Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE = CONFIGURATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Rasterizer Front Face</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE = CONFIGURATION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Graphic Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Graphic Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION_OPERATION_COUNT = CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.RenderPassInfoImpl <em>Render Pass Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.RenderPassInfoImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getRenderPassInfo()
	 * @generated
	 */
	int RENDER_PASS_INFO = 3;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO__ATTACHMENTS = 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO__DEPENDENCIES = 1;

	/**
	 * The feature id for the '<em><b>Bind Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO__BIND_POINT = 2;

	/**
	 * The number of structural features of the '<em>Render Pass Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Render Pass Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PASS_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.SubpassDependencyImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getSubpassDependency()
	 * @generated
	 */
	int SUBPASS_DEPENDENCY = 4;

	/**
	 * The feature id for the '<em><b>Src Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__SRC_SUBPASS = 0;

	/**
	 * The feature id for the '<em><b>Dst Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__DST_SUBPASS = 1;

	/**
	 * The feature id for the '<em><b>Src Stage Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__SRC_STAGE_MASK = 2;

	/**
	 * The feature id for the '<em><b>Dst Stage Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__DST_STAGE_MASK = 3;

	/**
	 * The feature id for the '<em><b>Src Access Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__SRC_ACCESS_MASK = 4;

	/**
	 * The feature id for the '<em><b>Dst Access Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBPASS_DEPENDENCY__DST_ACCESS_MASK = 5;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAttachmentDescription()
	 * @generated
	 */
	int ATTACHMENT_DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Stencil</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__STENCIL = 0;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__SAMPLES = 1;

	/**
	 * The feature id for the '<em><b>Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__LOAD_OP = 2;

	/**
	 * The feature id for the '<em><b>Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__STORE_OP = 3;

	/**
	 * The feature id for the '<em><b>Stencil Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP = 4;

	/**
	 * The feature id for the '<em><b>Stencil Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP = 5;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT = 6;

	/**
	 * The feature id for the '<em><b>Final Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__FINAL_LAYOUT = 7;

	/**
	 * The feature id for the '<em><b>Ref Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__REF_LAYOUT = 8;

	/**
	 * The number of structural features of the '<em>Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ColorDomainImpl <em>Color Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ColorDomainImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getColorDomain()
	 * @generated
	 */
	int COLOR_DOMAIN = 6;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.AbstractProcessPoolImpl <em>Abstract Process Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.AbstractProcessPoolImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractProcessPool()
	 * @generated
	 */
	int ABSTRACT_PROCESS_POOL = 7;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_POOL__PROCESSES = 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_POOL__RESOURCES = 1;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_POOL__RESET_ALLOWED = 2;

	/**
	 * The number of structural features of the '<em>Abstract Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_POOL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Abstract Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_POOL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ComputeProcessPoolImpl <em>Compute Process Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ComputeProcessPoolImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getComputeProcessPool()
	 * @generated
	 */
	int COMPUTE_PROCESS_POOL = 8;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL__PROCESSES = ABSTRACT_PROCESS_POOL__PROCESSES;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL__RESOURCES = ABSTRACT_PROCESS_POOL__RESOURCES;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL__RESET_ALLOWED = ABSTRACT_PROCESS_POOL__RESET_ALLOWED;

	/**
	 * The number of structural features of the '<em>Compute Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL_FEATURE_COUNT = ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Compute Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL_OPERATION_COUNT = ABSTRACT_PROCESS_POOL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.GraphicProcessPoolImpl <em>Graphic Process Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.GraphicProcessPoolImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getGraphicProcessPool()
	 * @generated
	 */
	int GRAPHIC_PROCESS_POOL = 9;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__PROCESSES = ABSTRACT_PROCESS_POOL__PROCESSES;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__RESOURCES = ABSTRACT_PROCESS_POOL__RESOURCES;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__RESET_ALLOWED = ABSTRACT_PROCESS_POOL__RESET_ALLOWED;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__CONFIGURATION = ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Render Pass Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO = ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Depth Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__DEPTH_IMAGE = ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Graphic Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL_FEATURE_COUNT = ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Graphic Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL_OPERATION_COUNT = ABSTRACT_PROCESS_POOL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.AbstractProcessImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractProcess()
	 * @generated
	 */
	int ABSTRACT_PROCESS = 10;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__UNITS = 0;

	/**
	 * The number of structural features of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.GraphicProcessImpl <em>Graphic Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.GraphicProcessImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getGraphicProcess()
	 * @generated
	 */
	int GRAPHIC_PROCESS = 11;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__UNITS = ABSTRACT_PROCESS__UNITS;

	/**
	 * The number of structural features of the '<em>Graphic Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_FEATURE_COUNT = ABSTRACT_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Graphic Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_OPERATION_COUNT = ABSTRACT_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ComputeProcessImpl <em>Compute Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ComputeProcessImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getComputeProcess()
	 * @generated
	 */
	int COMPUTE_PROCESS = 12;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__UNITS = ABSTRACT_PROCESS__UNITS;

	/**
	 * The number of structural features of the '<em>Compute Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_FEATURE_COUNT = ABSTRACT_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Compute Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_OPERATION_COUNT = ABSTRACT_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.IProcessUnit <em>IProcess Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.IProcessUnit
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIProcessUnit()
	 * @generated
	 */
	int IPROCESS_UNIT = 13;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT__STAGE = 1;

	/**
	 * The number of structural features of the '<em>IProcess Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>IProcess Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.PipelineBarrierImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getPipelineBarrier()
	 * @generated
	 */
	int PIPELINE_BARRIER = 14;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__ENABLED = IPROCESS_UNIT__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__STAGE = IPROCESS_UNIT__STAGE;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__SRC_STAGE = IPROCESS_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__DST_STAGE = IPROCESS_UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_FEATURE_COUNT = IPROCESS_UNIT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_OPERATION_COUNT = IPROCESS_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.BufferBarrierImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getBufferBarrier()
	 * @generated
	 */
	int BUFFER_BARRIER = 15;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__ENABLED = PIPELINE_BARRIER__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__STAGE = PIPELINE_BARRIER__STAGE;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__SRC_STAGE = PIPELINE_BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__DST_STAGE = PIPELINE_BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__BUFFER = PIPELINE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__SRC_ACCESS = PIPELINE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__DST_ACCESS = PIPELINE_BARRIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER_FEATURE_COUNT = PIPELINE_BARRIER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER_OPERATION_COUNT = PIPELINE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.AbstractImageBarrierImpl <em>Abstract Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.AbstractImageBarrierImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractImageBarrier()
	 * @generated
	 */
	int ABSTRACT_IMAGE_BARRIER = 16;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__ENABLED = PIPELINE_BARRIER__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__STAGE = PIPELINE_BARRIER__STAGE;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__SRC_STAGE = PIPELINE_BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__DST_STAGE = PIPELINE_BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__TRANSITIONS = PIPELINE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT = PIPELINE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT = PIPELINE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ImageBarrierImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getImageBarrier()
	 * @generated
	 */
	int IMAGE_BARRIER = 17;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__ENABLED = ABSTRACT_IMAGE_BARRIER__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__STAGE = ABSTRACT_IMAGE_BARRIER__STAGE;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__SRC_STAGE = ABSTRACT_IMAGE_BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__DST_STAGE = ABSTRACT_IMAGE_BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__TRANSITIONS = ABSTRACT_IMAGE_BARRIER__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__IMAGE = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER_FEATURE_COUNT = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER_OPERATION_COUNT = ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ReferenceImageBarrierImpl <em>Reference Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ReferenceImageBarrierImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getReferenceImageBarrier()
	 * @generated
	 */
	int REFERENCE_IMAGE_BARRIER = 18;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__ENABLED = ABSTRACT_IMAGE_BARRIER__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__STAGE = ABSTRACT_IMAGE_BARRIER__STAGE;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__SRC_STAGE = ABSTRACT_IMAGE_BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__DST_STAGE = ABSTRACT_IMAGE_BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__TRANSITIONS = ABSTRACT_IMAGE_BARRIER__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__IMAGE_ID = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__MIP_LEVELS = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER_FEATURE_COUNT = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Reference Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER_OPERATION_COUNT = ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ImageTransitionImpl <em>Image Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ImageTransitionImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getImageTransition()
	 * @generated
	 */
	int IMAGE_TRANSITION = 19;

	/**
	 * The feature id for the '<em><b>Src Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__SRC_LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Dst Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__DST_LAYOUT = 1;

	/**
	 * The feature id for the '<em><b>Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__SRC_ACCESS = 2;

	/**
	 * The feature id for the '<em><b>Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__DST_ACCESS = 3;

	/**
	 * The number of structural features of the '<em>Image Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Image Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.IDescriptor <em>IDescriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.IDescriptor
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIDescriptor()
	 * @generated
	 */
	int IDESCRIPTOR = 20;

	/**
	 * The number of structural features of the '<em>IDescriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IDescriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.DescriptorSetImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getDescriptorSet()
	 * @generated
	 */
	int DESCRIPTOR_SET = 21;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET__DESCRIPTORS = 0;

	/**
	 * The number of structural features of the '<em>Descriptor Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Descriptor Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.AbstractPipelineImpl <em>Abstract Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.AbstractPipelineImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractPipeline()
	 * @generated
	 */
	int ABSTRACT_PIPELINE = 22;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__ENABLED = IPROCESS_UNIT__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__STAGE = IPROCESS_UNIT__STAGE;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__DESCRIPTOR_SET = IPROCESS_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__PUSH_CONSTANT = IPROCESS_UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE_FEATURE_COUNT = IPROCESS_UNIT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Abstract Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE_OPERATION_COUNT = IPROCESS_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.AbstractCompositePipelineImpl <em>Abstract Composite Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.AbstractCompositePipelineImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractCompositePipeline()
	 * @generated
	 */
	int ABSTRACT_COMPOSITE_PIPELINE = 23;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__ENABLED = ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__STAGE = ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__DESCRIPTOR_SET = ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__PUSH_CONSTANT = ABSTRACT_PIPELINE__PUSH_CONSTANT;

	/**
	 * The feature id for the '<em><b>Pipelines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__PIPELINES = ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Composite Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE_FEATURE_COUNT = ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Composite Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE_OPERATION_COUNT = ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.GraphicsPipelineImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getGraphicsPipeline()
	 * @generated
	 */
	int GRAPHICS_PIPELINE = 24;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__ENABLED = ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__STAGE = ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DESCRIPTOR_SET = ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__PUSH_CONSTANT = ABSTRACT_PIPELINE__PUSH_CONSTANT;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__SHADERS = ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_FEATURE_COUNT = ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_OPERATION_COUNT = ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ComputePipelineImpl <em>Compute Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ComputePipelineImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getComputePipeline()
	 * @generated
	 */
	int COMPUTE_PIPELINE = 25;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__ENABLED = ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__STAGE = ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__DESCRIPTOR_SET = ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__PUSH_CONSTANT = ABSTRACT_PIPELINE__PUSH_CONSTANT;

	/**
	 * The feature id for the '<em><b>Computers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__COMPUTERS = ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Workgroup Size X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__WORKGROUP_SIZE_X = ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Workgroup Size Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__WORKGROUP_SIZE_Y = ABSTRACT_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Workgroup Size Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__WORKGROUP_SIZE_Z = ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__WIDTH = ABSTRACT_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__HEIGHT = ABSTRACT_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__DEPTH = ABSTRACT_PIPELINE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Compute Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE_FEATURE_COUNT = ABSTRACT_PIPELINE_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Compute Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE_OPERATION_COUNT = ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ComputerImpl <em>Computer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ComputerImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getComputer()
	 * @generated
	 */
	int COMPUTER = 26;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__ENABLED = IPROCESS_UNIT__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__STAGE = IPROCESS_UNIT__STAGE;

	/**
	 * The feature id for the '<em><b>Shader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__SHADER = IPROCESS_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_FEATURE_COUNT = IPROCESS_UNIT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_OPERATION_COUNT = IPROCESS_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ImagePipelineImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getImagePipeline()
	 * @generated
	 */
	int IMAGE_PIPELINE = 27;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__ENABLED = ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__STAGE = ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__DESCRIPTOR_SET = ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__PUSH_CONSTANT = ABSTRACT_PIPELINE__PUSH_CONSTANT;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE = ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_SRC_STAGE = ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_DST_STAGE = ABSTRACT_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Image Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_SRC_ACCESS = ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Image Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_DST_ACCESS = ABSTRACT_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Image Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE_FEATURE_COUNT = ABSTRACT_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Image Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE_OPERATION_COUNT = ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.MeshPipelineImpl <em>Mesh Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.MeshPipelineImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getMeshPipeline()
	 * @generated
	 */
	int MESH_PIPELINE = 28;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__ENABLED = GRAPHICS_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__STAGE = GRAPHICS_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__DESCRIPTOR_SET = GRAPHICS_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__PUSH_CONSTANT = GRAPHICS_PIPELINE__PUSH_CONSTANT;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__SHADERS = GRAPHICS_PIPELINE__SHADERS;

	/**
	 * The feature id for the '<em><b>Mesh</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__MESH = GRAPHICS_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mesh Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE_FEATURE_COUNT = GRAPHICS_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mesh Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE_OPERATION_COUNT = GRAPHICS_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.Resource <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.Resource
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 29;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.VulkanBuffer <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.VulkanBuffer
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getVulkanBuffer()
	 * @generated
	 */
	int VULKAN_BUFFER = 30;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_BUFFER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_BUFFER_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.BufferImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 31;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__SIZE = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__USAGE = VULKAN_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__PROPERTIES = VULKAN_BUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.SizedBuffer <em>Sized Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.SizedBuffer
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getSizedBuffer()
	 * @generated
	 */
	int SIZED_BUFFER = 32;

	/**
	 * The number of structural features of the '<em>Sized Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZED_BUFFER_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sized Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZED_BUFFER_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ImageImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 33;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = SIZED_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = SIZED_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.TextureImpl <em>Texture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.TextureImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getTexture()
	 * @generated
	 */
	int TEXTURE = 34;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__FILE = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__MIPMAP_ENABLED = VULKAN_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Texture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Texture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.DepthImageImpl <em>Depth Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.DepthImageImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getDepthImage()
	 * @generated
	 */
	int DEPTH_IMAGE = 35;

	/**
	 * The number of structural features of the '<em>Depth Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_IMAGE_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Depth Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_IMAGE_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.PathResourceImpl <em>Path Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.PathResourceImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getPathResource()
	 * @generated
	 */
	int PATH_RESOURCE = 36;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE__PATH = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Path Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.FileResourceImpl <em>File Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.FileResourceImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getFileResource()
	 * @generated
	 */
	int FILE_RESOURCE = 37;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE__PATH = PATH_RESOURCE__PATH;

	/**
	 * The number of structural features of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_FEATURE_COUNT = PATH_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_OPERATION_COUNT = PATH_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ModuleResourceImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getModuleResource()
	 * @generated
	 */
	int MODULE_RESOURCE = 38;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__PATH = PATH_RESOURCE__PATH;

	/**
	 * The feature id for the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__MODULE = PATH_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE_FEATURE_COUNT = PATH_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE_OPERATION_COUNT = PATH_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ShaderImpl <em>Shader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ShaderImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getShader()
	 * @generated
	 */
	int SHADER = 39;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__FILE = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__STAGE = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.PushConstantImpl <em>Push Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.PushConstantImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getPushConstant()
	 * @generated
	 */
	int PUSH_CONSTANT = 40;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT__SIZE = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT__STAGE = VULKAN_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Push Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Push Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.IndexedBufferImpl <em>Indexed Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.IndexedBufferImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIndexedBuffer()
	 * @generated
	 */
	int INDEXED_BUFFER = 41;

	/**
	 * The number of structural features of the '<em>Indexed Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_BUFFER_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Indexed Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_BUFFER_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.MeshBufferImpl <em>Mesh Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.MeshBufferImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getMeshBuffer()
	 * @generated
	 */
	int MESH_BUFFER = 42;

	/**
	 * The feature id for the '<em><b>Texture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_BUFFER__TEXTURE = INDEXED_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mesh Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_BUFFER_FEATURE_COUNT = INDEXED_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mesh Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_BUFFER_OPERATION_COUNT = INDEXED_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.UniformBufferImpl <em>Uniform Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.UniformBufferImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getUniformBuffer()
	 * @generated
	 */
	int UNIFORM_BUFFER = 43;

	/**
	 * The number of structural features of the '<em>Uniform Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_BUFFER_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Uniform Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_BUFFER_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.BoardBufferImpl <em>Board Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.BoardBufferImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getBoardBuffer()
	 * @generated
	 */
	int BOARD_BUFFER = 44;

	/**
	 * The number of structural features of the '<em>Board Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_BUFFER_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Board Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_BUFFER_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.BoardImageImpl <em>Board Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.BoardImageImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getBoardImage()
	 * @generated
	 */
	int BOARD_IMAGE = 45;

	/**
	 * The number of structural features of the '<em>Board Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_IMAGE_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Board Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_IMAGE_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>Java Module</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Module
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getJavaModule()
	 * @generated
	 */
	int JAVA_MODULE = 46;


	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.VulkanApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication
	 * @generated
	 */
	EClass getVulkanApplication();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#isEnabled()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#isFullscreen <em>Fullscreen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fullscreen</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#isFullscreen()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Fullscreen();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#isResizeable <em>Resizeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resizeable</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#isResizeable()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Resizeable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#isDebug <em>Debug</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#isDebug()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Debug();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getTitle()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getSize()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Size();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.VulkanApplication#getComputePools <em>Compute Pools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compute Pools</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getComputePools()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EReference getVulkanApplication_ComputePools();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.VulkanApplication#getGraphicPool <em>Graphic Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graphic Pool</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getGraphicPool()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EReference getVulkanApplication_GraphicPool();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sheepy.vulkan.model.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.GraphicConfiguration <em>Graphic Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphic Configuration</em>'.
	 * @see org.sheepy.vulkan.model.GraphicConfiguration
	 * @generated
	 */
	EClass getGraphicConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.GraphicConfiguration#isClearBeforeRender <em>Clear Before Render</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear Before Render</em>'.
	 * @see org.sheepy.vulkan.model.GraphicConfiguration#isClearBeforeRender()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_ClearBeforeRender();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.GraphicConfiguration#getPresentationMode <em>Presentation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Presentation Mode</em>'.
	 * @see org.sheepy.vulkan.model.GraphicConfiguration#getPresentationMode()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_PresentationMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.GraphicConfiguration#getSwapImageUsage <em>Swap Image Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Swap Image Usage</em>'.
	 * @see org.sheepy.vulkan.model.GraphicConfiguration#getSwapImageUsage()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_SwapImageUsage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.GraphicConfiguration#getFrameWaitStage <em>Frame Wait Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Wait Stage</em>'.
	 * @see org.sheepy.vulkan.model.GraphicConfiguration#getFrameWaitStage()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_FrameWaitStage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.GraphicConfiguration#getColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Color Domain</em>'.
	 * @see org.sheepy.vulkan.model.GraphicConfiguration#getColorDomain()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EReference getGraphicConfiguration_ColorDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.GraphicConfiguration#getRasterizerCullMode <em>Rasterizer Cull Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rasterizer Cull Mode</em>'.
	 * @see org.sheepy.vulkan.model.GraphicConfiguration#getRasterizerCullMode()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_RasterizerCullMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.GraphicConfiguration#getRasterizerFrontFace <em>Rasterizer Front Face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rasterizer Front Face</em>'.
	 * @see org.sheepy.vulkan.model.GraphicConfiguration#getRasterizerFrontFace()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_RasterizerFrontFace();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.RenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Pass Info</em>'.
	 * @see org.sheepy.vulkan.model.RenderPassInfo
	 * @generated
	 */
	EClass getRenderPassInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.RenderPassInfo#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachments</em>'.
	 * @see org.sheepy.vulkan.model.RenderPassInfo#getAttachments()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Attachments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.RenderPassInfo#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.sheepy.vulkan.model.RenderPassInfo#getDependencies()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.RenderPassInfo#getBindPoint <em>Bind Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bind Point</em>'.
	 * @see org.sheepy.vulkan.model.RenderPassInfo#getBindPoint()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EAttribute getRenderPassInfo_BindPoint();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.SubpassDependency <em>Subpass Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subpass Dependency</em>'.
	 * @see org.sheepy.vulkan.model.SubpassDependency
	 * @generated
	 */
	EClass getSubpassDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Subpass</em>'.
	 * @see org.sheepy.vulkan.model.SubpassDependency#getSrcSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcSubpass();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Subpass</em>'.
	 * @see org.sheepy.vulkan.model.SubpassDependency#getDstSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstSubpass();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.SubpassDependency#getSrcStageMask <em>Src Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Stage Mask</em>'.
	 * @see org.sheepy.vulkan.model.SubpassDependency#getSrcStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcStageMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.SubpassDependency#getDstStageMask <em>Dst Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Stage Mask</em>'.
	 * @see org.sheepy.vulkan.model.SubpassDependency#getDstStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstStageMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.SubpassDependency#getSrcAccessMask <em>Src Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.SubpassDependency#getSrcAccessMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcAccessMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.SubpassDependency#getDstAccessMask <em>Dst Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.SubpassDependency#getDstAccessMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstAccessMask();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.AttachmentDescription <em>Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachment Description</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription
	 * @generated
	 */
	EClass getAttachmentDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#isStencil <em>Stencil</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#isStencil()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_Stencil();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Samples</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#getSamples()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_Samples();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#getLoadOp <em>Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Op</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#getLoadOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_LoadOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#getStoreOp <em>Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Op</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#getStoreOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StoreOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#getStencilLoadOp <em>Stencil Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Load Op</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#getStencilLoadOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StencilLoadOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#getStencilStoreOp <em>Stencil Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Store Op</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#getStencilStoreOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StencilStoreOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#getInitialLayout <em>Initial Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Layout</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#getInitialLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_InitialLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#getFinalLayout <em>Final Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final Layout</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#getFinalLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_FinalLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AttachmentDescription#getRefLayout <em>Ref Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Layout</em>'.
	 * @see org.sheepy.vulkan.model.AttachmentDescription#getRefLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_RefLayout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Domain</em>'.
	 * @see org.sheepy.vulkan.model.ColorDomain
	 * @generated
	 */
	EClass getColorDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ColorDomain#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.sheepy.vulkan.model.ColorDomain#getFormat()
	 * @see #getColorDomain()
	 * @generated
	 */
	EAttribute getColorDomain_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ColorDomain#getColorSpace <em>Color Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Space</em>'.
	 * @see org.sheepy.vulkan.model.ColorDomain#getColorSpace()
	 * @see #getColorDomain()
	 * @generated
	 */
	EAttribute getColorDomain_ColorSpace();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.AbstractProcessPool <em>Abstract Process Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Process Pool</em>'.
	 * @see org.sheepy.vulkan.model.AbstractProcessPool
	 * @generated
	 */
	EClass getAbstractProcessPool();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.AbstractProcessPool#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see org.sheepy.vulkan.model.AbstractProcessPool#getProcesses()
	 * @see #getAbstractProcessPool()
	 * @generated
	 */
	EReference getAbstractProcessPool_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.AbstractProcessPool#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.sheepy.vulkan.model.AbstractProcessPool#getResources()
	 * @see #getAbstractProcessPool()
	 * @generated
	 */
	EReference getAbstractProcessPool_Resources();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.AbstractProcessPool#isResetAllowed <em>Reset Allowed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Allowed</em>'.
	 * @see org.sheepy.vulkan.model.AbstractProcessPool#isResetAllowed()
	 * @see #getAbstractProcessPool()
	 * @generated
	 */
	EAttribute getAbstractProcessPool_ResetAllowed();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ComputeProcessPool <em>Compute Process Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Process Pool</em>'.
	 * @see org.sheepy.vulkan.model.ComputeProcessPool
	 * @generated
	 */
	EClass getComputeProcessPool();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.GraphicProcessPool <em>Graphic Process Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphic Process Pool</em>'.
	 * @see org.sheepy.vulkan.model.GraphicProcessPool
	 * @generated
	 */
	EClass getGraphicProcessPool();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.GraphicProcessPool#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see org.sheepy.vulkan.model.GraphicProcessPool#getConfiguration()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.GraphicProcessPool#getRenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Render Pass Info</em>'.
	 * @see org.sheepy.vulkan.model.GraphicProcessPool#getRenderPassInfo()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_RenderPassInfo();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.GraphicProcessPool#getDepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depth Image</em>'.
	 * @see org.sheepy.vulkan.model.GraphicProcessPool#getDepthImage()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_DepthImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.AbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Process</em>'.
	 * @see org.sheepy.vulkan.model.AbstractProcess
	 * @generated
	 */
	EClass getAbstractProcess();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.AbstractProcess#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.sheepy.vulkan.model.AbstractProcess#getUnits()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_Units();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.GraphicProcess <em>Graphic Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphic Process</em>'.
	 * @see org.sheepy.vulkan.model.GraphicProcess
	 * @generated
	 */
	EClass getGraphicProcess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ComputeProcess <em>Compute Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Process</em>'.
	 * @see org.sheepy.vulkan.model.ComputeProcess
	 * @generated
	 */
	EClass getComputeProcess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.IProcessUnit <em>IProcess Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProcess Unit</em>'.
	 * @see org.sheepy.vulkan.model.IProcessUnit
	 * @generated
	 */
	EClass getIProcessUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.IProcessUnit#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.vulkan.model.IProcessUnit#isEnabled()
	 * @see #getIProcessUnit()
	 * @generated
	 */
	EAttribute getIProcessUnit_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.IProcessUnit#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.vulkan.model.IProcessUnit#getStage()
	 * @see #getIProcessUnit()
	 * @generated
	 */
	EAttribute getIProcessUnit_Stage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.PipelineBarrier <em>Pipeline Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline Barrier</em>'.
	 * @see org.sheepy.vulkan.model.PipelineBarrier
	 * @generated
	 */
	EClass getPipelineBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.PipelineBarrier#getSrcStage <em>Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Stage</em>'.
	 * @see org.sheepy.vulkan.model.PipelineBarrier#getSrcStage()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EAttribute getPipelineBarrier_SrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.PipelineBarrier#getDstStage <em>Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Stage</em>'.
	 * @see org.sheepy.vulkan.model.PipelineBarrier#getDstStage()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EAttribute getPipelineBarrier_DstStage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.BufferBarrier <em>Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Barrier</em>'.
	 * @see org.sheepy.vulkan.model.BufferBarrier
	 * @generated
	 */
	EClass getBufferBarrier();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.BufferBarrier#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.vulkan.model.BufferBarrier#getBuffer()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EReference getBufferBarrier_Buffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.BufferBarrier#getSrcAccess <em>Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access</em>'.
	 * @see org.sheepy.vulkan.model.BufferBarrier#getSrcAccess()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EAttribute getBufferBarrier_SrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.BufferBarrier#getDstAccess <em>Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access</em>'.
	 * @see org.sheepy.vulkan.model.BufferBarrier#getDstAccess()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EAttribute getBufferBarrier_DstAccess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.AbstractImageBarrier <em>Abstract Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.AbstractImageBarrier
	 * @generated
	 */
	EClass getAbstractImageBarrier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.AbstractImageBarrier#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.sheepy.vulkan.model.AbstractImageBarrier#getTransitions()
	 * @see #getAbstractImageBarrier()
	 * @generated
	 */
	EReference getAbstractImageBarrier_Transitions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ImageBarrier <em>Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.ImageBarrier
	 * @generated
	 */
	EClass getImageBarrier();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.ImageBarrier#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.vulkan.model.ImageBarrier#getImage()
	 * @see #getImageBarrier()
	 * @generated
	 */
	EReference getImageBarrier_Image();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ReferenceImageBarrier <em>Reference Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.ReferenceImageBarrier
	 * @generated
	 */
	EClass getReferenceImageBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see org.sheepy.vulkan.model.ReferenceImageBarrier#getImageId()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getMipLevels <em>Mip Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mip Levels</em>'.
	 * @see org.sheepy.vulkan.model.ReferenceImageBarrier#getMipLevels()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_MipLevels();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getImageFormat <em>Image Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Format</em>'.
	 * @see org.sheepy.vulkan.model.ReferenceImageBarrier#getImageFormat()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_ImageFormat();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ImageTransition <em>Image Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Transition</em>'.
	 * @see org.sheepy.vulkan.model.ImageTransition
	 * @generated
	 */
	EClass getImageTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ImageTransition#getSrcLayout <em>Src Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Layout</em>'.
	 * @see org.sheepy.vulkan.model.ImageTransition#getSrcLayout()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_SrcLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ImageTransition#getDstLayout <em>Dst Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Layout</em>'.
	 * @see org.sheepy.vulkan.model.ImageTransition#getDstLayout()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_DstLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ImageTransition#getSrcAccess <em>Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access</em>'.
	 * @see org.sheepy.vulkan.model.ImageTransition#getSrcAccess()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_SrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ImageTransition#getDstAccess <em>Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access</em>'.
	 * @see org.sheepy.vulkan.model.ImageTransition#getDstAccess()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_DstAccess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.IDescriptor <em>IDescriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDescriptor</em>'.
	 * @see org.sheepy.vulkan.model.IDescriptor
	 * @generated
	 */
	EClass getIDescriptor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.DescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Set</em>'.
	 * @see org.sheepy.vulkan.model.DescriptorSet
	 * @generated
	 */
	EClass getDescriptorSet();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.vulkan.model.DescriptorSet#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors</em>'.
	 * @see org.sheepy.vulkan.model.DescriptorSet#getDescriptors()
	 * @see #getDescriptorSet()
	 * @generated
	 */
	EReference getDescriptorSet_Descriptors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.AbstractPipeline <em>Abstract Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.AbstractPipeline
	 * @generated
	 */
	EClass getAbstractPipeline();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.AbstractPipeline#getDescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor Set</em>'.
	 * @see org.sheepy.vulkan.model.AbstractPipeline#getDescriptorSet()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_DescriptorSet();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.AbstractPipeline#getPushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Push Constant</em>'.
	 * @see org.sheepy.vulkan.model.AbstractPipeline#getPushConstant()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_PushConstant();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.AbstractCompositePipeline <em>Abstract Composite Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Composite Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.AbstractCompositePipeline
	 * @generated
	 */
	EClass getAbstractCompositePipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.AbstractCompositePipeline#getPipelines <em>Pipelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pipelines</em>'.
	 * @see org.sheepy.vulkan.model.AbstractCompositePipeline#getPipelines()
	 * @see #getAbstractCompositePipeline()
	 * @generated
	 */
	EReference getAbstractCompositePipeline_Pipelines();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.GraphicsPipeline <em>Graphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphics Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.GraphicsPipeline
	 * @generated
	 */
	EClass getGraphicsPipeline();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.vulkan.model.GraphicsPipeline#getShaders <em>Shaders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shaders</em>'.
	 * @see org.sheepy.vulkan.model.GraphicsPipeline#getShaders()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_Shaders();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ComputePipeline <em>Compute Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.ComputePipeline
	 * @generated
	 */
	EClass getComputePipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.ComputePipeline#getComputers <em>Computers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computers</em>'.
	 * @see org.sheepy.vulkan.model.ComputePipeline#getComputers()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EReference getComputePipeline_Computers();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ComputePipeline#getWorkgroupSizeX <em>Workgroup Size X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size X</em>'.
	 * @see org.sheepy.vulkan.model.ComputePipeline#getWorkgroupSizeX()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeX();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ComputePipeline#getWorkgroupSizeY <em>Workgroup Size Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size Y</em>'.
	 * @see org.sheepy.vulkan.model.ComputePipeline#getWorkgroupSizeY()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeY();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ComputePipeline#getWorkgroupSizeZ <em>Workgroup Size Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size Z</em>'.
	 * @see org.sheepy.vulkan.model.ComputePipeline#getWorkgroupSizeZ()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeZ();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ComputePipeline#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.vulkan.model.ComputePipeline#getWidth()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ComputePipeline#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.vulkan.model.ComputePipeline#getHeight()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ComputePipeline#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see org.sheepy.vulkan.model.ComputePipeline#getDepth()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Depth();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.Computer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computer</em>'.
	 * @see org.sheepy.vulkan.model.Computer
	 * @generated
	 */
	EClass getComputer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.Computer#getShader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shader</em>'.
	 * @see org.sheepy.vulkan.model.Computer#getShader()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Shader();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ImagePipeline <em>Image Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.ImagePipeline
	 * @generated
	 */
	EClass getImagePipeline();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.ImagePipeline#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.vulkan.model.ImagePipeline#getImage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EReference getImagePipeline_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Src Stage</em>'.
	 * @see org.sheepy.vulkan.model.ImagePipeline#getImageSrcStage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Dst Stage</em>'.
	 * @see org.sheepy.vulkan.model.ImagePipeline#getImageDstStage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ImagePipeline#getImageSrcAccess <em>Image Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Src Access</em>'.
	 * @see org.sheepy.vulkan.model.ImagePipeline#getImageSrcAccess()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ImagePipeline#getImageDstAccess <em>Image Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Dst Access</em>'.
	 * @see org.sheepy.vulkan.model.ImagePipeline#getImageDstAccess()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstAccess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.MeshPipeline <em>Mesh Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.MeshPipeline
	 * @generated
	 */
	EClass getMeshPipeline();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.MeshPipeline#getMesh <em>Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mesh</em>'.
	 * @see org.sheepy.vulkan.model.MeshPipeline#getMesh()
	 * @see #getMeshPipeline()
	 * @generated
	 */
	EReference getMeshPipeline_Mesh();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.sheepy.vulkan.model.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.VulkanBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.sheepy.vulkan.model.VulkanBuffer
	 * @generated
	 */
	EClass getVulkanBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.sheepy.vulkan.model.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.Buffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.vulkan.model.Buffer#getSize()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.Buffer#getUsage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage</em>'.
	 * @see org.sheepy.vulkan.model.Buffer#getUsage()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Usage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.Buffer#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties</em>'.
	 * @see org.sheepy.vulkan.model.Buffer#getProperties()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Properties();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.SizedBuffer <em>Sized Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sized Buffer</em>'.
	 * @see org.sheepy.vulkan.model.SizedBuffer
	 * @generated
	 */
	EClass getSizedBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.sheepy.vulkan.model.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.Texture <em>Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Texture</em>'.
	 * @see org.sheepy.vulkan.model.Texture
	 * @generated
	 */
	EClass getTexture();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.Texture#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.vulkan.model.Texture#getFile()
	 * @see #getTexture()
	 * @generated
	 */
	EReference getTexture_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.Texture#isMipmapEnabled <em>Mipmap Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mipmap Enabled</em>'.
	 * @see org.sheepy.vulkan.model.Texture#isMipmapEnabled()
	 * @see #getTexture()
	 * @generated
	 */
	EAttribute getTexture_MipmapEnabled();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.DepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depth Image</em>'.
	 * @see org.sheepy.vulkan.model.DepthImage
	 * @generated
	 */
	EClass getDepthImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.PathResource <em>Path Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Resource</em>'.
	 * @see org.sheepy.vulkan.model.PathResource
	 * @generated
	 */
	EClass getPathResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.PathResource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.sheepy.vulkan.model.PathResource#getPath()
	 * @see #getPathResource()
	 * @generated
	 */
	EAttribute getPathResource_Path();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Resource</em>'.
	 * @see org.sheepy.vulkan.model.FileResource
	 * @generated
	 */
	EClass getFileResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ModuleResource <em>Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Resource</em>'.
	 * @see org.sheepy.vulkan.model.ModuleResource
	 * @generated
	 */
	EClass getModuleResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ModuleResource#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module</em>'.
	 * @see org.sheepy.vulkan.model.ModuleResource#getModule()
	 * @see #getModuleResource()
	 * @generated
	 */
	EAttribute getModuleResource_Module();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.Shader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shader</em>'.
	 * @see org.sheepy.vulkan.model.Shader
	 * @generated
	 */
	EClass getShader();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.Shader#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.vulkan.model.Shader#getFile()
	 * @see #getShader()
	 * @generated
	 */
	EReference getShader_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.Shader#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.vulkan.model.Shader#getStage()
	 * @see #getShader()
	 * @generated
	 */
	EAttribute getShader_Stage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.PushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Constant</em>'.
	 * @see org.sheepy.vulkan.model.PushConstant
	 * @generated
	 */
	EClass getPushConstant();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.PushConstant#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.vulkan.model.PushConstant#getSize()
	 * @see #getPushConstant()
	 * @generated
	 */
	EAttribute getPushConstant_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.PushConstant#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.vulkan.model.PushConstant#getStage()
	 * @see #getPushConstant()
	 * @generated
	 */
	EAttribute getPushConstant_Stage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.IndexedBuffer <em>Indexed Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indexed Buffer</em>'.
	 * @see org.sheepy.vulkan.model.IndexedBuffer
	 * @generated
	 */
	EClass getIndexedBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.MeshBuffer <em>Mesh Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Buffer</em>'.
	 * @see org.sheepy.vulkan.model.MeshBuffer
	 * @generated
	 */
	EClass getMeshBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.MeshBuffer#getTexture <em>Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Texture</em>'.
	 * @see org.sheepy.vulkan.model.MeshBuffer#getTexture()
	 * @see #getMeshBuffer()
	 * @generated
	 */
	EReference getMeshBuffer_Texture();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.UniformBuffer <em>Uniform Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uniform Buffer</em>'.
	 * @see org.sheepy.vulkan.model.UniformBuffer
	 * @generated
	 */
	EClass getUniformBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.BoardBuffer <em>Board Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Board Buffer</em>'.
	 * @see org.sheepy.vulkan.model.BoardBuffer
	 * @generated
	 */
	EClass getBoardBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.BoardImage <em>Board Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Board Image</em>'.
	 * @see org.sheepy.vulkan.model.BoardImage
	 * @generated
	 */
	EClass getBoardImage();

	/**
	 * Returns the meta object for data type '{@link java.lang.Module <em>Java Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Module</em>'.
	 * @see java.lang.Module
	 * @model instanceClass="java.lang.Module"
	 * @generated
	 */
	EDataType getJavaModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VulkanFactory getVulkanFactory();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.VulkanApplicationImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getVulkanApplication()
		 * @generated
		 */
		EClass VULKAN_APPLICATION = eINSTANCE.getVulkanApplication();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__ENABLED = eINSTANCE.getVulkanApplication_Enabled();

		/**
		 * The meta object literal for the '<em><b>Fullscreen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__FULLSCREEN = eINSTANCE.getVulkanApplication_Fullscreen();

		/**
		 * The meta object literal for the '<em><b>Resizeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__RESIZEABLE = eINSTANCE.getVulkanApplication_Resizeable();

		/**
		 * The meta object literal for the '<em><b>Debug</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__DEBUG = eINSTANCE.getVulkanApplication_Debug();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__TITLE = eINSTANCE.getVulkanApplication_Title();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__SIZE = eINSTANCE.getVulkanApplication_Size();

		/**
		 * The meta object literal for the '<em><b>Compute Pools</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_APPLICATION__COMPUTE_POOLS = eINSTANCE.getVulkanApplication_ComputePools();

		/**
		 * The meta object literal for the '<em><b>Graphic Pool</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_APPLICATION__GRAPHIC_POOL = eINSTANCE.getVulkanApplication_GraphicPool();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.Configuration <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.Configuration
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.GraphicConfigurationImpl <em>Graphic Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.GraphicConfigurationImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getGraphicConfiguration()
		 * @generated
		 */
		EClass GRAPHIC_CONFIGURATION = eINSTANCE.getGraphicConfiguration();

		/**
		 * The meta object literal for the '<em><b>Clear Before Render</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER = eINSTANCE.getGraphicConfiguration_ClearBeforeRender();

		/**
		 * The meta object literal for the '<em><b>Presentation Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__PRESENTATION_MODE = eINSTANCE.getGraphicConfiguration_PresentationMode();

		/**
		 * The meta object literal for the '<em><b>Swap Image Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE = eINSTANCE.getGraphicConfiguration_SwapImageUsage();

		/**
		 * The meta object literal for the '<em><b>Frame Wait Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE = eINSTANCE.getGraphicConfiguration_FrameWaitStage();

		/**
		 * The meta object literal for the '<em><b>Color Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CONFIGURATION__COLOR_DOMAIN = eINSTANCE.getGraphicConfiguration_ColorDomain();

		/**
		 * The meta object literal for the '<em><b>Rasterizer Cull Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE = eINSTANCE.getGraphicConfiguration_RasterizerCullMode();

		/**
		 * The meta object literal for the '<em><b>Rasterizer Front Face</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE = eINSTANCE.getGraphicConfiguration_RasterizerFrontFace();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.RenderPassInfoImpl <em>Render Pass Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.RenderPassInfoImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getRenderPassInfo()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.SubpassDependencyImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getSubpassDependency()
		 * @generated
		 */
		EClass SUBPASS_DEPENDENCY = eINSTANCE.getSubpassDependency();

		/**
		 * The meta object literal for the '<em><b>Src Subpass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__SRC_SUBPASS = eINSTANCE.getSubpassDependency_SrcSubpass();

		/**
		 * The meta object literal for the '<em><b>Dst Subpass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__DST_SUBPASS = eINSTANCE.getSubpassDependency_DstSubpass();

		/**
		 * The meta object literal for the '<em><b>Src Stage Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__SRC_STAGE_MASK = eINSTANCE.getSubpassDependency_SrcStageMask();

		/**
		 * The meta object literal for the '<em><b>Dst Stage Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__DST_STAGE_MASK = eINSTANCE.getSubpassDependency_DstStageMask();

		/**
		 * The meta object literal for the '<em><b>Src Access Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__SRC_ACCESS_MASK = eINSTANCE.getSubpassDependency_SrcAccessMask();

		/**
		 * The meta object literal for the '<em><b>Dst Access Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__DST_ACCESS_MASK = eINSTANCE.getSubpassDependency_DstAccessMask();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.AttachmentDescriptionImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAttachmentDescription()
		 * @generated
		 */
		EClass ATTACHMENT_DESCRIPTION = eINSTANCE.getAttachmentDescription();

		/**
		 * The meta object literal for the '<em><b>Stencil</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__STENCIL = eINSTANCE.getAttachmentDescription_Stencil();

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
		EAttribute ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP = eINSTANCE.getAttachmentDescription_StencilLoadOp();

		/**
		 * The meta object literal for the '<em><b>Stencil Store Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP = eINSTANCE.getAttachmentDescription_StencilStoreOp();

		/**
		 * The meta object literal for the '<em><b>Initial Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT = eINSTANCE.getAttachmentDescription_InitialLayout();

		/**
		 * The meta object literal for the '<em><b>Final Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__FINAL_LAYOUT = eINSTANCE.getAttachmentDescription_FinalLayout();

		/**
		 * The meta object literal for the '<em><b>Ref Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__REF_LAYOUT = eINSTANCE.getAttachmentDescription_RefLayout();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ColorDomainImpl <em>Color Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ColorDomainImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getColorDomain()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.AbstractProcessPoolImpl <em>Abstract Process Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.AbstractProcessPoolImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractProcessPool()
		 * @generated
		 */
		EClass ABSTRACT_PROCESS_POOL = eINSTANCE.getAbstractProcessPool();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS_POOL__PROCESSES = eINSTANCE.getAbstractProcessPool_Processes();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS_POOL__RESOURCES = eINSTANCE.getAbstractProcessPool_Resources();

		/**
		 * The meta object literal for the '<em><b>Reset Allowed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PROCESS_POOL__RESET_ALLOWED = eINSTANCE.getAbstractProcessPool_ResetAllowed();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ComputeProcessPoolImpl <em>Compute Process Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ComputeProcessPoolImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getComputeProcessPool()
		 * @generated
		 */
		EClass COMPUTE_PROCESS_POOL = eINSTANCE.getComputeProcessPool();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.GraphicProcessPoolImpl <em>Graphic Process Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.GraphicProcessPoolImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getGraphicProcessPool()
		 * @generated
		 */
		EClass GRAPHIC_PROCESS_POOL = eINSTANCE.getGraphicProcessPool();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_PROCESS_POOL__CONFIGURATION = eINSTANCE.getGraphicProcessPool_Configuration();

		/**
		 * The meta object literal for the '<em><b>Render Pass Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO = eINSTANCE.getGraphicProcessPool_RenderPassInfo();

		/**
		 * The meta object literal for the '<em><b>Depth Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_PROCESS_POOL__DEPTH_IMAGE = eINSTANCE.getGraphicProcessPool_DepthImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.AbstractProcessImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractProcess()
		 * @generated
		 */
		EClass ABSTRACT_PROCESS = eINSTANCE.getAbstractProcess();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__UNITS = eINSTANCE.getAbstractProcess_Units();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.GraphicProcessImpl <em>Graphic Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.GraphicProcessImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getGraphicProcess()
		 * @generated
		 */
		EClass GRAPHIC_PROCESS = eINSTANCE.getGraphicProcess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ComputeProcessImpl <em>Compute Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ComputeProcessImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getComputeProcess()
		 * @generated
		 */
		EClass COMPUTE_PROCESS = eINSTANCE.getComputeProcess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.IProcessUnit <em>IProcess Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.IProcessUnit
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIProcessUnit()
		 * @generated
		 */
		EClass IPROCESS_UNIT = eINSTANCE.getIProcessUnit();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROCESS_UNIT__ENABLED = eINSTANCE.getIProcessUnit_Enabled();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROCESS_UNIT__STAGE = eINSTANCE.getIProcessUnit_Stage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.PipelineBarrierImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getPipelineBarrier()
		 * @generated
		 */
		EClass PIPELINE_BARRIER = eINSTANCE.getPipelineBarrier();

		/**
		 * The meta object literal for the '<em><b>Src Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPELINE_BARRIER__SRC_STAGE = eINSTANCE.getPipelineBarrier_SrcStage();

		/**
		 * The meta object literal for the '<em><b>Dst Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIPELINE_BARRIER__DST_STAGE = eINSTANCE.getPipelineBarrier_DstStage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.BufferBarrierImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getBufferBarrier()
		 * @generated
		 */
		EClass BUFFER_BARRIER = eINSTANCE.getBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_BARRIER__BUFFER = eINSTANCE.getBufferBarrier_Buffer();

		/**
		 * The meta object literal for the '<em><b>Src Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_BARRIER__SRC_ACCESS = eINSTANCE.getBufferBarrier_SrcAccess();

		/**
		 * The meta object literal for the '<em><b>Dst Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_BARRIER__DST_ACCESS = eINSTANCE.getBufferBarrier_DstAccess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.AbstractImageBarrierImpl <em>Abstract Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.AbstractImageBarrierImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractImageBarrier()
		 * @generated
		 */
		EClass ABSTRACT_IMAGE_BARRIER = eINSTANCE.getAbstractImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_IMAGE_BARRIER__TRANSITIONS = eINSTANCE.getAbstractImageBarrier_Transitions();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ImageBarrierImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getImageBarrier()
		 * @generated
		 */
		EClass IMAGE_BARRIER = eINSTANCE.getImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_BARRIER__IMAGE = eINSTANCE.getImageBarrier_Image();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ReferenceImageBarrierImpl <em>Reference Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ReferenceImageBarrierImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getReferenceImageBarrier()
		 * @generated
		 */
		EClass REFERENCE_IMAGE_BARRIER = eINSTANCE.getReferenceImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__IMAGE_ID = eINSTANCE.getReferenceImageBarrier_ImageId();

		/**
		 * The meta object literal for the '<em><b>Mip Levels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__MIP_LEVELS = eINSTANCE.getReferenceImageBarrier_MipLevels();

		/**
		 * The meta object literal for the '<em><b>Image Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT = eINSTANCE.getReferenceImageBarrier_ImageFormat();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ImageTransitionImpl <em>Image Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ImageTransitionImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getImageTransition()
		 * @generated
		 */
		EClass IMAGE_TRANSITION = eINSTANCE.getImageTransition();

		/**
		 * The meta object literal for the '<em><b>Src Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__SRC_LAYOUT = eINSTANCE.getImageTransition_SrcLayout();

		/**
		 * The meta object literal for the '<em><b>Dst Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__DST_LAYOUT = eINSTANCE.getImageTransition_DstLayout();

		/**
		 * The meta object literal for the '<em><b>Src Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__SRC_ACCESS = eINSTANCE.getImageTransition_SrcAccess();

		/**
		 * The meta object literal for the '<em><b>Dst Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__DST_ACCESS = eINSTANCE.getImageTransition_DstAccess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.IDescriptor <em>IDescriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.IDescriptor
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIDescriptor()
		 * @generated
		 */
		EClass IDESCRIPTOR = eINSTANCE.getIDescriptor();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.DescriptorSetImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getDescriptorSet()
		 * @generated
		 */
		EClass DESCRIPTOR_SET = eINSTANCE.getDescriptorSet();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTOR_SET__DESCRIPTORS = eINSTANCE.getDescriptorSet_Descriptors();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.AbstractPipelineImpl <em>Abstract Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.AbstractPipelineImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractPipeline()
		 * @generated
		 */
		EClass ABSTRACT_PIPELINE = eINSTANCE.getAbstractPipeline();

		/**
		 * The meta object literal for the '<em><b>Descriptor Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PIPELINE__DESCRIPTOR_SET = eINSTANCE.getAbstractPipeline_DescriptorSet();

		/**
		 * The meta object literal for the '<em><b>Push Constant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PIPELINE__PUSH_CONSTANT = eINSTANCE.getAbstractPipeline_PushConstant();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.AbstractCompositePipelineImpl <em>Abstract Composite Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.AbstractCompositePipelineImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getAbstractCompositePipeline()
		 * @generated
		 */
		EClass ABSTRACT_COMPOSITE_PIPELINE = eINSTANCE.getAbstractCompositePipeline();

		/**
		 * The meta object literal for the '<em><b>Pipelines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_COMPOSITE_PIPELINE__PIPELINES = eINSTANCE.getAbstractCompositePipeline_Pipelines();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.GraphicsPipelineImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getGraphicsPipeline()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ComputePipelineImpl <em>Compute Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ComputePipelineImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getComputePipeline()
		 * @generated
		 */
		EClass COMPUTE_PIPELINE = eINSTANCE.getComputePipeline();

		/**
		 * The meta object literal for the '<em><b>Computers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_PIPELINE__COMPUTERS = eINSTANCE.getComputePipeline_Computers();

		/**
		 * The meta object literal for the '<em><b>Workgroup Size X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTE_PIPELINE__WORKGROUP_SIZE_X = eINSTANCE.getComputePipeline_WorkgroupSizeX();

		/**
		 * The meta object literal for the '<em><b>Workgroup Size Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTE_PIPELINE__WORKGROUP_SIZE_Y = eINSTANCE.getComputePipeline_WorkgroupSizeY();

		/**
		 * The meta object literal for the '<em><b>Workgroup Size Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTE_PIPELINE__WORKGROUP_SIZE_Z = eINSTANCE.getComputePipeline_WorkgroupSizeZ();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTE_PIPELINE__WIDTH = eINSTANCE.getComputePipeline_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTE_PIPELINE__HEIGHT = eINSTANCE.getComputePipeline_Height();

		/**
		 * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTE_PIPELINE__DEPTH = eINSTANCE.getComputePipeline_Depth();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ComputerImpl <em>Computer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ComputerImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getComputer()
		 * @generated
		 */
		EClass COMPUTER = eINSTANCE.getComputer();

		/**
		 * The meta object literal for the '<em><b>Shader</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__SHADER = eINSTANCE.getComputer_Shader();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ImagePipelineImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getImagePipeline()
		 * @generated
		 */
		EClass IMAGE_PIPELINE = eINSTANCE.getImagePipeline();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_PIPELINE__IMAGE = eINSTANCE.getImagePipeline_Image();

		/**
		 * The meta object literal for the '<em><b>Image Src Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_SRC_STAGE = eINSTANCE.getImagePipeline_ImageSrcStage();

		/**
		 * The meta object literal for the '<em><b>Image Dst Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_DST_STAGE = eINSTANCE.getImagePipeline_ImageDstStage();

		/**
		 * The meta object literal for the '<em><b>Image Src Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_SRC_ACCESS = eINSTANCE.getImagePipeline_ImageSrcAccess();

		/**
		 * The meta object literal for the '<em><b>Image Dst Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_DST_ACCESS = eINSTANCE.getImagePipeline_ImageDstAccess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.MeshPipelineImpl <em>Mesh Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.MeshPipelineImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getMeshPipeline()
		 * @generated
		 */
		EClass MESH_PIPELINE = eINSTANCE.getMeshPipeline();

		/**
		 * The meta object literal for the '<em><b>Mesh</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESH_PIPELINE__MESH = eINSTANCE.getMeshPipeline_Mesh();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.Resource <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.Resource
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.VulkanBuffer <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.VulkanBuffer
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getVulkanBuffer()
		 * @generated
		 */
		EClass VULKAN_BUFFER = eINSTANCE.getVulkanBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.BufferImpl <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.BufferImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getBuffer()
		 * @generated
		 */
		EClass BUFFER = eINSTANCE.getBuffer();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__SIZE = eINSTANCE.getBuffer_Size();

		/**
		 * The meta object literal for the '<em><b>Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__USAGE = eINSTANCE.getBuffer_Usage();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__PROPERTIES = eINSTANCE.getBuffer_Properties();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.SizedBuffer <em>Sized Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.SizedBuffer
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getSizedBuffer()
		 * @generated
		 */
		EClass SIZED_BUFFER = eINSTANCE.getSizedBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ImageImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.TextureImpl <em>Texture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.TextureImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getTexture()
		 * @generated
		 */
		EClass TEXTURE = eINSTANCE.getTexture();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTURE__FILE = eINSTANCE.getTexture_File();

		/**
		 * The meta object literal for the '<em><b>Mipmap Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTURE__MIPMAP_ENABLED = eINSTANCE.getTexture_MipmapEnabled();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.DepthImageImpl <em>Depth Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.DepthImageImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getDepthImage()
		 * @generated
		 */
		EClass DEPTH_IMAGE = eINSTANCE.getDepthImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.PathResourceImpl <em>Path Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.PathResourceImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getPathResource()
		 * @generated
		 */
		EClass PATH_RESOURCE = eINSTANCE.getPathResource();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_RESOURCE__PATH = eINSTANCE.getPathResource_Path();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.FileResourceImpl <em>File Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.FileResourceImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getFileResource()
		 * @generated
		 */
		EClass FILE_RESOURCE = eINSTANCE.getFileResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ModuleResourceImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getModuleResource()
		 * @generated
		 */
		EClass MODULE_RESOURCE = eINSTANCE.getModuleResource();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_RESOURCE__MODULE = eINSTANCE.getModuleResource_Module();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ShaderImpl <em>Shader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ShaderImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getShader()
		 * @generated
		 */
		EClass SHADER = eINSTANCE.getShader();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADER__FILE = eINSTANCE.getShader_File();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHADER__STAGE = eINSTANCE.getShader_Stage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.PushConstantImpl <em>Push Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.PushConstantImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getPushConstant()
		 * @generated
		 */
		EClass PUSH_CONSTANT = eINSTANCE.getPushConstant();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_CONSTANT__SIZE = eINSTANCE.getPushConstant_Size();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_CONSTANT__STAGE = eINSTANCE.getPushConstant_Stage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.IndexedBufferImpl <em>Indexed Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.IndexedBufferImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIndexedBuffer()
		 * @generated
		 */
		EClass INDEXED_BUFFER = eINSTANCE.getIndexedBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.MeshBufferImpl <em>Mesh Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.MeshBufferImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getMeshBuffer()
		 * @generated
		 */
		EClass MESH_BUFFER = eINSTANCE.getMeshBuffer();

		/**
		 * The meta object literal for the '<em><b>Texture</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESH_BUFFER__TEXTURE = eINSTANCE.getMeshBuffer_Texture();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.UniformBufferImpl <em>Uniform Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.UniformBufferImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getUniformBuffer()
		 * @generated
		 */
		EClass UNIFORM_BUFFER = eINSTANCE.getUniformBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.BoardBufferImpl <em>Board Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.BoardBufferImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getBoardBuffer()
		 * @generated
		 */
		EClass BOARD_BUFFER = eINSTANCE.getBoardBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.BoardImageImpl <em>Board Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.BoardImageImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getBoardImage()
		 * @generated
		 */
		EClass BOARD_IMAGE = eINSTANCE.getBoardImage();

		/**
		 * The meta object literal for the '<em>Java Module</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Module
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getJavaModule()
		 * @generated
		 */
		EDataType JAVA_MODULE = eINSTANCE.getJavaModule();

	}

} //VulkanPackage
