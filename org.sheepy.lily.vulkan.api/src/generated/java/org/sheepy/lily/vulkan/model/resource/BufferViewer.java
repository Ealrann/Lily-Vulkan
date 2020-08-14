/**
 */
package org.sheepy.lily.vulkan.model.resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Viewer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getGrowThreshold <em>Grow Threshold</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferViewer()
 * @model
 * @generated
 */
public interface BufferViewer extends IBuffer
{
	/**
	 * Returns the value of the '<em><b>Data Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Provider</em>' containment reference.
	 * @see #setDataProvider(BufferDataProvider)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferViewer_DataProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BufferDataProvider getDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getDataProvider <em>Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider</em>' containment reference.
	 * @see #getDataProvider()
	 * @generated
	 */
	void setDataProvider(BufferDataProvider value);

	/**
	 * Returns the value of the '<em><b>Grow Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Factor</em>' attribute.
	 * @see #setGrowFactor(float)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferViewer_GrowFactor()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowFactor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getGrowFactor <em>Grow Factor</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferViewer_GrowThreshold()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowThreshold();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getGrowThreshold <em>Grow Threshold</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBufferViewer_Size()
	 * @model default="0"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferViewer#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

} // BufferViewer
