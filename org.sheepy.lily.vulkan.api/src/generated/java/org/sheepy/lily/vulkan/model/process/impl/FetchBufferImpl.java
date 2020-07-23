/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fetch Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl#getBufferReference <em>Buffer Reference</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl#getDataProvider <em>Data Provider</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FetchBufferImpl extends LilyEObject implements FetchBuffer
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
	 * The cached value of the '{@link #getBufferReference() <em>Buffer Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferReference()
	 * @generated
	 * @ordered
	 */
	protected BufferReference bufferReference;

	/**
	 * The cached value of the '{@link #getDataProvider() <em>Data Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProvider()
	 * @generated
	 * @ordered
	 */
	protected BufferDataProvider dataProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FetchBufferImpl()
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
		return ProcessPackage.Literals.FETCH_BUFFER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FETCH_BUFFER__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FETCH_BUFFER__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferReference getBufferReference()
	{
		return bufferReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBufferReference(BufferReference newBufferReference, NotificationChain msgs)
	{
		BufferReference oldBufferReference = bufferReference;
		bufferReference = newBufferReference;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE, oldBufferReference, newBufferReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBufferReference(BufferReference newBufferReference)
	{
		if (newBufferReference != bufferReference)
		{
			NotificationChain msgs = null;
			if (bufferReference != null)
				msgs = ((InternalEObject)bufferReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE, null, msgs);
			if (newBufferReference != null)
				msgs = ((InternalEObject)newBufferReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE, null, msgs);
			msgs = basicSetBufferReference(newBufferReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE, newBufferReference, newBufferReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferDataProvider getDataProvider()
	{
		if (dataProvider != null && ((EObject)dataProvider).eIsProxy())
		{
			InternalEObject oldDataProvider = dataProvider;
			dataProvider = (BufferDataProvider)eResolveProxy(oldDataProvider);
			if (dataProvider != oldDataProvider)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.FETCH_BUFFER__DATA_PROVIDER, oldDataProvider, dataProvider));
			}
		}
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferDataProvider basicGetDataProvider()
	{
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataProvider(BufferDataProvider newDataProvider)
	{
		BufferDataProvider oldDataProvider = dataProvider;
		dataProvider = newDataProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.FETCH_BUFFER__DATA_PROVIDER, oldDataProvider, dataProvider));
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
			case ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE:
				return basicSetBufferReference(null, msgs);
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
			case ProcessPackage.FETCH_BUFFER__NAME:
				return getName();
			case ProcessPackage.FETCH_BUFFER__ENABLED:
				return isEnabled();
			case ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE:
				return getBufferReference();
			case ProcessPackage.FETCH_BUFFER__DATA_PROVIDER:
				if (resolve) return getDataProvider();
				return basicGetDataProvider();
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
			case ProcessPackage.FETCH_BUFFER__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.FETCH_BUFFER__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE:
				setBufferReference((BufferReference)newValue);
				return;
			case ProcessPackage.FETCH_BUFFER__DATA_PROVIDER:
				setDataProvider((BufferDataProvider)newValue);
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
			case ProcessPackage.FETCH_BUFFER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.FETCH_BUFFER__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE:
				setBufferReference((BufferReference)null);
				return;
			case ProcessPackage.FETCH_BUFFER__DATA_PROVIDER:
				setDataProvider((BufferDataProvider)null);
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
			case ProcessPackage.FETCH_BUFFER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.FETCH_BUFFER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.FETCH_BUFFER__BUFFER_REFERENCE:
				return bufferReference != null;
			case ProcessPackage.FETCH_BUFFER__DATA_PROVIDER:
				return dataProvider != null;
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

} //FetchBufferImpl
