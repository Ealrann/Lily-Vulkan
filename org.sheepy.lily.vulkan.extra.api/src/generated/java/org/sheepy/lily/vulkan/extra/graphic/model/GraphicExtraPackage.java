/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
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
 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraFactory
 * @model kind="package"
 * @generated
 */
public interface GraphicExtraPackage extends EPackage
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
	String eNS_URI = "org.sheepy.lily.vulkan.extra.graphic.model";

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
	GraphicExtraPackage eINSTANCE = org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.MeshProviderImpl <em>Mesh Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.MeshProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getMeshProvider()
	 * @generated
	 */
	int MESH_PROVIDER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PROVIDER__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Mesh Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PROVIDER_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mesh Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PROVIDER_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider <em>IData Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getIDataProvider()
	 * @generated
	 */
	int IDATA_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDATA_PROVIDER__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>IData Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDATA_PROVIDER_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IData Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDATA_PROVIDER_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.MeshProvider <em>Mesh Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.MeshProvider
	 * @generated
	 */
	EClass getMeshProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider <em>IData Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IData Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider
	 * @generated
	 */
	EClass getIDataProvider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphicExtraFactory getGraphicExtraFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.MeshProviderImpl <em>Mesh Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.MeshProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getMeshProvider()
		 * @generated
		 */
		EClass MESH_PROVIDER = eINSTANCE.getMeshProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider <em>IData Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getIDataProvider()
		 * @generated
		 */
		EClass IDATA_PROVIDER = eINSTANCE.getIDataProvider();

	}

} //GraphicExtraPackage
