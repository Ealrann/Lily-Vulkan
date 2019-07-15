/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;
import org.sheepy.vulkan.model.graphicpipeline.StaticViewportState;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Viewport State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.StaticViewportStateImpl#getViewports <em>Viewports</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.StaticViewportStateImpl#getScissors <em>Scissors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StaticViewportStateImpl extends MinimalEObjectImpl.Container
		implements StaticViewportState
{
	/**
	 * The cached value of the '{@link #getViewports() <em>Viewports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewports()
	 * @generated
	 * @ordered
	 */
	protected EList<Viewport> viewports;

	/**
	 * The cached value of the '{@link #getScissors() <em>Scissors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScissors()
	 * @generated
	 * @ordered
	 */
	protected EList<Scissor> scissors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticViewportStateImpl()
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
		return GraphicpipelinePackage.Literals.STATIC_VIEWPORT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Viewport> getViewports()
	{
		if (viewports == null)
		{
			viewports = new EObjectContainmentEList<Viewport>(Viewport.class, this,
					GraphicpipelinePackage.STATIC_VIEWPORT_STATE__VIEWPORTS);
		}
		return viewports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Scissor> getScissors()
	{
		if (scissors == null)
		{
			scissors = new EObjectContainmentEList<Scissor>(Scissor.class, this,
					GraphicpipelinePackage.STATIC_VIEWPORT_STATE__SCISSORS);
		}
		return scissors;
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
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			return ((InternalEList<?>) getViewports()).basicRemove(otherEnd, msgs);
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__SCISSORS:
			return ((InternalEList<?>) getScissors()).basicRemove(otherEnd, msgs);
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
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			return getViewports();
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__SCISSORS:
			return getScissors();
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
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			getViewports().clear();
			getViewports().addAll((Collection<? extends Viewport>) newValue);
			return;
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__SCISSORS:
			getScissors().clear();
			getScissors().addAll((Collection<? extends Scissor>) newValue);
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
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			getViewports().clear();
			return;
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__SCISSORS:
			getScissors().clear();
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
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			return viewports != null && !viewports.isEmpty();
		case GraphicpipelinePackage.STATIC_VIEWPORT_STATE__SCISSORS:
			return scissors != null && !scissors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StaticViewportStateImpl
