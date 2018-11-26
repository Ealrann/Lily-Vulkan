/**
 */
package org.sheepy.vulkan.model.gui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.common.api.types.SVector2i;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Window</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.gui.Window#getWidgets <em>Widgets</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.gui.Window#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.gui.GuiPackage#getWindow()
 * @model
 * @generated
 */
public interface Window extends EObject
{

	/**
	 * Returns the value of the '<em><b>Widgets</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.gui.Widget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widgets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widgets</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.gui.GuiPackage#getWindow_Widgets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Widget> getWidgets();

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(SVector2i)
	 * @see org.sheepy.vulkan.model.gui.GuiPackage#getWindow_Position()
	 * @model unique="false" dataType="org.sheepy.common.model.types.SVector2i"
	 * @generated
	 */
	SVector2i getPosition();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.gui.Window#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(SVector2i value);
} // Window
