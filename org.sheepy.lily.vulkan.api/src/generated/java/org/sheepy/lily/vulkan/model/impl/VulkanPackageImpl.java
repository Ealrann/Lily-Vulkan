/**
 */
package org.sheepy.lily.vulkan.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
import org.sheepy.lily.vulkan.model.DescriptorPkg;
import org.sheepy.lily.vulkan.model.IDescriptor;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.MouseLocation;
import org.sheepy.lily.vulkan.model.RunProcess;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.WaitProcessIdle;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl;
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
public class VulkanPackageImpl extends EPackageImpl implements VulkanPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vulkanEngineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iResourceContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vulkanResourcePkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iVulkanResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitProcessIdleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptorPkgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mouseLocationEClass = null;

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
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#eNS_URI
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

		// Initialize simple dependencies
		ResourcePackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();
		VariablePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		PresentationPackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		BarrierPackage.eINSTANCE.eClass();
		EnumerationPackage.eINSTANCE.eClass();
		GraphicpipelinePackage.eINSTANCE.eClass();
		ImagePackage.eINSTANCE.eClass();
		PipelinePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ComputePackage.eNS_URI);
		ComputePackageImpl theComputePackage = (ComputePackageImpl)(registeredPackage instanceof ComputePackageImpl ? registeredPackage : ComputePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GraphicPackage.eNS_URI);
		GraphicPackageImpl theGraphicPackage = (GraphicPackageImpl)(registeredPackage instanceof GraphicPackageImpl ? registeredPackage : GraphicPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(registeredPackage instanceof ProcessPackageImpl ? registeredPackage : ProcessPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanResourcePackage.eNS_URI);
		VulkanResourcePackageImpl theVulkanResourcePackage = (VulkanResourcePackageImpl)(registeredPackage instanceof VulkanResourcePackageImpl ? registeredPackage : VulkanResourcePackage.eINSTANCE);

		// Create package meta-data objects
		theVulkanPackage.createPackageContents();
		theComputePackage.createPackageContents();
		theGraphicPackage.createPackageContents();
		theProcessPackage.createPackageContents();
		theVulkanResourcePackage.createPackageContents();

		// Initialize created meta-data
		theVulkanPackage.initializePackageContents();
		theComputePackage.initializePackageContents();
		theGraphicPackage.initializePackageContents();
		theProcessPackage.initializePackageContents();
		theVulkanResourcePackage.initializePackageContents();

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
	@Override
	public EClass getVulkanEngine()
	{
		return vulkanEngineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVulkanEngine_Enabled()
	{
		return (EAttribute)vulkanEngineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVulkanEngine_Processes()
	{
		return (EReference)vulkanEngineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVulkanEngine_Features()
	{
		return (EAttribute)vulkanEngineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIResourceContainer()
	{
		return iResourceContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIResourceContainer_VulkanResourcePkg()
	{
		return (EReference)iResourceContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIResourceContainer_DescriptorPkg()
	{
		return (EReference)iResourceContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVulkanResourcePkg()
	{
		return vulkanResourcePkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVulkanResourcePkg_Resources()
	{
		return (EReference)vulkanResourcePkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIVulkanResource()
	{
		return iVulkanResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIProcess()
	{
		return iProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIProcess_Enabled()
	{
		return (EAttribute)iProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIProcess_QueuePriority()
	{
		return (EAttribute)iProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIProcess_Cadence()
	{
		return (EReference)iProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRunProcess()
	{
		return runProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRunProcess_Process()
	{
		return (EReference)runProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWaitProcessIdle()
	{
		return waitProcessIdleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getWaitProcessIdle_Process()
	{
		return (EReference)waitProcessIdleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptorPkg()
	{
		return descriptorPkgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDescriptorPkg_Descriptors()
	{
		return (EReference)descriptorPkgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDescriptor()
	{
		return iDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIDescriptor_Type()
	{
		return (EAttribute)iDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIDescriptor_ShaderStages()
	{
		return (EAttribute)iDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMouseLocation()
	{
		return mouseLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMouseLocation_VulkanEngine()
	{
		return (EReference)mouseLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		vulkanEngineEClass = createEClass(VULKAN_ENGINE);
		createEAttribute(vulkanEngineEClass, VULKAN_ENGINE__ENABLED);
		createEReference(vulkanEngineEClass, VULKAN_ENGINE__PROCESSES);
		createEAttribute(vulkanEngineEClass, VULKAN_ENGINE__FEATURES);

		iResourceContainerEClass = createEClass(IRESOURCE_CONTAINER);
		createEReference(iResourceContainerEClass, IRESOURCE_CONTAINER__VULKAN_RESOURCE_PKG);
		createEReference(iResourceContainerEClass, IRESOURCE_CONTAINER__DESCRIPTOR_PKG);

		vulkanResourcePkgEClass = createEClass(VULKAN_RESOURCE_PKG);
		createEReference(vulkanResourcePkgEClass, VULKAN_RESOURCE_PKG__RESOURCES);

		iVulkanResourceEClass = createEClass(IVULKAN_RESOURCE);

		iProcessEClass = createEClass(IPROCESS);
		createEAttribute(iProcessEClass, IPROCESS__ENABLED);
		createEAttribute(iProcessEClass, IPROCESS__QUEUE_PRIORITY);
		createEReference(iProcessEClass, IPROCESS__CADENCE);

		runProcessEClass = createEClass(RUN_PROCESS);
		createEReference(runProcessEClass, RUN_PROCESS__PROCESS);

		waitProcessIdleEClass = createEClass(WAIT_PROCESS_IDLE);
		createEReference(waitProcessIdleEClass, WAIT_PROCESS_IDLE__PROCESS);

		descriptorPkgEClass = createEClass(DESCRIPTOR_PKG);
		createEReference(descriptorPkgEClass, DESCRIPTOR_PKG__DESCRIPTORS);

		iDescriptorEClass = createEClass(IDESCRIPTOR);
		createEAttribute(iDescriptorEClass, IDESCRIPTOR__TYPE);
		createEAttribute(iDescriptorEClass, IDESCRIPTOR__SHADER_STAGES);

		mouseLocationEClass = createEClass(MOUSE_LOCATION);
		createEReference(mouseLocationEClass, MOUSE_LOCATION__VULKAN_ENGINE);
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
		EnumerationPackage theEnumerationPackage = (EnumerationPackage)EPackage.Registry.INSTANCE.getEPackage(EnumerationPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		CadencePackage theCadencePackage = (CadencePackage)EPackage.Registry.INSTANCE.getEPackage(CadencePackage.eNS_URI);
		VariablePackage theVariablePackage = (VariablePackage)EPackage.Registry.INSTANCE.getEPackage(VariablePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		vulkanEngineEClass.getESuperTypes().add(theApplicationPackage.getIEngine());
		vulkanEngineEClass.getESuperTypes().add(this.getIResourceContainer());
		iVulkanResourceEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iProcessEClass.getESuperTypes().add(this.getIResourceContainer());
		iProcessEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		runProcessEClass.getESuperTypes().add(theCadencePackage.getICadenceTask());
		waitProcessIdleEClass.getESuperTypes().add(theCadencePackage.getICadenceTask());
		iDescriptorEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		mouseLocationEClass.getESuperTypes().add(theVariablePackage.getIModelVariable());

		// Initialize classes, features, and operations; add parameters
		initEClass(vulkanEngineEClass, VulkanEngine.class, "VulkanEngine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVulkanEngine_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, VulkanEngine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVulkanEngine_Processes(), this.getIProcess(), null, "processes", null, 0, -1, VulkanEngine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVulkanEngine_Features(), theEnumerationPackage.getEPhysicalDeviceFeature(), "features", null, 0, -1, VulkanEngine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iResourceContainerEClass, IResourceContainer.class, "IResourceContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIResourceContainer_VulkanResourcePkg(), this.getVulkanResourcePkg(), null, "vulkanResourcePkg", null, 0, 1, IResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIResourceContainer_DescriptorPkg(), this.getDescriptorPkg(), null, "descriptorPkg", null, 0, 1, IResourceContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vulkanResourcePkgEClass, VulkanResourcePkg.class, "VulkanResourcePkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVulkanResourcePkg_Resources(), this.getIVulkanResource(), null, "resources", null, 0, -1, VulkanResourcePkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iVulkanResourceEClass, IVulkanResource.class, "IVulkanResource", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iProcessEClass, IProcess.class, "IProcess", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIProcess_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, IProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIProcess_QueuePriority(), ecorePackage.getEFloat(), "queuePriority", "1.0", 1, 1, IProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIProcess_Cadence(), theApplicationPackage.getICadence(), null, "cadence", null, 0, 1, IProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runProcessEClass, RunProcess.class, "RunProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRunProcess_Process(), this.getIProcess(), null, "process", null, 1, 1, RunProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waitProcessIdleEClass, WaitProcessIdle.class, "WaitProcessIdle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWaitProcessIdle_Process(), this.getIProcess(), null, "process", null, 1, 1, WaitProcessIdle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptorPkgEClass, DescriptorPkg.class, "DescriptorPkg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptorPkg_Descriptors(), this.getIDescriptor(), null, "descriptors", null, 0, -1, DescriptorPkg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iDescriptorEClass, IDescriptor.class, "IDescriptor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIDescriptor_Type(), theEnumerationPackage.getEDescriptorType(), "type", null, 1, 1, IDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIDescriptor_ShaderStages(), theEnumerationPackage.getEShaderStage(), "shaderStages", null, 1, -1, IDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mouseLocationEClass, MouseLocation.class, "MouseLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMouseLocation_VulkanEngine(), this.getVulkanEngine(), null, "vulkanEngine", null, 1, 1, MouseLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //VulkanPackageImpl
