/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.extra.model.mesh.IcoSphere;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ico Sphere</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.mesh.impl.IcoSphereImpl#getSubdivisionCount <em>Subdivision Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IcoSphereImpl extends GeometricStructureImpl implements IcoSphere
{
	/**
	 * The default value of the '{@link #getSubdivisionCount() <em>Subdivision Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubdivisionCount()
	 * @generated
	 * @ordered
	 */
	protected static final int SUBDIVISION_COUNT_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getSubdivisionCount() <em>Subdivision Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubdivisionCount()
	 * @generated
	 * @ordered
	 */
	protected int subdivisionCount = SUBDIVISION_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IcoSphereImpl()
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
		return MeshPackage.Literals.ICO_SPHERE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSubdivisionCount()
	{
		return subdivisionCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSubdivisionCount(int newSubdivisionCount)
	{
		int oldSubdivisionCount = subdivisionCount;
		subdivisionCount = newSubdivisionCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MeshPackage.ICO_SPHERE__SUBDIVISION_COUNT, oldSubdivisionCount, subdivisionCount));
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
			case MeshPackage.ICO_SPHERE__SUBDIVISION_COUNT:
				return getSubdivisionCount();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case MeshPackage.ICO_SPHERE__SUBDIVISION_COUNT:
				setSubdivisionCount((Integer)newValue);
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
			case MeshPackage.ICO_SPHERE__SUBDIVISION_COUNT:
				setSubdivisionCount(SUBDIVISION_COUNT_EDEFAULT);
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
			case MeshPackage.ICO_SPHERE__SUBDIVISION_COUNT:
				return subdivisionCount != SUBDIVISION_COUNT_EDEFAULT;
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
		result.append(" (subdivisionCount: ");
		result.append(subdivisionCount);
		result.append(')');
		return result.toString();
	}

} //IcoSphereImpl
