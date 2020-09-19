/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.resource.ResourcePackage;

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
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceFactory
 * @model kind="package"
 * @generated
 */
public interface VulkanResourcePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vulkanresource";

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
	String eNS_PREFIX = "vulkanresource";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VulkanResourcePackage eINSTANCE = org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.TransferBufferImpl <em>Transfer Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.TransferBufferImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getTransferBuffer()
	 * @generated
	 */
	int TRANSFER_BUFFER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__NAME = VulkanPackage.IVULKAN_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__SIZE = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Used To Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__USED_TO_PUSH = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Used To Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__USED_TO_FETCH = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transfer Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER_FEATURE_COUNT = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Transfer Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER_OPERATION_COUNT = VulkanPackage.IVULKAN_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorPoolImpl <em>Descriptor Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorPoolImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getDescriptorPool()
	 * @generated
	 */
	int DESCRIPTOR_POOL = 1;

	/**
	 * The feature id for the '<em><b>Descriptor Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_POOL__DESCRIPTOR_SETS = 0;

	/**
	 * The number of structural features of the '<em>Descriptor Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_POOL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Descriptor Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_POOL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ConstantBufferImpl <em>Constant Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ConstantBufferImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getConstantBuffer()
	 * @generated
	 */
	int CONSTANT_BUFFER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER__NAME = VulkanPackage.IVULKAN_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER__DATA = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER_FEATURE_COUNT = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER_OPERATION_COUNT = VulkanPackage.IVULKAN_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.GenericConstantBufferImpl <em>Generic Constant Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.GenericConstantBufferImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getGenericConstantBuffer()
	 * @generated
	 */
	int GENERIC_CONSTANT_BUFFER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTANT_BUFFER__NAME = CONSTANT_BUFFER__NAME;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTANT_BUFFER__DATA = CONSTANT_BUFFER__DATA;

	/**
	 * The feature id for the '<em><b>Referenced Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES = CONSTANT_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTANT_BUFFER__VARIABLE_PKG = CONSTANT_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Generic Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTANT_BUFFER_FEATURE_COUNT = CONSTANT_BUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Generic Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_CONSTANT_BUFFER_OPERATION_COUNT = CONSTANT_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.IBuffer <em>IBuffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IBuffer
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getIBuffer()
	 * @generated
	 */
	int IBUFFER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER__USAGES = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IBuffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>IBuffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferReferenceImpl <em>Buffer Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferReferenceImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferReference()
	 * @generated
	 */
	int BUFFER_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Buffers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE__BUFFERS = 0;

	/**
	 * The feature id for the '<em><b>Stride</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE__STRIDE = 1;

	/**
	 * The feature id for the '<em><b>Index Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE__INDEX_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Buffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Buffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource <em>IBuffer Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getIBufferDataSource()
	 * @generated
	 */
	int IBUFFER_DATA_SOURCE = 6;

	/**
	 * The number of structural features of the '<em>IBuffer Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_DATA_SOURCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IBuffer Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_DATA_SOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDataProviderImpl <em>Image Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDataProviderImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageDataProvider()
	 * @generated
	 */
	int IMAGE_DATA_PROVIDER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DATA_PROVIDER__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Image Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DATA_PROVIDER_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Image Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DATA_PROVIDER_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.FileImageDataProviderImpl <em>File Image Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.FileImageDataProviderImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getFileImageDataProvider()
	 * @generated
	 */
	int FILE_IMAGE_DATA_PROVIDER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_DATA_PROVIDER__NAME = IMAGE_DATA_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>File Image Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_REFERENCE = IMAGE_DATA_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File Image Containment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT = IMAGE_DATA_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>File Image Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_DATA_PROVIDER_FEATURE_COUNT = IMAGE_DATA_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>File Image Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_DATA_PROVIDER_OPERATION_COUNT = IMAGE_DATA_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl <em>Image Inlay</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageInlay()
	 * @generated
	 */
	int IMAGE_INLAY = 9;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INLAY__IMAGE = 0;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INLAY__POSITION = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INLAY__SIZE = 2;

	/**
	 * The feature id for the '<em><b>Horizontal Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INLAY__HORIZONTAL_RELATIVE = 3;

	/**
	 * The feature id for the '<em><b>Vertical Relative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INLAY__VERTICAL_RELATIVE = 4;

	/**
	 * The number of structural features of the '<em>Image Inlay</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INLAY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Image Inlay</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INLAY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.SamplerImpl <em>Sampler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.SamplerImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getSampler()
	 * @generated
	 */
	int SAMPLER = 10;

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
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__IMAGE = ImagePackage.SAMPLER_INFO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sampler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_FEATURE_COUNT = ImagePackage.SAMPLER_INFO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sampler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_OPERATION_COUNT = ImagePackage.SAMPLER_INFO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferDescriptorImpl <em>Buffer Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferDescriptor()
	 * @generated
	 */
	int BUFFER_DESCRIPTOR = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DESCRIPTOR__NAME = VulkanPackage.IDESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DESCRIPTOR__TYPE = VulkanPackage.IDESCRIPTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DESCRIPTOR__SHADER_STAGES = VulkanPackage.IDESCRIPTOR__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DESCRIPTOR__BUFFER = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Buffer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DESCRIPTOR_FEATURE_COUNT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Buffer Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DESCRIPTOR_OPERATION_COUNT = VulkanPackage.IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl <em>Image Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageDescriptor()
	 * @generated
	 */
	int IMAGE_DESCRIPTOR = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR__NAME = VulkanPackage.IDESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR__TYPE = VulkanPackage.IDESCRIPTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR__SHADER_STAGES = VulkanPackage.IDESCRIPTOR__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Images</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR__IMAGES = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR__SAMPLER = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR__LAYOUT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Image Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR_FEATURE_COUNT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Image Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR_OPERATION_COUNT = VulkanPackage.IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorSetImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getDescriptorSet()
	 * @generated
	 */
	int DESCRIPTOR_SET = 13;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferBarrier()
	 * @generated
	 */
	int BUFFER_BARRIER = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__NAME = BarrierPackage.ABSTRACT_BUFFER_BARRIER__NAME;

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
	 * The feature id for the '<em><b>Buffers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__BUFFERS = BarrierPackage.ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageBarrier()
	 * @generated
	 */
	int IMAGE_BARRIER = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__NAME = BarrierPackage.ABSTRACT_IMAGE_BARRIER__NAME;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ShaderImpl <em>Shader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ShaderImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getShader()
	 * @generated
	 */
	int SHADER = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__NAME = VulkanPackage.IVULKAN_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__FILE = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__STAGE = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__CONSTANTS = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_FEATURE_COUNT = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_OPERATION_COUNT = VulkanPackage.IVULKAN_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.MemoryChunkImpl <em>Memory Chunk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.MemoryChunkImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getMemoryChunk()
	 * @generated
	 */
	int MEMORY_CHUNK = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK__NAME = VulkanPackage.IVULKAN_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK__PARTS = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK__TRANSFER_BUFFER = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Memory Chunk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK_FEATURE_COUNT = VulkanPackage.IVULKAN_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Memory Chunk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK_OPERATION_COUNT = VulkanPackage.IVULKAN_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart <em>IMemory Chunk Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getIMemoryChunkPart()
	 * @generated
	 */
	int IMEMORY_CHUNK_PART = 18;

	/**
	 * The number of structural features of the '<em>IMemory Chunk Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMEMORY_CHUNK_PART_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IMemory Chunk Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMEMORY_CHUNK_PART_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferMemoryImpl <em>Buffer Memory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferMemoryImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferMemory()
	 * @generated
	 */
	int BUFFER_MEMORY = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY__NAME = IMEMORY_CHUNK_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Buffers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY__BUFFERS = IMEMORY_CHUNK_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Buffer Memory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY_FEATURE_COUNT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Buffer Memory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_MEMORY_OPERATION_COUNT = IMEMORY_CHUNK_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticBufferImpl <em>Static Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticBufferImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getStaticBuffer()
	 * @generated
	 */
	int STATIC_BUFFER = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER__NAME = IBUFFER__NAME;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER__USAGES = IBUFFER__USAGES;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER__SIZE = IBUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init With Zero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER__INIT_WITH_ZERO = IBUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Static Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER_FEATURE_COUNT = IBUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Static Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER_OPERATION_COUNT = IBUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.DataBufferImpl <em>Data Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.DataBufferImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getDataBuffer()
	 * @generated
	 */
	int DATA_BUFFER = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER__NAME = IBUFFER__NAME;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER__USAGES = IBUFFER__USAGES;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER__DATA = IBUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER_FEATURE_COUNT = IBUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER_OPERATION_COUNT = IBUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl <em>Buffer Viewer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferViewer()
	 * @generated
	 */
	int BUFFER_VIEWER = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__NAME = IBUFFER__NAME;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__USAGES = IBUFFER__USAGES;

	/**
	 * The feature id for the '<em><b>Grow Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__GROW_FACTOR = IBUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Grow Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__GROW_THRESHOLD = IBUFFER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__SIZE = IBUFFER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__DATA_SOURCE = IBUFFER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Buffer Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER_FEATURE_COUNT = IBUFFER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Buffer Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER_OPERATION_COUNT = IBUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage <em>IVulkan Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getIVulkanImage()
	 * @generated
	 */
	int IVULKAN_IMAGE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVULKAN_IMAGE__NAME = ResourcePackage.IIMAGE__NAME;

	/**
	 * The number of structural features of the '<em>IVulkan Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVULKAN_IMAGE_FEATURE_COUNT = ResourcePackage.IIMAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IVulkan Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVULKAN_IMAGE_OPERATION_COUNT = ResourcePackage.IIMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.CompositeImageImpl <em>Composite Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.CompositeImageImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getCompositeImage()
	 * @generated
	 */
	int COMPOSITE_IMAGE = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__NAME = IVULKAN_IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__FORMAT = IVULKAN_IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__USAGES = IVULKAN_IMAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__TILING = IVULKAN_IMAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__MIP_LEVELS = IVULKAN_IMAGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__INITIAL_LAYOUT = IVULKAN_IMAGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Inlays</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__INLAYS = IVULKAN_IMAGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__BACKGROUND = IVULKAN_IMAGE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Composite Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE_FEATURE_COUNT = IVULKAN_IMAGE_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Composite Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE_OPERATION_COUNT = IVULKAN_IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticImageImpl <em>Static Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticImageImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getStaticImage()
	 * @generated
	 */
	int STATIC_IMAGE = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__NAME = IMEMORY_CHUNK_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FORMAT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__USAGES = IMEMORY_CHUNK_PART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__TILING = IMEMORY_CHUNK_PART_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__MIP_LEVELS = IMEMORY_CHUNK_PART_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__INITIAL_LAYOUT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Fill With Zero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FILL_WITH_ZERO = IMEMORY_CHUNK_PART_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Fill With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FILL_WITH = IMEMORY_CHUNK_PART_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__SIZE = IMEMORY_CHUNK_PART_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Static Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE_FEATURE_COUNT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Static Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE_OPERATION_COUNT = IMEMORY_CHUNK_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageViewerImpl <em>Image Viewer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageViewerImpl
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageViewer()
	 * @generated
	 */
	int IMAGE_VIEWER = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER__NAME = IMEMORY_CHUNK_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER__FORMAT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER__USAGES = IMEMORY_CHUNK_PART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER__TILING = IMEMORY_CHUNK_PART_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER__MIP_LEVELS = IMEMORY_CHUNK_PART_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER__INITIAL_LAYOUT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER__DATA_PROVIDER = IMEMORY_CHUNK_PART_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER__MIPMAP_ENABLED = IMEMORY_CHUNK_PART_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Image Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER_FEATURE_COUNT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Image Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_VIEWER_OPERATION_COUNT = IMEMORY_CHUNK_PART_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex <em>EContext Index</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getEContextIndex()
	 * @generated
	 */
	int ECONTEXT_INDEX = 27;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.EFlushMode <em>EFlush Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.EFlushMode
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getEFlushMode()
	 * @generated
	 */
	int EFLUSH_MODE = 28;

	/**
	 * The meta object id for the '<em>Byte Buffer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.ByteBuffer
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getByteBuffer()
	 * @generated
	 */
	int BYTE_BUFFER = 29;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer
	 * @generated
	 */
	EClass getTransferBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer#getSize()
	 * @see #getTransferBuffer()
	 * @generated
	 */
	EAttribute getTransferBuffer_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer#isUsedToPush <em>Used To Push</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used To Push</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer#isUsedToPush()
	 * @see #getTransferBuffer()
	 * @generated
	 */
	EAttribute getTransferBuffer_UsedToPush();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer#isUsedToFetch <em>Used To Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used To Fetch</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer#isUsedToFetch()
	 * @see #getTransferBuffer()
	 * @generated
	 */
	EAttribute getTransferBuffer_UsedToFetch();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool <em>Descriptor Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Pool</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool
	 * @generated
	 */
	EClass getDescriptorPool();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool#getDescriptorSets <em>Descriptor Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptor Sets</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool#getDescriptorSets()
	 * @see #getDescriptorPool()
	 * @generated
	 */
	EReference getDescriptorPool_DescriptorSets();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer <em>Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer
	 * @generated
	 */
	EClass getConstantBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer#getData()
	 * @see #getConstantBuffer()
	 * @generated
	 */
	EAttribute getConstantBuffer_Data();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer <em>Generic Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Constant Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer
	 * @generated
	 */
	EClass getGenericConstantBuffer();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer#getReferencedVariables <em>Referenced Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Variables</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer#getReferencedVariables()
	 * @see #getGenericConstantBuffer()
	 * @generated
	 */
	EReference getGenericConstantBuffer_ReferencedVariables();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer#getVariablePkg <em>Variable Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer#getVariablePkg()
	 * @see #getGenericConstantBuffer()
	 * @generated
	 */
	EReference getGenericConstantBuffer_VariablePkg();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.IBuffer <em>IBuffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IBuffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IBuffer
	 * @generated
	 */
	EClass getIBuffer();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.vulkanresource.IBuffer#getUsages <em>Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Usages</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IBuffer#getUsages()
	 * @see #getIBuffer()
	 * @generated
	 */
	EAttribute getIBuffer_Usages();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferReference <em>Buffer Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferReference
	 * @generated
	 */
	EClass getBufferReference();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferReference#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Buffers</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferReference#getBuffers()
	 * @see #getBufferReference()
	 * @generated
	 */
	EReference getBufferReference_Buffers();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferReference#getStride <em>Stride</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stride</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferReference#getStride()
	 * @see #getBufferReference()
	 * @generated
	 */
	EAttribute getBufferReference_Stride();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferReference#getIndexType <em>Index Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Type</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferReference#getIndexType()
	 * @see #getBufferReference()
	 * @generated
	 */
	EAttribute getBufferReference_IndexType();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource <em>IBuffer Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IBuffer Data Source</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource
	 * @generated
	 */
	EClass getIBufferDataSource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider <em>Image Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider
	 * @generated
	 */
	EClass getImageDataProvider();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider <em>File Image Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Image Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider
	 * @generated
	 */
	EClass getFileImageDataProvider();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider#getFileImageReference <em>File Image Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File Image Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider#getFileImageReference()
	 * @see #getFileImageDataProvider()
	 * @generated
	 */
	EReference getFileImageDataProvider_FileImageReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider#getFileImageContainment <em>File Image Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File Image Containment</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider#getFileImageContainment()
	 * @see #getFileImageDataProvider()
	 * @generated
	 */
	EReference getFileImageDataProvider_FileImageContainment();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay <em>Image Inlay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Inlay</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay
	 * @generated
	 */
	EClass getImageInlay();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getImage()
	 * @see #getImageInlay()
	 * @generated
	 */
	EReference getImageInlay_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getPosition()
	 * @see #getImageInlay()
	 * @generated
	 */
	EAttribute getImageInlay_Position();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getSize()
	 * @see #getImageInlay()
	 * @generated
	 */
	EAttribute getImageInlay_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getHorizontalRelative <em>Horizontal Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horizontal Relative</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getHorizontalRelative()
	 * @see #getImageInlay()
	 * @generated
	 */
	EAttribute getImageInlay_HorizontalRelative();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getVerticalRelative <em>Vertical Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Relative</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay#getVerticalRelative()
	 * @see #getImageInlay()
	 * @generated
	 */
	EAttribute getImageInlay_VerticalRelative();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.Sampler <em>Sampler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sampler</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.Sampler
	 * @generated
	 */
	EClass getSampler();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.Sampler#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.Sampler#getImage()
	 * @see #getSampler()
	 * @generated
	 */
	EReference getSampler_Image();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor <em>Buffer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor
	 * @generated
	 */
	EClass getBufferDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor#getBuffer()
	 * @see #getBufferDescriptor()
	 * @generated
	 */
	EReference getBufferDescriptor_Buffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor <em>Image Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor
	 * @generated
	 */
	EClass getImageDescriptor();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getImages <em>Images</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Images</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getImages()
	 * @see #getImageDescriptor()
	 * @generated
	 */
	EReference getImageDescriptor_Images();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getSampler <em>Sampler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sampler</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getSampler()
	 * @see #getImageDescriptor()
	 * @generated
	 */
	EReference getImageDescriptor_Sampler();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getLayout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor#getLayout()
	 * @see #getImageDescriptor()
	 * @generated
	 */
	EAttribute getImageDescriptor_Layout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Set</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet
	 * @generated
	 */
	EClass getDescriptorSet();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet#getDescriptors()
	 * @see #getDescriptorSet()
	 * @generated
	 */
	EReference getDescriptorSet_Descriptors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier <em>Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier
	 * @generated
	 */
	EClass getBufferBarrier();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffers</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier#getBuffers()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EReference getBufferBarrier_Buffers();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier <em>Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier
	 * @generated
	 */
	EClass getImageBarrier();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier#getImage()
	 * @see #getImageBarrier()
	 * @generated
	 */
	EReference getImageBarrier_Image();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.Shader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shader</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.Shader
	 * @generated
	 */
	EClass getShader();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.Shader#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.Shader#getFile()
	 * @see #getShader()
	 * @generated
	 */
	EReference getShader_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.Shader#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.Shader#getStage()
	 * @see #getShader()
	 * @generated
	 */
	EAttribute getShader_Stage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.Shader#getConstants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constants</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.Shader#getConstants()
	 * @see #getShader()
	 * @generated
	 */
	EReference getShader_Constants();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk <em>Memory Chunk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Chunk</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk
	 * @generated
	 */
	EClass getMemoryChunk();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk#getParts()
	 * @see #getMemoryChunk()
	 * @generated
	 */
	EReference getMemoryChunk_Parts();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk#getTransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk#getTransferBuffer()
	 * @see #getMemoryChunk()
	 * @generated
	 */
	EReference getMemoryChunk_TransferBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart <em>IMemory Chunk Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMemory Chunk Part</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart
	 * @generated
	 */
	EClass getIMemoryChunkPart();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory <em>Buffer Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Memory</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory
	 * @generated
	 */
	EClass getBufferMemory();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffers</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory#getBuffers()
	 * @see #getBufferMemory()
	 * @generated
	 */
	EReference getBufferMemory_Buffers();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer <em>Static Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer
	 * @generated
	 */
	EClass getStaticBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer#getSize()
	 * @see #getStaticBuffer()
	 * @generated
	 */
	EAttribute getStaticBuffer_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer#isInitWithZero <em>Init With Zero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init With Zero</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer#isInitWithZero()
	 * @see #getStaticBuffer()
	 * @generated
	 */
	EAttribute getStaticBuffer_InitWithZero();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer <em>Data Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer
	 * @generated
	 */
	EClass getDataBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer#getData()
	 * @see #getDataBuffer()
	 * @generated
	 */
	EAttribute getDataBuffer_Data();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer <em>Buffer Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Viewer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer
	 * @generated
	 */
	EClass getBufferViewer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getGrowFactor <em>Grow Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grow Factor</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getGrowFactor()
	 * @see #getBufferViewer()
	 * @generated
	 */
	EAttribute getBufferViewer_GrowFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getGrowThreshold <em>Grow Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grow Threshold</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getGrowThreshold()
	 * @see #getBufferViewer()
	 * @generated
	 */
	EAttribute getBufferViewer_GrowThreshold();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getSize()
	 * @see #getBufferViewer()
	 * @generated
	 */
	EAttribute getBufferViewer_Size();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getDataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Source</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getDataSource()
	 * @see #getBufferViewer()
	 * @generated
	 */
	EReference getBufferViewer_DataSource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage <em>IVulkan Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IVulkan Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage
	 * @generated
	 */
	EClass getIVulkanImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage <em>Composite Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage
	 * @generated
	 */
	EClass getCompositeImage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage#getInlays <em>Inlays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inlays</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage#getInlays()
	 * @see #getCompositeImage()
	 * @generated
	 */
	EReference getCompositeImage_Inlays();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage#getBackground <em>Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Background</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.CompositeImage#getBackground()
	 * @see #getCompositeImage()
	 * @generated
	 */
	EReference getCompositeImage_Background();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.StaticImage <em>Static Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.StaticImage
	 * @generated
	 */
	EClass getStaticImage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.StaticImage#isFillWithZero <em>Fill With Zero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fill With Zero</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.StaticImage#isFillWithZero()
	 * @see #getStaticImage()
	 * @generated
	 */
	EAttribute getStaticImage_FillWithZero();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.StaticImage#getFillWith <em>Fill With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fill With</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.StaticImage#getFillWith()
	 * @see #getStaticImage()
	 * @generated
	 */
	EAttribute getStaticImage_FillWith();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.StaticImage#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.StaticImage#getSize()
	 * @see #getStaticImage()
	 * @generated
	 */
	EAttribute getStaticImage_Size();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer <em>Image Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Viewer</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer
	 * @generated
	 */
	EClass getImageViewer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer#getDataProvider <em>Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer#getDataProvider()
	 * @see #getImageViewer()
	 * @generated
	 */
	EReference getImageViewer_DataProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer#isMipmapEnabled <em>Mipmap Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mipmap Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageViewer#isMipmapEnabled()
	 * @see #getImageViewer()
	 * @generated
	 */
	EAttribute getImageViewer_MipmapEnabled();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex <em>EContext Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EContext Index</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex
	 * @generated
	 */
	EEnum getEContextIndex();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.vulkan.model.vulkanresource.EFlushMode <em>EFlush Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EFlush Mode</em>'.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.EFlushMode
	 * @generated
	 */
	EEnum getEFlushMode();

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
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VulkanResourceFactory getVulkanResourceFactory();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.TransferBufferImpl <em>Transfer Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.TransferBufferImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getTransferBuffer()
		 * @generated
		 */
		EClass TRANSFER_BUFFER = eINSTANCE.getTransferBuffer();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_BUFFER__SIZE = eINSTANCE.getTransferBuffer_Size();

		/**
		 * The meta object literal for the '<em><b>Used To Push</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_BUFFER__USED_TO_PUSH = eINSTANCE.getTransferBuffer_UsedToPush();

		/**
		 * The meta object literal for the '<em><b>Used To Fetch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_BUFFER__USED_TO_FETCH = eINSTANCE.getTransferBuffer_UsedToFetch();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorPoolImpl <em>Descriptor Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorPoolImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getDescriptorPool()
		 * @generated
		 */
		EClass DESCRIPTOR_POOL = eINSTANCE.getDescriptorPool();

		/**
		 * The meta object literal for the '<em><b>Descriptor Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTOR_POOL__DESCRIPTOR_SETS = eINSTANCE.getDescriptorPool_DescriptorSets();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ConstantBufferImpl <em>Constant Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ConstantBufferImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getConstantBuffer()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.GenericConstantBufferImpl <em>Generic Constant Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.GenericConstantBufferImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getGenericConstantBuffer()
		 * @generated
		 */
		EClass GENERIC_CONSTANT_BUFFER = eINSTANCE.getGenericConstantBuffer();

		/**
		 * The meta object literal for the '<em><b>Referenced Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES = eINSTANCE.getGenericConstantBuffer_ReferencedVariables();

		/**
		 * The meta object literal for the '<em><b>Variable Pkg</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_CONSTANT_BUFFER__VARIABLE_PKG = eINSTANCE.getGenericConstantBuffer_VariablePkg();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.IBuffer <em>IBuffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.IBuffer
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getIBuffer()
		 * @generated
		 */
		EClass IBUFFER = eINSTANCE.getIBuffer();

		/**
		 * The meta object literal for the '<em><b>Usages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IBUFFER__USAGES = eINSTANCE.getIBuffer_Usages();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferReferenceImpl <em>Buffer Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferReferenceImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferReference()
		 * @generated
		 */
		EClass BUFFER_REFERENCE = eINSTANCE.getBufferReference();

		/**
		 * The meta object literal for the '<em><b>Buffers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_REFERENCE__BUFFERS = eINSTANCE.getBufferReference_Buffers();

		/**
		 * The meta object literal for the '<em><b>Stride</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_REFERENCE__STRIDE = eINSTANCE.getBufferReference_Stride();

		/**
		 * The meta object literal for the '<em><b>Index Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_REFERENCE__INDEX_TYPE = eINSTANCE.getBufferReference_IndexType();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource <em>IBuffer Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getIBufferDataSource()
		 * @generated
		 */
		EClass IBUFFER_DATA_SOURCE = eINSTANCE.getIBufferDataSource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDataProviderImpl <em>Image Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDataProviderImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageDataProvider()
		 * @generated
		 */
		EClass IMAGE_DATA_PROVIDER = eINSTANCE.getImageDataProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.FileImageDataProviderImpl <em>File Image Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.FileImageDataProviderImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getFileImageDataProvider()
		 * @generated
		 */
		EClass FILE_IMAGE_DATA_PROVIDER = eINSTANCE.getFileImageDataProvider();

		/**
		 * The meta object literal for the '<em><b>File Image Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_REFERENCE = eINSTANCE.getFileImageDataProvider_FileImageReference();

		/**
		 * The meta object literal for the '<em><b>File Image Containment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT = eINSTANCE.getFileImageDataProvider_FileImageContainment();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl <em>Image Inlay</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageInlay()
		 * @generated
		 */
		EClass IMAGE_INLAY = eINSTANCE.getImageInlay();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_INLAY__IMAGE = eINSTANCE.getImageInlay_Image();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INLAY__POSITION = eINSTANCE.getImageInlay_Position();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INLAY__SIZE = eINSTANCE.getImageInlay_Size();

		/**
		 * The meta object literal for the '<em><b>Horizontal Relative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INLAY__HORIZONTAL_RELATIVE = eINSTANCE.getImageInlay_HorizontalRelative();

		/**
		 * The meta object literal for the '<em><b>Vertical Relative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INLAY__VERTICAL_RELATIVE = eINSTANCE.getImageInlay_VerticalRelative();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.SamplerImpl <em>Sampler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.SamplerImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getSampler()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferDescriptorImpl <em>Buffer Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferDescriptor()
		 * @generated
		 */
		EClass BUFFER_DESCRIPTOR = eINSTANCE.getBufferDescriptor();

		/**
		 * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DESCRIPTOR__BUFFER = eINSTANCE.getBufferDescriptor_Buffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl <em>Image Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageDescriptor()
		 * @generated
		 */
		EClass IMAGE_DESCRIPTOR = eINSTANCE.getImageDescriptor();

		/**
		 * The meta object literal for the '<em><b>Images</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_DESCRIPTOR__IMAGES = eINSTANCE.getImageDescriptor_Images();

		/**
		 * The meta object literal for the '<em><b>Sampler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_DESCRIPTOR__SAMPLER = eINSTANCE.getImageDescriptor_Sampler();

		/**
		 * The meta object literal for the '<em><b>Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_DESCRIPTOR__LAYOUT = eINSTANCE.getImageDescriptor_Layout();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorSetImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getDescriptorSet()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferBarrier()
		 * @generated
		 */
		EClass BUFFER_BARRIER = eINSTANCE.getBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Buffers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_BARRIER__BUFFERS = eINSTANCE.getBufferBarrier_Buffers();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageBarrier()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ShaderImpl <em>Shader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ShaderImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getShader()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.MemoryChunkImpl <em>Memory Chunk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.MemoryChunkImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getMemoryChunk()
		 * @generated
		 */
		EClass MEMORY_CHUNK = eINSTANCE.getMemoryChunk();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_CHUNK__PARTS = eINSTANCE.getMemoryChunk_Parts();

		/**
		 * The meta object literal for the '<em><b>Transfer Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_CHUNK__TRANSFER_BUFFER = eINSTANCE.getMemoryChunk_TransferBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart <em>IMemory Chunk Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getIMemoryChunkPart()
		 * @generated
		 */
		EClass IMEMORY_CHUNK_PART = eINSTANCE.getIMemoryChunkPart();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferMemoryImpl <em>Buffer Memory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferMemoryImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferMemory()
		 * @generated
		 */
		EClass BUFFER_MEMORY = eINSTANCE.getBufferMemory();

		/**
		 * The meta object literal for the '<em><b>Buffers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_MEMORY__BUFFERS = eINSTANCE.getBufferMemory_Buffers();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticBufferImpl <em>Static Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticBufferImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getStaticBuffer()
		 * @generated
		 */
		EClass STATIC_BUFFER = eINSTANCE.getStaticBuffer();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_BUFFER__SIZE = eINSTANCE.getStaticBuffer_Size();

		/**
		 * The meta object literal for the '<em><b>Init With Zero</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_BUFFER__INIT_WITH_ZERO = eINSTANCE.getStaticBuffer_InitWithZero();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.DataBufferImpl <em>Data Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.DataBufferImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getDataBuffer()
		 * @generated
		 */
		EClass DATA_BUFFER = eINSTANCE.getDataBuffer();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_BUFFER__DATA = eINSTANCE.getDataBuffer_Data();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl <em>Buffer Viewer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getBufferViewer()
		 * @generated
		 */
		EClass BUFFER_VIEWER = eINSTANCE.getBufferViewer();

		/**
		 * The meta object literal for the '<em><b>Grow Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_VIEWER__GROW_FACTOR = eINSTANCE.getBufferViewer_GrowFactor();

		/**
		 * The meta object literal for the '<em><b>Grow Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_VIEWER__GROW_THRESHOLD = eINSTANCE.getBufferViewer_GrowThreshold();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_VIEWER__SIZE = eINSTANCE.getBufferViewer_Size();

		/**
		 * The meta object literal for the '<em><b>Data Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_VIEWER__DATA_SOURCE = eINSTANCE.getBufferViewer_DataSource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage <em>IVulkan Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getIVulkanImage()
		 * @generated
		 */
		EClass IVULKAN_IMAGE = eINSTANCE.getIVulkanImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.CompositeImageImpl <em>Composite Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.CompositeImageImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getCompositeImage()
		 * @generated
		 */
		EClass COMPOSITE_IMAGE = eINSTANCE.getCompositeImage();

		/**
		 * The meta object literal for the '<em><b>Inlays</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_IMAGE__INLAYS = eINSTANCE.getCompositeImage_Inlays();

		/**
		 * The meta object literal for the '<em><b>Background</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_IMAGE__BACKGROUND = eINSTANCE.getCompositeImage_Background();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticImageImpl <em>Static Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticImageImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getStaticImage()
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
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_IMAGE__SIZE = eINSTANCE.getStaticImage_Size();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageViewerImpl <em>Image Viewer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageViewerImpl
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getImageViewer()
		 * @generated
		 */
		EClass IMAGE_VIEWER = eINSTANCE.getImageViewer();

		/**
		 * The meta object literal for the '<em><b>Data Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_VIEWER__DATA_PROVIDER = eINSTANCE.getImageViewer_DataProvider();

		/**
		 * The meta object literal for the '<em><b>Mipmap Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_VIEWER__MIPMAP_ENABLED = eINSTANCE.getImageViewer_MipmapEnabled();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex <em>EContext Index</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getEContextIndex()
		 * @generated
		 */
		EEnum ECONTEXT_INDEX = eINSTANCE.getEContextIndex();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.vulkanresource.EFlushMode <em>EFlush Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.EFlushMode
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getEFlushMode()
		 * @generated
		 */
		EEnum EFLUSH_MODE = eINSTANCE.getEFlushMode();

		/**
		 * The meta object literal for the '<em>Byte Buffer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.nio.ByteBuffer
		 * @see org.sheepy.lily.vulkan.model.vulkanresource.impl.VulkanResourcePackageImpl#getByteBuffer()
		 * @generated
		 */
		EDataType BYTE_BUFFER = eINSTANCE.getByteBuffer();

	}

} //VulkanResourcePackage
