/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.enumeration.EBindPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bind Descriptor Sets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl#getDescriptorSets <em>Descriptor Sets</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl#getBindPoint <em>Bind Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindDescriptorSetsImpl extends LilyEObject implements BindDescriptorSets
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
	 * The cached value of the '{@link #getDescriptorSets() <em>Descriptor Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSets()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptorSet> descriptorSets;

	/**
	 * The default value of the '{@link #getBindPoint() <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindPoint()
	 * @generated
	 * @ordered
	 */
	protected static final EBindPoint BIND_POINT_EDEFAULT = EBindPoint.GRAPHICS;

	/**
	 * The cached value of the '{@link #getBindPoint() <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindPoint()
	 * @generated
	 * @ordered
	 */
	protected EBindPoint bindPoint = BIND_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindDescriptorSetsImpl()
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
		return ProcessPackage.Literals.BIND_DESCRIPTOR_SETS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.BIND_DESCRIPTOR_SETS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.BIND_DESCRIPTOR_SETS__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DescriptorSet> getDescriptorSets()
	{
		if (descriptorSets == null)
		{
			descriptorSets = new EObjectResolvingEList<DescriptorSet>(DescriptorSet.class, this, ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS);
		}
		return descriptorSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBindPoint getBindPoint()
	{
		return bindPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBindPoint(EBindPoint newBindPoint)
	{
		EBindPoint oldBindPoint = bindPoint;
		bindPoint = newBindPoint == null ? BIND_POINT_EDEFAULT : newBindPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.BIND_DESCRIPTOR_SETS__BIND_POINT, oldBindPoint, bindPoint));
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
			case ProcessPackage.BIND_DESCRIPTOR_SETS__NAME:
				return getName();
			case ProcessPackage.BIND_DESCRIPTOR_SETS__ENABLED:
				return isEnabled();
			case ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS:
				return getDescriptorSets();
			case ProcessPackage.BIND_DESCRIPTOR_SETS__BIND_POINT:
				return getBindPoint();
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
			case ProcessPackage.BIND_DESCRIPTOR_SETS__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.BIND_DESCRIPTOR_SETS__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS:
				getDescriptorSets().clear();
				getDescriptorSets().addAll((Collection<? extends DescriptorSet>)newValue);
				return;
			case ProcessPackage.BIND_DESCRIPTOR_SETS__BIND_POINT:
				setBindPoint((EBindPoint)newValue);
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
			case ProcessPackage.BIND_DESCRIPTOR_SETS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.BIND_DESCRIPTOR_SETS__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS:
				getDescriptorSets().clear();
				return;
			case ProcessPackage.BIND_DESCRIPTOR_SETS__BIND_POINT:
				setBindPoint(BIND_POINT_EDEFAULT);
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
			case ProcessPackage.BIND_DESCRIPTOR_SETS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.BIND_DESCRIPTOR_SETS__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.BIND_DESCRIPTOR_SETS__DESCRIPTOR_SETS:
				return descriptorSets != null && !descriptorSets.isEmpty();
			case ProcessPackage.BIND_DESCRIPTOR_SETS__BIND_POINT:
				return bindPoint != BIND_POINT_EDEFAULT;
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
		result.append(", bindPoint: ");
		result.append(bindPoint);
		result.append(')');
		return result.toString();
	}

} //BindDescriptorSetsImpl
