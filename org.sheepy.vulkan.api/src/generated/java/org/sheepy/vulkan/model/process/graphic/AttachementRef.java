/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attachement Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.AttachementRef#getAttachement <em>Attachement</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.AttachementRef#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getAttachementRef()
 * @model
 * @generated
 */
public interface AttachementRef extends EObject
{

	/**
	 * Returns the value of the '<em><b>Attachement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachement</em>' reference.
	 * @see #setAttachement(AttachmentDescription)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getAttachementRef_Attachement()
	 * @model
	 * @generated
	 */
	AttachmentDescription getAttachement();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.AttachementRef#getAttachement <em>Attachement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachement</em>' reference.
	 * @see #getAttachement()
	 * @generated
	 */
	void setAttachement(AttachmentDescription value);

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setLayout(EImageLayout)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getAttachementRef_Layout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.AttachementRef#getLayout <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(EImageLayout value);

} // AttachementRef
