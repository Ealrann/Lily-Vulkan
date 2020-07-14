/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.StaticBuffer#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.StaticBuffer#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.StaticBuffer#isInitWithZero <em>Init With Zero</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getStaticBuffer()
 * @model
 * @generated
 */
public interface StaticBuffer extends IBuffer, IBufferObject
{
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getStaticBuffer_Size()
	 * @model unique="false"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.StaticBuffer#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getStaticBuffer_Usages()
	 * @model
	 * @generated
	 */
	EList<EBufferUsage> getUsages();

	/**
	 * Returns the value of the '<em><b>Init With Zero</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init With Zero</em>' attribute.
	 * @see #setInitWithZero(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getStaticBuffer_InitWithZero()
	 * @model default="false"
	 * @generated
	 */
	boolean isInitWithZero();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.StaticBuffer#isInitWithZero <em>Init With Zero</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init With Zero</em>' attribute.
	 * @see #isInitWithZero()
	 * @generated
	 */
	void setInitWithZero(boolean value);

} // StaticBuffer