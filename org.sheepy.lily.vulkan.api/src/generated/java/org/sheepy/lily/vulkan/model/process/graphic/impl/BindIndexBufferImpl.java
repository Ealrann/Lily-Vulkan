/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.resource.IBuffer;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl#getOffset <em>Offset</em>}</li>
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.BIND_INDEX_BUFFER__NAME, oldName, name));
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
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.BIND_INDEX_BUFFER__ENABLED, oldEnabled, enabled));
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
							GraphicPackage.BIND_INDEX_BUFFER__BUFFER, oldBuffer, buffer));
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
				GraphicPackage.BIND_INDEX_BUFFER__BUFFER, oldBuffer, buffer));
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
				GraphicPackage.BIND_INDEX_BUFFER__OFFSET, oldOffset, offset));
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
		case GraphicPackage.BIND_INDEX_BUFFER__BUFFER:
			if (resolve) return getBuffer();
			return basicGetBuffer();
		case GraphicPackage.BIND_INDEX_BUFFER__OFFSET:
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
		case GraphicPackage.BIND_INDEX_BUFFER__NAME:
			setName((String) newValue);
			return;
		case GraphicPackage.BIND_INDEX_BUFFER__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case GraphicPackage.BIND_INDEX_BUFFER__BUFFER:
			setBuffer((IBuffer) newValue);
			return;
		case GraphicPackage.BIND_INDEX_BUFFER__OFFSET:
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
		case GraphicPackage.BIND_INDEX_BUFFER__NAME:
			setName(NAME_EDEFAULT);
			return;
		case GraphicPackage.BIND_INDEX_BUFFER__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case GraphicPackage.BIND_INDEX_BUFFER__BUFFER:
			setBuffer((IBuffer) null);
			return;
		case GraphicPackage.BIND_INDEX_BUFFER__OFFSET:
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
		case GraphicPackage.BIND_INDEX_BUFFER__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case GraphicPackage.BIND_INDEX_BUFFER__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case GraphicPackage.BIND_INDEX_BUFFER__BUFFER:
			return buffer != null;
		case GraphicPackage.BIND_INDEX_BUFFER__OFFSET:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", offset: ");
		result.append(offset);
		result.append(')');
		return result.toString();
	}

} //BindIndexBufferImpl
