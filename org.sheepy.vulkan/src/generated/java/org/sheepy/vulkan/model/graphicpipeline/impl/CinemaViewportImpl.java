/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.vulkan.model.graphicpipeline.CinemaViewport;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cinema Viewport</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.CinemaViewportImpl#getAspectRatio <em>Aspect Ratio</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.CinemaViewportImpl#getMinDepth <em>Min Depth</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.CinemaViewportImpl#getMaxDepth <em>Max Depth</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CinemaViewportImpl extends LilyEObject implements CinemaViewport
{
	/**
	 * The default value of the '{@link #getAspectRatio() <em>Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspectRatio()
	 * @generated
	 * @ordered
	 */
	protected static final float ASPECT_RATIO_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getAspectRatio() <em>Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspectRatio()
	 * @generated
	 * @ordered
	 */
	protected float aspectRatio = ASPECT_RATIO_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinDepth() <em>Min Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_DEPTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinDepth() <em>Min Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinDepth()
	 * @generated
	 * @ordered
	 */
	protected int minDepth = MIN_DEPTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxDepth() <em>Max Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_DEPTH_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMaxDepth() <em>Max Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDepth()
	 * @generated
	 * @ordered
	 */
	protected int maxDepth = MAX_DEPTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CinemaViewportImpl()
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
		return GraphicpipelinePackage.Literals.CINEMA_VIEWPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getAspectRatio()
	{
		return aspectRatio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAspectRatio(float newAspectRatio)
	{
		float oldAspectRatio = aspectRatio;
		aspectRatio = newAspectRatio;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.CINEMA_VIEWPORT__ASPECT_RATIO, oldAspectRatio, aspectRatio));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMinDepth()
	{
		return minDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinDepth(int newMinDepth)
	{
		int oldMinDepth = minDepth;
		minDepth = newMinDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.CINEMA_VIEWPORT__MIN_DEPTH, oldMinDepth, minDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxDepth()
	{
		return maxDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxDepth(int newMaxDepth)
	{
		int oldMaxDepth = maxDepth;
		maxDepth = newMaxDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.CINEMA_VIEWPORT__MAX_DEPTH, oldMaxDepth, maxDepth));
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
			case GraphicpipelinePackage.CINEMA_VIEWPORT__ASPECT_RATIO:
				return getAspectRatio();
			case GraphicpipelinePackage.CINEMA_VIEWPORT__MIN_DEPTH:
				return getMinDepth();
			case GraphicpipelinePackage.CINEMA_VIEWPORT__MAX_DEPTH:
				return getMaxDepth();
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
			case GraphicpipelinePackage.CINEMA_VIEWPORT__ASPECT_RATIO:
				setAspectRatio((Float)newValue);
				return;
			case GraphicpipelinePackage.CINEMA_VIEWPORT__MIN_DEPTH:
				setMinDepth((Integer)newValue);
				return;
			case GraphicpipelinePackage.CINEMA_VIEWPORT__MAX_DEPTH:
				setMaxDepth((Integer)newValue);
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
			case GraphicpipelinePackage.CINEMA_VIEWPORT__ASPECT_RATIO:
				setAspectRatio(ASPECT_RATIO_EDEFAULT);
				return;
			case GraphicpipelinePackage.CINEMA_VIEWPORT__MIN_DEPTH:
				setMinDepth(MIN_DEPTH_EDEFAULT);
				return;
			case GraphicpipelinePackage.CINEMA_VIEWPORT__MAX_DEPTH:
				setMaxDepth(MAX_DEPTH_EDEFAULT);
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
			case GraphicpipelinePackage.CINEMA_VIEWPORT__ASPECT_RATIO:
				return aspectRatio != ASPECT_RATIO_EDEFAULT;
			case GraphicpipelinePackage.CINEMA_VIEWPORT__MIN_DEPTH:
				return minDepth != MIN_DEPTH_EDEFAULT;
			case GraphicpipelinePackage.CINEMA_VIEWPORT__MAX_DEPTH:
				return maxDepth != MAX_DEPTH_EDEFAULT;
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
		result.append(" (aspectRatio: ");
		result.append(aspectRatio);
		result.append(", minDepth: ");
		result.append(minDepth);
		result.append(", maxDepth: ");
		result.append(maxDepth);
		result.append(')');
		return result.toString();
	}

} //CinemaViewportImpl
