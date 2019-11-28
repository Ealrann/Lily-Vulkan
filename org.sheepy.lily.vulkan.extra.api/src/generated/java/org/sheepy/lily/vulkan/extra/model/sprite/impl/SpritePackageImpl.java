/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.cadence.CadencePackage;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.core.model.presentation.PresentationPackage;
import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;

import org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl;

import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;

import org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl;

import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl;

import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteFactory;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteType;
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
public class SpritePackageImpl extends EPackageImpl implements SpritePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spriteRendererEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spriteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spriteMonoSamplerProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spriteStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spriteCountSpecializationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum spriteTypeEEnum = null;

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
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		PresentationPackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
		ProcessPackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		GraphicPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();

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
	public EClass getSpriteRenderer()
	{
		return spriteRendererEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSprite()
	{
		return spriteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSprite_File()
	{
		return (EReference)spriteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSprite_Type()
	{
		return (EAttribute)spriteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpriteMonoSamplerProvider()
	{
		return spriteMonoSamplerProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteMonoSamplerProvider_SamplerInfo()
	{
		return (EReference)spriteMonoSamplerProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpriteStructure()
	{
		return spriteStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpriteStructure_Width()
	{
		return (EAttribute)spriteStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpriteStructure_Height()
	{
		return (EAttribute)spriteStructureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteStructure_Sprites()
	{
		return (EReference)spriteStructureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpriteCountSpecialization()
	{
		return spriteCountSpecializationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpriteCountSpecialization_Provider()
	{
		return (EReference)spriteCountSpecializationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSpriteType()
	{
		return spriteTypeEEnum;
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
		spriteRendererEClass = createEClass(SPRITE_RENDERER);

		spriteEClass = createEClass(SPRITE);
		createEReference(spriteEClass, SPRITE__FILE);
		createEAttribute(spriteEClass, SPRITE__TYPE);

		spriteMonoSamplerProviderEClass = createEClass(SPRITE_MONO_SAMPLER_PROVIDER);
		createEReference(spriteMonoSamplerProviderEClass, SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO);

		spriteStructureEClass = createEClass(SPRITE_STRUCTURE);
		createEAttribute(spriteStructureEClass, SPRITE_STRUCTURE__WIDTH);
		createEAttribute(spriteStructureEClass, SPRITE_STRUCTURE__HEIGHT);
		createEReference(spriteStructureEClass, SPRITE_STRUCTURE__SPRITES);

		spriteCountSpecializationEClass = createEClass(SPRITE_COUNT_SPECIALIZATION);
		createEReference(spriteCountSpecializationEClass, SPRITE_COUNT_SPECIALIZATION__PROVIDER);

		// Create enums
		spriteTypeEEnum = createEEnum(SPRITE_TYPE);
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
		RenderingPackage theRenderingPackage = (RenderingPackage)EPackage.Registry.INSTANCE.getEPackage(RenderingPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		ImagePackage theImagePackage = (ImagePackage)EPackage.Registry.INSTANCE.getEPackage(ImagePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theRenderingPackage.getGenericRenderer());
		EGenericType g2 = createEGenericType(this.getSpriteStructure());
		g1.getETypeArguments().add(g2);
		spriteRendererEClass.getEGenericSuperTypes().add(g1);
		spriteEClass.getESuperTypes().add(theRenderingPackage.getPresentation());
		spriteMonoSamplerProviderEClass.getESuperTypes().add(theRenderingPackage.getResourceDescriptorProvider());
		spriteStructureEClass.getESuperTypes().add(theRenderingPackage.getStructure());
		spriteCountSpecializationEClass.getESuperTypes().add(theRenderingPackage.getISpecialization());

		// Initialize classes, features, and operations; add parameters
		initEClass(spriteRendererEClass, SpriteRenderer.class, "SpriteRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(spriteEClass, Sprite.class, "Sprite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSprite_File(), theResourcePackage.getPathResource(), null, "file", null, 1, 1, Sprite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSprite_Type(), this.getSpriteType(), "type", "Floor", 1, 1, Sprite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spriteMonoSamplerProviderEClass, SpriteMonoSamplerProvider.class, "SpriteMonoSamplerProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpriteMonoSamplerProvider_SamplerInfo(), theImagePackage.getSamplerInfo(), null, "samplerInfo", null, 1, 1, SpriteMonoSamplerProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spriteStructureEClass, SpriteStructure.class, "SpriteStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpriteStructure_Width(), ecorePackage.getEInt(), "width", null, 1, 1, SpriteStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpriteStructure_Height(), ecorePackage.getEInt(), "height", null, 1, 1, SpriteStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpriteStructure_Sprites(), this.getSprite(), null, "sprites", null, 1, -1, SpriteStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spriteCountSpecializationEClass, SpriteCountSpecialization.class, "SpriteCountSpecialization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpriteCountSpecialization_Provider(), this.getSpriteMonoSamplerProvider(), null, "provider", null, 1, 1, SpriteCountSpecialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(spriteTypeEEnum, SpriteType.class, "SpriteType");
		addEEnumLiteral(spriteTypeEEnum, SpriteType.FLOOR);
		addEEnumLiteral(spriteTypeEEnum, SpriteType.WALL);

		// Create resource
		createResource(eNS_URI);
	}

} //SpritePackageImpl
