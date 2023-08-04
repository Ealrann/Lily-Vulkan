/**
 */
package org.sheepy.lily.vulkan.extra.model.shape.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.extra.model.shape.ShapePackage;
import org.sheepy.lily.vulkan.extra.model.shape.Sphere;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sphere</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.shape.impl.SphereImpl#getSliceCount <em>Slice Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SphereImpl extends GeometricStructureImpl implements Sphere
{
	/**
	 * The default value of the '{@link #getSliceCount() <em>Slice Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int SLICE_COUNT_EDEFAULT = 12;

	/**
	 * The cached value of the '{@link #getSliceCount() <em>Slice Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSliceCount()
	 * @generated
	 * @ordered
	 */
	protected int sliceCount = SLICE_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SphereImpl()
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
		return ShapePackage.Literals.SPHERE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSliceCount()
	{
		return sliceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSliceCount(int newSliceCount)
	{
		int oldSliceCount = sliceCount;
		sliceCount = newSliceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShapePackage.SPHERE__SLICE_COUNT, oldSliceCount, sliceCount));
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
			case ShapePackage.SPHERE__SLICE_COUNT:
				return getSliceCount();
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
		switch (featureID)
		{
			case ShapePackage.SPHERE__SLICE_COUNT:
				setSliceCount((Integer)newValue);
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
			case ShapePackage.SPHERE__SLICE_COUNT:
				setSliceCount(SLICE_COUNT_EDEFAULT);
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
			case ShapePackage.SPHERE__SLICE_COUNT:
				return sliceCount != SLICE_COUNT_EDEFAULT;
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
		result.append(" (sliceCount: ");
		result.append(sliceCount);
		result.append(')');
		return result.toString();
	}

} //SphereImpl
