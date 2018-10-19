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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.VulkanFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/java' modelName='Vulkan' prefix='Vulkan' publicConstructors='true' updateClasspath='false' basePackage='org.sheepy.vulkan'"
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
	 * The feature id for the '<em><b>Compute Pools</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__COMPUTE_POOLS = 6;

	/**
	 * The feature id for the '<em><b>Graphic Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION__GRAPHIC_POOL = 7;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION_FEATURE_COUNT = 8;


	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_APPLICATION_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.VulkanApplication#getComputePools <em>Compute Pools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compute Pools</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getComputePools()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EReference getVulkanApplication_ComputePools();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.VulkanApplication#getGraphicPool <em>Graphic Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graphic Pool</em>'.
	 * @see org.sheepy.vulkan.model.VulkanApplication#getGraphicPool()
	 * @see #getVulkanApplication()
	 * @generated
	 */
	EReference getVulkanApplication_GraphicPool();

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
		 * The meta object literal for the '<em><b>Compute Pools</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_APPLICATION__COMPUTE_POOLS = eINSTANCE.getVulkanApplication_ComputePools();

		/**
		 * The meta object literal for the '<em><b>Graphic Pool</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULKAN_APPLICATION__GRAPHIC_POOL = eINSTANCE.getVulkanApplication_GraphicPool();

	}

} //VulkanPackage
