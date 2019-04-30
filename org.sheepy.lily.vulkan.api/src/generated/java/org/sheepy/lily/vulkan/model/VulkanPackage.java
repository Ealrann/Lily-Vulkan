/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.model.application.ApplicationPackage;
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
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__CONTENT_OBJECTS = ApplicationPackage.IENGINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__RESOURCE_PKG = ApplicationPackage.IENGINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__ENABLED = ApplicationPackage.IENGINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__PROCESSES = ApplicationPackage.IENGINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Features</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__FEATURES = ApplicationPackage.IENGINE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE_FEATURE_COUNT = ApplicationPackage.IENGINE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE___LINFERENCE_OBJECT = ApplicationPackage.IENGINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE___CREATE_CONTAINMENT_ELIST__ECLASS = ApplicationPackage.IENGINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE___LCONTENTS = ApplicationPackage.IENGINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE___LPARENT = ApplicationPackage.IENGINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE___LALL_CONTENTS = ApplicationPackage.IENGINE___LALL_CONTENTS;

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
	 * The number of structural features of the '<em>IResource Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IResource Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.impl.ResourcePkgImpl <em>Resource Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.impl.ResourcePkgImpl
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getResourcePkg()
	 * @generated
	 */
	int RESOURCE_PKG = 2;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG__RESOURCES = 0;

	/**
	 * The number of structural features of the '<em>Resource Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Resource Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.IResource <em>IResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.IResource
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIResource()
	 * @generated
	 */
	int IRESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>IResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.IProcess <em>IProcess</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.IProcess
	 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIProcess()
	 * @generated
	 */
	int IPROCESS = 4;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS__RESOURCE_PKG = IRESOURCE_CONTAINER__RESOURCE_PKG;

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
	 * The number of structural features of the '<em>IProcess</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_FEATURE_COUNT = IRESOURCE_CONTAINER_FEATURE_COUNT + 2;

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
	int IEXECUTION_MANAGER = 5;

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.ResourcePkg <em>Resource Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.ResourcePkg
	 * @generated
	 */
	EClass getResourcePkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.ResourcePkg#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.sheepy.lily.vulkan.model.ResourcePkg#getResources()
	 * @see #getResourcePkg()
	 * @generated
	 */
	EReference getResourcePkg_Resources();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.IResource <em>IResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IResource</em>'.
	 * @see org.sheepy.lily.vulkan.model.IResource
	 * @generated
	 */
	EClass getIResource();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.IExecutionManager <em>IExecution Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IExecution Manager</em>'.
	 * @see org.sheepy.lily.vulkan.model.IExecutionManager
	 * @generated
	 */
	EClass getIExecutionManager();

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
		EReference IRESOURCE_CONTAINER__RESOURCE_PKG = eINSTANCE
				.getIResourceContainer_ResourcePkg();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.impl.ResourcePkgImpl <em>Resource Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.impl.ResourcePkgImpl
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getResourcePkg()
		 * @generated
		 */
		EClass RESOURCE_PKG = eINSTANCE.getResourcePkg();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PKG__RESOURCES = eINSTANCE.getResourcePkg_Resources();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.IResource <em>IResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.IResource
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIResource()
		 * @generated
		 */
		EClass IRESOURCE = eINSTANCE.getIResource();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.IExecutionManager <em>IExecution Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.IExecutionManager
		 * @see org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl#getIExecutionManager()
		 * @generated
		 */
		EClass IEXECUTION_MANAGER = eINSTANCE.getIExecutionManager();

	}

} //VulkanPackage
