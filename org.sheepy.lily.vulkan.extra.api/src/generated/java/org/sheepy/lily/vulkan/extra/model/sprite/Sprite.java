/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sprite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getImage <em>Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSprite()
 * @model
 * @generated
 */
public interface Sprite extends Presentation, LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' containment reference.
	 * @see #setImage(FileImage)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSprite_Image()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FileImage getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getImage <em>Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' containment reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(FileImage value);

} // Sprite
