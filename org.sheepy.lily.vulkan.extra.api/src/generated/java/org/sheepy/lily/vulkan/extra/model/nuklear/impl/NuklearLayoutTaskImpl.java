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
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.process.CompositeTask;

import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nuklear Layout Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#getDrawTask <em>Draw Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#getPushBuffer <em>Push Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#getVertexBuffer <em>Vertex Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearLayoutTaskImpl extends MinimalEObjectImpl.Container implements NuklearLayoutTask
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
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected NuklearContext context;

	/**
	 * The cached value of the '{@link #getDrawTask() <em>Draw Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrawTask()
	 * @generated
	 * @ordered
	 */
	protected CompositeTask drawTask;

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
	 * The cached value of the '{@link #getVertexBuffer() <em>Vertex Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexBuffer()
	 * @generated
	 * @ordered
	 */
	protected Buffer vertexBuffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearLayoutTaskImpl()
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
		return NuklearPackage.Literals.NUKLEAR_LAYOUT_TASK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearContext getContext()
	{
		if (context != null && context.eIsProxy())
		{
			InternalEObject oldContext = (InternalEObject)context;
			context = (NuklearContext)eResolveProxy(oldContext);
			if (context != oldContext)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearContext basicGetContext()
	{
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(NuklearContext newContext, NotificationChain msgs)
	{
		NuklearContext oldContext = context;
		context = newContext;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, oldContext, newContext);
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
	public void setContext(NuklearContext newContext)
	{
		if (newContext != context)
		{
			NotificationChain msgs = null;
			if (context != null)
				msgs = ((InternalEObject)context).eInverseRemove(this, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, NuklearContext.class, msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, NuklearContext.class, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeTask getDrawTask()
	{
		if (drawTask != null && drawTask.eIsProxy())
		{
			InternalEObject oldDrawTask = (InternalEObject)drawTask;
			drawTask = (CompositeTask)eResolveProxy(oldDrawTask);
			if (drawTask != oldDrawTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_LAYOUT_TASK__DRAW_TASK, oldDrawTask, drawTask));
			}
		}
		return drawTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeTask basicGetDrawTask()
	{
		return drawTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDrawTask(CompositeTask newDrawTask)
	{
		CompositeTask oldDrawTask = drawTask;
		drawTask = newDrawTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__DRAW_TASK, oldDrawTask, drawTask));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_LAYOUT_TASK__PUSH_BUFFER, oldPushBuffer, pushBuffer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__PUSH_BUFFER, oldPushBuffer, pushBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getVertexBuffer()
	{
		if (vertexBuffer != null && vertexBuffer.eIsProxy())
		{
			InternalEObject oldVertexBuffer = (InternalEObject)vertexBuffer;
			vertexBuffer = (Buffer)eResolveProxy(oldVertexBuffer);
			if (vertexBuffer != oldVertexBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER, oldVertexBuffer, vertexBuffer));
			}
		}
		return vertexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer basicGetVertexBuffer()
	{
		return vertexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexBuffer(Buffer newVertexBuffer)
	{
		Buffer oldVertexBuffer = vertexBuffer;
		vertexBuffer = newVertexBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER, oldVertexBuffer, vertexBuffer));
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT:
				if (context != null)
					msgs = ((InternalEObject)context).eInverseRemove(this, NuklearPackage.NUKLEAR_CONTEXT__LAYOUT_TASK, NuklearContext.class, msgs);
				return basicSetContext((NuklearContext)otherEnd, msgs);
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT:
				return basicSetContext(null, msgs);
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__NAME:
				return getName();
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__ENABLED:
				return isEnabled();
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__DRAW_TASK:
				if (resolve) return getDrawTask();
				return basicGetDrawTask();
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__PUSH_BUFFER:
				if (resolve) return getPushBuffer();
				return basicGetPushBuffer();
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER:
				if (resolve) return getVertexBuffer();
				return basicGetVertexBuffer();
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__NAME:
				setName((String)newValue);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT:
				setContext((NuklearContext)newValue);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__DRAW_TASK:
				setDrawTask((CompositeTask)newValue);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__PUSH_BUFFER:
				setPushBuffer((PushBuffer)newValue);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER:
				setVertexBuffer((Buffer)newValue);
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT:
				setContext((NuklearContext)null);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__DRAW_TASK:
				setDrawTask((CompositeTask)null);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__PUSH_BUFFER:
				setPushBuffer((PushBuffer)null);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER:
				setVertexBuffer((Buffer)null);
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__CONTEXT:
				return context != null;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__DRAW_TASK:
				return drawTask != null;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__PUSH_BUFFER:
				return pushBuffer != null;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER:
				return vertexBuffer != null;
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
		result.append(')');
		return result.toString();
	}

} //NuklearLayoutTaskImpl
