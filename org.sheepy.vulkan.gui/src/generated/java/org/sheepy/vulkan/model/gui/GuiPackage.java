/**
 */
package org.sheepy.vulkan.model.gui;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.vulkan.model.process.graphic.GraphicPackage;

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
 * @see org.sheepy.vulkan.model.gui.GuiFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/gui' publicConstructors='true' updateClasspath='false' basePackage='org.sheepy.vulkan.model'"
 * @generated
 */
public interface GuiPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gui";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.model.gui";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gui";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GuiPackage eINSTANCE = org.sheepy.vulkan.model.gui.impl.GuiPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.gui.impl.GUIPipelineImpl <em>GUI Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.gui.impl.GUIPipelineImpl
	 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getGUIPipeline()
	 * @generated
	 */
	int GUI_PIPELINE = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__ENABLED = GraphicPackage.GRAPHICS_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__STAGE = GraphicPackage.GRAPHICS_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__UNITS = GraphicPackage.GRAPHICS_PIPELINE__UNITS;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__DESCRIPTOR_SET = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__CONSTANTS = GraphicPackage.GRAPHICS_PIPELINE__CONSTANTS;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__SHADERS = GraphicPackage.GRAPHICS_PIPELINE__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__VIEWPORT_STATE = GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__RASTERIZER = GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__COLOR_BLEND = GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__DYNAMIC_STATE = GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Windows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE__WINDOWS = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>GUI Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE_FEATURE_COUNT = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>GUI Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_PIPELINE_OPERATION_COUNT = GraphicPackage.GRAPHICS_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.gui.impl.WindowImpl <em>Window</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.gui.impl.WindowImpl
	 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getWindow()
	 * @generated
	 */
	int WINDOW = 1;

	/**
	 * The feature id for the '<em><b>Widgets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__WIDGETS = 0;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__POSITION = 1;

	/**
	 * The number of structural features of the '<em>Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.gui.impl.WidgetImpl <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.gui.impl.WidgetImpl
	 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 2;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.gui.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.gui.impl.TextImpl
	 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__VALUE = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.gui.impl.ButtonImpl <em>Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.gui.impl.ButtonImpl
	 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getButton()
	 * @generated
	 */
	int BUTTON = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__NAME = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>On Click</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON___ON_CLICK = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.gui.GUIPipeline <em>GUI Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GUI Pipeline</em>'.
	 * @see org.sheepy.vulkan.model.gui.GUIPipeline
	 * @generated
	 */
	EClass getGUIPipeline();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.gui.GUIPipeline#getWindows <em>Windows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Windows</em>'.
	 * @see org.sheepy.vulkan.model.gui.GUIPipeline#getWindows()
	 * @see #getGUIPipeline()
	 * @generated
	 */
	EReference getGUIPipeline_Windows();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.gui.Window <em>Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Window</em>'.
	 * @see org.sheepy.vulkan.model.gui.Window
	 * @generated
	 */
	EClass getWindow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.vulkan.model.gui.Window#getWidgets <em>Widgets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widgets</em>'.
	 * @see org.sheepy.vulkan.model.gui.Window#getWidgets()
	 * @see #getWindow()
	 * @generated
	 */
	EReference getWindow_Widgets();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.gui.Window#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.sheepy.vulkan.model.gui.Window#getPosition()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_Position();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.gui.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see org.sheepy.vulkan.model.gui.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.gui.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.sheepy.vulkan.model.gui.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.gui.Text#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.sheepy.vulkan.model.gui.Text#getValue()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Value();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.gui.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Button</em>'.
	 * @see org.sheepy.vulkan.model.gui.Button
	 * @generated
	 */
	EClass getButton();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.gui.Button#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sheepy.vulkan.model.gui.Button#getName()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Name();

	/**
	 * Returns the meta object for the '{@link org.sheepy.vulkan.model.gui.Button#onClick() <em>On Click</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>On Click</em>' operation.
	 * @see org.sheepy.vulkan.model.gui.Button#onClick()
	 * @generated
	 */
	EOperation getButton__OnClick();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GuiFactory getGuiFactory();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.gui.impl.GUIPipelineImpl <em>GUI Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.gui.impl.GUIPipelineImpl
		 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getGUIPipeline()
		 * @generated
		 */
		EClass GUI_PIPELINE = eINSTANCE.getGUIPipeline();

		/**
		 * The meta object literal for the '<em><b>Windows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUI_PIPELINE__WINDOWS = eINSTANCE.getGUIPipeline_Windows();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.gui.impl.WindowImpl <em>Window</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.gui.impl.WindowImpl
		 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getWindow()
		 * @generated
		 */
		EClass WINDOW = eINSTANCE.getWindow();

		/**
		 * The meta object literal for the '<em><b>Widgets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WINDOW__WIDGETS = eINSTANCE.getWindow_Widgets();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__POSITION = eINSTANCE.getWindow_Position();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.gui.impl.WidgetImpl <em>Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.gui.impl.WidgetImpl
		 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.gui.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.gui.impl.TextImpl
		 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__VALUE = eINSTANCE.getText_Value();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.gui.impl.ButtonImpl <em>Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.gui.impl.ButtonImpl
		 * @see org.sheepy.vulkan.model.gui.impl.GuiPackageImpl#getButton()
		 * @generated
		 */
		EClass BUTTON = eINSTANCE.getButton();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__NAME = eINSTANCE.getButton_Name();

		/**
		 * The meta object literal for the '<em><b>On Click</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUTTON___ON_CLICK = eINSTANCE.getButton__OnClick();

	}

} //GuiPackage
