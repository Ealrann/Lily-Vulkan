/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.sheepy.lily.vulkan.model.ColorDomain;

import org.sheepy.lily.vulkan.model.enumeration.EImageUsage;
import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.lily.vulkan.model.enumeration.EPresentMode;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#isClearBeforeRender <em>Clear Before Render</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getPresentationMode <em>Presentation Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getRequiredSwapImageCount <em>Required Swap Image Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getSwapImageUsages <em>Swap Image Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getAcquireWaitStage <em>Acquire Wait Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getColorDomain <em>Color Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicConfigurationImpl extends MinimalEObjectImpl.Container
		implements GraphicConfiguration
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
	 * The default value of the '{@link #getRequiredSwapImageCount() <em>Required Swap Image Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredSwapImageCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getRequiredSwapImageCount() <em>Required Swap Image Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredSwapImageCount()
	 * @generated
	 * @ordered
	 */
	protected int requiredSwapImageCount = REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSwapImageUsages() <em>Swap Image Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwapImageUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<EImageUsage> swapImageUsages;

	/**
	 * The default value of the '{@link #getAcquireWaitStage() <em>Acquire Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcquireWaitStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage ACQUIRE_WAIT_STAGE_EDEFAULT = EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT;

	/**
	 * The cached value of the '{@link #getAcquireWaitStage() <em>Acquire Wait Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcquireWaitStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage acquireWaitStage = ACQUIRE_WAIT_STAGE_EDEFAULT;

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
		return GraphicPackage.Literals.GRAPHIC_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isClearBeforeRender()
	{
		return clearBeforeRender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClearBeforeRender(boolean newClearBeforeRender)
	{
		boolean oldClearBeforeRender = clearBeforeRender;
		clearBeforeRender = newClearBeforeRender;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER, oldClearBeforeRender,
				clearBeforeRender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPresentMode getPresentationMode()
	{
		return presentationMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPresentationMode(EPresentMode newPresentationMode)
	{
		EPresentMode oldPresentationMode = presentationMode;
		presentationMode = newPresentationMode == null
				? PRESENTATION_MODE_EDEFAULT
				: newPresentationMode;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE, oldPresentationMode,
				presentationMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRequiredSwapImageCount()
	{
		return requiredSwapImageCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequiredSwapImageCount(int newRequiredSwapImageCount)
	{
		int oldRequiredSwapImageCount = requiredSwapImageCount;
		requiredSwapImageCount = newRequiredSwapImageCount;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT,
				oldRequiredSwapImageCount, requiredSwapImageCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EImageUsage> getSwapImageUsages()
	{
		if (swapImageUsages == null)
		{
			swapImageUsages = new EDataTypeEList<EImageUsage>(EImageUsage.class, this,
					GraphicPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGES);
		}
		return swapImageUsages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getAcquireWaitStage()
	{
		return acquireWaitStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAcquireWaitStage(EPipelineStage newAcquireWaitStage)
	{
		EPipelineStage oldAcquireWaitStage = acquireWaitStage;
		acquireWaitStage = newAcquireWaitStage == null
				? ACQUIRE_WAIT_STAGE_EDEFAULT
				: newAcquireWaitStage;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE, oldAcquireWaitStage,
				acquireWaitStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN, oldColorDomain,
					newColorDomain);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorDomain(ColorDomain newColorDomain)
	{
		if (newColorDomain != colorDomain)
		{
			NotificationChain msgs = null;
			if (colorDomain != null) msgs = ((InternalEObject) colorDomain).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN,
					null, msgs);
			if (newColorDomain != null) msgs = ((InternalEObject) newColorDomain).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN,
					null, msgs);
			msgs = basicSetColorDomain(newColorDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN, newColorDomain,
				newColorDomain));
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER:
			return isClearBeforeRender();
		case GraphicPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE:
			return getPresentationMode();
		case GraphicPackage.GRAPHIC_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
			return getRequiredSwapImageCount();
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGES:
			return getSwapImageUsages();
		case GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE:
			return getAcquireWaitStage();
		case GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
			return getColorDomain();
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER:
			setClearBeforeRender((Boolean) newValue);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE:
			setPresentationMode((EPresentMode) newValue);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
			setRequiredSwapImageCount((Integer) newValue);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGES:
			getSwapImageUsages().clear();
			getSwapImageUsages().addAll((Collection<? extends EImageUsage>) newValue);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE:
			setAcquireWaitStage((EPipelineStage) newValue);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
			setColorDomain((ColorDomain) newValue);
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER:
			setClearBeforeRender(CLEAR_BEFORE_RENDER_EDEFAULT);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE:
			setPresentationMode(PRESENTATION_MODE_EDEFAULT);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
			setRequiredSwapImageCount(REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGES:
			getSwapImageUsages().clear();
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE:
			setAcquireWaitStage(ACQUIRE_WAIT_STAGE_EDEFAULT);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
			setColorDomain((ColorDomain) null);
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__CLEAR_BEFORE_RENDER:
			return clearBeforeRender != CLEAR_BEFORE_RENDER_EDEFAULT;
		case GraphicPackage.GRAPHIC_CONFIGURATION__PRESENTATION_MODE:
			return presentationMode != PRESENTATION_MODE_EDEFAULT;
		case GraphicPackage.GRAPHIC_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
			return requiredSwapImageCount != REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT;
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAP_IMAGE_USAGES:
			return swapImageUsages != null && !swapImageUsages.isEmpty();
		case GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE:
			return acquireWaitStage != ACQUIRE_WAIT_STAGE_EDEFAULT;
		case GraphicPackage.GRAPHIC_CONFIGURATION__COLOR_DOMAIN:
			return colorDomain != null;
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
		result.append(", requiredSwapImageCount: ");
		result.append(requiredSwapImageCount);
		result.append(", swapImageUsages: ");
		result.append(swapImageUsages);
		result.append(", acquireWaitStage: ");
		result.append(acquireWaitStage);
		result.append(')');
		return result.toString();
	}

} //GraphicConfigurationImpl
