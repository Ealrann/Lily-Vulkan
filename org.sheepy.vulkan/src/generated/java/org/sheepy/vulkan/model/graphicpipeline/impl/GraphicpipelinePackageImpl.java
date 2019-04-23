/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelineFactory;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;
import org.sheepy.vulkan.model.graphicpipeline.StaticViewportState;
import org.sheepy.vulkan.model.graphicpipeline.Vec2I;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicpipelinePackageImpl extends EPackageImpl implements GraphicpipelinePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorBlendEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorBlendAttachmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputAssemblyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rasterizerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewportStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticViewportStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicViewportStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vec2IEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scissorEClass = null;

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
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphicpipelinePackageImpl()
	{
		super(eNS_URI, GraphicpipelineFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraphicpipelinePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphicpipelinePackage init()
	{
		if (isInited) return (GraphicpipelinePackage) EPackage.Registry.INSTANCE
				.getEPackage(GraphicpipelinePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGraphicpipelinePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GraphicpipelinePackageImpl theGraphicpipelinePackage = registeredGraphicpipelinePackage instanceof GraphicpipelinePackageImpl
				? (GraphicpipelinePackageImpl) registeredGraphicpipelinePackage
				: new GraphicpipelinePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraphicpipelinePackage.createPackageContents();

		// Initialize created meta-data
		theGraphicpipelinePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphicpipelinePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphicpipelinePackage.eNS_URI, theGraphicpipelinePackage);
		return theGraphicpipelinePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getColorBlend()
	{
		return colorBlendEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getColorBlend_Attachments()
	{
		return (EReference) colorBlendEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlend_LogicOpEnable()
	{
		return (EAttribute) colorBlendEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlend_LogicOp()
	{
		return (EAttribute) colorBlendEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlend_BlendConstant0()
	{
		return (EAttribute) colorBlendEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlend_BlendConstant1()
	{
		return (EAttribute) colorBlendEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlend_BlendConstant2()
	{
		return (EAttribute) colorBlendEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlend_BlendConstant3()
	{
		return (EAttribute) colorBlendEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getColorBlendAttachment()
	{
		return colorBlendAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_BlendEnable()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_SrcColor()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_DstColor()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_SrcAlpha()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_DstAlpha()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_ColorBlendOp()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_AlphaBlendOp()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_RedComponentEnable()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_GreenComponentEnable()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_BlueComponentEnable()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getColorBlendAttachment_AlphaComponentEnable()
	{
		return (EAttribute) colorBlendAttachmentEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInputAssembly()
	{
		return inputAssemblyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInputAssembly_PrimitiveRestartEnabled()
	{
		return (EAttribute) inputAssemblyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInputAssembly_PrimitiveTopology()
	{
		return (EAttribute) inputAssemblyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRasterizer()
	{
		return rasterizerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRasterizer_CullMode()
	{
		return (EAttribute) rasterizerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRasterizer_FrontFace()
	{
		return (EAttribute) rasterizerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRasterizer_PolygonMode()
	{
		return (EAttribute) rasterizerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRasterizer_LineWidth()
	{
		return (EAttribute) rasterizerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRasterizer_DepthClampEnable()
	{
		return (EAttribute) rasterizerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRasterizer_DiscardEnable()
	{
		return (EAttribute) rasterizerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRasterizer_DepthBiasEnable()
	{
		return (EAttribute) rasterizerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDynamicState()
	{
		return dynamicStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDynamicState_States()
	{
		return (EAttribute) dynamicStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getViewportState()
	{
		return viewportStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStaticViewportState()
	{
		return staticViewportStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStaticViewportState_Viewports()
	{
		return (EReference) staticViewportStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStaticViewportState_Scissors()
	{
		return (EReference) staticViewportStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDynamicViewportState()
	{
		return dynamicViewportStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDynamicViewportState_ViewportCount()
	{
		return (EAttribute) dynamicViewportStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDynamicViewportState_ScissorCount()
	{
		return (EAttribute) dynamicViewportStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVec2I()
	{
		return vec2IEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVec2I_X()
	{
		return (EAttribute) vec2IEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVec2I_Y()
	{
		return (EAttribute) vec2IEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getViewport()
	{
		return viewportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getViewport_OffsetX()
	{
		return (EAttribute) viewportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getViewport_OffsetY()
	{
		return (EAttribute) viewportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getViewport_Extent()
	{
		return (EReference) viewportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getViewport_MinDepth()
	{
		return (EAttribute) viewportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getViewport_MaxDepth()
	{
		return (EAttribute) viewportEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScissor()
	{
		return scissorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScissor_OffsetX()
	{
		return (EAttribute) scissorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScissor_OffsetY()
	{
		return (EAttribute) scissorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getScissor_Extent()
	{
		return (EReference) scissorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicpipelineFactory getGraphicpipelineFactory()
	{
		return (GraphicpipelineFactory) getEFactoryInstance();
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
		colorBlendEClass = createEClass(COLOR_BLEND);
		createEReference(colorBlendEClass, COLOR_BLEND__ATTACHMENTS);
		createEAttribute(colorBlendEClass, COLOR_BLEND__LOGIC_OP_ENABLE);
		createEAttribute(colorBlendEClass, COLOR_BLEND__LOGIC_OP);
		createEAttribute(colorBlendEClass, COLOR_BLEND__BLEND_CONSTANT0);
		createEAttribute(colorBlendEClass, COLOR_BLEND__BLEND_CONSTANT1);
		createEAttribute(colorBlendEClass, COLOR_BLEND__BLEND_CONSTANT2);
		createEAttribute(colorBlendEClass, COLOR_BLEND__BLEND_CONSTANT3);

		colorBlendAttachmentEClass = createEClass(COLOR_BLEND_ATTACHMENT);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__BLEND_ENABLE);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__SRC_COLOR);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__DST_COLOR);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__SRC_ALPHA);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__DST_ALPHA);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE);
		createEAttribute(colorBlendAttachmentEClass,
				COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE);
		createEAttribute(colorBlendAttachmentEClass, COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE);
		createEAttribute(colorBlendAttachmentEClass,
				COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE);

		inputAssemblyEClass = createEClass(INPUT_ASSEMBLY);
		createEAttribute(inputAssemblyEClass, INPUT_ASSEMBLY__PRIMITIVE_RESTART_ENABLED);
		createEAttribute(inputAssemblyEClass, INPUT_ASSEMBLY__PRIMITIVE_TOPOLOGY);

		rasterizerEClass = createEClass(RASTERIZER);
		createEAttribute(rasterizerEClass, RASTERIZER__CULL_MODE);
		createEAttribute(rasterizerEClass, RASTERIZER__FRONT_FACE);
		createEAttribute(rasterizerEClass, RASTERIZER__POLYGON_MODE);
		createEAttribute(rasterizerEClass, RASTERIZER__LINE_WIDTH);
		createEAttribute(rasterizerEClass, RASTERIZER__DEPTH_CLAMP_ENABLE);
		createEAttribute(rasterizerEClass, RASTERIZER__DISCARD_ENABLE);
		createEAttribute(rasterizerEClass, RASTERIZER__DEPTH_BIAS_ENABLE);

		dynamicStateEClass = createEClass(DYNAMIC_STATE);
		createEAttribute(dynamicStateEClass, DYNAMIC_STATE__STATES);

		viewportStateEClass = createEClass(VIEWPORT_STATE);

		staticViewportStateEClass = createEClass(STATIC_VIEWPORT_STATE);
		createEReference(staticViewportStateEClass, STATIC_VIEWPORT_STATE__VIEWPORTS);
		createEReference(staticViewportStateEClass, STATIC_VIEWPORT_STATE__SCISSORS);

		dynamicViewportStateEClass = createEClass(DYNAMIC_VIEWPORT_STATE);
		createEAttribute(dynamicViewportStateEClass, DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT);
		createEAttribute(dynamicViewportStateEClass, DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT);

		vec2IEClass = createEClass(VEC2_I);
		createEAttribute(vec2IEClass, VEC2_I__X);
		createEAttribute(vec2IEClass, VEC2_I__Y);

		viewportEClass = createEClass(VIEWPORT);
		createEAttribute(viewportEClass, VIEWPORT__OFFSET_X);
		createEAttribute(viewportEClass, VIEWPORT__OFFSET_Y);
		createEReference(viewportEClass, VIEWPORT__EXTENT);
		createEAttribute(viewportEClass, VIEWPORT__MIN_DEPTH);
		createEAttribute(viewportEClass, VIEWPORT__MAX_DEPTH);

		scissorEClass = createEClass(SCISSOR);
		createEAttribute(scissorEClass, SCISSOR__OFFSET_X);
		createEAttribute(scissorEClass, SCISSOR__OFFSET_Y);
		createEReference(scissorEClass, SCISSOR__EXTENT);
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
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage) EPackage.Registry.INSTANCE
				.getEPackage(EnumerationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		staticViewportStateEClass.getESuperTypes().add(this.getViewportState());
		dynamicViewportStateEClass.getESuperTypes().add(this.getViewportState());

		// Initialize classes, features, and operations; add parameters
		initEClass(colorBlendEClass, ColorBlend.class, "ColorBlend", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getColorBlend_Attachments(), this.getColorBlendAttachment(), null,
				"attachments", null, 0, -1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_LogicOpEnable(), theEcorePackage.getEBoolean(),
				"logicOpEnable", "false", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_LogicOp(), theEnumerationPackage.getELogicOp(), "logicOp",
				"COPY", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_BlendConstant0(), theEcorePackage.getEInt(), "blendConstant0",
				"0", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_BlendConstant1(), theEcorePackage.getEInt(), "blendConstant1",
				"0", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_BlendConstant2(), theEcorePackage.getEInt(), "blendConstant2",
				"0", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlend_BlendConstant3(), theEcorePackage.getEInt(), "blendConstant3",
				"1", 0, 1, ColorBlend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorBlendAttachmentEClass, ColorBlendAttachment.class, "ColorBlendAttachment",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorBlendAttachment_BlendEnable(), theEcorePackage.getEBoolean(),
				"blendEnable", "false", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getColorBlendAttachment_SrcColor(), theEnumerationPackage.getEBlendFactor(),
				"srcColor", "ONE", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_DstColor(), theEnumerationPackage.getEBlendFactor(),
				"dstColor", "ZERO", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_SrcAlpha(), theEnumerationPackage.getEBlendFactor(),
				"srcAlpha", "ONE", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_DstAlpha(), theEnumerationPackage.getEBlendFactor(),
				"dstAlpha", "ZERO", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_ColorBlendOp(), theEnumerationPackage.getEBlendOp(),
				"colorBlendOp", "ADD", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getColorBlendAttachment_AlphaBlendOp(), theEnumerationPackage.getEBlendOp(),
				"alphaBlendOp", "ADD", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getColorBlendAttachment_RedComponentEnable(), theEcorePackage.getEBoolean(),
				"redComponentEnable", "true", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getColorBlendAttachment_GreenComponentEnable(),
				theEcorePackage.getEBoolean(), "greenComponentEnable", "true", 0, 1,
				ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorBlendAttachment_BlueComponentEnable(), theEcorePackage.getEBoolean(),
				"blueComponentEnable", "true", 0, 1, ColorBlendAttachment.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getColorBlendAttachment_AlphaComponentEnable(),
				theEcorePackage.getEBoolean(), "alphaComponentEnable", "true", 0, 1,
				ColorBlendAttachment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputAssemblyEClass, InputAssembly.class, "InputAssembly", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputAssembly_PrimitiveRestartEnabled(), theEcorePackage.getEBoolean(),
				"primitiveRestartEnabled", "false", 0, 1, InputAssembly.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getInputAssembly_PrimitiveTopology(),
				theEnumerationPackage.getEPrimitiveTopology(), "primitiveTopology", "TRIANGLE_LIST",
				0, 1, InputAssembly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rasterizerEClass, Rasterizer.class, "Rasterizer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRasterizer_CullMode(), theEnumerationPackage.getECullMode(), "cullMode",
				"BACK_BIT", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_FrontFace(), theEnumerationPackage.getEFrontFace(),
				"frontFace", "CLOCKWISE", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_PolygonMode(), theEnumerationPackage.getEPolygonMode(),
				"polygonMode", "FILL", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_LineWidth(), theEcorePackage.getEInt(), "lineWidth", "1", 0, 1,
				Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_DepthClampEnable(), theEcorePackage.getEBoolean(),
				"depthClampEnable", "false", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_DiscardEnable(), theEcorePackage.getEBoolean(),
				"discardEnable", "false", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRasterizer_DepthBiasEnable(), theEcorePackage.getEBoolean(),
				"depthBiasEnable", "false", 0, 1, Rasterizer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicStateEClass, DynamicState.class, "DynamicState", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicState_States(), theEnumerationPackage.getEDynamicState(), "states",
				null, 0, -1, DynamicState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewportStateEClass, ViewportState.class, "ViewportState", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(staticViewportStateEClass, StaticViewportState.class, "StaticViewportState",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStaticViewportState_Viewports(), this.getViewport(), null, "viewports",
				null, 0, -1, StaticViewportState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getStaticViewportState_Scissors(), this.getScissor(), null, "scissors", null,
				0, -1, StaticViewportState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(dynamicViewportStateEClass, DynamicViewportState.class, "DynamicViewportState",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDynamicViewportState_ViewportCount(), theEcorePackage.getEInt(),
				"viewportCount", null, 0, 1, DynamicViewportState.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getDynamicViewportState_ScissorCount(), theEcorePackage.getEInt(),
				"scissorCount", null, 0, 1, DynamicViewportState.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vec2IEClass, Vec2I.class, "Vec2I", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVec2I_X(), theEcorePackage.getEInt(), "x", "0", 0, 1, Vec2I.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getVec2I_Y(), theEcorePackage.getEInt(), "y", "0", 0, 1, Vec2I.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(viewportEClass, Viewport.class, "Viewport", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewport_OffsetX(), theEcorePackage.getEInt(), "offsetX", "0", 0, 1,
				Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewport_OffsetY(), theEcorePackage.getEInt(), "offsetY", "0", 0, 1,
				Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewport_Extent(), this.getVec2I(), null, "extent", null, 0, 1,
				Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewport_MinDepth(), theEcorePackage.getEInt(), "minDepth", "0", 0, 1,
				Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewport_MaxDepth(), theEcorePackage.getEInt(), "maxDepth", "1", 0, 1,
				Viewport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scissorEClass, Scissor.class, "Scissor", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScissor_OffsetX(), theEcorePackage.getEInt(), "offsetX", "0", 0, 1,
				Scissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScissor_OffsetY(), theEcorePackage.getEInt(), "offsetY", "0", 0, 1,
				Scissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				!IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScissor_Extent(), this.getVec2I(), null, "extent", null, 0, 1,
				Scissor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphicpipelinePackageImpl
