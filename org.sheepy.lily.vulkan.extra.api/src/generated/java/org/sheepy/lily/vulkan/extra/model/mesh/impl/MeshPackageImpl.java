/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import org.eclipse.emf.ecore.EClass;
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
import org.sheepy.lily.vulkan.extra.model.mesh.IMeshStructure;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshFactory;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshRenderer;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPackageImpl;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderingPackageImpl;
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
public class MeshPackageImpl extends EPackageImpl implements MeshPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meshEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meshRendererEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meshStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMeshStructureEClass = null;

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
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MeshPackageImpl()
	{
		super(eNS_URI, MeshFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MeshPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MeshPackage init()
	{
		if (isInited) return (MeshPackage)EPackage.Registry.INSTANCE.getEPackage(MeshPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMeshPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MeshPackageImpl theMeshPackage = registeredMeshPackage instanceof MeshPackageImpl ? (MeshPackageImpl)registeredMeshPackage : new MeshPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ResourcePackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		PresentationPackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		GraphicPackage.eINSTANCE.eClass();
		ProcessPackage.eINSTANCE.eClass();
		VulkanPackage.eINSTANCE.eClass();
		VulkanResourcePackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NuklearPackage.eNS_URI);
		NuklearPackageImpl theNuklearPackage = (NuklearPackageImpl)(registeredPackage instanceof NuklearPackageImpl ? registeredPackage : NuklearPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RenderingPackage.eNS_URI);
		RenderingPackageImpl theRenderingPackage = (RenderingPackageImpl)(registeredPackage instanceof RenderingPackageImpl ? registeredPackage : RenderingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ShapePackage.eNS_URI);
		ShapePackageImpl theShapePackage = (ShapePackageImpl)(registeredPackage instanceof ShapePackageImpl ? registeredPackage : ShapePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SpritePackage.eNS_URI);
		SpritePackageImpl theSpritePackage = (SpritePackageImpl)(registeredPackage instanceof SpritePackageImpl ? registeredPackage : SpritePackage.eINSTANCE);

		// Create package meta-data objects
		theMeshPackage.createPackageContents();
		theNuklearPackage.createPackageContents();
		theRenderingPackage.createPackageContents();
		theShapePackage.createPackageContents();
		theSpritePackage.createPackageContents();

		// Initialize created meta-data
		theMeshPackage.initializePackageContents();
		theNuklearPackage.initializePackageContents();
		theRenderingPackage.initializePackageContents();
		theShapePackage.initializePackageContents();
		theSpritePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMeshPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MeshPackage.eNS_URI, theMeshPackage);
		return theMeshPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMesh()
	{
		return meshEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMeshRenderer()
	{
		return meshRendererEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMeshStructure()
	{
		return meshStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMeshStructure_Meshes()
	{
		return (EReference)meshStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIMeshStructure()
	{
		return iMeshStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MeshFactory getMeshFactory()
	{
		return (MeshFactory)getEFactoryInstance();
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
		meshEClass = createEClass(MESH);

		meshRendererEClass = createEClass(MESH_RENDERER);

		meshStructureEClass = createEClass(MESH_STRUCTURE);
		createEReference(meshStructureEClass, MESH_STRUCTURE__MESHES);

		iMeshStructureEClass = createEClass(IMESH_STRUCTURE);
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

		// Create type parameters
		ETypeParameter meshStructureEClass_T = addETypeParameter(meshStructureEClass, "T");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getMesh());
		meshStructureEClass_T.getEBounds().add(g1);

		// Add supertypes to classes
		meshEClass.getESuperTypes().add(theRenderingPackage.getPresentation());
		g1 = createEGenericType(theRenderingPackage.getGenericRenderer());
		EGenericType g2 = createEGenericType(this.getIMeshStructure());
		g1.getETypeArguments().add(g2);
		meshRendererEClass.getEGenericSuperTypes().add(g1);
		meshStructureEClass.getESuperTypes().add(this.getIMeshStructure());
		iMeshStructureEClass.getESuperTypes().add(theRenderingPackage.getStructure());

		// Initialize classes, features, and operations; add parameters
		initEClass(meshEClass, Mesh.class, "Mesh", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(meshRendererEClass, MeshRenderer.class, "MeshRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(meshStructureEClass, MeshStructure.class, "MeshStructure", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(meshStructureEClass_T);
		initEReference(getMeshStructure_Meshes(), g1, null, "meshes", null, 1, -1, MeshStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iMeshStructureEClass, IMeshStructure.class, "IMeshStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MeshPackageImpl
