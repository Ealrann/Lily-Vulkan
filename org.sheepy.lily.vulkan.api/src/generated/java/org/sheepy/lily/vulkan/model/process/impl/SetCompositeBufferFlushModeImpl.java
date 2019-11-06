/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.SetCompositeBufferFlushMode;

import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;
import org.sheepy.lily.vulkan.model.resource.EFlushMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Composite Buffer Flush Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.SetCompositeBufferFlushModeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.SetCompositeBufferFlushModeImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.SetCompositeBufferFlushModeImpl#getCompositeBuffer <em>Composite Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.SetCompositeBufferFlushModeImpl#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetCompositeBufferFlushModeImpl extends LilyEObject implements SetCompositeBufferFlushMode
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
	 * The cached value of the '{@link #getCompositeBuffer() <em>Composite Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeBuffer()
	 * @generated
	 * @ordered
	 */
	protected CompositeBuffer compositeBuffer;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final EFlushMode MODE_EDEFAULT = EFlushMode.PUSH;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected EFlushMode mode = MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetCompositeBufferFlushModeImpl()
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
		return ProcessPackage.Literals.SET_COMPOSITE_BUFFER_FLUSH_MODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeBuffer getCompositeBuffer()
	{
		if (compositeBuffer != null && ((EObject)compositeBuffer).eIsProxy())
		{
			InternalEObject oldCompositeBuffer = (InternalEObject)compositeBuffer;
			compositeBuffer = (CompositeBuffer)eResolveProxy(oldCompositeBuffer);
			if (compositeBuffer != oldCompositeBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__COMPOSITE_BUFFER, oldCompositeBuffer, compositeBuffer));
			}
		}
		return compositeBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeBuffer basicGetCompositeBuffer()
	{
		return compositeBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompositeBuffer(CompositeBuffer newCompositeBuffer)
	{
		CompositeBuffer oldCompositeBuffer = compositeBuffer;
		compositeBuffer = newCompositeBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__COMPOSITE_BUFFER, oldCompositeBuffer, compositeBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFlushMode getMode()
	{
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMode(EFlushMode newMode)
	{
		EFlushMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__MODE, oldMode, mode));
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
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__NAME:
				return getName();
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__ENABLED:
				return isEnabled();
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__COMPOSITE_BUFFER:
				if (resolve) return getCompositeBuffer();
				return basicGetCompositeBuffer();
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__MODE:
				return getMode();
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
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__COMPOSITE_BUFFER:
				setCompositeBuffer((CompositeBuffer)newValue);
				return;
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__MODE:
				setMode((EFlushMode)newValue);
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
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__COMPOSITE_BUFFER:
				setCompositeBuffer((CompositeBuffer)null);
				return;
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__MODE:
				setMode(MODE_EDEFAULT);
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
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__COMPOSITE_BUFFER:
				return compositeBuffer != null;
			case ProcessPackage.SET_COMPOSITE_BUFFER_FLUSH_MODE__MODE:
				return mode != MODE_EDEFAULT;
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
		result.append(", mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //SetCompositeBufferFlushModeImpl
