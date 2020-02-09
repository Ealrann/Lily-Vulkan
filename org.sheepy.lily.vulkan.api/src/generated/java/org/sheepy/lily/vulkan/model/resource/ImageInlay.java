/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.joml.Vector2ic;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Inlay</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getVerticalRelative <em>Vertical Relative</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageInlay()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ImageInlay extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' containment reference.
	 * @see #setImage(Image)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageInlay_Image()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Image getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getImage <em>Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' containment reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(Image value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The default value is <code>"0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(Vector2ic)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageInlay_Position()
	 * @model default="0;0" dataType="org.sheepy.lily.core.model.types.Vector2i" required="true"
	 * @generated
	 */
	Vector2ic getPosition();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Vector2ic value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(float)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageInlay_Size()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	float getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(float value);

	/**
	 * Returns the value of the '<em><b>Horizontal Relative</b></em>' attribute.
	 * The default value is <code>"LEFT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.types.EHorizontalRelative}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Relative</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EHorizontalRelative
	 * @see #setHorizontalRelative(EHorizontalRelative)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageInlay_HorizontalRelative()
	 * @model default="LEFT" required="true"
	 * @generated
	 */
	EHorizontalRelative getHorizontalRelative();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getHorizontalRelative <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Relative</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EHorizontalRelative
	 * @see #getHorizontalRelative()
	 * @generated
	 */
	void setHorizontalRelative(EHorizontalRelative value);

	/**
	 * Returns the value of the '<em><b>Vertical Relative</b></em>' attribute.
	 * The default value is <code>"TOP"</code>.
	 * The literals are from the enumeration {@link org.sheepy.lily.core.model.types.EVerticalRelative}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical Relative</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EVerticalRelative
	 * @see #setVerticalRelative(EVerticalRelative)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getImageInlay_VerticalRelative()
	 * @model default="TOP" required="true"
	 * @generated
	 */
	EVerticalRelative getVerticalRelative();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ImageInlay#getVerticalRelative <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical Relative</em>' attribute.
	 * @see org.sheepy.lily.core.model.types.EVerticalRelative
	 * @see #getVerticalRelative()
	 * @generated
	 */
	void setVerticalRelative(EVerticalRelative value);

} // ImageInlay
