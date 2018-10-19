/**
 */
package org.sheepy.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import org.sheepy.vulkan.model.process.PipelineBarrier;
import org.sheepy.vulkan.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl#getSrcStage <em>Src Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl#getDstStage <em>Dst Stage</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PipelineBarrierImpl extends MinimalEObjectImpl.Container implements PipelineBarrier
{
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final ECommandStage STAGE_EDEFAULT = ECommandStage.RENDER;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected ECommandStage stage = STAGE_EDEFAULT;

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
	public PipelineBarrierImpl()
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
		return ProcessPackage.Literals.PIPELINE_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECommandStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStage(ECommandStage newStage)
	{
		ECommandStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPipelineStage getSrcStage()
	{
		return srcStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcStage(EPipelineStage newSrcStage)
	{
		EPipelineStage oldSrcStage = srcStage;
		srcStage = newSrcStage == null ? SRC_STAGE_EDEFAULT : newSrcStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__SRC_STAGE, oldSrcStage, srcStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPipelineStage getDstStage()
	{
		return dstStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDstStage(EPipelineStage newDstStage)
	{
		EPipelineStage oldDstStage = dstStage;
		dstStage = newDstStage == null ? DST_STAGE_EDEFAULT : newDstStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__DST_STAGE, oldDstStage, dstStage));
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
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				return isEnabled();
			case ProcessPackage.PIPELINE_BARRIER__STAGE:
				return getStage();
			case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
				return getSrcStage();
			case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
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
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__STAGE:
				setStage((ECommandStage)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
				setSrcStage((EPipelineStage)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
				setDstStage((EPipelineStage)newValue);
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
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__STAGE:
				setStage(STAGE_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
				setSrcStage(SRC_STAGE_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
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
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.PIPELINE_BARRIER__STAGE:
				return stage != STAGE_EDEFAULT;
			case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
				return srcStage != SRC_STAGE_EDEFAULT;
			case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", stage: ");
		result.append(stage);
		result.append(", srcStage: ");
		result.append(srcStage);
		result.append(", dstStage: ");
		result.append(dstStage);
		result.append(')');
		return result.toString();
	}

} //PipelineBarrierImpl
