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
import org.sheepy.lily.vulkan.model.process.graphic.Scissor;
import org.sheepy.lily.vulkan.model.process.graphic.StaticViewportState;
import org.sheepy.lily.vulkan.model.process.graphic.Viewport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Viewport State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.StaticViewportStateImpl#getViewports <em>Viewports</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.StaticViewportStateImpl#getScissors <em>Scissors</em>}</li>
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
	public StaticViewportStateImpl()
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
		return GraphicPackage.Literals.STATIC_VIEWPORT_STATE;
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
					GraphicPackage.STATIC_VIEWPORT_STATE__VIEWPORTS);
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
					GraphicPackage.STATIC_VIEWPORT_STATE__SCISSORS);
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
		case GraphicPackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			return ((InternalEList<?>) getViewports()).basicRemove(otherEnd, msgs);
		case GraphicPackage.STATIC_VIEWPORT_STATE__SCISSORS:
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
		case GraphicPackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			return getViewports();
		case GraphicPackage.STATIC_VIEWPORT_STATE__SCISSORS:
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
		case GraphicPackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			getViewports().clear();
			getViewports().addAll((Collection<? extends Viewport>) newValue);
			return;
		case GraphicPackage.STATIC_VIEWPORT_STATE__SCISSORS:
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
		case GraphicPackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			getViewports().clear();
			return;
		case GraphicPackage.STATIC_VIEWPORT_STATE__SCISSORS:
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
		case GraphicPackage.STATIC_VIEWPORT_STATE__VIEWPORTS:
			return viewports != null && !viewports.isEmpty();
		case GraphicPackage.STATIC_VIEWPORT_STATE__SCISSORS:
			return scissors != null && !scissors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StaticViewportStateImpl
