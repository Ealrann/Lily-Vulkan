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
import org.joml.Vector2ic;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.IResource;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImageLayout;
import org.sheepy.vulkan.model.image.ImagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getTiling <em>Tiling</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getInitialLayout <em>Initial Layout</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#isFillWithZero <em>Fill With Zero</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getFillWith <em>Fill With</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StaticImageImpl extends LilyEObject implements StaticImage
{
	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final EFormat FORMAT_EDEFAULT = EFormat.R8G8B8A8_UNORM;

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
	 * The cached value of the '{@link #getInitialLayout() <em>Initial Layout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialLayout()
	 * @generated
	 * @ordered
	 */
	protected ImageLayout initialLayout;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final Vector2ic SIZE_EDEFAULT = (Vector2ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector2i(), "1;1");

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Vector2ic size = SIZE_EDEFAULT;

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
		return VulkanResourcePackage.Literals.STATIC_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFormat getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormat(EFormat newFormat) {
		EFormat oldFormat = format;
		format = newFormat == null ? FORMAT_EDEFAULT : newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EImageUsage> getUsages() {
		if (usages == null) {
			usages = new EDataTypeUniqueEList<EImageUsage>(EImageUsage.class, this, VulkanResourcePackage.STATIC_IMAGE__USAGES);
		}
		return usages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTiling() {
		return tiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTiling(int newTiling) {
		int oldTiling = tiling;
		tiling = newTiling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__TILING, oldTiling, tiling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMipLevels() {
		return mipLevels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMipLevels(int newMipLevels) {
		int oldMipLevels = mipLevels;
		mipLevels = newMipLevels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__MIP_LEVELS, oldMipLevels, mipLevels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageLayout getInitialLayout() {
		return initialLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialLayout(ImageLayout newInitialLayout, NotificationChain msgs) {
		ImageLayout oldInitialLayout = initialLayout;
		initialLayout = newInitialLayout;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT, oldInitialLayout, newInitialLayout);
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
	public void setInitialLayout(ImageLayout newInitialLayout) {
		if (newInitialLayout != initialLayout) {
			NotificationChain msgs = null;
			if (initialLayout != null)
				msgs = ((InternalEObject)initialLayout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT, null, msgs);
			if (newInitialLayout != null)
				msgs = ((InternalEObject)newInitialLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT, null, msgs);
			msgs = basicSetInitialLayout(newInitialLayout, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT, newInitialLayout, newInitialLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO, oldFillWithZero, fillWithZero));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__FILL_WITH, oldFillWith, fillWith));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector2ic getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(Vector2ic newSize)
	{
		Vector2ic oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT:
				return basicSetInitialLayout(null, msgs);
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
		switch (featureID) {
			case VulkanResourcePackage.STATIC_IMAGE__FORMAT:
				return getFormat();
			case VulkanResourcePackage.STATIC_IMAGE__USAGES:
				return getUsages();
			case VulkanResourcePackage.STATIC_IMAGE__TILING:
				return getTiling();
			case VulkanResourcePackage.STATIC_IMAGE__MIP_LEVELS:
				return getMipLevels();
			case VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT:
				return getInitialLayout();
			case VulkanResourcePackage.STATIC_IMAGE__NAME:
				return getName();
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				return isFillWithZero();
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH:
				return getFillWith();
			case VulkanResourcePackage.STATIC_IMAGE__SIZE:
				return getSize();
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
		switch (featureID) {
			case VulkanResourcePackage.STATIC_IMAGE__FORMAT:
				setFormat((EFormat)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EImageUsage>)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__TILING:
				setTiling((Integer)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__MIP_LEVELS:
				setMipLevels((Integer)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT:
				setInitialLayout((ImageLayout)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__NAME:
				setName((String)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				setFillWithZero((Boolean)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH:
				setFillWith((ByteBuffer)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__SIZE:
				setSize((Vector2ic)newValue);
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
		switch (featureID) {
			case VulkanResourcePackage.STATIC_IMAGE__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__USAGES:
				getUsages().clear();
				return;
			case VulkanResourcePackage.STATIC_IMAGE__TILING:
				setTiling(TILING_EDEFAULT);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__MIP_LEVELS:
				setMipLevels(MIP_LEVELS_EDEFAULT);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT:
				setInitialLayout((ImageLayout)null);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				setFillWithZero(FILL_WITH_ZERO_EDEFAULT);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH:
				setFillWith(FILL_WITH_EDEFAULT);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__SIZE:
				setSize(SIZE_EDEFAULT);
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
		switch (featureID) {
			case VulkanResourcePackage.STATIC_IMAGE__FORMAT:
				return format != FORMAT_EDEFAULT;
			case VulkanResourcePackage.STATIC_IMAGE__USAGES:
				return usages != null && !usages.isEmpty();
			case VulkanResourcePackage.STATIC_IMAGE__TILING:
				return tiling != TILING_EDEFAULT;
			case VulkanResourcePackage.STATIC_IMAGE__MIP_LEVELS:
				return mipLevels != MIP_LEVELS_EDEFAULT;
			case VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT:
				return initialLayout != null;
			case VulkanResourcePackage.STATIC_IMAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				return fillWithZero != FILL_WITH_ZERO_EDEFAULT;
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH:
				return FILL_WITH_EDEFAULT == null ? fillWith != null : !FILL_WITH_EDEFAULT.equals(fillWith);
			case VulkanResourcePackage.STATIC_IMAGE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ImageInfo.class) {
			switch (derivedFeatureID) {
				case VulkanResourcePackage.STATIC_IMAGE__FORMAT: return ImagePackage.IMAGE_INFO__FORMAT;
				case VulkanResourcePackage.STATIC_IMAGE__USAGES: return ImagePackage.IMAGE_INFO__USAGES;
				case VulkanResourcePackage.STATIC_IMAGE__TILING: return ImagePackage.IMAGE_INFO__TILING;
				case VulkanResourcePackage.STATIC_IMAGE__MIP_LEVELS: return ImagePackage.IMAGE_INFO__MIP_LEVELS;
				case VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT: return ImagePackage.IMAGE_INFO__INITIAL_LAYOUT;
				default: return -1;
			}
		}
		if (baseClass == LNamedElement.class) {
			switch (derivedFeatureID) {
				case VulkanResourcePackage.STATIC_IMAGE__NAME: return TypesPackage.LNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == IResource.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IImage.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Image.class) {
			switch (derivedFeatureID) {
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ImageInfo.class) {
			switch (baseFeatureID) {
				case ImagePackage.IMAGE_INFO__FORMAT: return VulkanResourcePackage.STATIC_IMAGE__FORMAT;
				case ImagePackage.IMAGE_INFO__USAGES: return VulkanResourcePackage.STATIC_IMAGE__USAGES;
				case ImagePackage.IMAGE_INFO__TILING: return VulkanResourcePackage.STATIC_IMAGE__TILING;
				case ImagePackage.IMAGE_INFO__MIP_LEVELS: return VulkanResourcePackage.STATIC_IMAGE__MIP_LEVELS;
				case ImagePackage.IMAGE_INFO__INITIAL_LAYOUT: return VulkanResourcePackage.STATIC_IMAGE__INITIAL_LAYOUT;
				default: return -1;
			}
		}
		if (baseClass == LNamedElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.LNAMED_ELEMENT__NAME: return VulkanResourcePackage.STATIC_IMAGE__NAME;
				default: return -1;
			}
		}
		if (baseClass == IResource.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == IImage.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Image.class) {
			switch (baseFeatureID) {
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
		result.append(" (format: ");
		result.append(format);
		result.append(", usages: ");
		result.append(usages);
		result.append(", tiling: ");
		result.append(tiling);
		result.append(", mipLevels: ");
		result.append(mipLevels);
		result.append(", name: ");
		result.append(name);
		result.append(", fillWithZero: ");
		result.append(fillWithZero);
		result.append(", fillWith: ");
		result.append(fillWith);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //StaticImageImpl
