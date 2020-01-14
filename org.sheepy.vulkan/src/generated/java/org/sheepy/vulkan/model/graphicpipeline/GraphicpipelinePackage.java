/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelineFactory
 * @model kind="package"
 * @generated
 */
public interface GraphicpipelinePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphicpipeline";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.model.graphicpipeline";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graphicpipeline";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphicpipelinePackage eINSTANCE = org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendImpl <em>Color Blend</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getColorBlend()
	 * @generated
	 */
	int COLOR_BLEND = 0;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__ATTACHMENTS = 0;

	/**
	 * The feature id for the '<em><b>Logic Op Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__LOGIC_OP_ENABLE = 1;

	/**
	 * The feature id for the '<em><b>Logic Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__LOGIC_OP = 2;

	/**
	 * The feature id for the '<em><b>Blend Constant0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__BLEND_CONSTANT0 = 3;

	/**
	 * The feature id for the '<em><b>Blend Constant1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__BLEND_CONSTANT1 = 4;

	/**
	 * The feature id for the '<em><b>Blend Constant2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__BLEND_CONSTANT2 = 5;

	/**
	 * The feature id for the '<em><b>Blend Constant3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND__BLEND_CONSTANT3 = 6;

	/**
	 * The number of structural features of the '<em>Color Blend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Color Blend</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl <em>Color Blend Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getColorBlendAttachment()
	 * @generated
	 */
	int COLOR_BLEND_ATTACHMENT = 1;

	/**
	 * The feature id for the '<em><b>Blend Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__BLEND_ENABLE = 0;

	/**
	 * The feature id for the '<em><b>Src Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__SRC_COLOR = 1;

	/**
	 * The feature id for the '<em><b>Dst Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__DST_COLOR = 2;

	/**
	 * The feature id for the '<em><b>Src Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__SRC_ALPHA = 3;

	/**
	 * The feature id for the '<em><b>Dst Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__DST_ALPHA = 4;

	/**
	 * The feature id for the '<em><b>Color Blend Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP = 5;

	/**
	 * The feature id for the '<em><b>Alpha Blend Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP = 6;

	/**
	 * The feature id for the '<em><b>Red Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE = 7;

	/**
	 * The feature id for the '<em><b>Green Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE = 8;

	/**
	 * The feature id for the '<em><b>Blue Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE = 9;

	/**
	 * The feature id for the '<em><b>Alpha Component Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE = 10;

	/**
	 * The number of structural features of the '<em>Color Blend Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Color Blend Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_BLEND_ATTACHMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.InputAssemblyImpl <em>Input Assembly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.InputAssemblyImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getInputAssembly()
	 * @generated
	 */
	int INPUT_ASSEMBLY = 2;

	/**
	 * The feature id for the '<em><b>Primitive Restart Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Primitive Topology</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY = 1;

	/**
	 * The number of structural features of the '<em>Input Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSEMBLY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Input Assembly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ASSEMBLY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl <em>Rasterizer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getRasterizer()
	 * @generated
	 */
	int RASTERIZER = 3;

	/**
	 * The feature id for the '<em><b>Cull Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__CULL_MODE = 0;

	/**
	 * The feature id for the '<em><b>Front Face</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__FRONT_FACE = 1;

	/**
	 * The feature id for the '<em><b>Polygon Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__POLYGON_MODE = 2;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__LINE_WIDTH = 3;

	/**
	 * The feature id for the '<em><b>Depth Clamp Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__DEPTH_CLAMP_ENABLE = 4;

	/**
	 * The feature id for the '<em><b>Discard Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__DISCARD_ENABLE = 5;

	/**
	 * The feature id for the '<em><b>Depth Bias Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER__DEPTH_BIAS_ENABLE = 6;

	/**
	 * The number of structural features of the '<em>Rasterizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Rasterizer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RASTERIZER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.DynamicStateImpl <em>Dynamic State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.DynamicStateImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getDynamicState()
	 * @generated
	 */
	int DYNAMIC_STATE = 4;

	/**
	 * The feature id for the '<em><b>States</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STATE__STATES = 0;

	/**
	 * The number of structural features of the '<em>Dynamic State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STATE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Dynamic State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.ViewportState <em>Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.ViewportState
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getViewportState()
	 * @generated
	 */
	int VIEWPORT_STATE = 5;

	/**
	 * The number of structural features of the '<em>Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT_STATE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.StaticViewportStateImpl <em>Static Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.StaticViewportStateImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getStaticViewportState()
	 * @generated
	 */
	int STATIC_VIEWPORT_STATE = 6;

	/**
	 * The feature id for the '<em><b>Viewports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEWPORT_STATE__VIEWPORTS = VIEWPORT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scissors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEWPORT_STATE__SCISSORS = VIEWPORT_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Static Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEWPORT_STATE_FEATURE_COUNT = VIEWPORT_STATE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Static Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEWPORT_STATE_OPERATION_COUNT = VIEWPORT_STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.DynamicViewportStateImpl <em>Dynamic Viewport State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.DynamicViewportStateImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getDynamicViewportState()
	 * @generated
	 */
	int DYNAMIC_VIEWPORT_STATE = 7;

	/**
	 * The feature id for the '<em><b>Viewport Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT = VIEWPORT_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scissor Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT = VIEWPORT_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dynamic Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VIEWPORT_STATE_FEATURE_COUNT = VIEWPORT_STATE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dynamic Viewport State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_VIEWPORT_STATE_OPERATION_COUNT = VIEWPORT_STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.Vec2IImpl <em>Vec2 I</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.Vec2IImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getVec2I()
	 * @generated
	 */
	int VEC2_I = 8;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEC2_I__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEC2_I__Y = 1;

	/**
	 * The number of structural features of the '<em>Vec2 I</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEC2_I_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Vec2 I</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEC2_I_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl <em>Viewport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getViewport()
	 * @generated
	 */
	int VIEWPORT = 9;

	/**
	 * The feature id for the '<em><b>Offset X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__OFFSET_X = 0;

	/**
	 * The feature id for the '<em><b>Offset Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__OFFSET_Y = 1;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__EXTENT = 2;

	/**
	 * The feature id for the '<em><b>Min Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__MIN_DEPTH = 3;

	/**
	 * The feature id for the '<em><b>Max Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT__MAX_DEPTH = 4;

	/**
	 * The number of structural features of the '<em>Viewport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Viewport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.ScissorImpl <em>Scissor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.ScissorImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getScissor()
	 * @generated
	 */
	int SCISSOR = 10;

	/**
	 * The feature id for the '<em><b>Offset X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR__OFFSET_X = 0;

	/**
	 * The feature id for the '<em><b>Offset Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR__OFFSET_Y = 1;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR__EXTENT = 2;

	/**
	 * The number of structural features of the '<em>Scissor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Scissor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCISSOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl <em>Depth Stencil State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl
	 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getDepthStencilState()
	 * @generated
	 */
	int DEPTH_STENCIL_STATE = 11;

	/**
	 * The feature id for the '<em><b>Depth Test</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE__DEPTH_TEST = 0;

	/**
	 * The feature id for the '<em><b>Depth Write</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE__DEPTH_WRITE = 1;

	/**
	 * The feature id for the '<em><b>Depth Bound Test</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST = 2;

	/**
	 * The feature id for the '<em><b>Stencil Test</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE__STENCIL_TEST = 3;

	/**
	 * The feature id for the '<em><b>Depth Compare Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP = 4;

	/**
	 * The feature id for the '<em><b>Min Depth Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS = 5;

	/**
	 * The feature id for the '<em><b>Max Depth Bounds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS = 6;

	/**
	 * The number of structural features of the '<em>Depth Stencil State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Depth Stencil State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_STENCIL_STATE_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend <em>Color Blend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Blend</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend
	 * @generated
	 */
	EClass getColorBlend();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachments</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getAttachments()
	 * @see #getColorBlend()
	 * @generated
	 */
	EReference getColorBlend_Attachments();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#isLogicOpEnable <em>Logic Op Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logic Op Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend#isLogicOpEnable()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_LogicOpEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getLogicOp <em>Logic Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logic Op</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getLogicOp()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_LogicOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant0 <em>Blend Constant0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant0</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant0()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant0();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant1 <em>Blend Constant1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant1</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant1()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant1();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant2 <em>Blend Constant2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant2</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant2()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant2();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant3 <em>Blend Constant3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Constant3</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend#getBlendConstant3()
	 * @see #getColorBlend()
	 * @generated
	 */
	EAttribute getColorBlend_BlendConstant3();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment <em>Color Blend Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Blend Attachment</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment
	 * @generated
	 */
	EClass getColorBlendAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isBlendEnable <em>Blend Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blend Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isBlendEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_BlendEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getSrcColor <em>Src Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Color</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getSrcColor()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_SrcColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getDstColor <em>Dst Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Color</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getDstColor()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_DstColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getSrcAlpha <em>Src Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Alpha</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getSrcAlpha()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_SrcAlpha();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getDstAlpha <em>Dst Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Alpha</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getDstAlpha()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_DstAlpha();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getColorBlendOp <em>Color Blend Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Blend Op</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getColorBlendOp()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_ColorBlendOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getAlphaBlendOp <em>Alpha Blend Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Blend Op</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getAlphaBlendOp()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_AlphaBlendOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isRedComponentEnable <em>Red Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Red Component Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isRedComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_RedComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isGreenComponentEnable <em>Green Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Green Component Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isGreenComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_GreenComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isBlueComponentEnable <em>Blue Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blue Component Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isBlueComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_BlueComponentEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isAlphaComponentEnable <em>Alpha Component Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha Component Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isAlphaComponentEnable()
	 * @see #getColorBlendAttachment()
	 * @generated
	 */
	EAttribute getColorBlendAttachment_AlphaComponentEnable();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly <em>Input Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Assembly</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.InputAssembly
	 * @generated
	 */
	EClass getInputAssembly();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly#isPrimitiveRestartEnabled <em>Primitive Restart Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive Restart Enabled</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.InputAssembly#isPrimitiveRestartEnabled()
	 * @see #getInputAssembly()
	 * @generated
	 */
	EAttribute getInputAssembly_PrimitiveRestartEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly#getPrimitiveTopology <em>Primitive Topology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive Topology</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.InputAssembly#getPrimitiveTopology()
	 * @see #getInputAssembly()
	 * @generated
	 */
	EAttribute getInputAssembly_PrimitiveTopology();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer <em>Rasterizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rasterizer</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer
	 * @generated
	 */
	EClass getRasterizer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getCullMode <em>Cull Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cull Mode</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getCullMode()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_CullMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getFrontFace <em>Front Face</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Front Face</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getFrontFace()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_FrontFace();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getPolygonMode <em>Polygon Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Polygon Mode</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getPolygonMode()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_PolygonMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getLineWidth <em>Line Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Width</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer#getLineWidth()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_LineWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDepthClampEnable <em>Depth Clamp Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Clamp Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDepthClampEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DepthClampEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDiscardEnable <em>Discard Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discard Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDiscardEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DiscardEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDepthBiasEnable <em>Depth Bias Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Bias Enable</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer#isDepthBiasEnable()
	 * @see #getRasterizer()
	 * @generated
	 */
	EAttribute getRasterizer_DepthBiasEnable();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicState <em>Dynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic State</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DynamicState
	 * @generated
	 */
	EClass getDynamicState();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicState#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>States</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DynamicState#getStates()
	 * @see #getDynamicState()
	 * @generated
	 */
	EAttribute getDynamicState_States();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.ViewportState <em>Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewport State</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ViewportState
	 * @generated
	 */
	EClass getViewportState();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.StaticViewportState <em>Static Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Viewport State</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.StaticViewportState
	 * @generated
	 */
	EClass getStaticViewportState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.graphicpipeline.StaticViewportState#getViewports <em>Viewports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Viewports</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.StaticViewportState#getViewports()
	 * @see #getStaticViewportState()
	 * @generated
	 */
	EReference getStaticViewportState_Viewports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.graphicpipeline.StaticViewportState#getScissors <em>Scissors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scissors</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.StaticViewportState#getScissors()
	 * @see #getStaticViewportState()
	 * @generated
	 */
	EReference getStaticViewportState_Scissors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState <em>Dynamic Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Viewport State</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState
	 * @generated
	 */
	EClass getDynamicViewportState();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState#getViewportCount <em>Viewport Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Viewport Count</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState#getViewportCount()
	 * @see #getDynamicViewportState()
	 * @generated
	 */
	EAttribute getDynamicViewportState_ViewportCount();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState#getScissorCount <em>Scissor Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scissor Count</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState#getScissorCount()
	 * @see #getDynamicViewportState()
	 * @generated
	 */
	EAttribute getDynamicViewportState_ScissorCount();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.Vec2I <em>Vec2 I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vec2 I</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Vec2I
	 * @generated
	 */
	EClass getVec2I();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Vec2I#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Vec2I#getX()
	 * @see #getVec2I()
	 * @generated
	 */
	EAttribute getVec2I_X();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Vec2I#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Vec2I#getY()
	 * @see #getVec2I()
	 * @generated
	 */
	EAttribute getVec2I_Y();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport <em>Viewport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewport</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Viewport
	 * @generated
	 */
	EClass getViewport();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getOffsetX <em>Offset X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset X</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Viewport#getOffsetX()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_OffsetX();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getOffsetY <em>Offset Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset Y</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Viewport#getOffsetY()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_OffsetY();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extent</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Viewport#getExtent()
	 * @see #getViewport()
	 * @generated
	 */
	EReference getViewport_Extent();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getMinDepth <em>Min Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Depth</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Viewport#getMinDepth()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_MinDepth();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getMaxDepth <em>Max Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Depth</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Viewport#getMaxDepth()
	 * @see #getViewport()
	 * @generated
	 */
	EAttribute getViewport_MaxDepth();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.Scissor <em>Scissor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scissor</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Scissor
	 * @generated
	 */
	EClass getScissor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getOffsetX <em>Offset X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset X</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Scissor#getOffsetX()
	 * @see #getScissor()
	 * @generated
	 */
	EAttribute getScissor_OffsetX();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getOffsetY <em>Offset Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset Y</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Scissor#getOffsetY()
	 * @see #getScissor()
	 * @generated
	 */
	EAttribute getScissor_OffsetY();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.graphicpipeline.Scissor#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extent</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Scissor#getExtent()
	 * @see #getScissor()
	 * @generated
	 */
	EReference getScissor_Extent();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState <em>Depth Stencil State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depth Stencil State</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DepthStencilState
	 * @generated
	 */
	EClass getDepthStencilState();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthTest <em>Depth Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Test</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthTest()
	 * @see #getDepthStencilState()
	 * @generated
	 */
	EAttribute getDepthStencilState_DepthTest();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthWrite <em>Depth Write</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Write</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthWrite()
	 * @see #getDepthStencilState()
	 * @generated
	 */
	EAttribute getDepthStencilState_DepthWrite();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthBoundTest <em>Depth Bound Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Bound Test</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthBoundTest()
	 * @see #getDepthStencilState()
	 * @generated
	 */
	EAttribute getDepthStencilState_DepthBoundTest();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isStencilTest <em>Stencil Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stencil Test</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isStencilTest()
	 * @see #getDepthStencilState()
	 * @generated
	 */
	EAttribute getDepthStencilState_StencilTest();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getDepthCompareOp <em>Depth Compare Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth Compare Op</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getDepthCompareOp()
	 * @see #getDepthStencilState()
	 * @generated
	 */
	EAttribute getDepthStencilState_DepthCompareOp();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getMinDepthBounds <em>Min Depth Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Depth Bounds</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getMinDepthBounds()
	 * @see #getDepthStencilState()
	 * @generated
	 */
	EAttribute getDepthStencilState_MinDepthBounds();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getMaxDepthBounds <em>Max Depth Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Depth Bounds</em>'.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getMaxDepthBounds()
	 * @see #getDepthStencilState()
	 * @generated
	 */
	EAttribute getDepthStencilState_MaxDepthBounds();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphicpipelineFactory getGraphicpipelineFactory();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendImpl <em>Color Blend</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getColorBlend()
		 * @generated
		 */
		EClass COLOR_BLEND = eINSTANCE.getColorBlend();

		/**
		 * The meta object literal for the '<em><b>Attachments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLOR_BLEND__ATTACHMENTS = eINSTANCE.getColorBlend_Attachments();

		/**
		 * The meta object literal for the '<em><b>Logic Op Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__LOGIC_OP_ENABLE = eINSTANCE.getColorBlend_LogicOpEnable();

		/**
		 * The meta object literal for the '<em><b>Logic Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__LOGIC_OP = eINSTANCE.getColorBlend_LogicOp();

		/**
		 * The meta object literal for the '<em><b>Blend Constant0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__BLEND_CONSTANT0 = eINSTANCE.getColorBlend_BlendConstant0();

		/**
		 * The meta object literal for the '<em><b>Blend Constant1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__BLEND_CONSTANT1 = eINSTANCE.getColorBlend_BlendConstant1();

		/**
		 * The meta object literal for the '<em><b>Blend Constant2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__BLEND_CONSTANT2 = eINSTANCE.getColorBlend_BlendConstant2();

		/**
		 * The meta object literal for the '<em><b>Blend Constant3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND__BLEND_CONSTANT3 = eINSTANCE.getColorBlend_BlendConstant3();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl <em>Color Blend Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getColorBlendAttachment()
		 * @generated
		 */
		EClass COLOR_BLEND_ATTACHMENT = eINSTANCE.getColorBlendAttachment();

		/**
		 * The meta object literal for the '<em><b>Blend Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__BLEND_ENABLE = eINSTANCE.getColorBlendAttachment_BlendEnable();

		/**
		 * The meta object literal for the '<em><b>Src Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__SRC_COLOR = eINSTANCE.getColorBlendAttachment_SrcColor();

		/**
		 * The meta object literal for the '<em><b>Dst Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__DST_COLOR = eINSTANCE.getColorBlendAttachment_DstColor();

		/**
		 * The meta object literal for the '<em><b>Src Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__SRC_ALPHA = eINSTANCE.getColorBlendAttachment_SrcAlpha();

		/**
		 * The meta object literal for the '<em><b>Dst Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__DST_ALPHA = eINSTANCE.getColorBlendAttachment_DstAlpha();

		/**
		 * The meta object literal for the '<em><b>Color Blend Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP = eINSTANCE.getColorBlendAttachment_ColorBlendOp();

		/**
		 * The meta object literal for the '<em><b>Alpha Blend Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP = eINSTANCE.getColorBlendAttachment_AlphaBlendOp();

		/**
		 * The meta object literal for the '<em><b>Red Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE = eINSTANCE.getColorBlendAttachment_RedComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Green Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE = eINSTANCE.getColorBlendAttachment_GreenComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Blue Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE = eINSTANCE.getColorBlendAttachment_BlueComponentEnable();

		/**
		 * The meta object literal for the '<em><b>Alpha Component Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE = eINSTANCE.getColorBlendAttachment_AlphaComponentEnable();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.InputAssemblyImpl <em>Input Assembly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.InputAssemblyImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getInputAssembly()
		 * @generated
		 */
		EClass INPUT_ASSEMBLY = eINSTANCE.getInputAssembly();

		/**
		 * The meta object literal for the '<em><b>Primitive Restart Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED = eINSTANCE.getInputAssembly_PrimitiveRestartEnabled();

		/**
		 * The meta object literal for the '<em><b>Primitive Topology</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY = eINSTANCE.getInputAssembly_PrimitiveTopology();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl <em>Rasterizer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getRasterizer()
		 * @generated
		 */
		EClass RASTERIZER = eINSTANCE.getRasterizer();

		/**
		 * The meta object literal for the '<em><b>Cull Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__CULL_MODE = eINSTANCE.getRasterizer_CullMode();

		/**
		 * The meta object literal for the '<em><b>Front Face</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__FRONT_FACE = eINSTANCE.getRasterizer_FrontFace();

		/**
		 * The meta object literal for the '<em><b>Polygon Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__POLYGON_MODE = eINSTANCE.getRasterizer_PolygonMode();

		/**
		 * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__LINE_WIDTH = eINSTANCE.getRasterizer_LineWidth();

		/**
		 * The meta object literal for the '<em><b>Depth Clamp Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__DEPTH_CLAMP_ENABLE = eINSTANCE.getRasterizer_DepthClampEnable();

		/**
		 * The meta object literal for the '<em><b>Discard Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__DISCARD_ENABLE = eINSTANCE.getRasterizer_DiscardEnable();

		/**
		 * The meta object literal for the '<em><b>Depth Bias Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RASTERIZER__DEPTH_BIAS_ENABLE = eINSTANCE.getRasterizer_DepthBiasEnable();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.DynamicStateImpl <em>Dynamic State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.DynamicStateImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getDynamicState()
		 * @generated
		 */
		EClass DYNAMIC_STATE = eINSTANCE.getDynamicState();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_STATE__STATES = eINSTANCE.getDynamicState_States();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.ViewportState <em>Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.ViewportState
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getViewportState()
		 * @generated
		 */
		EClass VIEWPORT_STATE = eINSTANCE.getViewportState();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.StaticViewportStateImpl <em>Static Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.StaticViewportStateImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getStaticViewportState()
		 * @generated
		 */
		EClass STATIC_VIEWPORT_STATE = eINSTANCE.getStaticViewportState();

		/**
		 * The meta object literal for the '<em><b>Viewports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIC_VIEWPORT_STATE__VIEWPORTS = eINSTANCE.getStaticViewportState_Viewports();

		/**
		 * The meta object literal for the '<em><b>Scissors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIC_VIEWPORT_STATE__SCISSORS = eINSTANCE.getStaticViewportState_Scissors();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.DynamicViewportStateImpl <em>Dynamic Viewport State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.DynamicViewportStateImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getDynamicViewportState()
		 * @generated
		 */
		EClass DYNAMIC_VIEWPORT_STATE = eINSTANCE.getDynamicViewportState();

		/**
		 * The meta object literal for the '<em><b>Viewport Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT = eINSTANCE.getDynamicViewportState_ViewportCount();

		/**
		 * The meta object literal for the '<em><b>Scissor Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT = eINSTANCE.getDynamicViewportState_ScissorCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.Vec2IImpl <em>Vec2 I</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.Vec2IImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getVec2I()
		 * @generated
		 */
		EClass VEC2_I = eINSTANCE.getVec2I();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEC2_I__X = eINSTANCE.getVec2I_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEC2_I__Y = eINSTANCE.getVec2I_Y();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl <em>Viewport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getViewport()
		 * @generated
		 */
		EClass VIEWPORT = eINSTANCE.getViewport();

		/**
		 * The meta object literal for the '<em><b>Offset X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWPORT__OFFSET_X = eINSTANCE.getViewport_OffsetX();

		/**
		 * The meta object literal for the '<em><b>Offset Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWPORT__OFFSET_Y = eINSTANCE.getViewport_OffsetY();

		/**
		 * The meta object literal for the '<em><b>Extent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEWPORT__EXTENT = eINSTANCE.getViewport_Extent();

		/**
		 * The meta object literal for the '<em><b>Min Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWPORT__MIN_DEPTH = eINSTANCE.getViewport_MinDepth();

		/**
		 * The meta object literal for the '<em><b>Max Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWPORT__MAX_DEPTH = eINSTANCE.getViewport_MaxDepth();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.ScissorImpl <em>Scissor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.ScissorImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getScissor()
		 * @generated
		 */
		EClass SCISSOR = eINSTANCE.getScissor();

		/**
		 * The meta object literal for the '<em><b>Offset X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCISSOR__OFFSET_X = eINSTANCE.getScissor_OffsetX();

		/**
		 * The meta object literal for the '<em><b>Offset Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCISSOR__OFFSET_Y = eINSTANCE.getScissor_OffsetY();

		/**
		 * The meta object literal for the '<em><b>Extent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCISSOR__EXTENT = eINSTANCE.getScissor_Extent();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl <em>Depth Stencil State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl
		 * @see org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl#getDepthStencilState()
		 * @generated
		 */
		EClass DEPTH_STENCIL_STATE = eINSTANCE.getDepthStencilState();

		/**
		 * The meta object literal for the '<em><b>Depth Test</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPTH_STENCIL_STATE__DEPTH_TEST = eINSTANCE.getDepthStencilState_DepthTest();

		/**
		 * The meta object literal for the '<em><b>Depth Write</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPTH_STENCIL_STATE__DEPTH_WRITE = eINSTANCE.getDepthStencilState_DepthWrite();

		/**
		 * The meta object literal for the '<em><b>Depth Bound Test</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST = eINSTANCE.getDepthStencilState_DepthBoundTest();

		/**
		 * The meta object literal for the '<em><b>Stencil Test</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPTH_STENCIL_STATE__STENCIL_TEST = eINSTANCE.getDepthStencilState_StencilTest();

		/**
		 * The meta object literal for the '<em><b>Depth Compare Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP = eINSTANCE.getDepthStencilState_DepthCompareOp();

		/**
		 * The meta object literal for the '<em><b>Min Depth Bounds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS = eINSTANCE.getDepthStencilState_MinDepthBounds();

		/**
		 * The meta object literal for the '<em><b>Max Depth Bounds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS = eINSTANCE.getDepthStencilState_MaxDepthBounds();

	}

} //GraphicpipelinePackage
