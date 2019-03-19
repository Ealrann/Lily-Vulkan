/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.sheepy.lily.vulkan.model.ColorDomain;
import org.sheepy.lily.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#isClearBeforeRender <em>Clear Before Render</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getSwapchainConfiguration <em>Swapchain Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getFramebufferConfiguration <em>Framebuffer Configuration</em>}</li>
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
	 * The cached value of the '{@link #getSwapchainConfiguration() <em>Swapchain Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwapchainConfiguration()
	 * @generated
	 * @ordered
	 */
	protected SwapchainConfiguration swapchainConfiguration;

	/**
	 * The cached value of the '{@link #getFramebufferConfiguration() <em>Framebuffer Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFramebufferConfiguration()
	 * @generated
	 * @ordered
	 */
	protected FramebufferConfiguration framebufferConfiguration;

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
	public SwapchainConfiguration getSwapchainConfiguration()
	{
		return swapchainConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSwapchainConfiguration(SwapchainConfiguration newSwapchainConfiguration,
															NotificationChain msgs)
	{
		SwapchainConfiguration oldSwapchainConfiguration = swapchainConfiguration;
		swapchainConfiguration = newSwapchainConfiguration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION,
					oldSwapchainConfiguration, newSwapchainConfiguration);
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
	public void setSwapchainConfiguration(SwapchainConfiguration newSwapchainConfiguration)
	{
		if (newSwapchainConfiguration != swapchainConfiguration)
		{
			NotificationChain msgs = null;
			if (swapchainConfiguration != null)
				msgs = ((InternalEObject) swapchainConfiguration).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION,
						null, msgs);
			if (newSwapchainConfiguration != null)
				msgs = ((InternalEObject) newSwapchainConfiguration).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION,
						null, msgs);
			msgs = basicSetSwapchainConfiguration(newSwapchainConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION,
				newSwapchainConfiguration, newSwapchainConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FramebufferConfiguration getFramebufferConfiguration()
	{
		return framebufferConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFramebufferConfiguration(	FramebufferConfiguration newFramebufferConfiguration,
																NotificationChain msgs)
	{
		FramebufferConfiguration oldFramebufferConfiguration = framebufferConfiguration;
		framebufferConfiguration = newFramebufferConfiguration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION,
					oldFramebufferConfiguration, newFramebufferConfiguration);
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
	public void setFramebufferConfiguration(FramebufferConfiguration newFramebufferConfiguration)
	{
		if (newFramebufferConfiguration != framebufferConfiguration)
		{
			NotificationChain msgs = null;
			if (framebufferConfiguration != null)
				msgs = ((InternalEObject) framebufferConfiguration).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION,
						null, msgs);
			if (newFramebufferConfiguration != null)
				msgs = ((InternalEObject) newFramebufferConfiguration).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION,
						null, msgs);
			msgs = basicSetFramebufferConfiguration(newFramebufferConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION,
				newFramebufferConfiguration, newFramebufferConfiguration));
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
			return basicSetSwapchainConfiguration(null, msgs);
		case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
			return basicSetFramebufferConfiguration(null, msgs);
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
			return getSwapchainConfiguration();
		case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
			return getFramebufferConfiguration();
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
			setSwapchainConfiguration((SwapchainConfiguration) newValue);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
			setFramebufferConfiguration((FramebufferConfiguration) newValue);
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
			setSwapchainConfiguration((SwapchainConfiguration) null);
			return;
		case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
			setFramebufferConfiguration((FramebufferConfiguration) null);
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
		case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
			return swapchainConfiguration != null;
		case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
			return framebufferConfiguration != null;
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
		result.append(", acquireWaitStage: ");
		result.append(acquireWaitStage);
		result.append(')');
		return result.toString();
	}

} //GraphicConfigurationImpl
