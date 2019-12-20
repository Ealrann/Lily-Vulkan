/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage
 * @generated
 */
public interface ResourceFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourceFactory eINSTANCE = org.sheepy.lily.vulkan.model.resource.impl.ResourceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transfer Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transfer Buffer</em>'.
	 * @generated
	 */
	TransferBuffer createTransferBuffer();

	/**
	 * Returns a new object of class '<em>Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Buffer</em>'.
	 * @generated
	 */
	ConstantBuffer createConstantBuffer();

	/**
	 * Returns a new object of class '<em>Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer</em>'.
	 * @generated
	 */
	Buffer createBuffer();

	/**
	 * Returns a new object of class '<em>Composite Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Buffer</em>'.
	 * @generated
	 */
	CompositeBuffer createCompositeBuffer();

	/**
	 * Returns a new object of class '<em>Composite Part Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Part Reference</em>'.
	 * @generated
	 */
	CompositePartReference createCompositePartReference();

	/**
	 * Returns a new object of class '<em>Buffer Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Reference</em>'.
	 * @generated
	 */
	BufferReference createBufferReference();

	/**
	 * Returns a new object of class '<em>Composite Buffer Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Buffer Reference</em>'.
	 * @generated
	 */
	CompositeBufferReference createCompositeBufferReference();

	/**
	 * Returns a new object of class '<em>Buffer Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Data Provider</em>'.
	 * @generated
	 */
	<T> BufferDataProvider<T> createBufferDataProvider();

	/**
	 * Returns a new object of class '<em>Static Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Image</em>'.
	 * @generated
	 */
	StaticImage createStaticImage();

	/**
	 * Returns a new object of class '<em>File Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Image</em>'.
	 * @generated
	 */
	FileImage createFileImage();

	/**
	 * Returns a new object of class '<em>Sampled Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampled Image</em>'.
	 * @generated
	 */
	SampledImage createSampledImage();

	/**
	 * Returns a new object of class '<em>Sampler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampler</em>'.
	 * @generated
	 */
	Sampler createSampler();

	/**
	 * Returns a new object of class '<em>Semaphore</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semaphore</em>'.
	 * @generated
	 */
	Semaphore createSemaphore();

	/**
	 * Returns a new object of class '<em>Font Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font Image</em>'.
	 * @generated
	 */
	FontImage createFontImage();

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
	 * Returns a new object of class '<em>Sampled Image Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampled Image Descriptor</em>'.
	 * @generated
	 */
	SampledImageDescriptor createSampledImageDescriptor();

	/**
	 * Returns a new object of class '<em>Sampler Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampler Descriptor</em>'.
	 * @generated
	 */
	SamplerDescriptor createSamplerDescriptor();

	/**
	 * Returns a new object of class '<em>Texture2 DArray Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Texture2 DArray Descriptor</em>'.
	 * @generated
	 */
	Texture2DArrayDescriptor createTexture2DArrayDescriptor();

	/**
	 * Returns a new object of class '<em>Descriptor Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptor Set</em>'.
	 * @generated
	 */
	DescriptorSet createDescriptorSet();

	/**
	 * Returns a new object of class '<em>Descriptor Set Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptor Set Pkg</em>'.
	 * @generated
	 */
	DescriptorSetPkg createDescriptorSetPkg();

	/**
	 * Returns a new object of class '<em>Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Barrier</em>'.
	 * @generated
	 */
	BufferBarrier createBufferBarrier();

	/**
	 * Returns a new object of class '<em>Composite Buffer Barrier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Buffer Barrier</em>'.
	 * @generated
	 */
	CompositeBufferBarrier createCompositeBufferBarrier();

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
	 * Returns a new object of class '<em>Texture2 DArray</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Texture2 DArray</em>'.
	 * @generated
	 */
	Texture2DArray createTexture2DArray();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResourcePackage getResourcePackage();

} //ResourceFactory
