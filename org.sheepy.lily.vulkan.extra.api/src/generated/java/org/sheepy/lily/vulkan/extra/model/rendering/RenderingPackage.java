/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

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
	 * The feature id for the '<em><b>Presentations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__PRESENTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = 1;

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
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__RESOURCE_PKG = GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG;

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
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__PUSH_CONSTANT_RANGES = GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT_RANGES;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__SPECIALIZATION_DATA = GraphicPackage.GRAPHICS_PIPELINE__SPECIALIZATION_DATA;

	/**
	 * The feature id for the '<em><b>Descriptor Set Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__DESCRIPTOR_SET_PKG = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__TASK_PKG = GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG;

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
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__SUBPASS = GraphicPackage.GRAPHICS_PIPELINE__SUBPASS;

	/**
	 * The feature id for the '<em><b>Vertex Input State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__VERTEX_INPUT_STATE = GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE;

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
	 * The feature id for the '<em><b>Push Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__PUSH_BUFFER = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Common Resource Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Generic Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_RENDERER_FEATURE_COUNT = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 6;

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
	int RENDER_DATA_PROVIDER__NAME = ResourcePackage.BUFFER_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__USAGE = ResourcePackage.BUFFER_DATA_PROVIDER__USAGE;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__INSTANCE_COUNT = ResourcePackage.BUFFER_DATA_PROVIDER__INSTANCE_COUNT;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER__DATA_SOURCE = ResourcePackage.BUFFER_DATA_PROVIDER__DATA_SOURCE;

	/**
	 * The number of structural features of the '<em>Render Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER_FEATURE_COUNT = ResourcePackage.BUFFER_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Render Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_DATA_PROVIDER_OPERATION_COUNT = ResourcePackage.BUFFER_DATA_PROVIDER_OPERATION_COUNT + 0;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DescribedDataProviderImpl <em>Described Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DescribedDataProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDescribedDataProvider()
	 * @generated
	 */
	int DESCRIBED_DATA_PROVIDER = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__NAME = RENDER_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__USAGE = RENDER_DATA_PROVIDER__USAGE;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__INSTANCE_COUNT = RENDER_DATA_PROVIDER__INSTANCE_COUNT;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__DATA_SOURCE = RENDER_DATA_PROVIDER__DATA_SOURCE;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__DESCRIPTOR = RENDER_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Described Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER_FEATURE_COUNT = RENDER_DATA_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Described Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER_OPERATION_COUNT = RENDER_DATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl <em>Renderable Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getRenderableDataSource()
	 * @generated
	 */
	int RENDERABLE_DATA_SOURCE = 11;

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
	int VERTEX_PROVIDER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__NAME = RENDER_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__USAGE = RENDER_DATA_PROVIDER__USAGE;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_PROVIDER__INSTANCE_COUNT = RENDER_DATA_PROVIDER__INSTANCE_COUNT;

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
	int INDEX_PROVIDER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__NAME = RENDER_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__USAGE = RENDER_DATA_PROVIDER__USAGE;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_PROVIDER__INSTANCE_COUNT = RENDER_DATA_PROVIDER__INSTANCE_COUNT;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider <em>Resource Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getResourceProvider()
	 * @generated
	 */
	int RESOURCE_PROVIDER = 14;

	/**
	 * The number of structural features of the '<em>Resource Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Resource Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PROVIDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.StaticResourceProviderImpl <em>Static Resource Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.StaticResourceProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getStaticResourceProvider()
	 * @generated
	 */
	int STATIC_RESOURCE_PROVIDER = 15;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_RESOURCE_PROVIDER__RESOURCES = RESOURCE_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Static Resource Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_RESOURCE_PROVIDER_FEATURE_COUNT = RESOURCE_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Static Resource Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_RESOURCE_PROVIDER_OPERATION_COUNT = RESOURCE_PROVIDER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CompositeResourceProviderImpl <em>Composite Resource Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.CompositeResourceProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getCompositeResourceProvider()
	 * @generated
	 */
	int COMPOSITE_RESOURCE_PROVIDER = 16;

	/**
	 * The feature id for the '<em><b>Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE_PROVIDER__PROVIDERS = RESOURCE_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Resource Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE_PROVIDER_FEATURE_COUNT = RESOURCE_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Resource Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE_PROVIDER_OPERATION_COUNT = RESOURCE_PROVIDER_OPERATION_COUNT + 0;


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
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.Structure#getPresentations <em>Presentations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Presentations</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Structure#getPresentations()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Presentations();

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
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getPushBuffer <em>Push Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Push Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getPushBuffer()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_PushBuffer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getCommonResourceProvider <em>Common Resource Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Common Resource Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer#getCommonResourceProvider()
	 * @see #getGenericRenderer()
	 * @generated
	 */
	EReference getGenericRenderer_CommonResourceProvider();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DescribedDataProvider <em>Described Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Described Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DescribedDataProvider
	 * @generated
	 */
	EClass getDescribedDataProvider();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider <em>Resource Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider
	 * @generated
	 */
	EClass getResourceProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider <em>Static Resource Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Resource Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider
	 * @generated
	 */
	EClass getStaticResourceProvider();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resources</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider#getResources()
	 * @see #getStaticResourceProvider()
	 * @generated
	 */
	EReference getStaticResourceProvider_Resources();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.rendering.CompositeResourceProvider <em>Composite Resource Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Resource Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.CompositeResourceProvider
	 * @generated
	 */
	EClass getCompositeResourceProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.rendering.CompositeResourceProvider#getProviders <em>Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Providers</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.CompositeResourceProvider#getProviders()
	 * @see #getCompositeResourceProvider()
	 * @generated
	 */
	EReference getCompositeResourceProvider_Providers();

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
		 * The meta object literal for the '<em><b>Presentations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__PRESENTATIONS = eINSTANCE.getStructure_Presentations();

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
		 * The meta object literal for the '<em><b>Push Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__PUSH_BUFFER = eINSTANCE.getGenericRenderer_PushBuffer();

		/**
		 * The meta object literal for the '<em><b>Common Resource Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER = eINSTANCE.getGenericRenderer_CommonResourceProvider();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DescribedDataProviderImpl <em>Described Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.DescribedDataProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getDescribedDataProvider()
		 * @generated
		 */
		EClass DESCRIBED_DATA_PROVIDER = eINSTANCE.getDescribedDataProvider();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider <em>Resource Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getResourceProvider()
		 * @generated
		 */
		EClass RESOURCE_PROVIDER = eINSTANCE.getResourceProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.StaticResourceProviderImpl <em>Static Resource Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.StaticResourceProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getStaticResourceProvider()
		 * @generated
		 */
		EClass STATIC_RESOURCE_PROVIDER = eINSTANCE.getStaticResourceProvider();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIC_RESOURCE_PROVIDER__RESOURCES = eINSTANCE.getStaticResourceProvider_Resources();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CompositeResourceProviderImpl <em>Composite Resource Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.CompositeResourceProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl#getCompositeResourceProvider()
		 * @generated
		 */
		EClass COMPOSITE_RESOURCE_PROVIDER = eINSTANCE.getCompositeResourceProvider();

		/**
		 * The meta object literal for the '<em><b>Providers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_RESOURCE_PROVIDER__PROVIDERS = eINSTANCE.getCompositeResourceProvider_Providers();

	}

} //RenderingPackage
