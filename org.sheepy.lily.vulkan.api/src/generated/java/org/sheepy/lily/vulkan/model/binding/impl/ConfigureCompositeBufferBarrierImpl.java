/**
 */
package org.sheepy.lily.vulkan.model.binding.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.binding.EInstance;

import org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configure Composite Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl#getBarrier <em>Barrier</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureCompositeBufferBarrierImpl#getTargetInstance <em>Target Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigureCompositeBufferBarrierImpl extends LilyEObject implements ConfigureCompositeBufferBarrier
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
	 * The cached value of the '{@link #getBarrier() <em>Barrier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBarrier()
	 * @generated
	 * @ordered
	 */
	protected CompositeBufferBarrier barrier;

	/**
	 * The default value of the '{@link #getTargetInstance() <em>Target Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetInstance()
	 * @generated
	 * @ordered
	 */
	protected static final EInstance TARGET_INSTANCE_EDEFAULT = EInstance.CONTEXT_INSTANCE;

	/**
	 * The cached value of the '{@link #getTargetInstance() <em>Target Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetInstance()
	 * @generated
	 * @ordered
	 */
	protected EInstance targetInstance = TARGET_INSTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigureCompositeBufferBarrierImpl()
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
		return BindingPackage.Literals.CONFIGURE_COMPOSITE_BUFFER_BARRIER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeBufferBarrier getBarrier()
	{
		if (barrier != null && ((EObject)barrier).eIsProxy())
		{
			InternalEObject oldBarrier = (InternalEObject)barrier;
			barrier = (CompositeBufferBarrier)eResolveProxy(oldBarrier);
			if (barrier != oldBarrier)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIER, oldBarrier, barrier));
			}
		}
		return barrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeBufferBarrier basicGetBarrier()
	{
		return barrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarrier(CompositeBufferBarrier newBarrier)
	{
		CompositeBufferBarrier oldBarrier = barrier;
		barrier = newBarrier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIER, oldBarrier, barrier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EInstance getTargetInstance()
	{
		return targetInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetInstance(EInstance newTargetInstance)
	{
		EInstance oldTargetInstance = targetInstance;
		targetInstance = newTargetInstance == null ? TARGET_INSTANCE_EDEFAULT : newTargetInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__TARGET_INSTANCE, oldTargetInstance, targetInstance));
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
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__NAME:
				return getName();
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIER:
				if (resolve) return getBarrier();
				return basicGetBarrier();
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__TARGET_INSTANCE:
				return getTargetInstance();
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
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__NAME:
				setName((String)newValue);
				return;
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIER:
				setBarrier((CompositeBufferBarrier)newValue);
				return;
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__TARGET_INSTANCE:
				setTargetInstance((EInstance)newValue);
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
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIER:
				setBarrier((CompositeBufferBarrier)null);
				return;
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__TARGET_INSTANCE:
				setTargetInstance(TARGET_INSTANCE_EDEFAULT);
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
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__BARRIER:
				return barrier != null;
			case BindingPackage.CONFIGURE_COMPOSITE_BUFFER_BARRIER__TARGET_INSTANCE:
				return targetInstance != TARGET_INSTANCE_EDEFAULT;
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
		result.append(", targetInstance: ");
		result.append(targetInstance);
		result.append(')');
		return result.toString();
	}

} //ConfigureCompositeBufferBarrierImpl
