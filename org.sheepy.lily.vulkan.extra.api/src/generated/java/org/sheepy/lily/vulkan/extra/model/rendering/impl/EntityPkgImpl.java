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

import org.sheepy.lily.vulkan.extra.model.rendering.Entity;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.EntityPkgImpl#getEntities <em>Entities</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EntityPkgImpl<T extends Entity> extends LilyEObject implements EntityPkg<T>
{
	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<T> entities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityPkgImpl()
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
		return RenderingPackage.Literals.ENTITY_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<T> getEntities()
	{
		if (entities == null)
		{
			entities = new EObjectContainmentEList<T>(Entity.class, this, RenderingPackage.ENTITY_PKG__ENTITIES);
		}
		return entities;
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
			case RenderingPackage.ENTITY_PKG__ENTITIES:
				return ((InternalEList<?>)getEntities()).basicRemove(otherEnd, msgs);
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
			case RenderingPackage.ENTITY_PKG__ENTITIES:
				return getEntities();
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
			case RenderingPackage.ENTITY_PKG__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends T>)newValue);
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
			case RenderingPackage.ENTITY_PKG__ENTITIES:
				getEntities().clear();
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
			case RenderingPackage.ENTITY_PKG__ENTITIES:
				return entities != null && !entities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EntityPkgImpl
