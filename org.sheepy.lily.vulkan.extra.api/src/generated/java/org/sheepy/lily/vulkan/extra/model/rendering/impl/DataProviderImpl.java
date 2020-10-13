/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getMinSize <em>Min Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl#getDataSourceName <em>Data Source Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataProviderImpl<T extends Structure> extends LilyEObject implements DataProvider<T>
{
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
	 * The cached value of the '{@link #getDataSource() <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected IBufferDataSource dataSource;

	/**
	 * The default value of the '{@link #getDataSourceName() <em>Data Source Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_SOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataSourceName() <em>Data Source Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceName()
	 * @generated
	 * @ordered
	 */
	protected String dataSourceName = DATA_SOURCE_NAME_EDEFAULT;

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
	public IBufferDataSource getDataSource()
	{
		if (dataSource != null && ((EObject)dataSource).eIsProxy())
		{
			InternalEObject oldDataSource = dataSource;
			dataSource = (IBufferDataSource)eResolveProxy(oldDataSource);
			if (dataSource != oldDataSource)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.DATA_PROVIDER__DATA_SOURCE, oldDataSource, dataSource));
			}
		}
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBufferDataSource basicGetDataSource()
	{
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataSource(IBufferDataSource newDataSource)
	{
		IBufferDataSource oldDataSource = dataSource;
		dataSource = newDataSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.DATA_PROVIDER__DATA_SOURCE, oldDataSource, dataSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDataSourceName()
	{
		return dataSourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataSourceName(String newDataSourceName)
	{
		String oldDataSourceName = dataSourceName;
		dataSourceName = newDataSourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.DATA_PROVIDER__DATA_SOURCE_NAME, oldDataSourceName, dataSourceName));
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
			case RenderingPackage.DATA_PROVIDER__USAGES:
				return getUsages();
			case RenderingPackage.DATA_PROVIDER__GROW_FACTOR:
				return getGrowFactor();
			case RenderingPackage.DATA_PROVIDER__MIN_SIZE:
				return getMinSize();
			case RenderingPackage.DATA_PROVIDER__DATA_SOURCE:
				if (resolve) return getDataSource();
				return basicGetDataSource();
			case RenderingPackage.DATA_PROVIDER__DATA_SOURCE_NAME:
				return getDataSourceName();
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
			case RenderingPackage.DATA_PROVIDER__DATA_SOURCE:
				setDataSource((IBufferDataSource)newValue);
				return;
			case RenderingPackage.DATA_PROVIDER__DATA_SOURCE_NAME:
				setDataSourceName((String)newValue);
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
			case RenderingPackage.DATA_PROVIDER__USAGES:
				getUsages().clear();
				return;
			case RenderingPackage.DATA_PROVIDER__GROW_FACTOR:
				setGrowFactor(GROW_FACTOR_EDEFAULT);
				return;
			case RenderingPackage.DATA_PROVIDER__MIN_SIZE:
				setMinSize(MIN_SIZE_EDEFAULT);
				return;
			case RenderingPackage.DATA_PROVIDER__DATA_SOURCE:
				setDataSource((IBufferDataSource)null);
				return;
			case RenderingPackage.DATA_PROVIDER__DATA_SOURCE_NAME:
				setDataSourceName(DATA_SOURCE_NAME_EDEFAULT);
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
			case RenderingPackage.DATA_PROVIDER__USAGES:
				return usages != null && !usages.isEmpty();
			case RenderingPackage.DATA_PROVIDER__GROW_FACTOR:
				return growFactor != GROW_FACTOR_EDEFAULT;
			case RenderingPackage.DATA_PROVIDER__MIN_SIZE:
				return minSize != MIN_SIZE_EDEFAULT;
			case RenderingPackage.DATA_PROVIDER__DATA_SOURCE:
				return dataSource != null;
			case RenderingPackage.DATA_PROVIDER__DATA_SOURCE_NAME:
				return DATA_SOURCE_NAME_EDEFAULT == null ? dataSourceName != null : !DATA_SOURCE_NAME_EDEFAULT.equals(dataSourceName);
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
		result.append(", dataSourceName: ");
		result.append(dataSourceName);
		result.append(')');
		return result.toString();
	}

} //DataProviderImpl
