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
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/graphic' publicConstructors='true' updateClasspath='false' basePackage='org.sheepy.vulkan.model.process'"
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
	 * The feature id for the '<em><b>Swap Image Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Frame Wait Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Color Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__COLOR_DOMAIN = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Rasterizer Cull Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Rasterizer Front Face</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_CONFIGURATION_FEATURE_COUNT = ProcessPackage.CONFIGURATION_FEATURE_COUNT + 7;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpassDependency()
	 * @generated
	 */
	int SUBPASS_DEPENDENCY = 2;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachmentDescription()
	 * @generated
	 */
	int ATTACHMENT_DESCRIPTION = 3;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessPoolImpl <em>Process Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessPoolImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicProcessPool()
	 * @generated
	 */
	int GRAPHIC_PROCESS_POOL = 4;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__PROCESSES = ProcessPackage.ABSTRACT_PROCESS_POOL__PROCESSES;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__RESOURCES = ProcessPackage.ABSTRACT_PROCESS_POOL__RESOURCES;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__RESET_ALLOWED = ProcessPackage.ABSTRACT_PROCESS_POOL__RESET_ALLOWED;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__CONFIGURATION = ProcessPackage.ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Render Pass Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO = ProcessPackage.ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Depth Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL__DEPTH_IMAGE = ProcessPackage.ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL_FEATURE_COUNT = ProcessPackage.ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_POOL_OPERATION_COUNT = ProcessPackage.ABSTRACT_PROCESS_POOL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicProcess()
	 * @generated
	 */
	int GRAPHIC_PROCESS = 5;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS__UNITS = ProcessPackage.ABSTRACT_PROCESS__UNITS;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_FEATURE_COUNT = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PROCESS_OPERATION_COUNT = ProcessPackage.ABSTRACT_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl <em>Graphics Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicsPipeline()
	 * @generated
	 */
	int GRAPHICS_PIPELINE = 6;

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
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__DESCRIPTOR_SET = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__PUSH_CONSTANT = ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE__SHADERS = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_FEATURE_COUNT = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Graphics Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_PIPELINE_OPERATION_COUNT = ProcessPackage.ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.ImagePipelineImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getImagePipeline()
	 * @generated
	 */
	int IMAGE_PIPELINE = 7;

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
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__DESCRIPTOR_SET = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__PUSH_CONSTANT = ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT;

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
	 * The feature id for the '<em><b>Image Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_SRC_ACCESS = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Image Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_DST_ACCESS = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Image Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE_FEATURE_COUNT = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Image Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE_OPERATION_COUNT = ProcessPackage.ABSTRACT_PIPELINE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.graphic.impl.PipelineImageBarrierImpl <em>Pipeline Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.graphic.impl.PipelineImageBarrierImpl
	 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getPipelineImageBarrier()
	 * @generated
	 */
	int PIPELINE_IMAGE_BARRIER = 8;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_IMAGE_BARRIER__ENABLED = ProcessPackage.PIPELINE_BARRIER__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_IMAGE_BARRIER__STAGE = ProcessPackage.PIPELINE_BARRIER__STAGE;

	/**
	 * The feature id for the '<em><b>Image Barrier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER = ProcessPackage.PIPELINE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pipeline Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_IMAGE_BARRIER_FEATURE_COUNT = ProcessPackage.PIPELINE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pipeline Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_IMAGE_BARRIER_OPERATION_COUNT = ProcessPackage.PIPELINE_BARRIER_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getSwapImageUsage <em>Swap Image Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Swap Image Usage</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getSwapImageUsage()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_SwapImageUsage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getFrameWaitStage <em>Frame Wait Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Wait Stage</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getFrameWaitStage()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_FrameWaitStage();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getRasterizerCullMode <em>Rasterizer Cull Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rasterizer Cull Mode</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getRasterizerCullMode()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_RasterizerCullMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getRasterizerFrontFace <em>Rasterizer Front Face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rasterizer Front Face</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicConfiguration#getRasterizerFrontFace()
	 * @see #getGraphicConfiguration()
	 * @generated
	 */
	EAttribute getGraphicConfiguration_RasterizerFrontFace();

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
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency <em>Subpass Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subpass Dependency</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency
	 * @generated
	 */
	EClass getSubpassDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass <em>Src Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Subpass</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcSubpass();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstSubpass <em>Dst Subpass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Subpass</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstSubpass()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstSubpass();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask <em>Src Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Stage Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcStageMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstStageMask <em>Dst Stage Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Stage Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstStageMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstStageMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcAccessMask <em>Src Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getSrcAccessMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_SrcAccessMask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstAccessMask <em>Dst Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access Mask</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.SubpassDependency#getDstAccessMask()
	 * @see #getSubpassDependency()
	 * @generated
	 */
	EAttribute getSubpassDependency_DstAccessMask();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#isStencil <em>Stencil</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#isStencil()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_Stencil();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getRefLayout <em>Ref Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Layout</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.AttachmentDescription#getRefLayout()
	 * @see #getAttachmentDescription()
	 * @generated
	 */
	EAttribute getAttachmentDescription_RefLayout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool <em>Process Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Pool</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicProcessPool
	 * @generated
	 */
	EClass getGraphicProcessPool();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getConfiguration()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getRenderPassInfo <em>Render Pass Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Render Pass Info</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getRenderPassInfo()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_RenderPassInfo();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getDepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depth Image</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicProcessPool#getDepthImage()
	 * @see #getGraphicProcessPool()
	 * @generated
	 */
	EReference getGraphicProcessPool_DepthImage();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcAccess <em>Image Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Src Access</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcAccess()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstAccess <em>Image Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Dst Access</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstAccess()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstAccess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.graphic.PipelineImageBarrier <em>Pipeline Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.PipelineImageBarrier
	 * @generated
	 */
	EClass getPipelineImageBarrier();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.graphic.PipelineImageBarrier#getImageBarrier <em>Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Image Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.graphic.PipelineImageBarrier#getImageBarrier()
	 * @see #getPipelineImageBarrier()
	 * @generated
	 */
	EReference getPipelineImageBarrier_ImageBarrier();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl <em>Subpass Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.SubpassDependencyImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getSubpassDependency()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl <em>Attachment Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.AttachmentDescriptionImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getAttachmentDescription()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessPoolImpl <em>Process Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessPoolImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicProcessPool()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getGraphicProcess()
		 * @generated
		 */
		EClass GRAPHIC_PROCESS = eINSTANCE.getGraphicProcess();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.graphic.impl.PipelineImageBarrierImpl <em>Pipeline Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.graphic.impl.PipelineImageBarrierImpl
		 * @see org.sheepy.vulkan.model.process.graphic.impl.GraphicPackageImpl#getPipelineImageBarrier()
		 * @generated
		 */
		EClass PIPELINE_IMAGE_BARRIER = eINSTANCE.getPipelineImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Image Barrier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER = eINSTANCE.getPipelineImageBarrier_ImageBarrier();

	}

} //GraphicPackage
