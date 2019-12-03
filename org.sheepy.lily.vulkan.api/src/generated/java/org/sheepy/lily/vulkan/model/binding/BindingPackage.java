/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.binding.BindingFactory
 * @model kind="package"
 * @generated
 */
public interface BindingPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "binding";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.model.binding";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "binding";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BindingPackage eINSTANCE = org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.impl.BindingConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingConfigurationImpl
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getBindingConfiguration()
	 * @generated
	 */
	int BINDING_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Descriptors Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION__DESCRIPTORS_SETS = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Set Stride</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION__TASKS = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.IConfigurationTask <em>IConfiguration Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.IConfigurationTask
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getIConfigurationTask()
	 * @generated
	 */
	int ICONFIGURATION_TASK = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONFIGURATION_TASK__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>IConfiguration Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONFIGURATION_TASK_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IConfiguration Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONFIGURATION_TASK_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureBindImpl <em>Configure Bind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigureBindImpl
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigureBind()
	 * @generated
	 */
	int CONFIGURE_BIND = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BIND__NAME = ICONFIGURATION_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Bind Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BIND__BIND_TASK = ICONFIGURATION_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Configure Bind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BIND_FEATURE_COUNT = ICONFIGURATION_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Configure Bind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BIND_OPERATION_COUNT = ICONFIGURATION_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.impl.RotateConfigurationImpl <em>Rotate Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.impl.RotateConfigurationImpl
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getRotateConfiguration()
	 * @generated
	 */
	int ROTATE_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE_CONFIGURATION__NAME = ProcessPackage.IPIPELINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE_CONFIGURATION__ENABLED = ProcessPackage.IPIPELINE_TASK__ENABLED;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE_CONFIGURATION__CONFIGURATIONS = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Force Record</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE_CONFIGURATION__FORCE_RECORD = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rotate Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE_CONFIGURATION_FEATURE_COUNT = ProcessPackage.IPIPELINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Rotate Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATE_CONFIGURATION_OPERATION_COUNT = ProcessPackage.IPIPELINE_TASK_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigurePrepareCompositeImpl <em>Configure Prepare Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigurePrepareCompositeImpl
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigurePrepareComposite()
	 * @generated
	 */
	int CONFIGURE_PREPARE_COMPOSITE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE__NAME = ICONFIGURATION_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Prepare Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE__PREPARE_TASK = ICONFIGURATION_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE__TARGET_INSTANCE = ICONFIGURATION_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Configure Prepare Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE_FEATURE_COUNT = ICONFIGURATION_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Configure Prepare Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE_OPERATION_COUNT = ICONFIGURATION_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl <em>Configure Composite Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigureCompositeBufferBarrier()
	 * @generated
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER__NAME = ICONFIGURATION_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Barrier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIER = ICONFIGURATION_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER__TARGET_INSTANCE = ICONFIGURATION_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Configure Composite Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER_FEATURE_COUNT = ICONFIGURATION_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Configure Composite Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER_OPERATION_COUNT = ICONFIGURATION_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.EInstance <em>EInstance</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.EInstance
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getEInstance()
	 * @generated
	 */
	int EINSTANCE = 6;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingConfiguration
	 * @generated
	 */
	EClass getBindingConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getDescriptorsSets <em>Descriptors Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors Sets</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getDescriptorsSets()
	 * @see #getBindingConfiguration()
	 * @generated
	 */
	EReference getBindingConfiguration_DescriptorsSets();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getDescriptorSetStride <em>Descriptor Set Stride</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descriptor Set Stride</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getDescriptorSetStride()
	 * @see #getBindingConfiguration()
	 * @generated
	 */
	EAttribute getBindingConfiguration_DescriptorSetStride();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getTasks()
	 * @see #getBindingConfiguration()
	 * @generated
	 */
	EReference getBindingConfiguration_Tasks();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBind <em>Configure Bind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configure Bind</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureBind
	 * @generated
	 */
	EClass getConfigureBind();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBind#getBindTask <em>Bind Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bind Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureBind#getBindTask()
	 * @see #getConfigureBind()
	 * @generated
	 */
	EReference getConfigureBind_BindTask();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration <em>Rotate Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rotate Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.RotateConfiguration
	 * @generated
	 */
	EClass getRotateConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Configurations</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.RotateConfiguration#getConfigurations()
	 * @see #getRotateConfiguration()
	 * @generated
	 */
	EReference getRotateConfiguration_Configurations();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration#isForceRecord <em>Force Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Force Record</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.RotateConfiguration#isForceRecord()
	 * @see #getRotateConfiguration()
	 * @generated
	 */
	EAttribute getRotateConfiguration_ForceRecord();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.IConfigurationTask <em>IConfiguration Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IConfiguration Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.IConfigurationTask
	 * @generated
	 */
	EClass getIConfigurationTask();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite <em>Configure Prepare Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configure Prepare Composite</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite
	 * @generated
	 */
	EClass getConfigurePrepareComposite();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getPrepareTask <em>Prepare Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prepare Task</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getPrepareTask()
	 * @see #getConfigurePrepareComposite()
	 * @generated
	 */
	EReference getConfigurePrepareComposite_PrepareTask();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getTargetInstance <em>Target Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Instance</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getTargetInstance()
	 * @see #getConfigurePrepareComposite()
	 * @generated
	 */
	EAttribute getConfigurePrepareComposite_TargetInstance();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier <em>Configure Composite Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configure Composite Buffer Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier
	 * @generated
	 */
	EClass getConfigureCompositeBufferBarrier();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getBarrier <em>Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getBarrier()
	 * @see #getConfigureCompositeBufferBarrier()
	 * @generated
	 */
	EReference getConfigureCompositeBufferBarrier_Barrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getTargetInstance <em>Target Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Instance</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getTargetInstance()
	 * @see #getConfigureCompositeBufferBarrier()
	 * @generated
	 */
	EAttribute getConfigureCompositeBufferBarrier_TargetInstance();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.vulkan.model.binding.EInstance <em>EInstance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EInstance</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.EInstance
	 * @generated
	 */
	EEnum getEInstance();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BindingFactory getBindingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.impl.BindingConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingConfigurationImpl
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getBindingConfiguration()
		 * @generated
		 */
		EClass BINDING_CONFIGURATION = eINSTANCE.getBindingConfiguration();

		/**
		 * The meta object literal for the '<em><b>Descriptors Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_CONFIGURATION__DESCRIPTORS_SETS = eINSTANCE.getBindingConfiguration_DescriptorsSets();

		/**
		 * The meta object literal for the '<em><b>Descriptor Set Stride</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE = eINSTANCE.getBindingConfiguration_DescriptorSetStride();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_CONFIGURATION__TASKS = eINSTANCE.getBindingConfiguration_Tasks();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureBindImpl <em>Configure Bind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigureBindImpl
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigureBind()
		 * @generated
		 */
		EClass CONFIGURE_BIND = eINSTANCE.getConfigureBind();

		/**
		 * The meta object literal for the '<em><b>Bind Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURE_BIND__BIND_TASK = eINSTANCE.getConfigureBind_BindTask();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.impl.RotateConfigurationImpl <em>Rotate Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.impl.RotateConfigurationImpl
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getRotateConfiguration()
		 * @generated
		 */
		EClass ROTATE_CONFIGURATION = eINSTANCE.getRotateConfiguration();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROTATE_CONFIGURATION__CONFIGURATIONS = eINSTANCE.getRotateConfiguration_Configurations();

		/**
		 * The meta object literal for the '<em><b>Force Record</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROTATE_CONFIGURATION__FORCE_RECORD = eINSTANCE.getRotateConfiguration_ForceRecord();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.IConfigurationTask <em>IConfiguration Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.IConfigurationTask
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getIConfigurationTask()
		 * @generated
		 */
		EClass ICONFIGURATION_TASK = eINSTANCE.getIConfigurationTask();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigurePrepareCompositeImpl <em>Configure Prepare Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigurePrepareCompositeImpl
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigurePrepareComposite()
		 * @generated
		 */
		EClass CONFIGURE_PREPARE_COMPOSITE = eINSTANCE.getConfigurePrepareComposite();

		/**
		 * The meta object literal for the '<em><b>Prepare Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURE_PREPARE_COMPOSITE__PREPARE_TASK = eINSTANCE.getConfigurePrepareComposite_PrepareTask();

		/**
		 * The meta object literal for the '<em><b>Target Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURE_PREPARE_COMPOSITE__TARGET_INSTANCE = eINSTANCE.getConfigurePrepareComposite_TargetInstance();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl <em>Configure Composite Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigureCompositeBufferBarrier()
		 * @generated
		 */
		EClass CONFIGURE_COMPOSITE_BUFFER_BARRIER = eINSTANCE.getConfigureCompositeBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Barrier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIER = eINSTANCE.getConfigureCompositeBufferBarrier_Barrier();

		/**
		 * The meta object literal for the '<em><b>Target Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURE_COMPOSITE_BUFFER_BARRIER__TARGET_INSTANCE = eINSTANCE.getConfigureCompositeBufferBarrier_TargetInstance();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.EInstance <em>EInstance</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.EInstance
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getEInstance()
		 * @generated
		 */
		EEnum EINSTANCE = eINSTANCE.getEInstance();

	}

} //BindingPackage
