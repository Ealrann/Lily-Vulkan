/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.resource.impl.IResourceImpl;

import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import org.sheepy.vulkan.model.image.SamplerInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sampled Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl#getSampler <em>Sampler</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SampledImageImpl#getImage <em>Image</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SampledImageImpl extends IResourceImpl implements SampledImage
{
	/**
	 * The cached value of the '{@link #getSampler() <em>Sampler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampler()
	 * @generated
	 * @ordered
	 */
	protected SamplerInfo sampler;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected Image image;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SampledImageImpl()
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
		return VulkanResourcePackage.Literals.SAMPLED_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SamplerInfo getSampler()
	{
		return sampler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSampler(SamplerInfo newSampler, NotificationChain msgs)
	{
		SamplerInfo oldSampler = sampler;
		sampler = newSampler;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER, oldSampler, newSampler);
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
	public void setSampler(SamplerInfo newSampler)
	{
		if (newSampler != sampler)
		{
			NotificationChain msgs = null;
			if (sampler != null)
				msgs = ((InternalEObject)sampler).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER, null, msgs);
			if (newSampler != null)
				msgs = ((InternalEObject)newSampler).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER, null, msgs);
			msgs = basicSetSampler(newSampler, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER, newSampler, newSampler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Image getImage()
	{
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImage(Image newImage, NotificationChain msgs)
	{
		Image oldImage = image;
		image = newImage;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.SAMPLED_IMAGE__IMAGE, oldImage, newImage);
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
	public void setImage(Image newImage)
	{
		if (newImage != image)
		{
			NotificationChain msgs = null;
			if (image != null)
				msgs = ((InternalEObject)image).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.SAMPLED_IMAGE__IMAGE, null, msgs);
			if (newImage != null)
				msgs = ((InternalEObject)newImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.SAMPLED_IMAGE__IMAGE, null, msgs);
			msgs = basicSetImage(newImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.SAMPLED_IMAGE__IMAGE, newImage, newImage));
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
			case VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER:
				return basicSetSampler(null, msgs);
			case VulkanResourcePackage.SAMPLED_IMAGE__IMAGE:
				return basicSetImage(null, msgs);
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
			case VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER:
				return getSampler();
			case VulkanResourcePackage.SAMPLED_IMAGE__IMAGE:
				return getImage();
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
			case VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER:
				setSampler((SamplerInfo)newValue);
				return;
			case VulkanResourcePackage.SAMPLED_IMAGE__IMAGE:
				setImage((Image)newValue);
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
			case VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER:
				setSampler((SamplerInfo)null);
				return;
			case VulkanResourcePackage.SAMPLED_IMAGE__IMAGE:
				setImage((Image)null);
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
			case VulkanResourcePackage.SAMPLED_IMAGE__SAMPLER:
				return sampler != null;
			case VulkanResourcePackage.SAMPLED_IMAGE__IMAGE:
				return image != null;
		}
		return super.eIsSet(featureID);
	}

} //SampledImageImpl
