/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getTiling <em>Tiling</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#getInitialLayout <em>Initial Layout</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Image#isFillWithZero <em>Fill With Zero</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage()
 * @model
 * @generated
 */
public interface Image extends BasicDescriptedResource
{
	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_Width()
	 * @model unique="false"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#getWidth <em>Width</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_Height()
	 * @model unique="false"
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#getHeight <em>Height</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_Format()
	 * @model unique="false"
	 * @generated
	 */
	EFormat getFormat();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#getFormat <em>Format</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_Usages()
	 * @model
	 * @generated
	 */
	EList<EImageUsage> getUsages();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' attribute.
	 * @see #setProperties(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_Properties()
	 * @model unique="false"
	 * @generated
	 */
	int getProperties();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#getProperties <em>Properties</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_Tiling()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getTiling();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#getTiling <em>Tiling</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_MipLevels()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getMipLevels();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#getMipLevels <em>Mip Levels</em>}' attribute.
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
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_InitialLayout()
	 * @model containment="true"
	 * @generated
	 */
	ImageLayout getInitialLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#getInitialLayout <em>Initial Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Layout</em>' containment reference.
	 * @see #getInitialLayout()
	 * @generated
	 */
	void setInitialLayout(ImageLayout value);

	/**
	 * Returns the value of the '<em><b>Fill With Zero</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill With Zero</em>' attribute.
	 * @see #setFillWithZero(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getImage_FillWithZero()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isFillWithZero();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Image#isFillWithZero <em>Fill With Zero</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill With Zero</em>' attribute.
	 * @see #isFillWithZero()
	 * @generated
	 */
	void setFillWithZero(boolean value);

} // Image
