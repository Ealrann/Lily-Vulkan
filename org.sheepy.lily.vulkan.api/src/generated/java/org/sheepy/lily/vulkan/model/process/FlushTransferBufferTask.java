/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.TransferBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flush Transfer Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#getTransferBuffer <em>Transfer Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getFlushTransferBufferTask()
 * @model
 * @generated
 */
public interface FlushTransferBufferTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transfer Buffer</em>' reference.
	 * @see #setTransferBuffer(TransferBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getFlushTransferBufferTask_TransferBuffer()
	 * @model required="true"
	 * @generated
	 */
	TransferBuffer getTransferBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#getTransferBuffer <em>Transfer Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transfer Buffer</em>' reference.
	 * @see #getTransferBuffer()
	 * @generated
	 */
	void setTransferBuffer(TransferBuffer value);

} // FlushTransferBufferTask
