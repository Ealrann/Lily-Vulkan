/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;

import org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshPackageImpl;

import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;

import org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl;

import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.Entity;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericDataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl;
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
public class RenderingPackageImpl extends EPackageImpl implements RenderingPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentationPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass presentableEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericRendererMaintainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericDataProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderableDataSourceEClass = null;

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
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RenderingPackageImpl()
	{
		super(eNS_URI, RenderingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RenderingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RenderingPackage init()
	{
		if (isInited) return (RenderingPackage)EPackage.Registry.INSTANCE.getEPackage(RenderingPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRenderingPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RenderingPackageImpl theRenderingPackage = registeredRenderingPackage instanceof RenderingPackageImpl ? (RenderingPackageImpl)registeredRenderingPackage : new RenderingPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		ProcessPackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		GraphicPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MeshPackage.eNS_URI);
		MeshPackageImpl theMeshPackage = (MeshPackageImpl)(registeredPackage instanceof MeshPackageImpl ? registeredPackage : MeshPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NuklearPackage.eNS_URI);
		NuklearPackageImpl theNuklearPackage = (NuklearPackageImpl)(registeredPackage instanceof NuklearPackageImpl ? registeredPackage : NuklearPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SpritePackage.eNS_URI);
		SpritePackageImpl theSpritePackage = (SpritePackageImpl)(registeredPackage instanceof SpritePackageImpl ? registeredPackage : SpritePackage.eINSTANCE);

		// Create package meta-data objects
		theRenderingPackage.createPackageContents();
		theMeshPackage.createPackageContents();
		theNuklearPackage.createPackageContents();
		theSpritePackage.createPackageContents();

		// Initialize created meta-data
		theRenderingPackage.initializePackageContents();
		theMeshPackage.initializePackageContents();
		theNuklearPackage.initializePackageContents();
		theSpritePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRenderingPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RenderingPackage.eNS_URI, theRenderingPackage);
		return theRenderingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntity()
	{
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPhysicalEntity()
	{
		return physicalEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPhysicalEntity_GeoLocation()
	{
		return (EAttribute)physicalEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPhysicalEntity_GeoOrientation()
	{
		return (EAttribute)physicalEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPhysicalEntity_AxisLocation()
	{
		return (EAttribute)physicalEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPhysicalEntity_Axis()
	{
		return (EReference)physicalEntityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAxis()
	{
		return axisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAxis_FrontDirection()
	{
		return (EAttribute)axisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAxis_UpDirection()
	{
		return (EAttribute)axisEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAxis_RightDirection()
	{
		return (EAttribute)axisEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPresentation()
	{
		return presentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPresentation_PresentedEntities()
	{
		return (EReference)presentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPresentationPkg()
	{
		return presentationPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPresentationPkg_Presentations()
	{
		return (EReference)presentationPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPresentableEntity()
	{
		return presentableEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPresentableEntity_Presentation()
	{
		return (EReference)presentableEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPresentableEntity_Scale()
	{
		return (EAttribute)presentableEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenericRendererMaintainer()
	{
		return genericRendererMaintainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRendererMaintainer_DataProviders()
	{
		return (EReference)genericRendererMaintainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRendererMaintainer_PresentationPkg()
	{
		return (EReference)genericRendererMaintainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRendererMaintainer_ConstantBuffer()
	{
		return (EReference)genericRendererMaintainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRendererMaintainer_BasicResources()
	{
		return (EReference)genericRendererMaintainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRendererMaintainer_PushBuffer()
	{
		return (EReference)genericRendererMaintainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenericDataProvider()
	{
		return genericDataProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRenderableDataSource()
	{
		return renderableDataSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderableDataSource_Presentation()
	{
		return (EReference)renderableDataSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRenderableDataSource_Part()
	{
		return (EAttribute)renderableDataSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderingFactory getRenderingFactory()
	{
		return (RenderingFactory)getEFactoryInstance();
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
		entityEClass = createEClass(ENTITY);

		physicalEntityEClass = createEClass(PHYSICAL_ENTITY);
		createEAttribute(physicalEntityEClass, PHYSICAL_ENTITY__GEO_LOCATION);
		createEAttribute(physicalEntityEClass, PHYSICAL_ENTITY__GEO_ORIENTATION);
		createEAttribute(physicalEntityEClass, PHYSICAL_ENTITY__AXIS_LOCATION);
		createEReference(physicalEntityEClass, PHYSICAL_ENTITY__AXIS);

		axisEClass = createEClass(AXIS);
		createEAttribute(axisEClass, AXIS__FRONT_DIRECTION);
		createEAttribute(axisEClass, AXIS__UP_DIRECTION);
		createEAttribute(axisEClass, AXIS__RIGHT_DIRECTION);

		presentationEClass = createEClass(PRESENTATION);
		createEReference(presentationEClass, PRESENTATION__PRESENTED_ENTITIES);

		presentationPkgEClass = createEClass(PRESENTATION_PKG);
		createEReference(presentationPkgEClass, PRESENTATION_PKG__PRESENTATIONS);

		presentableEntityEClass = createEClass(PRESENTABLE_ENTITY);
		createEReference(presentableEntityEClass, PRESENTABLE_ENTITY__PRESENTATION);
		createEAttribute(presentableEntityEClass, PRESENTABLE_ENTITY__SCALE);

		genericRendererMaintainerEClass = createEClass(GENERIC_RENDERER_MAINTAINER);
		createEReference(genericRendererMaintainerEClass, GENERIC_RENDERER_MAINTAINER__DATA_PROVIDERS);
		createEReference(genericRendererMaintainerEClass, GENERIC_RENDERER_MAINTAINER__PRESENTATION_PKG);
		createEReference(genericRendererMaintainerEClass, GENERIC_RENDERER_MAINTAINER__CONSTANT_BUFFER);
		createEReference(genericRendererMaintainerEClass, GENERIC_RENDERER_MAINTAINER__BASIC_RESOURCES);
		createEReference(genericRendererMaintainerEClass, GENERIC_RENDERER_MAINTAINER__PUSH_BUFFER);

		genericDataProviderEClass = createEClass(GENERIC_DATA_PROVIDER);

		renderableDataSourceEClass = createEClass(RENDERABLE_DATA_SOURCE);
		createEReference(renderableDataSourceEClass, RENDERABLE_DATA_SOURCE__PRESENTATION);
		createEAttribute(renderableDataSourceEClass, RENDERABLE_DATA_SOURCE__PART);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		GraphicPackage theGraphicPackage = (GraphicPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		MaintainerPackage theMaintainerPackage = (MaintainerPackage)EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);

		// Create type parameters
		ETypeParameter genericRendererMaintainerEClass_T = addETypeParameter(genericRendererMaintainerEClass, "T");
		ETypeParameter genericDataProviderEClass_T = addETypeParameter(genericDataProviderEClass, "T");
		ETypeParameter renderableDataSourceEClass_T = addETypeParameter(renderableDataSourceEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getPresentation());
		genericRendererMaintainerEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getPresentation());
		genericDataProviderEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getPresentation());
		renderableDataSourceEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		entityEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		physicalEntityEClass.getESuperTypes().add(this.getEntity());
		presentableEntityEClass.getESuperTypes().add(this.getPhysicalEntity());
		g1 = createEGenericType(theGraphicPackage.getGraphicsPipeline());
		genericRendererMaintainerEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMaintainerPackage.getMaintainer());
		EGenericType g2 = createEGenericType(theGraphicPackage.getGraphicsPipeline());
		g1.getETypeArguments().add(g2);
		genericRendererMaintainerEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theResourcePackage.getBufferDataProvider());
		g2 = createEGenericType(this.getRenderableDataSource());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(genericDataProviderEClass_T);
		g2.getETypeArguments().add(g3);
		genericDataProviderEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(physicalEntityEClass, PhysicalEntity.class, "PhysicalEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhysicalEntity_GeoLocation(), theTypesPackage.getVector3d(), "geoLocation", "0;0;0", 0, 1, PhysicalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalEntity_GeoOrientation(), theTypesPackage.getVector2f(), "geoOrientation", "0;0;0", 0, 1, PhysicalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalEntity_AxisLocation(), theTypesPackage.getVector3d(), "axisLocation", "0;0;0", 0, 1, PhysicalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalEntity_Axis(), this.getAxis(), null, "axis", null, 0, 1, PhysicalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(axisEClass, Axis.class, "Axis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAxis_FrontDirection(), theTypesPackage.getVector3d(), "frontDirection", "0;0;0", 0, 1, Axis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxis_UpDirection(), theTypesPackage.getVector3d(), "upDirection", "0;0;0", 0, 1, Axis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxis_RightDirection(), theTypesPackage.getVector3d(), "rightDirection", "0;0;0", 0, 1, Axis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(presentationEClass, Presentation.class, "Presentation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentation_PresentedEntities(), this.getPresentableEntity(), this.getPresentableEntity_Presentation(), "presentedEntities", null, 0, -1, Presentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(presentationPkgEClass, PresentationPkg.class, "PresentationPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentationPkg_Presentations(), this.getPresentation(), null, "presentations", null, 0, -1, PresentationPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(presentableEntityEClass, PresentableEntity.class, "PresentableEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentableEntity_Presentation(), this.getPresentation(), this.getPresentation_PresentedEntities(), "presentation", null, 0, 1, PresentableEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentableEntity_Scale(), theEcorePackage.getEDouble(), "scale", "1", 0, 1, PresentableEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericRendererMaintainerEClass, GenericRendererMaintainer.class, "GenericRendererMaintainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getGenericDataProvider());
		g2 = createEGenericType(genericRendererMaintainerEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getGenericRendererMaintainer_DataProviders(), g1, null, "dataProviders", null, 1, -1, GenericRendererMaintainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRendererMaintainer_PresentationPkg(), this.getPresentationPkg(), null, "presentationPkg", null, 1, 1, GenericRendererMaintainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRendererMaintainer_ConstantBuffer(), theResourcePackage.getConstantBuffer(), null, "constantBuffer", null, 0, 1, GenericRendererMaintainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRendererMaintainer_BasicResources(), theResourcePackage.getDescriptedResource(), null, "basicResources", null, 0, -1, GenericRendererMaintainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRendererMaintainer_PushBuffer(), theResourcePackage.getPushBuffer(), null, "pushBuffer", null, 1, 1, GenericRendererMaintainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericDataProviderEClass, GenericDataProvider.class, "GenericDataProvider", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(renderableDataSourceEClass, RenderableDataSource.class, "RenderableDataSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(renderableDataSourceEClass_T);
		initEReference(getRenderableDataSource_Presentation(), g1, null, "presentation", null, 1, 1, RenderableDataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenderableDataSource_Part(), theEcorePackage.getEInt(), "part", null, 1, 1, RenderableDataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RenderingPackageImpl
