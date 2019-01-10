/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.sheepy.vulkan.model.resource.DepthImage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depth Attachment Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.DepthAttachmentDescription#getDepthImage <em>Depth Image</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getDepthAttachmentDescription()
 * @model
 * @generated
 */
public interface DepthAttachmentDescription extends AttachmentDescription
{
	/**
	 * Returns the value of the '<em><b>Depth Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depth Image</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Image</em>' reference.
	 * @see #setDepthImage(DepthImage)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getDepthAttachmentDescription_DepthImage()
	 * @model
	 * @generated
	 */
	DepthImage getDepthImage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.DepthAttachmentDescription#getDepthImage <em>Depth Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Image</em>' reference.
	 * @see #getDepthImage()
	 * @generated
	 */
	void setDepthImage(DepthImage value);

} // DepthAttachmentDescription