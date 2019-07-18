/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

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
 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshFactory
 * @model kind="package"
 * @generated
 */
public interface MeshPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mesh";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.model.mesh";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mesh";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeshPackage eINSTANCE = org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshImpl <em>Mesh</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshImpl
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl#getMesh()
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshRendererMaintainerImpl <em>Renderer Maintainer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshRendererMaintainerImpl
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl#getMeshRendererMaintainer()
	 * @generated
	 */
	int MESH_RENDERER_MAINTAINER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__NAME = RenderingPackage.GENERIC_RENDERER_MAINTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__RESOURCE_PKG = RenderingPackage.GENERIC_RENDERER_MAINTAINER__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__ENABLED = RenderingPackage.GENERIC_RENDERER_MAINTAINER__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__STAGE = RenderingPackage.GENERIC_RENDERER_MAINTAINER__STAGE;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__PUSH_CONSTANT_RANGES = RenderingPackage.GENERIC_RENDERER_MAINTAINER__PUSH_CONSTANT_RANGES;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__SPECIALIZATION_DATA = RenderingPackage.GENERIC_RENDERER_MAINTAINER__SPECIALIZATION_DATA;

	/**
	 * The feature id for the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__DESCRIPTOR_SET_PKG = RenderingPackage.GENERIC_RENDERER_MAINTAINER__DESCRIPTOR_SET_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__TASK_PKG = RenderingPackage.GENERIC_RENDERER_MAINTAINER__TASK_PKG;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__MAINTAINER = RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINER;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__SHADERS = RenderingPackage.GENERIC_RENDERER_MAINTAINER__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__VIEWPORT_STATE = RenderingPackage.GENERIC_RENDERER_MAINTAINER__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__INPUT_ASSEMBLY = RenderingPackage.GENERIC_RENDERER_MAINTAINER__INPUT_ASSEMBLY;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__RASTERIZER = RenderingPackage.GENERIC_RENDERER_MAINTAINER__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__COLOR_BLEND = RenderingPackage.GENERIC_RENDERER_MAINTAINER__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__DYNAMIC_STATE = RenderingPackage.GENERIC_RENDERER_MAINTAINER__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__SUBPASS = RenderingPackage.GENERIC_RENDERER_MAINTAINER__SUBPASS;

	/**
	 * The feature id for the '<em><b>Vertex Input State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__VERTEX_INPUT_STATE = RenderingPackage.GENERIC_RENDERER_MAINTAINER__VERTEX_INPUT_STATE;

	/**
	 * The feature id for the '<em><b>Maintained</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__MAINTAINED = RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED;

	/**
	 * The feature id for the '<em><b>Data Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__DATA_PROVIDER_PKG = RenderingPackage.GENERIC_RENDERER_MAINTAINER__DATA_PROVIDER_PKG;

	/**
	 * The feature id for the '<em><b>Presentation Pkg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__PRESENTATION_PKG = RenderingPackage.GENERIC_RENDERER_MAINTAINER__PRESENTATION_PKG;

	/**
	 * The feature id for the '<em><b>Constant Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__CONSTANT_BUFFER = RenderingPackage.GENERIC_RENDERER_MAINTAINER__CONSTANT_BUFFER;

	/**
	 * The feature id for the '<em><b>Basic Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__BASIC_RESOURCES = RenderingPackage.GENERIC_RENDERER_MAINTAINER__BASIC_RESOURCES;

	/**
	 * The feature id for the '<em><b>Push Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER__PUSH_BUFFER = RenderingPackage.GENERIC_RENDERER_MAINTAINER__PUSH_BUFFER;

	/**
	 * The number of structural features of the '<em>Renderer Maintainer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_MAINTAINER_FEATURE_COUNT = RenderingPackage.GENERIC_RENDERER_MAINTAINER_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.mesh.Mesh <em>Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.Mesh
	 * @generated
	 */
	EClass getMesh();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.mesh.MeshRendererMaintainer <em>Renderer Maintainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Renderer Maintainer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshRendererMaintainer
	 * @generated
	 */
	EClass getMeshRendererMaintainer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MeshFactory getMeshFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshImpl <em>Mesh</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshImpl
		 * @see org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl#getMesh()
		 * @generated
		 */
		EClass MESH = eINSTANCE.getMesh();
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshRendererMaintainerImpl <em>Renderer Maintainer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshRendererMaintainerImpl
		 * @see org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl#getMeshRendererMaintainer()
		 * @generated
		 */
		EClass MESH_RENDERER_MAINTAINER = eINSTANCE.getMeshRendererMaintainer();

	}

} //MeshPackage
