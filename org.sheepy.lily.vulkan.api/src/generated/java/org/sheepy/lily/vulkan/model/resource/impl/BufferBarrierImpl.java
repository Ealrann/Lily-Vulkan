/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

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
	protected IBuffer buffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferBarrierImpl()
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
		return VulkanResourcePackage.Literals.BUFFER_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IBuffer getBuffer()
	{
		if (buffer != null && ((EObject)buffer).eIsProxy())
		{
			InternalEObject oldBuffer = (InternalEObject)buffer;
			buffer = (IBuffer)eResolveProxy(oldBuffer);
			if (buffer != oldBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VulkanResourcePackage.BUFFER_BARRIER__BUFFER, oldBuffer, buffer));
			}
		}
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBuffer basicGetBuffer()
	{
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuffer(IBuffer newBuffer)
	{
		IBuffer oldBuffer = buffer;
		buffer = newBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_BARRIER__BUFFER, oldBuffer, buffer));
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
			case VulkanResourcePackage.BUFFER_BARRIER__BUFFER:
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
			case VulkanResourcePackage.BUFFER_BARRIER__BUFFER:
				setBuffer((IBuffer)newValue);
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
			case VulkanResourcePackage.BUFFER_BARRIER__BUFFER:
				setBuffer((IBuffer)null);
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
			case VulkanResourcePackage.BUFFER_BARRIER__BUFFER:
				return buffer != null;
		}
		return super.eIsSet(featureID);
	}

} //BufferBarrierImpl
