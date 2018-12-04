/**
 */
package org.sheepy.vulkan.model.process.compute;

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
 * @see org.sheepy.vulkan.model.process.compute.ComputeFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/compute' publicConstructors='true' updateClasspath='false' basePackage='org.sheepy.vulkan.model.process'"
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
	String eNS_URI = "org.sheepy.vulkan.model.process.compute";

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
	ComputePackage eINSTANCE = org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputeProcessPoolImpl <em>Process Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputeProcessPoolImpl
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputeProcessPool()
	 * @generated
	 */
	int COMPUTE_PROCESS_POOL = 0;

	/**
	 * The feature id for the '<em><b>Descriptor Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL__DESCRIPTOR_SETS = ProcessPackage.ABSTRACT_PROCESS_POOL__DESCRIPTOR_SETS;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL__PROCESSES = ProcessPackage.ABSTRACT_PROCESS_POOL__PROCESSES;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL__RESOURCES = ProcessPackage.ABSTRACT_PROCESS_POOL__RESOURCES;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL__RESET_ALLOWED = ProcessPackage.ABSTRACT_PROCESS_POOL__RESET_ALLOWED;

	/**
	 * The number of structural features of the '<em>Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL_FEATURE_COUNT = ProcessPackage.ABSTRACT_PROCESS_POOL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Process Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_POOL_OPERATION_COUNT = ProcessPackage.ABSTRACT_PROCESS_POOL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputeProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputeProcessImpl
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputeProcess()
	 * @generated
	 */
	int COMPUTE_PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS__UNITS = ProcessPackage.ABSTRACT_PROCESS__UNITS;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_FEATURE_COUNT = ProcessPackage.ABSTRACT_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PROCESS_OPERATION_COUNT = ProcessPackage.ABSTRACT_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputePipelineImpl <em>Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePipelineImpl
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputePipeline()
	 * @generated
	 */
	int COMPUTE_PIPELINE = 2;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__ENABLED = ProcessPackage.ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__STAGE = ProcessPackage.ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__DESCRIPTOR_SET = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__PUSH_CONSTANT = ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__UNITS = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Workgroup Size X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__WORKGROUP_SIZE_X = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Workgroup Size Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__WORKGROUP_SIZE_Y = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Workgroup Size Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__WORKGROUP_SIZE_Z = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__WIDTH = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__HEIGHT = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE__DEPTH = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE_FEATURE_COUNT = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_PIPELINE_OPERATION_COUNT = ProcessPackage.ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.compute.IComputer <em>IComputer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.compute.IComputer
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getIComputer()
	 * @generated
	 */
	int ICOMPUTER = 3;

	/**
	 * The number of structural features of the '<em>IComputer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOMPUTER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IComputer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOMPUTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputerImpl <em>Computer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputerImpl
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputer()
	 * @generated
	 */
	int COMPUTER = 4;

	/**
	 * The feature id for the '<em><b>Shader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__SHADER = ICOMPUTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_FEATURE_COUNT = ICOMPUTER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_OPERATION_COUNT = ICOMPUTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputerBufferBarrierImpl <em>Computer Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputerBufferBarrierImpl
	 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputerBufferBarrier()
	 * @generated
	 */
	int COMPUTER_BUFFER_BARRIER = 5;

	/**
	 * The feature id for the '<em><b>Buffer Barrier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER = ICOMPUTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Computer Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_BUFFER_BARRIER_FEATURE_COUNT = ICOMPUTER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Computer Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_BUFFER_BARRIER_OPERATION_COUNT = ICOMPUTER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.compute.ComputeProcessPool <em>Process Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Pool</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputeProcessPool
	 * @generated
	 */
	EClass getComputeProcessPool();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.compute.ComputeProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputeProcess
	 * @generated
	 */
	EClass getComputeProcess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.compute.ComputePipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputePipeline
	 * @generated
	 */
	EClass getComputePipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.compute.ComputePipeline#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputePipeline#getUnits()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EReference getComputePipeline_Units();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeX <em>Workgroup Size X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size X</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeX()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeX();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeY <em>Workgroup Size Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size Y</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeY()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeY();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeZ <em>Workgroup Size Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Size Z</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputePipeline#getWorkgroupSizeZ()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_WorkgroupSizeZ();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.compute.ComputePipeline#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputePipeline#getWidth()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.compute.ComputePipeline#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputePipeline#getHeight()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.compute.ComputePipeline#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputePipeline#getDepth()
	 * @see #getComputePipeline()
	 * @generated
	 */
	EAttribute getComputePipeline_Depth();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.compute.IComputer <em>IComputer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IComputer</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.IComputer
	 * @generated
	 */
	EClass getIComputer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.compute.Computer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computer</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.Computer
	 * @generated
	 */
	EClass getComputer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.compute.Computer#getShader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shader</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.Computer#getShader()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Shader();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.compute.ComputerBufferBarrier <em>Computer Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computer Buffer Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputerBufferBarrier
	 * @generated
	 */
	EClass getComputerBufferBarrier();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.compute.ComputerBufferBarrier#getBufferBarrier <em>Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.compute.ComputerBufferBarrier#getBufferBarrier()
	 * @see #getComputerBufferBarrier()
	 * @generated
	 */
	EReference getComputerBufferBarrier_BufferBarrier();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputeProcessPoolImpl <em>Process Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputeProcessPoolImpl
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputeProcessPool()
		 * @generated
		 */
		EClass COMPUTE_PROCESS_POOL = eINSTANCE.getComputeProcessPool();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputeProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputeProcessImpl
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputeProcess()
		 * @generated
		 */
		EClass COMPUTE_PROCESS = eINSTANCE.getComputeProcess();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputePipelineImpl <em>Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePipelineImpl
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputePipeline()
		 * @generated
		 */
		EClass COMPUTE_PIPELINE = eINSTANCE.getComputePipeline();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_PIPELINE__UNITS = eINSTANCE.getComputePipeline_Units();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.compute.IComputer <em>IComputer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.compute.IComputer
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getIComputer()
		 * @generated
		 */
		EClass ICOMPUTER = eINSTANCE.getIComputer();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputerImpl <em>Computer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputerImpl
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputer()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.compute.impl.ComputerBufferBarrierImpl <em>Computer Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputerBufferBarrierImpl
		 * @see org.sheepy.vulkan.model.process.compute.impl.ComputePackageImpl#getComputerBufferBarrier()
		 * @generated
		 */
		EClass COMPUTER_BUFFER_BARRIER = eINSTANCE.getComputerBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Buffer Barrier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER = eINSTANCE.getComputerBufferBarrier_BufferBarrier();

	}

} //ComputePackage
