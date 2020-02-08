/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.types.TypesPackage;

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
 * @see org.sheepy.lily.vulkan.model.VulkanFactory
 * @model kind="package"
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
	String eNS_URI = "org.sheepy.lily.vulkan.model";

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
	VulkanPackage eINSTANCE = org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.impl.VulkanEngineImpl <em>Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanEngineImpl
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getVulkanEngine()
	 * @generated
	 */
	int VULKAN_ENGINE = 0;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__RESOURCE_PKG = ApplicationPackage.IENGINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__ENABLED = ApplicationPackage.IENGINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__PROCESSES = ApplicationPackage.IENGINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__FEATURES = ApplicationPackage.IENGINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__DESCRIPTOR_PKG = ApplicationPackage.IENGINE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE_FEATURE_COUNT = ApplicationPackage.IENGINE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE_OPERATION_COUNT = ApplicationPackage.IENGINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.IResourceContainer <em>IResource Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.IResourceContainer
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIResourceContainer()
	 * @generated
	 */
	int IRESOURCE_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_CONTAINER__RESOURCE_PKG = 0;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_CONTAINER__DESCRIPTOR_PKG = 1;

	/**
	 * The number of structural features of the '<em>IResource Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>IResource Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.IProcess <em>IProcess</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.IProcess
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIProcess()
	 * @generated
	 */
	int IPROCESS = 2;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS__RESOURCE_PKG = IRESOURCE_CONTAINER__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS__DESCRIPTOR_PKG = IRESOURCE_CONTAINER__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS__NAME = IRESOURCE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS__ENABLED = IRESOURCE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Queue Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS__QUEUE_PRIORITY = IRESOURCE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cadence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS__CADENCE = IRESOURCE_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>IProcess</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_FEATURE_COUNT = IRESOURCE_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>IProcess</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_OPERATION_COUNT = IRESOURCE_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.IExecutionManager <em>IExecution Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.IExecutionManager
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIExecutionManager()
	 * @generated
	 */
	int IEXECUTION_MANAGER = 3;

	/**
	 * The number of structural features of the '<em>IExecution Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEXECUTION_MANAGER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IExecution Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IEXECUTION_MANAGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.impl.RunProcessImpl <em>Run Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.impl.RunProcessImpl
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getRunProcess()
	 * @generated
	 */
	int RUN_PROCESS = 4;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROCESS__PROCESS = CadencePackage.ICADENCE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Run Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROCESS_FEATURE_COUNT = CadencePackage.ICADENCE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Run Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROCESS_OPERATION_COUNT = CadencePackage.ICADENCE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.impl.WaitProcessIdleImpl <em>Wait Process Idle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.impl.WaitProcessIdleImpl
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getWaitProcessIdle()
	 * @generated
	 */
	int WAIT_PROCESS_IDLE = 5;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_PROCESS_IDLE__PROCESS = CadencePackage.ICADENCE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wait Process Idle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_PROCESS_IDLE_FEATURE_COUNT = CadencePackage.ICADENCE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Wait Process Idle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_PROCESS_IDLE_OPERATION_COUNT = CadencePackage.ICADENCE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.impl.DescriptorPkgImpl <em>Descriptor Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.impl.DescriptorPkgImpl
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getDescriptorPkg()
	 * @generated
	 */
	int DESCRIPTOR_PKG = 6;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_PKG__DESCRIPTORS = 0;

	/**
	 * The number of structural features of the '<em>Descriptor Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Descriptor Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.IDescriptor <em>IDescriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.IDescriptor
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIDescriptor()
	 * @generated
	 */
	int IDESCRIPTOR = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR__TYPE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR__SHADER_STAGES = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IDescriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>IDescriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.VulkanEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine</em>'.
	 * @see org.sheepy.lily.vulkan.model.VulkanEngine
	 * @generated
	 */
	EClass getVulkanEngine();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.VulkanEngine#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.VulkanEngine#isEnabled()
	 * @see #getVulkanEngine()
	 * @generated
	 */
	EAttribute getVulkanEngine_Enabled();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.VulkanEngine#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see org.sheepy.lily.vulkan.model.VulkanEngine#getProcesses()
	 * @see #getVulkanEngine()
	 * @generated
	 */
	EReference getVulkanEngine_Processes();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.VulkanEngine#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Features</em>'.
	 * @see org.sheepy.lily.vulkan.model.VulkanEngine#getFeatures()
	 * @see #getVulkanEngine()
	 * @generated
	 */
	EAttribute getVulkanEngine_Features();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.VulkanEngine#getDescriptorPkg <em>Descriptor Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.VulkanEngine#getDescriptorPkg()
	 * @see #getVulkanEngine()
	 * @generated
	 */
	EReference getVulkanEngine_DescriptorPkg();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.IResourceContainer <em>IResource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IResource Container</em>'.
	 * @see org.sheepy.lily.vulkan.model.IResourceContainer
	 * @generated
	 */
	EClass getIResourceContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.IResourceContainer#getResourcePkg <em>Resource Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.IResourceContainer#getResourcePkg()
	 * @see #getIResourceContainer()
	 * @generated
	 */
	EReference getIResourceContainer_ResourcePkg();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.IResourceContainer#getDescriptorPkg <em>Descriptor Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.IResourceContainer#getDescriptorPkg()
	 * @see #getIResourceContainer()
	 * @generated
	 */
	EReference getIResourceContainer_DescriptorPkg();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.IProcess <em>IProcess</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProcess</em>'.
	 * @see org.sheepy.lily.vulkan.model.IProcess
	 * @generated
	 */
	EClass getIProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.IProcess#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.IProcess#isEnabled()
	 * @see #getIProcess()
	 * @generated
	 */
	EAttribute getIProcess_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.IProcess#getQueuePriority <em>Queue Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Queue Priority</em>'.
	 * @see org.sheepy.lily.vulkan.model.IProcess#getQueuePriority()
	 * @see #getIProcess()
	 * @generated
	 */
	EAttribute getIProcess_QueuePriority();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.IProcess#getCadence <em>Cadence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cadence</em>'.
	 * @see org.sheepy.lily.vulkan.model.IProcess#getCadence()
	 * @see #getIProcess()
	 * @generated
	 */
	EReference getIProcess_Cadence();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.IExecutionManager <em>IExecution Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IExecution Manager</em>'.
	 * @see org.sheepy.lily.vulkan.model.IExecutionManager
	 * @generated
	 */
	EClass getIExecutionManager();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.RunProcess <em>Run Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.RunProcess
	 * @generated
	 */
	EClass getRunProcess();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.RunProcess#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.RunProcess#getProcess()
	 * @see #getRunProcess()
	 * @generated
	 */
	EReference getRunProcess_Process();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.WaitProcessIdle <em>Wait Process Idle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait Process Idle</em>'.
	 * @see org.sheepy.lily.vulkan.model.WaitProcessIdle
	 * @generated
	 */
	EClass getWaitProcessIdle();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.WaitProcessIdle#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process</em>'.
	 * @see org.sheepy.lily.vulkan.model.WaitProcessIdle#getProcess()
	 * @see #getWaitProcessIdle()
	 * @generated
	 */
	EReference getWaitProcessIdle_Process();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.DescriptorPkg <em>Descriptor Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.DescriptorPkg
	 * @generated
	 */
	EClass getDescriptorPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.DescriptorPkg#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptors</em>'.
	 * @see org.sheepy.lily.vulkan.model.DescriptorPkg#getDescriptors()
	 * @see #getDescriptorPkg()
	 * @generated
	 */
	EReference getDescriptorPkg_Descriptors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.IDescriptor <em>IDescriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDescriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.IDescriptor
	 * @generated
	 */
	EClass getIDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.IDescriptor#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.sheepy.lily.vulkan.model.IDescriptor#getType()
	 * @see #getIDescriptor()
	 * @generated
	 */
	EAttribute getIDescriptor_Type();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.IDescriptor#getShaderStages <em>Shader Stages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Shader Stages</em>'.
	 * @see org.sheepy.lily.vulkan.model.IDescriptor#getShaderStages()
	 * @see #getIDescriptor()
	 * @generated
	 */
	EAttribute getIDescriptor_ShaderStages();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.impl.VulkanEngineImpl <em>Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanEngineImpl
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getVulkanEngine()
		 * @generated
		 */
		EClass VULKAN_ENGINE = eINSTANCE.getVulkanEngine();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_ENGINE__ENABLED = eINSTANCE.getVulkanEngine_Enabled();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_ENGINE__PROCESSES = eINSTANCE.getVulkanEngine_Processes();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_ENGINE__FEATURES = eINSTANCE.getVulkanEngine_Features();

		/**
		 * The meta object literal for the '<em><b>Descriptor Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_ENGINE__DESCRIPTOR_PKG = eINSTANCE.getVulkanEngine_DescriptorPkg();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.IResourceContainer <em>IResource Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.IResourceContainer
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIResourceContainer()
		 * @generated
		 */
		EClass IRESOURCE_CONTAINER = eINSTANCE.getIResourceContainer();

		/**
		 * The meta object literal for the '<em><b>Resource Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IRESOURCE_CONTAINER__RESOURCE_PKG = eINSTANCE.getIResourceContainer_ResourcePkg();

		/**
		 * The meta object literal for the '<em><b>Descriptor Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IRESOURCE_CONTAINER__DESCRIPTOR_PKG = eINSTANCE.getIResourceContainer_DescriptorPkg();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.IProcess <em>IProcess</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.IProcess
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIProcess()
		 * @generated
		 */
		EClass IPROCESS = eINSTANCE.getIProcess();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROCESS__ENABLED = eINSTANCE.getIProcess_Enabled();

		/**
		 * The meta object literal for the '<em><b>Queue Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROCESS__QUEUE_PRIORITY = eINSTANCE.getIProcess_QueuePriority();

		/**
		 * The meta object literal for the '<em><b>Cadence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPROCESS__CADENCE = eINSTANCE.getIProcess_Cadence();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.IExecutionManager <em>IExecution Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.IExecutionManager
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIExecutionManager()
		 * @generated
		 */
		EClass IEXECUTION_MANAGER = eINSTANCE.getIExecutionManager();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.impl.RunProcessImpl <em>Run Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.impl.RunProcessImpl
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getRunProcess()
		 * @generated
		 */
		EClass RUN_PROCESS = eINSTANCE.getRunProcess();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_PROCESS__PROCESS = eINSTANCE.getRunProcess_Process();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.impl.WaitProcessIdleImpl <em>Wait Process Idle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.impl.WaitProcessIdleImpl
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getWaitProcessIdle()
		 * @generated
		 */
		EClass WAIT_PROCESS_IDLE = eINSTANCE.getWaitProcessIdle();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAIT_PROCESS_IDLE__PROCESS = eINSTANCE.getWaitProcessIdle_Process();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.impl.DescriptorPkgImpl <em>Descriptor Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.impl.DescriptorPkgImpl
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getDescriptorPkg()
		 * @generated
		 */
		EClass DESCRIPTOR_PKG = eINSTANCE.getDescriptorPkg();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTOR_PKG__DESCRIPTORS = eINSTANCE.getDescriptorPkg_Descriptors();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.IDescriptor <em>IDescriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.IDescriptor
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIDescriptor()
		 * @generated
		 */
		EClass IDESCRIPTOR = eINSTANCE.getIDescriptor();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDESCRIPTOR__TYPE = eINSTANCE.getIDescriptor_Type();

		/**
		 * The meta object literal for the '<em><b>Shader Stages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDESCRIPTOR__SHADER_STAGES = eINSTANCE.getIDescriptor_ShaderStages();

	}

} //VulkanPackage
