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
	ResourceFactory eINSTANCE = org.sheepy.lily.vulkan.model.resource.impl.ResourceFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Basic Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Resource</em>'.
	 * @generated
	 */
	BasicResource createBasicResource();

	/**
	 * Returns a new object of class '<em>Push Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Push Buffer</em>'.
	 * @generated
	 */
	PushBuffer createPushBuffer();

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
	BufferDataProvider createBufferDataProvider();

	/**
	 * Returns a new object of class '<em>Described Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Described Data Provider</em>'.
	 * @generated
	 */
	DescribedDataProvider createDescribedDataProvider();

	/**
	 * Returns a new object of class '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image</em>'.
	 * @generated
	 */
	Image createImage();

	/**
	 * Returns a new object of class '<em>Image Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image Layout</em>'.
	 * @generated
	 */
	ImageLayout createImageLayout();

	/**
	 * Returns a new object of class '<em>Sampled Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampled Image</em>'.
	 * @generated
	 */
	SampledImage createSampledImage();

	/**
	 * Returns a new object of class '<em>Semaphore</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semaphore</em>'.
	 * @generated
	 */
	Semaphore createSemaphore();

	/**
	 * Returns a new object of class '<em>Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font</em>'.
	 * @generated
	 */
	Font createFont();

	/**
	 * Returns a new object of class '<em>Texture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Texture</em>'.
	 * @generated
	 */
	Texture createTexture();

	/**
	 * Returns a new object of class '<em>Sampler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sampler</em>'.
	 * @generated
	 */
	Sampler createSampler();

	/**
	 * Returns a new object of class '<em>Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Descriptor</em>'.
	 * @generated
	 */
	Descriptor createDescriptor();

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
	 * Returns a new object of class '<em>String Module Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Module Resource</em>'.
	 * @generated
	 */
	StringModuleResource createStringModuleResource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResourcePackage getResourcePackage();

} //ResourceFactory
