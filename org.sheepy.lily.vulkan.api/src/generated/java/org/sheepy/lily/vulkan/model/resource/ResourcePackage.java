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
 *        annotation="http://www.eclipse.org/emf/2002/GenModel cleanup='true' codeFormatting='true' modelDirectory='/org.sheepy.lily.vulkan.model/src/generated/java' editDirectory='/org.sheepy.lily.vulkan.model.edit/src/generated/java' publicConstructors='true' complianceLevel='11.0' resource='XMI' extensibleProviderFactory='true' childCreationExtenders='true' updateClasspath='false' basePackage='org.sheepy.lily.vulkan.model'"
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
	ResourcePackage eINSTANCE = org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.BasicResource <em>Basic Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.BasicResource
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
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.IDescriptor <em>IDescriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.IDescriptor
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getIDescriptor()
	 * @generated
	 */
	int IDESCRIPTOR = 14;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR__DESCRIPTOR_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR__SHADER_STAGES = 1;

	/**
	 * The number of structural features of the '<em>IDescriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>IDescriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.DescriptorResource <em>Descriptor Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptorResource
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorResource()
	 * @generated
	 */
	int DESCRIPTOR_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_RESOURCE__DESCRIPTOR_TYPE = IDESCRIPTOR__DESCRIPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_RESOURCE__SHADER_STAGES = IDESCRIPTOR__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_RESOURCE__NAME = IDESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Descriptor Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_RESOURCE_FEATURE_COUNT = IDESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Descriptor Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_RESOURCE_OPERATION_COUNT = IDESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 2;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__DESCRIPTOR_TYPE = DESCRIPTOR_RESOURCE__DESCRIPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__SHADER_STAGES = DESCRIPTOR_RESOURCE__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__NAME = DESCRIPTOR_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__SIZE = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__USAGES = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__DATA = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Often Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__OFTEN_UPDATED = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Gpu Buffer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__GPU_BUFFER = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = DESCRIPTOR_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 3;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__DESCRIPTOR_TYPE = DESCRIPTOR_RESOURCE__DESCRIPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__SHADER_STAGES = DESCRIPTOR_RESOURCE__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__NAME = DESCRIPTOR_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__WIDTH = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__HEIGHT = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__FORMAT = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__USAGES = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__PROPERTIES = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__TILING = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__MIP_LEVELS = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__INITIAL_LAYOUT = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = DESCRIPTOR_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageLayoutImpl <em>Image Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageLayoutImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageLayout()
	 * @generated
	 */
	int IMAGE_LAYOUT = 5;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl <em>Sampled Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampledImage()
	 * @generated
	 */
	int SAMPLED_IMAGE = 6;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl <em>Semaphore</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSemaphore()
	 * @generated
	 */
	int SEMAPHORE = 7;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FontImpl <em>Font</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.FontImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFont()
	 * @generated
	 */
	int FONT = 8;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractTextureImpl <em>Abstract Texture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.AbstractTextureImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getAbstractTexture()
	 * @generated
	 */
	int ABSTRACT_TEXTURE = 9;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.TextureImpl <em>Texture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.TextureImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTexture()
	 * @generated
	 */
	int TEXTURE = 10;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl <em>Sampler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getSampler()
	 * @generated
	 */
	int SAMPLER = 11;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractConstantsImpl <em>Abstract Constants</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.AbstractConstantsImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getAbstractConstants()
	 * @generated
	 */
	int ABSTRACT_CONSTANTS = 12;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ConstantsImpl <em>Constants</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ConstantsImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getConstants()
	 * @generated
	 */
	int CONSTANTS = 13;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DescriptorSetImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorSet()
	 * @generated
	 */
	int DESCRIPTOR_SET = 15;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BarrierImpl <em>Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBarrier()
	 * @generated
	 */
	int BARRIER = 16;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl <em>Buffer Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBufferBarrier()
	 * @generated
	 */
	int BUFFER_BARRIER = 17;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractImageBarrierImpl <em>Abstract Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.AbstractImageBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getAbstractImageBarrier()
	 * @generated
	 */
	int ABSTRACT_IMAGE_BARRIER = 18;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl <em>Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageBarrier()
	 * @generated
	 */
	int IMAGE_BARRIER = 19;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ReferenceImageBarrierImpl <em>Reference Image Barrier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ReferenceImageBarrierImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getReferenceImageBarrier()
	 * @generated
	 */
	int REFERENCE_IMAGE_BARRIER = 20;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageTransitionImpl <em>Image Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageTransitionImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageTransition()
	 * @generated
	 */
	int IMAGE_TRANSITION = 21;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl <em>Shader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getShader()
	 * @generated
	 */
	int SHADER = 22;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DepthImageImpl <em>Depth Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.model.resource.impl.DepthImageImpl
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDepthImage()
	 * @generated
	 */
	int DEPTH_IMAGE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_IMAGE__NAME = VulkanPackage.IRESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>Depth Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_IMAGE_FEATURE_COUNT = VulkanPackage.IRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Depth Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_IMAGE_OPERATION_COUNT = VulkanPackage.IRESOURCE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__DESCRIPTOR_TYPE = DESCRIPTOR_RESOURCE__DESCRIPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__SHADER_STAGES = DESCRIPTOR_RESOURCE__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__NAME = DESCRIPTOR_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE__SAMPLER = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sampled Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_FEATURE_COUNT = DESCRIPTOR_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sampled Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLED_IMAGE_OPERATION_COUNT = DESCRIPTOR_RESOURCE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__DESCRIPTOR_TYPE = SAMPLED_IMAGE__DESCRIPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__SHADER_STAGES = SAMPLED_IMAGE__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__NAME = SAMPLED_IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__SAMPLER = SAMPLED_IMAGE__SAMPLER;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__FILE = SAMPLED_IMAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__HEIGHT = SAMPLED_IMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Font</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_FEATURE_COUNT = SAMPLED_IMAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Font</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_OPERATION_COUNT = SAMPLED_IMAGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTURE__DESCRIPTOR_TYPE = SAMPLED_IMAGE__DESCRIPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTURE__SHADER_STAGES = SAMPLED_IMAGE__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTURE__NAME = SAMPLED_IMAGE__NAME;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTURE__SAMPLER = SAMPLED_IMAGE__SAMPLER;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTURE__MIPMAP_ENABLED = SAMPLED_IMAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Texture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTURE_FEATURE_COUNT = SAMPLED_IMAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Texture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TEXTURE_OPERATION_COUNT = SAMPLED_IMAGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__DESCRIPTOR_TYPE = ABSTRACT_TEXTURE__DESCRIPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__SHADER_STAGES = ABSTRACT_TEXTURE__SHADER_STAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__NAME = ABSTRACT_TEXTURE__NAME;

	/**
	 * The feature id for the '<em><b>Sampler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__SAMPLER = ABSTRACT_TEXTURE__SAMPLER;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__MIPMAP_ENABLED = ABSTRACT_TEXTURE__MIPMAP_ENABLED;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__FILE = ABSTRACT_TEXTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Texture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE_FEATURE_COUNT = ABSTRACT_TEXTURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Texture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE_OPERATION_COUNT = ABSTRACT_TEXTURE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MIN_FILTER = 0;

	/**
	 * The feature id for the '<em><b>Mag Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MAG_FILTER = 1;

	/**
	 * The feature id for the '<em><b>Mipmap Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MIPMAP_MODE = 2;

	/**
	 * The feature id for the '<em><b>Address Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__ADDRESS_MODE = 3;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__BORDER_COLOR = 4;

	/**
	 * The feature id for the '<em><b>Anisotropy Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__ANISOTROPY_ENABLED = 5;

	/**
	 * The feature id for the '<em><b>Unnormalized Coordinates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__UNNORMALIZED_COORDINATES = 6;

	/**
	 * The feature id for the '<em><b>Compare Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__COMPARE_ENABLE = 7;

	/**
	 * The feature id for the '<em><b>Lod Bias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__LOD_BIAS = 8;

	/**
	 * The feature id for the '<em><b>Min Lod</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MIN_LOD = 9;

	/**
	 * The feature id for the '<em><b>Max Lod</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MAX_LOD = 10;

	/**
	 * The feature id for the '<em><b>Max Anisotropy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER__MAX_ANISOTROPY = 11;

	/**
	 * The number of structural features of the '<em>Sampler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Sampler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTANTS__NAME = BASIC_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTANTS__STAGES = BASIC_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTANTS_FEATURE_COUNT = BASIC_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTANTS_OPERATION_COUNT = BASIC_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTS__NAME = ABSTRACT_CONSTANTS__NAME;

	/**
	 * The feature id for the '<em><b>Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTS__STAGES = ABSTRACT_CONSTANTS__STAGES;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTS__DATA = ABSTRACT_CONSTANTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTS_FEATURE_COUNT = ABSTRACT_CONSTANTS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANTS_OPERATION_COUNT = ABSTRACT_CONSTANTS_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER__SRC_STAGE = 0;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER__DST_STAGE = 1;

	/**
	 * The number of structural features of the '<em>Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BARRIER_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__SRC_STAGE = BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__DST_STAGE = BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__BUFFER = BARRIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__SRC_ACCESS = BARRIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER__DST_ACCESS = BARRIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER_FEATURE_COUNT = BARRIER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Buffer Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_BARRIER_OPERATION_COUNT = BARRIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__SRC_STAGE = BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__DST_STAGE = BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER__TRANSITIONS = BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT = BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT = BARRIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__SRC_STAGE = ABSTRACT_IMAGE_BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__DST_STAGE = ABSTRACT_IMAGE_BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__TRANSITIONS = ABSTRACT_IMAGE_BARRIER__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER__IMAGE = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER_FEATURE_COUNT = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_BARRIER_OPERATION_COUNT = ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__SRC_STAGE = ABSTRACT_IMAGE_BARRIER__SRC_STAGE;

	/**
	 * The feature id for the '<em><b>Dst Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__DST_STAGE = ABSTRACT_IMAGE_BARRIER__DST_STAGE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__TRANSITIONS = ABSTRACT_IMAGE_BARRIER__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__IMAGE_ID = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__MIP_LEVELS = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER_FEATURE_COUNT = ABSTRACT_IMAGE_BARRIER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Reference Image Barrier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_IMAGE_BARRIER_OPERATION_COUNT = ABSTRACT_IMAGE_BARRIER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__SRC_LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Dst Layout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__DST_LAYOUT = 1;

	/**
	 * The feature id for the '<em><b>Src Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__SRC_ACCESS_MASK = 2;

	/**
	 * The feature id for the '<em><b>Dst Access Mask</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION__DST_ACCESS_MASK = 3;

	/**
	 * The number of structural features of the '<em>Image Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Image Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_TRANSITION_OPERATION_COUNT = 0;

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
	 * The number of structural features of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_FEATURE_COUNT = BASIC_RESOURCE_FEATURE_COUNT + 2;

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
	int PATH_RESOURCE = 23;

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
	int FILE_RESOURCE = 24;

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
	int ABSTRACT_MODULE_RESOURCE = 25;

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
	int MODULE_RESOURCE = 26;

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
	int STRING_MODULE_RESOURCE = 27;

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
	 * The meta object id for the '<em>Byte Buffer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.ByteBuffer
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getByteBuffer()
	 * @generated
	 */
	int BYTE_BUFFER = 28;

	/**
	 * The meta object id for the '<em>Java Module</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Module
	 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getJavaModule()
	 * @generated
	 */
	int JAVA_MODULE = 29;

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.DescriptorResource <em>Descriptor Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Resource</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DescriptorResource
	 * @generated
	 */
	EClass getDescriptorResource();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Image#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image#getWidth()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Image#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image#getHeight()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Image#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image#getFormat()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Format();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.Image#getUsages <em>Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Usages</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image#getUsages()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Usages();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Image#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image#getProperties()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Properties();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Image#getTiling <em>Tiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tiling</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image#getTiling()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Tiling();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Image#getMipLevels <em>Mip Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mip Levels</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Image#getMipLevels()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_MipLevels();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Font <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Font
	 * @generated
	 */
	EClass getFont();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.Font#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Font#getFile()
	 * @see #getFont()
	 * @generated
	 */
	EReference getFont_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Font#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Font#getHeight()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Height();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.AbstractTexture <em>Abstract Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Texture</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.AbstractTexture
	 * @generated
	 */
	EClass getAbstractTexture();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.AbstractTexture#isMipmapEnabled <em>Mipmap Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mipmap Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.AbstractTexture#isMipmapEnabled()
	 * @see #getAbstractTexture()
	 * @generated
	 */
	EAttribute getAbstractTexture_MipmapEnabled();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Texture <em>Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Texture</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture
	 * @generated
	 */
	EClass getTexture();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.model.resource.Texture#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Texture#getFile()
	 * @see #getTexture()
	 * @generated
	 */
	EReference getTexture_File();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getMinFilter <em>Min Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Filter</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getMinFilter()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_MinFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getMagFilter <em>Mag Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mag Filter</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getMagFilter()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_MagFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getMipmapMode <em>Mipmap Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mipmap Mode</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getMipmapMode()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_MipmapMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getAddressMode <em>Address Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address Mode</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getAddressMode()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_AddressMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getBorderColor <em>Border Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border Color</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getBorderColor()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_BorderColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#isAnisotropyEnabled <em>Anisotropy Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Anisotropy Enabled</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#isAnisotropyEnabled()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_AnisotropyEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#isUnnormalizedCoordinates <em>Unnormalized Coordinates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unnormalized Coordinates</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#isUnnormalizedCoordinates()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_UnnormalizedCoordinates();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#isCompareEnable <em>Compare Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compare Enable</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#isCompareEnable()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_CompareEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getLodBias <em>Lod Bias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lod Bias</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getLodBias()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_LodBias();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getMinLod <em>Min Lod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Lod</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getMinLod()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_MinLod();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getMaxLod <em>Max Lod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Lod</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getMaxLod()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_MaxLod();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getMaxAnisotropy <em>Max Anisotropy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Anisotropy</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Sampler#getMaxAnisotropy()
	 * @see #getSampler()
	 * @generated
	 */
	EAttribute getSampler_MaxAnisotropy();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.AbstractConstants <em>Abstract Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Constants</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.AbstractConstants
	 * @generated
	 */
	EClass getAbstractConstants();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.AbstractConstants#getStages <em>Stages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stages</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.AbstractConstants#getStages()
	 * @see #getAbstractConstants()
	 * @generated
	 */
	EAttribute getAbstractConstants_Stages();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Constants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constants</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Constants
	 * @generated
	 */
	EClass getConstants();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Constants#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Constants#getData()
	 * @see #getConstants()
	 * @generated
	 */
	EAttribute getConstants_Data();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.IDescriptor <em>IDescriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDescriptor</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.IDescriptor
	 * @generated
	 */
	EClass getIDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.IDescriptor#getDescriptorType <em>Descriptor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descriptor Type</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.IDescriptor#getDescriptorType()
	 * @see #getIDescriptor()
	 * @generated
	 */
	EAttribute getIDescriptor_DescriptorType();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.IDescriptor#getShaderStages <em>Shader Stages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Shader Stages</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.IDescriptor#getShaderStages()
	 * @see #getIDescriptor()
	 * @generated
	 */
	EAttribute getIDescriptor_ShaderStages();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.Barrier <em>Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Barrier
	 * @generated
	 */
	EClass getBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Barrier#getSrcStage <em>Src Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Barrier#getSrcStage()
	 * @see #getBarrier()
	 * @generated
	 */
	EAttribute getBarrier_SrcStage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.Barrier#getDstStage <em>Dst Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Stage</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.Barrier#getDstStage()
	 * @see #getBarrier()
	 * @generated
	 */
	EAttribute getBarrier_DstStage();

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
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getSrcAccess <em>Src Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Access</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferBarrier#getSrcAccess()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EAttribute getBufferBarrier_SrcAccess();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.BufferBarrier#getDstAccess <em>Dst Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Access</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.BufferBarrier#getDstAccess()
	 * @see #getBufferBarrier()
	 * @generated
	 */
	EAttribute getBufferBarrier_DstAccess();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.AbstractImageBarrier <em>Abstract Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Image Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.AbstractImageBarrier
	 * @generated
	 */
	EClass getAbstractImageBarrier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.model.resource.AbstractImageBarrier#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.AbstractImageBarrier#getTransitions()
	 * @see #getAbstractImageBarrier()
	 * @generated
	 */
	EReference getAbstractImageBarrier_Transitions();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier <em>Reference Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Image Barrier</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier
	 * @generated
	 */
	EClass getReferenceImageBarrier();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier#getImageId <em>Image Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Id</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier#getImageId()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_ImageId();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier#getMipLevels <em>Mip Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mip Levels</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier#getMipLevels()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_MipLevels();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier#getImageFormat <em>Image Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Format</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ReferenceImageBarrier#getImageFormat()
	 * @see #getReferenceImageBarrier()
	 * @generated
	 */
	EAttribute getReferenceImageBarrier_ImageFormat();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.ImageTransition <em>Image Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Transition</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageTransition
	 * @generated
	 */
	EClass getImageTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageTransition#getSrcLayout <em>Src Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageTransition#getSrcLayout()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_SrcLayout();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.model.resource.ImageTransition#getDstLayout <em>Dst Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dst Layout</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageTransition#getDstLayout()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_DstLayout();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.ImageTransition#getSrcAccessMask <em>Src Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Src Access Mask</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageTransition#getSrcAccessMask()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_SrcAccessMask();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.lily.vulkan.model.resource.ImageTransition#getDstAccessMask <em>Dst Access Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dst Access Mask</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.ImageTransition#getDstAccessMask()
	 * @see #getImageTransition()
	 * @generated
	 */
	EAttribute getImageTransition_DstAccessMask();

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
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.model.resource.DepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depth Image</em>'.
	 * @see org.sheepy.lily.vulkan.model.resource.DepthImage
	 * @generated
	 */
	EClass getDepthImage();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.BasicResource <em>Basic Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.BasicResource
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBasicResource()
		 * @generated
		 */
		EClass BASIC_RESOURCE = eINSTANCE.getBasicResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.DescriptorResource <em>Descriptor Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.DescriptorResource
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorResource()
		 * @generated
		 */
		EClass DESCRIPTOR_RESOURCE = eINSTANCE.getDescriptorResource();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__WIDTH = eINSTANCE.getImage_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__HEIGHT = eINSTANCE.getImage_Height();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__FORMAT = eINSTANCE.getImage_Format();

		/**
		 * The meta object literal for the '<em><b>Usages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__USAGES = eINSTANCE.getImage_Usages();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__PROPERTIES = eINSTANCE.getImage_Properties();

		/**
		 * The meta object literal for the '<em><b>Tiling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__TILING = eINSTANCE.getImage_Tiling();

		/**
		 * The meta object literal for the '<em><b>Mip Levels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__MIP_LEVELS = eINSTANCE.getImage_MipLevels();

		/**
		 * The meta object literal for the '<em><b>Initial Layout</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE__INITIAL_LAYOUT = eINSTANCE.getImage_InitialLayout();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.FontImpl <em>Font</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.FontImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getFont()
		 * @generated
		 */
		EClass FONT = eINSTANCE.getFont();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FONT__FILE = eINSTANCE.getFont_File();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__HEIGHT = eINSTANCE.getFont_Height();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractTextureImpl <em>Abstract Texture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.AbstractTextureImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getAbstractTexture()
		 * @generated
		 */
		EClass ABSTRACT_TEXTURE = eINSTANCE.getAbstractTexture();

		/**
		 * The meta object literal for the '<em><b>Mipmap Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TEXTURE__MIPMAP_ENABLED = eINSTANCE.getAbstractTexture_MipmapEnabled();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.TextureImpl <em>Texture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.TextureImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getTexture()
		 * @generated
		 */
		EClass TEXTURE = eINSTANCE.getTexture();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXTURE__FILE = eINSTANCE.getTexture_File();

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
		 * The meta object literal for the '<em><b>Min Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__MIN_FILTER = eINSTANCE.getSampler_MinFilter();

		/**
		 * The meta object literal for the '<em><b>Mag Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__MAG_FILTER = eINSTANCE.getSampler_MagFilter();

		/**
		 * The meta object literal for the '<em><b>Mipmap Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__MIPMAP_MODE = eINSTANCE.getSampler_MipmapMode();

		/**
		 * The meta object literal for the '<em><b>Address Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__ADDRESS_MODE = eINSTANCE.getSampler_AddressMode();

		/**
		 * The meta object literal for the '<em><b>Border Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__BORDER_COLOR = eINSTANCE.getSampler_BorderColor();

		/**
		 * The meta object literal for the '<em><b>Anisotropy Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__ANISOTROPY_ENABLED = eINSTANCE.getSampler_AnisotropyEnabled();

		/**
		 * The meta object literal for the '<em><b>Unnormalized Coordinates</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__UNNORMALIZED_COORDINATES = eINSTANCE
				.getSampler_UnnormalizedCoordinates();

		/**
		 * The meta object literal for the '<em><b>Compare Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__COMPARE_ENABLE = eINSTANCE.getSampler_CompareEnable();

		/**
		 * The meta object literal for the '<em><b>Lod Bias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__LOD_BIAS = eINSTANCE.getSampler_LodBias();

		/**
		 * The meta object literal for the '<em><b>Min Lod</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__MIN_LOD = eINSTANCE.getSampler_MinLod();

		/**
		 * The meta object literal for the '<em><b>Max Lod</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__MAX_LOD = eINSTANCE.getSampler_MaxLod();

		/**
		 * The meta object literal for the '<em><b>Max Anisotropy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER__MAX_ANISOTROPY = eINSTANCE.getSampler_MaxAnisotropy();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractConstantsImpl <em>Abstract Constants</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.AbstractConstantsImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getAbstractConstants()
		 * @generated
		 */
		EClass ABSTRACT_CONSTANTS = eINSTANCE.getAbstractConstants();

		/**
		 * The meta object literal for the '<em><b>Stages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_CONSTANTS__STAGES = eINSTANCE.getAbstractConstants_Stages();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ConstantsImpl <em>Constants</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ConstantsImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getConstants()
		 * @generated
		 */
		EClass CONSTANTS = eINSTANCE.getConstants();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANTS__DATA = eINSTANCE.getConstants_Data();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.IDescriptor <em>IDescriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.IDescriptor
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getIDescriptor()
		 * @generated
		 */
		EClass IDESCRIPTOR = eINSTANCE.getIDescriptor();

		/**
		 * The meta object literal for the '<em><b>Descriptor Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDESCRIPTOR__DESCRIPTOR_TYPE = eINSTANCE.getIDescriptor_DescriptorType();

		/**
		 * The meta object literal for the '<em><b>Shader Stages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDESCRIPTOR__SHADER_STAGES = eINSTANCE.getIDescriptor_ShaderStages();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.BarrierImpl <em>Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.BarrierImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getBarrier()
		 * @generated
		 */
		EClass BARRIER = eINSTANCE.getBarrier();

		/**
		 * The meta object literal for the '<em><b>Src Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BARRIER__SRC_STAGE = eINSTANCE.getBarrier_SrcStage();

		/**
		 * The meta object literal for the '<em><b>Dst Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BARRIER__DST_STAGE = eINSTANCE.getBarrier_DstStage();

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
		 * The meta object literal for the '<em><b>Src Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_BARRIER__SRC_ACCESS = eINSTANCE.getBufferBarrier_SrcAccess();

		/**
		 * The meta object literal for the '<em><b>Dst Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER_BARRIER__DST_ACCESS = eINSTANCE.getBufferBarrier_DstAccess();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractImageBarrierImpl <em>Abstract Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.AbstractImageBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getAbstractImageBarrier()
		 * @generated
		 */
		EClass ABSTRACT_IMAGE_BARRIER = eINSTANCE.getAbstractImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_IMAGE_BARRIER__TRANSITIONS = eINSTANCE
				.getAbstractImageBarrier_Transitions();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ReferenceImageBarrierImpl <em>Reference Image Barrier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ReferenceImageBarrierImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getReferenceImageBarrier()
		 * @generated
		 */
		EClass REFERENCE_IMAGE_BARRIER = eINSTANCE.getReferenceImageBarrier();

		/**
		 * The meta object literal for the '<em><b>Image Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__IMAGE_ID = eINSTANCE.getReferenceImageBarrier_ImageId();

		/**
		 * The meta object literal for the '<em><b>Mip Levels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__MIP_LEVELS = eINSTANCE
				.getReferenceImageBarrier_MipLevels();

		/**
		 * The meta object literal for the '<em><b>Image Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT = eINSTANCE
				.getReferenceImageBarrier_ImageFormat();

		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.ImageTransitionImpl <em>Image Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ImageTransitionImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getImageTransition()
		 * @generated
		 */
		EClass IMAGE_TRANSITION = eINSTANCE.getImageTransition();

		/**
		 * The meta object literal for the '<em><b>Src Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__SRC_LAYOUT = eINSTANCE.getImageTransition_SrcLayout();

		/**
		 * The meta object literal for the '<em><b>Dst Layout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__DST_LAYOUT = eINSTANCE.getImageTransition_DstLayout();

		/**
		 * The meta object literal for the '<em><b>Src Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__SRC_ACCESS_MASK = eINSTANCE.getImageTransition_SrcAccessMask();

		/**
		 * The meta object literal for the '<em><b>Dst Access Mask</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_TRANSITION__DST_ACCESS_MASK = eINSTANCE.getImageTransition_DstAccessMask();

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
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.model.resource.impl.DepthImageImpl <em>Depth Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.model.resource.impl.DepthImageImpl
		 * @see org.sheepy.lily.vulkan.model.resource.impl.ResourcePackageImpl#getDepthImage()
		 * @generated
		 */
		EClass DEPTH_IMAGE = eINSTANCE.getDepthImage();

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
		EAttribute STRING_MODULE_RESOURCE__MODULE_NAME = eINSTANCE
				.getStringModuleResource_ModuleName();

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
