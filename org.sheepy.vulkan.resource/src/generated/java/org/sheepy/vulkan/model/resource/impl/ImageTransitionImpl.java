/**
 */
package org.sheepy.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.resource.ImageTransition;
import org.sheepy.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl#getSrcLayout <em>Src Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl#getDstLayout <em>Dst Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl#getSrcAccess <em>Src Access</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.ImageTransitionImpl#getDstAccess <em>Dst Access</em>}</li>
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
	 * The default value of the '{@link #getSrcAccess() <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccess()
	 * @generated
	 * @ordered
	 */
	protected static final int SRC_ACCESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSrcAccess() <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAccess()
	 * @generated
	 * @ordered
	 */
	protected int srcAccess = SRC_ACCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstAccess() <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccess()
	 * @generated
	 * @ordered
	 */
	protected static final int DST_ACCESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDstAccess() <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAccess()
	 * @generated
	 * @ordered
	 */
	protected int dstAccess = DST_ACCESS_EDEFAULT;

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
		return ResourcePackage.Literals.IMAGE_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EImageLayout getSrcLayout()
	{
		return srcLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcLayout(EImageLayout newSrcLayout)
	{
		EImageLayout oldSrcLayout = srcLayout;
		srcLayout = newSrcLayout == null ? SRC_LAYOUT_EDEFAULT : newSrcLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE_TRANSITION__SRC_LAYOUT, oldSrcLayout, srcLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EImageLayout getDstLayout()
	{
		return dstLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDstLayout(EImageLayout newDstLayout)
	{
		EImageLayout oldDstLayout = dstLayout;
		dstLayout = newDstLayout == null ? DST_LAYOUT_EDEFAULT : newDstLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE_TRANSITION__DST_LAYOUT, oldDstLayout, dstLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSrcAccess()
	{
		return srcAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcAccess(int newSrcAccess)
	{
		int oldSrcAccess = srcAccess;
		srcAccess = newSrcAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE_TRANSITION__SRC_ACCESS, oldSrcAccess, srcAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDstAccess()
	{
		return dstAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDstAccess(int newDstAccess)
	{
		int oldDstAccess = dstAccess;
		dstAccess = newDstAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE_TRANSITION__DST_ACCESS, oldDstAccess, dstAccess));
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
			case ResourcePackage.IMAGE_TRANSITION__SRC_LAYOUT:
				return getSrcLayout();
			case ResourcePackage.IMAGE_TRANSITION__DST_LAYOUT:
				return getDstLayout();
			case ResourcePackage.IMAGE_TRANSITION__SRC_ACCESS:
				return getSrcAccess();
			case ResourcePackage.IMAGE_TRANSITION__DST_ACCESS:
				return getDstAccess();
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
			case ResourcePackage.IMAGE_TRANSITION__SRC_LAYOUT:
				setSrcLayout((EImageLayout)newValue);
				return;
			case ResourcePackage.IMAGE_TRANSITION__DST_LAYOUT:
				setDstLayout((EImageLayout)newValue);
				return;
			case ResourcePackage.IMAGE_TRANSITION__SRC_ACCESS:
				setSrcAccess((Integer)newValue);
				return;
			case ResourcePackage.IMAGE_TRANSITION__DST_ACCESS:
				setDstAccess((Integer)newValue);
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
			case ResourcePackage.IMAGE_TRANSITION__SRC_LAYOUT:
				setSrcLayout(SRC_LAYOUT_EDEFAULT);
				return;
			case ResourcePackage.IMAGE_TRANSITION__DST_LAYOUT:
				setDstLayout(DST_LAYOUT_EDEFAULT);
				return;
			case ResourcePackage.IMAGE_TRANSITION__SRC_ACCESS:
				setSrcAccess(SRC_ACCESS_EDEFAULT);
				return;
			case ResourcePackage.IMAGE_TRANSITION__DST_ACCESS:
				setDstAccess(DST_ACCESS_EDEFAULT);
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
			case ResourcePackage.IMAGE_TRANSITION__SRC_LAYOUT:
				return srcLayout != SRC_LAYOUT_EDEFAULT;
			case ResourcePackage.IMAGE_TRANSITION__DST_LAYOUT:
				return dstLayout != DST_LAYOUT_EDEFAULT;
			case ResourcePackage.IMAGE_TRANSITION__SRC_ACCESS:
				return srcAccess != SRC_ACCESS_EDEFAULT;
			case ResourcePackage.IMAGE_TRANSITION__DST_ACCESS:
				return dstAccess != DST_ACCESS_EDEFAULT;
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
		result.append(", srcAccess: ");
		result.append(srcAccess);
		result.append(", dstAccess: ");
		result.append(dstAccess);
		result.append(')');
		return result.toString();
	}

} //ImageTransitionImpl
