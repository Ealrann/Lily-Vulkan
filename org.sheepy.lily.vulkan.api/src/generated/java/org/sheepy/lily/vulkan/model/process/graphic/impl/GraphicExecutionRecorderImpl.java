/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Recorder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicExecutionRecorderImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicExecutionRecorderImpl#getCommandBuffer <em>Command Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicExecutionRecorderImpl extends LilyEObject implements GraphicExecutionRecorder
{
	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCommandBuffer() <em>Command Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandBuffer()
	 * @generated
	 * @ordered
	 */
	protected GraphicCommandBuffer commandBuffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicExecutionRecorderImpl()
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
		return GraphicPackage.Literals.GRAPHIC_EXECUTION_RECORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIndex()
	{
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndex(int newIndex)
	{
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_EXECUTION_RECORDER__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicCommandBuffer getCommandBuffer()
	{
		if (commandBuffer != null && ((EObject)commandBuffer).eIsProxy())
		{
			InternalEObject oldCommandBuffer = commandBuffer;
			commandBuffer = (GraphicCommandBuffer)eResolveProxy(oldCommandBuffer);
			if (commandBuffer != oldCommandBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER, oldCommandBuffer, commandBuffer));
			}
		}
		return commandBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicCommandBuffer basicGetCommandBuffer()
	{
		return commandBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommandBuffer(GraphicCommandBuffer newCommandBuffer, NotificationChain msgs)
	{
		GraphicCommandBuffer oldCommandBuffer = commandBuffer;
		commandBuffer = newCommandBuffer;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER, oldCommandBuffer, newCommandBuffer);
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
	public void setCommandBuffer(GraphicCommandBuffer newCommandBuffer)
	{
		if (newCommandBuffer != commandBuffer)
		{
			NotificationChain msgs = null;
			if (commandBuffer != null)
				msgs = ((InternalEObject)commandBuffer).eInverseRemove(this, GraphicPackage.GRAPHIC_COMMAND_BUFFER__SUBMITTED_BY, GraphicCommandBuffer.class, msgs);
			if (newCommandBuffer != null)
				msgs = ((InternalEObject)newCommandBuffer).eInverseAdd(this, GraphicPackage.GRAPHIC_COMMAND_BUFFER__SUBMITTED_BY, GraphicCommandBuffer.class, msgs);
			msgs = basicSetCommandBuffer(newCommandBuffer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER, newCommandBuffer, newCommandBuffer));
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
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER:
				if (commandBuffer != null)
					msgs = ((InternalEObject)commandBuffer).eInverseRemove(this, GraphicPackage.GRAPHIC_COMMAND_BUFFER__SUBMITTED_BY, GraphicCommandBuffer.class, msgs);
				return basicSetCommandBuffer((GraphicCommandBuffer)otherEnd, msgs);
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
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER:
				return basicSetCommandBuffer(null, msgs);
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
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__INDEX:
				return getIndex();
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER:
				if (resolve) return getCommandBuffer();
				return basicGetCommandBuffer();
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
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__INDEX:
				setIndex((Integer)newValue);
				return;
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER:
				setCommandBuffer((GraphicCommandBuffer)newValue);
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
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER:
				setCommandBuffer((GraphicCommandBuffer)null);
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
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__INDEX:
				return index != INDEX_EDEFAULT;
			case GraphicPackage.GRAPHIC_EXECUTION_RECORDER__COMMAND_BUFFER:
				return commandBuffer != null;
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
		result.append(" (index: ");
		result.append(index);
		result.append(')');
		return result.toString();
	}

} //GraphicExecutionRecorderImpl
