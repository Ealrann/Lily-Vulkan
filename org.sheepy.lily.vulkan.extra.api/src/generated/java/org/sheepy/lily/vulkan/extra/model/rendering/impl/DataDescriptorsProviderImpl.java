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

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Descriptors Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorsProviderImpl#getDataDescriptors <em>Data Descriptors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataDescriptorsProviderImpl extends LilyEObject implements DataDescriptorsProvider
{
	/**
	 * The cached value of the '{@link #getDataDescriptors() <em>Data Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDescriptor> dataDescriptors;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataDescriptorsProviderImpl()
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
		return RenderingPackage.Literals.DATA_DESCRIPTORS_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescriptor> getDataDescriptors()
	{
		if (dataDescriptors == null)
		{
			dataDescriptors = new EObjectContainmentEList<DataDescriptor>(DataDescriptor.class, this, RenderingPackage.DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS);
		}
		return dataDescriptors;
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
			case RenderingPackage.DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS:
				return ((InternalEList<?>)getDataDescriptors()).basicRemove(otherEnd, msgs);
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
			case RenderingPackage.DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS:
				return getDataDescriptors();
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
			case RenderingPackage.DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS:
				getDataDescriptors().clear();
				getDataDescriptors().addAll((Collection<? extends DataDescriptor>)newValue);
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
			case RenderingPackage.DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS:
				getDataDescriptors().clear();
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
			case RenderingPackage.DATA_DESCRIPTORS_PROVIDER__DATA_DESCRIPTORS:
				return dataDescriptors != null && !dataDescriptors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataDescriptorsProviderImpl
