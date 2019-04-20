/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

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
 *        annotation="http://www.eclipse.org/emf/2002/GenModel cleanup='true' codeFormatting='true' modelDirectory='/org.sheepy.lily.vulkan.extra.model/src/generated/java' editDirectory='/org.sheepy.lily.vulkan.extra.model.edit/src/generated/java' publicConstructors='true' complianceLevel='11.0' resource='XMI' extensibleProviderFactory='true' childCreationExtenders='true' modelName='GraphicExtra' prefix='GraphicExtra' basePackage='org.sheepy.lily.vulkan.extra.graphic'"
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
	GraphicExtraPackage eINSTANCE = org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.ImagePipelineImpl
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getImagePipeline()
	 * @generated
	 */
	int IMAGE_PIPELINE = 0;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__CONTENT_OBJECTS = ProcessPackage.ABSTRACT_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__NAME = ProcessPackage.ABSTRACT_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__ENABLED = ProcessPackage.ABSTRACT_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__STAGE = ProcessPackage.ABSTRACT_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__RESOURCE_PKG = ProcessPackage.ABSTRACT_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__UNITS = ProcessPackage.ABSTRACT_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__DESCRIPTOR_SET_REF = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET_REF;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__DESCRIPTOR_SET = ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__CONSTANTS = ProcessPackage.ABSTRACT_PIPELINE__CONSTANTS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_SRC_STAGE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_DST_STAGE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Image Src Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Image Dst Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Src Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE__SRC_QUEUE = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Image Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE_FEATURE_COUNT = ProcessPackage.ABSTRACT_PIPELINE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___LINFERENCE_OBJECT = ProcessPackage.ABSTRACT_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS = ProcessPackage.ABSTRACT_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___LCONTENTS = ProcessPackage.ABSTRACT_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___LPARENT = ProcessPackage.ABSTRACT_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE___LALL_CONTENTS = ProcessPackage.ABSTRACT_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Image Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_PIPELINE_OPERATION_COUNT = ProcessPackage.ABSTRACT_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.MeshRendererImpl <em>Mesh Renderer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.MeshRendererImpl
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getMeshRenderer()
	 * @generated
	 */
	int MESH_RENDERER = 1;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__CONTENT_OBJECTS = GraphicPackage.GRAPHICS_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__NAME = GraphicPackage.GRAPHICS_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__ENABLED = GraphicPackage.GRAPHICS_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__STAGE = GraphicPackage.GRAPHICS_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__RESOURCE_PKG = GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__UNITS = GraphicPackage.GRAPHICS_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DESCRIPTOR_SET_REF = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DESCRIPTOR_SET = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__CONSTANTS = GraphicPackage.GRAPHICS_PIPELINE__CONSTANTS;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__SHADERS = GraphicPackage.GRAPHICS_PIPELINE__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__VIEWPORT_STATE = GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__INPUT_ASSEMBLY = GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__RASTERIZER = GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__COLOR_BLEND = GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__DYNAMIC_STATE = GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__SUBPASS = GraphicPackage.GRAPHICS_PIPELINE__SUBPASS;

	/**
	 * The feature id for the '<em><b>Mesh Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER__MESH_PROVIDER = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mesh Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_FEATURE_COUNT = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER___LINFERENCE_OBJECT = GraphicPackage.GRAPHICS_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER___CREATE_CONTAINMENT_ELIST__ECLASS = GraphicPackage.GRAPHICS_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER___LCONTENTS = GraphicPackage.GRAPHICS_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER___LPARENT = GraphicPackage.GRAPHICS_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER___LALL_CONTENTS = GraphicPackage.GRAPHICS_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Mesh Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_RENDERER_OPERATION_COUNT = GraphicPackage.GRAPHICS_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider <em>IMesh Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getIMeshProvider()
	 * @generated
	 */
	int IMESH_PROVIDER = 2;

	/**
	 * The number of structural features of the '<em>IMesh Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMESH_PROVIDER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IMesh Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMESH_PROVIDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ScreenRendererImpl <em>Screen Renderer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.ScreenRendererImpl
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getScreenRenderer()
	 * @generated
	 */
	int SCREEN_RENDERER = 3;

	/**
	 * The feature id for the '<em><b>Content Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__CONTENT_OBJECTS = GraphicPackage.GRAPHICS_PIPELINE__CONTENT_OBJECTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__NAME = GraphicPackage.GRAPHICS_PIPELINE__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__ENABLED = GraphicPackage.GRAPHICS_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__STAGE = GraphicPackage.GRAPHICS_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__RESOURCE_PKG = GraphicPackage.GRAPHICS_PIPELINE__RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__UNITS = GraphicPackage.GRAPHICS_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__DESCRIPTOR_SET_REF = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET_REF;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__DESCRIPTOR_SET = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__CONSTANTS = GraphicPackage.GRAPHICS_PIPELINE__CONSTANTS;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__SHADERS = GraphicPackage.GRAPHICS_PIPELINE__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__VIEWPORT_STATE = GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__INPUT_ASSEMBLY = GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__RASTERIZER = GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__COLOR_BLEND = GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__DYNAMIC_STATE = GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Subpass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER__SUBPASS = GraphicPackage.GRAPHICS_PIPELINE__SUBPASS;

	/**
	 * The number of structural features of the '<em>Screen Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER_FEATURE_COUNT = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER___LINFERENCE_OBJECT = GraphicPackage.GRAPHICS_PIPELINE___LINFERENCE_OBJECT;

	/**
	 * The operation id for the '<em>Create Containment EList</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER___CREATE_CONTAINMENT_ELIST__ECLASS = GraphicPackage.GRAPHICS_PIPELINE___CREATE_CONTAINMENT_ELIST__ECLASS;

	/**
	 * The operation id for the '<em>LContents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER___LCONTENTS = GraphicPackage.GRAPHICS_PIPELINE___LCONTENTS;

	/**
	 * The operation id for the '<em>LParent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER___LPARENT = GraphicPackage.GRAPHICS_PIPELINE___LPARENT;

	/**
	 * The operation id for the '<em>LAll Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER___LALL_CONTENTS = GraphicPackage.GRAPHICS_PIPELINE___LALL_CONTENTS;

	/**
	 * The number of operations of the '<em>Screen Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREEN_RENDERER_OPERATION_COUNT = GraphicPackage.GRAPHICS_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline <em>Image Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Pipeline</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline
	 * @generated
	 */
	EClass getImagePipeline();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EReference getImagePipeline_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Src Stage</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageSrcStage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Dst Stage</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageDstStage()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstStage();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageSrcAccessMask <em>Image Src Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Image Src Access Mask</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageSrcAccessMask()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageSrcAccessMask();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageDstAccessMask <em>Image Dst Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Image Dst Access Mask</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageDstAccessMask()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EAttribute getImagePipeline_ImageDstAccessMask();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getSrcQueue <em>Src Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src Queue</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getSrcQueue()
	 * @see #getImagePipeline()
	 * @generated
	 */
	EReference getImagePipeline_SrcQueue();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.MeshRenderer <em>Mesh Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Renderer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.MeshRenderer
	 * @generated
	 */
	EClass getMeshRenderer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.graphic.model.MeshRenderer#getMeshProvider <em>Mesh Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mesh Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.MeshRenderer#getMeshProvider()
	 * @see #getMeshRenderer()
	 * @generated
	 */
	EReference getMeshRenderer_MeshProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider <em>IMesh Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMesh Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider
	 * @generated
	 */
	EClass getIMeshProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.graphic.model.ScreenRenderer <em>Screen Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Screen Renderer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.ScreenRenderer
	 * @generated
	 */
	EClass getScreenRenderer();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ImagePipelineImpl <em>Image Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.ImagePipelineImpl
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getImagePipeline()
		 * @generated
		 */
		EClass IMAGE_PIPELINE = eINSTANCE.getImagePipeline();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_PIPELINE__IMAGE = eINSTANCE.getImagePipeline_Image();

		/**
		 * The meta object literal for the '<em><b>Image Src Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_SRC_STAGE = eINSTANCE.getImagePipeline_ImageSrcStage();

		/**
		 * The meta object literal for the '<em><b>Image Dst Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_DST_STAGE = eINSTANCE.getImagePipeline_ImageDstStage();

		/**
		 * The meta object literal for the '<em><b>Image Src Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_SRC_ACCESS_MASK = eINSTANCE
				.getImagePipeline_ImageSrcAccessMask();

		/**
		 * The meta object literal for the '<em><b>Image Dst Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_PIPELINE__IMAGE_DST_ACCESS_MASK = eINSTANCE
				.getImagePipeline_ImageDstAccessMask();

		/**
		 * The meta object literal for the '<em><b>Src Queue</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_PIPELINE__SRC_QUEUE = eINSTANCE.getImagePipeline_SrcQueue();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.MeshRendererImpl <em>Mesh Renderer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.MeshRendererImpl
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getMeshRenderer()
		 * @generated
		 */
		EClass MESH_RENDERER = eINSTANCE.getMeshRenderer();

		/**
		 * The meta object literal for the '<em><b>Mesh Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESH_RENDERER__MESH_PROVIDER = eINSTANCE.getMeshRenderer_MeshProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider <em>IMesh Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getIMeshProvider()
		 * @generated
		 */
		EClass IMESH_PROVIDER = eINSTANCE.getIMeshProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ScreenRendererImpl <em>Screen Renderer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.ScreenRendererImpl
		 * @see org.sheepy.lily.vulkan.extra.graphic.model.impl.GraphicExtraPackageImpl#getScreenRenderer()
		 * @generated
		 */
		EClass SCREEN_RENDERER = eINSTANCE.getScreenRenderer();

	}

} //GraphicExtraPackage
