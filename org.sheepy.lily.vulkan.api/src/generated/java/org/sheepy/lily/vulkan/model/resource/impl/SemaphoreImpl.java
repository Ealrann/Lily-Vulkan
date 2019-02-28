/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;

import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.Semaphore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semaphore</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl#isSignalizedAtInit <em>Signalized At Init</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.SemaphoreImpl#getWaitStage <em>Wait Stage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemaphoreImpl extends MinimalEObjectImpl.Container implements Semaphore
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
	 * The default value of the '{@link #isSignalizedAtInit() <em>Signalized At Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSignalizedAtInit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIGNALIZED_AT_INIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSignalizedAtInit() <em>Signalized At Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSignalizedAtInit()
	 * @generated
	 * @ordered
	 */
	protected boolean signalizedAtInit = SIGNALIZED_AT_INIT_EDEFAULT;

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
	public SemaphoreImpl()
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
		return ResourcePackage.Literals.SEMAPHORE;
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SEMAPHORE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSignalizedAtInit()
	{
		return signalizedAtInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSignalizedAtInit(boolean newSignalizedAtInit)
	{
		boolean oldSignalizedAtInit = signalizedAtInit;
		signalizedAtInit = newSignalizedAtInit;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SEMAPHORE__SIGNALIZED_AT_INIT, oldSignalizedAtInit,
				signalizedAtInit));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SEMAPHORE__WAIT_STAGE, oldWaitStage, waitStage));
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
		case ResourcePackage.SEMAPHORE__NAME:
			return getName();
		case ResourcePackage.SEMAPHORE__SIGNALIZED_AT_INIT:
			return isSignalizedAtInit();
		case ResourcePackage.SEMAPHORE__WAIT_STAGE:
			return getWaitStage();
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
		case ResourcePackage.SEMAPHORE__NAME:
			setName((String) newValue);
			return;
		case ResourcePackage.SEMAPHORE__SIGNALIZED_AT_INIT:
			setSignalizedAtInit((Boolean) newValue);
			return;
		case ResourcePackage.SEMAPHORE__WAIT_STAGE:
			setWaitStage((EPipelineStage) newValue);
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
		case ResourcePackage.SEMAPHORE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ResourcePackage.SEMAPHORE__SIGNALIZED_AT_INIT:
			setSignalizedAtInit(SIGNALIZED_AT_INIT_EDEFAULT);
			return;
		case ResourcePackage.SEMAPHORE__WAIT_STAGE:
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
		case ResourcePackage.SEMAPHORE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ResourcePackage.SEMAPHORE__SIGNALIZED_AT_INIT:
			return signalizedAtInit != SIGNALIZED_AT_INIT_EDEFAULT;
		case ResourcePackage.SEMAPHORE__WAIT_STAGE:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", signalizedAtInit: ");
		result.append(signalizedAtInit);
		result.append(", waitStage: ");
		result.append(waitStage);
		result.append(')');
		return result.toString();
	}

} //SemaphoreImpl
