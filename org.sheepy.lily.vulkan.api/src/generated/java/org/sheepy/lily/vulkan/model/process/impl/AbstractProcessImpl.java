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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.IExecutionManager;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#isFenceEnabled <em>Fence Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#isWaitingFenceDuringAcquire <em>Waiting Fence During Acquire</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getDescriptorSets <em>Descriptor Sets</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#isResetAllowed <em>Reset Allowed</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getSignals <em>Signals</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl#getWaitFor <em>Wait For</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractProcessImpl extends MinimalEObjectImpl.Container
		implements AbstractProcess
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
	 * The default value of the '{@link #isFenceEnabled() <em>Fence Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFenceEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FENCE_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFenceEnabled() <em>Fence Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFenceEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean fenceEnabled = FENCE_ENABLED_EDEFAULT;

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
	 * The cached value of the '{@link #getDescriptorSets() <em>Descriptor Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSets()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptorSet> descriptorSets;

	/**
	 * The cached value of the '{@link #getPipelinePkg() <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipelinePkg()
	 * @generated
	 * @ordered
	 */
	protected PipelinePkg pipelinePkg;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractProcessImpl()
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
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
			if (resourcePkg != null) msgs = ((InternalEObject) resourcePkg).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG, null,
					msgs);
			if (newResourcePkg != null) msgs = ((InternalEObject) newResourcePkg).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG, null,
					msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG, newResourcePkg, newResourcePkg));
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
				ProcessPackage.ABSTRACT_PROCESS__NAME, oldName, name));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PROCESS__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFenceEnabled()
	{
		return fenceEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFenceEnabled(boolean newFenceEnabled)
	{
		boolean oldFenceEnabled = fenceEnabled;
		fenceEnabled = newFenceEnabled;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PROCESS__FENCE_ENABLED, oldFenceEnabled, fenceEnabled));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE,
				oldWaitingFenceDuringAcquire, waitingFenceDuringAcquire));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DescriptorSet> getDescriptorSets()
	{
		if (descriptorSets == null)
		{
			descriptorSets = new EObjectContainmentEList<DescriptorSet>(DescriptorSet.class, this,
					ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS);
		}
		return descriptorSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelinePkg getPipelinePkg()
	{
		return pipelinePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPipelinePkg(PipelinePkg newPipelinePkg, NotificationChain msgs)
	{
		PipelinePkg oldPipelinePkg = pipelinePkg;
		pipelinePkg = newPipelinePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG, oldPipelinePkg, newPipelinePkg);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPipelinePkg(PipelinePkg newPipelinePkg)
	{
		if (newPipelinePkg != pipelinePkg)
		{
			NotificationChain msgs = null;
			if (pipelinePkg != null) msgs = ((InternalEObject) pipelinePkg).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG, null,
					msgs);
			if (newPipelinePkg != null) msgs = ((InternalEObject) newPipelinePkg).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG, null,
					msgs);
			msgs = basicSetPipelinePkg(newPipelinePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG, newPipelinePkg, newPipelinePkg));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED, oldResetAllowed, resetAllowed));
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
			signals = new EObjectResolvingEList<Semaphore>(Semaphore.class, this,
					ProcessPackage.ABSTRACT_PROCESS__SIGNALS);
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
			waitFor = new EObjectResolvingEList<Semaphore>(Semaphore.class, this,
					ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR);
		}
		return waitFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case ProcessPackage.ABSTRACT_PROCESS__RESOURCE_PKG:
			return basicSetResourcePkg(null, msgs);
		case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
			return ((InternalEList<?>) getDescriptorSets()).basicRemove(otherEnd, msgs);
		case ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG:
			return basicSetPipelinePkg(null, msgs);
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
		case ProcessPackage.ABSTRACT_PROCESS__NAME:
			return getName();
		case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
			return isEnabled();
		case ProcessPackage.ABSTRACT_PROCESS__FENCE_ENABLED:
			return isFenceEnabled();
		case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
			return isWaitingFenceDuringAcquire();
		case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
			return getDescriptorSets();
		case ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG:
			return getPipelinePkg();
		case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
			return isResetAllowed();
		case ProcessPackage.ABSTRACT_PROCESS__SIGNALS:
			return getSignals();
		case ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR:
			return getWaitFor();
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
			setResourcePkg((ResourcePkg) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__NAME:
			setName((String) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__FENCE_ENABLED:
			setFenceEnabled((Boolean) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
			setWaitingFenceDuringAcquire((Boolean) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
			getDescriptorSets().clear();
			getDescriptorSets().addAll((Collection<? extends DescriptorSet>) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG:
			setPipelinePkg((PipelinePkg) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
			setResetAllowed((Boolean) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__SIGNALS:
			getSignals().clear();
			getSignals().addAll((Collection<? extends Semaphore>) newValue);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR:
			getWaitFor().clear();
			getWaitFor().addAll((Collection<? extends Semaphore>) newValue);
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
			setResourcePkg((ResourcePkg) null);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__FENCE_ENABLED:
			setFenceEnabled(FENCE_ENABLED_EDEFAULT);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
			setWaitingFenceDuringAcquire(WAITING_FENCE_DURING_ACQUIRE_EDEFAULT);
			return;
		case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
			getDescriptorSets().clear();
			return;
		case ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG:
			setPipelinePkg((PipelinePkg) null);
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
		case ProcessPackage.ABSTRACT_PROCESS__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ProcessPackage.ABSTRACT_PROCESS__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case ProcessPackage.ABSTRACT_PROCESS__FENCE_ENABLED:
			return fenceEnabled != FENCE_ENABLED_EDEFAULT;
		case ProcessPackage.ABSTRACT_PROCESS__WAITING_FENCE_DURING_ACQUIRE:
			return waitingFenceDuringAcquire != WAITING_FENCE_DURING_ACQUIRE_EDEFAULT;
		case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
			return descriptorSets != null && !descriptorSets.isEmpty();
		case ProcessPackage.ABSTRACT_PROCESS__PIPELINE_PKG:
			return pipelinePkg != null;
		case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
			return resetAllowed != RESET_ALLOWED_EDEFAULT;
		case ProcessPackage.ABSTRACT_PROCESS__SIGNALS:
			return signals != null && !signals.isEmpty();
		case ProcessPackage.ABSTRACT_PROCESS__WAIT_FOR:
			return waitFor != null && !waitFor.isEmpty();
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
			case ProcessPackage.ABSTRACT_PROCESS__NAME:
				return TypesPackage.LNAMED_ELEMENT__NAME;
			default:
				return -1;
			}
		}
		if (baseClass == IExecutionManager.class)
		{
			switch (derivedFeatureID)
			{
			default:
				return -1;
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
			case TypesPackage.LNAMED_ELEMENT__NAME:
				return ProcessPackage.ABSTRACT_PROCESS__NAME;
			default:
				return -1;
			}
		}
		if (baseClass == IExecutionManager.class)
		{
			switch (baseFeatureID)
			{
			default:
				return -1;
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
		result.append(", fenceEnabled: ");
		result.append(fenceEnabled);
		result.append(", waitingFenceDuringAcquire: ");
		result.append(waitingFenceDuringAcquire);
		result.append(", resetAllowed: ");
		result.append(resetAllowed);
		result.append(')');
		return result.toString();
	}

} //AbstractProcessImpl
