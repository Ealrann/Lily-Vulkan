/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferReferenceImpl#getBuffers <em>Buffers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferReferenceImpl#getStride <em>Stride</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferReferenceImpl#getIndexType <em>Index Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferReferenceImpl extends LilyEObject implements BufferReference
{
	/**
	 * The cached value of the '{@link #getBuffers() <em>Buffers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffers()
	 * @generated
	 * @ordered
	 */
	protected EList<IBuffer> buffers;

	/**
	 * The default value of the '{@link #getStride() <em>Stride</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStride()
	 * @generated
	 * @ordered
	 */
	protected static final int STRIDE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStride() <em>Stride</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStride()
	 * @generated
	 * @ordered
	 */
	protected int stride = STRIDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected static final EContextIndex INDEX_TYPE_EDEFAULT = EContextIndex.CONTEXT_INSTANCE;

	/**
	 * The cached value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected EContextIndex indexType = INDEX_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BufferReferenceImpl()
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
		return VulkanResourcePackage.Literals.BUFFER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IBuffer> getBuffers()
	{
		if (buffers == null)
		{
			buffers = new EObjectResolvingEList<IBuffer>(IBuffer.class, this, VulkanResourcePackage.BUFFER_REFERENCE__BUFFERS);
		}
		return buffers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStride()
	{
		return stride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStride(int newStride)
	{
		int oldStride = stride;
		stride = newStride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_REFERENCE__STRIDE, oldStride, stride));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EContextIndex getIndexType()
	{
		return indexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexType(EContextIndex newIndexType)
	{
		EContextIndex oldIndexType = indexType;
		indexType = newIndexType == null ? INDEX_TYPE_EDEFAULT : newIndexType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_REFERENCE__INDEX_TYPE, oldIndexType, indexType));
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
			case VulkanResourcePackage.BUFFER_REFERENCE__BUFFERS:
				return getBuffers();
			case VulkanResourcePackage.BUFFER_REFERENCE__STRIDE:
				return getStride();
			case VulkanResourcePackage.BUFFER_REFERENCE__INDEX_TYPE:
				return getIndexType();
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
			case VulkanResourcePackage.BUFFER_REFERENCE__BUFFERS:
				getBuffers().clear();
				getBuffers().addAll((Collection<? extends IBuffer>)newValue);
				return;
			case VulkanResourcePackage.BUFFER_REFERENCE__STRIDE:
				setStride((Integer)newValue);
				return;
			case VulkanResourcePackage.BUFFER_REFERENCE__INDEX_TYPE:
				setIndexType((EContextIndex)newValue);
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
			case VulkanResourcePackage.BUFFER_REFERENCE__BUFFERS:
				getBuffers().clear();
				return;
			case VulkanResourcePackage.BUFFER_REFERENCE__STRIDE:
				setStride(STRIDE_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_REFERENCE__INDEX_TYPE:
				setIndexType(INDEX_TYPE_EDEFAULT);
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
			case VulkanResourcePackage.BUFFER_REFERENCE__BUFFERS:
				return buffers != null && !buffers.isEmpty();
			case VulkanResourcePackage.BUFFER_REFERENCE__STRIDE:
				return stride != STRIDE_EDEFAULT;
			case VulkanResourcePackage.BUFFER_REFERENCE__INDEX_TYPE:
				return indexType != INDEX_TYPE_EDEFAULT;
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
		result.append(" (stride: ");
		result.append(stride);
		result.append(", indexType: ");
		result.append(indexType);
		result.append(')');
		return result.toString();
	}

} //BufferReferenceImpl
