/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subpass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.Subpass#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.Subpass#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpass()
 * @model
 * @generated
 */
public interface Subpass extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpass_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.Subpass#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.process.graphic.AttachementRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refs</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getSubpass_Refs()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttachementRef> getRefs();

} // Subpass
