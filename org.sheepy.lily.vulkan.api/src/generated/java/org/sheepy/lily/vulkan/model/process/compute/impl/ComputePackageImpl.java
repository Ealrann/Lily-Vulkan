/**
 */
package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl;
import org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl;
import org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl;
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
public class ComputePackageImpl extends EPackageImpl implements ComputePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computeProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computePipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchTaskEClass = null;

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
	 * @see org.sheepy.lily.vulkan.model.process.compute.ComputePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComputePackageImpl()
	{
		super(eNS_URI, ComputeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ComputePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComputePackage init()
	{
		if (isInited) return (ComputePackage)EPackage.Registry.INSTANCE.getEPackage(ComputePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredComputePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ComputePackageImpl theComputePackage = registeredComputePackage instanceof ComputePackageImpl ? (ComputePackageImpl)registeredComputePackage : new ComputePackageImpl();

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
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI);
		BindingPackageImpl theBindingPackage = (BindingPackageImpl)(registeredPackage instanceof BindingPackageImpl ? registeredPackage : BindingPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		GraphicPackageImpl theGraphicPackage = (GraphicPackageImpl)(registeredPackage instanceof GraphicPackageImpl ? registeredPackage : GraphicPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(registeredPackage instanceof ProcessPackageImpl ? registeredPackage : ProcessPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);
		VulkanResourcePackageImpl theVulkanResourcePackage = (VulkanResourcePackageImpl)(registeredPackage instanceof VulkanResourcePackageImpl ? registeredPackage : VulkanResourcePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VulkanPackageImpl theVulkanPackage = (VulkanPackageImpl)(registeredPackage instanceof VulkanPackageImpl ? registeredPackage : VulkanPackage.eINSTANCE);

		// Create package meta-data objects
		theComputePackage.createPackageContents();
		theBindingPackage.createPackageContents();
		theGraphicPackage.createPackageContents();
		theProcessPackage.createPackageContents();
		theVulkanResourcePackage.createPackageContents();
		theVulkanPackage.createPackageContents();

		// Initialize created meta-data
		theComputePackage.initializePackageContents();
		theBindingPackage.initializePackageContents();
		theGraphicPackage.initializePackageContents();
		theProcessPackage.initializePackageContents();
		theVulkanResourcePackage.initializePackageContents();
		theVulkanPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComputePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ComputePackage.eNS_URI, theComputePackage);
		return theComputePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComputeProcess()
	{
		return computeProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputeProcess_PipelinePkg()
	{
		return (EReference)computeProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputeProcess_SourceEngine()
	{
		return (EReference)computeProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getComputePipeline()
	{
		return computePipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getComputePipeline_Shader()
	{
		return (EReference)computePipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDispatchTask()
	{
		return dispatchTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDispatchTask_WorkgroupCountX()
	{
		return (EAttribute)dispatchTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDispatchTask_WorkgroupCountY()
	{
		return (EAttribute)dispatchTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDispatchTask_WorkgroupCountZ()
	{
		return (EAttribute)dispatchTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputeFactory getComputeFactory()
	{
		return (ComputeFactory)getEFactoryInstance();
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
		computeProcessEClass = createEClass(COMPUTE_PROCESS);
		createEReference(computeProcessEClass, COMPUTE_PROCESS__PIPELINE_PKG);
		createEReference(computeProcessEClass, COMPUTE_PROCESS__SOURCE_ENGINE);

		computePipelineEClass = createEClass(COMPUTE_PIPELINE);
		createEReference(computePipelineEClass, COMPUTE_PIPELINE__SHADER);

		dispatchTaskEClass = createEClass(DISPATCH_TASK);
		createEAttribute(dispatchTaskEClass, DISPATCH_TASK__WORKGROUP_COUNT_X);
		createEAttribute(dispatchTaskEClass, DISPATCH_TASK__WORKGROUP_COUNT_Y);
		createEAttribute(dispatchTaskEClass, DISPATCH_TASK__WORKGROUP_COUNT_Z);
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
		ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		ApplicationPackage theApplicationPackage = (ApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicationPackage.eNS_URI);
		MaintainerPackage theMaintainerPackage = (MaintainerPackage)EPackage.Registry.INSTANCE.getEPackage(MaintainerPackage.eNS_URI);
		VulkanResourcePackage theVulkanResourcePackage = (VulkanResourcePackage)EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		computeProcessEClass.getESuperTypes().add(theProcessPackage.getAbstractProcess());
		EGenericType g1 = createEGenericType(theProcessPackage.getVkPipeline());
		computePipelineEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theMaintainerPackage.getMaintainable());
		EGenericType g2 = createEGenericType(this.getComputePipeline());
		g1.getETypeArguments().add(g2);
		computePipelineEClass.getEGenericSuperTypes().add(g1);
		dispatchTaskEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());

		// Initialize classes, features, and operations; add parameters
		initEClass(computeProcessEClass, ComputeProcess.class, "ComputeProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputeProcess_PipelinePkg(), theProcessPackage.getPipelinePkg(), null, "pipelinePkg", null, 0, 1, ComputeProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputeProcess_SourceEngine(), theApplicationPackage.getIEngine(), null, "sourceEngine", null, 0, 1, ComputeProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computePipelineEClass, ComputePipeline.class, "ComputePipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputePipeline_Shader(), theVulkanResourcePackage.getShader(), null, "shader", null, 0, 1, ComputePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dispatchTaskEClass, DispatchTask.class, "DispatchTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDispatchTask_WorkgroupCountX(), ecorePackage.getEInt(), "workgroupCountX", "1", 0, 1, DispatchTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDispatchTask_WorkgroupCountY(), ecorePackage.getEInt(), "workgroupCountY", "1", 0, 1, DispatchTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDispatchTask_WorkgroupCountZ(), ecorePackage.getEInt(), "workgroupCountZ", "1", 0, 1, DispatchTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ComputePackageImpl
