/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.PushBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PushBufferTask#getPushBuffer <em>Push Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPushBufferTask()
 * @model
 * @generated
 */
public interface PushBufferTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Push Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Push Buffer</em>' reference.
	 * @see #setPushBuffer(PushBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPushBufferTask_PushBuffer()
	 * @model required="true"
	 * @generated
	 */
	PushBuffer getPushBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PushBufferTask#getPushBuffer <em>Push Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Push Buffer</em>' reference.
	 * @see #getPushBuffer()
	 * @generated
	 */
	void setPushBuffer(PushBuffer value);

} // PushBufferTask
