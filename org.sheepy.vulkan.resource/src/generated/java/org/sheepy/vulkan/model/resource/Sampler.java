/**
 */
package org.sheepy.vulkan.model.resource;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sampler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getMinFilter <em>Min Filter</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getMagFilter <em>Mag Filter</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getMipmapMode <em>Mipmap Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getAddressMode <em>Address Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#isAnisotropyEnabled <em>Anisotropy Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#isUnnormalizedCoordinates <em>Unnormalized Coordinates</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#isCompareEnable <em>Compare Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getLodBias <em>Lod Bias</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getMinLod <em>Min Lod</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getMaxLod <em>Max Lod</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Sampler#getMaxAnisotropy <em>Max Anisotropy</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler()
 * @model
 * @generated
 */
public interface Sampler extends EObject
{
	/**
	 * Returns the value of the '<em><b>Min Filter</b></em>' attribute.
	 * The default value is <code>"NEAREST"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFilter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Filter</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFilter
	 * @see #setMinFilter(EFilter)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_MinFilter()
	 * @model default="NEAREST" unique="false"
	 * @generated
	 */
	EFilter getMinFilter();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getMinFilter <em>Min Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Filter</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFilter
	 * @see #getMinFilter()
	 * @generated
	 */
	void setMinFilter(EFilter value);

	/**
	 * Returns the value of the '<em><b>Mag Filter</b></em>' attribute.
	 * The default value is <code>"NEAREST"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFilter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mag Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mag Filter</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFilter
	 * @see #setMagFilter(EFilter)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_MagFilter()
	 * @model default="NEAREST" unique="false"
	 * @generated
	 */
	EFilter getMagFilter();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getMagFilter <em>Mag Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mag Filter</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFilter
	 * @see #getMagFilter()
	 * @generated
	 */
	void setMagFilter(EFilter value);

	/**
	 * Returns the value of the '<em><b>Mipmap Mode</b></em>' attribute.
	 * The default value is <code>"NEAREST"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mipmap Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mipmap Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode
	 * @see #setMipmapMode(ESamplerMipmapMode)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_MipmapMode()
	 * @model default="NEAREST" unique="false"
	 * @generated
	 */
	ESamplerMipmapMode getMipmapMode();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getMipmapMode <em>Mipmap Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mipmap Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode
	 * @see #getMipmapMode()
	 * @generated
	 */
	void setMipmapMode(ESamplerMipmapMode value);

	/**
	 * Returns the value of the '<em><b>Address Mode</b></em>' attribute.
	 * The default value is <code>"REPEAT"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ESamplerAddressMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ESamplerAddressMode
	 * @see #setAddressMode(ESamplerAddressMode)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_AddressMode()
	 * @model default="REPEAT" unique="false"
	 * @generated
	 */
	ESamplerAddressMode getAddressMode();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getAddressMode <em>Address Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Mode</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ESamplerAddressMode
	 * @see #getAddressMode()
	 * @generated
	 */
	void setAddressMode(ESamplerAddressMode value);

	/**
	 * Returns the value of the '<em><b>Border Color</b></em>' attribute.
	 * The default value is <code>"INT_OPAQUE_BLACK"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBorderColor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Color</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBorderColor
	 * @see #setBorderColor(EBorderColor)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_BorderColor()
	 * @model default="INT_OPAQUE_BLACK" unique="false"
	 * @generated
	 */
	EBorderColor getBorderColor();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getBorderColor <em>Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Color</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBorderColor
	 * @see #getBorderColor()
	 * @generated
	 */
	void setBorderColor(EBorderColor value);

	/**
	 * Returns the value of the '<em><b>Anisotropy Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anisotropy Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anisotropy Enabled</em>' attribute.
	 * @see #setAnisotropyEnabled(boolean)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_AnisotropyEnabled()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isAnisotropyEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#isAnisotropyEnabled <em>Anisotropy Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anisotropy Enabled</em>' attribute.
	 * @see #isAnisotropyEnabled()
	 * @generated
	 */
	void setAnisotropyEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Unnormalized Coordinates</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unnormalized Coordinates</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unnormalized Coordinates</em>' attribute.
	 * @see #setUnnormalizedCoordinates(boolean)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_UnnormalizedCoordinates()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isUnnormalizedCoordinates();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#isUnnormalizedCoordinates <em>Unnormalized Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unnormalized Coordinates</em>' attribute.
	 * @see #isUnnormalizedCoordinates()
	 * @generated
	 */
	void setUnnormalizedCoordinates(boolean value);

	/**
	 * Returns the value of the '<em><b>Compare Enable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compare Enable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compare Enable</em>' attribute.
	 * @see #setCompareEnable(boolean)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_CompareEnable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isCompareEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#isCompareEnable <em>Compare Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compare Enable</em>' attribute.
	 * @see #isCompareEnable()
	 * @generated
	 */
	void setCompareEnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Lod Bias</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lod Bias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lod Bias</em>' attribute.
	 * @see #setLodBias(float)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_LodBias()
	 * @model default="0" unique="false"
	 * @generated
	 */
	float getLodBias();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getLodBias <em>Lod Bias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lod Bias</em>' attribute.
	 * @see #getLodBias()
	 * @generated
	 */
	void setLodBias(float value);

	/**
	 * Returns the value of the '<em><b>Min Lod</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Lod</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Lod</em>' attribute.
	 * @see #setMinLod(int)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_MinLod()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getMinLod();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getMinLod <em>Min Lod</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Lod</em>' attribute.
	 * @see #getMinLod()
	 * @generated
	 */
	void setMinLod(int value);

	/**
	 * Returns the value of the '<em><b>Max Lod</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Lod</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Lod</em>' attribute.
	 * @see #setMaxLod(int)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_MaxLod()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getMaxLod();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getMaxLod <em>Max Lod</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Lod</em>' attribute.
	 * @see #getMaxLod()
	 * @generated
	 */
	void setMaxLod(int value);

	/**
	 * Returns the value of the '<em><b>Max Anisotropy</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Anisotropy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Anisotropy</em>' attribute.
	 * @see #setMaxAnisotropy(float)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getSampler_MaxAnisotropy()
	 * @model default="1" unique="false"
	 * @generated
	 */
	float getMaxAnisotropy();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Sampler#getMaxAnisotropy <em>Max Anisotropy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Anisotropy</em>' attribute.
	 * @see #getMaxAnisotropy()
	 * @generated
	 */
	void setMaxAnisotropy(float value);

} // Sampler
