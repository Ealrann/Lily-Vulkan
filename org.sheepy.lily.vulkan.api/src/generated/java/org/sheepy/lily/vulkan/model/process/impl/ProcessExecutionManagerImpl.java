/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl#getWaitForExecution <em>Wait For Execution</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl#getWaitedBy <em>Waited By</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl#getWaitStage <em>Wait Stage</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ProcessExecutionManagerImpl extends LilyEObject implements ProcessExecutionManager
{
	/**
	 * The cached value of the '{@link #getWaitForExecution() <em>Wait For Execution</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitForExecution()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessExecutionManager> waitForExecution;

	/**
	 * The cached value of the '{@link #getWaitedBy() <em>Waited By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessExecutionManager> waitedBy;

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
	protected ProcessExecutionManagerImpl()
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
		return ProcessPackage.Literals.PROCESS_EXECUTION_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessExecutionManager> getWaitForExecution()
	{
		if (waitForExecution == null)
		{
			waitForExecution = new EObjectWithInverseResolvingEList.ManyInverse<ProcessExecutionManager>(ProcessExecutionManager.class, this, ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION, ProcessPackage.PROCESS_EXECUTION_MANAGER__WAITED_BY);
		}
		return waitForExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessExecutionManager> getWaitedBy()
	{
		if (waitedBy == null)
		{
			waitedBy = new EObjectWithInverseResolvingEList.ManyInverse<ProcessExecutionManager>(ProcessExecutionManager.class, this, ProcessPackage.PROCESS_EXECUTION_MANAGER__WAITED_BY, ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION);
		}
		return waitedBy;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_STAGE, oldWaitStage, waitStage));
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
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWaitForExecution()).basicAdd(otherEnd, msgs);
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAITED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWaitedBy()).basicAdd(otherEnd, msgs);
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
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION:
				return ((InternalEList<?>)getWaitForExecution()).basicRemove(otherEnd, msgs);
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAITED_BY:
				return ((InternalEList<?>)getWaitedBy()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION:
				return getWaitForExecution();
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAITED_BY:
				return getWaitedBy();
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_STAGE:
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
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION:
				getWaitForExecution().clear();
				getWaitForExecution().addAll((Collection<? extends ProcessExecutionManager>)newValue);
				return;
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAITED_BY:
				getWaitedBy().clear();
				getWaitedBy().addAll((Collection<? extends ProcessExecutionManager>)newValue);
				return;
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_STAGE:
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
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION:
				getWaitForExecution().clear();
				return;
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAITED_BY:
				getWaitedBy().clear();
				return;
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_STAGE:
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
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_FOR_EXECUTION:
				return waitForExecution != null && !waitForExecution.isEmpty();
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAITED_BY:
				return waitedBy != null && !waitedBy.isEmpty();
			case ProcessPackage.PROCESS_EXECUTION_MANAGER__WAIT_STAGE:
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

} //ProcessExecutionManagerImpl
