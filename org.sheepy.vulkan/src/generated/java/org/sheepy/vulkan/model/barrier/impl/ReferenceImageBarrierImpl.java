/**
 */
package org.sheepy.vulkan.model.barrier.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.vulkan.model.barrier.BarrierPackage;
import org.sheepy.vulkan.model.barrier.ReferenceImageBarrier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ReferenceImageBarrierImpl#getImagePtr <em>Image Ptr</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ReferenceImageBarrierImpl#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.impl.ReferenceImageBarrierImpl#getImageFormat <em>Image Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImageBarrierImpl extends AbstractImageBarrierImpl implements ReferenceImageBarrier
{
	/**
	 * The default value of the '{@link #getImagePtr() <em>Image Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImagePtr()
	 * @generated
	 * @ordered
	 */
	protected static final long IMAGE_PTR_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getImagePtr() <em>Image Ptr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImagePtr()
	 * @generated
	 * @ordered
	 */
	protected long imagePtr = IMAGE_PTR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMipLevels() <em>Mip Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMipLevels()
	 * @generated
	 * @ordered
	 */
	protected static final int MIP_LEVELS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMipLevels() <em>Mip Levels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMipLevels()
	 * @generated
	 * @ordered
	 */
	protected int mipLevels = MIP_LEVELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageFormat() <em>Image Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageFormat()
	 * @generated
	 * @ordered
	 */
	protected static final int IMAGE_FORMAT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getImageFormat() <em>Image Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageFormat()
	 * @generated
	 * @ordered
	 */
	protected int imageFormat = IMAGE_FORMAT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceImageBarrierImpl()
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
		return BarrierPackage.Literals.REFERENCE_IMAGE_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getImagePtr()
	{
		return imagePtr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImagePtr(long newImagePtr)
	{
		long oldImagePtr = imagePtr;
		imagePtr = newImagePtr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_PTR, oldImagePtr, imagePtr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMipLevels()
	{
		return mipLevels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMipLevels(int newMipLevels)
	{
		int oldMipLevels = mipLevels;
		mipLevels = newMipLevels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BarrierPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS, oldMipLevels, mipLevels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getImageFormat()
	{
		return imageFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageFormat(int newImageFormat)
	{
		int oldImageFormat = imageFormat;
		imageFormat = newImageFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT, oldImageFormat, imageFormat));
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
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_PTR:
				return getImagePtr();
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
				return getMipLevels();
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
				return getImageFormat();
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
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_PTR:
				setImagePtr((Long)newValue);
				return;
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
				setMipLevels((Integer)newValue);
				return;
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
				setImageFormat((Integer)newValue);
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
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_PTR:
				setImagePtr(IMAGE_PTR_EDEFAULT);
				return;
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
				setMipLevels(MIP_LEVELS_EDEFAULT);
				return;
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
				setImageFormat(IMAGE_FORMAT_EDEFAULT);
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
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_PTR:
				return imagePtr != IMAGE_PTR_EDEFAULT;
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
				return mipLevels != MIP_LEVELS_EDEFAULT;
			case BarrierPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
				return imageFormat != IMAGE_FORMAT_EDEFAULT;
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
		result.append(" (imagePtr: ");
		result.append(imagePtr);
		result.append(", mipLevels: ");
		result.append(mipLevels);
		result.append(", imageFormat: ");
		result.append(imageFormat);
		result.append(')');
		return result.toString();
	}

} //ReferenceImageBarrierImpl
