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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.IContextConfiguration <em>IContext Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.IContextConfiguration
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getIContextConfiguration()
	 * @generated
	 */
	int ICONTEXT_CONFIGURATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTEXT_CONFIGURATION__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTEXT_CONFIGURATION__TASKS = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IContext Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTEXT_CONFIGURATION_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>IContext Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICONTEXT_CONFIGURATION_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

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
	int BINDING_CONFIGURATION__NAME = ICONTEXT_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION__TASKS = ICONTEXT_CONFIGURATION__TASKS;

	/**
	 * The feature id for the '<em><b>Descriptors Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION__DESCRIPTORS_SETS = ICONTEXT_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Set Stride</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE = ICONTEXT_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION_FEATURE_COUNT = ICONTEXT_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_CONFIGURATION_OPERATION_COUNT = ICONTEXT_CONFIGURATION_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Part Indices</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE__PART_INDICES = ICONFIGURATION_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE__COMPOSITE_BUFFER = ICONFIGURATION_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Configure Prepare Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE_FEATURE_COUNT = ICONFIGURATION_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Configure Prepare Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_PREPARE_COMPOSITE_OPERATION_COUNT = ICONFIGURATION_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureBufferDescriptorImpl <em>Configure Buffer Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigureBufferDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigureBufferDescriptor()
	 * @generated
	 */
	int CONFIGURE_BUFFER_DESCRIPTOR = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BUFFER_DESCRIPTOR__NAME = ICONFIGURATION_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BUFFER_DESCRIPTOR__COMPOSITE_BUFFER = ICONFIGURATION_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BUFFER_DESCRIPTOR__PART_INDEX = ICONFIGURATION_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BUFFER_DESCRIPTOR__DESCRIPTOR = ICONFIGURATION_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Configure Buffer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BUFFER_DESCRIPTOR_FEATURE_COUNT = ICONFIGURATION_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Configure Buffer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_BUFFER_DESCRIPTOR_OPERATION_COUNT = ICONFIGURATION_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl <em>Configure Composite Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigureCompositeBufferBarrier()
	 * @generated
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER = 6;

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
	 * The feature id for the '<em><b>Part Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER__PART_INDEX = ICONFIGURATION_TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER__COMPOSITE_BUFFER = ICONFIGURATION_TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Configure Composite Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER_FEATURE_COUNT = ICONFIGURATION_TASK_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Configure Composite Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURE_COMPOSITE_BUFFER_BARRIER_OPERATION_COUNT = ICONFIGURATION_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.impl.IndexConfigurationImpl <em>Index Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.impl.IndexConfigurationImpl
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getIndexConfiguration()
	 * @generated
	 */
	int INDEX_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CONFIGURATION__NAME = ICONTEXT_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CONFIGURATION__TASKS = ICONTEXT_CONFIGURATION__TASKS;

	/**
	 * The feature id for the '<em><b>Index Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CONFIGURATION__INDEX_COUNT = ICONTEXT_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Index Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CONFIGURATION_FEATURE_COUNT = ICONTEXT_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Index Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CONFIGURATION_OPERATION_COUNT = ICONTEXT_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.binding.EContextIndex <em>EContext Index</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.binding.EContextIndex
	 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getEContextIndex()
	 * @generated
	 */
	int ECONTEXT_INDEX = 9;

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
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getPartIndices <em>Part Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Part Indices</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getPartIndices()
	 * @see #getConfigurePrepareComposite()
	 * @generated
	 */
	EAttribute getConfigurePrepareComposite_PartIndices();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getCompositeBuffer <em>Composite Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getCompositeBuffer()
	 * @see #getConfigurePrepareComposite()
	 * @generated
	 */
	EReference getConfigurePrepareComposite_CompositeBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor <em>Configure Buffer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configure Buffer Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor
	 * @generated
	 */
	EClass getConfigureBufferDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getCompositeBuffer <em>Composite Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getCompositeBuffer()
	 * @see #getConfigureBufferDescriptor()
	 * @generated
	 */
	EReference getConfigureBufferDescriptor_CompositeBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getPartIndex <em>Part Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Index</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getPartIndex()
	 * @see #getConfigureBufferDescriptor()
	 * @generated
	 */
	EAttribute getConfigureBufferDescriptor_PartIndex();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor#getDescriptor()
	 * @see #getConfigureBufferDescriptor()
	 * @generated
	 */
	EReference getConfigureBufferDescriptor_Descriptor();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getPartIndex <em>Part Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Index</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getPartIndex()
	 * @see #getConfigureCompositeBufferBarrier()
	 * @generated
	 */
	EAttribute getConfigureCompositeBufferBarrier_PartIndex();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getCompositeBuffer <em>Composite Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getCompositeBuffer()
	 * @see #getConfigureCompositeBufferBarrier()
	 * @generated
	 */
	EReference getConfigureCompositeBufferBarrier_CompositeBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.IContextConfiguration <em>IContext Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IContext Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.IContextConfiguration
	 * @generated
	 */
	EClass getIContextConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.binding.IContextConfiguration#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.IContextConfiguration#getTasks()
	 * @see #getIContextConfiguration()
	 * @generated
	 */
	EReference getIContextConfiguration_Tasks();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.binding.IndexConfiguration <em>Index Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Configuration</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.IndexConfiguration
	 * @generated
	 */
	EClass getIndexConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.binding.IndexConfiguration#getIndexCount <em>Index Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.IndexConfiguration#getIndexCount()
	 * @see #getIndexConfiguration()
	 * @generated
	 */
	EAttribute getIndexConfiguration_IndexCount();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.vulkan.model.binding.EContextIndex <em>EContext Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EContext Index</em>'.
	 * @see org.sheepy.lily.vulkan.model.binding.EContextIndex
	 * @generated
	 */
	EEnum getEContextIndex();

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
		 * The meta object literal for the '<em><b>Part Indices</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURE_PREPARE_COMPOSITE__PART_INDICES = eINSTANCE.getConfigurePrepareComposite_PartIndices();

		/**
		 * The meta object literal for the '<em><b>Composite Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURE_PREPARE_COMPOSITE__COMPOSITE_BUFFER = eINSTANCE.getConfigurePrepareComposite_CompositeBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureBufferDescriptorImpl <em>Configure Buffer Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.impl.ConfigureBufferDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getConfigureBufferDescriptor()
		 * @generated
		 */
		EClass CONFIGURE_BUFFER_DESCRIPTOR = eINSTANCE.getConfigureBufferDescriptor();

		/**
		 * The meta object literal for the '<em><b>Composite Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURE_BUFFER_DESCRIPTOR__COMPOSITE_BUFFER = eINSTANCE.getConfigureBufferDescriptor_CompositeBuffer();

		/**
		 * The meta object literal for the '<em><b>Part Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURE_BUFFER_DESCRIPTOR__PART_INDEX = eINSTANCE.getConfigureBufferDescriptor_PartIndex();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURE_BUFFER_DESCRIPTOR__DESCRIPTOR = eINSTANCE.getConfigureBufferDescriptor_Descriptor();

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
		 * The meta object literal for the '<em><b>Part Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURE_COMPOSITE_BUFFER_BARRIER__PART_INDEX = eINSTANCE.getConfigureCompositeBufferBarrier_PartIndex();

		/**
		 * The meta object literal for the '<em><b>Composite Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURE_COMPOSITE_BUFFER_BARRIER__COMPOSITE_BUFFER = eINSTANCE.getConfigureCompositeBufferBarrier_CompositeBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.IContextConfiguration <em>IContext Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.IContextConfiguration
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getIContextConfiguration()
		 * @generated
		 */
		EClass ICONTEXT_CONFIGURATION = eINSTANCE.getIContextConfiguration();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ICONTEXT_CONFIGURATION__TASKS = eINSTANCE.getIContextConfiguration_Tasks();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.impl.IndexConfigurationImpl <em>Index Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.impl.IndexConfigurationImpl
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getIndexConfiguration()
		 * @generated
		 */
		EClass INDEX_CONFIGURATION = eINSTANCE.getIndexConfiguration();

		/**
		 * The meta object literal for the '<em><b>Index Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_CONFIGURATION__INDEX_COUNT = eINSTANCE.getIndexConfiguration_IndexCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.binding.EContextIndex <em>EContext Index</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.binding.EContextIndex
		 * @see org.sheepy.lily.vulkan.model.binding.impl.BindingPackageImpl#getEContextIndex()
		 * @generated
		 */
		EEnum ECONTEXT_INDEX = eINSTANCE.getEContextIndex();

	}

} //BindingPackage
