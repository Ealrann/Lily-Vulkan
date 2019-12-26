/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sheepy.lily.core.model.application.ApplicationPackage;
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl <em>Transfer Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTransferBuffer()
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
	int TRANSFER_BUFFER__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__SIZE = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__INSTANCE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Used To Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__USED_TO_PUSH = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Used To Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER__USED_TO_FETCH = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Transfer Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Transfer Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_BUFFER_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl <em>Constant Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ConstantBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getConstantBuffer()
	 * @generated
	 */
	int CONSTANT_BUFFER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER__DATA = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constant Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_BUFFER_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.IBuffer <em>IBuffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.IBuffer
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getIBuffer()
	 * @generated
	 */
	int IBUFFER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>IBuffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>IBuffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IBUFFER_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__NAME = IBUFFER__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__SIZE = IBUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__USAGES = IBUFFER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__DATA = IBUFFER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kept Mapped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__KEPT_MAPPED = IBUFFER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Host Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__HOST_VISIBLE = IBUFFER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Instance Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__INSTANCE_COUNT = IBUFFER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Coherent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__COHERENT = IBUFFER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = IBUFFER_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = IBUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl <em>Composite Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositeBuffer()
	 * @generated
	 */
	int COMPOSITE_BUFFER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER__NAME = IBUFFER__NAME;

	/**
	 * The feature id for the '<em><b>Data Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER__DATA_PROVIDERS = IBUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER__TRANSFER_BUFFER = IBUFFER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Min Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER__MIN_SIZE = IBUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_FEATURE_COUNT = IBUFFER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Composite Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_OPERATION_COUNT = IBUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositePartReferenceImpl <em>Composite Part Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositePartReferenceImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositePartReference()
	 * @generated
	 */
	int COMPOSITE_PART_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART_REFERENCE__NAME = TypesPackage.LNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART_REFERENCE__PART = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART_REFERENCE__INSTANCE = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Part Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART_REFERENCE_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Part Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PART_REFERENCE_OPERATION_COUNT = TypesPackage.LNAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.IBufferReference <em>IBuffer Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.IBufferReference
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getIBufferReference()
	 * @generated
	 */
	int IBUFFER_REFERENCE = 6;

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
	int BUFFER_REFERENCE = 7;

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
	int COMPOSITE_BUFFER_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE__NAME = COMPOSITE_PART_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE__PART = COMPOSITE_PART_REFERENCE__PART;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE__INSTANCE = COMPOSITE_PART_REFERENCE__INSTANCE;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE__BUFFER = COMPOSITE_PART_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Buffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE_FEATURE_COUNT = COMPOSITE_PART_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Buffer Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_REFERENCE_OPERATION_COUNT = COMPOSITE_PART_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl <em>Buffer Data Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDataProviderImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferDataProvider()
	 * @generated
	 */
	int BUFFER_DATA_PROVIDER = 9;

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
	 * The feature id for the '<em><b>Used To Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__USED_TO_PUSH = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Used To Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__USED_TO_FETCH = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Stage Before Push</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Access Before Push</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Stage Before Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Access Before Fetch</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Grow Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__GROW_FACTOR = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Grow Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER__GROW_THRESHOLD = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Buffer Data Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DATA_PROVIDER_FEATURE_COUNT = TypesPackage.LNAMED_ELEMENT_FEATURE_COUNT + 11;

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
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__FORMAT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__USAGES = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__TILING = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__MIP_LEVELS = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__INITIAL_LAYOUT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl <em>Static Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getStaticImage()
	 * @generated
	 */
	int STATIC_IMAGE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FORMAT = IMAGE__FORMAT;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__USAGES = IMAGE__USAGES;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__TILING = IMAGE__TILING;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__MIP_LEVELS = IMAGE__MIP_LEVELS;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Fill With Zero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FILL_WITH_ZERO = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fill With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__FILL_WITH = IMAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE__SIZE = IMAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Static Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_IMAGE_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 3;

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
	int FILE_IMAGE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_IMAGE__NAME = IMAGE__NAME;

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
	 * The feature id for the '<em><b>File</b></em>' containment reference.
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl <em>Sampled Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampledImage()
	 * @generated
	 */
	int SAMPLED_IMAGE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__SAMPLER = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__IMAGE = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sampled Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sampled Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl <em>Sampler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampler()
	 * @generated
	 */
	int SAMPLER = 14;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl <em>Semaphore</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSemaphore()
	 * @generated
	 */
	int SEMAPHORE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Signalized At Init</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE__SIGNALIZED_AT_INIT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Wait Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE__WAIT_STAGE = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Semaphore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Semaphore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMAPHORE_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDescriptorImpl <em>Buffer Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferDescriptor()
	 * @generated
	 */
	int BUFFER_DESCRIPTOR = 16;

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
	 * The feature id for the '<em><b>Buffer Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_DESCRIPTOR__BUFFER_REFERENCE = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 0;

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
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageDescriptor()
	 * @generated
	 */
	int IMAGE_DESCRIPTOR = 17;

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
	 * The number of structural features of the '<em>Image Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR_FEATURE_COUNT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Image Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_DESCRIPTOR_OPERATION_COUNT = VulkanPackage.IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageDescriptorImpl <em>Sampled Image Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SampledImageDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampledImageDescriptor()
	 * @generated
	 */
	int SAMPLED_IMAGE_DESCRIPTOR = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_DESCRIPTOR__NAME = VulkanPackage.IDESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_DESCRIPTOR__TYPE = VulkanPackage.IDESCRIPTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_DESCRIPTOR__SHADER_STAGES = VulkanPackage.IDESCRIPTOR__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Sampled Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_DESCRIPTOR__SAMPLED_IMAGE = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sampled Image Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_DESCRIPTOR_FEATURE_COUNT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sampled Image Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_DESCRIPTOR_OPERATION_COUNT = VulkanPackage.IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerDescriptorImpl <em>Sampler Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSamplerDescriptor()
	 * @generated
	 */
	int SAMPLER_DESCRIPTOR = 19;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayDescriptorImpl <em>Texture2 DArray Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayDescriptorImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTexture2DArrayDescriptor()
	 * @generated
	 */
	int TEXTURE2_DARRAY_DESCRIPTOR = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_DESCRIPTOR__NAME = VulkanPackage.IDESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_DESCRIPTOR__TYPE = VulkanPackage.IDESCRIPTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_DESCRIPTOR__SHADER_STAGES = VulkanPackage.IDESCRIPTOR__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Texture Array</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE_ARRAY = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Texture2 DArray Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_DESCRIPTOR_FEATURE_COUNT = VulkanPackage.IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Texture2 DArray Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_DESCRIPTOR_OPERATION_COUNT = VulkanPackage.IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorSet()
	 * @generated
	 */
	int DESCRIPTOR_SET = 21;

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
	int DESCRIPTOR_SET_PKG = 22;

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
	int BUFFER_BARRIER = 23;

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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferBarrierImpl <em>Composite Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositeBufferBarrier()
	 * @generated
	 */
	int COMPOSITE_BUFFER_BARRIER = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_BARRIER__NAME = BarrierPackage.ABSTRACT_BUFFER_BARRIER__NAME;

	/**
	 * The feature id for the '<em><b>Src Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_BARRIER__SRC_ACCESS_MASK = BarrierPackage.ABSTRACT_BUFFER_BARRIER__SRC_ACCESS_MASK;

	/**
	 * The feature id for the '<em><b>Dst Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_BARRIER__DST_ACCESS_MASK = BarrierPackage.ABSTRACT_BUFFER_BARRIER__DST_ACCESS_MASK;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_BARRIER__INSTANCE = BarrierPackage.ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER = BarrierPackage.ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_BARRIER_FEATURE_COUNT = BarrierPackage.ABSTRACT_BUFFER_BARRIER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_BUFFER_BARRIER_OPERATION_COUNT = BarrierPackage.ABSTRACT_BUFFER_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageBarrier()
	 * @generated
	 */
	int IMAGE_BARRIER = 25;

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
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getShader()
	 * @generated
	 */
	int SHADER = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__NAME = ApplicationPackage.IRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__FILE = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__STAGE = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__CONSTANTS = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_FEATURE_COUNT = ApplicationPackage.IRESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_OPERATION_COUNT = ApplicationPackage.IRESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ITextureArrayImpl <em>ITexture Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ITextureArrayImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getITextureArray()
	 * @generated
	 */
	int ITEXTURE_ARRAY = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEXTURE_ARRAY__NAME = IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEXTURE_ARRAY__FORMAT = IMAGE__FORMAT;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEXTURE_ARRAY__USAGES = IMAGE__USAGES;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEXTURE_ARRAY__TILING = IMAGE__TILING;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEXTURE_ARRAY__MIP_LEVELS = IMAGE__MIP_LEVELS;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEXTURE_ARRAY__INITIAL_LAYOUT = IMAGE__INITIAL_LAYOUT;

	/**
	 * The number of structural features of the '<em>ITexture Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEXTURE_ARRAY_FEATURE_COUNT = IMAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>ITexture Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEXTURE_ARRAY_OPERATION_COUNT = IMAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayImpl <em>Texture2 DArray</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTexture2DArray()
	 * @generated
	 */
	int TEXTURE2_DARRAY = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__NAME = ITEXTURE_ARRAY__NAME;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__FORMAT = ITEXTURE_ARRAY__FORMAT;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__USAGES = ITEXTURE_ARRAY__USAGES;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__TILING = ITEXTURE_ARRAY__TILING;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__MIP_LEVELS = ITEXTURE_ARRAY__MIP_LEVELS;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__INITIAL_LAYOUT = ITEXTURE_ARRAY__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__FILES = ITEXTURE_ARRAY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY__MIPMAP_ENABLED = ITEXTURE_ARRAY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Texture2 DArray</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_FEATURE_COUNT = ITEXTURE_ARRAY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Texture2 DArray</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE2_DARRAY_OPERATION_COUNT = ITEXTURE_ARRAY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FontTextureArrayImpl <em>Font Texture Array</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.FontTextureArrayImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFontTextureArray()
	 * @generated
	 */
	int FONT_TEXTURE_ARRAY = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY__NAME = ITEXTURE_ARRAY__NAME;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY__FORMAT = ITEXTURE_ARRAY__FORMAT;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY__USAGES = ITEXTURE_ARRAY__USAGES;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY__TILING = ITEXTURE_ARRAY__TILING;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY__MIP_LEVELS = ITEXTURE_ARRAY__MIP_LEVELS;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY__INITIAL_LAYOUT = ITEXTURE_ARRAY__INITIAL_LAYOUT;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY__HEIGHT = ITEXTURE_ARRAY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fonts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY__FONTS = ITEXTURE_ARRAY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Font Texture Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY_FEATURE_COUNT = ITEXTURE_ARRAY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Font Texture Array</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_TEXTURE_ARRAY_OPERATION_COUNT = ITEXTURE_ARRAY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.EFlushMode <em>EFlush Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getEFlushMode()
	 * @generated
	 */
	int EFLUSH_MODE = 30;

	/**
	 * The meta object id for the '<em>Byte Buffer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.ByteBuffer
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getByteBuffer()
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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#getInstanceCount <em>Instance Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Count</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.TransferBuffer#getInstanceCount()
	 * @see #getTransferBuffer()
	 * @generated
	 */
	EAttribute getTransferBuffer_InstanceCount();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isKeptMapped <em>Kept Mapped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kept Mapped</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#isKeptMapped()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_KeptMapped();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isHostVisible <em>Host Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host Visible</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#isHostVisible()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_HostVisible();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isCoherent <em>Coherent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coherent</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Buffer#isCoherent()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Coherent();

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
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getTransferBuffer <em>Transfer Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transfer Buffer</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getTransferBuffer()
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	EReference getCompositeBuffer_TransferBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getMinSize <em>Min Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Size</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getMinSize()
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	EAttribute getCompositeBuffer_MinSize();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.CompositePartReference <em>Composite Part Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Part Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositePartReference
	 * @generated
	 */
	EClass getCompositePartReference();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.CompositePartReference#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositePartReference#getPart()
	 * @see #getCompositePartReference()
	 * @generated
	 */
	EAttribute getCompositePartReference_Part();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.CompositePartReference#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositePartReference#getInstance()
	 * @see #getCompositePartReference()
	 * @generated
	 */
	EAttribute getCompositePartReference_Instance();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToPush <em>Used To Push</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used To Push</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToPush()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_UsedToPush();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToFetch <em>Used To Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used To Fetch</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#isUsedToFetch()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_UsedToFetch();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforePush <em>Stage Before Push</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage Before Push</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforePush()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_StageBeforePush();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getAccessBeforePush <em>Access Before Push</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Access Before Push</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getAccessBeforePush()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_AccessBeforePush();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforeFetch <em>Stage Before Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage Before Fetch</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getStageBeforeFetch()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_StageBeforeFetch();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getAccessBeforeFetch <em>Access Before Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Access Before Fetch</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getAccessBeforeFetch()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_AccessBeforeFetch();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowFactor <em>Grow Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grow Factor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowFactor()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_GrowFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowThreshold <em>Grow Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grow Threshold</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getGrowThreshold()
	 * @see #getBufferDataProvider()
	 * @generated
	 */
	EAttribute getBufferDataProvider_GrowThreshold();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.BufferDescriptor <em>Buffer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDescriptor
	 * @generated
	 */
	EClass getBufferDescriptor();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.BufferDescriptor#getBufferReference <em>Buffer Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Buffer Reference</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferDescriptor#getBufferReference()
	 * @see #getBufferDescriptor()
	 * @generated
	 */
	EReference getBufferDescriptor_BufferReference();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor <em>Sampled Image Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sampled Image Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor
	 * @generated
	 */
	EClass getSampledImageDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor#getSampledImage <em>Sampled Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sampled Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor#getSampledImage()
	 * @see #getSampledImageDescriptor()
	 * @generated
	 */
	EReference getSampledImageDescriptor_SampledImage();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor <em>Texture2 DArray Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Texture2 DArray Descriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor
	 * @generated
	 */
	EClass getTexture2DArrayDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor#getTextureArray <em>Texture Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Texture Array</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor#getTextureArray()
	 * @see #getTexture2DArrayDescriptor()
	 * @generated
	 */
	EReference getTexture2DArrayDescriptor_TextureArray();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier <em>Composite Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Buffer Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier
	 * @generated
	 */
	EClass getCompositeBufferBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier#getInstance()
	 * @see #getCompositeBufferBarrier()
	 * @generated
	 */
	EAttribute getCompositeBufferBarrier_Instance();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier#getDataProvider <em>Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Provider</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier#getDataProvider()
	 * @see #getCompositeBufferBarrier()
	 * @generated
	 */
	EReference getCompositeBufferBarrier_DataProvider();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ITextureArray <em>ITexture Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITexture Array</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ITextureArray
	 * @generated
	 */
	EClass getITextureArray();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.FontTextureArray <em>Font Texture Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Texture Array</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FontTextureArray
	 * @generated
	 */
	EClass getFontTextureArray();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.FontTextureArray#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FontTextureArray#getHeight()
	 * @see #getFontTextureArray()
	 * @generated
	 */
	EAttribute getFontTextureArray_Height();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.FontTextureArray#getFonts <em>Fonts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fonts</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.FontTextureArray#getFonts()
	 * @see #getFontTextureArray()
	 * @generated
	 */
	EReference getFontTextureArray_Fonts();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl <em>Transfer Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTransferBuffer()
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
		 * The meta object literal for the '<em><b>Instance Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_BUFFER__INSTANCE_COUNT = eINSTANCE.getTransferBuffer_InstanceCount();

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
		 * The meta object literal for the '<em><b>Kept Mapped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__KEPT_MAPPED = eINSTANCE.getBuffer_KeptMapped();

		/**
		 * The meta object literal for the '<em><b>Host Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__HOST_VISIBLE = eINSTANCE.getBuffer_HostVisible();

		/**
		 * The meta object literal for the '<em><b>Instance Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__INSTANCE_COUNT = eINSTANCE.getBuffer_InstanceCount();

		/**
		 * The meta object literal for the '<em><b>Coherent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__COHERENT = eINSTANCE.getBuffer_Coherent();

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
		 * The meta object literal for the '<em><b>Transfer Buffer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_BUFFER__TRANSFER_BUFFER = eINSTANCE.getCompositeBuffer_TransferBuffer();

		/**
		 * The meta object literal for the '<em><b>Min Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_BUFFER__MIN_SIZE = eINSTANCE.getCompositeBuffer_MinSize();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositePartReferenceImpl <em>Composite Part Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositePartReferenceImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositePartReference()
		 * @generated
		 */
		EClass COMPOSITE_PART_REFERENCE = eINSTANCE.getCompositePartReference();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_PART_REFERENCE__PART = eINSTANCE.getCompositePartReference_Part();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_PART_REFERENCE__INSTANCE = eINSTANCE.getCompositePartReference_Instance();

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
		 * The meta object literal for the '<em><b>Used To Push</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__USED_TO_PUSH = eINSTANCE.getBufferDataProvider_UsedToPush();

		/**
		 * The meta object literal for the '<em><b>Used To Fetch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__USED_TO_FETCH = eINSTANCE.getBufferDataProvider_UsedToFetch();

		/**
		 * The meta object literal for the '<em><b>Stage Before Push</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__STAGE_BEFORE_PUSH = eINSTANCE.getBufferDataProvider_StageBeforePush();

		/**
		 * The meta object literal for the '<em><b>Access Before Push</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__ACCESS_BEFORE_PUSH = eINSTANCE.getBufferDataProvider_AccessBeforePush();

		/**
		 * The meta object literal for the '<em><b>Stage Before Fetch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__STAGE_BEFORE_FETCH = eINSTANCE.getBufferDataProvider_StageBeforeFetch();

		/**
		 * The meta object literal for the '<em><b>Access Before Fetch</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__ACCESS_BEFORE_FETCH = eINSTANCE.getBufferDataProvider_AccessBeforeFetch();

		/**
		 * The meta object literal for the '<em><b>Grow Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__GROW_FACTOR = eINSTANCE.getBufferDataProvider_GrowFactor();

		/**
		 * The meta object literal for the '<em><b>Grow Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_DATA_PROVIDER__GROW_THRESHOLD = eINSTANCE.getBufferDataProvider_GrowThreshold();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferDescriptorImpl <em>Buffer Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferDescriptor()
		 * @generated
		 */
		EClass BUFFER_DESCRIPTOR = eINSTANCE.getBufferDescriptor();

		/**
		 * The meta object literal for the '<em><b>Buffer Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_DESCRIPTOR__BUFFER_REFERENCE = eINSTANCE.getBufferDescriptor_BufferReference();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageDescriptorImpl <em>Image Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageDescriptor()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageDescriptorImpl <em>Sampled Image Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.SampledImageDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampledImageDescriptor()
		 * @generated
		 */
		EClass SAMPLED_IMAGE_DESCRIPTOR = eINSTANCE.getSampledImageDescriptor();

		/**
		 * The meta object literal for the '<em><b>Sampled Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAMPLED_IMAGE_DESCRIPTOR__SAMPLED_IMAGE = eINSTANCE.getSampledImageDescriptor_SampledImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerDescriptorImpl <em>Sampler Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSamplerDescriptor()
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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayDescriptorImpl <em>Texture2 DArray Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayDescriptorImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTexture2DArrayDescriptor()
		 * @generated
		 */
		EClass TEXTURE2_DARRAY_DESCRIPTOR = eINSTANCE.getTexture2DArrayDescriptor();

		/**
		 * The meta object literal for the '<em><b>Texture Array</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE_ARRAY = eINSTANCE.getTexture2DArrayDescriptor_TextureArray();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferBarrierImpl <em>Composite Buffer Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getCompositeBufferBarrier()
		 * @generated
		 */
		EClass COMPOSITE_BUFFER_BARRIER = eINSTANCE.getCompositeBufferBarrier();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_BUFFER_BARRIER__INSTANCE = eINSTANCE.getCompositeBufferBarrier_Instance();

		/**
		 * The meta object literal for the '<em><b>Data Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER = eINSTANCE.getCompositeBufferBarrier_DataProvider();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ITextureArrayImpl <em>ITexture Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ITextureArrayImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getITextureArray()
		 * @generated
		 */
		EClass ITEXTURE_ARRAY = eINSTANCE.getITextureArray();

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
		 * The meta object literal for the '<em><b>Mipmap Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTURE2_DARRAY__MIPMAP_ENABLED = eINSTANCE.getTexture2DArray_MipmapEnabled();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FontTextureArrayImpl <em>Font Texture Array</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.FontTextureArrayImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFontTextureArray()
		 * @generated
		 */
		EClass FONT_TEXTURE_ARRAY = eINSTANCE.getFontTextureArray();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_TEXTURE_ARRAY__HEIGHT = eINSTANCE.getFontTextureArray_Height();

		/**
		 * The meta object literal for the '<em><b>Fonts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FONT_TEXTURE_ARRAY__FONTS = eINSTANCE.getFontTextureArray_Fonts();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.EFlushMode <em>EFlush Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getEFlushMode()
		 * @generated
		 */
		EEnum EFLUSH_MODE = eINSTANCE.getEFlushMode();

		/**
		 * The meta object literal for the '<em>Byte Buffer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.nio.ByteBuffer
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getByteBuffer()
		 * @generated
		 */
		EDataType BYTE_BUFFER = eINSTANCE.getByteBuffer();

	}

} //ResourcePackage
