/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;

import org.sheepy.lily.vulkan.model.resource.IBufferReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vertex Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl#getBufferRef <em>Buffer Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VertexBindingImpl extends MinimalEObjectImpl.Container implements VertexBinding
{
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
	protected VertexBindingImpl()
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
		return GraphicPackage.Literals.VERTEX_BINDING;
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
	public NotificationChain basicSetBufferRef(	IBufferReference newBufferRef,
												NotificationChain msgs)
	{
		IBufferReference oldBufferRef = bufferRef;
		bufferRef = newBufferRef;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.VERTEX_BINDING__BUFFER_REF, oldBufferRef, newBufferRef);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
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
			if (bufferRef != null) msgs = ((InternalEObject) bufferRef).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.VERTEX_BINDING__BUFFER_REF, null, msgs);
			if (newBufferRef != null) msgs = ((InternalEObject) newBufferRef).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.VERTEX_BINDING__BUFFER_REF, null, msgs);
			msgs = basicSetBufferRef(newBufferRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.VERTEX_BINDING__BUFFER_REF, newBufferRef, newBufferRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case GraphicPackage.VERTEX_BINDING__BUFFER_REF:
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
		case GraphicPackage.VERTEX_BINDING__BUFFER_REF:
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
		case GraphicPackage.VERTEX_BINDING__BUFFER_REF:
			setBufferRef((IBufferReference) newValue);
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
		case GraphicPackage.VERTEX_BINDING__BUFFER_REF:
			setBufferRef((IBufferReference) null);
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
		case GraphicPackage.VERTEX_BINDING__BUFFER_REF:
			return bufferRef != null;
		}
		return super.eIsSet(featureID);
	}

} //VertexBindingImpl
