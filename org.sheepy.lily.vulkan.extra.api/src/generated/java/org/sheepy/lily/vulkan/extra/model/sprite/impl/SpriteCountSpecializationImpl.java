/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.extra.model.rendering.impl.ISpecializationImpl;

import org.sheepy.lily.vulkan.extra.model.sprite.SpriteCountSpecialization;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Count Specialization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteCountSpecializationImpl#getProvider <em>Provider</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpriteCountSpecializationImpl extends ISpecializationImpl implements SpriteCountSpecialization
{
	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected SpriteMonoSamplerProvider provider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpriteCountSpecializationImpl()
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
		return SpritePackage.Literals.SPRITE_COUNT_SPECIALIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpriteMonoSamplerProvider getProvider()
	{
		if (provider != null && ((EObject)provider).eIsProxy())
		{
			InternalEObject oldProvider = (InternalEObject)provider;
			provider = (SpriteMonoSamplerProvider)eResolveProxy(oldProvider);
			if (provider != oldProvider)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpritePackage.SPRITE_COUNT_SPECIALIZATION__PROVIDER, oldProvider, provider));
			}
		}
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpriteMonoSamplerProvider basicGetProvider()
	{
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProvider(SpriteMonoSamplerProvider newProvider)
	{
		SpriteMonoSamplerProvider oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_COUNT_SPECIALIZATION__PROVIDER, oldProvider, provider));
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
			case SpritePackage.SPRITE_COUNT_SPECIALIZATION__PROVIDER:
				if (resolve) return getProvider();
				return basicGetProvider();
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
			case SpritePackage.SPRITE_COUNT_SPECIALIZATION__PROVIDER:
				setProvider((SpriteMonoSamplerProvider)newValue);
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
			case SpritePackage.SPRITE_COUNT_SPECIALIZATION__PROVIDER:
				setProvider((SpriteMonoSamplerProvider)null);
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
			case SpritePackage.SPRITE_COUNT_SPECIALIZATION__PROVIDER:
				return provider != null;
		}
		return super.eIsSet(featureID);
	}

} //SpriteCountSpecializationImpl
