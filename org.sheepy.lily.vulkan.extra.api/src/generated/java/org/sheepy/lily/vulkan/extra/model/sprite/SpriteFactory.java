/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage
 * @generated
 */
public interface SpriteFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpriteFactory eINSTANCE = org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Renderer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Renderer</em>'.
	 * @generated
	 */
	SpriteRenderer createSpriteRenderer();

	/**
	 * Returns a new object of class '<em>Sprite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sprite</em>'.
	 * @generated
	 */
	Sprite createSprite();

	/**
	 * Returns a new object of class '<em>Mono Sampler Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mono Sampler Provider</em>'.
	 * @generated
	 */
	SpriteMonoSamplerProvider createSpriteMonoSamplerProvider();

	/**
	 * Returns a new object of class '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure</em>'.
	 * @generated
	 */
	SpriteStructure createSpriteStructure();

	/**
	 * Returns a new object of class '<em>Count Specialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Count Specialization</em>'.
	 * @generated
	 */
	SpriteCountSpecialization createSpriteCountSpecialization();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SpritePackage getSpritePackage();

} //SpriteFactory
