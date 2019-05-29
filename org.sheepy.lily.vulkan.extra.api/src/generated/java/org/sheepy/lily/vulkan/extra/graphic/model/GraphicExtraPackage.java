/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ComplexMeshProviderImpl <em>Complex Mesh Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.ComplexMeshProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getComplexMeshProvider()
	 * @generated
	 */
	int COMPLEX_MESH_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MESH_PROVIDER__NAME = MESH_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Vertex Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER = MESH_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER = MESH_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Uniform Data Provider</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MESH_PROVIDER__UNIFORM_DATA_PROVIDER = MESH_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Complex Mesh Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MESH_PROVIDER_FEATURE_COUNT = MESH_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Complex Mesh Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_MESH_PROVIDER_OPERATION_COUNT = MESH_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider <em>IData Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getIDataProvider()
	 * @generated
	 */
	int IDATA_PROVIDER = 2;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.VertexDataProviderImpl <em>Vertex Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.VertexDataProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getVertexDataProvider()
	 * @generated
	 */
	int VERTEX_DATA_PROVIDER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_DATA_PROVIDER__NAME = IDATA_PROVIDER__NAME;

	/**
	 * The number of structural features of the '<em>Vertex Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_DATA_PROVIDER_FEATURE_COUNT = IDATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vertex Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_DATA_PROVIDER_OPERATION_COUNT = IDATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.IndexDataProviderImpl <em>Index Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.IndexDataProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getIndexDataProvider()
	 * @generated
	 */
	int INDEX_DATA_PROVIDER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DATA_PROVIDER__NAME = IDATA_PROVIDER__NAME;

	/**
	 * The number of structural features of the '<em>Index Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DATA_PROVIDER_FEATURE_COUNT = IDATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Index Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DATA_PROVIDER_OPERATION_COUNT = IDATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.UniformDataProviderImpl <em>Uniform Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.UniformDataProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getUniformDataProvider()
	 * @generated
	 */
	int UNIFORM_DATA_PROVIDER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_DATA_PROVIDER__NAME = IDATA_PROVIDER__NAME;

	/**
	 * The number of structural features of the '<em>Uniform Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_DATA_PROVIDER_FEATURE_COUNT = IDATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Uniform Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_DATA_PROVIDER_OPERATION_COUNT = IDATA_PROVIDER_OPERATION_COUNT + 0;


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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider <em>Complex Mesh Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Mesh Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider
	 * @generated
	 */
	EClass getComplexMeshProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getVertexDataProvider <em>Vertex Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertex Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getVertexDataProvider()
	 * @see #getComplexMeshProvider()
	 * @generated
	 */
	EReference getComplexMeshProvider_VertexDataProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getIndexDataProvider <em>Index Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getIndexDataProvider()
	 * @see #getComplexMeshProvider()
	 * @generated
	 */
	EReference getComplexMeshProvider_IndexDataProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getUniformDataProvider <em>Uniform Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uniform Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider#getUniformDataProvider()
	 * @see #getComplexMeshProvider()
	 * @generated
	 */
	EReference getComplexMeshProvider_UniformDataProvider();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.VertexDataProvider <em>Vertex Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.VertexDataProvider
	 * @generated
	 */
	EClass getVertexDataProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.IndexDataProvider <em>Index Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.IndexDataProvider
	 * @generated
	 */
	EClass getIndexDataProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.UniformDataProvider <em>Uniform Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uniform Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.UniformDataProvider
	 * @generated
	 */
	EClass getUniformDataProvider();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ComplexMeshProviderImpl <em>Complex Mesh Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.ComplexMeshProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getComplexMeshProvider()
		 * @generated
		 */
		EClass COMPLEX_MESH_PROVIDER = eINSTANCE.getComplexMeshProvider();

		/**
		 * The meta object literal for the '<em><b>Vertex Data Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER = eINSTANCE.getComplexMeshProvider_VertexDataProvider();

		/**
		 * The meta object literal for the '<em><b>Index Data Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER = eINSTANCE.getComplexMeshProvider_IndexDataProvider();

		/**
		 * The meta object literal for the '<em><b>Uniform Data Provider</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_MESH_PROVIDER__UNIFORM_DATA_PROVIDER = eINSTANCE.getComplexMeshProvider_UniformDataProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider <em>IData Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getIDataProvider()
		 * @generated
		 */
		EClass IDATA_PROVIDER = eINSTANCE.getIDataProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.VertexDataProviderImpl <em>Vertex Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.VertexDataProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getVertexDataProvider()
		 * @generated
		 */
		EClass VERTEX_DATA_PROVIDER = eINSTANCE.getVertexDataProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.IndexDataProviderImpl <em>Index Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.IndexDataProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getIndexDataProvider()
		 * @generated
		 */
		EClass INDEX_DATA_PROVIDER = eINSTANCE.getIndexDataProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.UniformDataProviderImpl <em>Uniform Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.UniformDataProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getUniformDataProvider()
		 * @generated
		 */
		EClass UNIFORM_DATA_PROVIDER = eINSTANCE.getUniformDataProvider();

	}

} //GraphicExtraPackage
