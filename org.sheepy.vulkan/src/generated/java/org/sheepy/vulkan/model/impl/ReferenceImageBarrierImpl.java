/**
 */
package org.sheepy.vulkan.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.vulkan.model.ReferenceImageBarrier;
import org.sheepy.vulkan.model.VulkanPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.impl.ReferenceImageBarrierImpl#getImageId <em>Image Id</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.ReferenceImageBarrierImpl#getMipLevels <em>Mip Levels</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.ReferenceImageBarrierImpl#getImageFormat <em>Image Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImageBarrierImpl extends AbstractImageBarrierImpl implements ReferenceImageBarrier
{
	/**
	 * The default value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected static final long IMAGE_ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getImageId() <em>Image Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageId()
	 * @generated
	 * @ordered
	 */
	protected long imageId = IMAGE_ID_EDEFAULT;

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
		return VulkanPackage.Literals.REFERENCE_IMAGE_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getImageId()
	{
		return imageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageId(long newImageId)
	{
		long oldImageId = imageId;
		imageId = newImageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_ID, oldImageId, imageId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMipLevels()
	{
		return mipLevels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMipLevels(int newMipLevels)
	{
		int oldMipLevels = mipLevels;
		mipLevels = newMipLevels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS, oldMipLevels, mipLevels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getImageFormat()
	{
		return imageFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageFormat(int newImageFormat)
	{
		int oldImageFormat = imageFormat;
		imageFormat = newImageFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT, oldImageFormat, imageFormat));
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
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_ID:
				return getImageId();
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
				return getMipLevels();
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
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
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_ID:
				setImageId((Long)newValue);
				return;
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
				setMipLevels((Integer)newValue);
				return;
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
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
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_ID:
				setImageId(IMAGE_ID_EDEFAULT);
				return;
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
				setMipLevels(MIP_LEVELS_EDEFAULT);
				return;
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
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
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_ID:
				return imageId != IMAGE_ID_EDEFAULT;
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__MIP_LEVELS:
				return mipLevels != MIP_LEVELS_EDEFAULT;
			case VulkanPackage.REFERENCE_IMAGE_BARRIER__IMAGE_FORMAT:
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
		result.append(" (imageId: ");
		result.append(imageId);
		result.append(", mipLevels: ");
		result.append(mipLevels);
		result.append(", imageFormat: ");
		result.append(imageFormat);
		result.append(')');
		return result.toString();
	}

} //ReferenceImageBarrierImpl
