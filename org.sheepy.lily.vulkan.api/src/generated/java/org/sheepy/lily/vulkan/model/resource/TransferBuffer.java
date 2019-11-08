/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.vulkan.model.IResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transfer Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#isUsedToPush <em>Used To Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#isUsedToFetch <em>Used To Fetch</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTransferBuffer()
 * @model
 * @generated
 */
public interface TransferBuffer extends IResource
{
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTransferBuffer_Size()
	 * @model unique="false"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see #setInstanceCount(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTransferBuffer_InstanceCount()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(int value);

	/**
	 * Returns the value of the '<em><b>Used To Push</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used To Push</em>' attribute.
	 * @see #setUsedToPush(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTransferBuffer_UsedToPush()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isUsedToPush();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#isUsedToPush <em>Used To Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used To Push</em>' attribute.
	 * @see #isUsedToPush()
	 * @generated
	 */
	void setUsedToPush(boolean value);

	/**
	 * Returns the value of the '<em><b>Used To Fetch</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used To Fetch</em>' attribute.
	 * @see #setUsedToFetch(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTransferBuffer_UsedToFetch()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUsedToFetch();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.TransferBuffer#isUsedToFetch <em>Used To Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used To Fetch</em>' attribute.
	 * @see #isUsedToFetch()
	 * @generated
	 */
	void setUsedToFetch(boolean value);

} // TransferBuffer
