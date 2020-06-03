/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Viewport</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl#getOffsetX <em>Offset X</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl#getOffsetY <em>Offset Y</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl#getMinDepth <em>Min Depth</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl#getMaxDepth <em>Max Depth</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl#getExtent <em>Extent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewportImpl extends LilyEObject implements Viewport
{
	/**
	 * The default value of the '{@link #getOffsetX() <em>Offset X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetX()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffsetX() <em>Offset X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetX()
	 * @generated
	 * @ordered
	 */
	protected int offsetX = OFFSET_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffsetY() <em>Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetY()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffsetY() <em>Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffsetY()
	 * @generated
	 * @ordered
	 */
	protected int offsetY = OFFSET_Y_EDEFAULT;

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
	 * The default value of the '{@link #getExtent() <em>Extent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtent()
	 * @generated
	 * @ordered
	 */
	protected static final Vector2ic EXTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtent() <em>Extent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtent()
	 * @generated
	 * @ordered
	 */
	protected Vector2ic extent = EXTENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewportImpl()
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
		return GraphicpipelinePackage.Literals.VIEWPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOffsetX()
	{
		return offsetX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetX(int newOffsetX)
	{
		int oldOffsetX = offsetX;
		offsetX = newOffsetX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.VIEWPORT__OFFSET_X, oldOffsetX, offsetX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOffsetY()
	{
		return offsetY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffsetY(int newOffsetY)
	{
		int oldOffsetY = offsetY;
		offsetY = newOffsetY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.VIEWPORT__OFFSET_Y, oldOffsetY, offsetY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector2ic getExtent()
	{
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtent(Vector2ic newExtent)
	{
		Vector2ic oldExtent = extent;
		extent = newExtent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.VIEWPORT__EXTENT, oldExtent, extent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.VIEWPORT__MIN_DEPTH, oldMinDepth, minDepth));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.VIEWPORT__MAX_DEPTH, oldMaxDepth, maxDepth));
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
			case GraphicpipelinePackage.VIEWPORT__OFFSET_X:
				return getOffsetX();
			case GraphicpipelinePackage.VIEWPORT__OFFSET_Y:
				return getOffsetY();
			case GraphicpipelinePackage.VIEWPORT__MIN_DEPTH:
				return getMinDepth();
			case GraphicpipelinePackage.VIEWPORT__MAX_DEPTH:
				return getMaxDepth();
			case GraphicpipelinePackage.VIEWPORT__EXTENT:
				return getExtent();
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
			case GraphicpipelinePackage.VIEWPORT__OFFSET_X:
				setOffsetX((Integer)newValue);
				return;
			case GraphicpipelinePackage.VIEWPORT__OFFSET_Y:
				setOffsetY((Integer)newValue);
				return;
			case GraphicpipelinePackage.VIEWPORT__MIN_DEPTH:
				setMinDepth((Integer)newValue);
				return;
			case GraphicpipelinePackage.VIEWPORT__MAX_DEPTH:
				setMaxDepth((Integer)newValue);
				return;
			case GraphicpipelinePackage.VIEWPORT__EXTENT:
				setExtent((Vector2ic)newValue);
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
			case GraphicpipelinePackage.VIEWPORT__OFFSET_X:
				setOffsetX(OFFSET_X_EDEFAULT);
				return;
			case GraphicpipelinePackage.VIEWPORT__OFFSET_Y:
				setOffsetY(OFFSET_Y_EDEFAULT);
				return;
			case GraphicpipelinePackage.VIEWPORT__MIN_DEPTH:
				setMinDepth(MIN_DEPTH_EDEFAULT);
				return;
			case GraphicpipelinePackage.VIEWPORT__MAX_DEPTH:
				setMaxDepth(MAX_DEPTH_EDEFAULT);
				return;
			case GraphicpipelinePackage.VIEWPORT__EXTENT:
				setExtent(EXTENT_EDEFAULT);
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
			case GraphicpipelinePackage.VIEWPORT__OFFSET_X:
				return offsetX != OFFSET_X_EDEFAULT;
			case GraphicpipelinePackage.VIEWPORT__OFFSET_Y:
				return offsetY != OFFSET_Y_EDEFAULT;
			case GraphicpipelinePackage.VIEWPORT__MIN_DEPTH:
				return minDepth != MIN_DEPTH_EDEFAULT;
			case GraphicpipelinePackage.VIEWPORT__MAX_DEPTH:
				return maxDepth != MAX_DEPTH_EDEFAULT;
			case GraphicpipelinePackage.VIEWPORT__EXTENT:
				return EXTENT_EDEFAULT == null ? extent != null : !EXTENT_EDEFAULT.equals(extent);
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
		result.append(" (offsetX: ");
		result.append(offsetX);
		result.append(", offsetY: ");
		result.append(offsetY);
		result.append(", minDepth: ");
		result.append(minDepth);
		result.append(", maxDepth: ");
		result.append(maxDepth);
		result.append(", extent: ");
		result.append(extent);
		result.append(')');
		return result.toString();
	}

} //ViewportImpl
