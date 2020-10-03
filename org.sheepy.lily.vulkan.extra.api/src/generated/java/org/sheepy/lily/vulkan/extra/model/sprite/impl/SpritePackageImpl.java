/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;

import org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl;

import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;

import org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl;

import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl;

import org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteFactory;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.model.VulkanPackage;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
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
public class SpritePackageImpl extends EPackageImpl implements SpritePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spriteExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSpriteDataSourceEClass = null;

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
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpritePackageImpl()
	{
		super(eNS_URI, SpriteFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SpritePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SpritePackage init()
	{
		if (isInited) return (SpritePackage)EPackage.Registry.INSTANCE.getEPackage(SpritePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSpritePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SpritePackageImpl theSpritePackage = registeredSpritePackage instanceof SpritePackageImpl ? (SpritePackageImpl)registeredSpritePackage : new SpritePackageImpl();

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
		VulkanPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		VulkanResourcePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MeshPackage.eNS_URI);
		MeshPackageImpl theMeshPackage = (MeshPackageImpl)(registeredPackage instanceof MeshPackageImpl ? registeredPackage : MeshPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NuklearPackage.eNS_URI);
		NuklearPackageImpl theNuklearPackage = (NuklearPackageImpl)(registeredPackage instanceof NuklearPackageImpl ? registeredPackage : NuklearPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RenderingPackage.eNS_URI);
		RenderingPackageImpl theRenderingPackage = (RenderingPackageImpl)(registeredPackage instanceof RenderingPackageImpl ? registeredPackage : RenderingPackage.eINSTANCE);

		// Create package meta-data objects
		theSpritePackage.createPackageContents();
		theMeshPackage.createPackageContents();
		theNuklearPackage.createPackageContents();
		theRenderingPackage.createPackageContents();

		// Initialize created meta-data
		theSpritePackage.initializePackageContents();
		theMeshPackage.initializePackageContents();
		theNuklearPackage.initializePackageContents();
		theRenderingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpritePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SpritePackage.eNS_URI, theSpritePackage);
		return theSpritePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpriteExtension()
	{
		return spriteExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteExtension_DrawTask()
	{
		return (EReference)spriteExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteExtension_IndexBufferViewer()
	{
		return (EReference)spriteExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteExtension_VertexBufferViewer()
	{
		return (EReference)spriteExtensionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteExtension_SpritesDescriptor()
	{
		return (EReference)spriteExtensionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteExtension_SpriteDataSource()
	{
		return (EReference)spriteExtensionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteExtension_SpritePipelineSpecialization()
	{
		return (EReference)spriteExtensionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteExtension_SpriteImageMemory()
	{
		return (EReference)spriteExtensionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getISpriteDataSource()
	{
		return iSpriteDataSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpriteFactory getSpriteFactory()
	{
		return (SpriteFactory)getEFactoryInstance();
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
		spriteExtensionEClass = createEClass(SPRITE_EXTENSION);
		createEReference(spriteExtensionEClass, SPRITE_EXTENSION__DRAW_TASK);
		createEReference(spriteExtensionEClass, SPRITE_EXTENSION__INDEX_BUFFER_VIEWER);
		createEReference(spriteExtensionEClass, SPRITE_EXTENSION__VERTEX_BUFFER_VIEWER);
		createEReference(spriteExtensionEClass, SPRITE_EXTENSION__SPRITES_DESCRIPTOR);
		createEReference(spriteExtensionEClass, SPRITE_EXTENSION__SPRITE_DATA_SOURCE);
		createEReference(spriteExtensionEClass, SPRITE_EXTENSION__SPRITE_PIPELINE_SPECIALIZATION);
		createEReference(spriteExtensionEClass, SPRITE_EXTENSION__SPRITE_IMAGE_MEMORY);

		iSpriteDataSourceEClass = createEClass(ISPRITE_DATA_SOURCE);
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
		VulkanResourcePackage theVulkanResourcePackage = (VulkanResourcePackage)EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);
		GraphicPackage theGraphicPackage = (GraphicPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		spriteExtensionEClass.getESuperTypes().add(theProcessPackage.getIPipelineExtension());
		spriteExtensionEClass.getESuperTypes().add(theVulkanResourcePackage.getIBufferDataSource());
		iSpriteDataSourceEClass.getESuperTypes().add(theVulkanResourcePackage.getIBufferDataSource());

		// Initialize classes, features, and operations; add parameters
		initEClass(spriteExtensionEClass, SpriteExtension.class, "SpriteExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpriteExtension_DrawTask(), theGraphicPackage.getDrawIndexed(), null, "drawTask", null, 1, 1, SpriteExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpriteExtension_IndexBufferViewer(), theVulkanResourcePackage.getBufferViewer(), null, "indexBufferViewer", null, 1, 1, SpriteExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpriteExtension_VertexBufferViewer(), theVulkanResourcePackage.getBufferViewer(), null, "vertexBufferViewer", null, 1, 1, SpriteExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpriteExtension_SpritesDescriptor(), theVulkanResourcePackage.getImageDescriptor(), null, "spritesDescriptor", null, 1, 1, SpriteExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpriteExtension_SpriteDataSource(), this.getISpriteDataSource(), null, "spriteDataSource", null, 1, 1, SpriteExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpriteExtension_SpritePipelineSpecialization(), theVulkanResourcePackage.getConstantBuffer(), null, "spritePipelineSpecialization", null, 0, 1, SpriteExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpriteExtension_SpriteImageMemory(), theVulkanResourcePackage.getMemoryChunk(), null, "spriteImageMemory", null, 1, 1, SpriteExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iSpriteDataSourceEClass, ISpriteDataSource.class, "ISpriteDataSource", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SpritePackageImpl
