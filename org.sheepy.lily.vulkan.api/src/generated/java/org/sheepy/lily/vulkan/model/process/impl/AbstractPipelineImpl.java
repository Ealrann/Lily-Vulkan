/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#isAllocate <em>Allocate</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractPipelineImpl#isRecord <em>Record</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractPipelineImpl extends LilyEObject implements AbstractPipeline
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
	 * The default value of the '{@link #isAllocate() <em>Allocate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllocate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOCATE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAllocate() <em>Allocate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllocate()
	 * @generated
	 * @ordered
	 */
	protected boolean allocate = ALLOCATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isRecord() <em>Record</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecord()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RECORD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRecord() <em>Record</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecord()
	 * @generated
	 * @ordered
	 */
	protected boolean record = RECORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractPipelineImpl()
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
		return ProcessPackage.Literals.ABSTRACT_PIPELINE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PIPELINE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAllocate()
	{
		return allocate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllocate(boolean newAllocate)
	{
		boolean oldAllocate = allocate;
		allocate = newAllocate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PIPELINE__ALLOCATE, oldAllocate, allocate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRecord()
	{
		return record;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecord(boolean newRecord)
	{
		boolean oldRecord = record;
		record = newRecord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PIPELINE__RECORD, oldRecord, record));
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
			case ProcessPackage.ABSTRACT_PIPELINE__NAME:
				return getName();
			case ProcessPackage.ABSTRACT_PIPELINE__ALLOCATE:
				return isAllocate();
			case ProcessPackage.ABSTRACT_PIPELINE__RECORD:
				return isRecord();
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
			case ProcessPackage.ABSTRACT_PIPELINE__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__ALLOCATE:
				setAllocate((Boolean)newValue);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__RECORD:
				setRecord((Boolean)newValue);
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
			case ProcessPackage.ABSTRACT_PIPELINE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__ALLOCATE:
				setAllocate(ALLOCATE_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__RECORD:
				setRecord(RECORD_EDEFAULT);
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
			case ProcessPackage.ABSTRACT_PIPELINE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.ABSTRACT_PIPELINE__ALLOCATE:
				return allocate != ALLOCATE_EDEFAULT;
			case ProcessPackage.ABSTRACT_PIPELINE__RECORD:
				return record != RECORD_EDEFAULT;
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
		result.append(", allocate: ");
		result.append(allocate);
		result.append(", record: ");
		result.append(record);
		result.append(')');
		return result.toString();
	}

} //AbstractPipelineImpl
