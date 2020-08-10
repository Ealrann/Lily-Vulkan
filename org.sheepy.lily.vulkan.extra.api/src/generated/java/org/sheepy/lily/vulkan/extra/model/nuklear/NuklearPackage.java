/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
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
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFactory
 * @model kind="package"
 * @generated
 */
public interface NuklearPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nuklear";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.model.nuklear";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nuklear";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NuklearPackage eINSTANCE = org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPushConstantsImpl <em>Push Constants</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPushConstantsImpl
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearPushConstants()
	 * @generated
	 */
	int NUKLEAR_PUSH_CONSTANTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__NAME = ProcessPackage.PUSH_CONSTANT__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__ENABLED = ProcessPackage.PUSH_CONSTANT__ENABLED;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__STAGES = ProcessPackage.PUSH_CONSTANT__STAGES;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__WIDTH = ProcessPackage.PUSH_CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__HEIGHT = ProcessPackage.PUSH_CONSTANT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current Descriptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR = ProcessPackage.PUSH_CONSTANT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Push Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS_FEATURE_COUNT = ProcessPackage.PUSH_CONSTANT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Push Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_PUSH_CONSTANTS_OPERATION_COUNT = ProcessPackage.PUSH_CONSTANT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearContext()
	 * @generated
	 */
	int NUKLEAR_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__NAME = ResourcePackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Font</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__FONT = ResourcePackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Null Texture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__NULL_TEXTURE = ResourcePackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image Array Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR = ResourcePackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Vertex Data Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__VERTEX_DATA_PROVIDER = ResourcePackage.IRESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Index Data Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__INDEX_DATA_PROVIDER = ResourcePackage.IRESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Vertex Memory Chunk</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__VERTEX_MEMORY_CHUNK = ResourcePackage.IRESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Composite Draw Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT__COMPOSITE_DRAW_TASK = ResourcePackage.IRESOURCE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT_FEATURE_COUNT = ResourcePackage.IRESOURCE_FEATURE_COUNT + 7;


	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_CONTEXT_OPERATION_COUNT = ResourcePackage.IRESOURCE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl <em>Font</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearFont()
	 * @generated
	 */
	int NUKLEAR_FONT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_FONT__NAME = ResourcePackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_FONT__TRANSFER_BUFFER = ResourcePackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Font Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_FONT__FONT_IMAGE = ResourcePackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Font</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_FONT_FEATURE_COUNT = ResourcePackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Font</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_FONT_OPERATION_COUNT = ResourcePackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl <em>Selector Panel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getSelectorPanel()
	 * @generated
	 */
	int SELECTOR_PANEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__NAME = UiPackage.IPANEL__NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__POSITION = UiPackage.IPANEL__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__VERTICAL_RELATIVE = UiPackage.IPANEL__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__HORIZONTAL_RELATIVE = UiPackage.IPANEL__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Catch Inputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__CATCH_INPUTS = UiPackage.IPANEL__CATCH_INPUTS;

	/**
	 * The feature id for the '<em><b>Button Size Px</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__BUTTON_SIZE_PX = UiPackage.IPANEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selection R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__SELECTION_R = UiPackage.IPANEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Selection G</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__SELECTION_G = UiPackage.IPANEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Selection B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__SELECTION_B = UiPackage.IPANEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Print Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__PRINT_LABELS = UiPackage.IPANEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__VARIABLE_RESOLVER = UiPackage.IPANEL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Input Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__INPUT_PROVIDER = UiPackage.IPANEL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Vertical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__VERTICAL = UiPackage.IPANEL_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Auto Hide Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__AUTO_HIDE_LABELS = UiPackage.IPANEL_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Fade Out Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__FADE_OUT_MS = UiPackage.IPANEL_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__UNSETTABLE = UiPackage.IPANEL_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Detect Hover On Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL__DETECT_HOVER_ON_LABELS = UiPackage.IPANEL_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Selector Panel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL_FEATURE_COUNT = UiPackage.IPANEL_FEATURE_COUNT + 12;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL___LINFERENCE_OBJECT = UiPackage.IPANEL___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Selector Panel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTOR_PANEL_OPERATION_COUNT = UiPackage.IPANEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider <em>IInput Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getIInputProvider()
	 * @generated
	 */
	int IINPUT_PROVIDER = 4;

	/**
	 * The number of structural features of the '<em>IInput Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINPUT_PROVIDER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IInput Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINPUT_PROVIDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.PanelViewerImpl <em>Panel Viewer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.PanelViewerImpl
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getPanelViewer()
	 * @generated
	 */
	int PANEL_VIEWER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__NAME = UiPackage.PANEL__NAME;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__POSITION = UiPackage.PANEL__POSITION;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__VERTICAL_RELATIVE = UiPackage.PANEL__VERTICAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__HORIZONTAL_RELATIVE = UiPackage.PANEL__HORIZONTAL_RELATIVE;

	/**
	 * The feature id for the '<em><b>Catch Inputs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__CATCH_INPUTS = UiPackage.PANEL__CATCH_INPUTS;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__WIDTH = UiPackage.PANEL__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__HEIGHT = UiPackage.PANEL__HEIGHT;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__CONTROLS = UiPackage.PANEL__CONTROLS;

	/**
	 * The feature id for the '<em><b>Show Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__SHOW_TITLE = UiPackage.PANEL__SHOW_TITLE;

	/**
	 * The feature id for the '<em><b>Minimizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__MINIMIZABLE = UiPackage.PANEL__MINIMIZABLE;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__MOVABLE = UiPackage.PANEL__MOVABLE;

	/**
	 * The feature id for the '<em><b>Minimized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__MINIMIZED = UiPackage.PANEL__MINIMIZED;

	/**
	 * The feature id for the '<em><b>Background Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__BACKGROUND_IMAGE = UiPackage.PANEL__BACKGROUND_IMAGE;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__BACKGROUND_COLOR = UiPackage.PANEL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__BORDER_COLOR = UiPackage.PANEL__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER__VARIABLE_RESOLVER = UiPackage.PANEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Panel Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER_FEATURE_COUNT = UiPackage.PANEL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>LInference Object</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER___LINFERENCE_OBJECT = UiPackage.PANEL___LINFERENCE_OBJECT;

	/**
	 * The number of operations of the '<em>Panel Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PANEL_VIEWER_OPERATION_COUNT = UiPackage.PANEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearVertexProviderImpl <em>Vertex Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearVertexProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearVertexProvider()
	 * @generated
	 */
	int NUKLEAR_VERTEX_PROVIDER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_VERTEX_PROVIDER__NAME = VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME;

	/**
	 * The number of structural features of the '<em>Vertex Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_VERTEX_PROVIDER_FEATURE_COUNT = VulkanResourcePackage.BUFFER_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vertex Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_VERTEX_PROVIDER_OPERATION_COUNT = VulkanResourcePackage.BUFFER_DATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearIndexProviderImpl <em>Index Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearIndexProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearIndexProvider()
	 * @generated
	 */
	int NUKLEAR_INDEX_PROVIDER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_INDEX_PROVIDER__NAME = VulkanResourcePackage.BUFFER_DATA_PROVIDER__NAME;

	/**
	 * The number of structural features of the '<em>Index Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_INDEX_PROVIDER_FEATURE_COUNT = VulkanResourcePackage.BUFFER_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Index Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUKLEAR_INDEX_PROVIDER_OPERATION_COUNT = VulkanResourcePackage.BUFFER_DATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants <em>Push Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Constants</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants
	 * @generated
	 */
	EClass getNuklearPushConstants();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants#getWidth()
	 * @see #getNuklearPushConstants()
	 * @generated
	 */
	EAttribute getNuklearPushConstants_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants#getHeight()
	 * @see #getNuklearPushConstants()
	 * @generated
	 */
	EAttribute getNuklearPushConstants_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants#getCurrentDescriptor <em>Current Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants#getCurrentDescriptor()
	 * @see #getNuklearPushConstants()
	 * @generated
	 */
	EAttribute getNuklearPushConstants_CurrentDescriptor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext
	 * @generated
	 */
	EClass getNuklearContext();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Font</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getFont()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_Font();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getNullTexture <em>Null Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Null Texture</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getNullTexture()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_NullTexture();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getImageArrayDescriptor <em>Image Array Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image Array Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getImageArrayDescriptor()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_ImageArrayDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexDataProvider <em>Vertex Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vertex Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexDataProvider()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_VertexDataProvider();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getIndexDataProvider <em>Index Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Index Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getIndexDataProvider()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_IndexDataProvider();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexMemoryChunk <em>Vertex Memory Chunk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vertex Memory Chunk</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getVertexMemoryChunk()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_VertexMemoryChunk();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getCompositeDrawTask <em>Composite Draw Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite Draw Task</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext#getCompositeDrawTask()
	 * @see #getNuklearContext()
	 * @generated
	 */
	EReference getNuklearContext_CompositeDrawTask();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont
	 * @generated
	 */
	EClass getNuklearFont();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getTransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getTransferBuffer()
	 * @see #getNuklearFont()
	 * @generated
	 */
	EReference getNuklearFont_TransferBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontImage <em>Font Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Font Image</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont#getFontImage()
	 * @see #getNuklearFont()
	 * @generated
	 */
	EReference getNuklearFont_FontImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel <em>Selector Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selector Panel</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel
	 * @generated
	 */
	EClass getSelectorPanel();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getButtonSizePx <em>Button Size Px</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button Size Px</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getButtonSizePx()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_ButtonSizePx();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionR <em>Selection R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection R</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionR()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_SelectionR();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionG <em>Selection G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection G</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionG()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_SelectionG();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionB <em>Selection B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection B</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionB()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_SelectionB();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isPrintLabels <em>Print Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Print Labels</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isPrintLabels()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_PrintLabels();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getVariableResolver <em>Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Resolver</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getVariableResolver()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EReference getSelectorPanel_VariableResolver();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getInputProvider <em>Input Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getInputProvider()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EReference getSelectorPanel_InputProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isVertical <em>Vertical</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isVertical()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_Vertical();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isAutoHideLabels <em>Auto Hide Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Hide Labels</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isAutoHideLabels()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_AutoHideLabels();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getFadeOutMs <em>Fade Out Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fade Out Ms</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getFadeOutMs()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_FadeOutMs();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isUnsettable <em>Unsettable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsettable</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isUnsettable()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_Unsettable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isDetectHoverOnLabels <em>Detect Hover On Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Detect Hover On Labels</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isDetectHoverOnLabels()
	 * @see #getSelectorPanel()
	 * @generated
	 */
	EAttribute getSelectorPanel_DetectHoverOnLabels();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider <em>IInput Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IInput Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider
	 * @generated
	 */
	EClass getIInputProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer <em>Panel Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Panel Viewer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer
	 * @generated
	 */
	EClass getPanelViewer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer#getVariableResolver <em>Variable Resolver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Resolver</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer#getVariableResolver()
	 * @see #getPanelViewer()
	 * @generated
	 */
	EReference getPanelViewer_VariableResolver();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider <em>Vertex Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider
	 * @generated
	 */
	EClass getNuklearVertexProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider <em>Index Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider
	 * @generated
	 */
	EClass getNuklearIndexProvider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NuklearFactory getNuklearFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPushConstantsImpl <em>Push Constants</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPushConstantsImpl
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearPushConstants()
		 * @generated
		 */
		EClass NUKLEAR_PUSH_CONSTANTS = eINSTANCE.getNuklearPushConstants();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUKLEAR_PUSH_CONSTANTS__WIDTH = eINSTANCE.getNuklearPushConstants_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUKLEAR_PUSH_CONSTANTS__HEIGHT = eINSTANCE.getNuklearPushConstants_Height();

		/**
		 * The meta object literal for the '<em><b>Current Descriptor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR = eINSTANCE.getNuklearPushConstants_CurrentDescriptor();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearContext()
		 * @generated
		 */
		EClass NUKLEAR_CONTEXT = eINSTANCE.getNuklearContext();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__FONT = eINSTANCE.getNuklearContext_Font();

		/**
		 * The meta object literal for the '<em><b>Null Texture</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__NULL_TEXTURE = eINSTANCE.getNuklearContext_NullTexture();

		/**
		 * The meta object literal for the '<em><b>Image Array Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__IMAGE_ARRAY_DESCRIPTOR = eINSTANCE.getNuklearContext_ImageArrayDescriptor();

		/**
		 * The meta object literal for the '<em><b>Vertex Data Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__VERTEX_DATA_PROVIDER = eINSTANCE.getNuklearContext_VertexDataProvider();

		/**
		 * The meta object literal for the '<em><b>Index Data Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__INDEX_DATA_PROVIDER = eINSTANCE.getNuklearContext_IndexDataProvider();

		/**
		 * The meta object literal for the '<em><b>Vertex Memory Chunk</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__VERTEX_MEMORY_CHUNK = eINSTANCE.getNuklearContext_VertexMemoryChunk();

		/**
		 * The meta object literal for the '<em><b>Composite Draw Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_CONTEXT__COMPOSITE_DRAW_TASK = eINSTANCE.getNuklearContext_CompositeDrawTask();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl <em>Font</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearFont()
		 * @generated
		 */
		EClass NUKLEAR_FONT = eINSTANCE.getNuklearFont();

		/**
		 * The meta object literal for the '<em><b>Transfer Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_FONT__TRANSFER_BUFFER = eINSTANCE.getNuklearFont_TransferBuffer();

		/**
		 * The meta object literal for the '<em><b>Font Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUKLEAR_FONT__FONT_IMAGE = eINSTANCE.getNuklearFont_FontImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl <em>Selector Panel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getSelectorPanel()
		 * @generated
		 */
		EClass SELECTOR_PANEL = eINSTANCE.getSelectorPanel();

		/**
		 * The meta object literal for the '<em><b>Button Size Px</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__BUTTON_SIZE_PX = eINSTANCE.getSelectorPanel_ButtonSizePx();

		/**
		 * The meta object literal for the '<em><b>Selection R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__SELECTION_R = eINSTANCE.getSelectorPanel_SelectionR();

		/**
		 * The meta object literal for the '<em><b>Selection G</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__SELECTION_G = eINSTANCE.getSelectorPanel_SelectionG();

		/**
		 * The meta object literal for the '<em><b>Selection B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__SELECTION_B = eINSTANCE.getSelectorPanel_SelectionB();

		/**
		 * The meta object literal for the '<em><b>Print Labels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__PRINT_LABELS = eINSTANCE.getSelectorPanel_PrintLabels();

		/**
		 * The meta object literal for the '<em><b>Variable Resolver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTOR_PANEL__VARIABLE_RESOLVER = eINSTANCE.getSelectorPanel_VariableResolver();

		/**
		 * The meta object literal for the '<em><b>Input Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTOR_PANEL__INPUT_PROVIDER = eINSTANCE.getSelectorPanel_InputProvider();

		/**
		 * The meta object literal for the '<em><b>Vertical</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__VERTICAL = eINSTANCE.getSelectorPanel_Vertical();

		/**
		 * The meta object literal for the '<em><b>Auto Hide Labels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__AUTO_HIDE_LABELS = eINSTANCE.getSelectorPanel_AutoHideLabels();

		/**
		 * The meta object literal for the '<em><b>Fade Out Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__FADE_OUT_MS = eINSTANCE.getSelectorPanel_FadeOutMs();

		/**
		 * The meta object literal for the '<em><b>Unsettable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__UNSETTABLE = eINSTANCE.getSelectorPanel_Unsettable();

		/**
		 * The meta object literal for the '<em><b>Detect Hover On Labels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTOR_PANEL__DETECT_HOVER_ON_LABELS = eINSTANCE.getSelectorPanel_DetectHoverOnLabels();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider <em>IInput Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getIInputProvider()
		 * @generated
		 */
		EClass IINPUT_PROVIDER = eINSTANCE.getIInputProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.PanelViewerImpl <em>Panel Viewer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.PanelViewerImpl
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getPanelViewer()
		 * @generated
		 */
		EClass PANEL_VIEWER = eINSTANCE.getPanelViewer();

		/**
		 * The meta object literal for the '<em><b>Variable Resolver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PANEL_VIEWER__VARIABLE_RESOLVER = eINSTANCE.getPanelViewer_VariableResolver();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearVertexProviderImpl <em>Vertex Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearVertexProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearVertexProvider()
		 * @generated
		 */
		EClass NUKLEAR_VERTEX_PROVIDER = eINSTANCE.getNuklearVertexProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearIndexProviderImpl <em>Index Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearIndexProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl#getNuklearIndexProvider()
		 * @generated
		 */
		EClass NUKLEAR_INDEX_PROVIDER = eINSTANCE.getNuklearIndexProvider();

	}

} //NuklearPackage
