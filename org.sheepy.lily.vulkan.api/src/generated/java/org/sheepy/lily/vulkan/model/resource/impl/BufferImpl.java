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

import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#isOftenUpdated <em>Often Updated</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#isGpuBuffer <em>Gpu Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferImpl#getInstanceCount <em>Instance Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferImpl extends BasicDescriptedResourceImpl implements Buffer
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
	 * The cached value of the '{@link #getUsages() <em>Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<EBufferUsage> usages;

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
	 * The default value of the '{@link #isOftenUpdated() <em>Often Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOftenUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OFTEN_UPDATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOftenUpdated() <em>Often Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOftenUpdated()
	 * @generated
	 * @ordered
	 */
	protected boolean oftenUpdated = OFTEN_UPDATED_EDEFAULT;

	/**
	 * The default value of the '{@link #isGpuBuffer() <em>Gpu Buffer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGpuBuffer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GPU_BUFFER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGpuBuffer() <em>Gpu Buffer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGpuBuffer()
	 * @generated
	 * @ordered
	 */
	protected boolean gpuBuffer = GPU_BUFFER_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTANCE_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected int instanceCount = INSTANCE_COUNT_EDEFAULT;

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
		return ResourcePackage.Literals.BUFFER;
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.BUFFER__SIZE, oldSize, size));
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
			usages = new EDataTypeUniqueEList<EBufferUsage>(EBufferUsage.class, this,
					ResourcePackage.BUFFER__USAGES);
		}
		return usages;
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.BUFFER__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOftenUpdated()
	{
		return oftenUpdated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOftenUpdated(boolean newOftenUpdated)
	{
		boolean oldOftenUpdated = oftenUpdated;
		oftenUpdated = newOftenUpdated;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.BUFFER__OFTEN_UPDATED, oldOftenUpdated, oftenUpdated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isGpuBuffer()
	{
		return gpuBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGpuBuffer(boolean newGpuBuffer)
	{
		boolean oldGpuBuffer = gpuBuffer;
		gpuBuffer = newGpuBuffer;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.BUFFER__GPU_BUFFER, oldGpuBuffer, gpuBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInstanceCount()
	{
		return instanceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceCount(int newInstanceCount)
	{
		int oldInstanceCount = instanceCount;
		instanceCount = newInstanceCount;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.BUFFER__INSTANCE_COUNT, oldInstanceCount, instanceCount));
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
		case ResourcePackage.BUFFER__SIZE:
			return getSize();
		case ResourcePackage.BUFFER__USAGES:
			return getUsages();
		case ResourcePackage.BUFFER__DATA:
			return getData();
		case ResourcePackage.BUFFER__OFTEN_UPDATED:
			return isOftenUpdated();
		case ResourcePackage.BUFFER__GPU_BUFFER:
			return isGpuBuffer();
		case ResourcePackage.BUFFER__INSTANCE_COUNT:
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
		case ResourcePackage.BUFFER__SIZE:
			setSize((Long) newValue);
			return;
		case ResourcePackage.BUFFER__USAGES:
			getUsages().clear();
			getUsages().addAll((Collection<? extends EBufferUsage>) newValue);
			return;
		case ResourcePackage.BUFFER__DATA:
			setData((ByteBuffer) newValue);
			return;
		case ResourcePackage.BUFFER__OFTEN_UPDATED:
			setOftenUpdated((Boolean) newValue);
			return;
		case ResourcePackage.BUFFER__GPU_BUFFER:
			setGpuBuffer((Boolean) newValue);
			return;
		case ResourcePackage.BUFFER__INSTANCE_COUNT:
			setInstanceCount((Integer) newValue);
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
		case ResourcePackage.BUFFER__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		case ResourcePackage.BUFFER__USAGES:
			getUsages().clear();
			return;
		case ResourcePackage.BUFFER__DATA:
			setData(DATA_EDEFAULT);
			return;
		case ResourcePackage.BUFFER__OFTEN_UPDATED:
			setOftenUpdated(OFTEN_UPDATED_EDEFAULT);
			return;
		case ResourcePackage.BUFFER__GPU_BUFFER:
			setGpuBuffer(GPU_BUFFER_EDEFAULT);
			return;
		case ResourcePackage.BUFFER__INSTANCE_COUNT:
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
		case ResourcePackage.BUFFER__SIZE:
			return size != SIZE_EDEFAULT;
		case ResourcePackage.BUFFER__USAGES:
			return usages != null && !usages.isEmpty();
		case ResourcePackage.BUFFER__DATA:
			return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
		case ResourcePackage.BUFFER__OFTEN_UPDATED:
			return oftenUpdated != OFTEN_UPDATED_EDEFAULT;
		case ResourcePackage.BUFFER__GPU_BUFFER:
			return gpuBuffer != GPU_BUFFER_EDEFAULT;
		case ResourcePackage.BUFFER__INSTANCE_COUNT:
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
		result.append(", usages: ");
		result.append(usages);
		result.append(", data: ");
		result.append(data);
		result.append(", oftenUpdated: ");
		result.append(oftenUpdated);
		result.append(", gpuBuffer: ");
		result.append(gpuBuffer);
		result.append(", instanceCount: ");
		result.append(instanceCount);
		result.append(')');
		return result.toString();
	}

} //BufferImpl
