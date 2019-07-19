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
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ReferenceBufferBarrierImpl#getBufferPtr <em>Buffer Ptr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceBufferBarrierImpl extends AbstractBufferBarrierImpl implements ReferenceBufferBarrier
{
	/**
	 * The default value of the '{@link #getBufferPtr() <em>Buffer Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferPtr()
	 * @generated
	 * @ordered
	 */
	protected static final long BUFFER_PTR_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBufferPtr() <em>Buffer Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferPtr()
	 * @generated
	 * @ordered
	 */
	protected long bufferPtr = BUFFER_PTR_EDEFAULT;

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
	public long getBufferPtr()
	{
		return bufferPtr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBufferPtr(long newBufferPtr)
	{
		long oldBufferPtr = bufferPtr;
		bufferPtr = newBufferPtr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_PTR, oldBufferPtr, bufferPtr));
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
			case BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_PTR:
				return getBufferPtr();
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
			case BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_PTR:
				setBufferPtr((Long)newValue);
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
			case BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_PTR:
				setBufferPtr(BUFFER_PTR_EDEFAULT);
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
			case BarrierPackage.REFERENCE_BUFFER_BARRIER__BUFFER_PTR:
				return bufferPtr != BUFFER_PTR_EDEFAULT;
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
		result.append(" (bufferPtr: ");
		result.append(bufferPtr);
		result.append(')');
		return result.toString();
	}

} //ReferenceBufferBarrierImpl
