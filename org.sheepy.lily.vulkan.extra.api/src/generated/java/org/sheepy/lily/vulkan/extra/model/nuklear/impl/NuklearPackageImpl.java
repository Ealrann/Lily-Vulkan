/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;
import org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl;
import org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFactory;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl;
import org.sheepy.lily.vulkan.model.VulkanPackage;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

import org.sheepy.vulkan.model.barrier.BarrierPackage;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.image.ImagePackage;
import org.sheepy.vulkan.model.pipeline.PipelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NuklearPackageImpl extends EPackageImpl implements NuklearPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuklearPushConstantsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuklearLayoutTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuklearContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuklearFontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectorPanelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iInputProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass panelViewerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuklearVertexProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nuklearIndexProviderEClass = null;

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
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NuklearPackageImpl()
	{
		super(eNS_URI, NuklearFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NuklearPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NuklearPackage init()
	{
		if (isInited) return (NuklearPackage)EPackage.Registry.INSTANCE.getEPackage(NuklearPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredNuklearPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		NuklearPackageImpl theNuklearPackage = registeredNuklearPackage instanceof NuklearPackageImpl ? (NuklearPackageImpl)registeredNuklearPackage : new NuklearPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		UiPackage.eINSTANCE.eClass();
		PresentationPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		GraphicPackage.eINSTANCE.eClass();
		ProcessPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MeshPackage.eNS_URI);
		MeshPackageImpl theMeshPackage = (MeshPackageImpl)(registeredPackage instanceof MeshPackageImpl ? registeredPackage : MeshPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RenderingPackage.eNS_URI);
		RenderingPackageImpl theRenderingPackage = (RenderingPackageImpl)(registeredPackage instanceof RenderingPackageImpl ? registeredPackage : RenderingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SpritePackage.eNS_URI);
		SpritePackageImpl theSpritePackage = (SpritePackageImpl)(registeredPackage instanceof SpritePackageImpl ? registeredPackage : SpritePackage.eINSTANCE);

		// Create package meta-data objects
		theNuklearPackage.createPackageContents();
		theMeshPackage.createPackageContents();
		theRenderingPackage.createPackageContents();
		theSpritePackage.createPackageContents();

		// Initialize created meta-data
		theNuklearPackage.initializePackageContents();
		theMeshPackage.initializePackageContents();
		theRenderingPackage.initializePackageContents();
		theSpritePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNuklearPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NuklearPackage.eNS_URI, theNuklearPackage);
		return theNuklearPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNuklearPushConstants()
	{
		return nuklearPushConstantsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNuklearPushConstants_Width()
	{
		return (EAttribute)nuklearPushConstantsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNuklearPushConstants_Height()
	{
		return (EAttribute)nuklearPushConstantsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNuklearPushConstants_CurrentDescriptor()
	{
		return (EAttribute)nuklearPushConstantsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNuklearLayoutTask()
	{
		return nuklearLayoutTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearLayoutTask_Context()
	{
		return (EReference)nuklearLayoutTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearLayoutTask_DrawTask()
	{
		return (EReference)nuklearLayoutTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearLayoutTask_VertexBuffer()
	{
		return (EReference)nuklearLayoutTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearLayoutTask_ImageArray()
	{
		return (EReference)nuklearLayoutTaskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNuklearContext()
	{
		return nuklearContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearContext_Font()
	{
		return (EReference)nuklearContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearContext_NullTexture()
	{
		return (EReference)nuklearContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearContext_LayoutTask()
	{
		return (EReference)nuklearContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNuklearFont()
	{
		return nuklearFontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearFont_FontSampledImage()
	{
		return (EReference)nuklearFontEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSelectorPanel()
	{
		return selectorPanelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelectorPanel_ButtonSizePx()
	{
		return (EAttribute)selectorPanelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelectorPanel_SelectionR()
	{
		return (EAttribute)selectorPanelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelectorPanel_SelectionG()
	{
		return (EAttribute)selectorPanelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelectorPanel_SelectionB()
	{
		return (EAttribute)selectorPanelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelectorPanel_PrintLabels()
	{
		return (EAttribute)selectorPanelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSelectorPanel_VariableResolver()
	{
		return (EReference)selectorPanelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSelectorPanel_InputProvider()
	{
		return (EReference)selectorPanelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelectorPanel_Vertical()
	{
		return (EAttribute)selectorPanelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelectorPanel_AutoHideLabels()
	{
		return (EAttribute)selectorPanelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSelectorPanel_FadeOutMs()
	{
		return (EAttribute)selectorPanelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIInputProvider()
	{
		return iInputProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPanelViewer()
	{
		return panelViewerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPanelViewer_VariableResolver()
	{
		return (EReference)panelViewerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNuklearVertexProvider()
	{
		return nuklearVertexProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearVertexProvider_Context()
	{
		return (EReference)nuklearVertexProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNuklearIndexProvider()
	{
		return nuklearIndexProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearIndexProvider_Context()
	{
		return (EReference)nuklearIndexProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearFactory getNuklearFactory()
	{
		return (NuklearFactory)getEFactoryInstance();
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
		nuklearPushConstantsEClass = createEClass(NUKLEAR_PUSH_CONSTANTS);
		createEAttribute(nuklearPushConstantsEClass, NUKLEAR_PUSH_CONSTANTS__WIDTH);
		createEAttribute(nuklearPushConstantsEClass, NUKLEAR_PUSH_CONSTANTS__HEIGHT);
		createEAttribute(nuklearPushConstantsEClass, NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR);

		nuklearLayoutTaskEClass = createEClass(NUKLEAR_LAYOUT_TASK);
		createEReference(nuklearLayoutTaskEClass, NUKLEAR_LAYOUT_TASK__CONTEXT);
		createEReference(nuklearLayoutTaskEClass, NUKLEAR_LAYOUT_TASK__DRAW_TASK);
		createEReference(nuklearLayoutTaskEClass, NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER);
		createEReference(nuklearLayoutTaskEClass, NUKLEAR_LAYOUT_TASK__IMAGE_ARRAY);

		nuklearContextEClass = createEClass(NUKLEAR_CONTEXT);
		createEReference(nuklearContextEClass, NUKLEAR_CONTEXT__FONT);
		createEReference(nuklearContextEClass, NUKLEAR_CONTEXT__NULL_TEXTURE);
		createEReference(nuklearContextEClass, NUKLEAR_CONTEXT__LAYOUT_TASK);

		nuklearFontEClass = createEClass(NUKLEAR_FONT);
		createEReference(nuklearFontEClass, NUKLEAR_FONT__FONT_SAMPLED_IMAGE);

		selectorPanelEClass = createEClass(SELECTOR_PANEL);
		createEAttribute(selectorPanelEClass, SELECTOR_PANEL__BUTTON_SIZE_PX);
		createEAttribute(selectorPanelEClass, SELECTOR_PANEL__SELECTION_R);
		createEAttribute(selectorPanelEClass, SELECTOR_PANEL__SELECTION_G);
		createEAttribute(selectorPanelEClass, SELECTOR_PANEL__SELECTION_B);
		createEAttribute(selectorPanelEClass, SELECTOR_PANEL__PRINT_LABELS);
		createEReference(selectorPanelEClass, SELECTOR_PANEL__VARIABLE_RESOLVER);
		createEReference(selectorPanelEClass, SELECTOR_PANEL__INPUT_PROVIDER);
		createEAttribute(selectorPanelEClass, SELECTOR_PANEL__VERTICAL);
		createEAttribute(selectorPanelEClass, SELECTOR_PANEL__AUTO_HIDE_LABELS);
		createEAttribute(selectorPanelEClass, SELECTOR_PANEL__FADE_OUT_MS);

		iInputProviderEClass = createEClass(IINPUT_PROVIDER);

		panelViewerEClass = createEClass(PANEL_VIEWER);
		createEReference(panelViewerEClass, PANEL_VIEWER__VARIABLE_RESOLVER);

		nuklearVertexProviderEClass = createEClass(NUKLEAR_VERTEX_PROVIDER);
		createEReference(nuklearVertexProviderEClass, NUKLEAR_VERTEX_PROVIDER__CONTEXT);

		nuklearIndexProviderEClass = createEClass(NUKLEAR_INDEX_PROVIDER);
		createEReference(nuklearIndexProviderEClass, NUKLEAR_INDEX_PROVIDER__CONTEXT);
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
		ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		PresentationPackage thePresentationPackage = (PresentationPackage)EPackage.Registry.INSTANCE.getEPackage(PresentationPackage.eNS_URI);
		VariablePackage theVariablePackage = (VariablePackage)EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);
		UiPackage theUiPackage = (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		nuklearPushConstantsEClass.getESuperTypes().add(theProcessPackage.getPushConstant());
		nuklearLayoutTaskEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		nuklearContextEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		nuklearFontEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		selectorPanelEClass.getESuperTypes().add(thePresentationPackage.getIPanel());
		panelViewerEClass.getESuperTypes().add(theUiPackage.getPanel());
		EGenericType g1 = createEGenericType(theResourcePackage.getBufferDataProvider());
		EGenericType g2 = createEGenericType(this.getNuklearContext());
		g1.getETypeArguments().add(g2);
		nuklearVertexProviderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theResourcePackage.getBufferDataProvider());
		g2 = createEGenericType(this.getNuklearContext());
		g1.getETypeArguments().add(g2);
		nuklearIndexProviderEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(nuklearPushConstantsEClass, NuklearPushConstants.class, "NuklearPushConstants", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNuklearPushConstants_Width(), ecorePackage.getEInt(), "width", null, 0, 1, NuklearPushConstants.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuklearPushConstants_Height(), ecorePackage.getEInt(), "height", null, 0, 1, NuklearPushConstants.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuklearPushConstants_CurrentDescriptor(), ecorePackage.getEInt(), "currentDescriptor", null, 0, 1, NuklearPushConstants.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuklearLayoutTaskEClass, NuklearLayoutTask.class, "NuklearLayoutTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNuklearLayoutTask_Context(), this.getNuklearContext(), this.getNuklearContext_LayoutTask(), "context", null, 1, 1, NuklearLayoutTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearLayoutTask_DrawTask(), theProcessPackage.getCompositeTask(), null, "drawTask", null, 0, 1, NuklearLayoutTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearLayoutTask_VertexBuffer(), theResourcePackage.getCompositeBuffer(), null, "vertexBuffer", null, 1, 1, NuklearLayoutTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearLayoutTask_ImageArray(), theResourcePackage.getTexture2DArray(), null, "imageArray", null, 0, 1, NuklearLayoutTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuklearContextEClass, NuklearContext.class, "NuklearContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNuklearContext_Font(), this.getNuklearFont(), null, "font", null, 1, 1, NuklearContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearContext_NullTexture(), theResourcePackage.getSampledImage(), null, "nullTexture", null, 0, 1, NuklearContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearContext_LayoutTask(), this.getNuklearLayoutTask(), this.getNuklearLayoutTask_Context(), "layoutTask", null, 1, 1, NuklearContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuklearFontEClass, NuklearFont.class, "NuklearFont", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNuklearFont_FontSampledImage(), theResourcePackage.getSampledImage(), null, "fontSampledImage", null, 1, 1, NuklearFont.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectorPanelEClass, SelectorPanel.class, "SelectorPanel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSelectorPanel_ButtonSizePx(), ecorePackage.getEInt(), "buttonSizePx", "32", 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectorPanel_SelectionR(), ecorePackage.getEInt(), "selectionR", "0", 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectorPanel_SelectionG(), ecorePackage.getEInt(), "selectionG", "135", 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectorPanel_SelectionB(), ecorePackage.getEInt(), "selectionB", "255", 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectorPanel_PrintLabels(), ecorePackage.getEBoolean(), "printLabels", null, 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectorPanel_VariableResolver(), theVariablePackage.getDirectVariableResolver(), null, "variableResolver", null, 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectorPanel_InputProvider(), this.getIInputProvider(), null, "inputProvider", null, 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectorPanel_Vertical(), ecorePackage.getEBoolean(), "vertical", "true", 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectorPanel_AutoHideLabels(), ecorePackage.getEBoolean(), "autoHideLabels", "true", 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectorPanel_FadeOutMs(), ecorePackage.getEInt(), "fadeOutMs", "500", 1, 1, SelectorPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iInputProviderEClass, IInputProvider.class, "IInputProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(panelViewerEClass, PanelViewer.class, "PanelViewer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPanelViewer_VariableResolver(), theVariablePackage.getDirectVariableResolver(), null, "variableResolver", null, 1, 1, PanelViewer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuklearVertexProviderEClass, NuklearVertexProvider.class, "NuklearVertexProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNuklearVertexProvider_Context(), this.getNuklearContext(), null, "context", null, 1, 1, NuklearVertexProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuklearIndexProviderEClass, NuklearIndexProvider.class, "NuklearIndexProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNuklearIndexProvider_Context(), this.getNuklearContext(), null, "context", null, 1, 1, NuklearIndexProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //NuklearPackageImpl
