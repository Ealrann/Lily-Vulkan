/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fetch Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.FetchBuffer#getBufferReference <em>Buffer Reference</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getFetchBuffer()
 * @model
 * @generated
 */
public interface FetchBuffer extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Buffer Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Reference</em>' containment reference.
	 * @see #setBufferReference(BufferReference)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getFetchBuffer_BufferReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BufferReference getBufferReference();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.FetchBuffer#getBufferReference <em>Buffer Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Reference</em>' containment reference.
	 * @see #getBufferReference()
	 * @generated
	 */
	void setBufferReference(BufferReference value);

} // FetchBuffer
