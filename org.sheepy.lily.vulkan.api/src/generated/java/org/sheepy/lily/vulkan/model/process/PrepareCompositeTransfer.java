/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.BufferReference;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prepare Composite Transfer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getCompositeBuffer <em>Composite Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getMode <em>Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#isPrepareDuringUpdate <em>Prepare During Update</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getBufferReference <em>Buffer Reference</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getTransferBuffer <em>Transfer Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer()
 * @model
 * @generated
 */
public interface PrepareCompositeTransfer extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Buffer</em>' reference.
	 * @see #setCompositeBuffer(CompositeBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_CompositeBuffer()
	 * @model required="true"
	 * @generated
	 */
	CompositeBuffer getCompositeBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getCompositeBuffer <em>Composite Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Buffer</em>' reference.
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	void setCompositeBuffer(CompositeBuffer value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The default value is <code>"PUSH"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.resource.EFlushMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
	 * @see #setMode(EFlushMode)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_Mode()
	 * @model default="PUSH" required="true"
	 * @generated
	 */
	EFlushMode getMode();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.resource.EFlushMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(EFlushMode value);

	/**
	 * Returns the value of the '<em><b>Prepare During Update</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prepare During Update</em>' attribute.
	 * @see #setPrepareDuringUpdate(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_PrepareDuringUpdate()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPrepareDuringUpdate();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#isPrepareDuringUpdate <em>Prepare During Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prepare During Update</em>' attribute.
	 * @see #isPrepareDuringUpdate()
	 * @generated
	 */
	void setPrepareDuringUpdate(boolean value);

	/**
	 * Returns the value of the '<em><b>Buffer Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Reference</em>' containment reference.
	 * @see #setBufferReference(BufferReference)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_BufferReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BufferReference getBufferReference();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getBufferReference <em>Buffer Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Reference</em>' containment reference.
	 * @see #getBufferReference()
	 * @generated
	 */
	void setBufferReference(BufferReference value);

	/**
	 * Returns the value of the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transfer Buffer</em>' reference.
	 * @see #setTransferBuffer(TransferBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getPrepareCompositeTransfer_TransferBuffer()
	 * @model required="true"
	 * @generated
	 */
	TransferBuffer getTransferBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer#getTransferBuffer <em>Transfer Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transfer Buffer</em>' reference.
	 * @see #getTransferBuffer()
	 * @generated
	 */
	void setTransferBuffer(TransferBuffer value);

} // PrepareCompositeTransfer
