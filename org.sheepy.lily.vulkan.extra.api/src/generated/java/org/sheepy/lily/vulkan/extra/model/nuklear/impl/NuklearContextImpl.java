/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.resource.SampledImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nuklear Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getFont <em>Font</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getNullTexture <em>Null Texture</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl#getLayoutTask <em>Layout Task</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearContextImpl extends MinimalEObjectImpl.Container implements NuklearContext
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
	 * The cached value of the '{@link #getFont() <em>Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected NuklearFont font;

	/**
	 * The cached value of the '{@link #getNullTexture() <em>Null Texture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNullTexture()
	 * @generated
	 * @ordered
	 */
	protected SampledImage nullTexture;

	/**
	 * The cached value of the '{@link #getLayoutTask() <em>Layout Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayoutTask()
	 * @generated
	 * @ordered
	 */
	protected NuklearLayoutTask layoutTask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearContextImpl()
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
		return NuklearPackage.Literals.NUKLEAR_CONTEXT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearFont getFont()
	{
		if (font != null && font.eIsProxy())
		{
			InternalEObject oldFont = (InternalEObject)font;
			font = (NuklearFont)eResolveProxy(oldFont);
			if (font != oldFont)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__FONT, oldFont, font));
			}
		}
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearFont basicGetFont()
	{
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFont(NuklearFont newFont)
	{
		NuklearFont oldFont = font;
		font = newFont;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__FONT, oldFont, font));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SampledImage getNullTexture()
	{
		if (nullTexture != null && nullTexture.eIsProxy())
		{
			InternalEObject oldNullTexture = (InternalEObject)nullTexture;
			nullTexture = (SampledImage)eResolveProxy(oldNullTexture);
			if (nullTexture != oldNullTexture)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE, oldNullTexture, nullTexture));
			}
		}
		return nullTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampledImage basicGetNullTexture()
	{
		return nullTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNullTexture(SampledImage newNullTexture)
	{
		SampledImage oldNullTexture = nullTexture;
		nullTexture = newNullTexture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE, oldNullTexture, nullTexture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearLayoutTask getLayoutTask()
	{
		if (layoutTask != null && layoutTask.eIsProxy())
		{
			InternalEObject oldLayoutTask = (InternalEObject)layoutTask;
			layoutTask = (NuklearLayoutTask)eResolveProxy(oldLayoutTask);
			if (layoutTask != oldLayoutTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, oldLayoutTask, layoutTask));
			}
		}
		return layoutTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearLayoutTask basicGetLayoutTask()
	{
		return layoutTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLayoutTask(NuklearLayoutTask newLayoutTask, NotificationChain msgs)
	{
		NuklearLayoutTask oldLayoutTask = layoutTask;
		layoutTask = newLayoutTask;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, oldLayoutTask, newLayoutTask);
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
	public void setLayoutTask(NuklearLayoutTask newLayoutTask)
	{
		if (newLayoutTask != layoutTask)
		{
			NotificationChain msgs = null;
			if (layoutTask != null)
				msgs = ((InternalEObject)layoutTask).eInverseRemove(this, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, NuklearLayoutTask.class, msgs);
			if (newLayoutTask != null)
				msgs = ((InternalEObject)newLayoutTask).eInverseAdd(this, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, NuklearLayoutTask.class, msgs);
			msgs = basicSetLayoutTask(newLayoutTask, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, newLayoutTask, newLayoutTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				if (layoutTask != null)
					msgs = ((InternalEObject)layoutTask).eInverseRemove(this, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, NuklearLayoutTask.class, msgs);
				return basicSetLayoutTask((NuklearLayoutTask)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				return basicSetLayoutTask(null, msgs);
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
			case NuklearPackage.NUKLEAR_CONTEXT__NAME:
				return getName();
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				if (resolve) return getFont();
				return basicGetFont();
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				if (resolve) return getNullTexture();
				return basicGetNullTexture();
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				if (resolve) return getLayoutTask();
				return basicGetLayoutTask();
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
			case NuklearPackage.NUKLEAR_CONTEXT__NAME:
				setName((String)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				setFont((NuklearFont)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				setNullTexture((SampledImage)newValue);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				setLayoutTask((NuklearLayoutTask)newValue);
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
			case NuklearPackage.NUKLEAR_CONTEXT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				setFont((NuklearFont)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				setNullTexture((SampledImage)null);
				return;
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				setLayoutTask((NuklearLayoutTask)null);
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
			case NuklearPackage.NUKLEAR_CONTEXT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NuklearPackage.NUKLEAR_CONTEXT__FONT:
				return font != null;
			case NuklearPackage.NUKLEAR_CONTEXT__NULL_TEXTURE:
				return nullTexture != null;
			case NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK:
				return layoutTask != null;
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

} //NuklearContextImpl
