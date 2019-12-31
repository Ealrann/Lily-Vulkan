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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.application.ResourcePkg;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.DescriptorPkg;
import org.sheepy.lily.vulkan.model.IExecutionManager;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.Semaphore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getResourcePkg <em>Resource Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getDescriptorPkg <em>Descriptor Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getQueuePriority <em>Queue Priority</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getCadence <em>Cadence</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#isWaitingFenceDuringAcquire <em>Waiting Fence During Acquire</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#isResetAllowed <em>Reset Allowed</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getSignals <em>Signals</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getWaitFor <em>Wait For</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getExtensionPkg <em>Extension Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractProcessImpl extends LilyEObject implements AbstractProcess
{
	/**
	 * The cached value of the '{@link #getResourcePkg() <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcePkg()
	 * @generated
	 * @ordered
	 */
	protected ResourcePkg resourcePkg;

	/**
	 * The cached value of the '{@link #getDescriptorPkg() <em>Descriptor Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorPkg()
	 * @generated
	 * @ordered
	 */
	protected DescriptorPkg descriptorPkg;

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
	 * The default value of the '{@link #getQueuePriority() <em>Queue Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueuePriority()
	 * @generated
	 * @ordered
	 */
	protected static final float QUEUE_PRIORITY_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getQueuePriority() <em>Queue Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueuePriority()
	 * @generated
	 * @ordered
	 */
	protected float queuePriority = QUEUE_PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCadence() <em>Cadence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCadence()
	 * @generated
	 * @ordered
	 */
	protected ICadence cadence;

	/**
	 * The default value of the '{@link #isWaitingFenceDuringAcquire() <em>Waiting Fence During Acquire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWaitingFenceDuringAcquire()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WAITING_FENCE_DURING_ACQUIRE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWaitingFenceDuringAcquire() <em>Waiting Fence During Acquire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWaitingFenceDuringAcquire()
	 * @generated
	 * @ordered
	 */
	protected boolean waitingFenceDuringAcquire = WAITING_FENCE_DURING_ACQUIRE_EDEFAULT;

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
	 * The cached value of the '{@link #getSignals() <em>Signals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignals()
	 * @generated
	 * @ordered
	 */
	protected EList<Semaphore> signals;

	/**
	 * The cached value of the '{@link #getWaitFor() <em>Wait For</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitFor()
	 * @generated
	 * @ordered
	 */
	protected EList<Semaphore> waitFor;

	/**
	 * The cached value of the '{@link #getExtensionPkg() <em>Extension Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionPkg()
	 * @generated
	 * @ordered
	 */
	protected ProcessExtensionPkg extensionPkg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractProcessImpl()
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
		return ProcessPackage.Literals.ABSTRACT_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePkg getResourcePkg()
	{
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourcePkg(ResourcePkg newResourcePkg, NotificationChain msgs)
	{
		ResourcePkg oldResourcePkg = resourcePkg;
		resourcePkg = newResourcePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
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
	public void setResourcePkg(ResourcePkg newResourcePkg)
	{
		if (newResourcePkg != resourcePkg)
		{
			NotificationChain msgs = null;
			if (resourcePkg != null)
				msgs = ((InternalEObject)resourcePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG, null, msgs);
			if (newResourcePkg != null)
				msgs = ((InternalEObject)newResourcePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG, null, msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG, newResourcePkg, newResourcePkg));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getQueuePriority()
	{
		return queuePriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQueuePriority(float newQueuePriority)
	{
		float oldQueuePriority = queuePriority;
		queuePriority = newQueuePriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__QUEUE_PRIORITY, oldQueuePriority, queuePriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ICadence getCadence()
	{
		return cadence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCadence(ICadence newCadence, NotificationChain msgs)
	{
		ICadence oldCadence = cadence;
		cadence = newCadence;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CADENCE, oldCadence, newCadence);
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
	public void setCadence(ICadence newCadence)
	{
		if (newCadence != cadence)
		{
			NotificationChain msgs = null;
			if (cadence != null)
				msgs = ((InternalEObject)cadence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__CADENCE, null, msgs);
			if (newCadence != null)
				msgs = ((InternalEObject)newCadence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__CADENCE, null, msgs);
			msgs = basicSetCadence(newCadence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__CADENCE, newCadence, newCadence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWaitingFenceDuringAcquire()
	{
		return waitingFenceDuringAcquire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWaitingFenceDuringAcquire(boolean newWaitingFenceDuringAcquire)
	{
		boolean oldWaitingFenceDuringAcquire = waitingFenceDuringAcquire;
		waitingFenceDuringAcquire = newWaitingFenceDuringAcquire;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE, oldWaitingFenceDuringAcquire, waitingFenceDuringAcquire));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResetAllowed()
	{
		return resetAllowed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResetAllowed(boolean newResetAllowed)
	{
		boolean oldResetAllowed = resetAllowed;
		resetAllowed = newResetAllowed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED, oldResetAllowed, resetAllowed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Semaphore> getSignals()
	{
		if (signals == null)
		{
			signals = new EObjectResolvingEList<Semaphore>(Semaphore.class, this, ProcessPackage.ABSTRACT_PROCESS__SIGNALS);
		}
		return signals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Semaphore> getWaitFor()
	{
		if (waitFor == null)
		{
			waitFor = new EObjectResolvingEList<Semaphore>(Semaphore.class, this, ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR);
		}
		return waitFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessExtensionPkg getExtensionPkg()
	{
		return extensionPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionPkg(ProcessExtensionPkg newExtensionPkg, NotificationChain msgs)
	{
		ProcessExtensionPkg oldExtensionPkg = extensionPkg;
		extensionPkg = newExtensionPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG, oldExtensionPkg, newExtensionPkg);
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
	public void setExtensionPkg(ProcessExtensionPkg newExtensionPkg)
	{
		if (newExtensionPkg != extensionPkg)
		{
			NotificationChain msgs = null;
			if (extensionPkg != null)
				msgs = ((InternalEObject)extensionPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG, null, msgs);
			if (newExtensionPkg != null)
				msgs = ((InternalEObject)newExtensionPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG, null, msgs);
			msgs = basicSetExtensionPkg(newExtensionPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG, newExtensionPkg, newExtensionPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorPkg getDescriptorPkg()
	{
		return descriptorPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptorPkg(DescriptorPkg newDescriptorPkg, NotificationChain msgs)
	{
		DescriptorPkg oldDescriptorPkg = descriptorPkg;
		descriptorPkg = newDescriptorPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG, oldDescriptorPkg, newDescriptorPkg);
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
	public void setDescriptorPkg(DescriptorPkg newDescriptorPkg)
	{
		if (newDescriptorPkg != descriptorPkg)
		{
			NotificationChain msgs = null;
			if (descriptorPkg != null)
				msgs = ((InternalEObject)descriptorPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG, null, msgs);
			if (newDescriptorPkg != null)
				msgs = ((InternalEObject)newDescriptorPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG, null, msgs);
			msgs = basicSetDescriptorPkg(newDescriptorPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG, newDescriptorPkg, newDescriptorPkg));
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
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG:
				return basicSetResourcePkg(null, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG:
				return basicSetDescriptorPkg(null, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__CADENCE:
				return basicSetCadence(null, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG:
				return basicSetExtensionPkg(null, msgs);
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
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG:
				return getResourcePkg();
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG:
				return getDescriptorPkg();
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				return getName();
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
				return isEnabled();
			case ProcessPackage.ABSTRACT_PROCESS__QUEUE_PRIORITY:
				return getQueuePriority();
			case ProcessPackage.ABSTRACT_PROCESS__CADENCE:
				return getCadence();
			case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
				return isWaitingFenceDuringAcquire();
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				return isResetAllowed();
			case ProcessPackage.ABSTRACT_PROCESS__SIGNALS:
				return getSignals();
			case ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR:
				return getWaitFor();
			case ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG:
				return getExtensionPkg();
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
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG:
				setResourcePkg((ResourcePkg)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__QUEUE_PRIORITY:
				setQueuePriority((Float)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__CADENCE:
				setCadence((ICadence)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
				setWaitingFenceDuringAcquire((Boolean)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				setResetAllowed((Boolean)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__SIGNALS:
				getSignals().clear();
				getSignals().addAll((Collection<? extends Semaphore>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR:
				getWaitFor().clear();
				getWaitFor().addAll((Collection<? extends Semaphore>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG:
				setExtensionPkg((ProcessExtensionPkg)newValue);
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
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG:
				setResourcePkg((ResourcePkg)null);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)null);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__QUEUE_PRIORITY:
				setQueuePriority(QUEUE_PRIORITY_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__CADENCE:
				setCadence((ICadence)null);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
				setWaitingFenceDuringAcquire(WAITING_FENCE_DURING_ACQUIRE_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				setResetAllowed(RESET_ALLOWED_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__SIGNALS:
				getSignals().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR:
				getWaitFor().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG:
				setExtensionPkg((ProcessExtensionPkg)null);
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
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG:
				return resourcePkg != null;
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_PKG:
				return descriptorPkg != null;
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.ABSTRACT_PROCESS__QUEUE_PRIORITY:
				return queuePriority != QUEUE_PRIORITY_EDEFAULT;
			case ProcessPackage.ABSTRACT_PROCESS__CADENCE:
				return cadence != null;
			case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
				return waitingFenceDuringAcquire != WAITING_FENCE_DURING_ACQUIRE_EDEFAULT;
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
				return resetAllowed != RESET_ALLOWED_EDEFAULT;
			case ProcessPackage.ABSTRACT_PROCESS__SIGNALS:
				return signals != null && !signals.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR:
				return waitFor != null && !waitFor.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__EXTENSION_PKG:
				return extensionPkg != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == LNamedElement.class)
		{
			switch (derivedFeatureID)
			{
				case ProcessPackage.ABSTRACT_PROCESS__NAME: return TypesPackage.LNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == IExecutionManager.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == LNamedElement.class)
		{
			switch (baseFeatureID)
			{
				case TypesPackage.LNAMED_ELEMENT__NAME: return ProcessPackage.ABSTRACT_PROCESS__NAME;
				default: return -1;
			}
		}
		if (baseClass == IExecutionManager.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", queuePriority: ");
		result.append(queuePriority);
		result.append(", waitingFenceDuringAcquire: ");
		result.append(waitingFenceDuringAcquire);
		result.append(", resetAllowed: ");
		result.append(resetAllowed);
		result.append(')');
		return result.toString();
	}

} //AbstractProcessImpl
