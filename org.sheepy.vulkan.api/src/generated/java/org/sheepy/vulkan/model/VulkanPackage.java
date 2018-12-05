/**
 */
package org.sheepy.vulkan.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.sheepy.vulkan.model.VulkanFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/vulkan' modelName='Vulkan' prefix='Vulkan' publicConstructors='true' updateClasspath='false' basePackage='org.sheepy.vulkan'"
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
	String eNS_URI = "org.sheepy.vulkan.model";

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
	VulkanPackage eINSTANCE = org.sheepy.vulkan.model.impl.VulkanPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.VulkanApplicationImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getVulkanApplication()
	 * @generated
	 */
	int VULKAN_APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Fullscreen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__FULLSCREEN = 1;

	/**
	 * The feature id for the '<em><b>Resizeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__RESIZEABLE = 2;

	/**
	 * The feature id for the '<em><b>Debug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__DEBUG = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__TITLE = 4;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__SIZE = 5;

	/**
	 * The feature id for the '<em><b>Engine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__ENGINE = 6;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.VulkanEngineImpl <em>Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.VulkanEngineImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getVulkanEngine()
	 * @generated
	 */
	int VULKAN_ENGINE = 1;

	/**
	 * The feature id for the '<em><b>Shared Resources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__SHARED_RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE__PROCESSES = 1;

	/**
	 * The number of structural features of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_ENGINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.IEnginePart <em>IEngine Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.IEnginePart
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIEnginePart()
	 * @generated
	 */
	int IENGINE_PART = 2;

	/**
	 * The number of structural features of the '<em>IEngine Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE_PART_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IEngine Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IENGINE_PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.SharedResourcesImpl <em>Shared Resources</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.SharedResourcesImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getSharedResources()
	 * @generated
	 */
	int SHARED_RESOURCES = 3;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_RESOURCES__RESOURCES = IENGINE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shared Resources</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_RESOURCES_FEATURE_COUNT = IENGINE_PART_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Shared Resources</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_RESOURCES_OPERATION_COUNT = IENGINE_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.IResource <em>IResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.IResource
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIResource()
	 * @generated
	 */
	int IRESOURCE = 4;

	/**
	 * The number of structural features of the '<em>IResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.IProcess <em>IProcess</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.IProcess
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIProcess()
	 * @generated
	 */
	int IPROCESS = 5;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS__ENABLED = IENGINE_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IProcess</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_FEATURE_COUNT = IENGINE_PART_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>IProcess</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESS_OPERATION_COUNT = IENGINE_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.impl.ColorDomainImpl <em>Color Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.impl.ColorDomainImpl
	 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getColorDomain()
	 * @generated
	 */
	int COLOR_DOMAIN = 6;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DOMAIN__FORMAT = 0;

	/**
	 * The feature id for the '<em><b>Color Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DOMAIN__COLOR_SPACE = 1;

	/**
	 * The number of structural features of the '<em>Color Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DOMAIN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Color Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DOMAIN_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.VulkanApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication
	 * @generated
	 */
	EClass getVulkanApplication();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#isEnabled()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#isFullscreen <em>Fullscreen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fullscreen</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#isFullscreen()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Fullscreen();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#isResizeable <em>Resizeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resizeable</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#isResizeable()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Resizeable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#isDebug <em>Debug</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Debug</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#isDebug()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Debug();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getTitle()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.VulkanApplication#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getSize()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EAttribute getVulkanApplication_Size();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.VulkanApplication#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Engine</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getEngine()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EReference getVulkanApplication_Engine();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.VulkanEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine</em>'.
	 * @see org.sheepy.vulkan.model.VulkanEngine
	 * @generated
	 */
	EClass getVulkanEngine();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.VulkanEngine#getSharedResources <em>Shared Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Shared Resources</em>'.
	 * @see org.sheepy.vulkan.model.VulkanEngine#getSharedResources()
	 * @see #getVulkanEngine()
	 * @generated
	 */
	EReference getVulkanEngine_SharedResources();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.VulkanEngine#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see org.sheepy.vulkan.model.VulkanEngine#getProcesses()
	 * @see #getVulkanEngine()
	 * @generated
	 */
	EReference getVulkanEngine_Processes();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.IEnginePart <em>IEngine Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IEngine Part</em>'.
	 * @see org.sheepy.vulkan.model.IEnginePart
	 * @generated
	 */
	EClass getIEnginePart();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.SharedResources <em>Shared Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Resources</em>'.
	 * @see org.sheepy.vulkan.model.SharedResources
	 * @generated
	 */
	EClass getSharedResources();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.SharedResources#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.sheepy.vulkan.model.SharedResources#getResources()
	 * @see #getSharedResources()
	 * @generated
	 */
	EReference getSharedResources_Resources();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.IResource <em>IResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IResource</em>'.
	 * @see org.sheepy.vulkan.model.IResource
	 * @generated
	 */
	EClass getIResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.IProcess <em>IProcess</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProcess</em>'.
	 * @see org.sheepy.vulkan.model.IProcess
	 * @generated
	 */
	EClass getIProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.IProcess#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.sheepy.vulkan.model.IProcess#isEnabled()
	 * @see #getIProcess()
	 * @generated
	 */
	EAttribute getIProcess_Enabled();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.ColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Domain</em>'.
	 * @see org.sheepy.vulkan.model.ColorDomain
	 * @generated
	 */
	EClass getColorDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ColorDomain#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.sheepy.vulkan.model.ColorDomain#getFormat()
	 * @see #getColorDomain()
	 * @generated
	 */
	EAttribute getColorDomain_Format();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.ColorDomain#getColorSpace <em>Color Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Space</em>'.
	 * @see org.sheepy.vulkan.model.ColorDomain#getColorSpace()
	 * @see #getColorDomain()
	 * @generated
	 */
	EAttribute getColorDomain_ColorSpace();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.VulkanApplicationImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getVulkanApplication()
		 * @generated
		 */
		EClass VULKAN_APPLICATION = eINSTANCE.getVulkanApplication();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__ENABLED = eINSTANCE.getVulkanApplication_Enabled();

		/**
		 * The meta object literal for the '<em><b>Fullscreen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__FULLSCREEN = eINSTANCE.getVulkanApplication_Fullscreen();

		/**
		 * The meta object literal for the '<em><b>Resizeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__RESIZEABLE = eINSTANCE.getVulkanApplication_Resizeable();

		/**
		 * The meta object literal for the '<em><b>Debug</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__DEBUG = eINSTANCE.getVulkanApplication_Debug();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__TITLE = eINSTANCE.getVulkanApplication_Title();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULKAN_APPLICATION__SIZE = eINSTANCE.getVulkanApplication_Size();

		/**
		 * The meta object literal for the '<em><b>Engine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_APPLICATION__ENGINE = eINSTANCE.getVulkanApplication_Engine();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.VulkanEngineImpl <em>Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.VulkanEngineImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getVulkanEngine()
		 * @generated
		 */
		EClass VULKAN_ENGINE = eINSTANCE.getVulkanEngine();

		/**
		 * The meta object literal for the '<em><b>Shared Resources</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_ENGINE__SHARED_RESOURCES = eINSTANCE.getVulkanEngine_SharedResources();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_ENGINE__PROCESSES = eINSTANCE.getVulkanEngine_Processes();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.IEnginePart <em>IEngine Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.IEnginePart
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIEnginePart()
		 * @generated
		 */
		EClass IENGINE_PART = eINSTANCE.getIEnginePart();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.SharedResourcesImpl <em>Shared Resources</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.SharedResourcesImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getSharedResources()
		 * @generated
		 */
		EClass SHARED_RESOURCES = eINSTANCE.getSharedResources();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHARED_RESOURCES__RESOURCES = eINSTANCE.getSharedResources_Resources();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.IResource <em>IResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.IResource
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIResource()
		 * @generated
		 */
		EClass IRESOURCE = eINSTANCE.getIResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.IProcess <em>IProcess</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.IProcess
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getIProcess()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.impl.ColorDomainImpl <em>Color Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.impl.ColorDomainImpl
		 * @see org.sheepy.vulkan.model.impl.VulkanPackageImpl#getColorDomain()
		 * @generated
		 */
		EClass COLOR_DOMAIN = eINSTANCE.getColorDomain();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_DOMAIN__FORMAT = eINSTANCE.getColorDomain_Format();

		/**
		 * The meta object literal for the '<em><b>Color Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_DOMAIN__COLOR_SPACE = eINSTANCE.getColorDomain_ColorSpace();

	}

} //VulkanPackage
