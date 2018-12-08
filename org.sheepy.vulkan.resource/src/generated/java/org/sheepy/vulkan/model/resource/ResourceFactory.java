/**
 */
package org.sheepy.vulkan.model.resource;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.resource.ResourcePackage
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
	ResourceFactory eINSTANCE = org.sheepy.vulkan.model.resource.impl.ResourceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer</em>'.
	 * @generated
	 */
	Buffer createBuffer();

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
	 * Returns a new object of class '<em>Push Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Push Constant</em>'.
	 * @generated
	 */
	PushConstant createPushConstant();

	/**
	 * Returns a new object of class '<em>Basic Descriptor Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Descriptor Set</em>'.
	 * @generated
	 */
	BasicDescriptorSet createBasicDescriptorSet();

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
	 * Returns a new object of class '<em>Shader</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shader</em>'.
	 * @generated
	 */
	Shader createShader();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResourcePackage getResourcePackage();

} //ResourceFactory
