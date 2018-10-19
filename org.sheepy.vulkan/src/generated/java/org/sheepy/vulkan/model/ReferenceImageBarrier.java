/**
 */
package org.sheepy.vulkan.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getImageFormat <em>Image Format</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.VulkanPackage#getReferenceImageBarrier()
 * @model
 * @generated
 */
public interface ReferenceImageBarrier extends AbstractImageBarrier
{
	/**
	 * Returns the value of the '<em><b>Image Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Id</em>' attribute.
	 * @see #setImageId(long)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getReferenceImageBarrier_ImageId()
	 * @model unique="false"
	 * @generated
	 */
	long getImageId();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getImageId <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Id</em>' attribute.
	 * @see #getImageId()
	 * @generated
	 */
	void setImageId(long value);

	/**
	 * Returns the value of the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mip Levels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mip Levels</em>' attribute.
	 * @see #setMipLevels(int)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getReferenceImageBarrier_MipLevels()
	 * @model unique="false"
	 * @generated
	 */
	int getMipLevels();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getMipLevels <em>Mip Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mip Levels</em>' attribute.
	 * @see #getMipLevels()
	 * @generated
	 */
	void setMipLevels(int value);

	/**
	 * Returns the value of the '<em><b>Image Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Format</em>' attribute.
	 * @see #setImageFormat(int)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getReferenceImageBarrier_ImageFormat()
	 * @model unique="false"
	 * @generated
	 */
	int getImageFormat();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ReferenceImageBarrier#getImageFormat <em>Image Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Format</em>' attribute.
	 * @see #getImageFormat()
	 * @generated
	 */
	void setImageFormat(int value);

} // ReferenceImageBarrier
