/**
 */
package org.sheepy.lily.vulkan.extra.model.shape;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;

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
 * @see org.sheepy.lily.vulkan.extra.model.shape.ShapeFactory
 * @model kind="package"
 * @generated
 */
public interface ShapePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "shape";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.model.shape";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "shape";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ShapePackage eINSTANCE = org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricStructureImpl <em>Geometric Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricStructureImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getGeometricStructure()
	 * @generated
	 */
	int GEOMETRIC_STRUCTURE = 0;

	/**
	 * The feature id for the '<em><b>Meshes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_STRUCTURE__MESHES = MeshPackage.MESH_STRUCTURE__MESHES;

	/**
	 * The number of structural features of the '<em>Geometric Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_STRUCTURE_FEATURE_COUNT = MeshPackage.MESH_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Geometric Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_STRUCTURE_OPERATION_COUNT = MeshPackage.MESH_STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricMeshImpl <em>Geometric Mesh</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricMeshImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getGeometricMesh()
	 * @generated
	 */
	int GEOMETRIC_MESH = 1;

	/**
	 * The feature id for the '<em><b>Presented Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_MESH__PRESENTED_ENTITIES = MeshPackage.MESH__PRESENTED_ENTITIES;

	/**
	 * The number of structural features of the '<em>Geometric Mesh</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_MESH_FEATURE_COUNT = MeshPackage.MESH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Geometric Mesh</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_MESH_OPERATION_COUNT = MeshPackage.MESH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.IcosahedronImpl <em>Icosahedron</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.IcosahedronImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getIcosahedron()
	 * @generated
	 */
	int ICOSAHEDRON = 2;

	/**
	 * The feature id for the '<em><b>Meshes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOSAHEDRON__MESHES = GEOMETRIC_STRUCTURE__MESHES;

	/**
	 * The number of structural features of the '<em>Icosahedron</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOSAHEDRON_FEATURE_COUNT = GEOMETRIC_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Icosahedron</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOSAHEDRON_OPERATION_COUNT = GEOMETRIC_STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.SphereImpl <em>Sphere</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.SphereImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getSphere()
	 * @generated
	 */
	int SPHERE = 3;

	/**
	 * The feature id for the '<em><b>Meshes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__MESHES = GEOMETRIC_STRUCTURE__MESHES;

	/**
	 * The feature id for the '<em><b>Slice Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE__SLICE_COUNT = GEOMETRIC_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sphere</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE_FEATURE_COUNT = GEOMETRIC_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sphere</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPHERE_OPERATION_COUNT = GEOMETRIC_STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.IcoSphereImpl <em>Ico Sphere</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.IcoSphereImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getIcoSphere()
	 * @generated
	 */
	int ICO_SPHERE = 4;

	/**
	 * The feature id for the '<em><b>Meshes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICO_SPHERE__MESHES = GEOMETRIC_STRUCTURE__MESHES;

	/**
	 * The feature id for the '<em><b>Subdivision Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICO_SPHERE__SUBDIVISION_COUNT = GEOMETRIC_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ico Sphere</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICO_SPHERE_FEATURE_COUNT = GEOMETRIC_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ico Sphere</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICO_SPHERE_OPERATION_COUNT = GEOMETRIC_STRUCTURE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.GeometricStructure <em>Geometric Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geometric Structure</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.GeometricStructure
	 * @generated
	 */
	EClass getGeometricStructure();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh <em>Geometric Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geometric Mesh</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh
	 * @generated
	 */
	EClass getGeometricMesh();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.Icosahedron <em>Icosahedron</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icosahedron</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.Icosahedron
	 * @generated
	 */
	EClass getIcosahedron();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.Sphere <em>Sphere</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sphere</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.Sphere
	 * @generated
	 */
	EClass getSphere();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.shape.Sphere#getSliceCount <em>Slice Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slice Count</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.Sphere#getSliceCount()
	 * @see #getSphere()
	 * @generated
	 */
	EAttribute getSphere_SliceCount();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.IcoSphere <em>Ico Sphere</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ico Sphere</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.IcoSphere
	 * @generated
	 */
	EClass getIcoSphere();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.shape.IcoSphere#getSubdivisionCount <em>Subdivision Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subdivision Count</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.IcoSphere#getSubdivisionCount()
	 * @see #getIcoSphere()
	 * @generated
	 */
	EAttribute getIcoSphere_SubdivisionCount();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ShapeFactory getShapeFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricStructureImpl <em>Geometric Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricStructureImpl
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getGeometricStructure()
		 * @generated
		 */
		EClass GEOMETRIC_STRUCTURE = eINSTANCE.getGeometricStructure();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricMeshImpl <em>Geometric Mesh</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricMeshImpl
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getGeometricMesh()
		 * @generated
		 */
		EClass GEOMETRIC_MESH = eINSTANCE.getGeometricMesh();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.IcosahedronImpl <em>Icosahedron</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.IcosahedronImpl
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getIcosahedron()
		 * @generated
		 */
		EClass ICOSAHEDRON = eINSTANCE.getIcosahedron();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.SphereImpl <em>Sphere</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.SphereImpl
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getSphere()
		 * @generated
		 */
		EClass SPHERE = eINSTANCE.getSphere();

		/**
		 * The meta object literal for the '<em><b>Slice Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPHERE__SLICE_COUNT = eINSTANCE.getSphere_SliceCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.IcoSphereImpl <em>Ico Sphere</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.IcoSphereImpl
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getIcoSphere()
		 * @generated
		 */
		EClass ICO_SPHERE = eINSTANCE.getIcoSphere();

		/**
		 * The meta object literal for the '<em><b>Subdivision Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICO_SPHERE__SUBDIVISION_COUNT = eINSTANCE.getIcoSphere_SubdivisionCount();

	}

} //ShapePackage
