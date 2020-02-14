/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attachment Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg#getColorAttachment <em>Color Attachment</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg#getExtraAttachments <em>Extra Attachments</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentPkg()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface AttachmentPkg extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Extra Attachments</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extra Attachments</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentPkg_ExtraAttachments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtraAttachment> getExtraAttachments();

	/**
	 * Returns the value of the '<em><b>Color Attachment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Attachment</em>' containment reference.
	 * @see #setColorAttachment(SwapImageAttachment)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentPkg_ColorAttachment()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SwapImageAttachment getColorAttachment();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg#getColorAttachment <em>Color Attachment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Attachment</em>' containment reference.
	 * @see #getColorAttachment()
	 * @generated
	 */
	void setColorAttachment(SwapImageAttachment value);

} // AttachmentPkg
