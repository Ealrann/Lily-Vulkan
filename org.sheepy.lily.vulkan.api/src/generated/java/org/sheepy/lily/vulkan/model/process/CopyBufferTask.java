/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.IBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Copy Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSize <em>Size</em>}</li>
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
	 * Returns the value of the '<em><b>Src Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Buffer</em>' reference.
	 * @see #setSrcBuffer(IBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask_SrcBuffer()
	 * @model required="true"
	 * @generated
	 */
	IBuffer getSrcBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSrcBuffer <em>Src Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Buffer</em>' reference.
	 * @see #getSrcBuffer()
	 * @generated
	 */
	void setSrcBuffer(IBuffer value);

	/**
	 * Returns the value of the '<em><b>Dst Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Buffer</em>' reference.
	 * @see #setDstBuffer(IBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask_DstBuffer()
	 * @model required="true"
	 * @generated
	 */
	IBuffer getDstBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getDstBuffer <em>Dst Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Buffer</em>' reference.
	 * @see #getDstBuffer()
	 * @generated
	 */
	void setDstBuffer(IBuffer value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #isSetSize()
	 * @see #unsetSize()
	 * @see #setSize(long)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getCopyBufferTask_Size()
	 * @model unsettable="true"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #isSetSize()
	 * @see #unsetSize()
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Unsets the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSize()
	 * @see #getSize()
	 * @see #setSize(long)
	 * @generated
	 */
	void unsetSize();

	/**
	 * Returns whether the value of the '{@link org.sheepy.lily.vulkan.model.process.CopyBufferTask#getSize <em>Size</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Size</em>' attribute is set.
	 * @see #unsetSize()
	 * @see #getSize()
	 * @see #setSize(long)
	 * @generated
	 */
	boolean isSetSize();

} // CopyBufferTask
