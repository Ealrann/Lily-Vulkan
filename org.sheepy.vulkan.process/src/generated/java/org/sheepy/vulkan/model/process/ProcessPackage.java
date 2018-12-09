/**
 */
package org.sheepy.vulkan.model.process;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.vulkan.model.VulkanPackage;

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
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/process' publicConstructors='true' updateClasspath='false' basePackage='org.sheepy.vulkan.model'"
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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AbstractProcessImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractProcess()
	 * @generated
	 */
	int ABSTRACT_PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__ENABLED = VulkanPackage.IPROCESS__ENABLED;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__RESOURCES = VulkanPackage.IPROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__DESCRIPTOR_SETS = VulkanPackage.IPROCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__UNITS = VulkanPackage.IPROCESS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__RESET_ALLOWED = VulkanPackage.IPROCESS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_FEATURE_COUNT = VulkanPackage.IPROCESS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_OPERATION_COUNT = VulkanPackage.IPROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.IProcessUnit <em>IProcess Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.IProcessUnit
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getIProcessUnit()
	 * @generated
	 */
	int IPROCESS_UNIT = 1;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.Configuration <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.Configuration
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 2;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBarrier()
	 * @generated
	 */
	int PIPELINE_BARRIER = 3;

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
	 * The number of structural features of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_FEATURE_COUNT = IPROCESS_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_OPERATION_COUNT = IPROCESS_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.PipelineBufferBarrierImpl <em>Pipeline Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.PipelineBufferBarrierImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBufferBarrier()
	 * @generated
	 */
	int PIPELINE_BUFFER_BARRIER = 4;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BUFFER_BARRIER__ENABLED = PIPELINE_BARRIER__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BUFFER_BARRIER__STAGE = PIPELINE_BARRIER__STAGE;

	/**
	 * The feature id for the '<em><b>Buffer Barrier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BUFFER_BARRIER__BUFFER_BARRIER = PIPELINE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pipeline Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BUFFER_BARRIER_FEATURE_COUNT = PIPELINE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pipeline Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BUFFER_BARRIER_OPERATION_COUNT = PIPELINE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.IPipeline <em>IPipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.IPipeline
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getIPipeline()
	 * @generated
	 */
	int IPIPELINE = 5;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__ENABLED = IPROCESS_UNIT__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__STAGE = IPROCESS_UNIT__STAGE;

	/**
	 * The number of structural features of the '<em>IPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_FEATURE_COUNT = IPROCESS_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_OPERATION_COUNT = IPROCESS_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.IPipelineUnit <em>IPipeline Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.IPipelineUnit
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getIPipelineUnit()
	 * @generated
	 */
	int IPIPELINE_UNIT = 6;

	/**
	 * The number of structural features of the '<em>IPipeline Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_UNIT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IPipeline Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_UNIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl <em>Abstract Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractPipeline()
	 * @generated
	 */
	int ABSTRACT_PIPELINE = 7;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__ENABLED = IPIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__STAGE = IPIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__UNITS = IPIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__DESCRIPTOR_SET = IPIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__CONSTANTS = IPIPELINE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE_FEATURE_COUNT = IPIPELINE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Abstract Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE_OPERATION_COUNT = IPIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.AbstractCompositePipelineImpl <em>Abstract Composite Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.AbstractCompositePipelineImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractCompositePipeline()
	 * @generated
	 */
	int ABSTRACT_COMPOSITE_PIPELINE = 8;

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
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__UNITS = ABSTRACT_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__DESCRIPTOR_SET = ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__CONSTANTS = ABSTRACT_PIPELINE__CONSTANTS;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.process.impl.PushConstantImpl <em>Push Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.process.impl.PushConstantImpl
	 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getPushConstant()
	 * @generated
	 */
	int PUSH_CONSTANT = 9;

	/**
	 * The number of structural features of the '<em>Push Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_FEATURE_COUNT = IPIPELINE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Push Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_OPERATION_COUNT = IPIPELINE_UNIT_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.AbstractProcess#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcess#getResources()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_Resources();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.AbstractProcess#getDescriptorSets <em>Descriptor Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptor Sets</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcess#getDescriptorSets()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_DescriptorSets();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.process.AbstractProcess#isResetAllowed <em>Reset Allowed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Allowed</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractProcess#isResetAllowed()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EAttribute getAbstractProcess_ResetAllowed();

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
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sheepy.vulkan.model.process.Configuration
	 * @generated
	 */
	EClass getConfiguration();

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
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.PipelineBufferBarrier <em>Pipeline Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline Buffer Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.PipelineBufferBarrier
	 * @generated
	 */
	EClass getPipelineBufferBarrier();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.process.PipelineBufferBarrier#getBufferBarrier <em>Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer Barrier</em>'.
	 * @see org.sheepy.vulkan.model.process.PipelineBufferBarrier#getBufferBarrier()
	 * @see #getPipelineBufferBarrier()
	 * @generated
	 */
	EReference getPipelineBufferBarrier_BufferBarrier();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.IPipeline <em>IPipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPipeline</em>'.
	 * @see org.sheepy.vulkan.model.process.IPipeline
	 * @generated
	 */
	EClass getIPipeline();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.IPipelineUnit <em>IPipeline Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPipeline Unit</em>'.
	 * @see org.sheepy.vulkan.model.process.IPipelineUnit
	 * @generated
	 */
	EClass getIPipelineUnit();

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
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.process.AbstractPipeline#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractPipeline#getUnits()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_Units();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.AbstractPipeline#getDescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Descriptor Set</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractPipeline#getDescriptorSet()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_DescriptorSet();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.model.process.AbstractPipeline#getConstants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constants</em>'.
	 * @see org.sheepy.vulkan.model.process.AbstractPipeline#getConstants()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_Constants();

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
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.process.PushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Constant</em>'.
	 * @see org.sheepy.vulkan.model.process.PushConstant
	 * @generated
	 */
	EClass getPushConstant();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.AbstractProcessImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getAbstractProcess()
		 * @generated
		 */
		EClass ABSTRACT_PROCESS = eINSTANCE.getAbstractProcess();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__RESOURCES = eINSTANCE.getAbstractProcess_Resources();

		/**
		 * The meta object literal for the '<em><b>Descriptor Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__DESCRIPTOR_SETS = eINSTANCE.getAbstractProcess_DescriptorSets();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__UNITS = eINSTANCE.getAbstractProcess_Units();

		/**
		 * The meta object literal for the '<em><b>Reset Allowed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PROCESS__RESET_ALLOWED = eINSTANCE.getAbstractProcess_ResetAllowed();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.Configuration <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.Configuration
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.PipelineBufferBarrierImpl <em>Pipeline Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.PipelineBufferBarrierImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBufferBarrier()
		 * @generated
		 */
		EClass PIPELINE_BUFFER_BARRIER = eINSTANCE.getPipelineBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Buffer Barrier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_BUFFER_BARRIER__BUFFER_BARRIER = eINSTANCE.getPipelineBufferBarrier_BufferBarrier();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.IPipeline <em>IPipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.IPipeline
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getIPipeline()
		 * @generated
		 */
		EClass IPIPELINE = eINSTANCE.getIPipeline();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.IPipelineUnit <em>IPipeline Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.IPipelineUnit
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getIPipelineUnit()
		 * @generated
		 */
		EClass IPIPELINE_UNIT = eINSTANCE.getIPipelineUnit();

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
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PIPELINE__UNITS = eINSTANCE.getAbstractPipeline_Units();

		/**
		 * The meta object literal for the '<em><b>Descriptor Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PIPELINE__DESCRIPTOR_SET = eINSTANCE.getAbstractPipeline_DescriptorSet();

		/**
		 * The meta object literal for the '<em><b>Constants</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PIPELINE__CONSTANTS = eINSTANCE.getAbstractPipeline_Constants();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.process.impl.PushConstantImpl <em>Push Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.process.impl.PushConstantImpl
		 * @see org.sheepy.vulkan.model.process.impl.ProcessPackageImpl#getPushConstant()
		 * @generated
		 */
		EClass PUSH_CONSTANT = eINSTANCE.getPushConstant();

	}

} //ProcessPackage
