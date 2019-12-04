/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.process.CompositePartReference;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Part Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CompositePartReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CompositePartReferenceImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CompositePartReferenceImpl#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositePartReferenceImpl extends LilyEObject implements CompositePartReference
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
	 * The default value of the '{@link #getPart() <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected static final int PART_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected int part = PART_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstance() <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTANCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected int instance = INSTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositePartReferenceImpl()
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
		return ProcessPackage.Literals.COMPOSITE_PART_REFERENCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSITE_PART_REFERENCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPart()
	{
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPart(int newPart)
	{
		int oldPart = part;
		part = newPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSITE_PART_REFERENCE__PART, oldPart, part));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInstance()
	{
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstance(int newInstance)
	{
		int oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSITE_PART_REFERENCE__INSTANCE, oldInstance, instance));
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
			case ProcessPackage.COMPOSITE_PART_REFERENCE__NAME:
				return getName();
			case ProcessPackage.COMPOSITE_PART_REFERENCE__PART:
				return getPart();
			case ProcessPackage.COMPOSITE_PART_REFERENCE__INSTANCE:
				return getInstance();
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
			case ProcessPackage.COMPOSITE_PART_REFERENCE__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.COMPOSITE_PART_REFERENCE__PART:
				setPart((Integer)newValue);
				return;
			case ProcessPackage.COMPOSITE_PART_REFERENCE__INSTANCE:
				setInstance((Integer)newValue);
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
			case ProcessPackage.COMPOSITE_PART_REFERENCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.COMPOSITE_PART_REFERENCE__PART:
				setPart(PART_EDEFAULT);
				return;
			case ProcessPackage.COMPOSITE_PART_REFERENCE__INSTANCE:
				setInstance(INSTANCE_EDEFAULT);
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
			case ProcessPackage.COMPOSITE_PART_REFERENCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.COMPOSITE_PART_REFERENCE__PART:
				return part != PART_EDEFAULT;
			case ProcessPackage.COMPOSITE_PART_REFERENCE__INSTANCE:
				return instance != INSTANCE_EDEFAULT;
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
		result.append(", part: ");
		result.append(part);
		result.append(", instance: ");
		result.append(instance);
		result.append(')');
		return result.toString();
	}

} //CompositePartReferenceImpl
