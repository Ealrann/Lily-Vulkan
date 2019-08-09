/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.VulkanPackage;

import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.image.ImagePackage;

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
 * @see org.sheepy.lily.vulkan.model.resource.ResourceFactory
 * @model kind="package"
 * @generated
 */
public interface ResourcePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resource";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.model.resource";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resource";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcePackage eINSTANCE = org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BasicResourceImpl <em>Basic Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BasicResourceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBasicResource()
	 * @generated
	 */
	int BASIC_RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RESOURCE__NAME = VulkanPackage.IRESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>Basic Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RESOURCE_FEATURE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Basic Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_RESOURCE_OPERATION_COUNT = VulkanPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.PushBufferImpl <em>Push Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.PushBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getPushBuffer()
	 * @generated
	 */
	int PUSH_BUFFER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUFFER__NAME = VulkanPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUFFER__SIZE = VulkanPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUFFER__INSTANCE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Push Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUFFER_FEATURE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Push Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_BUFFER_OPERATION_COUNT = VulkanPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.GetBufferImpl <em>Get Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.GetBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getGetBuffer()
	 * @generated
	 */
	int GET_BUFFER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUFFER__NAME = VulkanPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUFFER__SIZE = VulkanPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUFFER_FEATURE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Get Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BUFFER_OPERATION_COUNT = VulkanPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl <em>Constant Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getConstantBuffer()
	 * @generated
	 */
	int CONSTANT_BUFFER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER__NAME = VulkanPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER__DATA = VulkanPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER_FEATURE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER_OPERATION_COUNT = VulkanPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.DescriptedResource <em>Descripted Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptedResource
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptedResource()
	 * @generated
	 */
	int DESCRIPTED_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTED_RESOURCE__NAME = VulkanPackage.IRESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>Descripted Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTED_RESOURCE_FEATURE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Descripted Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTED_RESOURCE_OPERATION_COUNT = VulkanPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BasicDescriptedResourceImpl <em>Basic Descripted Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BasicDescriptedResourceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBasicDescriptedResource()
	 * @generated
	 */
	int BASIC_DESCRIPTED_RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_DESCRIPTED_RESOURCE__NAME = DESCRIPTED_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_DESCRIPTED_RESOURCE__DESCRIPTOR = DESCRIPTED_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Descripted Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT = DESCRIPTED_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Basic Descripted Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_DESCRIPTED_RESOURCE_OPERATION_COUNT = DESCRIPTED_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.IBuffer <em>IBuffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.IBuffer
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getIBuffer()
	 * @generated
	 */
	int IBUFFER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER__NAME = VulkanPackage.IRESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>IBuffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_FEATURE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IBuffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_OPERATION_COUNT = VulkanPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__NAME = BASIC_DESCRIPTED_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__DESCRIPTOR = BASIC_DESCRIPTED_RESOURCE__DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__SIZE = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__USAGES = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__DATA = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Often Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__OFTEN_UPDATED = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Gpu Buffer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__GPU_BUFFER = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__INSTANCE_COUNT = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = BASIC_DESCRIPTED_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl <em>Composite Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositeBuffer()
	 * @generated
	 */
	int COMPOSITE_BUFFER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER__NAME = DESCRIPTED_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER__DATA_PROVIDERS = DESCRIPTED_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Push Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER__PUSH_BUFFER = DESCRIPTED_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_FEATURE_COUNT = DESCRIPTED_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_OPERATION_COUNT = DESCRIPTED_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.IBufferReference <em>IBuffer Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.IBufferReference
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getIBufferReference()
	 * @generated
	 */
	int IBUFFER_REFERENCE = 9;

	/**
	 * The number of structural features of the '<em>IBuffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_REFERENCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IBuffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferReferenceImpl <em>Buffer Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferReferenceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferReference()
	 * @generated
	 */
	int BUFFER_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE__BUFFER = IBUFFER_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE__OFFSET = IBUFFER_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Buffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE_FEATURE_COUNT = IBUFFER_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Buffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE_OPERATION_COUNT = IBUFFER_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferReferenceImpl <em>Composite Buffer Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferReferenceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositeBufferReference()
	 * @generated
	 */
	int COMPOSITE_BUFFER_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE__BUFFER = IBUFFER_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE__PART = IBUFFER_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Buffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE_FEATURE_COUNT = IBUFFER_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Buffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE_OPERATION_COUNT = IBUFFER_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl <em>Buffer Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferDataProvider()
	 * @generated
	 */
	int BUFFER_DATA_PROVIDER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__USAGE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__INSTANCE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__DATA_SOURCE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Buffer Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Buffer Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescribedDataProviderImpl <em>Described Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DescribedDataProviderImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescribedDataProvider()
	 * @generated
	 */
	int DESCRIBED_DATA_PROVIDER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__NAME = BUFFER_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__USAGE = BUFFER_DATA_PROVIDER__USAGE;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__INSTANCE_COUNT = BUFFER_DATA_PROVIDER__INSTANCE_COUNT;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__DATA_SOURCE = BUFFER_DATA_PROVIDER__DATA_SOURCE;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER__DESCRIPTOR = BUFFER_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Described Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER_FEATURE_COUNT = BUFFER_DATA_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Described Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIBED_DATA_PROVIDER_OPERATION_COUNT = BUFFER_DATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__NAME = DESCRIPTED_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__INITIAL_LAYOUT = DESCRIPTED_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = DESCRIPTED_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = DESCRIPTED_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl <em>Static Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getStaticImage()
	 * @generated
	 */
	int STATIC_IMAGE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__WIDTH = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__HEIGHT = IMAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FORMAT = IMAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__USAGES = IMAGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__PROPERTIES = IMAGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__TILING = IMAGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__MIP_LEVELS = IMAGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__DESCRIPTOR = IMAGE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Fill With Zero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FILL_WITH_ZERO = IMAGE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Fill With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FILL_WITH = IMAGE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Static Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Static Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl <em>File Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFileImage()
	 * @generated
	 */
	int FILE_IMAGE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__DESCRIPTOR = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__FILE = IMAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__MIPMAP_ENABLED = IMAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>File Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>File Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageLayoutImpl <em>Image Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageLayoutImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageLayout()
	 * @generated
	 */
	int IMAGE_LAYOUT = 17;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_LAYOUT__STAGE = 0;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_LAYOUT__LAYOUT = 1;

	/**
	 * The feature id for the '<em><b>Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_LAYOUT__ACCESS_MASK = 2;

	/**
	 * The number of structural features of the '<em>Image Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_LAYOUT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Image Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_LAYOUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl <em>Sampled Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampledImage()
	 * @generated
	 */
	int SAMPLED_IMAGE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__NAME = BASIC_DESCRIPTED_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__DESCRIPTOR = BASIC_DESCRIPTED_RESOURCE__DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__SAMPLER = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__IMAGE = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sampled Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_FEATURE_COUNT = BASIC_DESCRIPTED_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sampled Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_OPERATION_COUNT = BASIC_DESCRIPTED_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl <em>Sampler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampler()
	 * @generated
	 */
	int SAMPLER = 19;

	/**
	 * The feature id for the '<em><b>Min Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MIN_FILTER = ImagePackage.SAMPLER_INFO__MIN_FILTER;

	/**
	 * The feature id for the '<em><b>Mag Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MAG_FILTER = ImagePackage.SAMPLER_INFO__MAG_FILTER;

	/**
	 * The feature id for the '<em><b>Mipmap Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MIPMAP_MODE = ImagePackage.SAMPLER_INFO__MIPMAP_MODE;

	/**
	 * The feature id for the '<em><b>Address Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__ADDRESS_MODE = ImagePackage.SAMPLER_INFO__ADDRESS_MODE;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__BORDER_COLOR = ImagePackage.SAMPLER_INFO__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Anisotropy Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__ANISOTROPY_ENABLED = ImagePackage.SAMPLER_INFO__ANISOTROPY_ENABLED;

	/**
	 * The feature id for the '<em><b>Unnormalized Coordinates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__UNNORMALIZED_COORDINATES = ImagePackage.SAMPLER_INFO__UNNORMALIZED_COORDINATES;

	/**
	 * The feature id for the '<em><b>Compare Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__COMPARE_ENABLE = ImagePackage.SAMPLER_INFO__COMPARE_ENABLE;

	/**
	 * The feature id for the '<em><b>Lod Bias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__LOD_BIAS = ImagePackage.SAMPLER_INFO__LOD_BIAS;

	/**
	 * The feature id for the '<em><b>Min Lod</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MIN_LOD = ImagePackage.SAMPLER_INFO__MIN_LOD;

	/**
	 * The feature id for the '<em><b>Max Lod</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MAX_LOD = ImagePackage.SAMPLER_INFO__MAX_LOD;

	/**
	 * The feature id for the '<em><b>Max Anisotropy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MAX_ANISOTROPY = ImagePackage.SAMPLER_INFO__MAX_ANISOTROPY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__NAME = ImagePackage.SAMPLER_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__DESCRIPTOR = ImagePackage.SAMPLER_INFO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__IMAGE = ImagePackage.SAMPLER_INFO_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sampler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_FEATURE_COUNT = ImagePackage.SAMPLER_INFO_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Sampler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_OPERATION_COUNT = ImagePackage.SAMPLER_INFO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl <em>Semaphore</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSemaphore()
	 * @generated
	 */
	int SEMAPHORE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE__NAME = BASIC_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Signalized At Init</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE__SIGNALIZED_AT_INIT = BASIC_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Wait Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE__WAIT_STAGE = BASIC_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Semaphore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE_FEATURE_COUNT = BASIC_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Semaphore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE_OPERATION_COUNT = BASIC_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl <em>Font Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFontImage()
	 * @generated
	 */
	int FONT_IMAGE = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__FILE = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__HEIGHT = IMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Font Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Font Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorImpl <em>Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptor()
	 * @generated
	 */
	int DESCRIPTOR = 22;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR__DESCRIPTOR_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR__SHADER_STAGES = 1;

	/**
	 * The number of structural features of the '<em>Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorSet()
	 * @generated
	 */
	int DESCRIPTOR_SET = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET__DESCRIPTORS = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Descriptor Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Descriptor Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetPkgImpl <em>Descriptor Set Pkg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetPkgImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorSetPkg()
	 * @generated
	 */
	int DESCRIPTOR_SET_PKG = 24;

	/**
	 * The feature id for the '<em><b>Descriptor Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_PKG__DESCRIPTOR_SETS = 0;

	/**
	 * The number of structural features of the '<em>Descriptor Set Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_PKG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Descriptor Set Pkg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_PKG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferBarrier()
	 * @generated
	 */
	int BUFFER_BARRIER = 25;

	/**
	 * The feature id for the '<em><b>Src Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__SRC_ACCESS_MASK = BarrierPackage.ABSTRACT_BUFFER_BARRIER__SRC_ACCESS_MASK;

	/**
	 * The feature id for the '<em><b>Dst Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__DST_ACCESS_MASK = BarrierPackage.ABSTRACT_BUFFER_BARRIER__DST_ACCESS_MASK;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__BUFFER = BarrierPackage.ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER_FEATURE_COUNT = BarrierPackage.ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER_OPERATION_COUNT = BarrierPackage.ABSTRACT_BUFFER_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageBarrier()
	 * @generated
	 */
	int IMAGE_BARRIER = 26;

	/**
	 * The feature id for the '<em><b>Src Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__SRC_ACCESS_MASK = BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_ACCESS_MASK;

	/**
	 * The feature id for the '<em><b>Dst Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__DST_ACCESS_MASK = BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_ACCESS_MASK;

	/**
	 * The feature id for the '<em><b>Src Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__SRC_LAYOUT = BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_LAYOUT;

	/**
	 * The feature id for the '<em><b>Dst Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__DST_LAYOUT = BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_LAYOUT;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__IMAGE = BarrierPackage.ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER_FEATURE_COUNT = BarrierPackage.ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER_OPERATION_COUNT = BarrierPackage.ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl <em>Shader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getShader()
	 * @generated
	 */
	int SHADER = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__NAME = BASIC_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__FILE = BASIC_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__STAGE = BASIC_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__CONSTANTS = BASIC_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_FEATURE_COUNT = BASIC_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_OPERATION_COUNT = BASIC_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.PathResourceImpl <em>Path Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.PathResourceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getPathResource()
	 * @generated
	 */
	int PATH_RESOURCE = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE__NAME = BASIC_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE__PATH = BASIC_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE_FEATURE_COUNT = BASIC_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Path Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE_OPERATION_COUNT = BASIC_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FileResourceImpl <em>File Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.FileResourceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFileResource()
	 * @generated
	 */
	int FILE_RESOURCE = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE__NAME = PATH_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE__PATH = PATH_RESOURCE__PATH;

	/**
	 * The number of structural features of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_FEATURE_COUNT = PATH_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_OPERATION_COUNT = PATH_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractModuleResourceImpl <em>Abstract Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.AbstractModuleResourceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getAbstractModuleResource()
	 * @generated
	 */
	int ABSTRACT_MODULE_RESOURCE = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODULE_RESOURCE__NAME = PATH_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODULE_RESOURCE__PATH = PATH_RESOURCE__PATH;

	/**
	 * The number of structural features of the '<em>Abstract Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT = PATH_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODULE_RESOURCE_OPERATION_COUNT = PATH_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getModuleResource()
	 * @generated
	 */
	int MODULE_RESOURCE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__NAME = ABSTRACT_MODULE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__PATH = ABSTRACT_MODULE_RESOURCE__PATH;

	/**
	 * The feature id for the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__MODULE = ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE_FEATURE_COUNT = ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE_OPERATION_COUNT = ABSTRACT_MODULE_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StringModuleResourceImpl <em>String Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.StringModuleResourceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getStringModuleResource()
	 * @generated
	 */
	int STRING_MODULE_RESOURCE = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE__NAME = ABSTRACT_MODULE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE__PATH = ABSTRACT_MODULE_RESOURCE__PATH;

	/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE__MODULE_NAME = ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE_FEATURE_COUNT = ABSTRACT_MODULE_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_MODULE_RESOURCE_OPERATION_COUNT = ABSTRACT_MODULE_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayImpl <em>Texture2 DArray</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTexture2DArray()
	 * @generated
	 */
	int TEXTURE2_DARRAY = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__DESCRIPTOR = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__FILES = IMAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__WIDTH = IMAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__HEIGHT = IMAGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__MIPMAP_ENABLED = IMAGE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Texture2 DArray</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Texture2 DArray</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>Byte Buffer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.ByteBuffer
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getByteBuffer()
	 * @generated
	 */
	int BYTE_BUFFER = 34;

	/**
	 * The meta object id for the '<em>Java Module</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Module
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getJavaModule()
	 * @generated
	 */
	int JAVA_MODULE = 35;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BasicResource <em>Basic Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BasicResource
	 * @generated
	 */
	EClass getBasicResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.PushBuffer <em>Push Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.PushBuffer
	 * @generated
	 */
	EClass getPushBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.PushBuffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.PushBuffer#getSize()
	 * @see #getPushBuffer()
	 * @generated
	 */
	EAttribute getPushBuffer_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.PushBuffer#getInstanceCount <em>Instance Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.PushBuffer#getInstanceCount()
	 * @see #getPushBuffer()
	 * @generated
	 */
	EAttribute getPushBuffer_InstanceCount();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.GetBuffer <em>Get Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.GetBuffer
	 * @generated
	 */
	EClass getGetBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.GetBuffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.GetBuffer#getSize()
	 * @see #getGetBuffer()
	 * @generated
	 */
	EAttribute getGetBuffer_Size();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ConstantBuffer <em>Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ConstantBuffer
	 * @generated
	 */
	EClass getConstantBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ConstantBuffer#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ConstantBuffer#getData()
	 * @see #getConstantBuffer()
	 * @generated
	 */
	EAttribute getConstantBuffer_Data();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.DescriptedResource <em>Descripted Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descripted Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptedResource
	 * @generated
	 */
	EClass getDescriptedResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BasicDescriptedResource <em>Basic Descripted Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Descripted Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BasicDescriptedResource
	 * @generated
	 */
	EClass getBasicDescriptedResource();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.BasicDescriptedResource#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BasicDescriptedResource#getDescriptor()
	 * @see #getBasicDescriptedResource()
	 * @generated
	 */
	EReference getBasicDescriptedResource_Descriptor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.IBuffer <em>IBuffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IBuffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.IBuffer
	 * @generated
	 */
	EClass getIBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Buffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#getSize()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Size();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.Buffer#getUsages <em>Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Usages</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#getUsages()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Usages();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Buffer#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#getData()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isOftenUpdated <em>Often Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Often Updated</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#isOftenUpdated()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_OftenUpdated();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isGpuBuffer <em>Gpu Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gpu Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#isGpuBuffer()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_GpuBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Buffer#getInstanceCount <em>Instance Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#getInstanceCount()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_InstanceCount();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer <em>Composite Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBuffer
	 * @generated
	 */
	EClass getCompositeBuffer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getDataProviders <em>Data Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Providers</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getDataProviders()
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	EReference getCompositeBuffer_DataProviders();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getPushBuffer <em>Push Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Push Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getPushBuffer()
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	EReference getCompositeBuffer_PushBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.IBufferReference <em>IBuffer Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IBuffer Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.IBufferReference
	 * @generated
	 */
	EClass getIBufferReference();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferReference <em>Buffer Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferReference
	 * @generated
	 */
	EClass getBufferReference();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferReference#getBuffer()
	 * @see #getBufferReference()
	 * @generated
	 */
	EReference getBufferReference_Buffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferReference#getOffset()
	 * @see #getBufferReference()
	 * @generated
	 */
	EAttribute getBufferReference_Offset();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferReference <em>Composite Buffer Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Buffer Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBufferReference
	 * @generated
	 */
	EClass getCompositeBufferReference();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferReference#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBufferReference#getBuffer()
	 * @see #getCompositeBufferReference()
	 * @generated
	 */
	EReference getCompositeBufferReference_Buffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferReference#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBufferReference#getPart()
	 * @see #getCompositeBufferReference()
	 * @generated
	 */
	EAttribute getCompositeBufferReference_Part();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider <em>Buffer Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider
	 * @generated
	 */
	EClass getBufferDataProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getUsage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getUsage()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_Usage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getInstanceCount <em>Instance Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getInstanceCount()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_InstanceCount();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getDataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Source</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getDataSource()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EReference getBufferDataProvider_DataSource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.DescribedDataProvider <em>Described Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Described Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescribedDataProvider
	 * @generated
	 */
	EClass getDescribedDataProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.DescribedDataProvider#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescribedDataProvider#getDescriptor()
	 * @see #getDescribedDataProvider()
	 * @generated
	 */
	EReference getDescribedDataProvider_Descriptor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.Image#getInitialLayout <em>Initial Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image#getInitialLayout()
	 * @see #getImage()
	 * @generated
	 */
	EReference getImage_InitialLayout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.StaticImage <em>Static Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StaticImage
	 * @generated
	 */
	EClass getStaticImage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.StaticImage#isFillWithZero <em>Fill With Zero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fill With Zero</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StaticImage#isFillWithZero()
	 * @see #getStaticImage()
	 * @generated
	 */
	EAttribute getStaticImage_FillWithZero();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.StaticImage#getFillWith <em>Fill With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fill With</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StaticImage#getFillWith()
	 * @see #getStaticImage()
	 * @generated
	 */
	EAttribute getStaticImage_FillWith();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.FileImage <em>File Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FileImage
	 * @generated
	 */
	EClass getFileImage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.FileImage#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FileImage#getFile()
	 * @see #getFileImage()
	 * @generated
	 */
	EReference getFileImage_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.FileImage#isMipmapEnabled <em>Mipmap Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mipmap Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FileImage#isMipmapEnabled()
	 * @see #getFileImage()
	 * @generated
	 */
	EAttribute getFileImage_MipmapEnabled();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ImageLayout <em>Image Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageLayout
	 * @generated
	 */
	EClass getImageLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageLayout#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageLayout#getStage()
	 * @see #getImageLayout()
	 * @generated
	 */
	EAttribute getImageLayout_Stage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageLayout#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageLayout#getLayout()
	 * @see #getImageLayout()
	 * @generated
	 */
	EAttribute getImageLayout_Layout();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.ImageLayout#getAccessMask <em>Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Access Mask</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageLayout#getAccessMask()
	 * @see #getImageLayout()
	 * @generated
	 */
	EAttribute getImageLayout_AccessMask();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.SampledImage <em>Sampled Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sampled Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.SampledImage
	 * @generated
	 */
	EClass getSampledImage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.SampledImage#getSampler <em>Sampler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sampler</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.SampledImage#getSampler()
	 * @see #getSampledImage()
	 * @generated
	 */
	EReference getSampledImage_Sampler();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.SampledImage#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.SampledImage#getImage()
	 * @see #getSampledImage()
	 * @generated
	 */
	EReference getSampledImage_Image();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Sampler <em>Sampler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sampler</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler
	 * @generated
	 */
	EClass getSampler();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getImage()
	 * @see #getSampler()
	 * @generated
	 */
	EReference getSampler_Image();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Semaphore <em>Semaphore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semaphore</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Semaphore
	 * @generated
	 */
	EClass getSemaphore();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Semaphore#isSignalizedAtInit <em>Signalized At Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signalized At Init</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Semaphore#isSignalizedAtInit()
	 * @see #getSemaphore()
	 * @generated
	 */
	EAttribute getSemaphore_SignalizedAtInit();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Semaphore#getWaitStage <em>Wait Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wait Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Semaphore#getWaitStage()
	 * @see #getSemaphore()
	 * @generated
	 */
	EAttribute getSemaphore_WaitStage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.FontImage <em>Font Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FontImage
	 * @generated
	 */
	EClass getFontImage();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.FontImage#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FontImage#getFile()
	 * @see #getFontImage()
	 * @generated
	 */
	EReference getFontImage_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.FontImage#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FontImage#getHeight()
	 * @see #getFontImage()
	 * @generated
	 */
	EAttribute getFontImage_Height();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Descriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Descriptor
	 * @generated
	 */
	EClass getDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Descriptor#getDescriptorType <em>Descriptor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descriptor Type</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Descriptor#getDescriptorType()
	 * @see #getDescriptor()
	 * @generated
	 */
	EAttribute getDescriptor_DescriptorType();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.Descriptor#getShaderStages <em>Shader Stages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Shader Stages</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Descriptor#getShaderStages()
	 * @see #getDescriptor()
	 * @generated
	 */
	EAttribute getDescriptor_ShaderStages();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.DescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Set</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptorSet
	 * @generated
	 */
	EClass getDescriptorSet();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.resource.DescriptorSet#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptorSet#getDescriptors()
	 * @see #getDescriptorSet()
	 * @generated
	 */
	EReference getDescriptorSet_Descriptors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg <em>Descriptor Set Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Set Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg
	 * @generated
	 */
	EClass getDescriptorSetPkg();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg#getDescriptorSets <em>Descriptor Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptor Sets</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg#getDescriptorSets()
	 * @see #getDescriptorSetPkg()
	 * @generated
	 */
	EReference getDescriptorSetPkg_DescriptorSets();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier <em>Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferBarrier
	 * @generated
	 */
	EClass getBufferBarrier();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffer()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EReference getBufferBarrier_Buffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ImageBarrier <em>Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageBarrier
	 * @generated
	 */
	EClass getImageBarrier();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.ImageBarrier#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageBarrier#getImage()
	 * @see #getImageBarrier()
	 * @generated
	 */
	EReference getImageBarrier_Image();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Shader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shader</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Shader
	 * @generated
	 */
	EClass getShader();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.Shader#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Shader#getFile()
	 * @see #getShader()
	 * @generated
	 */
	EReference getShader_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Shader#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Shader#getStage()
	 * @see #getShader()
	 * @generated
	 */
	EAttribute getShader_Stage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.Shader#getConstants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constants</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Shader#getConstants()
	 * @see #getShader()
	 * @generated
	 */
	EReference getShader_Constants();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.PathResource <em>Path Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.PathResource
	 * @generated
	 */
	EClass getPathResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.PathResource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.PathResource#getPath()
	 * @see #getPathResource()
	 * @generated
	 */
	EAttribute getPathResource_Path();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FileResource
	 * @generated
	 */
	EClass getFileResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.AbstractModuleResource <em>Abstract Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Module Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.AbstractModuleResource
	 * @generated
	 */
	EClass getAbstractModuleResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ModuleResource <em>Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ModuleResource
	 * @generated
	 */
	EClass getModuleResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ModuleResource#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ModuleResource#getModule()
	 * @see #getModuleResource()
	 * @generated
	 */
	EAttribute getModuleResource_Module();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.StringModuleResource <em>String Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Module Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StringModuleResource
	 * @generated
	 */
	EClass getStringModuleResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.StringModuleResource#getModuleName <em>Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Name</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StringModuleResource#getModuleName()
	 * @see #getStringModuleResource()
	 * @generated
	 */
	EAttribute getStringModuleResource_ModuleName();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray <em>Texture2 DArray</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Texture2 DArray</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture2DArray
	 * @generated
	 */
	EClass getTexture2DArray();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#getFiles <em>Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Files</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture2DArray#getFiles()
	 * @see #getTexture2DArray()
	 * @generated
	 */
	EReference getTexture2DArray_Files();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture2DArray#getWidth()
	 * @see #getTexture2DArray()
	 * @generated
	 */
	EAttribute getTexture2DArray_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture2DArray#getHeight()
	 * @see #getTexture2DArray()
	 * @generated
	 */
	EAttribute getTexture2DArray_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArray#isMipmapEnabled <em>Mipmap Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mipmap Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture2DArray#isMipmapEnabled()
	 * @see #getTexture2DArray()
	 * @generated
	 */
	EAttribute getTexture2DArray_MipmapEnabled();

	/**
	 * Returns the meta object for data type '{@link java.nio.ByteBuffer <em>Byte Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Byte Buffer</em>'.
	 * @see java.nio.ByteBuffer
	 * @model instanceClass="java.nio.ByteBuffer"
	 * @generated
	 */
	EDataType getByteBuffer();

	/**
	 * Returns the meta object for data type '{@link java.lang.Module <em>Java Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Module</em>'.
	 * @see java.lang.Module
	 * @model instanceClass="java.lang.Module"
	 * @generated
	 */
	EDataType getJavaModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourceFactory getResourceFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BasicResourceImpl <em>Basic Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BasicResourceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBasicResource()
		 * @generated
		 */
		EClass BASIC_RESOURCE = eINSTANCE.getBasicResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.PushBufferImpl <em>Push Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.PushBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getPushBuffer()
		 * @generated
		 */
		EClass PUSH_BUFFER = eINSTANCE.getPushBuffer();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_BUFFER__SIZE = eINSTANCE.getPushBuffer_Size();

		/**
		 * The meta object literal for the '<em><b>Instance Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_BUFFER__INSTANCE_COUNT = eINSTANCE.getPushBuffer_InstanceCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.GetBufferImpl <em>Get Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.GetBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getGetBuffer()
		 * @generated
		 */
		EClass GET_BUFFER = eINSTANCE.getGetBuffer();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_BUFFER__SIZE = eINSTANCE.getGetBuffer_Size();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl <em>Constant Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getConstantBuffer()
		 * @generated
		 */
		EClass CONSTANT_BUFFER = eINSTANCE.getConstantBuffer();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT_BUFFER__DATA = eINSTANCE.getConstantBuffer_Data();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.DescriptedResource <em>Descripted Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.DescriptedResource
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptedResource()
		 * @generated
		 */
		EClass DESCRIPTED_RESOURCE = eINSTANCE.getDescriptedResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BasicDescriptedResourceImpl <em>Basic Descripted Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BasicDescriptedResourceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBasicDescriptedResource()
		 * @generated
		 */
		EClass BASIC_DESCRIPTED_RESOURCE = eINSTANCE.getBasicDescriptedResource();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_DESCRIPTED_RESOURCE__DESCRIPTOR = eINSTANCE.getBasicDescriptedResource_Descriptor();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.IBuffer <em>IBuffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.IBuffer
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getIBuffer()
		 * @generated
		 */
		EClass IBUFFER = eINSTANCE.getIBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBuffer()
		 * @generated
		 */
		EClass BUFFER = eINSTANCE.getBuffer();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__SIZE = eINSTANCE.getBuffer_Size();

		/**
		 * The meta object literal for the '<em><b>Usages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__USAGES = eINSTANCE.getBuffer_Usages();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__DATA = eINSTANCE.getBuffer_Data();

		/**
		 * The meta object literal for the '<em><b>Often Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__OFTEN_UPDATED = eINSTANCE.getBuffer_OftenUpdated();

		/**
		 * The meta object literal for the '<em><b>Gpu Buffer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__GPU_BUFFER = eINSTANCE.getBuffer_GpuBuffer();

		/**
		 * The meta object literal for the '<em><b>Instance Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__INSTANCE_COUNT = eINSTANCE.getBuffer_InstanceCount();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl <em>Composite Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositeBuffer()
		 * @generated
		 */
		EClass COMPOSITE_BUFFER = eINSTANCE.getCompositeBuffer();

		/**
		 * The meta object literal for the '<em><b>Data Providers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_BUFFER__DATA_PROVIDERS = eINSTANCE.getCompositeBuffer_DataProviders();

		/**
		 * The meta object literal for the '<em><b>Push Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_BUFFER__PUSH_BUFFER = eINSTANCE.getCompositeBuffer_PushBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.IBufferReference <em>IBuffer Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.IBufferReference
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getIBufferReference()
		 * @generated
		 */
		EClass IBUFFER_REFERENCE = eINSTANCE.getIBufferReference();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferReferenceImpl <em>Buffer Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferReferenceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferReference()
		 * @generated
		 */
		EClass BUFFER_REFERENCE = eINSTANCE.getBufferReference();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_REFERENCE__BUFFER = eINSTANCE.getBufferReference_Buffer();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_REFERENCE__OFFSET = eINSTANCE.getBufferReference_Offset();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferReferenceImpl <em>Composite Buffer Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferReferenceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositeBufferReference()
		 * @generated
		 */
		EClass COMPOSITE_BUFFER_REFERENCE = eINSTANCE.getCompositeBufferReference();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_BUFFER_REFERENCE__BUFFER = eINSTANCE.getCompositeBufferReference_Buffer();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_BUFFER_REFERENCE__PART = eINSTANCE.getCompositeBufferReference_Part();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl <em>Buffer Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferDataProvider()
		 * @generated
		 */
		EClass BUFFER_DATA_PROVIDER = eINSTANCE.getBufferDataProvider();

		/**
		 * The meta object literal for the '<em><b>Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__USAGE = eINSTANCE.getBufferDataProvider_Usage();

		/**
		 * The meta object literal for the '<em><b>Instance Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__INSTANCE_COUNT = eINSTANCE.getBufferDataProvider_InstanceCount();

		/**
		 * The meta object literal for the '<em><b>Data Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DATA_PROVIDER__DATA_SOURCE = eINSTANCE.getBufferDataProvider_DataSource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescribedDataProviderImpl <em>Described Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.DescribedDataProviderImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescribedDataProvider()
		 * @generated
		 */
		EClass DESCRIBED_DATA_PROVIDER = eINSTANCE.getDescribedDataProvider();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIBED_DATA_PROVIDER__DESCRIPTOR = eINSTANCE.getDescribedDataProvider_Descriptor();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Initial Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE__INITIAL_LAYOUT = eINSTANCE.getImage_InitialLayout();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl <em>Static Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getStaticImage()
		 * @generated
		 */
		EClass STATIC_IMAGE = eINSTANCE.getStaticImage();

		/**
		 * The meta object literal for the '<em><b>Fill With Zero</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_IMAGE__FILL_WITH_ZERO = eINSTANCE.getStaticImage_FillWithZero();

		/**
		 * The meta object literal for the '<em><b>Fill With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_IMAGE__FILL_WITH = eINSTANCE.getStaticImage_FillWith();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl <em>File Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFileImage()
		 * @generated
		 */
		EClass FILE_IMAGE = eINSTANCE.getFileImage();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_IMAGE__FILE = eINSTANCE.getFileImage_File();

		/**
		 * The meta object literal for the '<em><b>Mipmap Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_IMAGE__MIPMAP_ENABLED = eINSTANCE.getFileImage_MipmapEnabled();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageLayoutImpl <em>Image Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageLayoutImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageLayout()
		 * @generated
		 */
		EClass IMAGE_LAYOUT = eINSTANCE.getImageLayout();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_LAYOUT__STAGE = eINSTANCE.getImageLayout_Stage();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_LAYOUT__LAYOUT = eINSTANCE.getImageLayout_Layout();

		/**
		 * The meta object literal for the '<em><b>Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_LAYOUT__ACCESS_MASK = eINSTANCE.getImageLayout_AccessMask();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl <em>Sampled Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampledImage()
		 * @generated
		 */
		EClass SAMPLED_IMAGE = eINSTANCE.getSampledImage();

		/**
		 * The meta object literal for the '<em><b>Sampler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLED_IMAGE__SAMPLER = eINSTANCE.getSampledImage_Sampler();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLED_IMAGE__IMAGE = eINSTANCE.getSampledImage_Image();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl <em>Sampler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampler()
		 * @generated
		 */
		EClass SAMPLER = eINSTANCE.getSampler();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLER__IMAGE = eINSTANCE.getSampler_Image();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl <em>Semaphore</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSemaphore()
		 * @generated
		 */
		EClass SEMAPHORE = eINSTANCE.getSemaphore();

		/**
		 * The meta object literal for the '<em><b>Signalized At Init</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMAPHORE__SIGNALIZED_AT_INIT = eINSTANCE.getSemaphore_SignalizedAtInit();

		/**
		 * The meta object literal for the '<em><b>Wait Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMAPHORE__WAIT_STAGE = eINSTANCE.getSemaphore_WaitStage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl <em>Font Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFontImage()
		 * @generated
		 */
		EClass FONT_IMAGE = eINSTANCE.getFontImage();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FONT_IMAGE__FILE = eINSTANCE.getFontImage_File();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_IMAGE__HEIGHT = eINSTANCE.getFontImage_Height();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorImpl <em>Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptor()
		 * @generated
		 */
		EClass DESCRIPTOR = eINSTANCE.getDescriptor();

		/**
		 * The meta object literal for the '<em><b>Descriptor Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTOR__DESCRIPTOR_TYPE = eINSTANCE.getDescriptor_DescriptorType();

		/**
		 * The meta object literal for the '<em><b>Shader Stages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTOR__SHADER_STAGES = eINSTANCE.getDescriptor_ShaderStages();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorSet()
		 * @generated
		 */
		EClass DESCRIPTOR_SET = eINSTANCE.getDescriptorSet();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTOR_SET__DESCRIPTORS = eINSTANCE.getDescriptorSet_Descriptors();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetPkgImpl <em>Descriptor Set Pkg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetPkgImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorSetPkg()
		 * @generated
		 */
		EClass DESCRIPTOR_SET_PKG = eINSTANCE.getDescriptorSetPkg();

		/**
		 * The meta object literal for the '<em><b>Descriptor Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTOR_SET_PKG__DESCRIPTOR_SETS = eINSTANCE.getDescriptorSetPkg_DescriptorSets();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferBarrier()
		 * @generated
		 */
		EClass BUFFER_BARRIER = eINSTANCE.getBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_BARRIER__BUFFER = eINSTANCE.getBufferBarrier_Buffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageBarrier()
		 * @generated
		 */
		EClass IMAGE_BARRIER = eINSTANCE.getImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_BARRIER__IMAGE = eINSTANCE.getImageBarrier_Image();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl <em>Shader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getShader()
		 * @generated
		 */
		EClass SHADER = eINSTANCE.getShader();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADER__FILE = eINSTANCE.getShader_File();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHADER__STAGE = eINSTANCE.getShader_Stage();

		/**
		 * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADER__CONSTANTS = eINSTANCE.getShader_Constants();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.PathResourceImpl <em>Path Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.PathResourceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getPathResource()
		 * @generated
		 */
		EClass PATH_RESOURCE = eINSTANCE.getPathResource();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_RESOURCE__PATH = eINSTANCE.getPathResource_Path();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FileResourceImpl <em>File Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.FileResourceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFileResource()
		 * @generated
		 */
		EClass FILE_RESOURCE = eINSTANCE.getFileResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractModuleResourceImpl <em>Abstract Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.AbstractModuleResourceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getAbstractModuleResource()
		 * @generated
		 */
		EClass ABSTRACT_MODULE_RESOURCE = eINSTANCE.getAbstractModuleResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ModuleResourceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getModuleResource()
		 * @generated
		 */
		EClass MODULE_RESOURCE = eINSTANCE.getModuleResource();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE_RESOURCE__MODULE = eINSTANCE.getModuleResource_Module();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StringModuleResourceImpl <em>String Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.StringModuleResourceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getStringModuleResource()
		 * @generated
		 */
		EClass STRING_MODULE_RESOURCE = eINSTANCE.getStringModuleResource();

		/**
		 * The meta object literal for the '<em><b>Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_MODULE_RESOURCE__MODULE_NAME = eINSTANCE.getStringModuleResource_ModuleName();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayImpl <em>Texture2 DArray</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTexture2DArray()
		 * @generated
		 */
		EClass TEXTURE2_DARRAY = eINSTANCE.getTexture2DArray();

		/**
		 * The meta object literal for the '<em><b>Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTURE2_DARRAY__FILES = eINSTANCE.getTexture2DArray_Files();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTURE2_DARRAY__WIDTH = eINSTANCE.getTexture2DArray_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTURE2_DARRAY__HEIGHT = eINSTANCE.getTexture2DArray_Height();

		/**
		 * The meta object literal for the '<em><b>Mipmap Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTURE2_DARRAY__MIPMAP_ENABLED = eINSTANCE.getTexture2DArray_MipmapEnabled();

		/**
		 * The meta object literal for the '<em>Byte Buffer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.nio.ByteBuffer
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getByteBuffer()
		 * @generated
		 */
		EDataType BYTE_BUFFER = eINSTANCE.getByteBuffer();

		/**
		 * The meta object literal for the '<em>Java Module</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Module
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getJavaModule()
		 * @generated
		 */
		EDataType JAVA_MODULE = eINSTANCE.getJavaModule();

	}

} //ResourcePackage
