/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ReferenceBufferBarrierImpl#getBufferAddress <em>Buffer Address</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceBufferBarrierImpl extends AbstractBufferBarrierImpl
		implements ReferenceBufferBarrier
{
	/**
	 * The default value of the '{@link #getBufferAddress() <em>Buffer Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferAddress()
	 * @generated
	 * @ordered
	 */
	protected static final long BUFFER_ADDRESS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBufferAddress() <em>Buffer Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferAddress()
	 * @generated
	 * @ordered
	 */
	protected long bufferAddress = BUFFER_ADDRESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceBufferBarrierImpl()
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
		return BarrierPackage.Literals.REFERENCE_BUFFER_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getBufferAddress()
	{
		return bufferAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBufferAddress(long newBufferAddress)
	{
		long oldBufferAddress = bufferAddress;
		bufferAddress = newBufferAddress;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_ADDRESS, oldBufferAddress,
				bufferAddress));
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
		case BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_ADDRESS:
			return getBufferAddress();
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
		case BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_ADDRESS:
			setBufferAddress((Long) newValue);
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
		case BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_ADDRESS:
			setBufferAddress(BUFFER_ADDRESS_EDEFAULT);
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
		case BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_ADDRESS:
			return bufferAddress != BUFFER_ADDRESS_EDEFAULT;
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
		result.append(" (bufferAddress: ");
		result.append(bufferAddress);
		result.append(')');
		return result.toString();
	}

} //ReferenceBufferBarrierImpl
