/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extra Attachment Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription#getAttachment <em>Attachment</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getExtraAttachmentDescription()
 * @model
 * @generated
 */
public interface ExtraAttachmentDescription extends AttachmentDescription
{
	/**
	 * Returns the value of the '<em><b>Attachment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment</em>' reference.
	 * @see #setAttachment(ISwapAttachment)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getExtraAttachmentDescription_Attachment()
	 * @model required="true"
	 * @generated
	 */
	ISwapAttachment getAttachment();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachmentDescription#getAttachment <em>Attachment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment</em>' reference.
	 * @see #getAttachment()
	 * @generated
	 */
	void setAttachment(ISwapAttachment value);

} // ExtraAttachmentDescription
