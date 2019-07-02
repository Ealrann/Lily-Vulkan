/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EObject;

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
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentRef()
 * @model
 * @generated
 */
public interface AttachmentRef extends EObject
{
	/**
	 * Returns the value of the '<em><b>Attachment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment</em>' reference.
	 * @see #setAttachment(AttachmentDescription)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getAttachmentRef_Attachment()
	 * @model
	 * @generated
	 */
	AttachmentDescription getAttachment();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef#getAttachment <em>Attachment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment</em>' reference.
	 * @see #getAttachment()
	 * @generated
	 */
	void setAttachment(AttachmentDescription value);

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

} // AttachmentRef