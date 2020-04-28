/**
 */
package org.sheepy.lily.vulkan.model.process.compute;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeFactory
 * @model kind="package"
 * @generated
 */
public interface ComputePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "compute";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.model.process.compute";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "compute";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComputePackage eINSTANCE = org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl
	 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl#getComputeProcess()
	 * @generated
	 */
	int COMPUTE_PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__RESOURCE_PKG = ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__DESCRIPTOR_PKG = ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__NAME = ProcessPackage.ABSTRACT_PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__ENABLED = ProcessPackage.ABSTRACT_PROCESS__ENABLED;

	/**
	 * The feature id for the '<em><b>Queue Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__QUEUE_PRIORITY = ProcessPackage.ABSTRACT_PROCESS__QUEUE_PRIORITY;

	/**
	 * The feature id for the '<em><b>Cadence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__CADENCE = ProcessPackage.ABSTRACT_PROCESS__CADENCE;

	/**
	 * The feature id for the '<em><b>Descriptor Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__DESCRIPTOR_POOL = ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_POOL;

	/**
	 * The feature id for the '<em><b>Waiting Fence During Acquire</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__WAITING_FENCE_DURING_ACQUIRE = ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__RESET_ALLOWED = ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED;

	/**
	 * The feature id for the '<em><b>Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__SIGNALS = ProcessPackage.ABSTRACT_PROCESS__SIGNALS;

	/**
	 * The feature id for the '<em><b>Wait For</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__WAIT_FOR = ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR;

	/**
	 * The feature id for the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__EXTENSION_PKG = ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG;

	/**
	 * The feature id for the '<em><b>Pipeline Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__PIPELINE_PKG = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__SOURCE_ENGINE = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_FEATURE_COUNT = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_OPERATION_COUNT = ProcessPackage.ABSTRACT_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputePipelineImpl <em>Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputePipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl#getComputePipeline()
	 * @generated
	 */
	int COMPUTE_PIPELINE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__NAME = ProcessPackage.VK_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__ENABLED = ProcessPackage.VK_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__STAGE = ProcessPackage.VK_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__RESOURCE_PKG = ProcessPackage.VK_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__DESCRIPTOR_PKG = ProcessPackage.VK_PIPELINE__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__TASK_PKG = ProcessPackage.VK_PIPELINE__TASK_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__DESCRIPTOR_POOL = ProcessPackage.VK_PIPELINE__DESCRIPTOR_POOL;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__SPECIALIZATION_DATA = ProcessPackage.VK_PIPELINE__SPECIALIZATION_DATA;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__PUSH_CONSTANT_RANGES = ProcessPackage.VK_PIPELINE__PUSH_CONSTANT_RANGES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__LAYOUT = ProcessPackage.VK_PIPELINE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__MAINTAINER = ProcessPackage.VK_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__SHADER = ProcessPackage.VK_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE_FEATURE_COUNT = ProcessPackage.VK_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE_OPERATION_COUNT = ProcessPackage.VK_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.compute.impl.DispatchTaskImpl <em>Dispatch Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.compute.impl.DispatchTaskImpl
	 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl#getDispatchTask()
	 * @generated
	 */
	int DISPATCH_TASK = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TASK__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TASK__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Workgroup Count X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TASK__WORKGROUP_COUNT_X = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Workgroup Count Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TASK__WORKGROUP_COUNT_Y = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Workgroup Count Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TASK__WORKGROUP_COUNT_Z = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Dispatch Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TASK_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Dispatch Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_TASK_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeProcess
	 * @generated
	 */
	EClass getComputeProcess();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getPipelinePkg <em>Pipeline Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pipeline Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getPipelinePkg()
	 * @see #getComputeProcess()
	 * @generated
	 */
	EReference getComputeProcess_PipelinePkg();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getSourceEngine <em>Source Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Engine</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputeProcess#getSourceEngine()
	 * @see #getComputeProcess()
	 * @generated
	 */
	EReference getComputeProcess_SourceEngine();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePipeline
	 * @generated
	 */
	EClass getComputePipeline();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getShader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shader</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePipeline#getShader()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EReference getComputePipeline_Shader();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask <em>Dispatch Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.DispatchTask
	 * @generated
	 */
	EClass getDispatchTask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountX <em>Workgroup Count X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Count X</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountX()
	 * @see #getDispatchTask()
	 * @generated
	 */
	EAttribute getDispatchTask_WorkgroupCountX();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountY <em>Workgroup Count Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Count Y</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountY()
	 * @see #getDispatchTask()
	 * @generated
	 */
	EAttribute getDispatchTask_WorkgroupCountY();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountZ <em>Workgroup Count Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Count Z</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.compute.DispatchTask#getWorkgroupCountZ()
	 * @see #getDispatchTask()
	 * @generated
	 */
	EAttribute getDispatchTask_WorkgroupCountZ();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComputeFactory getComputeFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl
		 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl#getComputeProcess()
		 * @generated
		 */
		EClass COMPUTE_PROCESS = eINSTANCE.getComputeProcess();

		/**
		 * The meta object literal for the '<em><b>Pipeline Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_PROCESS__PIPELINE_PKG = eINSTANCE.getComputeProcess_PipelinePkg();

		/**
		 * The meta object literal for the '<em><b>Source Engine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_PROCESS__SOURCE_ENGINE = eINSTANCE.getComputeProcess_SourceEngine();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputePipelineImpl <em>Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputePipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl#getComputePipeline()
		 * @generated
		 */
		EClass COMPUTE_PIPELINE = eINSTANCE.getComputePipeline();

		/**
		 * The meta object literal for the '<em><b>Shader</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_PIPELINE__SHADER = eINSTANCE.getComputePipeline_Shader();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.compute.impl.DispatchTaskImpl <em>Dispatch Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.compute.impl.DispatchTaskImpl
		 * @see org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl#getDispatchTask()
		 * @generated
		 */
		EClass DISPATCH_TASK = eINSTANCE.getDispatchTask();

		/**
		 * The meta object literal for the '<em><b>Workgroup Count X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPATCH_TASK__WORKGROUP_COUNT_X = eINSTANCE.getDispatchTask_WorkgroupCountX();

		/**
		 * The meta object literal for the '<em><b>Workgroup Count Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPATCH_TASK__WORKGROUP_COUNT_Y = eINSTANCE.getDispatchTask_WorkgroupCountY();

		/**
		 * The meta object literal for the '<em><b>Workgroup Count Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPATCH_TASK__WORKGROUP_COUNT_Z = eINSTANCE.getDispatchTask_WorkgroupCountZ();

	}

} //ComputePackage
