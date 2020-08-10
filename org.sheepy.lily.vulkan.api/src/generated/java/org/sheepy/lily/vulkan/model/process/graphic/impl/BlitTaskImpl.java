/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.vulkan.model.process.graphic.BlitTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Blit Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BlitTaskImpl#getDstImage <em>Dst Image</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlitTaskImpl extends AbstractBlitTaskImpl implements BlitTask
{
	/**
	 * The cached value of the '{@link #getDstImage() <em>Dst Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstImage()
	 * @generated
	 * @ordered
	 */
	protected IImage dstImage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlitTaskImpl()
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
		return GraphicPackage.Literals.BLIT_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IImage getDstImage()
	{
		if (dstImage != null && ((EObject)dstImage).eIsProxy()) {
			InternalEObject oldDstImage = dstImage;
			dstImage = (IImage)eResolveProxy(oldDstImage);
			if (dstImage != oldDstImage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.BLIT_TASK__DST_IMAGE, oldDstImage, dstImage));
			}
		}
		return dstImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IImage basicGetDstImage()
	{
		return dstImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstImage(IImage newDstImage)
	{
		IImage oldDstImage = dstImage;
		dstImage = newDstImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.BLIT_TASK__DST_IMAGE, oldDstImage, dstImage));
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
			case GraphicPackage.BLIT_TASK__DST_IMAGE:
				if (resolve) return getDstImage();
				return basicGetDstImage();
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
			case GraphicPackage.BLIT_TASK__DST_IMAGE:
				setDstImage((IImage)newValue);
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
			case GraphicPackage.BLIT_TASK__DST_IMAGE:
				setDstImage((IImage)null);
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
			case GraphicPackage.BLIT_TASK__DST_IMAGE:
				return dstImage != null;
		}
		return super.eIsSet(featureID);
	}

} //BlitTaskImpl
