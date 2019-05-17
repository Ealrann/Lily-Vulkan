/**
 */
package org.sheepy.lily.vulkan.extra.nuklear.model;

import org.sheepy.lily.vulkan.model.process.PushConstant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push Constants</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getCurrentDescriptor <em>Current Descriptor</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPushConstants()
 * @model
 * @generated
 */
public interface NuklearPushConstants extends PushConstant
{
	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPushConstants_Width()
	 * @model unique="false"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPushConstants_Height()
	 * @model unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Current Descriptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Descriptor</em>' attribute.
	 * @see #setCurrentDescriptor(int)
	 * @see org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage#getNuklearPushConstants_CurrentDescriptor()
	 * @model unique="false"
	 * @generated
	 */
	int getCurrentDescriptor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants#getCurrentDescriptor <em>Current Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Descriptor</em>' attribute.
	 * @see #getCurrentDescriptor()
	 * @generated
	 */
	void setCurrentDescriptor(int value);

} // NuklearPushConstants
