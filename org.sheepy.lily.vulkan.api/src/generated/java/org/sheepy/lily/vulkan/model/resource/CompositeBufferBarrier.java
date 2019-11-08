/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier#getDataProvider <em>Data Provider</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBufferBarrier()
 * @model
 * @generated
 */
public interface CompositeBufferBarrier extends AbstractBufferBarrier
{
	/**
	 * Returns the value of the '<em><b>Instance</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' attribute.
	 * @see #setInstance(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBufferBarrier_Instance()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getInstance();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier#getInstance <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' attribute.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(int value);

	/**
	 * Returns the value of the '<em><b>Data Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Provider</em>' reference.
	 * @see #setDataProvider(BufferDataProvider)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBufferBarrier_DataProvider()
	 * @model required="true"
	 * @generated
	 */
	BufferDataProvider<?> getDataProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier#getDataProvider <em>Data Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider</em>' reference.
	 * @see #getDataProvider()
	 * @generated
	 */
	void setDataProvider(BufferDataProvider<?> value);

} // CompositeBufferBarrier
