/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.nio.ByteBuffer;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.lily.vulkan.model.resource.BasicDescriptedResource;
import org.sheepy.lily.vulkan.model.resource.Descriptor;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.StaticImage;

import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getTiling <em>Tiling</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#isFillWithZero <em>Fill With Zero</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getFillWith <em>Fill With</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StaticImageImpl extends ImageImpl implements StaticImage
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
	 * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptor()
	 * @generated
	 * @ordered
	 */
	protected Descriptor descriptor;

	/**
	 * The default value of the '{@link #isFillWithZero() <em>Fill With Zero</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFillWithZero()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILL_WITH_ZERO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFillWithZero() <em>Fill With Zero</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFillWithZero()
	 * @generated
	 * @ordered
	 */
	protected boolean fillWithZero = FILL_WITH_ZERO_EDEFAULT;

	/**
	 * The default value of the '{@link #getFillWith() <em>Fill With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillWith()
	 * @generated
	 * @ordered
	 */
	protected static final ByteBuffer FILL_WITH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFillWith() <em>Fill With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillWith()
	 * @generated
	 * @ordered
	 */
	protected ByteBuffer fillWith = FILL_WITH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticImageImpl()
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
		return ResourcePackage.Literals.STATIC_IMAGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__HEIGHT, oldHeight, height));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__FORMAT, oldFormat, format));
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
			usages = new EDataTypeUniqueEList<EImageUsage>(EImageUsage.class, this, ResourcePackage.STATIC_IMAGE__USAGES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__PROPERTIES, oldProperties, properties));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__TILING, oldTiling, tiling));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__MIP_LEVELS, oldMipLevels, mipLevels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Descriptor getDescriptor()
	{
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptor(Descriptor newDescriptor, NotificationChain msgs)
	{
		Descriptor oldDescriptor = descriptor;
		descriptor = newDescriptor;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__DESCRIPTOR, oldDescriptor, newDescriptor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptor(Descriptor newDescriptor)
	{
		if (newDescriptor != descriptor)
		{
			NotificationChain msgs = null;
			if (descriptor != null)
				msgs = ((InternalEObject)descriptor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.STATIC_IMAGE__DESCRIPTOR, null, msgs);
			if (newDescriptor != null)
				msgs = ((InternalEObject)newDescriptor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.STATIC_IMAGE__DESCRIPTOR, null, msgs);
			msgs = basicSetDescriptor(newDescriptor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__DESCRIPTOR, newDescriptor, newDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFillWithZero()
	{
		return fillWithZero;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFillWithZero(boolean newFillWithZero)
	{
		boolean oldFillWithZero = fillWithZero;
		fillWithZero = newFillWithZero;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO, oldFillWithZero, fillWithZero));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ByteBuffer getFillWith()
	{
		return fillWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFillWith(ByteBuffer newFillWith)
	{
		ByteBuffer oldFillWith = fillWith;
		fillWith = newFillWith;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.STATIC_IMAGE__FILL_WITH, oldFillWith, fillWith));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ResourcePackage.STATIC_IMAGE__DESCRIPTOR:
				return basicSetDescriptor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ResourcePackage.STATIC_IMAGE__WIDTH:
				return getWidth();
			case ResourcePackage.STATIC_IMAGE__HEIGHT:
				return getHeight();
			case ResourcePackage.STATIC_IMAGE__FORMAT:
				return getFormat();
			case ResourcePackage.STATIC_IMAGE__USAGES:
				return getUsages();
			case ResourcePackage.STATIC_IMAGE__PROPERTIES:
				return getProperties();
			case ResourcePackage.STATIC_IMAGE__TILING:
				return getTiling();
			case ResourcePackage.STATIC_IMAGE__MIP_LEVELS:
				return getMipLevels();
			case ResourcePackage.STATIC_IMAGE__DESCRIPTOR:
				return getDescriptor();
			case ResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				return isFillWithZero();
			case ResourcePackage.STATIC_IMAGE__FILL_WITH:
				return getFillWith();
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
			case ResourcePackage.STATIC_IMAGE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__FORMAT:
				setFormat((EFormat)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EImageUsage>)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__PROPERTIES:
				setProperties((Integer)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__TILING:
				setTiling((Integer)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__MIP_LEVELS:
				setMipLevels((Integer)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__DESCRIPTOR:
				setDescriptor((Descriptor)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				setFillWithZero((Boolean)newValue);
				return;
			case ResourcePackage.STATIC_IMAGE__FILL_WITH:
				setFillWith((ByteBuffer)newValue);
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
			case ResourcePackage.STATIC_IMAGE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ResourcePackage.STATIC_IMAGE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ResourcePackage.STATIC_IMAGE__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case ResourcePackage.STATIC_IMAGE__USAGES:
				getUsages().clear();
				return;
			case ResourcePackage.STATIC_IMAGE__PROPERTIES:
				setProperties(PROPERTIES_EDEFAULT);
				return;
			case ResourcePackage.STATIC_IMAGE__TILING:
				setTiling(TILING_EDEFAULT);
				return;
			case ResourcePackage.STATIC_IMAGE__MIP_LEVELS:
				setMipLevels(MIP_LEVELS_EDEFAULT);
				return;
			case ResourcePackage.STATIC_IMAGE__DESCRIPTOR:
				setDescriptor((Descriptor)null);
				return;
			case ResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				setFillWithZero(FILL_WITH_ZERO_EDEFAULT);
				return;
			case ResourcePackage.STATIC_IMAGE__FILL_WITH:
				setFillWith(FILL_WITH_EDEFAULT);
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
			case ResourcePackage.STATIC_IMAGE__WIDTH:
				return width != WIDTH_EDEFAULT;
			case ResourcePackage.STATIC_IMAGE__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case ResourcePackage.STATIC_IMAGE__FORMAT:
				return format != FORMAT_EDEFAULT;
			case ResourcePackage.STATIC_IMAGE__USAGES:
				return usages != null && !usages.isEmpty();
			case ResourcePackage.STATIC_IMAGE__PROPERTIES:
				return properties != PROPERTIES_EDEFAULT;
			case ResourcePackage.STATIC_IMAGE__TILING:
				return tiling != TILING_EDEFAULT;
			case ResourcePackage.STATIC_IMAGE__MIP_LEVELS:
				return mipLevels != MIP_LEVELS_EDEFAULT;
			case ResourcePackage.STATIC_IMAGE__DESCRIPTOR:
				return descriptor != null;
			case ResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				return fillWithZero != FILL_WITH_ZERO_EDEFAULT;
			case ResourcePackage.STATIC_IMAGE__FILL_WITH:
				return FILL_WITH_EDEFAULT == null ? fillWith != null : !FILL_WITH_EDEFAULT.equals(fillWith);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == ImageInfo.class)
		{
			switch (derivedFeatureID)
			{
				case ResourcePackage.STATIC_IMAGE__WIDTH: return ImagePackage.IMAGE_INFO__WIDTH;
				case ResourcePackage.STATIC_IMAGE__HEIGHT: return ImagePackage.IMAGE_INFO__HEIGHT;
				case ResourcePackage.STATIC_IMAGE__FORMAT: return ImagePackage.IMAGE_INFO__FORMAT;
				case ResourcePackage.STATIC_IMAGE__USAGES: return ImagePackage.IMAGE_INFO__USAGES;
				case ResourcePackage.STATIC_IMAGE__PROPERTIES: return ImagePackage.IMAGE_INFO__PROPERTIES;
				case ResourcePackage.STATIC_IMAGE__TILING: return ImagePackage.IMAGE_INFO__TILING;
				case ResourcePackage.STATIC_IMAGE__MIP_LEVELS: return ImagePackage.IMAGE_INFO__MIP_LEVELS;
				default: return -1;
			}
		}
		if (baseClass == BasicDescriptedResource.class)
		{
			switch (derivedFeatureID)
			{
				case ResourcePackage.STATIC_IMAGE__DESCRIPTOR: return ResourcePackage.BASIC_DESCRIPTED_RESOURCE__DESCRIPTOR;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == ImageInfo.class)
		{
			switch (baseFeatureID)
			{
				case ImagePackage.IMAGE_INFO__WIDTH: return ResourcePackage.STATIC_IMAGE__WIDTH;
				case ImagePackage.IMAGE_INFO__HEIGHT: return ResourcePackage.STATIC_IMAGE__HEIGHT;
				case ImagePackage.IMAGE_INFO__FORMAT: return ResourcePackage.STATIC_IMAGE__FORMAT;
				case ImagePackage.IMAGE_INFO__USAGES: return ResourcePackage.STATIC_IMAGE__USAGES;
				case ImagePackage.IMAGE_INFO__PROPERTIES: return ResourcePackage.STATIC_IMAGE__PROPERTIES;
				case ImagePackage.IMAGE_INFO__TILING: return ResourcePackage.STATIC_IMAGE__TILING;
				case ImagePackage.IMAGE_INFO__MIP_LEVELS: return ResourcePackage.STATIC_IMAGE__MIP_LEVELS;
				default: return -1;
			}
		}
		if (baseClass == BasicDescriptedResource.class)
		{
			switch (baseFeatureID)
			{
				case ResourcePackage.BASIC_DESCRIPTED_RESOURCE__DESCRIPTOR: return ResourcePackage.STATIC_IMAGE__DESCRIPTOR;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", fillWithZero: ");
		result.append(fillWithZero);
		result.append(", fillWith: ");
		result.append(fillWith);
		result.append(')');
		return result.toString();
	}

} //StaticImageImpl
