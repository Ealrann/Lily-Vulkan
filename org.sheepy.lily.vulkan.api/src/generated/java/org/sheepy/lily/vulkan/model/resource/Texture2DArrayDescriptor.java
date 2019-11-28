/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.vulkan.model.IDescriptor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Texture2 DArray Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor#getTexture2DArray <em>Texture2 DArray</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTexture2DArrayDescriptor()
 * @model
 * @generated
 */
public interface Texture2DArrayDescriptor extends IDescriptor
{
	/**
	 * Returns the value of the '<em><b>Texture2 DArray</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture2 DArray</em>' reference.
	 * @see #setTexture2DArray(Texture2DArray)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTexture2DArrayDescriptor_Texture2DArray()
	 * @model required="true"
	 * @generated
	 */
	Texture2DArray getTexture2DArray();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor#getTexture2DArray <em>Texture2 DArray</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texture2 DArray</em>' reference.
	 * @see #getTexture2DArray()
	 * @generated
	 */
	void setTexture2DArray(Texture2DArray value);

} // Texture2DArrayDescriptor
