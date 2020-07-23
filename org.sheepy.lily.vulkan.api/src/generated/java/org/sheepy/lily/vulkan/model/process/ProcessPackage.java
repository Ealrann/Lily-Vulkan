/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.VulkanPackage;

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
 * @see org.sheepy.lily.vulkan.model.process.ProcessFactory
 * @model kind="package"
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
	String eNS_URI = "org.sheepy.lily.vulkan.model.process";

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
	ProcessPackage eINSTANCE = org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getAbstractProcess()
	 * @generated
	 */
	int ABSTRACT_PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__RESOURCE_PKG = VulkanPackage.IPROCESS__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__DESCRIPTOR_PKG = VulkanPackage.IPROCESS__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__NAME = VulkanPackage.IPROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__ENABLED = VulkanPackage.IPROCESS__ENABLED;

	/**
	 * The feature id for the '<em><b>Queue Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__QUEUE_PRIORITY = VulkanPackage.IPROCESS__QUEUE_PRIORITY;

	/**
	 * The feature id for the '<em><b>Cadence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__CADENCE = VulkanPackage.IPROCESS__CADENCE;

	/**
	 * The feature id for the '<em><b>Descriptor Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__DESCRIPTOR_POOL = VulkanPackage.IPROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Waiting Fence During Acquire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE = VulkanPackage.IPROCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__RESET_ALLOWED = VulkanPackage.IPROCESS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__EXTENSION_PKG = VulkanPackage.IPROCESS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Execution Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__EXECUTION_MANAGER = VulkanPackage.IPROCESS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_FEATURE_COUNT = VulkanPackage.IPROCESS_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_OPERATION_COUNT = VulkanPackage.IPROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelinePkgImpl <em>Pipeline Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PipelinePkgImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipelinePkg()
	 * @generated
	 */
	int PIPELINE_PKG = 1;

	/**
	 * The feature id for the '<em><b>Pipelines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_PKG__PIPELINES = 0;

	/**
	 * The number of structural features of the '<em>Pipeline Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Pipeline Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.IPipelineTask <em>IPipeline Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineTask
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIPipelineTask()
	 * @generated
	 */
	int IPIPELINE_TASK = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_TASK__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_TASK__ENABLED = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IPipeline Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_TASK_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>IPipeline Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_TASK_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl <em>Abstract Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getAbstractPipeline()
	 * @generated
	 */
	int ABSTRACT_PIPELINE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__ENABLED = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.TaskPipelineImpl <em>Task Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.TaskPipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getTaskPipeline()
	 * @generated
	 */
	int TASK_PIPELINE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PIPELINE__NAME = ABSTRACT_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PIPELINE__ENABLED = ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PIPELINE__RESOURCE_PKG = ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PIPELINE__DESCRIPTOR_PKG = ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Task Pkgs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PIPELINE__TASK_PKGS = ABSTRACT_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Task Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PIPELINE_FEATURE_COUNT = ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Task Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PIPELINE_OPERATION_COUNT = ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.VkPipelineImpl <em>Vk Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.VkPipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getVkPipeline()
	 * @generated
	 */
	int VK_PIPELINE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__NAME = TASK_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__ENABLED = TASK_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__RESOURCE_PKG = TASK_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__DESCRIPTOR_PKG = TASK_PIPELINE__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkgs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__TASK_PKGS = TASK_PIPELINE__TASK_PKGS;

	/**
	 * The feature id for the '<em><b>Descriptor Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__DESCRIPTOR_POOL = TASK_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__SPECIALIZATION_DATA = TASK_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__PUSH_CONSTANT_RANGES = TASK_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE__LAYOUT = TASK_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Vk Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE_FEATURE_COUNT = TASK_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Vk Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VK_PIPELINE_OPERATION_COUNT = TASK_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.TaskPkgImpl <em>Task Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.TaskPkgImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getTaskPkg()
	 * @generated
	 */
	int TASK_PKG = 6;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PKG__TASKS = 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PKG__STAGE = 1;

	/**
	 * The number of structural features of the '<em>Task Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PKG_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Task Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl <em>Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipeline()
	 * @generated
	 */
	int PIPELINE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__NAME = TASK_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__ENABLED = TASK_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__RESOURCE_PKG = TASK_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__DESCRIPTOR_PKG = TASK_PIPELINE__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkgs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__TASK_PKGS = TASK_PIPELINE__TASK_PKGS;

	/**
	 * The number of structural features of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_FEATURE_COUNT = TASK_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_OPERATION_COUNT = TASK_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.CompositePipelineImpl <em>Composite Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.CompositePipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getCompositePipeline()
	 * @generated
	 */
	int COMPOSITE_PIPELINE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PIPELINE__NAME = ABSTRACT_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PIPELINE__ENABLED = ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Pipelines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PIPELINE__PIPELINES = ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PIPELINE__REPEAT = ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PIPELINE_FEATURE_COUNT = ABSTRACT_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PIPELINE_OPERATION_COUNT = ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBarrier()
	 * @generated
	 */
	int PIPELINE_BARRIER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__NAME = IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__ENABLED = IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Barriers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__BARRIERS = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__SRC_STAGE = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__DST_STAGE = IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Src Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__SRC_QUEUE = IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dst Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__DST_QUEUE = IPIPELINE_TASK_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_OPERATION_COUNT = IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl <em>Composite Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getCompositeTask()
	 * @generated
	 */
	int COMPOSITE_TASK = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TASK__NAME = IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TASK__ENABLED = IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TASK__MAINTAINER = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Repeat Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TASK__REPEAT_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TASK__TASKS = IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TASK_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Composite Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TASK_OPERATION_COUNT = IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl <em>Bind Descriptor Sets</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getBindDescriptorSets()
	 * @generated
	 */
	int BIND_DESCRIPTOR_SETS = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_DESCRIPTOR_SETS__NAME = IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_DESCRIPTOR_SETS__ENABLED = IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Descriptor Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bind Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_DESCRIPTOR_SETS__BIND_POINT = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stride</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_DESCRIPTOR_SETS__STRIDE = IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bind Descriptor Sets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_DESCRIPTOR_SETS_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Bind Descriptor Sets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_DESCRIPTOR_SETS_OPERATION_COUNT = IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl <em>Push Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPushConstant()
	 * @generated
	 */
	int PUSH_CONSTANT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT__NAME = IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT__ENABLED = IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT__STAGES = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Push Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Push Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_OPERATION_COUNT = IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PushConstantBufferImpl <em>Push Constant Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PushConstantBufferImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPushConstantBuffer()
	 * @generated
	 */
	int PUSH_CONSTANT_BUFFER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_BUFFER__NAME = PUSH_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_BUFFER__ENABLED = PUSH_CONSTANT__ENABLED;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_BUFFER__STAGES = PUSH_CONSTANT__STAGES;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_BUFFER__BUFFER = PUSH_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Push Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_BUFFER_FEATURE_COUNT = PUSH_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Push Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_BUFFER_OPERATION_COUNT = PUSH_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl <em>Flush Transfer Buffer Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getFlushTransferBufferTask()
	 * @generated
	 */
	int FLUSH_TRANSFER_BUFFER_TASK = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLUSH_TRANSFER_BUFFER_TASK__NAME = IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLUSH_TRANSFER_BUFFER_TASK__ENABLED = IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Flush Transfer Buffer Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLUSH_TRANSFER_BUFFER_TASK_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Flush Transfer Buffer Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLUSH_TRANSFER_BUFFER_TASK_OPERATION_COUNT = IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl <em>Copy Buffer Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getCopyBufferTask()
	 * @generated
	 */
	int COPY_BUFFER_TASK = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK__NAME = IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK__ENABLED = IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Src Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK__SRC_BUFFER = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dst Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK__DST_BUFFER = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Copy Buffer Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Copy Buffer Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK_OPERATION_COUNT = IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.IProcessExtension <em>IProcess Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.IProcessExtension
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIProcessExtension()
	 * @generated
	 */
	int IPROCESS_EXTENSION = 16;

	/**
	 * The number of structural features of the '<em>IProcess Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_EXTENSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IProcess Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_EXTENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.ProcessExtensionPkgImpl <em>Extension Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessExtensionPkgImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessExtensionPkg()
	 * @generated
	 */
	int PROCESS_EXTENSION_PKG = 17;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXTENSION_PKG__EXTENSIONS = 0;

	/**
	 * The number of structural features of the '<em>Extension Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXTENSION_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Extension Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXTENSION_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PrepareCompositeTransferImpl <em>Prepare Composite Transfer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PrepareCompositeTransferImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPrepareCompositeTransfer()
	 * @generated
	 */
	int PREPARE_COMPOSITE_TRANSFER = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER__NAME = IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER__ENABLED = IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER__COMPOSITE_BUFFER = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER__MODE = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prepare During Update</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER__PREPARE_DURING_UPDATE = IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Buffer Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER__BUFFER_REFERENCE = IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER__TRANSFER_BUFFER = IPIPELINE_TASK_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Prepare Composite Transfer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Prepare Composite Transfer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER_OPERATION_COUNT = IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.SwapBindingsTaskImpl <em>Swap Bindings Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.SwapBindingsTaskImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getSwapBindingsTask()
	 * @generated
	 */
	int SWAP_BINDINGS_TASK = 19;

	/**
	 * The feature id for the '<em><b>Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_BINDINGS_TASK__TASK = CadencePackage.ICADENCE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_BINDINGS_TASK__DESCRIPTOR_SETS = CadencePackage.ICADENCE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Swap Bindings Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_BINDINGS_TASK_FEATURE_COUNT = CadencePackage.ICADENCE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Swap Bindings Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWAP_BINDINGS_TASK_OPERATION_COUNT = CadencePackage.ICADENCE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.ProcessConfiguration <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.ProcessConfiguration
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessConfiguration()
	 * @generated
	 */
	int PROCESS_CONFIGURATION = 20;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl <em>Execution Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessExecutionManager()
	 * @generated
	 */
	int PROCESS_EXECUTION_MANAGER = 21;

	/**
	 * The feature id for the '<em><b>Wait For Execution</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION = 0;

	/**
	 * The feature id for the '<em><b>Waited By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXECUTION_MANAGER__WAITED_BY = 1;

	/**
	 * The feature id for the '<em><b>Wait Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXECUTION_MANAGER__WAIT_STAGE = 2;

	/**
	 * The number of structural features of the '<em>Execution Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXECUTION_MANAGER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Execution Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_EXECUTION_MANAGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.ExecutionRecorder <em>Execution Recorder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.ExecutionRecorder
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getExecutionRecorder()
	 * @generated
	 */
	int EXECUTION_RECORDER = 22;

	/**
	 * The number of structural features of the '<em>Execution Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_RECORDER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Execution Recorder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_RECORDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl <em>Fetch Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getFetchBuffer()
	 * @generated
	 */
	int FETCH_BUFFER = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH_BUFFER__NAME = IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH_BUFFER__ENABLED = IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Buffer Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH_BUFFER__BUFFER_REFERENCE = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH_BUFFER__DATA_PROVIDER = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fetch Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH_BUFFER_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Fetch Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FETCH_BUFFER_OPERATION_COUNT = IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess
	 * @generated
	 */
	EClass getAbstractProcess();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorPool <em>Descriptor Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor Pool</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorPool()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_DescriptorPool();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isWaitingFenceDuringAcquire <em>Waiting Fence During Acquire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Waiting Fence During Acquire</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#isWaitingFenceDuringAcquire()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EAttribute getAbstractProcess_WaitingFenceDuringAcquire();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isResetAllowed <em>Reset Allowed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Allowed</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#isResetAllowed()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EAttribute getAbstractProcess_ResetAllowed();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getExtensionPkg <em>Extension Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getExtensionPkg()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_ExtensionPkg();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getExecutionManager <em>Execution Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Execution Manager</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getExecutionManager()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_ExecutionManager();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.PipelinePkg <em>Pipeline Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelinePkg
	 * @generated
	 */
	EClass getPipelinePkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.PipelinePkg#getPipelines <em>Pipelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pipelines</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelinePkg#getPipelines()
	 * @see #getPipelinePkg()
	 * @generated
	 */
	EReference getPipelinePkg_Pipelines();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.IPipelineTask <em>IPipeline Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPipeline Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineTask
	 * @generated
	 */
	EClass getIPipelineTask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.IPipelineTask#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineTask#isEnabled()
	 * @see #getIPipelineTask()
	 * @generated
	 */
	EAttribute getIPipelineTask_Enabled();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline <em>Abstract Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractPipeline
	 * @generated
	 */
	EClass getAbstractPipeline();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractPipeline#isEnabled()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EAttribute getAbstractPipeline_Enabled();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.TaskPipeline <em>Task Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.TaskPipeline
	 * @generated
	 */
	EClass getTaskPipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.TaskPipeline#getTaskPkgs <em>Task Pkgs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Pkgs</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.TaskPipeline#getTaskPkgs()
	 * @see #getTaskPipeline()
	 * @generated
	 */
	EReference getTaskPipeline_TaskPkgs();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.VkPipeline <em>Vk Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vk Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.VkPipeline
	 * @generated
	 */
	EClass getVkPipeline();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getDescriptorPool <em>Descriptor Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor Pool</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.VkPipeline#getDescriptorPool()
	 * @see #getVkPipeline()
	 * @generated
	 */
	EReference getVkPipeline_DescriptorPool();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getSpecializationData <em>Specialization Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specialization Data</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.VkPipeline#getSpecializationData()
	 * @see #getVkPipeline()
	 * @generated
	 */
	EReference getVkPipeline_SpecializationData();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getPushConstantRanges <em>Push Constant Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Push Constant Ranges</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.VkPipeline#getPushConstantRanges()
	 * @see #getVkPipeline()
	 * @generated
	 */
	EReference getVkPipeline_PushConstantRanges();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.VkPipeline#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.VkPipeline#getLayout()
	 * @see #getVkPipeline()
	 * @generated
	 */
	EReference getVkPipeline_Layout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.TaskPkg <em>Task Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.TaskPkg
	 * @generated
	 */
	EClass getTaskPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.TaskPkg#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.TaskPkg#getTasks()
	 * @see #getTaskPkg()
	 * @generated
	 */
	EReference getTaskPkg_Tasks();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.TaskPkg#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.TaskPkg#getStage()
	 * @see #getTaskPkg()
	 * @generated
	 */
	EAttribute getTaskPkg_Stage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.Pipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.Pipeline
	 * @generated
	 */
	EClass getPipeline();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.CompositePipeline <em>Composite Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CompositePipeline
	 * @generated
	 */
	EClass getCompositePipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.CompositePipeline#getPipelines <em>Pipelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pipelines</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CompositePipeline#getPipelines()
	 * @see #getCompositePipeline()
	 * @generated
	 */
	EReference getCompositePipeline_Pipelines();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.CompositePipeline#getRepeat <em>Repeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeat</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CompositePipeline#getRepeat()
	 * @see #getCompositePipeline()
	 * @generated
	 */
	EAttribute getCompositePipeline_Repeat();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier <em>Pipeline Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelineBarrier
	 * @generated
	 */
	EClass getPipelineBarrier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getBarriers <em>Barriers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Barriers</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelineBarrier#getBarriers()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EReference getPipelineBarrier_Barriers();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcStage <em>Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcStage()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EAttribute getPipelineBarrier_SrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstStage <em>Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstStage()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EAttribute getPipelineBarrier_DstStage();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcQueue <em>Src Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src Queue</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelineBarrier#getSrcQueue()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EReference getPipelineBarrier_SrcQueue();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstQueue <em>Dst Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dst Queue</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelineBarrier#getDstQueue()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EReference getPipelineBarrier_DstQueue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.CompositeTask <em>Composite Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CompositeTask
	 * @generated
	 */
	EClass getCompositeTask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.CompositeTask#getRepeatCount <em>Repeat Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeat Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CompositeTask#getRepeatCount()
	 * @see #getCompositeTask()
	 * @generated
	 */
	EAttribute getCompositeTask_RepeatCount();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.CompositeTask#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CompositeTask#getTasks()
	 * @see #getCompositeTask()
	 * @generated
	 */
	EReference getCompositeTask_Tasks();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets <em>Bind Descriptor Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bind Descriptor Sets</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.BindDescriptorSets
	 * @generated
	 */
	EClass getBindDescriptorSets();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getDescriptorSets <em>Descriptor Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptor Sets</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getDescriptorSets()
	 * @see #getBindDescriptorSets()
	 * @generated
	 */
	EReference getBindDescriptorSets_DescriptorSets();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getBindPoint <em>Bind Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bind Point</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getBindPoint()
	 * @see #getBindDescriptorSets()
	 * @generated
	 */
	EAttribute getBindDescriptorSets_BindPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getStride <em>Stride</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stride</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getStride()
	 * @see #getBindDescriptorSets()
	 * @generated
	 */
	EAttribute getBindDescriptorSets_Stride();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.PushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Constant</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PushConstant
	 * @generated
	 */
	EClass getPushConstant();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.process.PushConstant#getStages <em>Stages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stages</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PushConstant#getStages()
	 * @see #getPushConstant()
	 * @generated
	 */
	EAttribute getPushConstant_Stages();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.PushConstantBuffer <em>Push Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Constant Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PushConstantBuffer
	 * @generated
	 */
	EClass getPushConstantBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.PushConstantBuffer#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PushConstantBuffer#getBuffer()
	 * @see #getPushConstantBuffer()
	 * @generated
	 */
	EReference getPushConstantBuffer_Buffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask <em>Flush Transfer Buffer Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flush Transfer Buffer Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask
	 * @generated
	 */
	EClass getFlushTransferBufferTask();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#getTransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#getTransferBuffer()
	 * @see #getFlushTransferBufferTask()
	 * @generated
	 */
	EReference getFlushTransferBufferTask_TransferBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask <em>Copy Buffer Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copy Buffer Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CopyBufferTask
	 * @generated
	 */
	EClass getCopyBufferTask();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSrcBuffer <em>Src Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Src Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSrcBuffer()
	 * @see #getCopyBufferTask()
	 * @generated
	 */
	EReference getCopyBufferTask_SrcBuffer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getDstBuffer <em>Dst Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dst Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CopyBufferTask#getDstBuffer()
	 * @see #getCopyBufferTask()
	 * @generated
	 */
	EReference getCopyBufferTask_DstBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.IProcessExtension <em>IProcess Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProcess Extension</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IProcessExtension
	 * @generated
	 */
	EClass getIProcessExtension();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg <em>Extension Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg
	 * @generated
	 */
	EClass getProcessExtensionPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg#getExtensions()
	 * @see #getProcessExtensionPkg()
	 * @generated
	 */
	EReference getProcessExtensionPkg_Extensions();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer <em>Prepare Composite Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prepare Composite Transfer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer
	 * @generated
	 */
	EClass getPrepareCompositeTransfer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getCompositeBuffer <em>Composite Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getCompositeBuffer()
	 * @see #getPrepareCompositeTransfer()
	 * @generated
	 */
	EReference getPrepareCompositeTransfer_CompositeBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getMode()
	 * @see #getPrepareCompositeTransfer()
	 * @generated
	 */
	EAttribute getPrepareCompositeTransfer_Mode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#isPrepareDuringUpdate <em>Prepare During Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prepare During Update</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#isPrepareDuringUpdate()
	 * @see #getPrepareCompositeTransfer()
	 * @generated
	 */
	EAttribute getPrepareCompositeTransfer_PrepareDuringUpdate();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getBufferReference <em>Buffer Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getBufferReference()
	 * @see #getPrepareCompositeTransfer()
	 * @generated
	 */
	EReference getPrepareCompositeTransfer_BufferReference();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getTransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getTransferBuffer()
	 * @see #getPrepareCompositeTransfer()
	 * @generated
	 */
	EReference getPrepareCompositeTransfer_TransferBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.SwapBindingsTask <em>Swap Bindings Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Swap Bindings Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.SwapBindingsTask
	 * @generated
	 */
	EClass getSwapBindingsTask();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.SwapBindingsTask#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.SwapBindingsTask#getTask()
	 * @see #getSwapBindingsTask()
	 * @generated
	 */
	EReference getSwapBindingsTask_Task();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.SwapBindingsTask#getDescriptorSets <em>Descriptor Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptor Sets</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.SwapBindingsTask#getDescriptorSets()
	 * @see #getSwapBindingsTask()
	 * @generated
	 */
	EReference getSwapBindingsTask_DescriptorSets();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.ProcessConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessConfiguration
	 * @generated
	 */
	EClass getProcessConfiguration();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager <em>Execution Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Manager</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExecutionManager
	 * @generated
	 */
	EClass getProcessExecutionManager();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitForExecution <em>Wait For Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Wait For Execution</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitForExecution()
	 * @see #getProcessExecutionManager()
	 * @generated
	 */
	EReference getProcessExecutionManager_WaitForExecution();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitedBy <em>Waited By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Waited By</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitedBy()
	 * @see #getProcessExecutionManager()
	 * @generated
	 */
	EReference getProcessExecutionManager_WaitedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitStage <em>Wait Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wait Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessExecutionManager#getWaitStage()
	 * @see #getProcessExecutionManager()
	 * @generated
	 */
	EAttribute getProcessExecutionManager_WaitStage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.ExecutionRecorder <em>Execution Recorder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Recorder</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ExecutionRecorder
	 * @generated
	 */
	EClass getExecutionRecorder();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.FetchBuffer <em>Fetch Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fetch Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.FetchBuffer
	 * @generated
	 */
	EClass getFetchBuffer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.FetchBuffer#getBufferReference <em>Buffer Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.FetchBuffer#getBufferReference()
	 * @see #getFetchBuffer()
	 * @generated
	 */
	EReference getFetchBuffer_BufferReference();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.FetchBuffer#getDataProvider <em>Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.FetchBuffer#getDataProvider()
	 * @see #getFetchBuffer()
	 * @generated
	 */
	EReference getFetchBuffer_DataProvider();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getAbstractProcess()
		 * @generated
		 */
		EClass ABSTRACT_PROCESS = eINSTANCE.getAbstractProcess();

		/**
		 * The meta object literal for the '<em><b>Descriptor Pool</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__DESCRIPTOR_POOL = eINSTANCE.getAbstractProcess_DescriptorPool();

		/**
		 * The meta object literal for the '<em><b>Waiting Fence During Acquire</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE = eINSTANCE.getAbstractProcess_WaitingFenceDuringAcquire();

		/**
		 * The meta object literal for the '<em><b>Reset Allowed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PROCESS__RESET_ALLOWED = eINSTANCE.getAbstractProcess_ResetAllowed();

		/**
		 * The meta object literal for the '<em><b>Extension Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__EXTENSION_PKG = eINSTANCE.getAbstractProcess_ExtensionPkg();

		/**
		 * The meta object literal for the '<em><b>Execution Manager</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__EXECUTION_MANAGER = eINSTANCE.getAbstractProcess_ExecutionManager();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelinePkgImpl <em>Pipeline Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.PipelinePkgImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipelinePkg()
		 * @generated
		 */
		EClass PIPELINE_PKG = eINSTANCE.getPipelinePkg();

		/**
		 * The meta object literal for the '<em><b>Pipelines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_PKG__PIPELINES = eINSTANCE.getPipelinePkg_Pipelines();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.IPipelineTask <em>IPipeline Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.IPipelineTask
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIPipelineTask()
		 * @generated
		 */
		EClass IPIPELINE_TASK = eINSTANCE.getIPipelineTask();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPIPELINE_TASK__ENABLED = eINSTANCE.getIPipelineTask_Enabled();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl <em>Abstract Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getAbstractPipeline()
		 * @generated
		 */
		EClass ABSTRACT_PIPELINE = eINSTANCE.getAbstractPipeline();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PIPELINE__ENABLED = eINSTANCE.getAbstractPipeline_Enabled();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.TaskPipelineImpl <em>Task Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.TaskPipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getTaskPipeline()
		 * @generated
		 */
		EClass TASK_PIPELINE = eINSTANCE.getTaskPipeline();

		/**
		 * The meta object literal for the '<em><b>Task Pkgs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_PIPELINE__TASK_PKGS = eINSTANCE.getTaskPipeline_TaskPkgs();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.VkPipelineImpl <em>Vk Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.VkPipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getVkPipeline()
		 * @generated
		 */
		EClass VK_PIPELINE = eINSTANCE.getVkPipeline();

		/**
		 * The meta object literal for the '<em><b>Descriptor Pool</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VK_PIPELINE__DESCRIPTOR_POOL = eINSTANCE.getVkPipeline_DescriptorPool();

		/**
		 * The meta object literal for the '<em><b>Specialization Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VK_PIPELINE__SPECIALIZATION_DATA = eINSTANCE.getVkPipeline_SpecializationData();

		/**
		 * The meta object literal for the '<em><b>Push Constant Ranges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VK_PIPELINE__PUSH_CONSTANT_RANGES = eINSTANCE.getVkPipeline_PushConstantRanges();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VK_PIPELINE__LAYOUT = eINSTANCE.getVkPipeline_Layout();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.TaskPkgImpl <em>Task Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.TaskPkgImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getTaskPkg()
		 * @generated
		 */
		EClass TASK_PKG = eINSTANCE.getTaskPkg();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_PKG__TASKS = eINSTANCE.getTaskPkg_Tasks();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_PKG__STAGE = eINSTANCE.getTaskPkg_Stage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl <em>Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.PipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipeline()
		 * @generated
		 */
		EClass PIPELINE = eINSTANCE.getPipeline();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.CompositePipelineImpl <em>Composite Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.CompositePipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getCompositePipeline()
		 * @generated
		 */
		EClass COMPOSITE_PIPELINE = eINSTANCE.getCompositePipeline();

		/**
		 * The meta object literal for the '<em><b>Pipelines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PIPELINE__PIPELINES = eINSTANCE.getCompositePipeline_Pipelines();

		/**
		 * The meta object literal for the '<em><b>Repeat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_PIPELINE__REPEAT = eINSTANCE.getCompositePipeline_Repeat();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBarrier()
		 * @generated
		 */
		EClass PIPELINE_BARRIER = eINSTANCE.getPipelineBarrier();

		/**
		 * The meta object literal for the '<em><b>Barriers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_BARRIER__BARRIERS = eINSTANCE.getPipelineBarrier_Barriers();

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
		 * The meta object literal for the '<em><b>Src Queue</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_BARRIER__SRC_QUEUE = eINSTANCE.getPipelineBarrier_SrcQueue();

		/**
		 * The meta object literal for the '<em><b>Dst Queue</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_BARRIER__DST_QUEUE = eINSTANCE.getPipelineBarrier_DstQueue();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl <em>Composite Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getCompositeTask()
		 * @generated
		 */
		EClass COMPOSITE_TASK = eINSTANCE.getCompositeTask();

		/**
		 * The meta object literal for the '<em><b>Repeat Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_TASK__REPEAT_COUNT = eINSTANCE.getCompositeTask_RepeatCount();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_TASK__TASKS = eINSTANCE.getCompositeTask_Tasks();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl <em>Bind Descriptor Sets</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getBindDescriptorSets()
		 * @generated
		 */
		EClass BIND_DESCRIPTOR_SETS = eINSTANCE.getBindDescriptorSets();

		/**
		 * The meta object literal for the '<em><b>Descriptor Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS = eINSTANCE.getBindDescriptorSets_DescriptorSets();

		/**
		 * The meta object literal for the '<em><b>Bind Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIND_DESCRIPTOR_SETS__BIND_POINT = eINSTANCE.getBindDescriptorSets_BindPoint();

		/**
		 * The meta object literal for the '<em><b>Stride</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIND_DESCRIPTOR_SETS__STRIDE = eINSTANCE.getBindDescriptorSets_Stride();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl <em>Push Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPushConstant()
		 * @generated
		 */
		EClass PUSH_CONSTANT = eINSTANCE.getPushConstant();

		/**
		 * The meta object literal for the '<em><b>Stages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_CONSTANT__STAGES = eINSTANCE.getPushConstant_Stages();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.PushConstantBufferImpl <em>Push Constant Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.PushConstantBufferImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPushConstantBuffer()
		 * @generated
		 */
		EClass PUSH_CONSTANT_BUFFER = eINSTANCE.getPushConstantBuffer();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PUSH_CONSTANT_BUFFER__BUFFER = eINSTANCE.getPushConstantBuffer_Buffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl <em>Flush Transfer Buffer Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getFlushTransferBufferTask()
		 * @generated
		 */
		EClass FLUSH_TRANSFER_BUFFER_TASK = eINSTANCE.getFlushTransferBufferTask();

		/**
		 * The meta object literal for the '<em><b>Transfer Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER = eINSTANCE.getFlushTransferBufferTask_TransferBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl <em>Copy Buffer Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getCopyBufferTask()
		 * @generated
		 */
		EClass COPY_BUFFER_TASK = eINSTANCE.getCopyBufferTask();

		/**
		 * The meta object literal for the '<em><b>Src Buffer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COPY_BUFFER_TASK__SRC_BUFFER = eINSTANCE.getCopyBufferTask_SrcBuffer();

		/**
		 * The meta object literal for the '<em><b>Dst Buffer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COPY_BUFFER_TASK__DST_BUFFER = eINSTANCE.getCopyBufferTask_DstBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.IProcessExtension <em>IProcess Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.IProcessExtension
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIProcessExtension()
		 * @generated
		 */
		EClass IPROCESS_EXTENSION = eINSTANCE.getIProcessExtension();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.ProcessExtensionPkgImpl <em>Extension Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessExtensionPkgImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessExtensionPkg()
		 * @generated
		 */
		EClass PROCESS_EXTENSION_PKG = eINSTANCE.getProcessExtensionPkg();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_EXTENSION_PKG__EXTENSIONS = eINSTANCE.getProcessExtensionPkg_Extensions();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.PrepareCompositeTransferImpl <em>Prepare Composite Transfer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.PrepareCompositeTransferImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPrepareCompositeTransfer()
		 * @generated
		 */
		EClass PREPARE_COMPOSITE_TRANSFER = eINSTANCE.getPrepareCompositeTransfer();

		/**
		 * The meta object literal for the '<em><b>Composite Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREPARE_COMPOSITE_TRANSFER__COMPOSITE_BUFFER = eINSTANCE.getPrepareCompositeTransfer_CompositeBuffer();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREPARE_COMPOSITE_TRANSFER__MODE = eINSTANCE.getPrepareCompositeTransfer_Mode();

		/**
		 * The meta object literal for the '<em><b>Prepare During Update</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREPARE_COMPOSITE_TRANSFER__PREPARE_DURING_UPDATE = eINSTANCE.getPrepareCompositeTransfer_PrepareDuringUpdate();

		/**
		 * The meta object literal for the '<em><b>Buffer Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREPARE_COMPOSITE_TRANSFER__BUFFER_REFERENCE = eINSTANCE.getPrepareCompositeTransfer_BufferReference();

		/**
		 * The meta object literal for the '<em><b>Transfer Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREPARE_COMPOSITE_TRANSFER__TRANSFER_BUFFER = eINSTANCE.getPrepareCompositeTransfer_TransferBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.SwapBindingsTaskImpl <em>Swap Bindings Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.SwapBindingsTaskImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getSwapBindingsTask()
		 * @generated
		 */
		EClass SWAP_BINDINGS_TASK = eINSTANCE.getSwapBindingsTask();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWAP_BINDINGS_TASK__TASK = eINSTANCE.getSwapBindingsTask_Task();

		/**
		 * The meta object literal for the '<em><b>Descriptor Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWAP_BINDINGS_TASK__DESCRIPTOR_SETS = eINSTANCE.getSwapBindingsTask_DescriptorSets();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.ProcessConfiguration <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.ProcessConfiguration
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessConfiguration()
		 * @generated
		 */
		EClass PROCESS_CONFIGURATION = eINSTANCE.getProcessConfiguration();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl <em>Execution Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessExecutionManager()
		 * @generated
		 */
		EClass PROCESS_EXECUTION_MANAGER = eINSTANCE.getProcessExecutionManager();

		/**
		 * The meta object literal for the '<em><b>Wait For Execution</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION = eINSTANCE.getProcessExecutionManager_WaitForExecution();

		/**
		 * The meta object literal for the '<em><b>Waited By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_EXECUTION_MANAGER__WAITED_BY = eINSTANCE.getProcessExecutionManager_WaitedBy();

		/**
		 * The meta object literal for the '<em><b>Wait Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_EXECUTION_MANAGER__WAIT_STAGE = eINSTANCE.getProcessExecutionManager_WaitStage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.ExecutionRecorder <em>Execution Recorder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.ExecutionRecorder
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getExecutionRecorder()
		 * @generated
		 */
		EClass EXECUTION_RECORDER = eINSTANCE.getExecutionRecorder();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl <em>Fetch Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getFetchBuffer()
		 * @generated
		 */
		EClass FETCH_BUFFER = eINSTANCE.getFetchBuffer();

		/**
		 * The meta object literal for the '<em><b>Buffer Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FETCH_BUFFER__BUFFER_REFERENCE = eINSTANCE.getFetchBuffer_BufferReference();

		/**
		 * The meta object literal for the '<em><b>Data Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FETCH_BUFFER__DATA_PROVIDER = eINSTANCE.getFetchBuffer_DataProvider();

	}

} //ProcessPackage
