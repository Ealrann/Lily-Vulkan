/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.vulkan.model.image.SamplerInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sampler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Sampler#getInfo <em>Info</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSampler()
 * @model
 * @generated
 */
public interface Sampler extends DescriptedResource
{
	/**
	 * Returns the value of the '<em><b>Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Info</em>' containment reference.
	 * @see #setInfo(SamplerInfo)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getSampler_Info()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SamplerInfo getInfo();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Sampler#getInfo <em>Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Info</em>' containment reference.
	 * @see #getInfo()
	 * @generated
	 */
	void setInfo(SamplerInfo value);

} // Sampler
