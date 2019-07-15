/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vertex Input State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.VertexInputStateImpl#getInputDescriptor <em>Input Descriptor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VertexInputStateImpl extends MinimalEObjectImpl.Container implements VertexInputState
{
	/**
	 * The cached value of the '{@link #getInputDescriptor() <em>Input Descriptor</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputDescriptor()
	 * @generated
	 * @ordered
	 */
	protected EList<InputDescriptor> inputDescriptor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VertexInputStateImpl()
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
		return GraphicPackage.Literals.VERTEX_INPUT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InputDescriptor> getInputDescriptor()
	{
		if (inputDescriptor == null)
		{
			inputDescriptor = new EObjectContainmentEList<InputDescriptor>(InputDescriptor.class,
					this, GraphicPackage.VERTEX_INPUT_STATE__INPUT_DESCRIPTOR);
		}
		return inputDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case GraphicPackage.VERTEX_INPUT_STATE__INPUT_DESCRIPTOR:
			return ((InternalEList<?>) getInputDescriptor()).basicRemove(otherEnd, msgs);
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
		case GraphicPackage.VERTEX_INPUT_STATE__INPUT_DESCRIPTOR:
			return getInputDescriptor();
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
		case GraphicPackage.VERTEX_INPUT_STATE__INPUT_DESCRIPTOR:
			getInputDescriptor().clear();
			getInputDescriptor().addAll((Collection<? extends InputDescriptor>) newValue);
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
		case GraphicPackage.VERTEX_INPUT_STATE__INPUT_DESCRIPTOR:
			getInputDescriptor().clear();
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
		case GraphicPackage.VERTEX_INPUT_STATE__INPUT_DESCRIPTOR:
			return inputDescriptor != null && !inputDescriptor.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VertexInputStateImpl
