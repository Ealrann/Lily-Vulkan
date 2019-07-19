/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.AbstractImageBarrierImpl#getSrcLayout <em>Src Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.AbstractImageBarrierImpl#getDstLayout <em>Dst Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractImageBarrierImpl extends BarrierImpl implements AbstractImageBarrier
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractImageBarrierImpl()
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
		return BarrierPackage.Literals.ABSTRACT_IMAGE_BARRIER;
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_LAYOUT, oldSrcLayout, srcLayout));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_LAYOUT, oldDstLayout, dstLayout));
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
			case BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_LAYOUT:
				return getSrcLayout();
			case BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_LAYOUT:
				return getDstLayout();
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
			case BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_LAYOUT:
				setSrcLayout((EImageLayout)newValue);
				return;
			case BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_LAYOUT:
				setDstLayout((EImageLayout)newValue);
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
			case BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_LAYOUT:
				setSrcLayout(SRC_LAYOUT_EDEFAULT);
				return;
			case BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_LAYOUT:
				setDstLayout(DST_LAYOUT_EDEFAULT);
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
			case BarrierPackage.ABSTRACT_IMAGE_BARRIER__SRC_LAYOUT:
				return srcLayout != SRC_LAYOUT_EDEFAULT;
			case BarrierPackage.ABSTRACT_IMAGE_BARRIER__DST_LAYOUT:
				return dstLayout != DST_LAYOUT_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //AbstractImageBarrierImpl
