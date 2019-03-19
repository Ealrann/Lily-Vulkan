/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.resource.DepthImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depth Framebuffer Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DepthFramebufferAttachment#isClear <em>Clear</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.DepthFramebufferAttachment#getDepthImageRef <em>Depth Image Ref</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDepthFramebufferAttachment()
 * @model
 * @generated
 */
public interface DepthFramebufferAttachment extends IFramebufferAttachment
{
	/**
	 * Returns the value of the '<em><b>Clear</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear</em>' attribute.
	 * @see #setClear(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDepthFramebufferAttachment_Clear()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isClear();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.DepthFramebufferAttachment#isClear <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear</em>' attribute.
	 * @see #isClear()
	 * @generated
	 */
	void setClear(boolean value);

	/**
	 * Returns the value of the '<em><b>Depth Image Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Image Ref</em>' reference.
	 * @see #setDepthImageRef(DepthImage)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getDepthFramebufferAttachment_DepthImageRef()
	 * @model
	 * @generated
	 */
	DepthImage getDepthImageRef();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.DepthFramebufferAttachment#getDepthImageRef <em>Depth Image Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Image Ref</em>' reference.
	 * @see #getDepthImageRef()
	 * @generated
	 */
	void setDepthImageRef(DepthImage value);

} // DepthFramebufferAttachment
