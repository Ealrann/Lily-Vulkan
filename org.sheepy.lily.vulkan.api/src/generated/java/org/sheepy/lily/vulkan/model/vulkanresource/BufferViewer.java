/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Viewer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getGrowThreshold <em>Grow Threshold</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getDataSourceIdentifier <em>Data Source Identifier</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getBufferViewer()
 * @model
 * @generated
 */
public interface BufferViewer extends IBuffer
{
	/**
	 * Returns the value of the '<em><b>Grow Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Factor</em>' attribute.
	 * @see #setGrowFactor(float)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getBufferViewer_GrowFactor()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowFactor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getGrowFactor <em>Grow Factor</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getBufferViewer_GrowThreshold()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowThreshold();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getGrowThreshold <em>Grow Threshold</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getBufferViewer_Size()
	 * @model default="0"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' reference.
	 * @see #setDataSource(IBufferDataSource)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getBufferViewer_DataSource()
	 * @model
	 * @generated
	 */
	IBufferDataSource getDataSource();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getDataSource <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(IBufferDataSource value);

	/**
	 * Returns the value of the '<em><b>Data Source Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Identifier</em>' attribute.
	 * @see #setDataSourceIdentifier(String)
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage#getBufferViewer_DataSourceIdentifier()
	 * @model
	 * @generated
	 */
	String getDataSourceIdentifier();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer#getDataSourceIdentifier <em>Data Source Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source Identifier</em>' attribute.
	 * @see #getDataSourceIdentifier()
	 * @generated
	 */
	void setDataSourceIdentifier(String value);

} // BufferViewer
