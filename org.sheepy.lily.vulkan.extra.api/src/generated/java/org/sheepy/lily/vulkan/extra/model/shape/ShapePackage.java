/**
 */
package org.sheepy.lily.vulkan.extra.model.shape;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.Mesh <em>Mesh</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.Mesh
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getMesh()
	 * @generated
	 */
	int MESH = 0;

	/**
	 * The feature id for the '<em><b>Presented Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH__PRESENTED_ENTITIES = RenderingPackage.PRESENTATION__PRESENTED_ENTITIES;

	/**
	 * The number of structural features of the '<em>Mesh</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_FEATURE_COUNT = RenderingPackage.PRESENTATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mesh</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_OPERATION_COUNT = RenderingPackage.PRESENTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.MeshRendererImpl <em>Mesh Renderer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.MeshRendererImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getMeshRenderer()
	 * @generated
	 */
	int MESH_RENDERER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__NAME = RenderingPackage.GENERIC_RENDERER__NAME;

	/**
	 * The feature id for the '<em><b>Allocate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__ALLOCATE = RenderingPackage.GENERIC_RENDERER__ALLOCATE;

	/**
	 * The feature id for the '<em><b>Record</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__RECORD = RenderingPackage.GENERIC_RENDERER__RECORD;

	/**
	 * The feature id for the '<em><b>Extension Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__EXTENSION_PKG = RenderingPackage.GENERIC_RENDERER__EXTENSION_PKG;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__RESOURCE_PKG = RenderingPackage.GENERIC_RENDERER__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DESCRIPTOR_PKG = RenderingPackage.GENERIC_RENDERER__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkgs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__TASK_PKGS = RenderingPackage.GENERIC_RENDERER__TASK_PKGS;

	/**
	 * The feature id for the '<em><b>Descriptor Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DESCRIPTOR_POOL = RenderingPackage.GENERIC_RENDERER__DESCRIPTOR_POOL;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__SPECIALIZATION_DATA = RenderingPackage.GENERIC_RENDERER__SPECIALIZATION_DATA;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__PUSH_CONSTANT_RANGES = RenderingPackage.GENERIC_RENDERER__PUSH_CONSTANT_RANGES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__LAYOUT = RenderingPackage.GENERIC_RENDERER__LAYOUT;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__MAINTAINER = RenderingPackage.GENERIC_RENDERER__MAINTAINER;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__SHADERS = RenderingPackage.GENERIC_RENDERER__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__VIEWPORT_STATE = RenderingPackage.GENERIC_RENDERER__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__INPUT_ASSEMBLY = RenderingPackage.GENERIC_RENDERER__INPUT_ASSEMBLY;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__RASTERIZER = RenderingPackage.GENERIC_RENDERER__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__COLOR_BLEND = RenderingPackage.GENERIC_RENDERER__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DYNAMIC_STATE = RenderingPackage.GENERIC_RENDERER__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Vertex Input State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__VERTEX_INPUT_STATE = RenderingPackage.GENERIC_RENDERER__VERTEX_INPUT_STATE;

	/**
	 * The feature id for the '<em><b>Depth Stencil State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DEPTH_STENCIL_STATE = RenderingPackage.GENERIC_RENDERER__DEPTH_STENCIL_STATE;

	/**
	 * The feature id for the '<em><b>Maintained</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__MAINTAINED = RenderingPackage.GENERIC_RENDERER__MAINTAINED;

	/**
	 * The feature id for the '<em><b>Data Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DATA_PROVIDER_PKG = RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG;

	/**
	 * The feature id for the '<em><b>Rendered Structures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__RENDERED_STRUCTURES = RenderingPackage.GENERIC_RENDERER__RENDERED_STRUCTURES;

	/**
	 * The feature id for the '<em><b>Constant Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__CONSTANT_BUFFER = RenderingPackage.GENERIC_RENDERER__CONSTANT_BUFFER;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__TRANSFER_BUFFER = RenderingPackage.GENERIC_RENDERER__TRANSFER_BUFFER;

	/**
	 * The feature id for the '<em><b>Descriptor Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DESCRIPTOR_PROVIDER_PKG = RenderingPackage.GENERIC_RENDERER__DESCRIPTOR_PROVIDER_PKG;

	/**
	 * The feature id for the '<em><b>Specialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__SPECIALIZATION = RenderingPackage.GENERIC_RENDERER__SPECIALIZATION;

	/**
	 * The feature id for the '<em><b>Flush Transfer Buffer Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__FLUSH_TRANSFER_BUFFER_TASK = RenderingPackage.GENERIC_RENDERER__FLUSH_TRANSFER_BUFFER_TASK;

	/**
	 * The feature id for the '<em><b>One Pipeline Per Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__ONE_PIPELINE_PER_PART = RenderingPackage.GENERIC_RENDERER__ONE_PIPELINE_PER_PART;

	/**
	 * The feature id for the '<em><b>Maintaining</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__MAINTAINING = RenderingPackage.GENERIC_RENDERER__MAINTAINING;

	/**
	 * The number of structural features of the '<em>Mesh Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_FEATURE_COUNT = RenderingPackage.GENERIC_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mesh Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_OPERATION_COUNT = RenderingPackage.GENERIC_RENDERER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.IMeshStructureImpl <em>IMesh Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.IMeshStructureImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getIMeshStructure()
	 * @generated
	 */
	int IMESH_STRUCTURE = 3;

	/**
	 * The number of structural features of the '<em>IMesh Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMESH_STRUCTURE_FEATURE_COUNT = RenderingPackage.STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IMesh Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMESH_STRUCTURE_OPERATION_COUNT = RenderingPackage.STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.MeshStructure <em>Mesh Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.MeshStructure
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getMeshStructure()
	 * @generated
	 */
	int MESH_STRUCTURE = 2;

	/**
	 * The feature id for the '<em><b>Meshes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_STRUCTURE__MESHES = IMESH_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mesh Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_STRUCTURE_FEATURE_COUNT = IMESH_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mesh Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_STRUCTURE_OPERATION_COUNT = IMESH_STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricStructureImpl <em>Geometric Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricStructureImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getGeometricStructure()
	 * @generated
	 */
	int GEOMETRIC_STRUCTURE = 4;

	/**
	 * The feature id for the '<em><b>Meshes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_STRUCTURE__MESHES = MESH_STRUCTURE__MESHES;

	/**
	 * The number of structural features of the '<em>Geometric Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_STRUCTURE_FEATURE_COUNT = MESH_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Geometric Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_STRUCTURE_OPERATION_COUNT = MESH_STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricMeshImpl <em>Geometric Mesh</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.GeometricMeshImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getGeometricMesh()
	 * @generated
	 */
	int GEOMETRIC_MESH = 5;

	/**
	 * The feature id for the '<em><b>Presented Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_MESH__PRESENTED_ENTITIES = MESH__PRESENTED_ENTITIES;

	/**
	 * The number of structural features of the '<em>Geometric Mesh</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_MESH_FEATURE_COUNT = MESH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Geometric Mesh</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOMETRIC_MESH_OPERATION_COUNT = MESH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.IcosahedronImpl <em>Icosahedron</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.IcosahedronImpl
	 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getIcosahedron()
	 * @generated
	 */
	int ICOSAHEDRON = 6;

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
	int SPHERE = 7;

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
	int ICO_SPHERE = 8;

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.Mesh <em>Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.Mesh
	 * @generated
	 */
	EClass getMesh();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.MeshRenderer <em>Mesh Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Renderer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.MeshRenderer
	 * @generated
	 */
	EClass getMeshRenderer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.MeshStructure <em>Mesh Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Structure</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.MeshStructure
	 * @generated
	 */
	EClass getMeshStructure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.shape.MeshStructure#getMeshes <em>Meshes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meshes</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.MeshStructure#getMeshes()
	 * @see #getMeshStructure()
	 * @generated
	 */
	EReference getMeshStructure_Meshes();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.shape.IMeshStructure <em>IMesh Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMesh Structure</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.IMeshStructure
	 * @generated
	 */
	EClass getIMeshStructure();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.Mesh <em>Mesh</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.Mesh
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getMesh()
		 * @generated
		 */
		EClass MESH = eINSTANCE.getMesh();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.MeshRendererImpl <em>Mesh Renderer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.MeshRendererImpl
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getMeshRenderer()
		 * @generated
		 */
		EClass MESH_RENDERER = eINSTANCE.getMeshRenderer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.MeshStructure <em>Mesh Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.MeshStructure
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getMeshStructure()
		 * @generated
		 */
		EClass MESH_STRUCTURE = eINSTANCE.getMeshStructure();

		/**
		 * The meta object literal for the '<em><b>Meshes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESH_STRUCTURE__MESHES = eINSTANCE.getMeshStructure_Meshes();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.shape.impl.IMeshStructureImpl <em>IMesh Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.IMeshStructureImpl
		 * @see org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl#getIMeshStructure()
		 * @generated
		 */
		EClass IMESH_STRUCTURE = eINSTANCE.getIMeshStructure();

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
