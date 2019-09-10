/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.extra.model.mesh.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;

import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geometric Mesh</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.mesh.impl.GeometricMeshImpl#getPresentedEntities <em>Presented Entities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeometricMeshImpl extends LilyEObject implements GeometricMesh
{
	/**
	 * The cached value of the '{@link #getPresentedEntities() <em>Presented Entities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentedEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<PresentableEntity> presentedEntities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometricMeshImpl()
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
		return MeshPackage.Literals.GEOMETRIC_MESH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PresentableEntity> getPresentedEntities()
	{
		if (presentedEntities == null)
		{
			presentedEntities = new EObjectWithInverseResolvingEList<PresentableEntity>(PresentableEntity.class, this, MeshPackage.GEOMETRIC_MESH__PRESENTED_ENTITIES, RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION);
		}
		return presentedEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case MeshPackage.GEOMETRIC_MESH__PRESENTED_ENTITIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPresentedEntities()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case MeshPackage.GEOMETRIC_MESH__PRESENTED_ENTITIES:
				return ((InternalEList<?>)getPresentedEntities()).basicRemove(otherEnd, msgs);
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
			case MeshPackage.GEOMETRIC_MESH__PRESENTED_ENTITIES:
				return getPresentedEntities();
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
			case MeshPackage.GEOMETRIC_MESH__PRESENTED_ENTITIES:
				getPresentedEntities().clear();
				getPresentedEntities().addAll((Collection<? extends PresentableEntity>)newValue);
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
			case MeshPackage.GEOMETRIC_MESH__PRESENTED_ENTITIES:
				getPresentedEntities().clear();
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
			case MeshPackage.GEOMETRIC_MESH__PRESENTED_ENTITIES:
				return presentedEntities != null && !presentedEntities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GeometricMeshImpl
