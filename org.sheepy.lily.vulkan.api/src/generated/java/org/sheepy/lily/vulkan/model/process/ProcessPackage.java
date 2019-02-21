/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.lily.vulkan.model/src/generated/java' editDirectory='/org.sheepy.lily.vulkan.model.edit/src/generated/java' publicConstructors='true' complianceLevel='11.0' resource='XMI' extensibleProviderFactory='true' childCreationExtenders='true' updateClasspath='false' basePackage='org.sheepy.lily.vulkan.model'"
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
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__CONTENT_OBJECTS = VulkanPackage.IPROCESS__CONTENT_OBJECTS;

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
	 * The feature id for the '<em><b>Resource Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__RESOURCE_CONTAINER = VulkanPackage.IPROCESS_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Semaphores</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__SEMAPHORES = VulkanPackage.IPROCESS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reset Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__RESET_ALLOWED = VulkanPackage.IPROCESS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initialized Signalized Semaphore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE = VulkanPackage.IPROCESS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Dependent Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__DEPENDENT_PROCESSES = VulkanPackage.IPROCESS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_FEATURE_COUNT = VulkanPackage.IPROCESS_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS___LINFERENCE_OBJECT = VulkanPackage.IPROCESS___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS___CREATE_CONTAINMENT_ELIST__ECLASS = VulkanPackage.IPROCESS___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS___LCONTENTS = VulkanPackage.IPROCESS___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS___LPARENT = VulkanPackage.IPROCESS___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS___LALL_CONTENTS = VulkanPackage.IPROCESS___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_OPERATION_COUNT = VulkanPackage.IPROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.ProcessSemaphoreImpl <em>Semaphore</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessSemaphoreImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessSemaphore()
	 * @generated
	 */
	int PROCESS_SEMAPHORE = 1;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEMAPHORE__PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Wait Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEMAPHORE__WAIT_STAGE = 1;

	/**
	 * The number of structural features of the '<em>Semaphore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEMAPHORE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Semaphore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEMAPHORE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.IProcessUnit <em>IProcess Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.IProcessUnit
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIProcessUnit()
	 * @generated
	 */
	int IPROCESS_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT__CONTENT_OBJECTS = RootPackage.LOBJECT__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT__ENABLED = RootPackage.LOBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT__STAGE = RootPackage.LOBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IProcess Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT_FEATURE_COUNT = RootPackage.LOBJECT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT___LINFERENCE_OBJECT = RootPackage.LOBJECT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT___CREATE_CONTAINMENT_ELIST__ECLASS = RootPackage.LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT___LCONTENTS = RootPackage.LOBJECT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT___LPARENT = RootPackage.LOBJECT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT___LALL_CONTENTS = RootPackage.LOBJECT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IProcess Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_UNIT_OPERATION_COUNT = RootPackage.LOBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.Configuration <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.Configuration
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 3;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl <em>Pipeline Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPipelineBarrier()
	 * @generated
	 */
	int PIPELINE_BARRIER = 4;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__CONTENT_OBJECTS = IPROCESS_UNIT__CONTENT_OBJECTS;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__NAME = IPROCESS_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Barrier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__BARRIER = IPROCESS_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Src Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__SRC_QUEUE = IPROCESS_UNIT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dst Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER__DST_QUEUE = IPROCESS_UNIT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_FEATURE_COUNT = IPROCESS_UNIT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___LINFERENCE_OBJECT = IPROCESS_UNIT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___CREATE_CONTAINMENT_ELIST__ECLASS = IPROCESS_UNIT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___LCONTENTS = IPROCESS_UNIT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___LPARENT = IPROCESS_UNIT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER___LALL_CONTENTS = IPROCESS_UNIT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Pipeline Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_BARRIER_OPERATION_COUNT = IPROCESS_UNIT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__CONTENT_OBJECTS = IPROCESS_UNIT__CONTENT_OBJECTS;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE__NAME = IPROCESS_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_FEATURE_COUNT = IPROCESS_UNIT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE___LINFERENCE_OBJECT = IPROCESS_UNIT___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = IPROCESS_UNIT___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE___LCONTENTS = IPROCESS_UNIT___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE___LPARENT = IPROCESS_UNIT___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE___LALL_CONTENTS = IPROCESS_UNIT___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>IPipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_OPERATION_COUNT = IPROCESS_UNIT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl <em>Abstract Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getAbstractPipeline()
	 * @generated
	 */
	int ABSTRACT_PIPELINE = 6;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__CONTENT_OBJECTS = IPIPELINE__CONTENT_OBJECTS;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE__NAME = IPIPELINE__NAME;

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
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE___LINFERENCE_OBJECT = IPIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = IPIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE___LCONTENTS = IPIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE___LPARENT = IPIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE___LALL_CONTENTS = IPIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Abstract Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PIPELINE_OPERATION_COUNT = IPIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.IPipelineUnit <em>IPipeline Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineUnit
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIPipelineUnit()
	 * @generated
	 */
	int IPIPELINE_UNIT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_UNIT__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>IPipeline Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_UNIT_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IPipeline Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPIPELINE_UNIT_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.AbstractCompositePipelineImpl <em>Abstract Composite Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.AbstractCompositePipelineImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getAbstractCompositePipeline()
	 * @generated
	 */
	int ABSTRACT_COMPOSITE_PIPELINE = 8;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__CONTENT_OBJECTS = ABSTRACT_PIPELINE__CONTENT_OBJECTS;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE__NAME = ABSTRACT_PIPELINE__NAME;

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
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE___LINFERENCE_OBJECT = ABSTRACT_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = ABSTRACT_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE___LCONTENTS = ABSTRACT_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE___LPARENT = ABSTRACT_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE___LALL_CONTENTS = ABSTRACT_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Abstract Composite Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_COMPOSITE_PIPELINE_OPERATION_COUNT = ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl <em>Push Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl
	 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPushConstant()
	 * @generated
	 */
	int PUSH_CONSTANT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT__NAME = IPIPELINE_UNIT__NAME;

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess
	 * @generated
	 */
	EClass getAbstractProcess();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getResourceContainer <em>Resource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Container</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getResourceContainer()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_ResourceContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorSets <em>Descriptor Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptor Sets</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getDescriptorSets()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_DescriptorSets();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getUnits()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_Units();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#isInitializedSignalizedSemaphore <em>Initialized Signalized Semaphore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Signalized Semaphore</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#isInitializedSignalizedSemaphore()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EAttribute getAbstractProcess_InitializedSignalizedSemaphore();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getDependentProcesses <em>Dependent Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependent Processes</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getDependentProcesses()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_DependentProcesses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.AbstractProcess#getSemaphores <em>Semaphores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Semaphores</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractProcess#getSemaphores()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_Semaphores();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.ProcessSemaphore <em>Semaphore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semaphore</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessSemaphore
	 * @generated
	 */
	EClass getProcessSemaphore();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.ProcessSemaphore#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessSemaphore#getProcess()
	 * @see #getProcessSemaphore()
	 * @generated
	 */
	EReference getProcessSemaphore_Process();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.ProcessSemaphore#getWaitStage <em>Wait Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wait Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessSemaphore#getWaitStage()
	 * @see #getProcessSemaphore()
	 * @generated
	 */
	EAttribute getProcessSemaphore_WaitStage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.IProcessUnit <em>IProcess Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProcess Unit</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IProcessUnit
	 * @generated
	 */
	EClass getIProcessUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.IProcessUnit#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IProcessUnit#isEnabled()
	 * @see #getIProcessUnit()
	 * @generated
	 */
	EAttribute getIProcessUnit_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.process.IProcessUnit#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IProcessUnit#getStage()
	 * @see #getIProcessUnit()
	 * @generated
	 */
	EAttribute getIProcessUnit_Stage();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier <em>Pipeline Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelineBarrier
	 * @generated
	 */
	EClass getPipelineBarrier();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.process.PipelineBarrier#getBarrier <em>Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.PipelineBarrier#getBarrier()
	 * @see #getPipelineBarrier()
	 * @generated
	 */
	EReference getPipelineBarrier_Barrier();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.IPipeline <em>IPipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipeline
	 * @generated
	 */
	EClass getIPipeline();

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
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractPipeline#getUnits()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_Units();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getDescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Descriptor Set</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractPipeline#getDescriptorSet()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_DescriptorSet();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline#getConstants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constants</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractPipeline#getConstants()
	 * @see #getAbstractPipeline()
	 * @generated
	 */
	EReference getAbstractPipeline_Constants();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.IPipelineUnit <em>IPipeline Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IPipeline Unit</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineUnit
	 * @generated
	 */
	EClass getIPipelineUnit();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.process.AbstractCompositePipeline <em>Abstract Composite Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Composite Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractCompositePipeline
	 * @generated
	 */
	EClass getAbstractCompositePipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.process.AbstractCompositePipeline#getPipelines <em>Pipelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pipelines</em>'.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractCompositePipeline#getPipelines()
	 * @see #getAbstractCompositePipeline()
	 * @generated
	 */
	EReference getAbstractCompositePipeline_Pipelines();

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
		 * The meta object literal for the '<em><b>Resource Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__RESOURCE_CONTAINER = eINSTANCE.getAbstractProcess_ResourceContainer();

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
		 * The meta object literal for the '<em><b>Initialized Signalized Semaphore</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PROCESS__INITIALIZED_SIGNALIZED_SEMAPHORE = eINSTANCE.getAbstractProcess_InitializedSignalizedSemaphore();

		/**
		 * The meta object literal for the '<em><b>Dependent Processes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__DEPENDENT_PROCESSES = eINSTANCE.getAbstractProcess_DependentProcesses();

		/**
		 * The meta object literal for the '<em><b>Semaphores</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__SEMAPHORES = eINSTANCE.getAbstractProcess_Semaphores();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.ProcessSemaphoreImpl <em>Semaphore</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessSemaphoreImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getProcessSemaphore()
		 * @generated
		 */
		EClass PROCESS_SEMAPHORE = eINSTANCE.getProcessSemaphore();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_SEMAPHORE__PROCESS = eINSTANCE.getProcessSemaphore_Process();

		/**
		 * The meta object literal for the '<em><b>Wait Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_SEMAPHORE__WAIT_STAGE = eINSTANCE.getProcessSemaphore_WaitStage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.IProcessUnit <em>IProcess Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.IProcessUnit
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIProcessUnit()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.Configuration <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.Configuration
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

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
		 * The meta object literal for the '<em><b>Barrier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIPELINE_BARRIER__BARRIER = eINSTANCE.getPipelineBarrier_Barrier();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.IPipeline <em>IPipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.IPipeline
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIPipeline()
		 * @generated
		 */
		EClass IPIPELINE = eINSTANCE.getIPipeline();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.IPipelineUnit <em>IPipeline Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.IPipelineUnit
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getIPipelineUnit()
		 * @generated
		 */
		EClass IPIPELINE_UNIT = eINSTANCE.getIPipelineUnit();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.AbstractCompositePipelineImpl <em>Abstract Composite Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.AbstractCompositePipelineImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getAbstractCompositePipeline()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl <em>Push Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl
		 * @see org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl#getPushConstant()
		 * @generated
		 */
		EClass PUSH_CONSTANT = eINSTANCE.getPushConstant();

	}

} //ProcessPackage
