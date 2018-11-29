/**
 */
package org.sheepy.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import org.sheepy.vulkan.model.resource.PushConstant;
import org.sheepy.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Push Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.PushConstantImpl#getDescriptorType <em>Descriptor Type</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.PushConstantImpl#getShaderStages <em>Shader Stages</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PushConstantImpl extends MinimalEObjectImpl.Container implements PushConstant
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PushConstantImpl()
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
		return ResourcePackage.Literals.PUSH_CONSTANT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.PUSH_CONSTANT__DESCRIPTOR_TYPE, oldDescriptorType, descriptorType));
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
			shaderStages = new EDataTypeEList<EShaderStage>(EShaderStage.class, this, ResourcePackage.PUSH_CONSTANT__SHADER_STAGES);
		}
		return shaderStages;
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
			case ResourcePackage.PUSH_CONSTANT__DESCRIPTOR_TYPE:
				return getDescriptorType();
			case ResourcePackage.PUSH_CONSTANT__SHADER_STAGES:
				return getShaderStages();
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
			case ResourcePackage.PUSH_CONSTANT__DESCRIPTOR_TYPE:
				setDescriptorType((EDescriptorType)newValue);
				return;
			case ResourcePackage.PUSH_CONSTANT__SHADER_STAGES:
				getShaderStages().clear();
				getShaderStages().addAll((Collection<? extends EShaderStage>)newValue);
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
			case ResourcePackage.PUSH_CONSTANT__DESCRIPTOR_TYPE:
				setDescriptorType(DESCRIPTOR_TYPE_EDEFAULT);
				return;
			case ResourcePackage.PUSH_CONSTANT__SHADER_STAGES:
				getShaderStages().clear();
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
			case ResourcePackage.PUSH_CONSTANT__DESCRIPTOR_TYPE:
				return descriptorType != DESCRIPTOR_TYPE_EDEFAULT;
			case ResourcePackage.PUSH_CONSTANT__SHADER_STAGES:
				return shaderStages != null && !shaderStages.isEmpty();
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

} //PushConstantImpl
