/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.barrier.Barrier;

import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getBarriers <em>Barriers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getSrcStage <em>Src Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getDstStage <em>Dst Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getSrcQueue <em>Src Queue</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getDstQueue <em>Dst Queue</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl#getRecordDuringStage <em>Record During Stage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PipelineBarrierImpl extends LilyEObject implements PipelineBarrier
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
	 * The cached value of the '{@link #getBarriers() <em>Barriers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBarriers()
	 * @generated
	 * @ordered
	 */
	protected EList<Barrier> barriers;

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
	 * The cached value of the '{@link #getSrcQueue() <em>Src Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcQueue()
	 * @generated
	 * @ordered
	 */
	protected AbstractProcess srcQueue;

	/**
	 * The cached value of the '{@link #getDstQueue() <em>Dst Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstQueue()
	 * @generated
	 * @ordered
	 */
	protected AbstractProcess dstQueue;

	/**
	 * The default value of the '{@link #getRecordDuringStage() <em>Record During Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordDuringStage()
	 * @generated
	 * @ordered
	 */
	protected static final ECommandStage RECORD_DURING_STAGE_EDEFAULT = ECommandStage.INHERITED;

	/**
	 * The cached value of the '{@link #getRecordDuringStage() <em>Record During Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordDuringStage()
	 * @generated
	 * @ordered
	 */
	protected ECommandStage recordDuringStage = RECORD_DURING_STAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipelineBarrierImpl()
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public EList<Barrier> getBarriers()
	{
		if (barriers == null)
		{
			barriers = new EObjectContainmentEList<Barrier>(Barrier.class, this, ProcessPackage.PIPELINE_BARRIER__BARRIERS);
		}
		return barriers;
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__SRC_STAGE, oldSrcStage, srcStage));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__DST_STAGE, oldDstStage, dstStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractProcess getSrcQueue()
	{
		if (srcQueue != null && ((EObject)srcQueue).eIsProxy())
		{
			InternalEObject oldSrcQueue = (InternalEObject)srcQueue;
			srcQueue = (AbstractProcess)eResolveProxy(oldSrcQueue);
			if (srcQueue != oldSrcQueue)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE, oldSrcQueue, srcQueue));
			}
		}
		return srcQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcess basicGetSrcQueue()
	{
		return srcQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcQueue(AbstractProcess newSrcQueue)
	{
		AbstractProcess oldSrcQueue = srcQueue;
		srcQueue = newSrcQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE, oldSrcQueue, srcQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractProcess getDstQueue()
	{
		if (dstQueue != null && ((EObject)dstQueue).eIsProxy())
		{
			InternalEObject oldDstQueue = (InternalEObject)dstQueue;
			dstQueue = (AbstractProcess)eResolveProxy(oldDstQueue);
			if (dstQueue != oldDstQueue)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.PIPELINE_BARRIER__DST_QUEUE, oldDstQueue, dstQueue));
			}
		}
		return dstQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcess basicGetDstQueue()
	{
		return dstQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstQueue(AbstractProcess newDstQueue)
	{
		AbstractProcess oldDstQueue = dstQueue;
		dstQueue = newDstQueue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__DST_QUEUE, oldDstQueue, dstQueue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECommandStage getRecordDuringStage()
	{
		return recordDuringStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecordDuringStage(ECommandStage newRecordDuringStage)
	{
		ECommandStage oldRecordDuringStage = recordDuringStage;
		recordDuringStage = newRecordDuringStage == null ? RECORD_DURING_STAGE_EDEFAULT : newRecordDuringStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PIPELINE_BARRIER__RECORD_DURING_STAGE, oldRecordDuringStage, recordDuringStage));
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
			case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
				return ((InternalEList<?>)getBarriers()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				return getName();
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				return isEnabled();
			case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
				return getBarriers();
			case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
				return getSrcStage();
			case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
				return getDstStage();
			case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
				if (resolve) return getSrcQueue();
				return basicGetSrcQueue();
			case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
				if (resolve) return getDstQueue();
				return basicGetDstQueue();
			case ProcessPackage.PIPELINE_BARRIER__RECORD_DURING_STAGE:
				return getRecordDuringStage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
				getBarriers().clear();
				getBarriers().addAll((Collection<? extends Barrier>)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
				setSrcStage((EPipelineStage)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
				setDstStage((EPipelineStage)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
				setSrcQueue((AbstractProcess)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
				setDstQueue((AbstractProcess)newValue);
				return;
			case ProcessPackage.PIPELINE_BARRIER__RECORD_DURING_STAGE:
				setRecordDuringStage((ECommandStage)newValue);
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
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
				getBarriers().clear();
				return;
			case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
				setSrcStage(SRC_STAGE_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
				setDstStage(DST_STAGE_EDEFAULT);
				return;
			case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
				setSrcQueue((AbstractProcess)null);
				return;
			case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
				setDstQueue((AbstractProcess)null);
				return;
			case ProcessPackage.PIPELINE_BARRIER__RECORD_DURING_STAGE:
				setRecordDuringStage(RECORD_DURING_STAGE_EDEFAULT);
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
			case ProcessPackage.PIPELINE_BARRIER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.PIPELINE_BARRIER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.PIPELINE_BARRIER__BARRIERS:
				return barriers != null && !barriers.isEmpty();
			case ProcessPackage.PIPELINE_BARRIER__SRC_STAGE:
				return srcStage != SRC_STAGE_EDEFAULT;
			case ProcessPackage.PIPELINE_BARRIER__DST_STAGE:
				return dstStage != DST_STAGE_EDEFAULT;
			case ProcessPackage.PIPELINE_BARRIER__SRC_QUEUE:
				return srcQueue != null;
			case ProcessPackage.PIPELINE_BARRIER__DST_QUEUE:
				return dstQueue != null;
			case ProcessPackage.PIPELINE_BARRIER__RECORD_DURING_STAGE:
				return recordDuringStage != RECORD_DURING_STAGE_EDEFAULT;
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
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", srcStage: ");
		result.append(srcStage);
		result.append(", dstStage: ");
		result.append(dstStage);
		result.append(", recordDuringStage: ");
		result.append(recordDuringStage);
		result.append(')');
		return result.toString();
	}

} //PipelineBarrierImpl
