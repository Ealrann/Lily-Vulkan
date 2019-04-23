/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.joml.Vector3d;

import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;

import org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getRenderPassInfo <em>Render Pass Info</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getGraphicOffset <em>Graphic Offset</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getFieldOfViewY <em>Field Of View Y</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicProcessImpl extends AbstractProcessImpl implements GraphicProcess
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
	 * The default value of the '{@link #getGraphicOffset() <em>Graphic Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicOffset()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3d GRAPHIC_OFFSET_EDEFAULT = (Vector3d) TypesFactory.eINSTANCE
			.createFromString(TypesPackage.eINSTANCE.getVector3d(), "0;0;0");

	/**
	 * The cached value of the '{@link #getGraphicOffset() <em>Graphic Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphicOffset()
	 * @generated
	 * @ordered
	 */
	protected Vector3d graphicOffset = GRAPHIC_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getFieldOfViewY() <em>Field Of View Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldOfViewY()
	 * @generated
	 * @ordered
	 */
	protected static final float FIELD_OF_VIEW_Y_EDEFAULT = 45.0F;

	/**
	 * The cached value of the '{@link #getFieldOfViewY() <em>Field Of View Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldOfViewY()
	 * @generated
	 * @ordered
	 */
	protected float fieldOfViewY = FIELD_OF_VIEW_Y_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicProcessImpl()
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
		return GraphicPackage.Literals.GRAPHIC_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicConfiguration getConfiguration()
	{
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(	GraphicConfiguration newConfiguration,
													NotificationChain msgs)
	{
		GraphicConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, oldConfiguration,
					newConfiguration);
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
	public void setConfiguration(GraphicConfiguration newConfiguration)
	{
		if (newConfiguration != configuration)
		{
			NotificationChain msgs = null;
			if (configuration != null) msgs = ((InternalEObject) configuration).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, null,
					msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject) newConfiguration).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION,
						null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderPassInfo getRenderPassInfo()
	{
		return renderPassInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRenderPassInfo(RenderPassInfo newRenderPassInfo,
													NotificationChain msgs)
	{
		RenderPassInfo oldRenderPassInfo = renderPassInfo;
		renderPassInfo = newRenderPassInfo;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO, oldRenderPassInfo,
					newRenderPassInfo);
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
	public void setRenderPassInfo(RenderPassInfo newRenderPassInfo)
	{
		if (newRenderPassInfo != renderPassInfo)
		{
			NotificationChain msgs = null;
			if (renderPassInfo != null)
				msgs = ((InternalEObject) renderPassInfo).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO,
						null, msgs);
			if (newRenderPassInfo != null)
				msgs = ((InternalEObject) newRenderPassInfo).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO,
						null, msgs);
			msgs = basicSetRenderPassInfo(newRenderPassInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO, newRenderPassInfo,
				newRenderPassInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3d getGraphicOffset()
	{
		return graphicOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGraphicOffset(Vector3d newGraphicOffset)
	{
		Vector3d oldGraphicOffset = graphicOffset;
		graphicOffset = newGraphicOffset;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_PROCESS__GRAPHIC_OFFSET, oldGraphicOffset, graphicOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getFieldOfViewY()
	{
		return fieldOfViewY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFieldOfViewY(float newFieldOfViewY)
	{
		float oldFieldOfViewY = fieldOfViewY;
		fieldOfViewY = newFieldOfViewY;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y, oldFieldOfViewY, fieldOfViewY));
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
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			return basicSetConfiguration(null, msgs);
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			return basicSetRenderPassInfo(null, msgs);
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
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			return getConfiguration();
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			return getRenderPassInfo();
		case GraphicPackage.GRAPHIC_PROCESS__GRAPHIC_OFFSET:
			return getGraphicOffset();
		case GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y:
			return getFieldOfViewY();
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
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			setConfiguration((GraphicConfiguration) newValue);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			setRenderPassInfo((RenderPassInfo) newValue);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__GRAPHIC_OFFSET:
			setGraphicOffset((Vector3d) newValue);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y:
			setFieldOfViewY((Float) newValue);
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
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			setConfiguration((GraphicConfiguration) null);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			setRenderPassInfo((RenderPassInfo) null);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__GRAPHIC_OFFSET:
			setGraphicOffset(GRAPHIC_OFFSET_EDEFAULT);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y:
			setFieldOfViewY(FIELD_OF_VIEW_Y_EDEFAULT);
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
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			return configuration != null;
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			return renderPassInfo != null;
		case GraphicPackage.GRAPHIC_PROCESS__GRAPHIC_OFFSET:
			return GRAPHIC_OFFSET_EDEFAULT == null
					? graphicOffset != null
					: !GRAPHIC_OFFSET_EDEFAULT.equals(graphicOffset);
		case GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y:
			return fieldOfViewY != FIELD_OF_VIEW_Y_EDEFAULT;
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
		result.append(" (graphicOffset: ");
		result.append(graphicOffset);
		result.append(", fieldOfViewY: ");
		result.append(fieldOfViewY);
		result.append(')');
		return result.toString();
	}

} //GraphicProcessImpl
