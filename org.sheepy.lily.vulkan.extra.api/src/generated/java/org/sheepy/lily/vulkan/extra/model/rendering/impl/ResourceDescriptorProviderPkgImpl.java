/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Descriptor Provider Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.ResourceDescriptorProviderPkgImpl#getResourceDescriptorProviders <em>Resource Descriptor Providers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceDescriptorProviderPkgImpl extends LilyEObject implements ResourceDescriptorProviderPkg
{
	/**
	 * The cached value of the '{@link #getResourceDescriptorProviders() <em>Resource Descriptor Providers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDescriptorProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceDescriptorProvider> resourceDescriptorProviders;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDescriptorProviderPkgImpl()
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
		return RenderingPackage.Literals.RESOURCE_DESCRIPTOR_PROVIDER_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ResourceDescriptorProvider> getResourceDescriptorProviders()
	{
		if (resourceDescriptorProviders == null)
		{
			resourceDescriptorProviders = new EObjectContainmentEList<ResourceDescriptorProvider>(ResourceDescriptorProvider.class, this, RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS);
		}
		return resourceDescriptorProviders;
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
			case RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS:
				return ((InternalEList<?>)getResourceDescriptorProviders()).basicRemove(otherEnd, msgs);
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
			case RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS:
				return getResourceDescriptorProviders();
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
			case RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS:
				getResourceDescriptorProviders().clear();
				getResourceDescriptorProviders().addAll((Collection<? extends ResourceDescriptorProvider>)newValue);
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
			case RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS:
				getResourceDescriptorProviders().clear();
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
			case RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_PKG__RESOURCE_DESCRIPTOR_PROVIDERS:
				return resourceDescriptorProviders != null && !resourceDescriptorProviders.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceDescriptorProviderPkgImpl
