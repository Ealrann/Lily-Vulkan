/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Chunk</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.MemoryChunkImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.MemoryChunkImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.MemoryChunkImpl#getTransferBuffer <em>Transfer Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemoryChunkImpl extends LilyEObject implements MemoryChunk
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<IMemoryChunkPart> parts;

	/**
	 * The cached value of the '{@link #getTransferBuffer() <em>Transfer Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferBuffer()
	 * @generated
	 * @ordered
	 */
	protected TransferBuffer transferBuffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryChunkImpl()
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
		return VulkanResourcePackage.Literals.MEMORY_CHUNK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.MEMORY_CHUNK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IMemoryChunkPart> getParts()
	{
		if (parts == null)
		{
			parts = new EObjectContainmentEList<>(IMemoryChunkPart.class, this, VulkanResourcePackage.MEMORY_CHUNK__PARTS);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransferBuffer getTransferBuffer()
	{
		if (transferBuffer != null && ((EObject)transferBuffer).eIsProxy())
		{
			InternalEObject oldTransferBuffer = transferBuffer;
			transferBuffer = (TransferBuffer)eResolveProxy(oldTransferBuffer);
			if (transferBuffer != oldTransferBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VulkanResourcePackage.MEMORY_CHUNK__TRANSFER_BUFFER, oldTransferBuffer, transferBuffer));
			}
		}
		return transferBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransferBuffer basicGetTransferBuffer()
	{
		return transferBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransferBuffer(TransferBuffer newTransferBuffer)
	{
		TransferBuffer oldTransferBuffer = transferBuffer;
		transferBuffer = newTransferBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.MEMORY_CHUNK__TRANSFER_BUFFER, oldTransferBuffer, transferBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case VulkanResourcePackage.MEMORY_CHUNK__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case VulkanResourcePackage.MEMORY_CHUNK__NAME:
				return getName();
			case VulkanResourcePackage.MEMORY_CHUNK__PARTS:
				return getParts();
			case VulkanResourcePackage.MEMORY_CHUNK__TRANSFER_BUFFER:
				if (resolve) return getTransferBuffer();
				return basicGetTransferBuffer();
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
			case VulkanResourcePackage.MEMORY_CHUNK__NAME:
				setName((String)newValue);
				return;
			case VulkanResourcePackage.MEMORY_CHUNK__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends IMemoryChunkPart>)newValue);
				return;
			case VulkanResourcePackage.MEMORY_CHUNK__TRANSFER_BUFFER:
				setTransferBuffer((TransferBuffer)newValue);
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
			case VulkanResourcePackage.MEMORY_CHUNK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VulkanResourcePackage.MEMORY_CHUNK__PARTS:
				getParts().clear();
				return;
			case VulkanResourcePackage.MEMORY_CHUNK__TRANSFER_BUFFER:
				setTransferBuffer((TransferBuffer)null);
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
			case VulkanResourcePackage.MEMORY_CHUNK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VulkanResourcePackage.MEMORY_CHUNK__PARTS:
				return parts != null && !parts.isEmpty();
			case VulkanResourcePackage.MEMORY_CHUNK__TRANSFER_BUFFER:
				return transferBuffer != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MemoryChunkImpl
