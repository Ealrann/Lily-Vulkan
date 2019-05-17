/**
 */
package org.sheepy.vulkan.model.barrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getImagePtr <em>Image Ptr</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getImageFormat <em>Image Format</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getReferenceImageBarrier()
 * @model
 * @generated
 */
public interface ReferenceImageBarrier extends AbstractImageBarrier
{
	/**
	 * Returns the value of the '<em><b>Image Ptr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Ptr</em>' attribute.
	 * @see #setImagePtr(long)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getReferenceImageBarrier_ImagePtr()
	 * @model unique="false"
	 * @generated
	 */
	long getImagePtr();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getImagePtr <em>Image Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Ptr</em>' attribute.
	 * @see #getImagePtr()
	 * @generated
	 */
	void setImagePtr(long value);

	/**
	 * Returns the value of the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mip Levels</em>' attribute.
	 * @see #setMipLevels(int)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getReferenceImageBarrier_MipLevels()
	 * @model unique="false"
	 * @generated
	 */
	int getMipLevels();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getMipLevels <em>Mip Levels</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Format</em>' attribute.
	 * @see #setImageFormat(int)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getReferenceImageBarrier_ImageFormat()
	 * @model unique="false"
	 * @generated
	 */
	int getImageFormat();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.ReferenceImageBarrier#getImageFormat <em>Image Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Format</em>' attribute.
	 * @see #getImageFormat()
	 * @generated
	 */
	void setImageFormat(int value);

} // ReferenceImageBarrier
