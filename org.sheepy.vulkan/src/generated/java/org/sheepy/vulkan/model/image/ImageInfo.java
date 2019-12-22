/**
 */
package org.sheepy.vulkan.model.image;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getTiling <em>Tiling</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getInitialLayout <em>Initial Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface ImageInfo extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The default value is <code>"R8G8B8A8_UNORM"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFormat}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @see #setFormat(EFormat)
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_Format()
	 * @model default="R8G8B8A8_UNORM" required="true"
	 * @generated
	 */
	EFormat getFormat();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.image.ImageInfo#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(EFormat value);

	/**
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EImageUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EImageUsage
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_Usages()
	 * @model required="true"
	 * @generated
	 */
	EList<EImageUsage> getUsages();

	/**
	 * Returns the value of the '<em><b>Tiling</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tiling</em>' attribute.
	 * @see #setTiling(int)
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_Tiling()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getTiling();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.image.ImageInfo#getTiling <em>Tiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tiling</em>' attribute.
	 * @see #getTiling()
	 * @generated
	 */
	void setTiling(int value);

	/**
	 * Returns the value of the '<em><b>Mip Levels</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mip Levels</em>' attribute.
	 * @see #setMipLevels(int)
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_MipLevels()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getMipLevels();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.image.ImageInfo#getMipLevels <em>Mip Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mip Levels</em>' attribute.
	 * @see #getMipLevels()
	 * @generated
	 */
	void setMipLevels(int value);

	/**
	 * Returns the value of the '<em><b>Initial Layout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Layout</em>' containment reference.
	 * @see #setInitialLayout(ImageLayout)
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_InitialLayout()
	 * @model containment="true"
	 * @generated
	 */
	ImageLayout getInitialLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.image.ImageInfo#getInitialLayout <em>Initial Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Layout</em>' containment reference.
	 * @see #getInitialLayout()
	 * @generated
	 */
	void setInitialLayout(ImageLayout value);

} // ImageInfo
