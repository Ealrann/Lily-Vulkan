/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraFactory;
import org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage;
import org.sheepy.lily.vulkan.extra.graphic.model.IDataProvider;
import org.sheepy.lily.vulkan.extra.graphic.model.MeshProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicExtraPackageImpl extends EPackageImpl implements GraphicExtraPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meshProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDataProviderEClass = null;

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
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphicExtraPackageImpl()
	{
		super(eNS_URI, GraphicExtraFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GraphicExtraPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphicExtraPackage init()
	{
		if (isInited) return (GraphicExtraPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicExtraPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredGraphicExtraPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		GraphicExtraPackageImpl theGraphicExtraPackage = registeredGraphicExtraPackage instanceof GraphicExtraPackageImpl ? (GraphicExtraPackageImpl)registeredGraphicExtraPackage : new GraphicExtraPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGraphicExtraPackage.createPackageContents();

		// Initialize created meta-data
		theGraphicExtraPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphicExtraPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphicExtraPackage.eNS_URI, theGraphicExtraPackage);
		return theGraphicExtraPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMeshProvider()
	{
		return meshProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDataProvider()
	{
		return iDataProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicExtraFactory getGraphicExtraFactory()
	{
		return (GraphicExtraFactory)getEFactoryInstance();
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
		meshProviderEClass = createEClass(MESH_PROVIDER);

		iDataProviderEClass = createEClass(IDATA_PROVIDER);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		meshProviderEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iDataProviderEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(meshProviderEClass, MeshProvider.class, "MeshProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iDataProviderEClass, IDataProvider.class, "IDataProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphicExtraPackageImpl
