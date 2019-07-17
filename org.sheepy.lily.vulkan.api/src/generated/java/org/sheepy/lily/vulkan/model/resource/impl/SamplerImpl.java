/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.Sampler;

import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sampler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getMinFilter <em>Min Filter</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getMagFilter <em>Mag Filter</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getMipmapMode <em>Mipmap Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getAddressMode <em>Address Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#isAnisotropyEnabled <em>Anisotropy Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#isUnnormalizedCoordinates <em>Unnormalized Coordinates</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#isCompareEnable <em>Compare Enable</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getLodBias <em>Lod Bias</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getMinLod <em>Min Lod</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getMaxLod <em>Max Lod</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SamplerImpl#getMaxAnisotropy <em>Max Anisotropy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SamplerImpl extends MinimalEObjectImpl.Container implements Sampler
{
	/**
	 * The default value of the '{@link #getMinFilter() <em>Min Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinFilter()
	 * @generated
	 * @ordered
	 */
	protected static final EFilter MIN_FILTER_EDEFAULT = EFilter.NEAREST;

	/**
	 * The cached value of the '{@link #getMinFilter() <em>Min Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinFilter()
	 * @generated
	 * @ordered
	 */
	protected EFilter minFilter = MIN_FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMagFilter() <em>Mag Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMagFilter()
	 * @generated
	 * @ordered
	 */
	protected static final EFilter MAG_FILTER_EDEFAULT = EFilter.NEAREST;

	/**
	 * The cached value of the '{@link #getMagFilter() <em>Mag Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMagFilter()
	 * @generated
	 * @ordered
	 */
	protected EFilter magFilter = MAG_FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMipmapMode() <em>Mipmap Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMipmapMode()
	 * @generated
	 * @ordered
	 */
	protected static final ESamplerMipmapMode MIPMAP_MODE_EDEFAULT = ESamplerMipmapMode.NEAREST;

	/**
	 * The cached value of the '{@link #getMipmapMode() <em>Mipmap Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMipmapMode()
	 * @generated
	 * @ordered
	 */
	protected ESamplerMipmapMode mipmapMode = MIPMAP_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddressMode() <em>Address Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressMode()
	 * @generated
	 * @ordered
	 */
	protected static final ESamplerAddressMode ADDRESS_MODE_EDEFAULT = ESamplerAddressMode.REPEAT;

	/**
	 * The cached value of the '{@link #getAddressMode() <em>Address Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressMode()
	 * @generated
	 * @ordered
	 */
	protected ESamplerAddressMode addressMode = ADDRESS_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderColor()
	 * @generated
	 * @ordered
	 */
	protected static final EBorderColor BORDER_COLOR_EDEFAULT = EBorderColor.INT_OPAQUE_BLACK;

	/**
	 * The cached value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderColor()
	 * @generated
	 * @ordered
	 */
	protected EBorderColor borderColor = BORDER_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #isAnisotropyEnabled() <em>Anisotropy Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnisotropyEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANISOTROPY_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAnisotropyEnabled() <em>Anisotropy Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnisotropyEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean anisotropyEnabled = ANISOTROPY_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isUnnormalizedCoordinates() <em>Unnormalized Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnnormalizedCoordinates()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNNORMALIZED_COORDINATES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnnormalizedCoordinates() <em>Unnormalized Coordinates</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnnormalizedCoordinates()
	 * @generated
	 * @ordered
	 */
	protected boolean unnormalizedCoordinates = UNNORMALIZED_COORDINATES_EDEFAULT;

	/**
	 * The default value of the '{@link #isCompareEnable() <em>Compare Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompareEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPARE_ENABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCompareEnable() <em>Compare Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompareEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean compareEnable = COMPARE_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLodBias() <em>Lod Bias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLodBias()
	 * @generated
	 * @ordered
	 */
	protected static final float LOD_BIAS_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getLodBias() <em>Lod Bias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLodBias()
	 * @generated
	 * @ordered
	 */
	protected float lodBias = LOD_BIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinLod() <em>Min Lod</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLod()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_LOD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinLod() <em>Min Lod</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinLod()
	 * @generated
	 * @ordered
	 */
	protected int minLod = MIN_LOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxLod() <em>Max Lod</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLod()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_LOD_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMaxLod() <em>Max Lod</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxLod()
	 * @generated
	 * @ordered
	 */
	protected int maxLod = MAX_LOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxAnisotropy() <em>Max Anisotropy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAnisotropy()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX_ANISOTROPY_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getMaxAnisotropy() <em>Max Anisotropy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAnisotropy()
	 * @generated
	 * @ordered
	 */
	protected float maxAnisotropy = MAX_ANISOTROPY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SamplerImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ResourcePackage.Literals.SAMPLER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFilter getMinFilter()
	{
		return minFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinFilter(EFilter newMinFilter)
	{
		EFilter oldMinFilter = minFilter;
		minFilter = newMinFilter == null ? MIN_FILTER_EDEFAULT : newMinFilter;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__MIN_FILTER, oldMinFilter, minFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFilter getMagFilter()
	{
		return magFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMagFilter(EFilter newMagFilter)
	{
		EFilter oldMagFilter = magFilter;
		magFilter = newMagFilter == null ? MAG_FILTER_EDEFAULT : newMagFilter;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__MAG_FILTER, oldMagFilter, magFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ESamplerMipmapMode getMipmapMode()
	{
		return mipmapMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMipmapMode(ESamplerMipmapMode newMipmapMode)
	{
		ESamplerMipmapMode oldMipmapMode = mipmapMode;
		mipmapMode = newMipmapMode == null ? MIPMAP_MODE_EDEFAULT : newMipmapMode;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__MIPMAP_MODE, oldMipmapMode, mipmapMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ESamplerAddressMode getAddressMode()
	{
		return addressMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAddressMode(ESamplerAddressMode newAddressMode)
	{
		ESamplerAddressMode oldAddressMode = addressMode;
		addressMode = newAddressMode == null ? ADDRESS_MODE_EDEFAULT : newAddressMode;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__ADDRESS_MODE, oldAddressMode, addressMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBorderColor getBorderColor()
	{
		return borderColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBorderColor(EBorderColor newBorderColor)
	{
		EBorderColor oldBorderColor = borderColor;
		borderColor = newBorderColor == null ? BORDER_COLOR_EDEFAULT : newBorderColor;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__BORDER_COLOR, oldBorderColor, borderColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAnisotropyEnabled()
	{
		return anisotropyEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnisotropyEnabled(boolean newAnisotropyEnabled)
	{
		boolean oldAnisotropyEnabled = anisotropyEnabled;
		anisotropyEnabled = newAnisotropyEnabled;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__ANISOTROPY_ENABLED, oldAnisotropyEnabled,
				anisotropyEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUnnormalizedCoordinates()
	{
		return unnormalizedCoordinates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnnormalizedCoordinates(boolean newUnnormalizedCoordinates)
	{
		boolean oldUnnormalizedCoordinates = unnormalizedCoordinates;
		unnormalizedCoordinates = newUnnormalizedCoordinates;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__UNNORMALIZED_COORDINATES, oldUnnormalizedCoordinates,
				unnormalizedCoordinates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCompareEnable()
	{
		return compareEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompareEnable(boolean newCompareEnable)
	{
		boolean oldCompareEnable = compareEnable;
		compareEnable = newCompareEnable;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__COMPARE_ENABLE, oldCompareEnable, compareEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getLodBias()
	{
		return lodBias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLodBias(float newLodBias)
	{
		float oldLodBias = lodBias;
		lodBias = newLodBias;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__LOD_BIAS, oldLodBias, lodBias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMinLod()
	{
		return minLod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinLod(int newMinLod)
	{
		int oldMinLod = minLod;
		minLod = newMinLod;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__MIN_LOD, oldMinLod, minLod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxLod()
	{
		return maxLod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxLod(int newMaxLod)
	{
		int oldMaxLod = maxLod;
		maxLod = newMaxLod;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__MAX_LOD, oldMaxLod, maxLod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getMaxAnisotropy()
	{
		return maxAnisotropy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxAnisotropy(float newMaxAnisotropy)
	{
		float oldMaxAnisotropy = maxAnisotropy;
		maxAnisotropy = newMaxAnisotropy;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SAMPLER__MAX_ANISOTROPY, oldMaxAnisotropy, maxAnisotropy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
		case ResourcePackage.SAMPLER__MIN_FILTER:
			return getMinFilter();
		case ResourcePackage.SAMPLER__MAG_FILTER:
			return getMagFilter();
		case ResourcePackage.SAMPLER__MIPMAP_MODE:
			return getMipmapMode();
		case ResourcePackage.SAMPLER__ADDRESS_MODE:
			return getAddressMode();
		case ResourcePackage.SAMPLER__BORDER_COLOR:
			return getBorderColor();
		case ResourcePackage.SAMPLER__ANISOTROPY_ENABLED:
			return isAnisotropyEnabled();
		case ResourcePackage.SAMPLER__UNNORMALIZED_COORDINATES:
			return isUnnormalizedCoordinates();
		case ResourcePackage.SAMPLER__COMPARE_ENABLE:
			return isCompareEnable();
		case ResourcePackage.SAMPLER__LOD_BIAS:
			return getLodBias();
		case ResourcePackage.SAMPLER__MIN_LOD:
			return getMinLod();
		case ResourcePackage.SAMPLER__MAX_LOD:
			return getMaxLod();
		case ResourcePackage.SAMPLER__MAX_ANISOTROPY:
			return getMaxAnisotropy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case ResourcePackage.SAMPLER__MIN_FILTER:
			setMinFilter((EFilter) newValue);
			return;
		case ResourcePackage.SAMPLER__MAG_FILTER:
			setMagFilter((EFilter) newValue);
			return;
		case ResourcePackage.SAMPLER__MIPMAP_MODE:
			setMipmapMode((ESamplerMipmapMode) newValue);
			return;
		case ResourcePackage.SAMPLER__ADDRESS_MODE:
			setAddressMode((ESamplerAddressMode) newValue);
			return;
		case ResourcePackage.SAMPLER__BORDER_COLOR:
			setBorderColor((EBorderColor) newValue);
			return;
		case ResourcePackage.SAMPLER__ANISOTROPY_ENABLED:
			setAnisotropyEnabled((Boolean) newValue);
			return;
		case ResourcePackage.SAMPLER__UNNORMALIZED_COORDINATES:
			setUnnormalizedCoordinates((Boolean) newValue);
			return;
		case ResourcePackage.SAMPLER__COMPARE_ENABLE:
			setCompareEnable((Boolean) newValue);
			return;
		case ResourcePackage.SAMPLER__LOD_BIAS:
			setLodBias((Float) newValue);
			return;
		case ResourcePackage.SAMPLER__MIN_LOD:
			setMinLod((Integer) newValue);
			return;
		case ResourcePackage.SAMPLER__MAX_LOD:
			setMaxLod((Integer) newValue);
			return;
		case ResourcePackage.SAMPLER__MAX_ANISOTROPY:
			setMaxAnisotropy((Float) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
		case ResourcePackage.SAMPLER__MIN_FILTER:
			setMinFilter(MIN_FILTER_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__MAG_FILTER:
			setMagFilter(MAG_FILTER_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__MIPMAP_MODE:
			setMipmapMode(MIPMAP_MODE_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__ADDRESS_MODE:
			setAddressMode(ADDRESS_MODE_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__BORDER_COLOR:
			setBorderColor(BORDER_COLOR_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__ANISOTROPY_ENABLED:
			setAnisotropyEnabled(ANISOTROPY_ENABLED_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__UNNORMALIZED_COORDINATES:
			setUnnormalizedCoordinates(UNNORMALIZED_COORDINATES_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__COMPARE_ENABLE:
			setCompareEnable(COMPARE_ENABLE_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__LOD_BIAS:
			setLodBias(LOD_BIAS_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__MIN_LOD:
			setMinLod(MIN_LOD_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__MAX_LOD:
			setMaxLod(MAX_LOD_EDEFAULT);
			return;
		case ResourcePackage.SAMPLER__MAX_ANISOTROPY:
			setMaxAnisotropy(MAX_ANISOTROPY_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
		case ResourcePackage.SAMPLER__MIN_FILTER:
			return minFilter != MIN_FILTER_EDEFAULT;
		case ResourcePackage.SAMPLER__MAG_FILTER:
			return magFilter != MAG_FILTER_EDEFAULT;
		case ResourcePackage.SAMPLER__MIPMAP_MODE:
			return mipmapMode != MIPMAP_MODE_EDEFAULT;
		case ResourcePackage.SAMPLER__ADDRESS_MODE:
			return addressMode != ADDRESS_MODE_EDEFAULT;
		case ResourcePackage.SAMPLER__BORDER_COLOR:
			return borderColor != BORDER_COLOR_EDEFAULT;
		case ResourcePackage.SAMPLER__ANISOTROPY_ENABLED:
			return anisotropyEnabled != ANISOTROPY_ENABLED_EDEFAULT;
		case ResourcePackage.SAMPLER__UNNORMALIZED_COORDINATES:
			return unnormalizedCoordinates != UNNORMALIZED_COORDINATES_EDEFAULT;
		case ResourcePackage.SAMPLER__COMPARE_ENABLE:
			return compareEnable != COMPARE_ENABLE_EDEFAULT;
		case ResourcePackage.SAMPLER__LOD_BIAS:
			return lodBias != LOD_BIAS_EDEFAULT;
		case ResourcePackage.SAMPLER__MIN_LOD:
			return minLod != MIN_LOD_EDEFAULT;
		case ResourcePackage.SAMPLER__MAX_LOD:
			return maxLod != MAX_LOD_EDEFAULT;
		case ResourcePackage.SAMPLER__MAX_ANISOTROPY:
			return maxAnisotropy != MAX_ANISOTROPY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (minFilter: ");
		result.append(minFilter);
		result.append(", magFilter: ");
		result.append(magFilter);
		result.append(", mipmapMode: ");
		result.append(mipmapMode);
		result.append(", addressMode: ");
		result.append(addressMode);
		result.append(", borderColor: ");
		result.append(borderColor);
		result.append(", anisotropyEnabled: ");
		result.append(anisotropyEnabled);
		result.append(", unnormalizedCoordinates: ");
		result.append(unnormalizedCoordinates);
		result.append(", compareEnable: ");
		result.append(compareEnable);
		result.append(", lodBias: ");
		result.append(lodBias);
		result.append(", minLod: ");
		result.append(minLod);
		result.append(", maxLod: ");
		result.append(maxLod);
		result.append(", maxAnisotropy: ");
		result.append(maxAnisotropy);
		result.append(')');
		return result.toString();
	}

} //SamplerImpl
