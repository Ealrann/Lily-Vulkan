/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.BarrierPackage;

import org.sheepy.vulkan.model.enumeration.EAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.AbstractBufferBarrierImpl#getSrcAccess <em>Src Access</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.AbstractBufferBarrierImpl#getDstAccess <em>Dst Access</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractBufferBarrierImpl extends BarrierImpl implements AbstractBufferBarrier
{
	/**
	 * The default value of the '{@link #getSrcAccess() <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccess()
	 * @generated
	 * @ordered
	 */
	protected static final EAccess SRC_ACCESS_EDEFAULT = EAccess.UNDEFINED;

	/**
	 * The cached value of the '{@link #getSrcAccess() <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccess()
	 * @generated
	 * @ordered
	 */
	protected EAccess srcAccess = SRC_ACCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstAccess() <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccess()
	 * @generated
	 * @ordered
	 */
	protected static final EAccess DST_ACCESS_EDEFAULT = EAccess.UNDEFINED;

	/**
	 * The cached value of the '{@link #getDstAccess() <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccess()
	 * @generated
	 * @ordered
	 */
	protected EAccess dstAccess = DST_ACCESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractBufferBarrierImpl()
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
		return BarrierPackage.Literals.ABSTRACT_BUFFER_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAccess getSrcAccess()
	{
		return srcAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcAccess(EAccess newSrcAccess)
	{
		EAccess oldSrcAccess = srcAccess;
		srcAccess = newSrcAccess == null ? SRC_ACCESS_EDEFAULT : newSrcAccess;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				BarrierPackage.ABSTRACT_BUFFER_BARRIER__SRC_ACCESS, oldSrcAccess, srcAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAccess getDstAccess()
	{
		return dstAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstAccess(EAccess newDstAccess)
	{
		EAccess oldDstAccess = dstAccess;
		dstAccess = newDstAccess == null ? DST_ACCESS_EDEFAULT : newDstAccess;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				BarrierPackage.ABSTRACT_BUFFER_BARRIER__DST_ACCESS, oldDstAccess, dstAccess));
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
		case BarrierPackage.ABSTRACT_BUFFER_BARRIER__SRC_ACCESS:
			return getSrcAccess();
		case BarrierPackage.ABSTRACT_BUFFER_BARRIER__DST_ACCESS:
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
		case BarrierPackage.ABSTRACT_BUFFER_BARRIER__SRC_ACCESS:
			setSrcAccess((EAccess) newValue);
			return;
		case BarrierPackage.ABSTRACT_BUFFER_BARRIER__DST_ACCESS:
			setDstAccess((EAccess) newValue);
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
		case BarrierPackage.ABSTRACT_BUFFER_BARRIER__SRC_ACCESS:
			setSrcAccess(SRC_ACCESS_EDEFAULT);
			return;
		case BarrierPackage.ABSTRACT_BUFFER_BARRIER__DST_ACCESS:
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
		case BarrierPackage.ABSTRACT_BUFFER_BARRIER__SRC_ACCESS:
			return srcAccess != SRC_ACCESS_EDEFAULT;
		case BarrierPackage.ABSTRACT_BUFFER_BARRIER__DST_ACCESS:
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

} //AbstractBufferBarrierImpl
