/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.lily.vulkan.model.resource.IBufferReference;

import org.sheepy.vulkan.model.enumeration.EIndexType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bind Index Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl#getIndexType <em>Index Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl#getBufferRef <em>Buffer Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindIndexBufferImpl extends MinimalEObjectImpl.Container implements BindIndexBuffer
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
	 * The default value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected static final EIndexType INDEX_TYPE_EDEFAULT = EIndexType.UINT32;

	/**
	 * The cached value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected EIndexType indexType = INDEX_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBufferRef() <em>Buffer Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferRef()
	 * @generated
	 * @ordered
	 */
	protected IBufferReference bufferRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindIndexBufferImpl()
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
		return GraphicPackage.Literals.BIND_INDEX_BUFFER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.BIND_INDEX_BUFFER__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.BIND_INDEX_BUFFER__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EIndexType getIndexType()
	{
		return indexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexType(EIndexType newIndexType)
	{
		EIndexType oldIndexType = indexType;
		indexType = newIndexType == null ? INDEX_TYPE_EDEFAULT : newIndexType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.BIND_INDEX_BUFFER__INDEX_TYPE, oldIndexType, indexType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IBufferReference getBufferRef()
	{
		return bufferRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBufferRef(IBufferReference newBufferRef, NotificationChain msgs)
	{
		IBufferReference oldBufferRef = bufferRef;
		bufferRef = newBufferRef;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF, oldBufferRef, newBufferRef);
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
	public void setBufferRef(IBufferReference newBufferRef)
	{
		if (newBufferRef != bufferRef)
		{
			NotificationChain msgs = null;
			if (bufferRef != null)
				msgs = ((InternalEObject)bufferRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF, null, msgs);
			if (newBufferRef != null)
				msgs = ((InternalEObject)newBufferRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF, null, msgs);
			msgs = basicSetBufferRef(newBufferRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF, newBufferRef, newBufferRef));
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
			case GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF:
				return basicSetBufferRef(null, msgs);
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
			case GraphicPackage.BIND_INDEX_BUFFER__NAME:
				return getName();
			case GraphicPackage.BIND_INDEX_BUFFER__ENABLED:
				return isEnabled();
			case GraphicPackage.BIND_INDEX_BUFFER__INDEX_TYPE:
				return getIndexType();
			case GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF:
				return getBufferRef();
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
			case GraphicPackage.BIND_INDEX_BUFFER__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.BIND_INDEX_BUFFER__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case GraphicPackage.BIND_INDEX_BUFFER__INDEX_TYPE:
				setIndexType((EIndexType)newValue);
				return;
			case GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF:
				setBufferRef((IBufferReference)newValue);
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
			case GraphicPackage.BIND_INDEX_BUFFER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.BIND_INDEX_BUFFER__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case GraphicPackage.BIND_INDEX_BUFFER__INDEX_TYPE:
				setIndexType(INDEX_TYPE_EDEFAULT);
				return;
			case GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF:
				setBufferRef((IBufferReference)null);
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
			case GraphicPackage.BIND_INDEX_BUFFER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.BIND_INDEX_BUFFER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case GraphicPackage.BIND_INDEX_BUFFER__INDEX_TYPE:
				return indexType != INDEX_TYPE_EDEFAULT;
			case GraphicPackage.BIND_INDEX_BUFFER__BUFFER_REF:
				return bufferRef != null;
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
		result.append(", indexType: ");
		result.append(indexType);
		result.append(')');
		return result.toString();
	}

} //BindIndexBufferImpl
