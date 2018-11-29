/**
 */
package org.sheepy.vulkan.demo.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.resource.ResourcePackage;

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
 * @see org.sheepy.vulkan.demo.model.VulkanDemoFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/org.sheepy.vulkan.demo.model/src/generated/java' modelName='VulkanDemo' prefix='VulkanDemo' publicConstructors='true' updateClasspath='false' basePackage='org.sheepy.vulkan.demo'"
 * @generated
 */
public interface VulkanDemoPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.demo.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VulkanDemoPackage eINSTANCE = org.sheepy.vulkan.demo.model.impl.VulkanDemoPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.demo.model.impl.MeshPipelineImpl <em>Mesh Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.demo.model.impl.MeshPipelineImpl
	 * @see org.sheepy.vulkan.demo.model.impl.VulkanDemoPackageImpl#getMeshPipeline()
	 * @generated
	 */
	int MESH_PIPELINE = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__ENABLED = GraphicPackage.GRAPHICS_PIPELINE__ENABLED;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__STAGE = GraphicPackage.GRAPHICS_PIPELINE__STAGE;

	/**
	 * The feature id for the '<em><b>Descriptor Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__DESCRIPTOR_SET = GraphicPackage.GRAPHICS_PIPELINE__DESCRIPTOR_SET;

	/**
	 * The feature id for the '<em><b>Push Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__PUSH_CONSTANT = GraphicPackage.GRAPHICS_PIPELINE__PUSH_CONSTANT;

	/**
	 * The feature id for the '<em><b>Shaders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__SHADERS = GraphicPackage.GRAPHICS_PIPELINE__SHADERS;

	/**
	 * The feature id for the '<em><b>Viewport State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__VIEWPORT_STATE = GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE;

	/**
	 * The feature id for the '<em><b>Rasterizer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__RASTERIZER = GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER;

	/**
	 * The feature id for the '<em><b>Color Blend</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__COLOR_BLEND = GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND;

	/**
	 * The feature id for the '<em><b>Dynamic State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__DYNAMIC_STATE = GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE;

	/**
	 * The feature id for the '<em><b>Mesh</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE__MESH = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mesh Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE_FEATURE_COUNT = GraphicPackage.GRAPHICS_PIPELINE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mesh Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_PIPELINE_OPERATION_COUNT = GraphicPackage.GRAPHICS_PIPELINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.demo.model.impl.MeshBufferImpl <em>Mesh Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.demo.model.impl.MeshBufferImpl
	 * @see org.sheepy.vulkan.demo.model.impl.VulkanDemoPackageImpl#getMeshBuffer()
	 * @generated
	 */
	int MESH_BUFFER = 1;

	/**
	 * The feature id for the '<em><b>Texture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_BUFFER__TEXTURE = ResourcePackage.INDEXED_BUFFER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mesh Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_BUFFER_FEATURE_COUNT = ResourcePackage.INDEXED_BUFFER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mesh Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESH_BUFFER_OPERATION_COUNT = ResourcePackage.INDEXED_BUFFER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.demo.model.impl.UniformBufferImpl <em>Uniform Buffer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.demo.model.impl.UniformBufferImpl
	 * @see org.sheepy.vulkan.demo.model.impl.VulkanDemoPackageImpl#getUniformBuffer()
	 * @generated
	 */
	int UNIFORM_BUFFER = 2;

	/**
	 * The feature id for the '<em><b>Descriptor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_BUFFER__DESCRIPTOR_TYPE = ResourcePackage.PIPELINE_RESOURCE__DESCRIPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Shader Stages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_BUFFER__SHADER_STAGES = ResourcePackage.PIPELINE_RESOURCE__SHADER_STAGES;

	/**
	 * The number of structural features of the '<em>Uniform Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_BUFFER_FEATURE_COUNT = ResourcePackage.PIPELINE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Uniform Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIFORM_BUFFER_OPERATION_COUNT = ResourcePackage.PIPELINE_RESOURCE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.demo.model.MeshPipeline <em>Mesh Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Pipeline</em>'.
	 * @see org.sheepy.vulkan.demo.model.MeshPipeline
	 * @generated
	 */
	EClass getMeshPipeline();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.demo.model.MeshPipeline#getMesh <em>Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mesh</em>'.
	 * @see org.sheepy.vulkan.demo.model.MeshPipeline#getMesh()
	 * @see #getMeshPipeline()
	 * @generated
	 */
	EReference getMeshPipeline_Mesh();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.demo.model.MeshBuffer <em>Mesh Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mesh Buffer</em>'.
	 * @see org.sheepy.vulkan.demo.model.MeshBuffer
	 * @generated
	 */
	EClass getMeshBuffer();

	/**
	 * Returns the meta object for the reference '{@link org.sheepy.vulkan.demo.model.MeshBuffer#getTexture <em>Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Texture</em>'.
	 * @see org.sheepy.vulkan.demo.model.MeshBuffer#getTexture()
	 * @see #getMeshBuffer()
	 * @generated
	 */
	EReference getMeshBuffer_Texture();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.demo.model.UniformBuffer <em>Uniform Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uniform Buffer</em>'.
	 * @see org.sheepy.vulkan.demo.model.UniformBuffer
	 * @generated
	 */
	EClass getUniformBuffer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VulkanDemoFactory getVulkanDemoFactory();

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
		 * The meta object literal for the '{@link org.sheepy.vulkan.demo.model.impl.MeshPipelineImpl <em>Mesh Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.demo.model.impl.MeshPipelineImpl
		 * @see org.sheepy.vulkan.demo.model.impl.VulkanDemoPackageImpl#getMeshPipeline()
		 * @generated
		 */
		EClass MESH_PIPELINE = eINSTANCE.getMeshPipeline();

		/**
		 * The meta object literal for the '<em><b>Mesh</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESH_PIPELINE__MESH = eINSTANCE.getMeshPipeline_Mesh();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.demo.model.impl.MeshBufferImpl <em>Mesh Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.demo.model.impl.MeshBufferImpl
		 * @see org.sheepy.vulkan.demo.model.impl.VulkanDemoPackageImpl#getMeshBuffer()
		 * @generated
		 */
		EClass MESH_BUFFER = eINSTANCE.getMeshBuffer();

		/**
		 * The meta object literal for the '<em><b>Texture</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESH_BUFFER__TEXTURE = eINSTANCE.getMeshBuffer_Texture();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.demo.model.impl.UniformBufferImpl <em>Uniform Buffer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.demo.model.impl.UniformBufferImpl
		 * @see org.sheepy.vulkan.demo.model.impl.VulkanDemoPackageImpl#getUniformBuffer()
		 * @generated
		 */
		EClass UNIFORM_BUFFER = eINSTANCE.getUniformBuffer();

	}

} //VulkanDemoPackage
