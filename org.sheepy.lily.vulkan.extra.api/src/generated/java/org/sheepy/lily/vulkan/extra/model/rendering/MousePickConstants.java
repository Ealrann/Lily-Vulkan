/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mouse Pick Constants</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants#getMousePickExtension <em>Mouse Pick Extension</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickConstants()
 * @model
 * @generated
 */
public interface MousePickConstants extends ConstantBuffer
{

	/**
	 * Returns the value of the '<em><b>Mouse Pick Extension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mouse Pick Extension</em>' reference.
	 * @see #setMousePickExtension(MousePickExtension)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getMousePickConstants_MousePickExtension()
	 * @model required="true"
	 * @generated
	 */
	MousePickExtension getMousePickExtension();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants#getMousePickExtension <em>Mouse Pick Extension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mouse Pick Extension</em>' reference.
	 * @see #getMousePickExtension()
	 * @generated
	 */
	void setMousePickExtension(MousePickExtension value);
} // MousePickConstants
