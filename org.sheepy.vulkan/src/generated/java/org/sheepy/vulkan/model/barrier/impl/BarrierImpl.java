/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.barrier.BarrierPackage;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.BarrierImpl#getSrcStage <em>Src Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.BarrierImpl#getDstStage <em>Dst Stage</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BarrierImpl extends MinimalEObjectImpl.Container implements Barrier
{
	/**
	 * The default value of the '{@link #getSrcStage() <em>Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage SRC_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getSrcStage() <em>Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage srcStage = SRC_STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstStage() <em>Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage DST_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getDstStage() <em>Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage dstStage = DST_STAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BarrierImpl()
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
		return BarrierPackage.Literals.BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getSrcStage()
	{
		return srcStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcStage(EPipelineStage newSrcStage)
	{
		EPipelineStage oldSrcStage = srcStage;
		srcStage = newSrcStage == null ? SRC_STAGE_EDEFAULT : newSrcStage;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				BarrierPackage.BARRIER__SRC_STAGE, oldSrcStage, srcStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getDstStage()
	{
		return dstStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstStage(EPipelineStage newDstStage)
	{
		EPipelineStage oldDstStage = dstStage;
		dstStage = newDstStage == null ? DST_STAGE_EDEFAULT : newDstStage;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				BarrierPackage.BARRIER__DST_STAGE, oldDstStage, dstStage));
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
		case BarrierPackage.BARRIER__SRC_STAGE:
			return getSrcStage();
		case BarrierPackage.BARRIER__DST_STAGE:
			return getDstStage();
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
		case BarrierPackage.BARRIER__SRC_STAGE:
			setSrcStage((EPipelineStage) newValue);
			return;
		case BarrierPackage.BARRIER__DST_STAGE:
			setDstStage((EPipelineStage) newValue);
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
		case BarrierPackage.BARRIER__SRC_STAGE:
			setSrcStage(SRC_STAGE_EDEFAULT);
			return;
		case BarrierPackage.BARRIER__DST_STAGE:
			setDstStage(DST_STAGE_EDEFAULT);
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
		case BarrierPackage.BARRIER__SRC_STAGE:
			return srcStage != SRC_STAGE_EDEFAULT;
		case BarrierPackage.BARRIER__DST_STAGE:
			return dstStage != DST_STAGE_EDEFAULT;
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
		result.append(" (srcStage: ");
		result.append(srcStage);
		result.append(", dstStage: ");
		result.append(dstStage);
		result.append(')');
		return result.toString();
	}

} //BarrierImpl
