/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.vulkan.model.IDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sampled Image Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor#getSampledImage <em>Sampled Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getSampledImageDescriptor()
 * @model
 * @generated
 */
public interface SampledImageDescriptor extends IDescriptor
{
	/**
	 * Returns the value of the '<em><b>Sampled Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampled Image</em>' reference.
	 * @see #setSampledImage(SampledImage)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getSampledImageDescriptor_SampledImage()
	 * @model
	 * @generated
	 */
	SampledImage getSampledImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor#getSampledImage <em>Sampled Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampled Image</em>' reference.
	 * @see #getSampledImage()
	 * @generated
	 */
	void setSampledImage(SampledImage value);

} // SampledImageDescriptor
