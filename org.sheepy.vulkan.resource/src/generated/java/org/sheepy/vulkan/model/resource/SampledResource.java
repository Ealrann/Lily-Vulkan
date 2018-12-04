/**
 */
package org.sheepy.vulkan.model.resource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sampled Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.SampledResource#getSampler <em>Sampler</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampledResource()
 * @model abstract="true"
 * @generated
 */
public interface SampledResource extends PipelineResource
{
	/**
	 * Returns the value of the '<em><b>Sampler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sampler</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampler</em>' containment reference.
	 * @see #setSampler(Sampler)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampledResource_Sampler()
	 * @model containment="true"
	 * @generated
	 */
	Sampler getSampler();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.SampledResource#getSampler <em>Sampler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampler</em>' containment reference.
	 * @see #getSampler()
	 * @generated
	 */
	void setSampler(Sampler value);

} // SampledResource
