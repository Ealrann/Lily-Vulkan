/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.presentation.IPresentationPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntityResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.SpritePkg#getSprites <em>Sprites</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpritePkg()
 * @model
 * @generated
 */
public interface SpritePkg extends ISpriteDataSource, IEntityResolver, IPresentationPkg
{
	/**
	 * Returns the value of the '<em><b>Sprites</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sprites</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSpritePkg_Sprites()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sprite> getSprites();

} // SpritePkg
