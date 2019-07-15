/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getDataProviders <em>Data Providers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getPushBuffer <em>Push Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer()
 * @model
 * @generated
 */
public interface CompositeBuffer extends DescriptedResource, IBuffer
{
	/**
	 * Returns the value of the '<em><b>Data Providers</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Providers</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer_DataProviders()
	 * @model containment="true"
	 * @generated
	 */
	EList<BufferDataProvider> getDataProviders();

	/**
	 * Returns the value of the '<em><b>Push Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Push Buffer</em>' reference.
	 * @see #setPushBuffer(PushBuffer)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer_PushBuffer()
	 * @model required="true"
	 * @generated
	 */
	PushBuffer getPushBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getPushBuffer <em>Push Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Push Buffer</em>' reference.
	 * @see #getPushBuffer()
	 * @generated
	 */
	void setPushBuffer(PushBuffer value);

} // CompositeBuffer
