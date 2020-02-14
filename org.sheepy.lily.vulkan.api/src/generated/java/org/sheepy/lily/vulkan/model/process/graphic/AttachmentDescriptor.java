/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.vulkan.model.IDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attachment Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor#getAttachment <em>Attachment</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentDescriptor()
 * @model
 * @generated
 */
public interface AttachmentDescriptor extends IDescriptor
{
	/**
	 * Returns the value of the '<em><b>Attachment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment</em>' reference.
	 * @see #setAttachment(ExtraAttachment)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentDescriptor_Attachment()
	 * @model required="true"
	 * @generated
	 */
	ExtraAttachment getAttachment();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor#getAttachment <em>Attachment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment</em>' reference.
	 * @see #getAttachment()
	 * @generated
	 */
	void setAttachment(ExtraAttachment value);

} // AttachmentDescriptor
