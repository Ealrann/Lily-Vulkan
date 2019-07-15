/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

import org.sheepy.vulkan.model.barrier.impl.AbstractBufferBarrierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferBarrierImpl#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferBarrierImpl extends AbstractBufferBarrierImpl implements BufferBarrier
{
	/**
	 * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffer()
	 * @generated
	 * @ordered
	 */
	protected Buffer buffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferBarrierImpl()
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
		return ResourcePackage.Literals.BUFFER_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getBuffer()
	{
		if (buffer != null && buffer.eIsProxy())
		{
			InternalEObject oldBuffer = (InternalEObject) buffer;
			buffer = (Buffer) eResolveProxy(oldBuffer);
			if (buffer != oldBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ResourcePackage.BUFFER_BARRIER__BUFFER, oldBuffer, buffer));
			}
		}
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer basicGetBuffer()
	{
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuffer(Buffer newBuffer)
	{
		Buffer oldBuffer = buffer;
		buffer = newBuffer;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.BUFFER_BARRIER__BUFFER, oldBuffer, buffer));
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
		case ResourcePackage.BUFFER_BARRIER__BUFFER:
			if (resolve) return getBuffer();
			return basicGetBuffer();
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
		case ResourcePackage.BUFFER_BARRIER__BUFFER:
			setBuffer((Buffer) newValue);
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
		case ResourcePackage.BUFFER_BARRIER__BUFFER:
			setBuffer((Buffer) null);
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
		case ResourcePackage.BUFFER_BARRIER__BUFFER:
			return buffer != null;
		}
		return super.eIsSet(featureID);
	}

} //BufferBarrierImpl
