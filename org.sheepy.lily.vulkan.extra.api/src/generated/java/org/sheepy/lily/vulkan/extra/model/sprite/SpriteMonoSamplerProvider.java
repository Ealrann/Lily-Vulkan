/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.vulkan.model.image.SamplerInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mono Sampler Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider#getSamplerInfo <em>Sampler Info</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteMonoSamplerProvider()
 * @model
 * @generated
 */
public interface SpriteMonoSamplerProvider extends ResourceDescriptorProvider
{
	/**
	 * Returns the value of the '<em><b>Sampler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sampler Info</em>' containment reference.
	 * @see #setSamplerInfo(SamplerInfo)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteMonoSamplerProvider_SamplerInfo()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SamplerInfo getSamplerInfo();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider#getSamplerInfo <em>Sampler Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sampler Info</em>' containment reference.
	 * @see #getSamplerInfo()
	 * @generated
	 */
	void setSamplerInfo(SamplerInfo value);

} // SpriteMonoSamplerProvider
