/**
 */
package org.sheepy.vulkan.model.image;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

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
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getTiling <em>Tiling</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.ImageInfo#getMipLevels <em>Mip Levels</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo()
 * @model
 * @generated
 */
public interface ImageInfo extends EObject
{
	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_Width()
	 * @model required="true"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.image.ImageInfo#getWidth <em>Width</em>}' attribute.
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
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_Height()
	 * @model required="true"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.image.ImageInfo#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFormat}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFormat
	 * @see #setFormat(EFormat)
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_Format()
	 * @model required="true"
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
	 * Returns the value of the '<em><b>Properties</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' attribute.
	 * @see #setProperties(int)
	 * @see org.sheepy.vulkan.model.image.ImagePackage#getImageInfo_Properties()
	 * @model default="0"
	 * @generated
	 */
	int getProperties();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.image.ImageInfo#getProperties <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' attribute.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(int value);

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

} // ImageInfo
