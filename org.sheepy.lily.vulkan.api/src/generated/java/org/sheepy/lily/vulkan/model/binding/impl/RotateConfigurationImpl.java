/**
 */
package org.sheepy.lily.vulkan.model.binding.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.IContextConfiguration;
import org.sheepy.lily.vulkan.model.binding.RotateConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rotate Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.RotateConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.RotateConfigurationImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.RotateConfigurationImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.RotateConfigurationImpl#isForceRecord <em>Force Record</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RotateConfigurationImpl extends LilyEObject implements RotateConfiguration
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
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<IContextConfiguration> configurations;

	/**
	 * The default value of the '{@link #isForceRecord() <em>Force Record</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForceRecord()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FORCE_RECORD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isForceRecord() <em>Force Record</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForceRecord()
	 * @generated
	 * @ordered
	 */
	protected boolean forceRecord = FORCE_RECORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RotateConfigurationImpl()
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
		return BindingPackage.Literals.ROTATE_CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.ROTATE_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.ROTATE_CONFIGURATION__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IContextConfiguration> getConfigurations()
	{
		if (configurations == null)
		{
			configurations = new EObjectResolvingEList<IContextConfiguration>(IContextConfiguration.class, this, BindingPackage.ROTATE_CONFIGURATION__CONFIGURATIONS);
		}
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isForceRecord()
	{
		return forceRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForceRecord(boolean newForceRecord)
	{
		boolean oldForceRecord = forceRecord;
		forceRecord = newForceRecord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.ROTATE_CONFIGURATION__FORCE_RECORD, oldForceRecord, forceRecord));
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
			case BindingPackage.ROTATE_CONFIGURATION__NAME:
				return getName();
			case BindingPackage.ROTATE_CONFIGURATION__ENABLED:
				return isEnabled();
			case BindingPackage.ROTATE_CONFIGURATION__CONFIGURATIONS:
				return getConfigurations();
			case BindingPackage.ROTATE_CONFIGURATION__FORCE_RECORD:
				return isForceRecord();
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
			case BindingPackage.ROTATE_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case BindingPackage.ROTATE_CONFIGURATION__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case BindingPackage.ROTATE_CONFIGURATION__CONFIGURATIONS:
				getConfigurations().clear();
				getConfigurations().addAll((Collection<? extends IContextConfiguration>)newValue);
				return;
			case BindingPackage.ROTATE_CONFIGURATION__FORCE_RECORD:
				setForceRecord((Boolean)newValue);
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
			case BindingPackage.ROTATE_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BindingPackage.ROTATE_CONFIGURATION__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case BindingPackage.ROTATE_CONFIGURATION__CONFIGURATIONS:
				getConfigurations().clear();
				return;
			case BindingPackage.ROTATE_CONFIGURATION__FORCE_RECORD:
				setForceRecord(FORCE_RECORD_EDEFAULT);
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
			case BindingPackage.ROTATE_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BindingPackage.ROTATE_CONFIGURATION__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case BindingPackage.ROTATE_CONFIGURATION__CONFIGURATIONS:
				return configurations != null && !configurations.isEmpty();
			case BindingPackage.ROTATE_CONFIGURATION__FORCE_RECORD:
				return forceRecord != FORCE_RECORD_EDEFAULT;
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
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", forceRecord: ");
		result.append(forceRecord);
		result.append(')');
		return result.toString();
	}

} //RotateConfigurationImpl
