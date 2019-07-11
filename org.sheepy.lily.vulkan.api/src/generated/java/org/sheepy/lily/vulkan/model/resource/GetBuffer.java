/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.vulkan.model.IResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.GetBuffer#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getGetBuffer()
 * @model
 * @generated
 */
public interface GetBuffer extends IResource
{
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getGetBuffer_Size()
	 * @model unique="false"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.GetBuffer#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

} // GetBuffer
