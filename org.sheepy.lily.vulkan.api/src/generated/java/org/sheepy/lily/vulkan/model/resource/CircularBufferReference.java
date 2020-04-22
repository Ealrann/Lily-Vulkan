/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Circular Buffer Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBufferReference#getBuffers <em>Buffers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBufferReference#getStride <em>Stride</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CircularBufferReference#getIndexType <em>Index Type</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBufferReference()
 * @model
 * @generated
 */
public interface CircularBufferReference extends IBufferReference
{
	/**
	 * Returns the value of the '<em><b>Buffers</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.IBuffer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffers</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBufferReference_Buffers()
	 * @model
	 * @generated
	 */
	EList<IBuffer> getBuffers();

	/**
	 * Returns the value of the '<em><b>Stride</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stride</em>' attribute.
	 * @see #setStride(int)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBufferReference_Stride()
	 * @model default="1"
	 * @generated
	 */
	int getStride();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CircularBufferReference#getStride <em>Stride</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stride</em>' attribute.
	 * @see #getStride()
	 * @generated
	 */
	void setStride(int value);

	/**
	 * Returns the value of the '<em><b>Index Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.resource.EContextIndex}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Type</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.resource.EContextIndex
	 * @see #setIndexType(EContextIndex)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getCircularBufferReference_IndexType()
	 * @model required="true"
	 * @generated
	 */
	EContextIndex getIndexType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CircularBufferReference#getIndexType <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Type</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.resource.EContextIndex
	 * @see #getIndexType()
	 * @generated
	 */
	void setIndexType(EContextIndex value);

} // CircularBufferReference
