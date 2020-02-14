/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attachment Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef#getAttachment <em>Attachment</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentRef()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface AttachmentRef extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Attachment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment</em>' reference.
	 * @see #setAttachment(Attachment)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentRef_Attachment()
	 * @model
	 * @generated
	 */
	Attachment getAttachment();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef#getAttachment <em>Attachment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment</em>' reference.
	 * @see #getAttachment()
	 * @generated
	 */
	void setAttachment(Attachment value);

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setLayout(EImageLayout)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentRef_Layout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef#getLayout <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(EImageLayout value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"Color"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType
	 * @see #setType(EAttachmentType)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentRef_Type()
	 * @model default="Color" required="true"
	 * @generated
	 */
	EAttachmentType getType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType
	 * @see #getType()
	 * @generated
	 */
	void setType(EAttachmentType value);

} // AttachmentRef
