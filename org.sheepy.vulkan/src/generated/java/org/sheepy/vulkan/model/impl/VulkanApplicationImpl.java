/**
 */
package org.sheepy.vulkan.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.common.api.types.SVector2i;

import org.sheepy.vulkan.model.ComputeProcessPool;
import org.sheepy.vulkan.model.GraphicProcessPool;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.VulkanPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl#isFullscreen <em>Fullscreen</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl#isResizeable <em>Resizeable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl#isDebug <em>Debug</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl#getComputePools <em>Compute Pools</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.VulkanApplicationImpl#getGraphicPool <em>Graphic Pool</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VulkanApplicationImpl extends MinimalEObjectImpl.Container implements VulkanApplication
{
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isFullscreen() <em>Fullscreen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullscreen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FULLSCREEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFullscreen() <em>Fullscreen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullscreen()
	 * @generated
	 * @ordered
	 */
	protected boolean fullscreen = FULLSCREEN_EDEFAULT;

	/**
	 * The default value of the '{@link #isResizeable() <em>Resizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResizeable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESIZEABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResizeable() <em>Resizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResizeable()
	 * @generated
	 * @ordered
	 */
	protected boolean resizeable = RESIZEABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDebug() <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebug()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEBUG_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDebug() <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDebug()
	 * @generated
	 * @ordered
	 */
	protected boolean debug = DEBUG_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final SVector2i SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected SVector2i size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComputePools() <em>Compute Pools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputePools()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputeProcessPool> computePools;

	/**
	 * The cached value of the '{@link #getGraphicPool() <em>Graphic Pool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicPool()
	 * @generated
	 * @ordered
	 */
	protected GraphicProcessPool graphicPool;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanApplicationImpl()
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
		return VulkanPackage.Literals.VULKAN_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_APPLICATION__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFullscreen()
	{
		return fullscreen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFullscreen(boolean newFullscreen)
	{
		boolean oldFullscreen = fullscreen;
		fullscreen = newFullscreen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_APPLICATION__FULLSCREEN, oldFullscreen, fullscreen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResizeable()
	{
		return resizeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResizeable(boolean newResizeable)
	{
		boolean oldResizeable = resizeable;
		resizeable = newResizeable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_APPLICATION__RESIZEABLE, oldResizeable, resizeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDebug()
	{
		return debug;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebug(boolean newDebug)
	{
		boolean oldDebug = debug;
		debug = newDebug;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_APPLICATION__DEBUG, oldDebug, debug));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle)
	{
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_APPLICATION__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVector2i getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(SVector2i newSize)
	{
		SVector2i oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_APPLICATION__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputeProcessPool> getComputePools()
	{
		if (computePools == null)
		{
			computePools = new EObjectContainmentEList<ComputeProcessPool>(ComputeProcessPool.class, this, VulkanPackage.VULKAN_APPLICATION__COMPUTE_POOLS);
		}
		return computePools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicProcessPool getGraphicPool()
	{
		return graphicPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraphicPool(GraphicProcessPool newGraphicPool, NotificationChain msgs)
	{
		GraphicProcessPool oldGraphicPool = graphicPool;
		graphicPool = newGraphicPool;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL, oldGraphicPool, newGraphicPool);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphicPool(GraphicProcessPool newGraphicPool)
	{
		if (newGraphicPool != graphicPool)
		{
			NotificationChain msgs = null;
			if (graphicPool != null)
				msgs = ((InternalEObject)graphicPool).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL, null, msgs);
			if (newGraphicPool != null)
				msgs = ((InternalEObject)newGraphicPool).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL, null, msgs);
			msgs = basicSetGraphicPool(newGraphicPool, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL, newGraphicPool, newGraphicPool));
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
			case VulkanPackage.VULKAN_APPLICATION__COMPUTE_POOLS:
				return ((InternalEList<?>)getComputePools()).basicRemove(otherEnd, msgs);
			case VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL:
				return basicSetGraphicPool(null, msgs);
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
			case VulkanPackage.VULKAN_APPLICATION__ENABLED:
				return isEnabled();
			case VulkanPackage.VULKAN_APPLICATION__FULLSCREEN:
				return isFullscreen();
			case VulkanPackage.VULKAN_APPLICATION__RESIZEABLE:
				return isResizeable();
			case VulkanPackage.VULKAN_APPLICATION__DEBUG:
				return isDebug();
			case VulkanPackage.VULKAN_APPLICATION__TITLE:
				return getTitle();
			case VulkanPackage.VULKAN_APPLICATION__SIZE:
				return getSize();
			case VulkanPackage.VULKAN_APPLICATION__COMPUTE_POOLS:
				return getComputePools();
			case VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL:
				return getGraphicPool();
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
			case VulkanPackage.VULKAN_APPLICATION__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case VulkanPackage.VULKAN_APPLICATION__FULLSCREEN:
				setFullscreen((Boolean)newValue);
				return;
			case VulkanPackage.VULKAN_APPLICATION__RESIZEABLE:
				setResizeable((Boolean)newValue);
				return;
			case VulkanPackage.VULKAN_APPLICATION__DEBUG:
				setDebug((Boolean)newValue);
				return;
			case VulkanPackage.VULKAN_APPLICATION__TITLE:
				setTitle((String)newValue);
				return;
			case VulkanPackage.VULKAN_APPLICATION__SIZE:
				setSize((SVector2i)newValue);
				return;
			case VulkanPackage.VULKAN_APPLICATION__COMPUTE_POOLS:
				getComputePools().clear();
				getComputePools().addAll((Collection<? extends ComputeProcessPool>)newValue);
				return;
			case VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL:
				setGraphicPool((GraphicProcessPool)newValue);
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
			case VulkanPackage.VULKAN_APPLICATION__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case VulkanPackage.VULKAN_APPLICATION__FULLSCREEN:
				setFullscreen(FULLSCREEN_EDEFAULT);
				return;
			case VulkanPackage.VULKAN_APPLICATION__RESIZEABLE:
				setResizeable(RESIZEABLE_EDEFAULT);
				return;
			case VulkanPackage.VULKAN_APPLICATION__DEBUG:
				setDebug(DEBUG_EDEFAULT);
				return;
			case VulkanPackage.VULKAN_APPLICATION__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case VulkanPackage.VULKAN_APPLICATION__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case VulkanPackage.VULKAN_APPLICATION__COMPUTE_POOLS:
				getComputePools().clear();
				return;
			case VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL:
				setGraphicPool((GraphicProcessPool)null);
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
			case VulkanPackage.VULKAN_APPLICATION__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case VulkanPackage.VULKAN_APPLICATION__FULLSCREEN:
				return fullscreen != FULLSCREEN_EDEFAULT;
			case VulkanPackage.VULKAN_APPLICATION__RESIZEABLE:
				return resizeable != RESIZEABLE_EDEFAULT;
			case VulkanPackage.VULKAN_APPLICATION__DEBUG:
				return debug != DEBUG_EDEFAULT;
			case VulkanPackage.VULKAN_APPLICATION__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case VulkanPackage.VULKAN_APPLICATION__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case VulkanPackage.VULKAN_APPLICATION__COMPUTE_POOLS:
				return computePools != null && !computePools.isEmpty();
			case VulkanPackage.VULKAN_APPLICATION__GRAPHIC_POOL:
				return graphicPool != null;
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", fullscreen: ");
		result.append(fullscreen);
		result.append(", resizeable: ");
		result.append(resizeable);
		result.append(", debug: ");
		result.append(debug);
		result.append(", title: ");
		result.append(title);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //VulkanApplicationImpl
