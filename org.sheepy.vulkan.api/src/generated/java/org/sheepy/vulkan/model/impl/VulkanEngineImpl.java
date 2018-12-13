/**
 */
package org.sheepy.vulkan.model.impl;

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

import org.sheepy.vulkan.model.IProcess;
import org.sheepy.vulkan.model.SharedResources;
import org.sheepy.vulkan.model.VulkanEngine;
import org.sheepy.vulkan.model.VulkanPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Engine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanEngineImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanEngineImpl#getSharedResources <em>Shared Resources</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanEngineImpl#getProcesses <em>Processes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VulkanEngineImpl extends MinimalEObjectImpl.Container implements VulkanEngine
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
	 * The cached value of the '{@link #getSharedResources() <em>Shared Resources</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedResources()
	 * @generated
	 * @ordered
	 */
	protected SharedResources sharedResources;
	/**
	 * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<IProcess> processes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanEngineImpl()
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
		return VulkanPackage.Literals.VULKAN_ENGINE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_ENGINE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SharedResources getSharedResources()
	{
		return sharedResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSharedResources(SharedResources newSharedResources, NotificationChain msgs)
	{
		SharedResources oldSharedResources = sharedResources;
		sharedResources = newSharedResources;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES, oldSharedResources, newSharedResources);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedResources(SharedResources newSharedResources)
	{
		if (newSharedResources != sharedResources)
		{
			NotificationChain msgs = null;
			if (sharedResources != null)
				msgs = ((InternalEObject)sharedResources).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES, null, msgs);
			if (newSharedResources != null)
				msgs = ((InternalEObject)newSharedResources).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES, null, msgs);
			msgs = basicSetSharedResources(newSharedResources, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES, newSharedResources, newSharedResources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IProcess> getProcesses()
	{
		if (processes == null)
		{
			processes = new EObjectContainmentEList<IProcess>(IProcess.class, this, VulkanPackage.VULKAN_ENGINE__PROCESSES);
		}
		return processes;
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
			case VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES:
				return basicSetSharedResources(null, msgs);
			case VulkanPackage.VULKAN_ENGINE__PROCESSES:
				return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
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
			case VulkanPackage.VULKAN_ENGINE__ENABLED:
				return isEnabled();
			case VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES:
				return getSharedResources();
			case VulkanPackage.VULKAN_ENGINE__PROCESSES:
				return getProcesses();
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
			case VulkanPackage.VULKAN_ENGINE__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES:
				setSharedResources((SharedResources)newValue);
				return;
			case VulkanPackage.VULKAN_ENGINE__PROCESSES:
				getProcesses().clear();
				getProcesses().addAll((Collection<? extends IProcess>)newValue);
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
			case VulkanPackage.VULKAN_ENGINE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES:
				setSharedResources((SharedResources)null);
				return;
			case VulkanPackage.VULKAN_ENGINE__PROCESSES:
				getProcesses().clear();
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
			case VulkanPackage.VULKAN_ENGINE__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case VulkanPackage.VULKAN_ENGINE__SHARED_RESOURCES:
				return sharedResources != null;
			case VulkanPackage.VULKAN_ENGINE__PROCESSES:
				return processes != null && !processes.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //VulkanEngineImpl
