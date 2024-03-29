/**
 */
package org.sheepy.lily.vulkan.extra.model.shape.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
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
import org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricStructure;
import org.sheepy.lily.vulkan.extra.model.shape.IcoSphere;
import org.sheepy.lily.vulkan.extra.model.shape.Icosahedron;
import org.sheepy.lily.vulkan.extra.model.shape.ShapeFactory;
import org.sheepy.lily.vulkan.extra.model.shape.ShapePackage;
import org.sheepy.lily.vulkan.extra.model.shape.Sphere;
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
public class ShapePackageImpl extends EPackageImpl implements ShapePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geometricStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geometricMeshEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass icosahedronEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sphereEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass icoSphereEClass = null;

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
	 * @see org.sheepy.lily.vulkan.extra.model.shape.ShapePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ShapePackageImpl()
	{
		super(eNS_URI, ShapeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ShapePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ShapePackage init()
	{
		if (isInited) return (ShapePackage)EPackage.Registry.INSTANCE.getEPackage(ShapePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredShapePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ShapePackageImpl theShapePackage = registeredShapePackage instanceof ShapePackageImpl ? (ShapePackageImpl)registeredShapePackage : new ShapePackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(SpritePackage.eNS_URI);
		SpritePackageImpl theSpritePackage = (SpritePackageImpl)(registeredPackage instanceof SpritePackageImpl ? registeredPackage : SpritePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MeshPackage.eNS_URI);
		MeshPackageImpl theMeshPackage = (MeshPackageImpl)(registeredPackage instanceof MeshPackageImpl ? registeredPackage : MeshPackage.eINSTANCE);

		// Create package meta-data objects
		theShapePackage.createPackageContents();
		theNuklearPackage.createPackageContents();
		theRenderingPackage.createPackageContents();
		theSpritePackage.createPackageContents();
		theMeshPackage.createPackageContents();

		// Initialize created meta-data
		theShapePackage.initializePackageContents();
		theNuklearPackage.initializePackageContents();
		theRenderingPackage.initializePackageContents();
		theSpritePackage.initializePackageContents();
		theMeshPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theShapePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ShapePackage.eNS_URI, theShapePackage);
		return theShapePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGeometricStructure()
	{
		return geometricStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGeometricMesh()
	{
		return geometricMeshEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIcosahedron()
	{
		return icosahedronEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSphere()
	{
		return sphereEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSphere_SliceCount()
	{
		return (EAttribute)sphereEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIcoSphere()
	{
		return icoSphereEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIcoSphere_SubdivisionCount()
	{
		return (EAttribute)icoSphereEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ShapeFactory getShapeFactory()
	{
		return (ShapeFactory)getEFactoryInstance();
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
		geometricStructureEClass = createEClass(GEOMETRIC_STRUCTURE);

		geometricMeshEClass = createEClass(GEOMETRIC_MESH);

		icosahedronEClass = createEClass(ICOSAHEDRON);

		sphereEClass = createEClass(SPHERE);
		createEAttribute(sphereEClass, SPHERE__SLICE_COUNT);

		icoSphereEClass = createEClass(ICO_SPHERE);
		createEAttribute(icoSphereEClass, ICO_SPHERE__SUBDIVISION_COUNT);
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
		MeshPackage theMeshPackage = (MeshPackage)EPackage.Registry.INSTANCE.getEPackage(MeshPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theMeshPackage.getMeshStructure());
		EGenericType g2 = createEGenericType(this.getGeometricMesh());
		g1.getETypeArguments().add(g2);
		geometricStructureEClass.getEGenericSuperTypes().add(g1);
		geometricMeshEClass.getESuperTypes().add(theMeshPackage.getMesh());
		icosahedronEClass.getESuperTypes().add(this.getGeometricStructure());
		sphereEClass.getESuperTypes().add(this.getGeometricStructure());
		icoSphereEClass.getESuperTypes().add(this.getGeometricStructure());

		// Initialize classes, features, and operations; add parameters
		initEClass(geometricStructureEClass, GeometricStructure.class, "GeometricStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(geometricMeshEClass, GeometricMesh.class, "GeometricMesh", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(icosahedronEClass, Icosahedron.class, "Icosahedron", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sphereEClass, Sphere.class, "Sphere", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSphere_SliceCount(), ecorePackage.getEInt(), "sliceCount", "12", 0, 1, Sphere.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(icoSphereEClass, IcoSphere.class, "IcoSphere", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIcoSphere_SubdivisionCount(), ecorePackage.getEInt(), "subdivisionCount", "2", 0, 1, IcoSphere.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ShapePackageImpl
