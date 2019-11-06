/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.process.CompositeTask;

import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;

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
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#getTransferBuffer <em>Transfer Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#getVertexBuffer <em>Vertex Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearLayoutTaskImpl#getImageArray <em>Image Array</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearLayoutTaskImpl extends LilyEObject implements NuklearLayoutTask
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
	 * The cached value of the '{@link #getTransferBuffer() <em>Transfer Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferBuffer()
	 * @generated
	 * @ordered
	 */
	protected TransferBuffer transferBuffer;

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
	 * The cached value of the '{@link #getImageArray() <em>Image Array</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageArray()
	 * @generated
	 * @ordered
	 */
	protected Texture2DArray imageArray;

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
		if (context != null && ((EObject)context).eIsProxy())
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
		if (drawTask != null && ((EObject)drawTask).eIsProxy())
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
	public TransferBuffer getTransferBuffer()
	{
		if (transferBuffer != null && ((EObject)transferBuffer).eIsProxy())
		{
			InternalEObject oldTransferBuffer = (InternalEObject)transferBuffer;
			transferBuffer = (TransferBuffer)eResolveProxy(oldTransferBuffer);
			if (transferBuffer != oldTransferBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_LAYOUT_TASK__TRANSFER_BUFFER, oldTransferBuffer, transferBuffer));
			}
		}
		return transferBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransferBuffer basicGetTransferBuffer()
	{
		return transferBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTransferBuffer(TransferBuffer newTransferBuffer)
	{
		TransferBuffer oldTransferBuffer = transferBuffer;
		transferBuffer = newTransferBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__TRANSFER_BUFFER, oldTransferBuffer, transferBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Buffer getVertexBuffer()
	{
		if (vertexBuffer != null && ((EObject)vertexBuffer).eIsProxy())
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
	public Texture2DArray getImageArray()
	{
		if (imageArray != null && ((EObject)imageArray).eIsProxy())
		{
			InternalEObject oldImageArray = (InternalEObject)imageArray;
			imageArray = (Texture2DArray)eResolveProxy(oldImageArray);
			if (imageArray != oldImageArray)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_LAYOUT_TASK__IMAGE_ARRAY, oldImageArray, imageArray));
			}
		}
		return imageArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Texture2DArray basicGetImageArray()
	{
		return imageArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageArray(Texture2DArray newImageArray)
	{
		Texture2DArray oldImageArray = imageArray;
		imageArray = newImageArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_LAYOUT_TASK__IMAGE_ARRAY, oldImageArray, imageArray));
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__TRANSFER_BUFFER:
				if (resolve) return getTransferBuffer();
				return basicGetTransferBuffer();
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER:
				if (resolve) return getVertexBuffer();
				return basicGetVertexBuffer();
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__IMAGE_ARRAY:
				if (resolve) return getImageArray();
				return basicGetImageArray();
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__TRANSFER_BUFFER:
				setTransferBuffer((TransferBuffer)newValue);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER:
				setVertexBuffer((Buffer)newValue);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__IMAGE_ARRAY:
				setImageArray((Texture2DArray)newValue);
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__TRANSFER_BUFFER:
				setTransferBuffer((TransferBuffer)null);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER:
				setVertexBuffer((Buffer)null);
				return;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__IMAGE_ARRAY:
				setImageArray((Texture2DArray)null);
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
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__TRANSFER_BUFFER:
				return transferBuffer != null;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__VERTEX_BUFFER:
				return vertexBuffer != null;
			case NuklearPackage.NUKLEAR_LAYOUT_TASK__IMAGE_ARRAY:
				return imageArray != null;
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
