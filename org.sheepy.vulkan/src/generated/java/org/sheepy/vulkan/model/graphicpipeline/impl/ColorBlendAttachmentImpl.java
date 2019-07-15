/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.enumeration.EBlendFactor;
import org.sheepy.vulkan.model.enumeration.EBlendOp;

import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color Blend Attachment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#isBlendEnable <em>Blend Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#getSrcColor <em>Src Color</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#getDstColor <em>Dst Color</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#getSrcAlpha <em>Src Alpha</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#getDstAlpha <em>Dst Alpha</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#getColorBlendOp <em>Color Blend Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#getAlphaBlendOp <em>Alpha Blend Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#isRedComponentEnable <em>Red Component Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#isGreenComponentEnable <em>Green Component Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#isBlueComponentEnable <em>Blue Component Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl#isAlphaComponentEnable <em>Alpha Component Enable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColorBlendAttachmentImpl extends MinimalEObjectImpl.Container
		implements ColorBlendAttachment
{
	/**
	 * The default value of the '{@link #isBlendEnable() <em>Blend Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlendEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BLEND_ENABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBlendEnable() <em>Blend Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlendEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean blendEnable = BLEND_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrcColor() <em>Src Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcColor()
	 * @generated
	 * @ordered
	 */
	protected static final EBlendFactor SRC_COLOR_EDEFAULT = EBlendFactor.ONE;

	/**
	 * The cached value of the '{@link #getSrcColor() <em>Src Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcColor()
	 * @generated
	 * @ordered
	 */
	protected EBlendFactor srcColor = SRC_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstColor() <em>Dst Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstColor()
	 * @generated
	 * @ordered
	 */
	protected static final EBlendFactor DST_COLOR_EDEFAULT = EBlendFactor.ZERO;

	/**
	 * The cached value of the '{@link #getDstColor() <em>Dst Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstColor()
	 * @generated
	 * @ordered
	 */
	protected EBlendFactor dstColor = DST_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrcAlpha() <em>Src Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final EBlendFactor SRC_ALPHA_EDEFAULT = EBlendFactor.ONE;

	/**
	 * The cached value of the '{@link #getSrcAlpha() <em>Src Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcAlpha()
	 * @generated
	 * @ordered
	 */
	protected EBlendFactor srcAlpha = SRC_ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getDstAlpha() <em>Dst Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final EBlendFactor DST_ALPHA_EDEFAULT = EBlendFactor.ZERO;

	/**
	 * The cached value of the '{@link #getDstAlpha() <em>Dst Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstAlpha()
	 * @generated
	 * @ordered
	 */
	protected EBlendFactor dstAlpha = DST_ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorBlendOp() <em>Color Blend Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorBlendOp()
	 * @generated
	 * @ordered
	 */
	protected static final EBlendOp COLOR_BLEND_OP_EDEFAULT = EBlendOp.ADD;

	/**
	 * The cached value of the '{@link #getColorBlendOp() <em>Color Blend Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorBlendOp()
	 * @generated
	 * @ordered
	 */
	protected EBlendOp colorBlendOp = COLOR_BLEND_OP_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlphaBlendOp() <em>Alpha Blend Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlphaBlendOp()
	 * @generated
	 * @ordered
	 */
	protected static final EBlendOp ALPHA_BLEND_OP_EDEFAULT = EBlendOp.ADD;

	/**
	 * The cached value of the '{@link #getAlphaBlendOp() <em>Alpha Blend Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlphaBlendOp()
	 * @generated
	 * @ordered
	 */
	protected EBlendOp alphaBlendOp = ALPHA_BLEND_OP_EDEFAULT;

	/**
	 * The default value of the '{@link #isRedComponentEnable() <em>Red Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRedComponentEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RED_COMPONENT_ENABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRedComponentEnable() <em>Red Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRedComponentEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean redComponentEnable = RED_COMPONENT_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGreenComponentEnable() <em>Green Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGreenComponentEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GREEN_COMPONENT_ENABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGreenComponentEnable() <em>Green Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGreenComponentEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean greenComponentEnable = GREEN_COMPONENT_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isBlueComponentEnable() <em>Blue Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlueComponentEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BLUE_COMPONENT_ENABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isBlueComponentEnable() <em>Blue Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlueComponentEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean blueComponentEnable = BLUE_COMPONENT_ENABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAlphaComponentEnable() <em>Alpha Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlphaComponentEnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALPHA_COMPONENT_ENABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAlphaComponentEnable() <em>Alpha Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlphaComponentEnable()
	 * @generated
	 * @ordered
	 */
	protected boolean alphaComponentEnable = ALPHA_COMPONENT_ENABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorBlendAttachmentImpl()
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
		return GraphicpipelinePackage.Literals.COLOR_BLEND_ATTACHMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBlendEnable()
	{
		return blendEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlendEnable(boolean newBlendEnable)
	{
		boolean oldBlendEnable = blendEnable;
		blendEnable = newBlendEnable;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLEND_ENABLE, oldBlendEnable,
				blendEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBlendFactor getSrcColor()
	{
		return srcColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcColor(EBlendFactor newSrcColor)
	{
		EBlendFactor oldSrcColor = srcColor;
		srcColor = newSrcColor == null ? SRC_COLOR_EDEFAULT : newSrcColor;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_COLOR, oldSrcColor, srcColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBlendFactor getDstColor()
	{
		return dstColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstColor(EBlendFactor newDstColor)
	{
		EBlendFactor oldDstColor = dstColor;
		dstColor = newDstColor == null ? DST_COLOR_EDEFAULT : newDstColor;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_COLOR, oldDstColor, dstColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBlendFactor getSrcAlpha()
	{
		return srcAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSrcAlpha(EBlendFactor newSrcAlpha)
	{
		EBlendFactor oldSrcAlpha = srcAlpha;
		srcAlpha = newSrcAlpha == null ? SRC_ALPHA_EDEFAULT : newSrcAlpha;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_ALPHA, oldSrcAlpha, srcAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBlendFactor getDstAlpha()
	{
		return dstAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDstAlpha(EBlendFactor newDstAlpha)
	{
		EBlendFactor oldDstAlpha = dstAlpha;
		dstAlpha = newDstAlpha == null ? DST_ALPHA_EDEFAULT : newDstAlpha;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_ALPHA, oldDstAlpha, dstAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBlendOp getColorBlendOp()
	{
		return colorBlendOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorBlendOp(EBlendOp newColorBlendOp)
	{
		EBlendOp oldColorBlendOp = colorBlendOp;
		colorBlendOp = newColorBlendOp == null ? COLOR_BLEND_OP_EDEFAULT : newColorBlendOp;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP, oldColorBlendOp,
				colorBlendOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EBlendOp getAlphaBlendOp()
	{
		return alphaBlendOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlphaBlendOp(EBlendOp newAlphaBlendOp)
	{
		EBlendOp oldAlphaBlendOp = alphaBlendOp;
		alphaBlendOp = newAlphaBlendOp == null ? ALPHA_BLEND_OP_EDEFAULT : newAlphaBlendOp;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP, oldAlphaBlendOp,
				alphaBlendOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRedComponentEnable()
	{
		return redComponentEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRedComponentEnable(boolean newRedComponentEnable)
	{
		boolean oldRedComponentEnable = redComponentEnable;
		redComponentEnable = newRedComponentEnable;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE,
				oldRedComponentEnable, redComponentEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isGreenComponentEnable()
	{
		return greenComponentEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGreenComponentEnable(boolean newGreenComponentEnable)
	{
		boolean oldGreenComponentEnable = greenComponentEnable;
		greenComponentEnable = newGreenComponentEnable;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE,
				oldGreenComponentEnable, greenComponentEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBlueComponentEnable()
	{
		return blueComponentEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlueComponentEnable(boolean newBlueComponentEnable)
	{
		boolean oldBlueComponentEnable = blueComponentEnable;
		blueComponentEnable = newBlueComponentEnable;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE,
				oldBlueComponentEnable, blueComponentEnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAlphaComponentEnable()
	{
		return alphaComponentEnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlphaComponentEnable(boolean newAlphaComponentEnable)
	{
		boolean oldAlphaComponentEnable = alphaComponentEnable;
		alphaComponentEnable = newAlphaComponentEnable;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE,
				oldAlphaComponentEnable, alphaComponentEnable));
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
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLEND_ENABLE:
			return isBlendEnable();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_COLOR:
			return getSrcColor();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_COLOR:
			return getDstColor();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_ALPHA:
			return getSrcAlpha();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_ALPHA:
			return getDstAlpha();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP:
			return getColorBlendOp();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP:
			return getAlphaBlendOp();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE:
			return isRedComponentEnable();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE:
			return isGreenComponentEnable();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE:
			return isBlueComponentEnable();
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE:
			return isAlphaComponentEnable();
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
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLEND_ENABLE:
			setBlendEnable((Boolean) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_COLOR:
			setSrcColor((EBlendFactor) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_COLOR:
			setDstColor((EBlendFactor) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_ALPHA:
			setSrcAlpha((EBlendFactor) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_ALPHA:
			setDstAlpha((EBlendFactor) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP:
			setColorBlendOp((EBlendOp) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP:
			setAlphaBlendOp((EBlendOp) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE:
			setRedComponentEnable((Boolean) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE:
			setGreenComponentEnable((Boolean) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE:
			setBlueComponentEnable((Boolean) newValue);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE:
			setAlphaComponentEnable((Boolean) newValue);
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
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLEND_ENABLE:
			setBlendEnable(BLEND_ENABLE_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_COLOR:
			setSrcColor(SRC_COLOR_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_COLOR:
			setDstColor(DST_COLOR_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_ALPHA:
			setSrcAlpha(SRC_ALPHA_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_ALPHA:
			setDstAlpha(DST_ALPHA_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP:
			setColorBlendOp(COLOR_BLEND_OP_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP:
			setAlphaBlendOp(ALPHA_BLEND_OP_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE:
			setRedComponentEnable(RED_COMPONENT_ENABLE_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE:
			setGreenComponentEnable(GREEN_COMPONENT_ENABLE_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE:
			setBlueComponentEnable(BLUE_COMPONENT_ENABLE_EDEFAULT);
			return;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE:
			setAlphaComponentEnable(ALPHA_COMPONENT_ENABLE_EDEFAULT);
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
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLEND_ENABLE:
			return blendEnable != BLEND_ENABLE_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_COLOR:
			return srcColor != SRC_COLOR_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_COLOR:
			return dstColor != DST_COLOR_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__SRC_ALPHA:
			return srcAlpha != SRC_ALPHA_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__DST_ALPHA:
			return dstAlpha != DST_ALPHA_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__COLOR_BLEND_OP:
			return colorBlendOp != COLOR_BLEND_OP_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_BLEND_OP:
			return alphaBlendOp != ALPHA_BLEND_OP_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__RED_COMPONENT_ENABLE:
			return redComponentEnable != RED_COMPONENT_ENABLE_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__GREEN_COMPONENT_ENABLE:
			return greenComponentEnable != GREEN_COMPONENT_ENABLE_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__BLUE_COMPONENT_ENABLE:
			return blueComponentEnable != BLUE_COMPONENT_ENABLE_EDEFAULT;
		case GraphicpipelinePackage.COLOR_BLEND_ATTACHMENT__ALPHA_COMPONENT_ENABLE:
			return alphaComponentEnable != ALPHA_COMPONENT_ENABLE_EDEFAULT;
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
		result.append(" (blendEnable: ");
		result.append(blendEnable);
		result.append(", srcColor: ");
		result.append(srcColor);
		result.append(", dstColor: ");
		result.append(dstColor);
		result.append(", srcAlpha: ");
		result.append(srcAlpha);
		result.append(", dstAlpha: ");
		result.append(dstAlpha);
		result.append(", colorBlendOp: ");
		result.append(colorBlendOp);
		result.append(", alphaBlendOp: ");
		result.append(alphaBlendOp);
		result.append(", redComponentEnable: ");
		result.append(redComponentEnable);
		result.append(", greenComponentEnable: ");
		result.append(greenComponentEnable);
		result.append(", blueComponentEnable: ");
		result.append(blueComponentEnable);
		result.append(", alphaComponentEnable: ");
		result.append(alphaComponentEnable);
		result.append(')');
		return result.toString();
	}

} //ColorBlendAttachmentImpl
