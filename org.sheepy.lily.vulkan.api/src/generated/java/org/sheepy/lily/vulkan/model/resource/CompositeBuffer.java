/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getDataProviders <em>Data Providers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getTransferBuffer <em>Transfer Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getMinSize <em>Min Size</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer()
 * @model
 * @generated
 */
public interface CompositeBuffer extends IBuffer
{
	/**
	 * Returns the value of the '<em><b>Data Providers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider}<code>&lt;?&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Providers</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer_DataProviders()
	 * @model containment="true"
	 * @generated
	 */
	EList<BufferDataProvider<?>> getDataProviders();

	/**
	 * Returns the value of the '<em><b>Transfer Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transfer Buffer</em>' reference.
	 * @see #setTransferBuffer(TransferBuffer)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer_TransferBuffer()
	 * @model required="true"
	 * @generated
	 */
	TransferBuffer getTransferBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getTransferBuffer <em>Transfer Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transfer Buffer</em>' reference.
	 * @see #getTransferBuffer()
	 * @generated
	 */
	void setTransferBuffer(TransferBuffer value);

	/**
	 * Returns the value of the '<em><b>Min Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Size</em>' attribute.
	 * @see #setMinSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer_MinSize()
	 * @model default="0" required="true"
	 * @generated
	 */
	long getMinSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getMinSize <em>Min Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Size</em>' attribute.
	 * @see #getMinSize()
	 * @generated
	 */
	void setMinSize(long value);

} // CompositeBuffer
