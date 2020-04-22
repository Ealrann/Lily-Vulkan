/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

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
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory
 * @model kind="package"
 * @generated
 */
public interface RenderingPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rendering";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.model.rendering";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rendering";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RenderingPackage eINSTANCE = org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Entity <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Entity
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl <em>Physical Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPhysicalEntity()
	 * @generated
	 */
	int PHYSICAL_ENTITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Geo Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__GEO_LOCATION = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Geo Orientation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__GEO_ORIENTATION = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Axis Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__AXIS_LOCATION = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY__AXIS = ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Physical Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Physical Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl <em>Axis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getAxis()
	 * @generated
	 */
	int AXIS = 2;

	/**
	 * The feature id for the '<em><b>Front Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS__FRONT_DIRECTION = 0;

	/**
	 * The feature id for the '<em><b>Up Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS__UP_DIRECTION = 1;

	/**
	 * The feature id for the '<em><b>Right Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS__RIGHT_DIRECTION = 2;

	/**
	 * The number of structural features of the '<em>Axis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Axis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Structure <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Structure
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 3;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation <em>Presentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentation()
	 * @generated
	 */
	int PRESENTATION = 4;

	/**
	 * The feature id for the '<em><b>Presented Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION__PRESENTED_ENTITIES = 0;

	/**
	 * The number of structural features of the '<em>Presentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Presentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl <em>Presentation Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentationPkg()
	 * @generated
	 */
	int PRESENTATION_PKG = 5;

	/**
	 * The feature id for the '<em><b>Structures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_PKG__STRUCTURES = 0;

	/**
	 * The number of structural features of the '<em>Presentation Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Presentation Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl <em>Presentable Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentableEntity()
	 * @generated
	 */
	int PRESENTABLE_ENTITY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__NAME = PHYSICAL_ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Geo Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__GEO_LOCATION = PHYSICAL_ENTITY__GEO_LOCATION;

	/**
	 * The feature id for the '<em><b>Geo Orientation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__GEO_ORIENTATION = PHYSICAL_ENTITY__GEO_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Axis Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__AXIS_LOCATION = PHYSICAL_ENTITY__AXIS_LOCATION;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__AXIS = PHYSICAL_ENTITY__AXIS;

	/**
	 * The feature id for the '<em><b>Presentation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__PRESENTATION = PHYSICAL_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY__SCALE = PHYSICAL_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Presentable Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY_FEATURE_COUNT = PHYSICAL_ENTITY_FEATURE_COUNT + 2;


	/**
	 * The number of operations of the '<em>Presentable Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTABLE_ENTITY_OPERATION_COUNT = PHYSICAL_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl <em>Generic Renderer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getGenericRenderer()
	 * @generated
	 */
	int GENERIC_RENDERER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__NAME = GraphicPackage.GRAPHICS_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__ENABLED = GraphicPackage.GRAPHICS_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__STAGE = GraphicPackage.GRAPHICS_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__RESOURCE_PKG = GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__DESCRIPTOR_PKG = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__TASK_PKG = GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__DESCRIPTOR_POOL = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_POOL;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__SPECIALIZATION_DATA = GraphicPackage.GRAPHICS_PIPELINE__SPECIALIZATION_DATA;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__PUSH_CONSTANT_RANGES = GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__LAYOUT = GraphicPackage.GRAPHICS_PIPELINE__LAYOUT;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__MAINTAINER = GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__SHADERS = GraphicPackage.GRAPHICS_PIPELINE__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__VIEWPORT_STATE = GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__INPUT_ASSEMBLY = GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__RASTERIZER = GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__COLOR_BLEND = GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__DYNAMIC_STATE = GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Vertex Input State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__VERTEX_INPUT_STATE = GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE;

	/**
	 * The feature id for the '<em><b>Depth Stencil State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__DEPTH_STENCIL_STATE = GraphicPackage.GRAPHICS_PIPELINE__DEPTH_STENCIL_STATE;

	/**
	 * The feature id for the '<em><b>Maintained</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__MAINTAINED = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__DATA_PROVIDER_PKG = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rendered Structures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__RENDERED_STRUCTURES = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constant Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__CONSTANT_BUFFER = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__TRANSFER_BUFFER = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Descriptor Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__DESCRIPTOR_PROVIDER_PKG = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Specialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__SPECIALIZATION = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Flush Transfer Buffer Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__FLUSH_TRANSFER_BUFFER_TASK = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>One Pipeline Per Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__ONE_PIPELINE_PER_PART = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Generic Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER_FEATURE_COUNT = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Generic Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER_OPERATION_COUNT = GraphicPackage.GRAPHICS_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider <em>Render Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderDataProvider()
	 * @generated
	 */
	int RENDER_DATA_PROVIDER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__NAME = VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Used To Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__USED_TO_PUSH = VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_PUSH;

	/**
	 * The feature id for the '<em><b>Used To Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__USED_TO_FETCH = VulkanResourcePackage.BUFFER_DATA_PROVIDER__USED_TO_FETCH;

	/**
	 * The feature id for the '<em><b>Stage Before Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__STAGE_BEFORE_PUSH = VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH;

	/**
	 * The feature id for the '<em><b>Access Before Push</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__ACCESS_BEFORE_PUSH = VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH;

	/**
	 * The feature id for the '<em><b>Stage Before Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__STAGE_BEFORE_FETCH = VulkanResourcePackage.BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH;

	/**
	 * The feature id for the '<em><b>Access Before Fetch</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__ACCESS_BEFORE_FETCH = VulkanResourcePackage.BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__USAGES = VulkanResourcePackage.BUFFER_DATA_PROVIDER__USAGES;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__INSTANCE_COUNT = VulkanResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT;

	/**
	 * The feature id for the '<em><b>Grow Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__GROW_FACTOR = VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_FACTOR;

	/**
	 * The feature id for the '<em><b>Grow Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__GROW_THRESHOLD = VulkanResourcePackage.BUFFER_DATA_PROVIDER__GROW_THRESHOLD;

	/**
	 * The feature id for the '<em><b>Min Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__MIN_SIZE = VulkanResourcePackage.BUFFER_DATA_PROVIDER__MIN_SIZE;

	/**
	 * The feature id for the '<em><b>Requested Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__REQUESTED_SIZE = VulkanResourcePackage.BUFFER_DATA_PROVIDER__REQUESTED_SIZE;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__DATA_SOURCE = VulkanResourcePackage.BUFFER_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Render Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER_FEATURE_COUNT = VulkanResourcePackage.BUFFER_DATA_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Render Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER_OPERATION_COUNT = VulkanResourcePackage.BUFFER_DATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderPkgImpl <em>Data Provider Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderPkgImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDataProviderPkg()
	 * @generated
	 */
	int DATA_PROVIDER_PKG = 9;

	/**
	 * The feature id for the '<em><b>Data Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROVIDER_PKG__DATA_PROVIDERS = 0;

	/**
	 * The number of structural features of the '<em>Data Provider Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROVIDER_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Provider Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROVIDER_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl <em>Renderable Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderableDataSource()
	 * @generated
	 */
	int RENDERABLE_DATA_SOURCE = 10;

	/**
	 * The feature id for the '<em><b>Structure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERABLE_DATA_SOURCE__STRUCTURE = 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERABLE_DATA_SOURCE__PART = 1;

	/**
	 * The number of structural features of the '<em>Renderable Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERABLE_DATA_SOURCE_FEATURE_COUNT = 2;


	/**
	 * The number of operations of the '<em>Renderable Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERABLE_DATA_SOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.VertexProviderImpl <em>Vertex Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.VertexProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getVertexProvider()
	 * @generated
	 */
	int VERTEX_PROVIDER = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__NAME = RENDER_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Used To Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__USED_TO_PUSH = RENDER_DATA_PROVIDER__USED_TO_PUSH;

	/**
	 * The feature id for the '<em><b>Used To Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__USED_TO_FETCH = RENDER_DATA_PROVIDER__USED_TO_FETCH;

	/**
	 * The feature id for the '<em><b>Stage Before Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__STAGE_BEFORE_PUSH = RENDER_DATA_PROVIDER__STAGE_BEFORE_PUSH;

	/**
	 * The feature id for the '<em><b>Access Before Push</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__ACCESS_BEFORE_PUSH = RENDER_DATA_PROVIDER__ACCESS_BEFORE_PUSH;

	/**
	 * The feature id for the '<em><b>Stage Before Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__STAGE_BEFORE_FETCH = RENDER_DATA_PROVIDER__STAGE_BEFORE_FETCH;

	/**
	 * The feature id for the '<em><b>Access Before Fetch</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__ACCESS_BEFORE_FETCH = RENDER_DATA_PROVIDER__ACCESS_BEFORE_FETCH;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__USAGES = RENDER_DATA_PROVIDER__USAGES;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__INSTANCE_COUNT = RENDER_DATA_PROVIDER__INSTANCE_COUNT;

	/**
	 * The feature id for the '<em><b>Grow Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__GROW_FACTOR = RENDER_DATA_PROVIDER__GROW_FACTOR;

	/**
	 * The feature id for the '<em><b>Grow Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__GROW_THRESHOLD = RENDER_DATA_PROVIDER__GROW_THRESHOLD;

	/**
	 * The feature id for the '<em><b>Min Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__MIN_SIZE = RENDER_DATA_PROVIDER__MIN_SIZE;

	/**
	 * The feature id for the '<em><b>Requested Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__REQUESTED_SIZE = RENDER_DATA_PROVIDER__REQUESTED_SIZE;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__DATA_SOURCE = RENDER_DATA_PROVIDER__DATA_SOURCE;

	/**
	 * The number of structural features of the '<em>Vertex Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER_FEATURE_COUNT = RENDER_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vertex Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER_OPERATION_COUNT = RENDER_DATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.IndexProviderImpl <em>Index Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.IndexProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getIndexProvider()
	 * @generated
	 */
	int INDEX_PROVIDER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__NAME = RENDER_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Used To Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__USED_TO_PUSH = RENDER_DATA_PROVIDER__USED_TO_PUSH;

	/**
	 * The feature id for the '<em><b>Used To Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__USED_TO_FETCH = RENDER_DATA_PROVIDER__USED_TO_FETCH;

	/**
	 * The feature id for the '<em><b>Stage Before Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__STAGE_BEFORE_PUSH = RENDER_DATA_PROVIDER__STAGE_BEFORE_PUSH;

	/**
	 * The feature id for the '<em><b>Access Before Push</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__ACCESS_BEFORE_PUSH = RENDER_DATA_PROVIDER__ACCESS_BEFORE_PUSH;

	/**
	 * The feature id for the '<em><b>Stage Before Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__STAGE_BEFORE_FETCH = RENDER_DATA_PROVIDER__STAGE_BEFORE_FETCH;

	/**
	 * The feature id for the '<em><b>Access Before Fetch</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__ACCESS_BEFORE_FETCH = RENDER_DATA_PROVIDER__ACCESS_BEFORE_FETCH;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__USAGES = RENDER_DATA_PROVIDER__USAGES;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__INSTANCE_COUNT = RENDER_DATA_PROVIDER__INSTANCE_COUNT;

	/**
	 * The feature id for the '<em><b>Grow Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__GROW_FACTOR = RENDER_DATA_PROVIDER__GROW_FACTOR;

	/**
	 * The feature id for the '<em><b>Grow Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__GROW_THRESHOLD = RENDER_DATA_PROVIDER__GROW_THRESHOLD;

	/**
	 * The feature id for the '<em><b>Min Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__MIN_SIZE = RENDER_DATA_PROVIDER__MIN_SIZE;

	/**
	 * The feature id for the '<em><b>Requested Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__REQUESTED_SIZE = RENDER_DATA_PROVIDER__REQUESTED_SIZE;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__DATA_SOURCE = RENDER_DATA_PROVIDER__DATA_SOURCE;

	/**
	 * The feature id for the '<em><b>Index Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__INDEX_TYPE = RENDER_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Index Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER_FEATURE_COUNT = RENDER_DATA_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Index Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER_OPERATION_COUNT = RENDER_DATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider <em>Resource Descriptor Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getResourceDescriptorProvider()
	 * @generated
	 */
	int RESOURCE_DESCRIPTOR_PROVIDER = 13;

	/**
	 * The number of structural features of the '<em>Resource Descriptor Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR_PROVIDER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Resource Descriptor Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR_PROVIDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DescriptorsProviderImpl <em>Descriptors Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DescriptorsProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDescriptorsProvider()
	 * @generated
	 */
	int DESCRIPTORS_PROVIDER = 14;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTORS_PROVIDER__DESCRIPTORS = RESOURCE_DESCRIPTOR_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Descriptors Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTORS_PROVIDER_FEATURE_COUNT = RESOURCE_DESCRIPTOR_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Descriptors Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTORS_PROVIDER_OPERATION_COUNT = RESOURCE_DESCRIPTOR_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorsProviderImpl <em>Data Descriptors Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorsProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDataDescriptorsProvider()
	 * @generated
	 */
	int DATA_DESCRIPTORS_PROVIDER = 15;

	/**
	 * The feature id for the '<em><b>Data Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS = RESOURCE_DESCRIPTOR_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Descriptors Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTORS_PROVIDER_FEATURE_COUNT = RESOURCE_DESCRIPTOR_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Descriptors Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTORS_PROVIDER_OPERATION_COUNT = RESOURCE_DESCRIPTOR_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorImpl <em>Data Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDataDescriptor()
	 * @generated
	 */
	int DATA_DESCRIPTOR = 16;

	/**
	 * The feature id for the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTOR__PART = 0;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTOR__INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTOR__DESCRIPTOR_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTOR__STAGES = 3;

	/**
	 * The number of structural features of the '<em>Data Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Data Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.ResourceDescriptorProviderPkgImpl <em>Resource Descriptor Provider Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.ResourceDescriptorProviderPkgImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getResourceDescriptorProviderPkg()
	 * @generated
	 */
	int RESOURCE_DESCRIPTOR_PROVIDER_PKG = 17;

	/**
	 * The feature id for the '<em><b>Resource Descriptor Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS = 0;

	/**
	 * The number of structural features of the '<em>Resource Descriptor Provider Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR_PROVIDER_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Resource Descriptor Provider Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DESCRIPTOR_PROVIDER_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderProxyConstantBufferImpl <em>Render Proxy Constant Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderProxyConstantBufferImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderProxyConstantBuffer()
	 * @generated
	 */
	int RENDER_PROXY_CONSTANT_BUFFER = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PROXY_CONSTANT_BUFFER__NAME = VulkanResourcePackage.CONSTANT_BUFFER__NAME;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PROXY_CONSTANT_BUFFER__DATA = VulkanResourcePackage.CONSTANT_BUFFER__DATA;

	/**
	 * The feature id for the '<em><b>Constant Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER = VulkanResourcePackage.CONSTANT_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX = VulkanResourcePackage.CONSTANT_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Render Proxy Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PROXY_CONSTANT_BUFFER_FEATURE_COUNT = VulkanResourcePackage.CONSTANT_BUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Render Proxy Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_PROXY_CONSTANT_BUFFER_OPERATION_COUNT = VulkanResourcePackage.CONSTANT_BUFFER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.ISpecializationImpl <em>ISpecialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.ISpecializationImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getISpecialization()
	 * @generated
	 */
	int ISPECIALIZATION = 19;

	/**
	 * The number of structural features of the '<em>ISpecialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISPECIALIZATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>ISpecialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISPECIALIZATION_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.EntityPkgImpl <em>Entity Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.EntityPkgImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getEntityPkg()
	 * @generated
	 */
	int ENTITY_PKG = 20;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PKG__ENTITIES = 0;

	/**
	 * The number of structural features of the '<em>Entity Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Entity Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PKG_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderDrawTaskImpl <em>Render Draw Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderDrawTaskImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderDrawTask()
	 * @generated
	 */
	int RENDER_DRAW_TASK = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DRAW_TASK__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DRAW_TASK__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Vertex Providers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DRAW_TASK__VERTEX_PROVIDERS = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Render Draw Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DRAW_TASK_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Render Draw Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DRAW_TASK_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderIndexedDrawTaskImpl <em>Render Indexed Draw Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderIndexedDrawTaskImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderIndexedDrawTask()
	 * @generated
	 */
	int RENDER_INDEXED_DRAW_TASK = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_INDEXED_DRAW_TASK__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_INDEXED_DRAW_TASK__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Index Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_INDEXED_DRAW_TASK__STRUCTURE = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Render Indexed Draw Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_INDEXED_DRAW_TASK_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Render Indexed Draw Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_INDEXED_DRAW_TASK_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityVariableImpl <em>Physical Entity Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityVariableImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPhysicalEntityVariable()
	 * @generated
	 */
	int PHYSICAL_ENTITY_VARIABLE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY_VARIABLE__NAME = VariablePackage.IMODEL_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY_VARIABLE__ENTITY = VariablePackage.IMODEL_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY_VARIABLE__FEATURE = VariablePackage.IMODEL_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Physical Entity Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY_VARIABLE_FEATURE_COUNT = VariablePackage.IMODEL_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Physical Entity Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ENTITY_VARIABLE_OPERATION_COUNT = VariablePackage.IMODEL_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature <em>EPhysical Entity Feature</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getEPhysicalEntityFeature()
	 * @generated
	 */
	int EPHYSICAL_ENTITY_FEATURE = 24;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity <em>Physical Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physical Entity</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity
	 * @generated
	 */
	EClass getPhysicalEntity();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoLocation <em>Geo Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geo Location</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoLocation()
	 * @see #getPhysicalEntity()
	 * @generated
	 */
	EAttribute getPhysicalEntity_GeoLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoOrientation <em>Geo Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geo Orientation</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getGeoOrientation()
	 * @see #getPhysicalEntity()
	 * @generated
	 */
	EAttribute getPhysicalEntity_GeoOrientation();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxisLocation <em>Axis Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Axis Location</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxisLocation()
	 * @see #getPhysicalEntity()
	 * @generated
	 */
	EAttribute getPhysicalEntity_AxisLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxis <em>Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Axis</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity#getAxis()
	 * @see #getPhysicalEntity()
	 * @generated
	 */
	EReference getPhysicalEntity_Axis();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis <em>Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Axis</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis
	 * @generated
	 */
	EClass getAxis();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getFrontDirection <em>Front Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Front Direction</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis#getFrontDirection()
	 * @see #getAxis()
	 * @generated
	 */
	EAttribute getAxis_FrontDirection();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getUpDirection <em>Up Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Up Direction</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis#getUpDirection()
	 * @see #getAxis()
	 * @generated
	 */
	EAttribute getAxis_UpDirection();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis#getRightDirection <em>Right Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right Direction</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis#getRightDirection()
	 * @see #getAxis()
	 * @generated
	 */
	EAttribute getAxis_RightDirection();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation <em>Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation
	 * @generated
	 */
	EClass getPresentation();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation#getPresentedEntities <em>Presented Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Presented Entities</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation#getPresentedEntities()
	 * @see #getPresentation()
	 * @generated
	 */
	EReference getPresentation_PresentedEntities();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg <em>Presentation Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg
	 * @generated
	 */
	EClass getPresentationPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg#getStructures <em>Structures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structures</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg#getStructures()
	 * @see #getPresentationPkg()
	 * @generated
	 */
	EReference getPresentationPkg_Structures();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity <em>Presentable Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentable Entity</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity
	 * @generated
	 */
	EClass getPresentableEntity();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getPresentation <em>Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Presentation</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getPresentation()
	 * @see #getPresentableEntity()
	 * @generated
	 */
	EReference getPresentableEntity_Presentation();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getScale()
	 * @see #getPresentableEntity()
	 * @generated
	 */
	EAttribute getPresentableEntity_Scale();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer <em>Generic Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Renderer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer
	 * @generated
	 */
	EClass getGenericRenderer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getDataProviderPkg <em>Data Provider Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Provider Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getDataProviderPkg()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_DataProviderPkg();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getRenderedStructures <em>Rendered Structures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rendered Structures</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getRenderedStructures()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_RenderedStructures();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getConstantBuffer <em>Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constant Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getConstantBuffer()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_ConstantBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getTransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getTransferBuffer()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_TransferBuffer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getDescriptorProviderPkg <em>Descriptor Provider Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor Provider Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getDescriptorProviderPkg()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_DescriptorProviderPkg();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getSpecialization <em>Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specialization</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getSpecialization()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_Specialization();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getFlushTransferBufferTask <em>Flush Transfer Buffer Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Flush Transfer Buffer Task</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getFlushTransferBufferTask()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_FlushTransferBufferTask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#isOnePipelinePerPart <em>One Pipeline Per Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One Pipeline Per Part</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#isOnePipelinePerPart()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EAttribute getGenericRenderer_OnePipelinePerPart();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider <em>Render Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider
	 * @generated
	 */
	EClass getRenderDataProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider#getDataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Source</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider#getDataSource()
	 * @see #getRenderDataProvider()
	 * @generated
	 */
	EReference getRenderDataProvider_DataSource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg <em>Data Provider Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Provider Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg
	 * @generated
	 */
	EClass getDataProviderPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg#getDataProviders <em>Data Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Providers</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg#getDataProviders()
	 * @see #getDataProviderPkg()
	 * @generated
	 */
	EReference getDataProviderPkg_DataProviders();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource <em>Renderable Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Renderable Data Source</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource
	 * @generated
	 */
	EClass getRenderableDataSource();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getStructure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Structure</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getStructure()
	 * @see #getRenderableDataSource()
	 * @generated
	 */
	EReference getRenderableDataSource_Structure();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource#getPart()
	 * @see #getRenderableDataSource()
	 * @generated
	 */
	EAttribute getRenderableDataSource_Part();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider <em>Vertex Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider
	 * @generated
	 */
	EClass getVertexProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider <em>Index Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider
	 * @generated
	 */
	EClass getIndexProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider#getIndexType <em>Index Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Type</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider#getIndexType()
	 * @see #getIndexProvider()
	 * @generated
	 */
	EAttribute getIndexProvider_IndexType();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider <em>Resource Descriptor Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Descriptor Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider
	 * @generated
	 */
	EClass getResourceDescriptorProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider <em>Descriptors Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptors Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider
	 * @generated
	 */
	EClass getDescriptorsProvider();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider#getDescriptors()
	 * @see #getDescriptorsProvider()
	 * @generated
	 */
	EReference getDescriptorsProvider_Descriptors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider <em>Data Descriptors Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Descriptors Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider
	 * @generated
	 */
	EClass getDataDescriptorsProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider#getDataDescriptors <em>Data Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Descriptors</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider#getDataDescriptors()
	 * @see #getDataDescriptorsProvider()
	 * @generated
	 */
	EReference getDataDescriptorsProvider_DataDescriptors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor <em>Data Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor
	 * @generated
	 */
	EClass getDataDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getPart()
	 * @see #getDataDescriptor()
	 * @generated
	 */
	EAttribute getDataDescriptor_Part();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getInstance()
	 * @see #getDataDescriptor()
	 * @generated
	 */
	EAttribute getDataDescriptor_Instance();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getDescriptorType <em>Descriptor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descriptor Type</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getDescriptorType()
	 * @see #getDataDescriptor()
	 * @generated
	 */
	EAttribute getDataDescriptor_DescriptorType();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getStages <em>Stages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stages</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getStages()
	 * @see #getDataDescriptor()
	 * @generated
	 */
	EAttribute getDataDescriptor_Stages();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg <em>Resource Descriptor Provider Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Descriptor Provider Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg
	 * @generated
	 */
	EClass getResourceDescriptorProviderPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg#getResourceDescriptorProviders <em>Resource Descriptor Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Descriptor Providers</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg#getResourceDescriptorProviders()
	 * @see #getResourceDescriptorProviderPkg()
	 * @generated
	 */
	EReference getResourceDescriptorProviderPkg_ResourceDescriptorProviders();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer <em>Render Proxy Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Proxy Constant Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer
	 * @generated
	 */
	EClass getRenderProxyConstantBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer#getConstantBuffer <em>Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constant Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer#getConstantBuffer()
	 * @see #getRenderProxyConstantBuffer()
	 * @generated
	 */
	EReference getRenderProxyConstantBuffer_ConstantBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer#getPartIndex <em>Part Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Index</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer#getPartIndex()
	 * @see #getRenderProxyConstantBuffer()
	 * @generated
	 */
	EAttribute getRenderProxyConstantBuffer_PartIndex();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization <em>ISpecialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISpecialization</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization
	 * @generated
	 */
	EClass getISpecialization();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg <em>Entity Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg
	 * @generated
	 */
	EClass getEntityPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg#getEntities()
	 * @see #getEntityPkg()
	 * @generated
	 */
	EReference getEntityPkg_Entities();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDrawTask <em>Render Draw Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Draw Task</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderDrawTask
	 * @generated
	 */
	EClass getRenderDrawTask();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDrawTask#getVertexProviders <em>Vertex Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Vertex Providers</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderDrawTask#getVertexProviders()
	 * @see #getRenderDrawTask()
	 * @generated
	 */
	EReference getRenderDrawTask_VertexProviders();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask <em>Render Indexed Draw Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Indexed Draw Task</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask
	 * @generated
	 */
	EClass getRenderIndexedDrawTask();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask#getIndexProvider <em>Index Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Index Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask#getIndexProvider()
	 * @see #getRenderIndexedDrawTask()
	 * @generated
	 */
	EReference getRenderIndexedDrawTask_IndexProvider();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask#getStructure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Structure</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask#getStructure()
	 * @see #getRenderIndexedDrawTask()
	 * @generated
	 */
	EReference getRenderIndexedDrawTask_Structure();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable <em>Physical Entity Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physical Entity Variable</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable
	 * @generated
	 */
	EClass getPhysicalEntityVariable();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable#getEntity()
	 * @see #getPhysicalEntityVariable()
	 * @generated
	 */
	EReference getPhysicalEntityVariable_Entity();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable#getFeature()
	 * @see #getPhysicalEntityVariable()
	 * @generated
	 */
	EAttribute getPhysicalEntityVariable_Feature();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature <em>EPhysical Entity Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EPhysical Entity Feature</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature
	 * @generated
	 */
	EEnum getEPhysicalEntityFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RenderingFactory getRenderingFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Entity <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.Entity
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl <em>Physical Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPhysicalEntity()
		 * @generated
		 */
		EClass PHYSICAL_ENTITY = eINSTANCE.getPhysicalEntity();

		/**
		 * The meta object literal for the '<em><b>Geo Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_ENTITY__GEO_LOCATION = eINSTANCE.getPhysicalEntity_GeoLocation();

		/**
		 * The meta object literal for the '<em><b>Geo Orientation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_ENTITY__GEO_ORIENTATION = eINSTANCE.getPhysicalEntity_GeoOrientation();

		/**
		 * The meta object literal for the '<em><b>Axis Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_ENTITY__AXIS_LOCATION = eINSTANCE.getPhysicalEntity_AxisLocation();

		/**
		 * The meta object literal for the '<em><b>Axis</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_ENTITY__AXIS = eINSTANCE.getPhysicalEntity_Axis();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl <em>Axis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getAxis()
		 * @generated
		 */
		EClass AXIS = eINSTANCE.getAxis();

		/**
		 * The meta object literal for the '<em><b>Front Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS__FRONT_DIRECTION = eINSTANCE.getAxis_FrontDirection();

		/**
		 * The meta object literal for the '<em><b>Up Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS__UP_DIRECTION = eINSTANCE.getAxis_UpDirection();

		/**
		 * The meta object literal for the '<em><b>Right Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS__RIGHT_DIRECTION = eINSTANCE.getAxis_RightDirection();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Structure <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.Structure
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation <em>Presentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentation()
		 * @generated
		 */
		EClass PRESENTATION = eINSTANCE.getPresentation();

		/**
		 * The meta object literal for the '<em><b>Presented Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION__PRESENTED_ENTITIES = eINSTANCE.getPresentation_PresentedEntities();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl <em>Presentation Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentationPkg()
		 * @generated
		 */
		EClass PRESENTATION_PKG = eINSTANCE.getPresentationPkg();

		/**
		 * The meta object literal for the '<em><b>Structures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_PKG__STRUCTURES = eINSTANCE.getPresentationPkg_Structures();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl <em>Presentable Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPresentableEntity()
		 * @generated
		 */
		EClass PRESENTABLE_ENTITY = eINSTANCE.getPresentableEntity();

		/**
		 * The meta object literal for the '<em><b>Presentation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTABLE_ENTITY__PRESENTATION = eINSTANCE.getPresentableEntity_Presentation();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESENTABLE_ENTITY__SCALE = eINSTANCE.getPresentableEntity_Scale();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl <em>Generic Renderer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getGenericRenderer()
		 * @generated
		 */
		EClass GENERIC_RENDERER = eINSTANCE.getGenericRenderer();

		/**
		 * The meta object literal for the '<em><b>Data Provider Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__DATA_PROVIDER_PKG = eINSTANCE.getGenericRenderer_DataProviderPkg();

		/**
		 * The meta object literal for the '<em><b>Rendered Structures</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__RENDERED_STRUCTURES = eINSTANCE.getGenericRenderer_RenderedStructures();

		/**
		 * The meta object literal for the '<em><b>Constant Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__CONSTANT_BUFFER = eINSTANCE.getGenericRenderer_ConstantBuffer();

		/**
		 * The meta object literal for the '<em><b>Transfer Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__TRANSFER_BUFFER = eINSTANCE.getGenericRenderer_TransferBuffer();

		/**
		 * The meta object literal for the '<em><b>Descriptor Provider Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__DESCRIPTOR_PROVIDER_PKG = eINSTANCE.getGenericRenderer_DescriptorProviderPkg();

		/**
		 * The meta object literal for the '<em><b>Specialization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__SPECIALIZATION = eINSTANCE.getGenericRenderer_Specialization();

		/**
		 * The meta object literal for the '<em><b>Flush Transfer Buffer Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__FLUSH_TRANSFER_BUFFER_TASK = eINSTANCE.getGenericRenderer_FlushTransferBufferTask();

		/**
		 * The meta object literal for the '<em><b>One Pipeline Per Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_RENDERER__ONE_PIPELINE_PER_PART = eINSTANCE.getGenericRenderer_OnePipelinePerPart();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider <em>Render Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderDataProvider()
		 * @generated
		 */
		EClass RENDER_DATA_PROVIDER = eINSTANCE.getRenderDataProvider();

		/**
		 * The meta object literal for the '<em><b>Data Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_DATA_PROVIDER__DATA_SOURCE = eINSTANCE.getRenderDataProvider_DataSource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderPkgImpl <em>Data Provider Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderPkgImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDataProviderPkg()
		 * @generated
		 */
		EClass DATA_PROVIDER_PKG = eINSTANCE.getDataProviderPkg();

		/**
		 * The meta object literal for the '<em><b>Data Providers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PROVIDER_PKG__DATA_PROVIDERS = eINSTANCE.getDataProviderPkg_DataProviders();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl <em>Renderable Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderableDataSource()
		 * @generated
		 */
		EClass RENDERABLE_DATA_SOURCE = eINSTANCE.getRenderableDataSource();

		/**
		 * The meta object literal for the '<em><b>Structure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDERABLE_DATA_SOURCE__STRUCTURE = eINSTANCE.getRenderableDataSource_Structure();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RENDERABLE_DATA_SOURCE__PART = eINSTANCE.getRenderableDataSource_Part();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.VertexProviderImpl <em>Vertex Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.VertexProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getVertexProvider()
		 * @generated
		 */
		EClass VERTEX_PROVIDER = eINSTANCE.getVertexProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.IndexProviderImpl <em>Index Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.IndexProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getIndexProvider()
		 * @generated
		 */
		EClass INDEX_PROVIDER = eINSTANCE.getIndexProvider();

		/**
		 * The meta object literal for the '<em><b>Index Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_PROVIDER__INDEX_TYPE = eINSTANCE.getIndexProvider_IndexType();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider <em>Resource Descriptor Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getResourceDescriptorProvider()
		 * @generated
		 */
		EClass RESOURCE_DESCRIPTOR_PROVIDER = eINSTANCE.getResourceDescriptorProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DescriptorsProviderImpl <em>Descriptors Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DescriptorsProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDescriptorsProvider()
		 * @generated
		 */
		EClass DESCRIPTORS_PROVIDER = eINSTANCE.getDescriptorsProvider();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTORS_PROVIDER__DESCRIPTORS = eINSTANCE.getDescriptorsProvider_Descriptors();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorsProviderImpl <em>Data Descriptors Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorsProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDataDescriptorsProvider()
		 * @generated
		 */
		EClass DATA_DESCRIPTORS_PROVIDER = eINSTANCE.getDataDescriptorsProvider();

		/**
		 * The meta object literal for the '<em><b>Data Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS = eINSTANCE.getDataDescriptorsProvider_DataDescriptors();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorImpl <em>Data Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDataDescriptor()
		 * @generated
		 */
		EClass DATA_DESCRIPTOR = eINSTANCE.getDataDescriptor();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DESCRIPTOR__PART = eINSTANCE.getDataDescriptor_Part();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DESCRIPTOR__INSTANCE = eINSTANCE.getDataDescriptor_Instance();

		/**
		 * The meta object literal for the '<em><b>Descriptor Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DESCRIPTOR__DESCRIPTOR_TYPE = eINSTANCE.getDataDescriptor_DescriptorType();

		/**
		 * The meta object literal for the '<em><b>Stages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DESCRIPTOR__STAGES = eINSTANCE.getDataDescriptor_Stages();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.ResourceDescriptorProviderPkgImpl <em>Resource Descriptor Provider Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.ResourceDescriptorProviderPkgImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getResourceDescriptorProviderPkg()
		 * @generated
		 */
		EClass RESOURCE_DESCRIPTOR_PROVIDER_PKG = eINSTANCE.getResourceDescriptorProviderPkg();

		/**
		 * The meta object literal for the '<em><b>Resource Descriptor Providers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS = eINSTANCE.getResourceDescriptorProviderPkg_ResourceDescriptorProviders();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderProxyConstantBufferImpl <em>Render Proxy Constant Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderProxyConstantBufferImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderProxyConstantBuffer()
		 * @generated
		 */
		EClass RENDER_PROXY_CONSTANT_BUFFER = eINSTANCE.getRenderProxyConstantBuffer();

		/**
		 * The meta object literal for the '<em><b>Constant Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER = eINSTANCE.getRenderProxyConstantBuffer_ConstantBuffer();

		/**
		 * The meta object literal for the '<em><b>Part Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX = eINSTANCE.getRenderProxyConstantBuffer_PartIndex();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.ISpecializationImpl <em>ISpecialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.ISpecializationImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getISpecialization()
		 * @generated
		 */
		EClass ISPECIALIZATION = eINSTANCE.getISpecialization();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.EntityPkgImpl <em>Entity Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.EntityPkgImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getEntityPkg()
		 * @generated
		 */
		EClass ENTITY_PKG = eINSTANCE.getEntityPkg();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_PKG__ENTITIES = eINSTANCE.getEntityPkg_Entities();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderDrawTaskImpl <em>Render Draw Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderDrawTaskImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderDrawTask()
		 * @generated
		 */
		EClass RENDER_DRAW_TASK = eINSTANCE.getRenderDrawTask();

		/**
		 * The meta object literal for the '<em><b>Vertex Providers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_DRAW_TASK__VERTEX_PROVIDERS = eINSTANCE.getRenderDrawTask_VertexProviders();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderIndexedDrawTaskImpl <em>Render Indexed Draw Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderIndexedDrawTaskImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderIndexedDrawTask()
		 * @generated
		 */
		EClass RENDER_INDEXED_DRAW_TASK = eINSTANCE.getRenderIndexedDrawTask();

		/**
		 * The meta object literal for the '<em><b>Index Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER = eINSTANCE.getRenderIndexedDrawTask_IndexProvider();

		/**
		 * The meta object literal for the '<em><b>Structure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_INDEXED_DRAW_TASK__STRUCTURE = eINSTANCE.getRenderIndexedDrawTask_Structure();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityVariableImpl <em>Physical Entity Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityVariableImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getPhysicalEntityVariable()
		 * @generated
		 */
		EClass PHYSICAL_ENTITY_VARIABLE = eINSTANCE.getPhysicalEntityVariable();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_ENTITY_VARIABLE__ENTITY = eINSTANCE.getPhysicalEntityVariable_Entity();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_ENTITY_VARIABLE__FEATURE = eINSTANCE.getPhysicalEntityVariable_Feature();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature <em>EPhysical Entity Feature</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getEPhysicalEntityFeature()
		 * @generated
		 */
		EEnum EPHYSICAL_ENTITY_FEATURE = eINSTANCE.getEPhysicalEntityFeature();

	}

} //RenderingPackage
