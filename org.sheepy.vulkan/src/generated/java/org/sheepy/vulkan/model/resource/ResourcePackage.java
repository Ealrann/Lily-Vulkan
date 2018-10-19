/**
 */
package org.sheepy.vulkan.model.resource;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.sheepy.vulkan.model.resource.ResourceFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.model/src/generated/java' publicConstructors='true' basePackage='org.sheepy.vulkan.model'"
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
	String eNS_URI = "org.sheepy.vulkan.model.resource";

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
	ResourcePackage eINSTANCE = org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.Resource <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.Resource
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.VulkanBuffer <em>Vulkan Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.VulkanBuffer
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getVulkanBuffer()
	 * @generated
	 */
	int VULKAN_BUFFER = 1;

	/**
	 * The number of structural features of the '<em>Vulkan Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_BUFFER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vulkan Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULKAN_BUFFER_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.BufferImpl <em>Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.BufferImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getBuffer()
	 * @generated
	 */
	int BUFFER = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__SIZE = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__USAGE = VULKAN_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER__PROPERTIES = VULKAN_BUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.SizedBuffer <em>Sized Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.SizedBuffer
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getSizedBuffer()
	 * @generated
	 */
	int SIZED_BUFFER = 3;

	/**
	 * The number of structural features of the '<em>Sized Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZED_BUFFER_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sized Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIZED_BUFFER_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.ImageImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 4;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = SIZED_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = SIZED_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.TextureImpl <em>Texture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.TextureImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getTexture()
	 * @generated
	 */
	int TEXTURE = 5;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__FILE = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mipmap Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE__MIPMAP_ENABLED = VULKAN_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Texture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Texture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTURE_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.DepthImageImpl <em>Depth Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.DepthImageImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getDepthImage()
	 * @generated
	 */
	int DEPTH_IMAGE = 6;

	/**
	 * The number of structural features of the '<em>Depth Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_IMAGE_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Depth Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPTH_IMAGE_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.PathResourceImpl <em>Path Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.PathResourceImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getPathResource()
	 * @generated
	 */
	int PATH_RESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE__PATH = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Path Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_RESOURCE_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.FileResourceImpl <em>File Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.FileResourceImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getFileResource()
	 * @generated
	 */
	int FILE_RESOURCE = 8;

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
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.ModuleResourceImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getModuleResource()
	 * @generated
	 */
	int MODULE_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__PATH = PATH_RESOURCE__PATH;

	/**
	 * The feature id for the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE__MODULE = PATH_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE_FEATURE_COUNT = PATH_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Module Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_RESOURCE_OPERATION_COUNT = PATH_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.ShaderImpl <em>Shader</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.ShaderImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getShader()
	 * @generated
	 */
	int SHADER = 10;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__FILE = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER__STAGE = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Shader</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADER_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.PushConstantImpl <em>Push Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.PushConstantImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getPushConstant()
	 * @generated
	 */
	int PUSH_CONSTANT = 11;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT__SIZE = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT__STAGE = VULKAN_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Push Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Push Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSH_CONSTANT_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.IDescriptor <em>IDescriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.IDescriptor
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getIDescriptor()
	 * @generated
	 */
	int IDESCRIPTOR = 12;

	/**
	 * The number of structural features of the '<em>IDescriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IDescriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.DescriptorSetImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorSet()
	 * @generated
	 */
	int DESCRIPTOR_SET = 13;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET__DESCRIPTORS = 0;

	/**
	 * The number of structural features of the '<em>Descriptor Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Descriptor Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.resource.impl.IndexedBufferImpl <em>Indexed Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.resource.impl.IndexedBufferImpl
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getIndexedBuffer()
	 * @generated
	 */
	int INDEXED_BUFFER = 14;

	/**
	 * The number of structural features of the '<em>Indexed Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_BUFFER_FEATURE_COUNT = VULKAN_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Indexed Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_BUFFER_OPERATION_COUNT = VULKAN_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>Java Module</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Module
	 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getJavaModule()
	 * @generated
	 */
	int JAVA_MODULE = 15;


	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.sheepy.vulkan.model.resource.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.VulkanBuffer <em>Vulkan Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vulkan Buffer</em>'.
	 * @see org.sheepy.vulkan.model.resource.VulkanBuffer
	 * @generated
	 */
	EClass getVulkanBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer</em>'.
	 * @see org.sheepy.vulkan.model.resource.Buffer
	 * @generated
	 */
	EClass getBuffer();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.Buffer#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.vulkan.model.resource.Buffer#getSize()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.Buffer#getUsage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage</em>'.
	 * @see org.sheepy.vulkan.model.resource.Buffer#getUsage()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Usage();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.Buffer#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties</em>'.
	 * @see org.sheepy.vulkan.model.resource.Buffer#getProperties()
	 * @see #getBuffer()
	 * @generated
	 */
	EAttribute getBuffer_Properties();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.SizedBuffer <em>Sized Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sized Buffer</em>'.
	 * @see org.sheepy.vulkan.model.resource.SizedBuffer
	 * @generated
	 */
	EClass getSizedBuffer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.sheepy.vulkan.model.resource.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.Texture <em>Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Texture</em>'.
	 * @see org.sheepy.vulkan.model.resource.Texture
	 * @generated
	 */
	EClass getTexture();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.resource.Texture#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.vulkan.model.resource.Texture#getFile()
	 * @see #getTexture()
	 * @generated
	 */
	EReference getTexture_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.Texture#isMipmapEnabled <em>Mipmap Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mipmap Enabled</em>'.
	 * @see org.sheepy.vulkan.model.resource.Texture#isMipmapEnabled()
	 * @see #getTexture()
	 * @generated
	 */
	EAttribute getTexture_MipmapEnabled();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.DepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depth Image</em>'.
	 * @see org.sheepy.vulkan.model.resource.DepthImage
	 * @generated
	 */
	EClass getDepthImage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.PathResource <em>Path Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Resource</em>'.
	 * @see org.sheepy.vulkan.model.resource.PathResource
	 * @generated
	 */
	EClass getPathResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.PathResource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.sheepy.vulkan.model.resource.PathResource#getPath()
	 * @see #getPathResource()
	 * @generated
	 */
	EAttribute getPathResource_Path();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Resource</em>'.
	 * @see org.sheepy.vulkan.model.resource.FileResource
	 * @generated
	 */
	EClass getFileResource();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.ModuleResource <em>Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Resource</em>'.
	 * @see org.sheepy.vulkan.model.resource.ModuleResource
	 * @generated
	 */
	EClass getModuleResource();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.ModuleResource#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module</em>'.
	 * @see org.sheepy.vulkan.model.resource.ModuleResource#getModule()
	 * @see #getModuleResource()
	 * @generated
	 */
	EAttribute getModuleResource_Module();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.Shader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shader</em>'.
	 * @see org.sheepy.vulkan.model.resource.Shader
	 * @generated
	 */
	EClass getShader();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.vulkan.model.resource.Shader#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.vulkan.model.resource.Shader#getFile()
	 * @see #getShader()
	 * @generated
	 */
	EReference getShader_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.Shader#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.vulkan.model.resource.Shader#getStage()
	 * @see #getShader()
	 * @generated
	 */
	EAttribute getShader_Stage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.PushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Push Constant</em>'.
	 * @see org.sheepy.vulkan.model.resource.PushConstant
	 * @generated
	 */
	EClass getPushConstant();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.PushConstant#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.sheepy.vulkan.model.resource.PushConstant#getSize()
	 * @see #getPushConstant()
	 * @generated
	 */
	EAttribute getPushConstant_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.resource.PushConstant#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.sheepy.vulkan.model.resource.PushConstant#getStage()
	 * @see #getPushConstant()
	 * @generated
	 */
	EAttribute getPushConstant_Stage();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.IDescriptor <em>IDescriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IDescriptor</em>'.
	 * @see org.sheepy.vulkan.model.resource.IDescriptor
	 * @generated
	 */
	EClass getIDescriptor();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.DescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor Set</em>'.
	 * @see org.sheepy.vulkan.model.resource.DescriptorSet
	 * @generated
	 */
	EClass getDescriptorSet();

	/**
	 * Returns the meta object for the reference list '{@link org.sheepy.vulkan.model.resource.DescriptorSet#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors</em>'.
	 * @see org.sheepy.vulkan.model.resource.DescriptorSet#getDescriptors()
	 * @see #getDescriptorSet()
	 * @generated
	 */
	EReference getDescriptorSet_Descriptors();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.resource.IndexedBuffer <em>Indexed Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indexed Buffer</em>'.
	 * @see org.sheepy.vulkan.model.resource.IndexedBuffer
	 * @generated
	 */
	EClass getIndexedBuffer();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.Resource <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.Resource
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.VulkanBuffer <em>Vulkan Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.VulkanBuffer
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getVulkanBuffer()
		 * @generated
		 */
		EClass VULKAN_BUFFER = eINSTANCE.getVulkanBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.BufferImpl <em>Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.BufferImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getBuffer()
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
		 * The meta object literal for the '<em><b>Usage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__USAGE = eINSTANCE.getBuffer_Usage();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUFFER__PROPERTIES = eINSTANCE.getBuffer_Properties();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.SizedBuffer <em>Sized Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.SizedBuffer
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getSizedBuffer()
		 * @generated
		 */
		EClass SIZED_BUFFER = eINSTANCE.getSizedBuffer();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.ImageImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.TextureImpl <em>Texture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.TextureImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getTexture()
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
		 * The meta object literal for the '<em><b>Mipmap Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTURE__MIPMAP_ENABLED = eINSTANCE.getTexture_MipmapEnabled();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.DepthImageImpl <em>Depth Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.DepthImageImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getDepthImage()
		 * @generated
		 */
		EClass DEPTH_IMAGE = eINSTANCE.getDepthImage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.PathResourceImpl <em>Path Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.PathResourceImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getPathResource()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.FileResourceImpl <em>File Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.FileResourceImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getFileResource()
		 * @generated
		 */
		EClass FILE_RESOURCE = eINSTANCE.getFileResource();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.ModuleResourceImpl <em>Module Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.ModuleResourceImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getModuleResource()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.ShaderImpl <em>Shader</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.ShaderImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getShader()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.PushConstantImpl <em>Push Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.PushConstantImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getPushConstant()
		 * @generated
		 */
		EClass PUSH_CONSTANT = eINSTANCE.getPushConstant();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_CONSTANT__SIZE = eINSTANCE.getPushConstant_Size();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUSH_CONSTANT__STAGE = eINSTANCE.getPushConstant_Stage();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.IDescriptor <em>IDescriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.IDescriptor
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getIDescriptor()
		 * @generated
		 */
		EClass IDESCRIPTOR = eINSTANCE.getIDescriptor();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.DescriptorSetImpl <em>Descriptor Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.DescriptorSetImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getDescriptorSet()
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
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.resource.impl.IndexedBufferImpl <em>Indexed Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.resource.impl.IndexedBufferImpl
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getIndexedBuffer()
		 * @generated
		 */
		EClass INDEXED_BUFFER = eINSTANCE.getIndexedBuffer();

		/**
		 * The meta object literal for the '<em>Java Module</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Module
		 * @see org.sheepy.vulkan.model.resource.impl.ResourcePackageImpl#getJavaModule()
		 * @generated
		 */
		EDataType JAVA_MODULE = eINSTANCE.getJavaModule();

	}

} //ResourcePackage
