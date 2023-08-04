/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
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
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature;
import org.sheepy.lily.vulkan.extra.model.rendering.Entity;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.shape.ShapePackage;
import org.sheepy.lily.vulkan.extra.model.shape.impl.ShapePackageImpl;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl;
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
	private EClass dataProviderPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexedDataDescriptionEClass = null;

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
	private EClass resourceDescriptorProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptorsProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataDescriptorsProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDescriptorProviderPkgEClass = null;

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
	private EClass physicalEntityVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ePhysicalEntityFeatureEEnum = null;

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
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NuklearPackage.eNS_URI);
		NuklearPackageImpl theNuklearPackage = (NuklearPackageImpl)(registeredPackage instanceof NuklearPackageImpl ? registeredPackage : NuklearPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ShapePackage.eNS_URI);
		ShapePackageImpl theShapePackage = (ShapePackageImpl)(registeredPackage instanceof ShapePackageImpl ? registeredPackage : ShapePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SpritePackage.eNS_URI);
		SpritePackageImpl theSpritePackage = (SpritePackageImpl)(registeredPackage instanceof SpritePackageImpl ? registeredPackage : SpritePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MeshPackage.eNS_URI);
		MeshPackageImpl theMeshPackage = (MeshPackageImpl)(registeredPackage instanceof MeshPackageImpl ? registeredPackage : MeshPackage.eINSTANCE);

		// Create package meta-data objects
		theRenderingPackage.createPackageContents();
		theNuklearPackage.createPackageContents();
		theShapePackage.createPackageContents();
		theSpritePackage.createPackageContents();
		theMeshPackage.createPackageContents();

		// Initialize created meta-data
		theRenderingPackage.initializePackageContents();
		theNuklearPackage.initializePackageContents();
		theShapePackage.initializePackageContents();
		theSpritePackage.initializePackageContents();
		theMeshPackage.initializePackageContents();

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
	public EReference getGenericRenderer_DescriptorProviderPkg()
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
	public EAttribute getGenericRenderer_OnePipelinePerPart()
	{
		return (EAttribute)genericRendererEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGenericRenderer_Maintaining()
	{
		return (EAttribute)genericRendererEClass.getEStructuralFeatures().get(8);
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
	public EClass getDataProvider()
	{
		return dataProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataProvider_Usages()
	{
		return (EAttribute)dataProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataProvider_GrowFactor()
	{
		return (EAttribute)dataProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataProvider_MinSize()
	{
		return (EAttribute)dataProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataProvider_DataSource()
	{
		return (EReference)dataProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataProvider_DataSourceName()
	{
		return (EAttribute)dataProviderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIndexedDataDescription()
	{
		return indexedDataDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIndexedDataDescription_IndexType()
	{
		return (EAttribute)indexedDataDescriptionEClass.getEStructuralFeatures().get(0);
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
	public EReference getRenderableDataSource_DataSource()
	{
		return (EReference)renderableDataSourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResourceDescriptorProvider()
	{
		return resourceDescriptorProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptorsProvider()
	{
		return descriptorsProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptorsProvider_Descriptors()
	{
		return (EReference)descriptorsProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataDescriptorsProvider()
	{
		return dataDescriptorsProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataDescriptorsProvider_DataDescriptors()
	{
		return (EReference)dataDescriptorsProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataDescriptor()
	{
		return dataDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataDescriptor_Part()
	{
		return (EAttribute)dataDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataDescriptor_Instance()
	{
		return (EAttribute)dataDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataDescriptor_DescriptorType()
	{
		return (EAttribute)dataDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataDescriptor_Stages()
	{
		return (EAttribute)dataDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResourceDescriptorProviderPkg()
	{
		return resourceDescriptorProviderPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getResourceDescriptorProviderPkg_ResourceDescriptorProviders()
	{
		return (EReference)resourceDescriptorProviderPkgEClass.getEStructuralFeatures().get(0);
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
	public EClass getPhysicalEntityVariable()
	{
		return physicalEntityVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPhysicalEntityVariable_Entity()
	{
		return (EReference)physicalEntityVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPhysicalEntityVariable_Feature()
	{
		return (EAttribute)physicalEntityVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEPhysicalEntityFeature()
	{
		return ePhysicalEntityFeatureEEnum;
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
		createEReference(genericRendererEClass, GENERIC_RENDERER__DESCRIPTOR_PROVIDER_PKG);
		createEReference(genericRendererEClass, GENERIC_RENDERER__SPECIALIZATION);
		createEReference(genericRendererEClass, GENERIC_RENDERER__FLUSH_TRANSFER_BUFFER_TASK);
		createEAttribute(genericRendererEClass, GENERIC_RENDERER__ONE_PIPELINE_PER_PART);
		createEAttribute(genericRendererEClass, GENERIC_RENDERER__MAINTAINING);

		dataProviderPkgEClass = createEClass(DATA_PROVIDER_PKG);
		createEReference(dataProviderPkgEClass, DATA_PROVIDER_PKG__DATA_PROVIDERS);

		dataProviderEClass = createEClass(DATA_PROVIDER);
		createEAttribute(dataProviderEClass, DATA_PROVIDER__USAGES);
		createEAttribute(dataProviderEClass, DATA_PROVIDER__GROW_FACTOR);
		createEAttribute(dataProviderEClass, DATA_PROVIDER__MIN_SIZE);
		createEReference(dataProviderEClass, DATA_PROVIDER__DATA_SOURCE);
		createEAttribute(dataProviderEClass, DATA_PROVIDER__DATA_SOURCE_NAME);

		indexedDataDescriptionEClass = createEClass(INDEXED_DATA_DESCRIPTION);
		createEAttribute(indexedDataDescriptionEClass, INDEXED_DATA_DESCRIPTION__INDEX_TYPE);

		renderableDataSourceEClass = createEClass(RENDERABLE_DATA_SOURCE);
		createEReference(renderableDataSourceEClass, RENDERABLE_DATA_SOURCE__STRUCTURE);
		createEAttribute(renderableDataSourceEClass, RENDERABLE_DATA_SOURCE__PART);
		createEReference(renderableDataSourceEClass, RENDERABLE_DATA_SOURCE__DATA_SOURCE);

		resourceDescriptorProviderEClass = createEClass(RESOURCE_DESCRIPTOR_PROVIDER);

		descriptorsProviderEClass = createEClass(DESCRIPTORS_PROVIDER);
		createEReference(descriptorsProviderEClass, DESCRIPTORS_PROVIDER__DESCRIPTORS);

		dataDescriptorsProviderEClass = createEClass(DATA_DESCRIPTORS_PROVIDER);
		createEReference(dataDescriptorsProviderEClass, DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS);

		dataDescriptorEClass = createEClass(DATA_DESCRIPTOR);
		createEAttribute(dataDescriptorEClass, DATA_DESCRIPTOR__PART);
		createEAttribute(dataDescriptorEClass, DATA_DESCRIPTOR__INSTANCE);
		createEAttribute(dataDescriptorEClass, DATA_DESCRIPTOR__DESCRIPTOR_TYPE);
		createEAttribute(dataDescriptorEClass, DATA_DESCRIPTOR__STAGES);

		resourceDescriptorProviderPkgEClass = createEClass(RESOURCE_DESCRIPTOR_PROVIDER_PKG);
		createEReference(resourceDescriptorProviderPkgEClass, RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS);

		renderProxyConstantBufferEClass = createEClass(RENDER_PROXY_CONSTANT_BUFFER);
		createEReference(renderProxyConstantBufferEClass, RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER);
		createEAttribute(renderProxyConstantBufferEClass, RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX);

		iSpecializationEClass = createEClass(ISPECIALIZATION);

		entityPkgEClass = createEClass(ENTITY_PKG);
		createEReference(entityPkgEClass, ENTITY_PKG__ENTITIES);

		physicalEntityVariableEClass = createEClass(PHYSICAL_ENTITY_VARIABLE);
		createEReference(physicalEntityVariableEClass, PHYSICAL_ENTITY_VARIABLE__ENTITY);
		createEAttribute(physicalEntityVariableEClass, PHYSICAL_ENTITY_VARIABLE__FEATURE);

		// Create enums
		ePhysicalEntityFeatureEEnum = createEEnum(EPHYSICAL_ENTITY_FEATURE);
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
		VulkanResourcePackage theVulkanResourcePackage = (VulkanResourcePackage)EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);
		ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		VulkanPackage theVulkanPackage = (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VariablePackage theVariablePackage = (VariablePackage)EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);

		// Create type parameters
		ETypeParameter genericRendererEClass_T = addETypeParameter(genericRendererEClass, "T");
		ETypeParameter dataProviderPkgEClass_T = addETypeParameter(dataProviderPkgEClass, "T");
		ETypeParameter dataProviderEClass_T = addETypeParameter(dataProviderEClass, "T");
		ETypeParameter indexedDataDescriptionEClass_T = addETypeParameter(indexedDataDescriptionEClass, "T");
		ETypeParameter renderableDataSourceEClass_T = addETypeParameter(renderableDataSourceEClass, "T");
		ETypeParameter entityPkgEClass_T = addETypeParameter(entityPkgEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getStructure());
		genericRendererEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		dataProviderPkgEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		dataProviderEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		indexedDataDescriptionEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getStructure());
		renderableDataSourceEClass_T.getEBounds().add(g1);
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
		g1 = createEGenericType(this.getDataProvider());
		g2 = createEGenericType(indexedDataDescriptionEClass_T);
		g1.getETypeArguments().add(g2);
		indexedDataDescriptionEClass.getEGenericSuperTypes().add(g1);
		renderableDataSourceEClass.getESuperTypes().add(theVulkanResourcePackage.getIBufferDataSource());
		renderableDataSourceEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		renderableDataSourceEClass.getESuperTypes().add(theVulkanPackage.getIVulkanResource());
		descriptorsProviderEClass.getESuperTypes().add(this.getResourceDescriptorProvider());
		dataDescriptorsProviderEClass.getESuperTypes().add(this.getResourceDescriptorProvider());
		renderProxyConstantBufferEClass.getESuperTypes().add(theVulkanResourcePackage.getConstantBuffer());
		physicalEntityVariableEClass.getESuperTypes().add(theVariablePackage.getIModelVariable());

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
		initEReference(getGenericRenderer_ConstantBuffer(), theVulkanResourcePackage.getConstantBuffer(), null, "constantBuffer", null, 0, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_TransferBuffer(), theVulkanResourcePackage.getTransferBuffer(), null, "transferBuffer", null, 1, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_DescriptorProviderPkg(), this.getResourceDescriptorProviderPkg(), null, "descriptorProviderPkg", null, 0, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_Specialization(), this.getISpecialization(), null, "specialization", null, 0, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenericRenderer_FlushTransferBufferTask(), theProcessPackage.getFlushTransferBufferTask(), null, "flushTransferBufferTask", null, 1, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenericRenderer_OnePipelinePerPart(), ecorePackage.getEBoolean(), "onePipelinePerPart", "false", 1, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenericRenderer_Maintaining(), ecorePackage.getEBoolean(), "maintaining", "true", 0, 1, GenericRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataProviderPkgEClass, DataProviderPkg.class, "DataProviderPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getDataProvider());
		g2 = createEGenericType(dataProviderPkgEClass_T);
		g1.getETypeArguments().add(g2);
		initEReference(getDataProviderPkg_DataProviders(), g1, null, "dataProviders", null, 1, -1, DataProviderPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataProviderEClass, DataProvider.class, "DataProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataProvider_Usages(), theEnumerationPackage.getEBufferUsage(), "usages", null, 1, -1, DataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataProvider_GrowFactor(), ecorePackage.getEFloat(), "growFactor", "1.5f", 1, 1, DataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataProvider_MinSize(), ecorePackage.getELong(), "minSize", "0", 0, 1, DataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataProvider_DataSource(), theVulkanResourcePackage.getIBufferDataSource(), null, "dataSource", null, 0, 1, DataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataProvider_DataSourceName(), ecorePackage.getEString(), "dataSourceName", null, 1, 1, DataProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexedDataDescriptionEClass, IndexedDataDescription.class, "IndexedDataDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexedDataDescription_IndexType(), theEnumerationPackage.getEIndexType(), "indexType", "UINT32", 1, 1, IndexedDataDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderableDataSourceEClass, RenderableDataSource.class, "RenderableDataSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(renderableDataSourceEClass_T);
		initEReference(getRenderableDataSource_Structure(), g1, null, "structure", null, 1, 1, RenderableDataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenderableDataSource_Part(), ecorePackage.getEInt(), "part", null, 1, 1, RenderableDataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRenderableDataSource_DataSource(), theVulkanResourcePackage.getIBufferDataSource(), null, "dataSource", null, 0, 1, RenderableDataSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceDescriptorProviderEClass, ResourceDescriptorProvider.class, "ResourceDescriptorProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(descriptorsProviderEClass, DescriptorsProvider.class, "DescriptorsProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorsProvider_Descriptors(), theVulkanPackage.getIDescriptor(), null, "descriptors", null, 1, -1, DescriptorsProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataDescriptorsProviderEClass, DataDescriptorsProvider.class, "DataDescriptorsProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataDescriptorsProvider_DataDescriptors(), this.getDataDescriptor(), null, "dataDescriptors", null, 1, -1, DataDescriptorsProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataDescriptorEClass, DataDescriptor.class, "DataDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataDescriptor_Part(), ecorePackage.getEInt(), "part", null, 1, 1, DataDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataDescriptor_Instance(), ecorePackage.getEInt(), "instance", null, 1, 1, DataDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataDescriptor_DescriptorType(), theEnumerationPackage.getEDescriptorType(), "descriptorType", null, 1, 1, DataDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataDescriptor_Stages(), theEnumerationPackage.getEShaderStage(), "stages", null, 1, -1, DataDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceDescriptorProviderPkgEClass, ResourceDescriptorProviderPkg.class, "ResourceDescriptorProviderPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceDescriptorProviderPkg_ResourceDescriptorProviders(), this.getResourceDescriptorProvider(), null, "resourceDescriptorProviders", null, 0, -1, ResourceDescriptorProviderPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renderProxyConstantBufferEClass, RenderProxyConstantBuffer.class, "RenderProxyConstantBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenderProxyConstantBuffer_ConstantBuffer(), theVulkanResourcePackage.getConstantBuffer(), null, "constantBuffer", null, 1, 1, RenderProxyConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenderProxyConstantBuffer_PartIndex(), ecorePackage.getEInt(), "partIndex", null, 1, 1, RenderProxyConstantBuffer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iSpecializationEClass, ISpecialization.class, "ISpecialization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityPkgEClass, EntityPkg.class, "EntityPkg", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(entityPkgEClass_T);
		initEReference(getEntityPkg_Entities(), g1, null, "entities", null, 0, -1, EntityPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(physicalEntityVariableEClass, PhysicalEntityVariable.class, "PhysicalEntityVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPhysicalEntityVariable_Entity(), this.getPhysicalEntity(), null, "entity", null, 0, 1, PhysicalEntityVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalEntityVariable_Feature(), this.getEPhysicalEntityFeature(), "feature", null, 1, 1, PhysicalEntityVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(ePhysicalEntityFeatureEEnum, EPhysicalEntityFeature.class, "EPhysicalEntityFeature");
		addEEnumLiteral(ePhysicalEntityFeatureEEnum, EPhysicalEntityFeature.LOCATION);

		// Create resource
		createResource(eNS_URI);
	}

} //RenderingPackageImpl
