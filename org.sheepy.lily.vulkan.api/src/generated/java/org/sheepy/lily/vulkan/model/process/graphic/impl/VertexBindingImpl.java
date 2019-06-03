/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.resource.IBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vertex Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VertexBindingImpl extends MinimalEObjectImpl.Container implements VertexBinding
{
	/**
	 * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffer()
	 * @generated
	 * @ordered
	 */
	protected IBuffer buffer;

	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final long OFFSET_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected long offset = OFFSET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VertexBindingImpl()
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
	public IBuffer getBuffer()
	{
		if (buffer != null && buffer.eIsProxy())
		{
			InternalEObject oldBuffer = (InternalEObject) buffer;
			buffer = (IBuffer) eResolveProxy(oldBuffer);
			if (buffer != oldBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GraphicPackage.VERTEX_BINDING__BUFFER, oldBuffer, buffer));
			}
		}
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IBuffer basicGetBuffer()
	{
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuffer(IBuffer newBuffer)
	{
		IBuffer oldBuffer = buffer;
		buffer = newBuffer;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.VERTEX_BINDING__BUFFER, oldBuffer, buffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getOffset()
	{
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffset(long newOffset)
	{
		long oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.VERTEX_BINDING__OFFSET, oldOffset, offset));
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
		case GraphicPackage.VERTEX_BINDING__BUFFER:
			if (resolve) return getBuffer();
			return basicGetBuffer();
		case GraphicPackage.VERTEX_BINDING__OFFSET:
			return getOffset();
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
		case GraphicPackage.VERTEX_BINDING__BUFFER:
			setBuffer((IBuffer) newValue);
			return;
		case GraphicPackage.VERTEX_BINDING__OFFSET:
			setOffset((Long) newValue);
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
		case GraphicPackage.VERTEX_BINDING__BUFFER:
			setBuffer((IBuffer) null);
			return;
		case GraphicPackage.VERTEX_BINDING__OFFSET:
			setOffset(OFFSET_EDEFAULT);
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
		case GraphicPackage.VERTEX_BINDING__BUFFER:
			return buffer != null;
		case GraphicPackage.VERTEX_BINDING__OFFSET:
			return offset != OFFSET_EDEFAULT;
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
		result.append(" (offset: ");
		result.append(offset);
		result.append(')');
		return result.toString();
	}

} //VertexBindingImpl
