/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getMinSize <em>Min Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataProviderImpl<T extends Structure> extends LilyEObject implements DataProvider<T>
{
	/**
	 * The cached value of the '{@link #getDataProvider() <em>Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProvider()
	 * @generated
	 * @ordered
	 */
	protected RenderDataProvider<T> dataProvider;

	/**
	 * The cached value of the '{@link #getUsages() <em>Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<EBufferUsage> usages;

	/**
	 * The default value of the '{@link #getGrowFactor() <em>Grow Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowFactor()
	 * @generated
	 * @ordered
	 */
	protected static final float GROW_FACTOR_EDEFAULT = 1.5F;

	/**
	 * The cached value of the '{@link #getGrowFactor() <em>Grow Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowFactor()
	 * @generated
	 * @ordered
	 */
	protected float growFactor = GROW_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinSize() <em>Min Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinSize()
	 * @generated
	 * @ordered
	 */
	protected static final long MIN_SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMinSize() <em>Min Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinSize()
	 * @generated
	 * @ordered
	 */
	protected long minSize = MIN_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataProviderImpl()
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
		return RenderingPackage.Literals.DATA_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderDataProvider<T> getDataProvider()
	{
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataProvider(RenderDataProvider<T> newDataProvider, NotificationChain msgs)
	{
		RenderDataProvider<T> oldDataProvider = dataProvider;
		dataProvider = newDataProvider;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RenderingPackage.DATA_PROVIDER__DATA_PROVIDER, oldDataProvider, newDataProvider);
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
	public void setDataProvider(RenderDataProvider<T> newDataProvider)
	{
		if (newDataProvider != dataProvider)
		{
			NotificationChain msgs = null;
			if (dataProvider != null)
				msgs = ((InternalEObject)dataProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.DATA_PROVIDER__DATA_PROVIDER, null, msgs);
			if (newDataProvider != null)
				msgs = ((InternalEObject)newDataProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.DATA_PROVIDER__DATA_PROVIDER, null, msgs);
			msgs = basicSetDataProvider(newDataProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.DATA_PROVIDER__DATA_PROVIDER, newDataProvider, newDataProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EBufferUsage> getUsages()
	{
		if (usages == null)
		{
			usages = new EDataTypeUniqueEList<EBufferUsage>(EBufferUsage.class, this, RenderingPackage.DATA_PROVIDER__USAGES);
		}
		return usages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getGrowFactor()
	{
		return growFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGrowFactor(float newGrowFactor)
	{
		float oldGrowFactor = growFactor;
		growFactor = newGrowFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.DATA_PROVIDER__GROW_FACTOR, oldGrowFactor, growFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getMinSize()
	{
		return minSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinSize(long newMinSize)
	{
		long oldMinSize = minSize;
		minSize = newMinSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.DATA_PROVIDER__MIN_SIZE, oldMinSize, minSize));
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
			case RenderingPackage.DATA_PROVIDER__DATA_PROVIDER:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case RenderingPackage.DATA_PROVIDER__DATA_PROVIDER:
				return getDataProvider();
			case RenderingPackage.DATA_PROVIDER__USAGES:
				return getUsages();
			case RenderingPackage.DATA_PROVIDER__GROW_FACTOR:
				return getGrowFactor();
			case RenderingPackage.DATA_PROVIDER__MIN_SIZE:
				return getMinSize();
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
			case RenderingPackage.DATA_PROVIDER__DATA_PROVIDER:
				setDataProvider((RenderDataProvider<T>)newValue);
				return;
			case RenderingPackage.DATA_PROVIDER__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EBufferUsage>)newValue);
				return;
			case RenderingPackage.DATA_PROVIDER__GROW_FACTOR:
				setGrowFactor((Float)newValue);
				return;
			case RenderingPackage.DATA_PROVIDER__MIN_SIZE:
				setMinSize((Long)newValue);
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
			case RenderingPackage.DATA_PROVIDER__DATA_PROVIDER:
				setDataProvider((RenderDataProvider<T>)null);
				return;
			case RenderingPackage.DATA_PROVIDER__USAGES:
				getUsages().clear();
				return;
			case RenderingPackage.DATA_PROVIDER__GROW_FACTOR:
				setGrowFactor(GROW_FACTOR_EDEFAULT);
				return;
			case RenderingPackage.DATA_PROVIDER__MIN_SIZE:
				setMinSize(MIN_SIZE_EDEFAULT);
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
			case RenderingPackage.DATA_PROVIDER__DATA_PROVIDER:
				return dataProvider != null;
			case RenderingPackage.DATA_PROVIDER__USAGES:
				return usages != null && !usages.isEmpty();
			case RenderingPackage.DATA_PROVIDER__GROW_FACTOR:
				return growFactor != GROW_FACTOR_EDEFAULT;
			case RenderingPackage.DATA_PROVIDER__MIN_SIZE:
				return minSize != MIN_SIZE_EDEFAULT;
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
		result.append(" (usages: ");
		result.append(usages);
		result.append(", growFactor: ");
		result.append(growFactor);
		result.append(", minSize: ");
		result.append(minSize);
		result.append(')');
		return result.toString();
	}

} //DataProviderImpl
