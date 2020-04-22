/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fill Buffer Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFillBufferTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFillBufferTaskImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFillBufferTaskImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFillBufferTaskImpl#getDrawTask <em>Draw Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFillBufferTaskImpl#getVertexBuffer <em>Vertex Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFillBufferTaskImpl#getLayoutTask <em>Layout Task</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearFillBufferTaskImpl extends LilyEObject implements NuklearFillBufferTask
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
	 * The cached value of the '{@link #getVertexBuffer() <em>Vertex Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexBuffer()
	 * @generated
	 * @ordered
	 */
	protected CompositeBuffer vertexBuffer;

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
	protected NuklearFillBufferTaskImpl()
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
		return NuklearPackage.Literals.NUKLEAR_FILL_BUFFER_TASK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearContext getContext()
	{
		if (context != null && ((EObject)context).eIsProxy())
		{
			InternalEObject oldContext = (InternalEObject)context;
			context = (NuklearContext)eResolveProxy(oldContext);
			if (context != oldContext)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__CONTEXT, oldContext, context));
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
	@Override
	public void setContext(NuklearContext newContext)
	{
		NuklearContext oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeTask getDrawTask()
	{
		if (drawTask != null && ((EObject)drawTask).eIsProxy())
		{
			InternalEObject oldDrawTask = (InternalEObject)drawTask;
			drawTask = (CompositeTask)eResolveProxy(oldDrawTask);
			if (drawTask != oldDrawTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__DRAW_TASK, oldDrawTask, drawTask));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__DRAW_TASK, oldDrawTask, drawTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeBuffer getVertexBuffer()
	{
		if (vertexBuffer != null && ((EObject)vertexBuffer).eIsProxy())
		{
			InternalEObject oldVertexBuffer = (InternalEObject)vertexBuffer;
			vertexBuffer = (CompositeBuffer)eResolveProxy(oldVertexBuffer);
			if (vertexBuffer != oldVertexBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__VERTEX_BUFFER, oldVertexBuffer, vertexBuffer));
			}
		}
		return vertexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeBuffer basicGetVertexBuffer()
	{
		return vertexBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexBuffer(CompositeBuffer newVertexBuffer)
	{
		CompositeBuffer oldVertexBuffer = vertexBuffer;
		vertexBuffer = newVertexBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__VERTEX_BUFFER, oldVertexBuffer, vertexBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearLayoutTask getLayoutTask()
	{
		if (layoutTask != null && ((EObject)layoutTask).eIsProxy())
		{
			InternalEObject oldLayoutTask = (InternalEObject)layoutTask;
			layoutTask = (NuklearLayoutTask)eResolveProxy(oldLayoutTask);
			if (layoutTask != oldLayoutTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__LAYOUT_TASK, oldLayoutTask, layoutTask));
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
	@Override
	public void setLayoutTask(NuklearLayoutTask newLayoutTask)
	{
		NuklearLayoutTask oldLayoutTask = layoutTask;
		layoutTask = newLayoutTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__LAYOUT_TASK, oldLayoutTask, layoutTask));
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
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__NAME:
				return getName();
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__ENABLED:
				return isEnabled();
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__DRAW_TASK:
				if (resolve) return getDrawTask();
				return basicGetDrawTask();
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__VERTEX_BUFFER:
				if (resolve) return getVertexBuffer();
				return basicGetVertexBuffer();
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__LAYOUT_TASK:
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
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__NAME:
				setName((String)newValue);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__CONTEXT:
				setContext((NuklearContext)newValue);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__DRAW_TASK:
				setDrawTask((CompositeTask)newValue);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__VERTEX_BUFFER:
				setVertexBuffer((CompositeBuffer)newValue);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__LAYOUT_TASK:
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
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__CONTEXT:
				setContext((NuklearContext)null);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__DRAW_TASK:
				setDrawTask((CompositeTask)null);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__VERTEX_BUFFER:
				setVertexBuffer((CompositeBuffer)null);
				return;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__LAYOUT_TASK:
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
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__CONTEXT:
				return context != null;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__DRAW_TASK:
				return drawTask != null;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__VERTEX_BUFFER:
				return vertexBuffer != null;
			case NuklearPackage.NUKLEAR_FILL_BUFFER_TASK__LAYOUT_TASK:
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
		result.append(", enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

} //NuklearFillBufferTaskImpl
