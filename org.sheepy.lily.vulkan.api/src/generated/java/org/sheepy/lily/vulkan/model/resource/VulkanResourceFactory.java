/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage
 * @generated
 */
public interface VulkanResourceFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VulkanResourceFactory eINSTANCE = org.sheepy.lily.vulkan.model.resource.impl.VulkanResourceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transfer Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transfer Buffer</em>'.
	 * @generated
	 */
	TransferBuffer createTransferBuffer();

	/**
	 * Returns a new object of class '<em>Descriptor Pool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptor Pool</em>'.
	 * @generated
	 */
	DescriptorPool createDescriptorPool();

	/**
	 * Returns a new object of class '<em>Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Buffer</em>'.
	 * @generated
	 */
	ConstantBuffer createConstantBuffer();

	/**
	 * Returns a new object of class '<em>Generic Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Constant Buffer</em>'.
	 * @generated
	 */
	GenericConstantBuffer createGenericConstantBuffer();

	/**
	 * Returns a new object of class '<em>Buffer Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Reference</em>'.
	 * @generated
	 */
	BufferReference createBufferReference();

	/**
	 * Returns a new object of class '<em>Buffer Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Data Provider</em>'.
	 * @generated
	 */
	BufferDataProvider createBufferDataProvider();

	/**
	 * Returns a new object of class '<em>Image Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Data Provider</em>'.
	 * @generated
	 */
	ImageDataProvider createImageDataProvider();

	/**
	 * Returns a new object of class '<em>File Image Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Image Data Provider</em>'.
	 * @generated
	 */
	FileImageDataProvider createFileImageDataProvider();

	/**
	 * Returns a new object of class '<em>Static Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Image</em>'.
	 * @generated
	 */
	StaticImage createStaticImage();

	/**
	 * Returns a new object of class '<em>Image Viewer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Viewer</em>'.
	 * @generated
	 */
	ImageViewer createImageViewer();

	/**
	 * Returns a new object of class '<em>Composite Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Image</em>'.
	 * @generated
	 */
	CompositeImage createCompositeImage();

	/**
	 * Returns a new object of class '<em>Image Inlay</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Inlay</em>'.
	 * @generated
	 */
	ImageInlay createImageInlay();

	/**
	 * Returns a new object of class '<em>Sampler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampler</em>'.
	 * @generated
	 */
	Sampler createSampler();

	/**
	 * Returns a new object of class '<em>Buffer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Descriptor</em>'.
	 * @generated
	 */
	BufferDescriptor createBufferDescriptor();

	/**
	 * Returns a new object of class '<em>Image Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Descriptor</em>'.
	 * @generated
	 */
	ImageDescriptor createImageDescriptor();

	/**
	 * Returns a new object of class '<em>Sampler Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampler Descriptor</em>'.
	 * @generated
	 */
	SamplerDescriptor createSamplerDescriptor();

	/**
	 * Returns a new object of class '<em>Descriptor Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptor Set</em>'.
	 * @generated
	 */
	DescriptorSet createDescriptorSet();

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
	 * Returns a new object of class '<em>Shader</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shader</em>'.
	 * @generated
	 */
	Shader createShader();

	/**
	 * Returns a new object of class '<em>Image Array Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Array Descriptor</em>'.
	 * @generated
	 */
	ImageArrayDescriptor createImageArrayDescriptor();

	/**
	 * Returns a new object of class '<em>Memory Chunk</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Chunk</em>'.
	 * @generated
	 */
	MemoryChunk createMemoryChunk();

	/**
	 * Returns a new object of class '<em>Buffer Memory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Memory</em>'.
	 * @generated
	 */
	BufferMemory createBufferMemory();

	/**
	 * Returns a new object of class '<em>Static Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Buffer</em>'.
	 * @generated
	 */
	StaticBuffer createStaticBuffer();

	/**
	 * Returns a new object of class '<em>Data Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Buffer</em>'.
	 * @generated
	 */
	DataBuffer createDataBuffer();

	/**
	 * Returns a new object of class '<em>Buffer Viewer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Viewer</em>'.
	 * @generated
	 */
	BufferViewer createBufferViewer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VulkanResourcePackage getVulkanResourcePackage();

} //VulkanResourceFactory
