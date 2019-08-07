/**
 */
package org.sheepy.vulkan.model.image;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.image.ImageFactory
 * @model kind="package"
 * @generated
 */
public interface ImagePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "image";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.sheepy.vulkan.model.image";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "image";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImagePackage eINSTANCE = org.sheepy.vulkan.model.image.impl.ImagePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.image.impl.SamplerInfoImpl <em>Sampler Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.image.impl.SamplerInfoImpl
	 * @see org.sheepy.vulkan.model.image.impl.ImagePackageImpl#getSamplerInfo()
	 * @generated
	 */
	int SAMPLER_INFO = 0;

	/**
	 * The feature id for the '<em><b>Min Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__MIN_FILTER = 0;

	/**
	 * The feature id for the '<em><b>Mag Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__MAG_FILTER = 1;

	/**
	 * The feature id for the '<em><b>Mipmap Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__MIPMAP_MODE = 2;

	/**
	 * The feature id for the '<em><b>Address Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__ADDRESS_MODE = 3;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__BORDER_COLOR = 4;

	/**
	 * The feature id for the '<em><b>Anisotropy Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__ANISOTROPY_ENABLED = 5;

	/**
	 * The feature id for the '<em><b>Unnormalized Coordinates</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__UNNORMALIZED_COORDINATES = 6;

	/**
	 * The feature id for the '<em><b>Compare Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__COMPARE_ENABLE = 7;

	/**
	 * The feature id for the '<em><b>Lod Bias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__LOD_BIAS = 8;

	/**
	 * The feature id for the '<em><b>Min Lod</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__MIN_LOD = 9;

	/**
	 * The feature id for the '<em><b>Max Lod</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__MAX_LOD = 10;

	/**
	 * The feature id for the '<em><b>Max Anisotropy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO__MAX_ANISOTROPY = 11;

	/**
	 * The number of structural features of the '<em>Sampler Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Sampler Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLER_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl <em>Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sheepy.vulkan.model.image.impl.ImageInfoImpl
	 * @see org.sheepy.vulkan.model.image.impl.ImagePackageImpl#getImageInfo()
	 * @generated
	 */
	int IMAGE_INFO = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO__WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO__HEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO__FORMAT = 2;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO__USAGES = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO__PROPERTIES = 4;

	/**
	 * The feature id for the '<em><b>Tiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO__TILING = 5;

	/**
	 * The feature id for the '<em><b>Mip Levels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO__MIP_LEVELS = 6;

	/**
	 * The number of structural features of the '<em>Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_INFO_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.image.SamplerInfo <em>Sampler Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sampler Info</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo
	 * @generated
	 */
	EClass getSamplerInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getMinFilter <em>Min Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Filter</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getMinFilter()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_MinFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getMagFilter <em>Mag Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mag Filter</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getMagFilter()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_MagFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getMipmapMode <em>Mipmap Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mipmap Mode</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getMipmapMode()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_MipmapMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getAddressMode <em>Address Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address Mode</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getAddressMode()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_AddressMode();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getBorderColor <em>Border Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border Color</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getBorderColor()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_BorderColor();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#isAnisotropyEnabled <em>Anisotropy Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Anisotropy Enabled</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#isAnisotropyEnabled()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_AnisotropyEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#isUnnormalizedCoordinates <em>Unnormalized Coordinates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unnormalized Coordinates</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#isUnnormalizedCoordinates()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_UnnormalizedCoordinates();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#isCompareEnable <em>Compare Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compare Enable</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#isCompareEnable()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_CompareEnable();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getLodBias <em>Lod Bias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lod Bias</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getLodBias()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_LodBias();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getMinLod <em>Min Lod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Lod</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getMinLod()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_MinLod();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getMaxLod <em>Max Lod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Lod</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getMaxLod()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_MaxLod();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.SamplerInfo#getMaxAnisotropy <em>Max Anisotropy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Anisotropy</em>'.
	 * @see org.sheepy.vulkan.model.image.SamplerInfo#getMaxAnisotropy()
	 * @see #getSamplerInfo()
	 * @generated
	 */
	EAttribute getSamplerInfo_MaxAnisotropy();

	/**
	 * Returns the meta object for class '{@link org.sheepy.vulkan.model.image.ImageInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info</em>'.
	 * @see org.sheepy.vulkan.model.image.ImageInfo
	 * @generated
	 */
	EClass getImageInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.ImageInfo#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.sheepy.vulkan.model.image.ImageInfo#getWidth()
	 * @see #getImageInfo()
	 * @generated
	 */
	EAttribute getImageInfo_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.ImageInfo#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.sheepy.vulkan.model.image.ImageInfo#getHeight()
	 * @see #getImageInfo()
	 * @generated
	 */
	EAttribute getImageInfo_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.ImageInfo#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.sheepy.vulkan.model.image.ImageInfo#getFormat()
	 * @see #getImageInfo()
	 * @generated
	 */
	EAttribute getImageInfo_Format();

	/**
	 * Returns the meta object for the attribute list '{@link org.sheepy.vulkan.model.image.ImageInfo#getUsages <em>Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Usages</em>'.
	 * @see org.sheepy.vulkan.model.image.ImageInfo#getUsages()
	 * @see #getImageInfo()
	 * @generated
	 */
	EAttribute getImageInfo_Usages();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.ImageInfo#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties</em>'.
	 * @see org.sheepy.vulkan.model.image.ImageInfo#getProperties()
	 * @see #getImageInfo()
	 * @generated
	 */
	EAttribute getImageInfo_Properties();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.ImageInfo#getTiling <em>Tiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tiling</em>'.
	 * @see org.sheepy.vulkan.model.image.ImageInfo#getTiling()
	 * @see #getImageInfo()
	 * @generated
	 */
	EAttribute getImageInfo_Tiling();

	/**
	 * Returns the meta object for the attribute '{@link org.sheepy.vulkan.model.image.ImageInfo#getMipLevels <em>Mip Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mip Levels</em>'.
	 * @see org.sheepy.vulkan.model.image.ImageInfo#getMipLevels()
	 * @see #getImageInfo()
	 * @generated
	 */
	EAttribute getImageInfo_MipLevels();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImageFactory getImageFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.image.impl.SamplerInfoImpl <em>Sampler Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.image.impl.SamplerInfoImpl
		 * @see org.sheepy.vulkan.model.image.impl.ImagePackageImpl#getSamplerInfo()
		 * @generated
		 */
		EClass SAMPLER_INFO = eINSTANCE.getSamplerInfo();

		/**
		 * The meta object literal for the '<em><b>Min Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__MIN_FILTER = eINSTANCE.getSamplerInfo_MinFilter();

		/**
		 * The meta object literal for the '<em><b>Mag Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__MAG_FILTER = eINSTANCE.getSamplerInfo_MagFilter();

		/**
		 * The meta object literal for the '<em><b>Mipmap Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__MIPMAP_MODE = eINSTANCE.getSamplerInfo_MipmapMode();

		/**
		 * The meta object literal for the '<em><b>Address Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__ADDRESS_MODE = eINSTANCE.getSamplerInfo_AddressMode();

		/**
		 * The meta object literal for the '<em><b>Border Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__BORDER_COLOR = eINSTANCE.getSamplerInfo_BorderColor();

		/**
		 * The meta object literal for the '<em><b>Anisotropy Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__ANISOTROPY_ENABLED = eINSTANCE.getSamplerInfo_AnisotropyEnabled();

		/**
		 * The meta object literal for the '<em><b>Unnormalized Coordinates</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__UNNORMALIZED_COORDINATES = eINSTANCE.getSamplerInfo_UnnormalizedCoordinates();

		/**
		 * The meta object literal for the '<em><b>Compare Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__COMPARE_ENABLE = eINSTANCE.getSamplerInfo_CompareEnable();

		/**
		 * The meta object literal for the '<em><b>Lod Bias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__LOD_BIAS = eINSTANCE.getSamplerInfo_LodBias();

		/**
		 * The meta object literal for the '<em><b>Min Lod</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__MIN_LOD = eINSTANCE.getSamplerInfo_MinLod();

		/**
		 * The meta object literal for the '<em><b>Max Lod</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__MAX_LOD = eINSTANCE.getSamplerInfo_MaxLod();

		/**
		 * The meta object literal for the '<em><b>Max Anisotropy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLER_INFO__MAX_ANISOTROPY = eINSTANCE.getSamplerInfo_MaxAnisotropy();

		/**
		 * The meta object literal for the '{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl <em>Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sheepy.vulkan.model.image.impl.ImageInfoImpl
		 * @see org.sheepy.vulkan.model.image.impl.ImagePackageImpl#getImageInfo()
		 * @generated
		 */
		EClass IMAGE_INFO = eINSTANCE.getImageInfo();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INFO__WIDTH = eINSTANCE.getImageInfo_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INFO__HEIGHT = eINSTANCE.getImageInfo_Height();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INFO__FORMAT = eINSTANCE.getImageInfo_Format();

		/**
		 * The meta object literal for the '<em><b>Usages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INFO__USAGES = eINSTANCE.getImageInfo_Usages();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INFO__PROPERTIES = eINSTANCE.getImageInfo_Properties();

		/**
		 * The meta object literal for the '<em><b>Tiling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INFO__TILING = eINSTANCE.getImageInfo_Tiling();

		/**
		 * The meta object literal for the '<em><b>Mip Levels</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_INFO__MIP_LEVELS = eINSTANCE.getImageInfo_MipLevels();

	}

} //ImagePackage