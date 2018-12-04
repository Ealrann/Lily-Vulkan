/**
 */
package org.sheepy.vulkan.model.gui.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.common.model.types.TypesPackage;

import org.sheepy.vulkan.model.VulkanPackage;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.vulkan.model.gui.Button;
import org.sheepy.vulkan.model.gui.GUIPipeline;
import org.sheepy.vulkan.model.gui.GuiFactory;
import org.sheepy.vulkan.model.gui.GuiPackage;
import org.sheepy.vulkan.model.gui.Text;
import org.sheepy.vulkan.model.gui.Widget;
import org.sheepy.vulkan.model.gui.Window;

import org.sheepy.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GuiPackageImpl extends EPackageImpl implements GuiPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guiPipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buttonEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sheepy.vulkan.model.gui.GuiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GuiPackageImpl()
	{
		super(eNS_URI, GuiFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link GuiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GuiPackage init()
	{
		if (isInited) return (GuiPackage)EPackage.Registry.INSTANCE.getEPackage(GuiPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGuiPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GuiPackageImpl theGuiPackage = registeredGuiPackage instanceof GuiPackageImpl ? (GuiPackageImpl)registeredGuiPackage : new GuiPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		GraphicPackage.eINSTANCE.eClass();
		ProcessPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGuiPackage.createPackageContents();

		// Initialize created meta-data
		theGuiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGuiPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GuiPackage.eNS_URI, theGuiPackage);
		return theGuiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGUIPipeline()
	{
		return guiPipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGUIPipeline_Windows()
	{
		return (EReference)guiPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindow()
	{
		return windowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindow_Widgets()
	{
		return (EReference)windowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWindow_Position()
	{
		return (EAttribute)windowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidget()
	{
		return widgetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getText()
	{
		return textEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getText_Value()
	{
		return (EAttribute)textEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getButton()
	{
		return buttonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getButton_Name()
	{
		return (EAttribute)buttonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getButton__OnClick()
	{
		return buttonEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuiFactory getGuiFactory()
	{
		return (GuiFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		guiPipelineEClass = createEClass(GUI_PIPELINE);
		createEReference(guiPipelineEClass, GUI_PIPELINE__WINDOWS);

		windowEClass = createEClass(WINDOW);
		createEReference(windowEClass, WINDOW__WIDGETS);
		createEAttribute(windowEClass, WINDOW__POSITION);

		widgetEClass = createEClass(WIDGET);

		textEClass = createEClass(TEXT);
		createEAttribute(textEClass, TEXT__VALUE);

		buttonEClass = createEClass(BUTTON);
		createEAttribute(buttonEClass, BUTTON__NAME);
		createEOperation(buttonEClass, BUTTON___ON_CLICK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GraphicPackage theGraphicPackage = (GraphicPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		guiPipelineEClass.getESuperTypes().add(theGraphicPackage.getGraphicsPipeline());
		textEClass.getESuperTypes().add(this.getWidget());
		buttonEClass.getESuperTypes().add(this.getWidget());

		// Initialize classes, features, and operations; add parameters
		initEClass(guiPipelineEClass, GUIPipeline.class, "GUIPipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGUIPipeline_Windows(), this.getWindow(), null, "windows", null, 0, -1, GUIPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(windowEClass, Window.class, "Window", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWindow_Widgets(), this.getWidget(), null, "widgets", null, 0, -1, Window.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWindow_Position(), theTypesPackage.getSVector2i(), "position", null, 0, 1, Window.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetEClass, Widget.class, "Widget", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getText_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(buttonEClass, Button.class, "Button", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getButton_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Button.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getButton__OnClick(), null, "onClick", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GuiPackageImpl
