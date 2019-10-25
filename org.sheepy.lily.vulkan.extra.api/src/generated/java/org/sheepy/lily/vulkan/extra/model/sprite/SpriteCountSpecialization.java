/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Count Specialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization#getProvider <em>Provider</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteCountSpecialization()
 * @model
 * @generated
 */
public interface SpriteCountSpecialization extends ISpecialization
{
	/**
	 * Returns the value of the '<em><b>Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider</em>' reference.
	 * @see #setProvider(SpriteMonoSamplerProvider)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpriteCountSpecialization_Provider()
	 * @model required="true"
	 * @generated
	 */
	SpriteMonoSamplerProvider getProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization#getProvider <em>Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' reference.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(SpriteMonoSamplerProvider value);

} // SpriteCountSpecialization
