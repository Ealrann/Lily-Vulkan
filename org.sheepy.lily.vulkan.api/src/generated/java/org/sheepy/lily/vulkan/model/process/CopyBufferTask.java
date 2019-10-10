/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.Buffer;

import org.sheepy.vulkan.model.enumeration.ECommandStage;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getTrgBuffer <em>Trg Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getStage <em>Stage</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask()
 * @model
 * @generated
 */
public interface CopyBufferTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Src Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Buffer</em>' reference.
	 * @see #setSrcBuffer(Buffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask_SrcBuffer()
	 * @model required="true"
	 * @generated
	 */
	Buffer getSrcBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSrcBuffer <em>Src Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Buffer</em>' reference.
	 * @see #getSrcBuffer()
	 * @generated
	 */
	void setSrcBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Trg Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trg Buffer</em>' reference.
	 * @see #setTrgBuffer(Buffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask_TrgBuffer()
	 * @model required="true"
	 * @generated
	 */
	Buffer getTrgBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getTrgBuffer <em>Trg Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trg Buffer</em>' reference.
	 * @see #getTrgBuffer()
	 * @generated
	 */
	void setTrgBuffer(Buffer value);

	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The default value is <code>"Transfer"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECommandStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #setStage(ECommandStage)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask_Stage()
	 * @model default="Transfer" required="true"
	 * @generated
	 */
	ECommandStage getStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECommandStage
	 * @see #getStage()
	 * @generated
	 */
	void setStage(ECommandStage value);

} // CopyBufferTask
