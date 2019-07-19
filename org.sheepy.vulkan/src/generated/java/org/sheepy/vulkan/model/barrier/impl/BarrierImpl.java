/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.barrier.BarrierPackage;

import org.sheepy.vulkan.model.enumeration.EAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.BarrierImpl#getSrcAccessMask <em>Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.BarrierImpl#getDstAccessMask <em>Dst Access Mask</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BarrierImpl extends MinimalEObjectImpl.Container implements Barrier
{
	/**
	 * The cached value of the '{@link #getSrcAccessMask() <em>Src Access Mask</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccessMask()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> srcAccessMask;

	/**
	 * The cached value of the '{@link #getDstAccessMask() <em>Dst Access Mask</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccessMask()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> dstAccessMask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BarrierImpl()
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
		return BarrierPackage.Literals.BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getSrcAccessMask()
	{
		if (srcAccessMask == null)
		{
			srcAccessMask = new EDataTypeUniqueEList<EAccess>(EAccess.class, this, BarrierPackage.BARRIER__SRC_ACCESS_MASK);
		}
		return srcAccessMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getDstAccessMask()
	{
		if (dstAccessMask == null)
		{
			dstAccessMask = new EDataTypeUniqueEList<EAccess>(EAccess.class, this, BarrierPackage.BARRIER__DST_ACCESS_MASK);
		}
		return dstAccessMask;
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
			case BarrierPackage.BARRIER__SRC_ACCESS_MASK:
				return getSrcAccessMask();
			case BarrierPackage.BARRIER__DST_ACCESS_MASK:
				return getDstAccessMask();
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
			case BarrierPackage.BARRIER__SRC_ACCESS_MASK:
				getSrcAccessMask().clear();
				getSrcAccessMask().addAll((Collection<? extends EAccess>)newValue);
				return;
			case BarrierPackage.BARRIER__DST_ACCESS_MASK:
				getDstAccessMask().clear();
				getDstAccessMask().addAll((Collection<? extends EAccess>)newValue);
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
			case BarrierPackage.BARRIER__SRC_ACCESS_MASK:
				getSrcAccessMask().clear();
				return;
			case BarrierPackage.BARRIER__DST_ACCESS_MASK:
				getDstAccessMask().clear();
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
			case BarrierPackage.BARRIER__SRC_ACCESS_MASK:
				return srcAccessMask != null && !srcAccessMask.isEmpty();
			case BarrierPackage.BARRIER__DST_ACCESS_MASK:
				return dstAccessMask != null && !dstAccessMask.isEmpty();
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
		result.append(" (srcAccessMask: ");
		result.append(srcAccessMask);
		result.append(", dstAccessMask: ");
		result.append(dstAccessMask);
		result.append(')');
		return result.toString();
	}

} //BarrierImpl
