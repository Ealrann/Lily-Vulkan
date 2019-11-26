/**
 */
package org.sheepy.lily.vulkan.model.resource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sampler Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.SamplerDescriptor#getSampler <em>Sampler</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSamplerDescriptor()
 * @model
 * @generated
 */
public interface SamplerDescriptor extends Descriptor
{
	/**
	 * Returns the value of the '<em><b>Sampler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampler</em>' reference.
	 * @see #setSampler(Sampler)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSamplerDescriptor_Sampler()
	 * @model required="true"
	 * @generated
	 */
	Sampler getSampler();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.SamplerDescriptor#getSampler <em>Sampler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampler</em>' reference.
	 * @see #getSampler()
	 * @generated
	 */
	void setSampler(Sampler value);

} // SamplerDescriptor
