/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Circular Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getGrowThreshold <em>Grow Threshold</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBuffer()
 * @model
 * @generated
 */
public interface CircularBuffer extends IBuffer, IMemoryChunkPart
{
	/**
	 * Returns the value of the '<em><b>Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Provider</em>' containment reference.
	 * @see #setDataProvider(BufferDataProvider)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBuffer_DataProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BufferDataProvider getDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getDataProvider <em>Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider</em>' containment reference.
	 * @see #getDataProvider()
	 * @generated
	 */
	void setDataProvider(BufferDataProvider value);

	/**
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBuffer_Usages()
	 * @model
	 * @generated
	 */
	EList<EBufferUsage> getUsages();

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EInstanceCount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInstanceCount
	 * @see #setInstanceCount(EInstanceCount)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBuffer_InstanceCount()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EInstanceCount getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInstanceCount
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(EInstanceCount value);

	/**
	 * Returns the value of the '<em><b>Grow Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Factor</em>' attribute.
	 * @see #setGrowFactor(float)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBuffer_GrowFactor()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowFactor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getGrowFactor <em>Grow Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grow Factor</em>' attribute.
	 * @see #getGrowFactor()
	 * @generated
	 */
	void setGrowFactor(float value);

	/**
	 * Returns the value of the '<em><b>Grow Threshold</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Threshold</em>' attribute.
	 * @see #setGrowThreshold(float)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBuffer_GrowThreshold()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowThreshold();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getGrowThreshold <em>Grow Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grow Threshold</em>' attribute.
	 * @see #getGrowThreshold()
	 * @generated
	 */
	void setGrowThreshold(float value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBuffer_Size()
	 * @model default="0"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CircularBuffer#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

} // CircularBuffer
