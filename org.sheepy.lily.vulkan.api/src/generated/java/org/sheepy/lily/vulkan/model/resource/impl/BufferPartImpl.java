/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferPartImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.BufferPartImpl#getDataProvider <em>Data Provider</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferPartImpl extends LilyEObject implements BufferPart
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
	 * The cached value of the '{@link #getDataProvider() <em>Data Provider</em>}' containment reference.
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
	protected BufferPartImpl()
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
		return VulkanResourcePackage.Literals.BUFFER_PART;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_PART__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferDataProvider getDataProvider()
	{
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataProvider(BufferDataProvider newDataProvider, NotificationChain msgs)
	{
		BufferDataProvider oldDataProvider = dataProvider;
		dataProvider = newDataProvider;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER, oldDataProvider, newDataProvider);
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
	public void setDataProvider(BufferDataProvider newDataProvider)
	{
		if (newDataProvider != dataProvider)
		{
			NotificationChain msgs = null;
			if (dataProvider != null)
				msgs = ((InternalEObject)dataProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER, null, msgs);
			if (newDataProvider != null)
				msgs = ((InternalEObject)newDataProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER, null, msgs);
			msgs = basicSetDataProvider(newDataProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER, newDataProvider, newDataProvider));
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
			case VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER:
				return basicSetDataProvider(null, msgs);
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
			case VulkanResourcePackage.BUFFER_PART__NAME:
				return getName();
			case VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER:
				return getDataProvider();
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
			case VulkanResourcePackage.BUFFER_PART__NAME:
				setName((String)newValue);
				return;
			case VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER:
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
			case VulkanResourcePackage.BUFFER_PART__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER:
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
			case VulkanResourcePackage.BUFFER_PART__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VulkanResourcePackage.BUFFER_PART__DATA_PROVIDER:
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
		result.append(')');
		return result.toString();
	}

} //BufferPartImpl
