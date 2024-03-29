/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicExecutionManagerImpl#getRecorders <em>Recorders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicExecutionManagerImpl#getCommandBuffers <em>Command Buffers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicExecutionManagerImpl extends ProcessExecutionManagerImpl implements GraphicExecutionManager
{
	/**
	 * The cached value of the '{@link #getRecorders() <em>Recorders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecorders()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphicExecutionRecorder> recorders;

	/**
	 * The cached value of the '{@link #getCommandBuffers() <em>Command Buffers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandBuffers()
	 * @generated
	 * @ordered
	 */
	protected EList<GraphicCommandBuffer> commandBuffers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicExecutionManagerImpl()
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
		return GraphicPackage.Literals.GRAPHIC_EXECUTION_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GraphicExecutionRecorder> getRecorders()
	{
		if (recorders == null)
		{
			recorders = new EObjectContainmentEList<>(GraphicExecutionRecorder.class, this, GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS);
		}
		return recorders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GraphicCommandBuffer> getCommandBuffers()
	{
		if (commandBuffers == null)
		{
			commandBuffers = new EObjectContainmentEList<>(GraphicCommandBuffer.class, this, GraphicPackage.GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS);
		}
		return commandBuffers;
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
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS:
				return ((InternalEList<?>)getRecorders()).basicRemove(otherEnd, msgs);
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS:
				return ((InternalEList<?>)getCommandBuffers()).basicRemove(otherEnd, msgs);
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
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS:
				return getRecorders();
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS:
				return getCommandBuffers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS:
				getRecorders().clear();
				getRecorders().addAll((Collection<? extends GraphicExecutionRecorder>)newValue);
				return;
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS:
				getCommandBuffers().clear();
				getCommandBuffers().addAll((Collection<? extends GraphicCommandBuffer>)newValue);
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
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS:
				getRecorders().clear();
				return;
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS:
				getCommandBuffers().clear();
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
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__RECORDERS:
				return recorders != null && !recorders.isEmpty();
			case GraphicPackage.GRAPHIC_EXECUTION_MANAGER__COMMAND_BUFFERS:
				return commandBuffers != null && !commandBuffers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GraphicExecutionManagerImpl
