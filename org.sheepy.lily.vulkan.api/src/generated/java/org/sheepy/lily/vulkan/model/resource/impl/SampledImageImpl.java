/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.model.resource.Sampler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sampled Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl#getSampler <em>Sampler</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SampledImageImpl extends BasicDescriptedResourceImpl implements SampledImage
{
	/**
	 * The cached value of the '{@link #getSampler() <em>Sampler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampler()
	 * @generated
	 * @ordered
	 */
	protected Sampler sampler;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampledImageImpl()
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
		return ResourcePackage.Literals.SAMPLED_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sampler getSampler()
	{
		return sampler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSampler(Sampler newSampler, NotificationChain msgs)
	{
		Sampler oldSampler = sampler;
		sampler = newSampler;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcePackage.SAMPLED_IMAGE__SAMPLER, oldSampler, newSampler);
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
	public void setSampler(Sampler newSampler)
	{
		if (newSampler != sampler)
		{
			NotificationChain msgs = null;
			if (sampler != null)
				msgs = ((InternalEObject)sampler).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.SAMPLED_IMAGE__SAMPLER, null, msgs);
			if (newSampler != null)
				msgs = ((InternalEObject)newSampler).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.SAMPLED_IMAGE__SAMPLER, null, msgs);
			msgs = basicSetSampler(newSampler, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.SAMPLED_IMAGE__SAMPLER, newSampler, newSampler));
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
			case ResourcePackage.SAMPLED_IMAGE__SAMPLER:
				return basicSetSampler(null, msgs);
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
			case ResourcePackage.SAMPLED_IMAGE__SAMPLER:
				return getSampler();
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
			case ResourcePackage.SAMPLED_IMAGE__SAMPLER:
				setSampler((Sampler)newValue);
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
			case ResourcePackage.SAMPLED_IMAGE__SAMPLER:
				setSampler((Sampler)null);
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
			case ResourcePackage.SAMPLED_IMAGE__SAMPLER:
				return sampler != null;
		}
		return super.eIsSet(featureID);
	}

} //SampledImageImpl
