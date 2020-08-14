/**
 */
package org.sheepy.lily.openal.model.openal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.openal.model.openal.OpenALEngine;
import org.sheepy.lily.openal.model.openal.OpenalFactory;
import org.sheepy.lily.openal.model.openal.OpenalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OpenalPackageImpl extends EPackageImpl implements OpenalPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openALEngineEClass = null;

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
	 * @see org.sheepy.lily.openal.model.openal.OpenalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OpenalPackageImpl()
	{
		super(eNS_URI, OpenalFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OpenalPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OpenalPackage init()
	{
		if (isInited) return (OpenalPackage)EPackage.Registry.INSTANCE.getEPackage(OpenalPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredOpenalPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		OpenalPackageImpl theOpenalPackage = registeredOpenalPackage instanceof OpenalPackageImpl ? (OpenalPackageImpl)registeredOpenalPackage : new OpenalPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOpenalPackage.createPackageContents();

		// Initialize created meta-data
		theOpenalPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOpenalPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OpenalPackage.eNS_URI, theOpenalPackage);
		return theOpenalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOpenALEngine()
	{
		return openALEngineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpenalFactory getOpenalFactory()
	{
		return (OpenalFactory)getEFactoryInstance();
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
		openALEngineEClass = createEClass(OPEN_AL_ENGINE);
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
		ApplicationPackage theApplicationPackage = (ApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		openALEngineEClass.getESuperTypes().add(theApplicationPackage.getIEngine());

		// Initialize classes, features, and operations; add parameters
		initEClass(openALEngineEClass, OpenALEngine.class, "OpenALEngine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OpenalPackageImpl
