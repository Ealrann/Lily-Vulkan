/**
 */
package org.sheepy.vulkan.model.image.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl#getTiling <em>Tiling</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageInfoImpl#getMipLevels <em>Mip Levels</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageInfoImpl extends LilyEObject implements ImageInfo
{
	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final EFormat FORMAT_EDEFAULT = EFormat.UNDEFINED;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected EFormat format = FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsages() <em>Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<EImageUsage> usages;

	/**
	 * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTIES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected int properties = PROPERTIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getTiling() <em>Tiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiling()
	 * @generated
	 * @ordered
	 */
	protected static final int TILING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTiling() <em>Tiling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiling()
	 * @generated
	 * @ordered
	 */
	protected int tiling = TILING_EDEFAULT;

	/**
	 * The default value of the '{@link #getMipLevels() <em>Mip Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMipLevels()
	 * @generated
	 * @ordered
	 */
	protected static final int MIP_LEVELS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMipLevels() <em>Mip Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMipLevels()
	 * @generated
	 * @ordered
	 */
	protected int mipLevels = MIP_LEVELS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageInfoImpl()
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
		return ImagePackage.Literals.IMAGE_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWidth()
	{
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(int newWidth)
	{
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_INFO__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHeight()
	{
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeight(int newHeight)
	{
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_INFO__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFormat getFormat()
	{
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormat(EFormat newFormat)
	{
		EFormat oldFormat = format;
		format = newFormat == null ? FORMAT_EDEFAULT : newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_INFO__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EImageUsage> getUsages()
	{
		if (usages == null)
		{
			usages = new EDataTypeUniqueEList<EImageUsage>(EImageUsage.class, this, ImagePackage.IMAGE_INFO__USAGES);
		}
		return usages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getProperties()
	{
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperties(int newProperties)
	{
		int oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_INFO__PROPERTIES, oldProperties, properties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTiling()
	{
		return tiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTiling(int newTiling)
	{
		int oldTiling = tiling;
		tiling = newTiling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_INFO__TILING, oldTiling, tiling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMipLevels()
	{
		return mipLevels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMipLevels(int newMipLevels)
	{
		int oldMipLevels = mipLevels;
		mipLevels = newMipLevels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_INFO__MIP_LEVELS, oldMipLevels, mipLevels));
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
			case ImagePackage.IMAGE_INFO__WIDTH:
				return getWidth();
			case ImagePackage.IMAGE_INFO__HEIGHT:
				return getHeight();
			case ImagePackage.IMAGE_INFO__FORMAT:
				return getFormat();
			case ImagePackage.IMAGE_INFO__USAGES:
				return getUsages();
			case ImagePackage.IMAGE_INFO__PROPERTIES:
				return getProperties();
			case ImagePackage.IMAGE_INFO__TILING:
				return getTiling();
			case ImagePackage.IMAGE_INFO__MIP_LEVELS:
				return getMipLevels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ImagePackage.IMAGE_INFO__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ImagePackage.IMAGE_INFO__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ImagePackage.IMAGE_INFO__FORMAT:
				setFormat((EFormat)newValue);
				return;
			case ImagePackage.IMAGE_INFO__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EImageUsage>)newValue);
				return;
			case ImagePackage.IMAGE_INFO__PROPERTIES:
				setProperties((Integer)newValue);
				return;
			case ImagePackage.IMAGE_INFO__TILING:
				setTiling((Integer)newValue);
				return;
			case ImagePackage.IMAGE_INFO__MIP_LEVELS:
				setMipLevels((Integer)newValue);
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
			case ImagePackage.IMAGE_INFO__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ImagePackage.IMAGE_INFO__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ImagePackage.IMAGE_INFO__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case ImagePackage.IMAGE_INFO__USAGES:
				getUsages().clear();
				return;
			case ImagePackage.IMAGE_INFO__PROPERTIES:
				setProperties(PROPERTIES_EDEFAULT);
				return;
			case ImagePackage.IMAGE_INFO__TILING:
				setTiling(TILING_EDEFAULT);
				return;
			case ImagePackage.IMAGE_INFO__MIP_LEVELS:
				setMipLevels(MIP_LEVELS_EDEFAULT);
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
			case ImagePackage.IMAGE_INFO__WIDTH:
				return width != WIDTH_EDEFAULT;
			case ImagePackage.IMAGE_INFO__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case ImagePackage.IMAGE_INFO__FORMAT:
				return format != FORMAT_EDEFAULT;
			case ImagePackage.IMAGE_INFO__USAGES:
				return usages != null && !usages.isEmpty();
			case ImagePackage.IMAGE_INFO__PROPERTIES:
				return properties != PROPERTIES_EDEFAULT;
			case ImagePackage.IMAGE_INFO__TILING:
				return tiling != TILING_EDEFAULT;
			case ImagePackage.IMAGE_INFO__MIP_LEVELS:
				return mipLevels != MIP_LEVELS_EDEFAULT;
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
		result.append(" (width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", format: ");
		result.append(format);
		result.append(", usages: ");
		result.append(usages);
		result.append(", properties: ");
		result.append(properties);
		result.append(", tiling: ");
		result.append(tiling);
		result.append(", mipLevels: ");
		result.append(mipLevels);
		result.append(')');
		return result.toString();
	}

} //ImageInfoImpl
