/**
 */
package org.sheepy.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.process.ProcessSemaphore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semaphore</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ProcessSemaphoreImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ProcessSemaphoreImpl#getWaitStage <em>Wait Stage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessSemaphoreImpl extends MinimalEObjectImpl.Container implements ProcessSemaphore
{
	/**
	 * The cached value of the '{@link #getProcess() <em>Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcess()
	 * @generated
	 * @ordered
	 */
	protected AbstractProcess process;

	/**
	 * The default value of the '{@link #getWaitStage() <em>Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage WAIT_STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getWaitStage() <em>Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage waitStage = WAIT_STAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSemaphoreImpl()
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
		return ProcessPackage.Literals.PROCESS_SEMAPHORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractProcess getProcess()
	{
		if (process != null && process.eIsProxy())
		{
			InternalEObject oldProcess = (InternalEObject)process;
			process = (AbstractProcess)eResolveProxy(oldProcess);
			if (process != oldProcess)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.PROCESS_SEMAPHORE__PROCESS, oldProcess, process));
			}
		}
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcess basicGetProcess()
	{
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcess(AbstractProcess newProcess, NotificationChain msgs)
	{
		AbstractProcess oldProcess = process;
		process = newProcess;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_SEMAPHORE__PROCESS, oldProcess, newProcess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProcess(AbstractProcess newProcess)
	{
		if (newProcess != process)
		{
			NotificationChain msgs = null;
			if (process != null)
				msgs = ((InternalEObject)process).eInverseRemove(this, ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES, AbstractProcess.class, msgs);
			if (newProcess != null)
				msgs = ((InternalEObject)newProcess).eInverseAdd(this, ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES, AbstractProcess.class, msgs);
			msgs = basicSetProcess(newProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_SEMAPHORE__PROCESS, newProcess, newProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getWaitStage()
	{
		return waitStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWaitStage(EPipelineStage newWaitStage)
	{
		EPipelineStage oldWaitStage = waitStage;
		waitStage = newWaitStage == null ? WAIT_STAGE_EDEFAULT : newWaitStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_SEMAPHORE__WAIT_STAGE, oldWaitStage, waitStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ProcessPackage.PROCESS_SEMAPHORE__PROCESS:
				if (process != null)
					msgs = ((InternalEObject)process).eInverseRemove(this, ProcessPackage.ABSTRACT_PROCESS__DEPENDENT_PROCESSES, AbstractProcess.class, msgs);
				return basicSetProcess((AbstractProcess)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case ProcessPackage.PROCESS_SEMAPHORE__PROCESS:
				return basicSetProcess(null, msgs);
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
			case ProcessPackage.PROCESS_SEMAPHORE__PROCESS:
				if (resolve) return getProcess();
				return basicGetProcess();
			case ProcessPackage.PROCESS_SEMAPHORE__WAIT_STAGE:
				return getWaitStage();
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
			case ProcessPackage.PROCESS_SEMAPHORE__PROCESS:
				setProcess((AbstractProcess)newValue);
				return;
			case ProcessPackage.PROCESS_SEMAPHORE__WAIT_STAGE:
				setWaitStage((EPipelineStage)newValue);
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
			case ProcessPackage.PROCESS_SEMAPHORE__PROCESS:
				setProcess((AbstractProcess)null);
				return;
			case ProcessPackage.PROCESS_SEMAPHORE__WAIT_STAGE:
				setWaitStage(WAIT_STAGE_EDEFAULT);
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
			case ProcessPackage.PROCESS_SEMAPHORE__PROCESS:
				return process != null;
			case ProcessPackage.PROCESS_SEMAPHORE__WAIT_STAGE:
				return waitStage != WAIT_STAGE_EDEFAULT;
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
		result.append(" (waitStage: ");
		result.append(waitStage);
		result.append(')');
		return result.toString();
	}

} //ProcessSemaphoreImpl
