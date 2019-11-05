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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getMinSize <em>Min Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getGrowFactor <em>Grow Factor</em>}</li>
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
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider}<code>&lt;?&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Providers</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer_DataProviders()
	 * @model containment="true"
	 * @generated
	 */
	EList<BufferDataProvider<?>> getDataProviders();

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

	/**
	 * Returns the value of the '<em><b>Min Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Size</em>' attribute.
	 * @see #setMinSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer_MinSize()
	 * @model default="0" required="true"
	 * @generated
	 */
	long getMinSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getMinSize <em>Min Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Size</em>' attribute.
	 * @see #getMinSize()
	 * @generated
	 */
	void setMinSize(long value);

	/**
	 * Returns the value of the '<em><b>Grow Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Factor</em>' attribute.
	 * @see #setGrowFactor(float)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getCompositeBuffer_GrowFactor()
	 * @model default="1" required="true"
	 * @generated
	 */
	float getGrowFactor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.CompositeBuffer#getGrowFactor <em>Grow Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grow Factor</em>' attribute.
	 * @see #getGrowFactor()
	 * @generated
	 */
	void setGrowFactor(float value);

} // CompositeBuffer
