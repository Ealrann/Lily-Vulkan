/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.process.GetBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.GetBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Get Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.GetBufferTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.GetBufferTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.GetBufferTaskImpl#getGetBuffer <em>Get Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.GetBufferTaskImpl#getDeviceBuffer <em>Device Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GetBufferTaskImpl extends LilyEObject implements GetBufferTask
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
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGetBuffer() <em>Get Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetBuffer()
	 * @generated
	 * @ordered
	 */
	protected GetBuffer getBuffer;

	/**
	 * The cached value of the '{@link #getDeviceBuffer() <em>Device Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeviceBuffer()
	 * @generated
	 * @ordered
	 */
	protected Buffer deviceBuffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GetBufferTaskImpl()
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
		return ProcessPackage.Literals.GET_BUFFER_TASK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GET_BUFFER_TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GET_BUFFER_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GetBuffer getGetBuffer()
	{
		if (getBuffer != null && ((EObject)getBuffer).eIsProxy())
		{
			InternalEObject oldGetBuffer = (InternalEObject)getBuffer;
			getBuffer = (GetBuffer)eResolveProxy(oldGetBuffer);
			if (getBuffer != oldGetBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.GET_BUFFER_TASK__GET_BUFFER, oldGetBuffer, getBuffer));
			}
		}
		return getBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetBuffer basicGetGetBuffer()
	{
		return getBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGetBuffer(GetBuffer newGetBuffer)
	{
		GetBuffer oldGetBuffer = getBuffer;
		getBuffer = newGetBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GET_BUFFER_TASK__GET_BUFFER, oldGetBuffer, getBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getDeviceBuffer()
	{
		if (deviceBuffer != null && ((EObject)deviceBuffer).eIsProxy())
		{
			InternalEObject oldDeviceBuffer = (InternalEObject)deviceBuffer;
			deviceBuffer = (Buffer)eResolveProxy(oldDeviceBuffer);
			if (deviceBuffer != oldDeviceBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.GET_BUFFER_TASK__DEVICE_BUFFER, oldDeviceBuffer, deviceBuffer));
			}
		}
		return deviceBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer basicGetDeviceBuffer()
	{
		return deviceBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeviceBuffer(Buffer newDeviceBuffer)
	{
		Buffer oldDeviceBuffer = deviceBuffer;
		deviceBuffer = newDeviceBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GET_BUFFER_TASK__DEVICE_BUFFER, oldDeviceBuffer, deviceBuffer));
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
			case ProcessPackage.GET_BUFFER_TASK__NAME:
				return getName();
			case ProcessPackage.GET_BUFFER_TASK__ENABLED:
				return isEnabled();
			case ProcessPackage.GET_BUFFER_TASK__GET_BUFFER:
				if (resolve) return getGetBuffer();
				return basicGetGetBuffer();
			case ProcessPackage.GET_BUFFER_TASK__DEVICE_BUFFER:
				if (resolve) return getDeviceBuffer();
				return basicGetDeviceBuffer();
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
			case ProcessPackage.GET_BUFFER_TASK__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.GET_BUFFER_TASK__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.GET_BUFFER_TASK__GET_BUFFER:
				setGetBuffer((GetBuffer)newValue);
				return;
			case ProcessPackage.GET_BUFFER_TASK__DEVICE_BUFFER:
				setDeviceBuffer((Buffer)newValue);
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
			case ProcessPackage.GET_BUFFER_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.GET_BUFFER_TASK__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.GET_BUFFER_TASK__GET_BUFFER:
				setGetBuffer((GetBuffer)null);
				return;
			case ProcessPackage.GET_BUFFER_TASK__DEVICE_BUFFER:
				setDeviceBuffer((Buffer)null);
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
			case ProcessPackage.GET_BUFFER_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.GET_BUFFER_TASK__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.GET_BUFFER_TASK__GET_BUFFER:
				return getBuffer != null;
			case ProcessPackage.GET_BUFFER_TASK__DEVICE_BUFFER:
				return deviceBuffer != null;
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
		result.append(", enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

} //GetBufferTaskImpl
