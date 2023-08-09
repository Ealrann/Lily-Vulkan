/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntitySelection;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Proxy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.SelectionProxyImpl#getPickMode <em>Pick Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.SelectionProxyImpl#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.SelectionProxyImpl#getFocus <em>Focus</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectionProxyImpl extends LilyEObject implements SelectionProxy
{
	/**
	 * The default value of the '{@link #getPickMode() <em>Pick Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPickMode()
	 * @generated
	 * @ordered
	 */
	protected static final EMousePickMode PICK_MODE_EDEFAULT = EMousePickMode.ENABLED;

	/**
	 * The cached value of the '{@link #getPickMode() <em>Pick Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPickMode()
	 * @generated
	 * @ordered
	 */
	protected EMousePickMode pickMode = PICK_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSelection() <em>Selection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected IEntitySelection selection;

	/**
	 * The cached value of the '{@link #getFocus() <em>Focus</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFocus()
	 * @generated
	 * @ordered
	 */
	protected IEntitySelection focus;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectionProxyImpl()
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
		return RenderingPackage.Literals.SELECTION_PROXY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMousePickMode getPickMode()
	{
		return pickMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPickMode(EMousePickMode newPickMode)
	{
		EMousePickMode oldPickMode = pickMode;
		pickMode = newPickMode == null ? PICK_MODE_EDEFAULT : newPickMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.SELECTION_PROXY__PICK_MODE, oldPickMode, pickMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IEntitySelection getSelection()
	{
		return selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelection(IEntitySelection newSelection, NotificationChain msgs)
	{
		IEntitySelection oldSelection = selection;
		selection = newSelection;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RenderingPackage.SELECTION_PROXY__SELECTION, oldSelection, newSelection);
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
	public void setSelection(IEntitySelection newSelection)
	{
		if (newSelection != selection)
		{
			NotificationChain msgs = null;
			if (selection != null)
				msgs = ((InternalEObject)selection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.SELECTION_PROXY__SELECTION, null, msgs);
			if (newSelection != null)
				msgs = ((InternalEObject)newSelection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.SELECTION_PROXY__SELECTION, null, msgs);
			msgs = basicSetSelection(newSelection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.SELECTION_PROXY__SELECTION, newSelection, newSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IEntitySelection getFocus()
	{
		return focus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFocus(IEntitySelection newFocus, NotificationChain msgs)
	{
		IEntitySelection oldFocus = focus;
		focus = newFocus;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RenderingPackage.SELECTION_PROXY__FOCUS, oldFocus, newFocus);
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
	public void setFocus(IEntitySelection newFocus)
	{
		if (newFocus != focus)
		{
			NotificationChain msgs = null;
			if (focus != null)
				msgs = ((InternalEObject)focus).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.SELECTION_PROXY__FOCUS, null, msgs);
			if (newFocus != null)
				msgs = ((InternalEObject)newFocus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.SELECTION_PROXY__FOCUS, null, msgs);
			msgs = basicSetFocus(newFocus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.SELECTION_PROXY__FOCUS, newFocus, newFocus));
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
			case RenderingPackage.SELECTION_PROXY__SELECTION:
				return basicSetSelection(null, msgs);
			case RenderingPackage.SELECTION_PROXY__FOCUS:
				return basicSetFocus(null, msgs);
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
			case RenderingPackage.SELECTION_PROXY__PICK_MODE:
				return getPickMode();
			case RenderingPackage.SELECTION_PROXY__SELECTION:
				return getSelection();
			case RenderingPackage.SELECTION_PROXY__FOCUS:
				return getFocus();
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
			case RenderingPackage.SELECTION_PROXY__PICK_MODE:
				setPickMode((EMousePickMode)newValue);
				return;
			case RenderingPackage.SELECTION_PROXY__SELECTION:
				setSelection((IEntitySelection)newValue);
				return;
			case RenderingPackage.SELECTION_PROXY__FOCUS:
				setFocus((IEntitySelection)newValue);
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
			case RenderingPackage.SELECTION_PROXY__PICK_MODE:
				setPickMode(PICK_MODE_EDEFAULT);
				return;
			case RenderingPackage.SELECTION_PROXY__SELECTION:
				setSelection((IEntitySelection)null);
				return;
			case RenderingPackage.SELECTION_PROXY__FOCUS:
				setFocus((IEntitySelection)null);
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
			case RenderingPackage.SELECTION_PROXY__PICK_MODE:
				return pickMode != PICK_MODE_EDEFAULT;
			case RenderingPackage.SELECTION_PROXY__SELECTION:
				return selection != null;
			case RenderingPackage.SELECTION_PROXY__FOCUS:
				return focus != null;
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
		result.append(" (pickMode: ");
		result.append(pickMode);
		result.append(')');
		return result.toString();
	}

} //SelectionProxyImpl
