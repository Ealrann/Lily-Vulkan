/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.nio.ByteBuffer;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.model.resource.impl.IResourceImpl;

import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#isKeptMapped <em>Kept Mapped</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#isHostVisible <em>Host Visible</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#isCoherent <em>Coherent</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#getInstanceCount <em>Instance Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferImpl extends IResourceImpl implements Buffer
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
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final ByteBuffer DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected ByteBuffer data = DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #isKeptMapped() <em>Kept Mapped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeptMapped()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEPT_MAPPED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isKeptMapped() <em>Kept Mapped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeptMapped()
	 * @generated
	 * @ordered
	 */
	protected boolean keptMapped = KEPT_MAPPED_EDEFAULT;

	/**
	 * The default value of the '{@link #isHostVisible() <em>Host Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHostVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HOST_VISIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHostVisible() <em>Host Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHostVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean hostVisible = HOST_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isCoherent() <em>Coherent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCoherent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COHERENT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCoherent() <em>Coherent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCoherent()
	 * @generated
	 * @ordered
	 */
	protected boolean coherent = COHERENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsages() <em>Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<EBufferUsage> usages;

	/**
	 * The default value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected static final EInstanceCount INSTANCE_COUNT_EDEFAULT = EInstanceCount.ONE;

	/**
	 * The cached value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected EInstanceCount instanceCount = INSTANCE_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferImpl()
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
		return VulkanResourcePackage.Literals.BUFFER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ByteBuffer getData()
	{
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setData(ByteBuffer newData)
	{
		ByteBuffer oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isKeptMapped()
	{
		return keptMapped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKeptMapped(boolean newKeptMapped)
	{
		boolean oldKeptMapped = keptMapped;
		keptMapped = newKeptMapped;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER__KEPT_MAPPED, oldKeptMapped, keptMapped));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHostVisible()
	{
		return hostVisible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHostVisible(boolean newHostVisible)
	{
		boolean oldHostVisible = hostVisible;
		hostVisible = newHostVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER__HOST_VISIBLE, oldHostVisible, hostVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCoherent()
	{
		return coherent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCoherent(boolean newCoherent)
	{
		boolean oldCoherent = coherent;
		coherent = newCoherent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER__COHERENT, oldCoherent, coherent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EBufferUsage> getUsages()
	{
		if (usages == null)
		{
			usages = new EDataTypeUniqueEList<EBufferUsage>(EBufferUsage.class, this, VulkanResourcePackage.BUFFER__USAGES);
		}
		return usages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EInstanceCount getInstanceCount()
	{
		return instanceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceCount(EInstanceCount newInstanceCount)
	{
		EInstanceCount oldInstanceCount = instanceCount;
		instanceCount = newInstanceCount == null ? INSTANCE_COUNT_EDEFAULT : newInstanceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER__INSTANCE_COUNT, oldInstanceCount, instanceCount));
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
			case VulkanResourcePackage.BUFFER__SIZE:
				return getSize();
			case VulkanResourcePackage.BUFFER__DATA:
				return getData();
			case VulkanResourcePackage.BUFFER__KEPT_MAPPED:
				return isKeptMapped();
			case VulkanResourcePackage.BUFFER__HOST_VISIBLE:
				return isHostVisible();
			case VulkanResourcePackage.BUFFER__COHERENT:
				return isCoherent();
			case VulkanResourcePackage.BUFFER__USAGES:
				return getUsages();
			case VulkanResourcePackage.BUFFER__INSTANCE_COUNT:
				return getInstanceCount();
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
			case VulkanResourcePackage.BUFFER__SIZE:
				setSize((Long)newValue);
				return;
			case VulkanResourcePackage.BUFFER__DATA:
				setData((ByteBuffer)newValue);
				return;
			case VulkanResourcePackage.BUFFER__KEPT_MAPPED:
				setKeptMapped((Boolean)newValue);
				return;
			case VulkanResourcePackage.BUFFER__HOST_VISIBLE:
				setHostVisible((Boolean)newValue);
				return;
			case VulkanResourcePackage.BUFFER__COHERENT:
				setCoherent((Boolean)newValue);
				return;
			case VulkanResourcePackage.BUFFER__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends EBufferUsage>)newValue);
				return;
			case VulkanResourcePackage.BUFFER__INSTANCE_COUNT:
				setInstanceCount((EInstanceCount)newValue);
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
			case VulkanResourcePackage.BUFFER__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER__DATA:
				setData(DATA_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER__KEPT_MAPPED:
				setKeptMapped(KEPT_MAPPED_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER__HOST_VISIBLE:
				setHostVisible(HOST_VISIBLE_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER__COHERENT:
				setCoherent(COHERENT_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER__USAGES:
				getUsages().clear();
				return;
			case VulkanResourcePackage.BUFFER__INSTANCE_COUNT:
				setInstanceCount(INSTANCE_COUNT_EDEFAULT);
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
			case VulkanResourcePackage.BUFFER__SIZE:
				return size != SIZE_EDEFAULT;
			case VulkanResourcePackage.BUFFER__DATA:
				return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
			case VulkanResourcePackage.BUFFER__KEPT_MAPPED:
				return keptMapped != KEPT_MAPPED_EDEFAULT;
			case VulkanResourcePackage.BUFFER__HOST_VISIBLE:
				return hostVisible != HOST_VISIBLE_EDEFAULT;
			case VulkanResourcePackage.BUFFER__COHERENT:
				return coherent != COHERENT_EDEFAULT;
			case VulkanResourcePackage.BUFFER__USAGES:
				return usages != null && !usages.isEmpty();
			case VulkanResourcePackage.BUFFER__INSTANCE_COUNT:
				return instanceCount != INSTANCE_COUNT_EDEFAULT;
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
		result.append(", data: ");
		result.append(data);
		result.append(", keptMapped: ");
		result.append(keptMapped);
		result.append(", hostVisible: ");
		result.append(hostVisible);
		result.append(", coherent: ");
		result.append(coherent);
		result.append(", usages: ");
		result.append(usages);
		result.append(", instanceCount: ");
		result.append(instanceCount);
		result.append(')');
		return result.toString();
	}

} //BufferImpl
