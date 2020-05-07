/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;

import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getSwapchainConfiguration <em>Swapchain Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getFramebufferConfiguration <em>Framebuffer Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getAcquireWaitStage <em>Acquire Wait Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getSurface <em>Surface</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getRenderPass <em>Render Pass</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl#getImageViews <em>Image Views</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicConfigurationImpl extends LilyEObject implements GraphicConfiguration
{
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
	 * The cached value of the '{@link #getSurface() <em>Surface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSurface()
	 * @generated
	 * @ordered
	 */
	protected PhysicalSurface surface;

	/**
	 * The cached value of the '{@link #getRenderPass() <em>Render Pass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenderPass()
	 * @generated
	 * @ordered
	 */
	protected RenderPass renderPass;

	/**
	 * The cached value of the '{@link #getImageViews() <em>Image Views</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageViews()
	 * @generated
	 * @ordered
	 */
	protected ImageViews imageViews;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicConfigurationImpl()
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION, oldSwapchainConfiguration, newSwapchainConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
				msgs = ((InternalEObject)swapchainConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION, null, msgs);
			if (newSwapchainConfiguration != null)
				msgs = ((InternalEObject)newSwapchainConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION, null, msgs);
			msgs = basicSetSwapchainConfiguration(newSwapchainConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION, newSwapchainConfiguration, newSwapchainConfiguration));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION, oldFramebufferConfiguration, newFramebufferConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
				msgs = ((InternalEObject)framebufferConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION, null, msgs);
			if (newFramebufferConfiguration != null)
				msgs = ((InternalEObject)newFramebufferConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION, null, msgs);
			msgs = basicSetFramebufferConfiguration(newFramebufferConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION, newFramebufferConfiguration, newFramebufferConfiguration));
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
		acquireWaitStage = newAcquireWaitStage == null ? ACQUIRE_WAIT_STAGE_EDEFAULT : newAcquireWaitStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE, oldAcquireWaitStage, acquireWaitStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PhysicalSurface getSurface()
	{
		return surface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSurface(PhysicalSurface newSurface, NotificationChain msgs)
	{
		PhysicalSurface oldSurface = surface;
		surface = newSurface;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, oldSurface, newSurface);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSurface(PhysicalSurface newSurface)
	{
		if (newSurface != surface)
		{
			NotificationChain msgs = null;
			if (surface != null)
				msgs = ((InternalEObject)surface).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, null, msgs);
			if (newSurface != null)
				msgs = ((InternalEObject)newSurface).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, null, msgs);
			msgs = basicSetSurface(newSurface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE, newSurface, newSurface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderPass getRenderPass()
	{
		return renderPass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRenderPass(RenderPass newRenderPass, NotificationChain msgs)
	{
		RenderPass oldRenderPass = renderPass;
		renderPass = newRenderPass;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS, oldRenderPass, newRenderPass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenderPass(RenderPass newRenderPass)
	{
		if (newRenderPass != renderPass)
		{
			NotificationChain msgs = null;
			if (renderPass != null)
				msgs = ((InternalEObject)renderPass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS, null, msgs);
			if (newRenderPass != null)
				msgs = ((InternalEObject)newRenderPass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS, null, msgs);
			msgs = basicSetRenderPass(newRenderPass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS, newRenderPass, newRenderPass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageViews getImageViews()
	{
		return imageViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImageViews(ImageViews newImageViews, NotificationChain msgs)
	{
		ImageViews oldImageViews = imageViews;
		imageViews = newImageViews;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS, oldImageViews, newImageViews);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageViews(ImageViews newImageViews)
	{
		if (newImageViews != imageViews)
		{
			NotificationChain msgs = null;
			if (imageViews != null)
				msgs = ((InternalEObject)imageViews).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS, null, msgs);
			if (newImageViews != null)
				msgs = ((InternalEObject)newImageViews).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS, null, msgs);
			msgs = basicSetImageViews(newImageViews, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS, newImageViews, newImageViews));
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
			case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
				return basicSetSwapchainConfiguration(null, msgs);
			case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
				return basicSetFramebufferConfiguration(null, msgs);
			case GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE:
				return basicSetSurface(null, msgs);
			case GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS:
				return basicSetRenderPass(null, msgs);
			case GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS:
				return basicSetImageViews(null, msgs);
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
			case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
				return getSwapchainConfiguration();
			case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
				return getFramebufferConfiguration();
			case GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE:
				return getAcquireWaitStage();
			case GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE:
				return getSurface();
			case GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS:
				return getRenderPass();
			case GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS:
				return getImageViews();
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
			case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
				setSwapchainConfiguration((SwapchainConfiguration)newValue);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
				setFramebufferConfiguration((FramebufferConfiguration)newValue);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE:
				setAcquireWaitStage((EPipelineStage)newValue);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE:
				setSurface((PhysicalSurface)newValue);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS:
				setRenderPass((RenderPass)newValue);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS:
				setImageViews((ImageViews)newValue);
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
			case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
				setSwapchainConfiguration((SwapchainConfiguration)null);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
				setFramebufferConfiguration((FramebufferConfiguration)null);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE:
				setAcquireWaitStage(ACQUIRE_WAIT_STAGE_EDEFAULT);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE:
				setSurface((PhysicalSurface)null);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS:
				setRenderPass((RenderPass)null);
				return;
			case GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS:
				setImageViews((ImageViews)null);
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
			case GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION:
				return swapchainConfiguration != null;
			case GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION:
				return framebufferConfiguration != null;
			case GraphicPackage.GRAPHIC_CONFIGURATION__ACQUIRE_WAIT_STAGE:
				return acquireWaitStage != ACQUIRE_WAIT_STAGE_EDEFAULT;
			case GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE:
				return surface != null;
			case GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS:
				return renderPass != null;
			case GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS:
				return imageViews != null;
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
		result.append(" (acquireWaitStage: ");
		result.append(acquireWaitStage);
		result.append(')');
		return result.toString();
	}

} //GraphicConfigurationImpl
