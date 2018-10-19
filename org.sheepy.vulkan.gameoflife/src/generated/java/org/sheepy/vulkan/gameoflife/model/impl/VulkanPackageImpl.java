/**
 */
package org.sheepy.vulkan.gameoflife.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.vulkan.gameoflife.model.BoardBuffer;
import org.sheepy.vulkan.gameoflife.model.BoardImage;
import org.sheepy.vulkan.gameoflife.model.VulkanFactory;
import org.sheepy.vulkan.gameoflife.model.VulkanPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VulkanPackageImpl extends EPackageImpl implements VulkanPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boardBufferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boardImageEClass = null;

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
	 * @see org.sheepy.vulkan.gameoflife.model.VulkanPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VulkanPackageImpl()
	{
		super(eNS_URI, VulkanFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VulkanPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VulkanPackage init()
	{
		if (isInited) return (VulkanPackage)EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredVulkanPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		VulkanPackageImpl theVulkanPackage = registeredVulkanPackage instanceof VulkanPackageImpl ? (VulkanPackageImpl)registeredVulkanPackage : new VulkanPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theVulkanPackage.createPackageContents();

		// Initialize created meta-data
		theVulkanPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVulkanPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VulkanPackage.eNS_URI, theVulkanPackage);
		return theVulkanPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoardBuffer()
	{
		return boardBufferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoardImage()
	{
		return boardImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanFactory getVulkanFactory()
	{
		return (VulkanFactory)getEFactoryInstance();
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
		boardBufferEClass = createEClass(BOARD_BUFFER);

		boardImageEClass = createEClass(BOARD_IMAGE);
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

		// Add supertypes to classes
		boardBufferEClass.getESuperTypes().add(ecorePackage.getEObject());
		boardBufferEClass.getESuperTypes().add(ecorePackage.getEObject());
		boardImageEClass.getESuperTypes().add(ecorePackage.getEObject());
		boardImageEClass.getESuperTypes().add(ecorePackage.getEObject());

		// Initialize classes and features; add operations and parameters
		initEClass(boardBufferEClass, BoardBuffer.class, "BoardBuffer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boardImageEClass, BoardImage.class, "BoardImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //VulkanPackageImpl
