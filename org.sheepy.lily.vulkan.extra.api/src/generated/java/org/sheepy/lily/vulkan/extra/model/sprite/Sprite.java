/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite;

import org.sheepy.lily.core.model.resource.FileImage;
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
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getFile <em>File</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getType <em>Type</em>}</li>
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
	 * @see #setFile(FileImage)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSprite_File()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FileImage getFile();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getFile <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' containment reference.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(FileImage value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"Floor"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteType
	 * @see #setType(SpriteType)
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage#getSprite_Type()
	 * @model default="Floor" required="true"
	 * @generated
	 */
	SpriteType getType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.sprite.Sprite#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteType
	 * @see #getType()
	 * @generated
	 */
	void setType(SpriteType value);

} // Sprite
