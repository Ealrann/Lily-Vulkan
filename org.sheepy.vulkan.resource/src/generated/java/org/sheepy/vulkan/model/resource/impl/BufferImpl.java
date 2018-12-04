/**
 */
package org.sheepy.vulkan.model.resource.impl;

import java.nio.ByteBuffer;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferImpl#getDescriptorType <em>Descriptor Type</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferImpl#getShaderStages <em>Shader Stages</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferImpl#getUsage <em>Usage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferImpl#isChangeable <em>Changeable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.impl.BufferImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferImpl extends MinimalEObjectImpl.Container implements Buffer
{
	/**
	 * The default value of the '{@link #getDescriptorType() <em>Descriptor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorType()
	 * @generated
	 * @ordered
	 */
	protected static final EDescriptorType DESCRIPTOR_TYPE_EDEFAULT = EDescriptorType.SAMPLER;

	/**
	 * The cached value of the '{@link #getDescriptorType() <em>Descriptor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorType()
	 * @generated
	 * @ordered
	 */
	protected EDescriptorType descriptorType = DESCRIPTOR_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getShaderStages() <em>Shader Stages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaderStages()
	 * @generated
	 * @ordered
	 */
	protected EList<EShaderStage> shaderStages;

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
	 * The default value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected static final int USAGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUsage() <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsage()
	 * @generated
	 * @ordered
	 */
	protected int usage = USAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTIES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected int properties = PROPERTIES_EDEFAULT;

	/**
	 * The default value of the '{@link #isChangeable() <em>Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHANGEABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChangeable() <em>Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeable()
	 * @generated
	 * @ordered
	 */
	protected boolean changeable = CHANGEABLE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferImpl()
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
	public EDescriptorType getDescriptorType()
	{
		return descriptorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptorType(EDescriptorType newDescriptorType)
	{
		EDescriptorType oldDescriptorType = descriptorType;
		descriptorType = newDescriptorType == null ? DESCRIPTOR_TYPE_EDEFAULT : newDescriptorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER__DESCRIPTOR_TYPE, oldDescriptorType, descriptorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EShaderStage> getShaderStages()
	{
		if (shaderStages == null)
		{
			shaderStages = new EDataTypeEList<EShaderStage>(EShaderStage.class, this, ResourcePackage.BUFFER__SHADER_STAGES);
		}
		return shaderStages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(long newSize)
	{
		long oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUsage()
	{
		return usage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsage(int newUsage)
	{
		int oldUsage = usage;
		usage = newUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER__USAGE, oldUsage, usage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProperties()
	{
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(int newProperties)
	{
		int oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER__PROPERTIES, oldProperties, properties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChangeable()
	{
		return changeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeable(boolean newChangeable)
	{
		boolean oldChangeable = changeable;
		changeable = newChangeable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER__CHANGEABLE, oldChangeable, changeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByteBuffer getData()
	{
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(ByteBuffer newData)
	{
		ByteBuffer oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.BUFFER__DATA, oldData, data));
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
			case ResourcePackage.BUFFER__DESCRIPTOR_TYPE:
				return getDescriptorType();
			case ResourcePackage.BUFFER__SHADER_STAGES:
				return getShaderStages();
			case ResourcePackage.BUFFER__SIZE:
				return getSize();
			case ResourcePackage.BUFFER__USAGE:
				return getUsage();
			case ResourcePackage.BUFFER__PROPERTIES:
				return getProperties();
			case ResourcePackage.BUFFER__CHANGEABLE:
				return isChangeable();
			case ResourcePackage.BUFFER__DATA:
				return getData();
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
			case ResourcePackage.BUFFER__DESCRIPTOR_TYPE:
				setDescriptorType((EDescriptorType)newValue);
				return;
			case ResourcePackage.BUFFER__SHADER_STAGES:
				getShaderStages().clear();
				getShaderStages().addAll((Collection<? extends EShaderStage>)newValue);
				return;
			case ResourcePackage.BUFFER__SIZE:
				setSize((Long)newValue);
				return;
			case ResourcePackage.BUFFER__USAGE:
				setUsage((Integer)newValue);
				return;
			case ResourcePackage.BUFFER__PROPERTIES:
				setProperties((Integer)newValue);
				return;
			case ResourcePackage.BUFFER__CHANGEABLE:
				setChangeable((Boolean)newValue);
				return;
			case ResourcePackage.BUFFER__DATA:
				setData((ByteBuffer)newValue);
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
			case ResourcePackage.BUFFER__DESCRIPTOR_TYPE:
				setDescriptorType(DESCRIPTOR_TYPE_EDEFAULT);
				return;
			case ResourcePackage.BUFFER__SHADER_STAGES:
				getShaderStages().clear();
				return;
			case ResourcePackage.BUFFER__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case ResourcePackage.BUFFER__USAGE:
				setUsage(USAGE_EDEFAULT);
				return;
			case ResourcePackage.BUFFER__PROPERTIES:
				setProperties(PROPERTIES_EDEFAULT);
				return;
			case ResourcePackage.BUFFER__CHANGEABLE:
				setChangeable(CHANGEABLE_EDEFAULT);
				return;
			case ResourcePackage.BUFFER__DATA:
				setData(DATA_EDEFAULT);
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
			case ResourcePackage.BUFFER__DESCRIPTOR_TYPE:
				return descriptorType != DESCRIPTOR_TYPE_EDEFAULT;
			case ResourcePackage.BUFFER__SHADER_STAGES:
				return shaderStages != null && !shaderStages.isEmpty();
			case ResourcePackage.BUFFER__SIZE:
				return size != SIZE_EDEFAULT;
			case ResourcePackage.BUFFER__USAGE:
				return usage != USAGE_EDEFAULT;
			case ResourcePackage.BUFFER__PROPERTIES:
				return properties != PROPERTIES_EDEFAULT;
			case ResourcePackage.BUFFER__CHANGEABLE:
				return changeable != CHANGEABLE_EDEFAULT;
			case ResourcePackage.BUFFER__DATA:
				return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
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
		result.append(" (descriptorType: ");
		result.append(descriptorType);
		result.append(", shaderStages: ");
		result.append(shaderStages);
		result.append(", size: ");
		result.append(size);
		result.append(", usage: ");
		result.append(usage);
		result.append(", properties: ");
		result.append(properties);
		result.append(", changeable: ");
		result.append(changeable);
		result.append(", data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} //BufferImpl
