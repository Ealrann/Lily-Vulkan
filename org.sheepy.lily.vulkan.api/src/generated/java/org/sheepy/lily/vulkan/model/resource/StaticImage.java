/**
 */
package org.sheepy.lily.vulkan.model.resource;

import java.nio.ByteBuffer;
import org.sheepy.vulkan.model.image.ImageInfo;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.StaticImage#isFillWithZero <em>Fill With Zero</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.StaticImage#getFillWith <em>Fill With</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getStaticImage()
 * @model
 * @generated
 */
public interface StaticImage extends Image, ImageInfo, BasicDescriptedResource
{
	/**
	 * Returns the value of the '<em><b>Fill With Zero</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill With Zero</em>' attribute.
	 * @see #setFillWithZero(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getStaticImage_FillWithZero()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isFillWithZero();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.StaticImage#isFillWithZero <em>Fill With Zero</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill With Zero</em>' attribute.
	 * @see #isFillWithZero()
	 * @generated
	 */
	void setFillWithZero(boolean value);

	/**
	 * Returns the value of the '<em><b>Fill With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill With</em>' attribute.
	 * @see #setFillWith(ByteBuffer)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getStaticImage_FillWith()
	 * @model dataType="org.sheepy.lily.vulkan.model.resource.ByteBuffer"
	 * @generated
	 */
	ByteBuffer getFillWith();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.StaticImage#getFillWith <em>Fill With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill With</em>' attribute.
	 * @see #getFillWith()
	 * @generated
	 */
	void setFillWith(ByteBuffer value);

} // StaticImage
