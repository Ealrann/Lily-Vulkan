/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.barrier.ImageTransition;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl#getSrcLayout <em>Src Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl#getDstLayout <em>Dst Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl#getSrcAccessMask <em>Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl#getDstAccessMask <em>Dst Access Mask</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageTransitionImpl extends MinimalEObjectImpl.Container implements ImageTransition
{
	/**
	 * The default value of the '{@link #getSrcLayout() <em>Src Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout SRC_LAYOUT_EDEFAULT = EImageLayout.UNDEFINED;

	/**
	 * The cached value of the '{@link #getSrcLayout() <em>Src Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout srcLayout = SRC_LAYOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstLayout() <em>Dst Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout DST_LAYOUT_EDEFAULT = EImageLayout.UNDEFINED;

	/**
	 * The cached value of the '{@link #getDstLayout() <em>Dst Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout dstLayout = DST_LAYOUT_EDEFAULT;

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
	public ImageTransitionImpl()
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
		return BarrierPackage.Literals.IMAGE_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImageLayout getSrcLayout()
	{
		return srcLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcLayout(EImageLayout newSrcLayout)
	{
		EImageLayout oldSrcLayout = srcLayout;
		srcLayout = newSrcLayout == null ? SRC_LAYOUT_EDEFAULT : newSrcLayout;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				BarrierPackage.IMAGE_TRANSITION__SRC_LAYOUT, oldSrcLayout, srcLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImageLayout getDstLayout()
	{
		return dstLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstLayout(EImageLayout newDstLayout)
	{
		EImageLayout oldDstLayout = dstLayout;
		dstLayout = newDstLayout == null ? DST_LAYOUT_EDEFAULT : newDstLayout;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				BarrierPackage.IMAGE_TRANSITION__DST_LAYOUT, oldDstLayout, dstLayout));
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
			srcAccessMask = new EDataTypeUniqueEList<EAccess>(EAccess.class, this,
					BarrierPackage.IMAGE_TRANSITION__SRC_ACCESS_MASK);
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
			dstAccessMask = new EDataTypeUniqueEList<EAccess>(EAccess.class, this,
					BarrierPackage.IMAGE_TRANSITION__DST_ACCESS_MASK);
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
		case BarrierPackage.IMAGE_TRANSITION__SRC_LAYOUT:
			return getSrcLayout();
		case BarrierPackage.IMAGE_TRANSITION__DST_LAYOUT:
			return getDstLayout();
		case BarrierPackage.IMAGE_TRANSITION__SRC_ACCESS_MASK:
			return getSrcAccessMask();
		case BarrierPackage.IMAGE_TRANSITION__DST_ACCESS_MASK:
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
		case BarrierPackage.IMAGE_TRANSITION__SRC_LAYOUT:
			setSrcLayout((EImageLayout) newValue);
			return;
		case BarrierPackage.IMAGE_TRANSITION__DST_LAYOUT:
			setDstLayout((EImageLayout) newValue);
			return;
		case BarrierPackage.IMAGE_TRANSITION__SRC_ACCESS_MASK:
			getSrcAccessMask().clear();
			getSrcAccessMask().addAll((Collection<? extends EAccess>) newValue);
			return;
		case BarrierPackage.IMAGE_TRANSITION__DST_ACCESS_MASK:
			getDstAccessMask().clear();
			getDstAccessMask().addAll((Collection<? extends EAccess>) newValue);
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
		case BarrierPackage.IMAGE_TRANSITION__SRC_LAYOUT:
			setSrcLayout(SRC_LAYOUT_EDEFAULT);
			return;
		case BarrierPackage.IMAGE_TRANSITION__DST_LAYOUT:
			setDstLayout(DST_LAYOUT_EDEFAULT);
			return;
		case BarrierPackage.IMAGE_TRANSITION__SRC_ACCESS_MASK:
			getSrcAccessMask().clear();
			return;
		case BarrierPackage.IMAGE_TRANSITION__DST_ACCESS_MASK:
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
		case BarrierPackage.IMAGE_TRANSITION__SRC_LAYOUT:
			return srcLayout != SRC_LAYOUT_EDEFAULT;
		case BarrierPackage.IMAGE_TRANSITION__DST_LAYOUT:
			return dstLayout != DST_LAYOUT_EDEFAULT;
		case BarrierPackage.IMAGE_TRANSITION__SRC_ACCESS_MASK:
			return srcAccessMask != null && !srcAccessMask.isEmpty();
		case BarrierPackage.IMAGE_TRANSITION__DST_ACCESS_MASK:
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
		result.append(" (srcLayout: ");
		result.append(srcLayout);
		result.append(", dstLayout: ");
		result.append(dstLayout);
		result.append(", srcAccessMask: ");
		result.append(srcAccessMask);
		result.append(", dstAccessMask: ");
		result.append(dstAccessMask);
		result.append(')');
		return result.toString();
	}

} //ImageTransitionImpl
