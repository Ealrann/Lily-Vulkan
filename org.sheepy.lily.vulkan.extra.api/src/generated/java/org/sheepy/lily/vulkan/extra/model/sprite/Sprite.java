/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.model.resource.PathResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sprite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSprite()
 * @model
 * @generated
 */
public interface Sprite extends Presentation
{
	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference.
	 * @see #setFile(PathResource)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSprite_File()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PathResource getFile();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getFile <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' containment reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(PathResource value);

} // Sprite
