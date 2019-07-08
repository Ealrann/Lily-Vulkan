/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.vulkan.model.IResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.PushBuffer#isBeingUpdated <em>Being Updated</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.PushBuffer#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.PushBuffer#getInstanceCount <em>Instance Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getPushBuffer()
 * @model
 * @generated
 */
public interface PushBuffer extends IResource
{
	/**
	 * Returns the value of the '<em><b>Being Updated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Being Updated</em>' attribute.
	 * @see #setBeingUpdated(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getPushBuffer_BeingUpdated()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isBeingUpdated();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.PushBuffer#isBeingUpdated <em>Being Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Being Updated</em>' attribute.
	 * @see #isBeingUpdated()
	 * @generated
	 */
	void setBeingUpdated(boolean value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getPushBuffer_Size()
	 * @model unique="false"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.PushBuffer#getSize <em>Size</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getPushBuffer_InstanceCount()
	 * @model default="3" unique="false"
	 * @generated
	 */
	int getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.PushBuffer#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(int value);

} // PushBuffer
