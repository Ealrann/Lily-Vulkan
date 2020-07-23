/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.BufferReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Copy Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSrcBuffer <em>Src Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getDstBuffer <em>Dst Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask()
 * @model
 * @generated
 */
public interface CopyBufferTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Src Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Buffer</em>' containment reference.
	 * @see #setSrcBuffer(BufferReference)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask_SrcBuffer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BufferReference getSrcBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSrcBuffer <em>Src Buffer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Buffer</em>' containment reference.
	 * @see #getSrcBuffer()
	 * @generated
	 */
	void setSrcBuffer(BufferReference value);

	/**
	 * Returns the value of the '<em><b>Dst Buffer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Buffer</em>' containment reference.
	 * @see #setDstBuffer(BufferReference)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask_DstBuffer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BufferReference getDstBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getDstBuffer <em>Dst Buffer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Buffer</em>' containment reference.
	 * @see #getDstBuffer()
	 * @generated
	 */
	void setDstBuffer(BufferReference value);

} // CopyBufferTask
