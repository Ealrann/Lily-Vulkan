/**
 */
package org.sheepy.vulkan.model.process.compute.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputerBufferBarrier;

import org.sheepy.vulkan.model.resource.BufferBarrier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computer Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.compute.impl.ComputerBufferBarrierImpl#getBufferBarrier <em>Buffer Barrier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputerBufferBarrierImpl extends MinimalEObjectImpl.Container implements ComputerBufferBarrier
{
	/**
	 * The cached value of the '{@link #getBufferBarrier() <em>Buffer Barrier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferBarrier()
	 * @generated
	 * @ordered
	 */
	protected BufferBarrier bufferBarrier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputerBufferBarrierImpl()
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
		return ComputePackage.Literals.COMPUTER_BUFFER_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferBarrier getBufferBarrier()
	{
		return bufferBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBufferBarrier(BufferBarrier newBufferBarrier, NotificationChain msgs)
	{
		BufferBarrier oldBufferBarrier = bufferBarrier;
		bufferBarrier = newBufferBarrier;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER, oldBufferBarrier, newBufferBarrier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBufferBarrier(BufferBarrier newBufferBarrier)
	{
		if (newBufferBarrier != bufferBarrier)
		{
			NotificationChain msgs = null;
			if (bufferBarrier != null)
				msgs = ((InternalEObject)bufferBarrier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER, null, msgs);
			if (newBufferBarrier != null)
				msgs = ((InternalEObject)newBufferBarrier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER, null, msgs);
			msgs = basicSetBufferBarrier(newBufferBarrier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER, newBufferBarrier, newBufferBarrier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER:
				return basicSetBufferBarrier(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER:
				return getBufferBarrier();
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
			case ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER:
				setBufferBarrier((BufferBarrier)newValue);
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
			case ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER:
				setBufferBarrier((BufferBarrier)null);
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
			case ComputePackage.COMPUTER_BUFFER_BARRIER__BUFFER_BARRIER:
				return bufferBarrier != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputerBufferBarrierImpl
