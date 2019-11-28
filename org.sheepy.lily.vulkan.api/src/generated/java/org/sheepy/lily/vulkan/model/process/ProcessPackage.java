/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.root.RootPackage;

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
	 * The feature id for the '<em><b>Waiting Fence During Acquire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE = VulkanPackage.IPROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__PART_PKG = VulkanPackage.IPROCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__RESET_ALLOWED = VulkanPackage.IPROCESS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__SIGNALS = VulkanPackage.IPROCESS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wait For</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__WAIT_FOR = VulkanPackage.IPROCESS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__EXTENSION_PKG = VulkanPackage.IPROCESS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_FEATURE_COUNT = VulkanPackage.IPROCESS_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_OPERATION_COUNT = VulkanPackage.IPROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.Configuration <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.Configuration
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getConfiguration()
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.ProcessPartPkgImpl <em>Part Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPartPkgImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessPartPkg()
	 * @generated
	 */
	int PROCESS_PART_PKG = 2;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_PART_PKG__PARTS = 0;

	/**
	 * The number of structural features of the '<em>Part Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_PART_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Part Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_PART_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.IPipelineTask <em>IPipeline Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineTask
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIPipelineTask()
	 * @generated
	 */
	int IPIPELINE_TASK = 3;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.IProcessPart <em>IProcess Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.IProcessPart
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIProcessPart()
	 * @generated
	 */
	int IPROCESS_PART = 4;

	/**
	 * The number of structural features of the '<em>IProcess Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_PART_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IProcess Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.IPipeline <em>IPipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIPipeline()
	 * @generated
	 */
	int IPIPELINE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__RESOURCE_PKG = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__DESCRIPTOR_PKG = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__ENABLED = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__STAGE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__PUSH_CONSTANT_RANGES = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__SPECIALIZATION_DATA = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__DESCRIPTOR_SET_PKG = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__TASK_PKG = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>IPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>IPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * The number of structural features of the '<em>Task Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PKG_FEATURE_COUNT = 1;

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
	int PIPELINE__NAME = IPIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__RESOURCE_PKG = IPIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__DESCRIPTOR_PKG = IPIPELINE__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__ENABLED = IPIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__STAGE = IPIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__PUSH_CONSTANT_RANGES = IPIPELINE__PUSH_CONSTANT_RANGES;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__SPECIALIZATION_DATA = IPIPELINE__SPECIALIZATION_DATA;

	/**
	 * The feature id for the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__DESCRIPTOR_SET_PKG = IPIPELINE__DESCRIPTOR_SET_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__TASK_PKG = IPIPELINE__TASK_PKG;

	/**
	 * The number of structural features of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_FEATURE_COUNT = IPIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_OPERATION_COUNT = IPIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBarrier()
	 * @generated
	 */
	int PIPELINE_BARRIER = 8;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__CONTENT_OBJECTS = RootPackage.LOBJECT__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__NAME = RootPackage.LOBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__ENABLED = RootPackage.LOBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Barriers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__BARRIERS = RootPackage.LOBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__SRC_STAGE = RootPackage.LOBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__DST_STAGE = RootPackage.LOBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Src Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__SRC_QUEUE = RootPackage.LOBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Dst Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__DST_QUEUE = RootPackage.LOBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_FEATURE_COUNT = RootPackage.LOBJECT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___LINFERENCE_OBJECT = RootPackage.LOBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___CREATE_CONTAINMENT_ELIST__ECLASS = RootPackage.LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___LCONTENTS = RootPackage.LOBJECT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___LPARENT = RootPackage.LOBJECT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___LALL_CONTENTS = RootPackage.LOBJECT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_OPERATION_COUNT = RootPackage.LOBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl <em>Composite Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getCompositeTask()
	 * @generated
	 */
	int COMPOSITE_TASK = 9;

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
	int BIND_DESCRIPTOR_SETS = 10;

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
	 * The number of structural features of the '<em>Bind Descriptor Sets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIND_DESCRIPTOR_SETS_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 2;

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
	int PUSH_CONSTANT = 11;

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
	int PUSH_CONSTANT_BUFFER = 12;

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
	int FLUSH_TRANSFER_BUFFER_TASK = 13;

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
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLUSH_TRANSFER_BUFFER_TASK__STAGE = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Flush Transfer Buffer Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLUSH_TRANSFER_BUFFER_TASK_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 2;

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
	int COPY_BUFFER_TASK = 14;

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
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK__STAGE = IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK__SIZE = IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Src Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK__SRC_BUFFER = IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dst Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK__DST_BUFFER = IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Copy Buffer Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_BUFFER_TASK_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 4;

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
	int IPROCESS_EXTENSION = 15;

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
	int PROCESS_EXTENSION_PKG = 16;

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
	int PREPARE_COMPOSITE_TRANSFER = 17;

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
	 * The feature id for the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER__INSTANCE = IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Prepare Composite Transfer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREPARE_COMPOSITE_TRANSFER_FEATURE_COUNT = IPIPELINE_TASK_FEATURE_COUNT + 3;

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
	int SWAP_BINDINGS_TASK = 18;

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess
	 * @generated
	 */
	EClass getAbstractProcess();

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
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getPartPkg <em>Part Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Part Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getPartPkg()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_PartPkg();

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
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getSignals <em>Signals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Signals</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getSignals()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_Signals();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getWaitFor <em>Wait For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Wait For</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getWaitFor()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_WaitFor();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.ProcessPartPkg <em>Part Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPartPkg
	 * @generated
	 */
	EClass getProcessPartPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.ProcessPartPkg#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPartPkg#getParts()
	 * @see #getProcessPartPkg()
	 * @generated
	 */
	EReference getProcessPartPkg_Parts();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.IProcessPart <em>IProcess Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProcess Part</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IProcessPart
	 * @generated
	 */
	EClass getIProcessPart();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.IPipeline <em>IPipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline
	 * @generated
	 */
	EClass getIPipeline();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.IPipeline#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline#isEnabled()
	 * @see #getIPipeline()
	 * @generated
	 */
	EAttribute getIPipeline_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline#getStage()
	 * @see #getIPipeline()
	 * @generated
	 */
	EAttribute getIPipeline_Stage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getPushConstantRanges <em>Push Constant Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Push Constant Ranges</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline#getPushConstantRanges()
	 * @see #getIPipeline()
	 * @generated
	 */
	EReference getIPipeline_PushConstantRanges();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getSpecializationData <em>Specialization Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specialization Data</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline#getSpecializationData()
	 * @see #getIPipeline()
	 * @generated
	 */
	EReference getIPipeline_SpecializationData();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor Set Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline#getDescriptorSetPkg()
	 * @see #getIPipeline()
	 * @generated
	 */
	EReference getIPipeline_DescriptorSetPkg();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.IPipeline#getTaskPkg <em>Task Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline#getTaskPkg()
	 * @see #getIPipeline()
	 * @generated
	 */
	EReference getIPipeline_TaskPkg();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.Pipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.Pipeline
	 * @generated
	 */
	EClass getPipeline();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#getStage()
	 * @see #getFlushTransferBufferTask()
	 * @generated
	 */
	EAttribute getFlushTransferBufferTask_Stage();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CopyBufferTask#getStage()
	 * @see #getCopyBufferTask()
	 * @generated
	 */
	EAttribute getCopyBufferTask_Stage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSize()
	 * @see #getCopyBufferTask()
	 * @generated
	 */
	EAttribute getCopyBufferTask_Size();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getInstance()
	 * @see #getPrepareCompositeTransfer()
	 * @generated
	 */
	EAttribute getPrepareCompositeTransfer_Instance();

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
		 * The meta object literal for the '<em><b>Waiting Fence During Acquire</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE = eINSTANCE.getAbstractProcess_WaitingFenceDuringAcquire();

		/**
		 * The meta object literal for the '<em><b>Part Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__PART_PKG = eINSTANCE.getAbstractProcess_PartPkg();

		/**
		 * The meta object literal for the '<em><b>Reset Allowed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PROCESS__RESET_ALLOWED = eINSTANCE.getAbstractProcess_ResetAllowed();

		/**
		 * The meta object literal for the '<em><b>Signals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__SIGNALS = eINSTANCE.getAbstractProcess_Signals();

		/**
		 * The meta object literal for the '<em><b>Wait For</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__WAIT_FOR = eINSTANCE.getAbstractProcess_WaitFor();

		/**
		 * The meta object literal for the '<em><b>Extension Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__EXTENSION_PKG = eINSTANCE.getAbstractProcess_ExtensionPkg();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.Configuration <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.Configuration
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.ProcessPartPkgImpl <em>Part Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPartPkgImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessPartPkg()
		 * @generated
		 */
		EClass PROCESS_PART_PKG = eINSTANCE.getProcessPartPkg();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_PART_PKG__PARTS = eINSTANCE.getProcessPartPkg_Parts();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.IProcessPart <em>IProcess Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.IProcessPart
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIProcessPart()
		 * @generated
		 */
		EClass IPROCESS_PART = eINSTANCE.getIProcessPart();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.IPipeline <em>IPipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.IPipeline
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIPipeline()
		 * @generated
		 */
		EClass IPIPELINE = eINSTANCE.getIPipeline();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPIPELINE__ENABLED = eINSTANCE.getIPipeline_Enabled();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPIPELINE__STAGE = eINSTANCE.getIPipeline_Stage();

		/**
		 * The meta object literal for the '<em><b>Push Constant Ranges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPIPELINE__PUSH_CONSTANT_RANGES = eINSTANCE.getIPipeline_PushConstantRanges();

		/**
		 * The meta object literal for the '<em><b>Specialization Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPIPELINE__SPECIALIZATION_DATA = eINSTANCE.getIPipeline_SpecializationData();

		/**
		 * The meta object literal for the '<em><b>Descriptor Set Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPIPELINE__DESCRIPTOR_SET_PKG = eINSTANCE.getIPipeline_DescriptorSetPkg();

		/**
		 * The meta object literal for the '<em><b>Task Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPIPELINE__TASK_PKG = eINSTANCE.getIPipeline_TaskPkg();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl <em>Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.PipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipeline()
		 * @generated
		 */
		EClass PIPELINE = eINSTANCE.getPipeline();

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
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLUSH_TRANSFER_BUFFER_TASK__STAGE = eINSTANCE.getFlushTransferBufferTask_Stage();

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
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COPY_BUFFER_TASK__STAGE = eINSTANCE.getCopyBufferTask_Stage();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COPY_BUFFER_TASK__SIZE = eINSTANCE.getCopyBufferTask_Size();

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
		 * The meta object literal for the '<em><b>Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREPARE_COMPOSITE_TRANSFER__INSTANCE = eINSTANCE.getPrepareCompositeTransfer_Instance();

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

	}

} //ProcessPackage
