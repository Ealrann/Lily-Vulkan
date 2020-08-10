/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Provider Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderPkgImpl#getDataProviders <em>Data Providers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataProviderPkgImpl<T extends Structure> extends LilyEObject implements DataProviderPkg<T>
{
	/**
	 * The cached value of the '{@link #getDataProviders() <em>Data Providers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<RenderDataProvider<T>> dataProviders;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataProviderPkgImpl()
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
		return RenderingPackage.Literals.DATA_PROVIDER_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RenderDataProvider<T>> getDataProviders()
	{
		if (dataProviders == null) {
			dataProviders = new EObjectContainmentEList<RenderDataProvider<T>>(RenderDataProvider.class, this, RenderingPackage.DATA_PROVIDER_PKG__DATA_PROVIDERS);
		}
		return dataProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case RenderingPackage.DATA_PROVIDER_PKG__DATA_PROVIDERS:
				return ((InternalEList<?>)getDataProviders()).basicRemove(otherEnd, msgs);
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
			case RenderingPackage.DATA_PROVIDER_PKG__DATA_PROVIDERS:
				return getDataProviders();
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
			case RenderingPackage.DATA_PROVIDER_PKG__DATA_PROVIDERS:
				getDataProviders().clear();
				getDataProviders().addAll((Collection<? extends RenderDataProvider<T>>)newValue);
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
			case RenderingPackage.DATA_PROVIDER_PKG__DATA_PROVIDERS:
				getDataProviders().clear();
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
			case RenderingPackage.DATA_PROVIDER_PKG__DATA_PROVIDERS:
				return dataProviders != null && !dataProviders.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataProviderPkgImpl
