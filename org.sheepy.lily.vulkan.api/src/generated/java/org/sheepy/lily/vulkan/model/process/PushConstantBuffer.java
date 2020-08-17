/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push Constant Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PushConstantBuffer#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPushConstantBuffer()
 * @model
 * @generated
 */
public interface PushConstantBuffer extends PushConstant
{
	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' reference.
	 * @see #setBuffer(ConstantBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPushConstantBuffer_Buffer()
	 * @model required="true"
	 * @generated
	 */
	ConstantBuffer getBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PushConstantBuffer#getBuffer <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer</em>' reference.
	 * @see #getBuffer()
	 * @generated
	 */
	void setBuffer(ConstantBuffer value);

} // PushConstantBuffer
