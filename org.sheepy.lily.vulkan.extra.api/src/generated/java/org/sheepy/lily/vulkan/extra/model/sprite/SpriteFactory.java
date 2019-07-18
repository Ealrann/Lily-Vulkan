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
	 * Returns a new object of class '<em>Pipeline Maintainer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline Maintainer</em>'.
	 * @generated
	 */
	SpritePipelineMaintainer createSpritePipelineMaintainer();

	/**
	 * Returns a new object of class '<em>Sprite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sprite</em>'.
	 * @generated
	 */
	Sprite createSprite();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SpritePackage getSpritePackage();

} //SpriteFactory
