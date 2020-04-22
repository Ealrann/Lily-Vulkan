/**
 */
package org.sheepy.lily.vulkan.model.binding.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.IConfigurationTask;
import org.sheepy.lily.vulkan.model.binding.IndexConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.IndexConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.IndexConfigurationImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.IndexConfigurationImpl#getIndexCount <em>Index Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexConfigurationImpl extends LilyEObject implements IndexConfiguration
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
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<IConfigurationTask> tasks;

	/**
	 * The default value of the '{@link #getIndexCount() <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexCount()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_COUNT_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getIndexCount() <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexCount()
	 * @generated
	 * @ordered
	 */
	protected int indexCount = INDEX_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexConfigurationImpl()
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
		return BindingPackage.Literals.INDEX_CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.INDEX_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IConfigurationTask> getTasks()
	{
		if (tasks == null)
		{
			tasks = new EObjectContainmentEList<IConfigurationTask>(IConfigurationTask.class, this, BindingPackage.INDEX_CONFIGURATION__TASKS);
		}
		return tasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIndexCount()
	{
		return indexCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexCount(int newIndexCount)
	{
		int oldIndexCount = indexCount;
		indexCount = newIndexCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.INDEX_CONFIGURATION__INDEX_COUNT, oldIndexCount, indexCount));
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
			case BindingPackage.INDEX_CONFIGURATION__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
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
			case BindingPackage.INDEX_CONFIGURATION__NAME:
				return getName();
			case BindingPackage.INDEX_CONFIGURATION__TASKS:
				return getTasks();
			case BindingPackage.INDEX_CONFIGURATION__INDEX_COUNT:
				return getIndexCount();
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
			case BindingPackage.INDEX_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case BindingPackage.INDEX_CONFIGURATION__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends IConfigurationTask>)newValue);
				return;
			case BindingPackage.INDEX_CONFIGURATION__INDEX_COUNT:
				setIndexCount((Integer)newValue);
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
			case BindingPackage.INDEX_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BindingPackage.INDEX_CONFIGURATION__TASKS:
				getTasks().clear();
				return;
			case BindingPackage.INDEX_CONFIGURATION__INDEX_COUNT:
				setIndexCount(INDEX_COUNT_EDEFAULT);
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
			case BindingPackage.INDEX_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BindingPackage.INDEX_CONFIGURATION__TASKS:
				return tasks != null && !tasks.isEmpty();
			case BindingPackage.INDEX_CONFIGURATION__INDEX_COUNT:
				return indexCount != INDEX_COUNT_EDEFAULT;
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
		result.append(", indexCount: ");
		result.append(indexCount);
		result.append(')');
		return result.toString();
	}

} //IndexConfigurationImpl
