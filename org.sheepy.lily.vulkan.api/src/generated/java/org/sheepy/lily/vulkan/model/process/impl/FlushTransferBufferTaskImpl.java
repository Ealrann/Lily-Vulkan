/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flush Transfer Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl#getTransferBuffer <em>Transfer Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl#isFlushDuringUpdate <em>Flush During Update</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlushTransferBufferTaskImpl extends LilyEObject implements FlushTransferBufferTask
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
	 * The cached value of the '{@link #getTransferBuffer() <em>Transfer Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferBuffer()
	 * @generated
	 * @ordered
	 */
	protected TransferBuffer transferBuffer;

	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final ECommandStage STAGE_EDEFAULT = ECommandStage.TRANSFER;

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
	 * The default value of the '{@link #isFlushDuringUpdate() <em>Flush During Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlushDuringUpdate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLUSH_DURING_UPDATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlushDuringUpdate() <em>Flush During Update</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlushDuringUpdate()
	 * @generated
	 * @ordered
	 */
	protected boolean flushDuringUpdate = FLUSH_DURING_UPDATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlushTransferBufferTaskImpl()
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
		return ProcessPackage.Literals.FLUSH_TRANSFER_BUFFER_TASK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransferBuffer getTransferBuffer()
	{
		if (transferBuffer != null && ((EObject)transferBuffer).eIsProxy())
		{
			InternalEObject oldTransferBuffer = (InternalEObject)transferBuffer;
			transferBuffer = (TransferBuffer)eResolveProxy(oldTransferBuffer);
			if (transferBuffer != oldTransferBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER, oldTransferBuffer, transferBuffer));
			}
		}
		return transferBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransferBuffer basicGetTransferBuffer()
	{
		return transferBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransferBuffer(TransferBuffer newTransferBuffer)
	{
		TransferBuffer oldTransferBuffer = transferBuffer;
		transferBuffer = newTransferBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER, oldTransferBuffer, transferBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECommandStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(ECommandStage newStage)
	{
		ECommandStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFlushDuringUpdate()
	{
		return flushDuringUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFlushDuringUpdate(boolean newFlushDuringUpdate)
	{
		boolean oldFlushDuringUpdate = flushDuringUpdate;
		flushDuringUpdate = newFlushDuringUpdate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__FLUSH_DURING_UPDATE, oldFlushDuringUpdate, flushDuringUpdate));
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
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__NAME:
				return getName();
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__ENABLED:
				return isEnabled();
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER:
				if (resolve) return getTransferBuffer();
				return basicGetTransferBuffer();
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__STAGE:
				return getStage();
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__FLUSH_DURING_UPDATE:
				return isFlushDuringUpdate();
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
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER:
				setTransferBuffer((TransferBuffer)newValue);
				return;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__STAGE:
				setStage((ECommandStage)newValue);
				return;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__FLUSH_DURING_UPDATE:
				setFlushDuringUpdate((Boolean)newValue);
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
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER:
				setTransferBuffer((TransferBuffer)null);
				return;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__STAGE:
				setStage(STAGE_EDEFAULT);
				return;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__FLUSH_DURING_UPDATE:
				setFlushDuringUpdate(FLUSH_DURING_UPDATE_EDEFAULT);
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
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__TRANSFER_BUFFER:
				return transferBuffer != null;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__STAGE:
				return stage != STAGE_EDEFAULT;
			case ProcessPackage.FLUSH_TRANSFER_BUFFER_TASK__FLUSH_DURING_UPDATE:
				return flushDuringUpdate != FLUSH_DURING_UPDATE_EDEFAULT;
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
		result.append(", stage: ");
		result.append(stage);
		result.append(", flushDuringUpdate: ");
		result.append(flushDuringUpdate);
		result.append(')');
		return result.toString();
	}

} //FlushTransferBufferTaskImpl
