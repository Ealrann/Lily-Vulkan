/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.IResource;

import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageDataProvider;
import org.sheepy.lily.vulkan.model.resource.ImageViewer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Viewer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageViewerImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageViewerImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageViewerImpl#getTiling <em>Tiling</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageViewerImpl#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageViewerImpl#getInitialLayout <em>Initial Layout</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageViewerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageViewerImpl#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageViewerImpl#isMipmapEnabled <em>Mipmap Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageViewerImpl extends LilyEObject implements ImageViewer {
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
	 * The default value of the '{@link #getInitialLayout() <em>Initial Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout INITIAL_LAYOUT_EDEFAULT = EImageLayout.SHADER_READ_ONLY_OPTIMAL;

	/**
	 * The cached value of the '{@link #getInitialLayout() <em>Initial Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout initialLayout = INITIAL_LAYOUT_EDEFAULT;

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
	 * The cached value of the '{@link #getDataProvider() <em>Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProvider()
	 * @generated
	 * @ordered
	 */
	protected ImageDataProvider dataProvider;

	/**
	 * The default value of the '{@link #isMipmapEnabled() <em>Mipmap Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMipmapEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MIPMAP_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMipmapEnabled() <em>Mipmap Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMipmapEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean mipmapEnabled = MIPMAP_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageViewerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VulkanResourcePackage.Literals.IMAGE_VIEWER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_VIEWER__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EImageUsage> getUsages() {
		if (usages == null)
		{
			usages = new EDataTypeUniqueEList<EImageUsage>(EImageUsage.class, this, VulkanResourcePackage.IMAGE_VIEWER__USAGES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_VIEWER__TILING, oldTiling, tiling));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_VIEWER__MIP_LEVELS, oldMipLevels, mipLevels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImageLayout getInitialLayout() {
		return initialLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialLayout(EImageLayout newInitialLayout)
	{
		EImageLayout oldInitialLayout = initialLayout;
		initialLayout = newInitialLayout == null ? INITIAL_LAYOUT_EDEFAULT : newInitialLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_VIEWER__INITIAL_LAYOUT, oldInitialLayout, initialLayout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_VIEWER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageDataProvider getDataProvider() {
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataProvider(ImageDataProvider newDataProvider, NotificationChain msgs) {
		ImageDataProvider oldDataProvider = dataProvider;
		dataProvider = newDataProvider;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER, oldDataProvider, newDataProvider);
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
	public void setDataProvider(ImageDataProvider newDataProvider) {
		if (newDataProvider != dataProvider)
		{
			NotificationChain msgs = null;
			if (dataProvider != null)
				msgs = ((InternalEObject)dataProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER, null, msgs);
			if (newDataProvider != null)
				msgs = ((InternalEObject)newDataProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER, null, msgs);
			msgs = basicSetDataProvider(newDataProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER, newDataProvider, newDataProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMipmapEnabled()
	{
		return mipmapEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMipmapEnabled(boolean newMipmapEnabled)
	{
		boolean oldMipmapEnabled = mipmapEnabled;
		mipmapEnabled = newMipmapEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_VIEWER__MIPMAP_ENABLED, oldMipmapEnabled, mipmapEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER:
				return basicSetDataProvider(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case VulkanResourcePackage.IMAGE_VIEWER__FORMAT:
				return getFormat();
			case VulkanResourcePackage.IMAGE_VIEWER__USAGES:
				return getUsages();
			case VulkanResourcePackage.IMAGE_VIEWER__TILING:
				return getTiling();
			case VulkanResourcePackage.IMAGE_VIEWER__MIP_LEVELS:
				return getMipLevels();
			case VulkanResourcePackage.IMAGE_VIEWER__INITIAL_LAYOUT:
				return getInitialLayout();
			case VulkanResourcePackage.IMAGE_VIEWER__NAME:
				return getName();
			case VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER:
				return getDataProvider();
			case VulkanResourcePackage.IMAGE_VIEWER__MIPMAP_ENABLED:
				return isMipmapEnabled();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case VulkanResourcePackage.IMAGE_VIEWER__FORMAT:
				setFormat((EFormat)newValue);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EImageUsage>)newValue);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__TILING:
				setTiling((Integer)newValue);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__MIP_LEVELS:
				setMipLevels((Integer)newValue);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__INITIAL_LAYOUT:
				setInitialLayout((EImageLayout)newValue);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__NAME:
				setName((String)newValue);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER:
				setDataProvider((ImageDataProvider)newValue);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__MIPMAP_ENABLED:
				setMipmapEnabled((Boolean)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case VulkanResourcePackage.IMAGE_VIEWER__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__USAGES:
				getUsages().clear();
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__TILING:
				setTiling(TILING_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__MIP_LEVELS:
				setMipLevels(MIP_LEVELS_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__INITIAL_LAYOUT:
				setInitialLayout(INITIAL_LAYOUT_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER:
				setDataProvider((ImageDataProvider)null);
				return;
			case VulkanResourcePackage.IMAGE_VIEWER__MIPMAP_ENABLED:
				setMipmapEnabled(MIPMAP_ENABLED_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case VulkanResourcePackage.IMAGE_VIEWER__FORMAT:
				return format != FORMAT_EDEFAULT;
			case VulkanResourcePackage.IMAGE_VIEWER__USAGES:
				return usages != null && !usages.isEmpty();
			case VulkanResourcePackage.IMAGE_VIEWER__TILING:
				return tiling != TILING_EDEFAULT;
			case VulkanResourcePackage.IMAGE_VIEWER__MIP_LEVELS:
				return mipLevels != MIP_LEVELS_EDEFAULT;
			case VulkanResourcePackage.IMAGE_VIEWER__INITIAL_LAYOUT:
				return initialLayout != INITIAL_LAYOUT_EDEFAULT;
			case VulkanResourcePackage.IMAGE_VIEWER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VulkanResourcePackage.IMAGE_VIEWER__DATA_PROVIDER:
				return dataProvider != null;
			case VulkanResourcePackage.IMAGE_VIEWER__MIPMAP_ENABLED:
				return mipmapEnabled != MIPMAP_ENABLED_EDEFAULT;
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
		if (baseClass == ImageInfo.class)
		{
			switch (derivedFeatureID)
			{
				case VulkanResourcePackage.IMAGE_VIEWER__FORMAT: return ImagePackage.IMAGE_INFO__FORMAT;
				case VulkanResourcePackage.IMAGE_VIEWER__USAGES: return ImagePackage.IMAGE_INFO__USAGES;
				case VulkanResourcePackage.IMAGE_VIEWER__TILING: return ImagePackage.IMAGE_INFO__TILING;
				case VulkanResourcePackage.IMAGE_VIEWER__MIP_LEVELS: return ImagePackage.IMAGE_INFO__MIP_LEVELS;
				case VulkanResourcePackage.IMAGE_VIEWER__INITIAL_LAYOUT: return ImagePackage.IMAGE_INFO__INITIAL_LAYOUT;
				default: return -1;
			}
		}
		if (baseClass == LNamedElement.class)
		{
			switch (derivedFeatureID)
			{
				case VulkanResourcePackage.IMAGE_VIEWER__NAME: return TypesPackage.LNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == IResource.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == IImage.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Image.class)
		{
			switch (derivedFeatureID)
			{
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
		if (baseClass == ImageInfo.class)
		{
			switch (baseFeatureID)
			{
				case ImagePackage.IMAGE_INFO__FORMAT: return VulkanResourcePackage.IMAGE_VIEWER__FORMAT;
				case ImagePackage.IMAGE_INFO__USAGES: return VulkanResourcePackage.IMAGE_VIEWER__USAGES;
				case ImagePackage.IMAGE_INFO__TILING: return VulkanResourcePackage.IMAGE_VIEWER__TILING;
				case ImagePackage.IMAGE_INFO__MIP_LEVELS: return VulkanResourcePackage.IMAGE_VIEWER__MIP_LEVELS;
				case ImagePackage.IMAGE_INFO__INITIAL_LAYOUT: return VulkanResourcePackage.IMAGE_VIEWER__INITIAL_LAYOUT;
				default: return -1;
			}
		}
		if (baseClass == LNamedElement.class)
		{
			switch (baseFeatureID)
			{
				case TypesPackage.LNAMED_ELEMENT__NAME: return VulkanResourcePackage.IMAGE_VIEWER__NAME;
				default: return -1;
			}
		}
		if (baseClass == IResource.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == IImage.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Image.class)
		{
			switch (baseFeatureID)
			{
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
	public String toString() {
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
		result.append(", initialLayout: ");
		result.append(initialLayout);
		result.append(", name: ");
		result.append(name);
		result.append(", mipmapEnabled: ");
		result.append(mipmapEnabled);
		result.append(')');
		return result.toString();
	}

} //ImageViewerImpl
