/**
 */
package org.sheepy.lily.openal.model.openal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.openal.model.openal.OpenALEngine;
import org.sheepy.lily.openal.model.openal.OpenalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open AL Engine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.openal.model.openal.impl.OpenALEngineImpl#getResourcePkg <em>Resource Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OpenALEngineImpl extends LilyEObject implements OpenALEngine
{
	/**
	 * The cached value of the '{@link #getResourcePkg() <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcePkg()
	 * @generated
	 * @ordered
	 */
	protected org.sheepy.lily.core.model.resource.ResourcePkg resourcePkg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpenALEngineImpl()
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
		return OpenalPackage.Literals.OPEN_AL_ENGINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.sheepy.lily.core.model.resource.ResourcePkg getResourcePkg()
	{
		if (resourcePkg != null && ((EObject)resourcePkg).eIsProxy())
		{
			InternalEObject oldResourcePkg = resourcePkg;
			resourcePkg = (org.sheepy.lily.core.model.resource.ResourcePkg)eResolveProxy(oldResourcePkg);
			if (resourcePkg != oldResourcePkg)
			{
				InternalEObject newResourcePkg = resourcePkg;
				NotificationChain msgs = oldResourcePkg.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG, null, null);
				if (newResourcePkg.eInternalContainer() == null)
				{
					msgs = newResourcePkg.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG, oldResourcePkg, resourcePkg));
			}
		}
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.sheepy.lily.core.model.resource.ResourcePkg basicGetResourcePkg()
	{
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourcePkg(org.sheepy.lily.core.model.resource.ResourcePkg newResourcePkg, NotificationChain msgs)
	{
		org.sheepy.lily.core.model.resource.ResourcePkg oldResourcePkg = resourcePkg;
		resourcePkg = newResourcePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
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
	public void setResourcePkg(org.sheepy.lily.core.model.resource.ResourcePkg newResourcePkg)
	{
		if (newResourcePkg != resourcePkg)
		{
			NotificationChain msgs = null;
			if (resourcePkg != null)
				msgs = ((InternalEObject)resourcePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG, null, msgs);
			if (newResourcePkg != null)
				msgs = ((InternalEObject)newResourcePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG, null, msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG, newResourcePkg, newResourcePkg));
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
			case OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG:
				return basicSetResourcePkg(null, msgs);
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
			case OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG:
				if (resolve) return getResourcePkg();
				return basicGetResourcePkg();
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
			case OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG:
				setResourcePkg((org.sheepy.lily.core.model.resource.ResourcePkg)newValue);
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
			case OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG:
				setResourcePkg((org.sheepy.lily.core.model.resource.ResourcePkg)null);
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
			case OpenalPackage.OPEN_AL_ENGINE__RESOURCE_PKG:
				return resourcePkg != null;
		}
		return super.eIsSet(featureID);
	}

} //OpenALEngineImpl
