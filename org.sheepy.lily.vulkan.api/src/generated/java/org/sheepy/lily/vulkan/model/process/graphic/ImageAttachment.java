/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.joml.Vector4fc;
import org.sheepy.lily.vulkan.model.VulkanEngine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment#getClearValue <em>Clear Value</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment#getImageRef <em>Image Ref</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getImageAttachment()
 * @model
 * @generated
 */
public interface ImageAttachment extends ExtraAttachment
{
	/**
	 * Returns the value of the '<em><b>Clear Value</b></em>' attribute.
	 * The default value is <code>"0;0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Value</em>' attribute.
	 * @see #setClearValue(Vector4fc)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getImageAttachment_ClearValue()
	 * @model default="0;0;0;0" unique="false" dataType="org.sheepy.lily.core.model.types.Color4f"
	 * @generated
	 */
	Vector4fc getClearValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment#getClearValue <em>Clear Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Value</em>' attribute.
	 * @see #getClearValue()
	 * @generated
	 */
	void setClearValue(Vector4fc value);

	/**
	 * Returns the value of the '<em><b>Image Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Ref</em>' reference.
	 * @see #setImageRef(VulkanEngine)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getImageAttachment_ImageRef()
	 * @model
	 * @generated
	 */
	VulkanEngine getImageRef();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment#getImageRef <em>Image Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Ref</em>' reference.
	 * @see #getImageRef()
	 * @generated
	 */
	void setImageRef(VulkanEngine value);

} // ImageAttachment
