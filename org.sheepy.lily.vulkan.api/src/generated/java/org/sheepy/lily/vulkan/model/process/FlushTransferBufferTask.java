/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#isFlushDuringUpdate <em>Flush During Update</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The default value is <code>"Transfer"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECommandStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #setStage(ECommandStage)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getFlushTransferBufferTask_Stage()
	 * @model default="Transfer" required="true"
	 * @generated
	 */
	ECommandStage getStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #getStage()
	 * @generated
	 */
	void setStage(ECommandStage value);

	/**
	 * Returns the value of the '<em><b>Flush During Update</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flush During Update</em>' attribute.
	 * @see #setFlushDuringUpdate(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getFlushTransferBufferTask_FlushDuringUpdate()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isFlushDuringUpdate();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask#isFlushDuringUpdate <em>Flush During Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flush During Update</em>' attribute.
	 * @see #isFlushDuringUpdate()
	 * @generated
	 */
	void setFlushDuringUpdate(boolean value);

} // FlushTransferBufferTask
