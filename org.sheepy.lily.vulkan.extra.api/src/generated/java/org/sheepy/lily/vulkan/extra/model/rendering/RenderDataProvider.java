/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Render Data Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider#getDataSource <em>Data Source</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderDataProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface RenderDataProvider<T extends Structure> extends BufferDataProvider
{

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' containment reference.
	 * @see #setDataSource(RenderableDataSource)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getRenderDataProvider_DataSource()
	 * @model containment="true"
	 * @generated
	 */
	RenderableDataSource<T> getDataSource();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider#getDataSource <em>Data Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' containment reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(RenderableDataSource<T> value);
} // RenderDataProvider
