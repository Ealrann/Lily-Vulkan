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
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl#getBuilder <em>Builder</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl#getRepeatCount <em>Repeat Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.CompositeTaskImpl#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeTaskImpl extends MinimalEObjectImpl.Container implements CompositeTask
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
	 * The cached value of the '{@link #getBuilder() <em>Builder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuilder()
	 * @generated
	 * @ordered
	 */
	protected Maintainer<CompositeTask> builder;

	/**
	 * The default value of the '{@link #getRepeatCount() <em>Repeat Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeatCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REPEAT_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getRepeatCount() <em>Repeat Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeatCount()
	 * @generated
	 * @ordered
	 */
	protected int repeatCount = REPEAT_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<IPipelineTask> tasks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeTaskImpl()
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
		return ProcessPackage.Literals.COMPOSITE_TASK;
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
				ProcessPackage.COMPOSITE_TASK__NAME, oldName, name));
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
				ProcessPackage.COMPOSITE_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Maintainer<CompositeTask> getBuilder()
	{
		return builder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBuilder(	Maintainer<CompositeTask> newBuilder,
												NotificationChain msgs)
	{
		Maintainer<CompositeTask> oldBuilder = builder;
		builder = newBuilder;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ProcessPackage.COMPOSITE_TASK__BUILDER, oldBuilder, newBuilder);
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
	public void setBuilder(Maintainer<CompositeTask> newBuilder)
	{
		if (newBuilder != builder)
		{
			NotificationChain msgs = null;
			if (builder != null) msgs = ((InternalEObject) builder).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.COMPOSITE_TASK__BUILDER, null, msgs);
			if (newBuilder != null) msgs = ((InternalEObject) newBuilder).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.COMPOSITE_TASK__BUILDER, null, msgs);
			msgs = basicSetBuilder(newBuilder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.COMPOSITE_TASK__BUILDER, newBuilder, newBuilder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRepeatCount()
	{
		return repeatCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepeatCount(int newRepeatCount)
	{
		int oldRepeatCount = repeatCount;
		repeatCount = newRepeatCount;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.COMPOSITE_TASK__REPEAT_COUNT, oldRepeatCount, repeatCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IPipelineTask> getTasks()
	{
		if (tasks == null)
		{
			tasks = new EObjectContainmentEList<IPipelineTask>(IPipelineTask.class, this,
					ProcessPackage.COMPOSITE_TASK__TASKS);
		}
		return tasks;
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
		case ProcessPackage.COMPOSITE_TASK__BUILDER:
			return basicSetBuilder(null, msgs);
		case ProcessPackage.COMPOSITE_TASK__TASKS:
			return ((InternalEList<?>) getTasks()).basicRemove(otherEnd, msgs);
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
		case ProcessPackage.COMPOSITE_TASK__NAME:
			return getName();
		case ProcessPackage.COMPOSITE_TASK__ENABLED:
			return isEnabled();
		case ProcessPackage.COMPOSITE_TASK__BUILDER:
			return getBuilder();
		case ProcessPackage.COMPOSITE_TASK__REPEAT_COUNT:
			return getRepeatCount();
		case ProcessPackage.COMPOSITE_TASK__TASKS:
			return getTasks();
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
		case ProcessPackage.COMPOSITE_TASK__NAME:
			setName((String) newValue);
			return;
		case ProcessPackage.COMPOSITE_TASK__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case ProcessPackage.COMPOSITE_TASK__BUILDER:
			setBuilder((Maintainer<CompositeTask>) newValue);
			return;
		case ProcessPackage.COMPOSITE_TASK__REPEAT_COUNT:
			setRepeatCount((Integer) newValue);
			return;
		case ProcessPackage.COMPOSITE_TASK__TASKS:
			getTasks().clear();
			getTasks().addAll((Collection<? extends IPipelineTask>) newValue);
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
		case ProcessPackage.COMPOSITE_TASK__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ProcessPackage.COMPOSITE_TASK__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case ProcessPackage.COMPOSITE_TASK__BUILDER:
			setBuilder((Maintainer<CompositeTask>) null);
			return;
		case ProcessPackage.COMPOSITE_TASK__REPEAT_COUNT:
			setRepeatCount(REPEAT_COUNT_EDEFAULT);
			return;
		case ProcessPackage.COMPOSITE_TASK__TASKS:
			getTasks().clear();
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
		case ProcessPackage.COMPOSITE_TASK__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ProcessPackage.COMPOSITE_TASK__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case ProcessPackage.COMPOSITE_TASK__BUILDER:
			return builder != null;
		case ProcessPackage.COMPOSITE_TASK__REPEAT_COUNT:
			return repeatCount != REPEAT_COUNT_EDEFAULT;
		case ProcessPackage.COMPOSITE_TASK__TASKS:
			return tasks != null && !tasks.isEmpty();
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
		if (baseClass == Maintainable.class)
		{
			switch (derivedFeatureID)
			{
			case ProcessPackage.COMPOSITE_TASK__BUILDER:
				return MaintainerPackage.MAINTAINABLE__BUILDER;
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
		if (baseClass == Maintainable.class)
		{
			switch (baseFeatureID)
			{
			case MaintainerPackage.MAINTAINABLE__BUILDER:
				return ProcessPackage.COMPOSITE_TASK__BUILDER;
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
		result.append(", repeatCount: ");
		result.append(repeatCount);
		result.append(')');
		return result.toString();
	}

} //CompositeTaskImpl
