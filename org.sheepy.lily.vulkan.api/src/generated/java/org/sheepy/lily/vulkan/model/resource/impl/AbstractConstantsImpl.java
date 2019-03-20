/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;

import org.sheepy.lily.vulkan.model.resource.AbstractConstants;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Constants</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractConstantsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.AbstractConstantsImpl#getStages <em>Stages</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractConstantsImpl extends MinimalEObjectImpl.Container
		implements AbstractConstants
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
	 * The cached value of the '{@link #getStages() <em>Stages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStages()
	 * @generated
	 * @ordered
	 */
	protected EList<EShaderStage> stages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractConstantsImpl()
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
		return ResourcePackage.Literals.ABSTRACT_CONSTANTS;
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.ABSTRACT_CONSTANTS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EShaderStage> getStages()
	{
		if (stages == null)
		{
			stages = new EDataTypeUniqueEList<EShaderStage>(EShaderStage.class, this,
					ResourcePackage.ABSTRACT_CONSTANTS__STAGES);
		}
		return stages;
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
		case ResourcePackage.ABSTRACT_CONSTANTS__NAME:
			return getName();
		case ResourcePackage.ABSTRACT_CONSTANTS__STAGES:
			return getStages();
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
		case ResourcePackage.ABSTRACT_CONSTANTS__NAME:
			setName((String) newValue);
			return;
		case ResourcePackage.ABSTRACT_CONSTANTS__STAGES:
			getStages().clear();
			getStages().addAll((Collection<? extends EShaderStage>) newValue);
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
		case ResourcePackage.ABSTRACT_CONSTANTS__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ResourcePackage.ABSTRACT_CONSTANTS__STAGES:
			getStages().clear();
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
		case ResourcePackage.ABSTRACT_CONSTANTS__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ResourcePackage.ABSTRACT_CONSTANTS__STAGES:
			return stages != null && !stages.isEmpty();
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
		result.append(", stages: ");
		result.append(stages);
		result.append(')');
		return result.toString();
	}

} //AbstractConstantsImpl
