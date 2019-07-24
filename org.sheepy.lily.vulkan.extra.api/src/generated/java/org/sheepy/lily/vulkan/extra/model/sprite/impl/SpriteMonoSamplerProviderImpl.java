/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.extra.model.sprite.SpriteMonoSamplerProvider;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;

import org.sheepy.vulkan.model.image.SamplerInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mono Sampler Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteMonoSamplerProviderImpl#getSamplerInfo <em>Sampler Info</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteMonoSamplerProviderImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteMonoSamplerProviderImpl#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpriteMonoSamplerProviderImpl extends MinimalEObjectImpl.Container implements SpriteMonoSamplerProvider
{
	/**
	 * The cached value of the '{@link #getSamplerInfo() <em>Sampler Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSamplerInfo()
	 * @generated
	 * @ordered
	 */
	protected SamplerInfo samplerInfo;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpriteMonoSamplerProviderImpl()
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
		return SpritePackage.Literals.SPRITE_MONO_SAMPLER_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SamplerInfo getSamplerInfo()
	{
		return samplerInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSamplerInfo(SamplerInfo newSamplerInfo, NotificationChain msgs)
	{
		SamplerInfo oldSamplerInfo = samplerInfo;
		samplerInfo = newSamplerInfo;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO, oldSamplerInfo, newSamplerInfo);
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
	public void setSamplerInfo(SamplerInfo newSamplerInfo)
	{
		if (newSamplerInfo != samplerInfo)
		{
			NotificationChain msgs = null;
			if (samplerInfo != null)
				msgs = ((InternalEObject)samplerInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO, null, msgs);
			if (newSamplerInfo != null)
				msgs = ((InternalEObject)newSamplerInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO, null, msgs);
			msgs = basicSetSamplerInfo(newSamplerInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO, newSamplerInfo, newSamplerInfo));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__HEIGHT, oldHeight, height));
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
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO:
				return basicSetSamplerInfo(null, msgs);
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
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO:
				return getSamplerInfo();
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__WIDTH:
				return getWidth();
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__HEIGHT:
				return getHeight();
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
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO:
				setSamplerInfo((SamplerInfo)newValue);
				return;
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__WIDTH:
				setWidth((Integer)newValue);
				return;
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__HEIGHT:
				setHeight((Integer)newValue);
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
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO:
				setSamplerInfo((SamplerInfo)null);
				return;
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
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
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__SAMPLER_INFO:
				return samplerInfo != null;
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__WIDTH:
				return width != WIDTH_EDEFAULT;
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER__HEIGHT:
				return height != HEIGHT_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //SpriteMonoSamplerProviderImpl
