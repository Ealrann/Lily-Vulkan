/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.vulkan.model.process.ProcessPackage;

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
 * @see org.sheepy.vulkan.model.process.graphic.GraphicFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/java' editDirectory='/org.sheepy.vulkan.model.edit/src/generated/java' publicConstructors='true' complianceLevel='11.0' resource='XMI' extensibleProviderFactory='true' childCreationExtenders='true' updateClasspath='false' basePackage='org.sheepy.vulkan.model.process'"
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
	String eNS_URI = "org.sheepy.vulkan.model.process.graphic";

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
	GraphicPackage eINSTANCE = org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicConfigurationImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicConfiguration()
	 * @generated
	 */
	int GRAPHIC_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Clear Before Render</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Presentation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__PRESENTATION_MODE = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required Swap Image Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Swap Image Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGES = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Acquire Wait Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Color Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__COLOR_DOMAIN = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION_FEATURE_COUNT = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION_OPERATION_COUNT = ProcessPackage.CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl <em>Render Pass Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getRenderPassInfo()
	 * @generated
	 */
	int RENDER_PASS_INFO = 1;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.SubpassImpl <em>Subpass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.SubpassImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpass()
	 * @generated
	 */
	int SUBPASS = 2;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.AttachementRefImpl <em>Attachement Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.AttachementRefImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachementRef()
	 * @generated
	 */
	int ATTACHEMENT_REF = 3;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpassDependency()
	 * @generated
	 */
	int SUBPASS_DEPENDENCY = 4;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachmentDescription()
	 * @generated
	 */
	int ATTACHMENT_DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION__NAME = 0;

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
	 * The number of structural features of the '<em>Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.DepthAttachmentDescriptionImpl <em>Depth Attachment Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.DepthAttachmentDescriptionImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDepthAttachmentDescription()
	 * @generated
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__NAME = ATTACHMENT_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__SAMPLES = ATTACHMENT_DESCRIPTION__SAMPLES;

	/**
	 * The feature id for the '<em><b>Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__LOAD_OP = ATTACHMENT_DESCRIPTION__LOAD_OP;

	/**
	 * The feature id for the '<em><b>Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__STORE_OP = ATTACHMENT_DESCRIPTION__STORE_OP;

	/**
	 * The feature id for the '<em><b>Stencil Load Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP = ATTACHMENT_DESCRIPTION__STENCIL_LOAD_OP;

	/**
	 * The feature id for the '<em><b>Stencil Store Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP = ATTACHMENT_DESCRIPTION__STENCIL_STORE_OP;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT = ATTACHMENT_DESCRIPTION__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Final Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__FINAL_LAYOUT = ATTACHMENT_DESCRIPTION__FINAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Depth Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION__DEPTH_IMAGE = ATTACHMENT_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Depth Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION_FEATURE_COUNT = ATTACHMENT_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Depth Attachment Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_ATTACHMENT_DESCRIPTION_OPERATION_COUNT = ATTACHMENT_DESCRIPTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicProcess()
	 * @generated
	 */
	int GRAPHIC_PROCESS = 7;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__CONTENT_OBJECTS = ProcessPackage.ABSTRACT_PROCESS__CONTENT_OBJECTS;

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
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__RESOURCES = ProcessPackage.ABSTRACT_PROCESS__RESOURCES;

	/**
	 * The feature id for the '<em><b>Descriptor Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__DESCRIPTOR_SETS = ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__UNITS = ProcessPackage.ABSTRACT_PROCESS__UNITS;

	/**
	 * The feature id for the '<em><b>Semaphores</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__SEMAPHORES = ProcessPackage.ABSTRACT_PROCESS__SEMAPHORES;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__RESET_ALLOWED = ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED;

	/**
	 * The feature id for the '<em><b>Initialized Signalized Semaphore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE = ProcessPackage.ABSTRACT_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE;

	/**
	 * The feature id for the '<em><b>Dependent Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__DEPENDENT_PROCESSES = ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES;

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
	 * The feature id for the '<em><b>Depth Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__DEPTH_IMAGE = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_FEATURE_COUNT = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS___LINFERENCE_OBJECT = ProcessPackage.ABSTRACT_PROCESS___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS___CREATE_CONTAINMENT_ELIST__ECLASS = ProcessPackage.ABSTRACT_PROCESS___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS___LCONTENTS = ProcessPackage.ABSTRACT_PROCESS___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS___LPARENT = ProcessPackage.ABSTRACT_PROCESS___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS___LALL_CONTENTS = ProcessPackage.ABSTRACT_PROCESS___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_OPERATION_COUNT = ProcessPackage.ABSTRACT_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline <em>IGraphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIGraphicsPipeline()
	 * @generated
	 */
	int IGRAPHICS_PIPELINE = 8;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE__CONTENT_OBJECTS = ProcessPackage.IPIPELINE__CONTENT_OBJECTS;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGRAPHICS_PIPELINE__NAME = ProcessPackage.IPIPELINE__NAME;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.IGUIPipeline <em>IGUI Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.IGUIPipeline
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIGUIPipeline()
	 * @generated
	 */
	int IGUI_PIPELINE = 9;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE__CONTENT_OBJECTS = IGRAPHICS_PIPELINE__CONTENT_OBJECTS;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IGUI_PIPELINE__NAME = IGRAPHICS_PIPELINE__NAME;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicsPipeline()
	 * @generated
	 */
	int GRAPHICS_PIPELINE = 10;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__CONTENT_OBJECTS = ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__ENABLED = ProcessPackage.ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__STAGE = ProcessPackage.ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__NAME = ProcessPackage.ABSTRACT_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__UNITS = ProcessPackage.ABSTRACT_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DESCRIPTOR_SET = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__CONSTANTS = ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__SHADERS = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__VIEWPORT_STATE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__RASTERIZER = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__COLOR_BLEND = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DYNAMIC_STATE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__SUBPASS = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_FEATURE_COUNT = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___LINFERENCE_OBJECT = ProcessPackage.ABSTRACT_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = ProcessPackage.ABSTRACT_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___LCONTENTS = ProcessPackage.ABSTRACT_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___LPARENT = ProcessPackage.ABSTRACT_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE___LALL_CONTENTS = ProcessPackage.ABSTRACT_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_OPERATION_COUNT = ProcessPackage.ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.DynamicStateImpl <em>Dynamic State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.DynamicStateImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDynamicState()
	 * @generated
	 */
	int DYNAMIC_STATE = 11;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ColorBlendImpl <em>Color Blend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.ColorBlendImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorBlend()
	 * @generated
	 */
	int COLOR_BLEND = 12;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl <em>Color Blend Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorBlendAttachment()
	 * @generated
	 */
	int COLOR_BLEND_ATTACHMENT = 13;

	/**
	 * The feature id for the '<em><b>Blend Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__BLEND_ENABLE = 0;

	/**
	 * The feature id for the '<em><b>Red Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE = 1;

	/**
	 * The feature id for the '<em><b>Green Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE = 2;

	/**
	 * The feature id for the '<em><b>Blue Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE = 3;

	/**
	 * The feature id for the '<em><b>Alpha Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE = 4;

	/**
	 * The feature id for the '<em><b>Src Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__SRC_COLOR = 5;

	/**
	 * The feature id for the '<em><b>Dst Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__DST_COLOR = 6;

	/**
	 * The feature id for the '<em><b>Src Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__SRC_ALPHA = 7;

	/**
	 * The feature id for the '<em><b>Dst Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__DST_ALPHA = 8;

	/**
	 * The feature id for the '<em><b>Color Blend Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP = 9;

	/**
	 * The feature id for the '<em><b>Alpha Blend Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP = 10;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.ViewportState <em>Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.ViewportState
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getViewportState()
	 * @generated
	 */
	int VIEWPORT_STATE = 14;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.StaticViewportStateImpl <em>Static Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.StaticViewportStateImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getStaticViewportState()
	 * @generated
	 */
	int STATIC_VIEWPORT_STATE = 15;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.DynamicViewportStateImpl <em>Dynamic Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.DynamicViewportStateImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDynamicViewportState()
	 * @generated
	 */
	int DYNAMIC_VIEWPORT_STATE = 16;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ViewportImpl <em>Viewport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.ViewportImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getViewport()
	 * @generated
	 */
	int VIEWPORT = 17;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ScissorImpl <em>Scissor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.ScissorImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getScissor()
	 * @generated
	 */
	int SCISSOR = 18;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.RasterizerImpl <em>Rasterizer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.RasterizerImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getRasterizer()
	 * @generated
	 */
	int RASTERIZER = 19;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getImagePipeline()
	 * @generated
	 */
	int IMAGE_PIPELINE = 20;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__CONTENT_OBJECTS = ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__ENABLED = ProcessPackage.ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__STAGE = ProcessPackage.ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__NAME = ProcessPackage.ABSTRACT_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__UNITS = ProcessPackage.ABSTRACT_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__DESCRIPTOR_SET = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__CONSTANTS = ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_SRC_STAGE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_DST_STAGE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Image Src Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Image Dst Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Src Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__SRC_QUEUE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Image Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE_FEATURE_COUNT = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___LINFERENCE_OBJECT = ProcessPackage.ABSTRACT_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = ProcessPackage.ABSTRACT_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___LCONTENTS = ProcessPackage.ABSTRACT_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___LPARENT = ProcessPackage.ABSTRACT_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___LALL_CONTENTS = ProcessPackage.ABSTRACT_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Image Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE_OPERATION_COUNT = ProcessPackage.ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration
	 * @generated
	 */
	EClass getGraphicConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#isClearBeforeRender <em>Clear Before Render</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear Before Render</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#isClearBeforeRender()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_ClearBeforeRender();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getPresentationMode <em>Presentation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Presentation Mode</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getPresentationMode()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_PresentationMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getRequiredSwapImageCount <em>Required Swap Image Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Swap Image Count</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getRequiredSwapImageCount()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_RequiredSwapImageCount();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getSwapImageUsages <em>Swap Image Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Swap Image Usages</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getSwapImageUsages()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_SwapImageUsages();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getAcquireWaitStage <em>Acquire Wait Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acquire Wait Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getAcquireWaitStage()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_AcquireWaitStage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Color Domain</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getColorDomain()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EReference getGraphicConfiguration_ColorDomain();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Pass Info</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.RenderPassInfo
	 * @generated
	 */
	EClass getRenderPassInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachments</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getAttachments()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Attachments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getSubpasses <em>Subpasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subpasses</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getSubpasses()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Subpasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getDependencies()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EReference getRenderPassInfo_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getBindPoint <em>Bind Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bind Point</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.RenderPassInfo#getBindPoint()
	 * @see #getRenderPassInfo()
	 * @generated
	 */
	EAttribute getRenderPassInfo_BindPoint();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.Subpass <em>Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subpass</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Subpass
	 * @generated
	 */
	EClass getSubpass();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Subpass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Subpass#getName()
	 * @see #getSubpass()
	 * @generated
	 */
	EAttribute getSubpass_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.graphic.Subpass#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refs</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Subpass#getRefs()
	 * @see #getSubpass()
	 * @generated
	 */
	EReference getSubpass_Refs();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.AttachementRef <em>Attachement Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachement Ref</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachementRef
	 * @generated
	 */
	EClass getAttachementRef();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.graphic.AttachementRef#getAttachement <em>Attachement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attachement</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachementRef#getAttachement()
	 * @see #getAttachementRef()
	 * @generated
	 */
	EReference getAttachementRef_Attachement();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachementRef#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachementRef#getLayout()
	 * @see #getAttachementRef()
	 * @generated
	 */
	EAttribute getAttachementRef_Layout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency <em>Subpass Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subpass Dependency</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency
	 * @generated
	 */
	EClass getSubpassDependency();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src Subpass</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EReference getSubpassDependency_SrcSubpass();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dst Subpass</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EReference getSubpassDependency_DstSubpass();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask <em>Src Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Src Stage Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcStageMask();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstStageMask <em>Dst Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dst Stage Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstStageMask();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcAccesses <em>Src Accesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Src Accesses</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcAccesses()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcAccesses();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstAccesses <em>Dst Accesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dst Accesses</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstAccesses()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstAccesses();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription <em>Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachment Description</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription
	 * @generated
	 */
	EClass getAttachmentDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getName()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Samples</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getSamples()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_Samples();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getLoadOp <em>Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Op</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getLoadOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_LoadOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getStoreOp <em>Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Op</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getStoreOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StoreOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getStencilLoadOp <em>Stencil Load Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Load Op</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getStencilLoadOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StencilLoadOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getStencilStoreOp <em>Stencil Store Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Store Op</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getStencilStoreOp()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_StencilStoreOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getInitialLayout <em>Initial Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getInitialLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_InitialLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getFinalLayout <em>Final Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getFinalLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_FinalLayout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.DepthAttachmentDescription <em>Depth Attachment Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depth Attachment Description</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.DepthAttachmentDescription
	 * @generated
	 */
	EClass getDepthAttachmentDescription();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.graphic.DepthAttachmentDescription#getDepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depth Image</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.DepthAttachmentDescription#getDepthImage()
	 * @see #getDepthAttachmentDescription()
	 * @generated
	 */
	EReference getDepthAttachmentDescription_DepthImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicProcess
	 * @generated
	 */
	EClass getGraphicProcess();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcess#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicProcess#getConfiguration()
	 * @see #getGraphicProcess()
	 * @generated
	 */
	EReference getGraphicProcess_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcess#getRenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Render Pass Info</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicProcess#getRenderPassInfo()
	 * @see #getGraphicProcess()
	 * @generated
	 */
	EReference getGraphicProcess_RenderPassInfo();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcess#getDepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Depth Image</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicProcess#getDepthImage()
	 * @see #getGraphicProcess()
	 * @generated
	 */
	EReference getGraphicProcess_DepthImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline <em>IGraphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IGraphics Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline
	 * @generated
	 */
	EClass getIGraphicsPipeline();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.IGUIPipeline <em>IGUI Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IGUI Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.IGUIPipeline
	 * @generated
	 */
	EClass getIGUIPipeline();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.GraphicsPipeline <em>Graphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphics Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicsPipeline
	 * @generated
	 */
	EClass getGraphicsPipeline();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getShaders <em>Shaders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Shaders</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getShaders()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_Shaders();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getViewportState <em>Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Viewport State</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getViewportState()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_ViewportState();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getRasterizer <em>Rasterizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rasterizer</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getRasterizer()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_Rasterizer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getColorBlend <em>Color Blend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Color Blend</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getColorBlend()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_ColorBlend();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getDynamicState <em>Dynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dynamic State</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getDynamicState()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EReference getGraphicsPipeline_DynamicState();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getSubpass <em>Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subpass</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicsPipeline#getSubpass()
	 * @see #getGraphicsPipeline()
	 * @generated
	 */
	EAttribute getGraphicsPipeline_Subpass();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.DynamicState <em>Dynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic State</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.DynamicState
	 * @generated
	 */
	EClass getDynamicState();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.process.graphic.DynamicState#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>States</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.DynamicState#getStates()
	 * @see #getDynamicState()
	 * @generated
	 */
	EAttribute getDynamicState_States();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.ColorBlend <em>Color Blend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Blend</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlend
	 * @generated
	 */
	EClass getColorBlend();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.graphic.ColorBlend#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachments</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlend#getAttachments()
	 * @see #getColorBlend()
	 * @generated
	 */
	EReference getColorBlend_Attachments();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlend#isLogicOpEnable <em>Logic Op Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logic Op Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlend#isLogicOpEnable()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_LogicOpEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlend#getLogicOp <em>Logic Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logic Op</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlend#getLogicOp()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_LogicOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlend#getBlendConstant0 <em>Blend Constant0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant0</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlend#getBlendConstant0()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant0();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlend#getBlendConstant1 <em>Blend Constant1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant1</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlend#getBlendConstant1()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant1();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlend#getBlendConstant2 <em>Blend Constant2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant2</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlend#getBlendConstant2()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant2();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlend#getBlendConstant3 <em>Blend Constant3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant3</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlend#getBlendConstant3()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant3();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment <em>Color Blend Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Blend Attachment</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment
	 * @generated
	 */
	EClass getColorBlendAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isBlendEnable <em>Blend Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isBlendEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_BlendEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isRedComponentEnable <em>Red Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Red Component Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isRedComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_RedComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isGreenComponentEnable <em>Green Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Green Component Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isGreenComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_GreenComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isBlueComponentEnable <em>Blue Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blue Component Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isBlueComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_BlueComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isAlphaComponentEnable <em>Alpha Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Component Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#isAlphaComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_AlphaComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getSrcColor <em>Src Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Color</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getSrcColor()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_SrcColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getDstColor <em>Dst Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Color</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getDstColor()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_DstColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getSrcAlpha <em>Src Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Alpha</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getSrcAlpha()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_SrcAlpha();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getDstAlpha <em>Dst Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Alpha</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getDstAlpha()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_DstAlpha();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getColorBlendOp <em>Color Blend Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Blend Op</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getColorBlendOp()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_ColorBlendOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getAlphaBlendOp <em>Alpha Blend Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Blend Op</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ColorBlendAttachment#getAlphaBlendOp()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_AlphaBlendOp();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.ViewportState <em>Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewport State</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ViewportState
	 * @generated
	 */
	EClass getViewportState();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.StaticViewportState <em>Static Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Viewport State</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.StaticViewportState
	 * @generated
	 */
	EClass getStaticViewportState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.graphic.StaticViewportState#getViewports <em>Viewports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Viewports</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.StaticViewportState#getViewports()
	 * @see #getStaticViewportState()
	 * @generated
	 */
	EReference getStaticViewportState_Viewports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.graphic.StaticViewportState#getScissors <em>Scissors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scissors</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.StaticViewportState#getScissors()
	 * @see #getStaticViewportState()
	 * @generated
	 */
	EReference getStaticViewportState_Scissors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.DynamicViewportState <em>Dynamic Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Viewport State</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.DynamicViewportState
	 * @generated
	 */
	EClass getDynamicViewportState();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.DynamicViewportState#getViewportCount <em>Viewport Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Viewport Count</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.DynamicViewportState#getViewportCount()
	 * @see #getDynamicViewportState()
	 * @generated
	 */
	EAttribute getDynamicViewportState_ViewportCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.DynamicViewportState#getScissorCount <em>Scissor Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scissor Count</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.DynamicViewportState#getScissorCount()
	 * @see #getDynamicViewportState()
	 * @generated
	 */
	EAttribute getDynamicViewportState_ScissorCount();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.Viewport <em>Viewport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewport</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Viewport
	 * @generated
	 */
	EClass getViewport();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Viewport#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Viewport#getOffset()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Viewport#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extent</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Viewport#getExtent()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_Extent();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Viewport#getMinDepth <em>Min Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Depth</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Viewport#getMinDepth()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_MinDepth();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Viewport#getMaxDepth <em>Max Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Depth</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Viewport#getMaxDepth()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_MaxDepth();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.Scissor <em>Scissor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scissor</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Scissor
	 * @generated
	 */
	EClass getScissor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Scissor#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Scissor#getOffset()
	 * @see #getScissor()
	 * @generated
	 */
	EAttribute getScissor_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Scissor#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extent</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Scissor#getExtent()
	 * @see #getScissor()
	 * @generated
	 */
	EAttribute getScissor_Extent();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.Rasterizer <em>Rasterizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rasterizer</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Rasterizer
	 * @generated
	 */
	EClass getRasterizer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Rasterizer#getCullMode <em>Cull Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cull Mode</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Rasterizer#getCullMode()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_CullMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Rasterizer#getFrontFace <em>Front Face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Front Face</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Rasterizer#getFrontFace()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_FrontFace();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Rasterizer#getPolygonMode <em>Polygon Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Polygon Mode</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Rasterizer#getPolygonMode()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_PolygonMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Rasterizer#getLineWidth <em>Line Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Width</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Rasterizer#getLineWidth()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_LineWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Rasterizer#isDepthClampEnable <em>Depth Clamp Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Clamp Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Rasterizer#isDepthClampEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DepthClampEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Rasterizer#isDiscardEnable <em>Discard Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discard Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Rasterizer#isDiscardEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DiscardEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.Rasterizer#isDepthBiasEnable <em>Depth Bias Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Bias Enable</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.Rasterizer#isDepthBiasEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DepthBiasEnable();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline <em>Image Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline
	 * @generated
	 */
	EClass getImagePipeline();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EReference getImagePipeline_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Src Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcStage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Dst Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstStage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstStage();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcAccessMask <em>Image Src Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Image Src Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcAccessMask()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcAccessMask();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstAccessMask <em>Image Dst Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Image Dst Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstAccessMask()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstAccessMask();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getSrcQueue <em>Src Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src Queue</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline#getSrcQueue()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EReference getImagePipeline_SrcQueue();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicConfigurationImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicConfiguration()
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
		 * The meta object literal for the '<em><b>Required Swap Image Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT = eINSTANCE.getGraphicConfiguration_RequiredSwapImageCount();

		/**
		 * The meta object literal for the '<em><b>Swap Image Usages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGES = eINSTANCE.getGraphicConfiguration_SwapImageUsages();

		/**
		 * The meta object literal for the '<em><b>Acquire Wait Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE = eINSTANCE.getGraphicConfiguration_AcquireWaitStage();

		/**
		 * The meta object literal for the '<em><b>Color Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_CONFIGURATION__COLOR_DOMAIN = eINSTANCE.getGraphicConfiguration_ColorDomain();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl <em>Render Pass Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.RenderPassInfoImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getRenderPassInfo()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.SubpassImpl <em>Subpass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.SubpassImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpass()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.AttachementRefImpl <em>Attachement Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.AttachementRefImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachementRef()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpassDependency()
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
		EAttribute SUBPASS_DEPENDENCY__SRC_STAGE_MASK = eINSTANCE.getSubpassDependency_SrcStageMask();

		/**
		 * The meta object literal for the '<em><b>Dst Stage Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBPASS_DEPENDENCY__DST_STAGE_MASK = eINSTANCE.getSubpassDependency_DstStageMask();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachmentDescription()
		 * @generated
		 */
		EClass ATTACHMENT_DESCRIPTION = eINSTANCE.getAttachmentDescription();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT_DESCRIPTION__NAME = eINSTANCE.getAttachmentDescription_Name();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.DepthAttachmentDescriptionImpl <em>Depth Attachment Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.DepthAttachmentDescriptionImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDepthAttachmentDescription()
		 * @generated
		 */
		EClass DEPTH_ATTACHMENT_DESCRIPTION = eINSTANCE.getDepthAttachmentDescription();

		/**
		 * The meta object literal for the '<em><b>Depth Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPTH_ATTACHMENT_DESCRIPTION__DEPTH_IMAGE = eINSTANCE.getDepthAttachmentDescription_DepthImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicProcess()
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
		 * The meta object literal for the '<em><b>Depth Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHIC_PROCESS__DEPTH_IMAGE = eINSTANCE.getGraphicProcess_DepthImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline <em>IGraphics Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIGraphicsPipeline()
		 * @generated
		 */
		EClass IGRAPHICS_PIPELINE = eINSTANCE.getIGraphicsPipeline();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.IGUIPipeline <em>IGUI Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.IGUIPipeline
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getIGUIPipeline()
		 * @generated
		 */
		EClass IGUI_PIPELINE = eINSTANCE.getIGUIPipeline();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicsPipeline()
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
		EReference GRAPHICS_PIPELINE__VIEWPORT_STATE = eINSTANCE.getGraphicsPipeline_ViewportState();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.DynamicStateImpl <em>Dynamic State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.DynamicStateImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDynamicState()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ColorBlendImpl <em>Color Blend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.ColorBlendImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorBlend()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl <em>Color Blend Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.ColorBlendAttachmentImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getColorBlendAttachment()
		 * @generated
		 */
		EClass COLOR_BLEND_ATTACHMENT = eINSTANCE.getColorBlendAttachment();

		/**
		 * The meta object literal for the '<em><b>Blend Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__BLEND_ENABLE = eINSTANCE.getColorBlendAttachment_BlendEnable();

		/**
		 * The meta object literal for the '<em><b>Red Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE = eINSTANCE.getColorBlendAttachment_RedComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Green Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE = eINSTANCE.getColorBlendAttachment_GreenComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Blue Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE = eINSTANCE.getColorBlendAttachment_BlueComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Alpha Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE = eINSTANCE.getColorBlendAttachment_AlphaComponentEnable();

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
		EAttribute COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP = eINSTANCE.getColorBlendAttachment_ColorBlendOp();

		/**
		 * The meta object literal for the '<em><b>Alpha Blend Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP = eINSTANCE.getColorBlendAttachment_AlphaBlendOp();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.ViewportState <em>Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.ViewportState
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getViewportState()
		 * @generated
		 */
		EClass VIEWPORT_STATE = eINSTANCE.getViewportState();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.StaticViewportStateImpl <em>Static Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.StaticViewportStateImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getStaticViewportState()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.DynamicViewportStateImpl <em>Dynamic Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.DynamicViewportStateImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getDynamicViewportState()
		 * @generated
		 */
		EClass DYNAMIC_VIEWPORT_STATE = eINSTANCE.getDynamicViewportState();

		/**
		 * The meta object literal for the '<em><b>Viewport Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT = eINSTANCE.getDynamicViewportState_ViewportCount();

		/**
		 * The meta object literal for the '<em><b>Scissor Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT = eINSTANCE.getDynamicViewportState_ScissorCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ViewportImpl <em>Viewport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.ViewportImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getViewport()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ScissorImpl <em>Scissor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.ScissorImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getScissor()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.RasterizerImpl <em>Rasterizer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.RasterizerImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getRasterizer()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getImagePipeline()
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
		 * The meta object literal for the '<em><b>Image Src Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK = eINSTANCE.getImagePipeline_ImageSrcAccessMask();

		/**
		 * The meta object literal for the '<em><b>Image Dst Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK = eINSTANCE.getImagePipeline_ImageDstAccessMask();

		/**
		 * The meta object literal for the '<em><b>Src Queue</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_PIPELINE__SRC_QUEUE = eINSTANCE.getImagePipeline_SrcQueue();

	}

} //GraphicPackage
