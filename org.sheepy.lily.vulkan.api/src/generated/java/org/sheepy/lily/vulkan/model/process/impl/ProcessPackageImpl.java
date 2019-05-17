/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.Configuration;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.IProcessPart;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPartPkg;
import org.sheepy.lily.vulkan.model.process.PushBufferTask;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.enumeration.EnumerationPackage;
import org.sheepy.vulkan.model.pipeline.PipelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessPackageImpl extends EPackageImpl implements ProcessPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processPartPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPipelineTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iProcessPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineBarrierEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iPipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pipelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindDescriptorSetsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushBufferTaskEClass = null;

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
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProcessPackageImpl()
	{
		super(eNS_URI, ProcessFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProcessPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProcessPackage init()
	{
		if (isInited)
			return (ProcessPackage) EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredProcessPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ProcessPackageImpl theProcessPackage = registeredProcessPackage instanceof ProcessPackageImpl
				? (ProcessPackageImpl) registeredProcessPackage
				: new ProcessPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		VulkanPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		ResourcePackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();
		RootPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProcessPackage.createPackageContents();

		// Initialize created meta-data
		theProcessPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProcessPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProcessPackage.eNS_URI, theProcessPackage);
		return theProcessPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractProcess()
	{
		return abstractProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractProcess_WaitingFenceDuringAcquire()
	{
		return (EAttribute) abstractProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractProcess_DescriptorSetPkg()
	{
		return (EReference) abstractProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractProcess_PartPkg()
	{
		return (EReference) abstractProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractProcess_ResetAllowed()
	{
		return (EAttribute) abstractProcessEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractProcess_Signals()
	{
		return (EReference) abstractProcessEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractProcess_WaitFor()
	{
		return (EReference) abstractProcessEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfiguration()
	{
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProcessPartPkg()
	{
		return processPartPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProcessPartPkg_Parts()
	{
		return (EReference) processPartPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPipelineTask()
	{
		return iPipelineTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPipelineTask_Enabled()
	{
		return (EAttribute) iPipelineTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIProcessPart()
	{
		return iProcessPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPipelineBarrier()
	{
		return pipelineBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineBarrier_Barriers()
	{
		return (EReference) pipelineBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPipelineBarrier_SrcStage()
	{
		return (EAttribute) pipelineBarrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPipelineBarrier_DstStage()
	{
		return (EAttribute) pipelineBarrierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineBarrier_SrcQueue()
	{
		return (EReference) pipelineBarrierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPipelineBarrier_DstQueue()
	{
		return (EReference) pipelineBarrierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeTask()
	{
		return compositeTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCompositeTask_RepeatCount()
	{
		return (EAttribute) compositeTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeTask_Tasks()
	{
		return (EReference) compositeTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIPipeline()
	{
		return iPipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPipeline_Enabled()
	{
		return (EAttribute) iPipelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIPipeline_Stage()
	{
		return (EAttribute) iPipelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIPipeline_PushConstantRanges()
	{
		return (EReference) iPipelineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIPipeline_DescriptorSetRef()
	{
		return (EReference) iPipelineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIPipeline_DescriptorSet()
	{
		return (EReference) iPipelineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIPipeline_TaskPkg()
	{
		return (EReference) iPipelineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTaskPkg()
	{
		return taskPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTaskPkg_Tasks()
	{
		return (EReference) taskPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPipeline()
	{
		return pipelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBindDescriptorSets()
	{
		return bindDescriptorSetsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBindDescriptorSets_Index()
	{
		return (EAttribute) bindDescriptorSetsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPushConstant()
	{
		return pushConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushConstant_Stages()
	{
		return (EAttribute) pushConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPushConstant_Data()
	{
		return (EAttribute) pushConstantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPushBufferTask()
	{
		return pushBufferTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPushBufferTask_PushBuffer()
	{
		return (EReference) pushBufferTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessFactory getProcessFactory()
	{
		return (ProcessFactory) getEFactoryInstance();
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
		abstractProcessEClass = createEClass(ABSTRACT_PROCESS);
		createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__DESCRIPTOR_SET_PKG);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__PART_PKG);
		createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__RESET_ALLOWED);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__SIGNALS);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__WAIT_FOR);

		configurationEClass = createEClass(CONFIGURATION);

		processPartPkgEClass = createEClass(PROCESS_PART_PKG);
		createEReference(processPartPkgEClass, PROCESS_PART_PKG__PARTS);

		iPipelineTaskEClass = createEClass(IPIPELINE_TASK);
		createEAttribute(iPipelineTaskEClass, IPIPELINE_TASK__ENABLED);

		iProcessPartEClass = createEClass(IPROCESS_PART);

		iPipelineEClass = createEClass(IPIPELINE);
		createEAttribute(iPipelineEClass, IPIPELINE__ENABLED);
		createEAttribute(iPipelineEClass, IPIPELINE__STAGE);
		createEReference(iPipelineEClass, IPIPELINE__PUSH_CONSTANT_RANGES);
		createEReference(iPipelineEClass, IPIPELINE__DESCRIPTOR_SET_REF);
		createEReference(iPipelineEClass, IPIPELINE__DESCRIPTOR_SET);
		createEReference(iPipelineEClass, IPIPELINE__TASK_PKG);

		taskPkgEClass = createEClass(TASK_PKG);
		createEReference(taskPkgEClass, TASK_PKG__TASKS);

		pipelineEClass = createEClass(PIPELINE);

		pipelineBarrierEClass = createEClass(PIPELINE_BARRIER);
		createEReference(pipelineBarrierEClass, PIPELINE_BARRIER__BARRIERS);
		createEAttribute(pipelineBarrierEClass, PIPELINE_BARRIER__SRC_STAGE);
		createEAttribute(pipelineBarrierEClass, PIPELINE_BARRIER__DST_STAGE);
		createEReference(pipelineBarrierEClass, PIPELINE_BARRIER__SRC_QUEUE);
		createEReference(pipelineBarrierEClass, PIPELINE_BARRIER__DST_QUEUE);

		compositeTaskEClass = createEClass(COMPOSITE_TASK);
		createEAttribute(compositeTaskEClass, COMPOSITE_TASK__REPEAT_COUNT);
		createEReference(compositeTaskEClass, COMPOSITE_TASK__TASKS);

		bindDescriptorSetsEClass = createEClass(BIND_DESCRIPTOR_SETS);
		createEAttribute(bindDescriptorSetsEClass, BIND_DESCRIPTOR_SETS__INDEX);

		pushConstantEClass = createEClass(PUSH_CONSTANT);
		createEAttribute(pushConstantEClass, PUSH_CONSTANT__STAGES);
		createEAttribute(pushConstantEClass, PUSH_CONSTANT__DATA);

		pushBufferTaskEClass = createEClass(PUSH_BUFFER_TASK);
		createEReference(pushBufferTaskEClass, PUSH_BUFFER_TASK__PUSH_BUFFER);
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
		VulkanPackage theVulkanPackage = (VulkanPackage) EPackage.Registry.INSTANCE
				.getEPackage(VulkanPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		ResourcePackage theResourcePackage = (ResourcePackage) EPackage.Registry.INSTANCE
				.getEPackage(ResourcePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE
				.getEPackage(TypesPackage.eNS_URI);
		EnumerationPackage theEnumerationPackage = (EnumerationPackage) EPackage.Registry.INSTANCE
				.getEPackage(EnumerationPackage.eNS_URI);
		PipelinePackage thePipelinePackage = (PipelinePackage) EPackage.Registry.INSTANCE
				.getEPackage(PipelinePackage.eNS_URI);
		RootPackage theRootPackage = (RootPackage) EPackage.Registry.INSTANCE
				.getEPackage(RootPackage.eNS_URI);
		BarrierPackage theBarrierPackage = (BarrierPackage) EPackage.Registry.INSTANCE
				.getEPackage(BarrierPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractProcessEClass.getESuperTypes().add(theVulkanPackage.getIProcess());
		iPipelineTaskEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iPipelineEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iPipelineEClass.getESuperTypes().add(theVulkanPackage.getIResourceContainer());
		iPipelineEClass.getESuperTypes().add(this.getIProcessPart());
		pipelineEClass.getESuperTypes().add(this.getIPipeline());
		pipelineBarrierEClass.getESuperTypes().add(theRootPackage.getLObject());
		pipelineBarrierEClass.getESuperTypes().add(this.getIPipelineTask());
		compositeTaskEClass.getESuperTypes().add(this.getIPipelineTask());
		bindDescriptorSetsEClass.getESuperTypes().add(this.getIPipelineTask());
		pushConstantEClass.getESuperTypes().add(this.getIPipelineTask());
		pushBufferTaskEClass.getESuperTypes().add(this.getIPipelineTask());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractProcessEClass, AbstractProcess.class, "AbstractProcess", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractProcess_WaitingFenceDuringAcquire(),
				theEcorePackage.getEBoolean(), "waitingFenceDuringAcquire", "false", 0, 1,
				AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_DescriptorSetPkg(),
				theResourcePackage.getDescriptorSetPkg(), null, "descriptorSetPkg", null, 0, 1,
				AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_PartPkg(), this.getProcessPartPkg(), null, "partPkg",
				null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getAbstractProcess_ResetAllowed(), theEcorePackage.getEBoolean(),
				"resetAllowed", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_Signals(), theResourcePackage.getSemaphore(), null,
				"signals", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_WaitFor(), theResourcePackage.getSemaphore(), null,
				"waitFor", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processPartPkgEClass, ProcessPartPkg.class, "ProcessPartPkg", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessPartPkg_Parts(), this.getIProcessPart(), null, "parts", null, 0,
				-1, ProcessPartPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iPipelineTaskEClass, IPipelineTask.class, "IPipelineTask", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIPipelineTask_Enabled(), theEcorePackage.getEBoolean(), "enabled", "true",
				0, 1, IPipelineTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iProcessPartEClass, IProcessPart.class, "IProcessPart", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iPipelineEClass, IPipeline.class, "IPipeline", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIPipeline_Enabled(), theEcorePackage.getEBoolean(), "enabled", "true", 0,
				1, IPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIPipeline_Stage(), theEnumerationPackage.getECommandStage(), "stage",
				"Render", 0, 1, IPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIPipeline_PushConstantRanges(), thePipelinePackage.getPushConstantRange(),
				null, "pushConstantRanges", null, 0, -1, IPipeline.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIPipeline_DescriptorSetRef(), theResourcePackage.getDescriptorSet(), null,
				"descriptorSetRef", null, 0, 1, IPipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getIPipeline_DescriptorSet(), theResourcePackage.getDescriptorSet(), null,
				"descriptorSet", null, 0, 1, IPipeline.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getIPipeline_TaskPkg(), this.getTaskPkg(), null, "taskPkg", null, 0, 1,
				IPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskPkgEClass, TaskPkg.class, "TaskPkg", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskPkg_Tasks(), this.getIPipelineTask(), null, "tasks", null, 0, -1,
				TaskPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pipelineEClass, Pipeline.class, "Pipeline", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(pipelineBarrierEClass, PipelineBarrier.class, "PipelineBarrier", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPipelineBarrier_Barriers(), theBarrierPackage.getBarrier(), null,
				"barriers", null, 1, -1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipelineBarrier_SrcStage(), theEnumerationPackage.getEPipelineStage(),
				"srcStage", null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPipelineBarrier_DstStage(), theEnumerationPackage.getEPipelineStage(),
				"dstStage", null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPipelineBarrier_SrcQueue(), this.getAbstractProcess(), null, "srcQueue",
				null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getPipelineBarrier_DstQueue(), this.getAbstractProcess(), null, "dstQueue",
				null, 0, 1, PipelineBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(compositeTaskEClass, CompositeTask.class, "CompositeTask", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeTask_RepeatCount(), theEcorePackage.getEInt(), "repeatCount",
				"1", 0, 1, CompositeTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeTask_Tasks(), this.getIPipelineTask(), null, "tasks", null, 0,
				-1, CompositeTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindDescriptorSetsEClass, BindDescriptorSets.class, "BindDescriptorSets",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindDescriptorSets_Index(), theEcorePackage.getEInt(), "index", "0", 0, 1,
				BindDescriptorSets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pushConstantEClass, PushConstant.class, "PushConstant", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPushConstant_Stages(), theEnumerationPackage.getEShaderStage(), "stages",
				null, 1, -1, PushConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPushConstant_Data(), theResourcePackage.getByteBuffer(), "data", null, 0,
				1, PushConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pushBufferTaskEClass, PushBufferTask.class, "PushBufferTask", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPushBufferTask_PushBuffer(), theResourcePackage.getPushBuffer(), null,
				"pushBuffer", null, 1, 1, PushBufferTask.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ProcessPackageImpl
