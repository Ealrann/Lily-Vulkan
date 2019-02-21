/**
 */
package org.sheepy.lily.vulkan.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.model.IResource;
import org.sheepy.lily.vulkan.model.ResourceContainer;
import org.sheepy.lily.vulkan.model.VulkanPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.impl.ResourceContainerImpl#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceContainerImpl extends MinimalEObjectImpl.Container implements ResourceContainer
{
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainerImpl()
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
		return VulkanPackage.Literals.RESOURCE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IResource> getResources()
	{
		if (resources == null)
		{
			resources = new EObjectContainmentEList<IResource>(IResource.class, this, VulkanPackage.RESOURCE_CONTAINER__RESOURCES);
		}
		return resources;
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
			case VulkanPackage.RESOURCE_CONTAINER__RESOURCES:
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
			case VulkanPackage.RESOURCE_CONTAINER__RESOURCES:
				return getResources();
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
			case VulkanPackage.RESOURCE_CONTAINER__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends IResource>)newValue);
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
			case VulkanPackage.RESOURCE_CONTAINER__RESOURCES:
				getResources().clear();
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
			case VulkanPackage.RESOURCE_CONTAINER__RESOURCES:
				return resources != null && !resources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceContainerImpl
