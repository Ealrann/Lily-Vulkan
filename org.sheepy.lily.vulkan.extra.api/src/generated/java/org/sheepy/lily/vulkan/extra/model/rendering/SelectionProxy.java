/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.core.api.model.ILilyEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy#getPickMode <em>Pick Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy#getFocus <em>Focus</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getSelectionProxy()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface SelectionProxy extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Pick Mode</b></em>' attribute.
	 * The default value is <code>"Enabled"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pick Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode
	 * @see #setPickMode(EMousePickMode)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getSelectionProxy_PickMode()
	 * @model default="Enabled" required="true"
	 * @generated
	 */
	EMousePickMode getPickMode();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy#getPickMode <em>Pick Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pick Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode
	 * @see #getPickMode()
	 * @generated
	 */
	void setPickMode(EMousePickMode value);

	/**
	 * Returns the value of the '<em><b>Selection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' containment reference.
	 * @see #setSelection(IEntitySelection)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getSelectionProxy_Selection()
	 * @model containment="true"
	 * @generated
	 */
	IEntitySelection getSelection();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy#getSelection <em>Selection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection</em>' containment reference.
	 * @see #getSelection()
	 * @generated
	 */
	void setSelection(IEntitySelection value);

	/**
	 * Returns the value of the '<em><b>Focus</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Focus</em>' containment reference.
	 * @see #setFocus(IEntitySelection)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getSelectionProxy_Focus()
	 * @model containment="true"
	 * @generated
	 */
	IEntitySelection getFocus();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy#getFocus <em>Focus</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Focus</em>' containment reference.
	 * @see #getFocus()
	 * @generated
	 */
	void setFocus(IEntitySelection value);

} // SelectionProxy
