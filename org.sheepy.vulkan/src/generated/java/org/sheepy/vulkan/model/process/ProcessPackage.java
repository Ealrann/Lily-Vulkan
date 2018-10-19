/**
 */
package org.sheepy.vulkan.model.process;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.sheepy.vulkan.model.process.ProcessFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/java' publicConstructors='true' basePackage='org.sheepy.vulkan.model'"
 * @generated
 */
public interface ProcessPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "process";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.model.process";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "process";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcessPackage eINSTANCE = org.sheepy.vulkan.model.process.impl.ProcessPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.Configuration <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.Configuration
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl <em>Graphic Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getGraphicConfiguration()
	 * @generated
	 */
	int GRAPHIC_CONFIGURATION = 1;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.RenderPassInfoImpl <em>Render Pass Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.RenderPassInfoImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getRenderPassInfo()
	 * @generated
	 */
	int RENDER_PASS_INFO = 2;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.SubpassDependencyImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getSubpassDependency()
	 * @generated
	 */
	int SUBPASS_DEPENDENCY = 3;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AttachmentDescriptionImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAttachmentDescription()
	 * @generated
	 */
	int ATTACHMENT_DESCRIPTION = 4;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ColorDomainImpl <em>Color Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ColorDomainImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getColorDomain()
	 * @generated
	 */
	int COLOR_DOMAIN = 5;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl <em>Abstract Process Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractProcessPool()
	 * @generated
	 */
	int ABSTRACT_PROCESS_POOL = 6;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ComputeProcessPoolImpl <em>Compute Process Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ComputeProcessPoolImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getComputeProcessPool()
	 * @generated
	 */
	int COMPUTE_PROCESS_POOL = 7;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.GraphicProcessPoolImpl <em>Graphic Process Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.GraphicProcessPoolImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getGraphicProcessPool()
	 * @generated
	 */
	int GRAPHIC_PROCESS_POOL = 8;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AbstractProcessImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractProcess()
	 * @generated
	 */
	int ABSTRACT_PROCESS = 9;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.GraphicProcessImpl <em>Graphic Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.GraphicProcessImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getGraphicProcess()
	 * @generated
	 */
	int GRAPHIC_PROCESS = 10;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ComputeProcessImpl <em>Compute Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ComputeProcessImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getComputeProcess()
	 * @generated
	 */
	int COMPUTE_PROCESS = 11;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.IProcessUnit <em>IProcess Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.IProcessUnit
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getIProcessUnit()
	 * @generated
	 */
	int IPROCESS_UNIT = 12;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBarrier()
	 * @generated
	 */
	int PIPELINE_BARRIER = 13;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.BufferBarrierImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getBufferBarrier()
	 * @generated
	 */
	int BUFFER_BARRIER = 14;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AbstractImageBarrierImpl <em>Abstract Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AbstractImageBarrierImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractImageBarrier()
	 * @generated
	 */
	int ABSTRACT_IMAGE_BARRIER = 15;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ImageBarrierImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getImageBarrier()
	 * @generated
	 */
	int IMAGE_BARRIER = 16;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ReferenceImageBarrierImpl <em>Reference Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ReferenceImageBarrierImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getReferenceImageBarrier()
	 * @generated
	 */
	int REFERENCE_IMAGE_BARRIER = 17;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ImageTransitionImpl <em>Image Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ImageTransitionImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getImageTransition()
	 * @generated
	 */
	int IMAGE_TRANSITION = 18;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl <em>Abstract Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractPipeline()
	 * @generated
	 */
	int ABSTRACT_PIPELINE = 19;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AbstractCompositePipelineImpl <em>Abstract Composite Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AbstractCompositePipelineImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractCompositePipeline()
	 * @generated
	 */
	int ABSTRACT_COMPOSITE_PIPELINE = 20;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.GraphicsPipelineImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getGraphicsPipeline()
	 * @generated
	 */
	int GRAPHICS_PIPELINE = 21;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl <em>Compute Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ComputePipelineImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getComputePipeline()
	 * @generated
	 */
	int COMPUTE_PIPELINE = 22;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ComputerImpl <em>Computer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ComputerImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getComputer()
	 * @generated
	 */
	int COMPUTER = 23;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.ImagePipelineImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getImagePipeline()
	 * @generated
	 */
	int IMAGE_PIPELINE = 24;

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
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sheepy.vulkan.model.process.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.GraphicConfiguration <em>Graphic Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphic Configuration</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicConfiguration
	 * @generated
	 */
	EClass getGraphicConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#isClearBeforeRender <em>Clear Before Render</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear Before Render</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicConfiguration#isClearBeforeRender()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_ClearBeforeRender();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getPresentationMode <em>Presentation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Presentation Mode</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicConfiguration#getPresentationMode()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_PresentationMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getSwapImageUsage <em>Swap Image Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Swap Image Usage</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicConfiguration#getSwapImageUsage()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_SwapImageUsage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getFrameWaitStage <em>Frame Wait Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Wait Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicConfiguration#getFrameWaitStage()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_FrameWaitStage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Color Domain</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicConfiguration#getColorDomain()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EReference getGraphicConfiguration_ColorDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getRasterizerCullMode <em>Rasterizer Cull Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rasterizer Cull Mode</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicConfiguration#getRasterizerCullMode()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_RasterizerCullMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.GraphicConfiguration#getRasterizerFrontFace <em>Rasterizer Front Face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rasterizer Front Face</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicConfiguration#getRasterizerFrontFace()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_RasterizerFrontFace();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.RenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Pass Info</em>'.
	 * @see org.sheepy.vulkan.model.process.RenderPassInfo
	 * @generated
	 */
	EClass getRenderPassInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.RenderPassInfo#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachments</em>'.
	 * @see org.sheepy.vulkan.model.process.RenderPassInfo#getAttachments()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Attachments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.RenderPassInfo#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.sheepy.vulkan.model.process.RenderPassInfo#getDependencies()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.RenderPassInfo#getBindPoint <em>Bind Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bind Point</em>'.
	 * @see org.sheepy.vulkan.model.process.RenderPassInfo#getBindPoint()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EAttribute getRenderPassInfo_BindPoint();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.SubpassDependency <em>Subpass Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subpass Dependency</em>'.
	 * @see org.sheepy.vulkan.model.process.SubpassDependency
	 * @generated
	 */
	EClass getSubpassDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Subpass</em>'.
	 * @see org.sheepy.vulkan.model.process.SubpassDependency#getSrcSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcSubpass();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Subpass</em>'.
	 * @see org.sheepy.vulkan.model.process.SubpassDependency#getDstSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstSubpass();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.SubpassDependency#getSrcStageMask <em>Src Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Stage Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.SubpassDependency#getSrcStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcStageMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.SubpassDependency#getDstStageMask <em>Dst Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Stage Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.SubpassDependency#getDstStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstStageMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.SubpassDependency#getSrcAccessMask <em>Src Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.SubpassDependency#getSrcAccessMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcAccessMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.SubpassDependency#getDstAccessMask <em>Dst Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.SubpassDependency#getDstAccessMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstAccessMask();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.AttachmentDescription <em>Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachment Description</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription
	 * @generated
	 */
	EClass getAttachmentDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#isStencil <em>Stencil</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#isStencil()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_Stencil();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Samples</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#getSamples()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_Samples();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#getLoadOp <em>Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Op</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#getLoadOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_LoadOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#getStoreOp <em>Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Op</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#getStoreOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StoreOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#getStencilLoadOp <em>Stencil Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Load Op</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#getStencilLoadOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StencilLoadOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#getStencilStoreOp <em>Stencil Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Store Op</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#getStencilStoreOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StencilStoreOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#getInitialLayout <em>Initial Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#getInitialLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_InitialLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#getFinalLayout <em>Final Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#getFinalLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_FinalLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AttachmentDescription#getRefLayout <em>Ref Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.AttachmentDescription#getRefLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_RefLayout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.ColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Domain</em>'.
	 * @see org.sheepy.vulkan.model.process.ColorDomain
	 * @generated
	 */
	EClass getColorDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ColorDomain#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.sheepy.vulkan.model.process.ColorDomain#getFormat()
	 * @see #getColorDomain()
	 * @generated
	 */
	EAttribute getColorDomain_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ColorDomain#getColorSpace <em>Color Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Space</em>'.
	 * @see org.sheepy.vulkan.model.process.ColorDomain#getColorSpace()
	 * @see #getColorDomain()
	 * @generated
	 */
	EAttribute getColorDomain_ColorSpace();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.AbstractProcessPool <em>Abstract Process Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Process Pool</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcessPool
	 * @generated
	 */
	EClass getAbstractProcessPool();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.AbstractProcessPool#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcessPool#getProcesses()
	 * @see #getAbstractProcessPool()
	 * @generated
	 */
	EReference getAbstractProcessPool_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.AbstractProcessPool#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcessPool#getResources()
	 * @see #getAbstractProcessPool()
	 * @generated
	 */
	EReference getAbstractProcessPool_Resources();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AbstractProcessPool#isResetAllowed <em>Reset Allowed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Allowed</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcessPool#isResetAllowed()
	 * @see #getAbstractProcessPool()
	 * @generated
	 */
	EAttribute getAbstractProcessPool_ResetAllowed();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.ComputeProcessPool <em>Compute Process Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Process Pool</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputeProcessPool
	 * @generated
	 */
	EClass getComputeProcessPool();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.GraphicProcessPool <em>Graphic Process Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphic Process Pool</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicProcessPool
	 * @generated
	 */
	EClass getGraphicProcessPool();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.GraphicProcessPool#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicProcessPool#getConfiguration()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.GraphicProcessPool#getRenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Render Pass Info</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicProcessPool#getRenderPassInfo()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_RenderPassInfo();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.GraphicProcessPool#getDepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depth Image</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicProcessPool#getDepthImage()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_DepthImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.AbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Process</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcess
	 * @generated
	 */
	EClass getAbstractProcess();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.AbstractProcess#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcess#getUnits()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_Units();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.GraphicProcess <em>Graphic Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphic Process</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicProcess
	 * @generated
	 */
	EClass getGraphicProcess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.ComputeProcess <em>Compute Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Process</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputeProcess
	 * @generated
	 */
	EClass getComputeProcess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.IProcessUnit <em>IProcess Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProcess Unit</em>'.
	 * @see org.sheepy.vulkan.model.process.IProcessUnit
	 * @generated
	 */
	EClass getIProcessUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.IProcessUnit#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.vulkan.model.process.IProcessUnit#isEnabled()
	 * @see #getIProcessUnit()
	 * @generated
	 */
	EAttribute getIProcessUnit_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.IProcessUnit#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.IProcessUnit#getStage()
	 * @see #getIProcessUnit()
	 * @generated
	 */
	EAttribute getIProcessUnit_Stage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.PipelineBarrier <em>Pipeline Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.PipelineBarrier
	 * @generated
	 */
	EClass getPipelineBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.PipelineBarrier#getSrcStage <em>Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.PipelineBarrier#getSrcStage()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EAttribute getPipelineBarrier_SrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.PipelineBarrier#getDstStage <em>Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.PipelineBarrier#getDstStage()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EAttribute getPipelineBarrier_DstStage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.BufferBarrier <em>Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.BufferBarrier
	 * @generated
	 */
	EClass getBufferBarrier();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.BufferBarrier#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.vulkan.model.process.BufferBarrier#getBuffer()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EReference getBufferBarrier_Buffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.BufferBarrier#getSrcAccess <em>Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access</em>'.
	 * @see org.sheepy.vulkan.model.process.BufferBarrier#getSrcAccess()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EAttribute getBufferBarrier_SrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.BufferBarrier#getDstAccess <em>Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access</em>'.
	 * @see org.sheepy.vulkan.model.process.BufferBarrier#getDstAccess()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EAttribute getBufferBarrier_DstAccess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.AbstractImageBarrier <em>Abstract Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractImageBarrier
	 * @generated
	 */
	EClass getAbstractImageBarrier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.AbstractImageBarrier#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractImageBarrier#getTransitions()
	 * @see #getAbstractImageBarrier()
	 * @generated
	 */
	EReference getAbstractImageBarrier_Transitions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.ImageBarrier <em>Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.ImageBarrier
	 * @generated
	 */
	EClass getImageBarrier();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.ImageBarrier#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.vulkan.model.process.ImageBarrier#getImage()
	 * @see #getImageBarrier()
	 * @generated
	 */
	EReference getImageBarrier_Image();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.ReferenceImageBarrier <em>Reference Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.ReferenceImageBarrier
	 * @generated
	 */
	EClass getReferenceImageBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ReferenceImageBarrier#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see org.sheepy.vulkan.model.process.ReferenceImageBarrier#getImageId()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ReferenceImageBarrier#getMipLevels <em>Mip Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mip Levels</em>'.
	 * @see org.sheepy.vulkan.model.process.ReferenceImageBarrier#getMipLevels()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_MipLevels();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ReferenceImageBarrier#getImageFormat <em>Image Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Format</em>'.
	 * @see org.sheepy.vulkan.model.process.ReferenceImageBarrier#getImageFormat()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_ImageFormat();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.ImageTransition <em>Image Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Transition</em>'.
	 * @see org.sheepy.vulkan.model.process.ImageTransition
	 * @generated
	 */
	EClass getImageTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ImageTransition#getSrcLayout <em>Src Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.ImageTransition#getSrcLayout()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_SrcLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ImageTransition#getDstLayout <em>Dst Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.ImageTransition#getDstLayout()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_DstLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ImageTransition#getSrcAccess <em>Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access</em>'.
	 * @see org.sheepy.vulkan.model.process.ImageTransition#getSrcAccess()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_SrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ImageTransition#getDstAccess <em>Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access</em>'.
	 * @see org.sheepy.vulkan.model.process.ImageTransition#getDstAccess()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_DstAccess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.AbstractPipeline <em>Abstract Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractPipeline
	 * @generated
	 */
	EClass getAbstractPipeline();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.AbstractPipeline#getDescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor Set</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractPipeline#getDescriptorSet()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_DescriptorSet();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.AbstractPipeline#getPushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Push Constant</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractPipeline#getPushConstant()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_PushConstant();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.AbstractCompositePipeline <em>Abstract Composite Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Composite Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractCompositePipeline
	 * @generated
	 */
	EClass getAbstractCompositePipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.AbstractCompositePipeline#getPipelines <em>Pipelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pipelines</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractCompositePipeline#getPipelines()
	 * @see #getAbstractCompositePipeline()
	 * @generated
	 */
	EReference getAbstractCompositePipeline_Pipelines();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.GraphicsPipeline <em>Graphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphics Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicsPipeline
	 * @generated
	 */
	EClass getGraphicsPipeline();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.vulkan.model.process.GraphicsPipeline#getShaders <em>Shaders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shaders</em>'.
	 * @see org.sheepy.vulkan.model.process.GraphicsPipeline#getShaders()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_Shaders();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.ComputePipeline <em>Compute Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputePipeline
	 * @generated
	 */
	EClass getComputePipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.ComputePipeline#getComputers <em>Computers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computers</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputePipeline#getComputers()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EReference getComputePipeline_Computers();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ComputePipeline#getWorkgroupSizeX <em>Workgroup Size X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size X</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputePipeline#getWorkgroupSizeX()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeX();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ComputePipeline#getWorkgroupSizeY <em>Workgroup Size Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size Y</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputePipeline#getWorkgroupSizeY()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeY();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ComputePipeline#getWorkgroupSizeZ <em>Workgroup Size Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size Z</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputePipeline#getWorkgroupSizeZ()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeZ();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ComputePipeline#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputePipeline#getWidth()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ComputePipeline#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputePipeline#getHeight()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ComputePipeline#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see org.sheepy.vulkan.model.process.ComputePipeline#getDepth()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Depth();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.Computer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computer</em>'.
	 * @see org.sheepy.vulkan.model.process.Computer
	 * @generated
	 */
	EClass getComputer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.Computer#getShader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shader</em>'.
	 * @see org.sheepy.vulkan.model.process.Computer#getShader()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Shader();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.ImagePipeline <em>Image Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.ImagePipeline
	 * @generated
	 */
	EClass getImagePipeline();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.ImagePipeline#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.vulkan.model.process.ImagePipeline#getImage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EReference getImagePipeline_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Src Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.ImagePipeline#getImageSrcStage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Dst Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.ImagePipeline#getImageDstStage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ImagePipeline#getImageSrcAccess <em>Image Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Src Access</em>'.
	 * @see org.sheepy.vulkan.model.process.ImagePipeline#getImageSrcAccess()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.ImagePipeline#getImageDstAccess <em>Image Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Dst Access</em>'.
	 * @see org.sheepy.vulkan.model.process.ImagePipeline#getImageDstAccess()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstAccess();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProcessFactory getProcessFactory();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.Configuration <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.Configuration
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl <em>Graphic Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getGraphicConfiguration()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.RenderPassInfoImpl <em>Render Pass Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.RenderPassInfoImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getRenderPassInfo()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.SubpassDependencyImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getSubpassDependency()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.AttachmentDescriptionImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAttachmentDescription()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ColorDomainImpl <em>Color Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ColorDomainImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getColorDomain()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl <em>Abstract Process Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractProcessPool()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ComputeProcessPoolImpl <em>Compute Process Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ComputeProcessPoolImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getComputeProcessPool()
		 * @generated
		 */
		EClass COMPUTE_PROCESS_POOL = eINSTANCE.getComputeProcessPool();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.GraphicProcessPoolImpl <em>Graphic Process Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.GraphicProcessPoolImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getGraphicProcessPool()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.AbstractProcessImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractProcess()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.GraphicProcessImpl <em>Graphic Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.GraphicProcessImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getGraphicProcess()
		 * @generated
		 */
		EClass GRAPHIC_PROCESS = eINSTANCE.getGraphicProcess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ComputeProcessImpl <em>Compute Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ComputeProcessImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getComputeProcess()
		 * @generated
		 */
		EClass COMPUTE_PROCESS = eINSTANCE.getComputeProcess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.IProcessUnit <em>IProcess Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.IProcessUnit
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getIProcessUnit()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBarrier()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.BufferBarrierImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getBufferBarrier()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.AbstractImageBarrierImpl <em>Abstract Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.AbstractImageBarrierImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractImageBarrier()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ImageBarrierImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getImageBarrier()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ReferenceImageBarrierImpl <em>Reference Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ReferenceImageBarrierImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getReferenceImageBarrier()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ImageTransitionImpl <em>Image Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ImageTransitionImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getImageTransition()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl <em>Abstract Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractPipeline()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.AbstractCompositePipelineImpl <em>Abstract Composite Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.AbstractCompositePipelineImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractCompositePipeline()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.GraphicsPipelineImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getGraphicsPipeline()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl <em>Compute Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ComputePipelineImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getComputePipeline()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ComputerImpl <em>Computer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ComputerImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getComputer()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.ImagePipelineImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getImagePipeline()
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

	}

} //ProcessPackage
