/**
 */
package org.sheepy.lily.vulkan.extra.nuklear.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.builder.BuilderPackage;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearFactory;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearLayoutTask;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipelineBuilder;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
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
	private EClass nuklearPipelineBuilderEClass = null;

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
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#eNS_URI
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
		BuilderPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		GraphicPackage.eINSTANCE.eClass();
		ProcessPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theNuklearPackage.createPackageContents();

		// Initialize created meta-data
		theNuklearPackage.initializePackageContents();

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
	public EClass getNuklearPipelineBuilder()
	{
		return nuklearPipelineBuilderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearPipelineBuilder_Font()
	{
		return (EReference)nuklearPipelineBuilderEClass.getEStructuralFeatures().get(0);
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
	public EReference getNuklearLayoutTask_PushBuffer()
	{
		return (EReference)nuklearLayoutTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNuklearLayoutTask_VertexBuffer()
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
		nuklearPipelineBuilderEClass = createEClass(NUKLEAR_PIPELINE_BUILDER);
		createEReference(nuklearPipelineBuilderEClass, NUKLEAR_PIPELINE_BUILDER__FONT);

		nuklearPushConstantsEClass = createEClass(NUKLEAR_PUSH_CONSTANTS);
		createEAttribute(nuklearPushConstantsEClass, NUKLEAR_PUSH_CONSTANTS__WIDTH);
		createEAttribute(nuklearPushConstantsEClass, NUKLEAR_PUSH_CONSTANTS__HEIGHT);
		createEAttribute(nuklearPushConstantsEClass, NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR);

		nuklearLayoutTaskEClass = createEClass(NUKLEAR_LAYOUT_TASK);
		createEReference(nuklearLayoutTaskEClass, NUKLEAR_LAYOUT_TASK__CONTEXT);
		createEReference(nuklearLayoutTaskEClass, NUKLEAR_LAYOUT_TASK__DRAW_TASK);
		createEReference(nuklearLayoutTaskEClass, NUKLEAR_LAYOUT_TASK__PUSH_BUFFER);
		createEReference(nuklearLayoutTaskEClass, NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER);

		nuklearContextEClass = createEClass(NUKLEAR_CONTEXT);
		createEReference(nuklearContextEClass, NUKLEAR_CONTEXT__FONT);
		createEReference(nuklearContextEClass, NUKLEAR_CONTEXT__NULL_TEXTURE);
		createEReference(nuklearContextEClass, NUKLEAR_CONTEXT__LAYOUT_TASK);
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
		BuilderPackage theBuilderPackage = (BuilderPackage)EPackage.Registry.INSTANCE.getEPackage(BuilderPackage.eNS_URI);
		GraphicPackage theGraphicPackage = (GraphicPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theBuilderPackage.getBuilder());
		EGenericType g2 = createEGenericType(theGraphicPackage.getGraphicsPipeline());
		g1.getETypeArguments().add(g2);
		nuklearPipelineBuilderEClass.getEGenericSuperTypes().add(g1);
		nuklearPushConstantsEClass.getESuperTypes().add(theProcessPackage.getPushConstant());
		nuklearLayoutTaskEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		nuklearContextEClass.getESuperTypes().add(theVulkanPackage.getIResource());
		nuklearContextEClass.getESuperTypes().add(theResourcePackage.getBasicResource());

		// Initialize classes, features, and operations; add parameters
		initEClass(nuklearPipelineBuilderEClass, NuklearPipelineBuilder.class, "NuklearPipelineBuilder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNuklearPipelineBuilder_Font(), theResourcePackage.getFont(), null, "font", null, 1, 1, NuklearPipelineBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuklearPushConstantsEClass, NuklearPushConstants.class, "NuklearPushConstants", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNuklearPushConstants_Width(), theEcorePackage.getEInt(), "width", null, 0, 1, NuklearPushConstants.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuklearPushConstants_Height(), theEcorePackage.getEInt(), "height", null, 0, 1, NuklearPushConstants.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNuklearPushConstants_CurrentDescriptor(), theEcorePackage.getEInt(), "currentDescriptor", null, 0, 1, NuklearPushConstants.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuklearLayoutTaskEClass, NuklearLayoutTask.class, "NuklearLayoutTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNuklearLayoutTask_Context(), this.getNuklearContext(), this.getNuklearContext_LayoutTask(), "context", null, 1, 1, NuklearLayoutTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearLayoutTask_DrawTask(), theProcessPackage.getCompositeTask(), null, "drawTask", null, 0, 1, NuklearLayoutTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearLayoutTask_PushBuffer(), theResourcePackage.getPushBuffer(), null, "pushBuffer", null, 0, 1, NuklearLayoutTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearLayoutTask_VertexBuffer(), theResourcePackage.getBuffer(), null, "vertexBuffer", null, 0, 1, NuklearLayoutTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nuklearContextEClass, NuklearContext.class, "NuklearContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNuklearContext_Font(), theResourcePackage.getFont(), null, "font", null, 1, 1, NuklearContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearContext_NullTexture(), theResourcePackage.getSampledImage(), null, "nullTexture", null, 0, 1, NuklearContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNuklearContext_LayoutTask(), this.getNuklearLayoutTask(), this.getNuklearLayoutTask_Context(), "layoutTask", null, 1, 1, NuklearContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //NuklearPackageImpl
