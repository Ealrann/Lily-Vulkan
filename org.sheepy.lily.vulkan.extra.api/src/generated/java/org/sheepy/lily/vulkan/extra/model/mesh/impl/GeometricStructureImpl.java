/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.extra.model.mesh.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.mesh.GeometricStructure;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Geometric Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.mesh.impl.GeometricStructureImpl#getMeshes <em>Meshes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GeometricStructureImpl extends IMeshStructureImpl implements GeometricStructure
{
	/**
	 * The cached value of the '{@link #getMeshes() <em>Meshes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeshes()
	 * @generated
	 * @ordered
	 */
	protected EList<GeometricMesh> meshes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometricStructureImpl()
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
		return MeshPackage.Literals.GEOMETRIC_STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GeometricMesh> getMeshes()
	{
		if (meshes == null) {
			meshes = new EObjectContainmentEList<GeometricMesh>(GeometricMesh.class, this, MeshPackage.GEOMETRIC_STRUCTURE__MESHES);
		}
		return meshes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case MeshPackage.GEOMETRIC_STRUCTURE__MESHES:
				return ((InternalEList<?>)getMeshes()).basicRemove(otherEnd, msgs);
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
		switch (featureID) {
			case MeshPackage.GEOMETRIC_STRUCTURE__MESHES:
				return getMeshes();
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
		switch (featureID) {
			case MeshPackage.GEOMETRIC_STRUCTURE__MESHES:
				getMeshes().clear();
				getMeshes().addAll((Collection<? extends GeometricMesh>)newValue);
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
		switch (featureID) {
			case MeshPackage.GEOMETRIC_STRUCTURE__MESHES:
				getMeshes().clear();
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
		switch (featureID) {
			case MeshPackage.GEOMETRIC_STRUCTURE__MESHES:
				return meshes != null && !meshes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GeometricStructureImpl
