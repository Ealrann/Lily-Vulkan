/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.GetBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.GetBufferTask#getGetBuffer <em>Get Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.GetBufferTask#getDeviceBuffer <em>Device Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getGetBufferTask()
 * @model
 * @generated
 */
public interface GetBufferTask extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Get Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Get Buffer</em>' reference.
	 * @see #setGetBuffer(GetBuffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getGetBufferTask_GetBuffer()
	 * @model required="true"
	 * @generated
	 */
	GetBuffer getGetBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.GetBufferTask#getGetBuffer <em>Get Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get Buffer</em>' reference.
	 * @see #getGetBuffer()
	 * @generated
	 */
	void setGetBuffer(GetBuffer value);

	/**
	 * Returns the value of the '<em><b>Device Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device Buffer</em>' reference.
	 * @see #setDeviceBuffer(Buffer)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getGetBufferTask_DeviceBuffer()
	 * @model
	 * @generated
	 */
	Buffer getDeviceBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.GetBufferTask#getDeviceBuffer <em>Device Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device Buffer</em>' reference.
	 * @see #getDeviceBuffer()
	 * @generated
	 */
	void setDeviceBuffer(Buffer value);

} // GetBufferTask
