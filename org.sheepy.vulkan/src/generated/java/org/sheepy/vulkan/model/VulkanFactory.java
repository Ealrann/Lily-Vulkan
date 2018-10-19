/**
 */
package org.sheepy.vulkan.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.VulkanPackage
 * @generated
 */
public interface VulkanFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VulkanFactory eINSTANCE = org.sheepy.vulkan.model.impl.VulkanFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application</em>'.
	 * @generated
	 */
	VulkanApplication createVulkanApplication();

	/**
	 * Returns a new object of class '<em>Graphic Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graphic Configuration</em>'.
	 * @generated
	 */
	GraphicConfiguration createGraphicConfiguration();

	/**
	 * Returns a new object of class '<em>Render Pass Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Render Pass Info</em>'.
	 * @generated
	 */
	RenderPassInfo createRenderPassInfo();

	/**
	 * Returns a new object of class '<em>Subpass Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subpass Dependency</em>'.
	 * @generated
	 */
	SubpassDependency createSubpassDependency();

	/**
	 * Returns a new object of class '<em>Attachment Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attachment Description</em>'.
	 * @generated
	 */
	AttachmentDescription createAttachmentDescription();

	/**
	 * Returns a new object of class '<em>Color Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Domain</em>'.
	 * @generated
	 */
	ColorDomain createColorDomain();

	/**
	 * Returns a new object of class '<em>Compute Process Pool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compute Process Pool</em>'.
	 * @generated
	 */
	ComputeProcessPool createComputeProcessPool();

	/**
	 * Returns a new object of class '<em>Graphic Process Pool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graphic Process Pool</em>'.
	 * @generated
	 */
	GraphicProcessPool createGraphicProcessPool();

	/**
	 * Returns a new object of class '<em>Graphic Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graphic Process</em>'.
	 * @generated
	 */
	GraphicProcess createGraphicProcess();

	/**
	 * Returns a new object of class '<em>Compute Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compute Process</em>'.
	 * @generated
	 */
	ComputeProcess createComputeProcess();

	/**
	 * Returns a new object of class '<em>Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Barrier</em>'.
	 * @generated
	 */
	BufferBarrier createBufferBarrier();

	/**
	 * Returns a new object of class '<em>Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Barrier</em>'.
	 * @generated
	 */
	ImageBarrier createImageBarrier();

	/**
	 * Returns a new object of class '<em>Reference Image Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Image Barrier</em>'.
	 * @generated
	 */
	ReferenceImageBarrier createReferenceImageBarrier();

	/**
	 * Returns a new object of class '<em>Image Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Transition</em>'.
	 * @generated
	 */
	ImageTransition createImageTransition();

	/**
	 * Returns a new object of class '<em>Descriptor Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptor Set</em>'.
	 * @generated
	 */
	DescriptorSet createDescriptorSet();

	/**
	 * Returns a new object of class '<em>Compute Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compute Pipeline</em>'.
	 * @generated
	 */
	ComputePipeline createComputePipeline();

	/**
	 * Returns a new object of class '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computer</em>'.
	 * @generated
	 */
	Computer createComputer();

	/**
	 * Returns a new object of class '<em>Image Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Pipeline</em>'.
	 * @generated
	 */
	ImagePipeline createImagePipeline();

	/**
	 * Returns a new object of class '<em>Mesh Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mesh Pipeline</em>'.
	 * @generated
	 */
	MeshPipeline createMeshPipeline();

	/**
	 * Returns a new object of class '<em>Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer</em>'.
	 * @generated
	 */
	Buffer createBuffer();

	/**
	 * Returns a new object of class '<em>Texture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Texture</em>'.
	 * @generated
	 */
	Texture createTexture();

	/**
	 * Returns a new object of class '<em>Depth Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Depth Image</em>'.
	 * @generated
	 */
	DepthImage createDepthImage();

	/**
	 * Returns a new object of class '<em>File Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Resource</em>'.
	 * @generated
	 */
	FileResource createFileResource();

	/**
	 * Returns a new object of class '<em>Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module Resource</em>'.
	 * @generated
	 */
	ModuleResource createModuleResource();

	/**
	 * Returns a new object of class '<em>Shader</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shader</em>'.
	 * @generated
	 */
	Shader createShader();

	/**
	 * Returns a new object of class '<em>Push Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Push Constant</em>'.
	 * @generated
	 */
	PushConstant createPushConstant();

	/**
	 * Returns a new object of class '<em>Mesh Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mesh Buffer</em>'.
	 * @generated
	 */
	MeshBuffer createMeshBuffer();

	/**
	 * Returns a new object of class '<em>Uniform Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Uniform Buffer</em>'.
	 * @generated
	 */
	UniformBuffer createUniformBuffer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VulkanPackage getVulkanPackage();

} //VulkanFactory
