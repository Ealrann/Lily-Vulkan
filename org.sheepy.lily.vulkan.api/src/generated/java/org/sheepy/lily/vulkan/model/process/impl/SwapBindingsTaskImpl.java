/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.SwapBindingsTask;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Swap Bindings Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.SwapBindingsTaskImpl#getTask <em>Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.SwapBindingsTaskImpl#getDescriptorSets <em>Descriptor Sets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SwapBindingsTaskImpl extends LilyEObject implements SwapBindingsTask
{
	/**
	 * The cached value of the '{@link #getTask() <em>Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTask()
	 * @generated
	 * @ordered
	 */
	protected BindDescriptorSets task;

	/**
	 * The cached value of the '{@link #getDescriptorSets() <em>Descriptor Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSets()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptorSet> descriptorSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwapBindingsTaskImpl()
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
		return ProcessPackage.Literals.SWAP_BINDINGS_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindDescriptorSets getTask()
	{
		if (task != null && ((EObject)task).eIsProxy())
		{
			InternalEObject oldTask = task;
			task = (BindDescriptorSets)eResolveProxy(oldTask);
			if (task != oldTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.SWAP_BINDINGS_TASK__TASK, oldTask, task));
			}
		}
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindDescriptorSets basicGetTask()
	{
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTask(BindDescriptorSets newTask)
	{
		BindDescriptorSets oldTask = task;
		task = newTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SWAP_BINDINGS_TASK__TASK, oldTask, task));
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
			descriptorSets = new EObjectResolvingEList<DescriptorSet>(DescriptorSet.class, this, ProcessPackage.SWAP_BINDINGS_TASK__DESCRIPTOR_SETS);
		}
		return descriptorSets;
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
			case ProcessPackage.SWAP_BINDINGS_TASK__TASK:
				if (resolve) return getTask();
				return basicGetTask();
			case ProcessPackage.SWAP_BINDINGS_TASK__DESCRIPTOR_SETS:
				return getDescriptorSets();
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
			case ProcessPackage.SWAP_BINDINGS_TASK__TASK:
				setTask((BindDescriptorSets)newValue);
				return;
			case ProcessPackage.SWAP_BINDINGS_TASK__DESCRIPTOR_SETS:
				getDescriptorSets().clear();
				getDescriptorSets().addAll((Collection<? extends DescriptorSet>)newValue);
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
			case ProcessPackage.SWAP_BINDINGS_TASK__TASK:
				setTask((BindDescriptorSets)null);
				return;
			case ProcessPackage.SWAP_BINDINGS_TASK__DESCRIPTOR_SETS:
				getDescriptorSets().clear();
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
			case ProcessPackage.SWAP_BINDINGS_TASK__TASK:
				return task != null;
			case ProcessPackage.SWAP_BINDINGS_TASK__DESCRIPTOR_SETS:
				return descriptorSets != null && !descriptorSets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SwapBindingsTaskImpl
