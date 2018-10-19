/**
 */
package org.sheepy.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EPresentMode;

import org.sheepy.vulkan.model.process.ColorDomain;
import org.sheepy.vulkan.model.process.GraphicConfiguration;
import org.sheepy.vulkan.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphic Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl#isClearBeforeRender <em>Clear Before Render</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl#getPresentationMode <em>Presentation Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl#getSwapImageUsage <em>Swap Image Usage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl#getFrameWaitStage <em>Frame Wait Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl#getColorDomain <em>Color Domain</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl#getRasterizerCullMode <em>Rasterizer Cull Mode</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.GraphicConfigurationImpl#getRasterizerFrontFace <em>Rasterizer Front Face</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicConfigurationImpl extends MinimalEObjectImpl.Container implements GraphicConfiguration
{
	/**
	 * The default value of the '{@link #isClearBeforeRender() <em>Clear Before Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClearBeforeRender()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLEAR_BEFORE_RENDER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isClearBeforeRender() <em>Clear Before Render</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClearBeforeRender()
	 * @generated
	 * @ordered
	 */
	protected boolean clearBeforeRender = CLEAR_BEFORE_RENDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPresentationMode() <em>Presentation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationMode()
	 * @generated
	 * @ordered
	 */
	protected static final EPresentMode PRESENTATION_MODE_EDEFAULT = EPresentMode.MAIL_BOX;

	/**
	 * The cached value of the '{@link #getPresentationMode() <em>Presentation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationMode()
	 * @generated
	 * @ordered
	 */
	protected EPresentMode presentationMode = PRESENTATION_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSwapImageUsage() <em>Swap Image Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwapImageUsage()
	 * @generated
	 * @ordered
	 */
	protected static final int SWAP_IMAGE_USAGE_EDEFAULT = 16;

	/**
	 * The cached value of the '{@link #getSwapImageUsage() <em>Swap Image Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwapImageUsage()
	 * @generated
	 * @ordered
	 */
	protected int swapImageUsage = SWAP_IMAGE_USAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameWaitStage() <em>Frame Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameWaitStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage FRAME_WAIT_STAGE_EDEFAULT = EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT;

	/**
	 * The cached value of the '{@link #getFrameWaitStage() <em>Frame Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameWaitStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage frameWaitStage = FRAME_WAIT_STAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getColorDomain() <em>Color Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorDomain()
	 * @generated
	 * @ordered
	 */
	protected ColorDomain colorDomain;

	/**
	 * The default value of the '{@link #getRasterizerCullMode() <em>Rasterizer Cull Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRasterizerCullMode()
	 * @generated
	 * @ordered
	 */
	protected static final ECullMode RASTERIZER_CULL_MODE_EDEFAULT = ECullMode.BACK_BIT;

	/**
	 * The cached value of the '{@link #getRasterizerCullMode() <em>Rasterizer Cull Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRasterizerCullMode()
	 * @generated
	 * @ordered
	 */
	protected ECullMode rasterizerCullMode = RASTERIZER_CULL_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRasterizerFrontFace() <em>Rasterizer Front Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRasterizerFrontFace()
	 * @generated
	 * @ordered
	 */
	protected static final EFrontFace RASTERIZER_FRONT_FACE_EDEFAULT = EFrontFace.CLOCKWISE;

	/**
	 * The cached value of the '{@link #getRasterizerFrontFace() <em>Rasterizer Front Face</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRasterizerFrontFace()
	 * @generated
	 * @ordered
	 */
	protected EFrontFace rasterizerFrontFace = RASTERIZER_FRONT_FACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicConfigurationImpl()
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
		return ProcessPackage.Literals.GRAPHIC_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClearBeforeRender()
	{
		return clearBeforeRender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClearBeforeRender(boolean newClearBeforeRender)
	{
		boolean oldClearBeforeRender = clearBeforeRender;
		clearBeforeRender = newClearBeforeRender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER, oldClearBeforeRender, clearBeforeRender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPresentMode getPresentationMode()
	{
		return presentationMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPresentationMode(EPresentMode newPresentationMode)
	{
		EPresentMode oldPresentationMode = presentationMode;
		presentationMode = newPresentationMode == null ? PRESENTATION_MODE_EDEFAULT : newPresentationMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE, oldPresentationMode, presentationMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSwapImageUsage()
	{
		return swapImageUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwapImageUsage(int newSwapImageUsage)
	{
		int oldSwapImageUsage = swapImageUsage;
		swapImageUsage = newSwapImageUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE, oldSwapImageUsage, swapImageUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPipelineStage getFrameWaitStage()
	{
		return frameWaitStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameWaitStage(EPipelineStage newFrameWaitStage)
	{
		EPipelineStage oldFrameWaitStage = frameWaitStage;
		frameWaitStage = newFrameWaitStage == null ? FRAME_WAIT_STAGE_EDEFAULT : newFrameWaitStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE, oldFrameWaitStage, frameWaitStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDomain getColorDomain()
	{
		return colorDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColorDomain(ColorDomain newColorDomain, NotificationChain msgs)
	{
		ColorDomain oldColorDomain = colorDomain;
		colorDomain = newColorDomain;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN, oldColorDomain, newColorDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorDomain(ColorDomain newColorDomain)
	{
		if (newColorDomain != colorDomain)
		{
			NotificationChain msgs = null;
			if (colorDomain != null)
				msgs = ((InternalEObject)colorDomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN, null, msgs);
			if (newColorDomain != null)
				msgs = ((InternalEObject)newColorDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN, null, msgs);
			msgs = basicSetColorDomain(newColorDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN, newColorDomain, newColorDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECullMode getRasterizerCullMode()
	{
		return rasterizerCullMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRasterizerCullMode(ECullMode newRasterizerCullMode)
	{
		ECullMode oldRasterizerCullMode = rasterizerCullMode;
		rasterizerCullMode = newRasterizerCullMode == null ? RASTERIZER_CULL_MODE_EDEFAULT : newRasterizerCullMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE, oldRasterizerCullMode, rasterizerCullMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFrontFace getRasterizerFrontFace()
	{
		return rasterizerFrontFace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRasterizerFrontFace(EFrontFace newRasterizerFrontFace)
	{
		EFrontFace oldRasterizerFrontFace = rasterizerFrontFace;
		rasterizerFrontFace = newRasterizerFrontFace == null ? RASTERIZER_FRONT_FACE_EDEFAULT : newRasterizerFrontFace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE, oldRasterizerFrontFace, rasterizerFrontFace));
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
			case ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
				return basicSetColorDomain(null, msgs);
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
			case ProcessPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER:
				return isClearBeforeRender();
			case ProcessPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE:
				return getPresentationMode();
			case ProcessPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE:
				return getSwapImageUsage();
			case ProcessPackage.GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE:
				return getFrameWaitStage();
			case ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
				return getColorDomain();
			case ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE:
				return getRasterizerCullMode();
			case ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE:
				return getRasterizerFrontFace();
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
			case ProcessPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER:
				setClearBeforeRender((Boolean)newValue);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE:
				setPresentationMode((EPresentMode)newValue);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE:
				setSwapImageUsage((Integer)newValue);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE:
				setFrameWaitStage((EPipelineStage)newValue);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
				setColorDomain((ColorDomain)newValue);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE:
				setRasterizerCullMode((ECullMode)newValue);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE:
				setRasterizerFrontFace((EFrontFace)newValue);
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
			case ProcessPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER:
				setClearBeforeRender(CLEAR_BEFORE_RENDER_EDEFAULT);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE:
				setPresentationMode(PRESENTATION_MODE_EDEFAULT);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE:
				setSwapImageUsage(SWAP_IMAGE_USAGE_EDEFAULT);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE:
				setFrameWaitStage(FRAME_WAIT_STAGE_EDEFAULT);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
				setColorDomain((ColorDomain)null);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE:
				setRasterizerCullMode(RASTERIZER_CULL_MODE_EDEFAULT);
				return;
			case ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE:
				setRasterizerFrontFace(RASTERIZER_FRONT_FACE_EDEFAULT);
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
			case ProcessPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER:
				return clearBeforeRender != CLEAR_BEFORE_RENDER_EDEFAULT;
			case ProcessPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE:
				return presentationMode != PRESENTATION_MODE_EDEFAULT;
			case ProcessPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGE:
				return swapImageUsage != SWAP_IMAGE_USAGE_EDEFAULT;
			case ProcessPackage.GRAPHIC_CONFIGURATION__FRAME_WAIT_STAGE:
				return frameWaitStage != FRAME_WAIT_STAGE_EDEFAULT;
			case ProcessPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
				return colorDomain != null;
			case ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_CULL_MODE:
				return rasterizerCullMode != RASTERIZER_CULL_MODE_EDEFAULT;
			case ProcessPackage.GRAPHIC_CONFIGURATION__RASTERIZER_FRONT_FACE:
				return rasterizerFrontFace != RASTERIZER_FRONT_FACE_EDEFAULT;
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
		result.append(" (clearBeforeRender: ");
		result.append(clearBeforeRender);
		result.append(", presentationMode: ");
		result.append(presentationMode);
		result.append(", swapImageUsage: ");
		result.append(swapImageUsage);
		result.append(", frameWaitStage: ");
		result.append(frameWaitStage);
		result.append(", rasterizerCullMode: ");
		result.append(rasterizerCullMode);
		result.append(", rasterizerFrontFace: ");
		result.append(rasterizerFrontFace);
		result.append(')');
		return result.toString();
	}

} //GraphicConfigurationImpl
