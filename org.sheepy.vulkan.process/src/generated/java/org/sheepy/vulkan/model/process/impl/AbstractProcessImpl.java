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
import org.sheepy.vulkan.model.process.IProcessUnit;
import org.sheepy.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.IResource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getDescriptorSets <em>Descriptor Sets</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getUnits <em>Units</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractProcessImpl#isResetAllowed <em>Reset Allowed</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractProcessImpl extends MinimalEObjectImpl.Container implements AbstractProcess
{
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
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<IProcessUnit> units;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<IResource> resources;

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
	public EList<DescriptorSet> getDescriptorSets()
	{
		if (descriptorSets == null)
		{
			descriptorSets = new EObjectContainmentEList<DescriptorSet>(DescriptorSet.class, this, ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS);
		}
		return descriptorSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IProcessUnit> getUnits()
	{
		if (units == null)
		{
			units = new EObjectContainmentEList<IProcessUnit>(IProcessUnit.class, this, ProcessPackage.ABSTRACT_PROCESS__UNITS);
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IResource> getResources()
	{
		if (resources == null)
		{
			resources = new EObjectContainmentEList<IResource>(IResource.class, this, ProcessPackage.ABSTRACT_PROCESS__RESOURCES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED, oldResetAllowed, resetAllowed));
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
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				return ((InternalEList<?>)getDescriptorSets()).basicRemove(otherEnd, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				return ((InternalEList<?>)getUnits()).basicRemove(otherEnd, msgs);
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
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
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				return getDescriptorSets();
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				return getUnits();
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				return getResources();
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
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
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				getDescriptorSets().clear();
				getDescriptorSets().addAll((Collection<? extends DescriptorSet>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				getUnits().clear();
				getUnits().addAll((Collection<? extends IProcessUnit>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends IResource>)newValue);
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
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
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				getDescriptorSets().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				getUnits().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				getResources().clear();
				return;
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
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
			case ProcessPackage.ABSTRACT_PROCESS__DESCRIPTOR_SETS:
				return descriptorSets != null && !descriptorSets.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__UNITS:
				return units != null && !units.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__RESOURCES:
				return resources != null && !resources.isEmpty();
			case ProcessPackage.ABSTRACT_PROCESS__RESET_ALLOWED:
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

} //AbstractProcessImpl
