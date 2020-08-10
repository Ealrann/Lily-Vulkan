/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.resource.impl.IResourceImpl;

import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transfer Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl#isUsedToPush <em>Used To Push</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.TransferBufferImpl#isUsedToFetch <em>Used To Fetch</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransferBufferImpl extends IResourceImpl implements TransferBuffer
{
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final long SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected long size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isUsedToPush() <em>Used To Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsedToPush()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USED_TO_PUSH_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isUsedToPush() <em>Used To Push</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsedToPush()
	 * @generated
	 * @ordered
	 */
	protected boolean usedToPush = USED_TO_PUSH_EDEFAULT;

	/**
	 * The default value of the '{@link #isUsedToFetch() <em>Used To Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsedToFetch()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USED_TO_FETCH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUsedToFetch() <em>Used To Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUsedToFetch()
	 * @generated
	 * @ordered
	 */
	protected boolean usedToFetch = USED_TO_FETCH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransferBufferImpl()
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
		return VulkanResourcePackage.Literals.TRANSFER_BUFFER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(long newSize)
	{
		long oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.TRANSFER_BUFFER__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUsedToPush()
	{
		return usedToPush;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsedToPush(boolean newUsedToPush)
	{
		boolean oldUsedToPush = usedToPush;
		usedToPush = newUsedToPush;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_PUSH, oldUsedToPush, usedToPush));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUsedToFetch()
	{
		return usedToFetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsedToFetch(boolean newUsedToFetch)
	{
		boolean oldUsedToFetch = usedToFetch;
		usedToFetch = newUsedToFetch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_FETCH, oldUsedToFetch, usedToFetch));
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
			case VulkanResourcePackage.TRANSFER_BUFFER__SIZE:
				return getSize();
			case VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_PUSH:
				return isUsedToPush();
			case VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_FETCH:
				return isUsedToFetch();
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
			case VulkanResourcePackage.TRANSFER_BUFFER__SIZE:
				setSize((Long)newValue);
				return;
			case VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_PUSH:
				setUsedToPush((Boolean)newValue);
				return;
			case VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_FETCH:
				setUsedToFetch((Boolean)newValue);
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
			case VulkanResourcePackage.TRANSFER_BUFFER__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_PUSH:
				setUsedToPush(USED_TO_PUSH_EDEFAULT);
				return;
			case VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_FETCH:
				setUsedToFetch(USED_TO_FETCH_EDEFAULT);
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
			case VulkanResourcePackage.TRANSFER_BUFFER__SIZE:
				return size != SIZE_EDEFAULT;
			case VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_PUSH:
				return usedToPush != USED_TO_PUSH_EDEFAULT;
			case VulkanResourcePackage.TRANSFER_BUFFER__USED_TO_FETCH:
				return usedToFetch != USED_TO_FETCH_EDEFAULT;
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
		result.append(" (size: ");
		result.append(size);
		result.append(", usedToPush: ");
		result.append(usedToPush);
		result.append(", usedToFetch: ");
		result.append(usedToFetch);
		result.append(')');
		return result.toString();
	}

} //TransferBufferImpl
