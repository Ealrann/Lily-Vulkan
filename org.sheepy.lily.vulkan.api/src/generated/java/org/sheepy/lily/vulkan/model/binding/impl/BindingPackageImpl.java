/**
 */
package org.sheepy.lily.vulkan.model.binding.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sheepy.lily.core.model.action.ActionPackage;

import org.sheepy.lily.core.model.application.ApplicationPackage;

import org.sheepy.lily.core.model.cadence.CadencePackage;

import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.binding.BindingConfiguration;
import org.sheepy.lily.vulkan.model.binding.BindingFactory;
import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.ConfigureBind;
import org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.binding.EInstance;
import org.sheepy.lily.vulkan.model.binding.IConfigurationTask;
import org.sheepy.lily.vulkan.model.binding.IContextConfiguration;
import org.sheepy.lily.vulkan.model.binding.IndexConfiguration;
import org.sheepy.lily.vulkan.model.binding.RotateConfiguration;

import org.sheepy.lily.vulkan.model.impl.VulkanPackageImpl;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;

import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePackageImpl;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicPackageImpl;

import org.sheepy.lily.vulkan.model.process.impl.ProcessPackageImpl;

import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

import org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl;

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
public class BindingPackageImpl extends EPackageImpl implements BindingPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configureBindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rotateConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iConfigurationTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurePrepareCompositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configureCompositeBufferBarrierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iContextConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eInstanceEEnum = null;

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
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BindingPackageImpl()
	{
		super(eNS_URI, BindingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BindingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BindingPackage init()
	{
		if (isInited) return (BindingPackage)EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBindingPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BindingPackageImpl theBindingPackage = registeredBindingPackage instanceof BindingPackageImpl ? (BindingPackageImpl)registeredBindingPackage : new BindingPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();
		ActionPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		InferencePackage.eINSTANCE.eClass();
		MaintainerPackage.eINSTANCE.eClass();
		CadencePackage.eINSTANCE.eClass();
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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		ResourcePackageImpl theResourcePackage = (ResourcePackageImpl)(registeredPackage instanceof ResourcePackageImpl ? registeredPackage : ResourcePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VulkanPackage.eNS_URI);
		VulkanPackageImpl theVulkanPackage = (VulkanPackageImpl)(registeredPackage instanceof VulkanPackageImpl ? registeredPackage : VulkanPackage.eINSTANCE);

		// Create package meta-data objects
		theBindingPackage.createPackageContents();
		theComputePackage.createPackageContents();
		theGraphicPackage.createPackageContents();
		theProcessPackage.createPackageContents();
		theResourcePackage.createPackageContents();
		theVulkanPackage.createPackageContents();

		// Initialize created meta-data
		theBindingPackage.initializePackageContents();
		theComputePackage.initializePackageContents();
		theGraphicPackage.initializePackageContents();
		theProcessPackage.initializePackageContents();
		theResourcePackage.initializePackageContents();
		theVulkanPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBindingPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BindingPackage.eNS_URI, theBindingPackage);
		return theBindingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBindingConfiguration()
	{
		return bindingConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindingConfiguration_DescriptorsSets()
	{
		return (EReference)bindingConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBindingConfiguration_DescriptorSetStride()
	{
		return (EAttribute)bindingConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfigureBind()
	{
		return configureBindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConfigureBind_BindTask()
	{
		return (EReference)configureBindEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRotateConfiguration()
	{
		return rotateConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRotateConfiguration_Configurations()
	{
		return (EReference)rotateConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRotateConfiguration_ForceRecord()
	{
		return (EAttribute)rotateConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIConfigurationTask()
	{
		return iConfigurationTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfigurePrepareComposite()
	{
		return configurePrepareCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConfigurePrepareComposite_References()
	{
		return (EReference)configurePrepareCompositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfigurePrepareComposite_TargetInstance()
	{
		return (EAttribute)configurePrepareCompositeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfigureCompositeBufferBarrier()
	{
		return configureCompositeBufferBarrierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConfigureCompositeBufferBarrier_Barriers()
	{
		return (EReference)configureCompositeBufferBarrierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfigureCompositeBufferBarrier_TargetInstance()
	{
		return (EAttribute)configureCompositeBufferBarrierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIContextConfiguration()
	{
		return iContextConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIContextConfiguration_Tasks()
	{
		return (EReference)iContextConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIndexConfiguration()
	{
		return indexConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIndexConfiguration_IndexCount()
	{
		return (EAttribute)indexConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEInstance()
	{
		return eInstanceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingFactory getBindingFactory()
	{
		return (BindingFactory)getEFactoryInstance();
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
		bindingConfigurationEClass = createEClass(BINDING_CONFIGURATION);
		createEReference(bindingConfigurationEClass, BINDING_CONFIGURATION__DESCRIPTORS_SETS);
		createEAttribute(bindingConfigurationEClass, BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE);

		configureBindEClass = createEClass(CONFIGURE_BIND);
		createEReference(configureBindEClass, CONFIGURE_BIND__BIND_TASK);

		rotateConfigurationEClass = createEClass(ROTATE_CONFIGURATION);
		createEReference(rotateConfigurationEClass, ROTATE_CONFIGURATION__CONFIGURATIONS);
		createEAttribute(rotateConfigurationEClass, ROTATE_CONFIGURATION__FORCE_RECORD);

		iConfigurationTaskEClass = createEClass(ICONFIGURATION_TASK);

		configurePrepareCompositeEClass = createEClass(CONFIGURE_PREPARE_COMPOSITE);
		createEReference(configurePrepareCompositeEClass, CONFIGURE_PREPARE_COMPOSITE__REFERENCES);
		createEAttribute(configurePrepareCompositeEClass, CONFIGURE_PREPARE_COMPOSITE__TARGET_INSTANCE);

		configureCompositeBufferBarrierEClass = createEClass(CONFIGURE_COMPOSITE_BUFFER_BARRIER);
		createEReference(configureCompositeBufferBarrierEClass, CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIERS);
		createEAttribute(configureCompositeBufferBarrierEClass, CONFIGURE_COMPOSITE_BUFFER_BARRIER__TARGET_INSTANCE);

		iContextConfigurationEClass = createEClass(ICONTEXT_CONFIGURATION);
		createEReference(iContextConfigurationEClass, ICONTEXT_CONFIGURATION__TASKS);

		indexConfigurationEClass = createEClass(INDEX_CONFIGURATION);
		createEAttribute(indexConfigurationEClass, INDEX_CONFIGURATION__INDEX_COUNT);

		// Create enums
		eInstanceEEnum = createEEnum(EINSTANCE);
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
		ResourcePackage theResourcePackage = (ResourcePackage)EPackage.Registry.INSTANCE.getEPackage(ResourcePackage.eNS_URI);
		ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bindingConfigurationEClass.getESuperTypes().add(this.getIContextConfiguration());
		configureBindEClass.getESuperTypes().add(this.getIConfigurationTask());
		rotateConfigurationEClass.getESuperTypes().add(theProcessPackage.getIPipelineTask());
		iConfigurationTaskEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		configurePrepareCompositeEClass.getESuperTypes().add(this.getIConfigurationTask());
		configureCompositeBufferBarrierEClass.getESuperTypes().add(this.getIConfigurationTask());
		iContextConfigurationEClass.getESuperTypes().add(theTypesPackage.getLNamedElement());
		iContextConfigurationEClass.getESuperTypes().add(theProcessPackage.getIProcessExtension());
		indexConfigurationEClass.getESuperTypes().add(this.getIContextConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(bindingConfigurationEClass, BindingConfiguration.class, "BindingConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingConfiguration_DescriptorsSets(), theResourcePackage.getDescriptorSet(), null, "descriptorsSets", null, 1, -1, BindingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindingConfiguration_DescriptorSetStride(), ecorePackage.getEInt(), "descriptorSetStride", "0", 1, 1, BindingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configureBindEClass, ConfigureBind.class, "ConfigureBind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigureBind_BindTask(), theProcessPackage.getBindDescriptorSets(), null, "bindTask", null, 1, 1, ConfigureBind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rotateConfigurationEClass, RotateConfiguration.class, "RotateConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRotateConfiguration_Configurations(), this.getIContextConfiguration(), null, "configurations", null, 1, -1, RotateConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRotateConfiguration_ForceRecord(), ecorePackage.getEBoolean(), "forceRecord", "false", 1, 1, RotateConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iConfigurationTaskEClass, IConfigurationTask.class, "IConfigurationTask", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(configurePrepareCompositeEClass, ConfigurePrepareComposite.class, "ConfigurePrepareComposite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurePrepareComposite_References(), theResourcePackage.getCompositePartReference(), null, "references", null, 1, -1, ConfigurePrepareComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurePrepareComposite_TargetInstance(), this.getEInstance(), "targetInstance", null, 1, 1, ConfigurePrepareComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configureCompositeBufferBarrierEClass, ConfigureCompositeBufferBarrier.class, "ConfigureCompositeBufferBarrier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigureCompositeBufferBarrier_Barriers(), theResourcePackage.getCompositeBufferBarrier(), null, "barriers", null, 1, -1, ConfigureCompositeBufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigureCompositeBufferBarrier_TargetInstance(), this.getEInstance(), "targetInstance", null, 1, 1, ConfigureCompositeBufferBarrier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iContextConfigurationEClass, IContextConfiguration.class, "IContextConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIContextConfiguration_Tasks(), this.getIConfigurationTask(), null, "tasks", null, 0, -1, IContextConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexConfigurationEClass, IndexConfiguration.class, "IndexConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexConfiguration_IndexCount(), ecorePackage.getEInt(), "indexCount", "2", 1, 1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eInstanceEEnum, EInstance.class, "EInstance");
		addEEnumLiteral(eInstanceEEnum, EInstance.CONTEXT_INSTANCE);
		addEEnumLiteral(eInstanceEEnum, EInstance.CONTEXT_INSTANCE_PLUS_ONE);
		addEEnumLiteral(eInstanceEEnum, EInstance.CONTEXT_INSTANCE_MINUS_ONE);

		// Create resource
		createResource(eNS_URI);
	}

} //BindingPackageImpl
