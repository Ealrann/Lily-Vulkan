/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.vulkan.model.process.IProcessExtension;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mouse Pick Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getMousePickBuffer <em>Mouse Pick Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getSelectionProxy <em>Selection Proxy</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickExtension()
 * @model
 * @generated
 */
public interface MousePickExtension extends IProcessExtension
{
	/**
	 * Returns the value of the '<em><b>Mouse Pick Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mouse Pick Buffer</em>' reference.
	 * @see #setMousePickBuffer(StaticBuffer)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickExtension_MousePickBuffer()
	 * @model required="true"
	 * @generated
	 */
	StaticBuffer getMousePickBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getMousePickBuffer <em>Mouse Pick Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mouse Pick Buffer</em>' reference.
	 * @see #getMousePickBuffer()
	 * @generated
	 */
	void setMousePickBuffer(StaticBuffer value);

	/**
	 * Returns the value of the '<em><b>Selection Proxy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Proxy</em>' reference.
	 * @see #setSelectionProxy(SelectionProxy)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickExtension_SelectionProxy()
	 * @model
	 * @generated
	 */
	SelectionProxy getSelectionProxy();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension#getSelectionProxy <em>Selection Proxy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Proxy</em>' reference.
	 * @see #getSelectionProxy()
	 * @generated
	 */
	void setSelectionProxy(SelectionProxy value);

} // MousePickExtension
