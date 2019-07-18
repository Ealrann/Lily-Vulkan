/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.vulkan.extra.model.rendering.GenericDescribedDataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.Descriptor;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Described Data Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericDescribedDataProviderImpl#getDescriptorType <em>Descriptor Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericDescribedDataProviderImpl#getShaderStages <em>Shader Stages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenericDescribedDataProviderImpl<T extends Presentation> extends GenericDataProviderImpl<T> implements GenericDescribedDataProvider<T>
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
	protected GenericDescribedDataProviderImpl()
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
		return RenderingPackage.Literals.GENERIC_DESCRIBED_DATA_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDescriptorType getDescriptorType()
	{
		return descriptorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorType(EDescriptorType newDescriptorType)
	{
		EDescriptorType oldDescriptorType = descriptorType;
		descriptorType = newDescriptorType == null ? DESCRIPTOR_TYPE_EDEFAULT : newDescriptorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__DESCRIPTOR_TYPE, oldDescriptorType, descriptorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EShaderStage> getShaderStages()
	{
		if (shaderStages == null)
		{
			shaderStages = new EDataTypeUniqueEList<EShaderStage>(EShaderStage.class, this, RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__SHADER_STAGES);
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
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__DESCRIPTOR_TYPE:
				return getDescriptorType();
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__SHADER_STAGES:
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
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__DESCRIPTOR_TYPE:
				setDescriptorType((EDescriptorType)newValue);
				return;
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__SHADER_STAGES:
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
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__DESCRIPTOR_TYPE:
				setDescriptorType(DESCRIPTOR_TYPE_EDEFAULT);
				return;
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__SHADER_STAGES:
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
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__DESCRIPTOR_TYPE:
				return descriptorType != DESCRIPTOR_TYPE_EDEFAULT;
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__SHADER_STAGES:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Descriptor.class)
		{
			switch (derivedFeatureID)
			{
				case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__DESCRIPTOR_TYPE: return ResourcePackage.DESCRIPTOR__DESCRIPTOR_TYPE;
				case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__SHADER_STAGES: return ResourcePackage.DESCRIPTOR__SHADER_STAGES;
				default: return -1;
			}
		}
		if (baseClass == DescribedDataProvider.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == Descriptor.class)
		{
			switch (baseFeatureID)
			{
				case ResourcePackage.DESCRIPTOR__DESCRIPTOR_TYPE: return RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__DESCRIPTOR_TYPE;
				case ResourcePackage.DESCRIPTOR__SHADER_STAGES: return RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER__SHADER_STAGES;
				default: return -1;
			}
		}
		if (baseClass == DescribedDataProvider.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //GenericDescribedDataProviderImpl
