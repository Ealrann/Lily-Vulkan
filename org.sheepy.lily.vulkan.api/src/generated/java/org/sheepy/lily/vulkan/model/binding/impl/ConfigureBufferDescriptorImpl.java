/**
 */
package org.sheepy.lily.vulkan.model.binding.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor;
import org.sheepy.lily.vulkan.model.binding.EContextIndex;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configure Buffer Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureBufferDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureBufferDescriptorImpl#getCompositeBuffer <em>Composite Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureBufferDescriptorImpl#getPartIndex <em>Part Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigureBufferDescriptorImpl#getDescriptor <em>Descriptor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigureBufferDescriptorImpl extends LilyEObject implements ConfigureBufferDescriptor
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
	 * The cached value of the '{@link #getCompositeBuffer() <em>Composite Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeBuffer()
	 * @generated
	 * @ordered
	 */
	protected CompositeBuffer compositeBuffer;

	/**
	 * The default value of the '{@link #getPartIndex() <em>Part Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartIndex()
	 * @generated
	 * @ordered
	 */
	protected static final EContextIndex PART_INDEX_EDEFAULT = EContextIndex.CONTEXT_INSTANCE;

	/**
	 * The cached value of the '{@link #getPartIndex() <em>Part Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartIndex()
	 * @generated
	 * @ordered
	 */
	protected EContextIndex partIndex = PART_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptor()
	 * @generated
	 * @ordered
	 */
	protected BufferDescriptor descriptor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigureBufferDescriptorImpl()
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
		return BindingPackage.Literals.CONFIGURE_BUFFER_DESCRIPTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeBuffer getCompositeBuffer()
	{
		if (compositeBuffer != null && ((EObject)compositeBuffer).eIsProxy())
		{
			InternalEObject oldCompositeBuffer = (InternalEObject)compositeBuffer;
			compositeBuffer = (CompositeBuffer)eResolveProxy(oldCompositeBuffer);
			if (compositeBuffer != oldCompositeBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__COMPOSITE_BUFFER, oldCompositeBuffer, compositeBuffer));
			}
		}
		return compositeBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeBuffer basicGetCompositeBuffer()
	{
		return compositeBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompositeBuffer(CompositeBuffer newCompositeBuffer)
	{
		CompositeBuffer oldCompositeBuffer = compositeBuffer;
		compositeBuffer = newCompositeBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__COMPOSITE_BUFFER, oldCompositeBuffer, compositeBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EContextIndex getPartIndex()
	{
		return partIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartIndex(EContextIndex newPartIndex)
	{
		EContextIndex oldPartIndex = partIndex;
		partIndex = newPartIndex == null ? PART_INDEX_EDEFAULT : newPartIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__PART_INDEX, oldPartIndex, partIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferDescriptor getDescriptor()
	{
		if (descriptor != null && ((EObject)descriptor).eIsProxy())
		{
			InternalEObject oldDescriptor = (InternalEObject)descriptor;
			descriptor = (BufferDescriptor)eResolveProxy(oldDescriptor);
			if (descriptor != oldDescriptor)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__DESCRIPTOR, oldDescriptor, descriptor));
			}
		}
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferDescriptor basicGetDescriptor()
	{
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptor(BufferDescriptor newDescriptor)
	{
		BufferDescriptor oldDescriptor = descriptor;
		descriptor = newDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__DESCRIPTOR, oldDescriptor, descriptor));
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
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__NAME:
				return getName();
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__COMPOSITE_BUFFER:
				if (resolve) return getCompositeBuffer();
				return basicGetCompositeBuffer();
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__PART_INDEX:
				return getPartIndex();
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__DESCRIPTOR:
				if (resolve) return getDescriptor();
				return basicGetDescriptor();
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
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__COMPOSITE_BUFFER:
				setCompositeBuffer((CompositeBuffer)newValue);
				return;
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__PART_INDEX:
				setPartIndex((EContextIndex)newValue);
				return;
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__DESCRIPTOR:
				setDescriptor((BufferDescriptor)newValue);
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
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__COMPOSITE_BUFFER:
				setCompositeBuffer((CompositeBuffer)null);
				return;
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__PART_INDEX:
				setPartIndex(PART_INDEX_EDEFAULT);
				return;
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__DESCRIPTOR:
				setDescriptor((BufferDescriptor)null);
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
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__COMPOSITE_BUFFER:
				return compositeBuffer != null;
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__PART_INDEX:
				return partIndex != PART_INDEX_EDEFAULT;
			case BindingPackage.CONFIGURE_BUFFER_DESCRIPTOR__DESCRIPTOR:
				return descriptor != null;
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
		result.append(", partIndex: ");
		result.append(partIndex);
		result.append(')');
		return result.toString();
	}

} //ConfigureBufferDescriptorImpl
