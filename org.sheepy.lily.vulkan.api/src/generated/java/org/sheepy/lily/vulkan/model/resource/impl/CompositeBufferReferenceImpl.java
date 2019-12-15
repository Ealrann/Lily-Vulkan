/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferReference;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Buffer Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferReferenceImpl#getBuffer <em>Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeBufferReferenceImpl extends CompositePartReferenceImpl implements CompositeBufferReference
{
	/**
	 * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffer()
	 * @generated
	 * @ordered
	 */
	protected CompositeBuffer buffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeBufferReferenceImpl()
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
		return ResourcePackage.Literals.COMPOSITE_BUFFER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeBuffer getBuffer()
	{
		if (buffer != null && ((EObject)buffer).eIsProxy())
		{
			InternalEObject oldBuffer = (InternalEObject)buffer;
			buffer = (CompositeBuffer)eResolveProxy(oldBuffer);
			if (buffer != oldBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcePackage.COMPOSITE_BUFFER_REFERENCE__BUFFER, oldBuffer, buffer));
			}
		}
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeBuffer basicGetBuffer()
	{
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuffer(CompositeBuffer newBuffer)
	{
		CompositeBuffer oldBuffer = buffer;
		buffer = newBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.COMPOSITE_BUFFER_REFERENCE__BUFFER, oldBuffer, buffer));
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
			case ResourcePackage.COMPOSITE_BUFFER_REFERENCE__BUFFER:
				if (resolve) return getBuffer();
				return basicGetBuffer();
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
			case ResourcePackage.COMPOSITE_BUFFER_REFERENCE__BUFFER:
				setBuffer((CompositeBuffer)newValue);
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
			case ResourcePackage.COMPOSITE_BUFFER_REFERENCE__BUFFER:
				setBuffer((CompositeBuffer)null);
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
			case ResourcePackage.COMPOSITE_BUFFER_REFERENCE__BUFFER:
				return buffer != null;
		}
		return super.eIsSet(featureID);
	}

} //CompositeBufferReferenceImpl
