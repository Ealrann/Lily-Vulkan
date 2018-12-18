/**
 */
package org.sheepy.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.BufferBarrier;
import org.sheepy.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferBarrierImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferBarrierImpl#getSrcAccess <em>Src Access</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferBarrierImpl#getDstAccess <em>Dst Access</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferBarrierImpl extends BarrierImpl implements BufferBarrier
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
	 * The default value of the '{@link #getSrcAccess() <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccess()
	 * @generated
	 * @ordered
	 */
	protected static final int SRC_ACCESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSrcAccess() <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccess()
	 * @generated
	 * @ordered
	 */
	protected int srcAccess = SRC_ACCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstAccess() <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccess()
	 * @generated
	 * @ordered
	 */
	protected static final int DST_ACCESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDstAccess() <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccess()
	 * @generated
	 * @ordered
	 */
	protected int dstAccess = DST_ACCESS_EDEFAULT;

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
			InternalEObject oldBuffer = (InternalEObject)buffer;
			buffer = (Buffer)eResolveProxy(oldBuffer);
			if (buffer != oldBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcePackage.BUFFER_BARRIER__BUFFER, oldBuffer, buffer));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_BARRIER__BUFFER, oldBuffer, buffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSrcAccess()
	{
		return srcAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcAccess(int newSrcAccess)
	{
		int oldSrcAccess = srcAccess;
		srcAccess = newSrcAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_BARRIER__SRC_ACCESS, oldSrcAccess, srcAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDstAccess()
	{
		return dstAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstAccess(int newDstAccess)
	{
		int oldDstAccess = dstAccess;
		dstAccess = newDstAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER_BARRIER__DST_ACCESS, oldDstAccess, dstAccess));
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
			case ResourcePackage.BUFFER_BARRIER__SRC_ACCESS:
				return getSrcAccess();
			case ResourcePackage.BUFFER_BARRIER__DST_ACCESS:
				return getDstAccess();
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
				setBuffer((Buffer)newValue);
				return;
			case ResourcePackage.BUFFER_BARRIER__SRC_ACCESS:
				setSrcAccess((Integer)newValue);
				return;
			case ResourcePackage.BUFFER_BARRIER__DST_ACCESS:
				setDstAccess((Integer)newValue);
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
				setBuffer((Buffer)null);
				return;
			case ResourcePackage.BUFFER_BARRIER__SRC_ACCESS:
				setSrcAccess(SRC_ACCESS_EDEFAULT);
				return;
			case ResourcePackage.BUFFER_BARRIER__DST_ACCESS:
				setDstAccess(DST_ACCESS_EDEFAULT);
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
			case ResourcePackage.BUFFER_BARRIER__SRC_ACCESS:
				return srcAccess != SRC_ACCESS_EDEFAULT;
			case ResourcePackage.BUFFER_BARRIER__DST_ACCESS:
				return dstAccess != DST_ACCESS_EDEFAULT;
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
		result.append(" (srcAccess: ");
		result.append(srcAccess);
		result.append(", dstAccess: ");
		result.append(dstAccess);
		result.append(')');
		return result.toString();
	}

} //BufferBarrierImpl
