/**
 */
package org.sheepy.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import org.sheepy.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.vulkan.model.process.graphic.GraphicProcessPool;
import org.sheepy.vulkan.model.process.graphic.RenderPassInfo;

import org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl;

import org.sheepy.vulkan.model.resource.DepthImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Pool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessPoolImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessPoolImpl#getRenderPassInfo <em>Render Pass Info</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicProcessPoolImpl#getDepthImage <em>Depth Image</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicProcessPoolImpl extends AbstractProcessPoolImpl<GraphicProcess> implements GraphicProcessPool
{
	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected GraphicConfiguration configuration;

	/**
	 * The cached value of the '{@link #getRenderPassInfo() <em>Render Pass Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenderPassInfo()
	 * @generated
	 * @ordered
	 */
	protected RenderPassInfo renderPassInfo;

	/**
	 * The cached value of the '{@link #getDepthImage() <em>Depth Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepthImage()
	 * @generated
	 * @ordered
	 */
	protected DepthImage depthImage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicProcessPoolImpl()
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
		return GraphicPackage.Literals.GRAPHIC_PROCESS_POOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<GraphicProcess> getProcesses()
	{
		if (processes == null)
		{
			processes = new EObjectContainmentEList<GraphicProcess>(GraphicProcess.class, this, GraphicPackage.GRAPHIC_PROCESS_POOL__PROCESSES);
		}
		return processes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicConfiguration getConfiguration()
	{
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(GraphicConfiguration newConfiguration, NotificationChain msgs)
	{
		GraphicConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION, oldConfiguration, newConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(GraphicConfiguration newConfiguration)
	{
		if (newConfiguration != configuration)
		{
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenderPassInfo getRenderPassInfo()
	{
		return renderPassInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRenderPassInfo(RenderPassInfo newRenderPassInfo, NotificationChain msgs)
	{
		RenderPassInfo oldRenderPassInfo = renderPassInfo;
		renderPassInfo = newRenderPassInfo;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO, oldRenderPassInfo, newRenderPassInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenderPassInfo(RenderPassInfo newRenderPassInfo)
	{
		if (newRenderPassInfo != renderPassInfo)
		{
			NotificationChain msgs = null;
			if (renderPassInfo != null)
				msgs = ((InternalEObject)renderPassInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO, null, msgs);
			if (newRenderPassInfo != null)
				msgs = ((InternalEObject)newRenderPassInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO, null, msgs);
			msgs = basicSetRenderPassInfo(newRenderPassInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO, newRenderPassInfo, newRenderPassInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepthImage getDepthImage()
	{
		return depthImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDepthImage(DepthImage newDepthImage, NotificationChain msgs)
	{
		DepthImage oldDepthImage = depthImage;
		depthImage = newDepthImage;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE, oldDepthImage, newDepthImage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepthImage(DepthImage newDepthImage)
	{
		if (newDepthImage != depthImage)
		{
			NotificationChain msgs = null;
			if (depthImage != null)
				msgs = ((InternalEObject)depthImage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE, null, msgs);
			if (newDepthImage != null)
				msgs = ((InternalEObject)newDepthImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE, null, msgs);
			msgs = basicSetDepthImage(newDepthImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE, newDepthImage, newDepthImage));
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
			case GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO:
				return basicSetRenderPassInfo(null, msgs);
			case GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE:
				return basicSetDepthImage(null, msgs);
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
			case GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION:
				return getConfiguration();
			case GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO:
				return getRenderPassInfo();
			case GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE:
				return getDepthImage();
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
			case GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION:
				setConfiguration((GraphicConfiguration)newValue);
				return;
			case GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO:
				setRenderPassInfo((RenderPassInfo)newValue);
				return;
			case GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE:
				setDepthImage((DepthImage)newValue);
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
			case GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION:
				setConfiguration((GraphicConfiguration)null);
				return;
			case GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO:
				setRenderPassInfo((RenderPassInfo)null);
				return;
			case GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE:
				setDepthImage((DepthImage)null);
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
			case GraphicPackage.GRAPHIC_PROCESS_POOL__CONFIGURATION:
				return configuration != null;
			case GraphicPackage.GRAPHIC_PROCESS_POOL__RENDER_PASS_INFO:
				return renderPassInfo != null;
			case GraphicPackage.GRAPHIC_PROCESS_POOL__DEPTH_IMAGE:
				return depthImage != null;
		}
		return super.eIsSet(featureID);
	}

} //GraphicProcessPoolImpl
