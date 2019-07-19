/**
 */
package org.sheepy.vulkan.model.pipeline.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.barrier.impl.BarrierPackageImpl;
import org.sheepy.vulkan.model.enumeration.EnumerationPackage;

import org.sheepy.vulkan.model.enumeration.impl.EnumerationPackageImpl;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.graphicpipeline.impl.GraphicpipelinePackageImpl;
import org.sheepy.vulkan.model.pipeline.PipelineFactory;
import org.sheepy.vulkan.model.pipeline.PipelinePackage;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipelinePackageImpl extends EPackageImpl implements PipelinePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushConstantRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationConstantEClass = null;

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
	 * @see org.sheepy.vulkan.model.pipeline.PipelinePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PipelinePackageImpl()
	{
		super(eNS_URI, PipelineFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PipelinePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PipelinePackage init()
	{
		if (isInited) return (PipelinePackage)EPackage.Registry.INSTANCE.getEPackage(PipelinePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPipelinePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PipelinePackageImpl thePipelinePackage = registeredPipelinePackage instanceof PipelinePackageImpl ? (PipelinePackageImpl)registeredPipelinePackage : new PipelinePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BarrierPackage.eNS_URI);
		BarrierPackageImpl theBarrierPackage = (BarrierPackageImpl)(registeredPackage instanceof BarrierPackageImpl ? registeredPackage : BarrierPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		EnumerationPackageImpl theEnumerationPackage = (EnumerationPackageImpl)(registeredPackage instanceof EnumerationPackageImpl ? registeredPackage : EnumerationPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GraphicpipelinePackage.eNS_URI);
		GraphicpipelinePackageImpl theGraphicpipelinePackage = (GraphicpipelinePackageImpl)(registeredPackage instanceof GraphicpipelinePackageImpl ? registeredPackage : GraphicpipelinePackage.eINSTANCE);

		// Create package meta-data objects
		thePipelinePackage.createPackageContents();
		theBarrierPackage.createPackageContents();
		theEnumerationPackage.createPackageContents();
		theGraphicpipelinePackage.createPackageContents();

		// Initialize created meta-data
		thePipelinePackage.initializePackageContents();
		theBarrierPackage.initializePackageContents();
		theEnumerationPackage.initializePackageContents();
		theGraphicpipelinePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePipelinePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PipelinePackage.eNS_URI, thePipelinePackage);
		return thePipelinePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPushConstantRange()
	{
		return pushConstantRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushConstantRange_Stages()
	{
		return (EAttribute)pushConstantRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushConstantRange_Offset()
	{
		return (EAttribute)pushConstantRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushConstantRange_Size()
	{
		return (EAttribute)pushConstantRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecializationConstant()
	{
		return specializationConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpecializationConstant_Name()
	{
		return (EAttribute)specializationConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpecializationConstant_ConstantId()
	{
		return (EAttribute)specializationConstantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpecializationConstant_Size()
	{
		return (EAttribute)specializationConstantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelineFactory getPipelineFactory()
	{
		return (PipelineFactory)getEFactoryInstance();
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
		pushConstantRangeEClass = createEClass(PUSH_CONSTANT_RANGE);
		createEAttribute(pushConstantRangeEClass, PUSH_CONSTANT_RANGE__STAGES);
		createEAttribute(pushConstantRangeEClass, PUSH_CONSTANT_RANGE__OFFSET);
		createEAttribute(pushConstantRangeEClass, PUSH_CONSTANT_RANGE__SIZE);

		specializationConstantEClass = createEClass(SPECIALIZATION_CONSTANT);
		createEAttribute(specializationConstantEClass, SPECIALIZATION_CONSTANT__NAME);
		createEAttribute(specializationConstantEClass, SPECIALIZATION_CONSTANT__CONSTANT_ID);
		createEAttribute(specializationConstantEClass, SPECIALIZATION_CONSTANT__SIZE);
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
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(pushConstantRangeEClass, PushConstantRange.class, "PushConstantRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPushConstantRange_Stages(), theEnumerationPackage.getEShaderStage(), "stages", null, 1, -1, PushConstantRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPushConstantRange_Offset(), theEcorePackage.getEInt(), "offset", "0", 0, 1, PushConstantRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPushConstantRange_Size(), theEcorePackage.getEInt(), "size", null, 0, 1, PushConstantRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializationConstantEClass, SpecializationConstant.class, "SpecializationConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpecializationConstant_Name(), theEcorePackage.getEString(), "name", null, 0, 1, SpecializationConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecializationConstant_ConstantId(), theEcorePackage.getEInt(), "constantId", null, 0, 1, SpecializationConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecializationConstant_Size(), theEcorePackage.getEInt(), "size", null, 0, 1, SpecializationConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PipelinePackageImpl
