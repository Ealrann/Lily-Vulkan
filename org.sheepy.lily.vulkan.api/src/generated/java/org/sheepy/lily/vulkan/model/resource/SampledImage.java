/**
 */
package org.sheepy.lily.vulkan.model.resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sampled Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.SampledImage#getSampler <em>Sampler</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSampledImage()
 * @model
 * @generated
 */
public interface SampledImage extends BasicDescriptedResource
{
	/**
	 * Returns the value of the '<em><b>Sampler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampler</em>' containment reference.
	 * @see #setSampler(Sampler)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSampledImage_Sampler()
	 * @model containment="true"
	 * @generated
	 */
	Sampler getSampler();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.SampledImage#getSampler <em>Sampler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampler</em>' containment reference.
	 * @see #getSampler()
	 * @generated
	 */
	void setSampler(Sampler value);

} // SampledImage
