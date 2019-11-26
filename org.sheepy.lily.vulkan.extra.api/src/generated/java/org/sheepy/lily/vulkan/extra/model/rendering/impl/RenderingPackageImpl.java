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

import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.CompositeResourceProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.Entity;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderDrawTask;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderIndexedDrawTask;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider;
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
	private EClass structureEClass = null;

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
	private EClass genericRendererEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderDataProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataProviderPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderableDataSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vertexProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticResourceProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeResourceProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderProxyConstantBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSpecializationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderDrawTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderIndexedDrawTaskEClass = null;

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
		ImagePackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
		PresentationPackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();

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
	public EClass getStructure()
	{
		return structureEClass;
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
	public EReference getPresentationPkg_Structures()
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
	public EClass getGenericRenderer()
	{
		return genericRendererEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRenderer_DataProviderPkg()
	{
		return (EReference)genericRendererEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRenderer_RenderedStructures()
	{
		return (EReference)genericRendererEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRenderer_ConstantBuffer()
	{
		return (EReference)genericRendererEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRenderer_TransferBuffer()
	{
		return (EReference)genericRendererEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRenderer_CommonResourceProvider()
	{
		return (EReference)genericRendererEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRenderer_Specialization()
	{
		return (EReference)genericRendererEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGenericRenderer_FlushTransferBufferTask()
	{
		return (EReference)genericRendererEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRenderDataProvider()
	{
		return renderDataProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataProviderPkg()
	{
		return dataProviderPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataProviderPkg_DataProviders()
	{
		return (EReference)dataProviderPkgEClass.getEStructuralFeatures().get(0);
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
	public EReference getRenderableDataSource_Structure()
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
	public EClass getVertexProvider()
	{
		return vertexProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIndexProvider()
	{
		return indexProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIndexProvider_IndexType()
	{
		return (EAttribute)indexProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResourceProvider()
	{
		return resourceProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStaticResourceProvider()
	{
		return staticResourceProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStaticResourceProvider_Resources()
	{
		return (EReference)staticResourceProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeResourceProvider()
	{
		return compositeResourceProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeResourceProvider_Providers()
	{
		return (EReference)compositeResourceProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRenderProxyConstantBuffer()
	{
		return renderProxyConstantBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderProxyConstantBuffer_ConstantBuffer()
	{
		return (EReference)renderProxyConstantBufferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRenderProxyConstantBuffer_PartIndex()
	{
		return (EAttribute)renderProxyConstantBufferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getISpecialization()
	{
		return iSpecializationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntityPkg()
	{
		return entityPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEntityPkg_Entities()
	{
		return (EReference)entityPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRenderDrawTask()
	{
		return renderDrawTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderDrawTask_VertexProviders()
	{
		return (EReference)renderDrawTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRenderIndexedDrawTask()
	{
		return renderIndexedDrawTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderIndexedDrawTask_IndexProvider()
	{
		return (EReference)renderIndexedDrawTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRenderIndexedDrawTask_Structure()
	{
		return (EReference)renderIndexedDrawTaskEClass.getEStructuralFeatures().get(1);
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

		structureEClass = createEClass(STRUCTURE);

		presentationEClass = createEClass(PRESENTATION);
		createEReference(presentationEClass, PRESENTATION__PRESENTED_ENTITIES);

		presentationPkgEClass = createEClass(PRESENTATION_PKG);
		createEReference(presentationPkgEClass, PRESENTATION_PKG__STRUCTURES);

		presentableEntityEClass = createEClass(PRESENTABLE_ENTITY);
		createEReference(presentableEntityEClass, PRESENTABLE_ENTITY__PRESENTATION);
		createEAttribute(presentableEntityEClass, PRESENTABLE_ENTITY__SCALE);

		genericRendererEClass = createEClass(GENERIC_RENDERER);
		createEReference(genericRendererEClass, GENERIC_RENDERER__DATA_PROVIDER_PKG);
		createEReference(genericRendererEClass, GENERIC_RENDERER__RENDERED_STRUCTURES);
		createEReference(genericRendererEClass, GENERIC_RENDERER__CONSTANT_BUFFER);
		createEReference(genericRendererEClass, GENERIC_RENDERER__TRANSFER_BUFFER);
		createEReference(genericRendererEClass, GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER);
		createEReference(genericRendererEClass, GENERIC_RENDERER__SPECIALIZATION);
		createEReference(genericRendererEClass, GENERIC_RENDERER__FLUSH_TRANSFER_BUFFER_TASK);

		renderDataProviderEClass = createEClass(RENDER_DATA_PROVIDER);

		dataProviderPkgEClass = createEClass(DATA_PROVIDER_PKG);
		createEReference(dataProviderPkgEClass, DATA_PROVIDER_PKG__DATA_PROVIDERS);

		renderableDataSourceEClass = createEClass(RENDERABLE_DATA_SOURCE);
		createEReference(renderableDataSourceEClass, RENDERABLE_DATA_SOURCE__STRUCTURE);
		createEAttribute(renderableDataSourceEClass, RENDERABLE_DATA_SOURCE__PART);

		vertexProviderEClass = createEClass(VERTEX_PROVIDER);

		indexProviderEClass = createEClass(INDEX_PROVIDER);
		createEAttribute(indexProviderEClass, INDEX_PROVIDER__INDEX_TYPE);

		resourceProviderEClass = createEClass(RESOURCE_PROVIDER);

		staticResourceProviderEClass = createEClass(STATIC_RESOURCE_PROVIDER);
		createEReference(staticResourceProviderEClass, STATIC_RESOURCE_PROVIDER__RESOURCES);

		compositeResourceProviderEClass = createEClass(COMPOSITE_RESOURCE_PROVIDER);
		createEReference(compositeResourceProviderEClass, COMPOSITE_RESOURCE_PROVIDER__PROVIDERS);

		renderProxyConstantBufferEClass = createEClass(RENDER_PROXY_CONSTANT_BUFFER);
		createEReference(renderProxyConstantBufferEClass, RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER);
		createEAttribute(renderProxyConstantBufferEClass, RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX);

		iSpecializationEClass = createEClass(ISPECIALIZATION);

		entityPkgEClass = createEClass(ENTITY_PKG);
		createEReference(entityPkgEClass, ENTITY_PKG__ENTITIES);

		renderDrawTaskEClass = createEClass(RENDER_DRAW_TASK);
		createEReference(renderDrawTaskEClass, RENDER_DRAW_TASK__VERTEX_PROVIDERS);

		renderIndexedDrawTaskEClass = createEClass(RENDER_INDEXED_DRAW_TASK);
		createEReference(renderIndexedDrawTaskEClass, RENDER_INDEXED_DRAW_TASK__INDEX_PROVIDER);
		createEReference(renderIndexedDrawTaskEClass, RENDER_INDEXED_DRAW_TASK__STRUCTURE);
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
		GraphicPackage theGraphicPackage = (GraphicPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		MaintainerPackage theMaintainerPackage = (MaintainerPackage)EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);

		// Create type parameters
		ETypeParameter genericRendererEClass_T = addETypeParameter(genericRendererEClass, "T");
		ETypeParameter renderDataProviderEClass_T = addETypeParameter(renderDataProviderEClass, "T");
		ETypeParameter dataProviderPkgEClass_T = addETypeParameter(dataProviderPkgEClass, "T");
		ETypeParameter renderableDataSourceEClass_T = addETypeParameter(renderableDataSourceEClass, "T");
		ETypeParameter vertexProviderEClass_T = addETypeParameter(vertexProviderEClass, "T");
		ETypeParameter indexProviderEClass_T = addETypeParameter(indexProviderEClass, "T");
		ETypeParameter entityPkgEClass_T = addETypeParameter(entityPkgEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getStructure());
		genericRendererEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		renderDataProviderEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		dataProviderPkgEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		renderableDataSourceEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		vertexProviderEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		indexProviderEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getEntity());
		entityPkgEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		entityEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		physicalEntityEClass.getESuperTypes().add(this.getEntity());
		presentableEntityEClass.getESuperTypes().add(this.getPhysicalEntity());
		g1 = createEGenericType(theGraphicPackage.getGraphicsPipeline());
		genericRendererEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMaintainerPackage.getMaintainer());
		EGenericType g2 = createEGenericType(theGraphicPackage.getGraphicsPipeline());
		g1.getETypeArguments().add(g2);
		genericRendererEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theResourcePackage.getBufferDataProvider());
		g2 = createEGenericType(this.getRenderableDataSource());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(renderDataProviderEClass_T);
		g2.getETypeArguments().add(g3);
		renderDataProviderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getRenderDataProvider());
		g2 = createEGenericType(vertexProviderEClass_T);
		g1.getETypeArguments().add(g2);
		vertexProviderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getRenderDataProvider());
		g2 = createEGenericType(indexProviderEClass_T);
		g1.getETypeArguments().add(g2);
		indexProviderEClass.getEGenericSuperTypes().add(g1);
		staticResourceProviderEClass.getESuperTypes().add(this.getResourceProvider());
		compositeResourceProviderEClass.getESuperTypes().add(this.getResourceProvider());
		renderProxyConstantBufferEClass.getESuperTypes().add(theResourcePackage.getConstantBuffer());
		renderDrawTaskEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		renderIndexedDrawTaskEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());

		// Initialize classes, features, and operations; add parameters
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

		initEClass(structureEClass, Structure.class, "Structure", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(presentationEClass, Presentation.class, "Presentation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentation_PresentedEntities(), this.getPresentableEntity(), this.getPresentableEntity_Presentation(), "presentedEntities", null, 0, -1, Presentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(presentationPkgEClass, PresentationPkg.class, "PresentationPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentationPkg_Structures(), this.getStructure(), null, "structures", null, 0, -1, PresentationPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(presentableEntityEClass, PresentableEntity.class, "PresentableEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPresentableEntity_Presentation(), this.getPresentation(), this.getPresentation_PresentedEntities(), "presentation", null, 0, 1, PresentableEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentableEntity_Scale(), ecorePackage.getEDouble(), "scale", "1", 0, 1, PresentableEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genericRendererEClass, GenericRenderer.class, "GenericRenderer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getDataProviderPkg());
		g2 = createEGenericType(genericRendererEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getGenericRenderer_DataProviderPkg(), g1, null, "dataProviderPkg", null, 1, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(genericRendererEClass_T);
		initEReference(getGenericRenderer_RenderedStructures(), g1, null, "renderedStructures", null, 1, -1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_ConstantBuffer(), theResourcePackage.getConstantBuffer(), null, "constantBuffer", null, 0, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_TransferBuffer(), theResourcePackage.getTransferBuffer(), null, "transferBuffer", null, 1, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_CommonResourceProvider(), this.getResourceProvider(), null, "commonResourceProvider", null, 0, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_Specialization(), this.getISpecialization(), null, "specialization", null, 0, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_FlushTransferBufferTask(), theProcessPackage.getFlushTransferBufferTask(), null, "flushTransferBufferTask", null, 1, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderDataProviderEClass, RenderDataProvider.class, "RenderDataProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataProviderPkgEClass, DataProviderPkg.class, "DataProviderPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getRenderDataProvider());
		g2 = createEGenericType(dataProviderPkgEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getDataProviderPkg_DataProviders(), g1, null, "dataProviders", null, 1, -1, DataProviderPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderableDataSourceEClass, RenderableDataSource.class, "RenderableDataSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(renderableDataSourceEClass_T);
		initEReference(getRenderableDataSource_Structure(), g1, null, "structure", null, 1, 1, RenderableDataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenderableDataSource_Part(), ecorePackage.getEInt(), "part", null, 1, 1, RenderableDataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vertexProviderEClass, VertexProvider.class, "VertexProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(indexProviderEClass, IndexProvider.class, "IndexProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexProvider_IndexType(), theEnumerationPackage.getEIndexType(), "indexType", "UINT32", 1, 1, IndexProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceProviderEClass, ResourceProvider.class, "ResourceProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(staticResourceProviderEClass, StaticResourceProvider.class, "StaticResourceProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStaticResourceProvider_Resources(), theVulkanPackage.getIResource(), null, "resources", null, 1, -1, StaticResourceProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeResourceProviderEClass, CompositeResourceProvider.class, "CompositeResourceProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeResourceProvider_Providers(), this.getResourceProvider(), null, "providers", null, 0, -1, CompositeResourceProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderProxyConstantBufferEClass, RenderProxyConstantBuffer.class, "RenderProxyConstantBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenderProxyConstantBuffer_ConstantBuffer(), theResourcePackage.getConstantBuffer(), null, "constantBuffer", null, 1, 1, RenderProxyConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenderProxyConstantBuffer_PartIndex(), ecorePackage.getEInt(), "partIndex", null, 1, 1, RenderProxyConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iSpecializationEClass, ISpecialization.class, "ISpecialization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityPkgEClass, EntityPkg.class, "EntityPkg", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(entityPkgEClass_T);
		initEReference(getEntityPkg_Entities(), g1, null, "entities", null, 0, -1, EntityPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderDrawTaskEClass, RenderDrawTask.class, "RenderDrawTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getVertexProvider());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getRenderDrawTask_VertexProviders(), g1, null, "vertexProviders", null, 1, -1, RenderDrawTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderIndexedDrawTaskEClass, RenderIndexedDrawTask.class, "RenderIndexedDrawTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getIndexProvider());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getRenderIndexedDrawTask_IndexProvider(), g1, null, "indexProvider", null, 1, 1, RenderIndexedDrawTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRenderIndexedDrawTask_Structure(), this.getStructure(), null, "structure", null, 1, 1, RenderIndexedDrawTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RenderingPackageImpl
