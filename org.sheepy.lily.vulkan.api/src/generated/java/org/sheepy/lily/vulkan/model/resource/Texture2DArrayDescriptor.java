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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor#getTextureArray <em>Texture Array</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTexture2DArrayDescriptor()
 * @model
 * @generated
 */
public interface Texture2DArrayDescriptor extends IDescriptor
{
	/**
	 * Returns the value of the '<em><b>Texture Array</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture Array</em>' reference.
	 * @see #setTextureArray(ITextureArray)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getTexture2DArrayDescriptor_TextureArray()
	 * @model required="true"
	 * @generated
	 */
	ITextureArray getTextureArray();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor#getTextureArray <em>Texture Array</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texture Array</em>' reference.
	 * @see #getTextureArray()
	 * @generated
	 */
	void setTextureArray(ITextureArray value);

} // Texture2DArrayDescriptor
