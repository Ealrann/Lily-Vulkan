/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;
import org.sheepy.lily.vulkan.model.resource.Texture2DArrayDescriptor;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Texture2 DArray Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayDescriptorImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayDescriptorImpl#getShaderStages <em>Shader Stages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayDescriptorImpl#getTexture2DArray <em>Texture2 DArray</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Texture2DArrayDescriptorImpl extends LilyEObject implements Texture2DArrayDescriptor
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EDescriptorType TYPE_EDEFAULT = EDescriptorType.SAMPLER;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EDescriptorType type = TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getTexture2DArray() <em>Texture2 DArray</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTexture2DArray()
	 * @generated
	 * @ordered
	 */
	protected Texture2DArray texture2DArray;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Texture2DArrayDescriptorImpl()
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
		return ResourcePackage.Literals.TEXTURE2_DARRAY_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDescriptorType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EDescriptorType newType)
	{
		EDescriptorType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TYPE, oldType, type));
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
			shaderStages = new EDataTypeUniqueEList<EShaderStage>(EShaderStage.class, this, ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__SHADER_STAGES);
		}
		return shaderStages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Texture2DArray getTexture2DArray()
	{
		if (texture2DArray != null && ((EObject)texture2DArray).eIsProxy())
		{
			InternalEObject oldTexture2DArray = (InternalEObject)texture2DArray;
			texture2DArray = (Texture2DArray)eResolveProxy(oldTexture2DArray);
			if (texture2DArray != oldTexture2DArray)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE2_DARRAY, oldTexture2DArray, texture2DArray));
			}
		}
		return texture2DArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Texture2DArray basicGetTexture2DArray()
	{
		return texture2DArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTexture2DArray(Texture2DArray newTexture2DArray)
	{
		Texture2DArray oldTexture2DArray = texture2DArray;
		texture2DArray = newTexture2DArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE2_DARRAY, oldTexture2DArray, texture2DArray));
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
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__NAME:
				return getName();
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TYPE:
				return getType();
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__SHADER_STAGES:
				return getShaderStages();
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE2_DARRAY:
				if (resolve) return getTexture2DArray();
				return basicGetTexture2DArray();
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
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TYPE:
				setType((EDescriptorType)newValue);
				return;
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__SHADER_STAGES:
				getShaderStages().clear();
				getShaderStages().addAll((Collection<? extends EShaderStage>)newValue);
				return;
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE2_DARRAY:
				setTexture2DArray((Texture2DArray)newValue);
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
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__SHADER_STAGES:
				getShaderStages().clear();
				return;
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE2_DARRAY:
				setTexture2DArray((Texture2DArray)null);
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
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TYPE:
				return type != TYPE_EDEFAULT;
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__SHADER_STAGES:
				return shaderStages != null && !shaderStages.isEmpty();
			case ResourcePackage.TEXTURE2_DARRAY_DESCRIPTOR__TEXTURE2_DARRAY:
				return texture2DArray != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", shaderStages: ");
		result.append(shaderStages);
		result.append(')');
		return result.toString();
	}

} //Texture2DArrayDescriptorImpl
