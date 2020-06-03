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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.binding.BindingConfiguration;
import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.IConfigurationTask;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.BindingConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.BindingConfigurationImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.BindingConfigurationImpl#getDescriptorsSets <em>Descriptors Sets</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.BindingConfigurationImpl#getDescriptorSetStride <em>Descriptor Set Stride</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindingConfigurationImpl extends LilyEObject implements BindingConfiguration
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
	 * The cached value of the '{@link #getDescriptorsSets() <em>Descriptors Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorsSets()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptorSet> descriptorsSets;

	/**
	 * The default value of the '{@link #getDescriptorSetStride() <em>Descriptor Set Stride</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSetStride()
	 * @generated
	 * @ordered
	 */
	protected static final int DESCRIPTOR_SET_STRIDE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDescriptorSetStride() <em>Descriptor Set Stride</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSetStride()
	 * @generated
	 * @ordered
	 */
	protected int descriptorSetStride = DESCRIPTOR_SET_STRIDE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingConfigurationImpl()
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
		return BindingPackage.Literals.BINDING_CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.BINDING_CONFIGURATION__NAME, oldName, name));
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
			tasks = new EObjectContainmentEList<IConfigurationTask>(IConfigurationTask.class, this, BindingPackage.BINDING_CONFIGURATION__TASKS);
		}
		return tasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DescriptorSet> getDescriptorsSets()
	{
		if (descriptorsSets == null)
		{
			descriptorsSets = new EObjectResolvingEList<DescriptorSet>(DescriptorSet.class, this, BindingPackage.BINDING_CONFIGURATION__DESCRIPTORS_SETS);
		}
		return descriptorsSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDescriptorSetStride()
	{
		return descriptorSetStride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorSetStride(int newDescriptorSetStride)
	{
		int oldDescriptorSetStride = descriptorSetStride;
		descriptorSetStride = newDescriptorSetStride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE, oldDescriptorSetStride, descriptorSetStride));
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
			case BindingPackage.BINDING_CONFIGURATION__TASKS:
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
			case BindingPackage.BINDING_CONFIGURATION__NAME:
				return getName();
			case BindingPackage.BINDING_CONFIGURATION__TASKS:
				return getTasks();
			case BindingPackage.BINDING_CONFIGURATION__DESCRIPTORS_SETS:
				return getDescriptorsSets();
			case BindingPackage.BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE:
				return getDescriptorSetStride();
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
			case BindingPackage.BINDING_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case BindingPackage.BINDING_CONFIGURATION__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends IConfigurationTask>)newValue);
				return;
			case BindingPackage.BINDING_CONFIGURATION__DESCRIPTORS_SETS:
				getDescriptorsSets().clear();
				getDescriptorsSets().addAll((Collection<? extends DescriptorSet>)newValue);
				return;
			case BindingPackage.BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE:
				setDescriptorSetStride((Integer)newValue);
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
			case BindingPackage.BINDING_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BindingPackage.BINDING_CONFIGURATION__TASKS:
				getTasks().clear();
				return;
			case BindingPackage.BINDING_CONFIGURATION__DESCRIPTORS_SETS:
				getDescriptorsSets().clear();
				return;
			case BindingPackage.BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE:
				setDescriptorSetStride(DESCRIPTOR_SET_STRIDE_EDEFAULT);
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
			case BindingPackage.BINDING_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BindingPackage.BINDING_CONFIGURATION__TASKS:
				return tasks != null && !tasks.isEmpty();
			case BindingPackage.BINDING_CONFIGURATION__DESCRIPTORS_SETS:
				return descriptorsSets != null && !descriptorsSets.isEmpty();
			case BindingPackage.BINDING_CONFIGURATION__DESCRIPTOR_SET_STRIDE:
				return descriptorSetStride != DESCRIPTOR_SET_STRIDE_EDEFAULT;
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
		result.append(", descriptorSetStride: ");
		result.append(descriptorSetStride);
		result.append(')');
		return result.toString();
	}

} //BindingConfigurationImpl
