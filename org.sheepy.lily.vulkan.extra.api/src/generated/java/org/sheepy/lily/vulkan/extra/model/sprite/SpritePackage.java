/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteFactory
 * @model kind="package"
 * @generated
 */
public interface SpritePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sprite";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.lily.vulkan.extra.model.sprite";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sprite";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpritePackage eINSTANCE = org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteRendererImpl <em>Renderer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteRendererImpl
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteRenderer()
	 * @generated
	 */
	int SPRITE_RENDERER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__NAME = RenderingPackage.GENERIC_RENDERER__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__ENABLED = RenderingPackage.GENERIC_RENDERER__ENABLED;

	/**
	 * The feature id for the '<em><b>Vulkan Resource Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__VULKAN_RESOURCE_PKG = RenderingPackage.GENERIC_RENDERER__VULKAN_RESOURCE_PKG;

	/**
	 * The feature id for the '<em><b>Descriptor Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__DESCRIPTOR_PKG = RenderingPackage.GENERIC_RENDERER__DESCRIPTOR_PKG;

	/**
	 * The feature id for the '<em><b>Task Pkgs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__TASK_PKGS = RenderingPackage.GENERIC_RENDERER__TASK_PKGS;

	/**
	 * The feature id for the '<em><b>Descriptor Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__DESCRIPTOR_POOL = RenderingPackage.GENERIC_RENDERER__DESCRIPTOR_POOL;

	/**
	 * The feature id for the '<em><b>Specialization Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__SPECIALIZATION_DATA = RenderingPackage.GENERIC_RENDERER__SPECIALIZATION_DATA;

	/**
	 * The feature id for the '<em><b>Push Constant Ranges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__PUSH_CONSTANT_RANGES = RenderingPackage.GENERIC_RENDERER__PUSH_CONSTANT_RANGES;

	/**
	 * The feature id for the '<em><b>Layout</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__LAYOUT = RenderingPackage.GENERIC_RENDERER__LAYOUT;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__MAINTAINER = RenderingPackage.GENERIC_RENDERER__MAINTAINER;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__SHADERS = RenderingPackage.GENERIC_RENDERER__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__VIEWPORT_STATE = RenderingPackage.GENERIC_RENDERER__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Input Assembly</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__INPUT_ASSEMBLY = RenderingPackage.GENERIC_RENDERER__INPUT_ASSEMBLY;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__RASTERIZER = RenderingPackage.GENERIC_RENDERER__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__COLOR_BLEND = RenderingPackage.GENERIC_RENDERER__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__DYNAMIC_STATE = RenderingPackage.GENERIC_RENDERER__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Vertex Input State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__VERTEX_INPUT_STATE = RenderingPackage.GENERIC_RENDERER__VERTEX_INPUT_STATE;

	/**
	 * The feature id for the '<em><b>Depth Stencil State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__DEPTH_STENCIL_STATE = RenderingPackage.GENERIC_RENDERER__DEPTH_STENCIL_STATE;

	/**
	 * The feature id for the '<em><b>Maintained</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__MAINTAINED = RenderingPackage.GENERIC_RENDERER__MAINTAINED;

	/**
	 * The feature id for the '<em><b>Data Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__DATA_PROVIDER_PKG = RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG;

	/**
	 * The feature id for the '<em><b>Rendered Structures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__RENDERED_STRUCTURES = RenderingPackage.GENERIC_RENDERER__RENDERED_STRUCTURES;

	/**
	 * The feature id for the '<em><b>Constant Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__CONSTANT_BUFFER = RenderingPackage.GENERIC_RENDERER__CONSTANT_BUFFER;

	/**
	 * The feature id for the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__TRANSFER_BUFFER = RenderingPackage.GENERIC_RENDERER__TRANSFER_BUFFER;

	/**
	 * The feature id for the '<em><b>Descriptor Provider Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__DESCRIPTOR_PROVIDER_PKG = RenderingPackage.GENERIC_RENDERER__DESCRIPTOR_PROVIDER_PKG;

	/**
	 * The feature id for the '<em><b>Specialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__SPECIALIZATION = RenderingPackage.GENERIC_RENDERER__SPECIALIZATION;

	/**
	 * The feature id for the '<em><b>Flush Transfer Buffer Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__FLUSH_TRANSFER_BUFFER_TASK = RenderingPackage.GENERIC_RENDERER__FLUSH_TRANSFER_BUFFER_TASK;

	/**
	 * The feature id for the '<em><b>One Pipeline Per Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER__ONE_PIPELINE_PER_PART = RenderingPackage.GENERIC_RENDERER__ONE_PIPELINE_PER_PART;

	/**
	 * The number of structural features of the '<em>Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER_FEATURE_COUNT = RenderingPackage.GENERIC_RENDERER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Renderer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_RENDERER_OPERATION_COUNT = RenderingPackage.GENERIC_RENDERER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteImpl <em>Sprite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteImpl
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSprite()
	 * @generated
	 */
	int SPRITE = 1;

	/**
	 * The feature id for the '<em><b>Presented Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE__PRESENTED_ENTITIES = RenderingPackage.PRESENTATION__PRESENTED_ENTITIES;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE__FILE = RenderingPackage.PRESENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE__TYPE = RenderingPackage.PRESENTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sprite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_FEATURE_COUNT = RenderingPackage.PRESENTATION_FEATURE_COUNT + 2;


	/**
	 * The number of operations of the '<em>Sprite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_OPERATION_COUNT = RenderingPackage.PRESENTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteMonoSamplerProviderImpl <em>Mono Sampler Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteMonoSamplerProviderImpl
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteMonoSamplerProvider()
	 * @generated
	 */
	int SPRITE_MONO_SAMPLER_PROVIDER = 2;

	/**
	 * The feature id for the '<em><b>Sampler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO = RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mono Sampler Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_MONO_SAMPLER_PROVIDER_FEATURE_COUNT = RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mono Sampler Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_MONO_SAMPLER_PROVIDER_OPERATION_COUNT = RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteStructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteStructureImpl
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteStructure()
	 * @generated
	 */
	int SPRITE_STRUCTURE = 3;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_STRUCTURE__WIDTH = RenderingPackage.STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_STRUCTURE__HEIGHT = RenderingPackage.STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sprites</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_STRUCTURE__SPRITES = RenderingPackage.STRUCTURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_STRUCTURE_FEATURE_COUNT = RenderingPackage.STRUCTURE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_STRUCTURE_OPERATION_COUNT = RenderingPackage.STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteCountSpecializationImpl <em>Count Specialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteCountSpecializationImpl
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteCountSpecialization()
	 * @generated
	 */
	int SPRITE_COUNT_SPECIALIZATION = 4;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_COUNT_SPECIALIZATION__PROVIDER = RenderingPackage.ISPECIALIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Count Specialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_COUNT_SPECIALIZATION_FEATURE_COUNT = RenderingPackage.ISPECIALIZATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Count Specialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRITE_COUNT_SPECIALIZATION_OPERATION_COUNT = RenderingPackage.ISPECIALIZATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteType <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteType
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteType()
	 * @generated
	 */
	int SPRITE_TYPE = 5;

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer <em>Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Renderer</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer
	 * @generated
	 */
	EClass getSpriteRenderer();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite <em>Sprite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sprite</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.Sprite
	 * @generated
	 */
	EClass getSprite();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>File</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getFile()
	 * @see #getSprite()
	 * @generated
	 */
	EReference getSprite_File();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getType()
	 * @see #getSprite()
	 * @generated
	 */
	EAttribute getSprite_Type();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider <em>Mono Sampler Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mono Sampler Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider
	 * @generated
	 */
	EClass getSpriteMonoSamplerProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider#getSamplerInfo <em>Sampler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sampler Info</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider#getSamplerInfo()
	 * @see #getSpriteMonoSamplerProvider()
	 * @generated
	 */
	EReference getSpriteMonoSamplerProvider_SamplerInfo();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure
	 * @generated
	 */
	EClass getSpriteStructure();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure#getWidth()
	 * @see #getSpriteStructure()
	 * @generated
	 */
	EAttribute getSpriteStructure_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure#getHeight()
	 * @see #getSpriteStructure()
	 * @generated
	 */
	EAttribute getSpriteStructure_Height();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure#getSprites <em>Sprites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sprites</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure#getSprites()
	 * @see #getSpriteStructure()
	 * @generated
	 */
	EReference getSpriteStructure_Sprites();

	/**
	 * Returns the meta object for class '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization <em>Count Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Count Specialization</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization
	 * @generated
	 */
	EClass getSpriteCountSpecialization();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provider</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization#getProvider()
	 * @see #getSpriteCountSpecialization()
	 * @generated
	 */
	EReference getSpriteCountSpecialization_Provider();

	/**
	 * Returns the meta object for enum '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteType
	 * @generated
	 */
	EEnum getSpriteType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpriteFactory getSpriteFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteRendererImpl <em>Renderer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteRendererImpl
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteRenderer()
		 * @generated
		 */
		EClass SPRITE_RENDERER = eINSTANCE.getSpriteRenderer();
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteImpl <em>Sprite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteImpl
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSprite()
		 * @generated
		 */
		EClass SPRITE = eINSTANCE.getSprite();
		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE__FILE = eINSTANCE.getSprite_File();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRITE__TYPE = eINSTANCE.getSprite_Type();
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteMonoSamplerProviderImpl <em>Mono Sampler Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteMonoSamplerProviderImpl
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteMonoSamplerProvider()
		 * @generated
		 */
		EClass SPRITE_MONO_SAMPLER_PROVIDER = eINSTANCE.getSpriteMonoSamplerProvider();
		/**
		 * The meta object literal for the '<em><b>Sampler Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO = eINSTANCE.getSpriteMonoSamplerProvider_SamplerInfo();
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteStructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteStructureImpl
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteStructure()
		 * @generated
		 */
		EClass SPRITE_STRUCTURE = eINSTANCE.getSpriteStructure();
		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRITE_STRUCTURE__WIDTH = eINSTANCE.getSpriteStructure_Width();
		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRITE_STRUCTURE__HEIGHT = eINSTANCE.getSpriteStructure_Height();
		/**
		 * The meta object literal for the '<em><b>Sprites</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_STRUCTURE__SPRITES = eINSTANCE.getSpriteStructure_Sprites();
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteCountSpecializationImpl <em>Count Specialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteCountSpecializationImpl
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteCountSpecialization()
		 * @generated
		 */
		EClass SPRITE_COUNT_SPECIALIZATION = eINSTANCE.getSpriteCountSpecialization();
		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRITE_COUNT_SPECIALIZATION__PROVIDER = eINSTANCE.getSpriteCountSpecialization_Provider();
		/**
		 * The meta object literal for the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteType <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteType
		 * @see org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePackageImpl#getSpriteType()
		 * @generated
		 */
		EEnum SPRITE_TYPE = eINSTANCE.getSpriteType();

	}

} //SpritePackage
