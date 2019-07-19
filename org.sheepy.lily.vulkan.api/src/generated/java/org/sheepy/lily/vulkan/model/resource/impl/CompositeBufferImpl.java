/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl#getDataProviders <em>Data Providers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferImpl#getPushBuffer <em>Push Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeBufferImpl extends MinimalEObjectImpl.Container implements CompositeBuffer
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
	 * The cached value of the '{@link #getDataProviders() <em>Data Providers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<BufferDataProvider<?>> dataProviders;

	/**
	 * The cached value of the '{@link #getPushBuffer() <em>Push Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPushBuffer()
	 * @generated
	 * @ordered
	 */
	protected PushBuffer pushBuffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeBufferImpl()
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
		return ResourcePackage.Literals.COMPOSITE_BUFFER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.COMPOSITE_BUFFER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BufferDataProvider<?>> getDataProviders()
	{
		if (dataProviders == null)
		{
			dataProviders = new EObjectContainmentEList<BufferDataProvider<?>>(BufferDataProvider.class, this, ResourcePackage.COMPOSITE_BUFFER__DATA_PROVIDERS);
		}
		return dataProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PushBuffer getPushBuffer()
	{
		if (pushBuffer != null && pushBuffer.eIsProxy())
		{
			InternalEObject oldPushBuffer = (InternalEObject)pushBuffer;
			pushBuffer = (PushBuffer)eResolveProxy(oldPushBuffer);
			if (pushBuffer != oldPushBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcePackage.COMPOSITE_BUFFER__PUSH_BUFFER, oldPushBuffer, pushBuffer));
			}
		}
		return pushBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PushBuffer basicGetPushBuffer()
	{
		return pushBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPushBuffer(PushBuffer newPushBuffer)
	{
		PushBuffer oldPushBuffer = pushBuffer;
		pushBuffer = newPushBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.COMPOSITE_BUFFER__PUSH_BUFFER, oldPushBuffer, pushBuffer));
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
			case ResourcePackage.COMPOSITE_BUFFER__DATA_PROVIDERS:
				return ((InternalEList<?>)getDataProviders()).basicRemove(otherEnd, msgs);
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
			case ResourcePackage.COMPOSITE_BUFFER__NAME:
				return getName();
			case ResourcePackage.COMPOSITE_BUFFER__DATA_PROVIDERS:
				return getDataProviders();
			case ResourcePackage.COMPOSITE_BUFFER__PUSH_BUFFER:
				if (resolve) return getPushBuffer();
				return basicGetPushBuffer();
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
			case ResourcePackage.COMPOSITE_BUFFER__NAME:
				setName((String)newValue);
				return;
			case ResourcePackage.COMPOSITE_BUFFER__DATA_PROVIDERS:
				getDataProviders().clear();
				getDataProviders().addAll((Collection<? extends BufferDataProvider<?>>)newValue);
				return;
			case ResourcePackage.COMPOSITE_BUFFER__PUSH_BUFFER:
				setPushBuffer((PushBuffer)newValue);
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
			case ResourcePackage.COMPOSITE_BUFFER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ResourcePackage.COMPOSITE_BUFFER__DATA_PROVIDERS:
				getDataProviders().clear();
				return;
			case ResourcePackage.COMPOSITE_BUFFER__PUSH_BUFFER:
				setPushBuffer((PushBuffer)null);
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
			case ResourcePackage.COMPOSITE_BUFFER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ResourcePackage.COMPOSITE_BUFFER__DATA_PROVIDERS:
				return dataProviders != null && !dataProviders.isEmpty();
			case ResourcePackage.COMPOSITE_BUFFER__PUSH_BUFFER:
				return pushBuffer != null;
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

} //CompositeBufferImpl
