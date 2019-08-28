/**
 */
package org.sheepy.vulkan.model.pipeline.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.vulkan.model.pipeline.PipelinePackage;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialization Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.impl.SpecializationConstantImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.impl.SpecializationConstantImpl#getConstantId <em>Constant Id</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.impl.SpecializationConstantImpl#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecializationConstantImpl extends LilyEObject implements SpecializationConstant
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
	 * The default value of the '{@link #getConstantId() <em>Constant Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantId()
	 * @generated
	 * @ordered
	 */
	protected static final int CONSTANT_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getConstantId() <em>Constant Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantId()
	 * @generated
	 * @ordered
	 */
	protected int constantId = CONSTANT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecializationConstantImpl()
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
		return PipelinePackage.Literals.SPECIALIZATION_CONSTANT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PipelinePackage.SPECIALIZATION_CONSTANT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getConstantId()
	{
		return constantId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantId(int newConstantId)
	{
		int oldConstantId = constantId;
		constantId = newConstantId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PipelinePackage.SPECIALIZATION_CONSTANT__CONSTANT_ID, oldConstantId, constantId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(int newSize)
	{
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PipelinePackage.SPECIALIZATION_CONSTANT__SIZE, oldSize, size));
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
			case PipelinePackage.SPECIALIZATION_CONSTANT__NAME:
				return getName();
			case PipelinePackage.SPECIALIZATION_CONSTANT__CONSTANT_ID:
				return getConstantId();
			case PipelinePackage.SPECIALIZATION_CONSTANT__SIZE:
				return getSize();
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
			case PipelinePackage.SPECIALIZATION_CONSTANT__NAME:
				setName((String)newValue);
				return;
			case PipelinePackage.SPECIALIZATION_CONSTANT__CONSTANT_ID:
				setConstantId((Integer)newValue);
				return;
			case PipelinePackage.SPECIALIZATION_CONSTANT__SIZE:
				setSize((Integer)newValue);
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
			case PipelinePackage.SPECIALIZATION_CONSTANT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PipelinePackage.SPECIALIZATION_CONSTANT__CONSTANT_ID:
				setConstantId(CONSTANT_ID_EDEFAULT);
				return;
			case PipelinePackage.SPECIALIZATION_CONSTANT__SIZE:
				setSize(SIZE_EDEFAULT);
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
			case PipelinePackage.SPECIALIZATION_CONSTANT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PipelinePackage.SPECIALIZATION_CONSTANT__CONSTANT_ID:
				return constantId != CONSTANT_ID_EDEFAULT;
			case PipelinePackage.SPECIALIZATION_CONSTANT__SIZE:
				return size != SIZE_EDEFAULT;
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
		result.append(", constantId: ");
		result.append(constantId);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //SpecializationConstantImpl
