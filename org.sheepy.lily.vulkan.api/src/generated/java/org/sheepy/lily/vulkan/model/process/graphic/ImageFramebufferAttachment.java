/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.joml.Vector4f;
import org.sheepy.lily.vulkan.model.resource.Image;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Framebuffer Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ImageFramebufferAttachment#getClearValue <em>Clear Value</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ImageFramebufferAttachment#getImageRef <em>Image Ref</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getImageFramebufferAttachment()
 * @model
 * @generated
 */
public interface ImageFramebufferAttachment extends IFramebufferAttachment
{
	/**
	 * Returns the value of the '<em><b>Clear Value</b></em>' attribute.
	 * The default value is <code>"0;0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Value</em>' attribute.
	 * @see #setClearValue(Vector4f)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getImageFramebufferAttachment_ClearValue()
	 * @model default="0;0;0;0" unique="false" dataType="org.sheepy.lily.core.model.types.Color4f"
	 * @generated
	 */
	Vector4f getClearValue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.ImageFramebufferAttachment#getClearValue <em>Clear Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Value</em>' attribute.
	 * @see #getClearValue()
	 * @generated
	 */
	void setClearValue(Vector4f value);

	/**
	 * Returns the value of the '<em><b>Image Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Ref</em>' reference.
	 * @see #setImageRef(Image)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getImageFramebufferAttachment_ImageRef()
	 * @model
	 * @generated
	 */
	Image getImageRef();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.ImageFramebufferAttachment#getImageRef <em>Image Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Ref</em>' reference.
	 * @see #getImageRef()
	 * @generated
	 */
	void setImageRef(Image value);

} // ImageFramebufferAttachment
