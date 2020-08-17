/**
 */
package org.sheepy.lily.openal.model.openal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.model.application.ApplicationPackage;

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
 * @see org.sheepy.lily.openal.model.openal.OpenalFactory
 * @model kind="package"
 * @generated
 */
public interface OpenalPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "openal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.openal";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "openal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OpenalPackage eINSTANCE = org.sheepy.lily.openal.model.openal.impl.OpenalPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.openal.model.openal.impl.OpenALEngineImpl <em>Open AL Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.openal.model.openal.impl.OpenALEngineImpl
	 * @see org.sheepy.lily.openal.model.openal.impl.OpenalPackageImpl#getOpenALEngine()
	 * @generated
	 */
	int OPEN_AL_ENGINE = 0;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_AL_ENGINE__RESOURCE_PKG = ApplicationPackage.IENGINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Open AL Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_AL_ENGINE_FEATURE_COUNT = ApplicationPackage.IENGINE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Open AL Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_AL_ENGINE_OPERATION_COUNT = ApplicationPackage.IENGINE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.openal.model.openal.OpenALEngine <em>Open AL Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open AL Engine</em>'.
	 * @see org.sheepy.lily.openal.model.openal.OpenALEngine
	 * @generated
	 */
	EClass getOpenALEngine();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.openal.model.openal.OpenALEngine#getResourcePkg <em>Resource Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Pkg</em>'.
	 * @see org.sheepy.lily.openal.model.openal.OpenALEngine#getResourcePkg()
	 * @see #getOpenALEngine()
	 * @generated
	 */
	EReference getOpenALEngine_ResourcePkg();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OpenalFactory getOpenalFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.openal.model.openal.impl.OpenALEngineImpl <em>Open AL Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.openal.model.openal.impl.OpenALEngineImpl
		 * @see org.sheepy.lily.openal.model.openal.impl.OpenalPackageImpl#getOpenALEngine()
		 * @generated
		 */
		EClass OPEN_AL_ENGINE = eINSTANCE.getOpenALEngine();
		/**
		 * The meta object literal for the '<em><b>Resource Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPEN_AL_ENGINE__RESOURCE_PKG = eINSTANCE.getOpenALEngine_ResourcePkg();

	}

} //OpenalPackage
