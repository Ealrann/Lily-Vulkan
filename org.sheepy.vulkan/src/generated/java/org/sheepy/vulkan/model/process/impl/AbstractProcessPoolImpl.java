/**
 */
package org.sheepy.vulkan.model.process.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.vulkan.model.process.AbstractProcess;
import org.sheepy.vulkan.model.process.AbstractProcessPool;
import org.sheepy.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Process Pool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl#getProcesses <em>Processes</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl#isResetAllowed <em>Reset Allowed</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractProcessPoolImpl<T extends AbstractProcess> extends MinimalEObjectImpl.Container implements AbstractProcessPool<T>
{
	/**
	 * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<T> processes;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * The default value of the '{@link #isResetAllowed() <em>Reset Allowed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetAllowed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESET_ALLOWED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResetAllowed() <em>Reset Allowed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetAllowed()
	 * @generated
	 * @ordered
	 */
	protected boolean resetAllowed = RESET_ALLOWED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcessPoolImpl()
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
		return ProcessPackage.Literals.ABSTRACT_PROCESS_POOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<T> getProcesses()
	{
		if (processes == null)
		{
			processes = new EObjectContainmentEList<T>(AbstractProcess.class, this, ProcessPackage.ABSTRACT_PROCESS_POOL__PROCESSES);
		}
		return processes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources()
	{
		if (resources == null)
		{
			resources = new EObjectContainmentEList<Resource>(Resource.class, this, ProcessPackage.ABSTRACT_PROCESS_POOL__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResetAllowed()
	{
		return resetAllowed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResetAllowed(boolean newResetAllowed)
	{
		boolean oldResetAllowed = resetAllowed;
		resetAllowed = newResetAllowed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS_POOL__RESET_ALLOWED, oldResetAllowed, resetAllowed));
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
			case ProcessPackage.ABSTRACT_PROCESS_POOL__PROCESSES:
				return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.ABSTRACT_PROCESS_POOL__PROCESSES:
				return getProcesses();
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESOURCES:
				return getResources();
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESET_ALLOWED:
				return isResetAllowed();
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
			case ProcessPackage.ABSTRACT_PROCESS_POOL__PROCESSES:
				getProcesses().clear();
				getProcesses().addAll((Collection<? extends T>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESET_ALLOWED:
				setResetAllowed((Boolean)newValue);
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
			case ProcessPackage.ABSTRACT_PROCESS_POOL__PROCESSES:
				getProcesses().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESOURCES:
				getResources().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESET_ALLOWED:
				setResetAllowed(RESET_ALLOWED_EDEFAULT);
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
			case ProcessPackage.ABSTRACT_PROCESS_POOL__PROCESSES:
				return processes != null && !processes.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESOURCES:
				return resources != null && !resources.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS_POOL__RESET_ALLOWED:
				return resetAllowed != RESET_ALLOWED_EDEFAULT;
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
		result.append(" (resetAllowed: ");
		result.append(resetAllowed);
		result.append(')');
		return result.toString();
	}

} //AbstractProcessPoolImpl
