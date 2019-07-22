/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.enumeration.EPolygonMode;

import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rasterizer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl#getCullMode <em>Cull Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl#getFrontFace <em>Front Face</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl#getPolygonMode <em>Polygon Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl#isDepthClampEnable <em>Depth Clamp Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl#isDiscardEnable <em>Discard Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.RasterizerImpl#isDepthBiasEnable <em>Depth Bias Enable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RasterizerImpl extends MinimalEObjectImpl.Container implements Rasterizer
{
	/**
	 * The default value of the '{@link #getCullMode() <em>Cull Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCullMode()
	 * @generated
	 * @ordered
	 */
	protected static final ECullMode CULL_MODE_EDEFAULT = ECullMode.BACK_BIT;

	/**
	 * The cached value of the '{@link #getCullMode() <em>Cull Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCullMode()
	 * @generated
	 * @ordered
	 */
	protected ECullMode cullMode = CULL_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrontFace() <em>Front Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrontFace()
	 * @generated
	 * @ordered
	 */
	protected static final EFrontFace FRONT_FACE_EDEFAULT = EFrontFace.CLOCKWISE;

	/**
	 * The cached value of the '{@link #getFrontFace() <em>Front Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrontFace()
	 * @generated
	 * @ordered
	 */
	protected EFrontFace frontFace = FRONT_FACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPolygonMode() <em>Polygon Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolygonMode()
	 * @generated
	 * @ordered
	 */
	protected static final EPolygonMode POLYGON_MODE_EDEFAULT = EPolygonMode.FILL;

	/**
	 * The cached value of the '{@link #getPolygonMode() <em>Polygon Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolygonMode()
	 * @generated
	 * @ordered
	 */
	protected EPolygonMode polygonMode = POLYGON_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_WIDTH_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected int lineWidth = LINE_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isDepthClampEnable() <em>Depth Clamp Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthClampEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPTH_CLAMP_ENABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDepthClampEnable() <em>Depth Clamp Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthClampEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean depthClampEnable = DEPTH_CLAMP_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDiscardEnable() <em>Discard Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDiscardEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISCARD_ENABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDiscardEnable() <em>Discard Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDiscardEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean discardEnable = DISCARD_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDepthBiasEnable() <em>Depth Bias Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthBiasEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPTH_BIAS_ENABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDepthBiasEnable() <em>Depth Bias Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthBiasEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean depthBiasEnable = DEPTH_BIAS_ENABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RasterizerImpl()
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
		return GraphicpipelinePackage.Literals.RASTERIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECullMode getCullMode()
	{
		return cullMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCullMode(ECullMode newCullMode)
	{
		ECullMode oldCullMode = cullMode;
		cullMode = newCullMode == null ? CULL_MODE_EDEFAULT : newCullMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.RASTERIZER__CULL_MODE, oldCullMode, cullMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFrontFace getFrontFace()
	{
		return frontFace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrontFace(EFrontFace newFrontFace)
	{
		EFrontFace oldFrontFace = frontFace;
		frontFace = newFrontFace == null ? FRONT_FACE_EDEFAULT : newFrontFace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.RASTERIZER__FRONT_FACE, oldFrontFace, frontFace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPolygonMode getPolygonMode()
	{
		return polygonMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPolygonMode(EPolygonMode newPolygonMode)
	{
		EPolygonMode oldPolygonMode = polygonMode;
		polygonMode = newPolygonMode == null ? POLYGON_MODE_EDEFAULT : newPolygonMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.RASTERIZER__POLYGON_MODE, oldPolygonMode, polygonMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getLineWidth()
	{
		return lineWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLineWidth(int newLineWidth)
	{
		int oldLineWidth = lineWidth;
		lineWidth = newLineWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.RASTERIZER__LINE_WIDTH, oldLineWidth, lineWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDepthClampEnable()
	{
		return depthClampEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthClampEnable(boolean newDepthClampEnable)
	{
		boolean oldDepthClampEnable = depthClampEnable;
		depthClampEnable = newDepthClampEnable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.RASTERIZER__DEPTH_CLAMP_ENABLE, oldDepthClampEnable, depthClampEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDiscardEnable()
	{
		return discardEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDiscardEnable(boolean newDiscardEnable)
	{
		boolean oldDiscardEnable = discardEnable;
		discardEnable = newDiscardEnable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.RASTERIZER__DISCARD_ENABLE, oldDiscardEnable, discardEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDepthBiasEnable()
	{
		return depthBiasEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthBiasEnable(boolean newDepthBiasEnable)
	{
		boolean oldDepthBiasEnable = depthBiasEnable;
		depthBiasEnable = newDepthBiasEnable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.RASTERIZER__DEPTH_BIAS_ENABLE, oldDepthBiasEnable, depthBiasEnable));
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
			case GraphicpipelinePackage.RASTERIZER__CULL_MODE:
				return getCullMode();
			case GraphicpipelinePackage.RASTERIZER__FRONT_FACE:
				return getFrontFace();
			case GraphicpipelinePackage.RASTERIZER__POLYGON_MODE:
				return getPolygonMode();
			case GraphicpipelinePackage.RASTERIZER__LINE_WIDTH:
				return getLineWidth();
			case GraphicpipelinePackage.RASTERIZER__DEPTH_CLAMP_ENABLE:
				return isDepthClampEnable();
			case GraphicpipelinePackage.RASTERIZER__DISCARD_ENABLE:
				return isDiscardEnable();
			case GraphicpipelinePackage.RASTERIZER__DEPTH_BIAS_ENABLE:
				return isDepthBiasEnable();
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
			case GraphicpipelinePackage.RASTERIZER__CULL_MODE:
				setCullMode((ECullMode)newValue);
				return;
			case GraphicpipelinePackage.RASTERIZER__FRONT_FACE:
				setFrontFace((EFrontFace)newValue);
				return;
			case GraphicpipelinePackage.RASTERIZER__POLYGON_MODE:
				setPolygonMode((EPolygonMode)newValue);
				return;
			case GraphicpipelinePackage.RASTERIZER__LINE_WIDTH:
				setLineWidth((Integer)newValue);
				return;
			case GraphicpipelinePackage.RASTERIZER__DEPTH_CLAMP_ENABLE:
				setDepthClampEnable((Boolean)newValue);
				return;
			case GraphicpipelinePackage.RASTERIZER__DISCARD_ENABLE:
				setDiscardEnable((Boolean)newValue);
				return;
			case GraphicpipelinePackage.RASTERIZER__DEPTH_BIAS_ENABLE:
				setDepthBiasEnable((Boolean)newValue);
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
			case GraphicpipelinePackage.RASTERIZER__CULL_MODE:
				setCullMode(CULL_MODE_EDEFAULT);
				return;
			case GraphicpipelinePackage.RASTERIZER__FRONT_FACE:
				setFrontFace(FRONT_FACE_EDEFAULT);
				return;
			case GraphicpipelinePackage.RASTERIZER__POLYGON_MODE:
				setPolygonMode(POLYGON_MODE_EDEFAULT);
				return;
			case GraphicpipelinePackage.RASTERIZER__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case GraphicpipelinePackage.RASTERIZER__DEPTH_CLAMP_ENABLE:
				setDepthClampEnable(DEPTH_CLAMP_ENABLE_EDEFAULT);
				return;
			case GraphicpipelinePackage.RASTERIZER__DISCARD_ENABLE:
				setDiscardEnable(DISCARD_ENABLE_EDEFAULT);
				return;
			case GraphicpipelinePackage.RASTERIZER__DEPTH_BIAS_ENABLE:
				setDepthBiasEnable(DEPTH_BIAS_ENABLE_EDEFAULT);
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
			case GraphicpipelinePackage.RASTERIZER__CULL_MODE:
				return cullMode != CULL_MODE_EDEFAULT;
			case GraphicpipelinePackage.RASTERIZER__FRONT_FACE:
				return frontFace != FRONT_FACE_EDEFAULT;
			case GraphicpipelinePackage.RASTERIZER__POLYGON_MODE:
				return polygonMode != POLYGON_MODE_EDEFAULT;
			case GraphicpipelinePackage.RASTERIZER__LINE_WIDTH:
				return lineWidth != LINE_WIDTH_EDEFAULT;
			case GraphicpipelinePackage.RASTERIZER__DEPTH_CLAMP_ENABLE:
				return depthClampEnable != DEPTH_CLAMP_ENABLE_EDEFAULT;
			case GraphicpipelinePackage.RASTERIZER__DISCARD_ENABLE:
				return discardEnable != DISCARD_ENABLE_EDEFAULT;
			case GraphicpipelinePackage.RASTERIZER__DEPTH_BIAS_ENABLE:
				return depthBiasEnable != DEPTH_BIAS_ENABLE_EDEFAULT;
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
		result.append(" (cullMode: ");
		result.append(cullMode);
		result.append(", frontFace: ");
		result.append(frontFace);
		result.append(", polygonMode: ");
		result.append(polygonMode);
		result.append(", lineWidth: ");
		result.append(lineWidth);
		result.append(", depthClampEnable: ");
		result.append(depthClampEnable);
		result.append(", discardEnable: ");
		result.append(discardEnable);
		result.append(", depthBiasEnable: ");
		result.append(depthBiasEnable);
		result.append(')');
		return result.toString();
	}

} //RasterizerImpl
