/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Viewport State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DynamicViewportStateImpl#getViewportCount <em>Viewport Count</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DynamicViewportStateImpl#getScissorCount <em>Scissor Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DynamicViewportStateImpl extends LilyEObject implements DynamicViewportState
{
	/**
	 * The default value of the '{@link #getViewportCount() <em>Viewport Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewportCount()
	 * @generated
	 * @ordered
	 */
	protected static final int VIEWPORT_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getViewportCount() <em>Viewport Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewportCount()
	 * @generated
	 * @ordered
	 */
	protected int viewportCount = VIEWPORT_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getScissorCount() <em>Scissor Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScissorCount()
	 * @generated
	 * @ordered
	 */
	protected static final int SCISSOR_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getScissorCount() <em>Scissor Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScissorCount()
	 * @generated
	 * @ordered
	 */
	protected int scissorCount = SCISSOR_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicViewportStateImpl()
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
		return GraphicpipelinePackage.Literals.DYNAMIC_VIEWPORT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getViewportCount()
	{
		return viewportCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setViewportCount(int newViewportCount)
	{
		int oldViewportCount = viewportCount;
		viewportCount = newViewportCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT, oldViewportCount, viewportCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getScissorCount()
	{
		return scissorCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScissorCount(int newScissorCount)
	{
		int oldScissorCount = scissorCount;
		scissorCount = newScissorCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT, oldScissorCount, scissorCount));
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
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT:
				return getViewportCount();
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT:
				return getScissorCount();
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
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT:
				setViewportCount((Integer)newValue);
				return;
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT:
				setScissorCount((Integer)newValue);
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
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT:
				setViewportCount(VIEWPORT_COUNT_EDEFAULT);
				return;
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT:
				setScissorCount(SCISSOR_COUNT_EDEFAULT);
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
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__VIEWPORT_COUNT:
				return viewportCount != VIEWPORT_COUNT_EDEFAULT;
			case GraphicpipelinePackage.DYNAMIC_VIEWPORT_STATE__SCISSOR_COUNT:
				return scissorCount != SCISSOR_COUNT_EDEFAULT;
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
		result.append(" (viewportCount: ");
		result.append(viewportCount);
		result.append(", scissorCount: ");
		result.append(scissorCount);
		result.append(')');
		return result.toString();
	}

} //DynamicViewportStateImpl
