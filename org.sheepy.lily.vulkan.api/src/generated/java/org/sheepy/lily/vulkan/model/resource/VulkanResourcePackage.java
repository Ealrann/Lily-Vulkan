/**
 */
package org.sheepy.lily.vulkan.model.resource;

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
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory
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
	VulkanResourcePackage eINSTANCE = org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl <em>Transfer Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getTransferBuffer()
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
	int TRANSFER_BUFFER__NAME = ResourcePackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__SIZE = ResourcePackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Used To Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__USED_TO_PUSH = ResourcePackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Used To Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__USED_TO_FETCH = ResourcePackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transfer Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER_FEATURE_COUNT = ResourcePackage.IRESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Transfer Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER_OPERATION_COUNT = ResourcePackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorPoolImpl <em>Descriptor Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorPoolImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getDescriptorPool()
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl <em>Constant Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getConstantBuffer()
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
	int CONSTANT_BUFFER__NAME = ResourcePackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER__DATA = ResourcePackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER_FEATURE_COUNT = ResourcePackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER_OPERATION_COUNT = ResourcePackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.GenericConstantBufferImpl <em>Generic Constant Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.GenericConstantBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getGenericConstantBuffer()
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.IBuffer <em>IBuffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.IBuffer
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getIBuffer()
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
	 * The number of structural features of the '<em>IBuffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IBuffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferReferenceImpl <em>Buffer Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferReferenceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferReference()
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl <em>Buffer Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferDataProvider()
	 * @generated
	 */
	int BUFFER_DATA_PROVIDER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Buffer Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Buffer Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 7;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__FORMAT = ImagePackage.IMAGE_INFO__FORMAT;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__USAGES = ImagePackage.IMAGE_INFO__USAGES;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__TILING = ImagePackage.IMAGE_INFO__TILING;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__MIP_LEVELS = ImagePackage.IMAGE_INFO__MIP_LEVELS;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__INITIAL_LAYOUT = ImagePackage.IMAGE_INFO__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__NAME = ImagePackage.IMAGE_INFO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = ImagePackage.IMAGE_INFO_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = ImagePackage.IMAGE_INFO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl <em>Static Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getStaticImage()
	 * @generated
	 */
	int STATIC_IMAGE = 28;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl <em>File Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getFileImage()
	 * @generated
	 */
	int FILE_IMAGE = 8;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__FORMAT = IMAGE__FORMAT;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__USAGES = IMAGE__USAGES;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__TILING = IMAGE__TILING;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__MIP_LEVELS = IMAGE__MIP_LEVELS;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__FILE = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__MIPMAP_ENABLED = IMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>File Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>File Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl <em>Font Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getFontImage()
	 * @generated
	 */
	int FONT_IMAGE = 9;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__FORMAT = IMAGE__FORMAT;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__USAGES = IMAGE__USAGES;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__TILING = IMAGE__TILING;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__MIP_LEVELS = IMAGE__MIP_LEVELS;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Fonts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE__FONTS = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Font Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Font Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_IMAGE_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeImageImpl <em>Composite Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getCompositeImage()
	 * @generated
	 */
	int COMPOSITE_IMAGE = 10;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__FORMAT = IMAGE__FORMAT;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__USAGES = IMAGE__USAGES;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__TILING = IMAGE__TILING;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__MIP_LEVELS = IMAGE__MIP_LEVELS;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Inlays</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__INLAYS = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Background</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE__BACKGROUND = IMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_IMAGE_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageInlayImpl <em>Image Inlay</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageInlayImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImageInlay()
	 * @generated
	 */
	int IMAGE_INLAY = 11;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl <em>Sampler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getSampler()
	 * @generated
	 */
	int SAMPLER = 12;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDescriptorImpl <em>Buffer Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferDescriptor()
	 * @generated
	 */
	int BUFFER_DESCRIPTOR = 13;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageDescriptorImpl <em>Image Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImageDescriptor()
	 * @generated
	 */
	int IMAGE_DESCRIPTOR = 14;

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
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR__IMAGE = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR__SAMPLER = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Image Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR_FEATURE_COUNT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Image Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR_OPERATION_COUNT = VulkanPackage.IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerDescriptorImpl <em>Sampler Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getSamplerDescriptor()
	 * @generated
	 */
	int SAMPLER_DESCRIPTOR = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_DESCRIPTOR__NAME = VulkanPackage.IDESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_DESCRIPTOR__TYPE = VulkanPackage.IDESCRIPTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_DESCRIPTOR__SHADER_STAGES = VulkanPackage.IDESCRIPTOR__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_DESCRIPTOR__SAMPLER = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sampler Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_DESCRIPTOR_FEATURE_COUNT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sampler Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_DESCRIPTOR_OPERATION_COUNT = VulkanPackage.IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getDescriptorSet()
	 * @generated
	 */
	int DESCRIPTOR_SET = 16;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferBarrier()
	 * @generated
	 */
	int BUFFER_BARRIER = 17;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImageBarrier()
	 * @generated
	 */
	int IMAGE_BARRIER = 18;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl <em>Shader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getShader()
	 * @generated
	 */
	int SHADER = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__NAME = ResourcePackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__FILE = ResourcePackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__STAGE = ResourcePackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__CONSTANTS = ResourcePackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_FEATURE_COUNT = ResourcePackage.IRESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_OPERATION_COUNT = ResourcePackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl <em>Image Array Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImageArrayDescriptor()
	 * @generated
	 */
	int IMAGE_ARRAY_DESCRIPTOR = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ARRAY_DESCRIPTOR__NAME = VulkanPackage.IDESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ARRAY_DESCRIPTOR__TYPE = VulkanPackage.IDESCRIPTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ARRAY_DESCRIPTOR__SHADER_STAGES = VulkanPackage.IDESCRIPTOR__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Images</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ARRAY_DESCRIPTOR__IMAGES = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ARRAY_DESCRIPTOR__INITIAL_LAYOUT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Image Array Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ARRAY_DESCRIPTOR_FEATURE_COUNT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Image Array Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_ARRAY_DESCRIPTOR_OPERATION_COUNT = VulkanPackage.IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.MemoryChunkImpl <em>Memory Chunk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.MemoryChunkImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getMemoryChunk()
	 * @generated
	 */
	int MEMORY_CHUNK = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK__NAME = ResourcePackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK__PARTS = ResourcePackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK__TRANSFER_BUFFER = ResourcePackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Memory Chunk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK_FEATURE_COUNT = ResourcePackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Memory Chunk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_CHUNK_OPERATION_COUNT = ResourcePackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart <em>IMemory Chunk Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getIMemoryChunkPart()
	 * @generated
	 */
	int IMEMORY_CHUNK_PART = 22;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferMemoryImpl <em>Buffer Memory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferMemoryImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferMemory()
	 * @generated
	 */
	int BUFFER_MEMORY = 23;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.IBufferObject <em>IBuffer Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.IBufferObject
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getIBufferObject()
	 * @generated
	 */
	int IBUFFER_OBJECT = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_OBJECT__NAME = IBUFFER__NAME;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_OBJECT__USAGES = IBUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IBuffer Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_OBJECT_FEATURE_COUNT = IBUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>IBuffer Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_OBJECT_OPERATION_COUNT = IBUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StaticBufferImpl <em>Static Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.StaticBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getStaticBuffer()
	 * @generated
	 */
	int STATIC_BUFFER = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER__NAME = IBUFFER_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER__USAGES = IBUFFER_OBJECT__USAGES;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER__SIZE = IBUFFER_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init With Zero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER__INIT_WITH_ZERO = IBUFFER_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Static Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER_FEATURE_COUNT = IBUFFER_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Static Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_BUFFER_OPERATION_COUNT = IBUFFER_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DataBufferImpl <em>Data Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DataBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getDataBuffer()
	 * @generated
	 */
	int DATA_BUFFER = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER__NAME = IBUFFER_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER__USAGES = IBUFFER_OBJECT__USAGES;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER__DATA = IBUFFER_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER_FEATURE_COUNT = IBUFFER_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_BUFFER_OPERATION_COUNT = IBUFFER_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl <em>Buffer Viewer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferViewer()
	 * @generated
	 */
	int BUFFER_VIEWER = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__NAME = IBUFFER_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__USAGES = IBUFFER_OBJECT__USAGES;

	/**
	 * The feature id for the '<em><b>Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__DATA_PROVIDER = IBUFFER_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Grow Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__GROW_FACTOR = IBUFFER_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Grow Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__GROW_THRESHOLD = IBUFFER_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER__SIZE = IBUFFER_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Buffer Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER_FEATURE_COUNT = IBUFFER_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Buffer Viewer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_VIEWER_OPERATION_COUNT = IBUFFER_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FORMAT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__USAGES = IMEMORY_CHUNK_PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__TILING = IMEMORY_CHUNK_PART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__MIP_LEVELS = IMEMORY_CHUNK_PART_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__INITIAL_LAYOUT = IMEMORY_CHUNK_PART_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__NAME = IMEMORY_CHUNK_PART_FEATURE_COUNT + 5;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.EContextIndex <em>EContext Index</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.EContextIndex
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getEContextIndex()
	 * @generated
	 */
	int ECONTEXT_INDEX = 29;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.EFlushMode <em>EFlush Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getEFlushMode()
	 * @generated
	 */
	int EFLUSH_MODE = 30;

	/**
	 * The meta object id for the '<em>Byte Buffer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.ByteBuffer
	 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getByteBuffer()
	 * @generated
	 */
	int BYTE_BUFFER = 31;


	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.TransferBuffer
	 * @generated
	 */
	EClass getTransferBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.TransferBuffer#getSize()
	 * @see #getTransferBuffer()
	 * @generated
	 */
	EAttribute getTransferBuffer_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#isUsedToPush <em>Used To Push</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used To Push</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.TransferBuffer#isUsedToPush()
	 * @see #getTransferBuffer()
	 * @generated
	 */
	EAttribute getTransferBuffer_UsedToPush();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#isUsedToFetch <em>Used To Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used To Fetch</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.TransferBuffer#isUsedToFetch()
	 * @see #getTransferBuffer()
	 * @generated
	 */
	EAttribute getTransferBuffer_UsedToFetch();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.DescriptorPool <em>Descriptor Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Pool</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptorPool
	 * @generated
	 */
	EClass getDescriptorPool();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.DescriptorPool#getDescriptorSets <em>Descriptor Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptor Sets</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptorPool#getDescriptorSets()
	 * @see #getDescriptorPool()
	 * @generated
	 */
	EReference getDescriptorPool_DescriptorSets();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer <em>Generic Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Constant Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer
	 * @generated
	 */
	EClass getGenericConstantBuffer();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer#getReferencedVariables <em>Referenced Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Variables</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer#getReferencedVariables()
	 * @see #getGenericConstantBuffer()
	 * @generated
	 */
	EReference getGenericConstantBuffer_ReferencedVariables();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer#getVariablePkg <em>Variable Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Pkg</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer#getVariablePkg()
	 * @see #getGenericConstantBuffer()
	 * @generated
	 */
	EReference getGenericConstantBuffer_VariablePkg();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferReference <em>Buffer Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferReference
	 * @generated
	 */
	EClass getBufferReference();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Buffers</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferReference#getBuffers()
	 * @see #getBufferReference()
	 * @generated
	 */
	EReference getBufferReference_Buffers();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getStride <em>Stride</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stride</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferReference#getStride()
	 * @see #getBufferReference()
	 * @generated
	 */
	EAttribute getBufferReference_Stride();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferReference#getIndexType <em>Index Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Type</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferReference#getIndexType()
	 * @see #getBufferReference()
	 * @generated
	 */
	EAttribute getBufferReference_IndexType();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image
	 * @generated
	 */
	EClass getImage();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.StaticImage#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StaticImage#getSize()
	 * @see #getStaticImage()
	 * @generated
	 */
	EAttribute getStaticImage_Size();

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
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.FileImage#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File</em>'.
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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.FontImage <em>Font Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FontImage
	 * @generated
	 */
	EClass getFontImage();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.resource.FontImage#getFonts <em>Fonts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fonts</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FontImage#getFonts()
	 * @see #getFontImage()
	 * @generated
	 */
	EReference getFontImage_Fonts();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.CompositeImage <em>Composite Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeImage
	 * @generated
	 */
	EClass getCompositeImage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.CompositeImage#getInlays <em>Inlays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inlays</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeImage#getInlays()
	 * @see #getCompositeImage()
	 * @generated
	 */
	EReference getCompositeImage_Inlays();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.CompositeImage#getBackground <em>Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Background</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeImage#getBackground()
	 * @see #getCompositeImage()
	 * @generated
	 */
	EReference getCompositeImage_Background();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay <em>Image Inlay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Inlay</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageInlay
	 * @generated
	 */
	EClass getImageInlay();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageInlay#getImage()
	 * @see #getImageInlay()
	 * @generated
	 */
	EReference getImageInlay_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageInlay#getPosition()
	 * @see #getImageInlay()
	 * @generated
	 */
	EAttribute getImageInlay_Position();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageInlay#getSize()
	 * @see #getImageInlay()
	 * @generated
	 */
	EAttribute getImageInlay_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getHorizontalRelative <em>Horizontal Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Horizontal Relative</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageInlay#getHorizontalRelative()
	 * @see #getImageInlay()
	 * @generated
	 */
	EAttribute getImageInlay_HorizontalRelative();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getVerticalRelative <em>Vertical Relative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertical Relative</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageInlay#getVerticalRelative()
	 * @see #getImageInlay()
	 * @generated
	 */
	EAttribute getImageInlay_VerticalRelative();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferDescriptor <em>Buffer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDescriptor
	 * @generated
	 */
	EClass getBufferDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.BufferDescriptor#getBuffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDescriptor#getBuffer()
	 * @see #getBufferDescriptor()
	 * @generated
	 */
	EReference getBufferDescriptor_Buffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor <em>Image Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageDescriptor
	 * @generated
	 */
	EClass getImageDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getImage()
	 * @see #getImageDescriptor()
	 * @generated
	 */
	EReference getImageDescriptor_Image();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getSampler <em>Sampler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sampler</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageDescriptor#getSampler()
	 * @see #getImageDescriptor()
	 * @generated
	 */
	EReference getImageDescriptor_Sampler();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.SamplerDescriptor <em>Sampler Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sampler Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.SamplerDescriptor
	 * @generated
	 */
	EClass getSamplerDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.SamplerDescriptor#getSampler <em>Sampler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sampler</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.SamplerDescriptor#getSampler()
	 * @see #getSamplerDescriptor()
	 * @generated
	 */
	EReference getSamplerDescriptor_Sampler();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier <em>Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferBarrier
	 * @generated
	 */
	EClass getBufferBarrier();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffers</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferBarrier#getBuffers()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EReference getBufferBarrier_Buffers();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor <em>Image Array Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Array Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor
	 * @generated
	 */
	EClass getImageArrayDescriptor();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor#getImages <em>Images</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Images</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor#getImages()
	 * @see #getImageArrayDescriptor()
	 * @generated
	 */
	EReference getImageArrayDescriptor_Images();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor#getInitialLayout <em>Initial Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor#getInitialLayout()
	 * @see #getImageArrayDescriptor()
	 * @generated
	 */
	EAttribute getImageArrayDescriptor_InitialLayout();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.MemoryChunk <em>Memory Chunk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Chunk</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.MemoryChunk
	 * @generated
	 */
	EClass getMemoryChunk();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.MemoryChunk#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.MemoryChunk#getParts()
	 * @see #getMemoryChunk()
	 * @generated
	 */
	EReference getMemoryChunk_Parts();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.MemoryChunk#getTransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.MemoryChunk#getTransferBuffer()
	 * @see #getMemoryChunk()
	 * @generated
	 */
	EReference getMemoryChunk_TransferBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart <em>IMemory Chunk Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMemory Chunk Part</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart
	 * @generated
	 */
	EClass getIMemoryChunkPart();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferMemory <em>Buffer Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Memory</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferMemory
	 * @generated
	 */
	EClass getBufferMemory();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.BufferMemory#getBuffers <em>Buffers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buffers</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferMemory#getBuffers()
	 * @see #getBufferMemory()
	 * @generated
	 */
	EReference getBufferMemory_Buffers();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.IBufferObject <em>IBuffer Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IBuffer Object</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.IBufferObject
	 * @generated
	 */
	EClass getIBufferObject();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.IBufferObject#getUsages <em>Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Usages</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.IBufferObject#getUsages()
	 * @see #getIBufferObject()
	 * @generated
	 */
	EAttribute getIBufferObject_Usages();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.StaticBuffer <em>Static Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StaticBuffer
	 * @generated
	 */
	EClass getStaticBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.StaticBuffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StaticBuffer#getSize()
	 * @see #getStaticBuffer()
	 * @generated
	 */
	EAttribute getStaticBuffer_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.StaticBuffer#isInitWithZero <em>Init With Zero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init With Zero</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.StaticBuffer#isInitWithZero()
	 * @see #getStaticBuffer()
	 * @generated
	 */
	EAttribute getStaticBuffer_InitWithZero();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.DataBuffer <em>Data Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DataBuffer
	 * @generated
	 */
	EClass getDataBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.DataBuffer#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DataBuffer#getData()
	 * @see #getDataBuffer()
	 * @generated
	 */
	EAttribute getDataBuffer_Data();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer <em>Buffer Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Viewer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferViewer
	 * @generated
	 */
	EClass getBufferViewer();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getDataProvider <em>Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferViewer#getDataProvider()
	 * @see #getBufferViewer()
	 * @generated
	 */
	EReference getBufferViewer_DataProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getGrowFactor <em>Grow Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grow Factor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferViewer#getGrowFactor()
	 * @see #getBufferViewer()
	 * @generated
	 */
	EAttribute getBufferViewer_GrowFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getGrowThreshold <em>Grow Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grow Threshold</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferViewer#getGrowThreshold()
	 * @see #getBufferViewer()
	 * @generated
	 */
	EAttribute getBufferViewer_GrowThreshold();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferViewer#getSize()
	 * @see #getBufferViewer()
	 * @generated
	 */
	EAttribute getBufferViewer_Size();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.vulkan.model.resource.EContextIndex <em>EContext Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EContext Index</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.EContextIndex
	 * @generated
	 */
	EEnum getEContextIndex();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.vulkan.model.resource.EFlushMode <em>EFlush Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EFlush Mode</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl <em>Transfer Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getTransferBuffer()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorPoolImpl <em>Descriptor Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorPoolImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getDescriptorPool()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl <em>Constant Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getConstantBuffer()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.GenericConstantBufferImpl <em>Generic Constant Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.GenericConstantBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getGenericConstantBuffer()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.IBuffer <em>IBuffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.IBuffer
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getIBuffer()
		 * @generated
		 */
		EClass IBUFFER = eINSTANCE.getIBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferReferenceImpl <em>Buffer Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferReferenceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferReference()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl <em>Buffer Data Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferDataProvider()
		 * @generated
		 */
		EClass BUFFER_DATA_PROVIDER = eINSTANCE.getBufferDataProvider();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl <em>Static Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getStaticImage()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl <em>File Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getFileImage()
		 * @generated
		 */
		EClass FILE_IMAGE = eINSTANCE.getFileImage();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' reference feature.
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl <em>Font Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getFontImage()
		 * @generated
		 */
		EClass FONT_IMAGE = eINSTANCE.getFontImage();

		/**
		 * The meta object literal for the '<em><b>Fonts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FONT_IMAGE__FONTS = eINSTANCE.getFontImage_Fonts();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeImageImpl <em>Composite Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getCompositeImage()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageInlayImpl <em>Image Inlay</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageInlayImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImageInlay()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl <em>Sampler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getSampler()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDescriptorImpl <em>Buffer Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferDescriptor()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageDescriptorImpl <em>Image Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImageDescriptor()
		 * @generated
		 */
		EClass IMAGE_DESCRIPTOR = eINSTANCE.getImageDescriptor();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_DESCRIPTOR__IMAGE = eINSTANCE.getImageDescriptor_Image();

		/**
		 * The meta object literal for the '<em><b>Sampler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_DESCRIPTOR__SAMPLER = eINSTANCE.getImageDescriptor_Sampler();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerDescriptorImpl <em>Sampler Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getSamplerDescriptor()
		 * @generated
		 */
		EClass SAMPLER_DESCRIPTOR = eINSTANCE.getSamplerDescriptor();

		/**
		 * The meta object literal for the '<em><b>Sampler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLER_DESCRIPTOR__SAMPLER = eINSTANCE.getSamplerDescriptor_Sampler();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getDescriptorSet()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferBarrier()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImageBarrier()
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
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getShader()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl <em>Image Array Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getImageArrayDescriptor()
		 * @generated
		 */
		EClass IMAGE_ARRAY_DESCRIPTOR = eINSTANCE.getImageArrayDescriptor();

		/**
		 * The meta object literal for the '<em><b>Images</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_ARRAY_DESCRIPTOR__IMAGES = eINSTANCE.getImageArrayDescriptor_Images();

		/**
		 * The meta object literal for the '<em><b>Initial Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_ARRAY_DESCRIPTOR__INITIAL_LAYOUT = eINSTANCE.getImageArrayDescriptor_InitialLayout();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.MemoryChunkImpl <em>Memory Chunk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.MemoryChunkImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getMemoryChunk()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart <em>IMemory Chunk Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.IMemoryChunkPart
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getIMemoryChunkPart()
		 * @generated
		 */
		EClass IMEMORY_CHUNK_PART = eINSTANCE.getIMemoryChunkPart();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferMemoryImpl <em>Buffer Memory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferMemoryImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferMemory()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.IBufferObject <em>IBuffer Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.IBufferObject
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getIBufferObject()
		 * @generated
		 */
		EClass IBUFFER_OBJECT = eINSTANCE.getIBufferObject();

		/**
		 * The meta object literal for the '<em><b>Usages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IBUFFER_OBJECT__USAGES = eINSTANCE.getIBufferObject_Usages();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StaticBufferImpl <em>Static Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.StaticBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getStaticBuffer()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DataBufferImpl <em>Data Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.DataBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getDataBuffer()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl <em>Buffer Viewer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferViewerImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getBufferViewer()
		 * @generated
		 */
		EClass BUFFER_VIEWER = eINSTANCE.getBufferViewer();

		/**
		 * The meta object literal for the '<em><b>Data Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_VIEWER__DATA_PROVIDER = eINSTANCE.getBufferViewer_DataProvider();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.EContextIndex <em>EContext Index</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.EContextIndex
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getEContextIndex()
		 * @generated
		 */
		EEnum ECONTEXT_INDEX = eINSTANCE.getEContextIndex();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.EFlushMode <em>EFlush Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getEFlushMode()
		 * @generated
		 */
		EEnum EFLUSH_MODE = eINSTANCE.getEFlushMode();

		/**
		 * The meta object literal for the '<em>Byte Buffer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.nio.ByteBuffer
		 * @see org.sheepy.lily.vulkan.model.resource.impl.VulkanResourcePackageImpl#getByteBuffer()
		 * @generated
		 */
		EDataType BYTE_BUFFER = eINSTANCE.getByteBuffer();

	}

} //VulkanResourcePackage
