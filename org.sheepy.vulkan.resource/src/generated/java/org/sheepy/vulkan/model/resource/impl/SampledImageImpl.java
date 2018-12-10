/**
 */
package org.sheepy.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import org.sheepy.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.resource.SampledImage;
import org.sheepy.vulkan.model.resource.Sampler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sampled Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.SampledImageImpl#getDescriptorType <em>Descriptor Type</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.SampledImageImpl#getShaderStages <em>Shader Stages</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.SampledImageImpl#getSampler <em>Sampler</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SampledImageImpl extends MinimalEObjectImpl.Container implements SampledImage
{
	/**
	 * The default value of the '{@link #getDescriptorType() <em>Descriptor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorType()
	 * @generated
	 * @ordered
	 */
	protected static final EDescriptorType DESCRIPTOR_TYPE_EDEFAULT = EDescriptorType.SAMPLER;

	/**
	 * The cached value of the '{@link #getDescriptorType() <em>Descriptor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorType()
	 * @generated
	 * @ordered
	 */
	protected EDescriptorType descriptorType = DESCRIPTOR_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getShaderStages() <em>Shader Stages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaderStages()
	 * @generated
	 * @ordered
	 */
	protected EList<EShaderStage> shaderStages;

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
	public EDescriptorType getDescriptorType()
	{
		return descriptorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptorType(EDescriptorType newDescriptorType)
	{
		EDescriptorType oldDescriptorType = descriptorType;
		descriptorType = newDescriptorType == null ? DESCRIPTOR_TYPE_EDEFAULT : newDescriptorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.SAMPLED_IMAGE__DESCRIPTOR_TYPE, oldDescriptorType, descriptorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EShaderStage> getShaderStages()
	{
		if (shaderStages == null)
		{
			shaderStages = new EDataTypeEList<EShaderStage>(EShaderStage.class, this, ResourcePackage.SAMPLED_IMAGE__SHADER_STAGES);
		}
		return shaderStages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			case ResourcePackage.SAMPLED_IMAGE__DESCRIPTOR_TYPE:
				return getDescriptorType();
			case ResourcePackage.SAMPLED_IMAGE__SHADER_STAGES:
				return getShaderStages();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ResourcePackage.SAMPLED_IMAGE__DESCRIPTOR_TYPE:
				setDescriptorType((EDescriptorType)newValue);
				return;
			case ResourcePackage.SAMPLED_IMAGE__SHADER_STAGES:
				getShaderStages().clear();
				getShaderStages().addAll((Collection<? extends EShaderStage>)newValue);
				return;
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
			case ResourcePackage.SAMPLED_IMAGE__DESCRIPTOR_TYPE:
				setDescriptorType(DESCRIPTOR_TYPE_EDEFAULT);
				return;
			case ResourcePackage.SAMPLED_IMAGE__SHADER_STAGES:
				getShaderStages().clear();
				return;
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
			case ResourcePackage.SAMPLED_IMAGE__DESCRIPTOR_TYPE:
				return descriptorType != DESCRIPTOR_TYPE_EDEFAULT;
			case ResourcePackage.SAMPLED_IMAGE__SHADER_STAGES:
				return shaderStages != null && !shaderStages.isEmpty();
			case ResourcePackage.SAMPLED_IMAGE__SAMPLER:
				return sampler != null;
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
		result.append(" (descriptorType: ");
		result.append(descriptorType);
		result.append(", shaderStages: ");
		result.append(shaderStages);
		result.append(')');
		return result.toString();
	}

} //SampledResourceImpl
